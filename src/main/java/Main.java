import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
//Napraviti aplikaciju pomocu Selenium-a koji ce otvoriti sajt kupujemprodajem.com,
//// izlistati sve kategorije (Stvari) sa leve strane i njihove linkove (kao spoken tekst “kategorija: link”),
//// kliknuti iz te liste na Bicikli (bez hardkodovanja, posto imate listu,
//// iskoristiti element iz nje da se klikne),
//// kliknuti na Električni (mozete hardcodovati). Ostati na toj strani kao kraj zadatka.
//// Uspavati program na 5 sekundi kako bi se video rezultat i posle toga browser zatvoriti.
////
////Obratiti paznju na "ad" koji kaze da se registrujete.
//// Uzeti dugme x i kliknuti ga pre svega da ne bi ste imali problem da ne mozete da kliknete na kategoriju.
public class Main{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bakic\\Desktop\\selenium\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.kupujemprodajem.com/"); //prosledjujem link sajta kupujem prodajem
        driver.manage().window().maximize(); //uvecavam prozor

        WebElement closeBtn= driver.findElement(By.xpath("//*[@id=\"bodyTag\"]/div[9]/div/div[2]")); //pronalazim button X preko xpatha
        closeBtn.click(); //klik na x button
        try {
            Thread.sleep(2000); //uspavala sam program na 2 sekunde kako bih ispratila da li dobro radi
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement accept = driver.findElement(By.name("i-understand")); //pronalazim button za prihvatanje cookie-a
        accept.click(); //klik na button da prihvatim cookie

        List<WebElement> elementList= driver.findElements(By.id("category-tree-tab-goods")); //pronalayim elemente liste "stvari" pomocu id-a
        for (int i = 0; i < elementList.size(); i++) {
            WebElement links=elementList.get(i);
            System.out.println(links.getText()+ " "+  elementList.get(i).getDomAttribute("href")); // izlistati sve kategorije (Stvari) sa leve strane i njihove linkove , !!! problem pri pokretanju ne izlista linkove!)

        }

        WebElement bikeLink= driver.findElement(By.linkText("Bicikli")); //pronalazim element bicikl pomocu linkovanog teksta "Bicikli"
        bikeLink.click(); //klik na "Bicikli"
        try {
            Thread.sleep(2000);  //uspavala sam program na 2 sekunde kako bih ispratila da li tacno radi
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement electricBike= driver.findElement(By.xpath("//*[@id=\"groupBox1360\"]/div[1]/h2/a/span"));//pronalazim element elektricni bicikl pomocu xpatha
        electricBike.click(); //klik na "Elektricni bicikli"
        try {
            Thread.sleep(5000); ////uspavala sam program na 5 sekundi
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit(); //zatvaram diver




    }
}
