package com.app.Scap;

import com.app.Scap.view.menuScap;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScapApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ScapApplication.class, args);
		Application.launch(menuScap.class, args);

	}

}
