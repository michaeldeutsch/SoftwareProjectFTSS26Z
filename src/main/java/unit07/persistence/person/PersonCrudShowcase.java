package unit07.persistence.person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PersonCrudShowcase {

    private static final SessionFactory SESSION_FACTORY = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        logSection("CREATE");
        PersonEntity person = create("John", "Doe", "john.doe@test.com", 25);
        System.out.println("Created: " + person);

        logSection("GET BY ID");
        PersonEntity found = getPersonById(person.getId());
        System.out.println("Found: " + found);

        logSection("GET ALL");
        printAll();

        logSection("UPDATE");
        update(person.getId(), "John Updated", 26);

        logSection("DELETE");
        delete(person.getId());

        logSection("GET ALL AFTER DELETE");
        printAll();

        SESSION_FACTORY.close();
    }

    static PersonEntity create(String firstName, String lastName, String email, int age) {
        PersonEntity person = PersonEntity.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .age(age)
                .build();

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(person);
            tx.commit();
        }
        return person;
    }

    static PersonEntity getPersonById(Long id) {
        try (Session session = SESSION_FACTORY.openSession()) {
            return session.get(PersonEntity.class, id);
        }
    }

    static void printAll() {
        try (Session session = SESSION_FACTORY.openSession()) {
            List<PersonEntity> list = session.createQuery("from PersonEntity", PersonEntity.class).list();
            list.forEach(System.out::println);
        }
    }

    static void update(Long id, String newFirstName, int newAge) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            PersonEntity person = session.get(PersonEntity.class, id);
            if (person != null) {
                person.setFirstName(newFirstName);
                person.setAge(newAge);
                System.out.println("Updated: " + person);
            }
            tx.commit();
        }
    }

    static void delete(Long id) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            PersonEntity person = session.get(PersonEntity.class, id);
            if (person != null) {
                session.remove(person);
                System.out.println("Deleted: " + person);
            }
            tx.commit();
        }
    }

    private static void logSection(String title) {
        System.out.println("\n==== " + title + " ===================================\n");
    }
}