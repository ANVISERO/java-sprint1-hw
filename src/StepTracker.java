import java.util.Scanner;

// В этом классе реализована логика по сохранению и изменению количества шагов. Также в нём выводится статистика.
public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;  // Цель по количеству шагов за день (по умолчанию 10000)
    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    // Добавляет количество пройденных шагов за определённый день
    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца:");
        // ввод и проверка номера месяца
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно!");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно):");
        // ввод и проверка дня
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Номер вводимого дня должен быть от 1 до 30 включительно!");
            return;
        }

        System.out.println("Введите количество шагов:");
        // ввод и проверка количества шагов
        int steps = scanner.nextInt();
        if (steps < 1) {
            System.out.println("Количество шагов должно быть положительным числом!");
            return;
        }

        // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month - 1];
        // Сохранение полученных данных
        monthData.days[day - 1] = steps;
    }

    // Меняет цель по количеству шагов за день на то, которое укажет пользователь
    void changeStepGoal(int steps) {
        if (steps <= 0) {
            System.out.println("Цель шагов на день не может быть меньше или равна нулю!");
            return;
        }
        goalByStepsPerDay = steps;
        System.out.println("Цель сохранена. Текущая цель по количеству шагов за день: " + goalByStepsPerDay);
    }

    // Вывод статистики по определённому месяцу
    void printStatistic() {
        System.out.println("Введите число месяца");
        // ввод и проверка номера месяца
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно!");
            return;
        }

        MonthData monthData = monthToData[month - 1]; // получение соответствующего месяца
        int sumSteps = monthData.sumStepsFromMonth(); // получение суммы шагов за месяц
        monthData.printDaysAndStepsFromMonth(); // вывод общей статистики по дням
        System.out.println("Сумма шагов за месяц: " + sumSteps); // вывод суммы шагов за месяц
        // вывод максимального пройденного количества шагов за месяц
        System.out.println("Максимально пройденное количество шагов за месяц: " + monthData.maxSteps());
        // вывод среднего пройденного количества шагов за месяц
        System.out.println("Среднее пройденное количество шагов за месяц: " + (sumSteps / 30));
        // вывод пройденной за месяц дистанции в км
        System.out.println("Пройденная за месяц дистанция в км: " + converter.convertToKm(sumSteps));
        // вывод количества сожжённых килокалорий за месяц
        System.out.println("Количество сожжённых килокалорий за месяц: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay)); // вывод лучшей серии
        System.out.println(); //дополнительный перенос строки
    }

    // Возвращает текущую цель по количеству шагов за день
    int getGoalByStepsPerDay() {
        return goalByStepsPerDay;
    }
}
