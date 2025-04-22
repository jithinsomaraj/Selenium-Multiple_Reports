package loginCasesWithAllureReportandExcelReadMethode1;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.google.common.collect.ImmutableMap;

import allureReports.AllureListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;
import projectBase.Base;
import utils.ExcelOp;
import allureReports.AllureListener;
//import questionBankCreateEdit.QuestionBankCreatePage;
//import questionBankList.QuestionBankListPage;
//import studentDashboard.StudentDashboardPage;
import utils.ReadExcel;
import login.LoginPage;
import commonMethodes.Common;
@Listeners ({allureReports.AllureListener.class})//initiate the allure Listener.It wont necessary if you add the Listener in the Xml file
public class LoginCases extends Base{
//	WebDriver driver;
	LoginPage LoginPage;
	Common Common;

	@BeforeClass
	public void setup() {
		driver = Base.getDriver();
		LoginPage = new LoginPage(driver);
		Common = new Common(driver);
		sheetname = this.getClass().getSimpleName();//Assigns the class name to the Sheet name

	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		/*
		 * LoginPage.clickLogoutBtn();
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.
		 * LogoutElementBy()));
		 */


	}

	//Login with valid email and password..

	@Test(description="verify Login Test") // it should be the Test Name 

	@Description("Verify home page from allure-----") // It should be the description about the Test ,what is going to happen in this test

	@Epic("TC01")// Epic will be divided into smaller user stories at the appropriate time,Like the TC numbers


	@Feature("Feature1")//It should describes the feature of the test.Like Login,Registration etc.. 

	@Story("Login check lists")//It can be used as a sub feature or sub steps 

	@Step("Verify Login Test Working") // It should describes what is happening inside the test body

	@Severity(SeverityLevel.MINOR) //It assigns the severity of the test(eg: low/medium/high)
	public void ValidLoginCases() throws Exception
	{ Base.loadcompanyUrl(driver);
	LoginPage.login(ExcelOp.getValue("email"),ExcelOp.getValue("password"));
	Common.Wait(LoginPage.titleBy()); 
	String TitleText =LoginPage.GettitleText();
	LoginPage.clickLogoutBtn();
			Common.Wait((LoginPage.LogoutElementBy()));
			Assert.assertEquals(TitleText.trim(), ExcelOp.getValue("Title"),"Welcome text does not match");//It reads the Value of "Title" column from the excel sheets named logincases3 which is the class name
			}



	//login with invalid email and invalid password

	@Test(description="verify Login Error case Test")

	@Description("Verify home page from allure-----")

	@Epic("TC02")

	@Feature("Feature1")

	@Story("Login check lists")

	@Step("Verify Login error cases is  Working")

	@Severity(SeverityLevel.MINOR) public void LoginErrorCases1() throws
	Exception { Base.loadcompanyUrl(driver); driver.navigate().refresh();
	LoginPage.login(ExcelOp.getValue("InvalidEmail"),
			ExcelOp.getValue("InvalidPassword"));
	Common.Wait(LoginPage.LoginValidationMsgBy()); }


	//login with valid email and invalid password

	@Test(description="verify Login Error case 2 Test")

	@Description("Verify home page from allure-----")

	@Epic("TC03")

	@Feature("Feature1")

	@Story("Login check lists")

	@Step("Verify Login Error case  Test Working")

	@Severity(SeverityLevel.MINOR) public void LoginErrorCases2() throws
	Exception { Base.loadcompanyUrl(driver); driver.navigate().refresh();
	LoginPage.login(ExcelOp.getValue("email"),
			ExcelOp.getValue("InvalidPassword"));
	Common.Wait(LoginPage.LoginValidationMsgBy()); }



	//login with invalid email and valid Password
	@Test(description="verify Login Error case 3 Test")
	@Description("Verify home page from allure-----")
	@Epic("TC04")
	@Feature("Feature1")
	@Story("Login check lists")
	@Step("Verify Login Error case 3  Test Working")
	@Severity(SeverityLevel.MINOR)
	public void LoginErrorCases3() throws Exception {
		Base.loadcompanyUrl(driver);
        LoginPage.login(ExcelOp.getValue("InvalidEmail"),ExcelOp.getValue("password"));
		Common.Wait(LoginPage.LoginValidationMsgBy());
        Assert.assertEquals(LoginPage.GetErrorMsg(),
		ExcelOp.getValue("ErrorMessage"), "Erro message  does not match"); }





}