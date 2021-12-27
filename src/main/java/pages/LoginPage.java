package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    @FindBy(id = "inputEmail")
    public SelenideElement login;
    @FindBy(id = "inputPassword")
    public SelenideElement password;
    @FindBy(id = "btnLogin")
    public SelenideElement loginBtn;

    @Step
    public void enterLogin(String userLogin) {
        login.click();
        login.clear();
        login.sendKeys(userLogin);
    }

    @Step
    public void enterPassword(String userPassword) {
        password.click();
        password.clear();
        password.sendKeys(userPassword);
    }

    @Step
    public ProjectsPage clickLoginBtn() {
        loginBtn.click();
        return Selenide.page(ProjectsPage.class);

    }
}
