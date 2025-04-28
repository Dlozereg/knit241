package org.knit.solutions.Task2_15_Classses;

import org.apache.commons.text.RandomStringGenerator;

public class RealImage implements Image {
    private String content;
    private String imageName;

    public RealImage(String imageName){
        System.out.println("Loading image " + imageName + " from server...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RandomStringGenerator rsg = new RandomStringGenerator.Builder().get();
        content = rsg.generate(10, 20);
        this.imageName = imageName;
    }

    @Override
    public void Show() {
        System.out.printf("The content of image %s: %s%n", imageName, content);
    }
}
