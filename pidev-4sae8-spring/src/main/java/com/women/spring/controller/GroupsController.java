package com.women.spring.controller;

import com.women.spring.model.GroupeType;
import com.women.spring.model.Groups;
import com.women.spring.service.IGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupsController{
    @Autowired
    IGroupsService groupService;


    @PostMapping("/CreateGroups/{idUser}")
    @ResponseBody
    public void CreateGroup(@RequestBody Groups g , @PathVariable("idUser") List<Long> idUser) {
        groupService.CreateGroup(g,idUser);
    }


    @DeleteMapping("/deleteGroups/{idGroup}")
    public void deleteGroup(@PathVariable("idGroup")Long idGroup) {
        groupService.deleteGroup(idGroup);
    }




    @PutMapping("/upadateEtatGroup/{idGroup}/{etatGroup}")
    public void UpadateEtatGroup(@PathVariable("idGroup") Long idGroup,@PathVariable("etatGroup") GroupeType etatGroup) {
        groupService.UpadateEtatGroup(idGroup, etatGroup);
    }


    @PutMapping("/renameGroups/{idGroup}/{Newname}")
    public String RenameGroups( @PathVariable("idGroup")Long idGroup , @PathVariable("Newname") String Newname ) {
        return groupService.RenameGroups(idGroup, Newname);
    }


    public String ChangeImageGroups(Long idGroup,String image){
        return null;
    }


    @GetMapping("/{idGroup}")
    public Groups getByIdGroup( @PathVariable("idGroup") Long idGroup ) {
        return groupService.getByIdGroup(idGroup);

    }

    @GetMapping("")
    public List<Groups> retrieveAllGroup() {
        return groupService.retrieveAllGroup();
    }



    @DeleteMapping("/removeUser/{idGroup}/{idUser}")
    @ResponseBody
    public String RemoveMemberFromGroups(@PathVariable("idGroup") Long idGroup,@PathVariable("idUser") Long idUser) {
        return groupService.RemoveMemberFromGroups(idGroup, idUser);
    }

    @PutMapping("/AddMemberToGroups/{idGroup}/{IdUser}")

    public String AddMemberToGroups(@PathVariable("idGroup") Long idGroup,@PathVariable("IdUser") List<Long> IdUser){
        return groupService.AddMemberToGroups(idGroup, IdUser);
    }

    public String RenameMember(Long idGroup,Long idUser,String newName){
        return null;
    }

}
