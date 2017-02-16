public class OrderEdit extends AbstractEditor<Order> {
    @Override
    protected void initNewItem(Order item) {
        super.initNewItem(item);
        item.setStatus(OrderStatus.NEW);
    }
}
