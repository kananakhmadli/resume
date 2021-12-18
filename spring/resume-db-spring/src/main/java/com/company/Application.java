package com.company;

import com.company.dao.inter.UserRepository;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import outer.MyConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
@ComponentScan(basePackages = "outer")
@ComponentScan(basePackages = "com.company")
// burda com.company da dedim yoxsa yalnız outer e baxır
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    MyConfiguration myConfiguration;

    @Autowired
    UserServiceInter userServiceInter;

//    @Bean("userDao1")
//    public UserDaoInter getUserDao(){
//        return new UserDaoImpl();
//    }


//    @Bean
//    public CommandLineRunner run() throws Exception {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//               List<User> list=userRepository.findAll();
//                System.out.println(list);
//                System.out.println("++++++++++++++++++++++");
//                list=userRepository.findAll(Sort.by(Sort.Order.desc("id")));
//                System.out.println(list);
//
//                List<User> list = serviceInter.getAll(null, null, null);
//                for (int i = 0; i < list.size(); i++) {
//                    System.out.println(list.get(i).getNationality().getId());
//                    System.out.println("--------");
//                }
//
//            }
//
//        };
//    }

//    @Bean
//    public CommandLineRunner run() throws Exception {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                Properties properties = new Properties();
//                String driver;
//                String url;
//                String username;
//                String password;
//
//                try {
//                    FileInputStream fileInputStream = new FileInputStream("D://worksapace//resume//spring//resume-db-spring//src//main//resources//application.properties");
//                    properties.load(fileInputStream);
//                    driver = properties.getProperty("db_driver");
//                    url = properties.getProperty("db_url");
//                    username = properties.getProperty("db_username");
//                    password = properties.getProperty("db_password");
//                    System.out.println(driver);
//                    System.out.println(url);
//                    System.out.println(username);
//                    System.out.println(password);
//                    System.out.println("+++++++++++++++++");
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//
//
//
//            }
//
//        };
//    }


}

