/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.book.store;
import BackEnd.AdminAccount;
import BackEnd.GuestAccount;
import static e.book.store.EBookSystem.BookList;
import java.awt.Component;
import java.awt.Event;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author Dell
 */
public class DashBoardController implements Initializable {

    @FXML
    ImageView Book1; 
    @FXML
    ImageView Book2;  
    @FXML
    ImageView Book3; 
    @FXML
    ImageView Book4; 
    @FXML
    ImageView Book5; 
    @FXML
    ImageView Book6; 
    @FXML
    ImageView Book7;
    @FXML
    ImageView Book8;
    @FXML
    Button AdminAdd;
     @FXML
    Button FavouriteList;

    public static int index;
    List<LocatedImage> image = new LinkedList<>();
    
    public void BuildList()
    {
        
          for(int i = 0 ; i<EBookSystem.BookList.size();i++)//here 7
        {
         
            image.add(new LocatedImage(EBookSystem.BookList.get(i).getImagePath()));
        }
          
    }
    @FXML
    public void OnClick(MouseEvent e) throws FileNotFoundException//add MouseEvent
    {
       try{
      if(e.getSource() == Book1) 
      {
          index = 0;
         
      }
      else if(e.getSource() == Book2)
      {
          index = 1;

      }
      else if(e.getSource() == Book3) 
      {
            index = 2;
 
          System.out.println("Clicked book 3");
      }
      else if(e.getSource() == Book4) 
      {
            index = 3;

          System.out.println("Clicked book 4");
      }
      else if(e.getSource() == Book5) 
      {
            index = 4;

          System.out.println("Clicked book 5");
      }
      else if(e.getSource() == Book6) 
      {
            index = 5;

          System.out.println("Clicked book 6");
      }
      else if(e.getSource() == Book7) 
      {
            index = 6;

          System.out.println("Clicked book 7");
      }
     else if(e.getSource() == Book8) 
      {
            index = 7;
            //setValues();
          System.out.println("Clicked book 8");
      }
      
      EBookSystem .setPane(6);
       }
       catch(Exception error)
       {
           System.out.println("Error in DashBoard");
       }
    }
    public void AnchorPaneEntered()
    {
        //System.out.println(EBookSystem.BookList.get(6).getImagePath());
        if(EBookSystem.UserList.get(EBookSystem.userIndex) instanceof GuestAccount)
        {
            System.out.println("Guest");
            AdminAdd.setVisible(false);
            FavouriteList.setVisible(true);
        }
        else
        {
            System.out.println("Admin");
            AdminAdd.setVisible(true);
            FavouriteList.setVisible(false);
        }
         ViewBooks(); 
    }
    public void backOnClick()
    {
          EBookSystem.setPane(0);
    }
    public void OnAddButtonClicked()
    {
        EBookSystem.setPane(8);
    }
    public void OnFavButtonClicked()
    {
        EBookSystem.FavGuest = true;
        EBookSystem.setPane(9);
    }
    public void ViewBooks()
    {
        int c = 0;
        BuildList();
        Book1.setImage(null);
        Book2.setImage(null);
        Book3.setImage(null);
        Book4.setImage(null);
        Book5.setImage(null);
        Book6.setImage(null);
        Book7.setImage(null);
        Book8.setImage(null);
        if(c != image.size())
        {
            Book1.setImage(image.get(0));
            c++;
        }

        if(image.size()!= c)
        {
            Book2.setImage(image.get(1));
            c++;
        }

        if(image.size()!= c)
        {
            Book3.setImage(image.get(2));
            c++;
        }

        if(image.size()!= c)
        {
            Book4.setImage(image.get(3));
            c++;
        }
        if(image.size()!= c)
        {
            Book5.setImage(image.get(4));
            c++;
        }

        if(image.size()!= c)
        {
            Book6.setImage(image.get(5));
            c++;
        }
        if(image.size()!= c)
        {
            Book7.setImage(image.get(6));
            c++;
        }
        if(image.size()!= c)
        {
            Book8.setImage(image.get(7));
            c++;
        } 
        image.clear();

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
      
     // ViewBooks();
    }
    
}
