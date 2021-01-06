package usantatecla.mastermind.models;

public class Session {

	private State state;
	
	private Game game;
	
	private Registry registry;
	
	public Session() {
		this.state = new State();
		this.game = new Game();
		this.registry = new Registry(this.game);
	}

	public void next() {
		this.state.next();		
	}

	public void addProposedCombination(ProposedCombination proposedCombination) {
		this.game.addProposedCombination(proposedCombination);
		this.registry.registry();
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public void undo() {
		this.registry.undo(this.game);
	}

	public void redo() {
		this.registry.redo(this.game);
	}

	public void clearGame() {
		this.game.clear();
		this.state.reset();	
		this.registry.reset();
	}

	public boolean isWinner() {
		return this.game.isWinner();
	}

	public boolean isLooser() {
		return this.game.isLooser();
	}

	public StateValue getValueState() {
		return this.state.getValueState();
	}

	public Game getGame() {
		return this.game;
	}
	
}
