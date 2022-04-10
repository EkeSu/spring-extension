package com.eke.extension.bpp.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/10
 */
@Component
@Data
public class Pig {
    private Integer id;
    private String name;

    public void init() {
        this.name = "eke";
    }


}
