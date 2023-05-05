package com.example.demo;

import com.example.demo.annotation.DBClassProperty;
import com.example.demo.annotation.DBFieldProperty;
import com.example.demo.annotation.DBMethodProperty;
import com.example.demo.entity.User;
import com.fasterxml.jackson.databind.introspect.Annotated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

@SpringBootApplication
public class DemoForCustomAnnotationApplication {

	public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException {
		SpringApplication.run(DemoForCustomAnnotationApplication.class, args);

		//Below code is for Field Custom Annotation
		User user=new User();
		user.setId(1);
		user.setName("Rishabh");
		user.setEmail("Rishabh@gmail.com");
		user.setCreated(new Date());

		for(Field field: user.getClass().getDeclaredFields()) {
			DBFieldProperty dbFieldProperty = field.getAnnotation(DBFieldProperty.class);
			System.out.println("Field Name is " + dbFieldProperty.name());

			field.setAccessible(true);
			Object value = field.get(user);
			System.out.println("Field Value is " + value);

			System.out.println("Field Type is " + dbFieldProperty.type());
			System.out.println("is primary key " + dbFieldProperty.isPrimaryKey());

			System.out.println();
		}

		//Below code is for Class Custom Annotation
		Annotation userAnnt=user.getClass().getAnnotation(DBClassProperty.class);
		DBClassProperty dbClassProperty= (DBClassProperty) userAnnt;

		System.out.println("User Code is "+dbClassProperty.usercode());
		System.out.println("User Type is "+dbClassProperty.usertype());

		//Below code is for Method Custom Annotation

		//Get the value using method name
		Method methodAnnt=user.getClass().getMethod("sayHello");
		Annotation ann=methodAnnt.getAnnotation(DBMethodProperty.class);
		DBMethodProperty dbMethodProperty= (DBMethodProperty) ann;

		int value=dbMethodProperty.value();
		System.out.println("Value is "+value);

		user.sayHello();



	}

}
