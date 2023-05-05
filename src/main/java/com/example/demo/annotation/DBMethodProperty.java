package com.example.demo.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Target(ElementType.METHOD)

//Below annotation is used for checking the validity of user
public @interface DBMethodProperty {
    int value() default 10;
}
