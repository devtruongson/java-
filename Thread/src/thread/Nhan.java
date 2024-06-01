/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

/**
 *
 * @author Tiến Khum Bịp
 */
public class Nhan extends Thread {

    private double a, b, result;
    private final Object lock;

    public Nhan(double a, double b, Object lock) {
        this.a = a;
        this.b = b;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            result = a * b;
            lock.notify();
        }
    }

    public double getResult() {
        return result;
    }
}
