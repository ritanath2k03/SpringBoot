package com.ritanath.library.controller;

import com.ritanath.library.dto.BorrowingDto;
import com.ritanath.library.exceptions.ErrorValidationResponse;
import com.ritanath.library.mapper.BorrowingMapper;
import com.ritanath.library.model.Borrowing;
import com.ritanath.library.service.BorrowingServiceInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
@Tag(name = "Borrowing", description = "Borrowing API Endpoints")
public class BorrowingController {

        private final BorrowingServiceInterface borrowingServiceInterface;

        @Operation(summary = "Borrow Book", description = "Borrow Book for Student")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Borrow Added Successfully", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = BorrowingDto.class))
                        }),
                        @ApiResponse(responseCode = "400", description = "Validation Error", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorValidationResponse.class))
                        }),
                        @ApiResponse(responseCode = "404", description = "Book Id Or Student Id Not Found")
        })

        @PostMapping("/borrow/{bookId}/appUser/{appUserId}")
        public ResponseEntity<?> borrowBook(@PathVariable Long bookId,
                        @PathVariable Long appUserId,
                        @Valid @RequestBody BorrowingDto requestBody) {

                Borrowing borrowing = borrowingServiceInterface.borrowBook(bookId, appUserId,
                                requestBody.getDateMustReturnIn());
                BorrowingDto responseBody = BorrowingMapper.toDto(borrowing);
                return ResponseEntity.ok()
                                .body(responseBody);
        }

        @Operation(summary = "Return Book", description = "Return Book from Student")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Book Returned Successfully"),
                        @ApiResponse(responseCode = "400", description = "Validation Error", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorValidationResponse.class))
                        }),
                        @ApiResponse(responseCode = "404", description = "Book Id Or Student Id Not Found")
        })

        @PutMapping("/return/{bookId}/appUser/{appUserId}")
        public ResponseEntity<?> returnBook(@PathVariable Long bookId,
                        @PathVariable Long appUserId) {

                LocalDate returnDate = LocalDate.now();

                Borrowing borrowing = borrowingServiceInterface.returnBook(bookId, appUserId, returnDate);
                BorrowingDto responseBody = BorrowingMapper.toDto(borrowing);

                return ResponseEntity.ok()
                                .body(responseBody);
        }
}
