package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.materialsRecord;
import rms.po.materialsRecordExample;

public interface materialsRecordMapper {
    int countByExample(materialsRecordExample example);

    int deleteByExample(materialsRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(materialsRecord record);

    int insertSelective(materialsRecord record);

    List<materialsRecord> selectByExample(materialsRecordExample example);

    materialsRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") materialsRecord record, @Param("example") materialsRecordExample example);

    int updateByExample(@Param("record") materialsRecord record, @Param("example") materialsRecordExample example);

    int updateByPrimaryKeySelective(materialsRecord record);

    int updateByPrimaryKey(materialsRecord record);
}