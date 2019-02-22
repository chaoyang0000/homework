package com.baizhi.aspect;

import com.baizhi.annotation.ServiceLog;
import com.baizhi.dao.AdminLogDao;
import com.baizhi.entity.CmfzAdminLog;
import com.baizhi.entity.CmfzUser;
import com.baizhi.utils.IPKit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {
    @Resource
    private AdminLogDao adminLogDao;
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 切到方法上
     */
    @Pointcut("@annotation(com.baizhi.annotation.ServiceLog)")
    public void testLog(){}

    @Around("testLog()")
    public Object testLogAdd(ProceedingJoinPoint proceedingJoinPoint){
        CmfzAdminLog cmfzAdminLog=new CmfzAdminLog();
        //1.获取正在执行的方法 的方法对象
        MethodSignature signature=(MethodSignature) proceedingJoinPoint.getSignature();
        Method method=signature.getMethod();
        //2.通过方法对象获取方法上的注解对象
        ServiceLog annotation = method.getAnnotation(ServiceLog.class);
        //3.获取注解的值
        String value=annotation.value();

        //获取request
        ServletRequestAttributes requestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=requestAttributes.getRequest();

        //通过request和工具类得到ip
        String ip= IPKit.getIpAddrByRequest(request);

        //由于没登录页面用一个用户对象测试把数据写死
        CmfzUser cmfzUser=new CmfzUser();
        cmfzUser.setUserId(1);
        cmfzUser.setName("小花");
        try {
            Object proceed = proceedingJoinPoint.proceed();
            //        3.通过request可以得到session
            //        4.通过session可以得到session中的信息 id 和 用户名
//            封装对象
            cmfzAdminLog.setLogAction(value);
            cmfzAdminLog.setLogDate(new Date());
            cmfzAdminLog.setLogIp(ip);
            cmfzAdminLog.setAdminId(cmfzUser.getUserId());
            cmfzAdminLog.setAdminUsername(cmfzUser.getName());
            cmfzAdminLog.setLogResult("成功");
            //添加数据库
            adminLogDao.insert(cmfzAdminLog);
            logger.info("操作成功:"+cmfzAdminLog);
            return proceed;
        } catch (Throwable throwable) {
            logger.error("操作失败");
            return null;
        }




    }

}
