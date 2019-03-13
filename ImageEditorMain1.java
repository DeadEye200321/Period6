/**
 * Write a description of class ImageEditorMain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageEditorMain1
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
        
        System.out.println("What filter would you like to apply? \n 1. FILTER \n 2. FILTER \n 3. FILTER \n 4. FILTER \n 5. Fade to Grayscale \n 6. Double Size and Flip \n 7. FILTER \n 8. FILTER");
        filter = scanInt.nextInt();
        
        switch(filter){
            
            case 1:
                filter1();
                saveImage();
                break;
            case 2:
                filter2();
                saveImage();
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
                filter7();
                saveImage();
                break;
            case 8:
                filter8();
                saveImage();
                break;
            default:
                System.out.println("You forgot the arabic numerical system. ");
                menu();
                
        }
    }
    
    //Grant
    public static void filter1(){
        System.out.println("Filter 1");
    }
    
    //Grant
    public static void filter2(){
        System.out.println("Filter 2");
    }
    
    //Ethan
    public static void filter3(){
        System.out.println("Filter 3");
    }
    
    //Ethan
    public static void filter4(){
        System.out.println("Filter 4");
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
    public static void filter7(){
        System.out.println("Filter 7");
    }
    
    //Rhys
    public static void filter8(){
        System.out.println("Filter 8");
    }
    
    
    public static void saveImage(){
        
        File output = new File("images/" + saveName + ".jpg");
        try {
            ImageIO.write(image, "jpg", output);
        } catch (IOException e) {
        }
        
    }
}
