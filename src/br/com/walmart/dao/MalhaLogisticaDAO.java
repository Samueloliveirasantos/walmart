package br.com.walmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.walmart.bean.MalhaLogistica;
import br.com.walmart.connection.ConexaoFactoryHeroku;

public class MalhaLogisticaDAO {

	Connection conexao = null;

	/**
	 * metodo responsavel por incluir uma logistica.
	 * @param logistica
	 */
	public void incluirMalhaLogistica(MalhaLogistica logistica){
		PreparedStatement ps = null;
		try {
			
			int idMalhaLogistica = maxID() + 1;
			
			conexao = ConexaoFactoryHeroku.conexaoHeroku();

			String sql = "Insert into TB_MALHA_LOGISTICA (ID_MALHA,PONTO_INICIAL,PONTO_FINAL,DISTANCIA) values (?,?,?,?)";

			ps = conexao.prepareStatement(sql);
			int index = 1;
			ps.setInt(index++, idMalhaLogistica);
			ps.setString(index++, logistica.getPontoInicial());
			ps.setString(index++, logistica.getPontoFinal());
			ps.setInt(index++, logistica.getDistancia());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	

	}


	public List<MalhaLogistica> listarMalhaLogistica(){
		List<MalhaLogistica> logisticas = new ArrayList<MalhaLogistica>();
		Statement smt = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactoryHeroku.conexaoHeroku();
			smt = conexao.createStatement();
			String sql = "SELECT ID_MALHA,PONTO_INICIAL,PONTO_FINAL,DISTANCIA FROM TB_MALHA_LOGISTICA ";

			rs = smt.executeQuery(sql);
			while(rs.next()){
				MalhaLogistica logistica = new MalhaLogistica();
				logistica.setIdMalhaLogistica(rs.getInt("ID_MALHA"));
				logistica.setPontoInicial(rs.getString("PONTO_INICIAL"));
				logistica.setPontoFinal(rs.getString("PONTO_FINAL"));
				logistica.setDistancia(rs.getInt("DISTACIA"));
				logisticas.add(logistica);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				smt.close();
				conexao.close();
				rs.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}

		return logisticas;
	}
	
	
	private int maxID(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactoryHeroku.conexaoHeroku();
			
			String sql = "SELECT max(id_malha) as id_malha_max FROM TB_MALHA_LOGISTICA";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt("id_malha_max");
			}else{
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conexao.close();
				rs.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return 1;
	}
	
}
