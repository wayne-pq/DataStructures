package JDK;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Base64;

/**
 * Created by panqian on 2017/3/9.
 */
public class Base64_1 {
    public static void main(String[] args) {
        //加密
        Base64.Encoder encoder = Base64.getEncoder();
        String s = "123456" + ":" + "123456";
        String string = encoder.encodeToString(s.getBytes());
        System.out.println("加密后" + string);

        //解密
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(string);
        String s1 = new String(decode);
        System.out.println("解密：" + s1);


        //包装输出流,动态输出的时候实时加密
        Path afterEncoder = Paths.get("AfterEncoder.txt");

        System.out.println("输入需要Base64加密的值：");
        try (OutputStream outputStream = Files.newOutputStream(afterEncoder, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
             OutputStream wrap = encoder.wrap(outputStream);
             BufferedReader read = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")))
        ) {
            String str;
            while (!"exit".equals(str = read.readLine())) {
                byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
                wrap.write(bytes);
            }
        } catch (IOException e) {
        }


        //包装输入流，反编译文件
        Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
        byte[] bytes = new byte[512];

        try (InputStream inputStream = Files.newInputStream(afterEncoder);
             InputStream wrap = mimeDecoder.wrap(inputStream);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(wrap)
        ) {

            StringBuffer stringBuffer = new StringBuffer();
            while (bufferedInputStream.read(bytes) != -1) {
                stringBuffer.append(new String(bytes, Charset.forName("UTF-8")));
            }
            System.out.println("编译后：");
            System.out.println(stringBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
