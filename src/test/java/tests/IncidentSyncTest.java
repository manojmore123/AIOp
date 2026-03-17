public class IncidentSyncTest {

    WebDriver driver;

    @Test
    public void testSync() {

        String body = "{ \"short_description\": \"CPU High\" }";

        Response res = IncidentAPI.createIncident(body);
        String id = res.jsonPath().getString("result.number");

        Response aiops = WaitUtils.waitUntil(
                () -> AIOpsAPI.getIncident(id),
                r -> r.getStatusCode() == 200
        );

        Assert.assertEquals(aiops.getStatusCode(), 200);
    }
}