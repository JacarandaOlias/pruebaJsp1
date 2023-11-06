package es.jacaranda.db;

import java.time.LocalDate;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.jacaranda.exception.DbException;
import es.jacaranda.exception.UserException;
import es.jacaranda.model.Player;

public class DbRepository {
	
	
	
	public static Player findUserAddIfnotFind(String userName) throws DbException {
		Player player=null;

		if (userName == null) {
			throw new DbException("Error al buscar usuario: Es necesario introducir un nombre para jugar");
		}
			
		try {
				player = (Player) DbRepository.find(Player.class, userName);
		} catch (Exception e) {
			throw new DbException("Error al buscar usuario:" + e.getMessage());

		}

		if (player == null) {
			// Hay que añadirlo a la base de datos
			player = new Player(userName, Date.valueOf(LocalDate.now()));
			try {
				player = DbRepository.save(player);
			} catch (Exception e) {
				throw new DbException("Error al añadir usuario");

			}
		}
		return player;
	}
	

}
