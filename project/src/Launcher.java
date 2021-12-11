import PostaciCreator.Controller.Controller;
import PostaciCreator.Controller.ControllerInterface;
import PostaciCreator.Model.Model;
import PostaciCreator.Model.ModelInterface;

public class Launcher {

	public static void main(String[] args){
		ModelInterface model = new Model();
		ControllerInterface controller = new Controller(model);
	}
}
