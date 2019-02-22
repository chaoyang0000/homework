package com.baizhi.service.impl;

import com.baizhi.annotation.ServiceLog;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.UserDTO;
import com.baizhi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    /**
     * IO密集型任务  （常出现于线程中：数据库数据交互、文件上传下载、网络数据传输等等 能够体现多核处理器的优势）
     * CPU密集型任务 (常出现于线程中：复杂算法 能体现CPU版本的优势）
     *
     */
    private static int corePoolSize = Runtime.getRuntime().availableProcessors();
    /**
     * public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,
     *                           TimeUnit unit,BlockingQueue<Runnable> workQueue)
     * corePoolSize用于指定核心线程数量
     * maximumPoolSize指定最大线程数
     * keepAliveTime和TimeUnit指定线程空闲后的最大存活时间
     * workQueue则是线程池的缓冲队列,还未执行的线程会在队列中等待
     * 监控队列长度，确保队列有界
     * 不当的线程池大小会使得处理速度变慢，稳定性下降，并且导致内存泄露。如果配置的线程过少，则队列会持续变大，消耗过多内存。
     * 而过多的线程又会 由于频繁的上下文切换导致整个系统的速度变缓——殊途而同归。队列的长度至关重要，它必须得是有界的，这样如果线程池不堪重负了它可以暂时拒绝掉新的请求。
     * ExecutorService 默认的实现是一个无界的 LinkedBlockingQueue。
     */
    private static ThreadPoolExecutor executor  = new ThreadPoolExecutor(corePoolSize, corePoolSize+1, 10l, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1000));

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Override
    @ServiceLog("查询男女各多少人")
    public Map getAllSexCount() {
        Map map=userDao.getAllSexCount();
        return map;
    }

    @Override
    @ServiceLog("查询用户注册量")
    public Map getAllUserCount() {
        Map map=userDao.getAllUserCount();
        return map;
    }

    @Override
    @ServiceLog("查询各个省份的注册人数")
    public List<UserDTO> getAllProvinceCity() {
        List<UserDTO> list=userDao.getAllProvinceCity();
        return list;
    }

    @Override
    public Map getAllDate() {
        Map map=new HashMap();
        Map map1= getAllSexCount();
        Map map2=getAllUserCount();
        List<UserDTO> list=getAllProvinceCity();
        map.put("sex",map1);
        map.put("count",map2);
        map.put("map",list);

        return map;
    }

    @Override
    @ServiceLog("执行了这个查询全部的方法")
    public Map getAllDate1() {
        final Map map=new HashMap();
        //创建三个线程的计数器
        final CountDownLatch countDownLatch=new CountDownLatch(3);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Map map1=getAllSexCount();
                map.put("sex",map1);
                //执行完计数器减一
                countDownLatch.countDown();
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Map map2=getAllUserCount();
                map.put("user",map2);
                //执行完计数器减一
                countDownLatch.countDown();
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<UserDTO> list=getAllProvinceCity();
                map.put("map",list);
                //执行完计数器减一
                countDownLatch.countDown();
            }
        });
        //        3.主线程等待其他线程执行完
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map;
    }
}
