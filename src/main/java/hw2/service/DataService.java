package hw2.service;

import hw2.model.Customer;
import hw2.model.Order;
import hw2.repository.CustomerRepository;
import hw2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void createOrder(Order order) {
        order.setCustomer(getCustomer(order.getCustomer().getId()));
        orderRepository.save(order);
    }

    public Customer getCustomer(long id) {
        return customerRepository.getById(id);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Order getOrder(long id) {
        return orderRepository.getById(id);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }


    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }

    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}
