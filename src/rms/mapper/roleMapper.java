package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.role;
import rms.po.roleExample;

public interface roleMapper {
    int countByExample(roleExample example);

    int deleteByExample(roleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(role record);

    int insertSelective(role record);

    List<role> selectByExample(roleExample example);

    role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") role record, @Param("example") roleExample example);

    int updateByExample(@Param("record") role record, @Param("example") roleExample example);

    int updateByPrimaryKeySelective(role record);

    int updateByPrimaryKey(role record);
}