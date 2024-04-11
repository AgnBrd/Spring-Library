package com.ts.projekt_ts.infrastucture.service;

import com.ts.projekt_ts.controllers.dto.CreateLoanDto;
import com.ts.projekt_ts.controllers.dto.CreateResponseLoanDto;
import com.ts.projekt_ts.controllers.dto.GetLoanDto;
import com.ts.projekt_ts.infrastucture.entity.BookEntity;
import com.ts.projekt_ts.infrastucture.entity.LoanEntity;
import com.ts.projekt_ts.infrastucture.entity.UserEntity;
import com.ts.projekt_ts.infrastucture.repository.BookRepository;
import com.ts.projekt_ts.infrastucture.repository.LoanRepository;
import com.ts.projekt_ts.infrastucture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<GetLoanDto> getAll() {
        return loanRepository.findAll().stream()
                .map(loan -> new GetLoanDto(loan.getId(), loan.getBook().getId(), loan.getUser().getId()))// loan.getLoanDate(), loan.getEndDate(), loan.getReturnDate(), loan.getBook(), loan.getUser())
                .collect(Collectors.toList());
    }

    public GetLoanDto getOne(long id) {
        LoanEntity loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        return new GetLoanDto(loan.getId(), loan.getUser().getId(), loan.getBook().getId());//loan.getLoanDate(), loan.getEndDate(), loan.getReturnDate(), Optional.ofNullable(loan.getBook()), Optional.ofNullable(loan.getUser()));
    }

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
        return new CreateResponseLoanDto(newLoan.getId(), newLoan.getLoanDate(), newLoan.getEndDate(), newLoan.getReturnDate(), userId, bookId);// newLoan.getUser(), newLoan.getBook());
    }

    public void delete(long id) {
        if (!loanRepository.existsById(id)) {
            throw new RuntimeException("Loan not found");
        }
        loanRepository.deleteById(id);
    }
}

