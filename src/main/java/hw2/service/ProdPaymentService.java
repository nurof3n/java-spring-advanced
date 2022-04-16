package hw2.service;

import hw2.model.Customer;
import hw2.model.PaymentTypes;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdPaymentService implements IPaymentService {
    // over this threshold we will use credit card for the payment
    private static final double BALANCE_THRESHOLD = 50.0;

    @Override
    public void pay(Customer customer, double amount) {
        if (amount > BALANCE_THRESHOLD) {
            customer.pay(amount, PaymentTypes.CREDIT_CARD);
        } else {
            customer.pay(amount, PaymentTypes.CASH);
        }
    }
}
