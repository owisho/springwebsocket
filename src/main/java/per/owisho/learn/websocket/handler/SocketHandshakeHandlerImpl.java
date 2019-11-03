package per.owisho.learn.websocket.handler;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeFailureException;
import org.springframework.web.socket.server.HandshakeHandler;

import javax.servlet.http.Cookie;
import java.util.Map;

public class SocketHandshakeHandlerImpl implements HandshakeHandler {
    @Override
    public boolean doHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws HandshakeFailureException {
        System.out.println(request);
        if(request instanceof ServletServerHttpRequest){
            ServletServerHttpRequest req = (ServletServerHttpRequest)request;
            Cookie[] cookies =req.getServletRequest().getCookies();
            String token = getToken("token",cookies);
            System.out.println(token);
        }
        return false;
    }

    private String getToken(String name,Cookie[] cookies){
        if(cookies != null){
            for(Cookie cookie:cookies){
                if(name.equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        }
        return "";
    }

}
