package club.yanfeng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminHistory {
    private Integer idx;
    private Integer borrowId;
    private String bookName;
    private String author;
    private String publish;
    private String caseName;
    private String username;
    private Date borrowtime;
    private Date approvalTime;
    private Date returntime;
    private String state;
}
