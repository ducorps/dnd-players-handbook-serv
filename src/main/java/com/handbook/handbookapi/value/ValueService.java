package com.handbook.handbookapi.value;

import com.handbook.handbookapi.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class ValueService extends AbstractService<Value, Long> {
    @Autowired
    private ValueRepository valueRepository;

    @Override
    protected JpaRepository<Value, Long> getRepository() {
        return valueRepository;
    }
}
