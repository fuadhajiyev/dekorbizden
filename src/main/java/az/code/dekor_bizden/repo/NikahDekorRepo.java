package az.code.dekor_bizden.repo;

import az.code.dekor_bizden.entities.FotoZona;
import az.code.dekor_bizden.entities.NikahDekor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NikahDekorRepo extends JpaRepository<NikahDekor, Long> {

    NikahDekor findByItemCode(String itemCode);


    List<NikahDekor> findAllByOrderByIdDesc();
}
