package JDK.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author panqian
 * @Description:
 * @date 2018/1/2
 */
public class NIOWrite {
    public static void main(String[] args) throws IOException {
        ByteBuffer wrap = ByteBuffer.wrap("潘谦".getBytes(Charset.forName("utf-8")));
        FileChannel channel = new FileOutputStream(NIOWrite.class.getResource("/").getPath().toString() + "NIO.txt").getChannel();
        channel.write(wrap);
        channel.close();
    }
}
