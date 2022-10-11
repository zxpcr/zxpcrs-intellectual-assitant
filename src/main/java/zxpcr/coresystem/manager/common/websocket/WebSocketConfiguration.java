package zxpcr.coresystem.manager.common.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;
import zxpcr.coresystem.manager.whattoeat.wshandler.SyncMenuHandler;

import java.util.Map;


@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

    private Logger logger = LoggerFactory.getLogger(WebSocketConfiguration.class);
    public WebSocketConfiguration() {
        logger.info("啊");
    }


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SyncMenuHandler(), "/ws/test")
                .setAllowedOrigins("*")
                .addInterceptors(new MyWebSocketInterceptor());
    }



    class MyWebSocketInterceptor implements HandshakeInterceptor {
        //前置拦截一般用来注册用户信息，绑定 WebSocketSession
        @Override
        public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                       WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
            System.out.println("whatsup");
            if (!(request instanceof ServletServerHttpRequest)) return true;
//            HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
//          String userName = (String) servletRequest.getSession().getAttribute("userName");
            String userName = "" + Math.ceil(Math.random() * 10000);
            attributes.put("userName", userName);
            return true;
        }
        @Override
        public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Exception exception) {
            System.out.println("nani?");
        }
    }

}
