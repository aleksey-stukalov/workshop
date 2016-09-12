package com.company.workshop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|description")
@Table(name = "WORKSHOP_ORDER")
@Entity(name = "workshop$Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = 922007560588072984L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CLIENT_ID")
    protected Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MECHANIC_ID")
    protected Mechanic mechanic;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @Column(name = "HOURS_SPENT")
    protected Integer hoursSpent;

    @Column(name = "AMOUNT")
    protected BigDecimal amount;

    @JoinTable(name = "WORKSHOP_ORDER_SPARE_PART_LINK",
        joinColumns = @JoinColumn(name = "ORDER_ID"),
        inverseJoinColumns = @JoinColumn(name = "SPARE_PART_ID"))
    @ManyToMany
    protected Set<SparePart> parts;

    @Column(name = "STATUS")
    protected Integer status;

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setHoursSpent(Integer hoursSpent) {
        this.hoursSpent = hoursSpent;
    }

    public Integer getHoursSpent() {
        return hoursSpent;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setParts(Set<SparePart> parts) {
        this.parts = parts;
    }

    public Set<SparePart> getParts() {
        return parts;
    }

    public void setStatus(OrderStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public OrderStatus getStatus() {
        return status == null ? null : OrderStatus.fromId(status);
    }


}