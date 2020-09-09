package club.yanfeng.service.impl;



import club.yanfeng.dao.UserDao;
import club.yanfeng.entity.User;
import club.yanfeng.entity.UserHistory;
import club.yanfeng.entity.UserIndex;
import club.yanfeng.service.CommonService;
import club.yanfeng.service.UpdateService;
import club.yanfeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    //    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired()
    private UserDao userDao;
    @Override
    public User validateUser(String username, String password){
        return userDao.queryUser(username, password);
    }

    @Override
    public List<UserIndex> queryUserIndex(Integer currentPage, Integer dataPrePage){
        return userDao.queryUserIndex((currentPage - 1) * CommonService.LIMIT, dataPrePage);
    }

    @Override
    public List<UserHistory> queryUserHistory(Integer currentPage, Integer dataPrePage, Integer userId){
        return userDao.queryUserHistory((currentPage - 1) * CommonService.LIMIT, dataPrePage, userId);
    }

    @Override
    public Integer getHistoryPages(Integer dataPrePage, Integer userId) {
        return userDao.getHistoryPages(dataPrePage, userId);
    }

    @Override
    public List<UserHistory> queryUserAccomplish(Integer currentPage, Integer dataPrePage,Integer userId) {
        return userDao.queryUserAccomplish((currentPage - 1) * CommonService.LIMIT, dataPrePage, userId);
    }

    @Override
    public Integer getAccomplishPages(Integer dataPrePage, Integer userId) {
        return userDao.getAccomplishPages(dataPrePage, userId);
    }

    @Override
    public List<UserHistory> queryUserReading(Integer currentPage, Integer dataPrePage, Integer userId) {
        return userDao.queryUserReading((currentPage - 1) * CommonService.LIMIT, dataPrePage, userId);
    }

    @Override
    public Integer getReadingPages(Integer dataPrePage, Integer userId) {
        return userDao.getReadingPages(dataPrePage, userId);
    }

    @Override
    public List<UserHistory> queryUserApproval(Integer currentPage, Integer dataPrePage, Integer userId) {
        return userDao.queryUserApproval((currentPage - 1) * CommonService.LIMIT, dataPrePage, userId);
    }

    @Override
    public Integer getApprovalPages(Integer dataPrePage, Integer userId) {
        return userDao.getApprovalPages(dataPrePage, userId);
    }
}

