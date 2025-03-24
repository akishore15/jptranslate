package com.example.translateapp;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TranslateResponse {

    @SerializedName("data")
    private TranslateData data;

    public TranslateData getData() {
        return data;
    }

    public static class TranslateData {
        @SerializedName("translations")
        private List<Translation> translations;

        public List<Translation> getTranslations() {
            return translations;
        }
    }

    public static class Translation {
        @SerializedName("translatedText")
        private String translatedText;

        public String getTranslatedText() {
            return translatedText;
        }
    }
}
