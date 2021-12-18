package com.company.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

    @PreAuthorize("hasAnyAuthority('ADMIN')")
//    @PreAuthorize("isAuthenticated()")  //sənin üçün sesia açılıbsa icazə verir
    public void foo(){
        System.out.println("foo was called in dummy service");
    }
}
