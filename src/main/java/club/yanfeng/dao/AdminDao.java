package club.yanfeng.dao;

import club.yanfeng.entity.Admin;
import club.yanfeng.entity.AdminHistory;
import club.yanfeng.entity.AdminIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminDao {
    /**
     * 向数据库验证输入的密码是否正确
     */
    Admin queryAdmin(@Param("username") String username, @Param("password") String password);

    List<AdminIndex> queryAdminIndex(@Param("currentPage") Integer currentPage, @Param("dataPrePage") Integer dataPrePage);

    List<AdminHistory> queryAdminHistory(@Param("currentPage") Integer currentPage, @Param("dataPrePage") Integer dataPrePage, @Param("userId") Integer userId);

    Integer getHistoryPages(@Param("dataPrePage") Integer dataPrePage, @Param("userId") Integer userId);

    List<AdminHistory> queryApply(@Param("currentPage") Integer currentPage, @Param("dataPrePage") Integer dataPrePage);

    Integer getApplyPages(@Param("dataPrePage") Integer dataPrePage);

    void queryApproval(@Param("borrowId") Integer borrowId, @Param("adminId") Integer adminId, @Param("approvalTime") String approvalTime);

    void queryRefuse(@Param("borrowId") Integer borrowId,  @Param("adminId") Integer adminId, @Param("approvalTime") String approvalTime);
}
