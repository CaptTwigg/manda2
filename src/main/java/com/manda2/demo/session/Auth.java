package com.manda2.demo.session;

import com.manda2.demo.model.Person;
import com.manda2.demo.repository.PersonRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

@Service
public class Auth {

  @Autowired
  private PersonRepo personRepo;


  public boolean isLoggedIn(HttpSession session) {
    return session.getAttribute("ID") != null;
  }

  public boolean login(String email, String password, HttpSession httpSession) throws SQLException {
    Person person = personRepo.findByEmail(email);
    if (checkUsername(email) & checkPassword(password, person.getPassword())) {
      httpSession.setAttribute("ID", person.getId());
      httpSession.setAttribute("NIVEAU", person.getNiveau());
      return true;
    }
    return false;
  }

  public  void logout(HttpSession session) {
    session.removeAttribute("ID");
    session.removeAttribute("NIVEAU");

  }

  public  boolean checkPassword(String password, String hashed) {
    return BCrypt.checkpw(password, hashed);
  }

  private boolean checkUsername(String email) {
    List<Person> persons = (List<Person>) personRepo.findAll();
    for (Person person : persons) {
      if (person.getEmail().equals(email))
        return true;
    }
    return false;
  }
}

