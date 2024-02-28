package lostnfoundbe.Implementation;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import lostnfoundbe.Entity.SystemAdmin;
import lostnfoundbe.Repository.SystemAdminRepo;
import lostnfoundbe.Service.AdminService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class AdminImpl implements AdminService {

    @Autowired
    private SystemAdminRepo systemAdminRepo;

    @Override
    public List<SystemAdmin> queryAllAdmins() {
        List<SystemAdmin> fetchAdmins = systemAdminRepo.findAll();

        try {
            if (fetchAdmins.isEmpty()) {
                throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return fetchAdmins;
    }

    @Override
    public Optional<SystemAdmin> queryAdminByID(@PathVariable Long id) {

        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        Optional<SystemAdmin> adminID = systemAdminRepo.findById(id);

        try {
            if (!adminID.isPresent()) {
                throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return adminID;
    }

    @Override
    public ResponseEntity<String> createAdminAccount(@RequestBody SystemAdmin systemAdmin) {

        if (systemAdmin == null) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        Optional<SystemAdmin> existingFirstName = systemAdminRepo.findByFirstName(systemAdmin.getFirstName());
        Optional<SystemAdmin> existingLastName = systemAdminRepo.findByLastName(systemAdmin.getLastName());
        Optional<SystemAdmin> existingEmailAddress = systemAdminRepo.findByEmailAddress(systemAdmin.getEmailAddress());

        try {
            if (existingFirstName.isPresent() && existingLastName.isPresent() && existingEmailAddress.isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(" ADMIN DETAILS ALREADY EXIST ");
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        systemAdminRepo.save(systemAdmin);
        return ResponseEntity.status(HttpStatus.OK).body(" ADMIN ACCOUNT CREATED ");
    }

    @Override
    public ResponseEntity<String> updateAdminAccount(@PathVariable Long id, @RequestBody SystemAdmin systemAdmin) {

        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" ID MISSING ");
        }
        SystemAdmin systemAdmin2 = systemAdminRepo.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        systemAdmin2.setFirstName(systemAdmin.getFirstName());
        systemAdmin2.setLastName(systemAdmin.getLastName());
        systemAdmin2.setEmailAddress(systemAdmin.getEmailAddress());
        systemAdmin.setUserName(systemAdmin.getUserName());
        systemAdmin.setPassword(systemAdmin.getPassword());

        systemAdminRepo.save(systemAdmin);
        return ResponseEntity.status(HttpStatus.OK).body(" ADMIN DATA UPDATED ");
    }

}
