package gra.controller;

import gra.view.GUI;
import gra.model.IGameModel;

import javax.swing.*;

public class GameController implements IGameController {
    private IGameModel model;
    private GUI gui;

    public GameController(IGameModel model){
        this.model = model;
        gui = new GUI(model, this);
    }

    public void kliknietoGuzik(JButton guzik) {
            if (guzik == gui.getNormalAttackButton()) model.normalAttack(1);
            else if (guzik == gui.getSpecialAttackButton()) model.normalAttack(2);
            else if (guzik == gui.getWalkUpButton()) model.walkUpAction();
    }
}
