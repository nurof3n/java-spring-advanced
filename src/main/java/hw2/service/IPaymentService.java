package hw2.service;

import hw2.model.Customer;

public interface IPaymentService {
    public void pay(Customer customer, double amount);
}
