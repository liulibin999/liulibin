package com.jk.controller;

import com.jk.model.Goods;
import com.jk.model.TreeBean;
import com.jk.model.User;
import com.jk.service.UserServiceFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserServiceFeign userServiceFeign;

    @RequestMapping("queryUser")
    @ResponseBody
    public List<User> queryUser(){
        List<User> userList = userServiceFeign.queryUser();
        return userList;
    }

    @RequestMapping("selectGoods")
    @ResponseBody
    public Map selectGoods(Integer page, Integer rows, HttpServletResponse response) throws IOException {

        Map map = new HashMap();
        map = userServiceFeign.selectGoods(page,rows);
        if (map==null){
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("网络异常！请稍后重试");
            printWriter.flush();
            printWriter.close();
        }
        return map;
    }

    @RequestMapping("/findMyTree")
    @ResponseBody
    public List<TreeBean> findMyTree(HttpServletResponse response) throws IOException {

        List<TreeBean> treeBeanList = userServiceFeign.findMyTree();

        if (treeBeanList == null){
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("网络异常！请稍后重试");
            printWriter.flush();
            printWriter.close();
        }

        return treeBeanList;
    }

    @RequestMapping("delGoods")
    @ResponseBody
    public void delGoods(String ids){
        userServiceFeign.delGoods(ids);
    }

    @RequestMapping("saveGoods")
    @ResponseBody
    public Boolean saveGoods(Goods goods){

        try {
            userServiceFeign.saveGoods(goods);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
