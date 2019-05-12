package com.luca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.luca.entity.Studente;
import com.luca.util.DBUtil;

public class StudenteDao {

	public StudenteDao() {

	}

	@SuppressWarnings("resource")
	public Studente getStudenteByCodFisc(String codFisc) {
		// System.out.println("sono in get studente dao");
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		Studente stu = new Studente();
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT s.id,s.nome,s.cognome,s.cod_fisc,s.id_corso,c.nome_corso  from studente as s INNER JOIN corso as c ON s.id_corso = c.id_corso  where cod_fisc = ?");

		try {
			// System.out.println("sono nel try");
			connection = DBUtil.getConnection();
			pstm = connection.prepareStatement(sql.toString());
			pstm.setString(1, codFisc);
			rs = pstm.executeQuery();

			if (rs.next()) {
				// System.out.println("sono nell'if del rs next");
				stu.setId_studente(rs.getInt("id"));
				stu.setNome(rs.getString("nome"));
				stu.setCognome(rs.getString("cognome"));
				stu.setCodFisc(rs.getString("cod_fisc"));
				stu.setId_corso(rs.getInt("id_corso"));
				stu.setCorso(rs.getString("nome_corso"));

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

		return stu;
	}

	public void aggiungiStudente(Studente studentToAdd) {

		// System.out.println("sono in get studente dao");
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		Studente stu = new Studente();
		StringBuilder sql = new StringBuilder();
		sql.append(
				"INSERT INTO studente (nome,cognome,cod_fisc,id_corso) VALUES (?,?,?,?)");

		try {
			// System.out.println("sono nel try");
			connection = DBUtil.getConnection();
			pstm = connection.prepareStatement(sql.toString());
			pstm.setString(1, studentToAdd.getNome());
			pstm.setString(2, studentToAdd.getCognome());
			pstm.setString(3, studentToAdd.getCodFisc());
			pstm.setInt(4, studentToAdd.getId_corso());
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

	public void eliminaStudente(String codiceFiscale) {

		// viene eliminato uno studente

	}

	public void modificaAnnoIscrizioneStudente(String codFisc,int idCorso) {

		// faccio un alter su tutti i campi del record rimpiazzandoli con quelli
		// dell'oggetto studente passato
		
		// System.out.println("sono in get studente dao");
				Connection connection = null;
				PreparedStatement pstm = null;
				ResultSet rs = null;

				Studente stu = new Studente();
				StringBuilder sql = new StringBuilder();
				sql.append(
						"UPDATE studente SET id_corso = ? WHERE cod_fisc= ? ");

				try {
					// System.out.println("sono nel try");
					connection = DBUtil.getConnection();
					pstm = connection.prepareStatement(sql.toString());
					pstm.setInt(1, idCorso);
					pstm.setString(2, codFisc);
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

	public ArrayList<Studente> ottieniTuttiGliStudenti() {

		ArrayList<Studente> allStudenti = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT s.id,s.nome,s.cognome,s.cod_fisc,c.nome_corso  from studente as s INNER JOIN corso as c ON s.id_corso = c.id_corso");

		try {

			connection = DBUtil.getConnection();
			pstm = connection.prepareStatement(sql.toString());
			rs = pstm.executeQuery();

			while (rs.next()) {
				Studente stu = new Studente();
				stu.setId_studente(rs.getInt("id"));
				stu.setNome(rs.getString("nome"));
				stu.setCognome(rs.getString("cognome"));
				stu.setCodFisc(rs.getString("cod_fisc"));
				stu.setCorso(rs.getString("nome_corso"));

				allStudenti.add(stu);

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

		return allStudenti;
	}

	public ArrayList<Studente> ottieniStudentiCorso(int idCorso) {
		
		ArrayList<Studente> studentiCorso = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT s.id,s.nome,s.cognome,s.cod_fisc,c.nome_corso  from studente as s INNER JOIN corso as c ON s.id_corso = c.id_corso WHERE s.id_corso = ?");

		try {

			connection = DBUtil.getConnection();
			pstm = connection.prepareStatement(sql.toString());
			pstm.setInt(1, idCorso);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Studente stu = new Studente();
				stu.setId_studente(rs.getInt("id"));
				stu.setNome(rs.getString("nome"));
				stu.setCognome(rs.getString("cognome"));
				stu.setCodFisc(rs.getString("cod_fisc"));
				stu.setCorso(rs.getString("nome_corso"));

				studentiCorso.add(stu);

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
		
		return studentiCorso;
	}

}
