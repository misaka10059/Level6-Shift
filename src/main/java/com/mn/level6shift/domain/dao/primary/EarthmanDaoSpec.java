package com.mn.level6shift.domain.dao.primary;

import com.mn.level6shift.domain.entity.primary.Earthman;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/11/25 8:55
 * DESC
 */
public class EarthmanDaoSpec {

    public static Specification<Earthman> getVariableSpec(String name) {
        return (entity, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.isFalse(entity.get("delFlag"));
            List<Predicate> additionList = new ArrayList<>();
            if (null != name && !name.isEmpty()) {
                additionList.add(criteriaBuilder.like(entity.get("name"), "%" + name + "%"));
            }
            for (Predicate addition : additionList) {
                predicate = criteriaBuilder.and(predicate, addition);
            }
            return predicate;
        };

    }
}
