package MidtermPractice;

import Week3.Lecture.ArrayQueue;

public class Practice5 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();

        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }

}
class RecentCounter{

    ArrayQueue<Integer> recentRequests;

    public RecentCounter(){
       this.recentRequests = new ArrayQueue<>();
    }

    public int ping(int t) {
        recentRequests.enQueue(t);
        if(recentRequests.peekFront() < t - 3000){
            recentRequests.deQueue();
        }
        return recentRequests.size();
    }

}

