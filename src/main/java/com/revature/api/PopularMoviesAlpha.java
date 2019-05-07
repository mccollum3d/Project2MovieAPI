package com.revature.api;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.revature.model.PopMovie;
import com.revature.model.PopMovieList;
import com.revature.repository.PopMovieRepository;

@Service("popMoviesService")
public class PopularMoviesAlpha implements PopularMovies{
	
	private static Logger logger = Logger.getLogger(PopularMoviesAlpha.class);
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	PopMovieRepository popMovieRepositry;
	
	final String url = "https://api.themoviedb.org/3/movie/popular?api_key=0c0310c62d5381ede7d4780860ab79f6&language=en-US&page=1";
	final String findBy = "https://api.themoviedb.org/3/search/movie?api_key=0c0310c62d5381ede7d4780860ab79f6&language=en-US&query=";
	final String findBy2 = "&page=1&include_adult=false";
	public PopularMoviesAlpha() {
		
	}
	
	public PopMovie getPopMovieList(@RequestBody PopMovie popmovie){
		logger.trace("Attempting to get a list of Popular Movies");
		RestTemplate restTemplate = new RestTemplate();
		PopMovie popMovie = restTemplate.getForObject(url, PopMovie.class);
		return popMovie;
	}
	
//	public PopMovieList getPopMovieList(@RequestBody PopMovie popmovie){
//		logger.trace("Attempting to get a list of Popular Movies");
//		RestTemplate restTemplate = new RestTemplate();
//		PopMovieList popMovie = restTemplate.getForObject(url, PopMovieList.class);
//		return popMovie;
//	}
	
//	public List<PopMovie> getPopMovieList() {
//		logger.trace("Attempting to return a list of Popular Movies");
//		ResponseEntity<PopMovie[]> response = restTemplate.getForEntity(url, PopMovie[].class);
//		return Arrays.asList(response.getBody());
//
//	}
	
//	public PopMovie getByName(int id) {
//		ResponseEntity<PopMovie> response = restTemplate.getForEntity(findBy + title + findBy2, PopMovie.class);
//		return response.getBody();

}
