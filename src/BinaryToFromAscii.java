import java.util.Scanner;

public class BinaryToFromAscii
{
    static Scanner input = new Scanner(System.in);

    public static void run()
    {
        System.out.println(
                """
                -------
                1. Text to Binary
                2. Binary to text
                3. Quit
                -------
                Enter choice:\s
                """
        );
        int choice = input.nextInt();
        input.nextLine(); // Filler line

        if(choice == 1)
        {
            textToBinary();
        }
        else if (choice == 2)
        {
            binaryToText();
        }
        else if (choice == 3)
        {
            System.out.println("Why?");
        }
    }

    private static void binaryToText()
    {
        System.out.println("Enter binary: ");
    }

    private static void textToBinary()
    {
        System.out.println("Enter Text: ");
        String text = input.nextLine();

        StringBuilder binaryOutput = new StringBuilder();
        for(int i = 0; i < text.length(); i++)
        {
            int asciiValue = text.charAt(i);

            for(int e = 128; e > 0; e /= 2)
            {
                if((asciiValue - e) >= 0)
                {
                    binaryOutput.append("1");
                    asciiValue -= e;
                }
                else
                {
                    binaryOutput.append("0");
                }
            }
            binaryOutput.append(" ");
        }
        System.out.println(binaryOutput);
        run();
    }
}
