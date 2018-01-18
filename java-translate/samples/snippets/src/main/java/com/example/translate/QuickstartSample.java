/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.translate;

// [START translate_quickstart]
// Imports the Google Cloud client library
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class QuickstartSample {
  public static void main(String... args) throws Exception {
    // Instantiates a client
    Translate translate = TranslateOptions.getDefaultInstance().getService();

    // The text to translate
    String text = "Hello, world!";

    // Translates some text into Russian
    Translation translation =
        translate.translate(
            text,
            TranslateOption.sourceLanguage("en"),
            TranslateOption.targetLanguage("ru"));


    System.out.printf("Text: %s%n", text);
    System.out.printf("Translation: %s%n", translation.getTranslatedText());
  }
}
// [END translate_quickstart]
