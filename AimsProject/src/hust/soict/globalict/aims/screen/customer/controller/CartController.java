package hust.soict.globalict.aims.screen.customer.controller;


import java.io.IOException;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import hust.soict.globalict.aims.Store.Store;
import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.playable.Playable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private Cart cart;
	private Store store;
	
    public CartController(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
	}
	@FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TableColumn<Media,Integer> colMediaID;
    @FXML
    private TableColumn<Media,String> colMediaCategory;
    @FXML
    private TableColumn<Media,Float> colMediaCost;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private Label costLabel;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private TextField tfFilter;
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media=tblMedia.getSelectionModel().getSelectedItem();
    	if(media instanceof Playable)media.play();
    }
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media=tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media.getTitle());
    }
    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String STORE_FXML_FILE_PATH="/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
    		fxmlLoader.setController(new ViewStoreController(store,cart));
    		Parent root=fxmlLoader.load();
    		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    		stage.setTitle("Store");
    		stage.setScene(new Scene(root));
    		stage.show();
    		}
    		catch(IOException e) {
    			e.printStackTrace();
    		}
    }
    
    @FXML
    public void initialize() {
    	colMediaID.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media,String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media,Float>("cost"));
    	if(cart.getItemsOrdered()==null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		@Override
    		public void changed(ObservableValue<? extends Media>observable, Media oldValue, Media newValue) {
    			updateButtonBar(newValue);
    		}
    	});
    	
    }
    private void showFilterMedia(String newValue) {
    	
    }
    void updateButtonBar(Media media) {
    	if(media==null) {
    		btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	}
    	else {
    		btnRemove.setVisible(true);
    		if (media instanceof Playable) {
    			btnPlay.setVisible(true);
    		}
    		else btnPlay.setVisible(false);
    	}
    }
    
}