package br.com.conexao;

//Classes necessárias para uso de Banco de dados 
//Essas classes são do drive mysqlconnector.java que colamos na pasta lib.
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*; 

//import com.mysql.cj.xdevapi.Statement;
//import com.sun.jdi.connect.spi.Connection;

public class Conn {
	
	public PreparedStatement pst; 
    public Statement stm;
    public Connection conn;
    public ResultSet rs;

    //Método para conexão
    public static Connection conectaMysql() {
        Connection con = null;
        String url = "jdbc:mysql://127.0.0.1:3308/dbCadastro?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "";

      //Carrega o driver especificado
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//Faz com que a classe seja carregada pela JVM
            try {
            	if (con == null) {//P testar a conecção, se vdd imprime "Conexão realizada com sucesso!!"
            		con = DriverManager.getConnection(url, usuario, senha);//Criamos a conexão com o BD
				}
            	System.out.println("Conexão realizada com sucesso!!!");
            	
            } catch (SQLException ex) {//Caso aconteça alguma exceção, SQLException fornece informações sobre o erro.) 
                System.out.println("Url, senha ou usuário incorretos");//Vai imprimir essa mensagem aqui
            }
        } catch (ClassNotFoundException ex) {//Se falso pode imprir isso dependendo do tipo de erro
            System.out.println("Drive não encontrado");
        }
        return con;//Retorna com a resposta.
    }

}
