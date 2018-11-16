package utilities;

public class Constants {
    public String DRIVERS_DIRECTORY = System.getProperty("user.dir");
    public String PATH_TO_DRIVERS = "\\src\\main\\resources\\drivers\\";
    public String CHROME_DRIVER_DIRECTORY = DRIVERS_DIRECTORY + PATH_TO_DRIVERS + "chromedriver.exe";
    public String IE_DRIVER_DIRECTORY = DRIVERS_DIRECTORY + PATH_TO_DRIVERS + "IEDriverServer.exe";
    public String FIREFOX_DRIVER_DIRECTORY = DRIVERS_DIRECTORY + PATH_TO_DRIVERS + "geckodriver.exe";

    public String SYSTEM_UNDERTEST = "http://35.205.178.227:3000";
    public String BROWSER = "chrome";
}
