package com.example.translateapp;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEnglish;
    private TextView textViewTranslation;
    private Button buttonTranslate, buttonSpeak;

    private TextToSpeech textToSpeech;

    private static final String API_KEY = "YOUR_GOOGLE_API_KEY";  // Replace with your Google API key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEnglish = findViewById(R.id.editTextEnglish);
        textViewTranslation = findViewById(R.id.textViewTranslation);
        buttonTranslate = findViewById(R.id.buttonTranslate);
        buttonSpeak = findViewById(R.id.buttonSpeak);

        // Initialize TextToSpeech
        textToSpeech = new TextToSpeech(this, new OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int langResult = textToSpeech.setLanguage(Locale.JAPAN);
                    if (langResult == TextToSpeech.LANG_MISSING_DATA
                            || langResult == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported or missing data");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        // Translate Button Click
        buttonTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String englishText = editTextEnglish.getText().toString();
                if (!englishText.isEmpty()) {
                    translateText(englishText);
                }
            }
        });

        // Speak Button Click
        buttonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String japaneseTranslation = textViewTranslation.getText().toString();
                if (!japaneseTranslation.isEmpty()) {
                    speakText(japaneseTranslation);
                }
            }
        });
    }

    private void translateText(String englishText) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://translation.googleapis.com/language/translate/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GoogleTranslateService translateService = retrofit.create(GoogleTranslateService.class);

        Call<TranslateResponse> call = translateService.translate(API_KEY, englishText, "en", "ja");
        call.enqueue(new Callback<TranslateResponse>() {
            @Override
            public void onResponse(Call<TranslateResponse> call, Response<TranslateResponse> response) {
                if (response.isSuccessful()) {
                    TranslateResponse translateResponse = response.body();
                    String translatedText = translateResponse.getData().getTranslations().get(0).getTranslatedText();
                    textViewTranslation.setText(translatedText);
                }
            }

            @Override
            public void onFailure(Call<TranslateResponse> call, Throwable t) {
                Log.e("Translate", "Translation failed", t);
            }
        });
    }

    private void speakText(String text) {
        if (textToSpeech != null) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}
