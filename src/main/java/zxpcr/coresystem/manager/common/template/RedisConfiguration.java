package zxpcr.coresystem.manager.common.template;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisConfiguration {

    @Value("redis.host")
    private String host;

    @Value("redis.port")
    private Integer port;

    private Jedis jedis;

    private RedisConfiguration() {
        jedis = new Jedis(this.host, this.port);
    }

    public Jedis getJedis(){
        return this.jedis;
    }

    private static RedisConfiguration redis = new RedisConfiguration();


    public static RedisConfiguration getInstance() {
        return redis;
    }

}
