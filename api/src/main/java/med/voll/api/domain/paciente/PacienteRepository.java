package med.voll.api.domain.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {


    @Query("""
        select p.ativo
        from Paciente p
        where
        p.id = :id
        """)
    Boolean findAtivoById(Long id);


}
