/*
 * Copyright 2016, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.language.spi.v1;

import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1.AnalyzeSentimentRequest;
import com.google.cloud.language.v1.AnalyzeSentimentResponse;
import com.google.cloud.language.v1.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1.AnnotateTextRequest;
import com.google.cloud.language.v1.AnnotateTextRequest.Features;
import com.google.cloud.language.v1.AnnotateTextResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.EncodingType;
import com.google.protobuf.ExperimentalApi;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;

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
 * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
 *   Document document = Document.newBuilder().build();
 *   AnalyzeSentimentResponse response = languageServiceClient.analyzeSentiment(document);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the languageServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of LanguageServiceSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * InstantiatingChannelProvider channelProvider =
 *     LanguageServiceSettings.defaultChannelProviderBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LanguageServiceSettings languageServiceSettings =
 *     LanguageServiceSettings.defaultBuilder().setChannelProvider(channelProvider).build();
 * LanguageServiceClient languageServiceClient =
 *     LanguageServiceClient.create(languageServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
@ExperimentalApi
public class LanguageServiceClient implements AutoCloseable {
  private final LanguageServiceSettings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentCallable;
  private final UnaryCallable<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesCallable;
  private final UnaryCallable<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse> analyzeSyntaxCallable;
  private final UnaryCallable<AnnotateTextRequest, AnnotateTextResponse> annotateTextCallable;

  /** Constructs an instance of LanguageServiceClient with default settings. */
  public static final LanguageServiceClient create() throws IOException {
    return create(LanguageServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of LanguageServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LanguageServiceClient create(LanguageServiceSettings settings)
      throws IOException {
    return new LanguageServiceClient(settings);
  }

  /**
   * Constructs an instance of LanguageServiceClient, using the given settings. This is protected so
   * that it easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected LanguageServiceClient(LanguageServiceSettings settings) throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();

    this.analyzeSentimentCallable =
        UnaryCallable.create(settings.analyzeSentimentSettings(), this.channel, this.executor);
    this.analyzeEntitiesCallable =
        UnaryCallable.create(settings.analyzeEntitiesSettings(), this.channel, this.executor);
    this.analyzeSyntaxCallable =
        UnaryCallable.create(settings.analyzeSyntaxSettings(), this.channel, this.executor);
    this.annotateTextCallable =
        UnaryCallable.create(settings.annotateTextSettings(), this.channel, this.executor);

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

  public final LanguageServiceSettings getSettings() {
    return settings;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Analyzes the sentiment of the provided text.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnalyzeSentimentResponse response = languageServiceClient.analyzeSentiment(document);
   * }
   * </code></pre>
   *
   * @param document Input document. Currently, `analyzeSentiment` only supports English text
   *     ([Document.language][google.cloud.language.v1.Document.language]="EN").
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
   * <p>Sample code:
   *
   * <pre><code>
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnalyzeSentimentRequest request = AnalyzeSentimentRequest.newBuilder()
   *     .setDocument(document)
   *     .build();
   *   AnalyzeSentimentResponse response = languageServiceClient.analyzeSentiment(request);
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
   * <p>Sample code:
   *
   * <pre><code>
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnalyzeSentimentRequest request = AnalyzeSentimentRequest.newBuilder()
   *     .setDocument(document)
   *     .build();
   *   RpcFuture&lt;AnalyzeSentimentResponse&gt; future = languageServiceClient.analyzeSentimentCallable().futureCall(request);
   *   // Do something
   *   AnalyzeSentimentResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentCallable() {
    return analyzeSentimentCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Finds named entities (currently finds proper names) in the text, entity types, salience,
   * mentions for each entity, and other properties.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnalyzeEntitiesResponse response = languageServiceClient.analyzeEntities(document, encodingType);
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
   * Finds named entities (currently finds proper names) in the text, entity types, salience,
   * mentions for each entity, and other properties.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnalyzeEntitiesRequest request = AnalyzeEntitiesRequest.newBuilder()
   *     .setDocument(document)
   *     .setEncodingType(encodingType)
   *     .build();
   *   AnalyzeEntitiesResponse response = languageServiceClient.analyzeEntities(request);
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
   * Finds named entities (currently finds proper names) in the text, entity types, salience,
   * mentions for each entity, and other properties.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnalyzeEntitiesRequest request = AnalyzeEntitiesRequest.newBuilder()
   *     .setDocument(document)
   *     .setEncodingType(encodingType)
   *     .build();
   *   RpcFuture&lt;AnalyzeEntitiesResponse&gt; future = languageServiceClient.analyzeEntitiesCallable().futureCall(request);
   *   // Do something
   *   AnalyzeEntitiesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesCallable() {
    return analyzeEntitiesCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Analyzes the syntax of the text and provides sentence boundaries and tokenization along with
   * part of speech tags, dependency trees, and other properties.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnalyzeSyntaxResponse response = languageServiceClient.analyzeSyntax(document, encodingType);
   * }
   * </code></pre>
   *
   * @param document Input document.
   * @param encodingType The encoding type used by the API to calculate offsets.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final AnalyzeSyntaxResponse analyzeSyntax(Document document, EncodingType encodingType) {

    AnalyzeSyntaxRequest request =
        AnalyzeSyntaxRequest.newBuilder()
            .setDocument(document)
            .setEncodingType(encodingType)
            .build();
    return analyzeSyntax(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Analyzes the syntax of the text and provides sentence boundaries and tokenization along with
   * part of speech tags, dependency trees, and other properties.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnalyzeSyntaxRequest request = AnalyzeSyntaxRequest.newBuilder()
   *     .setDocument(document)
   *     .setEncodingType(encodingType)
   *     .build();
   *   AnalyzeSyntaxResponse response = languageServiceClient.analyzeSyntax(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final AnalyzeSyntaxResponse analyzeSyntax(AnalyzeSyntaxRequest request) {
    return analyzeSyntaxCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Analyzes the syntax of the text and provides sentence boundaries and tokenization along with
   * part of speech tags, dependency trees, and other properties.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnalyzeSyntaxRequest request = AnalyzeSyntaxRequest.newBuilder()
   *     .setDocument(document)
   *     .setEncodingType(encodingType)
   *     .build();
   *   RpcFuture&lt;AnalyzeSyntaxResponse&gt; future = languageServiceClient.analyzeSyntaxCallable().futureCall(request);
   *   // Do something
   *   AnalyzeSyntaxResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse> analyzeSyntaxCallable() {
    return analyzeSyntaxCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * A convenience method that provides all the features that analyzeSentiment, analyzeEntities, and
   * analyzeSyntax provide in one call.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnnotateTextRequest.Features features = AnnotateTextRequest.Features.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnnotateTextResponse response = languageServiceClient.annotateText(document, features, encodingType);
   * }
   * </code></pre>
   *
   * @param document Input document.
   * @param features The enabled features.
   * @param encodingType The encoding type used by the API to calculate offsets.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final AnnotateTextResponse annotateText(
      Document document, AnnotateTextRequest.Features features, EncodingType encodingType) {

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
   * A convenience method that provides all the features that analyzeSentiment, analyzeEntities, and
   * analyzeSyntax provide in one call.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnnotateTextRequest.Features features = AnnotateTextRequest.Features.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnnotateTextRequest request = AnnotateTextRequest.newBuilder()
   *     .setDocument(document)
   *     .setFeatures(features)
   *     .setEncodingType(encodingType)
   *     .build();
   *   AnnotateTextResponse response = languageServiceClient.annotateText(request);
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
   * A convenience method that provides all the features that analyzeSentiment, analyzeEntities, and
   * analyzeSyntax provide in one call.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnnotateTextRequest.Features features = AnnotateTextRequest.Features.newBuilder().build();
   *   EncodingType encodingType = EncodingType.NONE;
   *   AnnotateTextRequest request = AnnotateTextRequest.newBuilder()
   *     .setDocument(document)
   *     .setFeatures(features)
   *     .setEncodingType(encodingType)
   *     .build();
   *   RpcFuture&lt;AnnotateTextResponse&gt; future = languageServiceClient.annotateTextCallable().futureCall(request);
   *   // Do something
   *   AnnotateTextResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AnnotateTextRequest, AnnotateTextResponse> annotateTextCallable() {
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
