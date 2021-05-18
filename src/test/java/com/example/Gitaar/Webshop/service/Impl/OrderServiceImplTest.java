package com.example.Gitaar.Webshop.service.Impl;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {
/*
    @Autowired
    private OrderServiceImpl orderService;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private OrderItemRepository orderItemRepository;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private MailSender mailSender;

    @Test
    public void findAll() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order());
        orderList.add(new Order());

        when(orderRepository.findAll()).thenReturn(orderList);
        orderService.findAll();
        assertEquals(2, orderList.size());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    public void finalizeOrder() {
        Order order1 = new Order();
        order1.setId(1L);
        Order order2 = new Order();
        order2.setId(2L);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        when(orderRepository.findAll()).thenReturn(orderList);
        orderService.finalizeOrder();
        assertEquals(2, orderList.get(orderList.size() - 1).getId());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    public void findOrderByEmail() {
        Order order1 = new Order();
        order1.setEmail(ORDER_EMAIL);
        Order order2 = new Order();
        order2.setEmail(ORDER_EMAIL);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        when(orderRepository.findOrderByEmail(ORDER_EMAIL)).thenReturn(orderList);
        orderService.findOrderByEmail(ORDER_EMAIL);
        assertEquals(2, orderList.size());
        verify(orderRepository, times(1)).findOrderByEmail(ORDER_EMAIL);
    }

    @Test
    public void postOrder() {
        Map<Long, Long> productsId = new HashMap<>();
        productsId.put(1L, 1L);
        productsId.put(2L, 1L);

        Product product1 = new Product();
        product1.setId(1L);
        product1.setPrice(PRICE);
        Product product2 = new Product();
        product2.setPrice(PRICE);
        product2.setId(2L);

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(product1);
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(product2);

        Order order = new Order();
        order.setFirstName(FIRST_NAME);
        order.setLastName(LAST_NAME);
        order.setCity(CITY);
        order.setAddress(ADDRESS);
        order.setEmail(ORDER_EMAIL);
        order.setPostIndex(POST_INDEX);
        order.setPhoneNumber(PHONE_NUMBER);
        order.setTotalPrice(TOTAL_PRICE);
        order.setOrderItems(Arrays.asList(orderItem1, orderItem2));

        when(productRepository.findById(1L)).thenReturn(java.util.Optional.of(product1));
        when(productRepository.findById(2L)).thenReturn(java.util.Optional.of(product2));
        when(orderItemRepository.save(orderItem1)).thenReturn(orderItem1);
        when(orderItemRepository.save(orderItem2)).thenReturn(orderItem2);
        when(orderRepository.save(order)).thenReturn(order);
        orderService.postOrder(order, productsId);
        assertNotNull(order);
        assertEquals(ORDER_EMAIL, order.getEmail());
        assertNotNull(orderItem1);
        assertNotNull(orderItem2);
        verify(mailSender, times(1))
                .send(
                        ArgumentMatchers.eq(order.getEmail()),
                        ArgumentMatchers.eq("Order #" + order.getId()),
                        ArgumentMatchers.anyString());
    }
*/
}
