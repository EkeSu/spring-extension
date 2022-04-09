## 使用 BeanFactoryPostProcessor 扩展

### BeanFactoryPostProcessor 是个啥？
BeanFactoryPostProcessor 接口只有一个方法就是 postProcessBeanFactory 见名知意，它是用来后置处理 beanFactory 的。
那么可以干啥呢，可以做很多事情，对 BeanFactory 为所欲为吧，它支持的方法，你想干啥干啥，比如添加我们自己的 BeanPostProcessor 注册一个新的 Bean，为 特定 Bean 增加一个别名等，这是笔者例子上面干的事情啦，哈哈哈
如果要更好的理解 BeanFactoryPostProcessor 还是要理清楚它是发生在整个 Spring 流程的哪一环节的，这个可以看下本项目总的 README 文件上面的链接哈，笔者画了一张简单的图，上面有标出来 BeanFactoryPostProcessor 是在哪里被执行的
另外还整理了 BeanFactoryPostProcessor 和它的子类 BeanDefinitionRegistryPostProcessor 各自的执行逻辑。简述就是先执行 BeanDefinitionRegistryPostProcessor 后执行 BeanFactoryPostProcessor，且执行的时候都是先执行实现了 PriorityOrder 接口的 PostProcessor，之后再执行实现了 Order 接口的 PostProcessor，之后再执行 没有实现这俩接口的 PostProcessor。
关于 BeanFactoryPostProcessor 和它的子类的执行位置，完整路径是：
    
    org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors  这个方法是我们 Spring 非常重要的方法，它的执行逻辑比较复杂，不过大体就是上面说的了。

### 如何添加 BeanFactoryPostProcessor ？
很简单，写一个自己的类，实现 BeanFactoryPostProcessor 接口，然后在类上添加 @Component 注解即可。

### 为什么上面的添加方式可以让 Spring 识别到我们自己建的 BeanFactoryProcessor ？
上面说过执行 BeanFactoryPostProcessor 的地方是在  invokeBeanFactoryPostProcessors 这个方法里面干的，那么 Spring 要执行 BeanFactoryPostProcessor 的方法得干啥，是的，得先获取当前项目内的所有 BeanFactoryPostProcessor，如您所料，她会调用 beanFactory 的如下方法：

    beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false)

这样就能获取了BeanName然后进行创建相应的 BeanFactoryPostProcessor 的 Bean 了，可能有小伙伴又会有疑问之前是怎么拿到这个 BeanName 的呢，这个就可以看下 bdrpp 模块提到的 ConfigurationClassPostProcessor 了，它实现了 BeanFactoryPostProcessor 的子接口 BeanDefinitionRegistryPostProcessor，执行的时候会去扫描我们配置类同目录下的所有类，要是一个类被打上了 @Component @Service @Controller ，，， 等注解就会解析类信息封装成相应的 BeanDefinition 放入 BeanFactory，所以，我们在这边就能根据类型拿到对应的 BeanName 了哦。

