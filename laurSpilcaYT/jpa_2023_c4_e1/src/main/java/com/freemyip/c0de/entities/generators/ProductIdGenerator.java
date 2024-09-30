package com.freemyip.c0de.entities.generators;

import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProductIdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        Random random = new Random();
        int idNumber = random.nextInt() + 1;
        return "prod-" + idNumber;
    }

}
