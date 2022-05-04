package com.pidevteam.service.impl;

import com.pidevteam.entity.Etat;
import com.pidevteam.entity.RoleEnum;
import com.pidevteam.entity.Subscription;
import com.pidevteam.entity.util.ChangePasswordVM;
import com.pidevteam.repository.RoleRepository;
import com.pidevteam.repository.UserRepository;
import com.pidevteam.entity.User;
import com.pidevteam.entity.dto.UserDto;
import com.pidevteam.service.EmailSenderService;
import com.pidevteam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;



@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	EmailSenderService emailSenderService;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	@Autowired
	SubscriptionServiceImpl subscriptionService ;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			//authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName().toString()));
		});
		return authorities;
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		//emailSenderService.sendMail("anonymousmega04@gmail.com","this is an email", "claim");
		userRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
    public User save(UserDto user) {
		User newUser = new User();
		if (user.getId() != null)
			newUser.setId(user.getId());

		newUser.setUsername(user.getUsername());
		if (user.getPassword() != null)
	{		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		//emailSenderService.sendMail("anonymousmega04@gmail.com", "this is an email! \n \n your user password : " + user.getPassword(), "your user infos");
	    //https://i.imgur.com/7s5Jv7k.png

	}
		else
//		if(user.getSubscription() != null ){
//
//			Subscription subscribption= user.getSubscription() ;
//			if(subscribption.getIdSubscription() != null){
//				subscriptionService.retrieveSubscription(user.getSubscription().getIdSubscription()) ;
//			}
//			subscribption =subscriptionService.addSubscription(subscribption);
//			newUser.setSubscriptions(subscribption);
//		}




		newUser.setPassword(findById(newUser.getId()).getPassword());

		//newUser.setSalary(user.getSalary());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setBirthdate(user.getBirthdate());
		newUser.setEmail(user.getEmail());
		newUser.setAddress(user.getAddress());

		//newUser.setSubscription
		// (user.getCin());

		if( user.getRoles() != null){

            for (RoleEnum role: user.getRoles()) {
               // System.out.println(roleRepository.findByName(role));
				newUser.getRoles().add(roleRepository.findByName(role));
			//	newUser.getRoles().add(roleRepository.findByName(RoleEnum.ADMIN));
				// System.out.println(roleRepository.findByName(role));

			}
        }
		else{
            newUser.getRoles().add(roleRepository.findByName(RoleEnum.USER));

        }


		return userRepository.save(newUser);
    }



    public User update(User user){
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public boolean changePassword(ChangePasswordVM vm , String username){
		User user = findOne(username);
		System.out.println("----------------"+ bcryptEncoder.encode(vm.getOldPassword()) + "--------------------" + user.getPassword());
		System.out.println("------" + vm.getOldPassword());

		if (bcryptEncoder.matches(vm.getOldPassword(),user.getPassword())){
			user.setPassword(bcryptEncoder.encode(vm.getNewPassword()));
			userRepository.save(user);
			return true;
		}
		else return false;

	}


	public User virer (Long id) {
		User user =  userRepository.findById(id).get();
		user.setEtat(Etat.viré);

		return userRepository.save(user);
	}
	public User avertire (Long id) {
		User user =  userRepository.findById(id).get();
		user.setEtat(Etat.Averti);

		return userRepository.save(user);

	}
	public User sactionner (Long id) {
		User user =  userRepository.findById(id).get();
		user.setEtat(Etat.Sactionné);

		return userRepository.save(user);
	}
}
