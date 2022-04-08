package com.eke.aware.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/8
 */
@Data
@Component
public class User {
    private Long id;
    private String name;
}
