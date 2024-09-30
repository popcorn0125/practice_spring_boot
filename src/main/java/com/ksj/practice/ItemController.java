package com.ksj.practice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    @GetMapping("/list")
    String list(Model model) {
        System.out.println("ItemController - GET - list 실행");
        model.addAttribute("items", itemService.list());
        return "list";

    }

    @GetMapping("/addItem")
    public String addItem(Model model) {
        System.out.println("ItemController - GET - addItem 실행");
        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItem(@ModelAttribute Item item) {
        System.out.println("ItemController - POST - addItem 실행");
        itemService.addItem(item);
        return "redirect:/list";
    }

    @GetMapping("/detailItem/{id}")
    public String detailItem(Model model, @PathVariable("id") Long id) {
        System.out.println("ItemController - GET - detailItem 실행");
        Optional<Item> result = itemService.detailItem(id);
        if(result.isPresent()) {
            model.addAttribute("item", result.get());
            return "detailItem";
        }
        else {
            return "redirect:/list";
        }
    }

    @GetMapping("/test/{test}")
    ResponseEntity<String> test() throws Exception {
        throw new Exception("예외처리");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @GetMapping("/updateItem/{id}")
    public String updateItem(Model model, @PathVariable("id")Long id) {
        System.out.println("ItemController - GET - updateItem 실행");
        Optional<Item> result = itemService.detailItem(id);
        if(result.isPresent()){
            model.addAttribute("item", result.get());
            return "editItem";
        }else {
            return "redirect:/list";
        }

    }

    @PostMapping("/editItem")
    public String editItem(@ModelAttribute Item item) {
        System.out.println("ItemController - POST - editItem 실행");
        itemService.editItem(item);
        return "redirect:/list";
    }

    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Long id) {
        System.out.println("ItemController - GET - deleteItem 실행");
        itemService.deleteItem(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
