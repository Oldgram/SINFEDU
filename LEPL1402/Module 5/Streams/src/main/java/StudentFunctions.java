import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StudentFunctions implements StudentStreamFunction {

  public Stream<Student> findSecondAndThirdTopStudentForGivenCourse(Stream<Student> studentStream, String name){
    return studentStream
            .filter(s -> s.getCoursesResults().containsKey(name))
            .sorted((s1, s2) -> Double.compare(0.0, s1.getCoursesResults().get(name) - s2.getCoursesResults().get(name)))
            .skip(1).limit(2);
  }

  public Object[] computeAverageForStudentInSection(Stream<Student> studentStream, int section){
    return studentStream
            .filter(s -> s.getSection() == section)
            .map(s -> new Object[]{
                    "Student " + s.getLastName() + " " + s.getFirstName(),
                    s.getCoursesResults().values().stream().reduce(0.0, Double::sum) / s.getCoursesResults().size()})
            .toArray();
  }

  public int getNumberOfSuccessfulStudents(Stream<Student> studentStream){
    return (int) studentStream
            .filter(s -> s.getCoursesResults().values().stream().allMatch(g -> g > 10.0))
            .count();
  }

  public Student findLastInLexicographicOrder(Stream<Student> studentStream){
    return studentStream
            .max(Comparator
                    .comparing(Student::getLastName)
                    .thenComparing(Student::getFirstName))
            .orElse(null);
  }

  public double getFullSum(Stream<Student> studentStream){
    return studentStream.map(s -> s.getCoursesResults().values().stream().reduce(0.0, Double::sum)).reduce(0.0, Double::sum);
  }
}
