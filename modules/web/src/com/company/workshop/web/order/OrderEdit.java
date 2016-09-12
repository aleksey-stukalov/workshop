package com.company.workshop.web.order;

import com.company.workshop.entity.OrderStatus;
import com.company.workshop.service.OrderService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.workshop.entity.Order;

import javax.inject.Inject;

public class OrderEdit extends AbstractEditor<Order> {

    @Inject
    private OrderService orderService;

    @Override
    protected void initNewItem(Order item) {
        super.initNewItem(item);
        item.setStatus(OrderStatus.NEW);
    }

    @Override
    protected boolean preCommit() {
        getItem().setAmount(orderService.calculateOrderAmount(getItem()));
        return super.preCommit();
    }
}