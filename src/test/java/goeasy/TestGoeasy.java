package goeasy;

import com.baizhi.dao.UserDao;
import com.google.gson.Gson;
import io.goeasy.GoEasy;
import org.junit.Test;
import test.TestUser;

import javax.annotation.Resource;
import java.lang.annotation.Target;
import java.util.Map;

public class TestGoeasy extends TestUser {
    @Resource
    private UserDao userDao;

    @Test
    public void test1(){
        //获取数据
    Map map=userDao.getAllUserCount();
    //把数据转化为json串
    Gson gson=new Gson();
    String s = gson.toJson(map);
    //创建GoEasy对象
    GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io", "BC-2ad959660db34f92aa7f01cdce6cd947");


    // 4.推送信息
    /**
     * channel 通道 频道的名字
     * content 要发布的内容
     */
        goEasy.publish("cmfzChannel", s);
}

}
