package com.ts.projekt_ts.infrastucture.service;

import com.ts.projekt_ts.controllers.dto.*;
import com.ts.projekt_ts.infrastucture.entity.BookEntity;
import com.ts.projekt_ts.infrastucture.entity.LoanEntity;
import com.ts.projekt_ts.infrastucture.entity.UserEntity;
import com.ts.projekt_ts.infrastucture.repository.BookRepository;
import com.ts.projekt_ts.infrastucture.repository.LoanRepository;
import com.ts.projekt_ts.infrastucture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;

    }

    /**
     * Retrieves a list of all loans.
     * @return a list of GetLoanDto objects representing all loans
     */
    public List<GetLoanDto> getAll() {

        return loanRepository.findAll().stream()
                .map(loan -> new GetLoanDto(loan.getId(), loan.getLoanDate(), loan.getEndDate(), loan.getReturnDate(), loan.getBook().getId(), loan.getUser().getId(), loan.getBook().getTitle()))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a single loan by ID.
     * @param id the ID of the loan to retrieve
     * @return a GetLoanDto object representing the retrieved loan
     */
    public GetLoanDto getOne(long id) {

        LoanEntity loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        return new GetLoanDto(loan.getId(), loan.getLoanDate(), loan.getEndDate(), loan.getReturnDate(), loan.getUser().getId(), loan.getBook().getId(), loan.getBook().getTitle());//loan.getLoanDate(), loan.getEndDate(), loan.getReturnDate(), Optional.ofNullable(loan.getBook()), Optional.ofNullable(loan.getUser()));
    }

    /**
     * Creates a new loan.
     * @param loan the data for creating the new loan
     * @return a CreateResponseLoanDto object representing the created loan
     */
    public CreateResponseLoanDto create(CreateLoanDto loan) {

        LoanEntity loanEntity = new LoanEntity();
        UserEntity user = (userRepository.findById(loan.getUserId())).orElse(new UserEntity());
        BookEntity book = (bookRepository.findById(loan.getBookId())).orElse(new BookEntity());
        loanEntity.setLoanDate(loan.getLoanDate());
        loanEntity.setEndDate(loan.getEndDate());
        loanEntity.setReturnDate(loan.getReturnDate());
        loanEntity.setUser(user);
        loanEntity.setBook(book);
        LoanEntity newLoan = loanRepository.save(loanEntity);
        long userId = newLoan.getUser().getId();
        long bookId = newLoan.getBook().getId();
        return new CreateResponseLoanDto(newLoan.getId(), newLoan.getLoanDate(), newLoan.getEndDate(), newLoan.getReturnDate(), userId, bookId);
    }

    /**
     * Updates a loan's information.
     * @param id the ID of the loan to update
     * @param dto the data to update the loan with
     * @return an UpdateLoanResponseDto object representing the updated loan
     */
    public UpdateLoanResponseDto update(long id, UpdateLoanDto dto) {

        var loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        UserEntity user = (userRepository.findById(dto.getUserId())).orElse(new UserEntity());
        BookEntity book = (bookRepository.findById(dto.getBookId())).orElse(new BookEntity());
        loan.setLoanDate(dto.getLoanDate());
        loan.setEndDate(dto.getEndDate());
        loan.setReturnDate(dto.getReturnDate());
        loan.setUser(user);
        loan.setBook(book);
        loanRepository.save(loan);
        long userId = loan.getUser().getId();
        long bookId = loan.getBook().getId();
        return new UpdateLoanResponseDto(loan.getLoanDate(), loan.getEndDate(), loan.getReturnDate(), userId, bookId);
    }

    /**
     * Deletes a loan by ID.
     * @param id the ID of the loan to delete
     */
    public void delete(long id) {

        if (!loanRepository.existsById(id)) {
            throw new RuntimeException("Loan not found");
        }
        loanRepository.deleteById(id);
    }
}

