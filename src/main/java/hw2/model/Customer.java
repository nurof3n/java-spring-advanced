package hw2.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@ToString
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @Transient
    private Map<PaymentTypes, Double> balanceMap;

    @OneToMany
    @ToString.Exclude
    List<Order> orders;

    public Customer() {
        // populate balanceMap with some money for each payment type
        balanceMap = new HashMap<>();
        balanceMap.put(PaymentTypes.CASH, 100.0);
        balanceMap.put(PaymentTypes.CREDIT_CARD, 100.0);
        balanceMap.put(PaymentTypes.CHECK, 100.0);
    }

    public void pay(double amount, PaymentTypes paymentType) {
        double balance = balanceMap.get(paymentType);
        if (balance < amount) {
            throw new IllegalArgumentException("Not enough money");
        }
        balance -= amount;
        balanceMap.put(paymentType, balance);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return id != 0 ? (int) (id ^ (id >>> 32)) : super.hashCode();
    }
}
