package zxpcr.coresystem.manager.whattoeat.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import zxpcr.coresystem.manager.common.template.RedisConfiguration;
import zxpcr.coresystem.manager.common.template.RedisOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MenuRoomService {

    private Logger logger = LoggerFactory.getLogger(MenuRoomService.class);

    public Map createNewRoom(String roomName) {
        Map room = new HashMap<>();
        room.put("roomName", roomName);
        room.put("roomId", UUID.randomUUID().toString());
        return room;
    }

    public void addNewRoom(String roomName) {
        RedisOperation.setListKey("whattoeat.room", List.of(roomName));
    }

    public List getRoomList() {
        return RedisOperation.getListKey("whattoeat.room");
    }

    public void closeRoom(String roomName) {
        RedisOperation.removeListKey("whattoeat.room", roomName);
    }

}
