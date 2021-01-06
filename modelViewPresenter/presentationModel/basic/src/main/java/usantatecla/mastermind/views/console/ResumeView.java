package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.YesNoDialog;

class ResumeView {

    private ResumeController resumeController;

    ResumeView(ResumeController resumeController) {
        this.resumeController = resumeController;
    }

    boolean interact() {
        boolean newGame = new YesNoDialog().read(Message.RESUME.getMessage());
        if (newGame) {
            this.resumeController.reset();
        }
        return newGame;
    }

}
