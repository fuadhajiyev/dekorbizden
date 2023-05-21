package az.code.dekor_bizden.controller;

import az.code.dekor_bizden.entities.FotoZona;
import az.code.dekor_bizden.entities.NikahDekor;
import az.code.dekor_bizden.services.FotoZonaService;
import az.code.dekor_bizden.services.NikahDekorService;
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
public class NikahController {

    @Autowired
    NikahDekorService nikahDekorService;


    @PostMapping("/nikahdekorlar")
    public GenericResponse createDekor(@Valid @RequestBody NikahDekor body) {

        NikahDekor nikahDekor = nikahDekorService.save(body);
        return new GenericResponse("nikah dekor yaradildi  !!!");

    }

    @GetMapping("/nikahdekorlar")
    public Page<NikahDekor> getMasaDekorlar(Pageable page) {
        return nikahDekorService.getNikahDekorlar(page);
    }

    @GetMapping("/allnikahdekorlar")
    @Transactional
    public List<NikahDekor> getFotoZonalar() {
        return nikahDekorService.getListNikahDekorlar();
    }




    @GetMapping("/nikahdekorlar/{itemCode}")
    @Transactional
    ResponseEntity<NikahDekor> getMasaDekor(@PathVariable String itemCode) {
        return ResponseEntity.ok(nikahDekorService.getByItemCode(itemCode));
    }




    @PutMapping("/nikahdekorlar/{itemCode}")
    @Transactional
    ResponseEntity<?> updateMasaDekor(@Valid @RequestBody NikahDekor body, @PathVariable String itemCode){
        NikahDekor updateNikahDekor = nikahDekorService.updateNikahDekor(body, itemCode);

        return  ResponseEntity.ok(updateNikahDekor);
    }


}
