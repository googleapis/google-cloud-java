/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.examples.translate.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.translate.Detection;
import com.google.cloud.translate.Language;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translation;
import com.google.cloud.translate.testing.RemoteTranslateHelper;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class contains a number of snippets for the {@link Translate} interface.
 *
 * <p>After modifying snippets in this file, run {@code ./utilities/snippets
 * ./google-cloud-examples/src/test/java/com/google/cloud/examples/translate/snippets/ITTranslateSnippets.java
 * ./google-cloud-clients/google-cloud-translate/src/main/java/com/google/cloud/translate/Translate.java}
 * to include the snippets in the Javadoc.
 */
public class ITTranslateSnippets {

  private static Translate translate;

  private static final String[] LANGUAGES = {
    "af", "sq", "ar", "hy", "az", "eu", "be", "bn", "bs", "bg", "ca", "ceb", "ny", "zh-TW", "hr",
    "cs", "da", "nl", "en", "eo", "et", "tl", "fi", "fr", "gl", "ka", "de", "el", "gu", "ht", "ha",
    "iw", "hi", "hmn", "hu", "is", "ig", "id", "ga", "it", "ja", "jw", "kn", "kk", "km", "ko", "lo",
    "la", "lv", "lt", "mk", "mg", "ms", "ml", "mt", "mi", "mr", "mn", "my", "ne", "no", "fa", "pl",
    "pt", "ro", "ru", "sr", "st", "si", "sk", "sl", "so", "es", "su", "sw", "sv", "tg", "ta", "te",
    "th", "tr", "uk", "ur", "uz", "vi", "cy", "yi", "yo", "zu"
  };

  @BeforeClass
  public static void beforeClass() {
    RemoteTranslateHelper helper = RemoteTranslateHelper.create();
    translate = helper.getOptions().getService();
  }

  @Test
  public void testListSupportedLanguages() {
    // [START translate_list_codes]
    // TODO(developer): Uncomment these lines.
    // import com.google.cloud.translate.*;
    // Translate translate = TranslateOptions.getDefaultInstance().getService();

    List<Language> languages = translate.listSupportedLanguages();

    for (Language language : languages) {
      System.out.printf("Name: %s, Code: %s\n", language.getName(), language.getCode());
    }
    // [END translate_list_codes]

    Set<String> supportedLanguages = new HashSet<>();
    for (Language language : languages) {
      supportedLanguages.add(language.getCode());
      assertNotNull(language.getName());
    }
    for (String code : LANGUAGES) {
      assertTrue(supportedLanguages.contains(code));
    }
  }

  @Test
  public void testListSupportedLanguagesWithTarget() {
    // [START translate_list_language_names]
    // TODO(developer): Uncomment these lines.
    // import com.google.cloud.translate.*;
    // Translate translate = TranslateOptions.getDefaultInstance().getService();

    List<Language> languages =
        translate.listSupportedLanguages(Translate.LanguageListOption.targetLanguage("es"));

    for (Language language : languages) {
      System.out.printf("Name: %s, Code: %s\n", language.getName(), language.getCode());
    }
    // [END translate_list_language_names]

    Set<String> supportedLanguages = new HashSet<>();
    for (Language language : languages) {
      supportedLanguages.add(language.getCode());
      assertNotNull(language.getName());
    }
    for (String code : LANGUAGES) {
      assertTrue(supportedLanguages.contains(code));
    }
  }

  @Test
  public void testDetectLanguageOfTexts() {
    // SNIPPET translate_detect_language_array
    List<Detection> detections = translate.detect("Hello, World!", "¡Hola Mundo!");
    // SNIPPET translate_detect_language_array

    Detection detection = detections.get(0);
    assertEquals("en", detection.getLanguage());
    detection = detections.get(1);
    assertEquals("es", detection.getLanguage());
  }

  @Test
  public void testDetectLanguageOfTextList() {
    // [START translate_detect_language]
    // TODO(developer): Uncomment these lines.
    // import com.google.cloud.translate.*;
    // Translate translate = TranslateOptions.getDefaultInstance().getService();

    List<String> texts = new LinkedList<>();
    texts.add("Hello, World!");
    texts.add("¡Hola Mundo!");
    List<Detection> detections = translate.detect(texts);

    System.out.println("Language(s) detected:");
    for (Detection detection : detections) {
      System.out.printf("\t%s\n", detection);
    }
    // [END translate_detect_language]

    Detection detection = detections.get(0);
    assertEquals("en", detection.getLanguage());
    detection = detections.get(1);
    assertEquals("es", detection.getLanguage());
  }

  @Test
  public void testDetectLanguageOfText() {
    // SNIPPET translate_detect_language_string
    Detection detection = translate.detect("Hello, World!");
    // SNIPPET translate_detect_language_string
    assertEquals("en", detection.getLanguage());
  }

  @Test
  public void testTranslateTextList() {
    // SNIPPET translateTexts
    List<String> texts = new LinkedList<>();
    texts.add("Hello, World!");
    texts.add("¡Hola Mundo!");
    List<Translation> translations = translate.translate(texts);
    // SNIPPET translateTexts

    Translation translation = translations.get(0);
    assertEquals("Hello, World!", translation.getTranslatedText());
    assertEquals("en", translation.getSourceLanguage());
    translation = translations.get(1);
    assertEquals("Hello World!", translation.getTranslatedText());
    assertEquals("es", translation.getSourceLanguage());
  }

  @Test
  public void testTranslateTextListWithOptions() {
    // SNIPPET translateTextsWithOptions
    List<String> texts = new LinkedList<>();
    texts.add("¡Hola Mundo!");
    List<Translation> translations =
        translate.translate(
            texts,
            Translate.TranslateOption.sourceLanguage("es"),
            Translate.TranslateOption.targetLanguage("de"));
    // SNIPPET translateTextsWithOptions
    Translation translation = translations.get(0);
    assertEquals("Hallo Welt!", translation.getTranslatedText());
    assertEquals("es", translation.getSourceLanguage());
  }

  @Test
  public void testTranslateText() {
    // [START translate_translate_text]
    // TODO(developer): Uncomment these lines.
    // import com.google.cloud.translate.*;
    // Translate translate = TranslateOptions.getDefaultInstance().getService();

    Translation translation = translate.translate("¡Hola Mundo!");
    System.out.printf("Translated Text:\n\t%s\n", translation.getTranslatedText());
    // [END translate_translate_text]
    assertEquals("Hello World!", translation.getTranslatedText());
    assertEquals("es", translation.getSourceLanguage());
  }

  @Test
  public void testTranslateTextWithModel() {
    // [START translate_text_with_model]
    Translation translation =
        translate.translate(
            "Hola Mundo!",
            Translate.TranslateOption.sourceLanguage("es"),
            Translate.TranslateOption.targetLanguage("de"),
            // Use "base" for standard edition, "nmt" for the premium model.
            Translate.TranslateOption.model("nmt"));

    System.out.printf("TranslatedText:\nText: %s\n", translation.getTranslatedText());
    // [END translate_text_with_model]
    assertEquals("Hallo Welt!", translation.getTranslatedText());
    assertEquals("es", translation.getSourceLanguage());
  }
}
