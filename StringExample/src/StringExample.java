

public class StringExample {
    static String name = " Bibek Baram ";
    static String name2 = " Bibek Baram ";
    static String name3 = "Bibek Baram";

    static void main() {
        System.out.println(name.toLowerCase());
        System.out.println(name.toUpperCase());
        System.out.println(name.charAt(8));
        System.out.println(name.trim());
        System.out.println(name.substring(1,6));
        System.out.println(name.getBytes());
        System.out.println(name.strip());
        System.out.println(name.equals(name2));
        System.out.println(name == name2);

        StringBuilder sb = new StringBuilder("Bibek");
        System.out.println(sb);
        sb.append("Baram");
        System.out.println(sb);
        sb.insert(0,"Hello");
        System.out.println(sb);
        System.out.println(sb.reverse());

        StringBuffer sb2 = new StringBuffer(name3);
        System.out.println(sb2);

    }
}
