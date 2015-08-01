package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.category;
import rms.po.categoryExample;

public interface categoryMapper {
    int countByExample(categoryExample example);

    int deleteByExample(categoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(category record);

    int insertSelective(category record);

    List<category> selectByExample(categoryExample example);

    category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") category record, @Param("example") categoryExample example);

    int updateByExample(@Param("record") category record, @Param("example") categoryExample example);

    int updateByPrimaryKeySelective(category record);

    int updateByPrimaryKey(category record);
}