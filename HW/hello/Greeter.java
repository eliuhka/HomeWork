package hello;

public class Greeter extends Counter {

    Counter count = new Counter();

    public String sayHello(String name) {
        int length;
        try {
            length = count.checkLength(name);
        } catch (Exception x) {
            String error = "Error!";
            return error;
        }

        if (length == 1) {
            String shortName = name + ", su nimi on lühike!";
            return shortName;
        } else if (length > 0 && length < 15) {
            return String.format("Tere, %s ! Su nimi on %d tähte pikk", name, length);
        }  else {
            String whoIs = "Kes sa oled?";
            return whoIs;
        }
    }

}

