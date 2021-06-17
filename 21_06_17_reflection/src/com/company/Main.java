package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        User user = new User();
        String path = "com.company.User";

        User user1 = (User) Class.forName(path).getConstructor().newInstance();
        System.out.println(user1);
        user1.setEmail("valid@mail.com");
        System.out.println(user1);

        User user2 = (User) Class.forName(path)
                .getConstructor(String.class, String.class, int.class)
                .newInstance("vasja@mail.com", "Vasja", 777);
        System.out.println(user2);

        String pathAdminUser = "com.company.exapmle_pkg.AdminUser";
        User admin = (User) Class
                .forName(pathAdminUser)
                .getConstructor(String.class, String.class, int.class)
                .newInstance("admin@mail.com", "Petja", 98468);
        System.out.println(admin);
        System.out.println("email: " + admin.getEmail() + ", name: " + admin.getName() + ", pn: " + admin.getPhoneNumber());

        Field[] fieldIsAdmin = admin.getClass().getDeclaredFields();
        for (Field field : fieldIsAdmin) {
            System.out.println(field.getName());
            field.setAccessible(true);

            System.out.println(field.get(admin));
        }
    }
}
