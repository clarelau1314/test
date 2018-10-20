package test;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.collections.keyvalue.MultiKey;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import com.amerisia.ebills.swift.exception.SwiftException;

public class TestBase64 {
    //�� s ���� BASE64 ����
    public static String Base64Encoder(String s) {
        if (s == null)
            return null;
        return (new BASE64Encoder()).encode(s.getBytes());
    }

    //�� BASE64 ������ַ��� s ���н���
    public static String Base64Decoder(String s) {
        if (s == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(s);
            return new String(b);
        } catch (Exception e) {
            return null;
        }
    }

    public static void aa() throws SwiftException {
        try {
            FileInputStream fs = null;
            fs = new FileInputStream("c:/aa.txt");
            int i = 4 / 0;
        } catch (Exception e) {
            throw new SwiftException(e.getMessage(), 10);
        }
    }

    public static void main(String[] args) {
        String string = "������������������������������������������������������������������������������������������������������������������������";
        System.out.println("����ǰ:" + string);
        String s1 = TestBase64.Base64Encoder(string);
        System.out.println("�����" + s1);
        String s2 = TestBase64.Base64Decoder(s1);
        System.out.println("�����" + s2);
        try {
            aa();
        } catch (SwiftException e) {
            System.out.println(e.getCode());
        }
        HashMap map=new HashMap();
        MultiKey key1=new MultiKey("aa","001");
        MultiKey key2=new MultiKey("aa","002");
        map.put(key1,"111");
        map.put(key2,"222");
        Iterator iterator=map.keySet().iterator();
        while(iterator.hasNext()){
            MultiKey key=(MultiKey)iterator.next();
            System.out.println(key.getKey(1));
        }
        
        
    }
}