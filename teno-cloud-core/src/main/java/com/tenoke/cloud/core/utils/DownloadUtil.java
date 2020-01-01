package com.tenoke.cloud.core.utils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

/**
 * 下载文件到本地
 *
 * @author jerrylau
 */
public class DownloadUtil {


    /**
     * 下载文件到本地
     *
     * @param urlString
     * @param filename
     * @throws Exception
     * @author sun
     * @date 2018年3月25日 上午11:01:05
     */
    public void download(String urlString, String filename) throws Exception {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        // 输入流
        InputStream is = con.getInputStream();
        String code = con.getHeaderField("Content-Encoding");
        if ((null != code) && code.equals("gzip")) {
            GZIPInputStream gis = new GZIPInputStream(is);
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            OutputStream os = new FileOutputStream(filename);
            // 开始读取
            while ((len = gis.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            gis.close();
            os.close();
            is.close();
        } else {
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            OutputStream os = new FileOutputStream(filename);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
        }
    }

    public void main(String[] args) {
        try {
            download("https://www.baidu.com/img/bd_logo1.png", "/Users/jerrylau/b.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
