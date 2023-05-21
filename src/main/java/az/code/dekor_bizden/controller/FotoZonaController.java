package az.code.dekor_bizden.controller;

import az.code.dekor_bizden.entities.FotoZona;
import az.code.dekor_bizden.entities.MasaDekor;
import az.code.dekor_bizden.services.FotoZonaService;
import az.code.dekor_bizden.services.MasaDekorService;
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
public class FotoZonaController {

    @Autowired
    FotoZonaService fotoZonaService;


    @PostMapping("/fotozonalar")
    public GenericResponse createDekor(@Valid @RequestBody FotoZona body) {
        log.info(body.getCover_img());
        log.info(body.getTitle());
        FotoZona fotoZona = fotoZonaService.save(body);
        return new GenericResponse("foto zona yaradildi  !!!");

    }

    @GetMapping("/fotozonalar")
    public Page<FotoZona> getMasaDekorlar(Pageable page) {
        return fotoZonaService.getFotoZonalar(page);
    }

    @GetMapping("/allfotozonalar")
    @Transactional
    public List<FotoZona> getFotoZonalar() {
        return fotoZonaService.getListFotozonalar();
    }




    @GetMapping("/fotozonalar/{itemCode}")
    @Transactional
    ResponseEntity<FotoZona> getMasaDekor(@PathVariable String itemCode) {
        return ResponseEntity.ok(fotoZonaService.getByItemCode(itemCode));
    }




    @PutMapping("/fotozonalar/{itemCode}")
    @Transactional
    ResponseEntity<?> updateMasaDekor(@Valid @RequestBody FotoZona body, @PathVariable String itemCode){
       FotoZona updateMasaDekor = fotoZonaService.updateFotoZona(body, itemCode);

        return  ResponseEntity.ok(updateMasaDekor);
    }


}
