package com.example.ieharrison_spring.ieharrison;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IeharrisonService {

  @Autowired
  private IeharrisonRepository ieharrisonRepository;

  public void createIeharrison(Ieharrison ieharrison) {
    ieharrisonRepository.save(ieharrison);
  }

  public boolean removeIeharrison(Integer id) {
    if (ieharrisonRepository.findById(id).isPresent()) {
      ieharrisonRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  public Optional<Ieharrison> findIeharrison(Integer id) {
    return ieharrisonRepository.findById(id);
  }

  public List<Ieharrison> findAll() {
    return ieharrisonRepository.findAll();
  }

  public Optional<Ieharrison> editIeharrison(
    Integer id,
    Ieharrison ieharrison
  ) {
    Optional<Ieharrison> p = ieharrisonRepository.findById(id);
    if (p.isPresent()) {
      p.get().setName(ieharrison.getName());
      p.get().setSurname(ieharrison.getSurname());
      p.get().setBalance(ieharrison.getBalance());
      p.get().setEmail(ieharrison.getEmail());
      ieharrisonRepository.saveAndFlush(p.get());
    }
    return p;
  }

  public boolean removeAll() {
    try {
      ieharrisonRepository.deleteAll();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public Integer increaseBalance(int id, Float amount) {
    Optional<Ieharrison> optionalIeharrison = ieharrisonRepository.findById(id);

    if (optionalIeharrison.isPresent()) {
      Ieharrison ieharrison = optionalIeharrison.get();
      Float currentBalance = ieharrison.getBalance();
      Float newBalance = currentBalance + amount;
      ieharrison.setBalance(newBalance);
      ieharrisonRepository.save(ieharrison);

      if (currentBalance == 0) {
        return 201; //INITIALISED
      } else {
        return 200; //INCREASED
      }
    } else {
      return 209; //ID NOT FOUND
    }
  }

  public Integer decreaseBalance(int id, Float cantidad) {
    Optional<Ieharrison> optionalIeharrison = ieharrisonRepository.findById(id);

    if (optionalIeharrison.isPresent()) {
      Ieharrison ieharrison = optionalIeharrison.get();
      Float currentBalance = ieharrison.getBalance();
      Float newBalance = currentBalance - cantidad;
      ieharrison.setBalance(newBalance);
      ieharrisonRepository.save(ieharrison);

      if (newBalance >= 0) {
        return 0; //SUCCESS
      } else {
        return 1; // SUCCESS NEGATIVE
      }
    } else {
      return null; //ID NOT FOUND
    }
  }

  public Float calculateAverageBalance() {
    List<Ieharrison> allIeharrisons = ieharrisonRepository.findAll();
    
    if (allIeharrisons.isEmpty()) {
        return null;
    }

    Float sum = 0f;
    int count = 0;
    for (int i = 0; i < allIeharrisons.size(); i++) {
        Ieharrison ieharrison = allIeharrisons.get(i);
        sum += ieharrison.getBalance();
        count++;
    }
    
    return sum / count;
}
}
