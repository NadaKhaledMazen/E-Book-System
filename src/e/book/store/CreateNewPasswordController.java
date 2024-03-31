/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.book.store;

import BackEnd.*;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class CreateNewPasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField NewPassword;
    @FXML 
    TextField ConfirmPassword; 
    
    public void OnConfirmClick() throws IOException
    {
         Component frame = null;
         if(NewPassword.getText().isEmpty()|| ConfirmPassword.getText().isEmpty())
         {
            JOptionPane.showMessageDialog(frame,"Password Field Is Empty","New Password confirmation",JOptionPane.ERROR_MESSAGE);
         }
         else 
         {
            if(NewPassword.getText().equals(ConfirmPassword.getText()))
            { System.out.println(((GuestAccount)EBookSystem.UserList.get(0)).getBookList().size());
                
                ((GuestAccount)EBookSystem.UserList.get(EBookSystem.userIndex)).setPassword(NewPassword.getText());//if Class is imported you dont have to call the static member using class name
                JsonFileCreater.PrintInFile(EBookSystem.UserList,EBookSystem.BookList);
                JOptionPane.showMessageDialog(frame,"New Password Confirmed ","New Password confirmation",JOptionPane.PLAIN_MESSAGE);
                NewPassword.clear();
                ConfirmPassword.clear();
                EBookSystem.setPane(5);
            }
            else
            {

                JOptionPane.showMessageDialog(frame,"New Password Doesn't Match The Confirm Password","New Password confirmation",JOptionPane.ERROR_MESSAGE);
            }
         }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
