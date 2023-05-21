package az.code.dekor_bizden.services;

import az.code.dekor_bizden.entities.MasaDekor;
import az.code.dekor_bizden.error.NotFoundException;
import az.code.dekor_bizden.file.FileService;
import az.code.dekor_bizden.repo.MasaDekorRepo;
import az.code.dekor_bizden.shared.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Base64;
import java.util.List;

@Service
@Slf4j
public class MasaDekorService {
    MasaDekorRepo masaDekorRepo;
    FileService fileService;

    public MasaDekorService(MasaDekorRepo masaDekorRepo,  FileService fileService) {
        this.masaDekorRepo = masaDekorRepo;
        this.fileService = fileService;
    }


    public MasaDekor save(MasaDekor body)  {


//        if (body.getCover_img() != null && body.getCover_img() != "") {
//            try {
//                String coverImgName = fileService.writeBase64EncodedStringToFile(body.getCover_img());
//
//                body.setCover_img(coverImgName);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }


        return masaDekorRepo.save(body);
    }

    public Page<MasaDekor> getMasaDekorlar(Pageable page) {


        return masaDekorRepo.findAll(page);
    }


    public List<MasaDekor> getListMasaDekorlar(String type) {

        return masaDekorRepo.findByType(type);
    }

    public MasaDekor getByItemCode(String itemCode) {
        MasaDekor inDB = masaDekorRepo.findByItemCode(itemCode);
        if (inDB == null) {
            throw new NotFoundException();
        }
        return inDB;
    }

    public MasaDekor updateMasaDekor(MasaDekor body, String itemCode) {
        MasaDekor inDB = getByItemCode(itemCode);
        inDB.setTitle(body.getTitle());
        inDB.setDescription(body.getDescription());
        inDB.setPrice(body.getPrice());
        inDB.setType(body.getType());
        inDB.setGuest_count(body.getGuest_count());
        inDB.setItemCode(body.getItemCode());

        if (body.getCover_img() != null) {
            String oldImageName = inDB.getCover_img();
            try {
                String pictureFileName = fileService.writeBase64EncodedStringToFile(body.getCover_img());
                inDB.setCover_img(pictureFileName);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fileService.deleteFile(oldImageName);


        }

        return masaDekorRepo.save(inDB);


    }




    public List<MasaDekor> getSearchByItemCode(String itemCode) {
        List<MasaDekor> inDB = masaDekorRepo.findByItemCodeLike(itemCode);
        if (inDB == null) {
            throw new NotFoundException();
        }
        return inDB;
    }
}
