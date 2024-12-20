package com.ritanath.library.controller;

import com.ritanath.library.dto.BookDto;
import com.ritanath.library.exceptions.ErrorValidationResponse;
import com.ritanath.library.mapper.BookMapper;
import com.ritanath.library.model.Book;
import com.ritanath.library.service.BookServiceInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Book", description = "Book API Endpoints")
@RestController
@RequestMapping("/v1/book")

public class BookController {

        @Autowired
        private BookServiceInterface bookServiceInterface;

        @Operation(summary = "Add Book", description = "Add Book")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Book Added Successfully", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = BookDto.class))
                        }),
                        @ApiResponse(responseCode = "400", description = "Validation Error", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorValidationResponse.class))
                        })
        })
        @PostMapping
        public ResponseEntity<?> add(@Valid @RequestBody BookDto requestBody) {
                Book book = bookServiceInterface.save(BookMapper.toEntity(requestBody));
                BookDto responseBody = BookMapper.toDto(book);
                return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
        }

        @Operation(summary = "Find Book By Id", description = "Find Book By Id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Book Retrieved Successfully", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = BookDto.class))
                        }),
                        @ApiResponse(responseCode = "404", description = "Book Not Found With the Given Id")
        })

        @GetMapping("/{id}")
        public ResponseEntity<?> findById(@PathVariable Long id) {
                Book book = bookServiceInterface.findById(id);
                BookDto responseBody = BookMapper.toDto(book);
                return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }

        @Operation(summary = "Find All Books", description = "Find All Books")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Books Retrieved Successfully", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = BookDto.class))
                        })
        })
        @GetMapping
        public ResponseEntity<?> findAll() {
                List<Book> books = bookServiceInterface.findAll();

                System.out.println(books);
                List<BookDto> responseBody = books.stream()
                                .map(BookMapper::toDto)
                                .collect(Collectors.toList());

                return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }

        @Operation(summary = "Delete Book By Id", description = "Delete Book By Id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "Book Deleted Successfully"),
                        @ApiResponse(responseCode = "404", description = "Book Not Found With the Given Id")
        })
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteById(@PathVariable Long id) {
                bookServiceInterface.deleteById(id);
                return ResponseEntity.noContent()
                                .build();
        }

        @Operation(summary = "Update Book By Id", description = "Update Book By Id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "Book Updated Successfully"),
                        @ApiResponse(responseCode = "404", description = "Book Not Found With the Given Id")
        })

        @PutMapping("/{id}")
        public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody BookDto requestBody) {
                Book book = BookMapper.toEntity(requestBody);
                bookServiceInterface.updateById(id, book);
               
                return ResponseEntity.noContent()
                                .build();
        }
}
