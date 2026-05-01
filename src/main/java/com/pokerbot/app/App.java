package com.pokerbot.app;

public class App {
    public static void main(String[] args) throws Exception {
        ApiClient api = new ApiClient();
        String apiKey = System.getenv("POKER_API_KEY");
        String result = api.get("https://pokermind.itmindsinternal.dk/api/next_games", apiKey);
        System.out.println(result);
    }
}
