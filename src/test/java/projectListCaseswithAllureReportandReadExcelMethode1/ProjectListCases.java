package projectListCaseswithAllureReportandReadExcelMethode1;
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



import login.LoginPage;
import projectBase.Base;
import utils.ExcelOp;
import utils.ReadExcel;
import projectList.ProjectListPage;
import commonMethodes.Common;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
public class ProjectListCases extends Base{
	WebDriver driver;
	LoginPage LoginPage;
	Common Common;
	ProjectListPage ProjectListPage;

	@BeforeClass
	@Parameters({ "email", "Password" })
	public void setup() throws Exception {
		driver = Base.getDriver();
		LoginPage = new LoginPage(driver);
		ProjectListPage = new ProjectListPage(driver);
		Common = new Common(driver);
		sheetname = this.getClass().getSimpleName();//Assigns the class name to the Sheet name
		LoginPage.login(ExcelOp.getValue("email"),ExcelOp.getValue("password"));
		Common.Wait(LoginPage.titleBy());
		System.out.println(ExcelOp.getValue("Project_Name"));

	}

	@AfterClass
	public void closeBrowser() {
		//LoginPage.clickLogoutBtn();  
		//wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.LogoutElementBy()));
		//driver.quit();
	}


	@Test(description="verify ProjectList Page") // it should be the Test Name 

	@Description("Verify ProjectList page from allure-----") // It should be the description about the Test ,what is going to happen in this test

	@Epic("TC01")// Epic will be divided into smaller user stories at the appropriate time,Like the TC numbers


	@Feature("Feature2")//It should describes the feature of the test.Like Login,Registration etc.. 

	@Story("ProjectList check lists")//It can be used as a sub feature or sub steps 

	@Step("Verify ProjectList page is  Working") // It should describes what is happening inside the test body

	@Severity(SeverityLevel.NORMAL) //It assigns the severity of the test(eg: low/medium/high)
	public void ValidProjectListCases() throws Exception {
		ProjectListPage.clickprojectListBtn();
		Common.Wait(ProjectListPage.projectNameBy());

		String ProjectName =ProjectListPage.getprojectName();

		Assert.assertEquals(ProjectName.trim(), ExcelOp.getValue("Project_Name"),
				"Tesext does not match");
		
		
	}





}
