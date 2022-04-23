package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User Den = new User("Den", "DunKan", "dunkan@mail.ru");
      User Kolya = new User("Kolya", "Goro", "gotov@mail.com");

      userService.add(Den.setCar(new Car("grantasport", 10)).setUser(Den));
      userService.add(Kolya.setCar(new Car("citrienlux", 31)).setUser(Kolya));



      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }


      System.out.println(userService.getUserByCar("grantasport", 10));
}
}
