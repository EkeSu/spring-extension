## 扩展点 BeanPostProcessor 

### 什么是 BeanPostProcessor ?
BeanPostProcessor  是一个为 Bean 的创建忙前忙后的 扩展类，有时候甚至它自己就担起了创建 Bean 对象的责任，在 Spring 的大家族中地位举足轻重。
我想我们得先认识一下 BeanPostProcessor的类图，然后，类图解析请看 https://processon.com/diagraming/60978a72e401fd45926dac67 这边的 【BeanPostProcessor的结构】部分哦，里面有对 BeanPostProcessor 的一些关键的子接口子类做了总结介绍哈
然后，我们来玩一下它吧，哈哈


### 1. （BPPCreateAndDestoryApplication）使用 BeanPostProcessor 子接口 InstantiationAwareBeanPostProcessor 创建 Bean ～
What？ 创建 Bean，啊哈，是的。不知道为啥，有很多人的印象是 Spring 喜欢用【反射】来创建对象，它的原则也是用【反射】来做。但是笔者认为，Spring 使用反射来创建对象是为了便于扩展，不然的话使用new也是很香的呢，而且 Spring 内部也是有不少的类是直接 new 出来的哦,
在这个模块中，我创建了一个 实现了 InstantiationAwareBeanPostProcessor 的 MyInstantiationAwareBeanPostProcessor，用来实例化 User，运行笔者的程序，可以看到打印出来的User对象是有值的哦
执行路径：
    org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(java.lang.String, org.springframework.beans.factory.support.RootBeanDefinition, java.lang.Object[])，在这个createBean 方法内会调用 resolveBeforeInstantiation 方法，这个方法内会调用我们的 InstantiationAwareBeanPostProcessor 接口的创建 bean 的方法，且如果调用成功直接返回对象，不再执行下面用反射创建 bean 的逻辑，注意这点哦，因为反射创建 bean对象还是有不少逻辑的，比如下面的扩展点，就显示出来了差异呢

### 2. （BPPCreateAndDestoryApplication）使用 BeanPostProcessor 子接口 DestructionAwareBeanPostProcessor 在销毁 Bean 之前进行扩展
在这个模块我创建了一个实现了 DestructionAwareBeanPostProcessor 的 MyDestructionAwareBeanPostProcessor 来对对象的销毁进行扩展，只是打印出了一句话--调用 context 的 close 方法才会执行销毁哦，关掉 Idea 或者项目是不行的。 但是如果看代码的话，会发现，我明明是想扩展 User 和 Worker 两个对象的销毁过程，但是结果只打印出来了一个Worker，为什么呢？
因为，执行销毁的时候是销毁 BeanFactory 抽象类 DefaultSingletonBeanRegistry 内的 disposableBeans 这个集合的对象，而我们的 User 对象是扩展 InstantiationAwareBeanPostProcessor 自己创建的，这个创建的逻辑的执行要先于使用反射创建bean，且创建对象之后不会再走反射创建bean的逻辑而是直接 return， 而把 bean 信息注册进入 disposableBeans 是在使用反射创建 bean 的逻辑内执行的，因此就不会调用到我们的扩展方法了，因为销毁的时候没有处理它哦。
执行路径，调用上下文的 close() 方法，然后就会调用了，这边断点进去看逻辑也是很清晰的哦：
org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.destroySingletons

### 3. （BPPMergedBeanDefinitionApplication）使用 BeanPostProcessor 子接口 MergedBeanDefinitionPostProcessor 在创建对象之前修改 BeanDefinition 的信息改变 Bean 的创建结果
MergedBeanDefinitionPostProcessor的用途是在实例化完对象之后，又再去修改一次 BeanDefinition 的信息，比如笔者的例子 MergedBeanDefinitionPostProcessor 就修改了 Pig 的初始化方法，使得这只 pig 有了名字，叫做 eke 哈哈。
MergedBeanDefinitionPostProcessor 被调用的位置：doCreateBean 方法内会调用一个方法 applyMergedBeanDefinitionPostProcessors，在这里面调用的，稍微梳理下 doCreateBean 的执行逻辑就是
1. 调用 createBeanInstance 实例化 Bean
2. 调用 populateBean 方法为 Bean 填充属性
3. 调用 initializeBean 方法初始化 Bean，这个初始化步骤又包含了 <br/> 
3-1 调用 Aware 接口的方法 <br/>
3-2 执行 BeanPostProcessor 的 before 方法 <br/>
3-3 执行 用户定义的初始化方法（Pig的init方法就在这边被调用哦）或者是实现的 InitializingBean 接口的方法 <br/>
3-4 而后执行 BeanPostProcessor 的 after 方法 <br/>

上面是创建 doCreateBean 的一个比较粗糙的逻辑过程，而我们的 MergedBeanDefinitionPostProcessor 方法调用就在【步骤1】之后。
加一个小小的说明 CommonAnnotationBeanPostProcessor 是 MergedBeanDefinitionPostProcessor 一个比较重要的子类哦，它会去解析 @Autowired @Resource @PostConstruct @PreDestory  等注解，然后把元数据信息记入 BeanDefinition 内便于后续处理哦

    


