package com.thidinhxm.daos;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.thidinhxm.entities.Room;
import com.thidinhxm.utils.HibernateUtil;

public class RoomDAO {
	public static List<Room> getRooms() {
		List<Room> rooms = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from Room";
			Query<Room> query = session.createQuery(hql, Room.class);
			rooms = query.list();
		}
		catch (NoResultException ex) {
		}
		catch(HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return rooms;
	}
}
