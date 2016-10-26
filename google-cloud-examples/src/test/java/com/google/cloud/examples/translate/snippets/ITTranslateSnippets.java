/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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
import com.google.cloud.translate.Translation;
import com.google.cloud.translate.testing.RemoteTranslateHelper;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ITTranslateSnippets {

  private static TranslateSnippets translateSnippets;

  private static final String[] LANGUAGES = {"af", "sq", "ar", "hy", "az", "eu", "be", "bn", "bs",
      "bg", "ca", "ceb", "ny", "zh-TW", "hr", "cs", "da", "nl", "en", "eo", "et", "tl", "fi", "fr",
      "gl", "ka", "de", "el", "gu", "ht", "ha", "iw", "hi", "hmn", "hu", "is", "ig", "id", "ga",
      "it", "ja", "jw", "kn", "kk", "km", "ko", "lo", "la", "lv", "lt", "mk", "mg", "ms", "ml",
      "mt", "mi", "mr", "mn", "my", "ne", "no", "fa", "pl", "pt", "ro", "ru", "sr", "st", "si",
      "sk", "sl", "so", "es", "su", "sw", "sv", "tg", "ta", "te", "th", "tr", "uk", "ur", "uz",
      "vi", "cy", "yi", "yo", "zu"};

  @BeforeClass
  public static void beforeClass() {
    RemoteTranslateHelper helper = RemoteTranslateHelper.create();
    translateSnippets = new TranslateSnippets(helper.getOptions().service());
  }

  @Test
  public void testListSupportedLanguages() {
    Set<String> supportedLanguages = new HashSet<>();
    List<Language> languages = translateSnippets.listSupportedLanguages();
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
    Set<String> supportedLanguages = new HashSet<>();
    List<Language> languages = translateSnippets.listSupportedLanguagesWithTarget();
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
    List<Detection> detections = translateSnippets.detectLanguageOfTexts();
    Detection detection = detections.get(0);
    assertEquals("en", detection.getLanguage());
    detection = detections.get(1);
    assertEquals("es", detection.getLanguage());
  }

  @Test
  public void testDetectLanguageOfTextList() {
    List<Detection> detections = translateSnippets.detectLanguageOfTextList();
    Detection detection = detections.get(0);
    assertEquals("en", detection.getLanguage());
    detection = detections.get(1);
    assertEquals("es", detection.getLanguage());
  }

  @Test
  public void testDetectLanguageOfText() {
    Detection detection = translateSnippets.detectLanguageOfText();
    assertEquals("en", detection.getLanguage());
  }

  @Test
  public void testTranslateTextList() {
    List<Translation> translations = translateSnippets.translateTexts();
    Translation translation = translations.get(0);
    assertEquals("Hello, World!", translation.getTranslatedText());
    assertEquals("en", translation.getSourceLanguage());
    translation = translations.get(1);
    assertEquals("Hello World!", translation.getTranslatedText());
    assertEquals("es", translation.getSourceLanguage());
  }

  @Test
  public void testTranslateText() {
    Translation translation = translateSnippets.translateText();
    assertEquals("Hello World!", translation.getTranslatedText());
    assertEquals("es", translation.getSourceLanguage());
  }

  @Test
  public void testTranslateTextWithOptions() {
    Translation translation = translateSnippets.translateTextWithOptions();
    assertEquals("Hallo Welt!", translation.getTranslatedText());
    assertEquals("es", translation.getSourceLanguage());
  }
}
