package thread;

/**
 * @author lixinglin
 * @date 2020/4/9 4:13 下午
 * @since jdk 1.8
 */
public class PrintBySort_1114_easy {

    private boolean firstFinished = false;
    private boolean secondFinished = false;

    public PrintBySort_1114_easy() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            this.notifyAll();

        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (!firstFinished) {
                this.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            this.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (!secondFinished) {
                this.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
