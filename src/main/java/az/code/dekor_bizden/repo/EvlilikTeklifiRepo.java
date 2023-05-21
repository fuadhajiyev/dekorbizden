package az.code.dekor_bizden.repo;

import az.code.dekor_bizden.entities.EvlilikTeklifiDekor;
import az.code.dekor_bizden.entities.FotoZona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EvlilikTeklifiRepo extends JpaRepository<EvlilikTeklifiDekor, Long> {

    EvlilikTeklifiDekor findByItemCode(String itemCode);


    List<EvlilikTeklifiDekor> findAllByOrderByIdDesc();
}
