package com.nordstrom.common.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nordstrom.common.base.UncheckedThrow;
import com.nordstrom.common.jdbc.Param.Mode;

import java.sql.PreparedStatement;

/**
 * This utility class provides facilities that enable you to define collections of database queries and stored
 * procedures in an easy-to-execute format.
 * <p>
 * Query collections are defined as Java enumerations that implement the {@link QueryAPI}
 * interface:
 * <ul>
 * <li>{@link QueryAPI#getQueryStr() getQueryStr} - Get the query string for this constant. This is the actual query
 *     that's sent to the database.</li>
 * <li>{@link QueryAPI#getArgNames() getArgNames} - Get the names of the arguments for this query. This provides
 *     diagnostic information if the incorrect number of arguments is specified by the client.</li>
 * <li>{@link QueryAPI#getConnection() getConnection} - Get the connection string associated with this query. This
 *     eliminates the need for the client to provide this information.</li>
 * <li>{@link QueryAPI#getEnum() getEnum} - Get the enumeration to which this query belongs. This enables {@link 
 *     #executeQuery(Class, QueryAPI, Object[])} to retrieve the name of the query's enumerated constant for
 *     diagnostic messages.</li>
 * </ul>
 * <p>
 * Store procedure collections are defined as Java enumerations that implement the {@link SProcAPI}
 * interface: 
 * <ul>
 * <li>{@link SProcAPI#getSignature() getSignature} - Get the signature for this stored procedure object. This defines
 *     the name of the stored procedure and the modes of its arguments. If the stored procedure accepts varargs, this
 *     will also be indicated.</li>
 * <li>{@link SProcAPI#getArgTypes() getArgTypes} - Get the argument types for this stored procedure object. </li>
 * <li>{@link SProcAPI#getConnection() getConnection} - Get the connection string associated with this stored
 *     procedure. This eliminates the need for the client to provide this information.</li>
 * <li>{@link SProcAPI#getEnum() getEnum} - Get the enumeration to which this stored procedure belongs. This enables
 *     {@link #executeStoredProcedure(Class, SProcAPI, Object[])} to retrieve the name of the stored procedured's
 *     enumerated constant for diagnostic messages.</li>
 * </ul>
 * <p>
 * To maximize usability and configurability, we recommend the following implementation strategy: <ul>
 * <li>Define your collection as an enumeration: <ul>
 *     <li>Query collections implement {@link QueryAPI}.</li>
 *     <li>Stored procedure collections implement {@link SProcAPI}.</li>
 *     </ul></li>
 * <li>Define each constant: <ul>
 *     <li>(query) Specify a property name and a name for each argument (if any).</li>
 *     <li>(sproc) Declare the signature and the type for each argument (if any).</li>
 *     </ul></li>
 * <li>To assist users of your queries, preface their names with a type indicator (<b>GET</b> or <b>UPDATE</b>).</li>
 * <li>Back query collections with configurations that implement the <b>{@code Settings API}</b>: <ul>
 *     <li>groupId: com.nordstrom.test-automation.tools</li>
 *     <li>artifactId: settings</li>
 *     <li>className: com.nordstrom.automation.settings.SettingsCore</li>
 *     </ul></li>
 * <li>To support execution on multiple endpoints, implement {@link QueryAPI#getConnection()} or {@link
 *     SProcAPI#getConnection()} with sub-configurations or other dynamic data sources (e.g.
 *     - web service).</li>
 * </ul>
 * <b>Query Collection Example</b>
 * 
 * <pre>
 * public class OpctConfig extends {@code SettingsCore<OpctConfig.OpctValues>} {
 * 
 *     private static final String SETTINGS_FILE = "OpctConfig.properties";
 * 
 *     private OpctConfig() throws ConfigurationException, IOException {
 *         super(OpctValues.class);
 *     }
 * 
 *     public enum OpctValues implements SettingsCore.SettingsAPI, QueryAPI {
 *         /** args: [  ] *&#47;
 *         GET_RULE_HEAD_DETAILS("opct.query.getRuleHeadDetails"),
 *         /** args: [ name, zone_id, priority, rule_type ] *&#47;
 *         GET_RULE_COUNT("opct.query.getRuleCount", "name", "zone_id", "priority", "rule_type"),
 *         /** args: [ role_id, user_id ] *&#47;
 *         UPDATE_USER_ROLE("opct.query.updateRsmUserRole", "role_id", "user_id"),
 *         /** MST connection string *&#47;
 *         MST_CONNECT("opct.connect.mst"),
 *         /** RMS connection string *&#47;
 *         RMS_CONNECT("opct.connect.rms");
 * 
 *         private String key;
 *         private String[] args;
 *         private String query;
 * 
 *         private static OpctConfig config;
 *         private static String mstConnect;
 *         private static String rmsConnect;
 * 
 *         private static {@code EnumSet<OpctValues>} rmsQueries = EnumSet.of(UPDATE_USER_ROLE);
 * 
 *         static {
 *             try {
 *                 config = new OpctConfig();
 *             } catch (ConfigurationException | IOException e) {
 *                 throw new RuntimeException("Unable to instantiate OPCT configuration object", e);
 *             }
 *         }
 * 
 *         OpctValues(String key, String... args) {
 *             this.key = key;
 *             this.args = args;
 *         }
 * 
 *         {@code @Override}
 *         public String key() {
 *             return key;
 *         }
 * 
 *         {@code @Override}
 *         public String getQueryStr() {
 *             if (query == null) {
 *                 query = config.getString(key);
 *             }
 *             return query;
 *         }
 * 
 *         {@code @Override}
 *         public String[] getArgNames() {
 *             return args;
 *         }
 * 
 *         {@code @Override}
 *         public String getConnection() {
 *             if (rmsQueries.contains(this)) {
 *                 return getRmsConnect();
 *             } else {
 *                 return getMstConnect();
 *             }
 *         }
 * 
 *         {@code @Override}
 *         public {@code Enum<OpctValues>} getEnum() {
 *             return this;
 *         }
 * 
 *         /**
 *          * Get MST connection string.
 *          * 
 *          * @return MST connection string
 *          *&#47;
 *         public static String getMstConnect() {
 *             if (mstConnect == null) {
 *                 mstConnect = config.getString(OpctValues.MST_CONNECT.key());
 *             }
 *             return mstConnect;
 *         }
 * 
 *         /**
 *          * Get RMS connection string.
 *          * 
 *          * @return RMS connection string
 *          *&#47;
 *         public static String getRmsConnect() {
 *             if (rmsConnect == null) {
 *                 rmsConnect = config.getString(OpctValues.RMS_CONNECT.key());
 *             }
 *             return rmsConnect;
 *         }
 *     }
 * 
 *     {@code @Override}
 *     public String getSettingsPath() {
 *         return SETTINGS_FILE;
 *     }
 * 
 *     /**
 *      * Get OPCT configuration object.
 *      *
 *      * @return OPCT configuration object
 *      *&#47;
 *     public static OpctConfig getConfig() {
 *         return OpctValues.config;
 *     }
 * 
 *     public enum SProcValues implements SProcAPI {
 *         /** args: [  ] *&#47;
 *         SHOW_SUPPLIERS("SHOW_SUPPLIERS()"),
 *         /** args: [ coffee_name, supplier_name ] *&#47;
 *         GET_SUPPLIER_OF_COFFEE("GET_SUPPLIER_OF_COFFEE(&gt;, &lt;)", Types.VARCHAR, Types.VARCHAR),
 *         /** args: [ coffee_name, max_percent, new_price ] *&#47;
 *         RAISE_PRICE("RAISE_PRICE(&gt;, &gt;, =)", Types.VARCHAR, Types.REAL, Types.NUMERIC),
 *         /** args: [ str, val... ] *&#47;
 *         IN_VARARGS("IN_VARARGS(&lt;, &gt;:)", Types.VARCHAR, Types.INTEGER),
 *         /** args: [ val, str... ] *&#47;
 *         OUT_VARARGS("OUT_VARARGS(&gt;, &lt;:)", Types.INTEGER, Types.VARCHAR);
 * 
 *         private int[] argTypes;
 *         private String signature;
 * 
 *         SProcValues(String signature, int... argTypes) {
 *             this.signature = signature;
 *             
 *             this.argTypes = argTypes;
 *         }
 * 
 *         {@code @Override}
 *         public String getSignature() {
 *             return signature;
 *         }
 * 
 *         {@code @Override}
 *         public int[] getArgTypes () {
 *             return argTypes;
 *         }
 * 
 *         {@code @Override}
 *         public String getConnection() {
               return OpctValues.getRmsConnect();
 *         }
 * 
 *         {@code @Override}
 *         public {@code Enum<SProcValues>} getEnum() {
 *             return this;
 *         }
 *     }
 * }
 * </pre>
 */
