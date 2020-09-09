package club.yanfeng.service;

import club.yanfeng.entity.Admin;
import club.yanfeng.entity.AdminHistory;
import club.yanfeng.entity.AdminIndex;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
    /**
     * 登陆时查询数据库是否有该学生记录。
     */
    Admin validateAdm(String username, String password);

    List<AdminIndex> queryAdminIndex(Integer currentPage, Integer dataPrePage);

    List<AdminHistory> queryAdminHistory(Integer currentPage, Integer dataPrePage, Integer userId);

    Integer getHistoryPages(Integer dataPrePage, Integer userId);

    List<AdminHistory> queryApply(Integer currentPage, Integer dataPrePage);

    Integer getApplyPages(Integer dataPrePage);

    void queryApproval(Integer borrowId, Integer adminId, String approvalTime);

    void queryRefuse(Integer borrowId, Integer adminId, String approvalTime);
}
