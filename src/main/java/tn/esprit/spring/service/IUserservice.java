package tn.esprit.spring.service;



import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.FileDB;
import tn.esprit.spring.entity.User;

public interface IUserservice {
	public User inscription(User user);
	public User updateUser(User user, Long idUser);
	public void deleteUser(Long idUser);
	public User affichDetailUser(Long idUser);
	public List<User> affichUser();
	public User findbyusername(String username);
	public User affcterfileauuser(Long iduser,Long idfile);
    public Optional<User> findUserByEmail(String email);
    public Optional<User> findUserByResetToken(String resetToken);

}
