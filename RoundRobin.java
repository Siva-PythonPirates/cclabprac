import java.util.LinkedList;
import java.util.Queue;

class Process {
    int id, remainingTime;

    Process(int id, int burstTime) {
        this.id = id;
        this.remainingTime = burstTime;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        int timeQuantum = 4, currentTime = 0;
        Queue<Process> queue = new LinkedList<>();

        // Add processes
        queue.add(new Process(1, 10));
        queue.add(new Process(2, 5));
        queue.add(new Process(3, 8));

        while (!queue.isEmpty()) {
            Process p = queue.poll();
            int timeUsed = Math.min(timeQuantum, p.remainingTime);
            p.remainingTime -= timeUsed;
            currentTime += timeUsed;

            if (p.remainingTime > 0) queue.add(p);
            else System.out.println("Process " + p.id + " finished at time " + currentTime);
        }
    }
}
