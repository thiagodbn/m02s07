package tech.devinhouse.ProjetoVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.ProjetoVeiculos.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
}
