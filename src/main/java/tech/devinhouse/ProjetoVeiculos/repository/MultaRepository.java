package tech.devinhouse.ProjetoVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.ProjetoVeiculos.model.Multa;

public interface MultaRepository  extends JpaRepository<Multa, Integer> {
}
