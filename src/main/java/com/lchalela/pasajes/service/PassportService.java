package com.lchalela.pasajes.service;

import com.lchalela.pasajes.dto.PassportDTO;
import com.lchalela.pasajes.model.Passport;

import java.util.List;

public interface PassportService {
    List<PassportDTO> findAllPassport();
    PassportDTO findPassportById(String id) throws Exception;
    void savePassport(PassportDTO passportDTO);
    void updatePassport(String id,PassportDTO passportDTO) throws Exception;
    void deletePassportById(String id) throws Exception;
}