package com.example.prj.service;

import com.example.prj.pojo.AuthenticateRequest;
import com.example.prj.pojo.AuthenticateResponse;

public interface AuthenticateService {

    AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest);
}
