public class Park {
    public class Attraction {
        String nameAttraction, time;
        double sale;

        public Attraction(String nameAttraction, String time, double sale){
            this.nameAttraction = nameAttraction;
            this.time = time;
            this.sale = sale;
        }
        public void returnInfo() {
            System.out.println("\nАттракцион: " + this.nameAttraction +
                    "\nВремя работы: " + this.time +
                    "\nСтоимость: " + this.sale + " BYR");
        }

    }
}
