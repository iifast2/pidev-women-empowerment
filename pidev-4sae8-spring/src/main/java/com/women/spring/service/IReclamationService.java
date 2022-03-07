package com.women.spring.service;

import com.women.spring.model.Reclamation;

public interface IReclamationService {
    public void addReclamation (Reclamation reclamation);
    public void deleteReclamation(Long id);
    public void updateReclamation(Reclamation reclamation);
}
