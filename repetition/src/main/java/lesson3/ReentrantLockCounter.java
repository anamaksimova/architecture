package lesson3;


import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements Runnable {
    public ReentrantLockCounter(String name,ReentrantLock lock) {
              this.name = name;
        this.lock = lock;
    }
    private String name;
   private ReentrantLock lock;

    @Override
    public void run() {
        lock.lock();
        try {
            Count.count += 1;
        } finally {
            System.out.println("Завершил работу "+ name);
            System.out.println("Счетчик " + Count.count);
            lock.unlock();
        }

    }
}
