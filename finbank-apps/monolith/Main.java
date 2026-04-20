import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        String dbHost = System.getenv().getOrDefault("DB_HOST", "postgres.finbank-data.svc.cluster.local");
        String dbName = System.getenv().getOrDefault("DB_NAME", "finbank");

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/health", exchange -> send(exchange, 200, "OK"));

        server.createContext("/api/auth/login", exchange ->
                sendJson(exchange, 200, "{\"service\":\"monolith\",\"token\":\"legacy-token\"}"));

        server.createContext("/api/accounts", exchange ->
                sendJson(exchange, 200, "{\"service\":\"monolith\",\"accounts\":[\"CHK-1001\",\"SVG-2201\"],\"db\":\"" + dbHost + "/" + dbName + "\"}"));

        server.createContext("/api/transactions", exchange ->
                sendJson(exchange, 200, "{\"service\":\"monolith\",\"status\":\"accepted\"}"));

        server.createContext("/", exchange ->
                sendJson(exchange, 200, "{\"service\":\"monolith\",\"message\":\"FinBank legacy monolith\"}"));

        server.start();
        System.out.printf("Monolith listening on %d%n", port);
    }

    private static void send(HttpExchange exchange, int status, String body) throws IOException {
        exchange.sendResponseHeaders(status, body.getBytes().length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(body.getBytes());
        }
    }

    private static void sendJson(HttpExchange exchange, int status, String body) throws IOException {
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        send(exchange, status, body);
    }
}
