package com.LigaAcademic.AcademicProject.service;

import com.LigaAcademic.AcademicProject.model.Membro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LigaAcademic.AcademicProject.repository.MembroRepository;

import java.util.List;

@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    public void registrarMembro(Membro membronovo) {

        if (membronovo.getNome() == null || membronovo.getNome().trim().isEmpty()){
            System.out.println("O nome não pode ser nulo");
            return;
        }
        if (membronovo.getMatricula() == null || membronovo.getMatricula().length() < 11 || membronovo.getMatricula().length() > 11 || !membronovo.getMatricula().matches("[0-9]+")) {
            System.out.println("O número de mátricula precisa ter 11 dígitos");
            return;
        }

        if (!membronovo.getEmail().contains("@") || membronovo.getEmail().trim().isEmpty()) {
            System.out.println("Coloque um email válido");
            return;
        }
        if (membronovo.getCargo() == null || membronovo.getCargo().trim().isEmpty()) {
            System.out.println("Cargo do membro não pode ser vazio");
            return;
        }

        membroRepository.save(membronovo);
    }

    public void removerMembro(String matriculaRemove){
        if(matriculaRemove == null || matriculaRemove.trim().isEmpty()){
            System.out.println("A matricula informada está em branco ou é inválida");
            return;
        }

            Membro membroEncontrado = membroRepository.findByMatricula(matriculaRemove);

        if(membroEncontrado != null){
            System.out.println("Membro encontrado");
            membroRepository.delete(membroEncontrado);
        }else{
            System.out.println("Membro não econtrado");
        }

    }

    public void atualizarMembro(String nome,String matricula, String email, String cargo){

        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("O nome não pode ser nulo");
            return;
        }
        if (matricula == null || matricula.length() < 11 || matricula.length() > 11 || !matricula.matches("[0-9]+")) {
            System.out.println("O número de mátricula precisa ter 11 dígitos");
            return;
        }

        if (email == null || !email.contains("@") || email.trim().isEmpty()) {
            System.out.println("Coloque um email válido");
            return;
        }
        if (cargo == null || cargo.trim().isEmpty()) {
            System.out.println("Cargo do membro não pode ser vazio");
            return;
        }
    }

    public void listarMembro(String matricula){
        if (matricula == null || matricula.length() < 11 || matricula.length() > 11 || !matricula.matches("[0-9]+")) {
            System.out.println("O número de mátricula precisa ter 11 dígitos ou não existe");
            return;
        }
        Membro membroMatricula = membroRepository.findByMatricula(matricula);
    }

    public List<Membro> listaTodos(){
        return membroRepository.findAll();
    }
}
