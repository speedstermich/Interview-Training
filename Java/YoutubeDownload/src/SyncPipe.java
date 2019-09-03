import java.io.InputStream;
import java.io.OutputStream;

public class SyncPipe implements Runnable{
    private final OutputStream outputStream;
    private final InputStream inputStream;
    public SyncPipe(InputStream istrm, OutputStream ostrm){
        inputStream = istrm;
        outputStream = ostrm;
    }
    public void run(){
        try{
            final byte[] buffer = new byte[1024];
            for (int length = 0; (length = inputStream.read(buffer)) != -1; ){
                outputStream.write(buffer, 0, length);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

