package com.luca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.luca.entity.Materia;
import com.luca.entity.Studente;
import com.luca.util.DBUtil;

public class MateriaDao {

	public Materia getMateriaById(int idMateria) {

		// System.out.println("sono in get studente dao");
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		Materia m = new Materia();
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT m.nome_materia,m.corso_associato,c.nome_corso  from materia as m INNER JOIN corso as c ON m.corso_associato = c.id_corso  where m.id_materia = ?");

		try {
			// System.out.println("sono nel try");
			connection = DBUtil.getConnection();
			pstm = connection.prepareStatement(sql.toString());
			pstm.setInt(1, idMateria);
			rs = pstm.executeQuery();

			if (rs.next()) {
				// System.out.println("sono nell'if del rs next");
				m.setNome_materia(rs.getString("nome_materia"));
				m.setCorso_associato(rs.getInt("corso_associato"));
				m.setNome_corso(rs.getString("nome_corso"));
				

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

		return m;
	}

}
