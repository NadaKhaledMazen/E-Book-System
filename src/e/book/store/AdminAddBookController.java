/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.book.store;

import BackEnd.Book;
import BackEnd.JsonFileCreater;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AdminAddBookController implements Initializable {

    /**
     * Initializes the controller class.
     */
//    @FXML
//    ImageView iv;
    @FXML
    TextField BookName;
    @FXML
    TextField AuthorName;
    @FXML
    TextField Genre;
    @FXML
    TextArea Description;
    @FXML
    TextField ImagePath;
    @FXML
    TextField PDFPath;
    @FXML
    Button AddBook;
    @FXML
    ImageView imageview;
//    public void AddImage(MouseEvent e)
//    {
//        
//    }
    Book b = new Book();
    Component frame = null;
    public void BackClicked()
    {
    	EBookSystem.setPane(5);
    }
    public void OnClickAddBook() throws FileNotFoundException, IOException
    {//
//ImagePath.getText().isEmpty()
            //

        if(BookName.getText().isEmpty() || AuthorName.getText().isEmpty() || Genre.getText().isEmpty()|| Description.getText().isEmpty()|| PDFPath.getText().isEmpty()
                || ImagePath.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(frame,"Book Data is Missing!","Admin Book Add",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            
            if(EBookSystem.BookList.size()<8)
            {
                if(AddPdfFile() == false)
                {
                    JOptionPane.showMessageDialog(frame,"Please re-Enter your Pdf File Path as structured","Admin Book Add",JOptionPane.ERROR_MESSAGE);
                }
              //  else if(AddImageFile() == true)
//                {
                    
                    b.setImagePath(ImagePath.getText());
                    b.setAutherName(AuthorName.getText());
                    b.setBookName(BookName.getText());
                    b.setGenre(Genre.getText());
                    b.setDescription(Description.getText());
                    JOptionPane.showMessageDialog(frame,"You have sucessfully Added a new Book","Admin Book Add",JOptionPane.PLAIN_MESSAGE);
                    EBookSystem.BookList.add(b);
                    JsonFileCreater.PrintInFile(EBookSystem.UserList, EBookSystem.BookList);
                    BookName.clear();
                    AuthorName.clear();
                    Genre.clear();
                    Description.clear();
                    PDFPath.clear();
                    ImagePath.clear();
                    imageview.setImage(null);
//                }
//                else 
//                {
//                    JOptionPane.showMessageDialog(frame,"Please re-Enter your Image File Path as structured","Admin Book Add",JOptionPane.ERROR_MESSAGE);
//                }

            }
            else
            {
                JOptionPane.showMessageDialog(frame,"You Have Exceeded The Maximum Number Of Books","Admin Book Add",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public boolean AddPdfFile()
    {
        try{
            File pdfFile = new File(PDFPath.getText());//Implement the actual Book
            if (pdfFile.exists()) 
            {

                if (Desktop.isDesktopSupported())
                {
                    b.setPath(PDFPath.getText());
                    return true;
                } 
                else
                {
                   return false;
                    
                }

		} 
            else
            {
		return false;
            }

		
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     return false;   
    }
    public boolean AddImageFile() throws FileNotFoundException //onClick Function for the CheckImage Button
    {
        File ImageFile = new File(ImagePath.getText());//Implement the actual Book
            if (ImageFile.exists()) 
            {
                try
                {
                    imageview.setImage(new Image(new FileInputStream(ImagePath.getText())));
                    
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(frame,"The Image Path isnot in the correct Format!","Admin Book Add",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
         
            }
            return true;
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
