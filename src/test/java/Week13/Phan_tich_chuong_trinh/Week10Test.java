package Week13.Phan_tich_chuong_trinh;

import Week14.Input_Output.Utils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Week10Test {
    private static final String PATH_TESTS = "src"
            + File.separator + "main"
            + File.separator + "java"
            + File.separator + "Week13"
            + File.separator + "Phan_tich_chuong_trinh"
            + File.separator + "Test_cases"
            + File.separator;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void restoreStreams() {
        System.setOut(printStream);
    }

    @Test
    public void TestRandomNumberUtils() throws IOException {
        String filePath = PATH_TESTS + "RandomNumberUtils.txt";
        String fileContent = Utils.readContentFromFile(filePath);

        String expected = "[randomInt(), randomInt(int,int), randomIntLessThan(int), " +
                "randomLong(), randomPositiveLong(), randomNegativeLong(), randomLong(long,long), " +
                "randomLongGreaterThan(long), randomLongLessThan(long), randomDouble(), " +
                "randomPositiveDouble(), randomNegativeDouble(), randomDouble(double,double), " +
                "randomDoubleGreaterThan(double), randomDoubleLessThan(double)]";

        List<String> actual = Week10.getAllFunctions(fileContent);
        System.out.print(actual);

        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void TestDatabaseUtils() throws IOException {
        String filePath = PATH_TESTS + "DatabaseUtils.txt";
        String fileContent = Utils.readContentFromFile(filePath);

        String expected = "[update(com.nordstrom.common.jdbc.utils.QueryAPI,java.lang.Object), " +
                "getInt(com.nordstrom.common.jdbc.utils.QueryAPI,java.lang.Object), " +
                "getString(com.nordstrom.common.jdbc.utils.QueryAPI,java.lang.Object), " +
                "getResultPackage(com.nordstrom.common.jdbc.utils.QueryAPI,java.lang.Object), " +
                "executeQuery(java.lang.Class<?>,com.nordstrom.common.jdbc.utils.QueryAPI,java.lang.Object), " +
                "executeQuery(java.lang.Class<?>,java.lang.String,java.lang.String,java.lang.Object), " +
                "getInt(com.nordstrom.common.jdbc.utils.SProcAPI,java.lang.Object), " +
                "getString(com.nordstrom.common.jdbc.utils.SProcAPI,java.lang.Object), " +
                "getResultPackage(com.nordstrom.common.jdbc.utils.SProcAPI,java.lang.Object), " +
                "executeStoredProcedure(java.lang.Class<?>,com.nordstrom.common.jdbc.utils.SProcAPI,java.lang.Object), " +
                "executeStoredProcedure(java.lang.Class<?>,java.lang.String,java.lang.String,com.nordstrom.common.jdbc.Param), " +
                "executeStatement(java.lang.Class<?>,java.sql.Connection,java.sql.PreparedStatement), " +
                "getConnection(java.lang.String)]";

        List<String> actual = Week10.getAllFunctions(fileContent);
        System.out.print(actual);

        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void TestOSInfo() throws IOException {
        String filePath = PATH_TESTS + "OSInfo.txt";
        String fileContent = Utils.readContentFromFile(filePath);

        String expected = "[getDefault(), osName(), version(), arch()]";

        List<String> actual = Week10.getAllFunctions(fileContent);
        System.out.print(actual);

        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void TestVolumeInfo() throws IOException {
        String filePath = PATH_TESTS + "VolumeInfo.txt";
        String fileContent = Utils.readContentFromFile(filePath);

        String expected = "[getVolumeProps(), getVolumeProps(java.io.InputStream)]";

        List<String> actual = Week10.getAllFunctions(fileContent);
        System.out.print(actual);

        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void TestRandomArrayUtils() throws IOException {
        String filePath = PATH_TESTS + "RandomArrayUtils.txt";
        String fileContent = Utils.readContentFromFile(filePath);

        String expected = "[randomArrayFrom(T[],com.google.common.collect.Range<java.lang.Integer>), " +
                "randomArrayFrom(java.lang.Iterable<T>,com.google.common.collect.Range<java.lang.Integer>), " +
                "randomArrayFrom(T[],int), randomArrayFrom(java.lang.Iterable<T>,int), " +
                "randomArrayFrom(java.util.function.Supplier<T>,com.google.common.collect.Range<java.lang.Integer>), " +
                "randomArrayFrom(java.util.function.Supplier<T>,int)]";

        List<String> actual = Week10.getAllFunctions(fileContent);
        System.out.print(actual);

        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void TestPathUtils() throws IOException {
        String filePath = PATH_TESTS + "PathUtils.txt";
        String fileContent = Utils.readContentFromFile(filePath);

        String expected = "[fromObject(java.lang.Object), getPathForObject(java.lang.Object), getTargetPath(), " +
                "getNextPath(java.nio.file.Path,java.lang.String,java.lang.String), getBaseDir()]";

        List<String> actual = Week10.getAllFunctions(fileContent);
        System.out.print(actual);

        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void TestDateUtils() throws IOException {
        String filePath = PATH_TESTS + "DateUtils.txt";
        String fileContent = Utils.readContentFromFile(filePath);

        String expected = "[isLeapDay(java.time.temporal.TemporalAccessor), " +
                "atStartOfDay(java.util.Date), atEndOfDay(java.util.Date), " +
                "dateToLocalDateTime(java.util.Date), localDateTimeToDate(java.time.LocalDateTime)]";

        List<String> actual = Week10.getAllFunctions(fileContent);
        System.out.print(actual);

        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void TestRandomDateUtils() throws IOException {
        String filePath = PATH_TESTS + "RandomDateUtils.txt";
        String fileContent = Utils.readContentFromFile(filePath);

        String expected = "[randomZonedDateTime(), randomZonedDateTime(java.time.ZonedDateTime,java.time.ZonedDateTime), " +
                "randomFutureZonedDateTime(), randomZonedDateTimeAfter(java.time.ZonedDateTime), " +
                "randomPastZonedDateTime(), randomZonedDateTimeBefore(java.time.ZonedDateTime), " +
                "randomOffsetDateTime(), randomOffsetDateTime(java.time.OffsetDateTime,java.time.OffsetDateTime), " +
                "randomFutureOffsetDateTime(), randomOffsetDateTimeAfter(java.time.OffsetDateTime), " +
                "randomPastOffsetDateTime(), randomOffsetDateTimeBefore(java.time.OffsetDateTime), " +
                "randomLocalDateTime(), randomLocalDateTime(java.time.LocalDateTime,java.time.LocalDateTime), " +
                "randomFutureLocalDateTime(), randomLocalDateTimeAfter(java.time.LocalDateTime), " +
                "randomPastLocalDateTime(), randomLocalDateTimeBefore(java.time.LocalDateTime), " +
                "randomLocalDate(), randomLocalDate(java.time.LocalDate,java.time.LocalDate), " +
                "randomFutureLocalDate(), randomLocalDateAfter(java.time.LocalDate), randomPastLocalDate(), " +
                "randomLocalDateBefore(java.time.LocalDate), randomDate(), randomDate(java.util.Date,java.util.Date), " +
                "randomFutureDate(), randomDateAfter(java.util.Date), randomPastDate(), randomDateBefore(java.util.Date), " +
                "randomInstant(), randomInstant(java.time.Instant,java.time.Instant), randomFutureInstant(), " +
                "randomInstantAfter(java.time.Instant), randomPastInstant(), randomInstantBefore(java.time.Instant), " +
                "randomLocalTime(), randomLocalTime(java.time.LocalTime,java.time.LocalTime), " +
                "randomLocalTimeAfter(java.time.LocalTime), randomLocalTimeBefore(java.time.LocalTime), " +
                "random(java.time.temporal.TemporalField), random(java.time.temporal.TemporalField,long,long), " +
                "randomAfter(java.time.temporal.TemporalField,long), randomBefore(java.time.temporal.TemporalField,long), " +
                "randomMonthDay(), randomMonthDay(boolean), randomMonthDay(java.time.MonthDay,java.time.MonthDay), " +
                "randomMonthDay(java.time.MonthDay,java.time.MonthDay,boolean), randomMonthDayAfter(java.time.MonthDay), " +
                "randomMonthDayAfter(java.time.MonthDay,boolean), randomMonthDayBefore(java.time.MonthDay), " +
                "randomMonthDayBefore(java.time.MonthDay,boolean), randomYearMonth(), " +
                "randomYearMonth(java.time.YearMonth,java.time.YearMonth), randomFutureYearMonth(), " +
                "randomYearMonthAfter(java.time.YearMonth), randomPastYearMonth(), randomYearMonthBefore(java.time.YearMonth), " +
                "randomYear(), randomYear(java.time.Year,java.time.Year), randomYear(int,int), randomFutureYear(), " +
                "randomYearAfter(java.time.Year), randomYearAfter(int), randomPastYear(), randomYearBefore(java.time.Year), " +
                "randomYearBefore(int), randomFixedUtcClock(), randomFixedClock(), randomZoneId(), randomDayOfWeek(), " +
                "randomMonth(), randomZoneOffset(), randomPeriod(), randomPositivePeriod(), randomNegativePeriod(), " +
                "randomDuration(), randomPositiveDuration(), randomNegativeDuration()]";

        List<String> actual = Week10.getAllFunctions(fileContent);
        System.out.print(actual);

        assertEquals(expected, outputStream.toString());
    }
}
