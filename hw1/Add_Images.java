import ij.ImagePlus;
import ij.gui.GenericDialog;
import ij.plugin.filter.PlugInFilter;
import ij.process.Blitter;
import ij.process.ImageProcessor;
// import imagingbook.lib.ij.IjUtils;
import ij.WindowManager;
import ij.gui.NewImage;

public class Add_Images implements PlugInFilter {
	static double alpha = 0.5; // transparency of foreground image
 	ImagePlus fgIm; // foreground image (to be selected)
 	ImageProcessor ip;
 	public int setup(String arg, ImagePlus im) {
 		this.fgIm = im;
		return DOES_ALL+DOES_STACKS+SUPPORTS_MASKING;
	}

	public void run(ImageProcessor ip) { // ipBG = IBG
		this.ip = ip;
		// get list of open images and their titles:
		String[] imageTitles = WindowManager.getImageTitles();
		ImagePlus[] openImages = new ImagePlus[imageTitles.length];

		int height = 0;
		int width  = 0;

		for(int i = 0; i < imageTitles.length; i++) {
			openImages[i] = WindowManager.getImage(imageTitles[i]);
		}

		for (int i = 0; i < openImages.length; i++) {
			imageTitles[i] = openImages[i].getShortTitle();
			width += openImages[i].getWidth();
			height = openImages[i].getHeight() > height ? openImages[i].getHeight() : height;
		}

		ImagePlus finalImage = NewImage.createImage("Colauge", width, height, 1, 8, 0);
		
		ImageProcessor fp = finalImage.getProcessor();

		// create the dialog and show option to choose the first iage in colage
		// GenericDialog gd = new GenericDialog("Linear Blending");
		// gd.addChoice("First image:", imageTitles, imageTitles[0]);
		// gd.addNumericField("Alpha value [0..1]:", alpha, 2);
		// gd.showDialog();
		
		int startX = 0;
		for (int i = 0; i < openImages.length; i++) {
			ImageProcessor ip1 = openImages[i].getProcessor();
			int x = 0;
			for (int y = 0; y < openImages[i].getHeight(); y++) {
				
				for (x = 0; x < openImages[i].getWidth(); x++) {
					fp.set(x + startX, y, ip1.get(x, y));
				}

				
			}

			startX += x;
		}

		finalImage.show();
	}
}