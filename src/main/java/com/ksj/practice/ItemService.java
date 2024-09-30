package com.ksj.practice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    // 모든 상품 조회
    List<Item> list() {
        return itemRepository.findAll();
    }

    // 해당 상품 조회
    Optional<Item> detailItem(Long id) {
        return itemRepository.findById(id);
    }

    // 상품 등록
    void addItem(Item item) {
        itemRepository.save(item);
    }

    void editItem(Item item) {
        itemRepository.save(item);
    }

    void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
