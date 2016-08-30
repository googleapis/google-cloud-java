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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in READMEs and javadoc. Any change to this file should be reflected in
 * the project's READMEs and package-info.java.
 */

package com.google.cloud.examples.translate.snippets;

import com.google.cloud.translate.Detection;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

/**
 * A snippet for Google Translate showing how to detect the language of some text and translate
 * some other text.
 */
public class DetectLanguageAndTranslate {

  public static void main(String... args) {
    // Create a service object
    // API key is read from the GOOGLE_API_KEY environment variable
    Translate translate = TranslateOptions.defaultInstance().service();

    // Detect the language of some text
    Detection detection = translate.detect("Hola");
    String detectedLanguage = detection.language();

    // Translate some text
    Translation translation = translate.translate(
        "World",
        TranslateOption.sourceLanguage("en"),
        TranslateOption.targetLanguage(detectedLanguage));

    System.out.printf("Hola %s%n", translation.translatedText());
  }
}
