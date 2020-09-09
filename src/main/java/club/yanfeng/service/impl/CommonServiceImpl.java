package club.yanfeng.service.impl;

import club.yanfeng.dao.CommonDao;
import club.yanfeng.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired()
    CommonDao commonDao;
    @Override
    public Integer getBookPages(Integer dataPrePage) {
        return commonDao.getBookPages(dataPrePage);
    }
}
