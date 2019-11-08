package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.Goods;
import com.jk.model.TreeBean;
import com.jk.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class UserServiceImpl implements UserService1 {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryUser() {
        return userMapper.queryUser();
    }



    @Override
    public Map selectGoods(Integer page, Integer rows) {

        HashMap<String, Object> result = new HashMap<>();

        HashMap<String, Object> params = new HashMap<>();

        int count = userMapper.findGoodsListCount();
        result.put("total",count);

        params.put("start",(page-1)*rows);
        params.put("end",rows);

        List<Goods> goods = userMapper.findGoodsList(params);
        result.put("rows",goods);
        return result;
    }

    @Override
    public void delGoods(String ids) {
        userMapper.delGoods(ids);
    }

    @Override
    public void saveGoods(Goods goods) {
        userMapper.saveGoods(goods);
    }

    @Override
    public List<TreeBean> findMyTree() {
        Integer id =0;
        return treeNode(id);
    }

    private List<TreeBean> treeNode(Integer id) {
        List<TreeBean> trees = userMapper.findTreeNodeList(id);
        for (TreeBean treeBean: trees) {
            Integer id2 = treeBean.getId();
            List<TreeBean> treeBeans = treeNode(id2);
            if (treeBeans != null && treeBeans.size()>0){
                treeBean.setNodes(treeBeans);
            }else{
                treeBean.setSelectable(true);
            }
        }
        return trees;
    }
}
