import java.util.ArrayList;
public class Digits
{
    private ArrayList<Integer> digitList;
    private ArrayList<Integer> switchList;
    int newNum = 0;
    
    public Digits(int num)
    {
        digitList = new ArrayList<Integer>();
        switchList = new ArrayList<Integer>();

        if(num == 0)
        {
            switchList.add(0);
        }

        while(num > 0)
        {
            newNum = num % 10;
            digitList.add(newNum);
            num /= 10;
        }
        
        for(int i = digitList.size(); i > 0; i--)
        {
            switchList.add(digitList.get(i - 1));
        }
    }
    
    public boolean isStrictlyIncreasing()
    {
        for(int i = 0; i < switchList.size() - 1; i++)
        {
            if(switchList.get(i) >= switchList.get(i + 1))
            {
                return false;
            }
        }
        return true;
    }
}