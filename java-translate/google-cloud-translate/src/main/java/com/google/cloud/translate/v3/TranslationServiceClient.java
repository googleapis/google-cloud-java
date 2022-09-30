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

package com.google.cloud.translate.v3;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.translate.v3.stub.TranslationServiceStub;
import com.google.cloud.translate.v3.stub.TranslationServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides natural language translation operations.
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
 * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   String targetLanguageCode = "targetLanguageCode-106414698";
 *   List<String> contents = new ArrayList<>();
 *   TranslateTextResponse response =
 *       translationServiceClient.translateText(parent, targetLanguageCode, contents);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TranslationServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of TranslationServiceSettings to
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
 * TranslationServiceSettings translationServiceSettings =
 *     TranslationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TranslationServiceClient translationServiceClient =
 *     TranslationServiceClient.create(translationServiceSettings);
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
 * TranslationServiceSettings translationServiceSettings =
 *     TranslationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TranslationServiceClient translationServiceClient =
 *     TranslationServiceClient.create(translationServiceSettings);
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
 * TranslationServiceSettings translationServiceSettings =
 *     TranslationServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             TranslationServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * TranslationServiceClient translationServiceClient =
 *     TranslationServiceClient.create(translationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TranslationServiceClient implements BackgroundResource {
  private final TranslationServiceSettings settings;
  private final TranslationServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of TranslationServiceClient with default settings. */
  public static final TranslationServiceClient create() throws IOException {
    return create(TranslationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TranslationServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TranslationServiceClient create(TranslationServiceSettings settings)
      throws IOException {
    return new TranslationServiceClient(settings);
  }

  /**
   * Constructs an instance of TranslationServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(TranslationServiceSettings).
   */
  public static final TranslationServiceClient create(TranslationServiceStub stub) {
    return new TranslationServiceClient(stub);
  }

  /**
   * Constructs an instance of TranslationServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TranslationServiceClient(TranslationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TranslationServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected TranslationServiceClient(TranslationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final TranslationServiceSettings getSettings() {
    return settings;
  }

  public TranslationServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String targetLanguageCode = "targetLanguageCode-106414698";
   *   List<String> contents = new ArrayList<>();
   *   TranslateTextResponse response =
   *       translationServiceClient.translateText(parent, targetLanguageCode, contents);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}` or
   *     `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Non-global location is required for requests using AutoML models or custom glossaries.
   *     <p>Models and glossaries must be within the same region (have same location-id), otherwise
   *     an INVALID_ARGUMENT (400) error is returned.
   * @param targetLanguageCode Required. The BCP-47 language code to use for translation of the
   *     input text, set to one of the language codes listed in Language Support.
   * @param contents Required. The content of the input in string format. We recommend the total
   *     content be less than 30k codepoints. The max length of this field is 1024. Use
   *     BatchTranslateText for larger text.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateTextResponse translateText(
      LocationName parent, String targetLanguageCode, List<String> contents) {
    TranslateTextRequest request =
        TranslateTextRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTargetLanguageCode(targetLanguageCode)
            .addAllContents(contents)
            .build();
    return translateText(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String targetLanguageCode = "targetLanguageCode-106414698";
   *   List<String> contents = new ArrayList<>();
   *   TranslateTextResponse response =
   *       translationServiceClient.translateText(parent, targetLanguageCode, contents);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}` or
   *     `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Non-global location is required for requests using AutoML models or custom glossaries.
   *     <p>Models and glossaries must be within the same region (have same location-id), otherwise
   *     an INVALID_ARGUMENT (400) error is returned.
   * @param targetLanguageCode Required. The BCP-47 language code to use for translation of the
   *     input text, set to one of the language codes listed in Language Support.
   * @param contents Required. The content of the input in string format. We recommend the total
   *     content be less than 30k codepoints. The max length of this field is 1024. Use
   *     BatchTranslateText for larger text.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateTextResponse translateText(
      String parent, String targetLanguageCode, List<String> contents) {
    TranslateTextRequest request =
        TranslateTextRequest.newBuilder()
            .setParent(parent)
            .setTargetLanguageCode(targetLanguageCode)
            .addAllContents(contents)
            .build();
    return translateText(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String model = "model104069929";
   *   String mimeType = "mimeType-1392120434";
   *   String sourceLanguageCode = "sourceLanguageCode1645917472";
   *   String targetLanguageCode = "targetLanguageCode-106414698";
   *   List<String> contents = new ArrayList<>();
   *   TranslateTextResponse response =
   *       translationServiceClient.translateText(
   *           parent, model, mimeType, sourceLanguageCode, targetLanguageCode, contents);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}` or
   *     `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Non-global location is required for requests using AutoML models or custom glossaries.
   *     <p>Models and glossaries must be within the same region (have same location-id), otherwise
   *     an INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. The `model` type requested for this translation.
   *     <p>The format depends on model type:
   *     <p>- AutoML Translation models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/{model-id}`
   *     <p>- General (built-in) models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/nmt`,
   *     <p>For global (non-regionalized) requests, use `location-id` `global`. For example,
   *     `projects/{project-number-or-id}/locations/global/models/general/nmt`.
   *     <p>If not provided, the default Google model (NMT) will be used.
   * @param mimeType Optional. The format of the source text, for example, "text/html",
   *     "text/plain". If left blank, the MIME type defaults to "text/html".
   * @param sourceLanguageCode Optional. The BCP-47 language code of the input text if known, for
   *     example, "en-US" or "sr-Latn". Supported language codes are listed in Language Support. If
   *     the source language isn't specified, the API attempts to identify the source language
   *     automatically and returns the source language within the response.
   * @param targetLanguageCode Required. The BCP-47 language code to use for translation of the
   *     input text, set to one of the language codes listed in Language Support.
   * @param contents Required. The content of the input in string format. We recommend the total
   *     content be less than 30k codepoints. The max length of this field is 1024. Use
   *     BatchTranslateText for larger text.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateTextResponse translateText(
      LocationName parent,
      String model,
      String mimeType,
      String sourceLanguageCode,
      String targetLanguageCode,
      List<String> contents) {
    TranslateTextRequest request =
        TranslateTextRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModel(model)
            .setMimeType(mimeType)
            .setSourceLanguageCode(sourceLanguageCode)
            .setTargetLanguageCode(targetLanguageCode)
            .addAllContents(contents)
            .build();
    return translateText(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String model = "model104069929";
   *   String mimeType = "mimeType-1392120434";
   *   String sourceLanguageCode = "sourceLanguageCode1645917472";
   *   String targetLanguageCode = "targetLanguageCode-106414698";
   *   List<String> contents = new ArrayList<>();
   *   TranslateTextResponse response =
   *       translationServiceClient.translateText(
   *           parent, model, mimeType, sourceLanguageCode, targetLanguageCode, contents);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}` or
   *     `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Non-global location is required for requests using AutoML models or custom glossaries.
   *     <p>Models and glossaries must be within the same region (have same location-id), otherwise
   *     an INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. The `model` type requested for this translation.
   *     <p>The format depends on model type:
   *     <p>- AutoML Translation models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/{model-id}`
   *     <p>- General (built-in) models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/nmt`,
   *     <p>For global (non-regionalized) requests, use `location-id` `global`. For example,
   *     `projects/{project-number-or-id}/locations/global/models/general/nmt`.
   *     <p>If not provided, the default Google model (NMT) will be used.
   * @param mimeType Optional. The format of the source text, for example, "text/html",
   *     "text/plain". If left blank, the MIME type defaults to "text/html".
   * @param sourceLanguageCode Optional. The BCP-47 language code of the input text if known, for
   *     example, "en-US" or "sr-Latn". Supported language codes are listed in Language Support. If
   *     the source language isn't specified, the API attempts to identify the source language
   *     automatically and returns the source language within the response.
   * @param targetLanguageCode Required. The BCP-47 language code to use for translation of the
   *     input text, set to one of the language codes listed in Language Support.
   * @param contents Required. The content of the input in string format. We recommend the total
   *     content be less than 30k codepoints. The max length of this field is 1024. Use
   *     BatchTranslateText for larger text.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateTextResponse translateText(
      String parent,
      String model,
      String mimeType,
      String sourceLanguageCode,
      String targetLanguageCode,
      List<String> contents) {
    TranslateTextRequest request =
        TranslateTextRequest.newBuilder()
            .setParent(parent)
            .setModel(model)
            .setMimeType(mimeType)
            .setSourceLanguageCode(sourceLanguageCode)
            .setTargetLanguageCode(targetLanguageCode)
            .addAllContents(contents)
            .build();
    return translateText(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   TranslateTextRequest request =
   *       TranslateTextRequest.newBuilder()
   *           .addAllContents(new ArrayList<String>())
   *           .setMimeType("mimeType-1392120434")
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .setTargetLanguageCode("targetLanguageCode-106414698")
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel("model104069929")
   *           .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   TranslateTextResponse response = translationServiceClient.translateText(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateTextResponse translateText(TranslateTextRequest request) {
    return translateTextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   TranslateTextRequest request =
   *       TranslateTextRequest.newBuilder()
   *           .addAllContents(new ArrayList<String>())
   *           .setMimeType("mimeType-1392120434")
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .setTargetLanguageCode("targetLanguageCode-106414698")
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel("model104069929")
   *           .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<TranslateTextResponse> future =
   *       translationServiceClient.translateTextCallable().futureCall(request);
   *   // Do something.
   *   TranslateTextResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TranslateTextRequest, TranslateTextResponse> translateTextCallable() {
    return stub.translateTextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detects the language of text within a request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String model = "model104069929";
   *   String mimeType = "mimeType-1392120434";
   *   String content = "content951530617";
   *   DetectLanguageResponse response =
   *       translationServiceClient.detectLanguage(parent, model, mimeType, content);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}/locations/{location-id}` or
   *     `projects/{project-number-or-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Only models within the same region (has same location-id) can be used. Otherwise an
   *     INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. The language detection model to be used.
   *     <p>Format:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/language-detection/{model-id}`
   *     <p>Only one language detection model is currently supported:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/language-detection/default`.
   *     <p>If not specified, the default model is used.
   * @param mimeType Optional. The format of the source text, for example, "text/html",
   *     "text/plain". If left blank, the MIME type defaults to "text/html".
   * @param content The content of the input stored as a string.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetectLanguageResponse detectLanguage(
      LocationName parent, String model, String mimeType, String content) {
    DetectLanguageRequest request =
        DetectLanguageRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModel(model)
            .setMimeType(mimeType)
            .setContent(content)
            .build();
    return detectLanguage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detects the language of text within a request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String model = "model104069929";
   *   String mimeType = "mimeType-1392120434";
   *   String content = "content951530617";
   *   DetectLanguageResponse response =
   *       translationServiceClient.detectLanguage(parent, model, mimeType, content);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}/locations/{location-id}` or
   *     `projects/{project-number-or-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Only models within the same region (has same location-id) can be used. Otherwise an
   *     INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. The language detection model to be used.
   *     <p>Format:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/language-detection/{model-id}`
   *     <p>Only one language detection model is currently supported:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/language-detection/default`.
   *     <p>If not specified, the default model is used.
   * @param mimeType Optional. The format of the source text, for example, "text/html",
   *     "text/plain". If left blank, the MIME type defaults to "text/html".
   * @param content The content of the input stored as a string.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetectLanguageResponse detectLanguage(
      String parent, String model, String mimeType, String content) {
    DetectLanguageRequest request =
        DetectLanguageRequest.newBuilder()
            .setParent(parent)
            .setModel(model)
            .setMimeType(mimeType)
            .setContent(content)
            .build();
    return detectLanguage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detects the language of text within a request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DetectLanguageRequest request =
   *       DetectLanguageRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel("model104069929")
   *           .setMimeType("mimeType-1392120434")
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   DetectLanguageResponse response = translationServiceClient.detectLanguage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetectLanguageResponse detectLanguage(DetectLanguageRequest request) {
    return detectLanguageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detects the language of text within a request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DetectLanguageRequest request =
   *       DetectLanguageRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModel("model104069929")
   *           .setMimeType("mimeType-1392120434")
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<DetectLanguageResponse> future =
   *       translationServiceClient.detectLanguageCallable().futureCall(request);
   *   // Do something.
   *   DetectLanguageResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DetectLanguageRequest, DetectLanguageResponse>
      detectLanguageCallable() {
    return stub.detectLanguageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of supported languages for translation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String model = "model104069929";
   *   String displayLanguageCode = "displayLanguageCode-1457478841";
   *   SupportedLanguages response =
   *       translationServiceClient.getSupportedLanguages(parent, model, displayLanguageCode);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}` or
   *     `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Non-global location is required for AutoML models.
   *     <p>Only models within the same region (have same location-id) can be used, otherwise an
   *     INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. Get supported languages of this model.
   *     <p>The format depends on model type:
   *     <p>- AutoML Translation models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/{model-id}`
   *     <p>- General (built-in) models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/nmt`,
   *     <p>Returns languages supported by the specified model. If missing, we get supported
   *     languages of Google general NMT model.
   * @param displayLanguageCode Optional. The language to use to return localized, human readable
   *     names of supported languages. If missing, then display names are not returned in a
   *     response.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportedLanguages getSupportedLanguages(
      LocationName parent, String model, String displayLanguageCode) {
    GetSupportedLanguagesRequest request =
        GetSupportedLanguagesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModel(model)
            .setDisplayLanguageCode(displayLanguageCode)
            .build();
    return getSupportedLanguages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of supported languages for translation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String model = "model104069929";
   *   String displayLanguageCode = "displayLanguageCode-1457478841";
   *   SupportedLanguages response =
   *       translationServiceClient.getSupportedLanguages(parent, model, displayLanguageCode);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-number-or-id}` or
   *     `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-number-or-id}/locations/global` or
   *     `projects/{project-number-or-id}`.
   *     <p>Non-global location is required for AutoML models.
   *     <p>Only models within the same region (have same location-id) can be used, otherwise an
   *     INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. Get supported languages of this model.
   *     <p>The format depends on model type:
   *     <p>- AutoML Translation models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/{model-id}`
   *     <p>- General (built-in) models:
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/nmt`,
   *     <p>Returns languages supported by the specified model. If missing, we get supported
   *     languages of Google general NMT model.
   * @param displayLanguageCode Optional. The language to use to return localized, human readable
   *     names of supported languages. If missing, then display names are not returned in a
   *     response.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportedLanguages getSupportedLanguages(
      String parent, String model, String displayLanguageCode) {
    GetSupportedLanguagesRequest request =
        GetSupportedLanguagesRequest.newBuilder()
            .setParent(parent)
            .setModel(model)
            .setDisplayLanguageCode(displayLanguageCode)
            .build();
    return getSupportedLanguages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of supported languages for translation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetSupportedLanguagesRequest request =
   *       GetSupportedLanguagesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDisplayLanguageCode("displayLanguageCode-1457478841")
   *           .setModel("model104069929")
   *           .build();
   *   SupportedLanguages response = translationServiceClient.getSupportedLanguages(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportedLanguages getSupportedLanguages(GetSupportedLanguagesRequest request) {
    return getSupportedLanguagesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of supported languages for translation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetSupportedLanguagesRequest request =
   *       GetSupportedLanguagesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDisplayLanguageCode("displayLanguageCode-1457478841")
   *           .setModel("model104069929")
   *           .build();
   *   ApiFuture<SupportedLanguages> future =
   *       translationServiceClient.getSupportedLanguagesCallable().futureCall(request);
   *   // Do something.
   *   SupportedLanguages response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSupportedLanguagesRequest, SupportedLanguages>
      getSupportedLanguagesCallable() {
    return stub.getSupportedLanguagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates documents in synchronous mode.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   TranslateDocumentRequest request =
   *       TranslateDocumentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .setTargetLanguageCode("targetLanguageCode-106414698")
   *           .setDocumentInputConfig(DocumentInputConfig.newBuilder().build())
   *           .setDocumentOutputConfig(DocumentOutputConfig.newBuilder().build())
   *           .setModel("model104069929")
   *           .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   TranslateDocumentResponse response = translationServiceClient.translateDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateDocumentResponse translateDocument(TranslateDocumentRequest request) {
    return translateDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates documents in synchronous mode.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   TranslateDocumentRequest request =
   *       TranslateDocumentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .setTargetLanguageCode("targetLanguageCode-106414698")
   *           .setDocumentInputConfig(DocumentInputConfig.newBuilder().build())
   *           .setDocumentOutputConfig(DocumentOutputConfig.newBuilder().build())
   *           .setModel("model104069929")
   *           .setGlossaryConfig(TranslateTextGlossaryConfig.newBuilder().build())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<TranslateDocumentResponse> future =
   *       translationServiceClient.translateDocumentCallable().futureCall(request);
   *   // Do something.
   *   TranslateDocumentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TranslateDocumentRequest, TranslateDocumentResponse>
      translateDocumentCallable() {
    return stub.translateDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of text in asynchronous batch mode. This function provides real-time
   * output as the inputs are being processed. If caller cancels a request, the partial results (for
   * an input file, it's all or nothing) may still be available on the specified output location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   BatchTranslateTextRequest request =
   *       BatchTranslateTextRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .addAllTargetLanguageCodes(new ArrayList<String>())
   *           .putAllModels(new HashMap<String, String>())
   *           .addAllInputConfigs(new ArrayList<InputConfig>())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   BatchTranslateResponse response =
   *       translationServiceClient.batchTranslateTextAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchTranslateResponse, BatchTranslateMetadata>
      batchTranslateTextAsync(BatchTranslateTextRequest request) {
    return batchTranslateTextOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of text in asynchronous batch mode. This function provides real-time
   * output as the inputs are being processed. If caller cancels a request, the partial results (for
   * an input file, it's all or nothing) may still be available on the specified output location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   BatchTranslateTextRequest request =
   *       BatchTranslateTextRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .addAllTargetLanguageCodes(new ArrayList<String>())
   *           .putAllModels(new HashMap<String, String>())
   *           .addAllInputConfigs(new ArrayList<InputConfig>())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   OperationFuture<BatchTranslateResponse, BatchTranslateMetadata> future =
   *       translationServiceClient.batchTranslateTextOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchTranslateResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchTranslateTextRequest, BatchTranslateResponse, BatchTranslateMetadata>
      batchTranslateTextOperationCallable() {
    return stub.batchTranslateTextOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of text in asynchronous batch mode. This function provides real-time
   * output as the inputs are being processed. If caller cancels a request, the partial results (for
   * an input file, it's all or nothing) may still be available on the specified output location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   BatchTranslateTextRequest request =
   *       BatchTranslateTextRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .addAllTargetLanguageCodes(new ArrayList<String>())
   *           .putAllModels(new HashMap<String, String>())
   *           .addAllInputConfigs(new ArrayList<InputConfig>())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.batchTranslateTextCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchTranslateTextRequest, Operation> batchTranslateTextCallable() {
    return stub.batchTranslateTextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of document in asynchronous batch mode. This function provides
   * real-time output as the inputs are being processed. If caller cancels a request, the partial
   * results (for an input file, it's all or nothing) may still be available on the specified output
   * location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String sourceLanguageCode = "sourceLanguageCode1645917472";
   *   List<String> targetLanguageCodes = new ArrayList<>();
   *   List<BatchDocumentInputConfig> inputConfigs = new ArrayList<>();
   *   BatchDocumentOutputConfig outputConfig = BatchDocumentOutputConfig.newBuilder().build();
   *   BatchTranslateDocumentResponse response =
   *       translationServiceClient
   *           .batchTranslateDocumentAsync(
   *               parent, sourceLanguageCode, targetLanguageCodes, inputConfigs, outputConfig)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Location to make a regional call.
   *     <p>Format: `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>The `global` location is not supported for batch translation.
   *     <p>Only AutoML Translation models or glossaries within the same region (have the same
   *     location-id) can be used, otherwise an INVALID_ARGUMENT (400) error is returned.
   * @param sourceLanguageCode Required. The BCP-47 language code of the input document if known,
   *     for example, "en-US" or "sr-Latn". Supported language codes are listed in Language Support
   *     (https://cloud.google.com/translate/docs/languages).
   * @param targetLanguageCodes Required. The BCP-47 language code to use for translation of the
   *     input document. Specify up to 10 language codes here.
   * @param inputConfigs Required. Input configurations. The total number of files matched should be
   *     &lt;= 100. The total content size to translate should be &lt;= 100M Unicode codepoints. The
   *     files must use UTF-8 encoding.
   * @param outputConfig Required. Output configuration. If 2 input configs match to the same file
   *     (that is, same input path), we don't generate output for duplicate inputs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchTranslateDocumentResponse, BatchTranslateDocumentMetadata>
      batchTranslateDocumentAsync(
          LocationName parent,
          String sourceLanguageCode,
          List<String> targetLanguageCodes,
          List<BatchDocumentInputConfig> inputConfigs,
          BatchDocumentOutputConfig outputConfig) {
    BatchTranslateDocumentRequest request =
        BatchTranslateDocumentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSourceLanguageCode(sourceLanguageCode)
            .addAllTargetLanguageCodes(targetLanguageCodes)
            .addAllInputConfigs(inputConfigs)
            .setOutputConfig(outputConfig)
            .build();
    return batchTranslateDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of document in asynchronous batch mode. This function provides
   * real-time output as the inputs are being processed. If caller cancels a request, the partial
   * results (for an input file, it's all or nothing) may still be available on the specified output
   * location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String sourceLanguageCode = "sourceLanguageCode1645917472";
   *   List<String> targetLanguageCodes = new ArrayList<>();
   *   List<BatchDocumentInputConfig> inputConfigs = new ArrayList<>();
   *   BatchDocumentOutputConfig outputConfig = BatchDocumentOutputConfig.newBuilder().build();
   *   BatchTranslateDocumentResponse response =
   *       translationServiceClient
   *           .batchTranslateDocumentAsync(
   *               parent, sourceLanguageCode, targetLanguageCodes, inputConfigs, outputConfig)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Location to make a regional call.
   *     <p>Format: `projects/{project-number-or-id}/locations/{location-id}`.
   *     <p>The `global` location is not supported for batch translation.
   *     <p>Only AutoML Translation models or glossaries within the same region (have the same
   *     location-id) can be used, otherwise an INVALID_ARGUMENT (400) error is returned.
   * @param sourceLanguageCode Required. The BCP-47 language code of the input document if known,
   *     for example, "en-US" or "sr-Latn". Supported language codes are listed in Language Support
   *     (https://cloud.google.com/translate/docs/languages).
   * @param targetLanguageCodes Required. The BCP-47 language code to use for translation of the
   *     input document. Specify up to 10 language codes here.
   * @param inputConfigs Required. Input configurations. The total number of files matched should be
   *     &lt;= 100. The total content size to translate should be &lt;= 100M Unicode codepoints. The
   *     files must use UTF-8 encoding.
   * @param outputConfig Required. Output configuration. If 2 input configs match to the same file
   *     (that is, same input path), we don't generate output for duplicate inputs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchTranslateDocumentResponse, BatchTranslateDocumentMetadata>
      batchTranslateDocumentAsync(
          String parent,
          String sourceLanguageCode,
          List<String> targetLanguageCodes,
          List<BatchDocumentInputConfig> inputConfigs,
          BatchDocumentOutputConfig outputConfig) {
    BatchTranslateDocumentRequest request =
        BatchTranslateDocumentRequest.newBuilder()
            .setParent(parent)
            .setSourceLanguageCode(sourceLanguageCode)
            .addAllTargetLanguageCodes(targetLanguageCodes)
            .addAllInputConfigs(inputConfigs)
            .setOutputConfig(outputConfig)
            .build();
    return batchTranslateDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of document in asynchronous batch mode. This function provides
   * real-time output as the inputs are being processed. If caller cancels a request, the partial
   * results (for an input file, it's all or nothing) may still be available on the specified output
   * location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   BatchTranslateDocumentRequest request =
   *       BatchTranslateDocumentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .addAllTargetLanguageCodes(new ArrayList<String>())
   *           .addAllInputConfigs(new ArrayList<BatchDocumentInputConfig>())
   *           .setOutputConfig(BatchDocumentOutputConfig.newBuilder().build())
   *           .putAllModels(new HashMap<String, String>())
   *           .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
   *           .putAllFormatConversions(new HashMap<String, String>())
   *           .build();
   *   BatchTranslateDocumentResponse response =
   *       translationServiceClient.batchTranslateDocumentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchTranslateDocumentResponse, BatchTranslateDocumentMetadata>
      batchTranslateDocumentAsync(BatchTranslateDocumentRequest request) {
    return batchTranslateDocumentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of document in asynchronous batch mode. This function provides
   * real-time output as the inputs are being processed. If caller cancels a request, the partial
   * results (for an input file, it's all or nothing) may still be available on the specified output
   * location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   BatchTranslateDocumentRequest request =
   *       BatchTranslateDocumentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .addAllTargetLanguageCodes(new ArrayList<String>())
   *           .addAllInputConfigs(new ArrayList<BatchDocumentInputConfig>())
   *           .setOutputConfig(BatchDocumentOutputConfig.newBuilder().build())
   *           .putAllModels(new HashMap<String, String>())
   *           .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
   *           .putAllFormatConversions(new HashMap<String, String>())
   *           .build();
   *   OperationFuture<BatchTranslateDocumentResponse, BatchTranslateDocumentMetadata> future =
   *       translationServiceClient.batchTranslateDocumentOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchTranslateDocumentResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchTranslateDocumentRequest,
          BatchTranslateDocumentResponse,
          BatchTranslateDocumentMetadata>
      batchTranslateDocumentOperationCallable() {
    return stub.batchTranslateDocumentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates a large volume of document in asynchronous batch mode. This function provides
   * real-time output as the inputs are being processed. If caller cancels a request, the partial
   * results (for an input file, it's all or nothing) may still be available on the specified output
   * location.
   *
   * <p>This call returns immediately and you can use google.longrunning.Operation.name to poll the
   * status of the call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   BatchTranslateDocumentRequest request =
   *       BatchTranslateDocumentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceLanguageCode("sourceLanguageCode1645917472")
   *           .addAllTargetLanguageCodes(new ArrayList<String>())
   *           .addAllInputConfigs(new ArrayList<BatchDocumentInputConfig>())
   *           .setOutputConfig(BatchDocumentOutputConfig.newBuilder().build())
   *           .putAllModels(new HashMap<String, String>())
   *           .putAllGlossaries(new HashMap<String, TranslateTextGlossaryConfig>())
   *           .putAllFormatConversions(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.batchTranslateDocumentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchTranslateDocumentRequest, Operation>
      batchTranslateDocumentCallable() {
    return stub.batchTranslateDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Glossary glossary = Glossary.newBuilder().build();
   *   Glossary response = translationServiceClient.createGlossaryAsync(parent, glossary).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project name.
   * @param glossary Required. The glossary to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Glossary, CreateGlossaryMetadata> createGlossaryAsync(
      LocationName parent, Glossary glossary) {
    CreateGlossaryRequest request =
        CreateGlossaryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGlossary(glossary)
            .build();
    return createGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Glossary glossary = Glossary.newBuilder().build();
   *   Glossary response = translationServiceClient.createGlossaryAsync(parent, glossary).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project name.
   * @param glossary Required. The glossary to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Glossary, CreateGlossaryMetadata> createGlossaryAsync(
      String parent, Glossary glossary) {
    CreateGlossaryRequest request =
        CreateGlossaryRequest.newBuilder().setParent(parent).setGlossary(glossary).build();
    return createGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateGlossaryRequest request =
   *       CreateGlossaryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGlossary(Glossary.newBuilder().build())
   *           .build();
   *   Glossary response = translationServiceClient.createGlossaryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Glossary, CreateGlossaryMetadata> createGlossaryAsync(
      CreateGlossaryRequest request) {
    return createGlossaryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateGlossaryRequest request =
   *       CreateGlossaryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGlossary(Glossary.newBuilder().build())
   *           .build();
   *   OperationFuture<Glossary, CreateGlossaryMetadata> future =
   *       translationServiceClient.createGlossaryOperationCallable().futureCall(request);
   *   // Do something.
   *   Glossary response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateGlossaryRequest, Glossary, CreateGlossaryMetadata>
      createGlossaryOperationCallable() {
    return stub.createGlossaryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   CreateGlossaryRequest request =
   *       CreateGlossaryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGlossary(Glossary.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.createGlossaryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGlossaryRequest, Operation> createGlossaryCallable() {
    return stub.createGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Glossary element : translationServiceClient.listGlossaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project from which to list all of the glossaries.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossariesPagedResponse listGlossaries(LocationName parent) {
    ListGlossariesRequest request =
        ListGlossariesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGlossaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Glossary element : translationServiceClient.listGlossaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project from which to list all of the glossaries.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossariesPagedResponse listGlossaries(String parent) {
    ListGlossariesRequest request = ListGlossariesRequest.newBuilder().setParent(parent).build();
    return listGlossaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListGlossariesRequest request =
   *       ListGlossariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Glossary element : translationServiceClient.listGlossaries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossariesPagedResponse listGlossaries(ListGlossariesRequest request) {
    return listGlossariesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListGlossariesRequest request =
   *       ListGlossariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Glossary> future =
   *       translationServiceClient.listGlossariesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Glossary element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGlossariesRequest, ListGlossariesPagedResponse>
      listGlossariesPagedCallable() {
    return stub.listGlossariesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListGlossariesRequest request =
   *       ListGlossariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListGlossariesResponse response =
   *         translationServiceClient.listGlossariesCallable().call(request);
   *     for (Glossary element : response.getGlossariesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGlossariesRequest, ListGlossariesResponse>
      listGlossariesCallable() {
    return stub.listGlossariesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   Glossary response = translationServiceClient.getGlossary(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the glossary to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Glossary getGlossary(GlossaryName name) {
    GetGlossaryRequest request =
        GetGlossaryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGlossary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString();
   *   Glossary response = translationServiceClient.getGlossary(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the glossary to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Glossary getGlossary(String name) {
    GetGlossaryRequest request = GetGlossaryRequest.newBuilder().setName(name).build();
    return getGlossary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetGlossaryRequest request =
   *       GetGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .build();
   *   Glossary response = translationServiceClient.getGlossary(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Glossary getGlossary(GetGlossaryRequest request) {
    return getGlossaryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetGlossaryRequest request =
   *       GetGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .build();
   *   ApiFuture<Glossary> future =
   *       translationServiceClient.getGlossaryCallable().futureCall(request);
   *   // Do something.
   *   Glossary response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGlossaryRequest, Glossary> getGlossaryCallable() {
    return stub.getGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   DeleteGlossaryResponse response = translationServiceClient.deleteGlossaryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the glossary to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeleteGlossaryResponse, DeleteGlossaryMetadata> deleteGlossaryAsync(
      GlossaryName name) {
    DeleteGlossaryRequest request =
        DeleteGlossaryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString();
   *   DeleteGlossaryResponse response = translationServiceClient.deleteGlossaryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the glossary to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeleteGlossaryResponse, DeleteGlossaryMetadata> deleteGlossaryAsync(
      String name) {
    DeleteGlossaryRequest request = DeleteGlossaryRequest.newBuilder().setName(name).build();
    return deleteGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteGlossaryRequest request =
   *       DeleteGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .build();
   *   DeleteGlossaryResponse response = translationServiceClient.deleteGlossaryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeleteGlossaryResponse, DeleteGlossaryMetadata> deleteGlossaryAsync(
      DeleteGlossaryRequest request) {
    return deleteGlossaryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteGlossaryRequest request =
   *       DeleteGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .build();
   *   OperationFuture<DeleteGlossaryResponse, DeleteGlossaryMetadata> future =
   *       translationServiceClient.deleteGlossaryOperationCallable().futureCall(request);
   *   // Do something.
   *   DeleteGlossaryResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteGlossaryRequest, DeleteGlossaryResponse, DeleteGlossaryMetadata>
      deleteGlossaryOperationCallable() {
    return stub.deleteGlossaryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DeleteGlossaryRequest request =
   *       DeleteGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       translationServiceClient.deleteGlossaryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGlossaryRequest, Operation> deleteGlossaryCallable() {
    return stub.deleteGlossaryCallable();
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

  public static class ListGlossariesPagedResponse
      extends AbstractPagedListResponse<
          ListGlossariesRequest,
          ListGlossariesResponse,
          Glossary,
          ListGlossariesPage,
          ListGlossariesFixedSizeCollection> {

    public static ApiFuture<ListGlossariesPagedResponse> createAsync(
        PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> context,
        ApiFuture<ListGlossariesResponse> futureResponse) {
      ApiFuture<ListGlossariesPage> futurePage =
          ListGlossariesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGlossariesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGlossariesPagedResponse(ListGlossariesPage page) {
      super(page, ListGlossariesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGlossariesPage
      extends AbstractPage<
          ListGlossariesRequest, ListGlossariesResponse, Glossary, ListGlossariesPage> {

    private ListGlossariesPage(
        PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> context,
        ListGlossariesResponse response) {
      super(context, response);
    }

    private static ListGlossariesPage createEmptyPage() {
      return new ListGlossariesPage(null, null);
    }

    @Override
    protected ListGlossariesPage createPage(
        PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> context,
        ListGlossariesResponse response) {
      return new ListGlossariesPage(context, response);
    }

    @Override
    public ApiFuture<ListGlossariesPage> createPageAsync(
        PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> context,
        ApiFuture<ListGlossariesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGlossariesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlossariesRequest,
          ListGlossariesResponse,
          Glossary,
          ListGlossariesPage,
          ListGlossariesFixedSizeCollection> {

    private ListGlossariesFixedSizeCollection(List<ListGlossariesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGlossariesFixedSizeCollection createEmptyCollection() {
      return new ListGlossariesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGlossariesFixedSizeCollection createCollection(
        List<ListGlossariesPage> pages, int collectionSize) {
      return new ListGlossariesFixedSizeCollection(pages, collectionSize);
    }
  }
}
