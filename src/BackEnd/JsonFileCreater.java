/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;
import e.book.store.EBookSystem;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.*;
/**
 *
 * @author nadam
 */
public abstract  class JsonFileCreater 
{
    private static FileWriter file;
    public static void PrintInFile(List<User> UserList , List<Book> BookList)throws IOException
    {
        JSONObject TheObject = new JSONObject();
        
          JSONArray GuestArr = new JSONArray();
          JSONArray AdminArr = new JSONArray();
        for (int i = 0 ; i< UserList.size() ; i++) 
        {
            JSONObject Guest = new JSONObject();
             JSONObject Admin = new JSONObject();
             if(UserList.get(i) instanceof GuestAccount )
             {
             Guest.put("UserName", UserList.get(i).getUserName() );
             Guest.put("Password", UserList.get(i).getPassword());
             Guest.put("Answer", ((GuestAccount)UserList.get(i)).getAnswer());
             Guest.put("BookList", AddBookValues(((GuestAccount)UserList.get(i)).getBookList()));
             GuestArr.add(Guest);
             }
             else if(UserList.get(i) instanceof AdminAccount ) 
             {
                Admin.put("UserName", UserList.get(i).getUserName() );
                Admin.put("Password", UserList.get(i).getPassword());
                AdminArr.add(Admin);
              }
        }
        
        TheObject.put("Guest", GuestArr);
        TheObject.put("Admin", AdminArr);
        TheObject.put("Books", AddBookValues(BookList));
      try{
            file = new FileWriter("DataBase.txt");
            file.write(TheObject.toJSONString());

      } catch (IOException e) {
      } finally {

          try {
              file.flush();
              file.close();
          } catch (IOException e) {}
      }
      
    } 
      
     public static void FileScanner(List<User> UserList , List<Book> BookList) throws FileNotFoundException, IOException, org.json.simple.parser.ParseException
     {
         GuestAccount guest;
         
         Book book;
         try{
             
                  
       JSONObject obj =  (JSONObject) new JSONParser().parse(new FileReader("DataBase.txt"));

        JSONArray BooksArray = (JSONArray) obj.get("Books");

        for (int j = 0; j < BooksArray.size(); j++)
        {

          JSONObject Book = (JSONObject) BooksArray.get(j);

          String Genre = (String) Book.get("genre");
          String Description = (String) Book.get("description");
          String BookName = (String) Book.get("bookName");
          String Auther = (String) Book.get("autherName");
          String Path = (String) Book.get("path");
          String ImagePath = (String) Book.get("imagePath");
//
//             System.out.println(Genre);
//             System.out.println(Description);
//             System.out.println(BookName);
//             System.out.println(Auther);

            BookList.add(new Book(Auther,Description,BookName,Genre,Path,ImagePath));
          //System.out.println("_________________________________________");
        }
         JSONArray GuestArray = (JSONArray) obj.get("Guest");
         
         for (int i = 0; i < GuestArray.size(); i++)
         {
             JSONObject Guest = (JSONObject) GuestArray.get(i);
             
             String UserName = (String) Guest.get("UserName");
             String Password = (String) Guest.get("Password");
             String Answer = (String) Guest.get("Answer");
             
//                System.out.println(UserName);
//                System.out.println(Password);
//                System.out.println(Answer);             
             
             GuestAccount GuestConstructor = new GuestAccount(UserName,Password,Answer);
             JSONArray GuestBookArray = (JSONArray) Guest.get("BookList");
             for (int j = 0; j <  GuestBookArray.size(); j++)
             {
                JSONObject Book = (JSONObject)  GuestBookArray.get(j);
                 
                String Genre = (String) Book.get("genre");
                String Description = (String) Book.get("description");
                String BookName = (String) Book.get("bookName");
                String Auther = (String) Book.get("autherName");
                String Path = (String) Book.get("path");
                String ImagePath = (String) Book.get("imagePath");
         
//                   System.out.println(Description);
//                   System.out.println(BookName);                   
//                   System.out.println(Genre);
//                   System.out.println(Auther);
                //The Guest isnot Downloading the File itself but only a refrence 
               GuestConstructor.AddBook(new Book(Auther,Description,BookName,Genre,Path,ImagePath));
                 
             }
              
              UserList.add(GuestConstructor);
             

       }
         
        JSONArray AdminArray = (JSONArray) obj.get("Admin");
        
         for (int i = 0; i < AdminArray.size(); i++)
         {             
           JSONObject Admin = (JSONObject) AdminArray.get(i);

           String UserName = (String) Admin.get("UserName");
           String Password = (String) Admin.get("Password");


           UserList.add(new AdminAccount(UserName,Password,BookList));
         }
          

        }
         
         catch(FileNotFoundException e){}
         catch(IOException | ParseException e){}
         
     }
     
     private static JSONArray AddBookValues(List<Book> b)
     {
            
            JSONArray BooksArray =new JSONArray();
        for (int i = 0 ; i< b.size() ; i++) {
             JSONObject book = new JSONObject();
             book.put("autherName", b.get(i).getAutherName());
             book.put("bookName", b.get(i).getBookName());
             book.put("description", b.get(i).getDescription());
             book.put("genre", b.get(i).getGenre());
             book.put("path", b.get(i).getPath());
             book.put("imagePath", b.get(i).getImagePath());
             BooksArray.add(book);
        }
        return BooksArray;
     }
       
}