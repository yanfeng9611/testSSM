package club.yanfeng.service;

public interface UpdateService {

    void borrowOperate(Integer bookId, Integer userId, String borrowTime);

    void reduceBookAvailableNum(Integer bookId);

    void addBookAvailableNum(Integer bookId);

    void retoreOperate(Integer borrowId, String returnTime);

    void repealOperate(Integer borrowId, String returnTime);
}
