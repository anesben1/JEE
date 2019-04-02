/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.tn.client.Controller;

import java.awt.Dialog;
import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.soap.Text;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import entity.Condidate_Profile;
import entity.Entreprise_Profile;
import entity.Post;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import services.serviceConnectionRemote;
import services.servicePublicationRemote;

/**
 * FXML Controller class
 *
 * @author HP I3
 */
public class PublicationsFXMLController implements Initializable {

    @FXML
    private TextArea PostTf;
    private Button Postbtn;
    private Button Cancelbtn;
    @FXML
    private VBox PostsFeeds;
    
    public static Post post;
    @FXML
    private VBox listCondidatSugg;
    @FXML
    private Hyperlink ConnectionlistLink;
    @FXML
    private VBox listEntrepriseSugg;
    @FXML
    private Hyperlink followSuggetionLink;
    @FXML
    private Hyperlink FollowlistLink;
    @FXML
    private Hyperlink SeggetionPersonLink;
    @FXML
    private StackPane postStackpane;
    
    public static JFXDialog PostForm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	
    	Hashtable ht=new Hashtable();
		ht.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
     	ht.put("java.naming.provider.url","http-remoting://localhost:18080");
		ht.put("jboss.naming.client.ejb.context",true);
		
		try {
			Context ctx = new InitialContext(ht);	
			Object obj = ctx.lookup("/ergaciaBU-ear/ergaciaBU-ejb/servicePublication!services.servicePublicationRemote");
			servicePublicationRemote service = (servicePublicationRemote) obj;
			List<Post> listposts = service.ReturnPostbyConnectionsandfollows(LoginFXMLController.CurrentUser);
			for(Post p : listposts )
			{
				post =p;
				 try {
			            Parent root = FXMLLoader.load(getClass().getResource("PublicationFXML.fxml"));
			            PostsFeeds.getChildren().add(root);
			        } catch (IOException ex) {
			            ex.printStackTrace();
			        }
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
			
			Map<Condidate_Profile,Integer> listsuggetion = Metier.ReturnSeggestionConnections(LoginFXMLController.CurrentUser);
			for(Condidate_Profile p : listsuggetion.keySet() )
			{
				 FXMLProfilCondidModelController.profil=p;
				 try {
			            Parent root = FXMLLoader.load(getClass().getResource("FXMLProfilCondidModel.fxml"));
			            listCondidatSugg.getChildren().add(root);
			        } catch (IOException ex) {
			            ex.printStackTrace();
			        }
			}
			
			ArrayList<Entreprise_Profile> listsuggetionEntr = Metier.ReturnSeggestionEntreprise(LoginFXMLController.CurrentUser);
			for(Entreprise_Profile p : listsuggetionEntr )
			{
				 FXMLEntrepriseModelController.profil=p;
				 try {
			            Parent root = FXMLLoader.load(getClass().getResource("FXMLEntrepriseModel.fxml"));
			            listEntrepriseSugg.getChildren().add(root);
			        } catch (IOException ex) {
			            ex.printStackTrace();
			        }
			}
		
    }    


    private void CancelOnClick(ActionEvent event) {
        PostTf.setText("");
        Postbtn.setVisible(false);
        Cancelbtn.setVisible(false);
        
    }

    private void DisablingPost(MouseEvent event) {
        Postbtn.setVisible(false);
        Cancelbtn.setVisible(false);
    }

    private void OnWritingPost(MouseEvent event) {
        Postbtn.setVisible(true);
        Cancelbtn.setVisible(true);
    }


    @FXML
    private void GottoConnections(ActionEvent event) {
    }

    @FXML
    private void GotofollowSuggetion(ActionEvent event) {
    }

    @FXML
    private void GotoFollows(ActionEvent event) {
    }

    @FXML
    private void PopPostFormu(MouseEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("PostAddDialog.fxml"));
    	JFXDialogLayout dialogLayout = new JFXDialogLayout();
    	JFXTextField Head = new JFXTextField("Create your post");
    	Head.setEditable(false);
    	dialogLayout.setHeading(Head);
    	dialogLayout.setBody(root);
    	 PostForm = new JFXDialog(postStackpane,dialogLayout,JFXDialog.DialogTransition.CENTER);
    	JFXButton Cancellbtn = new JFXButton("Cancel");
    	
    	
    	Cancellbtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				PostForm.close();
			}
		});
    	
    	
    	dialogLayout.setActions(Cancellbtn);
    	
    	PostForm.show();
    }

    @FXML
    private void GotoSeggetionlConnectionistAction(ActionEvent event) {
    }
    
}
