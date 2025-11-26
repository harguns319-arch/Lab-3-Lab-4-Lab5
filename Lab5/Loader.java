package util;

public class Loader implements Runnable {

    @Override
    public void run() {
        try {
            System.out.print("Loading");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(400);
                System.out.print(".");
            }
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Loading interrupted.");
        }
    }
}
