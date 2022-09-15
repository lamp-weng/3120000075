package com.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author:lamp
 * @Date:2022/9/15 - 09 -15 -0:30
 * @Description:com.Utils
 * @version:1.0
 */
public class GetSimilarityUtil {

    Map<String, int[]> vectorMap = new HashMap<String, int[]>();//字符串：数组 "abc":[0]

    int[] tempArray = null;//数组tempArray


    /**
     * 构造器 在这里面分词
     * @param str1 文本1
     * @param str2 文本2
     */
    public GetSimilarityUtil(String str1, String str2) {

        ArrayList<String> list1 = new ArrayList<>();


        for (String s : JieBaUtil.startParticiple(str1)) {
            if (vectorMap.containsKey(s)) {//是否包含关键字s
                vectorMap.get(s)[0]++;
            } else {
                tempArray = new int[2];
                tempArray[0] = 1;
                tempArray[1] = 0;
                vectorMap.put(s, tempArray);
            }
        }
        for (String s2 : JieBaUtil.startParticiple(str2)) {
            if (vectorMap.containsKey(s2)) {
                vectorMap.get(s2)[1]++;
            } else {
                tempArray = new int[2];
                tempArray[0] = 0;
                tempArray[1] = 1;
                vectorMap.put(s2, tempArray);
            }
        }
    }

    /**
     *  求平方和
     * @param paramMap 键值对，记录词组的数量
     * @return 返回词组平方乘积开根号
     */

    //平方相乘开根号
    private double sqrtMulti(Map<String, int[]> paramMap) {
        double result1 = 0;
        double result2 = 0;
        Set<String> keySet = paramMap.keySet();
        for (String character : keySet) {
            int temp[] = paramMap.get(character);
            result1 += (temp[0] * temp[0]);
            result2 += (temp[1] * temp[1]);
        }
//        return result1 * result2;
        double result = 0;
        result = result1 * result2;
        result = Math.sqrt(result);
        return result;
    }

    // 点乘法
    private double pointMulti(Map<String, int[]> paramMap) {
        double result = 0;
        Set<String> keySet = paramMap.keySet();
        for (String character : keySet) {
            int temp[] = paramMap.get(character);
            result += (temp[0] * temp[1]);
        }
        return result;
    }
    // 求余弦相似度
    public double sim() {
        double result = 0;
        result = pointMulti(vectorMap) / sqrtMulti(vectorMap);
        return result;
    }
}
