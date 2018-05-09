import java.awt.Graphics;

public class MenuState extends State {
	int y;
	public static Button buttonStart, buttonHelp, buttonExit;
	
	public MenuState(Handler handler){
		super(handler);
		buttonStart = new Button(handler, AssetLoader.buttonStart, 20, 420, 128, 64);
		buttonHelp = new Button(handler, AssetLoader.buttonHelp, 20, 520, 128, 64 );	
		buttonExit = new Button(handler, AssetLoader.buttonExit, 20, 620, 128, 64);
		
	}
	
	@Override
	public void update() {
		//System.out.println(main.mouseManager.mouseX + ", " + main.mouseManager.mouseY);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(AssetLoader.menuArt, 0, 0, handler.getWidth(), handler.getHeight(), null);
		buttonStart.render(g);
		buttonHelp.render(g);
		buttonExit.render(g);
	}

}
