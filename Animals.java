public class Animals 
{
    
    String text;
    String yash;
    int val;

    public Animals() 
    {  
        
    }

    public Animals(String text) {
        this.text = text;
    }

    public Animals(String text, String yash, int val) 
    {
        this.yash = yash;
    }

    public Animals(int val)
    {
        this.val = val;
    }

    public Animals(String text, int val)
    {
        this.text = text;
        this.val = val;
    }

    public void setText(String text) 
    {
        this.text = text;
    }

    public String getText() 
    {
        return text;
    }

    public void setVal(int val) 
    {
        this.val = val;
    }

    public int getVal() 
    {
        return val;
    }

    public String toString() 
    {
        return text + " - " + getVal();
    }
}