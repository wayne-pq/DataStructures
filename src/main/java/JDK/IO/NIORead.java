package JDK.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author panqian
 * @Description:
 * @date 2018/1/2
 */
public class NIORead {
    public static void main(String[] args) throws IOException {
        FileChannel channel = new FileInputStream(NIORead.class.getResource("/").getPath().toString() + "NIO.txt").getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (channel.read(buffer) > 0) {
            buffer.flip();
//            while (buffer.hasRemaining()) {
//                System.out.print(buffer.get());
//            }
            System.out.println(Charset.forName("UTF-8").decode(buffer));
//            System.out.println(buffer.asCharBuffer());
            buffer.clear();
        }
    }
}
