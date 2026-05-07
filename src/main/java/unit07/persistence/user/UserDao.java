package unit07.persistence.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserDao {
    private final SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(UserEntity user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        }
    }

    public Optional<UserEntity> findById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(UserEntity.class, id));
        }
    }

    public List<UserEntity> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from UserEntity", UserEntity.class).list();
        }
    }

    public void update(UserEntity user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(user);
            tx.commit();
        }
    }

    public void delete(String id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            UserEntity user = session.get(UserEntity.class, id);
            if (user != null) {
                session.remove(user);
            }
            tx.commit();
        }
    }

    public Optional<UserEntity> login(String username, String password) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from UserEntity where userId = :username and password = :password";
            UserEntity user = session.createQuery(hql, UserEntity.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();

            if (user != null) {
                // Return a copy without the password for security/navigation purposes
                return Optional.of(UserEntity.builder()
                        .userId(user.getUserId())
                        .role(user.getRole())
                        .build());
            }
            return Optional.empty();
        }
    }
}
