package rms.po;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.wechatTemplate;
import rms.po.wechatTemplateExample;

public interface wechatTemplateMapper {
    int countByExample(wechatTemplateExample example);

    int deleteByExample(wechatTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(wechatTemplate record);

    int insertSelective(wechatTemplate record);

    List<wechatTemplate> selectByExample(wechatTemplateExample example);

    wechatTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") wechatTemplate record, @Param("example") wechatTemplateExample example);

    int updateByExample(@Param("record") wechatTemplate record, @Param("example") wechatTemplateExample example);

    int updateByPrimaryKeySelective(wechatTemplate record);

    int updateByPrimaryKey(wechatTemplate record);
}