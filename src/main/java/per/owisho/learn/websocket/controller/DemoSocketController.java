package per.owisho.learn.websocket.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DemoSocketController {

    @Autowired
    MessageSendingOperations<String> messageSendingOperations;

    @MessageMapping("/test")
    @SendTo("/topic/callback")
    public String message(JSONObject json) {
        System.out.println(json);
        System.out.println("接收到socket消息");
        return json.getString("message");
}

    @GetMapping("sendMsg")
    @ResponseBody
    public String sendMsg() {
        Message<String> message = new Message<String>() {
            @Override
            public String getPayload() {
                return "ssssssssssssssss";
            }

            @Override
            public MessageHeaders getHeaders() {
                return null;
            }
        };
//        messageSendingOperations.send("", message);

        this.messageSendingOperations.convertAndSend("/topic/callback", "sjon", message.getHeaders());
        return "1";
    }
}
