package org.team4.upcomingevents.files;

import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
    
    void store(MultipartFile file);

}
