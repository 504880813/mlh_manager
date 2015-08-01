package rms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.diningTable;
import rms.po.diningTableExample;

public interface diningTableMapper {
    int countByExample(diningTableExample example);

    int deleteByExample(diningTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(diningTable record);

    int insertSelective(diningTable record);

    List<diningTable> selectByExample(diningTableExample example);

    diningTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") diningTable record, @Param("example") diningTableExample example);

    int updateByExample(@Param("record") diningTable record, @Param("example") diningTableExample example);

    int updateByPrimaryKeySelective(diningTable record);

    int updateByPrimaryKey(diningTable record);
}