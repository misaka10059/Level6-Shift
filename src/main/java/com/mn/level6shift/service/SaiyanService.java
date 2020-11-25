package com.mn.level6shift.service;

import com.mn.level6shift.domain.dao.secondary.SaiyanDao;
import com.mn.level6shift.domain.entity.secondary.Saiyan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/10/30 11:31
 * DESC
 */
@Service
public class SaiyanService {

    @Autowired
    private SaiyanDao saiyanDao;

    /**
     * DATE 2020/10/30 11:41
     * DESC
     */
    public Saiyan add(String name) {
        Saiyan saiyan = new Saiyan(name);
        return saiyanDao.save(saiyan);
    }

    /**
     * DATE 2020/10/30 11:32
     * DESC
     */
    public List<Saiyan> list() {
        return saiyanDao.findAll();
    }
}
