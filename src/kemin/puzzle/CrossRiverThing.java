package kemin.puzzle;

public enum CrossRiverThing {
	p("person"), w("wolf"), s("sheep"), c("cabbage"); // person, wolf, sheep, cabbage
	
	String name;
	CrossRiverThing(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name();
	}
}
