package lostnfoundbe.Service;

import org.springframework.stereotype.Service;
import lostnfoundbe.Entity.SystemAdmin;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@Service
public interface AdminService {
    
    List <SystemAdmin> queryAllAdmins();
    Optional <SystemAdmin> queryAdminByID(Long id);
    ResponseEntity <String> createAdminAccount(SystemAdmin creatSystemAdmin);
    ResponseEntity <String> updateAdminAccount(Long id, SystemAdmin updatSystemAdmin);
    ResponseEntity <String> removeAdminAccount(Long id);

}
