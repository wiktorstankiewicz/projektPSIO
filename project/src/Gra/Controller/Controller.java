package Gra.Controller;

import Gra.View.GUI;
import Gra.Model.ModelInterface;

import javax.swing.*;

public class Controller implements ControllerInterface {
    private ModelInterface model;
    private GUI gui;

    public Controller(Gra.Model.ModelInterface model){
        this.model = model;
        gui = new GUI(model, this);
    }

    public void kliknietoGuzik(JButton guzik) {
            if (guzik == gui.getNormalAttackButton()) model.normalAttackButton(1);
            else if (guzik == gui.getSpecialAttackButton()) model.normalAttackButton(2);
            else if (guzik == gui.getWalkUpButton()) model.walkUpAction();
    }
}
