package com.example.desafioquality.infrastructure.repositories.impl;

import com.example.desafioquality.domain.District;
import com.example.desafioquality.domain.Enum.DistrictErrorMessage;
import com.example.desafioquality.domain.Exceptions.EntityNotFoundException;
import com.example.desafioquality.infrastructure.repositories.DistrictRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {
    private Map<String,Double> districtList;

    public DistrictRepositoryImpl() {
        districtList = new HashMap<>();
        districtList.put("Centro",	20074.);
        districtList.put("Capoeiras",	19323.);
        districtList.put("Trindade",	15031.);
        districtList.put("Agronômica",	14591.);
        districtList.put("Saco dos Limões",	13771.);
        districtList.put("Coqueiros",	13592.);
        districtList.put("Monte Cristo",	12634.);
        districtList.put("Jardim, Atlântico",	12047.);
        districtList.put("Itacorubi",	10307.);
        districtList.put("Costeira, do Pirajubaé",	9301.);
        districtList.put("Capivari",	8686.);
        districtList.put("Tapera da Base",	7081.);
        districtList.put("Estreito",	7007.);
        districtList.put("Monte Verde",	6198.);
        districtList.put("Balneário",	6110.);
        districtList.put("São João do Rio Vermelho",	5571.);
        districtList.put("Canto",	5560.);
        districtList.put("Abraão",	5210.);
        districtList.put("Santa Mônica",	5081.);
        districtList.put("Lagoa",	5081.);
        districtList.put("Saco Grande",	5002.);
        districtList.put("Córrego Grande",	4833.);
        districtList.put("Canasvieiras",	4822.);
        districtList.put("Pantanal",	4703.);
        districtList.put("Coloninha",	4432.);

    }

    @Override
    public District find(District onlyName) throws EntityNotFoundException {
        return find(onlyName.getName());
    }

    @Override
    public District find(String name) throws EntityNotFoundException {
        var response= districtList.get(name);
        if(response == null)throw new EntityNotFoundException(DistrictErrorMessage.NOT_FOUND);
        return new District(name,response);
    }
}
