public class APILogger {

    public static void logRequest(String method, String url, Object body) {
        ExtentTestManager.getTest().info(
                "<pre>METHOD: " + method + "\nURL: " + url + "\nBODY:\n" + body + "</pre>"
        );
    }

    public static void logResponse(Response res) {
        ExtentTestManager.getTest().info(
                "<pre>STATUS: " + res.getStatusCode() +
                        "\nRESPONSE:\n" + res.getBody().asPrettyString() + "</pre>"
        );
    }
}