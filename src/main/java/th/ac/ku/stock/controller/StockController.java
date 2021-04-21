package th.ac.ku.stock.controller;

import org.springframework.web.bind.annotation.*;
import th.ac.ku.stock.data.StockRepository;
import th.ac.ku.stock.model.Stock;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private StockRepository repository;

    public StockController(StockRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Stock> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Stock getOne(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Stock create(@RequestBody Stock stock) {
        Stock record = repository.save(stock);
        repository.flush();
        return record;
    }



    @PutMapping("/{id}")
    public Stock update(@RequestBody Stock stock,@PathVariable int id) {
        Stock record = null;
        try {
            if(repository.findById(id).get() == null){

            }
            else{
                System.out.println("work");
                record = repository.findById(id).get();
                record.setBalance(stock.getBalance());
                repository.save(record);
            }
        } catch (Exception e) {
            System.out.println(id);
        }
        return record;
    }

    @DeleteMapping("/{id}")
    public Stock delete(@PathVariable int id) {
        Stock record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }
}