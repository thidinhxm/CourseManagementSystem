package com.thidinhxm.daos;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.thidinhxm.entities.Period;
import com.thidinhxm.utils.HibernateUtil;

public class PeriodDAO {
	public static List<Period> getPeriodList() {
		List<Period> periodList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from Period";
			Query<Period> query = session.createQuery(hql, Period.class);
			periodList = query.list();
		}
		catch (NoResultException ex) {
		}
		catch(HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return periodList;
	}
}
