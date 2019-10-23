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
// DO NOT EDIT! This is a generated sample ("Request",  "language_entity_sentiment_text")
// sample-metadata:
//   title: Analyzing Entity Sentiment
//   description: Analyzing Entity Sentiment in a String
//   usage: gradle run -PmainClass=com.google.cloud.examples.language.v1.LanguageEntitySentimentText [--args='[--text_content "Grapes are good. Bananas are bad."]']

package com.google.cloud.examples.language.v1;

import com.google.cloud.language.v1.AnalyzeEntitySentimentRequest;
import com.google.cloud.language.v1.AnalyzeEntitySentimentResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.Entity;
import com.google.cloud.language.v1.EntityMention;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import java.util.Map;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class LanguageEntitySentimentText {
  // [START language_entity_sentiment_text]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.language.v1.AnalyzeEntitySentimentRequest;
   * import com.google.cloud.language.v1.AnalyzeEntitySentimentResponse;
   * import com.google.cloud.language.v1.Document;
   * import com.google.cloud.language.v1.EncodingType;
   * import com.google.cloud.language.v1.Entity;
   * import com.google.cloud.language.v1.EntityMention;
   * import com.google.cloud.language.v1.LanguageServiceClient;
   * import com.google.cloud.language.v1.Sentiment;
   * import java.util.Map;
   */

  /**
   * Analyzing Entity Sentiment in a String
   *
   * @param textContent The text content to analyze
   */
  public static void sampleAnalyzeEntitySentiment(String textContent) {
    try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
      // textContent = "Grapes are good. Bananas are bad.";

      // Available types: PLAIN_TEXT, HTML
      Document.Type type = Document.Type.PLAIN_TEXT;

      // Optional. If not specified, the language is automatically detected.
      // For list of supported languages:
      // https://cloud.google.com/natural-language/docs/languages
      String language = "en";
      Document document =
          Document.newBuilder().setContent(textContent).setType(type).setLanguage(language).build();

      // Available values: NONE, UTF8, UTF16, UTF32
      EncodingType encodingType = EncodingType.UTF8;
      AnalyzeEntitySentimentRequest request =
          AnalyzeEntitySentimentRequest.newBuilder()
              .setDocument(document)
              .setEncodingType(encodingType)
              .build();
      AnalyzeEntitySentimentResponse response =
          languageServiceClient.analyzeEntitySentiment(request);
      // Loop through entitites returned from the API
      for (Entity entity : response.getEntitiesList()) {
        System.out.printf("Representative name for the entity: %s\n", entity.getName());
        // Get entity type, e.g. PERSON, LOCATION, ADDRESS, NUMBER, et al
        System.out.printf("Entity type: %s\n", entity.getType());
        // Get the salience score associated with the entity in the [0, 1.0] range
        System.out.printf("Salience score: %s\n", entity.getSalience());
        // Get the aggregate sentiment expressed for this entity in the provided document.
        Sentiment sentiment = entity.getSentiment();
        System.out.printf("Entity sentiment score: %s\n", sentiment.getScore());
        System.out.printf("Entity sentiment magnitude: %s\n", sentiment.getMagnitude());
        // Loop over the metadata associated with entity. For many known entities,
        // the metadata is a Wikipedia URL (wikipedia_url) and Knowledge Graph MID (mid).
        // Some entity types may have additional metadata, e.g. ADDRESS entities
        // may have metadata for the address street_name, postal_code, et al.
        for (Map.Entry<String, String> entry : entity.getMetadataMap().entrySet()) {
          String metadataName = entry.getKey();
          String metadataValue = entry.getValue();
          System.out.printf("%s = %s\n", metadataName, metadataValue);
        }

        // Loop over the mentions of this entity in the input document.
        // The API currently supports proper noun mentions.
        for (EntityMention mention : entity.getMentionsList()) {
          System.out.printf("Mention text: %s\n", mention.getText().getContent());
          // Get the mention type, e.g. PROPER for proper noun
          System.out.printf("Mention type: %s\n", mention.getType());
        }
      }
      // Get the language of the text, which will be the same as
      // the language specified in the request or, if not specified,
      // the automatically-detected language.
      System.out.printf("Language of the text: %s\n", response.getLanguage());
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END language_entity_sentiment_text]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("text_content").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String textContent = cl.getOptionValue("text_content", "Grapes are good. Bananas are bad.");

    sampleAnalyzeEntitySentiment(textContent);
  }
}
