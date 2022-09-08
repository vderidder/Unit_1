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
            System.out.println();
        }
    }

    private static void binaryToText()
    {
        StringBuilder textOutput = new StringBuilder(); // Framework for the output
        System.out.println("Enter Binary: ");
        String SneakySpaceIncoming = input.nextLine(); // Input for the binary code
        int u = 0; // used later
        String binary = SneakySpaceIncoming + " "; // adding a space at the end to make it even for the loop
        for(int i = 0; i < (binary.length()/9); i++)
        {
            int unicodeIndex = 0; // Used to find the letter described in binary
            for(int w = 128; w > 0; w /= 2)
            {
                String binarySnippet = binary.substring(u, u+1); // Gets each number individually
                if(binarySnippet.equals("1"))
                {
                    unicodeIndex += w; // adds the value if it is present
                }
                u++; // Along with the for loop parameter, it will run exactly 8 times
            }
            u++; // Used to skip the space
            char letter = (char) unicodeIndex; // transforms the unicode to a letter or symbol
            textOutput.append(letter); // adds the letter to the final string
        }
        System.out.println(textOutput);
        run();

    }

    private static void textToBinary()
    {
        System.out.println("Enter Text: ");
        String text = input.nextLine(); // input for text

        StringBuilder binaryOutput = new StringBuilder(); // Framework for the output
        for(int i = 0; i < text.length(); i++)
        {
            int asciiValue = text.charAt(i); // grabbing 1 letter as a char and finding its unicode value

            for(int e = 128; e > 0; e /= 2) // for loop to go through all binary possibilities 128 64 etc...
            {
                if((asciiValue - e) >= 0) // checks if the unicode value can be subtracted by the respective binary one
                {
                    binaryOutput.append("1"); // the unicode value can be subtracted
                    asciiValue -= e;
                }
                else
                {
                    binaryOutput.append("0"); // the unicode value cannot
                }
            }
            binaryOutput.append(" "); // Putting a space to space out the 8 digits
        }
        System.out.println(binaryOutput);
        run();
    }
}
