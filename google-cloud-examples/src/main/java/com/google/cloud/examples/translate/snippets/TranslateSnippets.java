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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in Translate's javadoc. Any change to this file should be reflected in
 * Translate's javadoc.
 */

package com.google.cloud.examples.translate.snippets;

import com.google.cloud.translate.Detection;
import com.google.cloud.translate.Language;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.LanguageListOption;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.util.LinkedList;
import java.util.List;

/**
 * This class contains a number of snippets for the {@link Translate} interface.
 */
public class TranslateSnippets {

  private final Translate translate;

  public TranslateSnippets(Translate translate) {
    this.translate = translate;
  }

  /**
   * Example of listing supported languages, localized according to
   * {@link TranslateOptions#getTargetLanguage()}.
   */
  // [TARGET listSupportedLanguages(LanguageListOption...)]
  public List<Language> listSupportedLanguages() {
    // [START listSupportedLanguages]
    List<Language> languages = translate.listSupportedLanguages();
    // [END listSupportedLanguages]
    return languages;
  }

  /**
   * Example of listing supported languages, localized according to a provided language.
   */
  // [TARGET listSupportedLanguages(LanguageListOption...)]
  public List<Language> listSupportedLanguagesWithTarget() {
    // [START listSupportedLanguagesWithTarget]
    List<Language> languages = translate.listSupportedLanguages(
        LanguageListOption.targetLanguage("es"));
    // [END listSupportedLanguagesWithTarget]
    return languages;
  }

  /**
   * Example of detecting the language of some texts.
   */
  // [TARGET detect(List)]
  public List<Detection> detectLanguageOfTextList() {
    // [START detectLanguageOfTextList]
    List<String> texts = new LinkedList<>();
    texts.add("Hello, World!");
    texts.add("¡Hola Mundo!");
    List<Detection> detections = translate.detect(texts);
    // [END detectLanguageOfTextList]
    return detections;
  }

  /**
   * Example of detecting the language of some texts.
   */
  // [TARGET detect(String...)]
  public List<Detection> detectLanguageOfTexts() {
    // [START detectLanguageOfTexts]
    List<Detection> detections = translate.detect("Hello, World!", "¡Hola Mundo!");
    // [END detectLanguageOfTexts]
    return detections;
  }

  /**
   * Example of detecting the language of a text.
   */
  // [TARGET detect(String)]
  public Detection detectLanguageOfText() {
    // [START detect]
    Detection detection = translate.detect("Hello, World!");
    // [END detect]
    return detection;
  }

  /**
   * Example of translating some texts.
   */
  // [TARGET translate(List, TranslateOption...)]
  public List<Translation> translateTexts() {
    // [START translateTexts]
    List<String> texts = new LinkedList<>();
    texts.add("Hello, World!");
    texts.add("¡Hola Mundo!");
    List<Translation> translations = translate.translate(texts);
    // [END translateTexts]
    return translations;
  }

  /**
   * Example of translating some texts, specifying source and target language.
   */
  // [TARGET translate(List, TranslateOption...)]
  public List<Translation> translateTextsWithOptions() {
    // [START translateTextsWithOptions]
    List<String> texts = new LinkedList<>();
    texts.add("¡Hola Mundo!");
    List<Translation> translations = translate.translate(texts,
        TranslateOption.sourceLanguage("es"), TranslateOption.targetLanguage("de"));
    // [END translateTextsWithOptions]
    return translations;
  }

  /**
   * Example of translating a text.
   */
  // [TARGET translate(String, TranslateOption...)]
  public Translation translateText() {
    // [START translateText]
    Translation translation = translate.translate("¡Hola Mundo!");
    // [END translateText]
    return translation;
  }

  /**
   * Example of translating a text, specifying source and target language.
   */
  // [TARGET translate(String, TranslateOption...)]
  public Translation translateTextWithOptions() {
    // [START translateTextWithOptions]
    Translation translation = translate.translate("¡Hola Mundo!",
        TranslateOption.sourceLanguage("es"), TranslateOption.targetLanguage("de"));
    // [END translateTextWithOptions]
    return translation;
  }
}
