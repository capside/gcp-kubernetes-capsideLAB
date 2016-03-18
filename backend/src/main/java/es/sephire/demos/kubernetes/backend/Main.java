package es.sephire.demos.kubernetes.backend;


import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

			//Obtain the mysql service address
			Map<String, String> env = System.getenv();
			String mysqlHost = env.get("MYSQL_SERVICE_HOST");
			String mysqlPort = env.get("MYSQL_SERVICE_PORT");
			String mysqlUser = env.get("DB_USER_NAME");
			String mysqlPassword = env.get("DB_USER_PASSWORD");
			StringBuilder connectionUrl = new StringBuilder();
			connectionUrl.append("jdbc:mysql://").append(mysqlHost).append(":").append(mysqlPort)
						 .append("/test?user=").append(mysqlUser).append("&password=").append(mysqlPassword);

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection(connectionUrl.toString());
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
