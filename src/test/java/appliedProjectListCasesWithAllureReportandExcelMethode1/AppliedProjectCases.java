package appliedProjectListCasesWithAllureReportandExcelMethode1;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.google.common.collect.ImmutableMap;

import login.LoginPage;
import projectBase.Base;
import appliedProjectList.AppliedProjectPage;
import utils.ExcelOp;
import utils.ReadExcel;
import commonMethodes.Common;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
public class AppliedProjectCases extends Base {

	WebDriver driver;
	//LoginPage LoginPage;
	Common Common;
	AppliedProjectPage AppliedProjectPage;

	/*
	 * void setAllureEnvironment() { allureEnvironmentWriter(ImmutableMap.<String,
	 * String>builder() .put("Browser", "Chrome") .put("Browser.Version",
	 * "70.0.3538.77") .put("URL", "http://testjs.site88.net") .build()); }
	 */
	/*
	 * private void allureEnvironmentWriter(ImmutableMap<String, String> build) { //
	 * TODO Auto-generated method stub
	 * 
	 * }
	 */

	@BeforeClass
	@Parameters({ "email", "Password" })
	public void setup() throws Exception {
		System.out.println("Second Test");
		driver = Base.getDriver();
		//LoginPage = new LoginPage(driver);
		Common = new Common(driver);
		AppliedProjectPage = new AppliedProjectPage(driver);
		sheetname = this.getClass().getSimpleName(); //this.getClass().getSimpleName();//Assigns the class name to the Sheet name
		//LoginPage.login(ExcelOp.getValue("email"),ExcelOp.getValue("password"));
		//Common.Wait(LoginPage.titleBy()); 
		

	}

	@AfterClass
	public void closeBrowser() {
		//LoginPage.clickLogoutBtn(); 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.LogoutElementBy()));
		//driver.quit();
	}

	
	
	
	
	
	
	
	
	@Test(description="verify AppliedProjectList Page") // it should be the Test Name 

	@Description("Verify AppliedProjectList page from allure-----") // It should be the description about the Test ,what is going to happen in this test

	@Epic("TC01")// Epic will be divided into smaller user stories at the appropriate time,Like the TC numbers


	@Feature("Feature2")//It should describes the feature of the test.Like Login,Registration etc.. 

	@Story("AppliedProjectList check lists")//It can be used as a sub feature or sub steps 

	@Step("Verify AppliedProjectList page is  Working") // It should describes what is happening inside the test body

	@Severity(SeverityLevel.NORMAL) //It assigns the severity of the test(eg: low/medium/high)
	
	public void AppliedProjectListCases() throws Exception {
		
		
		AppliedProjectPage.clickAppliedprojectListBtn();
		//Common.Wait(AppliedProjectPage.AppProjectNameBy());

//		String AppliedProjectName =AppliedProjectPage.getAppProjectName();



		AppliedProjectPage.clickDuringTradBtn();
		//Common.Wait(AppliedProjectPage.DuringTradeProjectNameBy());

//		String DuringProjectName =AppliedProjectPage.getDuringTradeProjectName();



		AppliedProjectPage.clickEndTransactBtn();
		//Common.Wait(AppliedProjectPage.EndProjectNameBy());

//		String EOTProjectName =AppliedProjectPage.getEndProjectName();



		AppliedProjectPage.clickCancellTransact();
		//Common.Wait(AppliedProjectPage.CancellTransactNameBy());

//		String cancelledProjectName =AppliedProjectPage.getCancellTransactName();




		AppliedProjectPage.clickFailedTransacbtn();
		//Common.Wait(AppliedProjectPage.FailedTransNameBy());
/*
		String FailedProjectName =AppliedProjectPage.getFailedTransName();
		Assert.assertEquals(AppliedProjectName.trim(), ExcelOp.getValue("Applied Project Name"),
				"Tesext does not match in Applying Project");

		Assert.assertEquals(DuringProjectName.trim(), ExcelOp.getValue("During Trading Project Name"),
				"Tesext does not match in During Project");

		Assert.assertEquals(EOTProjectName.trim(), ExcelOp.getValue("EOT Project Name"),
				"Tesext does not match in EOT Project");

		Assert.assertEquals(cancelledProjectName.trim(), ExcelOp.getValue("Cancelled Project Name"),
				"Tesext does not match in cancelled Project");

		Assert.assertEquals(FailedProjectName.trim(), ExcelOp.getValue("FAiled Project Name"),
				"Tesext does not match in Failed Project");
	*/
	}


	



}