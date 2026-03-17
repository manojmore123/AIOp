package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class IncidentAPI {

    public static Response createIncident(String body) {
        RestAssured RestClient = null;
        return RestClient.post("/api/now/table/incident", body);

        System.out.println("Incident created with body: ");
    }
}