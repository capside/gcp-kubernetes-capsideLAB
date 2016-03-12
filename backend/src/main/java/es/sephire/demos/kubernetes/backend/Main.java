package es.sephire.demos.kubernetes.backend;


import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.exception;
import static spark.Spark.get;

public class Main {

	public static void main(String[] args) {
		CorsFilter.apply();
		Gson gson = new Gson();

		get("/", (req, res) -> {
			return "Good day, sir.";
		});

		get("/user/:name", (request, response) -> {
			String name = request.params(":name");

			return "Hello, " + name + ". How do you do?";
		});

		get("/movies", (request, response) -> {

			List<Movie> movies = new ArrayList<Movie>();

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection("jdbc:mysql://172.17.0.4/test?user=testuser&password=1234");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from movies");

			while(resultSet.next()){
				movies.add(new Movie(
						resultSet.getLong("id"),
						resultSet.getString("name"),
						resultSet.getDate("publish_date"),
						resultSet.getString("description")
				));
			}

			return movies;
		},gson::toJson);

		exception(Exception.class,(e,request,response)->{
			response.status(500);
			response.body("Server Error: "+e.getMessage());
		});
	}

}
