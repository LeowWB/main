package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.KeyboardFlashCards;
import seedu.address.model.ReadOnlyKeyboardFlashCards;
import seedu.address.model.category.Category;
import seedu.address.model.deadline.Deadline;
import seedu.address.model.deadline.DueDate;
import seedu.address.model.deadline.Task;
import seedu.address.model.flashcard.Answer;
import seedu.address.model.flashcard.FlashCard;
import seedu.address.model.flashcard.Question;
import seedu.address.model.flashcard.Rating;

/**
 * Contains utility methods for populating {@code KeyboardFlashCards} with sample data.
 */
public class SampleDataUtil {
    public static FlashCard[] getSampleFlashcards() {
        return new FlashCard[] {
            new FlashCard(new Question("What is pointer in C ?"),
                    new Answer("A pointer variable stores the address of a memory location"),
                new Rating("easy"),
                getCategorySet("CS2100", "C", "POINTER")),
            new FlashCard(new Question("How to declare a pointer in C ?"),
                    new Answer("& + variable name"),
                    new Rating("easy"),
                getCategorySet("CS2100")),
            new FlashCard(new Question("What is internet "),
                    new Answer("The Internet is a network of connected computing devices"),
                    new Rating("easy"),
                getCategorySet("CS2105")),
            new FlashCard(new Question("How is data transmitted through net?"),
                    new Answer("Circuit switching / Packet switching"),
                new Rating("good"),
                getCategorySet()),
            new FlashCard(new Question("What is link transmission rate?"),
                    new Answer("It is aka link capacity or link bandwidth"),
                new Rating("easy"),
                getCategorySet())
        };
    }

    public static Deadline[] getSampleDeadline() {
        return new Deadline[]{
            new Deadline(new Task("CS2103 Final Project Submission"),
                        new DueDate("10/11/2019")),
            new Deadline(new Task("CS2101 User Guide Submission"),
                        new DueDate("12/11/2019"))
        };
    }

    public static ReadOnlyKeyboardFlashCards getSampleAddressBook() {
        KeyboardFlashCards sampleAb = new KeyboardFlashCards();
        for (FlashCard sampleFlashCard : getSampleFlashcards()) {
            sampleAb.addFlashcard(sampleFlashCard);
        }
        for (Deadline sampleDeadline: getSampleDeadline()) {
            sampleAb.addDeadline(sampleDeadline);
        }
        return sampleAb;
    }

    /**
     * Returns a category set containing the list of strings given.
     */
    public static Set<Category> getCategorySet(String... strings) {
        return Arrays.stream(strings)
                .map(Category::new)
                .collect(Collectors.toSet());
    }

}
