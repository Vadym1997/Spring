package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {
    public ArrayList<Person> people = new ArrayList<Person>(){{
        this.add(new Person(1,"vasya"));
        this.add(new Person(2,"anya"));
        this.add(new Person(3,"anya1"));
        this.add(new Person(4,"poroh"));
    }};

    @RequestMapping("/") //@@RequestMapping(value ="/", method = RequestMethod.Get)
    public String sendMeToIndexPagePlease(){

        return "index";
    }

@GetMapping("/greeting")
    public String greeting(@RequestParam("imya") String name, Model model){//imya приходить з htlm, якщо імя і нейм співпадають то в @можна не прописувати
   // System.out.println(name);
    model.addAttribute("x", name);//для виводу інфи на сторінку(за параметром х закріпили значення name
        return "index";

    }
    @PostMapping("/greeting")
    public String Postgreeting(@RequestParam int idOfPerson, Model model){
        Person person1 = people.stream().filter(person -> person.getId() == idOfPerson).findFirst().get();
        model.addAttribute("x", person1);
        return "asd";
    }


}
