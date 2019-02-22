package test;

import com.baizhi.AppRun;
import com.baizhi.dao.DepartmentDao;
import com.baizhi.entity.TDepartment;
import com.baizhi.service.DepartmentService;
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
public class TestDepartment {
    @Resource
    private DepartmentDao departmentDao;
    @Resource
    private DepartmentService departmentService;
    @Test
    public void selectByPage(){
        Map map=departmentService.selectByPage(1,3,null);
        List<TDepartment> list=(List<TDepartment>) map.get("rows");
        for (TDepartment tDepartment : list) {
            System.out.println("&&&&"+tDepartment);
        }
        int count=(int)map.get("total");
        System.out.println("***"+count);
    }
}
