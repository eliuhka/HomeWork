import server.JettyServer;

public class Application {
    public static void main(String[] args) {
        JettyServer jettyServer = new JettyServer();
        try {
            jettyServer.start();
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }
}
