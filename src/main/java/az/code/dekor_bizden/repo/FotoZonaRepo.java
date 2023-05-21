package az.code.dekor_bizden.repo;

import az.code.dekor_bizden.entities.FotoZona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FotoZonaRepo extends JpaRepository<FotoZona, Long> {

    FotoZona findByItemCode(String itemCode);


    List<FotoZona> findAllByOrderByIdDesc();
}
