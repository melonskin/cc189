package c07OOD;

/**
 * Created by SkinTang on 6/20/17.
 */
public class RestaurantSingleton {
    private static RestaurantSingleton _instance;
    protected RestaurantSingleton() {}
    public static RestaurantSingleton getInstance() {
        if (_instance == null) {
            _instance = new RestaurantSingleton();
        }
        return _instance;
    }

}
