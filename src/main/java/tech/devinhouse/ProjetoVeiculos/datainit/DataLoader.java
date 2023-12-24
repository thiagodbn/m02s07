package tech.devinhouse.ProjetoVeiculos.datainit;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.devinhouse.ProjetoVeiculos.model.Multa;
import tech.devinhouse.ProjetoVeiculos.model.TipoVeiculo;
import tech.devinhouse.ProjetoVeiculos.model.Veiculo;
import tech.devinhouse.ProjetoVeiculos.repository.MultaRepository;
import tech.devinhouse.ProjetoVeiculos.repository.VeiculoRepository;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MultaRepository multaRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Veiculo veiculo1 = new Veiculo("ABC-1234", TipoVeiculo.AUTOMOVEL, "Bat-Movel", 2022, "preto");
        Veiculo veiculo2 = new Veiculo("BCA-4321", TipoVeiculo.ONIBUS, "Enterprise", 1960, "prata");

        veiculoRepository.saveAll(Arrays.asList(veiculo1, veiculo2));

        Multa multa1 = new Multa("Farol apagado", "Gotham City", 250.0f, veiculo1);
        Multa multa2 = new Multa("Insulfilm", "Gotham City", 100.0f, veiculo1);
        Multa multa3 = new Multa("Excesso de velocidade", "Hiper-espaço", 400.0f, veiculo2);

        multaRepository.saveAll(Arrays.asList(multa1, multa2, multa3));

        // Alterar o valor da multa do segundo veículo
        multa3.setValor(380.0f);
        multaRepository.save(multa3);

        // Imprimir veículos e multas
        veiculoRepository.findAll().forEach(veiculo -> {
            System.out.println(veiculo);
            if (veiculo.getMultas() != null) {
                veiculo.getMultas().forEach(System.out::println);
            }
        });
    }
}
