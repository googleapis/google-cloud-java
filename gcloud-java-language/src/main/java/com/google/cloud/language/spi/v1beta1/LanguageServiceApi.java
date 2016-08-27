/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.language.spi.v1beta1;

import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.cloud.language.v1beta1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1beta1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1beta1.AnalyzeSentimentRequest;
import com.google.cloud.language.v1beta1.AnalyzeSentimentResponse;
import com.google.cloud.language.v1beta1.AnnotateTextRequest;
import com.google.cloud.language.v1beta1.AnnotateTextRequest.Features;
import com.google.cloud.language.v1beta1.AnnotateTextResponse;
import com.google.cloud.language.v1beta1.Document;
import com.google.cloud.language.v1beta1.EncodingType;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Provides text analysis operations such as sentiment analysis and entity
 * recognition.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (LanguageServiceApi languageServiceApi = LanguageServiceApi.create()) {
 *   Document document = Document.newBuilder().build();
 *   AnalyzeSentimentResponse response = languageServiceApi.analyzeSentiment(document);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the languageServiceApi object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * ApiCallable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of LanguageServiceSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * LanguageServiceSettings languageServiceSettings = LanguageServiceSettings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * LanguageServiceApi languageServiceApi = LanguageServiceApi.create(languageServiceSettings);
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class LanguageServiceApi implements AutoCloseable {
  private final LanguageServiceSettings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentCallable;
  private final ApiCallable<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesCallable;
  private final ApiCallable<AnnotateTextRequest, AnnotateTextResponse> annotateTextCallable;

  public final LanguageServiceSettings getSettings() {
    return settings;
  }

  /**
   * Constructs an instance of LanguageServiceApi with default settings.
   */
  public static final LanguageServiceApi create() throws IOException {
    return create(LanguageServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of LanguageServiceApi, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final LanguageServiceApi create(LanguageServiceSettings settings)
      throws IOException {
    return new LanguageServiceApi(settings);
  }

  /**
   * Constructs an instance of LanguageServiceApi, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected LanguageServiceApi(LanguageServiceSettings settings) throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.analyzeSentimentCallable =
        ApiCallable.create(settings.analyzeSentimentSettings(), this.channel, this.executor);
    this.analyzeEntitiesCallable =
        ApiCallable.create(settings.analyzeEntitiesSettings(), this.channel, this.executor);
    this.annotateTextCallable =
        ApiCallable.create(settings.annotateTextSettings(), this.channel, this.executor);

    if (settings.getChannelProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              channel.shutdown();
            }
          });
    }
    if (settings.getExecutorProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              executor.shutdown();
            }
          });
    }
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Analyzes the sentiment of the provided text.
   *
   * Sample code:
   * <pre><code>
   * try (LanguageServiceApi languageServiceApi = LanguageServiceApi.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnalyzeSentimentResponse response = languageServiceApi.analyzeSentiment(document);
   * }
   * </code></pre>
   *
   * @param document Input document. Currently, `analyzeSentiment` only supports English text
   * ([Document.language][google.cloud.language.v1beta1.Document.language]="EN").
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final AnalyzeSentimentResponse analyzeSentiment(Document document) {
    AnalyzeSentimentRequest request =
        AnalyzeSentimentRequest.newBuilder().setDocument(document).build();
    return analyzeSentiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Analyzes the sentiment of the provided text.
   *
   * Sample code:
   * <pre><code>
   * try (LanguageServiceApi languageServiceApi = LanguageServiceApi.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnalyzeSentimentRequest request = AnalyzeSentimentRequest.newBuilder()
   *     .setDocument(document)
   *     .build();
   *   AnalyzeSentimentResponse response = languageServiceApi.analyzeSentiment(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final AnalyzeSentimentResponse analyzeSentiment(AnalyzeSentimentRequest request) {
    return analyzeSentimentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Analyzes the sentiment of the provided text.
   *
   * Sample code:
   * <pre><code>
   * try (LanguageServiceApi languageServiceApi = LanguageServiceApi.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnalyzeSentimentRequest request = AnalyzeSentimentRequest.newBuilder()
   *     .setDocument(document)
   *     .build();
   *   ListenableFuture&lt;AnalyzeSentimentResponse&gt; future = languageServiceApi.analyzeSentimentCallable().futureCall(request);
   *   // Do something
   *   AnalyzeSentimentResponse response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentCallable() {
    return analyzeSentimentCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Finds named entities (currently finds proper names) in the text,
   * entity types, salience, mentions for each entity, and other properties.
   *
   * Sample code:
   * <pre><code>
   * try (LanguageServiceApi languageServiceApi = LanguageServiceApi.create()) {
   *   Document document = Document.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnalyzeEntitiesResponse response = languageServiceApi.analyzeEntities(document, encodingType);
   * }
   * </code></pre>
   *
   * @param document Input document.
   * @param encodingType The encoding type used by the API to calculate offsets.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final AnalyzeEntitiesResponse analyzeEntities(
      Document document, EncodingType encodingType) {
    AnalyzeEntitiesRequest request =
        AnalyzeEntitiesRequest.newBuilder()
            .setDocument(document)
            .setEncodingType(encodingType)
            .build();
    return analyzeEntities(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Finds named entities (currently finds proper names) in the text,
   * entity types, salience, mentions for each entity, and other properties.
   *
   * Sample code:
   * <pre><code>
   * try (LanguageServiceApi languageServiceApi = LanguageServiceApi.create()) {
   *   Document document = Document.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnalyzeEntitiesRequest request = AnalyzeEntitiesRequest.newBuilder()
   *     .setDocument(document)
   *     .setEncodingType(encodingType)
   *     .build();
   *   AnalyzeEntitiesResponse response = languageServiceApi.analyzeEntities(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final AnalyzeEntitiesResponse analyzeEntities(AnalyzeEntitiesRequest request) {
    return analyzeEntitiesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Finds named entities (currently finds proper names) in the text,
   * entity types, salience, mentions for each entity, and other properties.
   *
   * Sample code:
   * <pre><code>
   * try (LanguageServiceApi languageServiceApi = LanguageServiceApi.create()) {
   *   Document document = Document.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnalyzeEntitiesRequest request = AnalyzeEntitiesRequest.newBuilder()
   *     .setDocument(document)
   *     .setEncodingType(encodingType)
   *     .build();
   *   ListenableFuture&lt;AnalyzeEntitiesResponse&gt; future = languageServiceApi.analyzeEntitiesCallable().futureCall(request);
   *   // Do something
   *   AnalyzeEntitiesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesCallable() {
    return analyzeEntitiesCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Advanced API that analyzes the document and provides a full set of text
   * annotations, including semantic, syntactic, and sentiment information. This
   * API is intended for users who are familiar with machine learning and need
   * in-depth text features to build upon.
   *
   * Sample code:
   * <pre><code>
   * try (LanguageServiceApi languageServiceApi = LanguageServiceApi.create()) {
   *   Document document = Document.newBuilder().build();
   *   Features features = Features.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnnotateTextResponse response = languageServiceApi.annotateText(document, features, encodingType);
   * }
   * </code></pre>
   *
   * @param document Input document.
   * @param features The enabled features.
   * @param encodingType The encoding type used by the API to calculate offsets.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final AnnotateTextResponse annotateText(
      Document document, Features features, EncodingType encodingType) {
    AnnotateTextRequest request =
        AnnotateTextRequest.newBuilder()
            .setDocument(document)
            .setFeatures(features)
            .setEncodingType(encodingType)
            .build();
    return annotateText(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Advanced API that analyzes the document and provides a full set of text
   * annotations, including semantic, syntactic, and sentiment information. This
   * API is intended for users who are familiar with machine learning and need
   * in-depth text features to build upon.
   *
   * Sample code:
   * <pre><code>
   * try (LanguageServiceApi languageServiceApi = LanguageServiceApi.create()) {
   *   Document document = Document.newBuilder().build();
   *   Features features = Features.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnnotateTextRequest request = AnnotateTextRequest.newBuilder()
   *     .setDocument(document)
   *     .setFeatures(features)
   *     .setEncodingType(encodingType)
   *     .build();
   *   AnnotateTextResponse response = languageServiceApi.annotateText(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final AnnotateTextResponse annotateText(AnnotateTextRequest request) {
    return annotateTextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Advanced API that analyzes the document and provides a full set of text
   * annotations, including semantic, syntactic, and sentiment information. This
   * API is intended for users who are familiar with machine learning and need
   * in-depth text features to build upon.
   *
   * Sample code:
   * <pre><code>
   * try (LanguageServiceApi languageServiceApi = LanguageServiceApi.create()) {
   *   Document document = Document.newBuilder().build();
   *   Features features = Features.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnnotateTextRequest request = AnnotateTextRequest.newBuilder()
   *     .setDocument(document)
   *     .setFeatures(features)
   *     .setEncodingType(encodingType)
   *     .build();
   *   ListenableFuture&lt;AnnotateTextResponse&gt; future = languageServiceApi.annotateTextCallable().futureCall(request);
   *   // Do something
   *   AnnotateTextResponse response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<AnnotateTextRequest, AnnotateTextResponse> annotateTextCallable() {
    return annotateTextCallable;
  }

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   */
  @Override
  public final void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }
}
