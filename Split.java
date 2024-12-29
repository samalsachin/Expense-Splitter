import java.util.*;

class Split {
    static HashMap<String, Integer> hm = new HashMap<>();
    static int total = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Number of Persons: ");
        int sz = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < sz; i++) {
            System.out.print("Enter the Name of Person " + (i + 1) + ": ");
            String p1 = scanner.nextLine();
            hm.put(p1, 0);
        }

        String item;
        int givenMoney;
        String wpm;

        while (true) {
            System.out.print("Enter the Name of the Item (or 'break' to stop): ");
            item = scanner.nextLine();
            if (item.equalsIgnoreCase("break")) {
                break;
            }

            System.out.print("Enter the Amount for the Item: ");
            givenMoney = scanner.nextInt();
            total += givenMoney;

            System.out.print("Enter the Name of the Person Who Paid: ");
            scanner.nextLine();
            wpm = scanner.nextLine();
            hm.put(wpm, hm.get(wpm) + givenMoney);

            ArrayList<String> person = new ArrayList<>();

            while (true) {
                System.out.print("Enter the Name of the Person Who Shared (or 'break' to stop): ");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("break")) {
                    break;
                }
                person.add(name);
            }

            int perp = givenMoney / person.size();

            for (int i = 0; i < person.size(); i++) {
                hm.put(person.get(i), hm.get(person.get(i)) - perp);
            }
        }
        System.out.println("Total Spent::"+total);
        for (String an : hm.keySet()) {
            System.out.println(an + "::" + hm.get(an));
        }

        scanner.close();
    }
}
