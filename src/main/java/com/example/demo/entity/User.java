package com.example.demo.entity;

import com.example.demo.annotation.DBClassProperty;
import com.example.demo.annotation.DBFieldProperty;
import com.example.demo.annotation.DBMethodProperty;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.Method;
import java.util.Date;

@DBClassProperty(usercode ="20",usertype = "Admin")
public class User {
    @DBFieldProperty(name="id",isPrimaryKey = true,type = Long.class)
    private long id;

    @DBFieldProperty(name="name",type = String.class)
    private String name;

    @DBFieldProperty(name="email",type = String.class)
    private String email;

    @DBFieldProperty(name = "created", type = Date.class)
    private Date created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    @DBMethodProperty(value = 15)
    public void sayHello() throws NoSuchMethodException {
        System.out.println("Hi This is Hello ");

        //Below code is usd for getting the annotation parameter value
        Method method=User.class.getMethod("sayHello");
        DBMethodProperty dbMethodProperty=method.getAnnotation(DBMethodProperty.class);
        int value=dbMethodProperty.value();

        System.out.print("Value is "+value);

        /*Method[] methods = User.class.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(DBMethodProperty.class)) {
                DBMethodProperty ta = m.getAnnotation(DBMethodProperty.class);
                System.out.println(ta.value());
            }
        }*/
    }
}
