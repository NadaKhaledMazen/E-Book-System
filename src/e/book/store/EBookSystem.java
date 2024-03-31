/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.book.store;

import BackEnd.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import javafx.scene.image.Image;
/**
 *
 * @author nadam
 */
public class EBookSystem extends Application {

        public static List<User> UserList = new LinkedList<User>();
    	//public static List<GuestAccount> GuestList=new LinkedList<GuestAccount>(); 
        //public static List<AdminAccount> AdminList=new LinkedList<AdminAccount>(); 
        public static List<Book> BookList=new LinkedList<Book>();
       // public Book book = new Book("rrrrr","eeeee","kkkkkk","7azomblo","C:\\Users\\Dell\\OneDrive\\Desktop\\CE Schedule-Spring2022.pdf","C:\\Users\\nadam\\Destop\\UNIVERSITY\\SEMSETER 6\\Object-Oriented Programming\\Project\\Images\\GoogleIcon.png")
        public  GuestAccount guest = new GuestAccount("Guest1","Gest1Pass","Guest1Ans");
        public  GuestAccount guest2 = new GuestAccount("a","a","a");
        public AdminAccount Admin = new AdminAccount("1", "1" , BookList );
        public static int userIndex;
         public static boolean FavGuest = false;
         public void Print() throws JSONException, IOException, FileNotFoundException, ParseException
    {
//        BOOK1
           BookList.add(new Book("William Stallings","Data and Computer Communications, 10e, is a two-time winner of the best"
                    + " Computer Science and Engineering textbook of the year award from the Textbook and Academic Authors Association. It is ideal for one/two-semester courses in Computer Networks, Data Communications, and Communications Networks in CS, CIS, and Electrical Engineering departments. This book is also suitable for Product Development personnel, Programmers, Systems Engineers, Network Designers and others involved in the design of data communications and networking products."
                    ,"Data and Computer Communications", "Education" ,"pdf//Data and computer communications.pdf" ,"/PDFfile/Data and Computers Communictions.jpeg"));
        //BOOK2
           BookList.add(new Book("M. Morris Mano","Digital Design,fifth edition is a modern update of the classic authoritative text on digital design.  This book teaches the basic concepts of digital design in a clear, accessible manner. The book presents the basic tools for the design of digital circuits and provides procedures suitable for a variety of digital applications.",
                   "Digital Design: With a Introduction to the Verilog Hdl","Education","pdf//Digital Design With a Introduction to the Verilog Hdl.pdf","/PDFfile/MorisMano.jpeg"));
        //BOOK3
           BookList.add(new Book("M. Morris Mano","Dealing with computer architecture as well as computer organization and design, this fully updated book provides the basic knowledge necessary to understand the hardware operation of digital computers. Written to aid electrical engineers, computer engineers, and computer scientists, the volume includes: KEY FEATURES: the computer architecture, organization, and design associated with computer hardware • the various digital components used in the organization and design of digital computers • detailed steps that a designer must go through in order to design an elementary basic computer • the organization and architecture of the central processing unit • the organization and architecture of input-output and memory • the concept of multiprocessing • two new chapters on pipeline and vector processing • two sections devoted completely to the reduced instruction set computer (RISC) • and sample worked-out problems to clarify topics.",
                   "Computer System Architecture","Education","pdf//Computer System Architecture.pdf","/PDFfile/Computer Architecture.jpeg"));
        //BOOK4
          BookList.add(new Book("William G. Sullivan","For courses in undergraduate introductory engineering economics. Understand the importance of engineering economics principles and how to make smart economic choices Used by engineering students worldwide, this bestselling text provides a sound understanding of the principles, basic concepts, and methodology of engineering economy. Explanations and examples that are student-centered and practical in real-life situations help students develop proficiency in the methods and processes for making rational decisions. Built upon the rich and time-tested teaching materials of earlier editions, the text is extensively revised and updated to reflect current trends and issues. The new edition captures the spirit of environmental sustainability with more than 160 \"green\" problems, as well as new end-of-chapter problems and group exercises, and includes updates to the new 2017 Federal Tax code revisions. MyLab (TM) Engineering is not included. Students, if MyLab Engineering is a recommended/mandatory component of the course, please ask your instructor for the correct ISBN. MyLab Engineering should only be purchased when required by an instructor. Instructors, contact your Pearson representative for more information. Reach every student by pairing this text with MyLab Engineering MyLab (TM) is the teaching and learning platform that empowers you to reach every student. By combining trusted author content with digital tools and a flexible plat"
                  + "form, MyLab personalizes the learning experience and improves results for each student","Engineering Economy ","Education","pdf//Engineering Economy.pdf","/PDFfile/Engineering Economy.jpeg"));
        //BOOK5
          BookList.add(new Book("Ronald E. Walpole and Raymond H. Myers","For junior/senior undergraduates taking probability and statistics as applied to engineering, science, or computer science. This classic text provides a rigorous introduction to basic probability theory and statistical inference, with a unique balance between theory and methodology. Interesting, relevant applications use real data from actual studies, showing how the concepts and methods can be used to solve problems in the field. This revision focuses on improved clarity and deeper understanding. MyStatLab is not included. Students, if MyStatLab is a recommended/mandatory component of the course, please ask your instructor for the correct ISBN and course ID. MyStatLab should only be purchased when required by an instructor. Instructors, contact your Pearson representative for more information. MyStatLab is an online homework, tutorial, and assessment program designed to work with this text to engage students and improve results. Within its structured environment, students practice what they learn, test their understanding, and pursue a personalized study plan that helps them absorb course material and understand difficult concepts."
                  ,"Probability and Statistics for Engineering and The Sciences","Education","pdf//Probability and Statistics for Engineering and The Sciences.pdf","/PDFfile/math6.jpeg"));
        //BOOK6
          BookList.add(new Book("Louis Nashelsky and Robert Boylestad","Electronic Devices and Circuit Theory, Eleventh Edition, offers students a complete, comprehensive survey, focusing on all the essentials they will need to succeed on the job. Setting the standard for nearly 30 years, this highly accurate text is supported by strong pedagogy and content that is ideal for new students of this rapidly changing field. The colorful layout with ample photographs and examples enhances students’ understanding of important topics. This text is an excellent reference work for anyone involved with electronic devices and other circuitry applications, such as electrical and technical engineers."
                  ,"Electronic Devices and Circuit Theory","Education","pdf//Electronic Devices and Circuit Theory.pdf","/PDFfile/Electronics1.jpeg"));
        //BOOK7
          BookList.add(new Book("Thomas L. Floyd","Description. Digital Fundamentals, Eleventh Edition, continues its long and respected tradition of offering students a strong foundation in the core fundamentals of digital technology, providing basic concepts reinforced by plentiful illustrations, examples, exercises, and applications.",
                  "Digital Fundamentals","Education","pdf//Digital Fundamentals.pdf","/PDFfile/Digital Fundamentals.jpeg"));
        //BOOK8
          BookList.add(new Book("B.L. THERAJA and A.k. THERAJA","Textbook of Electrical Technology: Volume I elaborately covers all the basic concepts of Electrical Engineering. The book discusses and explains various theories related to electrical engineering ranging from electric circuits to capacitors and different types of AC Circuits. The book also explains concepts of Harmonics and Fourier series. The chapters consist of various exercises, examples and multiple illustrations that aid in understanding the subject better. A book which has seen, foreseen and incorporated changes in the subject for more than 50 years, it continues to be one of the most sought after texts by the students","Electrical Technology",
                 "Education","pdf//Electrical Technology.pdf","/PDFfile/Electronics 2.jpeg"));
        
        
            UserList.add(guest);
            UserList.add(guest2);
            UserList.add(Admin);
        
         //JsonFileCreater.FileScanner( UserList,BookList);
         JsonFileCreater.PrintInFile( UserList,BookList);
        }
         
         
         
         
         
