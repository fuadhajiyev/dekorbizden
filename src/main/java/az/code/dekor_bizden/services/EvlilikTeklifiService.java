package az.code.dekor_bizden.services;

import az.code.dekor_bizden.entities.EvlilikTeklifiDekor;
import az.code.dekor_bizden.entities.FotoZona;
import az.code.dekor_bizden.error.NotFoundException;
import az.code.dekor_bizden.repo.EvlilikTeklifiRepo;
import az.code.dekor_bizden.repo.FotoZonaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EvlilikTeklifiService {
    EvlilikTeklifiRepo evlilikTeklifiRepo;

    public EvlilikTeklifiService(EvlilikTeklifiRepo evlilikTeklifiRepo) {
        this.evlilikTeklifiRepo = evlilikTeklifiRepo;
    }


    public EvlilikTeklifiDekor save(EvlilikTeklifiDekor body)  {


        return evlilikTeklifiRepo.save(body);
    }

    public Page<EvlilikTeklifiDekor> getEvlilikTeklifiDekor(Pageable page) {

        return evlilikTeklifiRepo.findAll(page);
    }


    public EvlilikTeklifiDekor getByItemCode(String itemCode) {
        EvlilikTeklifiDekor inDB = evlilikTeklifiRepo.findByItemCode(itemCode);
        if (inDB == null) {
            throw new NotFoundException();
        }
        return inDB;
    }

    public EvlilikTeklifiDekor updateEvlilikTeklifiDekor(EvlilikTeklifiDekor body, String itemCode) {
        EvlilikTeklifiDekor inDB = getByItemCode(itemCode);
        inDB.setTitle(body.getTitle());
        inDB.setDescription(body.getDescription());
        inDB.setPrice(body.getPrice());
        inDB.setItemCode(body.getItemCode());
        inDB.setCover_img(body.getCover_img());

        return evlilikTeklifiRepo.save(inDB);


    }


    public List<EvlilikTeklifiDekor> getListEvlilikTeklifiDekorlar() {

        return evlilikTeklifiRepo.findAllByOrderByIdDesc();

    }
}
