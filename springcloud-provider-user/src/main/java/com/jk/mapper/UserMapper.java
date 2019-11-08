package com.jk.mapper;

import com.jk.model.Goods;
import com.jk.model.TreeBean;
import com.jk.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from t_feignUser")
    List<User> queryUser();

    @Select("select id,url as path,pid,text from t_power where pid = #{value}")
    List<TreeBean> findTreeNodeList(Integer id);

    @Select("select count(1) from t_goods")
    int findGoodsListCount();

    @Select("select * from t_goods limit #{start},#{end}")
    List<Goods> findGoodsList(HashMap<String, Object> params);

    @Delete("delete from t_goods where goodId in (#{ids})")
    void delGoods(String ids);

    @Insert("insert into t_goods(goodName,goodPrice) values(#{goodName},#{goodPrice})")
    void saveGoods(Goods goods);
}
