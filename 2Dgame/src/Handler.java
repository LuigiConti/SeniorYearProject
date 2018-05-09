
public class Handler {
	private Main main;
	private Map map;
	
	public Handler(Main main) {
		this.main = main;
	}
	
	
	//Easy Access 
	public EntityManager getEntityManager() {
		return map.entityManager;
	}
	
	public Camera getCamera() {
		return main.getCamera();
	}
	
	public KeyboardManager getKeyboardManager() {
		return main.keyboardManager;
	}
	
	public MouseManager getMouseManager() {
		return main.mouseManager;
	}

	public int getWidth() {
		return main.getWidth();
	}
	
	public int getHeight() {
		return main.getHeight();
	}
	
	//Getters and Setters
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
	
}
