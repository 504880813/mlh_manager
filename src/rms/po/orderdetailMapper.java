package rms.po;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import rms.po.orderdetail;
import rms.po.orderdetailExample;

public interface orderdetailMapper {
    int countByExample(orderdetailExample example);

    int deleteByExample(orderdetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(orderdetail record);

    int insertSelective(orderdetail record);

    List<orderdetail> selectByExample(orderdetailExample example);

    orderdetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") orderdetail record, @Param("example") orderdetailExample example);

    int updateByExample(@Param("record") orderdetail record, @Param("example") orderdetailExample example);

    int updateByPrimaryKeySelective(orderdetail record);

    int updateByPrimaryKey(orderdetail record);
}