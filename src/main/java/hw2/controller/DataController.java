package hw2.controller;

import hw2.model.Customer;
import hw2.model.Order;
import hw2.service.DataService;
import hw2.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataController {
    @Autowired
    private DataService dataService;
    @Autowired
    private IPaymentService paymentService;

    @PostMapping("/create/customer")
    public void createCustomer(@RequestBody Customer customer) {
        dataService.createCustomer(customer);
    }

    @PostMapping("/create/order")
    public void createOrder(@RequestBody Order order) {
        dataService.createOrder(order);
        // call the payment service
        paymentService.pay(order.getCustomer(), order.getPrice());
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return dataService.getCustomers();
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return dataService.getOrders();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable long id) {
        return dataService.getCustomer(id);
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable long id) {
        return dataService.getOrder(id);
    }

    @PutMapping("/update/customer")
    public void updateCustomer(@RequestBody Customer customer) {
        dataService.updateCustomer(customer);
    }

    @PutMapping("/update/order")
    public void updateOrder(Order order) {
        dataService.updateOrder(order);
    }

    @DeleteMapping("/delete/customer/{id}")
    public void deleteCustomer(@PathVariable long id) {
        dataService.deleteCustomer(id);
    }

    @DeleteMapping("/delete/order/{id}")
    public void deleteOrder(@PathVariable long id) {
        dataService.deleteOrder(id);
    }

    @DeleteMapping("/delete/customers")
    public void deleteCustomers() {
        dataService.deleteAllCustomers();
    }

    @DeleteMapping("/delete/orders")
    public void deleteOrders() {
        dataService.deleteAllOrders();
    }
}
