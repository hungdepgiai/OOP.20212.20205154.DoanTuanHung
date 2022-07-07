package hust.soict.globalict.aims.screen.customer.controller;

import java.util.ArrayList;

import hust.soict.globalict.aims.Store.Store;
import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCartScreen extends Application {
	private static Store store;
	private static Cart cart;
	@Override
	public void start(Stage primaryStage) throws Exception{
		final String STORE_FXML_FILE_PATH="/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
				FXMLLoader fxmlLoader=new FXMLLoader();
				CartController CartController=new CartController(cart,store);
				fxmlLoader.setController(CartController);
				fxmlLoader.setLocation(getClass().getResource(STORE_FXML_FILE_PATH));
				Parent root=fxmlLoader.load();
				primaryStage.setTitle("Cart");
				primaryStage.setScene(new Scene(root));
				primaryStage.show();
						}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
cart=new Cart();
DigitalVideoDisc dvd1=new DigitalVideoDisc("First disk","Animation",23.45f,75,"Jason");
DigitalVideoDisc dvd3= new DigitalVideoDisc("The Lion King","Animation",19.95f,87,"Roger Allers");
DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars","Science Fiction",24.95f,87,"George Lucas");
DigitalVideoDisc dvd4 = new DigitalVideoDisc("Princess Mononoke","Animation",18.99f,133,"Hayao Miyazaki");
DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spirited Away","Animation",18.15f,125, "Hayao Miyazaki");
DigitalVideoDisc dvd6 = new DigitalVideoDisc("Tenet","Action",  22.45f,75, "Christopher Nolan");
DigitalVideoDisc dvd7 = new DigitalVideoDisc("Space Wars","Science Fiction",15.99f,90, "Stanley Kubrick");
ArrayList<String>authors=new ArrayList<String>();
authors.add("Hung");
authors.add("Hien");
Book book=new Book("Don quixote","Novel",18.67f,authors);
cart.addMedia(dvd1,book,dvd2,dvd3);
launch(args);
	}
}
