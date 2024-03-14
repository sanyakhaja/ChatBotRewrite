import java.util.*;

public class ChatMeUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello and welcome to ChatMeUp! Enter 'exit' or 'stop' or 'bye' to quit at anytime.");
        System.out.println("BOT: What would you like me to call you?");
        String userName = scanner.nextLine();
        System.out.println("Nice to meet you " + userName + "! Go ahead and ask me a question.");

        String name = "Chatterbox";
        String mood = "Eh";
        String today = java.time.LocalDate.now().toString();
        String weather = "Sunny";

        String botTemplate = name + " : %s";
        String userTemplate = userName + " : %s";

        // HashMap to store responses to different user inputs
        Map<String, List<String>> responses = new HashMap<>();
        responses.put("what's your name?", Arrays.asList(
                "My name is %s. How are you doing?",
                "My friends call me chatty, but you could call me %s. How are things for you today?",
                "The name I was given at creation is %s. How's life?"));
        responses.put("what's the weather today?", Arrays.asList(
                "Although I like rainy weather, today it is %s. Do you like %s weather?",
                "It is %s at the moment.",
                "According to my quite reliable sources, it is %s"));
        responses.put("what is today's date?", Arrays.asList(
                "The date today is %s.",
                "Today's date is %s.",
                "It is %s"));
        responses.put("how are you?", Arrays.asList(
                "I am feeling quite %s. How are you?",
                "I am %s, how about you?",
                "Today has been a pretty rough day, I would say I am %s at the moment. How are you?"));
        responses.put("are you a robot?", Arrays.asList(
                "I would like to think of myself as a robot with feelings. Are you a robot?",
                "Maybe I am, maybe I'm not. Who knows?",
                "Well, are you a human?"));
        responses.put("what are your pronouns?", Arrays.asList(
                "So kind of you to ask, I go by it/its as I am a robot. How about you?",
                "Not often we hear someone ask a robot that question, but I prefer it/its. How about you?",
                "I go by it/its, how about you?"));
        responses.put("yes", Arrays.asList(
                "Well that is quite interesting. Would you like to ask me another question?",
                "Really? I was not expecting that. Is there anything else you would like to ask me?"));
        responses.put("no", Arrays.asList(
                "Oh is that so?",
                "Well there is nothing I could do about that, is there?"));
        responses.put("I do", Arrays.asList(
                "Well do you really think so?",
                "Oh really? Is that so?"));
        responses.put("maybe", Arrays.asList(
                "Hmm, treading in safe water I see. Aren't you a smart one?"));
        responses.put("I am good", Arrays.asList(
                "Well that is nice to hear.",
                "Don't hear that too often, good for you."));
        responses.put("I am not good", Arrays.asList(
                "Well I bet you are just having a bad day, I hope you feel better soon.",
                "Things will get better, don't worry too much.",
                "Everyone has bad days, whats important is how make them better."));
        responses.put("Eh", Arrays.asList(
                "Wow we are so similar, aren't we?",
                "who would've thought a robot and a human felt the same way?"));
        responses.put("I go by __", Arrays.asList(
                "Hmm that is nice to know",
                "Mm that's cool!"));
        responses.put("Bruh", Arrays.asList(
                "Well I am neither male nor female nor non-binary, soooo",
                "Are you my long lost sibling?",
                "Oh no, did I say something wrong?"));
        responses.put("What is your favorite song?", Arrays.asList(
                "My current favorite song is 'Hey Tayo' by Enhypen. How about yours?",
                "You can never go wrong with '0X1=LOVESONG' by Tommorow By Together. What's your favorite song",
                "Here is the link to my favorite song, https://www.youtube.com/watch?v=dQw4w9WgXcQ. I hope you enjoy it."));
        responses.put("", Arrays.asList(
                "Hey, did I bore you already?",
                "Sorry I am unable to respond to this. I am still a work in progress afterall:) You could ask me another question!",
                "Oh that is quite interesting. Any other questions for me?",
                "Hm is that so? Are you enjoying chatting with me?"));
        responses.put("default", Collections.singletonList(
                "sorry I am unable to respond to this. I am still a work in progress afterall:)"));

        while (true) {
            String userIn = scanner.nextLine().toLowerCase();
            if (userIn.equals("exit") || userIn.equals("stop") || userIn.equals("bye")) {
                System.out.println("I enjoyed chatting with you! Bye:))");
                break;
            }
            String similar = similarResponse(userIn);
            botResponse(similar, responses, userIn, userTemplate, botTemplate);
        }
    }

    // Method to find a suitable response based on user input
    private static String similarResponse(String userInput) {
        if (userInput.contains("name")) {
            return "what's your name?";
        } else if (userInput.contains("date")) {
            return "what is today's date?";
        } else if (userInput.contains("how are")) {
            return "how are you?";
        } else if (userInput.contains("bot")) {
            return "are you a robot?";
        } else if (userInput.contains("pronouns")) {
            return "what are your pronouns?";
        } else if (userInput.contains("yes") || userInput.contains("yeah") || userInput.contains("yea") || userInput.contains("it is")) {
            return "yes";
        } else if (userInput.contains("not good")) {
            return "I am not good";
        } else if (userInput.contains("no") || userInput.contains("nah")) {
            return "no";
        } else if (userInput.contains("good")) {
            return "I am good";
        } else if (userInput.contains("i do") || userInput.contains("me") || userInput.contains("i am")) {
            return "I do";
        } else if (userInput.contains("maybe")) {
            return "maybe";
        } else if (userInput.contains("eh")) {
            return "Eh";
        } else if (userInput.contains("/") || userInput.contains("mine are") || userInput.contains("i go by")) {
            return "I go by __";

        } else if (userInput.contains("bruh") || userInput.contains("bro")) {
            return "Bruh";
        } else if (userInput.contains("song")) {
            return "What is your favorite song?";
        } else {
            return "";
        }
    }

    // Method to generate bot responses based on user input
    private static void botResponse(String similar, Map<String, List<String>> responses, String userIn,
                                    String userTemplate, String botTemplate) {
        System.out.println(String.format(userTemplate, userIn));
        List<String> possibleResponses = responses.getOrDefault(similar, responses.get("default"));
        String response = possibleResponses.get(new Random().nextInt(possibleResponses.size()));
        System.out.println(String.format(botTemplate, response));
    }
}

