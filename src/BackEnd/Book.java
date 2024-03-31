/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

/**
 *
 * @author nadam
 */
public final class Book
{
    	private  String AutherName;
	private String Description ;
	private String BookName;
        private String Genre;
        private String Path;
        private String ImagePath;
    
        public Book()
        {}
	public Book(Book book) {
		this.AutherName = book.AutherName;
		this.Description = book.Description;
		this.BookName = book.BookName;
		this.Genre = book.Genre;
	}
	public Book(String autherName, String description, String bookName, String genre,String path,String imagePath) {//Image path is to be Implemented
		AutherName = autherName;
		Description = description;
		BookName = bookName;
		Genre = genre;
                Path = path;
                ImagePath = imagePath;
	}
	public String getAutherName() {
		return AutherName;
	}
	public void setAutherName(String autherName) {
		AutherName = autherName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}

        public String getPath() {
        return Path;
        }

        public void setPath(String Path) {
        this.Path = Path;
        }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String ImagePath) {
        this.ImagePath = ImagePath;
    }
    
}
