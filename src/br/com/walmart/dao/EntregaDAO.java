package br.com.walmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.walmart.bean.Entrega;
import br.com.walmart.connection.ConexaoFactoryHeroku;

public class EntregaDAO {

	Connection conexao = null;

	/**
	 * metodo responsavel por incluir uma entrega.
	 * @param entrega
	 */
	public void incluirEntrega(Entrega entrega){
		PreparedStatement ps = null;
		try {
			
			int idMapa = maxID();
			
			conexao = ConexaoFactoryHeroku.conexaoHeroku();

			String sql = "Insert into TB_ENTREGA (ID_MAPA,NM_MAPA,ORIGEM,DESTINO,distancia,AUTONOMIA, VL_LITRO, CUSTO) values (?,?,?,?,?,?,?,?)";

			ps = conexao.prepareStatement(sql);
			int index = 1;
			ps.setInt(index++, idMapa+1);
			ps.setString(index++, entrega.getNomeMapa());
			ps.setString(index++, entrega.getOrigem());
			ps.setString(index++, entrega.getDestino());
			ps.setFloat(index++, entrega.getDistancia());
			ps.setFloat(index++, entrega.getAutonomia());
			ps.setFloat(index++, entrega.getValorLitro());
			ps.setFloat(index++, entrega.getCusto());
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


	public List<Entrega> listarEntregas(){
		List<Entrega> entregas = new ArrayList<Entrega>();
		Statement smt = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactoryHeroku.conexaoHeroku();
			smt = conexao.createStatement();
			String sql = "SELECT ID_MAPA, NM_MAPA , ORIGEM , DESTINO , distancia , AUTONOMIA , VL_LITRO, CUSTO FROM TB_ENTREGA ";

			rs = smt.executeQuery(sql);
			while(rs.next()){
				Entrega entrega = new Entrega();
				entrega.setIdMapa(rs.getInt("ID_MAPA"));
				entrega.setNomeMapa(rs.getString("NM_MAPA"));
				entrega.setOrigem(rs.getString("ORIGEM"));
				entrega.setDestino(rs.getString("DESTINO"));
				entrega.setDistancia(rs.getFloat("distancia"));
				entrega.setAutonomia(rs.getFloat("AUTONOMIA"));
				entrega.setValorLitro(rs.getFloat("VL_LITRO"));
				entrega.setCusto(rs.getFloat("CUSTO"));
				entregas.add(entrega);
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

		return entregas;
	}
	
	
	private int maxID(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactoryHeroku.conexaoHeroku();
			
			String sql = "SELECT max(id_mapa) as id_mapa_max FROM TB_ENTREGA";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt("id_mapa_max");
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
	
	
	public float distanciaEntreOsDoisPontos(Entrega entrega){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conexao = ConexaoFactoryHeroku.conexaoHeroku();
			
			String sql = "SELECT sum(DISTANCIA) AS distancia FROM tb_malha_logistica WHERE PONTO_FINAL = ? "
			+" AND PONTO_INICIAL in (SELECT PONTO_FINAL FROM tb_malha_logistica WHERE PONTO_INICIAL = ?)";
			
			ps = conexao.prepareStatement(sql);
			
			ps.setString(1, entrega.getDestino());
			ps.setString(2, entrega.getOrigem());
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				return rs.getFloat("distancia");
			}else{
				return 0;
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
		return 0;

	}
	
	
	
}
