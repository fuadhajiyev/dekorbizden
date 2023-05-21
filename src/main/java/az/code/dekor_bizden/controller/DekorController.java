package az.code.dekor_bizden.controller;

import az.code.dekor_bizden.entities.MasaDekor;
import az.code.dekor_bizden.services.MasaDekorService;
import az.code.dekor_bizden.shared.GenericResponse;
import com.fasterxml.jackson.core.JsonParser;
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
public class DekorController {

    @Autowired
    MasaDekorService masaDekorService;


    @PostMapping("/dekorlar")
    public GenericResponse createDekor(@Valid @RequestBody MasaDekor body) {
        log.info(body.getCover_img());
        log.info(body.getTitle());
        MasaDekor masaDekor = masaDekorService.save(body);
        return new GenericResponse("masa dekor yaradildi  !!!");

    }

    @GetMapping("/dekorlar")
    public Page<MasaDekor> getMasaDekorlar(Pageable page) {
        return masaDekorService.getMasaDekorlar(page);
    }

    @GetMapping("/alldekorlar")
    @Transactional
    public List<MasaDekor> getMasaDekorlar(String type) {
        return masaDekorService.getListMasaDekorlar(type);
    }




    @GetMapping("/dekorlar/{itemCode}")
    @Transactional
    ResponseEntity<MasaDekor> getMasaDekor(@PathVariable String itemCode) {
        return ResponseEntity.ok(masaDekorService.getByItemCode(itemCode));
    }




    @PutMapping("/dekorlar/{itemCode}")
    @Transactional
    ResponseEntity<?> updateMasaDekor(@Valid @RequestBody MasaDekor body, @PathVariable String itemCode){
       MasaDekor updateMasaDekor = masaDekorService.updateMasaDekor(body, itemCode);

        return  ResponseEntity.ok(updateMasaDekor);
    }


}
