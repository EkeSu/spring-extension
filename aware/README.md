# 扩展点1 实现 Aware 接口
## 什么是 Aware 接口，干啥的？
Aware 接口是spring 提供的接口，它底下有很多子接口，要是我们实现了这些接口，spring在为我们创建bean的时候，就会调用相应的aware接口的方法，具体的aware接口包括
* EnvironmentAware
* EmbeddedValueResolverAware
* ResourceLoaderAware
* ApplicationEventPublisherAware
* MessageSourceAware
* ApplicationStartupAware
* ApplicationContextAware

* BeanNameAware
* BeanClassLoaderAware
* BeanFactoryAware

## Aware接口的方法在哪里被调用？
Aware接口的调用分做了两个地方
1. Bean对象的创建分为实例化和初始化阶段，初始化阶段会先执行 populateBean 方法，而后调用 initializeBean 方法，在 initializeBean 方法内会调用 invokeAwareMethods ，这方法里面会调用 Aware 接口的方法，不过只会调用上面类举的后3个 ，完整的类路径是： org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(java.lang.String, java.lang.Object, org.springframework.beans.factory.support.RootBeanDefinition)，

2. 上面说了只会调用后3个，那么其他几个是在哪里被调用的呢，在 BeanPostProcessor 的 postProcessBeforeInitialization方法被调用的时候执行的，对应的 BeanPostProcessor 是 ApplicationContextAwareProcessor，执行的时机点也是 在上面的 initializeBean 被调用的时候， 完整类路径是 org.springframework.context.support.ApplicationContextAwareProcessor.invokeAwareInterfaces

## 意义呢？
笔者在这个项目写了两个工具类，ApplicationContextUtil 和 EnvironmentUtil，我们可以通过他们来访问 Spring 自身管理的对象，从而直接调用 Spring 的一些内部方法进行处理，比如在一些地方我们要动态的获取属性值的话就可以用这个 EnvironmentUtil
