package unit02.lombok.lecturer;

public class MainBuilderWithCondition
{

    public static void main(String[] args) {
        String optionalFIeld = "Something is inside";

        var person = Lecturer.builder().name("asdf").id(1);

        if(optionalFIeld != null) person.email(optionalFIeld);

        Lecturer l = person.build();

    }
}
