import com.infomaximum.entity.Address;
import com.infomaximum.service.StatisticsService;
import com.infomaximum.service.UserPathHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final List<Address> addressList = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Scanner input = new Scanner(System.in);
        System.out.println("Input Your File Path Here Or Input exit To End The Program: ");
        while (input.hasNextLine()) {
            String path = input.nextLine();
            List<Address> addresses = UserPathHandler.readFileWithEnds(path);
            StatisticsService.countingDuplicates(addresses);
            StatisticsService.countingFloorInCities(addresses);
                System.out.println("Input Your File Path Here Or Input exit To End The Program: ");
            if (path.equals("exit")) {
                System.out.println("Program Close");
                break;
            }
        }
    }
}
