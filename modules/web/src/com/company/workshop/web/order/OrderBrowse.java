package com.company.workshop.web.order;

import com.company.workshop.entity.Order;
import com.company.workshop.entity.OrderStatus;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.UUID;

public class OrderBrowse extends AbstractLookup {

    @Inject
    private CollectionDatasource<Order, UUID> ordersDs;

    public void onBtnSetNewStatusClick(Component source) {
        Order o = ordersDs.getItem();
        if (o != null) {
            o.setStatus(OrderStatus.NEW);
            ordersDs.commit();
        }
    }
}