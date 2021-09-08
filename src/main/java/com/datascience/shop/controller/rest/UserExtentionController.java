package com.datascience.shop.controller.rest;

import com.datascience.shop.dto.UserDTO;
import com.datascience.shop.entity.User;
import com.datascience.shop.service.ServiceException;
import com.datascience.shop.service.UserServise;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.swing.plaf.PanelUI;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@RestController
@RequestMapping(value = "/rest/users777", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserExtentionController {

        private final UserServise userServise;



    }


