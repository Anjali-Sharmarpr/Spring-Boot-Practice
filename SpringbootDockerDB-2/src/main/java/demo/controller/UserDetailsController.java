package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.DTO.UserInDto;
import demo.entity.UserDetails;
import demo.service.UserDetailService;

@RestController
public class UserDetailsController {
	
	@Autowired
	UserDetailService userDetailService;

	@PostMapping("/add")
	public UserDetails addUser(@RequestBody UserInDto userInDto) {
		return userDetailService.addUser(userInDto);
	}
}
