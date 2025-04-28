package org.knit.solutions.Task2_14_Classes;

public class File implements FileSystemElement {
    private String name;
    private int sizeKB = 1;
    private String content;

    public File(String name) {
        this.name = name;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizeKB() {
        return sizeKB;
    }

    public void setSizeKB(int sizeKB) {
        this.sizeKB = sizeKB;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        sizeKB += content.length();
    }
}
