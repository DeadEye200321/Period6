import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * Introduction to photo editing
 *
 * @author Jake Ciasca
 * @version 11/15/18
 */
public class PE
{
    public static void main(String [] args) throws Exception
    {
        
    }
    
    public static void grayscale()
    {
        try
        {
            File input = new File("images/juneau.jpg");
            BufferedImage image = ImageIO.read(input);
            
            int width = image.getWidth();
            int height = image.getHeight();
            
            System.out.println("the image is " + width + " x " + height + ".");
            
            for (int x = 0; x < width; x++)
            {
                for (int y = 0; y < height; y++)
                {
                    Color c = new Color(image.getRGB(x, y));
                    
                    int red = c.getRed();
                    int green = c.getGreen();
                    int blue = c.getBlue();
                    
                    int grayValue = (red + green + blue) / 3;
                    
                    if (grayValue > 255)
                    {
                        grayValue = 255;
                    }
                    
                    Color newColor = new Color(grayValue, grayValue, grayValue);
                    
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            
            File output = new File("images/juneau_gs17.jpg");
            ImageIO.write(image, "jpg", output);
        }
        catch (Exception e)
        {
            System.out.println("Oops: " + e);
        }
    }
    
    public static void flipX()
    {
        try
        {
            File input = new File("images/juneau.jpg");
            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();
            
            BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            
            
            for(int x = 0; x < width; x++)
            {
                for (int y = 0; y < height; y++)
                {
                    Color c = new Color(image.getRGB(x, y));
                    
                    newImage.setRGB(width - 1 - x, y, c.getRGB());
                }
            }
            
            File output = new File("images/test20.jpg");
            ImageIO.write(newImage, "jpg", output);
        }
        catch (Exception e)
        {
            System.out.println("Oops: " + e);
        }
    }
    
    public static void flipY()
    {
        try
        {
            File input = new File("images/juneau.jpg");
            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();
            
            BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            
            
            for(int x = 0; x < width; x++)
            {
                for (int y = 0; y < height; y++)
                {
                    Color c = new Color(image.getRGB(x, y));
                    
                    newImage.setRGB(x, height - 1 - y, c.getRGB());
                }
            }
            
            File output = new File("images/test3.jpg");
            ImageIO.write(newImage, "jpg", output);
        }
        catch (Exception e)
        {
            System.out.println("Oops: " + e);
        }
    }
    
    public static void vignette()
    {
        try
        {
            File input = new File("images/juneau.jpg");
            BufferedImage image = ImageIO.read(input);
            
            int width = image.getWidth();
            int height = image.getHeight();
            
            System.out.println("the image is " + width + " x " + height + ".");
            for (int x = 0; x < width; x++)
            {
                for (int y = 0; y < height; y++)
                {
                    Color c = new Color(image.getRGB(x, y));
                    
                    int red = c.getRed();
                    int green = c.getGreen();
                    int blue = c.getBlue();
                    
                    Color newColor = new Color(0, 0, 0);
                    
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            
            File output = new File("images/juneau_gs17.jpg");
            ImageIO.write(image, "jpg", output);
        }
        catch (Exception e)
        {
            System.out.println("Oops: " + e);
        }
    }
}

