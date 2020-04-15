package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lixinglin
 * @date 2020/4/9 4:56 下午
 * @since jdk 1.8
 */
public class DiningPhilosophers_1226_medium {

    public static void main(String[] args) {

    }

    private Semaphore eatLimit = new Semaphore(4);


    //针对叉子增加可重入锁

    private ReentrantLock[] locks = {new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()};


    //fork与philosopher顺时针顺序为 [0] 0 [1] 1 [2] 2 [3] 3 [4] 4
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork = (philosopher + 1) % 5;
        int rightFork = philosopher;

        eatLimit.acquire();

        locks[leftFork].lock();
        locks[rightFork].lock();

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();

        putLeftFork.run();
        putRightFork.run();

        locks[leftFork].unlock();
        locks[rightFork].unlock();

        eatLimit.release();

    }
}
