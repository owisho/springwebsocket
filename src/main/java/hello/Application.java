package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.sockjs.frame.Jackson2SockJsMessageCodec;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ServletWebServerFactory getServletWebServerFactory() {
		return new TomcatServletWebServerFactory(9000);
	}
	
	@Bean
	public Jackson2SockJsMessageCodec getJackson2SockJsMessageCodec() {
		return new Jackson2SockJsMessageCodec();
	}
}
