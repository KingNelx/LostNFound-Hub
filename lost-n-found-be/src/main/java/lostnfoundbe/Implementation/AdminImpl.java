package lostnfoundbe.Implementation;

import org.springframework.stereotype.Service;

import lostnfoundbe.Entity.SystemAdmin;
import lostnfoundbe.Repository.SystemAdminRepo;
import lostnfoundbe.Service.AdminService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@Service
public class AdminImpl  implements AdminService{
    
    @Override
    SystemAdminRepo systemAdminRepo;

    @Override
    public List <SystemAdmin> queryAllAdmins(){
        List <SystemAdmin> fetchAdmins = systemAdminRepo.findAll();

        try{

        }catch(IOException exception){

        }
    }
}
