package stepDef;

import io.cucumber.java.en.Given;

public class ApiStep {
    @Given("prepare a valid URL for the GET list data request")
    public void prepareAValidURLForTheGETListDataRequest() {
        System.out.println("Hello Step");
    }
}
