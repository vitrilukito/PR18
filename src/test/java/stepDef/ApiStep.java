package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {

    ApiPage apiPage;

    public ApiStep() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare a valid URL for {string}")
    public void prepareAValidURLFor(String url) {
        apiPage.prepareAValidURLFor(url);
    }

    @And("hit the API to get list data")
    public void hitTheAPIToGetListData() {
        apiPage.hitTheAPIToGetListData();
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int status_code) {
        apiPage.theStatusCodeShouldBe(status_code);
    }

    @Then("the response message should be {string}")
    public void theResponseMessageShouldBe(String arg0) {
        apiPage.theResponseMessageShouldBe(arg0);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response JSON with JSONSchema {string}")
    public void validationResponseJSONWithJSONSchema(String filename) {
        apiPage.validationResponseJSONWithJSONSchema(filename);
    }

    @Given("prepare an invalid URL for the {string}")
    public void prepareAnInvalidURLForThe(String url) {
        apiPage.prepareAnInvalidURLFor(url);
    }

    @Given("prepare a valid URL without a valid token for the {string}")
    public void prepareAValidURLWithoutAValidTokenForThe(String url) {
        apiPage.prepareAValidURLWithoutAValidToken(url);
    }

    @And("hit the API to get data")
    public void hitTheAPIToGetData() {
        apiPage.hitTheAPIToGetData();
    }

    @And("hit the API post create new users")
    public void hitTheAPIPostCreateNewUsers() {
        apiPage.hitTheAPIPostCreateNewUsers();
    }

    @Then("validation response body post create new users")
    public void validationResponseBodyPostCreateNewUsers() {
        apiPage.validationResponseBodyPostCreateNewUsers();
    }

    @And("hit the API delete users")
    public void hitTheAPIDeleteUsers() {
        apiPage.hitTheAPIDeleteUsers();
    }

    @And("hit the API to update data")
    public void hitTheAPIToUpdateData() {
        apiPage.hitTheAPIToUpdateData();
    }

    @Then("validation response body update users")
    public void validationResponseBodyUpdateUsers() {
        apiPage.validationResponseBodyUpdateUsers();
    }

    @And("hit the API to post create new users")
    public void hitTheAPIToPostCreateNewUsers() {
        apiPage.hitTheAPIToPostCreateNewUsers();
    }

    @And("hit the API to create new users")
    public void hitTheAPIToCreateNewUsers() {
        apiPage.hitTheAPIToCreateNewUsers();
    }

    @And("hit the API post create new users without body")
    public void hitTheAPIPostCreateNewUsersWithoutBody() {
        apiPage.hitTheAPIPostCreateNewUsersWithoutBody();
    }

    @And("hit the API to delete users")
    public void hitTheAPIToDeleteUsers() {
        apiPage.hitTheAPIToDeleteUsers();
    }

    @And("hit the API to update data with empty field")
    public void hitTheAPIToUpdateDataWithEmptyField() {
        apiPage.hitTheAPIToUpdateDataWithEmptyField();
    }

    @And("hit the API to update data with non-existing ID")
    public void hitTheAPIToUpdateDataWithNonExistingID() {
        apiPage.hitTheAPIToUpdateDataWithNonExistingID();
    }

    @And("hit the API post create users with {int} characters")
    public void hitTheAPIPostCreateUsersWithCharacters(int arg0) {
        apiPage.hitTheAPIPostCreateUsersWithCharacters();
    }

    @And("hit the API post create users with more than {int} characters")
    public void hitTheAPIPostCreateUsersWithMoreThanCharacters(int arg0) {
        apiPage.hitTheAPIPostCreateUsersWithMoreThanCharacters();
    }

    @And("hit the API post create users with {int} characters email")
    public void hitTheAPIPostCreateUsersWithCharactersEmail(int arg0) {
        apiPage.hitTheAPIPostCreateUsersWithCharactersEmail();
    }

    @And("hit the API post create users with more than {int} characters email")
    public void hitTheAPIPostCreateUsersWithMoreThanCharactersEmail(int arg0) {
        apiPage.hitTheAPIPostCreateUsersWithMoreThanCharactersEmail();
    }

    @And("hit the API post create users with only one character name")
    public void hitTheAPIPostCreateUsersWithOnlyOneCharacterName() {
        apiPage.hitTheAPIPostCreateUsersWithOnlyOneCharacterName();
    }

    @And("hit the API post create users with only one character email")
    public void hitTheAPIPostCreateUsersWithOnlyOneCharacterEmail() {
        apiPage.hitTheAPIPostCreateUsersWithOnlyOneCharacterEmail();
    }

    @And("hit the API post create users with invalid email format")
    public void hitTheAPIPostCreateUsersWithInvalidEmailFormat() {
        apiPage.hitTheAPIPostCreateUsersWithInvalidEmailFormat();
    }

    @And("hit the API post create new users with valid gender field")
    public void hitTheAPIPostCreateNewUsersWithValidGenderField() {
        apiPage.hitTheAPIPostCreateNewUserWithValidGenderField();
    }

    @And("hit the API post create new users with invalid gender")
    public void hitTheAPIPostCreateNewUsersWithInvalidGender() {
        apiPage.hitTheAPIPostCreateNewUsersWithInvalidGender();
    }

    @And("hit the API post create new users with valid status")
    public void hitTheAPIPostCreateNewUsersWithValidStatus() {
        apiPage.hitTheAPIPostCreateNewUsersWithValidStatus();
    }

    @And("hit the API post create new users with invalid status")
    public void hitTheAPIPostCreateNewUsersWithInvalidStatus() {
        apiPage.hitTheAPIPostCreateNewUsersWithInvalidStatus();
    }
}


