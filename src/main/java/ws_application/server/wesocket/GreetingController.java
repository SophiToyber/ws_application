package ws_application.server.wesocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import ws_application.client.Message;

@Controller
public class GreetingController {
	private Logger logger = LogManager.getLogger(GreetingController.class);

	@MessageMapping("/hello")
	@SendTo("/topic/app")
	public Message greeting(Message message) throws Exception {
		
		System.out.println("Hello" + message);
		logger.info("Server GET message --" + message);
		return new Message("Hello, u too " + message);
	}

}
