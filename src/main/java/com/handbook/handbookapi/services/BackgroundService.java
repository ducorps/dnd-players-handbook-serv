package com.handbook.handbookapi.services;

import com.handbook.handbookapi.abstracts.AbstractService;
import com.handbook.handbookapi.model.background.Background;
import com.handbook.handbookapi.repositories.BackgroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BackgroundService extends AbstractService<Background, Long> {
    @Autowired
    private BackgroundRepository backgroundRepository;

    @Override
    protected JpaRepository<Background, Long> getRepository() {
        return backgroundRepository;
    }
}
