public class ScreenshotUtil {

    public static String capture(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "reports/screenshots/" + name + ".png";
            Files.createDirectories(Paths.get("reports/screenshots"));
            Files.copy(src.toPath(), Paths.get(path));
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}