import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;


// Это основной класс. В нём происходит взаимодействие приложения с пользователем через консольный интерфейс
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();

            int i = scanner.nextInt();
            if (i == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (i == 2) {
                System.out.println("Текущая цель по количеству шагов: " + stepTracker.getGoalByStepsPerDay());
                System.out.println("Введите новую цель по количеству шагов: ");
                stepTracker.changeStepGoal(scanner.nextInt());
            } else if (i == 3) {
                stepTracker.printStatistic();
            } else if (i == 4) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }

    // Вывод меню в консоль
    static void printMenu() {
        System.out.println("Выберите одно из предложенных ниже действий:\n" +
                "(1) Ввести количество шагов за определённый день\n" +
                "(2) Изменить цель по количеству шагов за день\n" +
                "(3) Напечатать статистику за определённый месяц\n" +
                "(4) Выйти из приложения");
    }
}
