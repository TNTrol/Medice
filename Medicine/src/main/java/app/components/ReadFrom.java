package app.components;

public class ReadFrom
{


    public int getInt(int start, int end)
    {
        return 0;
    }
    
    public static class Max123
    {
        private int[] max = new int[3];
        private int m = 0;
        private boolean check = false;
        public Max123(){}
        public void put(int num)
        {
            if(m < 3)
            {
                max[m] = num;
                m++;
                return;
            }
            for (int i = 0; i < 3; i++)
                if( max[i] < num)
                {
                    max[i] = num;
                    return;
                }
        }
        public int getMax1()
        {
            return max[0];
        }
        public int getMax2()
        {
            return max[1];
        }
        public int getMax3()
        {
            return max[2];
        }
    }

    public  static void main(String[] arg)
    {
        int[] arr = {1,6,45,2,-1,8,7};
        Max123 max123 = new Max123();
        for (int a: arr) {
            max123.put(a);
        }
        System.out.println(max123.getMax1());
        System.out.println(max123.getMax2());
        System.out.println(max123.getMax3());
    }

}
