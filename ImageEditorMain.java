/**
 * This is our group photo editor
 *
 * @author Jake Ciasca, Ethan David, Grant Forgues, Rhys Plassmann
 * @version 12/14/18
 */

import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;

public class ImageEditorMain
{
    
    public static BufferedImage image;
    public static Scanner scanInt = new Scanner(System.in);
    public static Scanner scanStr = new Scanner(System.in);
    public static int filter;
    public static String imageName;
    public static String saveName;
    
    public static void main(String []args){
        loadImage();
        menu();
    }
    
    
    public static void loadImage(){
        
        System.out.println("Current Name of Image: ");
        imageName = scanStr.nextLine();
        
        System.out.println("Name of Image to be Saved: ");
        saveName = scanStr.nextLine();
        
       try {
            image = ImageIO.read(new File("images/" + imageName + ".jpg"));
        } catch (IOException e) {
            image = null;
            System.out.println("Image Failed to Load");
            loadImage();
        }
    }
    
    public static void menu(){
        
        System.out.println("What filter would you like to apply? \n 1. Frame \n 2. Smash Confirmer \n 3. Scaler and Opacity \n 4. Line detection \n 5. Fade to Grayscale \n 6. Double Size and Flip \n 7. Vignette \n 8. Lowres");
        filter = scanInt.nextInt();
        
        switch(filter){
            
            case 1:
                frame();
                saveImage();
                break;
            case 2:
                smashball();
                break;
            case 3:
                filter3();
                saveImage();
                break;
            case 4:
                filter4();
                saveImage();
                break;
            case 5:
                fadeGrayscale();
                saveImage();
                break;
            case 6:
                doubleSizeAndFlip();
                saveImage();
                break;
            case 7:
                vignette();
                saveImage();
                break;
            case 8:
                filter8();
                break;
            default:
                System.out.println("You forgot the arabic numerical system. ");
                menu();
                
        }
    }

//Grant
    public static void frame(){
        System.out.println("What color frame do you want? \n 1. Black \n 2. Red \n 3. Blue");
        int frameChoice = scanInt.nextInt();
        switch (frameChoice)
        {
            case 1:
            blackFrame();
            break;
            case 2:
            redFrame();
            break;
            case 3:
            blueFrame();
            break;
        }
    }
    public static void blackFrame(){
        int width = image.getWidth();
        int height = image.getHeight();
        
        for (int x = 0; x < width / 16; x++)
        {
            for (int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                Color newColor = new Color(0, 0, 0);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        for (int x = width - (width / 16); x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                Color newColor = new Color(0, 0, 0);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height / 16; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                Color newColor = new Color(0, 0, 0);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        for (int x = 0; x < width; x++)
        {
            for (int y = height - (height / 16); y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                Color newColor = new Color(0, 0, 0);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
    }
    public static void redFrame(){
        int width = image.getWidth();
        int height = image.getHeight();
        
        for (int x = 0; x < width / 16; x++)
        {
            for (int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                Color newColor = new Color(255, 0, 0);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        for (int x = width - (width / 16); x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                Color newColor = new Color(255, 0, 0);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height / 16; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                Color newColor = new Color(255, 0, 0);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        for (int x = 0; x < width; x++)
        {
            for (int y = height - (height / 16); y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                Color newColor = new Color(255, 0, 0);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
    }
    public static void blueFrame(){
        int width = image.getWidth();
        int height = image.getHeight();
        
        for (int x = 0; x < width / 16; x++)
        {
            for (int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                Color newColor = new Color(0, 0, 255);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        for (int x = width - (width / 16); x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                Color newColor = new Color(0, 0, 255);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height / 16; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                Color newColor = new Color(0, 0, 255);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        for (int x = 0; x < width; x++)
        {
            for (int y = height - (height / 16); y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                Color newColor = new Color(0, 0, 255);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
    }
    
    //Grant
    public static void smashball(){
        System.out.println("OMG plz tell me this is real. If this is fake I’ll cry.");
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage image2 = new BufferedImage (width + ((int)(.2 * width)),height + ((int)(height * .2)) , BufferedImage.TYPE_INT_RGB);
        int width2 = image2.getWidth();
        int height2 = image2.getHeight();
        for (int x = 0; x < (width * .3); x++)
        {
            for (int y = 0; y < (height * .7); y++)
            {
                Color c = new Color(image.getRGB(x, y));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                Color newColor = new Color(red, green, blue);
                image2.setRGB(x, y, newColor.getRGB());
            }
        }
        for (int x = (int)(width * .3); x < width ; x++)
        {
            for (int y = (int)(height * .7); y < height ; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                Color newColor = new Color(red, green, blue);
                image2.setRGB(x + (int)(.2 * width), y + (int)(.2 * height), newColor.getRGB());
            }
        }
        for (int x = 0; x < (width * .3); x++)
        {
            for (int y = height - (int)(.3 * height); y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                Color newColor = new Color(red, green, blue);
                image2.setRGB(x, y + (int)(.2 * height), newColor.getRGB());
            }
        }
        for (int x = (int)(.3 * width); x < width; x++)
        {
            for (int y = 0; y < (height * .7); y++)
            {
                Color c = new Color(image.getRGB(x, y));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                Color newColor = new Color(red, green, blue);
                image2.setRGB(x + (int)(.2 * width), y, newColor.getRGB());
            }
        }
        File output = new File("images/" + saveName + ".jpg");
        try {
            ImageIO.write(image2, "jpg", output);
        } catch (IOException e) {
        }
    }
    
//Ethan
    public static void filter3(){
        System.out.println("Image Scaler");
        
        System.out.println("How many pixels do you want on the X-axis?");
        int newW = scanStr.nextInt();
        
        System.out.println("How many pixels do you want on the Y-axis?");
        int newH = scanStr.nextInt();
        
        System.out.println("What should the opacity of the image be? (0-100)");
        float opacity = scanInt.nextInt()/100f;
        
        Image tmp = image.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        image = dimg;   

    }

    
    //Ethan
    public static void filter4(){
        BufferedImage origImage = image;
        
        System.out.println("Line Detection");
        
        System.out.println("Red Value for Line Highlight: ");
        int customR = scanInt.nextInt();
        
        System.out.println("Green Value for Line Highlight: ");
        int customG = scanInt.nextInt();
         
        System.out.println("Blue Value for Line Highlight: ");
        int customB = scanInt.nextInt();
        
        System.out.println("RGB Pixel Value Difference Allowance \n(50 is sweet spot, smaller numbers means more outlining)");
        int allowance = scanInt.nextInt();
        
        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                
                if(x > 1 && x < image.getWidth() - 1 && y > 0 && y < image.getHeight() - 1){
                    
                    Color color = new Color(image.getRGB(x, y));
                    
                    int pixelValue = ((color.getRed() + color.getGreen() + color.getBlue())/3);
                    
                    Color colorB = new Color(image.getRGB(x, y + 1));
                    Color colorR = new Color(image.getRGB(x + 1, y));
                    int belowPixelValue = (colorB.getRed() + colorB.getBlue() + colorB.getGreen() )/3;
                    int rightPixelValue = (colorR.getRed() + colorR.getBlue() + colorR.getGreen() )/3;
                    
                    if( (((pixelValue -  belowPixelValue) < -allowance || ((pixelValue -  belowPixelValue)) > allowance)) ){
                        color = new Color(customR, customG, customB);
                        
                        image.setRGB(x, y, color.getRGB());
                    }
                    
                    if( (((pixelValue -  rightPixelValue) < -allowance || ((pixelValue -  rightPixelValue)) > allowance)) ){
                        color = new Color(customR, customG, customB);
                        
                        image.setRGB(x, y, color.getRGB());
                    }
                }
            }
        }
        defineLine(image, origImage, customR, customG, customB);
    }

//Ethan
public static void defineLine(BufferedImage image, BufferedImage origImage, int customR, int customG, int customB){
        boolean hasNeighboringPixel = false;
        Color customColor = new Color(customR, customG, customB);
        for(int x = 1; x < image.getWidth() - 1; x++) {
            hasNeighboringPixel = false;
            for(int y = 1; y < image.getHeight() - 1; y++) {
                //hasNeighboringPixel = false;
                if(image.getRGB(x,y) == customColor.getRGB()){
                //North
                if(new Color(image.getRGB(x,y - 1)) == customColor){
                    hasNeighboringPixel = true;
                }
                //South
                if(new Color(image.getRGB(x,y + 1)) == customColor){
                    hasNeighboringPixel = true;
                }
                //North East
                if(new Color(image.getRGB(x + 1,y - 1)) == customColor){
                    hasNeighboringPixel = true;
                }
                //North West
                if(new Color(image.getRGB(x - 1,y - 1)) == customColor){
                    hasNeighboringPixel = true;
                }
                //South East
                if(new Color(image.getRGB(x + 1,y + 1)) == customColor){
                    hasNeighboringPixel = true;
                }
                //South West
                if(new Color(image.getRGB(x - 1,y + 1)) == customColor){
                    hasNeighboringPixel = true;
                }
                //East
                if(new Color(image.getRGB(x + 1,y)) == customColor){
                    hasNeighboringPixel = true;
                }
                //West
                if(new Color(image.getRGB(x - 1,y)) == customColor){
                    hasNeighboringPixel = true;
                }

                if(hasNeighboringPixel == false){
                    Color origC = new Color(origImage.getRGB(x,y));
                    Color test = new Color(customR,customG,customB);
                    //image.setRGB(x, y, origC.getRGB());
                    image.setRGB(x, y, test.getRGB());
                }
                hasNeighboringPixel = false;
            }
            }
        }
    }

    
    //Jake
    public static void fadeGrayscale(){
        int width = image.getWidth();
        int height = image.getHeight();
        
        int startWidth = (int)(width / 3.0);
        int endWidth = (int)((2.0 * width) / 3);
        
        for (int x = startWidth; x < width; x++)
        {
          for (int y = 0; y < height; y++)
          {
              Color c = new Color(image.getRGB(x, y));
              
              int red = c.getRed();
              int green = c.getGreen();
              int blue = c.getBlue();
              
              int grayValue = (red + green + blue) / 3;
              double changePerc = ((double)(x - startWidth) / (endWidth - startWidth));
              
              if (changePerc > 1)
                changePerc = 1;
              
              int redDif = red - grayValue;
              int greenDif = green - grayValue;
              int blueDif = blue - grayValue;
              
              red = red - (int)(redDif * changePerc);
              green = green - (int)(greenDif * changePerc);
              blue = blue - (int)(blueDif * changePerc);
              
              Color newColor = new Color(red, green, blue);
              image.setRGB(x, y, newColor.getRGB());
          }
        }
    }

    
    //Jake
    public static void doubleSizeAndFlip(){
        int width = image.getWidth();
        int height = image.getHeight();
        
        int newWidth = width * 2;
        int newHeight = height * 2;
        
        BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        
        for (int x = 0; x < width; x++)
        {
          for (int y = 0; y < height; y++)
          {
              Color c = new Color(image.getRGB(x, y));
              
              newImage.setRGB(x * 2, y * 2, c.getRGB());
              newImage.setRGB(x * 2 + 1, y * 2, c.getRGB());
              newImage.setRGB(x * 2, y * 2 + 1, c.getRGB());
              newImage.setRGB(x * 2 + 1, y * 2 + 1, c.getRGB());
          }
        }
        
        System.out.println("Would you like to flip your new image?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        int userSelect = scanInt.nextInt();
        
        BufferedImage newImageTwo = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        
        switch(userSelect)
        {
            case 1:
                for(int x = 0; x < newWidth; x++)
                {
                    for (int y = 0; y < newHeight; y++)
                    {
                        Color c = new Color(newImage.getRGB(x, y));
                    
                        newImageTwo.setRGB(newWidth - 1 - x, y, c.getRGB());
                    }
                }
                image = newImageTwo;
                break;
            case 2:
                image = newImage;
                break;
            default:
                image = newImage;
                break;
        }
        
    }

    
    //Rhys
    public static void vignette(){
        System.out.println("Vignette");
            
        int width = image.getWidth();
        int height = image.getHeight();
        
        System.out.println("enter intensity (1-100)");
        double cover = scanInt.nextInt();
        double a = .2 * width;
        double b = .2 * height;
        double angle = 0;
        for (int x = 0; x < width; x++)
        {
             for (int y = 0; y < height; y++)
             {
                 double distx = x-(width/2);
                 double disty = y-(height/2);    
                 try{
                     angle = Math.atan((Math.abs(disty)/(Math.abs(distx))));
                 }
                 catch(Exception e){}
                 double s = Math.sin(angle);
                 double c = Math.cos(angle);
                 double radius = (a*b)/(Math.sqrt((a*a)*(s*s)+(b*b)*(c*c)));
                 int radiusi = (int)radius;
                 double dist = (int)((Math.sqrt((distx*distx) + (disty*disty))) - radiusi);
                            
                 if (Math.sqrt((distx*distx) + (disty*disty)) > radiusi)
                 {
                     Color j = new Color(image.getRGB(x, y));
                     
                     double avgofdims = (width + height) / 2;
                     double mod = ((10.0*cover)/avgofdims) * dist;
                     int modi = (int)mod;
                     int red = j.getRed() - modi;
                                    
                     if (red < 0)
                        red = 0;
                     int green = j.getGreen() - modi;
                     if (green < 0)
                        green = 0;
                     int blue = j.getBlue() - modi;
                     if (blue < 0)
                        blue = 0;
                     Color newColor = new Color(red,green,blue);
                     image.setRGB(x, y, newColor.getRGB());      
                 }
             }    
        }   
    }

    
    //Rhys
    public static void filter8(){
        System.out.println("Lowres");
        int width = image.getWidth();
        int height = image.getHeight();
        System.out.println("by what factor to scale down (1-100)");
        int factor = scanInt.nextInt();
        double groupwidth = width / (100 - factor);
        double groupheight = height / (100 - factor);
        int groupwidthi = (int)groupwidth;
        int groupheighti = (int)groupheight;
        if (groupwidthi == 0)
            groupwidthi = 1;
        if (groupheighti == 0)
            groupheighti = 1;
        BufferedImage newImage = new BufferedImage(groupwidthi * (100 - factor), groupheighti * (100 - factor), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < (100 - factor); i++)
        {
            for (int j = 0; j < (100 - factor); j++)
            {
                double totalred = 0;
                double totalgreen = 0;
                double totalblue = 0;
                for (int x = groupwidthi * i; x < groupwidthi * i + groupwidthi; x++)
                {
                    for (int y = groupheighti * j; y < groupheighti * j + groupheighti; y++)
                    {
                        Color c = new Color(image.getRGB(x, y));
                        totalred += c.getRed();
                        totalgreen += c.getGreen();
                        totalblue += c.getBlue();
                    }
                }
                double avgred = totalred/(groupwidthi*groupheighti);
                double avggreen = totalgreen/(groupwidthi*groupheighti);
                double avgblue = totalblue/(groupwidthi*groupheighti);
                int avgredi = (int)avgred;
                int avggreeni = (int)avggreen;
                int avgbluei = (int)avgblue;
                Color newColor = new Color(avgredi,avggreeni,avgbluei);
                for (int x = groupwidthi * i; x < groupwidthi * i + groupwidthi; x++)
                {
                    for (int y = groupheighti * j; y < groupheighti * j + groupheighti; y++)
                    {
                            newImage.setRGB(x, y, newColor.getRGB());
                    }
                }
            }
        }
        File output = new File("images/" + saveName + ".jpg");
        try{
            ImageIO.write(newImage, "jpg", output);
        }
        catch(IOException e){}
    }
    


    public static void saveImage(){
        
        File output = new File("images/" + saveName + ".jpg");
        try {
            ImageIO.write(image, "jpg", output);
        } catch (IOException e) {
        }
        
    }
}


