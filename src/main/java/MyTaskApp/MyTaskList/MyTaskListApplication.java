package MyTaskApp.MyTaskList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MyTaskListApplication {

	private static final Logger logger = LoggerFactory.getLogger(MyTaskListApplication.class);

	public static void main(String[] args) {
		logger.info("=== STARTING MYTASK APPLICATION ===");
		logger.info("PORT environment variable: {}", System.getenv("PORT"));
		logger.info("MONGODB_URI set: {}", System.getenv("MONGODB_URI") != null ? "YES" : "NO");
		
		try {
			SpringApplication.run(MyTaskListApplication.class, args);
		} catch (Exception e) {
			logger.error("=== APPLICATION STARTUP FAILED ===", e);
			throw e;
		}
	}

	@Component
	static class ApplicationStartupListener {
		
		private static final Logger logger = LoggerFactory.getLogger(ApplicationStartupListener.class);
		
		@Value("${server.port:8082}")
		private String serverPort;

		@EventListener(ApplicationReadyEvent.class)
		public void onApplicationReady() {
			logger.info("=== MYTASK APPLICATION READY ===");
			logger.info("Application is running on port: {}", serverPort);
			logger.info("Health endpoint: /ping");
			logger.info("Test endpoint: /test");
			logger.info("API endpoints: /api/tasks, /api/categories");
			logger.info("=== APPLICATION STARTUP COMPLETE ===");
		}
	}
}
