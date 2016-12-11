package authoring.editorview.path.subviews.editorfields;

import java.util.ResourceBundle;

import authoring.editorview.INodeView;
import authoring.utilityfactories.GridFactory;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class PathImageDisplayView implements INodeView {

	private ImageView pathImageView;
	
	private GridPane root;
	
	public PathImageDisplayView(ResourceBundle pathResource){
		
		formatPathImageView();
		buildRoot(pathResource);
	}

	@Override
	public Node getInstanceAsNode() {
		return root;
	}

	public void updateImage(String imagePath){
		addImageView(imagePath);
	}
	
	private void buildRoot(ResourceBundle pathResource){
		root = GridFactory.createRowWithLabelandNode(
				pathResource.getString("PathImage"), 
				pathImageView);
	}
	
	private void formatPathImageView() {
		pathImageView = new ImageView();
		pathImageView.setFitHeight(155);
		pathImageView.setFitWidth(155);
	}	
	
	private void addImageView(String pathImagePath) {
		
		Image image;
		if (root.getChildren().contains(pathImageView)){
			root.getChildren().remove(pathImageView);
		}
		
		if (!pathImagePath.contains("file:") && !pathImagePath.contains("http:")) {
			image = new Image (getClass().getClassLoader().getResourceAsStream(pathImagePath));		
		}
		
		else {
			image = new Image(pathImagePath);
		}
			
		pathImageView.setImage(image);
		root.getChildren().add(pathImageView);		
	}
	
}
