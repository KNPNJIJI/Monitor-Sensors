package by.ska.Web.Controllers;

import by.ska.Model.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
//@ComponentScan(basePackages = "by.ska")
public class ContTest {

    @GetMapping("/")
    @ResponseBody
    public List<String> findAllUsers() {
        List<String> users = new ArrayList<>();

        users.add("wq@ska.com");
        users.add("gh@ska.com");
        //Unit perc = Unit.valueOf("percent");
        users.add((Unit.valueOf("percent")).toString());
        users.add((Unit.valueOf("degreesCelsius")).toString());
//        users.add(new AppUser(1L, "wq@ska.com", "123", "ROLE_ADMIN"));
//        users.add(new AppUser(1L, "gh@ska.com", "123", "ROLE_USER"));
//        users.add(new AppUser(1L, "rtr@ska.com", "123", "ROLE_USER"));
        return users;
    }
}
