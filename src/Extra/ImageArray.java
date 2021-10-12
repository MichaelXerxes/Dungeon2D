package Extra;

import java.util.ArrayList;

public class ImageArray {
    protected ArrayList<ImageLoader> list=new ArrayList<ImageLoader>();
    public ImageArray(){

    }
    public void setImage(ImageLoader image){
        list.add(image);
    }
    public ArrayList getImage(){
        return list;
    }
    public void addNewImage(){
       // setList(ImageLoader.loadImage(""));
    }

    public ArrayList<ImageLoader> getList() {
        return list;
    }

    public void setList(ArrayList<ImageLoader> list) {
        this.list = list;
    }
}
