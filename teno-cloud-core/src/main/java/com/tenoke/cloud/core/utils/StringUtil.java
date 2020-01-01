package com.tenoke.cloud.core.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author jerrylau
 */
@Slf4j
public class StringUtil {
    /**
     * 对字符串md5加密
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密出现错误");
        }
    }

    /**
     * base64编码
     *
     * @param string
     * @return
     */
    public static String base64Encode(String string) {
        return Base64.getEncoder().encodeToString(string.getBytes());
    }


    /**
     * 16位 md5
     *
     * @param str
     * @return
     */
    public static String getMD5_Short(String str, Integer length) {
        assert length >= 10 : "不能少于10位";
        return StringUtil.getMD5(str).substring(0, length);
    }

    /**
     * 获取上传文件的md5
     *
     * @param bytes
     * @return
     * @throws IOException
     */
    public static String getMd5(byte[] bytes) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(bytes);
            String hashString = new BigInteger(1, digest).toString(16);
            return hashString;
        } catch (Exception e) {
            log.error(e.toString(), e);
        }
        return SnowFlakeUtil.getId().toString();
    }

    /**
     * 16位 md5
     *
     * @param str
     * @return
     */
    public static String getMD5_16(String str) {
        return StringUtil.getMD5(str).substring(8, 24);
    }


    /**
     * 用户密码加盐加密
     *
     * @param password
     * @param salt
     * @return
     */
    public static String encryptRawPwd(String password, String salt) {
        return StringUtil.getMD5(password + "|" + salt);
    }

    /**
     * List转换，联结
     *
     * @param longList
     * @return
     */
    public static String longListToString(List<Long> longList) {
        List<String> stringList = new ArrayList<>();
        for (Long item : longList) {
            stringList.add(Long.toString(item));
        }
        return String.join(",", stringList);
    }

    /**
     * List转换，联结
     *
     * @param longList
     * @return
     */
    public static String longListToString(Set<Long> longList) {
        List<String> stringList = new ArrayList<>();
        for (Long item : longList) {
            stringList.add(Long.toString(item));
        }
        return String.join(",", stringList);
    }

    /**
     * 逗号分割的Long List 转换为List<Long>格式
     *
     * @param originString
     * @return
     */
    public static List<Long> stringToLongList(String originString) {
        List<Long> longList = new ArrayList<>();
        String[] stringList = originString.split(",");
        for (String string : stringList) {
            longList.add(Long.parseLong(string));
        }
        return longList;
    }

    /**
     * base64解码
     *
     * @param string
     * @return
     */
    public static String base64Decode(String string) {
        return new String(Base64.getDecoder().decode(string));
    }

    /**
     * Path后面跟上 /
     *
     * @param path
     * @return
     */
    public static String pathEndWithSlash(String path) {
        return path.substring(path.length() - 1, path.length()).equals("/") ? path : path + "/";
    }

    /**
     * 日期转为字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String dateToDateString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    /**
     * 字符串转为日期
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date dateFromString(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
    }

    /**
     * 验证JSON格式
     *
     * @param jsonObject
     * @return
     */
    public static Boolean validRssFeedCrawlConfJsonFormat(JSONObject jsonObject) {
        return JSONPath.contains(jsonObject, "$.articleCrawlerConf") &&
                JSONPath.contains(jsonObject, "$.articleCrawlerConf.url") &&
                JSONPath.contains(jsonObject, "$.articleCrawlerConf.titlePath") &&
                JSONPath.contains(jsonObject, "$.articleCrawlerConf.publishDatePath") &&
                JSONPath.contains(jsonObject, "$.articleCrawlerConf.authorPath") &&
                JSONPath.contains(jsonObject, "$.listCrawlerConf") &&
                JSONPath.contains(jsonObject, "$.listCrawlerConf.titlePath") &&
                JSONPath.contains(jsonObject, "$.listCrawlerConf.itemPath") &&
                JSONPath.contains(jsonObject, "$.listCrawlerConf.itemTitlePath") &&
                JSONPath.contains(jsonObject, "$.listCrawlerConf.itemLinkPath") &&
                JSONPath.contains(jsonObject, "$.listCrawlerConf.url")
                ;
    }

    /**
     * InputStream --> String
     *
     * @param is
     * @return
     * @throws IOException
     */
    public static String inputStream2String(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }
}
