

# JPTranslate - English to Japanese Translation with Pronunciation

**JPTranslate** is a Python-based tool that translates English text into Japanese and provides the pronunciation of the Japanese translation in romanized form (using `pyttsx3` to speak it out loud).

## Features:
- Translate English text to Japanese.
- Provide romanized pronunciation for the Japanese text.
- Use text-to-speech to say the pronunciation using `pyttsx3`.

## Prerequisites:
- Python 3.6 or later
- `googletrans` library for translation
- `pyttsx3` library for text-to-speech functionality
- Termux

## Installation:

### Clone the repository:
To get started, clone the repository using the following command:

```bash
git clone https://github.com/akishore15/jptranslate.git
```

### Install the required dependencies:
After cloning the repository, navigate to the project folder and install the necessary libraries using `pip`:

```bash
cd jptranslate
pip install googletrans==4.0.0-rc1 pyttsx3
```
## Usage:

1. After installing the dependencies, run the script `main.py`:

```bash
python3 translate.py
```

2. The program will prompt you to enter an English sentence that you want to translate into Japanese.
   
   Example:
   
   ```
   Enter an English sentence to translate into Japanese: Hello, how are you?
   ```

3. The program will show the translation along with the pronunciation in romanized form and will use `pyttsx3` to speak the pronunciation out loud.

   Example output:

   ```
   --- Translation Result ---
   English: Hello, how are you?
   Japanese: こんにちは、お元気ですか？
   Pronunciation: Konnichiwa, ogenki desu ka?

   Now speaking the pronunciation...
   ```

4. The pronunciation will be spoken using your system’s default text-to-speech engine.

## License:
This project is licensed under the GNU GPL License - see the [LICENSE](LICENSE) file for details.

## Contributing:
Feel free to fork this repository and submit issues or pull requests if you want to contribute. Any contributions are welcome!

## Acknowledgments:
- `googletrans` library for the translation functionality.
- `pyttsx3` library for the text-to-speech feature.

### How to Use:
1. Clone the repo.
2. Install the dependencies.
3. Run the Python script, and the translation with pronunciation will be spoken aloud.

This README provides clear instructions on how to set up and use your project on GitHub.
