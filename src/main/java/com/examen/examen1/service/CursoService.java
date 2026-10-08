package com.examen.examen1.service;

import com.examen.examen1.dto.CursoDTO;
import com.examen.examen1.model.Curso;
import com.examen.examen1.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    private CursoDTO toDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        dto.setDescripcion(curso.getDescripcion());
        dto.setDuracionHoras(curso.getDuracionHoras());
        dto.setNivel(curso.getNivel());
        return dto;
    }

    private Curso toEntity(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setId(dto.getId());
        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setDuracionHoras(dto.getDuracionHoras());
        curso.setNivel(dto.getNivel());
        return curso;
    }

    public CursoDTO crear(CursoDTO dto) {
        return toDTO(cursoRepository.save(toEntity(dto)));
    }

    public List<CursoDTO> listarTodos() {
        return cursoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CursoDTO> buscarPorId(Long id) {
        return cursoRepository.findById(id).map(this::toDTO);
    }

    public Optional<CursoDTO> actualizar(Long id, CursoDTO dto) {
        return cursoRepository.findById(id).map(existente -> {
            existente.setNombre(dto.getNombre());
            existente.setDescripcion(dto.getDescripcion());
            existente.setDuracionHoras(dto.getDuracionHoras());
            existente.setNivel(dto.getNivel());
            return toDTO(cursoRepository.save(existente));
        });
    }

    public boolean eliminar(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}