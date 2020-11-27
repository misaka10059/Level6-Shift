package com.mn.level6shift.domain.dao.primary;

import com.mn.level6shift.domain.entity.primary.Earthman;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/10/30 11:30
 * DESC
 */
public interface EarthmanDao extends JpaRepository<Earthman, String> {

    List<Earthman> findAll(Specification<Earthman> querySpec);

    List<Earthman> findAllByNameLikeOrderByNameDesc(String name);

    List<Earthman> findAll(Specification<Earthman> querySpec, Sort sort);

    Page<Earthman> findAll(Specification<Earthman> querySpec, Pageable pageable);

    List<Earthman> findByCodeLikeOrderByCodeDesc(String code);
}
