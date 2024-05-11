package exerciciolgcselenium1;

import java.time.Duration;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {
	@Test
	public void abrirPaginaChrome() {
		// define caminho do webdriver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		// inicia o webdrver
		WebDriver driver = new ChromeDriver();
		try {
			
			driver.get("https://www.letsgetchecked.ie/account/login");

			By elementAcceptAllCookiesId = By.id("onetrust-accept-btn-handler");
			WebElement elementAcceptAllCookies = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(elementAcceptAllCookiesId));
			elementAcceptAllCookies.click();
			
			By elementUserNameId = By.id("userName");
			WebElement elementUserName = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(elementUserNameId));
			elementUserName.sendKeys("brunonf15@gmail.com");
			
			By elementPasswordId = By.id("password");
			WebElement elementPassword = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(elementPasswordId));
			elementPassword.sendKeys("Qwop120-1234567");
			
			By elementSingInXpath = By.xpath("//button[normalize-space()='Sign in']");
			WebElement elementSingIn = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(elementSingInXpath));
			elementSingIn.click();
			
			By elementFullUserNameXpath = By.xpath("//span[normalize-space()='BRUNO NASCIMENTO DE FIGUEIREDO']");
			WebElement elementFullUserName = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(elementFullUserNameXpath));
			String fullName = elementFullUserName.getText();
			
			Assert.assertTrue(fullName.equals("BRUNO NASCIMENTO DE FIGUEIREDO"));
			
			
		} finally {
			driver.quit();
		}
		

		
		
	
		
	}

}
