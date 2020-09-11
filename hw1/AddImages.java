import ij.ImagePlus;
import ij.gui.GenericDialog;
import ij.plugin.filter.PlugInFilter;
import ij.process.Blitter;
import ij.process.ImageProcessor;
import imagingbook.lib.ij.IjUtils;

public class AddImages implements PlugInFilter {
	static double alpha = 0.5; // transparency of foreground image
 	ImagePlus fgIm; // foreground image (to be selected)
 	public int setup(String arg, ImagePlus im) {
		return DOES_8G;
	}

	public void run(ImageProcessor ipBG) { // ipBG = IBG
		if(runDialog()) {
			ImageProcessor ipFG = // ipFG = IFG
			fgIm.getProcessor().convertToByte(false);
			ipFG = ipFG.duplicate();
			ipFG.multiply(1 - alpha); // IFG ← IFG · (1 − α)
			ipBG.multiply(alpha); // IBG ← IBG · α
			ipBG.copyBits(ipFG,0,0,Blitter.ADD); // IBG ← IBG+IFG
 		}
	}

	boolean runDialog() {
		// get list of open images and their titles:
		ImagePlus[] openImages = IjUtils.getOpenImages(true);
		String[] imageTitles = new String[openImages.length];
		int height = 0;
		int width  = 0;
		for (int i = 0; i < openImages.length; i++) {
			imageTitles[i] = openImages[i].getShortTitle();
			width += openImages[i].getWidth();
			height = openImages[i].getWidth() > height ? openImages[i].getWidth() : height;
		}
		// create the dialog and show:
		GenericDialog gd = new GenericDialog("Linear Blending");
		gd.addChoice("Foreground image:", imageTitles, imageTitles[0]);
		
		gd.addNumericField("Alpha value [0..1]:", alpha, 2);
		gd.showDialog();
		
		if (gd.wasCanceled()) {
			return false;
		}
		else {
			fgIm = openImages[gd.getNextChoiceIndex()];
			alpha = gd.getNextNumber();
			return true;
		}
	}
}