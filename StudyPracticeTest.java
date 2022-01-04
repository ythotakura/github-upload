public class StudyPracticeTest 
{
    public static void main(String [] args)
    {
        StudyPractice study = new MultPractice(7,3);
        System.out.println(study.getProblem());
        study.nextProblem();
        System.out.println(study.getProblem());
        study.nextProblem();
        System.out.println(study.getProblem());
        study.nextProblem();
        System.out.println(study.getProblem());
        study.nextProblem();
        System.out.println(study.getProblem());
        study.nextProblem();
        System.out.println(study.getProblem());
    }
}