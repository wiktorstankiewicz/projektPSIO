package PostaciCreator.Controller;

import PostaciCreator.Model.ModelInterface;
import PostaciCreator.View.View;

public class Controller {
	ModelInterface model;
	View view;

	public Controller(ModelInterface model){
		this.model = model;
		view = new View(model);


	}
}
