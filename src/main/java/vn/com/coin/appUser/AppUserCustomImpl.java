package vn.com.coin.appUser;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import vn.com.coin.entity.AppUser;

@Repository
public class AppUserCustomImpl implements AppUserCustom{

	@PersistenceContext
    EntityManager entityManager;
	@Override
	public List<AppUser> getUserbyNameAndId(String name, Integer id) {
		Query query = entityManager.createNativeQuery("SELECT u.* FROM username as u " +
                "WHERE u.name LIKE ? and u.id = ?", AppUser.class);
        query.setParameter(1, "%" + name + "%");
        query.setParameter(2, id );
        return query.getResultList();
	}
}
