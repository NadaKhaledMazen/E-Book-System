/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.book.store;

import BackEnd.AdminAccount;
import BackEnd.Book;
import BackEnd.GuestAccount;
import BackEnd.JsonFileCreater;
import static e.book.store.EBookSystem.BookList;
import static e.book.store.EBookSystem.UserList;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;

/**
 * FXML Controller class
 *
 * @author nadam
 */
public class BookViewController implements Initializable {

    @FXML 
    ImageView imageView;
    @FXML
    Label BookName;
    @FXML
    Label AuthorName;
    @FXML
    Label Genre;
    @FXML
    Label Description;
    @FXML
    Button AddBook;
    @FXML
    Button RemoveBook;
    
    public static final int MaxBook = 8;
    
    public void setImageToEmp(Image image)
    {
        imageView.setImage(image);
    }
    public void setValues()
    {
        if(EBookSystem.UserList.get(EBookSystem.userIndex) instanceof GuestAccount )
        {
             if(EBookSystem.FavGuest == false)
             {
                 AddBook.setVisible(true);
                 RemoveBook.setVisible(false);
             }
             

        }
         System.out.println(EBookSystem.FavGuest);
        if(EBookSystem.FavGuest == false)
        {
            CheckDash(EBookSystem.BookList.get(DashBoardController.index));
        }
        else if (EBookSystem.FavGuest == true)
        {
            CheckDash(((GuestAccount)EBookSystem.UserList.get(EBookSystem.userIndex)).getBookList().get(GuestFavListController.FavGuestIndex));
        }
//        BookName.setText(EBookSystem.BookList.get(DashBoardController.index).getBookName());
//        imageView.setImage(new Image(BookList.get(DashBoardController.index).getImagePath()));
//        AuthorName.setText(BookList.get(DashBoardController.index).getAutherName());
//        Genre.setText(BookList.get(DashBoardController.index).getGenre());
//        Description.setText(BookList.get(DashBoardController.index).getDescription());
 
    }
    public void CheckDash(Book book)
    {
        BookName.setText(book.getBookName());
        imageView.setImage(new Image(book.getImagePath()));
        AuthorName.setText(book.getAutherName());
        Genre.setText(book.getGenre());
        Description.setText(book.getDescription());
    }
    public void onClickAdd() throws IOException
    {
          Component frame = null;
        if(((GuestAccount)EBookSystem.UserList.get(EBookSystem.userIndex)).getBookList().size()<8)
        {
           //AddBook to the Guest BookList
            //public Book(String autherName, String description, String bookName, String genre,String path,String imagePath)
            ((GuestAccount)EBookSystem.UserList.get(EBookSystem.userIndex)).AddBook(BookList.get(DashBoardController.index));//(BookList.get(DashBoardController.index));
            JsonFileCreater.PrintInFile(EBookSystem.UserList,EBookSystem.BookList);
            JOptionPane.showMessageDialog(frame,"You Successfully added The Book ","Book Adder",JOptionPane.PLAIN_MESSAGE);
            
        }
        else
        {
            JOptionPane.showMessageDialog(frame,"You have Exceeded the Number of Books!","Book Adder",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    public void onClickRemove() throws IOException, FileNotFoundException, ParseException
    {
       if(EBookSystem.UserList.get(EBookSystem.userIndex) instanceof GuestAccount)
       {
           ((GuestAccount)EBookSystem.UserList.get(EBookSystem.userIndex)).RemoveBook(GuestFavListController.FavGuestIndex);
       }
       else if(EBookSystem.UserList.get(EBookSystem.userIndex) instanceof AdminAccount)
       {
           ((AdminAccount)EBookSystem.UserList.get(EBookSystem.userIndex)).RemoveBook(DashBoardController.index);
       }
      
       JsonFileCreater.PrintInFile(EBookSystem.UserList,EBookSystem.BookList);
      if(EBookSystem.FavGuest == false)
         {EBookSystem .setPane(5);}
         else if(EBookSystem.FavGuest == true)
         {EBookSystem .setPane(9);} 
    }
    public void OnClickView()
    {
           
    }
    public void OnClickBack()
    {
        BookName.setText("Book Name: ");
        imageView.setImage(null);
        AuthorName.setText("Author Name: ");
        Genre.setText("Genre: ");
        Description.setText("Description: ");
        AddBook.setVisible(false);
        RemoveBook.setVisible(true);
         if(EBookSystem.FavGuest == false)
         {EBookSystem .setPane(5);}
         else if(EBookSystem.FavGuest == true)
         {EBookSystem .setPane(9);} 
         
    }
    public void OnClickRead()
    {
        try{
            File pdfFile = new File(EBookSystem.BookList.get(DashBoardController.index).getPath());//Implement the actual Book
            if (pdfFile.exists()) {

			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(pdfFile);
			} else {
				System.out.println("Awt Desktop is not supported!");
			}

		} else {
			System.out.println("File is not exists!");
		}

		System.out.println("Done");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {    
                    
    }    
    
}
