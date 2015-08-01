package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.materials;
import rms.po.materialsExample;

public interface materialsMapper {
    int countByExample(materialsExample example);

    int deleteByExample(materialsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(materials record);

    int insertSelective(materials record);

    List<materials> selectByExample(materialsExample example);

    materials selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") materials record, @Param("example") materialsExample example);

    int updateByExample(@Param("record") materials record, @Param("example") materialsExample example);

    int updateByPrimaryKeySelective(materials record);

    int updateByPrimaryKey(materials record);
}