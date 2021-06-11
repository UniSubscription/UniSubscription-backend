package az.code.unisubscription.repositories;

import az.code.unisubscription.models.Subscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
    @Query(value = "select * from Subscription",nativeQuery = true)
    List<Subscription> getAllSubscriptions();
//
//    @Query(value = "select * from students s where s.name = ?1 and s.surname =  ?2",nativeQuery = true)
//    List<Student> findStudentByNameAndSurname( String name, String surname);
//
//    @Query("SELECT s FROM Student s WHERE s.name LIKE  CONCAT('%', :name, '%') AND (SELECT MAX(m.grade) FROM Mark m WHERE m.student.id = s.id) > :grade")
//    List<Student> findStudentByNameAndGrade( String name, int grade);
//
//    @Query("SELECT m FROM Mark m WHERE m.student.id = :studentId AND ((SELECT s.name FROM Student s WHERE s.id = m.student.id) LIKE CONCAT('%', :name, '%')) AND m.grade > :grade")
//    List<Mark> findMarksByNameAndGrade(int studentId, String name, int grade);
}
