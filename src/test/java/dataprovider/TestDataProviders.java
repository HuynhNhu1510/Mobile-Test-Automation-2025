package dataprovider;

import org.example.helpers.JsonDataReader;
import org.example.model.ChangePasswordTestData;
import org.example.model.LoginTestData;
import org.example.model.RegisterTestData;
import org.testng.annotations.DataProvider;

import java.util.List;

public class TestDataProviders {
    @DataProvider(name = "loginValidCredentials_EP")
    public Object[][] loginValidCredentials() {
        List<LoginTestData> testData = JsonDataReader.getLoginTestData(
                "login_test_data.valid_credentials");
        return convertLoginDataToArray(testData);
    }

    @DataProvider(name = "loginInvalidEmailFormat_EP")
    public Object[][] loginInvalidEmailFormat() {
        List<LoginTestData> testData = JsonDataReader.getLoginTestData(
                "login_test_data.equivalence_partitioning.invalid_email_format");
        return convertLoginDataToArray(testData);
    }

    @DataProvider(name = "loginInvalidPasswordFormat_EP")
    public Object[][] loginInvalidPasswordFormat() {
        List<LoginTestData> testData = JsonDataReader.getLoginTestData(
                "login_test_data.equivalence_partitioning.invalid_password_format");
        return convertLoginDataToArray(testData);
    }

    @DataProvider(name = "loginEmptyFields_EP")
    public Object[][] loginEmptyFields() {
        List<LoginTestData> testData = JsonDataReader.getLoginTestData(
                "login_test_data.equivalence_partitioning.empty_fields");
        return convertLoginDataToArray(testData);
    }

    @DataProvider(name = "loginPasswordLength_BVA")
    public Object[][] loginPasswordLength() {
        List<LoginTestData> testData = JsonDataReader.getLoginTestData(
                "login_test_data.boundary_value_analysis.password_length");
        return convertLoginDataToArray(testData);
    }

    @DataProvider(name = "loginEmailLength_BVA")
    public Object[][] loginEmailLength() {
        List<LoginTestData> testData = JsonDataReader.getLoginTestData(
                "login_test_data.boundary_value_analysis.email_length");
        return convertLoginDataToArray(testData);
    }

    @DataProvider(name = "allLoginEquivalencePartitioning")
    public Object[][] allLoginEquivalencePartitioning() {
        List<LoginTestData> testData = JsonDataReader.getAllLoginEquivalencePartitioning();
        return convertLoginDataToArray(testData);
    }

    @DataProvider(name = "allLoginBoundaryValueAnalysis")
    public Object[][] allLoginBoundaryValueAnalysis() {
        List<LoginTestData> testData = JsonDataReader.getAllLoginBoundaryValueAnalysis();
        return convertLoginDataToArray(testData);
    }

    @DataProvider(name = "loginInvalidSpecialChars_EP")
    public Object[][] loginInvalidSpecialChars() {
        List<LoginTestData> testData = JsonDataReader.getLoginTestData(
                "login_test_data.equivalence_partitioning.invalid_special_characters");
        return convertLoginDataToArray(testData);
    }

    @DataProvider(name = "loginSpecialCases")
    public Object[][] loginSpecialCases() {
        List<LoginTestData> testData = JsonDataReader.getLoginTestData(
                "login_test_data.special_cases");
        return convertLoginDataToArray(testData);
    }

    @DataProvider(name = "loginCombinationTests")
    public Object[][] loginCombinationTests() {
        List<LoginTestData> testData = JsonDataReader.getLoginTestData(
                "login_test_data.combination_testing");
        return convertLoginDataToArray(testData);
    }

    @DataProvider(name = "loginSpecialCharCount_BVA")
    public Object[][] loginSpecialCharCount() {
        List<LoginTestData> testData = JsonDataReader.getLoginTestData(
                "login_test_data.boundary_value_analysis.special_character_count");
        return convertLoginDataToArray(testData);
    }

    // ==================== REGISTER DATA PROVIDERS ====================

    @DataProvider(name = "registerDecisionTable")
    public Object[][] registerDecisionTable() {
        List<RegisterTestData> testData = JsonDataReader.getRegisterTestData(
                "register_test_data.decision_table");
        return convertRegisterDataToArray(testData);
    }

    @DataProvider(name = "registerInvalidFullName_EP")
    public Object[][] registerInvalidFullName() {
        List<RegisterTestData> testData = JsonDataReader.getRegisterTestData(
                "register_test_data.equivalence_partitioning.invalid_fullname_patterns");
        return convertRegisterDataToArray(testData);
    }

    @DataProvider(name = "registerFullNameLength_BVA")
    public Object[][] registerFullNameLength() {
        List<RegisterTestData> testData = JsonDataReader.getRegisterTestData(
                "register_test_data.boundary_value_analysis.fullname_length");
        return convertRegisterDataToArray(testData);
    }

