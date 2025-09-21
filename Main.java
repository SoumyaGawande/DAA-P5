public class Main
{
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
        String S = "AABCBDC";
char[] x = S.toCharArray();
        int n = x.length;

Output[][] c = new Output[n + 1][n + 1];

for(int i = 0; i<= n; i++)
        {
for(int j = 0; j <= n; j++)
            {
                c[i][j] = new Output();
                c[i][j].val = 0;
                c[i][j].dirn = "";
            }
        }

for(int i = 1; i<= n; i++)
        {
for(int j = 1; j <= n; j++)
            {
if(x[i - 1] == x[j - 1] &&i != j)
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

print(c, x, n, n);
System.out.println();
    }
}
