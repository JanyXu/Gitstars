package cn.gitstars.gitstars.utils;

import android.text.TextUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class StringUtil {

    /**
     * 适用于用户中心的DES加密
     *
     * @param source 待加密字符串
     * @param key    DES密钥
     * @return 返回DES加密后并经过BASE64编码后的字符串
     */
    public static String qucDesEncryptStr(String source, String key) {
        String encryptedStr = "";
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());

            // 创建一个密匙工厂，然后用它把DESKeySpec转换成
            // 一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(dks);

            // using DES in CBC mode
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

            // 初始化Cipher对象
            IvParameterSpec iv = new IvParameterSpec(key.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

            // 执行加密操作
            byte encryptedData[] = cipher.doFinal(source.getBytes());

            // 通过Base64将二进制数据变成文本
            encryptedStr = new String(Base64.encode(encryptedData));

        } catch (Exception e) {
        }

        return encryptedStr;
    }

    public static String MD5Encode(byte[] bytes) {
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            byte[] digest = md.digest();
            String text;
            for (int i = 0; i < digest.length; i++) {
                text = Integer.toHexString(0xFF & digest[i]);
                if (text.length() < 2) {
                    text = "0" + text;
                }
                hexString.append(text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }


    /**
     * 获取字符串的字节长度
     */
    public static int getStringWordLength(String s) {
        if (TextUtils.isEmpty(s))
            return 0;
        // String tmp = s.replace("[^\\x00-\\xff]", "**");// 将非标准字符替换为两个标准字符
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            if (ascii >= 0 && ascii <= 255)
                length++;
            else
                length += 2;
        }
        return length;
    }

    /**
     * 系统提供的md5算法
     *
     * @param text
     * @return
     */
    public static String MD5Encode(String text) {
        String md5Str;
        md5Str = MD5Encode(text.getBytes());
        //Log.d(StringUtil.class, "MD5Encode text:" + text + " md5：" + md5Str);
        return md5Str;
    }

    public static String toUtf8(String str) {
        try {
            byte[] strb = null;
            strb = str.getBytes("UTF-8");
            String newStr = new String(strb);
            return newStr;
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private static HashSet<String> Website_Suffix = new HashSet<String>();
    private static String suffixs[] = {"cn", "com", "edu", "gov", "net", "org", "biz", "info", "pro", "name", "coop", "jp", "us", "ca",
            "tw"};

    public static String getTLDText(String url) {
        if (url.startsWith("http://")) {
            url = url.substring(7);
        }
        if (Website_Suffix.size() == 0) {
            for (int i = 0, length = suffixs.length; i < length; i++)
                Website_Suffix.add(suffixs[i]);
        }
        int index1 = url.indexOf("/");
        if (index1 != -1) {
            url = url.substring(0, index1);
        }

        ArrayList<String> tokens = new ArrayList<String>();

        StringTokenizer tokenizer = new StringTokenizer(url, ".");
        while (tokenizer.hasMoreTokens()) {
            String object = (String) tokenizer.nextElement();
            tokens.add(object);
        }

        int tokenSize = tokens.size();

        StringBuffer builder = new StringBuffer();
        boolean tagAppear = false;
        for (int i = tokenSize - 1; i >= 0; i--) {
            String token = tokens.get(i);
            if (Website_Suffix.contains(token)) {
                tagAppear = true;
                builder.insert(0, token);
                builder.insert(0, ".");
                continue;
            } else if (tagAppear) {
                builder.insert(0, token);
                break;
            }
        }
        return builder.toString();
    }

    public static String toMd5(byte[] bytes) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(bytes);
            return toHexString(algorithm.digest(), "");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String toHexString(byte[] bytes, String separator) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(Integer.toHexString(0xFF & b)).append(separator);
        }
        return hexString.toString();
    }

    public static String getSHA(String info) {

        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("SHA");
            byte[] srcBytes = info.getBytes();
            // 使用srcBytes更新摘要
            md5.update(srcBytes);
            // 完成哈希计算，得到result
            byte[] resultBytes = md5.digest();
            return new String(resultBytes);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Hash 加密
     */
    public static String convertSHA1(String plainText) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        return result;
    }

    public static void string2Utf8Stream(String str, OutputStream os) throws IOException {
        if (str == null || os == null)
            return;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 0x80) {
                os.write((byte) c);
            } else if (c >= 0x80 && c < 0x100) {
                int hi = c >> 6;
                hi |= 0xC0;
                int lo = c & 0x3F;
                lo |= 0x80;
                os.write(hi);
                os.write(lo);

            } else {

                int first = c >> 12;
                first |= 0xE0;
                int second = c >> 6;
                second &= 0x3F;
                second |= 0x80;
                int third = c & 0x3F;
                third |= 0x80;
                os.write(first);
                os.write(second);
                os.write(third);
            }
        }
    }

    public static int getNum(String origin, String ch) {
        int chLength = ch.length();
        if (origin.length() == 0)
            return 0;
        if (chLength == 0)
            return -1; // 如果统计的字符为空(即"",不是指空格)返回-1；
        int index = 0;
        int count = 0;
        while (origin.indexOf(ch, index) != -1) {
            ++count;
            index = origin.indexOf(ch, index) + chLength;
        }
        return count;
    }

    public static int getNumCount(String str) {
        int at = str.indexOf(".");
        if (at != -1) {
            int length = str.length() - at;
            return length;
        } else {
            return -1;
        }
    }

    /**
     * 参数排序
     *
     * @param params
     * @return
     */
    public static List<Entry<String, String>> hashMapSort(HashMap<String, String> params) {
        if (null == params)
            return null;

        List<Entry<String, String>> listMap = new ArrayList<Entry<String, String>>(params.entrySet());
        // 排序
        Collections.sort(listMap, new Comparator<Entry<String, String>>() {
            public int compare(Entry<String, String> o1, Entry<String, String> o2) {
                // return (o2.getValue() - o1.getValue());
                return (o1.getKey()).toString().compareTo(o2.getKey());
            }
        });
        return listMap;
    }

    public static String getParad(HashMap<String, String> params, String key) {
        if (null == params)
            return null;

        List<Entry<String, String>> infoIds = hashMapSort(params);
        StringBuilder strBuf = new StringBuilder();

        int size = infoIds.size();
        // 排序后
        for (int i = 0; i < size; i++) {
            strBuf.append(infoIds.get(i).getKey().toString()).append("=").append(infoIds.get(i).getValue().toString());
            if (i < (size - 1)) {
                strBuf.append("&");
            }
        }

        String result;

        result = strBuf.toString();
        // Log.d(StringUtil.class, "result:" + result);
        String parardStr = StringUtil.qucDesEncryptStr(result, key);

        //Log.d(StringUtil.class, "parard:" + parardStr);
        return parardStr;
    }

    public static String urlEncode(String str) {
        String strEncode;
        try {
            strEncode = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            str = "";
            e.printStackTrace();
        }
        return str;
    }
}
