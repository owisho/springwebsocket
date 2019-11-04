package per.owisho.learn.websocket.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.Cookie;
import java.util.Map;

public class HandshakeInterceptorImpl extends HttpSessionHandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        if(request instanceof ServletServerHttpRequest){
            ServletServerHttpRequest req = (ServletServerHttpRequest)request;
            Cookie[] cookies =req.getServletRequest().getCookies();
            String token = getToken("token",cookies);
            attributes.put("token", token);
        }
        return super.beforeHandshake(request, response, wsHandler, attributes);
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
