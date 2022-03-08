package com.women.spring.service;

import com.women.spring.model.GroupeType;
import com.women.spring.model.Groups;

import java.util.List;

public interface IGroupsService{
    // CRUD GROUPS
    public void CreateGroup(Groups groups , List<Long> idUser);
    public Groups getByIdGroup(Long idGroup);
    public List<Groups> retrieveAllGroup();
    public void deleteGroup(Long idGroup);
    public void UpadateEtatGroup(Long idGroup, GroupeType etatGroup);
    public String RenameGroups(Long idGroup,String Newname);
    public String ChangeImageGroups(Long idGroup,String image);

    public String AddMemberToGroups(Long idGroup,List<Long> IdUser);
    public String RemoveMemberFromGroups(Long idGroup,Long idUser);
    public String RenameMember(Long idGroup,Long idUser,String newName);

}
