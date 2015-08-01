package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.dish;
import rms.po.dishExample;

public interface dishMapper {
    int countByExample(dishExample example);

    int deleteByExample(dishExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(dish record);

    int insertSelective(dish record);

    List<dish> selectByExample(dishExample example);

    dish selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") dish record, @Param("example") dishExample example);

    int updateByExample(@Param("record") dish record, @Param("example") dishExample example);

    int updateByPrimaryKeySelective(dish record);

    int updateByPrimaryKey(dish record);
}