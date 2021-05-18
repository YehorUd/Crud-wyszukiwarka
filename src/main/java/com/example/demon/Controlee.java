package com.example.demon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class Controlee {
    private AnimalRepo animalRepo;
    @Autowired
    public Controlee(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }
    @RequestMapping("/add")
    public String addData(
            @RequestParam("type") String type,
            @RequestParam("name") String name,
            @RequestParam("size") String size,
            @RequestParam("weight") String weight,
            Model model)
            throws Exception {
        Animal animal = new Animal(type, name, size, weight, true);
        System.out.println(animal);
        animalRepo.save(animal);
        model.addAttribute("animal", animal);
        return "Show";
    }
    @RequestMapping("/form")
    public String addData(){return "Form";}
    @RequestMapping("/show")
    public String show( Model model) {
        model.addAttribute("animal", animalRepo.findAll());
        return "Show";
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Integer id, Model model){
        animalRepo.deleteById(id);

        model.addAttribute("animal", animalRepo.findAll());
        return "Show";
    }
    @RequestMapping("/search")
    public String search(@RequestParam("criterion") String criterion, Model model){
        model.addAttribute("animal", animalRepo.findAllByName(criterion));
        return "Show";
    }
    @RequestMapping("/redirect")
    public String redirect(
            @RequestParam("id") Integer id, Model model
    )
            throws Exception {
        System.out.println(animalRepo.findById(id));
        model.addAttribute("animal", animalRepo.findById(id));
        return "Update";
    }

    @RequestMapping("/update")
    public String update(
            @RequestParam("id") Integer id,
            @RequestParam("type") String type,
            @RequestParam("name") String name,
            @RequestParam("size") String size,
            @RequestParam("weight") String weight,
            Model model)
            throws Exception {
        Animal animal = new Animal(id, type, name, size, weight, true);
        System.out.println(animal);
        animalRepo.save(animal);
        model.addAttribute("animal", animal);
        return "Show";
    }

}