public class DatabaseUtils {
    
    private static Pattern SPROC_PATTERN = 
                    Pattern.compile("([\\p{Alpha}_][\\p{Alpha}\\p{Digit}@$#_]*)(?:\\(([<>=](?:,\\s*[<>=])*)?(:)?\\))?");
    
    private DatabaseUtils() {
        throw new AssertionError("DatabaseUtils is a static utility class that cannot be instantiated");
    }
    
    static {
        Iterator<Driver> iterator = ServiceLoader.load(Driver.class).iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }
    
    /**
     * Execute the specified query object with supplied arguments as an 'update' operation
     * 
     * @param query query object to execute
     * @param queryArgs replacement values for query place-holders
     * @return count of records updated
     */
    public static int update(QueryAPI query, Object... queryArgs) {
        Integer result = (Integer) executeQuery(null, query, queryArgs);
        return (result != null) ? result.intValue() : -1;
    }
    
    /**
     * Execute the specified query object with supplied arguments as a 'query' operation
     * 
     * @param query query object to execute
     * @param queryArgs replacement values for query place-holders
     * @return row 1 / column 1 as integer; -1 if no rows were returned
     */
    public static int getInt(QueryAPI query, Object... queryArgs) {
        Integer result = (Integer) executeQuery(Integer.class, query, queryArgs);
        return (result != null) ? result.intValue() : -1;
    }
    
