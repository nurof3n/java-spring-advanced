package hw2.service;

import hw2.model.Customer;
import hw2.model.PaymentTypes;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class CheckPaymentService implements IPaymentService {
    @Override
    public void pay(Customer customer, double amount) {
        customer.pay(amount, PaymentTypes.CHECK);
    }
}
