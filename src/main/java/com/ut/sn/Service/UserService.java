package com.ut.sn.Service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ut.sn.DTO.UserDTO;
import com.ut.sn.Modeles.UserModel;
import com.ut.sn.Repository.UserRepository;



@Service
public class UserService  implements UserDetailsService {
	private final UserRepository userrepository;
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	public UserService(UserRepository userrepository) {
		this.userrepository = userrepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;

		UserModel user = userrepository.findByEmail(email).get();
		if (user != null) {
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
			return new User(user.getEmail(), user.getPassword(), roles);
		}
		throw new UsernameNotFoundException("User not found with the name " + email);
	}

	public UserModel save(UserDTO user) {
		UserModel newUser = new UserModel();
		newUser.setEmail(user.getEmail());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		return userDao.save(newUser);
	}

	public List<UserModel> getAllUser() {
		return this.userrepository.findAll();
	}

	public void deleteUser(Integer id) {
		this.userrepository.deleteById(id);
	}

	public UserModel findOneUser(String email) {
		return this.userrepository.findByEmail(email).get();
	}

	public UserModel updateUser(UserModel user) {
		return this.userrepository.save(user);
	}

}
