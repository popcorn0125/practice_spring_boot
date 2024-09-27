package com.kjs.web.Controller;

import com.kjs.web.Entity.Item;
import com.kjs.web.Repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;


    @GetMapping("/list")
    public String list(Model model) {
        System.out.println("ItemController - list 실행");

        List<Item> result = itemRepository.findAll();

        model.addAttribute("items", result);

        return "list";
    }

    @GetMapping("/addItem")
    public String addItem() {
        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItem(String car, Integer price, String manufacturer, String explanation, String image, LocalDate release_date) {
        System.out.println("ItemController - insertItem 실행");
        Item item = new Item();
        item.setImage(image);
        item.setCar(car);
        item.setPrice(price);
        item.setExplanation(explanation);
        item.setManufacturing_company(manufacturer);
        item.setRelease_date(release_date);
        itemRepository.save(item);
        return "redirect:/list";
    }

    @PostMapping("/addItem2")
    public String addItem2(@ModelAttribute Item item) {
        System.out.println("ItemController - addItem2 실행");
        itemRepository.save(item);
        return "redirect:/list";
    }

    @GetMapping("/detailItem/{id}")
    public String detailItem(@PathVariable("id") Long id, Model model) {
        System.out.println("ItemController - get detailItem 실행");

        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()) {
            System.out.println("result : " + result);
            model.addAttribute("item", result.get());
            return "detailItem";
        } else {
            return "redirect:/list";
        }

    }
}
