package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.wechatuser;
import rms.po.wechatuserExample;

public interface wechatuserMapper {
    int countByExample(wechatuserExample example);

    int deleteByExample(wechatuserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(wechatuser record);

    int insertSelective(wechatuser record);

    List<wechatuser> selectByExample(wechatuserExample example);

    wechatuser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") wechatuser record, @Param("example") wechatuserExample example);

    int updateByExample(@Param("record") wechatuser record, @Param("example") wechatuserExample example);

    int updateByPrimaryKeySelective(wechatuser record);

    int updateByPrimaryKey(wechatuser record);
}