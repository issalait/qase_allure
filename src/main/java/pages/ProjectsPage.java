package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage {
    @FindBy(id = "user-menu")
    public SelenideElement profileLink;

    @FindBy(xpath = "//a[@href='/project/DEMO']")
    public SelenideElement demoProjectLink;

    @Step
    public void checkUserAuthorized() {
        profileLink.shouldBe(Condition.visible);
    }

    @Step
    public ProjectPageBoard openDemoProject() {
        demoProjectLink.click();
        return Selenide.page(ProjectPageBoard.class);
    }
}
