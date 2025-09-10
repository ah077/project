package com.fsd.project.service;

import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Staff;
import com.fsd.project.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found with id: " + id));
    }

    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff updateStaff(Long id, Staff staffDetails) {
        Staff existingStaff = getStaffById(id);
        existingStaff.setName(staffDetails.getName());
        existingStaff.setRole(staffDetails.getRole());
        existingStaff.setPhone(staffDetails.getPhone());
        existingStaff.setAddress(staffDetails.getAddress());
        // Note: Updating department relationship would require fetching the Department entity
        return staffRepository.save(existingStaff);
    }

    public void deleteStaff(Long id) {
        if (!staffRepository.existsById(id)) {
            throw new ResourceNotFoundException("Staff not found with id: " + id);
        }
        staffRepository.deleteById(id);
    }
}