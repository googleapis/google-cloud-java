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
package com.google.cloud.language.it;

import static com.google.cloud.language.v1.Document.Type;
import static com.google.cloud.language.v1.PartOfSpeech.Tag;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1.AnalyzeEntitySentimentRequest;
import com.google.cloud.language.v1.AnalyzeEntitySentimentResponse;
import com.google.cloud.language.v1.AnalyzeSentimentResponse;
import com.google.cloud.language.v1.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1.ClassificationCategory;
import com.google.cloud.language.v1.ClassifyTextRequest;
import com.google.cloud.language.v1.ClassifyTextResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.Entity;
import com.google.cloud.language.v1.EntityMention;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import com.google.cloud.language.v1.Token;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ITSystemTest {

  private static LanguageServiceClient client;
  private static final String ANALYZE_TEXT =
      "Android is a mobile operating system developed by Google, based on the Linux kernel and designed primarily for touchscreen mobile devices such as smartphones and tablets.";

  @Before
  public void setUp() throws IOException {
    client = LanguageServiceClient.create();
  }

  @After
  public void tearDown() {
    client.close();
  }

  @Test
  public void analyzeEntitiesFileTest() {
    Document doc =
        Document.newBuilder()
            .setGcsContentUri("gs://cloud-samples-data/language/android.txt")
            .setType(Type.PLAIN_TEXT)
            .build();
    AnalyzeEntitiesRequest request = AnalyzeEntitiesRequest.newBuilder().setDocument(doc).build();
    AnalyzeEntitiesResponse response = client.analyzeEntities(request);
    for (Entity entity : response.getEntitiesList()) {
      if (entity.getName().equals("Android")) {
        assertEquals(Entity.Type.CONSUMER_GOOD, entity.getType());
        assertEquals(0.69612604, entity.getSalience(), 10);
        assertEquals(2, entity.getMentionsCount());
        assertEquals(2, entity.getMetadataMap().size());
        break;
      }
    }
  }

  @Test
  public void analyzeEntitiesTextTest() {
    Document doc = Document.newBuilder().setContent(ANALYZE_TEXT).setType(Type.PLAIN_TEXT).build();
    AnalyzeEntitiesRequest request =
        AnalyzeEntitiesRequest.newBuilder()
            .setDocument(doc)
            .setEncodingType(EncodingType.UTF16)
            .build();
    AnalyzeEntitiesResponse response = client.analyzeEntities(request);
    for (Entity entity : response.getEntitiesList()) {
      if (entity.getName().equals("Android")) {
        assertEquals(Entity.Type.CONSUMER_GOOD, entity.getType());
        assertEquals(0.69612604, entity.getSalience(), 10);
        assertEquals(2, entity.getMentionsCount());
        assertEquals(2, entity.getMetadataMap().size());
        break;
      }
    }
  }

  @Test
  public void analyzeEntitySentimentFileTest() {
    Document doc =
        Document.newBuilder()
            .setGcsContentUri("gs://cloud-samples-data/language/president.txt")
            .setType(Type.PLAIN_TEXT)
            .build();
    AnalyzeEntitySentimentRequest request =
        AnalyzeEntitySentimentRequest.newBuilder()
            .setDocument(doc)
            .setEncodingType(EncodingType.UTF16)
            .build();
    AnalyzeEntitySentimentResponse response = client.analyzeEntitySentiment(request);
    List<String> actual = new ArrayList<>();
    for (Entity entity : response.getEntitiesList()) {
      actual.add(entity.getName());
    }
    assertEquals(Arrays.asList("Kennedy", "White House"), actual);
  }

  @Test
  public void analyzeEntitySentimentTextWithExpectedResultTest() {
    Document doc =
        Document.newBuilder()
            .setContent(
                "Oranges, grapes, and apples can be found in the cafeterias located in Mountain View, Seattle, and London.")
            .setType(Type.PLAIN_TEXT)
            .build();
    AnalyzeEntitySentimentRequest request =
        AnalyzeEntitySentimentRequest.newBuilder()
            .setDocument(doc)
            .setEncodingType(EncodingType.UTF16)
            .build();
    AnalyzeEntitySentimentResponse response = client.analyzeEntitySentiment(request);
    List<String> actual = new ArrayList<>();
    for (Entity entity : response.getEntitiesList()) {
      actual.add(entity.getName());
    }
    assertTrue(actual.contains("Seattle"));
  }

  @Test
  public void analyzeEntitySentimentTextWithEncodedExpectedResultTest() {
    Document doc = Document.newBuilder().setContent("foo→bar").setType(Type.PLAIN_TEXT).build();
    AnalyzeEntitySentimentRequest request =
        AnalyzeEntitySentimentRequest.newBuilder()
            .setDocument(doc)
            .setEncodingType(EncodingType.UTF16)
            .build();
    AnalyzeEntitySentimentResponse response = client.analyzeEntitySentiment(request);
    List<Integer> actual = new ArrayList<>();
    for (Entity entity : response.getEntitiesList()) {
      for (EntityMention mention : entity.getMentionsList()) {
        actual.add(mention.getText().getBeginOffset());
      }
    }
    assertTrue(actual.contains(4));
  }

  @Test
  public void analyzeSentimentFileWithReturnPositiveTest() {
    Document doc =
        Document.newBuilder()
            .setGcsContentUri("gs://cloud-samples-data/language/sentiment-positive.txt")
            .setType(Type.PLAIN_TEXT)
            .build();
    AnalyzeSentimentResponse response = client.analyzeSentiment(doc);
    Sentiment actual = response.getDocumentSentiment();
    assertTrue(actual.getMagnitude() > 0.0F);
    assertTrue(actual.getScore() > 0.0F);
  }

  @Test
  public void analyzeSentimentTextWithReturnPositiveTest() {
    Document doc =
        Document.newBuilder()
            .setContent("Tom Cruise is one of the finest actors in hollywood and a great star!")
            .setType(Type.PLAIN_TEXT)
            .build();
    Sentiment sentiment = client.analyzeSentiment(doc).getDocumentSentiment();
    assertTrue(sentiment.getMagnitude() > 0.0F);
    assertTrue(sentiment.getScore() > 0.0F);
  }

  @Test
  public void analyzeSentimentFileWithReturnNegativeTest() {
    Document doc =
        Document.newBuilder()
            .setGcsContentUri("gs://cloud-samples-data/language/sentiment-negative.txt")
            .setType(Type.PLAIN_TEXT)
            .build();
    Sentiment sentiment = client.analyzeSentiment(doc).getDocumentSentiment();
    assertTrue(sentiment.getMagnitude() > 0.0F);
    assertTrue(sentiment.getScore() < 0.0F);
  }

  @Test
  public void analyzeSentimentTextWithReturnNegativeTest() {
    Document doc =
        Document.newBuilder()
            .setContent("That was the worst performance I've seen in a while.")
            .setType(Type.PLAIN_TEXT)
            .build();
    Sentiment sentiment = client.analyzeSentiment(doc).getDocumentSentiment();
    assertTrue(sentiment.getMagnitude() > 0.0F);
    assertTrue(sentiment.getScore() < 0.0F);
  }

  @Test
  public void analyzeSyntaxFileTest() {
    Document doc =
        Document.newBuilder()
            .setGcsContentUri("gs://cloud-samples-data/language/syntax-sentence.txt")
            .setType(Type.PLAIN_TEXT)
            .build();
    AnalyzeSyntaxRequest request =
        AnalyzeSyntaxRequest.newBuilder()
            .setDocument(doc)
            .setEncodingType(EncodingType.UTF16)
            .build();
    List<Token> tokens = client.analyzeSyntax(request).getTokensList();
    List<Tag> expected = Arrays.asList(Tag.DET, Tag.VERB, Tag.DET, Tag.ADJ, Tag.NOUN, Tag.PUNCT);
    List<Tag> actual = new ArrayList<>();
    for (Token token : tokens) {
      actual.add(token.getPartOfSpeech().getTag());
    }
    assertEquals(expected, actual);
  }

  @Test
  public void analyzeSyntaxTextTest() {
    Document doc =
        Document.newBuilder()
            .setContent("President Obama was elected for the second term")
            .setType(Type.PLAIN_TEXT)
            .build();
    AnalyzeSyntaxRequest request =
        AnalyzeSyntaxRequest.newBuilder()
            .setDocument(doc)
            .setEncodingType(EncodingType.UTF16)
            .build();
    List<Token> tokens = client.analyzeSyntax(request).getTokensList();
    List<Tag> expected =
        Arrays.asList(Tag.NOUN, Tag.NOUN, Tag.VERB, Tag.VERB, Tag.ADP, Tag.DET, Tag.ADJ, Tag.NOUN);
    List<Tag> actual = new ArrayList<>();
    for (Token token : tokens) {
      actual.add(token.getPartOfSpeech().getTag());
    }
    assertEquals(expected, actual);
  }

  @Test
  public void classifyFileTest() {
    Document doc =
        Document.newBuilder()
            .setGcsContentUri("gs://cloud-samples-data/language/android.txt")
            .setType(Type.PLAIN_TEXT)
            .build();
    ClassifyTextRequest request = ClassifyTextRequest.newBuilder().setDocument(doc).build();
    ClassifyTextResponse response = client.classifyText(request);
    List<String> expected =
        Arrays.asList(
            "/Computers & Electronics",
            "/Internet & Telecom/Mobile & Wireless/Mobile Apps & Add-Ons");
    List<String> actual = new ArrayList<>();
    for (ClassificationCategory category : response.getCategoriesList()) {
      actual.add(category.getName());
    }
    assertEquals(expected, actual);
  }

  @Test
  public void classifyTextTest() {
    Document doc = Document.newBuilder().setContent(ANALYZE_TEXT).setType(Type.PLAIN_TEXT).build();
    ClassifyTextRequest request = ClassifyTextRequest.newBuilder().setDocument(doc).build();
    ClassifyTextResponse response = client.classifyText(request);
    List<String> expected =
        Arrays.asList(
            "/Computers & Electronics",
            "/Internet & Telecom/Mobile & Wireless/Mobile Apps & Add-Ons");
    List<String> actual = new ArrayList<>();
    for (ClassificationCategory category : response.getCategoriesList()) {
      actual.add(category.getName());
    }
    assertEquals(expected, actual);
  }
}
