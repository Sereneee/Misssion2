package com.example.Mission2;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

;
@Controller
@EnableAutoConfiguration
public class CRUDController
{
    List<Pet> petList = new ArrayList<Pet>();

    // add pets to list
    @PostMapping("/Pet")
    public void create(@RequestBody Pet pet)
    {
        petList.add(pet);

    }
    // view all pets in list
    @GetMapping("/Pet") //aka  @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Pet> readAll()
    {
        return petList;
    }

    // view 1 pet at a time
    @GetMapping("/Pet/{id}") //short cut for @RequestMapping(value = "/Pet/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Pet read1(@PathVariable (value = "id") String id)
    {
        Pet tempPet = null;
        for(int i=0; i<petList.size(); i++)
        {
            if(petList.get(i).getId().equals(id))
                tempPet = petList.get(i);
        }
        return tempPet;
    }

    // update pet info
    @PutMapping("/Pet/{id}")
    @ResponseBody
    public void update(@PathVariable (value = "id") String id, @RequestBody Pet requestBodyPet)
    {
        Pet tempPet = requestBodyPet;
        petList = petList.stream().filter(a -> a.getId().equals(id)).map(p -> p=tempPet).collect(Collectors.toList());
    }

    // delete pet
    @DeleteMapping("/Pet/{id}")
    @ResponseBody
    public void delete(@PathVariable (value = "id") String petId)
    {
        petList.removeIf(a -> a.getId().equals(petId));
    }
    /*
    @PutMapping("/replace/{id}")
    public void update(@PathVariable(value = "id") Integer OrderId,@RequestBody Order order) {
        service.updateOrder(OrderId,order);
    }
    */
}

/*
@RestController
public class CRUDController {
    @Autowired
    private PaintService service;
    @PostMapping("/order")
    public void create(@RequestBody Order order) {
        service.addOrder(order);
    }
    @GetMapping("/view")
    public List<Order> read() {
        return service.getOrders();
    }
    @PutMapping("/replace/{id}")
    public void update(@PathVariable(value = "id") Integer OrderId,@RequestBody Order order) {
        service.updateOrder(OrderId,order);
    }
    @DeleteMapping("/remove/{id}")
    public void delete(@PathVariable(value = "id") Integer OrderId) {
        service.deleteOrder(OrderId);
    }
}
*/
/*
@Controller
@EnableAutoConfiguration
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hey Hi Hello" +
                "\nWhat's good in da hood?" +
                "\nRed riding hood," +
                "\nConvection hood" +
                "\nAyyoo what up girl!";
    }
}
*/