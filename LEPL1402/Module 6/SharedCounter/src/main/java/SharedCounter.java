package main.java;

public class SharedCounter {

    private int counter = 0;

    synchronized void inc() {
        counter++;
        notifyAll();
    }

    synchronized void dec() {
        while (true) {
            if (counter > 0) {
                counter--;
                break;
            } else {
                try {
                    this.wait();
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    synchronized int get() { return counter; }

}
