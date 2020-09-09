package club.yanfeng.service.impl;

import club.yanfeng.dao.UpdateDao;
import club.yanfeng.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    UpdateDao updateDao;

    @Override
    public void repealOperate(Integer borrowId, String returnTime) {
        updateDao.repealOperate(borrowId, returnTime);
    }

    @Override
    public void retoreOperate(Integer borrowId, String returnTime) {
        updateDao.restoreOperate(borrowId, returnTime);
    }

    @Override
    public void borrowOperate(Integer bookId, Integer userId, String borrowTime) {
        updateDao.borrowOperate(bookId, userId, borrowTime);
    }

    @Override
    public void reduceBookAvailableNum(Integer bookId) {
        updateDao.reduceBookAvailableNum(bookId);
    }

    @Override
    public void addBookAvailableNum(Integer bookId) {
        updateDao.addBookAvailableNum(bookId);
    }
}
