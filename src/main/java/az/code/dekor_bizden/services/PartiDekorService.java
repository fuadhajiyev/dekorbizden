package az.code.dekor_bizden.services;

import az.code.dekor_bizden.entities.PartiDekor;
import az.code.dekor_bizden.entities.XinaDekor;
import az.code.dekor_bizden.error.NotFoundException;
import az.code.dekor_bizden.repo.PartiDekorRepo;
import az.code.dekor_bizden.repo.XinaDekorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PartiDekorService {
    PartiDekorRepo partiDekorRepo;

    public PartiDekorService(PartiDekorRepo partiDekorRepo) {
        this.partiDekorRepo = partiDekorRepo;
    }


    public PartiDekor save(PartiDekor body)  {

        return partiDekorRepo.save(body);
    }

    public Page<PartiDekor> getPartiDekorlar(Pageable page) {


        return partiDekorRepo.findAll(page);
    }


    public List<PartiDekor> getListPartiDekorlar(String type) {

        return partiDekorRepo.findByTypeOrderByIdDesc(type);
    }

    public PartiDekor getByItemCode(String itemCode) {
        PartiDekor inDB = partiDekorRepo.findByItemCode(itemCode);
        if (inDB == null) {
            throw new NotFoundException();
        }
        return inDB;
    }

    public PartiDekor updatePartiDekor(PartiDekor body, String itemCode) {
        PartiDekor inDB = getByItemCode(itemCode);
        inDB.setTitle(body.getTitle());
        inDB.setDescription(body.getDescription());
        inDB.setPrice(body.getPrice());
        inDB.setType(body.getType());
        inDB.setGuest_count(body.getGuest_count());
        inDB.setItemCode(body.getItemCode());
        inDB.setCover_img(body.getCover_img());
        inDB.setImg_one(body.getImg_one());


        return partiDekorRepo.save(inDB);


    }


}
