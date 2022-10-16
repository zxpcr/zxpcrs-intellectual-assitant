package zxpcr.coresystem.manager.whattoeat.wshandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class SyncMenuHandler implements WebSocketHandler {

    private Logger logger = LoggerFactory.getLogger(SyncMenuHandler.class);

    private static final Map<String, WebSocketSession> sessionStorage = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        String userName = session.getAttributes().get("userName").toString();
        sessionStorage.put(userName, session);
        logger.info("检测到神奇的新用户?", userName);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        logger.info(message.getPayload().toString());
        WebSocketSession sessionOnProcess = null;
        int a = 0;
        Iterator<Map.Entry<String, WebSocketSession>> iterator = sessionStorage.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, WebSocketSession> sessionPair = iterator.next();
            sessionOnProcess = (WebSocketSession) sessionPair.getValue();
            if (sessionOnProcess.isOpen()) {
                sessionOnProcess.sendMessage(message);
            } /*else {
                //本不应这样
                sessionOnProcess.close();
                sessionStorage.remove(sessionPair.getKey());
            }*/
            a += 1;
        }
        logger.info("当前总session数量为" + a);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        exception.printStackTrace();
        logger.info("出错啦");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

        WebSocketSession sessionOnProcess = null;
        Iterator<Map.Entry<String, WebSocketSession>> iterator = sessionStorage.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, WebSocketSession> sessionPair = iterator.next();
            sessionOnProcess = (WebSocketSession) sessionPair.getValue();
            if (sessionOnProcess.equals(session)) {
                sessionOnProcess.close();
                sessionStorage.remove(sessionPair.getKey());
            }
        }

        logger.info("完事啦");

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }


}
