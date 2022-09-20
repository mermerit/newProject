package com.example.payment.infrastructure.modul;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PaymentRepository extends JpaRepository<PaymentStatusEntity,Integer> {
}
