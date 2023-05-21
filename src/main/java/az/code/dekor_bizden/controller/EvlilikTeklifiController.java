package az.code.dekor_bizden.controller;

import az.code.dekor_bizden.entities.EvlilikTeklifiDekor;
import az.code.dekor_bizden.entities.FotoZona;
import az.code.dekor_bizden.services.EvlilikTeklifiService;
import az.code.dekor_bizden.services.FotoZonaService;
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
public class EvlilikTeklifiController {

    @Autowired
    EvlilikTeklifiService evlilikTeklifiService;


    @PostMapping("/evlilik/teklifi/dekorlar")
    public GenericResponse createDekor(@Valid @RequestBody EvlilikTeklifiDekor body) {

        EvlilikTeklifiDekor evlilikTeklifiDekor = evlilikTeklifiService.save(body);
        return new GenericResponse("evlilik teklifi dekoru  yaradildi  !!!");

    }

    @GetMapping("/evlilik/teklifi/dekorlar")
    public Page<EvlilikTeklifiDekor> getEvlilikTeklifiDekorlar(Pageable page) {
        return evlilikTeklifiService.getEvlilikTeklifiDekor(page);
    }

    @GetMapping("/all/evlilik/teklifi/dekorlar")
    @Transactional
    public List<EvlilikTeklifiDekor> getEvlilikTeklifiDekorlar() {
        return evlilikTeklifiService.getListEvlilikTeklifiDekorlar();
    }




    @GetMapping("/evlilik/teklifi/dekorlar/{itemCode}")
    @Transactional
    ResponseEntity<EvlilikTeklifiDekor> getEvlilikTeklifiDekor(@PathVariable String itemCode) {
        return ResponseEntity.ok(evlilikTeklifiService.getByItemCode(itemCode));
    }




    @PutMapping("/evlilik/teklifi/dekorlar/{itemCode}")
    @Transactional
    ResponseEntity<?> updateEvlilikTeklifiDekor(@Valid @RequestBody EvlilikTeklifiDekor body, @PathVariable String itemCode){
        EvlilikTeklifiDekor updateMasaDekor = evlilikTeklifiService.updateEvlilikTeklifiDekor(body, itemCode);

        return  ResponseEntity.ok(updateMasaDekor);
    }


}
