package MyPackage;

public class Pesel {
    public Pesel() {
    }

    public static void Check(String pesel) {
        if (CheckUtil(pesel)) {
            System.out.println("PESEL poprawny.");
        } else {
            System.out.println("PESEL niepoprawny.");
        }

    }

    private static boolean CheckUtil(String pesel) {
        if (pesel.length() != 11) {
            return false;
        } else {
            int sum = 0;
            int day = Integer.parseInt(pesel.substring(4, 6));
            int month = Integer.parseInt(pesel.substring(2, 4));
            int pesel_checksum = Integer.parseInt(pesel.substring(10, 11));
            int[] checksum_wages = new int[]{1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
            if (day <= 31 && day != 0) {
                if (month - 10 * (month / 10) > 12) {
                    return false;
                } else {
                    for(int i = 0; i < 10; ++i) {
                        sum += checksum_wages[i] * Integer.parseInt(pesel.substring(i, i + 1));
                    }

                    int x = (10 - sum % 10) % 10;
                    return x == pesel_checksum;
                }
            } else {
                return false;
            }
        }
    }
}
