package com.LigaAcademic.AcademicProject.service;

import com.LigaAcademic.AcademicProject.model.ContabilHoras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LigaAcademic.AcademicProject.repository.ContabilHorasRepository;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ContabilHorasService {

    @Autowired
    private ContabilHorasRepository contabilHorasRepository;

    public void registrarHoras(ContabilHoras contabilHoras){

        if(contabilHoras.getParticipantes()==null || contabilHoras.getParticipantes().trim().isEmpty()){
            System.out.println("Adicione ao menos 1 participante");
            return;
        }
        if(contabilHoras.getTipoAtividade() == null || contabilHoras.getTipoAtividade().trim().isEmpty()){
            System.out.println("Adicione ao menos 1 atividade realizada");
            return;
        }
        if(contabilHoras.getDescAtividade() == null || contabilHoras.getDescAtividade().trim().isEmpty()){
            System.out.println("Adicione uma descrição na atividade");
            return;
        }
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try{
            contabilHorasRepository.save(contabilHoras);
        }catch (DateTimeException e){
            System.out.println("Erro de validação: A data" + contabilHoras.getDataAtividade() + "é inválida");
            System.out.println("Utilize estruitamente o formato: AAAA-MM-DD");
        }

    }

    public List<ContabilHoras> listarTodos(){
        return contabilHorasRepository.findAll();
    }
}
