package tech.devinhouse.ProjetoVeiculos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Veiculo {
    @Id
    private String placa;

    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipo;

    private String nome;
    private Integer anoFabricacao;
    private String cor;

    @OneToMany(mappedBy = "veiculo")
    private List<Multa> multas;
}
