package vn.com.coin.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import vn.com.coin.appUser.AppUserCustom;
import vn.com.coin.entity.AppUser;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AppUserRepository extends CrudRepository<AppUser, Integer>, AppUserCustom {
	

	

    Optional<AppUser> findByEmail(@Param("email") String email);

}
