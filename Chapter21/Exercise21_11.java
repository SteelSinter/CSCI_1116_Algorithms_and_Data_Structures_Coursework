import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
  private HashMap<String, Integer>[] mapForBoy = new HashMap[10];
  private HashMap<String, Integer>[] mapForGirl = new HashMap[10];
  
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  
  private final static String urlString = 
		  "http://liveexample.pearsoncmg.com/data/babynamesranking";
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) throws MalformedURLException {
	URL url = null;
	HashMap<String, Integer> boyMap;
	HashMap<String, Integer> girlMap;
	
	for (int year = 2001; year <= 2010; year++) {
	  boyMap = new HashMap<String, Integer>();
	  girlMap = new HashMap<String, Integer>();
	  
	  url = new URL(urlString + year + ".txt");
	  System.out.println(url.toString());
	  
	  try (Scanner input = new Scanner(new DataInputStream(new BufferedInputStream(url.openStream())))) {
		  for (int rank = 1; rank <= 1000; rank++) {
			try {
			  input.next();
			  boyMap.put(String.valueOf(input.next()), rank);
			  input.next();
			  girlMap.put(String.valueOf(input.next()), rank);
			  input.nextLine();
			  
			}
			catch (Exception e) {
			  e.printStackTrace();
			}
		  }
		  mapForBoy[year - 2000 - 1] = (boyMap);
		  mapForGirl[year - 2000 - 1] = (girlMap);
		}
	    catch (Exception e) {
		  e.printStackTrace();
		}
	  
	}
	
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    for (int year = 2001; year <= 2010; year++) {
      cboYear.getItems().add(year);
    }
    cboYear.setValue(2001);
        
    cboGender.getItems().addAll("Boy", "Girl");
    cboGender.setValue("Boy");
    
    btFindRanking.setOnAction(e -> {
    	HashMap<String, Integer> map;
    	String name = tfName.getText();
    	
    	if (cboGender.getValue() == "Boy") {
    		map = mapForBoy[cboYear.getValue() - 2000 - 1];
    	}
    	else {
    		map = mapForGirl[cboYear.getValue() - 2000 - 1];
    	}
    	tfName.setText(name = name.replace(name.charAt(0), (String.valueOf(name.charAt(0)).toUpperCase()).charAt(0)));
    	
    	if (map.get(name) == null)
    		lblResult.setText(name + " was not found in the year " + cboYear.getValue() + ".");
    	else
    		lblResult.setText(name + " was ranked #" + map.get(name) + " in the year " + cboYear.getValue());
    	
    });
    
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
