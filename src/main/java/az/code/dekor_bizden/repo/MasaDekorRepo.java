package az.code.dekor_bizden.repo;

import az.code.dekor_bizden.entities.MasaDekor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MasaDekorRepo extends JpaRepository<MasaDekor, Long> {

    MasaDekor findByItemCode(String itemCode);

    List<MasaDekor> findByItemCodeLike(String itemCode);

    List<MasaDekor> findByType(String type);

}
