package com.itlaoqi.model;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
// 使用Lombok的@Data注解，自动生成getter、setter、equals、hashCode和toString方法  
@Data
// 使用Lombok的@Slf4j注解，为类添加日志对象log
@Slf4j
//自动生成一个无参构造方法
@NoArgsConstructor
//自动生成一个包含所有字段的构造方法
@AllArgsConstructor
//自动生成一个包含所有需要特殊处理的字段（例如，被final修饰或有@NonNull注解的字段）的构造方法
@RequiredArgsConstructor
public class Order {
    private Long id;  // 订单ID  
    // 使用Lombok的@NonNull注解，表示该字段不能为空。在生成包含该字段的构造方法时，会进行非空检查  
    @NonNull private String orderNumber;  // 订单号  
    @NonNull private String customerName;  // 客户名  
    @NonNull private double totalAmount;  // 订单总金额  
    private String status;  // 订单状态  

    // 使用Lombok的@SneakyThrows注解，可以“偷偷地”抛出受检异常，而无需在方法签名中声明  
    @SneakyThrows
    public void processOrder()  { //throws Exception
        //log打印对象
        log.info("Processing {} ", this);
        // 抛出一个测试异常，实际使用时请替换为具体的业务逻辑  
        throw new Exception("Test");
    }

    public static void main(String[] args) {
        //@NoArgsConstructor
        new Order();
        //@AllArgsConstructor
        Order order = new Order(1l, "111-222333", "客户名", 18, "init");
        //@RequiredArgsConstructor
        new Order("111-222333", "IT老齐", 18);
        order.getOrderNumber();
        order.setId(1l);
        order.setOrderNumber("111-22-333");
        // 调用processOrder方法处理订单
        // 注意，由于该方法使用了@SneakyThrows注解，因此可能会抛出异常
        try {
            order.processOrder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}