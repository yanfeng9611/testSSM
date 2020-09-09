package club.yanfeng.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommonDao {
    Integer getBookPages(@Param("dataPrePage") Integer dataPrePage);
}
