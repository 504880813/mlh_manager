package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.cardRecord;
import rms.po.cardRecordExample;

public interface cardRecordMapper {
    int countByExample(cardRecordExample example);

    int deleteByExample(cardRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(cardRecord record);

    int insertSelective(cardRecord record);

    List<cardRecord> selectByExample(cardRecordExample example);

    cardRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") cardRecord record, @Param("example") cardRecordExample example);

    int updateByExample(@Param("record") cardRecord record, @Param("example") cardRecordExample example);

    int updateByPrimaryKeySelective(cardRecord record);

    int updateByPrimaryKey(cardRecord record);
}