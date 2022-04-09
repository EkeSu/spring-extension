## 扩展点 BeanPostProcessor 

### 什么是 BeanPostProcessor ?
BeanPostProcessor  是一个为 Bean 的创建忙前忙后的 扩展类，有时候甚至它自己就担起了创建 Bean 对象的责任，在 Spring 的大家族中地位举足轻重。
我想我们得先认识一下 BeanPostProcessor的类图，然后，类图解析请看 https://processon.com/diagraming/60978a72e401fd45926dac67 这边的 【BeanPostProcessor的结构】部分哦，里面有对 BeanPostProcessor 的一些关键的子接口子类做了总结介绍哈
然后，我们来玩一下它吧，哈哈

### 使用 BeanPostProcessor 创建 Bean～
What？ 创建 Bean，啊哈，是的。不知道为啥，有很多人的印象是 Spring 喜欢用【反射】来创建对象，它的原则也是用【反射】来做。但是笔者认为，Spring 使用反射来创建对象是为了便于扩展，不然的话使用new也是很香的呢，而且 Spring 内部也是有不少的类是直接 new 出来的哦