     	static AnchorPane root;
	static List<Pane> ProgramFrames = new ArrayList<Pane>(); 
	private static int  curIndex=0;    
    @Override
    public void start(Stage primaryStage) throws Exception {
          Print();

          //JsonFileCreater.FileScanner(UserList,BookList);
          System.out.println(((GuestAccount)EBookSystem.UserList.get(0)).getBookList().size());
        
      try {  
     root = (AnchorPane)FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
     Scene scene = new Scene(root);
     primaryStage.setTitle("E-Book System");
     primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("Logo.jpeg")));
     ProgramFrames.add((Pane)FXMLLoader.load(getClass().getResource("HomeFrame.fxml")));//index = 0
     ProgramFrames.add((Pane)FXMLLoader.load(getClass().getResource("AdminLogIn.fxml")));//index = 1
     ProgramFrames.add((Pane)FXMLLoader.load(getClass().getResource("GuestLogIn.fxml")));// index = 2
     ProgramFrames.add((Pane)FXMLLoader.load(getClass().getResource("ForgetPassword.fxml")));//index = 3
     ProgramFrames.add((Pane)FXMLLoader.load(getClass().getResource("Register.fxml")));//index = 4
     ProgramFrames.add((Pane)FXMLLoader.load(getClass().getResource("DashBoard.fxml")));//index = 5
     ProgramFrames.add((Pane)FXMLLoader.load(getClass().getResource("BookView.fxml")));//index = 6
     ProgramFrames.add((Pane)FXMLLoader.load(getClass().getResource("CreateNewPassword.fxml")));//index = 7
     ProgramFrames.add((Pane)FXMLLoader.load(getClass().getResource("AdminAddBook.fxml")));//index = 8
      ProgramFrames.add((Pane)FXMLLoader.load(getClass().getResource("GuestFavList.fxml")));//index = 9
     root.getChildren().add(ProgramFrames.get(0));
     //setSize
       primaryStage.setResizable(false);
       primaryStage.setScene(scene);
       primaryStage.show();
     }
      catch(Exception e)
     {
            e.printStackTrace();
        }
    }

    	public static Pane getPane(int index)
	{
		return ProgramFrames.get(index);
	}
	public static void setPane(int index)
        {
            root.getChildren().remove(ProgramFrames.get(curIndex));
            root.getChildren().add(ProgramFrames.get(index));
            curIndex = index;
		
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JSONException, IOException {
      
        launch(args);
    }
    
     
    
}
