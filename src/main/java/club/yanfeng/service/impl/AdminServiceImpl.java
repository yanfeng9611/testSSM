package club.yanfeng.service.impl;

import club.yanfeng.dao.AdminDao;
import club.yanfeng.entity.Admin;
import club.yanfeng.entity.AdminHistory;
import club.yanfeng.entity.AdminIndex;
import club.yanfeng.service.AdminService;
import club.yanfeng.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired()
    private AdminDao adminDao;

    @Override
    public Admin validateAdm(String username, String password){
        return adminDao.queryAdmin(username, password);
    }

    @Override
    public List<AdminIndex> queryAdminIndex(Integer currentPage, Integer dataPrePage){
        return adminDao.queryAdminIndex((currentPage - 1) * CommonService.LIMIT, dataPrePage);
    }

    @Override
    public List<AdminHistory> queryAdminHistory(Integer currentPage, Integer dataPrePage, Integer userId){
        return adminDao.queryAdminHistory((currentPage - 1) * CommonService.LIMIT, dataPrePage, userId);
    }

    @Override
    public Integer getHistoryPages(Integer dataPrePage, Integer userId) {
        return adminDao.getHistoryPages(dataPrePage, userId);
    }

    @Override
    public List<AdminHistory> queryApply(Integer currentPage, Integer dataPrePage) {
        return adminDao.queryApply((currentPage - 1) * CommonService.LIMIT, dataPrePage);
    }

    @Override
    public Integer getApplyPages(Integer dataPrePage) {
        return adminDao.getApplyPages(dataPrePage);
    }

    @Override
    public void queryApproval(Integer borrowId, Integer adminId, String approvalTime) {
        adminDao.queryApproval(borrowId, adminId, approvalTime);
    }

    @Override
    public void queryRefuse(Integer borrowId, Integer adminId,String approvalTime) {
        adminDao.queryRefuse(borrowId, adminId, approvalTime);
    }
}
