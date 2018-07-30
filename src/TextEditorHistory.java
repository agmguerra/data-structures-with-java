import java.util.Stack;

public class TextEditorHistory {
	
	protected Stack<String> history;
	
	public TextEditorHistory() {
		history = new Stack<String>();
	}
	
	public void addToHistory(String currentVersion) {
		history.push(currentVersion);
	}
	
	public boolean canUndo() {
		return !history.isEmpty();
	}
	
	public String undo() {
		if (!canUndo()) {
			return null;
		}
		return history.pop();
	}
}
