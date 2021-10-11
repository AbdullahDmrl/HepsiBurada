package Pages;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends Parent{

    public DialogContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(id = "myAccount")
    private WebElement myAccount;

    @FindBy(xpath = "//a[text()='Giriş Yap")
    private WebElement girisYap;

    @FindBy(id = "txtUserName")
    private WebElement emailAddress;

    @FindBy(id = "txtPassword")
    private WebElement password;

    @FindBy(id = "btnLogin")
    private WebElement buttonLogin;

    @FindBy(css = "div#myAccount>span")
    private WebElement myAccountText;

    @FindBy(css = "input.desktopOldAutosuggestTheme-input")
    private WebElement searchInput;

    @FindBy(xpath = "//div[text()='ARA']")
    private WebElement searchBtn;

    @FindBy(css = "ol#categoryList>li:nth-child(2)")
    private WebElement telefonBtn;

    @FindBy(css = "ol#categoryList>li:nth-child(4)")
    private WebElement ceptelefonBtn;

    @FindBy(css = "div#productresults>header")
    private WebElement searchResultsText;

    @FindBy(css = "div#pagination>ul>li:nth-child(2)")
    private WebElement secondPageBtn;

    @FindBy(css = "ul.product-list.results-container.do-flex.list>li")
    private List <WebElement> secondPagProdList;

    @FindBy(xpath = "//div[text()='Beğen']")
    private WebElement begenButton;

    @FindBy(css = "div.hb-toast-text")
    private WebElement listeEklediPopup;

    @FindBy(linkText = "Beğendiklerim")
    private WebElement begendiklerim;

    @FindBy(css = "div.infinite-scroll-holder>ul>div")
    private List<WebElement> begendiklerimList;

    @FindBy(xpath = "(//button[text()='Seç'])[2]")
    private WebElement secButton;

    @FindBy(xpath = "//button[text()='Sepete Ekle']")
    private WebElement sepeteEkleButton;

    @FindBy(xpath = "//div[@class='hb-toast-text']")
    private WebElement sepEkpopUpText;

    @FindBy(xpath = "//span[text()='Sepetim']")
    private WebElement sepetimButton;

    @FindBy(css = "section#onboarding_item_list>ul>li")
    private List<WebElement> sepetProductNames;

    @FindBy(css = "a[aria-label='Ürünü Kaldır']")
    public List<WebElement>  kaldirGarbages;

    @FindBy(css = "a[class*='delete_product']")
    private WebElement kaldirButton;

    @FindBy(xpath = "//button[text()='Sil']")
    private WebElement silButton;

    @FindBy(xpath = "//span[text()='Ürün sepetinizden silinmiştir']")
    private WebElement SepSilPupupText;

    @FindBy(xpath = " //span[text()='KK']")
    private WebElement kaanBtn;

    @FindBy(xpath = "//a[text()='Beğendiklerim']")
    private WebElement begendiklerimTitle;

    @FindBy(css = "button#StickActionHeader-RemoveSelected")
    private WebElement deleteBtn;

   @FindBy(xpath = "(//button[text()='Sil'])[2]")
    private WebElement confirmDelBtn;

    @FindBy(xpath = "//span[text()=]")
    private WebElement lisSilPupupText;


    public WebElement fithCellPhone;
    WebElement desiredPhone;
    public String fifthPhoneName;
    WebElement myElement;
    List<WebElement> myelemnts;

    public void findAndSend(String elementName,String value)
    {
          switch (elementName) {
              case "emailAddress": myElement = emailAddress;  break;
              case "password": myElement = password; break;
              case "searchInput": myElement = searchInput; break;

          }

          sendKeysFunction(myElement, value);
    }

    public void findAndClick(String elementName)
    {
        switch (elementName) {
            case "myAccount": myElement = myAccount; break;
            case "girisYap":myElement = girisYap; break;
            case "buttonLogin": myElement = buttonLogin;break;
            case "searchBtn": myElement = searchBtn;break;
            case "telefonBtn": myElement = telefonBtn;break;
            case "ceptelefonBtn": myElement = ceptelefonBtn;break;
            case "secondPageBtn": myElement = secondPageBtn;break;
            case "begenButton": myElement = begenButton;break;
            case "begendiklerim": myElement = begendiklerim;break;
            case "secButton": myElement = secButton;break;
            case "sepeteEkleButton": myElement = sepeteEkleButton;break;
            case "sepetimButton": myElement = sepetimButton;break;
            case "kaldirButton": myElement = kaldirButton;break;
            case "silButton": myElement = silButton;break;
            case "kaanBtn": myElement = kaanBtn;break;
            case "deleteBtn": myElement = deleteBtn;break;
            case "confirmDelBtn": myElement = confirmDelBtn;break;
            case "begendiklerimTitle": myElement = begendiklerimTitle;break;


        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String elementName, String msg)
    {
        switch (elementName) {
            case "myAccountText": myElement = myAccountText; break;
            case "searchResultsText": myElement = searchResultsText; break;
            case "listeEklediPopup": myElement = listeEklediPopup; break;
            case "sepEkpopUpText": myElement = sepEkpopUpText; break;
            case "SepSilPupupText": myElement = SepSilPupupText; break;
            case "lisSilPupupText": myElement = lisSilPupupText; break;
        }

        verifyContainsText(myElement, msg);
    }

    public void listWebelementsSelect(String listName, int index )
    {
        switch (listName) {
            case "secondPagProdList": myelemnts=secondPagProdList; break;
        }
        desiredPhone= myelemnts.get(index);
        desiredPhone.click();
        fifthPhoneName=desiredPhone.getText();
    }

    public void listContainsWebElement(String listName, String text)
    {
        switch (listName) {
            case "begendiklerimList": myelemnts=begendiklerimList; break;
        }
        verifyContainsWebelement(myelemnts, text);
    }

    public void selectElementFromLists(String listName, String text)
    {
        switch (listName) {
            case "begendiklerimList": myelemnts=begendiklerimList; break;
        }
        clickSelectedElement(myelemnts, text);
    }


    public void findAndDelElmntfromList(String listName,List<WebElement> kaldirList, String text)
    {
        switch (listName) {
            case "sepetProductNames": myelemnts=sepetProductNames; break;



        }
            delWebelement(myelemnts, kaldirList,text);

    }



    public void invisibilityOfElement(String elementName)
    {
        switch (elementName) {
            //  case "successMessage": myElement = successMessage; break;

        }
        waitUntilInvisibility(myElement);
    }

}
