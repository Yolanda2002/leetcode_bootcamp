package LeetcodeBootcamp.lecture4;

public class lc2327 {
    static final int MODULO = 1000000007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int ownCount = 1, shareCount = 0;
        Queue<int[]> ownQueue = new ArrayDeque<int[]>();
        Queue<int[]> shareQueue = new ArrayDeque<int[]>();
        ownQueue.offer(new int[]{delay + 1, 1});
        for (int i = 2; i <= n; i++) {
            if (!shareQueue.isEmpty() && shareQueue.peek()[0] == i) {
                shareCount = (shareCount - shareQueue.poll()[1] + MODULO) % MODULO;
            }
            if (!ownQueue.isEmpty() && ownQueue.peek()[0] == i) {
                int currCount = ownQueue.poll()[1];
                shareQueue.offer(new int[]{i + forget - delay, currCount});
                ownCount = (ownCount - currCount + MODULO) % MODULO;
                shareCount = (shareCount + currCount) % MODULO;
            }
            ownQueue.offer(new int[]{i + delay, shareCount});
            ownCount = (ownCount + shareCount) % MODULO;
        }
        return (ownCount + shareCount) % MODULO;
    }

}
