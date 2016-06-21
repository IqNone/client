package el;

import android.os.StrictMode;

import el.client.Client;
import el.server.ServerConnection;
import el.server.ServerConnectionTask;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    private static final String HOST = "game.eternal-lands.com";
    private static final int PORT = 2001;

    public static final String USERNAME = "";
    public static final String PASSWORD = "";

    public static void main(String[] args) throws IOException {
        try {
            setUp();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void setUp() throws IOException {

        // A network operations should always be ran in the background
        // on a thread or as an asynchronous task. But if you know better
        // and are willing to accept the consequences, and must do
        // network operations on the main thread, you can override the default behavior:
        // StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        // StrictMode.setThreadPolicy(policy);

        // ServerConnection connection = new ServerConnection(HOST, PORT);
        // connection.connect();
        // Client client = new Client(connection);
        // client.authenticate(USERNAME, PASSWORD);
        ServerConnectionTask connectionTask = new ServerConnectionTask();
        connectionTask.execute(HOST, Integer.toString(PORT));
        try {
            connectionTask.get(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}
