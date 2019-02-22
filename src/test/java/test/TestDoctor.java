package test;

import com.baizhi.AppRun;
import com.baizhi.dao.DoctorDao;
import com.baizhi.entity.TDoctor;
import com.baizhi.service.DoctorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppRun.class)
public class TestDoctor {
    @Resource
    private DoctorService doctorService;
    @Resource
    private DoctorDao doctorDao;

    @Test
    public void getDoctor(){
        TDoctor tDoctor=new TDoctor();
        tDoctor.setUsername("小臭臭");
        tDoctor.setPassword("123456");
        TDoctor tDoctor1=doctorDao.getDoctor(tDoctor);
        System.out.println("++++"+tDoctor1);
    }

    @Test
    public void insertDoctor(){
        TDoctor tDoctor=new TDoctor();
        tDoctor.setUsername("小花花");
        tDoctor.setPassword("123456");
        tDoctor.setRealname("谢放放");
        tDoctor.setSex(0);
        tDoctor.setMobile("155");
        tDoctor.setEmail("944521712@qq.com");
        tDoctor.setPic("E://服务器/1.jsp");
        tDoctor.setDeptId(101);
        doctorService.insertDoctor(tDoctor);

    }
}
