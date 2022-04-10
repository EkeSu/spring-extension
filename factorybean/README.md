## 扩展点 实现 FactoryBean 接口来创建bean

### FactoryBean 相信是不陌生的，好像是面试的高频呢？那么它和 beanFactory 是什么区别呢？
笔者感觉它们是因为名字相似所以被一直问吧，其实是两个完全不一样的东西嘛，要说相似之处的话，俩都是接口，都是 Spring 的接口，算不算，哈哈哈
BeanFactory 本质上是工厂啦，管理 bean 的一个顶级接口。
FactoryBean 本质上是bean啦，实现了它可以用来作为媒介创建另一个bean，看笔者的例子，就是要实现3个接口，然后加上 @Component 注解，就可以了。

### 注意点
通过使用 FactoryBean 创建的 Bean 是不放在一级缓存（singletonObjects）的哦，它会被放在 factoryBeanObjectCache 这个缓存内的哦，会放在一级缓存的是我们实现了 FactoryBean 的那个 Bean 呢
