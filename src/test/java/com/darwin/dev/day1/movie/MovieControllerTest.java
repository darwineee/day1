package com.darwin.dev.day1.movie;

import com.darwin.dev.day1.mock.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieRepository movieRepository;

    @Test
    public void testGetMovies_returnAll() throws Exception {
        //Arrange
        List<Movie> movieList = new ArrayList<>();
        Data.fill(movieList);
        var movieJson = new ObjectMapper().writeValueAsString(movieList);

        //Act
        when(movieRepository.getMovies(Optional.empty(), Optional.empty())).thenReturn(movieList);
        var act = mockMvc.perform(get("/movies"));

        //Assert
        act.andExpect(status().isOk());
        act.andExpect(content().json(movieJson));
    }
}
