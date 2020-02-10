package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.HashMap;
import java.util.Map;

public class RedisWithReentrantLock {
    private ThreadLocal<Map<String,Integer>> lockers = new ThreadLocal<>();
    private Jedis jedis;
    public RedisWithReentrantLock(Jedis jedis){
        this.jedis = jedis;
    }
    private boolean _lock(String key){
        return jedis.set(key,"",new SetParams()) != null;
    }
    private void  _unlock(String key){
        jedis.del(key);
    }
    private Map<String,Integer> currentLockers(){
        Map<String,Integer> refs = this.lockers.get();
        if (refs != null){
            return refs;
        }
        this.lockers.set(new HashMap<>());
        return this.lockers.get();
    }
}
