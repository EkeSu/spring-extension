package extention.aware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/7
 */
@SpringBootApplication
public class ExtentionApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ExtentionApplication.class, args);
    }
}
