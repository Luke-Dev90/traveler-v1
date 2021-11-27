package com.lchalela.pasajes.service.impl;

import com.lchalela.pasajes.dto.PassportDTO;
import com.lchalela.pasajes.mapper.PassportMapper;
import com.lchalela.pasajes.model.Passport;
import com.lchalela.pasajes.repository.PassportRepository;
import com.lchalela.pasajes.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportServiceImpl implements PassportService {

    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private PassportMapper passportMapper;

    @Override
    public List<PassportDTO> findAllPassport() {
        List<PassportDTO> passportDTOList = passportMapper.toListDTO(passportRepository.findAll());
        if(passportDTOList.isEmpty()){
            new Exception("List passports is empty");
        }
        return passportDTOList;
    }

    @Override
    public PassportDTO findPassportById(String id) throws Exception {
        Long idParse = 0l;
        try {
            idParse = Long.parseLong(id);
        }catch (NumberFormatException ef){
            new NumberFormatException("Invalid format id");
        }
        return passportMapper.toDTO( passportRepository.findById(idParse).orElseThrow( () ->{
            return new Exception("Passport not found");}
        ));
    }

    @Override
    public void savePassport(PassportDTO passportDTO) {
        passportRepository.save(passportMapper.toEntity(passportDTO));
    }

    @Override
    public void updatePassport(String id, PassportDTO passportDTO) throws Exception {
        Long idParse = 0l;
        try{
            idParse = Long.parseLong(id);
        }catch (NumberFormatException ef){
            new NumberFormatException("The id is invalid format");
        }
        Passport passport = passportRepository.findById(idParse).orElseThrow(
                () -> {return new Exception("Passport not found");}
        );
        passportMapper.updatePassport(passportDTO,passport);
        passportRepository.save(passport);
    }

    @Override
    public void deletePassportById(String id) throws Exception {
        Long idParse = 0l;
        try {
            idParse = Long.parseLong(id);
        }catch (NumberFormatException ef){
            new NumberFormatException("Invalid format exception");
        }
        Passport passport = passportRepository.findById(idParse).orElseThrow(()->{
            return new Exception("Passport not found");
        });
        passportRepository.delete(passport);
    }
}