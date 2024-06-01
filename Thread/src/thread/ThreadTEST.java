/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package thread;

/**
 *
 * @author Tiến Khum Bịp
 */
public class ThreadTEST {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread2 is notifying...");
                // Thread2 thông báo
                lock.notify(); // loại wait đi
            }
        });
        Thread thread1 = new Thread(() -> {

            synchronized (lock) {
                try {
                    System.out.println("Thread1 bắt đầu chờ...");
                    lock.wait(); // Thread1 chờ
                    thread2.join();
                    if (thread2.isAlive()) {
                        System.out.println("Đang chạy");
                    } else {
                        System.out.println("Đã dừng");
                    }
                    System.out.println("Thread1 tiếp tục.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        try {
            // Đảm bảo thread1 đã vào trạng thái chờ
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (thread1.isAlive()) {
            System.out.println("Đang chạy");
        } else {
            System.out.println("Đã dừng");
        }
        thread2.start();

    }

}
