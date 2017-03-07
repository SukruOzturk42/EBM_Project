/**
 * Created by sukru on 26.02.2017.
 */
import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.BitSet;

public class Main {

    public static void main(String[] args) throws IOException {
  /*      Path path =  Paths.get("a.583");
        BinaryParser parser = new BinaryParser(path);
        byte[] maBytes = new byte[11];
        maBytes[0] = parser.readNextByte();
        maBytes[1] = parser.readNextByte();
        maBytes[2] = parser.readNextByte();
        maBytes[3] = parser.readNextByte();
        maBytes[4] = parser.readNextByte();
        maBytes[5] = parser.readNextByte();
        maBytes[6] = parser.readNextByte();
        maBytes[7] = parser.readNextByte();
        maBytes[8] = parser.readNextByte();
        maBytes[9] = parser.readNextByte();
        maBytes[10] = parser.readNextByte();
        String hex = DatatypeConverter.printHexBinary(maBytes);
        String binaryStr = hexToBin(hex);
*/
        long a = System.currentTimeMillis();
        final FileChannel channel = new FileInputStream("C:/Users/sukru/Desktop/EBM_project/EBM/A20150804.1446+0300-20150804.1447+0300_2_ebs.585").getChannel();
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        long b = System.currentTimeMillis();
        long c = (b - a) / 1000;
        System.out.println(a + "\n" + b + "\n" + c);
        //  byte[] maBytes = {buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.get()};
        byte[] maBytes = {buffer.get(), buffer.get()};
        System.out.println(DatatypeConverter.printHexBinary(maBytes));

    }

    static String hexToBin(String s) {
        return new BigInteger(s, 16).toString(2);
    }


}