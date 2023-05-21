package az.code.dekor_bizden.services;

import az.code.dekor_bizden.entities.MasaDekor;
import az.code.dekor_bizden.entities.XinaDekor;
import az.code.dekor_bizden.error.NotFoundException;
import az.code.dekor_bizden.file.FileService;
import az.code.dekor_bizden.repo.MasaDekorRepo;
import az.code.dekor_bizden.repo.XinaDekorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class XinaDekorService {
    XinaDekorRepo xinaDekorRepo;

    public XinaDekorService(XinaDekorRepo xinaDekorRepo) {
        this.xinaDekorRepo = xinaDekorRepo;
    }


    public XinaDekor save(XinaDekor body)  {


//        if (body.getCover_img() != null && body.getCover_img() != "") {
//            try {
//                String coverImgName = fileService.writeBase64EncodedStringToFile(body.getCover_img());
//
//                body.setCover_img(coverImgName);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }


        return xinaDekorRepo.save(body);
    }

    public Page<XinaDekor> getXinaDekorlar(Pageable page) {


        return xinaDekorRepo.findAll(page);
    }


    public List<XinaDekor> getListXinaDekorlar(String type) {

        return xinaDekorRepo.findByTypeOrderByIdDesc(type);
    }

    public XinaDekor getByItemCode(String itemCode) {
        XinaDekor inDB = xinaDekorRepo.findByItemCode(itemCode);
        if (inDB == null) {
            throw new NotFoundException();
        }
        return inDB;
    }

    public XinaDekor updateMasaDekor(XinaDekor body, String itemCode) {
        XinaDekor inDB = getByItemCode(itemCode);
        inDB.setTitle(body.getTitle());
        inDB.setDescription(body.getDescription());
        inDB.setPrice(body.getPrice());
        inDB.setType(body.getType());
        inDB.setGuest_count(body.getGuest_count());
        inDB.setItemCode(body.getItemCode());
        inDB.setCover_img(body.getCover_img());


        return xinaDekorRepo.save(inDB);


    }


}
