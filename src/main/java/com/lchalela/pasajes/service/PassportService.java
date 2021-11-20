package com.lchalela.pasajes.service;

import com.lchalela.pasajes.model.Passport;

import java.util.List;

public interface PassportService {
    List<Passport> findAllPassport();
    Passport findPassportById(Long id);
    void savePassport(Passport passport);
    void updatePassport(Long id,Passport passport);
    void deletePassportById(Long id);
}