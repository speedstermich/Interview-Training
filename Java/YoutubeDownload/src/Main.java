import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        String download_path = "I:\\Opening-Video";
        String url = "https://www.youtube.com/watch?v=QPwd_TQpsHY";
        String[] command = {
                "cmd",
        };
        Process process;
        try {
            process = Runtime.getRuntime().exec(command);
            new Thread(new SyncPipe(process.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(process.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(process.getOutputStream());
            stdin.println("cd \""+download_path+"\"");
            stdin.println(download_path+"\\youtube-dl "+url);
            stdin.close();
            process.waitFor();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
