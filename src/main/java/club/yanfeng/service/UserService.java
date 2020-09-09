package club.yanfeng.service;

import club.yanfeng.entity.User;
import club.yanfeng.entity.UserHistory;
import club.yanfeng.entity.UserIndex;

import java.util.List;

public interface UserService {
    /**
     * 登陆时查询数据库是否有该学生记录。
     */
    User validateUser(String username, String password);

    List<UserIndex> queryUserIndex(Integer currentPage, Integer dataPrePage);

    List<UserHistory> queryUserHistory(Integer currentPage, Integer dataPrePage, Integer userId);

    Integer getHistoryPages(Integer dataPrePage, Integer userId);

    List<UserHistory> queryUserApproval(Integer currentPage, Integer dataPrePage, Integer userId);

    Integer getApprovalPages(Integer dataPrePage, Integer userId);

    List<UserHistory> queryUserReading(Integer currentPage, Integer dataPrePage, Integer userId);

    Integer getReadingPages(Integer dataPrePage, Integer userId);

    List<UserHistory> queryUserAccomplish(Integer currentPage, Integer dataPrePage, Integer userId);

    Integer getAccomplishPages(Integer dataPrePage, Integer userId);
}
