package tech.devinhouse.ProjetoVeiculos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String local;
    private String motivo;
    private Float valor;

    @ManyToOne
    @JoinColumn(name = "placa_veiculo")
    private Veiculo veiculo;

    public Multa(String motivo, String local, float valor, Veiculo veiculo) {
        this.motivo = motivo;
        this.local = local;
        this.valor = valor;
        this.veiculo = veiculo;
    }
}
