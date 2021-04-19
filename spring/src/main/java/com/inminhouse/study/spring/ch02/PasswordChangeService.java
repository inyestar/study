package com.inminhouse.study.spring.ch02;

public class PasswordChangeService {

	private UserRepository userRepository;
	
	public PasswordChangeService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void changePassword(String userId, String oldPw, String newPw) throws UserNotFoundException {
		
		User user = userRepository.findUserById(userId);
		
		if(user == null) {
			throw new UserNotFoundException();
		}
		
		user.changePassword(oldPw, newPw);
	}
}
