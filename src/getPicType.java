import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class getPicType {
    public  String getPicType(FileInputStream fis) {
        //读取文件的前几个字节来判断图片格式
        byte[] b = new byte[8];
        try {
            fis.read(b, 0, b.length);
            String type = bytesToHexString(b).toUpperCase();
            System.out.println(type);
            if (type.contains("6A50")||type.contains("6A70")||type.contains("4A50")||type.contains("4A70")) {
                return "TYPE_JPG";
            } else if (type.contains("89504E47")) {
                return "TYPE_PNG";
            } else if (type.contains("47494638")) {
                return "TYPE_GIF";
            } else if (type.contains("424D")) {
                return "TYPE_BMP";
            }else{
                return "TYPE_UNKNOWN";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public  String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
    public static void main(String args[]) throws FileNotFoundException {
        getPicType g=new getPicType();
        System.out.println(g.getPicType(new FileInputStream("/Users/mochix/Desktop/boot/untitled/src/current_face.jpg")));
    }
}
