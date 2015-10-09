package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.cardLevel;
import rms.po.cardLevelExample;

public interface cardLevelMapper {
    int countByExample(cardLevelExample example);

    int deleteByExample(cardLevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(cardLevel record);

    int insertSelective(cardLevel record);

    List<cardLevel> selectByExample(cardLevelExample example);

    cardLevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") cardLevel record, @Param("example") cardLevelExample example);

    int updateByExample(@Param("record") cardLevel record, @Param("example") cardLevelExample example);

    int updateByPrimaryKeySelective(cardLevel record);

    int updateByPrimaryKey(cardLevel record);
}