/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nadam
 */
public final class GuestAccount extends User
{
    	private String Answer;
	private List<Book> BookList =new LinkedList<Book>(); 
	public List<Book> getBookList() {
		return BookList;
	}

	public void setBookList(List<Book> bookList) {
		BookList = bookList;
	}


	public GuestAccount (){}
	public GuestAccount(String userName, String password,String Answer) {
		super(userName, password);
		this.Answer =Answer;
	}

	public GuestAccount(GuestAccount Guest) {
		super(Guest);
		
	}

	@Override
	public void RemoveBook(int index) 
        {
		BookList.remove(index);
	}

	@Override
	public void AddBook(Book book)
        {
            BookList.add(book);
	}
        
        public String getAnswer()
        {
            return Answer;
        }

	public void setAnswer(String answer) {
		Answer = answer;
	}
    
}
