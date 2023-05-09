package pages.magentopages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElisaEverCoolTeePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(ElisaEverCoolTeePage.class.getName());

    public ElisaEverCoolTeePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='tab-label-reviews-title']")
    WebElement ReviewsButton;
    @FindBy(xpath= "//label[@class='rating-5']")
    WebElement RatingButton;

    @FindBy(xpath = "//input[@id='summary_field']")
    WebElement summayField ;

    @FindBy(css = "#review_field")
    WebElement reviewField ;
    @FindBy(xpath = "//span[text()='Submit Review']")
    WebElement SubmitReviewButton ;

    @FindBy(xpath = "(//div[@class='block-content'])[2]")
    WebElement blockContent;

    public void clickOnReviews(){
        clickOn(ReviewsButton);
        LOG.info("click on Review button success");
    }

    public void clickOnSubmitReview(){
        clickOn(SubmitReviewButton);
        LOG.info("click on Submit Review button success");
    }

    public void typeSummary(String Summary) {
        type(summayField, Summary);
        LOG.info("type Summary success");
    }
    public void typeReview(String review) {
        type(reviewField, review);
        LOG.info("type review success");
    }
    public void hoverOverRatingButton(WebDriver driver){
        waitForElementToBeVisible(driver, 10,RatingButton );
        hoverOver(driver,RatingButton);
        LOG.info("hover over rating button success");
    }

}
