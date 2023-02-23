package contactsManagerMisael;


public class ConsoleHelper {
    private String lastLine = "";

    public void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (int i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1)
                System.out.print("\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }

    private byte anim;

//    public void animate(String line) {
//        switch (anim) {
//            case 1 -> print("[] " + line);
//            case 2 -> print("[ Contacts ] " + line);
//            case 3  -> print("[ Manager ] " + line);
//            case 4 -> print("[ Contacts ] " + line);
//            case 5 -> print("[ Manager ] " + line);
//            case 6 -> print("[ Contacts ] " + line);
////            case 8 -> print("[ Contacts Manager! ] " + line);
//
//
//            default -> {
//                anim = 0;
//                print("[ - ] " + line);
//            }
//        }
//        anim++;
//    }


    public void animate(String line) {
        switch (anim) {
//            case 1 -> print("\u001B[33m[] \u001B[0m" + line); // yellow
            case 1 -> print("\u001B[31m[\n" +
                    "──────▄▄▄▄▄███████████████████▄▄▄▄▄──────\n" +
                    "────▄██████████▀▀▀▀▀▀▀▀▀▀██████▀████▄────\n" +
                    "──▄██▀████████▄─────────────▀▀████─▀██▄──\n" +
                    "─▀██▄▄██████████████████▄▄▄─────────▄██▀─\n" +
                    "───▀█████████████████████████▄────▄██▀───\n" +
                    "─────▀████▀▀▀▀▀▀▀▀▀▀▀▀█████████▄▄██▀─────\n" +
                    "───────▀███▄──────────────▀██████▀───────\n" +
                    "─────────▀██████▄─────────▄████▀─────────\n" +
                    "────────────▀█████▄▄▄▄▄▄▄███▀────────────\n" +
                    "──────────────▀████▀▀▀████▀──────────────\n" +
                    "────────────────▀███▄███▀────────────────\n" +
                    "───────────────────▀█▀───────────────────] \u001B[0m" + line); // red
            case 2 -> print("\u001B[35m[ Contacts ] \u001B[0m" + line); // magenta
            case 3 -> print("\u001B[36m[ Manager ] \u001B[0m" + line); // cyan
            case 4 -> print("\u001B[32m[ Contacts ] \u001B[0m" + line); // green
            case 5 -> print("\u001B[35m[ Manager ] \u001B[0m" + line); // magenta
            case 6 -> print("\u001B[32m[ Contacts ] \u001B[0m" + line); // green
            default -> {
                anim = 0;
                print("\u001B[31m[ - ] \u001B[0m" + line); // red
            }
        }
        anim++;
    }

    public static void main(String[] args) throws InterruptedException {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        for (int i = 0; i < 30; i++) {
            consoleHelper.animate(i + "");
            //simulate a piece of task
            Thread.sleep(3000);
//            System.out.println(i);



        }
    }
}



