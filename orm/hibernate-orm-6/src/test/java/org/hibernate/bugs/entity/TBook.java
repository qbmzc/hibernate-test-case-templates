package org.hibernate.bugs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Table(name = "t_book")
@Entity
@Data
public class TBook extends TItem{

    private String pageCount;
}
