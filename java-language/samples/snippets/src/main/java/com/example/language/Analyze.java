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

package com.example.language;

import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1.AnalyzeEntitySentimentRequest;
import com.google.cloud.language.v1.AnalyzeEntitySentimentResponse;
import com.google.cloud.language.v1.AnalyzeSentimentResponse;
import com.google.cloud.language.v1.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1.ClassificationCategory;
import com.google.cloud.language.v1.ClassificationModelOptions;
import com.google.cloud.language.v1.ClassificationModelOptions.V2Model;
import com.google.cloud.language.v1.ClassificationModelOptions.V2Model.ContentCategoriesVersion;
import com.google.cloud.language.v1.ClassifyTextRequest;
import com.google.cloud.language.v1.ClassifyTextResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.Entity;
import com.google.cloud.language.v1.EntityMention;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import com.google.cloud.language.v1.Token;
import java.util.List;
import java.util.Map;

/**
 * A sample application that uses the Natural Language API to perform entity, sentiment and syntax
 * analysis.
 */
public class Analyze {

  /** Detects entities,sentiment and syntax in a document using the Natural Language API. */
  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage:");
      System.err.printf(
          "\tjava %s \"command\" \"text to analyze\"\n", Analyze.class.getCanonicalName());
      System.exit(1);
    }
    String command = args[0];
    String text = args[1];

    if (command.equals("classify")) {
      if (text.startsWith("gs://")) {
        classifyFile(text);
      } else {
        classifyText(text);
      }
    } else if (command.equals("entities")) {
      if (text.startsWith("gs://")) {
        analyzeEntitiesFile(text);
      } else {
        analyzeEntitiesText(text);
      }
    } else if (command.equals("sentiment")) {
      if (text.startsWith("gs://")) {
        analyzeSentimentFile(text);
      } else {
        analyzeSentimentText(text);
      }
    } else if (command.equals("syntax")) {
      if (text.startsWith("gs://")) {
        analyzeSyntaxFile(text);
      } else {
        analyzeSyntaxText(text);
      }
    } else if (command.equals("entities-sentiment")) {
      if (text.startsWith("gs://")) {
        entitySentimentFile(text);
      } else {
        entitySentimentText(text);
      }
    }
  }

  /** Identifies entities in the string {@code text}. */
  public static void analyzeEntitiesText(String text) throws Exception {
    // [START language_entities_text]
    // Instantiate the Language client com.google.cloud.language.v1.LanguageServiceClient
    try (LanguageServiceClient language = LanguageServiceClient.create()) {
      Document doc = Document.newBuilder().setContent(text).setType(Type.PLAIN_TEXT).build();
      AnalyzeEntitiesRequest request =
          AnalyzeEntitiesRequest.newBuilder()
              .setDocument(doc)
              .setEncodingType(EncodingType.UTF16)
              .build();

      AnalyzeEntitiesResponse response = language.analyzeEntities(request);

      // Print the response
      for (Entity entity : response.getEntitiesList()) {
        System.out.printf("Entity: %s", entity.getName());
        System.out.printf("Salience: %.3f\n", entity.getSalience());
        System.out.println("Metadata: ");
        for (Map.Entry<String, String> entry : entity.getMetadataMap().entrySet()) {
          System.out.printf("%s : %s", entry.getKey(), entry.getValue());
        }
        for (EntityMention mention : entity.getMentionsList()) {
          System.out.printf("Begin offset: %d\n", mention.getText().getBeginOffset());
          System.out.printf("Content: %s\n", mention.getText().getContent());
          System.out.printf("Type: %s\n\n", mention.getType());
        }
      }
    }
    // [END language_entities_text]
  }

  /** Identifies entities in the contents of the object at the given GCS {@code path}. */
  public static void analyzeEntitiesFile(String gcsUri) throws Exception {
    // [START language_entities_gcs]
    // Instantiate the Language client com.google.cloud.language.v1.LanguageServiceClient
    try (LanguageServiceClient language = LanguageServiceClient.create()) {
      // Set the GCS Content URI path to the file to be analyzed
      Document doc =
          Document.newBuilder().setGcsContentUri(gcsUri).setType(Type.PLAIN_TEXT).build();
      AnalyzeEntitiesRequest request =
          AnalyzeEntitiesRequest.newBuilder()
              .setDocument(doc)
              .setEncodingType(EncodingType.UTF16)
              .build();

      AnalyzeEntitiesResponse response = language.analyzeEntities(request);

      // Print the response
      for (Entity entity : response.getEntitiesList()) {
        System.out.printf("Entity: %s\n", entity.getName());
        System.out.printf("Salience: %.3f\n", entity.getSalience());
        System.out.println("Metadata: ");
        for (Map.Entry<String, String> entry : entity.getMetadataMap().entrySet()) {
          System.out.printf("%s : %s", entry.getKey(), entry.getValue());
        }
        for (EntityMention mention : entity.getMentionsList()) {
          System.out.printf("Begin offset: %d\n", mention.getText().getBeginOffset());
          System.out.printf("Content: %s\n", mention.getText().getContent());
          System.out.printf("Type: %s\n\n", mention.getType());
        }
      }
    }
    // [END language_entities_gcs]
  }

  /** Identifies the sentiment in the string {@code text}. */
  public static Sentiment analyzeSentimentText(String text) throws Exception {
    // [START language_sentiment_text]
    // Instantiate the Language client com.google.cloud.language.v1.LanguageServiceClient
    try (LanguageServiceClient language = LanguageServiceClient.create()) {
      Document doc = Document.newBuilder().setContent(text).setType(Type.PLAIN_TEXT).build();
      AnalyzeSentimentResponse response = language.analyzeSentiment(doc);
      Sentiment sentiment = response.getDocumentSentiment();
      if (sentiment == null) {
        System.out.println("No sentiment found");
      } else {
        System.out.printf("Sentiment magnitude: %.3f\n", sentiment.getMagnitude());
        System.out.printf("Sentiment score: %.3f\n", sentiment.getScore());
      }
      return sentiment;
    }
    // [END language_sentiment_text]
  }

  /** Gets {@link Sentiment} from the contents of the GCS hosted file. */
  public static Sentiment analyzeSentimentFile(String gcsUri) throws Exception {
    // [START language_sentiment_gcs]
    // Instantiate the Language client com.google.cloud.language.v1.LanguageServiceClient
    try (LanguageServiceClient language = LanguageServiceClient.create()) {
      Document doc =
          Document.newBuilder().setGcsContentUri(gcsUri).setType(Type.PLAIN_TEXT).build();
      AnalyzeSentimentResponse response = language.analyzeSentiment(doc);
      Sentiment sentiment = response.getDocumentSentiment();
      if (sentiment == null) {
        System.out.println("No sentiment found");
      } else {
        System.out.printf("Sentiment magnitude : %.3f\n", sentiment.getMagnitude());
        System.out.printf("Sentiment score : %.3f\n", sentiment.getScore());
      }
      return sentiment;
    }
    // [END language_sentiment_gcs]
  }

  /** from the string {@code text}. */
  public static List<Token> analyzeSyntaxText(String text) throws Exception {
    // [START language_syntax_text]
    // Instantiate the Language client com.google.cloud.language.v1.LanguageServiceClient
    try (LanguageServiceClient language = LanguageServiceClient.create()) {
      Document doc = Document.newBuilder().setContent(text).setType(Type.PLAIN_TEXT).build();
      AnalyzeSyntaxRequest request =
          AnalyzeSyntaxRequest.newBuilder()
              .setDocument(doc)
              .setEncodingType(EncodingType.UTF16)
              .build();
      // Analyze the syntax in the given text
      AnalyzeSyntaxResponse response = language.analyzeSyntax(request);
      // Print the response
      for (Token token : response.getTokensList()) {
        System.out.printf("\tText: %s\n", token.getText().getContent());
        System.out.printf("\tBeginOffset: %d\n", token.getText().getBeginOffset());
        System.out.printf("Lemma: %s\n", token.getLemma());
        System.out.printf("PartOfSpeechTag: %s\n", token.getPartOfSpeech().getTag());
        System.out.printf("\tAspect: %s\n", token.getPartOfSpeech().getAspect());
        System.out.printf("\tCase: %s\n", token.getPartOfSpeech().getCase());
        System.out.printf("\tForm: %s\n", token.getPartOfSpeech().getForm());
        System.out.printf("\tGender: %s\n", token.getPartOfSpeech().getGender());
        System.out.printf("\tMood: %s\n", token.getPartOfSpeech().getMood());
        System.out.printf("\tNumber: %s\n", token.getPartOfSpeech().getNumber());
        System.out.printf("\tPerson: %s\n", token.getPartOfSpeech().getPerson());
        System.out.printf("\tProper: %s\n", token.getPartOfSpeech().getProper());
        System.out.printf("\tReciprocity: %s\n", token.getPartOfSpeech().getReciprocity());
        System.out.printf("\tTense: %s\n", token.getPartOfSpeech().getTense());
        System.out.printf("\tVoice: %s\n", token.getPartOfSpeech().getVoice());
        System.out.println("DependencyEdge");
        System.out.printf("\tHeadTokenIndex: %d\n", token.getDependencyEdge().getHeadTokenIndex());
        System.out.printf("\tLabel: %s\n\n", token.getDependencyEdge().getLabel());
      }
      return response.getTokensList();
    }
    // [END language_syntax_text]
  }

  /** Get the syntax of the GCS hosted file. */
  public static List<Token> analyzeSyntaxFile(String gcsUri) throws Exception {
    // [START language_syntax_gcs]
    // Instantiate the Language client com.google.cloud.language.v1.LanguageServiceClient
    try (LanguageServiceClient language = LanguageServiceClient.create()) {
      Document doc =
          Document.newBuilder().setGcsContentUri(gcsUri).setType(Type.PLAIN_TEXT).build();
      AnalyzeSyntaxRequest request =
          AnalyzeSyntaxRequest.newBuilder()
              .setDocument(doc)
              .setEncodingType(EncodingType.UTF16)
              .build();
      // Analyze the syntax in the given text
      AnalyzeSyntaxResponse response = language.analyzeSyntax(request);
      // Print the response
      for (Token token : response.getTokensList()) {
        System.out.printf("\tText: %s\n", token.getText().getContent());
        System.out.printf("\tBeginOffset: %d\n", token.getText().getBeginOffset());
        System.out.printf("Lemma: %s\n", token.getLemma());
        System.out.printf("PartOfSpeechTag: %s\n", token.getPartOfSpeech().getTag());
        System.out.printf("\tAspect: %s\n", token.getPartOfSpeech().getAspect());
        System.out.printf("\tCase: %s\n", token.getPartOfSpeech().getCase());
        System.out.printf("\tForm: %s\n", token.getPartOfSpeech().getForm());
        System.out.printf("\tGender: %s\n", token.getPartOfSpeech().getGender());
        System.out.printf("\tMood: %s\n", token.getPartOfSpeech().getMood());
        System.out.printf("\tNumber: %s\n", token.getPartOfSpeech().getNumber());
        System.out.printf("\tPerson: %s\n", token.getPartOfSpeech().getPerson());
        System.out.printf("\tProper: %s\n", token.getPartOfSpeech().getProper());
        System.out.printf("\tReciprocity: %s\n", token.getPartOfSpeech().getReciprocity());
        System.out.printf("\tTense: %s\n", token.getPartOfSpeech().getTense());
        System.out.printf("\tVoice: %s\n", token.getPartOfSpeech().getVoice());
        System.out.println("DependencyEdge");
        System.out.printf("\tHeadTokenIndex: %d\n", token.getDependencyEdge().getHeadTokenIndex());
        System.out.printf("\tLabel: %s\n\n", token.getDependencyEdge().getLabel());
      }

      return response.getTokensList();
    }
    // [END language_syntax_gcs]
  }

  /** Detects categories in text using the Language Beta API. */
  public static void classifyText(String text) throws Exception {
    // [START language_classify_text]
    // Instantiate the Language client com.google.cloud.language.v1.LanguageServiceClient
    try (LanguageServiceClient language = LanguageServiceClient.create()) {
      // Set content to the text string
      Document doc = Document.newBuilder().setContent(text).setType(Type.PLAIN_TEXT).build();
      V2Model v2Model = V2Model.setContentCategoriesVersion(ContentCategoriesVersion.V2).build();
      ClassificationModelOptions options =
          ClassificationModelOptions.newBuilder().setV2Model(v2Model).build();
      ClassifyTextRequest request =
          ClassifyTextRequest.newBuilder()
              .setDocument(doc)
              .setClassificationModelOptions(options)
              .build();
      // Detect categories in the given text
      ClassifyTextResponse response = language.classifyText(request);

      for (ClassificationCategory category : response.getCategoriesList()) {
        System.out.printf(
            "Category name : %s, Confidence : %.3f\n",
            category.getName(), category.getConfidence());
      }
    }
    // [END language_classify_text]
  }

  /** Detects categories in a GCS hosted file using the Language Beta API. */
  public static void classifyFile(String gcsUri) throws Exception {
    // [START language_classify_gcs]
    // Instantiate the Language client com.google.cloud.language.v1.LanguageServiceClient
    try (LanguageServiceClient language = LanguageServiceClient.create()) {
      // Set the GCS content URI path
      Document doc =
          Document.newBuilder().setGcsContentUri(gcsUri).setType(Type.PLAIN_TEXT).build();
      ClassifyTextRequest request = ClassifyTextRequest.newBuilder().setDocument(doc).build();
      // Detect categories in the given file
      ClassifyTextResponse response = language.classifyText(request);

      for (ClassificationCategory category : response.getCategoriesList()) {
        System.out.printf(
            "Category name : %s, Confidence : %.3f\n",
            category.getName(), category.getConfidence());
      }
    }
    // [END language_classify_gcs]
  }

  /** Detects the entity sentiments in the string {@code text} using the Language Beta API. */
  public static void entitySentimentText(String text) throws Exception {
    // [START language_entity_sentiment_text]
    // Instantiate the Language client com.google.cloud.language.v1.LanguageServiceClient
    try (LanguageServiceClient language = LanguageServiceClient.create()) {
      Document doc = Document.newBuilder().setContent(text).setType(Type.PLAIN_TEXT).build();
      AnalyzeEntitySentimentRequest request =
          AnalyzeEntitySentimentRequest.newBuilder()
              .setDocument(doc)
              .setEncodingType(EncodingType.UTF16)
              .build();
      // Detect entity sentiments in the given string
      AnalyzeEntitySentimentResponse response = language.analyzeEntitySentiment(request);
      // Print the response
      for (Entity entity : response.getEntitiesList()) {
        System.out.printf("Entity: %s\n", entity.getName());
        System.out.printf("Salience: %.3f\n", entity.getSalience());
        System.out.printf("Sentiment : %s\n", entity.getSentiment());
        for (EntityMention mention : entity.getMentionsList()) {
          System.out.printf("Begin offset: %d\n", mention.getText().getBeginOffset());
          System.out.printf("Content: %s\n", mention.getText().getContent());
          System.out.printf("Magnitude: %.3f\n", mention.getSentiment().getMagnitude());
          System.out.printf("Sentiment score : %.3f\n", mention.getSentiment().getScore());
          System.out.printf("Type: %s\n\n", mention.getType());
        }
      }
    }
    // [END language_entity_sentiment_text]
  }

  /** Identifies the entity sentiments in the GCS hosted file using the Language Beta API. */
  public static void entitySentimentFile(String gcsUri) throws Exception {
    // [START language_entity_sentiment_gcs]
    // Instantiate the Language client com.google.cloud.language.v1.LanguageServiceClient
    try (LanguageServiceClient language = LanguageServiceClient.create()) {
      Document doc =
          Document.newBuilder().setGcsContentUri(gcsUri).setType(Type.PLAIN_TEXT).build();
      AnalyzeEntitySentimentRequest request =
          AnalyzeEntitySentimentRequest.newBuilder()
              .setDocument(doc)
              .setEncodingType(EncodingType.UTF16)
              .build();
      // Detect entity sentiments in the given file
      AnalyzeEntitySentimentResponse response = language.analyzeEntitySentiment(request);
      // Print the response
      for (Entity entity : response.getEntitiesList()) {
        System.out.printf("Entity: %s\n", entity.getName());
        System.out.printf("Salience: %.3f\n", entity.getSalience());
        System.out.printf("Sentiment : %s\n", entity.getSentiment());
        for (EntityMention mention : entity.getMentionsList()) {
          System.out.printf("Begin offset: %d\n", mention.getText().getBeginOffset());
          System.out.printf("Content: %s\n", mention.getText().getContent());
          System.out.printf("Magnitude: %.3f\n", mention.getSentiment().getMagnitude());
          System.out.printf("Sentiment score : %.3f\n", mention.getSentiment().getScore());
          System.out.printf("Type: %s\n\n", mention.getType());
        }
      }
    }
    // [END language_entity_sentiment_gcs]
  }
}