    @DataProvider(name = "registerFullNameValidation_EP")
    public Object[][] registerFullNameValidation() {
        List<RegisterTestData> testData = JsonDataReader.getRegisterTestData(
                "register_test_data.equivalence_partitioning.fullname_validation");
        return convertRegisterDataToArray(testData);
    }

    @DataProvider(name = "registerEmailValidation_EP")
    public Object[][] registerEmailValidation() {
        List<RegisterTestData> testData = JsonDataReader.getRegisterTestData(
                "register_test_data.equivalence_partitioning.email_validation");
        return convertRegisterDataToArray(testData);
    }

    @DataProvider(name = "registerPasswordValidation_EP")
    public Object[][] registerPasswordValidation() {
        List<RegisterTestData> testData = JsonDataReader.getRegisterTestData(
                "register_test_data.equivalence_partitioning.password_validation");
        return convertRegisterDataToArray(testData);
    }

    @DataProvider(name = "registerInvalidSpecialChars_EP")
    public Object[][] registerInvalidSpecialChars() {
        List<RegisterTestData> testData = JsonDataReader.getRegisterTestData(
                "register_test_data.equivalence_partitioning.invalid_special_characters_register");
        return convertRegisterDataToArray(testData);
    }

    // ==================== CHANGE PASSWORD DATA PROVIDERS ====================

    @DataProvider(name = "changePasswordValid_EP")
    public Object[][] changePasswordValid() {
        List<ChangePasswordTestData> testData = JsonDataReader.getChangePasswordTestData(
                "change_password_test_data.equivalence_partitioning.valid_passwords");
        return convertChangePasswordDataToArray(testData);
    }

    @DataProvider(name = "changePasswordInvalidCurrent_EP")
    public Object[][] changePasswordInvalidCurrent() {
        List<ChangePasswordTestData> testData = JsonDataReader.getChangePasswordTestData(
                "change_password_test_data.equivalence_partitioning.invalid_current");
        return convertChangePasswordDataToArray(testData);
    }

    @DataProvider(name = "changePasswordInvalidNew_EP")
    public Object[][] changePasswordInvalidNew() {
        List<ChangePasswordTestData> testData = JsonDataReader.getChangePasswordTestData(
                "change_password_test_data.equivalence_partitioning.invalid_new_format");
        return convertChangePasswordDataToArray(testData);
    }

    @DataProvider(name = "changePasswordLength_BVA")
    public Object[][] changePasswordLength() {
        List<ChangePasswordTestData> testData = JsonDataReader.getChangePasswordTestData(
                "change_password_test_data.boundary_value_analysis.new_password_length");
        return convertChangePasswordDataToArray(testData);
    }

    @DataProvider(name = "changePasswordInvalidNewFormat_EP")
    public Object[][] changePasswordInvalidNewFormat() {
        List<ChangePasswordTestData> testData = JsonDataReader.getChangePasswordTestData(
                "change_password_test_data.equivalence_partitioning.new_password_format");
        return convertChangePasswordDataToArray(testData);
    }

    @DataProvider(name = "changePasswordInvalidSpecialChars_EP")
    public Object[][] changePasswordInvalidSpecialChars() {
        List<ChangePasswordTestData> testData = JsonDataReader.getChangePasswordTestData(
                "change_password_test_data.equivalence_partitioning.invalid_special_characters_change");
        return convertChangePasswordDataToArray(testData);
    }

    @DataProvider(name = "changePasswordEmptyFields_EP")
    public Object[][] changePasswordEmptyFields() {
        List<ChangePasswordTestData> testData = JsonDataReader.getChangePasswordTestData(
                "change_password_test_data.equivalence_partitioning.empty_fields");
        return convertChangePasswordDataToArray(testData);
    }

    @DataProvider(name = "changePasswordSpecialCases")
    public Object[][] changePasswordSpecialCases() {
        List<ChangePasswordTestData> testData = JsonDataReader.getChangePasswordTestData(
                "change_password_test_data.special_cases");
        return convertChangePasswordDataToArray(testData);
    }

    // ==================== HELPER METHODS ====================

    private Object[][] convertLoginDataToArray(List<LoginTestData> dataList) {
        Object[][] dataArray = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            dataArray[i][0] = dataList.get(i);
        }
        return dataArray;
    }

    private Object[][] convertRegisterDataToArray(List<RegisterTestData> dataList) {
        Object[][] dataArray = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            dataArray[i][0] = dataList.get(i);
        }
        return dataArray;
    }

    private Object[][] convertChangePasswordDataToArray(List<ChangePasswordTestData> dataList) {
        Object[][] dataArray = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            dataArray[i][0] = dataList.get(i);
        }
        return dataArray;
    }
}
