package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.wechatInterface;
import rms.po.wechatInterfaceExample;

public interface wechatInterfaceMapper {
    int countByExample(wechatInterfaceExample example);

    int deleteByExample(wechatInterfaceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(wechatInterface record);

    int insertSelective(wechatInterface record);

    List<wechatInterface> selectByExample(wechatInterfaceExample example);

    wechatInterface selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") wechatInterface record, @Param("example") wechatInterfaceExample example);

    int updateByExample(@Param("record") wechatInterface record, @Param("example") wechatInterfaceExample example);

    int updateByPrimaryKeySelective(wechatInterface record);

    int updateByPrimaryKey(wechatInterface record);
}