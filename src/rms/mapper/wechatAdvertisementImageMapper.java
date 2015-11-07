package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.wechatAdvertisementImage;
import rms.po.wechatAdvertisementImageExample;

public interface wechatAdvertisementImageMapper {
    int countByExample(wechatAdvertisementImageExample example);

    int deleteByExample(wechatAdvertisementImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(wechatAdvertisementImage record);

    int insertSelective(wechatAdvertisementImage record);

    List<wechatAdvertisementImage> selectByExample(wechatAdvertisementImageExample example);

    wechatAdvertisementImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") wechatAdvertisementImage record, @Param("example") wechatAdvertisementImageExample example);

    int updateByExample(@Param("record") wechatAdvertisementImage record, @Param("example") wechatAdvertisementImageExample example);

    int updateByPrimaryKeySelective(wechatAdvertisementImage record);

    int updateByPrimaryKey(wechatAdvertisementImage record);
}