package pages.orangehrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LeavePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(LeavePage.class.getName());
    public LeavePage(WebDriver driver){
        PageFactory.initElements(driver,this);}

    //objects or locators
    @FindBy(xpath = "//span[text()='Leave']")
    WebElement menuLeave;
    @FindBy(xpath = "//a[text()='Leave List']")
    WebElement LeaveListHeader;
    @FindBy(xpath = "//h5[text()='Leave List']")
    WebElement LeaveListTitle;

    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--label-danger oxd-table-cell-action-space'])[2]")
    WebElement RejectButtonOnTheSecondRow ;
    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--label-success oxd-table-cell-action-space'])[2]")
    WebElement ApproveButtonOnTheSecondRow ;
    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--label-success'])")
    WebElement ApproveButtonInTheHeaderLeaveList ;
    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--label-danger'])")
    WebElement RejectButtonInTheHeaderLeaveList ;
    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--label-warn'])")
    WebElement CancelButtonInTheHeaderLeaveList ;
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
    WebElement recordsFound;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement toastMessage;
    @FindBy(xpath = "//p[text()='Success']")
    WebElement toastTitle;
    @FindBy(xpath = "//h6[text()='Leave']")
    WebElement headerOfLeavePage;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--card-title']")
    WebElement titleInTheRejectAndApproveLeaveDialogBox;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2']")
    WebElement textInTheRejectAndApproveLeaveDialogBox;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement yesConfirmationButton;
    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin'])")
    WebElement noCancelButton;
    @FindBy(xpath = "(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[3]")
    WebElement secondCheckboxInTheLeaveList;
    @FindBy(xpath = "(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[5]")
    WebElement forthCheckboxInTheLeaveList;
    @FindBy(xpath = "(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[1]")
    WebElement CheckboxInTheLeaveListHeader;
    @FindBy(xpath = "//a[normalize-space()='Assign Leave']")
    WebElement assignLeaveHeader;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameField;
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
    WebElement assignLeaveSlideTitle;
    @FindBy(xpath = "(//div[@role='option']/span)[1]")
    WebElement firstOptionFromEmployeeNameField;
    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    WebElement LeaveTypeDropdown;
    @FindBy(xpath = "//div[@role='option']")
    List<WebElement> LeaveTypeDropdownOptions;
    @FindBy(xpath = "(//input[@placeholder='yyyy-mm-dd'])[1]")
    WebElement fromDate;
    @FindBy(xpath = "(//input[@placeholder='yyyy-mm-dd'])[2]")
    WebElement toDate;
    @FindBy(xpath = "//button[normalize-space()='Assign']")
    WebElement assign;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--card-title']")
    WebElement confirmationCardTitle;
    @FindBy(xpath = "//button[normalize-space()='Ok']")
    WebElement okButton;

    //reusable steps
    public void approveLeaveTheFifthInTheLeaveList() throws InterruptedException {
        clickOn(menuLeave);
        Assert.assertEquals(getTextFromElement(headerOfLeavePage),"Leave");
        LOG.info("landed to the leave page success");
        clickOn(LeaveListHeader);
        Assert.assertEquals(getTextFromElement(LeaveListTitle),"Leave List");
        LOG.info("landed to the Leave List page success");
        Thread.sleep(3000);
        String RecordsFound=getTextFromElement(recordsFound);
        if (RecordsFound.equalsIgnoreCase("No Records Found")) {
            LOG.info("no records found to approve : ");
        }else {
            LOG.info("Before approving leave: " + getTextFromElement(recordsFound));
            clickOn(ApproveButtonOnTheSecondRow);
            Assert.assertEquals(getTextFromElement(toastMessage), "Successfully Updated");
            LOG.info("approved the leave request success");
            Thread.sleep(2000);
            LOG.info("After approving leave request: " + getTextFromElement(recordsFound));
        }
    }
    public void rejectLeaveTheSecondInTheLeaveList() throws InterruptedException {
        clickOn(menuLeave);
        Assert.assertEquals(getTextFromElement(headerOfLeavePage),"Leave");
        LOG.info("landed to the leave page success");
        clickOn(LeaveListHeader);
        Assert.assertEquals(getTextFromElement(LeaveListTitle),"Leave List");
        LOG.info("landed to the Leave List page success");
        Thread.sleep(3000);
        String RecordsFound=getTextFromElement(recordsFound);
        if (RecordsFound.equalsIgnoreCase("No Records Found")) {
            LOG.info("no records found to reject: ");
        }else {
            LOG.info("Before rejecting leave: " + getTextFromElement(recordsFound));
            clickOn(RejectButtonOnTheSecondRow);
            Assert.assertEquals(getTextFromElement(toastMessage), "Successfully Updated");
            LOG.info("rejected the leave request success");
            Thread.sleep(2000);
            LOG.info("After rejecting leave request: " + getTextFromElement(recordsFound));
        }
    }
    public void rejectMultipleLeaveRequestsUsingRejectButtonAboveLeaveList() throws InterruptedException {
        clickOn(menuLeave);
        Assert.assertEquals(getTextFromElement(headerOfLeavePage),"Leave");
        LOG.info("we are successfully landed to the leave page");
        clickOn(LeaveListHeader);
        Assert.assertEquals(getTextFromElement(LeaveListTitle),"Leave List");
        LOG.info("we are successfully landed to the Leave List page");
        Thread.sleep(3000);
        String RecordsFound=getTextFromElement(recordsFound);
        if (RecordsFound.equalsIgnoreCase("No Records Found")) {
            LOG.info("there were no records found to reject : ");
        }else {
            LOG.info("Before rejecting leave it was: " + getTextFromElement(recordsFound));
            clickOn(secondCheckboxInTheLeaveList);
            clickOn(forthCheckboxInTheLeaveList);
            clickOn(RejectButtonInTheHeaderLeaveList);
            Assert.assertEquals(getTextFromElement(textInTheRejectAndApproveLeaveDialogBox), "You are about to Reject 2 Leave Requests Are you sure you want to continue?");
            LOG.info("switched to confirm or cancel leave request dialogue box success");
            clickOn(yesConfirmationButton);
            Assert.assertEquals(getTextFromElement(toastMessage), "2 Leave Requests Rejected");
            LOG.info("we are successfully rejected the leave request");
            Thread.sleep(3000);
            LOG.info("After rejecting leave request: " + getTextFromElement(recordsFound));
        }
    }
    public void approveMultipleLeaveRequestsUsingRejectButtonAboveLeaveList() throws InterruptedException {
        clickOn(menuLeave);
        Assert.assertEquals(getTextFromElement(headerOfLeavePage),"Leave");
        LOG.info("landed to the leave page success");
        clickOn(LeaveListHeader);
        Assert.assertEquals(getTextFromElement(LeaveListTitle),"Leave List");
        LOG.info("landed to the Leave List page success");
        Thread.sleep(3000);
        String RecordsFound=getTextFromElement(recordsFound);
        if (RecordsFound.equalsIgnoreCase("No Records Found")) {
            LOG.info("no records found to approve : ");
        }else {
            LOG.info("Before rejecting leave it was there: " + getTextFromElement(recordsFound));
            clickOn(secondCheckboxInTheLeaveList);
            clickOn(forthCheckboxInTheLeaveList);
            clickOn(ApproveButtonInTheHeaderLeaveList);
            Assert.assertEquals(getTextFromElement(textInTheRejectAndApproveLeaveDialogBox), "You are about to Approve 2 Leave Requests Are you sure you want to continue?");
            LOG.info("we are successfully switched to confirm or cancel leave request dialogue box");
            clickOn(yesConfirmationButton);
            Assert.assertEquals(getTextFromElement(toastMessage), "2 Leave Requests Approved");
            LOG.info("we are successfully approved the leave request");
            LOG.info("After approving leave request there: " + getTextFromElement(recordsFound));
        }
    }
    public void cancelApproveMultipleLeaveRequests() throws InterruptedException {
        clickOn(menuLeave);
        Assert.assertEquals(getTextFromElement(headerOfLeavePage),"Leave");
        LOG.info("landed to the leave page success");
        clickOn(LeaveListHeader);
        Assert.assertEquals(getTextFromElement(LeaveListTitle),"Leave List");
        LOG.info("we are successfully landed to the Leave List page success");
        Thread.sleep(3000);
        String RecordsFound = getTextFromElement(recordsFound);
        if (RecordsFound.equalsIgnoreCase("No Records Found")) {
            LOG.info("no records found to approve : ");
        }else {
            LOG.info("Before rejecting leave: " + getTextFromElement(recordsFound));
            clickOn(secondCheckboxInTheLeaveList);
            clickOn(forthCheckboxInTheLeaveList);
            clickOn(ApproveButtonInTheHeaderLeaveList);
            Assert.assertEquals(getTextFromElement(textInTheRejectAndApproveLeaveDialogBox), "You are about to Approve 2 Leave Requests Are you sure you want to continue?");
            LOG.info("switched to confirm or cancel leave request dialogue box success");
            clickOn(noCancelButton);
            Assert.assertEquals(getTextFromElement(LeaveListTitle), "Leave List");
            LOG.info("landed back to the Leave List page success");
        }
    }
    public void CancelRejectMultipleLeaveRequests() throws InterruptedException {
        clickOn(menuLeave);
        Assert.assertEquals(getTextFromElement(headerOfLeavePage),"Leave");
        LOG.info("landed to the leave page success");
        clickOn(LeaveListHeader);
        Assert.assertEquals(getTextFromElement(LeaveListTitle),"Leave List");
        LOG.info("landed to the Leave List page success");
        Thread.sleep(3000);
        String RecordsFound=getTextFromElement(recordsFound);
        if (RecordsFound.equalsIgnoreCase("No Records Found")) {
            LOG.info("no records found to reject : ");
        }else {
            LOG.info("Before rejecting leave: " + getTextFromElement(recordsFound));
            clickOn(secondCheckboxInTheLeaveList);
            clickOn(forthCheckboxInTheLeaveList);
            clickOn(RejectButtonInTheHeaderLeaveList);
            Assert.assertEquals(getTextFromElement(textInTheRejectAndApproveLeaveDialogBox), "You are about to Reject 2 Leave Requests Are you sure you want to continue?");
            LOG.info("switched to confirm or cancel leave request dialogue box success");
            clickOn(noCancelButton);
            Assert.assertEquals(getTextFromElement(LeaveListTitle), "Leave List");
            LOG.info("landed back to the Leave List page success");
        }
    }
    public void ApproveAllLeaveRequests() throws InterruptedException {
        clickOn(menuLeave);
        Assert.assertEquals(getTextFromElement(headerOfLeavePage),"Leave");
        LOG.info("landed to the leave page success");
        clickOn(LeaveListHeader);
        Assert.assertEquals(getTextFromElement(LeaveListTitle),"Leave List");
        LOG.info("landed to the Leave List page success");
        Thread.sleep(3000);
        String RecordsFound=getTextFromElement(recordsFound);
        if (RecordsFound.equalsIgnoreCase("No Records Found")) {
            LOG.info("no records found to reject : ");
        }else {
            LOG.info("Before rejecting any leave request: " + RecordsFound);
            clickOn(CheckboxInTheLeaveListHeader);
            clickOn(ApproveButtonInTheHeaderLeaveList);
            Assert.assertEquals(getTextFromElement(titleInTheRejectAndApproveLeaveDialogBox), "Approve Leave");
            LOG.info("switched to confirm or cancel leave request dialogue box success");
            clickOn(yesConfirmationButton);
            Assert.assertEquals(getTextFromElement(toastTitle), "Success");
            LOG.info("approved all the leave request success");
            LOG.info("After approving all the leave requests: " + getTextFromElement(recordsFound));
        }
    }
    public void RejectAllLeaveRequests() throws InterruptedException {
        clickOn(menuLeave);
        Assert.assertEquals(getTextFromElement(headerOfLeavePage),"Leave");
        LOG.info("landed to the leave page success");
        clickOn(LeaveListHeader);
        Assert.assertEquals(getTextFromElement(LeaveListTitle),"Leave List");
        LOG.info("landed to the Leave List page success");
        String RecordsFound=getTextFromElement(recordsFound);
        if (RecordsFound.equalsIgnoreCase("No Records Found")) {
            LOG.info("no records found to reject: ");
        }else {
            LOG.info("Before rejecting any leave request: " + RecordsFound);
            clickOn(CheckboxInTheLeaveListHeader);
            clickOn(RejectButtonInTheHeaderLeaveList);
            Assert.assertEquals(getTextFromElement(titleInTheRejectAndApproveLeaveDialogBox), "Reject Leave");
            LOG.info("switched to confirm or cancel leave request dialogue box success");
            clickOn(yesConfirmationButton);
            Assert.assertEquals(getTextFromElement(toastMessage), "Success");
            LOG.info("approved all the leave request success");
            LOG.info("After rejecting all leave request there: " + getTextFromElement(recordsFound));
        }
    }
    public void searchLeaveRequest() throws InterruptedException {
        clickOn(menuLeave);
        Assert.assertEquals(getTextFromElement(headerOfLeavePage),"Leave");
        LOG.info("landed to the leave page success");
        clickOn(LeaveListHeader);
        Assert.assertEquals(getTextFromElement(LeaveListTitle),"Leave List");
        LOG.info("landed to the Leave List page success");
        LOG.info("Before searching it was there: "+getTextFromElement(recordsFound));
        clickOn(secondCheckboxInTheLeaveList);
        clickOn(forthCheckboxInTheLeaveList);
        clickOn(ApproveButtonInTheHeaderLeaveList);
        Assert.assertEquals(getTextFromElement(textInTheRejectAndApproveLeaveDialogBox),"You are about to Approve 2 Leave Requests Are you sure you want to continue?");
        LOG.info("switched to confirm or cancel leave request dialogue box success");
        clickOn(yesConfirmationButton);
        Assert.assertEquals(getTextFromElement(toastMessage),"2 Leave Requests Approved");
        LOG.info("approved the leave request success");
        LOG.info("After approving leave request there: "+getTextFromElement(recordsFound));
    }
    public void checkTheVisibilityOfApproveButton() throws InterruptedException {
        clickOn(menuLeave);
        Assert.assertEquals(getTextFromElement(headerOfLeavePage),"Leave");
        LOG.info("landed to the leave page success");
        clickOn(LeaveListHeader);
        Assert.assertEquals(getTextFromElement(LeaveListTitle),"Leave List");
        LOG.info("landed to the Leave List page success");
        String RecordsFound=getTextFromElement(recordsFound);
        if (RecordsFound.equalsIgnoreCase("No Records Found")) {
            LOG.info("records found to select : ");
        }else {
            try {
                checkElementIsDisplayed(ApproveButtonInTheHeaderLeaveList);
                LOG.info("the Approve button was visible before selecting any of the leave requests form leave list");
            } catch (NoSuchElementException e) {
                LOG.info("the Approve button button is not visible before selecting any of the leave requests form leave list");
            }
            clickOn(secondCheckboxInTheLeaveList);
            if (checkElementIsDisplayed(ApproveButtonInTheHeaderLeaveList)) {
                LOG.info("the approve button is visible after selecting leave request from the leave list");
            } else {
                LOG.info("the approve button is not visible even after selecting a leave request from the leave list");
            }
        }
    }
    public void checkTheVisibilityOfRejectButton() throws InterruptedException {
        clickOn(menuLeave);
        clickOn(LeaveListHeader);
        Assert.assertEquals(getTextFromElement(LeaveListTitle),"Leave List");
        LOG.info("landed to the Leave List page success");
        String RecordsFound=getTextFromElement(recordsFound);
        if (RecordsFound.equalsIgnoreCase("No Records Found")) {
            LOG.info("records found to select : ");
        }else {
            try {
                checkElementIsDisplayed(ApproveButtonInTheHeaderLeaveList);
                LOG.info("the Reject button was visible even before selecting any of the leave requests form leave list");
            } catch (NoSuchElementException e) {
                LOG.info("the Reject button button is not visible before selecting any of the leave requests form leave list");
            }
            clickOn(secondCheckboxInTheLeaveList);
            if (checkElementIsDisplayed(ApproveButtonInTheHeaderLeaveList)) {
                LOG.info("the Reject button is visible after selecting leave request from the leave list");
            } else {
                LOG.info("the Reject button is not visible even after selecting a leave request from the leave list");
            }
        }
    }
    public void checkTheVisibilityOfCancelButton() throws InterruptedException {
        clickOn(menuLeave);
        clickOn(LeaveListHeader);
        Assert.assertEquals(getTextFromElement(LeaveListTitle),"Leave List");
        LOG.info("we are successfully landed to the Leave List page");
        String RecordsFound=getTextFromElement(recordsFound);
        if (RecordsFound.equalsIgnoreCase("No Records Found")) {
            LOG.info("no records found to select : ");
        }else {
            try {
                checkElementIsDisplayed(ApproveButtonInTheHeaderLeaveList);
                LOG.info("the Cancel button was visible even before selecting any of the leave requests form leave list");
            } catch (NoSuchElementException e) {
                LOG.info("the Cancel button button is not visible before selecting any of the leave requests form leave list");
            }
            clickOn(secondCheckboxInTheLeaveList);
            if (checkElementIsDisplayed(ApproveButtonInTheHeaderLeaveList)) {
                LOG.info("the Cancel button is visible after selecting leave request from the leave list");
            } else {
                LOG.info("the Cancel button is not visible even after selecting a leave request from the leave list");
            }
        }
    }


    public void assignLeaveRequest(String employeeName,String optionFromDropDown,String FromDate,String ToDate) throws Exception {
        clickOn(menuLeave);
        clickOn(assignLeaveHeader);
        Assert.assertEquals(getTextFromElement(assignLeaveSlideTitle), "Assign Leave");
        LOG.info("we are successfully landed to the Assign Leave page");
        type(toDate,ToDate);
        type(fromDate,FromDate);
        Thread.sleep(3000);
        type(employeeNameField,employeeName);
        arrowDown(employeeNameField);
        clickOn(firstOptionFromEmployeeNameField);
        clickOn(LeaveTypeDropdown);
        clickOnAnElementThatContainSpecificTextInList(LeaveTypeDropdownOptions,optionFromDropDown);
        clickOn(assign);
        Thread.sleep(3000);
        Assert.assertEquals(getTextFromElement(confirmationCardTitle), "Confirm Leave Assignment");
        LOG.info("landed to the Confirmation Leave Assignment card success");
        clickOn(okButton);
        try {
            Assert.assertEquals(getTextFromElement(toastMessage), "Successfully Saved");
            LOG.info("landed to the Confirmation Leave Assignment card");
        }catch (AssertionError e) {
            Assert.assertEquals(getTextFromElement(toastMessage), "Failed to Submit");
            LOG.info("The Leave already Assigned");

        }


    }
}
