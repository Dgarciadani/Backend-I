public class App {
    public static void main(String[] args) {
        ComputadoraFactory computadora = new ComputadoraFactory();
        Computadora mac1 = computadora.getComputer("Macos",16,500);
        Computadora win1 = computadora.getComputer("Wind",2,256);
        Computadora mac2 = computadora.getComputer("Macos",16,540);
        Computadora win2 = computadora.getComputer("Wind",16,500);

        System.out.println(mac2.toString());
        System.out.println(mac1.toString());
        System.out.println(win1.toString());
        System.out.println(win2.toString());
    }
}
