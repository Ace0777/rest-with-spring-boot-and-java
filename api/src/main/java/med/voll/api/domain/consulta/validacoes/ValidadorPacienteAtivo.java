package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoExpection;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo  implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        if (dados.idMedico() == null){
            return;
        }


        var pacienteEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!pacienteEstaAtivo){
            throw new ValidacaoExpection("Consulta não pode ser agendada com paciente excluido!");
        }
    }
}
