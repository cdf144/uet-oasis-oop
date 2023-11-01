package com.nordstrom.common.file;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class provides utility methods and abstractions for host operating system features.
 * 
 * @param <T> an operating system mapping enumeration that implements the {@link OSProps} interface
 */
public class OSInfo<T extends Enum<T> & OSInfo.OSProps> {
    
    private static String osName = System.getProperty("os.name");
    private static String version = System.getProperty("os.version");
    private static String arch = System.getProperty("os.arch");

    private final Map<T, String> typeMap = new LinkedHashMap<>();
    
    /**
     * Get an object that supports the set of operating systems defined in the {@link OSType} enumeration.
     * 
     * @return OSUtils object that supports the operating systems defined in {@link OSType}
     */
    public static OSInfo<OSType> getDefault() {
        return new OSInfo<>(OSType.class);
    }
    
    /**
     * Create an object that supports the mappings defined by the specified enumeration.
     * 
     * @param enumClass operating system mapping enumeration
     */
    public OSInfo(Class<T> enumClass) {
        putAll(enumClass);
    }
    
    /**
     * Get the enumerated type constant for the active operating system.
     * 
     * @return OS type constant; if no match, returns 'null'
     */
    public T getType() {
        // populate a linked list with the entries of the linked type map
        List<Entry<T, String>> entryList = new LinkedList<>(typeMap.entrySet());
        // get a list iterator, setting the cursor at the tail end
        ListIterator<Entry<T, String>> iterator = entryList.listIterator(entryList.size());
        // iterate from last to first
        while (iterator.hasPrevious()) {
            Entry<T, String> thisEntry = iterator.previous();
            if (osName.matches(thisEntry.getValue())) {
                return thisEntry.getKey();
            }
        }
        return null;
    }
    
    /**
     * Add the specified mapping to the collection.<br>
     * <b>NOTE</b>: If a mapping for the specified constant already exists, this mapping will be replaced.
     * 
     * @param <U> an operating system mapping enumeration that implements the {@link OSProps} interface
     * @param typeConst OS type constant
     * @return value of previous mapping; 'null' if no mapping existed
     */
    @SuppressWarnings("unchecked")
    public <U extends Enum<U> & OSProps> String put(U typeConst) {
        return typeMap.put((T) typeConst, typeConst.pattern());
    }
    
    /**
     * Add the specified mapping to the collection.<br>
     * <b>NOTE</b>: If a mapping for the specified constant already exists, this mapping will be replaced.
     * 
     * @param <U> an operating system mapping enumeration that implements the {@link OSProps} interface
     * @param typeConst OS type constant
     * @param pattern OS name match pattern
     * @return value of previous mapping; 'null' if no mapping existed
     */
    @SuppressWarnings("unchecked")
    public <U extends Enum<U> & OSProps> String put(U typeConst, String pattern) {
        return typeMap.put((T) typeConst, pattern);
    }
    
    /**
     * Add the mappings defined by the specified enumeration to the collection.<br>
     * <b>NOTE</b>: If any of the specified mappings already exist, the previous mappings will be replaced.
     * 
     * @param <U> an operating system mapping enumeration that implements the {@link OSProps} interface
     * @param enumClass operating system mapping enumeration
     */
    public <U extends Enum<U> & OSProps> void putAll(Class<U> enumClass) {
        for (U typeConst : enumClass.getEnumConstants()) {
            put(typeConst);
        }
    }
    
    /**
     * Get the name of the active operating system.
     * 
     * @return name of the active operating system
     */
    public static String osName() {
        return osName;
    }
    
    /**
     * Get the version of the existing operating system.
     * 
     * @return version of the existing operating system
     */
    public static String version() {
        return version;
    }
    
    /**
     * Get the architecture of the active operating system.
     * 
     * @return architecture of the active operating system
     */
    public static String arch() {
        return arch;
    }
    
    /**
     * This enumeration defines the default set of operating system mappings.
     */
    public enum OSType implements OSProps {
        WINDOWS("(?i).*win.*"),
        MACINTOSH("(?i).*mac.*"),
        UNIX("(?i).*(?:nix|nux|aix).*"),
        SOLARIS("(?i).*sunos.*");
        
        OSType(String pattern) {
            this.pattern = pattern;
        }
        
        private String pattern;
        
        @Override
        public String pattern() {
            return pattern;
        }
    }
    
    /**
     * This interface defines the required contract for operating system mapping enumerations.
     */
    public interface OSProps {
        
        /**
         * Get the OS name match pattern for this mapping.
         *  
         * @return OS name match pattern
         */
        String pattern();
        
    }

}
