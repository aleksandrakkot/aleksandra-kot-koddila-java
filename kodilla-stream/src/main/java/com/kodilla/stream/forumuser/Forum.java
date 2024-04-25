package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Forum {
    private final List<ForumUser> theForumList = new ArrayList<>();

    public Forum() {
        theForumList.add(new ForumUser(1, "johnDoe", 'M', LocalDate.of(1990, 5, 15), 10));
        theForumList.add(new ForumUser(2, "aliceSmith", 'F', LocalDate.of(1985, 9, 22), 0));
        theForumList.add(new ForumUser(3, "bobJohnson", 'M', LocalDate.of(1988, 3, 10), 5));
        theForumList.add(new ForumUser(4, "emmaBrown", 'F', LocalDate.of(1995, 11, 7), 3));
        theForumList.add(new ForumUser(5, "michaelWilson", 'M', LocalDate.of(1980, 7, 3), 7));

    }
    public List<ForumUser> getUserList() {
        return new ArrayList<>(theForumList);
    }
}
