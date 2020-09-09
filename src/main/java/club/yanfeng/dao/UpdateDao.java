package club.yanfeng.dao;

import club.yanfeng.entity.UserHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

@Mapper
public interface UpdateDao {



    void borrowOperate(@Param("bookId") Integer bookId, @Param("userId") Integer userId, @Param("borrowTime") String borrowTime);

    void reduceBookAvailableNum(@Param("bookId") Integer bookId);

    void addBookAvailableNum(@Param("bookId") Integer bookId);

    void restoreOperate(@Param("borrowId") Integer borrowId, @Param("returnTime") String returnTime);

    void repealOperate(@Param("borrowId") Integer borrowId, @Param("returnTime") String returnTime);

}
