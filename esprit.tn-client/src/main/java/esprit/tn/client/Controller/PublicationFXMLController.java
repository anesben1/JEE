/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.tn.client.Controller;

import com.jfoenix.controls.JFXButton;
import entity.Post;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author HP I3
 */
public class PublicationFXMLController implements Initializable {

    @FXML
    private AnchorPane Post;
    @FXML
    private ImageView ImgUser;
    @FXML
    private Label NameUserTf;
    @FXML
    private Label PostDateTf;
    @FXML
    private Text PostTf;
    @FXML
    private JFXButton likebtn;
    @FXML
    private ImageView likeicon;
    @FXML
    private JFXButton Commentbtn;
    @FXML
    private JFXButton Sharebtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Post p = PublicationsFXMLController.post;
        NameUserTf.setText(p.getUsersPosts().getFirst_name()+" "+p.getUsersPosts().getLast_name());
        PostTf.setText(p.getContent());
        
    }    

    @FXML
    private void GotoProfil(MouseEvent event) {
    }

    @FXML
    private void OnlikePost(ActionEvent event) {
    }

    @FXML
    private void OnCommentpost(ActionEvent event) {
    }

    @FXML
    private void OnSharePost(ActionEvent event) {
    }

    @FXML
    private void OpenPost(MouseEvent event) {
    }
    
}
