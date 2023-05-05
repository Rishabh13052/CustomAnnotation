package com.example.demo.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DBFieldProperty {
    String name();
    Class<? > type();
    boolean isPrimaryKey() default false;

}
