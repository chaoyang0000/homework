package test;

import com.baizhi.AppRun;
import com.baizhi.dao.PatientDao;
import com.baizhi.entity.TPatient;
import com.baizhi.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppRun.class)
public class TestPatient {
    @Resource
    private PatientDao patientDao;
    @Resource
    private PatientService patientService;
    @Test
    public void selectByPage(){
        Map map=patientService.selectByPage(1,3,null);
        List<TPatient> list=(List<TPatient>) map.get("rows");
        for (TPatient tPatient : list) {
            System.out.println("++++++"+tPatient);
        }
        int count=(int)map.get("total");
        System.out.println("***********"+count);
    }

    @Test
    public void insertPatient(){
        TPatient tPatient=new TPatient();
        tPatient.setName("小花胡");
        tPatient.setSex(1);
        tPatient.setIdcard("4128518458556");
        tPatient.setAddress("大王庄");
        tPatient.setMobile("555");

        patientService.insertPatient(tPatient);
    }
}
