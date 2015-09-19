package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.wechatuser;
import rms.po.wechatuserExample;
import rms.po.wechatuserWithBLOBs;

public interface wechatuserMapper {
    int countByExample(wechatuserExample example);

    int deleteByExample(wechatuserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(wechatuserWithBLOBs record);

    int insertSelective(wechatuserWithBLOBs record);

    List<wechatuserWithBLOBs> selectByExampleWithBLOBs(wechatuserExample example);

    List<wechatuser> selectByExample(wechatuserExample example);

    wechatuserWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") wechatuserWithBLOBs record, @Param("example") wechatuserExample example);

    int updateByExampleWithBLOBs(@Param("record") wechatuserWithBLOBs record, @Param("example") wechatuserExample example);

    int updateByExample(@Param("record") wechatuser record, @Param("example") wechatuserExample example);

    int updateByPrimaryKeySelective(wechatuserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(wechatuserWithBLOBs record);

    int updateByPrimaryKey(wechatuser record);
}