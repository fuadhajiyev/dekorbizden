package az.code.dekor_bizden.services;

import az.code.dekor_bizden.entities.FotoZona;
import az.code.dekor_bizden.entities.NikahDekor;
import az.code.dekor_bizden.error.NotFoundException;
import az.code.dekor_bizden.repo.FotoZonaRepo;
import az.code.dekor_bizden.repo.NikahDekorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NikahDekorService {
    NikahDekorRepo nikahDekorRepo;

    public NikahDekorService(NikahDekorRepo nikahDekorRepo) {
        this.nikahDekorRepo = nikahDekorRepo;
    }


    public NikahDekor save(NikahDekor body)  {


        return nikahDekorRepo.save(body);
    }

    public Page<NikahDekor> getNikahDekorlar(Pageable page) {

        return nikahDekorRepo.findAll(page);
    }


    public NikahDekor getByItemCode(String itemCode) {
        NikahDekor inDB = nikahDekorRepo.findByItemCode(itemCode);
        if (inDB == null) {
            throw new NotFoundException();
        }
        return inDB;
    }

    public NikahDekor updateNikahDekor(NikahDekor body, String itemCode) {
        NikahDekor inDB = getByItemCode(itemCode);
        inDB.setTitle(body.getTitle());
        inDB.setDescription(body.getDescription());
        inDB.setPrice(body.getPrice());
        inDB.setItemCode(body.getItemCode());
        inDB.setCover_img(body.getCover_img());

        return nikahDekorRepo.save(inDB);


    }


    public List<NikahDekor> getListNikahDekorlar() {

        return nikahDekorRepo.findAllByOrderByIdDesc();

    }
}
