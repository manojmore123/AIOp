public class WaitUtils {

    public static <T> T waitUntil(Supplier<T> supplier, Predicate<T> condition) {

        int max = Integer.parseInt(ConfigManager.get("max.retry"));
        int interval = Integer.parseInt(ConfigManager.get("retry.interval"));

        T result;

        for (int i = 0; i < max; i++) {
            result = supplier.get();

            if (condition.test(result)) return result;

            try { Thread.sleep(interval * 1000); } catch (Exception e) {}
        }

        throw new RuntimeException("Condition not met");
    }
}