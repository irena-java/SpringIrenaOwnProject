package com.datascience.shop.controller.rest;

import com.datascience.shop.dto.UserDTO;
import com.datascience.shop.dto.UserExtentionDTO;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@RestController
@RequestMapping(value = "/rest/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class UserController {
    private final UserServise userServise;

    @RequestMapping(value = "/get-test", method = RequestMethod.GET)
    public String getSomeString() {
        return "test";
    }

    @GetMapping(value = "/get-one")
    public ResponseEntity<UserDTO> getById(@RequestParam Integer id) {
        final User user = userServise.getById(id);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        final List<User> users = userServise.getAll();
        List<UserDTO> usersDTO = users.stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO();
                    BeanUtils.copyProperties(user, userDTO);
                    return userDTO;
                })
                .collect(Collectors.toList());
        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/get-one/{id}")
    public ResponseEntity<UserDTO> getById2(@PathVariable Integer id) {
        final User user = userServise.getById(id);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<UserDTO>> getPage(
            @RequestParam(required = false, defaultValue = "rrr") String name,
            @RequestParam int pageSize,
            @RequestParam int pageNumber) {
        final PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        final Page<User> pageUser = userServise.getPage(name, pageRequest);
        final Page<UserDTO> pageUserDTO = pageUser.map(user -> {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            return userDTO;
        });
        return new ResponseEntity<>(pageUserDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> create(
            @RequestBody UserDTO userDTO) {
        final User user = userServise.create(userDTO);
        userDTO.setId(user.getId());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) throws ServiceException {
        userServise.delete(id);
    }

    @PutMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @PathVariable Integer id,
            @RequestBody UserDTO userDTO) throws ServiceException {
        userServise.update(id, userDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/create-user-extension", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserExtentionDTO> createUserExtensionDTO(
            @RequestBody UserExtentionDTO userExtentionDTO) {
        return new ResponseEntity<>(userExtentionDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/filter")
    public ResponseEntity<List<UserDTO>> getByName(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "reer") String trash
    ) {
        final List<User> users = userServise.getByName(name);
        List<UserDTO> usersDTO = users.stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO();
                    BeanUtils.copyProperties(user, userDTO);
                    return userDTO;
                })
                .collect(Collectors.toList());
        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }
}