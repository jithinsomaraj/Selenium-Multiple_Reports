package transactionDetailsCasesWithAllureReportandReadExcelMethode2;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commonMethodes.Common;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import login.LoginPage;
import projectBase.Base;
import transactionDetails.TransactionSearchPage;
import utils.ReadExcel;

public class TransactionSearchCases2 {
	WebDriver driver;
	LoginPage LoginPage;
	TransactionSearchPage TransactionSearchPage;
	Common Common;

	@BeforeClass
	@Parameters({ "email", "Password" })
	public void setup(String email, String password) {
		driver = Base.getDriver();
		//LoginPage = new LoginPage(driver);
		Common = new Common(driver);
		TransactionSearchPage = new TransactionSearchPage(driver);
		//Base.loadcompanyUrl(driver); LoginPage.login(email, password); 
		//Common.Wait(LoginPage.titleBy());



	}

	@AfterClass
	public void closeBrowser() {
		//LoginPage.clickLogoutBtn(); 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.LogoutElementBy()));
		//driver.quit();
	}

	@Test(description="verify TransactionList Page",dataProvider = "TransactionSeacrh-Verify") // it should be the Test Name 

	@Description("Verify TransactionList page from allure-----") // It should be the description about the Test ,what is going to happen in this test

	@Epic("TC01")// Epic will be divided into smaller user stories at the appropriate time,Like the TC numbers


	@Feature("Feature2")//It should describes the feature of the test.Like Login,Registration etc.. 

	@Story("Transaction check lists")//It can be used as a sub feature or sub steps 


	@Severity(SeverityLevel.NORMAL) //It assigns the severity of the test(eg: low/medium/high)
	public void ValidTransactionSearchCases(String TCID, String TCDescription,String SearchValue,String Compensation,String ExpProjName,String ExpPlaceofWork,String StartYear,String StartDay,String EndYear,String EndDay) throws InterruptedException {
		TransactionSearchPage.clickTransactionListBtn();
		Common.Wait(TransactionSearchPage.TransactionTitleBy());
		TransactionSearchPage.clickSearchbutton1();
		Common.Wait(TransactionSearchPage.SearchTitleBy());
	

		Common.Wait(TransactionSearchPage.SearchTitleBy());

		TransactionSearchPage.SelectDate(StartYear,StartDay,EndYear,EndDay);


		Common.Wait(TransactionSearchPage.ClickDateSubmitbtnBy());
		TransactionSearchPage.ClickDateSubmitbtn();




		TransactionSearchPage.Search(SearchValue,Compensation);
		Common.Wait(TransactionSearchPage.ResutTitleBy());

		String ProjectTitleText =TransactionSearchPage.GetProjectTitle(); String
		placeofworkText =TransactionSearchPage.GetPlaceofWork();


		Assert.assertEquals(ProjectTitleText.trim(), ExpProjName,
				"Search results  does not match woth project name");
		Assert.assertEquals(placeofworkText.trim(), ExpPlaceofWork,
				"Search results  does not match with place of work");






	}	


	@DataProvider(name = "TransactionSeacrh-Verify")
	public Object[][] Transaction_Search() {
		Object[][] TransactionValid= ReadExcel.ReadTestData(this.getClass().getSimpleName(), "ValidTransactionSearchCases", 10);
		return TransactionValid;
	}



}



