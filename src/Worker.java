public class Worker {
    String fio,post,email,phone;
    int payday, year;

    public Worker(String fio, String post, String email, String phone, int payday, int year ) {
        this.fio = fio;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.payday = payday;
        this.year = year;
    }
    public void returnInfo(){
        System.out.println("\nФИО: " + this.fio + "\nДолжность: " + this.post + "\nEmail: " + this.email +
                "\nТелефон:" + this.phone + "\nЗарплата:"+ this.payday + "\nВозраст: " + this.year);
    }


}
