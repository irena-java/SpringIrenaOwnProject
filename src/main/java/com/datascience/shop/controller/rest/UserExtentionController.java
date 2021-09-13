package com.datascience.shop.controller.rest;

import com.datascience.shop.service.UserExtentionService;
import com.datascience.shop.service.UserServise;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Builder
@RestController
@RequestMapping(value = "/rest/users777", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class UserExtentionController {
        private final UserExtentionService userExtentionService;
    }


