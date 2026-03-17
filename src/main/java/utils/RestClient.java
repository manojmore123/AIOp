public class RestClient {

    public static Response post(String endpoint, Object body) {

        String url = ConfigManager.get("base.url") + endpoint;

        APILogger.logRequest("POST", url, body);

        Response res = given()
                .header("Content-Type", "application/json")
                .body(body)
                .post(endpoint);

        APILogger.logResponse(res);

        return res;
    }

    public static Response get(String endpoint) {

        String url = ConfigManager.get("base.url") + endpoint;

        APILogger.logRequest("GET", url, "N/A");

        Response res = given().get(endpoint);

        APILogger.logResponse(res);

        return res;
    }
}