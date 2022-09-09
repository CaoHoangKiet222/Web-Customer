package com.web.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/** BcryptCalculator */
public class BcryptCalculator {
  public static void main(String[] args) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    System.out.println(bCryptPasswordEncoder.encode("thangcho"));
  }
}
