package com.jk.service;

import com.jk.model.Goods;
import com.jk.model.TreeBean;
import com.jk.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class FeignClientImpl implements UserServiceFeign {


    public List<User> queryUser() {
        return null;
    }

    public List<TreeBean> findMyTree() {
        System.out.println("树错误");
        return null;
    }

    public Map selectGoods(Integer page, Integer rows) {
        // 将数据记录mongodb或者redis
        // 等服务器恢复，将数据存储到数据库中
        System.out.println(page);
        System.out.println(rows);
        return null;
    }

    public void delGoods(String ids) {

    }

    public void saveGoods(Goods goods) {

    }
}
