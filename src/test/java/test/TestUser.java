package test;

import com.baizhi.dao.AdminLogDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.CmfzAdminLog;
import com.baizhi.entity.CmfzUser;
import com.baizhi.entity.UserDTO;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.utils.PlaceUtil;
import com.google.gson.Gson;
import io.goeasy.GoEasy;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestUser extends TestDoctor {
    @Resource
    private UserDao userDao;
    @Resource
    private AdminLogDao adminLogDao;
    @Resource
    private UserService userService;
    @Test
    public void getAllSexCount(){
        Map map=userDao.getAllSexCount();


        System.out.println("****"+map.get("nan")+"****"+map.get("nv"));

    }

    @Test
    public void getAllUserCount(){
        Map map=userDao.getAllUserCount();
        System.out.println("****"+map.get("c1")+map.get("c2")+map.get("c3"));
    }

    @Test
    public void getAllProvinceCity(){
        List<UserDTO> list=userDao.getAllProvinceCity();
        for (UserDTO userDTO : list) {

            System.out.println("****"+list);
        }
    }

    @Test
    public void insert(){
        for (int i = 0; i <200 ; i++) {
            CmfzUser cmfzUser=PlaceUtil.getUser();
            userDao.insert(cmfzUser);
            //获取数据
            Map map=userService.getAllDate1();
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
@Test
    public  void insert1(){
        CmfzAdminLog cmfzAdminLog=new CmfzAdminLog();
        cmfzAdminLog.setAdminUsername("这个展示数据系统");
        cmfzAdminLog.setLogAction("查询了全部数据");
        cmfzAdminLog.setLogDate(new Date());
        cmfzAdminLog.setLogIp("0.0");
        cmfzAdminLog.setLogResult("成功");
        adminLogDao.insert(cmfzAdminLog);
    }


}
