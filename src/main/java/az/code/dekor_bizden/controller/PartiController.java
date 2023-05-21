package az.code.dekor_bizden.controller;

import az.code.dekor_bizden.entities.PartiDekor;
import az.code.dekor_bizden.entities.XinaDekor;
import az.code.dekor_bizden.services.PartiDekorService;
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
public class PartiController {

    @Autowired
    PartiDekorService partiDekorService;


    @PostMapping("/partidekorlar")
    public GenericResponse createDekor(@Valid @RequestBody PartiDekor body) {

        PartiDekor partiDekor= partiDekorService.save(body);
        return new GenericResponse("parti dekor yaradildi  !!!");

    }

    @GetMapping("/partidekorlar")
    public Page<PartiDekor> getMasaDekorlar(Pageable page) {
        return partiDekorService.getPartiDekorlar(page);
    }

    @GetMapping("/allpartidekorlar")
    @Transactional
    public List<PartiDekor> getMasaDekorlar(String type) {
        return partiDekorService.getListPartiDekorlar(type);
    }




    @GetMapping("/partidekorlar/{itemCode}")
    @Transactional
    ResponseEntity<PartiDekor> getMasaDekor(@PathVariable String itemCode) {
        return ResponseEntity.ok(partiDekorService.getByItemCode(itemCode));
    }




    @PutMapping("/partidekorlar/{itemCode}")
    @Transactional
    ResponseEntity<?> updateMasaDekor(@Valid @RequestBody PartiDekor body, @PathVariable String itemCode){
        PartiDekor updatePartiDekor = partiDekorService.updatePartiDekor(body, itemCode);

        return  ResponseEntity.ok(updatePartiDekor);
    }


}
