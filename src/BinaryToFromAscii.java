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
        StringBuilder textOutput = new StringBuilder();
        System.out.println("Enter Binary: ");
        String f = input.nextLine();
        int unicodeIndex = 0;
        int u = 0;
        String binary = f + " ";

        for(int i = 0; i < (binary.length()/9); i++)
        {
                for(int w = 128; w > 0; w /= 2)
                {
                    String binarySnippet = binary.substring(u, u+1);
                    if(binarySnippet.equals("1"))
                    {
                        unicodeIndex += w;
                    }
                    u++;
                }
                u++;
                char letter = (char) unicodeIndex;
                textOutput.append(letter);
                unicodeIndex = 0;
        }
        System.out.println(textOutput);
        run();

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
