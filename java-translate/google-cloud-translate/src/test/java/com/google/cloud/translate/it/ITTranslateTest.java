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

package com.google.cloud.translate.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.translate.Detection;
import com.google.cloud.translate.Language;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.LanguageListOption;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.cloud.translate.testing.RemoteTranslateHelper;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.junit.Test;

public class ITTranslateTest {

  private static final Translate TRANSLATE =
      RemoteTranslateHelper.create().getOptions().getService();
  private static final String[] LANGUAGES = {
    "af", "sq", "ar", "hy", "az", "eu", "be", "bn", "bs", "bg", "ca", "ceb", "ny", "zh-TW", "hr",
    "cs", "da", "nl", "en", "eo", "et", "tl", "fi", "fr", "gl", "ka", "de", "el", "gu", "ht", "ha",
    "iw", "hi", "hmn", "hu", "is", "ig", "id", "ga", "it", "ja", "jw", "kn", "kk", "km", "ko", "lo",
    "la", "lv", "lt", "mk", "mg", "ms", "ml", "mt", "mi", "mr", "mn", "my", "ne", "no", "fa", "pl",
    "pt", "ro", "ru", "sr", "st", "si", "sk", "sl", "so", "es", "su", "sw", "sv", "tg", "ta", "te",
    "th", "tr", "uk", "ur", "uz", "vi", "cy", "yi", "yo", "zu"
  };
  private static final String API_KEY = "api_key";

  @Test
  public void testListSupportedLanguages() {
    Set<String> supportedLanguages = new HashSet<>();
    List<Language> languages = TRANSLATE.listSupportedLanguages();
    for (Language language : languages) {
      supportedLanguages.add(language.getCode());
      assertNotNull(language.getName());
    }
    for (String code : LANGUAGES) {
      assertTrue(supportedLanguages.contains(code));
    }
  }

  @Test
  public void testListSupportedLanguagesWithOptions() {
    Set<String> supportedLanguages = new HashSet<>();
    List<Language> languages =
        TRANSLATE.listSupportedLanguages(LanguageListOption.targetLanguage("es"));
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
    List<Detection> detections = TRANSLATE.detect("Hello", "Hallo");
    Detection detection = detections.get(0);
    assertEquals("en", detection.getLanguage());
    detection = detections.get(1);
    assertEquals("de", detection.getLanguage());
  }

  @Test
  public void testDetectLanguageOfTextList() {
    List<Detection> detections = TRANSLATE.detect(ImmutableList.of("Hello", "Hallo"));
    Detection detection = detections.get(0);
    assertEquals("en", detection.getLanguage());
    detection = detections.get(1);
    assertEquals("de", detection.getLanguage());
  }

  @Test
  public void testDetectLanguageOfText() {
    Detection detection = TRANSLATE.detect("Hello");
    assertEquals("en", detection.getLanguage());
  }

  @Test
  public void testTranslateTextList() {
    List<Translation> translations = TRANSLATE.translate(ImmutableList.of("ocho", "acht"));
    Translation translation = translations.get(0);
    assertEquals("eight", translation.getTranslatedText().toLowerCase(Locale.ENGLISH));
    assertEquals("es", translation.getSourceLanguage());
    translation = translations.get(1);
    assertEquals("act", translation.getTranslatedText().toLowerCase(Locale.ENGLISH));
    assertEquals("ga", translation.getSourceLanguage());
  }

  @Test
  public void testTranslateTextListWithModel() {
    List<Translation> translations =
        TRANSLATE.translate(ImmutableList.of("ocho", "acht"), TranslateOption.model("nmt"));
    Translation translation = translations.get(0);
    assertEquals("eight", translation.getTranslatedText().toLowerCase(Locale.ENGLISH));
    assertEquals("es", translation.getSourceLanguage());
    assertEquals("nmt", translation.getModel());
    translation = translations.get(1);
    assertEquals("act", translation.getTranslatedText().toLowerCase(Locale.ENGLISH));
    assertEquals("ga", translation.getSourceLanguage());
    assertEquals("nmt", translation.getModel());
  }

  @Test
  public void testTranslateText() {
    Translation translation = TRANSLATE.translate("ocho");
    assertEquals("eight", translation.getTranslatedText().toLowerCase(Locale.ENGLISH));
    assertEquals("es", translation.getSourceLanguage());
  }

  @Test
  public void testTranslateTextWithOptions() {
    Translation translation =
        TRANSLATE.translate(
            "Hola", TranslateOption.sourceLanguage("es"), TranslateOption.targetLanguage("de"));
    assertEquals("Hallo", translation.getTranslatedText());
    assertEquals("es", translation.getSourceLanguage());
  }

  @Test
  public void testApiKeyOverridesDefaultCredentials() {
    TranslateOptions options = RemoteTranslateHelper.create(API_KEY).getOptions();
    assertNull(options.getCredentials());
    assertEquals(options.getApiKey(), API_KEY);
  }

  @Test
  public void testDefaultCredentialsOverridesDefaultApiKey() {
    TranslateOptions options = RemoteTranslateHelper.create().getOptions();
    assertNotNull(options.getCredentials());
    assertNull(options.getApiKey());
  }

  @Test
  public void testTranslateTextWithApiKey() {
    Translate translate = RemoteTranslateHelper.create().getOptions().getService();
    Translation translation = translate.translate("ocho");
    assertEquals("eight", translation.getTranslatedText().toLowerCase(Locale.ENGLISH));
    assertEquals("es", translation.getSourceLanguage());
  }
}
