// Преобразование шагов в километры и килокалории
public class Converter {

    // Переводит количество  шагов в километры
    int convertToKm(int steps) {
        return steps * 3 / 4 / 1000;
    }

    // Переводит количество шагов в килокалории
    int convertStepsToKilocalories(int steps) {
        return steps * 50 / 1000;
    }
}
