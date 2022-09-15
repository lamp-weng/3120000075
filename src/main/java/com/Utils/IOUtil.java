package com.Utils;

import java.io.*;

/**
 * @Author:lamp
 * @Date:2022/9/15 - 09 -15 -0:31
 * @Description:com.Utils
 * @version:1.0
 */
public class IOUtil {
    /**
     *
     * @param path 文件路径
     * @return 返回字符串
     */
    public static String textToString(String path){
        if(path==null||"".equals(path)){
            return "";
        }
        StringBuilder sb = new StringBuilder();//可变字符串 用于存储文本
        File file = new File(path);
        InputStreamReader read = null;
        BufferedReader reader = null;
        try {
            read = new InputStreamReader(new FileInputStream(file),
                    "utf-8");//将字节流转换为字符流
            reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {     //逐行读取 字符串格式
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
        return sb.toString();
    }

    /**
     * 输出文件,输出结果
     * @param outputFilePath 输出文件的路径
     * @param result 字符串形式传入结果
     */
    public static void StringToFile(String outputFilePath, String result){
        //创建输出路径的文件
        File outputFile = new File(outputFilePath);
        try (FileWriter fr = new FileWriter(outputFile)) {
            char[] cs = result.toCharArray();
            fr.write(cs);
            fr.close();
            System.out.println("结果写入 " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
