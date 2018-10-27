package com.web.conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

	public static void main (String args[]) {
		
		Connection con;
		
		try {
				con=FabricaConexao.getConexao();
				if(con!=null) {
					System.out.println("Conectado....");
					con.close();
				}
				
			}catch (SQLException e) {
			 e.printStackTrace();
			}
			
		}
	}

