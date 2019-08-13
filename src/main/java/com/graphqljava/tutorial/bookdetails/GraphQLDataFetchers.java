package com.graphqljava.tutorial.bookdetails;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> books = Arrays.asList(
            ImmutableMap.of("id", "book-1",
                    "name", "Harry Potter and the Philosopher's Stone",
                    "pageCount", "223"),
            ImmutableMap.of("id", "book-2",
                    "name", "Moby Dick",
                    "pageCount", "635"),
            ImmutableMap.of("id", "book-3",
                    "name", "Interview with the vampire",
                    "pageCount", "371")
    );

    public DataFetcher getBookByPageCountDataFetcher() {
        return dataFetchingEnvironment -> {
            Integer bookId = dataFetchingEnvironment.getArgument("pageCount");
            return books
                    .stream()
                    .filter(book -> Integer.valueOf(book.get("pageCount")).equals(bookId))
                    .findFirst()
                    .orElse(null);
        };
    }
}
