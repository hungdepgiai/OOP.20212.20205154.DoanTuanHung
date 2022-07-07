package hust.soict.globalict.aims.screen.customer.controller;
import java.io.IOException;

import hust.soict.globalict.aims.Store.Store;
import hust.soict.globalict.aims.cart.Cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class ViewStoreController {
private Store store;
private Cart cart;
@FXML
private GridPane gridPane;
public ViewStoreController(Store store,Cart cart) {
	this.store=store;
	this.cart=cart;
}
@FXML
void btnViewCartPressed(ActionEvent event) {
	try {
	final String CART_FXML_FILE_PATH="/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
	FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
	CartController cartcontroller=new CartController(cart,store);
	fxmlLoader.setController(cartcontroller);
	Parent root=fxmlLoader.load();
	Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	stage.setTitle("Cart");
	stage.setScene(new Scene(root));
	stage.show();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
}
@FXML
public void initialize() {
	final String ITEM_FXML_FILE_PATH="/hust/soict/globalict/aims/screen/customer/view/Item.fxml";
	int column=0;
	int row=1;
	for(int i=0;i<store.getItemsInStore().size();i++) {
		try {
			FXMLLoader fxmlLoader=new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
			ItemController itemController=new ItemController();
			fxmlLoader.setController(itemController);
			AnchorPane anchorPane=new AnchorPane();
			anchorPane=fxmlLoader.load();
			itemController.setData(store.getItemsInStore().get(i));
			if(column==3){
			column=0;
			row++;
			}
			gridPane.add(anchorPane,column++,row);
			GridPane.setMargin(anchorPane, new Insets(20,10,10,10));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

	}

