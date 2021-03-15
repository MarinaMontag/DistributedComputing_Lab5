package barrier;

import java.util.concurrent.atomic.AtomicInteger;

public class MyCyclicBarrier {
    private final int parties;
    private final AtomicInteger currentParties=new AtomicInteger(0);
    private final Runnable barrierAction;
    MyCyclicBarrier(int parties, Runnable barrierAction){
        this.parties=parties;
        this.barrierAction=barrierAction;
    }

    public synchronized void await(){
        if(currentParties.compareAndSet(parties,0)){
            new Thread(barrierAction).start();
        }
    }
}
