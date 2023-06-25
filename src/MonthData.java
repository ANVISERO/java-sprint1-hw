// В этом классе хранятся данные конкретного месяца и логика по подсчёту статистики
public class MonthData {
    int[] days = new int[30];

    // Выводит количество пройденных шагов по дням
    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    // Возвращает общее количество шагов за месяц
    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int day : days) {
            // подсчёт суммы элементов массива days[]
            sumSteps += day;
        }
        return sumSteps;
    }

    // Возвращает максимальное количество шагов за месяц
    int maxSteps() {
        int maxSteps = 0;
        for (int day : days) {
            // поиск максимального элемента
            if (day > maxSteps) {
                maxSteps = day;
            }
        }
        return maxSteps;
    }

    // Возвращает лучшую серию (максимальное количество подряд идущих дней, в течение которых количество шагов за день
    // было равно или выше целевого)
    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int day : days) {
            // поиск максимальной серии
            if (day < goalByStepsPerDay) {
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
                currentSeries = 0;
                continue;
            }
            currentSeries++;
        }
        return finalSeries;
    }
}
