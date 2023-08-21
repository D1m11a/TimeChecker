package TimeChecker;

public class TimeChecker {
    public static void main(String[] args) {
        Thread clockThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (true) {
                long currentTime = System.currentTimeMillis();
                long elapsedTime = (currentTime - startTime) / 1000;
                System.out.println("Пройшло " + elapsedTime + " секунд");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread messageThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        clockThread.start();
        messageThread.start();
    }
}
