package th.ac.ku.stock.data;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.ku.stock.model.Stock;


public interface StockRepository extends JpaRepository<Stock,Integer> {

}
