import pyttsx3
from googletrans import Translator

# Initialize the translator and pyttsx3 engine
translator = Translator()
engine = pyttsx3.init()

# Function to translate and return the English sentence, Japanese translation, and pronunciation
def translate_to_japanese(english_text):
    # Translate text to Japanese
    translation = translator.translate(english_text, src='en', dest='ja')
    japanese_translation = translation.text


    romanized_translation = translation.pronunciation if translation.pronunciation else "Pronunciation unavailable"

    return english_text, japanese_translation, romanized_translation

# Function to say the pronunciation using pyttsx3
def speak_pronunciation(pronunciation):
    engine.say(pronunciation)
    engine.runAndWait()

def main():
    # Input English sentence
    english_sentence = input("Enter an English sentence to translate into Japanese: ")

    # Get translation and pronunciation
    english, japanese, pronunciation = translate_to_japanese(english_sentence)

    # Display the output
    print("\n--- Translation Result ---")
    print(f"English: {english}")
    print(f"Japanese: {japanese}")
    print(f"Pronunciation: {pronunciation}")

    # Speak the pronunciation using pyttsx3
    print("\nNow speaking the pronunciation...")
    speak_pronunciation(pronunciation)
