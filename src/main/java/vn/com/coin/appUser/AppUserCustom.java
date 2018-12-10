package vn.com.coin.appUser;

import java.util.List;

import vn.com.coin.entity.AppUser;

public interface AppUserCustom {
	public List<AppUser>getUserbyNameAndId(String name, Integer id);

}
