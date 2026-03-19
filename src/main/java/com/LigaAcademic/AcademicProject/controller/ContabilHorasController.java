package com.LigaAcademic.AcademicProject.controller;


import com.LigaAcademic.AcademicProject.model.ContabilHoras;
import com.LigaAcademic.AcademicProject.service.ContabilHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/contabilhoras")
public class ContabilHorasController {


    @Autowired
    private ContabilHorasService contabilHorasService;

    @PostMapping
    public String contabilizarHoras(@RequestBody ContabilHoras contabilHoras){
        contabilHorasService.registrarHoras(contabilHoras);
        return "Horas contabilizada";
    }
}
