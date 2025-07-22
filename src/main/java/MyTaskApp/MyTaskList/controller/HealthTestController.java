package MyTaskApp.MyTaskList.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthTestController {
    
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> root() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "MyTask API is running");
        response.put("version", "1.0.0");
        response.put("status", "OK");
        response.put("endpoints", new String[]{"/ping", "/test", "/api/tasks", "/api/categories", "/api/health"});
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ping")
    public ResponseEntity<Map<String, Object>> ping() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("message", "MyTask Backend is running");
        response.put("timestamp", System.currentTimeMillis());
        response.put("server", "Railway");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/test")
    public ResponseEntity<Map<String, Object>> test() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Test endpoint working");
        response.put("server", "MyTask Backend");
        response.put("status", "OK");
        response.put("port", System.getProperty("server.port", "unknown"));
        response.put("activeProfile", System.getProperty("spring.profiles.active", "default"));
        response.put("environment", System.getenv("RAILWAY_ENVIRONMENT_NAME"));
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/api/health")
    public ResponseEntity<Map<String, Object>> apiHealth() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("message", "API endpoints are working");
        response.put("timestamp", System.currentTimeMillis());
        response.put("endpoints", new String[]{"/api/tasks", "/api/categories"});
        return ResponseEntity.ok(response);
    }
}
