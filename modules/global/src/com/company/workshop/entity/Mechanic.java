package com.company.workshop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.security.entity.User;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|user")
@Table(name = "WORKSHOP_MECHANIC")
@Entity(name = "workshop$Mechanic")
public class Mechanic extends StandardEntity {
    private static final long serialVersionUID = 4167246151086798403L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID")
    protected User user;

    @Column(name = "HOURLY_RATE", nullable = false)
    protected BigDecimal hourlyRate;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }


}