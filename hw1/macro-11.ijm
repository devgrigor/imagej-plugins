open("D:/aua/image_processing/imagej-plugins/hw1/deniro-old-2.jpg");
open("D:/aua/image_processing/imagej-plugins/hw1/de-niro-young-straight.jpg");
selectWindow("deniro-old-2.jpg");
//run("Brightness/Contrast...");
setMinAndMax(1, 254);
run("Histogram");
close();

selectWindow("de-niro-young-straight.jpg");
//run("Brightness/Contrast...");
setMinAndMax(1, 254);
run("Histogram");
close();

selectWindow("deniro-old-2.jpg");
selectWindow("de-niro-young-straight.jpg");
//setTool("line");
selectWindow("deniro-old-2.jpg");
makeLine(560, 142, 554, 673);
selectWindow("de-niro-young-straight.jpg");
makeLine(249, 55, 254, 674);
makeLine(262, 54, 254, 674);
//setTool("rectangle");
makeRectangle(24, 53, 472, 625);
makeRectangle(24, 77, 472, 601);
makeRectangle(22, 77, 474, 601);
run("Crop");
selectWindow("deniro-old-2.jpg");
makeRectangle(339, 111, 410, 565);
makeRectangle(316, 111, 433, 565);
makeRectangle(316, 136, 433, 540);
makeRectangle(316, 136, 456, 540);
run("Crop");
selectWindow("de-niro-young-straight.jpg");
//setTool("line");

makeLine(102, 239, 222, 242);
makeLine(256, 236, 387, 237);
makeLine(197, 394, 281, 395);
makeLine(164, 462, 301, 461);
selectWindow("deniro-old-2.jpg");
makeLine(89, 204, 206, 180);
makeLine(282, 195, 393, 218);
makeLine(195, 346, 290, 351);
makeLine(161, 410, 303, 415);
selectWindow("de-niro-young-straight.jpg");
selectWindow("deniro-old-2.jpg");
selectWindow("de-niro-young-straight.jpg");
selectWindow("deniro-old-2.jpg");
//setTool("rectangle");
makeRectangle(0, 1, 241, 539);
run("Crop");
saveAs("Jpeg", "D:/aua/image_processing/imagej-plugins/hw1/west.jpg");
open("D:/aua/image_processing/imagej-plugins/hw1/west.jpg");
selectWindow("de-niro-young-straight.jpg");
makeRectangle(227, 3, 247, 598);
makeRectangle(239, 3, 235, 598);
run("Crop");
saveAs("Jpeg", "D:/aua/image_processing/imagej-plugins/hw1/east.jpg");
open("D:/aua/image_processing/imagej-plugins/hw1/east.jpg");
selectWindow("west.jpg");
run("Histogram");
close();
selectWindow("east.jpg");

selectWindow("east.jpg");
selectWindow("west.jpg");
selectWindow("east.jpg");
run("Enhance Contrast...", "saturated=0.3 equalize");
selectWindow("west.jpg");
run("Enhance Contrast...", "saturated=0.3 equalize");
selectWindow("east.jpg");
run("Histogram");
close();
selectWindow("west.jpg");
run("Histogram");
close();
run("Histogram");
close();
selectWindow("west.jpg");
selectWindow("east.jpg");
selectWindow("west.jpg");
selectWindow("east.jpg");
makeRectangle(1, 50, 234, 548);
makeRectangle(0, 50, 235, 548);
run("Crop");
makeRectangle(2, 538, 233, 10);
makeRectangle(1, 0, 234, 539);
run("Crop");


selectWindow("de-niro-young-straight.jpg");
close();
selectWindow("deniro-old-2.jpg");
close();
run("Add Images");
saveAs("PNG", "D:/aua/image_processing/imagej-plugins/hw1/Colauge.png");
