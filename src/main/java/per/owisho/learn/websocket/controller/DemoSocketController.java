package per.owisho.learn.websocket.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class DemoSocketController {

    @MessageMapping("/test")
    public void message(JSONObject json){
        System.out.println(json);
        System.out.println("接收到socket消息");
    }

}
