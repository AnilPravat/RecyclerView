package myapp.anilandroid.com.recyclerview_demo;

public class List_Provider {
    private  int img_id;
    String country,capital;

    public List_Provider(int img_id, String country, String capital) {
        this.setImg_id(img_id);
        this.setCountry(country);
        this.setCapital(capital);
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
