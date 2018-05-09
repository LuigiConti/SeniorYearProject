import java.awt.image.BufferedImage;
//test
public class AssetLoader {
	public static final int width = 32, height = 32;
	
								//Tiles
	public static BufferedImage grass, forest, mushroom, 
								//Entities
								slime, wizard, portal,
								//Buttons
								buttonStart, buttonExit, buttonHelp,
								//Other
								menuArt;
	
	
	public static void init(){
		SpriteSheet gameSheet = new SpriteSheet(ImageLoader.loadImage("/textures/GameSheet.png"));
		SpriteSheet menuSheet= new SpriteSheet(ImageLoader.loadImage("/textures/MenuSheet.png"));
		
		menuArt = ImageLoader.loadImage("/textures/MenuArt.jpg");
		
		//Tiles
		grass = gameSheet.crop(0,0,width,height); 
		forest = gameSheet.crop(width*3, 0, width, height);
		mushroom = gameSheet.crop(width*4, 0, width, height);
		//Entities
		wizard = gameSheet.crop(width, 0, width, height);
		portal = gameSheet.crop(width*2, 0, width, height);
		slime = ImageLoader.loadImage("/textures/Slime.png");
		//Buttons
		buttonStart = menuSheet.crop(0, 0, width*2, height);
		buttonExit = menuSheet.crop(width*2, 0, width*2, height);
		buttonHelp = menuSheet.crop(width*4, 0, width*2, height);
		
		
	}

}
