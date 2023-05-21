package az.code.dekor_bizden.services;

import az.code.dekor_bizden.entities.FotoZona;
import az.code.dekor_bizden.entities.MasaDekor;
import az.code.dekor_bizden.error.NotFoundException;
import az.code.dekor_bizden.file.FileService;
import az.code.dekor_bizden.repo.FotoZonaRepo;
import az.code.dekor_bizden.repo.MasaDekorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class FotoZonaService {
    FotoZonaRepo fotoZonaRepo;

    public FotoZonaService(FotoZonaRepo fotoZonaRepo) {
        this.fotoZonaRepo = fotoZonaRepo;
    }


    public FotoZona save(FotoZona body)  {


        return fotoZonaRepo.save(body);
    }

    public Page<FotoZona> getFotoZonalar(Pageable page) {

        return fotoZonaRepo.findAll(page);
    }


    public FotoZona getByItemCode(String itemCode) {
        FotoZona inDB = fotoZonaRepo.findByItemCode(itemCode);
        if (inDB == null) {
            throw new NotFoundException();
        }
        return inDB;
    }

    public FotoZona updateFotoZona(FotoZona body, String itemCode) {
        FotoZona inDB = getByItemCode(itemCode);
        inDB.setTitle(body.getTitle());
        inDB.setDescription(body.getDescription());
        inDB.setPrice(body.getPrice());
        inDB.setItemCode(body.getItemCode());
        inDB.setCover_img(body.getCover_img());

        return fotoZonaRepo.save(inDB);


    }


    public List<FotoZona> getListFotozonalar() {

        return fotoZonaRepo.findAllByOrderByIdDesc();

    }
}
