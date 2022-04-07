import java.util.Scanner;

class TaxСalculation {

    public static void main(String[] args) {
        System.out.println("Выбирите операцию и введите ее номер, либо введите end для завершения.");
        System.out.println("1.Добавить новый доход.\n2.Добавить новый расход.\n3.Выбор системы налогообложения.");
        Scanner scanner = new Scanner(System.in);

        double earnings = 0;
        double spendings = 0;

        while (true) {
            double eMs = earningsMinusSpending(earnings, spendings);
            double taxE = taxEarnings(earnings);
            double tax = taxEarningsMinusSpending(eMs);


            String input = scanner.nextLine();
            if (input.equals("end")) {
                System.out.println("Программа завершена!");
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String lossesStr = scanner.nextLine();
                    int losses = Integer.parseInt(lossesStr);
                    spendings += losses;
                    break;
                case 3:
                    System.out.println("Выбрать систему налогооблажения");
                    differenceСalculation(tax, taxE);
                    break;
                default:
                    System.out.println("Такой операции нет!");
            }
        }
    }

    public static void differenceСalculation(double tax, double taxE) {
        double difference;
        if (taxE < tax) {
            difference = tax - taxE;
            System.out.println("Мы советуем Вам УСН доходы.\nВаш налог составит " + taxE + "!");
            System.out.println("Налог на другой системе : " + tax + "\nЭкономия: " + difference + "!!!");
        } else if (taxE > tax) {
            difference = taxE - tax;
            System.out.println("Мы советуем Вам УСН доходы минус расходы.\nВаш налог составит " + tax + "!");
            System.out.println("Налог на другой системе : " + taxE + "\nЭкономия: " + difference + "!!!");
        } else {
            System.out.println("Налоговые вычеты равны в обоих УСН");
        }
    }

    public static double taxEarnings(double earnings) {
        double taxE = earnings * 6 / 100;
        if (taxE >= 0) {
            return taxE;
        } else {
            return 0;
        }
    }

    public static double earningsMinusSpending(double earnings, double spendings) {
        double eMs = earnings - spendings;
        return eMs;
    }

    public static double taxEarningsMinusSpending(double eMs) {
        double tax = eMs * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
}