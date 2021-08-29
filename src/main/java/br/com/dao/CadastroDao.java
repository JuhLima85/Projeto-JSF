package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import br.com.conexao.Conn;
import br.com.Model.CadastroModel;

public class CadastroDao {

	PreparedStatement pst;
	Statement stm;
	Connection conn;
	ResultSet rs;

	//Método Salvar
	public boolean salvarCadastro(CadastroModel cm) {//Método plúblico, variável do tipo boolean, atribuimos o nome "salvarCadastro" ao método. Entre parenteses criamos um objeto CadastroModel chamado "cm" (pra mim só criava objeto com new)
		conn = Conn.conectaMysql(); //Pra realizar a conexao, pegamos o objeto que criamos e atribuímos a classe conn.conetaMysql (que criamos na classe Conn).

		try {//Try catch - tentativa e erro
			String sql = "insert into cadastro(nome, endereco, telefone, email) values(?,?,?,?)";//Criamos uma variável do tipo string e nomeamos de sql para inserir campos na tabela. Insert into... é para inserir os dados na tabela, ele descreve os campos (lembrando que o id é auto increment logo naõ precisa ser manipulado) e colocamos um ? para cada campo, pois não sabemos os valores que serao inseridos pelo cliente.
			pst = conn.prepareStatement(sql); //Criamos uma prepareStatement para executar uma query
			pst.setString(1, cm.getNome()); //Adcionar os valores que são esperados pela query
			pst.setString(2, cm.getEndereco());
			pst.setString(3, cm.getTelefone());
			pst.setString(4, cm.getEmail());

			pst.execute(); //Para executar a query (o pstm tem a query)
		} catch (Exception e) {//Caso aconteça alguma exceção, SQLException fornece informações sobre o erro.) 
			e.printStackTrace();//Aqui vai printar a execessão
		}
		return false;
	}

	public boolean atualizar(CadastroModel cad) {
		conn = Conn.conectaMysql();
		try {
			String sql = "update cadastro set nome=?, endereco=?, telefone=?, email=? where id=?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, cad.getNome());
			pst.setString(2, cad.getEndereco());
			pst.setString(3, cad.getTelefone());
			pst.setString(4, cad.getEmail());
			pst.setInt(5, cad.getId());

			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}
	
	public boolean apagar(CadastroModel cad) {
		conn = Conn.conectaMysql();
		try {
			String sqlremover = "delete from cadastro where id=?";//Dizemos a linha que queremos apagar pelo id
			
			pst = conn.prepareStatement(sqlremover);
			pst.setInt(1, cad.getId());
			
			pst.execute();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}
}
