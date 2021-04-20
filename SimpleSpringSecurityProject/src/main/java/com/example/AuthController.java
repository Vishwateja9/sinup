 package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.AuthenticationRequest;
import com.example.models.AuthenticationResponse;
import com.example.models.UserModel;
import com.example.models.UserRepository;
import com.example.services.UserService;
import com.example.utils.JwtUtils;

@RestController
@CrossOrigin
 public class AuthController {
	
	//then here i used to use userrepository
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@GetMapping("/dashboard")
	private String testingToken(){
		return "Welcome to the DASHBOARD" + SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	
	@PostMapping("/subs")
	@CrossOrigin(origins = "http://localhost:7070/subs")
	private ResponseEntity<?> subscribeClient(@RequestBody  AuthenticationRequest authenticationRequest) throws Exception{
		//for retriving username whenerver subscribe a client
	
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		UserModel usermodel = new UserModel();
		usermodel.setUsername(username);
		usermodel.setPassword(password);
		userRepository.save(usermodel);
		//for exception
		try {
			userRepository.save(usermodel);
		} catch(Exception e) {
			throw new Exception("bad Credentials");
		}
		
		return ResponseEntity.ok(new AuthenticationResponse("Succesful Subscription for client" + username));
		
	}
	
	
	@PostMapping("/auth")
	@CrossOrigin(origins = "http://localhost:7070/auth")
	private ResponseEntity<?> authenticateClient(@RequestBody  AuthenticationRequest authenticationRequest) throws Exception{
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch (Exception e) {
			throw new Exception("bad Credentials");
		}
		
		UserDetails loadedUser = userService.loadUserByUsername(username);
		
		String generatedToken = jwtUtils.generateToken(loadedUser);
		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
	}
	 
 }