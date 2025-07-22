package MyTaskApp.MyTaskList.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthTestController {

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
        return ResponseEntity.ok(response);
    }
}