    /**
     * Execute the specified query object with supplied arguments as a 'query' operation
     * 
     * @param query query object to execute
     * @param queryArgs replacement values for query place-holders
     * @return row 1 / column 1 as string; {@code null} if no rows were returned
     */
    public static String getString(QueryAPI query, Object... queryArgs) {
        return (String) executeQuery(String.class, query, queryArgs);
    }
    
    /**
     * Execute the specified query object with supplied arguments as a 'query' operation
     * 
     * @param query query object to execute
     * @param queryArgs replacement values for query place-holders
     * @return {@link ResultPackage} object
     */
    public static ResultPackage getResultPackage(QueryAPI query, Object... queryArgs) {
        return (ResultPackage) executeQuery(ResultPackage.class, query, queryArgs);
    }
    
    /**
     * Execute the specified query with the supplied arguments, returning a result of the indicated type.
     * <p>
     * <b>TYPES</b>: Specific result types produce the following behaviors: <ul>
     * <li>{@code null} - The query is executed as an update operation.</li>
     * <li>{@link ResultPackage} - An object containing the connection, statement, and result set is returned</li>
     * <li>{@link Integer} - If rows were returned, row 1 / column 1 is returned as an Integer; otherwise -1</li>
     * <li>{@link String} - If rows were returned, row 1 / column 1 is returned as an String; otherwise {@code null}</li>
     * <li>For other types, {@link ResultSet#getObject(int, Class)} to return row 1 / column 1 as that type</li></ul>
     * 
     * @param resultType desired result type (see TYPES above)
     * @param query query object to execute
     * @param queryArgs replacement values for query place-holders
     * @return for update operations, the number of rows affected; for query operations, an object of the indicated type<br>
     * <b>NOTE</b>: If you specify {@link ResultPackage} as the result type, it's recommended that you close this object
     * when you're done with it to free up database and JDBC resources that were allocated for it. 
     */
    private static Object executeQuery(Class<?> resultType, QueryAPI query, Object... queryArgs) {
        int expectCount = query.getArgNames().length;
        int actualCount = queryArgs.length;
        
        if (actualCount != expectCount) {
            String message;
            
            if (expectCount == 0) {
                message = "No arguments expected for " + query.getEnum().name();
            } else {
                message = String.format("Incorrect argument count for %s%s: expect: %d; actual: %d", 
                        query.getEnum().name(), Arrays.toString(query.getArgNames()), expectCount, actualCount);
            }
            
            throw new IllegalArgumentException(message);
        }
        
        return executeQuery(resultType, query.getConnection(), query.getQueryStr(), queryArgs);
    }
    
