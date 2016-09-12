package com.company.workshop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Lob;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|title")
@Table(name = "WORKSHOP_SPARE_PART")
@Entity(name = "workshop$SparePart")
public class SparePart extends StandardEntity {
    private static final long serialVersionUID = -6241692300506712393L;

    @Column(name = "TITLE", nullable = false, unique = true)
    protected String title;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @Column(name = "PRICE", nullable = false)
    protected BigDecimal price;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }


}