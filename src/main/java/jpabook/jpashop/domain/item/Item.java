package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.domain.exceptions.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype") // dtype으로 구분을 해주는데, 이걸 이제 상속 받은 애들한테 설정해주자.
@Getter @Setter
public class Item {

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    public void addItems(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeItems(int quantity) {
        int restItems = this.stockQuantity - quantity;
        if (restItems < 0) {
            throw new NotEnoughStockException("Not Enough Stocks");
        }
        this.stockQuantity = restItems;
    }

}
