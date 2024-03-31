/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.util.List;

/**
 *
 * @author nadam
 */
public final class AdminAccount extends User
{	
	 private List<Book> BookList; 
	
	public AdminAccount(String userName, String password,List<Book> BookList) {
		super(userName, password);
		this.BookList=BookList;
	}

	public AdminAccount(AdminAccount Admin) {
		super(Admin);
		this.BookList=Admin.BookList;
	}

	@Override
	public void RemoveBook(int index) 
        {
            BookList.remove(index);
	}

	@Override
	public void AddBook(Book book) {
            BookList.add(book);
	}
        
      
}
