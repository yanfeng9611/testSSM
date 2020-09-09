package club.yanfeng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String bookName;
    private String author;
    private String publish;
    private Date publicationTime;
    private String bookCase;
    private Integer pages;
    private Double price;
    private Integer availableQuantity;
    private Integer totalQuantity;
}
