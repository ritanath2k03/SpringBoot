package com.ritanath.library.controller;

import com.ritanath.library.dto.UserDto;
import com.ritanath.library.exceptions.ErrorValidationResponse;
import com.ritanath.library.mapper.UserMapper;
import com.ritanath.library.model.AppUser;
import com.ritanath.library.service.UserServiceInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/user")
@Tag(name = "User", description = "User API Endpoints")

public class UserController {
        @Autowired
        private UserServiceInterface appUserServiceInterface;

        @Operation(summary = "Add Student", description = "Add Student")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Book Added Successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))),
                        @ApiResponse(responseCode = "400", description = "Validation Error", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorValidationResponse.class))
                        })
        })
        @PostMapping
        public ResponseEntity<?> add(@Valid @RequestBody UserDto requestBody) {
                com.ritanath.library.model.AppUser newSavedStudent = appUserServiceInterface.add(UserMapper.toEntity(requestBody));
                UserDto responseBody = UserMapper.toDto(newSavedStudent);
                return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
        }

        @Operation(summary = "Find Student By Id", description = "Find Student By Id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Student Retrieved Successfully", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                        }),
                        @ApiResponse(responseCode = "404", description = "Student Not Found With the Given Id")
        })
        @GetMapping("/{id}")
        public ResponseEntity<?> findById(@PathVariable Long id) {
                AppUser appUser = appUserServiceInterface.findById(id);
                UserDto responseBody = UserMapper.toDto(appUser);
                return ResponseEntity.ok(responseBody);
        }

        @Operation(summary = "Find All Students", description = "Find All Students")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Students Retrieved Successfully", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                        })
        })

        @GetMapping
        public ResponseEntity<?> findAll() {
                List<AppUser> appUsers = appUserServiceInterface.findAll();
                List<UserDto> responseBody = appUsers.stream()
                                .map(UserMapper::toDto)
                                .collect(Collectors.toList());
                return ResponseEntity.ok(responseBody);
        }

        @Operation(summary = "Delete Student By Id", description = "Delete Student By Id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "Student Deleted Successfully"),
                        @ApiResponse(responseCode = "404", description = "Student Not Found With the Given Id")
        })
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteById(@PathVariable Long id) {
                appUserServiceInterface.deleteById(id);
                return ResponseEntity.noContent()
                                .build();
        }

        @Operation(summary = "Update Student By Id", description = "Update Student By Id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "Student Updated Successfully"),
                        @ApiResponse(responseCode = "404", description = "Student Not Found With the Given Id")
        })
        @PutMapping("/{id}")
        public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody UserDto requestBody) {
                AppUser appUser = UserMapper.toEntity(requestBody);
                AppUser updatedStudent = appUserServiceInterface.updateById(id, appUser);
                return ResponseEntity.noContent()
                                .build();
        }
}
