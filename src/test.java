import com.google.protobuf.ByteString;
import org.apache.commons.codec.binary.Base64;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class test {
    public static void main(String args[]) throws Exception {
        Utils utils =new Utils();
        J2KCompressor j2KCompressor =new J2KCompressor();

        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader("/Users/mochix/Desktop/boot/untitled/src/ttt.txt"));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        byte[] decoded=Base64.decodeBase64(result.toString().getBytes());
        ByteString byteString=ByteString.copyFrom(decoded);
        byte[] bytes=byteString.toByteArray();

        //输出原始图像
        utils.writeImage(bytes,"/Users/mochix/Desktop/boot/untitled/src/origin_face.jpg" );
        //压缩
        byte[] compressed= j2KCompressor.compress(bytes);
        //输出压缩之后的图像
        utils.writeImage(compressed,"/Users/mochix/Desktop/boot/untitled/src/compress_face.jpg" );
        //解压缩
        byte[] decompressed= j2KCompressor.decompress(compressed);
        //输出压缩->解压缩之后的图像
        utils.writeImage(decompressed,"/Users/mochix/Desktop/boot/untitled/src/current_face.jpg");

        for (int i=     0 ;i<     10;i++){
                System.out.println("You Know Me??");
        }

        for (int k=0;k<1  ;k++){
            System.out.println("Hi");
        }
    }
}
