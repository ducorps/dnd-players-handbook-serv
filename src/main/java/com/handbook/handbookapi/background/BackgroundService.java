package com.handbook.handbookapi.background;

import com.handbook.handbookapi.common.AbstractService;
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
