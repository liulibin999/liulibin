package com.jk.service;

import com.jk.model.Goods;
import com.jk.model.TreeBean;
import com.jk.model.User;

import java.util.List;
import java.util.Map;

public interface UserService1 {

    List<User> queryUser();

    List<TreeBean> findMyTree();

    Map selectGoods(Integer page, Integer rows);

    void delGoods(String ids);

    void saveGoods(Goods goods);
}
