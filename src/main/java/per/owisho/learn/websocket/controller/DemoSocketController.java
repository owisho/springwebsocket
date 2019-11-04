package per.owisho.learn.websocket.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

@Controller
public class DemoSocketController {

    @MessageMapping("/test")
    public void message(JSONObject json, Session session){
        System.out.println(json);
        System.out.println("接收到socket消息");
    }
}
