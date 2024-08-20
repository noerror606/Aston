public class Main {
    public static void main(String[] args) {
        Worker[] arrayWorker = new Worker[5];
        arrayWorker[0]=new Worker("Диана Кукушкина Евгеньевна","Тестировщик","noerror606@gmail.com","+375336186208",1500000,22);
        arrayWorker[1]=new Worker("Артём Бондарев Александрович","Тестировщик","noerror706@gmail.com","+375336306208",2500000,26);
        arrayWorker[2]=new Worker("Денис Сидоров Романович","Скрам мастер","noerror609@gmail.com","+375336826208",3500000,62);
        arrayWorker[3]=new Worker("Лиана Иванова Леонидовна","Дата-аналитик","noerror686@gmail.com","+375331276208",4500000,42);
        arrayWorker[4]=new Worker("Людмила Романова Артёмовна","Программист JAVA","noerror306@gmail.com","+375337856208",5500000,28);

        //вывод
        for (int i = 0; i<arrayWorker.length; i++){
            arrayWorker[i].returnInfo();
        }

        //3 задание
        Park park = new Park();  // Создаем объект парка
        Park.Attraction attraction1 = park.new Attraction("Cупер-8", "10:00 - 18:00", 20.0);

        attraction1.returnInfo();
    }
}