package com.bits.leave;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class LeaveServiceApplication {
    public static void main(String[] args) throws Exception {
        String environment = System.getenv().getOrDefault("APP_ENV", "development");

        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", 8080), 0);

        server.createContext("/", exchange -> {
            String response = "Leave Service Application Started\n"
                    + "Environment: " + environment + "\n"
                    + "Leave Balance: " + LeaveCalculator.calculateLeaveBalance(20, 5) + "\n"
                    + "Leave Encashment: " + LeaveCalculator.calculateLeaveEncashment(5, 1000) + "\n";

            exchange.getResponseHeaders().set("Content-Type", "text/plain");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        server.start();
        System.out.println("Leave Service running on port 8080");
        System.out.println("Environment: " + environment);
    }
}
