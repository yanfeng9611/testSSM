package club.yanfeng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHistory {
    private Integer idx;
    private Integer borrowId;
    private Integer bookId;
    private String bookName;
    private String author;
    private String publish;
    private String caseName;
    private Date borrowtime;
    private Date approvalTime;
    private Date returntime;
    private String state;
}
