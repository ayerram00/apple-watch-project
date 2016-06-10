package com.sqa.ay;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

public class AppleWatchProject {
	private boolean acceptNextAlert = true;
	private String baseUrl = "http://www.apple.com/";;
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	// @BeforeClass(alwaysRun = true)
	// public void setUp() throws Exception {
	// this.driver = new FirefoxDriver();
	// this.baseUrl = "http://www.apple.com/";
	// this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	// }

	// @AfterClass(alwaysRun = true)
	// public void tearDown() throws Exception {
	// this.driver.quit();
	// String verificationErrorString = this.verificationErrors.toString();
	// if (!"".equals(verificationErrorString)) {
	// fail(verificationErrorString);
	// }
	// }

	@Test
	public void testAppleWatchProject() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		this.driver = new ChromeDriver();

		// this.driver = new FirefoxDriver();
		this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.linkText("Watch")).click();
		this.driver.findElement(By.linkText("Buy Apple Watch")).click();
		this.driver.findElement(By.xpath("//section/div/div/div/div/div[2]/a/span")).click();
		this.driver.findElement(By.xpath("(//button[@name='proceed'])[20]")).click();
		this.driver.findElement(By.name("proceed")).click();
		this.driver.findElement(By.name("add-to-cart")).click();
		this.driver.findElement(By.xpath("//p/button")).click();
	}

	@SuppressWarnings("unused")
	private String closeAlertAndGetItsText() {
		try {
			Alert alert = this.driver.switchTo().alert();
			String alertText = alert.getText();
			if (this.acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			this.acceptNextAlert = true;
		}
	}

	@SuppressWarnings("unused")
	private boolean isAlertPresent() {
		try {
			this.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@SuppressWarnings("unused")
	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
