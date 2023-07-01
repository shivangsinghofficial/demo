package com.example.demo.developer.application;

import com.example.demo.domain.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService{

    @Autowired
    DeveloperDao developerDao;

    DeveloperServiceImpl(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }

    @Override
    public void addDevelopers(List<Developer> developerList) {
        developerDao.addDeveloper(developerList);
    }
}
