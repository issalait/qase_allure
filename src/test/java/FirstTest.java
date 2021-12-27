import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pages.IssuePage;
import pages.LoginPage;
import pages.ProjectPageBoard;
import pages.ProjectsPage;
import util.CardData;
import util.UserData;


import static com.codeborne.selenide.Selenide.*;

public class FirstTest {
    public String issueName;
    public CardData issue;
    public UserData user;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

        Configuration.browserCapabilities.setAcceptInsecureCerts(true);
        Configuration.browser="chrome";

        issue = new CardData("test9", "test description8", "1");
        issueName = issue.getCardName();
        user = new UserData("issalait@gmail.com","hQ43d13hQ43d13", "https://app.qase.io/login");
    }

    /*
    @Test
    public void openDemoProject(){
        open("https://app.qase.io/login");
        LoginPage loginPage = open("https://app.qase.io/login", LoginPage.class);
        loginPage.enterLogin("issalait@gmail.com");
        loginPage.enterPassword("hQ43d13");
        ProjectsPage projectsPage = loginPage.clickLoginBtn();
        projectsPage.checkUserAuthorized();
        ProjectPageBoard projectPageBoard = projectsPage.openDemoProject();
        projectPageBoard.checkDemoTitle();
    }
*/

    @Test
    public void createIssue(){
        LoginPage loginPage = open(user.getAuthPage(), LoginPage.class);
        loginPage.enterLogin(user.getUserName());
        loginPage.enterPassword(user.getUserPassword());
        ProjectsPage projectsPage = loginPage.clickLoginBtn();
        projectsPage.checkUserAuthorized();
        ProjectPageBoard projectPageBoard = projectsPage.openDemoProject();
        IssuePage issuePage = projectPageBoard.openDefects();
        issuePage.checkDefectsTitle();
        issuePage.createIssue(issue.getCardName(),issue.getCardDescription());
    }

    @Test
    public void deleteIssue(){
        LoginPage loginPage = open(user.getAuthPage(), LoginPage.class);
        loginPage.enterLogin(user.getUserName());
        loginPage.enterPassword(user.getUserPassword());
        ProjectsPage projectsPage = loginPage.clickLoginBtn();
        projectsPage.checkUserAuthorized();
        ProjectPageBoard projectPageBoard = projectsPage.openDemoProject();
        IssuePage issuePage = projectPageBoard.openDefects();
        issuePage.deleteIssue(issueName);
    }


/*
    @Test
    public void testOne() throws Exception {

        open("https://app.qase.io/login");


        $(By.id("inputEmail")).click();
        $(By.id("inputEmail")).clear();
        $(By.id("inputEmail")).sendKeys("issalaitqa@gmail.com");

        $(By.id("inputPassword")).click();
        $(By.id("inputPassword")).clear();
        $(By.id("inputPassword")).sendKeys("FC8-2fU-jQU-VPz");

        $(By.id("btnLogin")).click();

        $(By.xpath("//a[@href='/project/DEMO']")).click();
    }
 */
    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        close();
    }
}
