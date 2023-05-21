package az.code.dekor_bizden.repo;

import az.code.dekor_bizden.entities.FotoZona;
import az.code.dekor_bizden.entities.MasaDekor;
import az.code.dekor_bizden.entities.XinaDekor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface XinaDekorRepo extends JpaRepository<XinaDekor, Long> {

    XinaDekor findByItemCode(String itemCode);


    List<XinaDekor> findAllByOrderByIdDesc();

    List<XinaDekor> findByTypeOrderByIdDesc(String type);

}
