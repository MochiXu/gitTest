import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utils {
    public void writeImage(byte[] image, String fileName) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName))) {
            System.out.println("准备存储图像");
            fileOutputStream.write(image);
        }
    }
}
