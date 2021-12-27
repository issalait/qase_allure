package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class IssuePage {

    @FindBy(xpath = "//a[.='Create new defect']")
    public SelenideElement createIssueBtn;

    @FindBy(xpath = "//h1[.='Defects']")
    public SelenideElement defectsTitle;

    @FindBy(id = "title")
    public SelenideElement issueTitle;

    @FindBy(xpath = "//div[@id='undefinedGroup']/div/div/div/div[2]/div/div[2]/div/div/p")
    public SelenideElement issueResult;

    @FindBy(xpath = "//div[@id='severityGroup']/div[1]/div/div[1]")
    public SelenideElement IssuePrioritySelector;

    @FindBy(id = "react-select-3-option-1")
    public SelenideElement IssuePriorityNormal;

    @FindBy(xpath = "//button[.='Create defect']")
    public SelenideElement saveIssueBtn;


    //@FindBy(xpath = "//td/div[.='"+issueName+"']/../following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/div/a")
   // public SelenideElement pointsIssueBtn;

    @FindBy(xpath = "//a[.='Delete']")
    public SelenideElement deleteIssueBtn;

    @FindBy(xpath = "//button[.='Delete']")
    public SelenideElement deleteIssueConfirmBtn;

    @Step
    public void checkDefectsTitle() {
        defectsTitle.shouldBe(Condition.visible);
    }

    @Step
    public void setIssuePriorityNormal() {
        IssuePrioritySelector.click();
        IssuePriorityNormal.click();
    }

    @Step
    public void createIssue(String cardTitle,String cardResult) {
        createIssueBtn.click();
        issueTitle.click();
        issueTitle.sendKeys(cardTitle);
        issueResult.click();
        issueResult.sendKeys(cardResult);
        setIssuePriorityNormal();
        saveIssueBtn.click();
    }

    @Step
    public void deleteIssue(String issueName){
        Selenide.$(By.xpath("//td//div[.='"+issueName+"']/../following::td/following::td/following::td/following::td/following::td/following::td/div/a")).click();
        //pointsIssueBtn.click();
        deleteIssueBtn.click();
        deleteIssueConfirmBtn.click();
    }
}