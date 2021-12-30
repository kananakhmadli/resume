package com.company.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DummyService {

    @PreAuthorize("hasAnyAuthority('ADMIN')")
//    @PreAuthorize("isAuthenticated()")  //sənin üçün sesia açılıbsa icazə verir
    public void foo() {
        log.info("foo was called in dummy service");
    }

}