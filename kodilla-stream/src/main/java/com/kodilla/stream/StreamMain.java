package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()  // [1]
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));                    // [2]

        System.out.println(theResultStringOfBooks);

        Forum theForumList = new Forum();
        Map<Integer, ForumUser>  theResultStringOfUsers = theForumList.getUserList().stream()
                .filter(user -> user.getGender() == 'M') // Filtrujemy tylko mężczyzn
                .filter(user -> user.getBirthDate().isBefore(LocalDate.now().minusYears(20))) // Filtrujemy użytkowników mających co najmniej 20 lat
                .filter(user -> user.getPostsCount() > 0) // Filtrujemy użytkowników, którzy mają co najmniej jeden opublikowany post
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user)); // Tworzymy mapę userId -> ForumUser

        System.out.println(theResultStringOfUsers);
    }
}