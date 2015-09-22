package rms.po;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.dishImage;
import rms.po.dishImageExample;

public interface dishImageMapper {
    int countByExample(dishImageExample example);

    int deleteByExample(dishImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(dishImage record);

    int insertSelective(dishImage record);

    List<dishImage> selectByExample(dishImageExample example);

    dishImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") dishImage record, @Param("example") dishImageExample example);

    int updateByExample(@Param("record") dishImage record, @Param("example") dishImageExample example);

    int updateByPrimaryKeySelective(dishImage record);

    int updateByPrimaryKey(dishImage record);
}