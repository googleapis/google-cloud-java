/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.language.v1beta2;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.language.v1beta2.stub.LanguageServiceStub;
import com.google.cloud.language.v1beta2.stub.LanguageServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides text analysis operations such as sentiment analysis and entity
 * recognition.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
 *   Document document = Document.newBuilder().build();
 *   AnalyzeSentimentResponse response = languageServiceClient.analyzeSentiment(document);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LanguageServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
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
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LanguageServiceSettings languageServiceSettings =
 *     LanguageServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LanguageServiceClient languageServiceClient =
 *     LanguageServiceClient.create(languageServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LanguageServiceSettings languageServiceSettings =
 *     LanguageServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LanguageServiceClient languageServiceClient =
 *     LanguageServiceClient.create(languageServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LanguageServiceSettings languageServiceSettings =
 *     LanguageServiceSettings.newHttpJsonBuilder().build();
 * LanguageServiceClient languageServiceClient =
 *     LanguageServiceClient.create(languageServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class LanguageServiceClient implements BackgroundResource {
  private final LanguageServiceSettings settings;
  private final LanguageServiceStub stub;

  /** Constructs an instance of LanguageServiceClient with default settings. */
  public static final LanguageServiceClient create() throws IOException {
    return create(LanguageServiceSettings.newBuilder().build());
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
   * Constructs an instance of LanguageServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(LanguageServiceSettings).
   */
  public static final LanguageServiceClient create(LanguageServiceStub stub) {
    return new LanguageServiceClient(stub);
  }

  /**
   * Constructs an instance of LanguageServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LanguageServiceClient(LanguageServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LanguageServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LanguageServiceClient(LanguageServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LanguageServiceSettings getSettings() {
    return settings;
  }

  public LanguageServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes the sentiment of the provided text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnalyzeSentimentResponse response = languageServiceClient.analyzeSentiment(document);
   * }
   * }</pre>
   *
   * @param document Required. Input document.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzeSentimentResponse analyzeSentiment(Document document) {
    AnalyzeSentimentRequest request =
        AnalyzeSentimentRequest.newBuilder().setDocument(document).build();
    return analyzeSentiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes the sentiment of the provided text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   EncodingType encodingType = EncodingType.forNumber(0);
   *   AnalyzeSentimentResponse response =
   *       languageServiceClient.analyzeSentiment(document, encodingType);
   * }
   * }</pre>
   *
   * @param document Required. Input document.
   * @param encodingType The encoding type used by the API to calculate sentence offsets for the
   *     sentence sentiment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzeSentimentResponse analyzeSentiment(
      Document document, EncodingType encodingType) {
    AnalyzeSentimentRequest request =
        AnalyzeSentimentRequest.newBuilder()
            .setDocument(document)
            .setEncodingType(encodingType)
            .build();
    return analyzeSentiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes the sentiment of the provided text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   AnalyzeSentimentRequest request =
   *       AnalyzeSentimentRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setEncodingType(EncodingType.forNumber(0))
   *           .build();
   *   AnalyzeSentimentResponse response = languageServiceClient.analyzeSentiment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzeSentimentResponse analyzeSentiment(AnalyzeSentimentRequest request) {
    return analyzeSentimentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes the sentiment of the provided text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   AnalyzeSentimentRequest request =
   *       AnalyzeSentimentRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setEncodingType(EncodingType.forNumber(0))
   *           .build();
   *   ApiFuture<AnalyzeSentimentResponse> future =
   *       languageServiceClient.analyzeSentimentCallable().futureCall(request);
   *   // Do something.
   *   AnalyzeSentimentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentCallable() {
    return stub.analyzeSentimentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds named entities (currently proper names and common nouns) in the text along with entity
   * types, salience, mentions for each entity, and other properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnalyzeEntitiesResponse response = languageServiceClient.analyzeEntities(document);
   * }
   * }</pre>
   *
   * @param document Required. Input document.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzeEntitiesResponse analyzeEntities(Document document) {
    AnalyzeEntitiesRequest request =
        AnalyzeEntitiesRequest.newBuilder().setDocument(document).build();
    return analyzeEntities(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds named entities (currently proper names and common nouns) in the text along with entity
   * types, salience, mentions for each entity, and other properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   EncodingType encodingType = EncodingType.forNumber(0);
   *   AnalyzeEntitiesResponse response =
   *       languageServiceClient.analyzeEntities(document, encodingType);
   * }
   * }</pre>
   *
   * @param document Required. Input document.
   * @param encodingType The encoding type used by the API to calculate offsets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds named entities (currently proper names and common nouns) in the text along with entity
   * types, salience, mentions for each entity, and other properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   AnalyzeEntitiesRequest request =
   *       AnalyzeEntitiesRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setEncodingType(EncodingType.forNumber(0))
   *           .build();
   *   AnalyzeEntitiesResponse response = languageServiceClient.analyzeEntities(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzeEntitiesResponse analyzeEntities(AnalyzeEntitiesRequest request) {
    return analyzeEntitiesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds named entities (currently proper names and common nouns) in the text along with entity
   * types, salience, mentions for each entity, and other properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   AnalyzeEntitiesRequest request =
   *       AnalyzeEntitiesRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setEncodingType(EncodingType.forNumber(0))
   *           .build();
   *   ApiFuture<AnalyzeEntitiesResponse> future =
   *       languageServiceClient.analyzeEntitiesCallable().futureCall(request);
   *   // Do something.
   *   AnalyzeEntitiesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesCallable() {
    return stub.analyzeEntitiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds entities, similar to
   * [AnalyzeEntities][google.cloud.language.v1beta2.LanguageService.AnalyzeEntities] in the text
   * and analyzes sentiment associated with each entity and its mentions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnalyzeEntitySentimentResponse response =
   *       languageServiceClient.analyzeEntitySentiment(document);
   * }
   * }</pre>
   *
   * @param document Required. Input document.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzeEntitySentimentResponse analyzeEntitySentiment(Document document) {
    AnalyzeEntitySentimentRequest request =
        AnalyzeEntitySentimentRequest.newBuilder().setDocument(document).build();
    return analyzeEntitySentiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds entities, similar to
   * [AnalyzeEntities][google.cloud.language.v1beta2.LanguageService.AnalyzeEntities] in the text
   * and analyzes sentiment associated with each entity and its mentions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   EncodingType encodingType = EncodingType.forNumber(0);
   *   AnalyzeEntitySentimentResponse response =
   *       languageServiceClient.analyzeEntitySentiment(document, encodingType);
   * }
   * }</pre>
   *
   * @param document Required. Input document.
   * @param encodingType The encoding type used by the API to calculate offsets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzeEntitySentimentResponse analyzeEntitySentiment(
      Document document, EncodingType encodingType) {
    AnalyzeEntitySentimentRequest request =
        AnalyzeEntitySentimentRequest.newBuilder()
            .setDocument(document)
            .setEncodingType(encodingType)
            .build();
    return analyzeEntitySentiment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds entities, similar to
   * [AnalyzeEntities][google.cloud.language.v1beta2.LanguageService.AnalyzeEntities] in the text
   * and analyzes sentiment associated with each entity and its mentions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   AnalyzeEntitySentimentRequest request =
   *       AnalyzeEntitySentimentRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setEncodingType(EncodingType.forNumber(0))
   *           .build();
   *   AnalyzeEntitySentimentResponse response =
   *       languageServiceClient.analyzeEntitySentiment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzeEntitySentimentResponse analyzeEntitySentiment(
      AnalyzeEntitySentimentRequest request) {
    return analyzeEntitySentimentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds entities, similar to
   * [AnalyzeEntities][google.cloud.language.v1beta2.LanguageService.AnalyzeEntities] in the text
   * and analyzes sentiment associated with each entity and its mentions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   AnalyzeEntitySentimentRequest request =
   *       AnalyzeEntitySentimentRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setEncodingType(EncodingType.forNumber(0))
   *           .build();
   *   ApiFuture<AnalyzeEntitySentimentResponse> future =
   *       languageServiceClient.analyzeEntitySentimentCallable().futureCall(request);
   *   // Do something.
   *   AnalyzeEntitySentimentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AnalyzeEntitySentimentRequest, AnalyzeEntitySentimentResponse>
      analyzeEntitySentimentCallable() {
    return stub.analyzeEntitySentimentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes the syntax of the text and provides sentence boundaries and tokenization along with
   * part of speech tags, dependency trees, and other properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnalyzeSyntaxResponse response = languageServiceClient.analyzeSyntax(document);
   * }
   * }</pre>
   *
   * @param document Required. Input document.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzeSyntaxResponse analyzeSyntax(Document document) {
    AnalyzeSyntaxRequest request = AnalyzeSyntaxRequest.newBuilder().setDocument(document).build();
    return analyzeSyntax(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes the syntax of the text and provides sentence boundaries and tokenization along with
   * part of speech tags, dependency trees, and other properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   EncodingType encodingType = EncodingType.forNumber(0);
   *   AnalyzeSyntaxResponse response = languageServiceClient.analyzeSyntax(document, encodingType);
   * }
   * }</pre>
   *
   * @param document Required. Input document.
   * @param encodingType The encoding type used by the API to calculate offsets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzeSyntaxResponse analyzeSyntax(Document document, EncodingType encodingType) {
    AnalyzeSyntaxRequest request =
        AnalyzeSyntaxRequest.newBuilder()
            .setDocument(document)
            .setEncodingType(encodingType)
            .build();
    return analyzeSyntax(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes the syntax of the text and provides sentence boundaries and tokenization along with
   * part of speech tags, dependency trees, and other properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   AnalyzeSyntaxRequest request =
   *       AnalyzeSyntaxRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setEncodingType(EncodingType.forNumber(0))
   *           .build();
   *   AnalyzeSyntaxResponse response = languageServiceClient.analyzeSyntax(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzeSyntaxResponse analyzeSyntax(AnalyzeSyntaxRequest request) {
    return analyzeSyntaxCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes the syntax of the text and provides sentence boundaries and tokenization along with
   * part of speech tags, dependency trees, and other properties.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   AnalyzeSyntaxRequest request =
   *       AnalyzeSyntaxRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setEncodingType(EncodingType.forNumber(0))
   *           .build();
   *   ApiFuture<AnalyzeSyntaxResponse> future =
   *       languageServiceClient.analyzeSyntaxCallable().futureCall(request);
   *   // Do something.
   *   AnalyzeSyntaxResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse> analyzeSyntaxCallable() {
    return stub.analyzeSyntaxCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Classifies a document into categories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   ClassifyTextResponse response = languageServiceClient.classifyText(document);
   * }
   * }</pre>
   *
   * @param document Required. Input document.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClassifyTextResponse classifyText(Document document) {
    ClassifyTextRequest request = ClassifyTextRequest.newBuilder().setDocument(document).build();
    return classifyText(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Classifies a document into categories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   ClassifyTextRequest request =
   *       ClassifyTextRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setClassificationModelOptions(ClassificationModelOptions.newBuilder().build())
   *           .build();
   *   ClassifyTextResponse response = languageServiceClient.classifyText(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ClassifyTextResponse classifyText(ClassifyTextRequest request) {
    return classifyTextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Classifies a document into categories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   ClassifyTextRequest request =
   *       ClassifyTextRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setClassificationModelOptions(ClassificationModelOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<ClassifyTextResponse> future =
   *       languageServiceClient.classifyTextCallable().futureCall(request);
   *   // Do something.
   *   ClassifyTextResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ClassifyTextRequest, ClassifyTextResponse> classifyTextCallable() {
    return stub.classifyTextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A convenience method that provides all syntax, sentiment, entity, and classification features
   * in one call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnnotateTextRequest.Features features = AnnotateTextRequest.Features.newBuilder().build();
   *   AnnotateTextResponse response = languageServiceClient.annotateText(document, features);
   * }
   * }</pre>
   *
   * @param document Required. Input document.
   * @param features Required. The enabled features.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotateTextResponse annotateText(
      Document document, AnnotateTextRequest.Features features) {
    AnnotateTextRequest request =
        AnnotateTextRequest.newBuilder().setDocument(document).setFeatures(features).build();
    return annotateText(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A convenience method that provides all syntax, sentiment, entity, and classification features
   * in one call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   AnnotateTextRequest.Features features = AnnotateTextRequest.Features.newBuilder().build();
   *   EncodingType encodingType = EncodingType.forNumber(0);
   *   AnnotateTextResponse response =
   *       languageServiceClient.annotateText(document, features, encodingType);
   * }
   * }</pre>
   *
   * @param document Required. Input document.
   * @param features Required. The enabled features.
   * @param encodingType The encoding type used by the API to calculate offsets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A convenience method that provides all syntax, sentiment, entity, and classification features
   * in one call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   AnnotateTextRequest request =
   *       AnnotateTextRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setFeatures(AnnotateTextRequest.Features.newBuilder().build())
   *           .setEncodingType(EncodingType.forNumber(0))
   *           .build();
   *   AnnotateTextResponse response = languageServiceClient.annotateText(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnnotateTextResponse annotateText(AnnotateTextRequest request) {
    return annotateTextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A convenience method that provides all syntax, sentiment, entity, and classification features
   * in one call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
   *   AnnotateTextRequest request =
   *       AnnotateTextRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setFeatures(AnnotateTextRequest.Features.newBuilder().build())
   *           .setEncodingType(EncodingType.forNumber(0))
   *           .build();
   *   ApiFuture<AnnotateTextResponse> future =
   *       languageServiceClient.annotateTextCallable().futureCall(request);
   *   // Do something.
   *   AnnotateTextResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AnnotateTextRequest, AnnotateTextResponse> annotateTextCallable() {
    return stub.annotateTextCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
