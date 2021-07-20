package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dao.ColaboradorDAO;
import domain.Colaborador;
import lombok.Data;

@SuppressWarnings("serial")
@Named
@ViewScoped
@Data
public class ColaboradoresBean implements Serializable {
	private List<Colaborador> colaboradores;
	private Colaborador colaborador;
	private ColaboradorDAO cdao;

	@PostConstruct
	public void inciar() {
		cdao = new ColaboradorDAO();
		colaborador = new Colaborador();
		colaboradores = cdao.listar();
		limpar();

	}

	public void salvar() {
		cdao.save(colaborador);
		colaboradores = cdao.listar();
		Messages.addGlobalInfo("O colaborador " + colaborador.getNome() + " foi salvo com sucesso.");
		colaborador = new Colaborador();
	}

	public void Selecionar(Colaborador colaboradorSelecionado) {
		colaborador = colaboradorSelecionado;
		System.out.println(colaborador);
	}

	public void editar() {
		cdao.editar(colaborador);
		limpar();
		Messages.addGlobalInfo("O colaborador foi editadata com sucesso!");
	}

	public void limpar() {
		colaborador = new Colaborador();
		colaboradores = cdao.listar();
	}

	public void excluir() {
		colaboradores = cdao.listar();
		cdao.delete(colaborador.getId());
		limpar();
		Messages.addGlobalInfo("A tarefa foi excluida com sucesso!");
	}

}