    /**
     * Execute the specified query with the supplied arguments, returning a result of the indicated type.
     * <p>
     * <b>TYPES</b>: Specific result types produce the following behaviors: <ul>
     * <li>{@code null} - The query is executed as an update operation.</li>
     * <li>{@link ResultPackage} - An object containing the connection, statement, and result set is returned</li>
     * <li>{@link Integer} - If rows were returned, row 1 / column 1 is returned as an Integer; otherwise -1</li>
     * <li>{@link String} - If rows were returned, row 1 / column 1 is returned as an String; otherwise {@code null}</li>
     * <li>For other types, {@link ResultSet#getObject(int, Class)} to return row 1 / column 1 as that type</li></ul>
     * 
     * @param resultType desired result type (see TYPES above)
     * @param connectionStr database connection string
     * @param queryStr a SQL statement that may contain one or more '?' IN parameter placeholders
     * @param params an array of objects containing the input parameter values
     * @return for update operations, the number of rows affected; for query operations, an object of the indicated type<br>
     * <b>NOTE</b>: If you specify {@link ResultPackage} as the result type, it's recommended that you close this object
     * when you're done with it to free up database and JDBC resources that were allocated for it. 
     */
    public static Object executeQuery(Class<?> resultType, String connectionStr, String queryStr, Object... params) {
        try {
            Connection connection = getConnection(connectionStr);
            PreparedStatement statement = connection.prepareStatement(queryStr);
            
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            
            return executeStatement(resultType, connection, statement);
        } catch (SQLException e) {
            throw UncheckedThrow.throwUnchecked(e);
        }
    }
    
    /**
     * Execute the specified stored procedure object with supplied parameters
     * 
     * @param sproc stored procedure object to execute
     * @param params an array of objects containing the input parameter values
     * @return row 1 / column 1 as integer; -1 if no rows were returned
     */
    public static int getInt(SProcAPI sproc, Object... params) {
        Integer result = (Integer) executeStoredProcedure(Integer.class, sproc, params);
        return (result != null) ? result.intValue() : -1;
    }
    
    /**
     * Execute the specified stored procedure object with supplied parameters
     * 
     * @param sproc stored procedure object to execute
     * @param params an array of objects containing the input parameter values
     * @return row 1 / column 1 as string; {@code null} if no rows were returned
     */
    public static String getString(SProcAPI sproc, Object... params) {
        return (String) executeStoredProcedure(String.class, sproc, params);
    }
    
    /**
     * Execute the specified stored procedure object with supplied parameters
     * 
     * @param sproc stored procedure object to execute
     * @param params an array of objects containing the input parameter values
     * @return {@link ResultPackage} object
     */
    public static ResultPackage getResultPackage(SProcAPI sproc, Object... params) {
        return (ResultPackage) executeStoredProcedure(ResultPackage.class, sproc, params);
    }
    
