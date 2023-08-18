package locators;

import org.openqa.selenium.By;

public class Locators {
    public static final By selectCountryButton = By.id("com.androidsample.generalstore:id/spinnerCountry");
    public static final By gender = By.id("com.androidsample.generalstore:id/radioFemale");
    public static final By shopButton = By.id("com.androidsample.generalstore:id/btnLetsShop");
    public static final By nameField = By.id("com.androidsample.generalstore:id/nameField");
    public static final By titleProducts = By.xpath("//*[@text='Products']");
    public static final By selectedCountryName = By.id("android:id/text1");
    public static final By addedInCart = By.xpath("(//*[@text='ADD TO CART'])[2]");
    public static final By counter = By.id("com.androidsample.generalstore:id/counterText");
    public static final By addToCart = By.id("com.androidsample.generalstore:id/appbar_btn_cart");
    public static final By shoe = By.xpath("//*[contains(@text,'PG 3')]");
    public static By webSearch = By.id("com.androidsample.generalstore:id/btnProceed");
    public static By input = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText");
    public static By searchBar = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View/android.view.View/android.widget.Button");

}
