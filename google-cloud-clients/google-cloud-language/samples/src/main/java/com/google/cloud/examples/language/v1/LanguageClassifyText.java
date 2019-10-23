/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// DO NOT EDIT! This is a generated sample ("Request",  "language_classify_text")
// sample-metadata:
//   title: Classify Content
//   description: Classifying Content in a String
//   usage: gradle run -PmainClass=com.google.cloud.examples.language.v1.LanguageClassifyText [--args='[--text_content "That actor on TV makes movies in Hollywood and also stars in a variety of popular new TV shows."]']

package com.google.cloud.examples.language.v1;

import com.google.cloud.language.v1.ClassificationCategory;
import com.google.cloud.language.v1.ClassifyTextRequest;
import com.google.cloud.language.v1.ClassifyTextResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.LanguageServiceClient;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class LanguageClassifyText {
  // [START language_classify_text]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.language.v1.ClassificationCategory;
   * import com.google.cloud.language.v1.ClassifyTextRequest;
   * import com.google.cloud.language.v1.ClassifyTextResponse;
   * import com.google.cloud.language.v1.Document;
   * import com.google.cloud.language.v1.LanguageServiceClient;
   */

  /**
   * Classifying Content in a String
   *
   * @param textContent The text content to analyze. Must include at least 20 words.
   */
  public static void sampleClassifyText(String textContent) {
    try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
      // textContent = "That actor on TV makes movies in Hollywood and also stars in a variety of popular new TV shows.";

      // Available types: PLAIN_TEXT, HTML
      Document.Type type = Document.Type.PLAIN_TEXT;

      // Optional. If not specified, the language is automatically detected.
      // For list of supported languages:
      // https://cloud.google.com/natural-language/docs/languages
      String language = "en";
      Document document =
          Document.newBuilder().setContent(textContent).setType(type).setLanguage(language).build();
      ClassifyTextRequest request = ClassifyTextRequest.newBuilder().setDocument(document).build();
      ClassifyTextResponse response = languageServiceClient.classifyText(request);
      // Loop through classified categories returned from the API
      for (ClassificationCategory category : response.getCategoriesList()) {
        // Get the name of the category representing the document.
        // See the predefined taxonomy of categories:
        // https://cloud.google.com/natural-language/docs/categories
        System.out.printf("Category name: %s\n", category.getName());
        // Get the confidence. Number representing how certain the classifier
        // is that this category represents the provided text.
        System.out.printf("Confidence: %s\n", category.getConfidence());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END language_classify_text]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("text_content").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String textContent =
        cl.getOptionValue(
            "text_content",
            "That actor on TV makes movies in Hollywood and also stars in a variety of popular new TV shows.");

    sampleClassifyText(textContent);
  }
}
