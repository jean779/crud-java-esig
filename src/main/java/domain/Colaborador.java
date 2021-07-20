package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "colaborador")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Colaborador {

	@Id
	@SequenceGenerator(name = "colaborador_idcolaborador_seq", sequenceName = "colaborador_idcolaborador_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "colaborador_idcolaborador_seq")
	@Column(name = "id", columnDefinition = "serial", updatable = false)
	private Integer id;

	@Column(length = 50, nullable = false, name = "cargo")
	@NotBlank(message = "O Campo (Cargo) é obrigatório!")
	private String cargo;

	@Column(length = 50, nullable = false, name = "nome")
	@NotBlank(message = "O Campo (Nome) é obrigatório!")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
