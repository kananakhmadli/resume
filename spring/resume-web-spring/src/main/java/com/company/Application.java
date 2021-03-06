package com.company;

import com.company.entity.User;
import com.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import outer.MyConfiguration;

@SuppressWarnings({"unused", "CommentedOutCode", "FieldCanBeLocal"})
@SpringBootApplication
@ComponentScan(basePackages = "outer")
@ComponentScan(basePackages = "com.company")
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private final MyConfiguration myConfiguration;
    private final UserService userService;

    public Application(MyConfiguration myConfiguration, UserService userService) {
        this.myConfiguration = myConfiguration;
        this.userService = userService;
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            User user = userService.getById(1);
            log.info(user.getGroupUsers().get(0).getMyGroup().toString());
//            user.getUserSkills().forEach(userSkill -> System.out.println(userSkill.getSkill().getName()));
//                System.out.println(skillRepository.getSkillBSkillId(1).getUserSkills());
        };
    }

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
//                List<User> list = serviceInter.getAll(null, null, null);
//                for (int i = 0; i < list.size(); i++) {
//                    System.out.println(list.get(i).getNationality().getId());
//                    System.out.println("--------");
//                }
//            }
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
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        };
//    }

}