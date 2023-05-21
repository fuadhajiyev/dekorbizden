package az.code.dekor_bizden.repo;

import az.code.dekor_bizden.entities.PartiDekor;
import az.code.dekor_bizden.entities.XinaDekor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PartiDekorRepo extends JpaRepository<PartiDekor, Long> {

    PartiDekor findByItemCode(String itemCode);


    List<PartiDekor> findAllByOrderByIdDesc();

    List<PartiDekor> findByTypeOrderByIdDesc(String type);

}
