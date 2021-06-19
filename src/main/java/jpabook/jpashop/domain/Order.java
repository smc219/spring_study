package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name="orders")
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id") // foreign key가 멤버가 된다.
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "delivery_id") // 이게 주인
    private Delivery delivery;
    private LocalDateTime orderDate;
    private DeliveryStatus orderStatus;

    //==연관관계 메서드==//
    // 이런식으로 연관관계들을 하나에서 둘씩 서로 묶어준다. 양방향일때 한계의 코드로 해결하는 것.
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this); // 이렇게 하나로 묶어주면 까먹을 일이 없다.
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

}
