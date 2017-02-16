public class OrderEdit extends AbstractEditor<Order> {

    @Inject
    private OrderService orderService;

    @Override
    protected boolean preCommit() {
        Order order = getItem();
        order.setAmount(orderService.calculateAmount(order));
        return super.preCommit();
    }

    @Override
    protected void initNewItem(Order item) {
        super.initNewItem(item);
        item.setStatus(OrderStatus.NEW);
    }
}
