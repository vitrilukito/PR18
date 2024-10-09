package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiPage {

    String setURL, global_id;
    Response res;

    public void prepareAValidURLFor(String url){
        switch (url) {
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USERS":
                setURL = Endpoint.CREATE_NEW_USERS;
                break;
            default:
                System.out.println("input get list user URL");
        }
        System.out.println("The endpoint is " + setURL);
    }

    public void hitTheAPIToGetListData (){
        res = getListUsers(setURL);
        System.out.println(res.getBody().asString());
    }

    public void theStatusCodeShouldBe(int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
        System.out.println("The status code is " + status_code);
    }

    public void theResponseMessageShouldBe (String arg0){
        assertThat(res.statusLine()).contains(arg0);
        System.out.println("The response message is " + arg0);
    }

    public void validationResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        System.out.println(id.get(0));
        System.out.println(name.get(0));
        System.out.println(email.get(0));
        System.out.println(gender.get(0));
        System.out.println(status.get(0));

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }

    public void validationResponseJSONWithJSONSchema(String filename) {
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema (JSONFile));
    }

    public void prepareAnInvalidURLFor(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS + "123";
                break;
            case "CREATE_NEW_USERS":
                setURL = Endpoint.CREATE_NEW_USERS;
                break;
            default:
                System.out.println("input get list user URL");
        }
        System.out.println("The endpoint is " + setURL);
    }

    public void prepareAValidURLWithoutAValidToken (String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USERS":
                setURL = Endpoint.CREATE_NEW_USERS;
                break;
            default:
                System.out.println("input get list user URL");
        }
        System.out.println("The endpoint is  " + setURL);
    }

    public void hitTheAPIToGetData() {
        res = getListUsersNoToken(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIPostCreateNewUsers() {
        res = postCreateUsers(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validationResponseBodyPostCreateNewUsers() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get ("id");
        String name = jsonPathEvaluator.get ("name");
        String email = jsonPathEvaluator.get ("email");
        String gender = jsonPathEvaluator.get ("gender");
        String status = jsonPathEvaluator.get ("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_id = Integer.toString(id);

        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIDeleteUsers() {
        res = deleteUsers(setURL, global_id);
    }

    public void hitTheAPIToUpdateData() {
        res = updateUsers(setURL, global_id);
    }

    public void validationResponseBodyUpdateUsers() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get ("id");
        String name = jsonPathEvaluator.get ("name");
        String email = jsonPathEvaluator.get ("email");
        String gender = jsonPathEvaluator.get ("gender");
        String status = jsonPathEvaluator.get ("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIToPostCreateNewUsers() {
        res = postCreateUsersNoToken(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIToCreateNewUsers() {
        res = postCreateUsersTakenEmail(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIPostCreateNewUsersWithoutBody() {
        res = postCreateUsersWithoutBody (setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIToDeleteUsers() {
        res = deleteUsersNonExistentID (setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIToUpdateDataWithEmptyField() {
        res = updateUsersEmptyField(setURL, global_id);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIToUpdateDataWithNonExistingID() {
        res = updateUsersNonExistentID(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIPostCreateUsersWithCharacters() {
        res = nameFieldBoundary(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIPostCreateUsersWithMoreThanCharacters() {
        res = nameFieldMoreThan200Boundary(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIPostCreateUsersWithCharactersEmail() {
        res = emailBoundary(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIPostCreateUsersWithMoreThanCharactersEmail() {
        res = emailMoreThan200Boundary(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIPostCreateUsersWithOnlyOneCharacterName() {
        res = nameFieldOneChar(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIPostCreateUsersWithOnlyOneCharacterEmail() {
        res = emailOneChar(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIPostCreateUsersWithInvalidEmailFormat() {
        res = invalidEMail(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIPostCreateNewUserWithValidGenderField() {
        res = validGender(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIPostCreateNewUsersWithInvalidGender() {
        res = invalidGender(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIPostCreateNewUsersWithValidStatus() {
        res = validStatus(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitTheAPIPostCreateNewUsersWithInvalidStatus() {
        res = invalidStatus(setURL);
        System.out.println(res.getBody().asString());
    }
}
