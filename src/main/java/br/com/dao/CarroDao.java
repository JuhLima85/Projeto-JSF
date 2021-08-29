package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import br.com.Model.CarroModel;
import br.com.conexao.Conn;

public class CarroDao {

	PreparedStatement pst;
	Statement stm;
	Connection conn;
	ResultSet rs;

	public boolean salvarCarro(CarroModel cm) {
		conn = Conn.conectaMysql();

		try {
			String sql = "insert into carro(modelo, ano, cor, combustivel) values(?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, cm.getModelo());
			pst.setInt(2, cm.getAno());
			pst.setString(3, cm.getCor());
			pst.setString(4, cm.getCombustivel());

			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean atualizar(CarroModel car) {
		conn = Conn.conectaMysql();
		try {
			String sql = "update carro set modelo=?, ano=?, cor=?, combustivel=? where id=?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, car.getModelo());
			pst.setInt(2, car.getAno());
			pst.setString(3, car.getCor());
			pst.setString(4, car.getCombustivel());
			pst.setInt(5, car.getId());

			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			
		}
		return false;

	}
	
	public boolean apagar(CarroModel car) {
		conn = Conn.conectaMysql();
		try {
			String sqlremover = "delete from carro where id=?";
			
			pst = conn.prepareStatement(sqlremover);
			pst.setInt(1, car.getId());
			
			pst.execute();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}
}
