package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.jsoup.select.Evaluator;
import org.openqa.selenium.support.FindBy;

public class ProjectPageBoard {

    @FindBy(id = "menu-link-test-defects")
    public SelenideElement defectsLink;

    //project-avatar-container
    @FindBy(xpath = "//p[@class='header']")
    public SelenideElement projectTitle;

    @Step
    public void checkDemoTitle() {
        projectTitle.shouldHave(Condition.text("Demo Project"));
    }

    @Step
    public IssuePage openDefects() {
        defectsLink.click();
        return Selenide.page(IssuePage.class);
    }
}
