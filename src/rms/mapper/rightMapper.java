package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.right;
import rms.po.rightExample;

public interface rightMapper {
    int countByExample(rightExample example);

    int deleteByExample(rightExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(right record);

    int insertSelective(right record);

    List<right> selectByExample(rightExample example);

    right selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") right record, @Param("example") rightExample example);

    int updateByExample(@Param("record") right record, @Param("example") rightExample example);

    int updateByPrimaryKeySelective(right record);

    int updateByPrimaryKey(right record);
}