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
	File file = null;
	
	for (int year = 2001; year <= 2010; year++) {
	  Map<String, Integer> boyMap = new TreeMap<String, Integer>();
	  Map<String, Integer> girlMap = new TreeMap<String, Integer>();
	  
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
			  
			  System.out.println(boyMap.toString());
			  System.out.println(girlMap.toString());
			  
			}
			catch (Exception e) {
			  e.printStackTrace();
			}
		  }
		  mapForBoy.put(year - 2000, boyMap);//////////////////////////////////
		  
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
        
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");
    
  }
  
  //DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
