package Extra;

import java.awt.image.BufferedImage;

public class Assets {
    private static BufferedImage testImage;
    private static BufferedImage sheetImage;
    private static BufferedImage characters;
    private static BufferedImage terran;
    public  static BufferedImage player,dirt,grass,stone,tree,water;
    public static void  init(){
        SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("res/testures/map1Terran.png"));
        SpriteSheet sheet2=new SpriteSheet(ImageLoader.loadImage("res/testures/characters.png"));
        testImage= ImageLoader.loadImage("res/testures/redmark1.png");
        sheetImage=ImageLoader.loadImage("res/testures/spritesheet.png");
        characters=ImageLoader.loadImage("res/testures/characters.png");
        terran=ImageLoader.loadImage("res/testures/map1Terran.png");

        grass=sheet.crop(115,290,25,25);
        stone=sheet.crop(50,105,35,35);
        dirt=sheet.crop(0,0,35,35);
        player=sheet2.crop(0,0,55,60);
        tree=sheet.crop(0,0,25,25);
        water=sheet.crop(490,10,25,25);
    }
}
