package com.rennan.wkt.controller;

import com.rennan.wkt.domain.AgeRangeIMC;
import com.rennan.wkt.domain.BloodTypeQuant;
import com.rennan.wkt.domain.EstateQuant;
import com.rennan.wkt.domain.Obesity;
import com.rennan.wkt.service.DonatorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Donators")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DonatorController {

    private final DonatorService donatorService;

    @GetMapping("/states")
    public List<EstateQuant> listStates(){
        return donatorService.quantByState();
    }

    @GetMapping("/imc")
    public List<AgeRangeIMC> listImc(){
        return donatorService.imc10A10();
    }

    @GetMapping("/obesity")
    public List<Obesity> listObesity(){
        return donatorService.obesityByGender();
    }

    @GetMapping("/bloodType")
    public List<BloodTypeQuant> listBloodType(){
        return donatorService.bloodTypeQuant();
    }

    @GetMapping("/receptors")
    public List<BloodTypeQuant> listReceptors(){
        return donatorService.receptorsQuant();
    }
}
