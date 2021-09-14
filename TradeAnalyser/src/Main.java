import com.demise.service.ImageLocator;
import org.opencv.core.Core;

public class Main {

    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    public static void main( String[] args ) throws Exception {

        String imagePath = "C:\\Users\\Happy\\Desktop\\work\\workspace\\TradeReader\\src\\main\\resources\\img\\test2.png";
        String templatePath = "C:\\Users\\Happy\\Desktop\\work\\workspace\\TradeReader\\src\\main\\resources\\img\\materials/oreganot2.png";
        String maskPath = "C:\\Users\\Happy\\Desktop\\work\\workspace\\TradeReader\\src\\main\\resources\\img\\materials/oreganot1g.png";

        ImageLocator imageLocator = new ImageLocator();
          imageLocator.scan2(imagePath,templatePath);
        imageLocator.scan(imagePath, templatePath,maskPath);
        /*
        // Load the sub-image you want to find that appears in the image, respectively.
        BufferedImage subimage = ImageIO.read(new File("C:\\Users\\Happy\\Desktop\\work\\workspace\\TradeReader\\src\\main\\resources\\img\\materials/beanssmol.png"));
        BufferedImage image = ImageIO.read(new File("C:\\Users\\Happy\\Desktop\\work\\workspace\\TradeReader\\src\\main\\resources\\img\\test1.png"));

        // Attempt to find the match.
        Point match = FindImage.match(subimage, image);

        // If null, no match. Otherwise, show where the match occurred.
        if ( match == null ) {
            System.out.println("no");
        } else {
            System.out.println("Found img in img:" + match.x + "," + match.y);
            Drawer drawer = new Drawer();
            drawer.drawDot(image, match);

         }
           */

    }
}
