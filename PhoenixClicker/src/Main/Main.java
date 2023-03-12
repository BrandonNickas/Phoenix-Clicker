package Main;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class Main extends Application {

    Counter counter = new Counter();


    public void start(Stage primaryStage) throws Exception {

        //These two arrays were used in the creation of the generator objects
        int[] cst = new int[4];
        String[] st = new String[5];

        //Making Intro to Stem
        st[0] = "Build a Rube Goldberg Machine";
        st[1] = "Build a Boat";
        st[2] = "Learn About Paper";
        st[3] = "Take a Personality Test";
        cst[0] = 75;
        cst[1] = 150;
        cst[2] = 400;
        cst[3] = 5000;

        Generator ITS = new Generator("Intro to Stem", 1, 25, st, cst);

        //Making Intro to Programing
        st[0] = "Write Hello World";
        st[1] = "Learn Loops";
        st[2] = "Make a Class";
        st[3] = "Make a Calculator";
        cst[0] = 750;
        cst[1] = 1500;
        cst[2] = 2000;
        cst[3] = 10000;

        Generator ITP = new Generator("Intro to Programing", 10, 500, st, cst);

        //Making Digital Media
        st[0] = "Edit Audio";
        st[1] = "Edit Pictures";
        st[2] = "Edit Video";
        st[3] = "Make an AD";
        cst[0] = 2300;
        cst[1] = 4500;
        cst[2] = 6000;
        cst[3] = 50000;

        Generator DM = new Generator("Digital Media", 50, 1700, st, cst);

        //Making Software Engineering
        st[0] = "Group Project";
        st[1] = "Write a SAD Document";
        st[2] = "Make UML Charts";
        st[3] = "Build an Idle Game";
        cst[0] = 12000;
        cst[1] = 15000;
        cst[2] = 25000;
        cst[3] = 1000000;

        Generator SE = new Generator("Software Engineering", 100, 10000, st, cst);

        //Making the Click Button
        st[0] = "Complete Freshman Year";
        st[1] = "Complete Sophomore Year";
        st[2] = "Survive Corona Virus";
        st[3] = "Complete Senior Year";
        cst[0] = 100;
        cst[1] = 500;
        cst[2] = 700;
        cst[3] = 1000;

        ClickButton btn = new ClickButton(st, cst);

        primaryStage.setTitle("Phoenix Clicker");



        //Set up for the UI

        Text phoenixes = new Text(Long.toString(counter.getCounter()));           //text that contains counter of phoenixes
        phoenixes.setFont(Font.font("Times New Roman", 36));            //font information for the counter

        Text generatorText = new Text("         generator");                      //text that appears above the generators
        generatorText.setFont(Font.font("Times New Roman", 20));

        Text upgradeText = new Text("            upgrade");                         //text that appears above the upgrade buttons
        upgradeText.setFont(Font.font("Times New Roman", 20));

        Button clickButton = new Button("Click");                           //the button that the user will push to increase the counter
        clickButton.setPrefSize(500, 50);                       //size configuration for the button
        clickButton.setMinSize(50, 50);

        clickButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //counter();
                counter.addCounter(btn.getBtnTotal());                      //this section controls how the button at the bottom of the screen functions
                phoenixes.setText(Long.toString(counter.getCounter()));
            }
        });

        Button introToStemGenerator = new Button(ITS.getGenName() + "\nCost: " + ITS.getGenCost() + "\nOwned: " + ITS.getGenAmount());      // set up for the intro to stem button
        introToStemGenerator.setPrefSize(200, 100);
        introToStemGenerator.setMaxSize(500, 500);

        introToStemGenerator.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                counter.setCounter(ITS.buyGen(counter.getCounter()));
                introToStemGenerator.setText(ITS.getGenName() + "\nCost: " + ITS.getGenCost() + "\nOwned: " + ITS.getGenAmount());               //how the intro to stem button talks with the generator class and displays the information
                phoenixes.setText(Long.toString(counter.getCounter()));
            }
        });


        Button intoToProgrammingGenerator = new Button(ITP.getGenName() + "\nCost: " + ITP.getGenCost() + "\nOwned: " + ITP.getGenAmount());        //set up for the intro to programming button
        intoToProgrammingGenerator.setPrefSize(200, 100);
        intoToProgrammingGenerator.setMaxSize(500, 500);

        intoToProgrammingGenerator.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                counter.setCounter(ITP.buyGen(counter.getCounter()));
                intoToProgrammingGenerator.setText(ITP.getGenName() + "\nCost: " + ITP.getGenCost() + "\nOwned: " + ITP.getGenAmount());               //the button talking with the generator class
                phoenixes.setText(Long.toString(counter.getCounter()));
            }
        });


        Button digitalMediaGenerator = new Button(DM.getGenName() + "\nCost: " + DM.getGenCost() + "\nOwned: " + DM.getGenAmount());            // set up for digital media button
        digitalMediaGenerator.setPrefSize(200, 100);
        digitalMediaGenerator.setMaxSize(500, 500);

        digitalMediaGenerator.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                counter.setCounter(DM.buyGen(counter.getCounter()));
                digitalMediaGenerator.setText(DM.getGenName() + "\nCost: " + DM.getGenCost() + "\nOwned: " + DM.getGenAmount());               //digital media button talking with the generator class
                phoenixes.setText(Long.toString(counter.getCounter()));
            }
        });


        Button softwareEngineeringGenerator = new Button(SE.getGenName() + "\nCost: " + SE.getGenCost() + "\nOwned: " + SE.getGenAmount());         //set up for the software engineering button
        softwareEngineeringGenerator.setPrefSize(200, 100);
        softwareEngineeringGenerator.setMaxSize(500, 500);

        softwareEngineeringGenerator.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                counter.setCounter(SE.buyGen(counter.getCounter()));
                softwareEngineeringGenerator.setText(SE.getGenName() + "\nCost: " + SE.getGenCost() + "\nOwned: " + SE.getGenAmount());               //the button talking with the generator class
                phoenixes.setText(Long.toString(counter.getCounter()));
            }
        });


        Button introToStemUpgrade = new Button(ITS.getSerText() + "\nCost: " + ITS.getSerCost());               //creation of the upgrade button for the intro to stem generator
        introToStemUpgrade.setPrefSize(200, 100);
        introToStemUpgrade.setMaxSize(500, 500);

        introToStemUpgrade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!ITS.isDone) {                                                                          //if statement to ensure it follows the array of upgrades with no overflow
                    counter.setCounter(ITS.serBuy(counter.getCounter()));
                    introToStemUpgrade.setText(ITS.getSerText() + "\nCost: " + ITS.getSerCost());               // the button changing text based on the current upgrade position
                    phoenixes.setText(Long.toString(counter.getCounter()));
                    if (ITS.isDone) {
                        introToStemUpgrade.setText(ITS.getSerText() + "\nPurchased");
                    }
                }

            }
        });


        Button introToProgrammingUpgrade = new Button(ITP.getSerText() + "\nCost: " + ITP.getSerCost());            //creation of the upgrade button for the intro to programming generator
        introToProgrammingUpgrade.setPrefSize(200, 100);
        introToProgrammingUpgrade.setMaxSize(500, 500);

        introToProgrammingUpgrade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!ITP.isDone) {                                                                                              //if statement to ensure it follows the array of upgrades with no overflow
                    counter.setCounter(ITP.serBuy(counter.getCounter()));
                    introToProgrammingUpgrade.setText(ITP.getSerText() + "\nCost: " + ITP.getSerCost());                    // the button going through the text array as upgrades are bought
                    phoenixes.setText(Long.toString(counter.getCounter()));
                    if (ITP.isDone) {
                        introToProgrammingUpgrade.setText(ITP.getSerText() + "\nPurchased");
                    }
                }
            }
        });


        Button digitalMediaUpgrade = new Button(DM.getSerText() + "\nCost: " + DM.getSerCost());                    //creation of the upgrade button for the digital media generator
        digitalMediaUpgrade.setPrefSize(200, 100);
        digitalMediaUpgrade.setMaxSize(500, 500);

        digitalMediaUpgrade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!DM.isDone) {                                                                                           //if statement to ensure it follows the array of upgrades with no overflow
                    counter.setCounter(DM.serBuy(counter.getCounter()));
                    digitalMediaUpgrade.setText(DM.getSerText() + "\nCost: " + DM.getSerCost());                                // the button going through the text array as upgrades are bought
                    phoenixes.setText(Long.toString(counter.getCounter()));
                    if (DM.isDone) {
                        digitalMediaUpgrade.setText(DM.getSerText() + "\nPurchased");
                    }
                }
            }
        });


        Button softwareEngineeringUpgrade = new Button(SE.getSerText() + "\nCost: " + SE.getSerCost());             //creation of the upgrade button for the software engineering generator
        softwareEngineeringUpgrade.setPrefSize(200, 100);
        softwareEngineeringUpgrade.setMaxSize(500, 500);

        softwareEngineeringUpgrade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!SE.isDone) {                                                                                           //if statement to ensure it follows the array of upgrades with no overflow
                    counter.setCounter(SE.serBuy(counter.getCounter()));
                    softwareEngineeringUpgrade.setText(SE.getSerText() + "\nCost: " + SE.getSerCost());                     // the button going through the text array as upgrades are bought
                    phoenixes.setText(Long.toString(counter.getCounter()));
                    if (SE.isDone) {
                        softwareEngineeringUpgrade.setText(SE.getSerText() + "\nPurchased");
                    }
                }
            }
        });


        Button clickButtonUpgrade = new Button(btn.getSerText() + "\nCost: " + btn.getSerCost());                    //creation of the upgrade button for the software engineering generator
        clickButtonUpgrade.setPrefSize(200, 100);
        clickButtonUpgrade.setMaxSize(500, 500);

        clickButtonUpgrade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!btn.isDone) {                                                                                          //if statement to ensure it follows the array of upgrades with no overflow
                    counter.setCounter(btn.serBuy(counter.getCounter()));
                    clickButtonUpgrade.setText(btn.getSerText() + "\nCost: " + btn.getSerCost());                           // the button going through the text array as upgrades are bought
                    phoenixes.setText(Long.toString(counter.getCounter()));
                    if (btn.isDone) {
                        clickButtonUpgrade.setText(btn.getSerText() + "\nPurchased");
                    }
                }
            }
        });


        Button Save = new Button("Save");                                                                           //creation of the save button
        Save.setPrefSize(100, 50);
        Save.setMaxSize(500, 500);

        Save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            //This action events holds the save function of the game.
            //O/I more specifically O was used to write all important to a save file on the users local machine
            public void handle(ActionEvent e) {
                File saveFile = new File("../saveFile.txt");

                if (saveFile.exists()) {
                    saveFile.delete();
                }

                try {
                    saveFile.createNewFile();
                    FileWriter writer = new FileWriter("saveFile.txt");
                    writer.write(counter.getCounter() + " " + btn.getSerPlace() + " " + btn.isDone + " " + ITS.getGenAmount() + " " + ITS.getSerPlace() + " " + ITS.isDone + " " + ITP.getGenAmount() + " " + ITP.getSerPlace() + " " + ITP.isDone + " " + DM.getGenAmount() + " " + DM.getSerPlace() + " " + DM.isDone + " " + SE.getGenAmount() + " " + SE.getSerPlace() + " " + SE.isDone);
                    writer.close();
                } catch (IOException ex) {
                    System.out.println("Error making file");
                }
            }
        });

        Button Load = new Button("Load");                                                                           //creation of the load button
        Load.setPrefSize(100, 50);
        Load.setMaxSize(500, 500);

        Load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            //This action even holds the load function of the game.
            //Inputs were read one by one while updating relevant variables. An update function for each of the classes that did some quick math
            public void handle(ActionEvent e) {
                try {
                    File saveFile = new File("saveFile.txt");
                    Scanner reader = new Scanner(saveFile);
                    int data = reader.nextInt();
                    counter.setCounter(data);

                    //Loading data for the click button
                    data = reader.nextInt();
                    btn.setSerPlace(data);
                    Boolean data2 = reader.nextBoolean();
                    btn.isDone = data2;
                    btn.update();
                    if (!btn.isDone) {
                        clickButtonUpgrade.setText(btn.getSerText() + "\nCost: " + btn.getSerCost());
                    } else {
                        clickButtonUpgrade.setText(btn.getSerText() + "\nPurchased");
                    }

                    //This loads info about the intro to stem class
                    data = reader.nextInt();
                    ITS.setGenAmount(data);
                    introToStemGenerator.setText(ITS.getGenName() + "\nCost: " + ITS.getGenCost() + "\nOwned: " + ITS.getGenAmount());
                    data = reader.nextInt();
                    ITS.setSerPlace(data);
                    data2 = reader.nextBoolean();
                    ITS.isDone = data2;
                    ITS.update();
                    if (!ITS.isDone) {
                        introToStemUpgrade.setText(ITS.getSerText() + "\nCost: " + ITS.getSerCost());
                    } else {
                        introToStemUpgrade.setText(ITS.getSerText() + "\nPurchased");
                    }

                    //This loads info about the intro to programing class
                    data = reader.nextInt();
                    ITP.setGenAmount(data);
                    intoToProgrammingGenerator.setText(ITP.getGenName() + "\nCost: " + ITP.getGenCost() + "\nOwned: " + ITP.getGenAmount());
                    data = reader.nextInt();
                    ITP.setSerPlace(data);
                    data2 = reader.nextBoolean();
                    ITP.isDone = data2;
                    ITP.update();
                    if (!ITP.isDone) {
                        introToProgrammingUpgrade.setText(ITP.getSerText() + "\nCost: " + ITP.getSerCost());
                    } else {
                        introToProgrammingUpgrade.setText(ITP.getSerText() + "\nPurchased");
                    }

                    //This loads info about the digital media  class
                    data = reader.nextInt();
                    DM.setGenAmount(data);
                    digitalMediaGenerator.setText(DM.getGenName() + "\nCost: " + DM.getGenCost() + "\nOwned: " + DM.getGenAmount());
                    data = reader.nextInt();
                    DM.setSerPlace(data);
                    data2 = reader.nextBoolean();
                    DM.isDone = data2;
                    DM.update();
                    if (!DM.isDone) {
                        digitalMediaUpgrade.setText(DM.getSerText() + "\nCost: " + DM.getSerCost());
                    } else {
                        digitalMediaUpgrade.setText(DM.getSerText() + "\nPurchased");
                    }

                    //This loads info about the software engineering class
                    data = reader.nextInt();
                    SE.setGenAmount(data);
                    softwareEngineeringGenerator.setText(SE.getGenName() + "\nCost: " + SE.getGenCost() + "\nOwned: " + SE.getGenAmount());
                    data = reader.nextInt();
                    SE.setSerPlace(data);
                    data2 = reader.nextBoolean();
                    SE.isDone = data2;
                    SE.update();
                    if (!SE.isDone) {
                        softwareEngineeringUpgrade.setText(SE.getSerText() + "\nCost: " + SE.getSerCost());
                    } else {
                        softwareEngineeringUpgrade.setText(SE.getSerText() + "\nPurchased");
                    }

                    reader.close();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });

        Image phoenixImage = new Image(new FileInputStream("birb.jpg"));                                            //import for the phoenix image
        ImageView imageView = new ImageView(phoenixImage);                                                                  //converting the image to be used for the screen
        imageView.setFitHeight(350);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);

        VBox vbox = new VBox();                                                                                             //creation of the generator column of buttons
        vbox.setSpacing(10);

        vbox.getChildren().add(generatorText);
        vbox.getChildren().add(introToStemGenerator);
        vbox.getChildren().add(intoToProgrammingGenerator);
        vbox.getChildren().add(digitalMediaGenerator);                                                                      //adding the UI elements to the VBox
        vbox.getChildren().add(softwareEngineeringGenerator);
        vbox.getChildren().add(Save);
        vbox.getChildren().add(Load);


        VBox vbox2 = new VBox();                                                                                            //creation of the upgrade column
        vbox2.setSpacing(10);

        vbox2.getChildren().add(upgradeText);
        vbox2.getChildren().add(introToStemUpgrade);
        vbox2.getChildren().add(introToProgrammingUpgrade);                                                                 // adding the UI elements to the VBox
        vbox2.getChildren().add(digitalMediaUpgrade);
        vbox2.getChildren().add(softwareEngineeringUpgrade);
        vbox2.getChildren().add(clickButtonUpgrade);


        BorderPane screen = new BorderPane();                                                                               //creation of the border pane that will hold all UI elements
        screen.setPadding(new Insets(5, 5, 5, 5));
        HBox hbox = new HBox();
        screen.setTop(phoenixes);                                                                                           //setting the counter at the top of the screen
        screen.setAlignment(phoenixes, Pos.BOTTOM_CENTER);
        StackPane stackPane = new StackPane(hbox);                                                                           // Add HBox in top region

        screen.setCenter(imageView);
        screen.setAlignment(clickButton, Pos.BOTTOM_CENTER);
        screen.setLeft(vbox);                                                                                               //laying out where the UI elements will go
        screen.setRight(vbox2);
        screen.setBottom(clickButton);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {                                                                                             // thread to make the counter update with the per second function
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        counter.perSecond(ITS.getGenTotal(), ITP.getGenTotal(), DM.getGenTotal(), SE.getGenTotal());            // calling to receive how much it will add to the counter
                        phoenixes.setText(Long.toString(counter.getCounter()));
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);                                                                         //making the screen update every second until closed
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
        thread.setDaemon(true);
        thread.start();

        Scene scene = new Scene(screen, 1000, 500);                                                             //setting the bounds for the screen
        primaryStage.setScene(scene);

        primaryStage.show();                                                                                                //making the screen visible to the user
    }

    public void counter() {                                                                                                 //a test method to make sure that all buttons and UI elements work when interacted with
        counter.addCounter(1000000);
    }

    public static void main(String[] args) {
        launch(args);                                                                                                       // launching the UI and in turn the other classes of the project
    }
}