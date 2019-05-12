package com.luca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.luca.entity.Studente;
import com.luca.entity.Voto;
import com.luca.util.DBUtil;

public class VotoDao {

	public void aggiungiVoto(Voto votoToAdd) {

		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO voto (id_studente,id_materia,voto) VALUES (?,?,?)");

		try {
			// System.out.println("sono nel try");
			connection = DBUtil.getConnection();
			pstm = connection.prepareStatement(sql.toString());
			pstm.setInt(1, votoToAdd.getId_studente());
			pstm.setInt(2, votoToAdd.getId_materia());
			pstm.setInt(3, votoToAdd.getVoto());

			pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Attenzione errore di db");

		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e1) {
					// non faccio nulla
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e1) {
					// non faccio nulla
				}
			}
		}

	}

	public Voto findVotoByStudenteAndMateria(int idStudente, int idMateria) {

		// System.out.println("sono in get studente dao");
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		Voto v = new Voto();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT v.id_materia,v.id_studente  from voto as v  where v.id_studente = ? AND v.id_materia = ?");

		try {
			// System.out.println("sono nel try");
			connection = DBUtil.getConnection();
			pstm = connection.prepareStatement(sql.toString());
			pstm.setInt(1, idStudente);
			pstm.setInt(2, idMateria);
			rs = pstm.executeQuery();

			if (rs.next()) {
				// System.out.println("sono nell'if del rs next");
				v.setId_materia(rs.getInt("id_materia"));
				v.setId_studente(rs.getInt("id_studente"));

			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Attenzione errore di db");

		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e1) {
					// non faccio nulla
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e1) {
					// non faccio nulla
				}
			}
		}

		return v;
	}

	public ArrayList<Voto> findAllVotoByStudente(int idStudente) {

		// System.out.println("sono in get studente dao");
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		ArrayList<Voto> listaVotiStudente = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT v.id_materia,v.id_studente,v.voto,m.nome_materia  from voto as v INNER JOIN materia as m ON v.id_materia = m.id_materia where v.id_studente = ?");

		try {
			// System.out.println("sono nel try");
			connection = DBUtil.getConnection();
			pstm = connection.prepareStatement(sql.toString());
			pstm.setInt(1, idStudente);
			
			rs = pstm.executeQuery();

			while (rs.next()) {
				Voto v = new Voto();
				// System.out.println("sono nell'if del rs next");
				v.setNomeMateria(rs.getString("nome_materia"));
				v.setId_studente(rs.getInt("id_studente"));
				v.setVoto(rs.getInt("voto"));
				
				listaVotiStudente.add(v);
				
			} 

		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Attenzione errore di db");

		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e1) {
					// non faccio nulla
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e1) {
					// non faccio nulla
				}
			}
		}
		
		return listaVotiStudente;

	}

}
