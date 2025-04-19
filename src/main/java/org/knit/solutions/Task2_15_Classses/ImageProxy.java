package org.knit.solutions.Task2_15_Classses;

public class ImageProxy implements Image {
    private RealImage realImage;
    private String imageName;

    public ImageProxy(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void Show() {
        if (realImage == null) {
            realImage = new RealImage(imageName);
        }
        realImage.Show();
    }
}
