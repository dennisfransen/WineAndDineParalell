package grupp3.iths.se.wineanddineparalell;


import android.widget.ImageView;

public class ItemInfo {
    public ImageView image;
    private String name;
    private String distance;
    private String cost;
    private String star;

    public ItemInfo(){
        // empty constructor needed
    }

    /**
     * constructor for FirestoreRecyclerAdapter
     * @param image
     * @param name
     * @param distance
     * @param cost
     * @param star
     */
    public ItemInfo(ImageView image, String name, String distance, String cost, String star) {
        this.image = image;
        this.name = name;
        this.distance = distance;
        this.cost = cost;
        this.star = star;
    }

    /**
     * Getters and setters for all fields in ItemInfo class
     * @return
     */
    public ImageView getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance;
    }

    public String getCost() {
        return cost;
    }

    public String getStar() {
        return star;
    }
}
