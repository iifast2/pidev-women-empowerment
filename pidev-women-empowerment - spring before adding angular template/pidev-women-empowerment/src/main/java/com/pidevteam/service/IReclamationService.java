package com.pidevteam.service;

import com.pidevteam.entity.Reclamation;

public interface IReclamationService {
    public void addReclamation (Reclamation reclamation);
    public void deleteReclamation(Long id);
    public void updateReclamation(Reclamation reclamation);
}
