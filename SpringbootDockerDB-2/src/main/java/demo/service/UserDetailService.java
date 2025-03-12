package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.DTO.UserInDto;
import demo.entity.UserDetails;
import demo.respository.UserDetailsRepository;

@Service
public class UserDetailService {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;

	public UserDetails addUser(UserInDto userInDto) {
		UserDetails userDetails =  new UserDetails();
		userDetails.setName(userInDto.getName());
		userDetails.setEmailId(userInDto.getEmailId());
		userDetails.setAddress(userInDto.getAddress());
		
		return userDetailsRepository.save(userDetails);
	}
}
