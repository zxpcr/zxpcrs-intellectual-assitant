package zxpcr.coresystem.manager.whattoeat.wshandler;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import zxpcr.coresystem.manager.whattoeat.service.MenuRoomService;

import javax.websocket.Session;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class MenuRoomHandler implements WebSocketHandler {

    private Logger logger = LoggerFactory.getLogger(MenuRoomHandler.class);

    private static final List<WebSocketSession> sessionStorage = new CopyOnWriteArrayList<>();

    @Autowired
    private MenuRoomService roomService;



    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        String userName = session.getAttributes().get("userName").toString();
        sessionStorage.add(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        logger.info(message.getPayload().toString());
        WebSocketSession sessionOnProcess = null;

        Map request = (Map) JSON.parse(message.getPayload().toString());
        switch ((String) request.get("type")) {
            case "0":   //Adding new room
                roomService.addNewRoom((String) request.get("roomName"));

                Map noticeMap = new HashMap();
                noticeMap.put("roomList", roomService.getRoomList());
                String notice = JSON.toJSONString(noticeMap);
                TextMessage noticeMsg = new TextMessage(notice);
                for (WebSocketSession socketSession : sessionStorage) {
                    session.sendMessage(noticeMsg);
                }

                break;
            //case "1":
            default:
                break;
        }








    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        exception.printStackTrace();
        logger.info("出错啦");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

        WebSocketSession sessionOnProcess = null;
        Iterator<WebSocketSession> iterator = sessionStorage.iterator();
        while (iterator.hasNext()) {
            WebSocketSession sessionNext = iterator.next();
            if (sessionNext.equals(session)) {
                sessionNext.close();
                sessionStorage.remove(sessionNext);
            }
        }

        logger.info("完事啦");

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }







}
