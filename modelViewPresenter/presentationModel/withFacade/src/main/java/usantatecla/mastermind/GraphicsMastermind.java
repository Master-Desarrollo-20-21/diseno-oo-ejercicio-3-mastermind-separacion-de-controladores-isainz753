package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.View;
import usantatecla.mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind extends Mastermind {

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }

    @Override
    protected View createView(Logic logic) {
        return new GraphicsView(logic);
    }
}
