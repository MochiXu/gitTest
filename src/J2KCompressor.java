

import com.github.jaiimageio.jpeg2000.J2KImageWriteParam;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Method;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public  class J2KCompressor{
    public byte[] compress(byte[] src) throws IOException {
        System.out.println("compress-fileSuffix-jp2");
        Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix("jp2");
        ImageWriter writer = writers.next();
        J2KImageWriteParam writeParams = (J2KImageWriteParam) writer.getDefaultWriteParam();
        writeParams.setLossless(false);
        writeParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        writeParams.setCompressionType("JPEG2000");
        writeParams.setCompressionQuality(0.0f);
        writeParams.setEncodingRate(0.8f);

        BufferedImage image = ImageIO.read(new ByteArrayInputStream(src));
        ByteArrayOutputStream dst = new ByteArrayOutputStream();
        ImageOutputStream ios = ImageIO.createImageOutputStream(dst);
        writer.setOutput(ios);
        writer.write(null, new IIOImage(image, null, null), writeParams);
        ios.close();
        return dst.toByteArray();
    }

    public byte[] decompress(byte[] dst) throws IOException {
        System.out.println("decompress-fileSuffix-bmp");
        Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix("bmp");
        ImageWriter writer = writers.next();

        BufferedImage image = ImageIO.read(new ByteArrayInputStream(dst));
        ByteArrayOutputStream src = new ByteArrayOutputStream();
        ImageOutputStream ios = ImageIO.createImageOutputStream(src);
        writer.setOutput(ios);
        writer.write(new IIOImage(image, null, null));
        ios.close();
        return src.toByteArray();
    }
}
