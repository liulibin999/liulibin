package com.jk.controller;

import com.jk.model.Goods;
import com.jk.model.TreeBean;
import com.jk.model.User;
import com.jk.service.UserService1;
import com.jk.service.UserServiceFeign;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class UserController implements UserServiceFeign {

    @Resource
    private UserService1 userService;


    @GetMapping("queryUser")
    @Override
    public List<User> queryUser() {
        return userService.queryUser();
    }

    @GetMapping("findMyTree")
    @Override
    public List<TreeBean> findMyTree() {

        return userService.findMyTree();
    }

    @GetMapping("selectGoods")
    @Override
    public Map selectGoods(@RequestParam ("page")Integer page, @RequestParam("rows") Integer rows) {
        return userService.selectGoods(page,rows);
    }

    @Override
    @DeleteMapping("delGoods")
    public void delGoods(@RequestParam("ids") String ids) {
        userService.delGoods(ids);
    }

    @Override
    @PostMapping("saveGoods")
    public void saveGoods(@SpringQueryMap Goods goods) {
        userService.saveGoods(goods);
    }


}
