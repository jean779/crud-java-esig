package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.hibernate.internal.build.AllowSysOut;
import org.omnifaces.util.Messages;
import org.omnifaces.util.Messages.Message;

import dao.ColaboradorDAO;
import dao.TarefasDAO;
import domain.Colaborador;
import domain.Tarefas;
import lombok.Data;

@SuppressWarnings("serial")
@Named
@ViewScoped
@Data
public class TarefasBean implements Serializable {
	private Tarefas tarefas;
	private List<Colaborador> colaborador;
	private List<Tarefas> tlist;

	private ColaboradorDAO cdao;
	private TarefasDAO tdao;

	private Integer id;
	private String titulo;
	private boolean status;
	private String prioridade;
	private Colaborador colab;

	@PostConstruct
	public void iniciar() {
		cdao = new ColaboradorDAO();
		tdao = new TarefasDAO();
		limpar();
	}

	public void tlist() {
		tdao.save(tarefas);
		limpar();
		Messages.addGlobalInfo("A tarefa salva com sucesso!");

	}

	public void Selecionar(Tarefas tarefaSelecionada) {
		tarefas = tarefaSelecionada;
	}

	public void limpar() {
		tarefas = new Tarefas();
		colaborador = cdao.listar();
		tlist = tdao.listar();
	}

	public void excluir() {
		tdao.delete(tarefas.getId());
		limpar();
		Messages.addGlobalInfo("Tarefa " + this.tarefas.getTitulo() + " foi excluida com sucesso!");
	}

	public void editar() {
		tdao.editar(tarefas);
		limpar();
		Messages.addGlobalInfo("Tarefa " + this.tarefas.getTitulo() + " alterada com sucesso!");
	}

	public void cadastrarTarefa() {
		this.tdao.save(this.tarefas);
		Messages.addFlashGlobalInfo("Tarefa " + this.tarefas.getTitulo() + " cadastrada com sucesso");
		limpar();
	}

	public void concluirTarefa() {
		Messages.addFlashGlobalInfo("Tarefa " + this.tarefas.getTitulo() + " concluida com sucesso");
		this.tarefas.setStatus(true);
		tdao.editar(this.tarefas);
		limpar();
	}

	public void listarTarefasStatus() {
		Messages.addFlashGlobalInfo("Tarefas listadas por Status");
		this.tlist = this.tdao.listarTarefasStatus(this.status);
		System.out.println(tlist);
	}

	public void listarTarefasId() {
		Messages.addFlashGlobalInfo("Tarefas listadas por ID");
		this.tlist = this.tdao.listarTarefasNumero(this.id);
	}

	public void listarTarefasTitulo() {
		Messages.addFlashGlobalInfo("Tarefas listadas por titulo");
		this.tlist = this.tdao.listarTarefasTitulo(this.titulo + "");
	}

	public void listarTarefasPrioriade() {
		Messages.addFlashGlobalInfo("Tarefas listadas por prioriade");
		this.tlist = this.tdao.listarTarefasPrioridade(prioridade);
		System.out.println(tlist);
	}

	public void listarTarefasColaborador() {
		Messages.addFlashGlobalInfo("Tarefas listadas por Colaborador");
		this.tlist = this.tdao.listarTarefasColaborador(colab);

	}
}
