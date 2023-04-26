import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] product = {
                "Хлеб  ",
                "Молоко",
                "Гречка"
        };
        int[] prices = {
                40,
                60,
                80
        };
        System.out.println("Список возможных товаров для покупки: ");
        for (int i = 0; i < product.length; i++) {
            System.out.println(i+1 + "." + product[i] + " " + prices[i] + " руб/шт");
        }
        int productNumber = 0;//номер продукта
        int productCount = 0;//кол-во продуктов
        int currentPrice = 0;//цена определенного продукта
        int sum = 0;//сумма всех товаров
        int[] count = new int[3];//массив для подсчета количества раз добавления товара
        int[] sumOfOneProduct = new int[3];//массив для подсчета суммы по одному товару

        while (true){
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            }
            String[] parts = input.split(" ");
            productNumber = Integer.parseInt(parts[0])-1;
            productCount = Integer.parseInt(parts[1]);
            currentPrice = prices[productNumber];
            count[productNumber] += productCount;
            sumOfOneProduct[productNumber] += productCount*currentPrice;
            sum = sum + productCount*currentPrice;
        }

        System.out.println("Ваша корзина: ");
        System.out.println("Наименование товара  Количество  Цена за ед. Общая стоимость");
        for (int i = 0; i<count.length;i++) {
            if (count[i] > 0) {
                System.out.println("" + product[i] + "               " + count[i] +
                        "           " + prices[i] + "руб.      " + sumOfOneProduct[i] + "руб.");
            }
        }
        System.out.println("                                 Итого:      " + sum +" руб.");
    }

}
