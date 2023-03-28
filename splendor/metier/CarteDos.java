package splendor.metier;

public sealed class CarteDos permits Carte {

    private int age;
    private String url;

    public CarteDos(int age, String url) {
        
        this.age = age;
        this.url = url;
    }
    
    public int getAge() { 
        return this.age; 
    }
    
    public String getUrl() { 
        return this.url; 
    }

    public String toString() { 
        return "" + this.age; 
    }
}
