## 自己写一个 starter 是最重要的一个扩展手段了吧大概，因为我们平时可能会需要写很多的基础工具包，利用自己写starter的方式来实现可插拔

### 咋写呢？
1. 写一个配置类
2. 在 resources 下创建文件夹 META-INF 然后在里面创建好一个文件叫做 spring.factories
3. 在 spring.factories 内配置好我们的配置类，具体咋写的可以看项目哈，注意这个配置 key 是固定的，value 就是我们的配置类的类路径
4. 接下来对我们的配置类做一些加工 
    1. 加上 @Configuration 注解
    2. 加上 @ComponentScan 注解（如果需要注册一些 bean 的话，可选哦）
    3. 然后你可以继续在这个类里面搞七搞八


### 关于配置类是怎么生效的
#### 被扫描
1. 话说，我们的启动类上面不是有个注解喵，这个注解里面还包含了其他的注解，是滴不，然后，在 invokeBeanFactoryPostProcessors 这个方法（org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors）的时候，会调用一个 BDRPP（ConfigurationClassPostProcessor）  会去解析我们的启动类，往这个方法内跟，会发现他会去解析我们的启动类的，然后就会解析到它有注解，解析注解到时候是递归解析的，就会解析到这个：
@SpringBootApplication -> @EnableAutoConfiguration -> @Import(AutoConfigurationImportSelector.class), 然后肯定要解析 @Import注解是滴不，就会调用 AutoConfigurationImportSelector 实现的接口  ImportSelector 的方法 【selectImports】，然后就会去读取配置文件 spring.factoies 里面的配置项了。so
### 生效
1. 这个其实没啥好说的了，读取回来配置项就能找到我们的配置类了，然后也会像解析我们的启动类一样解析我们的配置类，然后就会读取到一些配置注册一些bean， 或者像nacos那样还会创建一些线程，执行注册和心跳之类的。

   
