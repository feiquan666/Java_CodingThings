package redis;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FunnelRateLimiter {
    static class Funnel {
        int capacity; // 漏斗容量
        float leakingRate; // 漏嘴流水速率
        int leftQuota; // 漏斗剩余容量
        long leakingTs; // 上次漏水时间

        public Funnel(int capacity, float leakingRate) {
            this.capacity = capacity;
            this.leakingRate = leakingRate;
            this.leftQuota = capacity;
            this.leakingTs = System.currentTimeMillis();
        }

        void makeSpace() {
            long nowTs = System.currentTimeMillis();
            long deltaTs = nowTs - this.leakingTs; // 距离上次漏水过去了多久
            int deltaQuota = (int) (deltaTs * this.leakingRate);
            if (deltaQuota < 0) { // 间隔时间太长，整数数字溢出
                this.leftQuota = capacity;
                this.leakingTs = nowTs;
                return;
            }
            if (deltaQuota < 1) { //腾出空间太小：最小单位是一
                return;
            }
            this.leftQuota += deltaQuota;
            this.leakingTs = nowTs;
            if (this.leftQuota > this.capacity) {
                this.leftQuota = this.capacity;
            }
        }

        boolean watering(int quota) {
            this.makeSpace();
            if (this.leftQuota >= quota) {
                this.leftQuota -= quota;
                return true;
            }
            return false;
        }
    }

    private Map<String, Funnel> funnels = new HashMap<>();

    public boolean isActionAllowed(String userId, String actionKey, int capacity, float leakingRate) {
        String key = String.format("%s:%s", userId, actionKey);
        Funnel funnel = funnels.get(key);
        if (funnel == null) {
            funnel = new Funnel(capacity, leakingRate);
            funnels.put(key, funnel);
        }
        return funnel.watering(1);
    }

    @Test
    public static void main(String[] args) {
        FunnelRateLimiter f = new FunnelRateLimiter();
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        while (true){
            if(a > 0){
                System.out.println(f.isActionAllowed("zs","key",1,0.001f));
            }
            a =  scanner.nextInt();
        }
    }
}
