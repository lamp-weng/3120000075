package com.lamp;

import com.Utils.IOUtil;
import com.Utils.GetSimilarityUtil;

import java.io.File;
import java.io.IOException;


import static com.Utils.IOUtil.textToString;

/**
 * @Author:lamp
 * @Date:2022/9/15 - 09 -15 -0:15
 * @Description:com.lamp
 * @version:1.0
 */
public class Check {
    public static void main(String[] args) throws IOException {

        String originalPath = "D:/workspace/src/main/file/orig.txt";
        String plagiarizePath = "D:/workspace/src/main/file/orig_0.8_add.txt";
        String resultPath = "D:/workspace/src/main/file/response.txt";

        Check d = new Check();
        d.getRepetiveRate(originalPath,plagiarizePath,resultPath);

    }

    /**
     * @param originalPath   原文件路径
     * @param plagiarizePath 抄袭文件路径
     */
    public void getRepetiveRate(String originalPath, String plagiarizePath , String resultPath) {

        File originalFile = new File(originalPath);
        File plagiarizeFile = new File(plagiarizePath);


        String oriStr = textToString(originalPath); //文本转为字符串
        String plagStr = textToString(plagiarizePath);
        String resStr = resultPath;
        if (!originalFile.exists() || !plagiarizeFile.exists()) {  //文件不存在
            return;
        }
        //余弦相似度计算
        GetSimilarityUtil getSimiarityUtil = new GetSimilarityUtil(originalPath, plagiarizePath);
        System.out.println("相似度："+getSimiarityUtil.sim());
        IOUtil.StringToFile(resStr, oriStr + "\n" + plagStr + "\n"
                + "相似度 ：" + getSimiarityUtil.sim());
    }

}
