package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.View;

public class ConsoleView extends View {

    private StartView startView;
    private ProposalView proposalView;
    private ResumeView resumeView;

    public ConsoleView(Logic logic) {
        super(logic);
        this.startView = new StartView(this.logic);
        this.proposalView = new ProposalView(this.logic);
        this.resumeView = new ResumeView(this.logic);
    }

    @Override
    protected void start() {
        this.startView.interact();
    }

    @Override
    protected boolean propose() {
        return this.proposalView.interact();
    }

    @Override
    protected boolean isNewGame() {
        return this.resumeView.interact();
    }

}
