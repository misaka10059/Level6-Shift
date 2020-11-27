package com.mn.level6shift.service;

import com.google.gson.reflect.TypeToken;
import com.mn.level6shift.component.util.TimeUtil;
import com.mn.level6shift.domain.dao.primary.EarthmanDao;
import com.mn.level6shift.domain.dao.primary.EarthmanDaoSpec;
import com.mn.level6shift.domain.entity.primary.Earthman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/10/30 11:29
 * DESC
 */
@Service
public class EarthmanService {

    @Autowired
    private EarthmanDao earthmanDao;

    private String generateCodePrefix() {
        return "E" + TimeUtil.getFormatTime(TimeUtil.UnitOfTimeMeasurement.YEAR) + TimeUtil.getFormatTime(TimeUtil.UnitOfTimeMeasurement.MONTH);
    }

    private String getFormatNumber(int number) {
        StringBuilder result = new StringBuilder(String.valueOf(number));
        while (result.length() < 5) {
            result.insert(0, "0");
        }
        return result.toString();
    }

    private String generateCode() {
        String latestCode;
        String newCode;
        String codePrefix = generateCodePrefix();
        int number = 1;
        List<Earthman> list = earthmanDao.findByCodeLikeOrderByCodeDesc("%" + codePrefix + "%");
        if (null != list && list.size() > 0) {
            latestCode = list.get(0).getCode();
            number = Integer.valueOf(latestCode.substring(latestCode.length() - 5)) + 1;
            newCode = codePrefix + getFormatNumber(number);
        } else {
            newCode = codePrefix + getFormatNumber(number);
        }
        return newCode;
    }

    /**
     * DATE 2020/10/30 11:39
     * DESC
     */
//    @Transactional
    public Earthman add(String name) {
        String code = generateCode();
        Earthman earthman = new Earthman(code, name);
        Earthman insertEarthman;
        try {
            insertEarthman = earthmanDao.save(earthman);
        } catch (DataAccessException e) {
            code = generateCode();
            earthman = new Earthman(code, name);
            insertEarthman = earthmanDao.save(earthman);
        }
        return insertEarthman;
//        return earthmanDao.save(earthman);
    }

    /**
     * DATE 2020/10/30 11:31
     * DESC
     */
    public List<Earthman> list() {
        doIt();
        return earthmanDao.findAll();
    }

    /*-----------------------------------------------------------------*
     *                                 排序
     *-----------------------------------------------------------------*/

    /**
     * DATE 2020/11/25 8:58
     * DESC JDBC中排序，通过Sort
     */
    public List<Earthman> listSortedPattern1(String name) {
        Specification<Earthman> querySpec = EarthmanDaoSpec.getVariableSpec(name);
        Sort sort = new Sort(Sort.Direction.DESC, "name");
        return earthmanDao.findAll(querySpec, sort);
    }

    /**
     * DATE 2020/11/25 10:10
     * DESC 通过Stream排序
     */
    public List<Earthman> listSortedPattern2(String name) {
        Specification<Earthman> querySpec = EarthmanDaoSpec.getVariableSpec(name);
        List<Earthman> list = earthmanDao.findAll(querySpec);
        return list.stream()
                .sorted(Comparator.comparing(Earthman::getName).reversed())
                .collect(Collectors.toList());
    }

    /**
     * DATE 2020/11/25 10:10
     * DESC JDBC中排序，通过like
     */
    public List<Earthman> listSortedPattern3(String name) {
        return earthmanDao.findAllByNameLikeOrderByNameDesc("%" + name + "%");
    }

    /**
     * DATE 2020/11/25 10:10
     * DESC JDBC中排序，通过Sort(PageRequest)
     */
    public List<Earthman> listSortedPattern4(String name) {
        Specification<Earthman> querySpec = EarthmanDaoSpec.getVariableSpec(name);
        Pageable pageRequest = new PageRequest(0, 999, new Sort(Sort.Direction.DESC, "name"));
        Page<Earthman> page = earthmanDao.findAll(querySpec, pageRequest);
        return page.getContent();
    }

    /*-----------------------------------------------------------------*
     *
     *-----------------------------------------------------------------*/

    public void doIt() {
        Hello hello = new Hello();
        hello.setMessage("Can I do?");
        hello.setFruit(Fruit.APPLE);
        Type type = new TypeToken<Fruit>() {
        }.getType();
        Fruit fruit = Fruit.APPLE;
        if (fruit.getClass().isEnum()) {
            System.out.println("this is a kind of fruit");
        }
        System.out.println("type:" + type);
    }
}
