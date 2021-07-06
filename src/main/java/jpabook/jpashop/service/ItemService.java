package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void save(Item item) {
        itemRepository.save(item);
    }
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
    public Item findOne(Long itemId) {
        return itemRepository.find(itemId);
    }


}
