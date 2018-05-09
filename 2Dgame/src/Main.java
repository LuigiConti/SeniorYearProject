import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
//Lets hope this works
public class Main extends JFrame implements Runnable{
	//Window and Canvas
	private boolean isRunning;
	public long fps = 60;
	public static int ticks = 0;
	public static int frames = 0;
	private int windowWidth = 1080;
	private int windowHeight = 720;
	private Canvas canvas = new Canvas();
	private BufferStrategy bufferStrategy;
	private Graphics2D g;
	
	//States
	public static State gameState;
	public static State menuState;
	
	//Input
	public MouseManager mouseManager;
	public KeyboardManager keyboardManager = new KeyboardManager();
	
	//Camera
	private Camera camera;
	
	//Handler
	private Handler handler;
	

	public static void main(String[] args){
		Main game = new Main(); 
        game.run(); 
        System.exit(0);
	}
	
    // This method starts the game and runs it in a loop 
    public void run(){ 
    	initialize(); 
        long fpsTimer = System.currentTimeMillis();
        
        
        //THE GAME LOOP
    	while(isRunning){ 
                long firstTime = System.currentTimeMillis(); 
                ticks++;
                update(); 
                 
                frames++;
                render(); 
                 
                // Time it took for one frame. If it took longer than frame cap, do nothing. If it was faster than frame cap, delay the next frame. 
                long delay = (1000 / fps) - (System.currentTimeMillis() - firstTime); 
                 
                if (delay > 0) 
                { 
                	 
                        try{ 
                                Thread.sleep(delay); 
                        } 
                        catch(Exception e){} 
                } 
                
                //Every 60 seconds (or whatever the fps is) print how many updates and how many frames there have been
                if(System.currentTimeMillis() - fpsTimer >=1000 ){
                	fpsTimer = System.currentTimeMillis();
                	System.out.println("ticks: " + ticks + " frames: " + frames);
                	ticks = 0;
                	frames = 0;
                }
                 
        }// GAME LOOP 
         
        setVisible(false); 
   } 
    
    
   //sets up everything needed for the game to run 
   void initialize(){ 
	   //Window stuff
	   setTitle("Command and Conjour"); 
       setSize(windowWidth, windowHeight);  
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setResizable(false);
       setVisible(true);
       isRunning = true;
        //Handler
       handler = new Handler(this);
       
        //Assets
       AssetLoader.init();
       
        //States
       gameState = new GameState(handler);
       menuState = new MenuState(handler );
       State.setState(menuState);
       
       //Camera
       camera = new Camera(handler, 0, 0);

       //Input
       mouseManager = new MouseManager(handler);
       
       //Listeners
       addMouseListener(mouseManager);
       addMouseMotionListener(mouseManager);
       canvas.addMouseListener(mouseManager); //add mouse listeners to both jframe and canvas so whichever is active or focused mouse will still be tracked
       canvas.addMouseMotionListener(mouseManager);
       
       addKeyListener(keyboardManager);
       canvas.addKeyListener(keyboardManager);
       
       //Canvas
       //The canvas is what the graphics are "drawn" on
       canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
       canvas.setMaximumSize(new Dimension(windowWidth, windowHeight));
       canvas.setMinimumSize(new Dimension(windowWidth, windowHeight));
       canvas.setFocusable(false);
       add(canvas);
       pack();
       
       
   } 
    
   /* Checks for input, move things 
    around and check for win conditions, etc */
   void update(){ 
	   if(State.getState() != null){
		   State.getState().update();
	   }
   } 
    
   /* This method will draw everything */
   void render(){ 
	   bufferStrategy = canvas.getBufferStrategy();
	   if(bufferStrategy == null){
		   canvas.createBufferStrategy(4);
		   return;
	   }
	   g = (Graphics2D) bufferStrategy.getDrawGraphics();
	   //Clears the screen
	   g.clearRect(0, 0, windowWidth, windowHeight);
	   
	   //Displays the images
	   
	   if(State.getState() != null){
		   State.getState().render(g);
	   }
	   
	   //Displays the buffer
	   bufferStrategy.show();
	   g.dispose();
	   
   	}
   
   public MouseManager getMouseManager(){
	   return mouseManager;
   }
   
   public KeyboardManager getKeyboardManager(){
	   return keyboardManager;
   }
   
   public Camera getCamera(){
	   return camera;
   }
   
   public int getWidth(){
	   return this.windowWidth;
   }
   
   public int getHeight() {
	   return this.windowHeight;
   }
   
    
}
