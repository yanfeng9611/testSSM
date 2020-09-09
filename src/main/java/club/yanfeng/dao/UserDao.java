package club.yanfeng.dao;

import club.yanfeng.entity.User;
import club.yanfeng.entity.UserHistory;
import club.yanfeng.entity.UserIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 向数据库验证输入的密码是否正确
     */
    User queryUser(@Param("username") String username, @Param("password") String password);

    List<UserIndex> queryUserIndex(@Param("currentPage") Integer currentPage, @Param("dataPrePage") Integer dataPrePage);

    List<UserHistory> queryUserHistory(@Param("currentPage") Integer currentPage, @Param("dataPrePage") Integer dataPrePage, @Param("userId") Integer userId);

    Integer getHistoryPages(@Param("dataPrePage") Integer dataPrePage, @Param("userId") Integer userId);

    List<UserHistory> queryUserApproval(@Param("currentPage") Integer currentPage, @Param("dataPrePage") Integer dataPrePage, @Param("userId") Integer userId);

    Integer getApprovalPages(@Param("dataPrePage") Integer dataPrePage, @Param("userId") Integer userId);

    List<UserHistory> queryUserReading(@Param("currentPage") Integer currentPage, @Param("dataPrePage") Integer dataPrePage, @Param("userId") Integer userId);

    Integer getReadingPages(@Param("dataPrePage") Integer dataPrePage, @Param("userId") Integer userId);

    List<UserHistory> queryUserAccomplish(@Param("currentPage") Integer currentPage, @Param("dataPrePage") Integer dataPrePage, @Param("userId") Integer userId);

    Integer getAccomplishPages(@Param("dataPrePage") Integer dataPrePage, @Param("userId") Integer userId);

}
