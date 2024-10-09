package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.*;

public class Models {

    private static RequestSpecification request;

    public static void setupHeaders(){
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json" )
                .header("Authorization", "Bearer 27df45adad5a9b7994a7488f35b075af3a6bbbd2f3b66018cd3a4f751bb066b3");
    }

    public static Response getListUsers(String endpoint){
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response postCreateUsers(String endpoint){
        String name = "Vitri";
        String gender = "female";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response postCreateUsersTakenEmail (String endpoint) {
        String name = "Zach";
        String gender = "male";
        String email = "dc_abbott_chandranath@lubowitz.test";
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response postCreateUsersWithoutBody (String endpoint){
        String name = "";
        String gender = "";
        String email = generateRandomEmail();
        String status = "";
        JSONObject payload = new JSONObject();
        payload.put("", name);
        payload.put("", gender);
        payload.put("", email);
        payload.put("", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response deleteUsers(String endpoint, String user_id){
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().delete(finalEndpoint);
    }

    public static Response deleteUsersNonExistentID (String endpoint){
        setupHeaders();
        String finalEndpoint = endpoint + "/" + "1234567";
        return request.when().delete(finalEndpoint);
    }

    public static Response updateUsers(String endpoint, String user_id){
        setupHeaders();

        String name = "Vitri Edit";
        String gender = "female";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        String finalEndpoint = endpoint + "/" + user_id;
        return request.body(payload.toString()).when().patch(finalEndpoint);
    }

    public static Response updateUsersEmptyField (String endpoint, String user_id){
        setupHeaders();

        String name = null;
        String gender = null;
        String email = null;
        String status = null;
        JSONObject payload = new JSONObject();
        payload.put("name", JSONObject.NULL);
        payload.put("gender", JSONObject.NULL);
        payload.put("email", JSONObject.NULL);
        payload.put("status", JSONObject.NULL);

        String finalEndpoint = endpoint + "/" + user_id;
        return request.body(payload.toString()).when().patch(finalEndpoint);
    }

    public static Response updateUsersNonExistentID (String endpoint){
        setupHeaders();

        String name = "Vitri Edit";
        String gender = "female";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        String finalEndpoint = endpoint + "/" + "1234567";
        return request.body(payload.toString()).when().patch(finalEndpoint);
    }

    public static Response nameFieldOneChar (String endpoint){
        String name = generate1CharName();
        String gender = "female";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response nameFieldBoundary (String endpoint){
        String name = generate200CharName();
        String gender = "female";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response nameFieldMoreThan200Boundary (String endpoint){
        String name = generate201CharName();
        String gender = "female";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response emailOneChar (String endpoint){
        String name = "Vitri";
        String gender = "female";
        String email = generate1CharEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response emailBoundary (String endpoint){
        String name = "Vitri";
        String gender = "female";
        String email = generate200CharEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response emailMoreThan200Boundary (String endpoint){
        String name = "Vitri";
        String gender = "female";
        String email = generate201CharEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response invalidEMail (String endpoint){
        String name = "Vitri";
        String gender = "female";
        String email = generateInvalidEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response validGender (String endpoint){
        String name = "Vitri";
        String gender = generateValidGender();
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response invalidGender (String endpoint){
        String name = "Vitri";
        String gender = "unknown";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response validStatus (String endpoint){
        String name = "Vitri";
        String gender = generateValidGender();
        String email = generateRandomEmail();
        String status = generateValidStatus();
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response invalidStatus (String endpoint){
        String name = "Vitri";
        String gender = generateValidGender();
        String email = generateRandomEmail();
        String status = "blocked";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static void setupHeadersNoToken (){
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json" )
                .header("Authorization", "Bearer Token ");
    }

    public static Response getListUsersNoToken (String endpoint){
        setupHeadersNoToken();
        return request.when().get(endpoint);
    }

    public static Response postCreateUsersNoToken (String endpoint){
        String name = "Vitri";
        String gender = "female";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeadersNoToken();
        return request.body(payload.toString()).when().post(endpoint);
    }
}
