/*
 * Copyright 2017 Google Inc.
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

package beta.example.language;

import com.example.language.Analyze;
import com.google.cloud.language.v1beta2.AnalyzeSentimentResponse;
import com.google.cloud.language.v1beta2.ClassificationCategory;
import com.google.cloud.language.v1beta2.ClassifyTextRequest;
import com.google.cloud.language.v1beta2.ClassifyTextResponse;
import com.google.cloud.language.v1beta2.Document;
import com.google.cloud.language.v1beta2.Document.Type;
import com.google.cloud.language.v1beta2.LanguageServiceClient;
import com.google.cloud.language.v1beta2.Sentiment;

/**
 * A sample application that uses the Natural Language API to perform entity, sentiment and syntax
 * analysis.
 */
public class AnalyzeBeta {

  /** Detects entities,sentiment and syntax in a document using the Natural Language API. */
  public static void main(String[] args) throws Exception {
    if (args.length < 2 || args.length > 4) {
      System.err.println("Usage:");
      System.err.printf(
          "\tjava %s \"command\" \"text to analyze\" \"language\" \n",
          Analyze.class.getCanonicalName());
      System.exit(1);
    }
    String command = args[0];
    String text = args[1];
    String lang = null;
    if (args.length > 2) {
      lang = args[2];
    }

    if (command.equals("classify")) {
      if (text.startsWith("gs://")) {
        classifyFile(text);
      } else {
        classifyText(text);
      }
    } else if (command.equals("sentiment")) {
      analyzeSentimentText(text, lang);
    }
  }

  /** Detects sentiments from the string {@code text}. */
  public static Sentiment analyzeSentimentText(String text, String lang) throws Exception {
    // [START beta_sentiment_text]
    // Instantiate a beta client : com.google.cloud.language.v1beta2.LanguageServiceClient
    try (LanguageServiceClient language = LanguageServiceClient.create()) {
      // NL auto-detects the language, if not provided
      Document doc;
      if (lang != null) {
        doc =
            Document.newBuilder()
                .setLanguage(lang)
                .setContent(text)
                .setType(Type.PLAIN_TEXT)
                .build();
      } else {
        doc = Document.newBuilder().setContent(text).setType(Type.PLAIN_TEXT).build();
      }
      AnalyzeSentimentResponse response = language.analyzeSentiment(doc);
      Sentiment sentiment = response.getDocumentSentiment();
      if (sentiment != null) {
        System.out.println("Found sentiment.");
        System.out.printf("\tMagnitude: %.3f\n", sentiment.getMagnitude());
        System.out.printf("\tScore: %.3f\n", sentiment.getScore());
      } else {
        System.out.println("No sentiment found");
      }
      return sentiment;
    }
    // [END beta_sentiment_text]
  }

  /** Detects categories in text using the Language Beta API. */
  public static void classifyText(String text) throws Exception {
    // [START classify_text]
    // Instantiate a beta client : com.google.cloud.language.v1beta2.LanguageServiceClient
    try (LanguageServiceClient language = LanguageServiceClient.create()) {
      // set content to the text string
      Document doc = Document.newBuilder().setContent(text).setType(Type.PLAIN_TEXT).build();
      ClassifyTextRequest request = ClassifyTextRequest.newBuilder().setDocument(doc).build();
      // detect categories in the given text
      ClassifyTextResponse response = language.classifyText(request);

      for (ClassificationCategory category : response.getCategoriesList()) {
        System.out.printf(
            "Category name : %s, Confidence : %.3f\n",
            category.getName(), category.getConfidence());
      }
    }
    // [END classify_text]
  }

  /** Detects categories in a GCS hosted file using the Language Beta API. */
  public static void classifyFile(String gcsUri) throws Exception {
    // [START classify_file]
    // Instantiate a beta client : com.google.cloud.language.v1beta2.LanguageServiceClient
    try (LanguageServiceClient language = LanguageServiceClient.create()) {
      // set the GCS content URI path
      Document doc =
          Document.newBuilder().setGcsContentUri(gcsUri).setType(Type.PLAIN_TEXT).build();
      ClassifyTextRequest request = ClassifyTextRequest.newBuilder().setDocument(doc).build();
      // detect categories in the given file
      ClassifyTextResponse response = language.classifyText(request);

      for (ClassificationCategory category : response.getCategoriesList()) {
        System.out.printf(
            "Category name : %s, Confidence : %.3f\n",
            category.getName(), category.getConfidence());
      }
    }
    // [END classify_file]
  }
}
