/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretsantagenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SecretSantaGenerator {
    
        public static List<Pair<String, String>> generateSecretSanta(List<String> names) {
        List<String> participants = new ArrayList<>(names);
        List<String> santas = new ArrayList<>(names);
        Collections.shuffle(santas);

        List<Pair<String, String>> pairings = new ArrayList<>();

        for (int i = 0; i < participants.size(); i++) {
            pairings.add(new Pair<>(participants.get(i), santas.get(i)));
        }

        return pairings;
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of participants
        System.out.print("Enter the number of Secret Santa participants: ");
        int numParticipants = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        List<String> participantsList = new ArrayList<>();

        // Manually add names based on the number of participants
        System.out.println("Enter names for Secret Santa participants:");
        for (int i = 0; i < numParticipants; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            String name = scanner.nextLine();
            participantsList.add(name);
        }

        List<Pair<String, String>> secretSantaPairs = generateSecretSanta(participantsList);

        System.out.println("\nSecret Santa pairings:");
        for (Pair<String, String> pair : secretSantaPairs) {
            System.out.println(pair.getFirst() + " is Secret Santa for " + pair.getSecond());
        }
    }

    static class Pair<T, U> {
        private final T first;
        private final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
    }
}

   
    

