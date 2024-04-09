package com.ts.projekt_ts.controllers;

import com.ts.projekt_ts.controllers.dto.CreateLoanDto;
import com.ts.projekt_ts.controllers.dto.CreateResponseLoanDto;
import com.ts.projekt_ts.controllers.dto.GetLoanDto;
import com.ts.projekt_ts.infrastucture.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    @PreAuthorize("hasRole('EMPLOEE') || hasRole('ADMIN')")
    public List<GetLoanDto> getAllLoans() {
        return loanService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOEE') || hasRole('ADMIN')")
    public GetLoanDto getOne(@PathVariable long id) {
        return loanService.getOne(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('EMPLOEE') || hasRole('ADMIN')")
    public ResponseEntity<CreateResponseLoanDto> create(@RequestBody CreateLoanDto loan) {
        var newLoan = loanService.create(loan);
        return new ResponseEntity<>(newLoan, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('EMPLOEE') || hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        loanService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

