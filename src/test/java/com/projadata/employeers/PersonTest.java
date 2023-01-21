package com.projadata.employeers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  @DisplayName("testa se cria corretamenta uma pessoa.")
  void test() {
    String person1 = "Luciano";
    LocalDate birthdate1 = LocalDate.of(1992, 2, 19);
    
    Person personTest1 = new Person(person1, birthdate1);
    assertEquals("Luciano", personTest1.name);
    assertEquals(birthdate1, personTest1.birthdate);
    assertEquals("19/02/1992", personTest1.getBirthdateDayMonthYear());
  }

}
