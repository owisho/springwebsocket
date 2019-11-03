package per.owisho.learn.websocket.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class DemoSocketController {

    @MessageMapping("/test")
    public void message(JSONPObject json){
        System.out.println(json);
        System.out.println("接收到socket消息");
    }

}
