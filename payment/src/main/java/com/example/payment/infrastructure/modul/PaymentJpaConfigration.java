package com.example.payment.infrastructure.modul;

import com.example.payment.domain.PaymentStatusPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentJpaConfigration {
    @Bean
    public PaymentStatusPort getCoursePort (PaymentRepository repository){

        return  new PaymentAdapter(repository);
    }

}
