package br.com.teste;
import java.sql.Connection;

import br.com.Model.CadastroModel;
import br.com.Model.CarroModel;
import br.com.dao.CadastroDao;
import br.com.dao.CarroDao;
public class CadastroTeste {

	public static void main(String[] args) throws Exception {
		CarroModel cm = new CarroModel();
		CarroDao dao = new CarroDao();
		try {
			
			cm.setId(4);
			
			dao.apagar(cm);
		} catch (Exception e) {
			System.out.println("Erro");
		}
		System.out.println("Alterado com sucesso");
	}

}
