package test;

import com.baizhi.AppRun;
import com.baizhi.dao.DrugDao;
import com.baizhi.entity.TDrug;
import com.baizhi.service.DrugService;
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
public class TestDrug {
    @Resource
    private DrugDao drugDao;
    @Autowired
    private DrugService drugService;

    @Test
    public void selectByPage(){
        Map map=drugService.selectByPage(1,3,null);
        List<TDrug> list=(List<TDrug>) map.get("rows");
        int count=(int)map.get("total");
        for (TDrug tDrug : list) {
            System.out.println("++++++"+tDrug);
        }
        System.out.println("____"+count);
    }

    @Test
    public void updateStatus(){
        drugService.updateSaleStatus(0,101);
    }
    @Test
    public void getAllExamAndDrug(){
        List<TDrug> list=drugService.getAllExamAndDrug();
        for (TDrug tDrug : list) {
            System.out.println(tDrug);
        }
    }
}
