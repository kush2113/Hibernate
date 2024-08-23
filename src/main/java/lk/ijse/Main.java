package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.embed.FullName;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session= FactoryConfiguration.getInstance().getSession();

        FullName fullName = new FullName("Ruca","Dila");

        Student student = new Student();
        student.setId(1);
        student.setName(fullName);
        student.setAddress("Mathugama");


        Transaction transaction = session.beginTransaction();
        //save
        session.save(student);

          //delete
//        session.delete(student);

        Student st = session.get(Student.class,1);
        System.out.println(st.getId());
        System.out.println(st.getName().getFirstName());
        System.out.println(st.getAddress());
        transaction.commit();
        session.close();
    }
}