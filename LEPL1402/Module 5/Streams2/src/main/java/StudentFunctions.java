import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StudentFunctions implements StudentStreamFunction {

  public Student findFirst(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions){
      return matching(studentsStream, conditions).findFirst().orElse(null);
  }

  public Student[] findAll(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions){
      return matching(studentsStream, conditions).toArray(Student[]::new);
  }

  public boolean exists(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions, int n){
      return matching(studentsStream, conditions).count() >= n;
  }

  public Student[] filterThenSort(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions, Comparator<Student> comparator){
      return matching(studentsStream, conditions).sorted(comparator).toArray(Student[]::new);
  }

  private Stream<Student> matching(Stream<Student> studentsStream, Map<String, Predicate<?>> criterion){
    for (Map.Entry<String, Predicate<?>> criteria : criterion.entrySet()){
      switch(criteria.getKey()){
        case "firstName":
          Predicate<String> p1 = (Predicate<String>) criteria.getValue();
          studentsStream = studentsStream.filter(s -> p1.test(s.getFirstName()));
          break;
        case "lastName":
          Predicate<String> p2 = (Predicate<String>) criteria.getValue();
          studentsStream = studentsStream.filter(s -> p2.test(s.getLastName()));
          break;
        case "section":
          Predicate<Integer> p3 = (Predicate<Integer>) criteria.getValue();
          studentsStream = studentsStream.filter(s -> p3.test(s.getSection()));
          break;
        case "courses_results":
          Predicate<Map<String, Double>> p4 = (Predicate<Map<String, Double>>) criteria.getValue();
          studentsStream = studentsStream.filter(s -> p4.test(s.getCourses_results()));
          break;
        default:
          break;
      }
    }
    return studentsStream;
  }
}
