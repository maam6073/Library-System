package com.rmsoft_test.LibrarySystem.book.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int book_id;
    @Column
    String name;
    @Column
    String detail;
    @Column
    int count;

    private enum bookStatus{
        RENTAL_ON("대여 가능"),
        RENTAL_OFF("대여 불가"),
        BOOK_OVERDUE("연체중");
        @Getter
        private String status;

        bookStatus(String status){
            this.status = status;
        }
    }
}