    /**
     * Execute the specified stored procedure with the specified arguments, returning a result of the indicated type.
     * <p>
     * <b>TYPES</b>: Specific result types produce the following behaviors: <ul>
     * <li>{@link ResultPackage} - An object containing the connection, statement, and result set is returned</li>
     * <li>{@link Integer} - If rows were returned, row 1 / column 1 is returned as an Integer; otherwise -1</li>
     * <li>{@link String} - If rows were returned, row 1 / column 1 is returned as an String; otherwise {@code null}</li>
     * <li>For other types, {@link ResultSet#getObject(int, Class)} to return row 1 / column 1 as that type</li></ul>
     * 
     * @param resultType desired result type (see TYPES above)
     * @param sproc stored procedure object to execute
     * @param params an array of objects containing the input parameter values
     * @return an object of the indicated type<br>
     * <b>NOTE</b>: If you specify {@link ResultPackage} as the result type, it's recommended that you close this object
     * when you're done with it to free up database and JDBC resources that were allocated for it. 
     */
    public static Object executeStoredProcedure(Class<?> resultType, SProcAPI sproc, Object... params) {
        Objects.requireNonNull(resultType, "[resultType] argument must be non-null");
        
        String[] args = {};
        String sprocName = null;
        boolean hasVarArgs = false;
        int[] argTypes = sproc.getArgTypes();
        String signature = sproc.getSignature();
        Matcher matcher = SPROC_PATTERN.matcher(signature);
        
        String message = null;
        if (matcher.matches()) {
            sprocName = matcher.group(1);
            hasVarArgs = (matcher.group(3) != null);
            if (matcher.group(2) != null) {
                args = matcher.group(2).split(",\\s");
            } else {
                if (hasVarArgs) {
                    message = String.format("VarArgs indicated with no placeholder in signature for %s: %s",
                            sproc.getEnum().name(), signature);
                }
            }
        } else {
            message = String.format("Unsupported stored procedure signature for %s: %s",
                            sproc.getEnum().name(), signature);
        }
        
        if (message != null) {
            throw new IllegalArgumentException(message);
        }
        
        int argsCount = args.length;
        int typesCount = argTypes.length;
        int parmsCount = params.length;
        
        int minCount = typesCount;
        
        // if unbalanced args/types
        if (argsCount != typesCount) {
            message = String.format(
                            "Signature argument count differs from declared type count for %s%s: "
                                            + "signature: %d; declared: %d",
                            sproc.getEnum().name(), Arrays.toString(argTypes), argsCount, typesCount);
        } else if (hasVarArgs) {
            minCount -= 1;
            if (parmsCount < minCount) {
                message = String.format(
                                "Insufficient arguments count for %s%s: minimum: %d; actual: %d",
                                sproc.getEnum().name(), Arrays.toString(argTypes), minCount, parmsCount);
            }
        } else if (parmsCount != typesCount) {
            if (typesCount == 0) {
                message = "No arguments expected for " + sproc.getEnum().name();
            } else {
                message = String.format(
                                "Incorrect arguments count for %s%s: expect: %d; actual: %d",
                                sproc.getEnum().name(), Arrays.toString(argTypes), typesCount, parmsCount);
            }
        }
        
        if (message != null) {
            throw new IllegalArgumentException(message);
        }
        
        Param[] parmArray = Param.array(parmsCount);
        
        int i;
        
        // process declared parameters
        for (i = 0; i < minCount; i++) {
            Mode mode = Mode.fromChar(args[i].charAt(0));
            parmArray[i] = Param.create(mode, argTypes[i], params[i]);
        }
        
        // handle varargs parameters
        for (int j = i; j < parmsCount; j++) {
            Mode mode = Mode.fromChar(args[i].charAt(0));
            parmArray[j] = Param.create(mode, argTypes[i], params[j]);
        }
        
        return executeStoredProcedure(resultType, sproc.getConnection(), sprocName, parmArray);
    }
    
    /**
     * Execute the specified stored procedure with the supplied arguments, returning a result of the indicated type.
     * <p>
     * <b>TYPES</b>: Specific result types produce the following behaviors: <ul>
     * <li>{@link ResultPackage} - An object containing the connection, statement, and result set is returned</li>
     * <li>{@link Integer} - If rows were returned, row 1 / column 1 is returned as an Integer; otherwise -1</li>
     * <li>{@link String} - If rows were returned, row 1 / column 1 is returned as an String; otherwise {@code null}</li>
     * <li>For other types, {@link ResultSet#getObject(int, Class)} to return row 1 / column 1 as that type</li></ul>
     * 
     * @param resultType desired result type (see TYPES above)
     * @param connectionStr database connection string
     * @param sprocName name of the stored procedure to be executed
     * @param params an array of objects containing the input parameter values
     * @return an object of the indicated type<br>
     * <b>NOTE</b>: If you specify {@link ResultPackage} as the result type, it's recommended that you close this object
     * when you're done with it to free up database and JDBC resources that were allocated for it. 
     */
    public static Object executeStoredProcedure(Class<?> resultType, String connectionStr, String sprocName, Param... params) {
        Objects.requireNonNull(resultType, "[resultType] argument must be non-null");
        
        StringBuilder sprocStr = new StringBuilder("{call ").append(sprocName).append("(");
        
        String placeholder = "?";
        for (int i = 0; i < params.length; i++) {
            sprocStr.append(placeholder);
            placeholder = ",?";
        }
        
        sprocStr.append(")}");
        
        try {
            Connection connection = getConnection(connectionStr);
            CallableStatement statement = connection.prepareCall(sprocStr.toString());
            
            for (int i = 0; i < params.length; i++) {
                params[i].set(statement, i + 1);
            }
            
            return executeStatement(resultType, connection, statement);
        } catch (SQLException e) {
            throw UncheckedThrow.throwUnchecked(e);
        }
    }
    
