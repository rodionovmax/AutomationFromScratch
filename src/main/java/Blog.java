import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Blog extends BaseActions {

    int articles;
    String articleTitle;

    public Blog(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public Integer verifyNumberOfArticles(){
        articles = driver.findElements(Locators.BLOG_ARTICLES).size();
        return articles;
    }

    public String findArticleInTheListThenClickAndVerifyTitle(){
        driver.findElements(Locators.BLOG_ARTICLES).get(Data.INDEX_ARTICLE).click();
        articleTitle = driver.findElement(Locators.ARTICLE_KHARKOV_AGENCY).getText();
        return articleTitle;
    }
}
