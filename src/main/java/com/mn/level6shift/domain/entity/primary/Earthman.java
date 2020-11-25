package com.mn.level6shift.domain.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/10/30 11:09
 * DESC
 */
@Table(name = "earthman")
@Entity
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Earthman {

    @Id
    private String id = UUID.randomUUID().toString().replace("-", "");

    @Column
    private String name;

    @Column
    private Timestamp createTime;

    @Column
    private Timestamp updateTime;

    @Column
    private boolean delFlag;

    public Earthman(String name) {
        this.name = name;
    }

}
