package com.example.demo.repository.developer;

import com.example.demo.developer.application.DeveloperDao;
import com.example.demo.domain.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperDaoImpl implements DeveloperDao {

    @Autowired
    DeveloperRepository developerRepository;

    DeveloperDaoImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public void addDeveloper(List<Developer> developerList) {
        List<DeveloperEntity> developerEntities = developerList.stream().map(DeveloperMapper::developerEntityMapper)
                .collect(Collectors.toList());
        this.developerRepository.saveAll(developerEntities);
    }
}
