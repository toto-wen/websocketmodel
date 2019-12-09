import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by PC-007 on 2019/11/28.
 */
public class TestMain {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String str = "编码";
        System.out.println(str.equals(new String(str.getBytes(), "GBK")));
    }
}
