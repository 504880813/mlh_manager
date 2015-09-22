package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.card;
import rms.po.cardExample;

public interface cardMapper {
    int countByExample(cardExample example);

    int deleteByExample(cardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(card record);

    int insertSelective(card record);

    List<card> selectByExample(cardExample example);

    card selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") card record, @Param("example") cardExample example);

    int updateByExample(@Param("record") card record, @Param("example") cardExample example);

    int updateByPrimaryKeySelective(card record);

    int updateByPrimaryKey(card record);
}