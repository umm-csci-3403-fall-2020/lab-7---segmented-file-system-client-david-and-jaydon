package segmentedfilesystem;
import java.io.IOException;
import java.net.SocketException;

public class Main {
    
    // If there's one command line argument, it is assumed to
    // be the server. If there are two, the second is assumed
    // to be the port to use.
    public static void main(String[] args) {
        System.out.println("started!");
        String server = "csci-4409.morris.umn.edu";
        // CHANGE THIS DEFAULT PORT TO THE PORT NUMBER PROVIDED
        // BY THE INSTRUCTOR.
        int port = 6014;
        
        if (args.length >= 1) {
            server = args[0];
        }
        if (args.length >= 2) {
            port = Integer.parseInt(args[1]);
        }

        FileRetriever fileRetriever = null;
        try {
            fileRetriever = new FileRetriever(server, port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        try {
            fileRetriever.downloadFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
