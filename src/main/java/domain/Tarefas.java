package domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarefas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarefas {
	@Id
	@SequenceGenerator(name="tarefa_idtarefa_seq",
	sequenceName="tarefa_idtarefa_seq",
	allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator="tarefa_idtarefa_seq")
	@Column(name="id", columnDefinition = "serial", updatable = false) 
	private Integer id;
	
	@Column(nullable = false)
	private boolean status = false;

	@Column(length = 80, nullable = false, unique = true, name = "titulo")
	@NotBlank(message = "O Campo (Titulo) é obrigatório!")
	private String titulo;
	
	@Column(length = 100, name = "descricao")
	@NotBlank(message = "O Campo (Descrição) é obrigatório!")
	private String descricao;

	@Column(length = 80, name = "prioridade", nullable = false)
	@NotBlank(message = "O Campo (Prioridade) é obrigatório!")
	private String prioridade;

	@Column(name = "data", nullable = false )
	@Future(message = "A data deve ser uma data futura")
	@javax.validation.constraints.NotNull(message = "O campo (Data) é obrigatório!")
	private LocalDate data;
	

	
	
	@ManyToOne
	@javax.validation.constraints.NotNull(message= "O campo (Responsável) é obrigatório!")
	@JoinColumn(nullable = false)
	private Colaborador responsavel;
	


}
