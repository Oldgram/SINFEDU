public class BoundedBuffer {
    private Integer[] data;
    private int putPointer, takePointer, size;

    public BoundedBuffer(int capacity){
        this.data = new Integer[capacity];
        this.putPointer = 0;
        this.takePointer = 0;
        this.size = 0;
    }

    /*
     * Mechanics of putting x on the buffer.
     * x is added at the end of the buffer.
     */
    private void doPut(Integer x){
        this.data[this.putPointer] = x;
        this.size++;
        this.putPointer++;
        if (this.putPointer == this.data.length) {
            this.putPointer = 0;
        }
        this.notifyAll();
    }

    /*
     * Mechanics of getting the first element of the buffer
     */
    private Integer doTake(){
        int x = this.data[this.takePointer];
        this.data[this.takePointer] = null;
        this.size--;
        this.takePointer++;
        if (this.takePointer == this.data.length) {
            this.takePointer = 0;
        }
        this.notifyAll();
        return x;
    }

    private boolean isFull(){
        return this.data.length == this.size;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    /*
     * put x on the buffer if the buffer is not full
     * if the buffer is full, the thread waits until a place is free
     */
    public synchronized void put(Integer x) throws InterruptedException{
        while (this.isFull()) {
            try {
                this.wait();
            } catch (InterruptedException e) { throw new InterruptedException(); }
        }
        this.doPut(x);
    }

    /*
     * Get the first element of the buffer
     * if the buffer is empty, the thread waits until an element arrives
     */
    public synchronized Integer take() throws InterruptedException{
        while (this.isEmpty()) {
            try  {
                this.wait();
            } catch (InterruptedException e) { throw new InterruptedException(); }
        }
        return this.doTake();
    }

    /*
     * put x on the buffer if the buffer is not full
     * if the buffer is full, the thread waits ms milliseconds until a place is free
     * if the delay is exceeded, don't put x on the buffer
     * return true if x was added on the buffer, or false
     * return false if an exception occurs
     */
    public synchronized boolean offer(Integer x, long ms){
        if (this.isFull()) {
            try {
                this.wait(ms);
            } catch (InterruptedException e) { return false; }
            if (this.isFull()) { return false; }
        }
        try {
            this.put(x);
        } catch (InterruptedException e) { return false; }
        return true;
    }

    /*
     * get the first element of the buffer
     * if the buffer is empty, the thread waits ms milliseconds until an element arrives
     * if the delay is exceeded or an exception occurs return null
     */
    public synchronized Integer poll(long ms){
        if (this.isEmpty()) {
            try {
                this.wait(ms);
            } catch (InterruptedException e) { return null; }
            if (this.isEmpty()) { return null; }
        }
        try {
            return this.take();
        } catch (InterruptedException e) { return null; }
    }



}
