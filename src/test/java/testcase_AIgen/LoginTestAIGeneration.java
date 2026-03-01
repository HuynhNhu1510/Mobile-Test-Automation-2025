package testcase_AIgen;

import common.CommonTest;
import dataprovider.TestDataProviders;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.LoginTestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

@Epic("Authentication")
@Feature("Login Functionality - AI Generated Test Cases")
public class LoginTestAIGeneration extends CommonTest {
    private static final Logger logger = LogManager.getLogger(LoginTestAIGeneration.class);

    LoginPage loginPage;

    @Override
    protected String getTestName() {
        return "Login Test AI Generated Test Cases";
    }

    @Test(dataProvider = "loginAI_EmptyFields",
            dataProviderClass = TestDataProviders.class,
            description = "Login with empty fields - AI Test Cases")
    @Story("AI - Empty Fields Validation")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginAI_EmptyFields(LoginTestData testData) {
        logger.info("\n[{}] {}", testData.getTestId(), testData.getCategory());
        logger.debug("Description: {}", testData.getDescription());

        loginPage = new HomePage().clickSignInButton();
        loginPage.loginExpectFailure(testData.getEmail(), testData.getPassword());

        switch (testData.getExpectedResult()) {
            case "email_empty":
                Assert.assertTrue(loginPage.isEmailEmptyFieldDisplayed(),
                        "Email empty error should be displayed for: " + testData.getTestId());
                String emailMsg = loginPage.getEmailEmptyMessage();
                Assert.assertEquals(emailMsg, testData.getExpectedMessage(),
                        "Error message should match for: " + testData.getTestId());
                break;

            case "password_empty":
                Assert.assertTrue(loginPage.isPasswordEmptyFieldDisplayed(),
                        "Password empty error should be displayed for: " + testData.getTestId());
                String passMsg = loginPage.getPasswordEmptyMessage();
                Assert.assertEquals(passMsg, testData.getExpectedMessage(),
                        "Error message should match for: " + testData.getTestId());
                break;

            default:
                Assert.fail("Unknown expectedResult: " + testData.getExpectedResult());
        }

        logger.info("[{}] PASSED", testData.getTestId());
    }

    @Test(dataProvider = "loginAI_InvalidEmail",
            dataProviderClass = TestDataProviders.class,
            description = "Login with invalid email formats - AI Test Cases")
    @Story("AI - Invalid Email Validation")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginAI_InvalidEmail(LoginTestData testData) {
        logger.info("\n[{}] {}", testData.getTestId(), testData.getCategory());
        logger.debug("Description: {}", testData.getDescription());

        loginPage = new HomePage().clickSignInButton();
        loginPage.loginExpectFailure(testData.getEmail(), testData.getPassword());

        Assert.assertTrue(loginPage.isEmailInvalidMessageDisplayed(),
                "Email invalid message should be displayed for: " + testData.getTestId());

        String actualMsg = loginPage.getEmailInvalidMessage();
        Assert.assertEquals(actualMsg, testData.getExpectedMessage(),
                "Error message should match for: " + testData.getTestId());

        logger.info("[{}] PASSED", testData.getTestId());
    }

    @Test(dataProvider = "loginAI_InvalidPassword",
            dataProviderClass = TestDataProviders.class,
            description = "Login with invalid password formats - AI Test Cases")
    @Story("AI - Invalid Password Validation")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginAI_InvalidPassword(LoginTestData testData) {
        logger.info("\n[{}] {}", testData.getTestId(), testData.getCategory());
        logger.debug("Description: {}", testData.getDescription());

        loginPage = new HomePage().clickSignInButton();
        loginPage.loginExpectFailure(testData.getEmail(), testData.getPassword());

        Assert.assertTrue(loginPage.isEmailNotExistedErrorDisplayed(),
                "Credential error should be displayed for: " + testData.getTestId());

        String actualMsg = loginPage.getEmailNotExistedErrorMessage();
        Assert.assertEquals(actualMsg, testData.getExpectedMessage(),
                "Error message should match for: " + testData.getTestId());

        logger.info("[{}] PASSED", testData.getTestId());
    }

    @Test(dataProvider = "loginAI_ValidLogin",
            dataProviderClass = TestDataProviders.class,
            description = "Login with valid credentials - AI Test Cases")
    @Story("AI - Valid Login")
    @Severity(SeverityLevel.BLOCKER)
    public void testLoginAI_ValidLogin(LoginTestData testData) {
        logger.info("\n[{}] {}", testData.getTestId(), testData.getCategory());
        logger.debug("Description: {}", testData.getDescription());

        loginPage = new HomePage().clickSignInButton();
        homePage = loginPage.loginExpectSuccess(testData.getEmail(), testData.getPassword());

        Assert.assertTrue(homePage.isLoggedIn(),
                "Should login successfully for: " + testData.getTestId());

        logger.info("[{}] PASSED", testData.getTestId());
    }

    @Test(dataProvider = "loginAI_WrongCredentials",
            dataProviderClass = TestDataProviders.class,
            description = "Login with wrong credentials - AI Test Cases")
    @Story("AI - Wrong Credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginAI_WrongCredentials(LoginTestData testData) {
        logger.info("\n[{}] {}", testData.getTestId(), testData.getCategory());
        logger.debug("Description: {}", testData.getDescription());

        loginPage = new HomePage().clickSignInButton();
        loginPage.loginExpectFailure(testData.getEmail(), testData.getPassword());

        Assert.assertTrue(loginPage.isEmailNotExistedErrorDisplayed(),
                "Credential error should be displayed for: " + testData.getTestId());

        String actualMsg = loginPage.getEmailNotExistedErrorMessage();
        Assert.assertEquals(actualMsg, testData.getExpectedMessage(),
                "Error message should match for: " + testData.getTestId());

        logger.info("[{}] PASSED", testData.getTestId());
    }
}
