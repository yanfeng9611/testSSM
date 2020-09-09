package club.yanfeng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminIndex {
    private Integer idx;
    private String bookName;
    private String author;
    private String publish;
    private String caseName;
    private Date publicationTime;
    private Integer pages;
    private Float price;
    private Integer availableQuantity;
    private Integer totalQuantity;
}
