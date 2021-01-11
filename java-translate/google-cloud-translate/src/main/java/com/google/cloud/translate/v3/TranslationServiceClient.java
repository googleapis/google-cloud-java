/*
 * Copyright 2020 Google LLC
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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
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
import com.google.longrunning.OperationsClient;
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
 * TranslationServiceSettings translationServiceSettings =
 *     TranslationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
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
  private final OperationsClient operationsClient;

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
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TranslationServiceClient(TranslationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final TranslationServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TranslationServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Translates input text and returns translated text.
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
   *     content be less than 30k codepoints. Use BatchTranslateText for larger text.
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
   *     content be less than 30k codepoints. Use BatchTranslateText for larger text.
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
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/base`
   *     <p>For global (non-regionalized) requests, use `location-id` `global`. For example,
   *     `projects/{project-number-or-id}/locations/global/models/general/nmt`.
   *     <p>If missing, the system decides which google base model to use.
   * @param mimeType Optional. The format of the source text, for example, "text/html",
   *     "text/plain". If left blank, the MIME type defaults to "text/html".
   * @param sourceLanguageCode Optional. The BCP-47 language code of the input text if known, for
   *     example, "en-US" or "sr-Latn". Supported language codes are listed in Language Support. If
   *     the source language isn't specified, the API attempts to identify the source language
   *     automatically and returns the source language within the response.
   * @param targetLanguageCode Required. The BCP-47 language code to use for translation of the
   *     input text, set to one of the language codes listed in Language Support.
   * @param contents Required. The content of the input in string format. We recommend the total
   *     content be less than 30k codepoints. Use BatchTranslateText for larger text.
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
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/base`
   *     <p>For global (non-regionalized) requests, use `location-id` `global`. For example,
   *     `projects/{project-number-or-id}/locations/global/models/general/nmt`.
   *     <p>If missing, the system decides which google base model to use.
   * @param mimeType Optional. The format of the source text, for example, "text/html",
   *     "text/plain". If left blank, the MIME type defaults to "text/html".
   * @param sourceLanguageCode Optional. The BCP-47 language code of the input text if known, for
   *     example, "en-US" or "sr-Latn". Supported language codes are listed in Language Support. If
   *     the source language isn't specified, the API attempts to identify the source language
   *     automatically and returns the source language within the response.
   * @param targetLanguageCode Required. The BCP-47 language code to use for translation of the
   *     input text, set to one of the language codes listed in Language Support.
   * @param contents Required. The content of the input in string format. We recommend the total
   *     content be less than 30k codepoints. Use BatchTranslateText for larger text.
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
   */
  public final UnaryCallable<TranslateTextRequest, TranslateTextResponse> translateTextCallable() {
    return stub.translateTextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detects the language of text within a request.
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
   */
  public final UnaryCallable<DetectLanguageRequest, DetectLanguageResponse>
      detectLanguageCallable() {
    return stub.detectLanguageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of supported languages for translation.
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
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/base`
   *     <p>Returns languages supported by the specified model. If missing, we get supported
   *     languages of Google general base (PBMT) model.
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
   *     `projects/{project-number-or-id}/locations/{location-id}/models/general/base`
   *     <p>Returns languages supported by the specified model. If missing, we get supported
   *     languages of Google general base (PBMT) model.
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
   */
  public final UnaryCallable<GetSupportedLanguagesRequest, SupportedLanguages>
      getSupportedLanguagesCallable() {
    return stub.getSupportedLanguagesCallable();
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
   */
  public final UnaryCallable<BatchTranslateTextRequest, Operation> batchTranslateTextCallable() {
    return stub.batchTranslateTextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
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
   */
  public final UnaryCallable<CreateGlossaryRequest, Operation> createGlossaryCallable() {
    return stub.createGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
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
   */
  public final UnaryCallable<ListGlossariesRequest, ListGlossariesResponse>
      listGlossariesCallable() {
    return stub.listGlossariesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist.
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
   */
  public final UnaryCallable<GetGlossaryRequest, Glossary> getGlossaryCallable() {
    return stub.getGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
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
          new ApiFunction<ListGlossariesPage, ListGlossariesPagedResponse>() {
            @Override
            public ListGlossariesPagedResponse apply(ListGlossariesPage input) {
              return new ListGlossariesPagedResponse(input);
            }
          },
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
