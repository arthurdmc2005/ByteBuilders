
package com.LigaAcademic.AcademicProject.controller;

import com.LigaAcademic.AcademicProject.model.Membro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.LigaAcademic.AcademicProject.service.MembroService;

import java.util.List;

@RestController
@RequestMapping("/membros")
public class MembroController {

    @Autowired
    private MembroService membroService;

    @GetMapping
    public ResponseEntity<List<Membro>>listarTodos(){
        return ResponseEntity.ok(membroService.listaTodos());
    }


    @PostMapping
    public String adicionarMembro(@RequestBody Membro membro){
        membroService.registrarMembro(membro);
        return "Requisição recebida";
    }

    @GetMapping("/{matricula}")
    public String buscar(@PathVariable String matricula){
        membroService.listarMembro(matricula);
        return "Matricula buscada com sucesso";

    }

    @PutMapping("/{matricula}")
    public String atualizar(@PathVariable String matricula, @RequestBody Membro membroAtualizado){
        membroService.atualizarMembro(
                membroAtualizado.getNome(),
                matricula,
                membroAtualizado.getEmail(),
                membroAtualizado.getCargo()
        );
        return "Requisição PUT recebida!";
    }

    @DeleteMapping("/{matricula}")
    public String deletar(@PathVariable String matricula){
        membroService.removerMembro(matricula);
        return "Membro deletado";
    }
}
