package mytest;

import org.junit.Test;
import com.lamp.Check;
/**
 * @Author:lamp
 * @Date:2022/9/15 - 09 -15 -9:03
 * @Description:PACKAGE_NAME
 * @version:1.0
 */
public class test {
    Check c = new Check();
/*
    @Test
    public void test(){
        c.getRepetiveRate("D:/workspace/src/main/file/orig.txt","D:/workspace/src/main/file/orig_0.8_add.txt","D:/workspace/src/main/file/respond.txt");
    }

 */
    @Test
    public void test2(){
        c.getRepetiveRate("D:/workspace/src/main/file/orig_0.8_add.txt","D:/workspace/src/main/file/orig_0.8_del.txt","D:/workspace/src/main/file/response.txt");
    }

}
