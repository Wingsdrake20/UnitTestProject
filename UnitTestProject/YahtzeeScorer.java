public class YahtzeeScorer {
    int points;
    Boolean Y, L, F, T;

    public YahtzeeScorer()
    {
        Y = false;
        L = false;
        F = false;
        T = false;
        points = 0;
    }

    public void newRoll(int a, int b, int c, int d, int e)
    {
        System.out.println("Dice are: " + a + ", " + b + ", " + c + ", " + d + ", " + e );
    }

    public int scorer(String choice, int a, int b, int c, int d, int e)
    {
        if(choice.equals("Yahtzee") && a == b && a == c && a == d && a == e && !Y)
        {
            points += 50;
            played("Yahtzee", true);
            return 50;
        }
        else if(choice.equals("Yahtzee"))
        {
            played("Yahtzee", true);
        }
        else if(choice.equals("Large Straight"))
        {
            int[] straight = new int[5];
            straight[0] = a;
            straight[1] = b;
            straight[2] = c;
            straight[3] = d;
            straight[4] = e;
            for(int i = 0; i < 5; i++)
            {
                for(int j = 0; j < i; j++)
                {
                    if(straight[j] > straight[i])
                    {
                        int temp = straight[j];
                        straight[j] = straight[i];
                        straight[i] = temp;
                    }
                }
            }
            if(straight[0] == 1 && straight[1] == 2 && straight[2] == 3 && straight[3] == 4 && straight[4] == 5 && !L)
            {
                points += 40;
                played("Large Straight", true);
                return 40;
            }
            else if(straight[0] == 2 && straight[1] == 3 && straight[2] == 4 && straight[3] == 5 && straight[4] == 6 && !L)
            {
                points += 40;
                played("Large Straight", true);
                return 40;
            }
            played("Large Straight", true);
        }
        else if(choice.equals("3 of a Kind"))
        {
            int[] tk = new int[5];
            tk[0] = a;
            tk[1] = b;
            tk[2] = c;
            tk[3] = d;
            tk[4] = e;
            for(int i = 0; i < 5; i++)
            {
                for(int j = 0; j < i; j++)
                {
                    if(tk[j] > tk[i])
                    {
                        int temp = tk[j];
                        tk[j] = tk[i];
                        tk[i] = temp;
                    }
                }
            }
            if(tk[0] == tk[1]  && tk[1] == tk[2] && !T)
            {
                points += a + b + c + d + e;
                played("3 of a Kind", true);
                return a + b + c + d + e;
            }
            else if(tk[1] == tk[2]  && tk[2] == tk[3] && !T)
            {
                points += a + b + c + d + e;
                played("3 of a Kind", true);
                return a + b + c + d + e;
            }
            else if(tk[2] == tk[3]  && tk[3] == tk[4] && !T)
            {
                points += a + b + c + d + e;
                played("3 of a Kind", true);
                return a + b + c + d + e;
            }
            return 0;
        }
        else if(choice.equals("Full House"))
        {
            int[] full = new int[5];
            full[0] = a;
            full[1] = b;
            full[2] = c;
            full[3] = d;
            full[4] = e;
            for(int i = 0; i < 5; i++)
            {
                for(int j = 0; j < i; j++)
                {
                    if(full[j] > full[i])
                    {
                        int temp = full[j];
                        full[j] = full[i];
                        full[i] = temp;
                    }
                }
            }
            if(full[0] == full[1]  && full[1] == full[2] && full[3] == full[4] && full[1] != full[4] && !F)
            {
                points += 25;
                played("Full House", true);
                return 25;
            }
            else if(full[0] == full[1] && full[2] == full[3] && full[3] == full[4] && full[1] != full[4] && !F)
            {
                points += 25;
                played("Full House", true);
                return 25;
            }
            return 0;
        }
        return 0;
    }

    public void played(String choice, Boolean beenPlayed)
    {
        if (choice.equals("Yahtzee"))
        {
            Y = beenPlayed;
        }
        else if (choice.equals("Large Straight"))
        {
            L = beenPlayed;
        }
        else if (choice.equals("Full House"))
        {
            F = beenPlayed;
        }
        else if (choice.equals("3 of a Kind"))
        {
            T = beenPlayed;
        }

    }

    public int getScore()
    {
        return points;
    }
}
