package az.code.dekor_bizden.controller;

import az.code.dekor_bizden.entities.MasaDekor;
import az.code.dekor_bizden.entities.XinaDekor;
import az.code.dekor_bizden.services.MasaDekorService;
import az.code.dekor_bizden.services.XinaDekorService;
import az.code.dekor_bizden.shared.GenericResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/1.0")
@Slf4j
@CrossOrigin(origins = "*")
public class XinaController {

    @Autowired
    XinaDekorService xinaDekorService;


    @PostMapping("/xinadekorlar")
    public GenericResponse createDekor(@Valid @RequestBody XinaDekor body) {

        XinaDekor xinaDekor = xinaDekorService.save(body);
        return new GenericResponse("xina dekor yaradildi  !!!");

    }

    @GetMapping("/xinadekorlar")
    public Page<XinaDekor> getMasaDekorlar(Pageable page) {
        return xinaDekorService.getXinaDekorlar(page);
    }

    @GetMapping("/allxinadekorlar")
    @Transactional
    public List<XinaDekor> getMasaDekorlar(String type) {
        return xinaDekorService.getListXinaDekorlar(type);
    }




    @GetMapping("/xinadekorlar/{itemCode}")
    @Transactional
    ResponseEntity<XinaDekor> getMasaDekor(@PathVariable String itemCode) {
        return ResponseEntity.ok(xinaDekorService.getByItemCode(itemCode));
    }




    @PutMapping("/xinadekorlar/{itemCode}")
    @Transactional
    ResponseEntity<?> updateMasaDekor(@Valid @RequestBody XinaDekor body, @PathVariable String itemCode){
        XinaDekor updateMasaDekor = xinaDekorService.updateMasaDekor(body, itemCode);

        return  ResponseEntity.ok(updateMasaDekor);
    }


}
