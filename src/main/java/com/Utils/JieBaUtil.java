package com.Utils;

import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.List;

/**
 * @Author:lamp
 * @Date:2022/9/15 - 09 -15 -0:32
 * @Description:com.Utils
 * @version:1.0
 */
public class JieBaUtil {
    /**
     * 开始调用结巴分词
     * @param text1 文本1
     */
    public static List<String> startParticiple(String text1){
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<String> s = segmenter.sentenceProcess(text1);
        return s;
    }
}
