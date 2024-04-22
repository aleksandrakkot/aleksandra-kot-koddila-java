package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StatisticsCalculatorTestSuite {

    @Mock
    private Statistics statisticsMock;

    private StatisticsCalculator statisticsCalculator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        statisticsCalculator = new StatisticsCalculator();
    }

    @Test
    void testCalculateAdvStatisticsWithNoPosts() {
        List<String> users = Arrays.asList("user1", "user2");
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);

        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        assertEquals(2, statisticsCalculator.getUsersCount());
        assertEquals(0, statisticsCalculator.getPostsCount());
        assertEquals(0, statisticsCalculator.getCommentsCount());
        assertEquals(0, statisticsCalculator.getAvgPostsPerUser());
        assertEquals(0, statisticsCalculator.getAvgCommentsPerUser());
        assertEquals(0, statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWithThousandPosts() {
        // Given
        List<String> users = Arrays.asList("user1", "user2");
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(2000);

        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(2, statisticsCalculator.getUsersCount());
        assertEquals(1000, statisticsCalculator.getPostsCount());
        assertEquals(2000, statisticsCalculator.getCommentsCount());
        assertEquals(500, statisticsCalculator.getAvgPostsPerUser());
        assertEquals(1000, statisticsCalculator.getAvgCommentsPerUser());
        assertEquals(2, statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWithNoComments() {
        // Given
        List<String> users = Arrays.asList("user1", "user2");
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);

        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(2, statisticsCalculator.getUsersCount());
        assertEquals(100, statisticsCalculator.getPostsCount());
        assertEquals(0, statisticsCalculator.getCommentsCount());
        assertEquals(50, statisticsCalculator.getAvgPostsPerUser());
        assertEquals(0, statisticsCalculator.getAvgCommentsPerUser());
        assertEquals(0, statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWithLessCommentsThanPosts() {
        // Given
        List<String> users = Arrays.asList("user1", "user2");
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);

        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(2, statisticsCalculator.getUsersCount());
        assertEquals(100, statisticsCalculator.getPostsCount());
        assertEquals(50, statisticsCalculator.getCommentsCount());
        assertEquals(50, statisticsCalculator.getAvgPostsPerUser());
        assertEquals(25, statisticsCalculator.getAvgCommentsPerUser());
        assertEquals(0.5, statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWithMoreCommentsThanPosts() {
        // Given
        List<String> users = Arrays.asList("user1", "user2");
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);

        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(2, statisticsCalculator.getUsersCount());
        assertEquals(50, statisticsCalculator.getPostsCount());
        assertEquals(100, statisticsCalculator.getCommentsCount());
        assertEquals(25, statisticsCalculator.getAvgPostsPerUser());
        assertEquals(50, statisticsCalculator.getAvgCommentsPerUser());
        assertEquals(2, statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWithNoUsers() {
        // Given
        List<String> users = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(200);

        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, statisticsCalculator.getUsersCount());
        assertEquals(100, statisticsCalculator.getPostsCount());
        assertEquals(200, statisticsCalculator.getCommentsCount());
        assertEquals(0, statisticsCalculator.getAvgPostsPerUser());
        assertEquals(0, statisticsCalculator.getAvgCommentsPerUser());
        assertEquals(2, statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWithHundredUsers() {
        // Given
        List<String> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            users.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(2000);

        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(100, statisticsCalculator.getUsersCount());
        assertEquals(1000, statisticsCalculator.getPostsCount());
        assertEquals(2000, statisticsCalculator.getCommentsCount());
        assertEquals(10, statisticsCalculator.getAvgPostsPerUser());
        assertEquals(20, statisticsCalculator.getAvgCommentsPerUser());
        assertEquals(2, statisticsCalculator.getAvgCommentsPerPost());
    }
}
