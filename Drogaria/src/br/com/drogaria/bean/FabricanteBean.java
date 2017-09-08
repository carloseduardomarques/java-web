package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricante;
	private ListDataModel<Fabricante> fabricantes;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ListDataModel<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(ListDataModel<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			FabricanteDAO dao = new FabricanteDAO();
			ArrayList<Fabricante> lista = dao.listar();
			fabricantes = new ListDataModel<Fabricante>(lista);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void prepararNovo() {

		fabricante = new Fabricante();

	}

	public void novo() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);

			ArrayList<Fabricante> lista = dao.listar();
			fabricantes = new ListDataModel<Fabricante>(lista);

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}
