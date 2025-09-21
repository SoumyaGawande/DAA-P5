public class LongestCommonSubsequence {
    static void print(Output[][] c , char[] x , int i , int j)
    {
if(i == 0 || j == 0)
        {
            return;
        }

        if(c[i][j].dirn.equals("d"))
        {
print(c , x , i - 1 , j - 1);
System.out.print(x[i - 1]);
        }
        else
        {
            if(c[i][j].dirn.equals("u"))
            {
print(c , x , i - 1 , j);
            }
            else
            {
print(c , x , i , j - 1);
            }
        }
    }

    public static void main(String[] args) 
    {
        String X = "AGCCCTAAGGGCTACCTAGCTT";
        String Y = "GACAGCCTACAAGCGTTAGCTTG";

char[] x = X.toCharArray();
char[] y = Y.toCharArray();

Output[][] c = new Output[X.length() + 1][Y.length() + 1];

        for (int i = 0; i<= X.length(); i++)
        {
            for (int j = 0; j <= Y.length(); j++)
            {
                c[i][j] = new Output();
                c[i][j].val = 0;
                c[i][j].dirn = "";
            }
        }

for(int i = 1; i<= X.length(); i++)
        {
for(int j = 1; j <= Y.length(); j++)
            {
if(x[i - 1] == y[j - 1])
                {
                    c[i][j].val = c[i - 1][j - 1].val + 1;
                    c[i][j].dirn = "d";	
                }
                else
                {
if(c[i - 1][j].val>= c[i][j - 1].val)
                    {
                       c[i][j].val = c[i - 1][j].val;
                       c[i][j].dirn = "u"; 
                    }
                    else
                    {
                       c[i][j].val = c[i][j - 1].val;
                       c[i][j].dirn = "l"; 
                    }
                }
            }
        }
System.out.println("Length of LCS is : " + c[x.length][y.length].val);
print(c , x , X.length() , Y.length());
System.out.println();
    }

}


