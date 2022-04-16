package hw2.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private long id;
    private double price;

    @ManyToOne
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return id != 0 ? (int) (id ^ (id >>> 32)) : super.hashCode();
    }
}
