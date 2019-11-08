package com.jk.service;

import com.jk.model.Goods;
import com.jk.model.TreeBean;
import com.jk.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "PROVIDER-USER",fallback = FeignClientImpl.class)
public interface UserServiceFeign {

    @GetMapping("queryUser")
    List<User> queryUser();

    @GetMapping("findMyTree")
    List<TreeBean> findMyTree();

    @GetMapping("selectGoods")
    Map selectGoods(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);

    @DeleteMapping("delGoods")
    void delGoods(@RequestParam("ids") String ids);

    @PostMapping("saveGoods")
    void saveGoods(@SpringQueryMap Goods goods);
}
