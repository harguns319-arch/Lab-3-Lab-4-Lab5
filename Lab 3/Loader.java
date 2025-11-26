// Loader class to simulate loading using multithreading
public class Loader implements Runnable {

    @Override
    public void run() {
        try {
            System.out.print("Loading");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500); // pause for 0.5 sec
                System.out.print(".");
            }
            System.out.println("\n");
        } catch (InterruptedException e) {
            System.out.println("Loading interrupted!");
        }
    }
}