    /**
     * Execute the specified prepared statement, returning a result of the indicated type.
     * <p>
     * <b>TYPES</b>: Specific result types produce the following behaviors: <ul>
     * <li>{@code null} - The prepared statement is a query to be executed as an update operation.</li>
     * <li>{@link ResultPackage} - An object containing the connection, statement, and result set is returned</li>
     * <li>{@link Integer} - If rows were returned, row 1 / column 1 is returned as an Integer; otherwise -1</li>
     * <li>{@link String} - If rows were returned, row 1 / column 1 is returned as an String; otherwise {@code null}</li>
     * <li>For other types, {@link ResultSet#getObject(int, Class)} to return row 1 / column 1 as that type</li></ul>
     * <p>
     * <b>NOTE</b>: For all result types except {@link ResultPackage}, the specified connection and statement, as well
     * as the result set from executing the statement, are closed prior to returning the result. 
     * 
     * @param resultType desired result type (see TYPES above)
     * @param connectionStr database connection string
     * @param statement prepared statement to be executed (query or store procedure)
     * @return for update operations, the number of rows affected; for query operations, an object of the indicated type<br>
     * <b>NOTE</b>: If you specify {@link ResultPackage} as the result type, it's recommended that you close this object
     * when you're done with it to free up database and JDBC resources that were allocated for it. 
     */
    private static Object executeStatement(Class<?> resultType, Connection connection, PreparedStatement statement) {
        Object result = null;
        boolean failed = false;
        
        ResultSet resultSet = null;
        
        try {
            if (resultType == null) {
                result = Integer.valueOf(statement.executeUpdate());
            } else {
                if (statement instanceof CallableStatement) {
                    if (statement.execute()) {
                        resultSet = statement.getResultSet(); //NOSONAR
                    }
                    
                    if (resultType == ResultPackage.class) {
                        result = new ResultPackage(connection, statement, resultSet); //NOSONAR
                    } else if (resultType == Integer.class) {
                        result = ((CallableStatement) statement).getInt(1);
                    } else if (resultType == String.class) {
                        result = ((CallableStatement) statement).getString(1);
                    } else {
                        result = ((CallableStatement) statement).getObject(1);
                    }
                } else {
                    resultSet = statement.executeQuery(); //NOSONAR
                    
                    if (resultType == ResultPackage.class) {
                        result = new ResultPackage(connection, statement, resultSet); //NOSONAR
                    } else if (resultType == Integer.class) {
                        result = Integer.valueOf((resultSet.next()) ? resultSet.getInt(1) : -1);
                    } else if (resultType == String.class) {
                        result = (resultSet.next()) ? resultSet.getString(1) : null;
                    } else {
                        result = (resultSet.next()) ? resultSet.getObject(1, resultType) : null;
                    }
                }
            }

        } catch (SQLException e) {
            failed = true;
            throw UncheckedThrow.throwUnchecked(e);
        } finally {
            if (failed || (resultType != ResultPackage.class)) {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        // Suppress shutdown failures
                    }
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        // Suppress shutdown failures
                    }
                }
                if (connection != null) {
                    try {
                        connection.commit();
                        connection.close();
                    } catch (SQLException e) {
                        // Suppress shutdown failures
                    }
                }
            }
        }
        
        return result;
    }
    
    /**
     * Get a connection to the database associated with the specified connection string.
     * 
     * @param connectionString database connection string
     * @return database connection object
     */
    private static Connection getConnection(String connectionString) {
        try {
            return DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            throw UncheckedThrow.throwUnchecked(e);
        }
    }
    
    /**
     * This interface defines the API supported by database query collections
     */
    public interface QueryAPI {
        
        /**
         * Get the query string for this query object.
         * 
         * @return query object query string
         */
        String getQueryStr();
        
        /**
         * Get the argument names for this query object.
         *  
         * @return query object argument names
         */
        String[] getArgNames();
        
        /**
         * Get the database connection string for this query object.
         * 
         * @return query object connection string
         */
        String getConnection();
        
        /**
         * Get the implementing enumerated constant for this query object.
         * 
         * @return query object enumerated constant
         */
        Enum<? extends QueryAPI> getEnum(); //NOSONAR
    }
    
    /**
     * This interface defines the API supported by database stored procedure collections
     */
    public interface SProcAPI {
        
        /**
         * Get the signature for this stored procedure object.
         * <p>
         * Each argument place holder in the stored procedure signature indicates the mode of the corresponding
         * parameter: 
         * 
         * <ul>
         *     <li>'&gt;' : This argument is an IN parameter</li>
         *     <li>'&lt;' : This argument is an OUT parameter</li>
         *     <li>'=' : This argument is an INOUT parameter</li>
         * </ul>
         * 
         * For example:
         * 
         * <blockquote>RAISE_PRICE(&gt;, &lt;, =)</blockquote>
         * 
         * The first and second arguments are IN parameters, and the third argument is an INOUT parameter.
         * 
         * @return stored procedure signature
         */
        String getSignature();
        
        /**
         * Get the argument types for this stored procedure object.
         * 
         * @return stored procedure argument types
         */
        int[] getArgTypes();
        
        /**
         * Get the database connection string for this stored procedure object.
         * 
         * @return stored procedure connection string
         */
        String getConnection();
        
        /**
         * Get the implementing enumerated constant for this stored procedure object.
         * 
         * @return stored procedure enumerated constant
         */
        Enum<? extends SProcAPI> getEnum(); //NOSONAR
    }
    
    /**
     * This class defines a package of database objects associated with a query. These include:<ul>
     * <li>{@link Connection} object</li>
     * <li>{@link PreparedStatement} object</li>
     * <li>{@link ResultSet} object</li></ul>
     */
    public static class ResultPackage implements AutoCloseable {
        
        private Connection connection;
        private PreparedStatement statement;
        private ResultSet resultSet;
        
        /**
         * Constructor for a result package object
         * 
         * @param connection {@link Connection} object
         * @param statement {@link PreparedStatement} object
         * @param resultSet {@link ResultSet} object
         */
        private ResultPackage(Connection connection, PreparedStatement statement, ResultSet resultSet) {
            this.connection = connection;
            this.statement = statement;
            this.resultSet = resultSet;
        }
        
        public Connection getConnection() {
            return connection;
        }
        
        public PreparedStatement getStatement() {
            return statement;
        }
        
        public CallableStatement getCallable() {
            if (statement instanceof CallableStatement) {
                return (CallableStatement) statement;
            }
            throw new UnsupportedOperationException("The statement of this package is not a CallableStatement");
        }
        
        /**
         * Get the result set object of this package.
         * 
         * @return {@link ResultSet} object
         */
        public ResultSet getResultSet() {
            if (resultSet != null) return resultSet;
            throw new IllegalStateException("The result set in this package has been closed");
        }
        
        @Override
        public void close() {
            if (resultSet != null) {
                try {
                    resultSet.close();
                    resultSet = null;
                } catch (SQLException e) { }
            }
            if (statement != null) {
                try {
                    statement.close();
                    statement = null;
                } catch (SQLException e) { }
            }
            if (connection != null) {
                try {
                    connection.commit();
                    connection.close();
                    connection = null;
                } catch (SQLException e) { }
            }
        }
    }
}