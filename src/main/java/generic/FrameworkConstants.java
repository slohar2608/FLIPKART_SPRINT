package generic;

public interface FrameworkConstants {
	public String CHROME_KEY="webdriver.chrome.driver";
	public String CHROME_VALUE="./src/main/resources/Drivers/chromedriver.exe";
	
	public String FIREFOX_KEY="webdriver.gecko.driver";
	public String FIREFOX_VALUE="./src/main/resources/Drivers/chromedriver.exe";
	
	public String EXCEL_PATH="./src/test/resources/TestData/TestData.xlsx";
	public String SCREENSHOT_PATH="./Screenshots";
	public String REPORT_PATH="/Reports";
	public String PROPERTYFILE_PATH="./src/test/resources/propertyFile/data.properties";
	public String TEST_NAME="FlipkartTest";
	long TIMEOUTS_WAIT=20;
	
	

}
