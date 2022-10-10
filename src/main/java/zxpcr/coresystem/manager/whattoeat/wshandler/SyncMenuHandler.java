package zxpcr.coresystem.manager.whattoeat.wshandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

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
        logger.info("检测到神奇的新用户?",userName);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        logger.info(message.getPayload().toString());
        for (Map.Entry<String, WebSocketSession> sessionUser : sessionStorage.entrySet()) {
            sessionUser.getValue().sendMessage(message);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        logger.info("出错啦");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.info("完事啦");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }


}
