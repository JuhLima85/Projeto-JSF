package br.com.conexao;

//Classes necess�rias para uso de Banco de dados 
//Essas classes s�o do drive mysqlconnector.java que colamos na pasta lib.
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

    //M�todo para conex�o
    public static Connection conectaMysql() {
        Connection con = null;
        String url = "jdbc:mysql://127.0.0.1:3308/dbCadastro?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "";

      //Carrega o driver especificado
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//Faz com que a classe seja carregada pela JVM
            try {
            	if (con == null) {//P testar a conec��o, se vdd imprime "Conex�o realizada com sucesso!!"
            		con = DriverManager.getConnection(url, usuario, senha);//Criamos a conex�o com o BD
				}
            	System.out.println("Conex�o realizada com sucesso!!!");
            	
            } catch (SQLException ex) {//Caso aconte�a alguma exce��o, SQLException fornece informa��es sobre o erro.) 
                System.out.println("Url, senha ou usu�rio incorretos");//Vai imprimir essa mensagem aqui
            }
        } catch (ClassNotFoundException ex) {//Se falso pode imprir isso dependendo do tipo de erro
            System.out.println("Drive n�o encontrado");
        }
        return con;//Retorna com a resposta.
    }

}
