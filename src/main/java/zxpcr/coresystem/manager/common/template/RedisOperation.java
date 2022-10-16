package zxpcr.coresystem.manager.common.template;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;

@Component
public class RedisOperation {

    private static Jedis redis = RedisConfiguration.getInstance().getJedis();


    public static boolean isKeyExist(String key) {
        return redis.exists(key);
    }


    public static void setStringKey(String key, String value) {
        redis.set(key, value);
    }

    public static void setListKey(String key, List<String> value) {
        for (String item : value) {
            redis.lpush(key, item);
        }
    }

    public static Long getListKeyLen(String key) {
        return redis.llen(key);
    }


    public static List getListKey(String key) {
        return redis.lrange(key, 0, getListKeyLen(key).intValue());
    }


    public static void removeListKey(String key, String o) {
        redis.lrem(key, 0L,  o);
    }



}
