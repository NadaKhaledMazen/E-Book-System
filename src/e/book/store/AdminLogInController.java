/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.book.store;

import BackEnd.AdminAccount;
import java.awt.Component;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nadam
 */
public class  AdminLogInController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField AdminUserName;
    @FXML
    TextField AdminPassword;
  public static boolean AddView = false;
    private boolean flag = false;
    
    
     public void BackClicked()
    {
    	EBookSystem.setPane(0);
        EBookSystem.userIndex = -1;
    }
     public void LoginClicked()
    {
          Component frame = null;
        for (int i =  0;i<EBookSystem.UserList.size();i++)
        {
            if(EBookSystem.UserList.get(i) instanceof AdminAccount ) 
            {
                if(EBookSystem.UserList.get(i).getUserName().equals(AdminUserName.getText()))
                {
                    if(EBookSystem.UserList.get(i).getPassword().equals(AdminPassword.getText()))
                    {
                        flag = true;
                        System.out.println("Logged in!");
                        flag = false;
                        JOptionPane.showMessageDialog(frame,"Logged in successfully","Login confirmation",JOptionPane.PLAIN_MESSAGE);
                        EBookSystem.userIndex = EBookSystem.UserList.size() - 1;
                        AddView = true;
                        AdminUserName.clear();
                        AdminPassword.clear();
                        EBookSystem.setPane(5);
                       return;

                    }                
                }
            }
        }
        if(flag == false)
        {
            JOptionPane.showMessageDialog(frame,"Incorrect UserName or Password!\n Please try Again","Login confirmation",JOptionPane.ERROR_MESSAGE);

            System.out.println("Not Logged in!");
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
