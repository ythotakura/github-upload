public class MultPractice implements StudyPractice
{
    private int firstNum;
    private int secondNum;

    public MultPractice(int num1, int num2)
    {
        firstNum = num1;
        secondNum = num2;
    }

    public String getProblem()
    {
        return firstNum + " TIMES " + secondNum;
    }

    public void nextProblem()
    {
        secondNum++;
    }
}