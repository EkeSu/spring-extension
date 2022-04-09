package com.eke.extension.bp.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/9
 */
@Component
@Data
public class User {
    private Long id;
    private String name;
}
