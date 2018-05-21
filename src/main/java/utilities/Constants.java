package utilities;

public class Constants {
    public static String DRIVERS_DIRECTORY = System.getProperty("user.dir");
    public static String PATH_TO_DRIVERS = "\\src\\main\\resources\\drivers\\";
    public static String CHROME_DRIVER_DIRECTORY = DRIVERS_DIRECTORY + PATH_TO_DRIVERS + "chromedriver.exe";
    public static String IE_DRIVER_DIRECTORY = DRIVERS_DIRECTORY + PATH_TO_DRIVERS + "IEDriverServer.exe";
    public static String FIREFOX_DRIVER_DIRECTORY = DRIVERS_DIRECTORY + PATH_TO_DRIVERS + "geckodriver.exe";

    public static String SYSTEM_UNDERTEST = "http://35.205.178.227:3000";
    public static String BROWSER = "chrome";
}
