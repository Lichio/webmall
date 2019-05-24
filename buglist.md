1. org.hibernate.LazyInitializationException: could not initialize proxy - no Session

**描述**：portal使用Dubbo调用logistics-service中的服务时，服务实现中使用了hibernate操作数据库，出现了该错误；但portal中使用hibernate操作数据库并不会出现此错误。

> 延迟加载，在查询的时候不会立刻访问数据库，而是返回代理对象，当真正去使用对象的时候才会访问数据库。(默认)

SpringBoot有如下默认配置：

```properties
spring.jpa.open-in-view=true # Register OpenEntityManagerInViewInterceptor. Binds a JPA EntityManager to the thread for the entire processing of the request.
```

该配置会注册一个OpenEntityManagerInViewInterceptor。在处理请求时，将 EntityManager 绑定到整个处理流程中（model->dao->service->controller），开启和关闭session。这样一来，就不会出现 no Session 的错误了（可以尝试将该配置的值置为 false, 就会出现懒加载的错误了。）

懒加载问题一直存在，因为有上述默认配置的原因，在Web调用中不会出现问题；但在新的线程中，定时任务线程中，rpc远程调用时还是会出现上述问题。

**解决**：有如下配置
```properties
spring.jpa.properties.hibernate.enable_lazy_load_no_trans 
```
允许在没有 transaction 的情况下支持懒加载。将此配置设置为false。