package api;

import com.google.gson.JsonArray;
import io.restassured.response.Response;

public class AIOpsAPI {

    public static Response getIncident(String id) {
        JsonArray RestClient = null;
        return RestClient.get("/aiops/incidents/" + id);
    }
}