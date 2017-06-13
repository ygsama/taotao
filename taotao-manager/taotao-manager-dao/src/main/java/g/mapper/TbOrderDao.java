package g.mapper;

import g.pojo.TbOrder;
import g.pojo.TbOrderQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderDao {
    int countByExample(TbOrderQuery example);

    int deleteByExample(TbOrderQuery example);

    int deleteByPrimaryKey(String orderId);

    int insert(TbOrder record);

    int insertSelective(TbOrder record);

    List<TbOrder> selectByExample(TbOrderQuery example);

    TbOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") TbOrder record, @Param("example") TbOrderQuery example);

    int updateByExample(@Param("record") TbOrder record, @Param("example") TbOrderQuery example);

    int updateByPrimaryKeySelective(TbOrder record);

    int updateByPrimaryKey(TbOrder record);
}