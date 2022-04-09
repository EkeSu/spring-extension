## 使用 BeanFactoryPostProcessor 扩展

### BeanFactoryPostProcessor 是个啥？
BeanFactoryPostProcessor 接口只有一个方法就是 postProcessBeanFactory 见名知意，它是用来后置处理 beanFactory 的。
那么可以干啥呢，可以做很多事情，对 BeanFactory 为所欲为吧，它支持的方法，你想干啥干啥，比如添加我们自己的 BeanPostProcessor 注册一个新的 Bean，为 特定 Bean 增加一个别名等，这是笔者例子上面干的事情啦，哈哈哈
如果要更好的理解 BeanFactoryPostProcessor 还是要理清楚它是发生在整个 Spring 流程的哪一环节的，这个可以看下本项目总的 README 文件上面的链接哈，笔者画了一张简单的图，上面有标出来 BeanFactoryPostProcessor 是在哪里被执行的
另外还整理了 BeanFactoryPostProcessor 和它的子类 BeanDefinitionRegistryPostProcessor 各自的执行逻辑。简述就是先执行 BeanDefinitionRegistryPostProcessor 后执行 BeanFactoryPostProcessor，且执行的时候都是先执行实现了 PriorityOrder 接口的 PostProcessor，之后再执行实现了 Order 接口的 PostProcessor，之后再执行 没有实现这俩接口的 PostProcessor。
关于 BeanFactoryPostProcessor 和它的子类的执行位置，完整路径是：org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors  这个方法是我们 Spring 非常重要的方法，它的执行逻辑比较复杂，不过大体就是上面说的了。
