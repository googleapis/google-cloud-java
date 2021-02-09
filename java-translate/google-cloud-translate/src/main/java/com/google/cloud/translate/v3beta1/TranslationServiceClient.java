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

package com.google.cloud.translate.v3beta1;

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
import com.google.cloud.translate.v3beta1.stub.TranslationServiceStub;
import com.google.cloud.translate.v3beta1.stub.TranslationServiceStubSettings;
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
 * <pre>{@code
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
@BetaApi
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
   * <p>Sample code:
   *
   * <pre>{@code
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String model = "model104069929";
   *   String mimeType = "mimeType-1392120434";
   *   DetectLanguageResponse response =
   *       translationServiceClient.detectLanguage(parent, model, mimeType);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-id}/locations/{location-id}` or `projects/{project-id}`.
   *     <p>For global calls, use `projects/{project-id}/locations/global` or
   *     `projects/{project-id}`.
   *     <p>Only models within the same region (has same location-id) can be used. Otherwise an
   *     INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. The language detection model to be used.
   *     <p>Format:
   *     `projects/{project-id}/locations/{location-id}/models/language-detection/{model-id}`
   *     <p>Only one language detection model is currently supported:
   *     `projects/{project-id}/locations/{location-id}/models/language-detection/default`.
   *     <p>If not specified, the default model is used.
   * @param mimeType Optional. The format of the source text, for example, "text/html",
   *     "text/plain". If left blank, the MIME type defaults to "text/html".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetectLanguageResponse detectLanguage(
      LocationName parent, String model, String mimeType) {
    DetectLanguageRequest request =
        DetectLanguageRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModel(model)
            .setMimeType(mimeType)
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String model = "model104069929";
   *   String mimeType = "mimeType-1392120434";
   *   DetectLanguageResponse response =
   *       translationServiceClient.detectLanguage(parent, model, mimeType);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-id}/locations/{location-id}` or `projects/{project-id}`.
   *     <p>For global calls, use `projects/{project-id}/locations/global` or
   *     `projects/{project-id}`.
   *     <p>Only models within the same region (has same location-id) can be used. Otherwise an
   *     INVALID_ARGUMENT (400) error is returned.
   * @param model Optional. The language detection model to be used.
   *     <p>Format:
   *     `projects/{project-id}/locations/{location-id}/models/language-detection/{model-id}`
   *     <p>Only one language detection model is currently supported:
   *     `projects/{project-id}/locations/{location-id}/models/language-detection/default`.
   *     <p>If not specified, the default model is used.
   * @param mimeType Optional. The format of the source text, for example, "text/html",
   *     "text/plain". If left blank, the MIME type defaults to "text/html".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetectLanguageResponse detectLanguage(String parent, String model, String mimeType) {
    DetectLanguageRequest request =
        DetectLanguageRequest.newBuilder()
            .setParent(parent)
            .setModel(model)
            .setMimeType(mimeType)
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String displayLanguageCode = "displayLanguageCode-1457478841";
   *   String model = "model104069929";
   *   SupportedLanguages response =
   *       translationServiceClient.getSupportedLanguages(parent, displayLanguageCode, model);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-id}` or `projects/{project-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-id}/locations/global` or
   *     `projects/{project-id}`.
   *     <p>Non-global location is required for AutoML models.
   *     <p>Only models within the same region (have same location-id) can be used, otherwise an
   *     INVALID_ARGUMENT (400) error is returned.
   * @param displayLanguageCode Optional. The language to use to return localized, human readable
   *     names of supported languages. If missing, then display names are not returned in a
   *     response.
   * @param model Optional. Get supported languages of this model.
   *     <p>The format depends on model type:
   *     <p>- AutoML Translation models:
   *     `projects/{project-id}/locations/{location-id}/models/{model-id}`
   *     <p>- General (built-in) models:
   *     `projects/{project-id}/locations/{location-id}/models/general/nmt`,
   *     `projects/{project-id}/locations/{location-id}/models/general/base`
   *     <p>Returns languages supported by the specified model. If missing, we get supported
   *     languages of Google general base (PBMT) model.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportedLanguages getSupportedLanguages(
      LocationName parent, String displayLanguageCode, String model) {
    GetSupportedLanguagesRequest request =
        GetSupportedLanguagesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDisplayLanguageCode(displayLanguageCode)
            .setModel(model)
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String displayLanguageCode = "displayLanguageCode-1457478841";
   *   String model = "model104069929";
   *   SupportedLanguages response =
   *       translationServiceClient.getSupportedLanguages(parent, displayLanguageCode, model);
   * }
   * }</pre>
   *
   * @param parent Required. Project or location to make a call. Must refer to a caller's project.
   *     <p>Format: `projects/{project-id}` or `projects/{project-id}/locations/{location-id}`.
   *     <p>For global calls, use `projects/{project-id}/locations/global` or
   *     `projects/{project-id}`.
   *     <p>Non-global location is required for AutoML models.
   *     <p>Only models within the same region (have same location-id) can be used, otherwise an
   *     INVALID_ARGUMENT (400) error is returned.
   * @param displayLanguageCode Optional. The language to use to return localized, human readable
   *     names of supported languages. If missing, then display names are not returned in a
   *     response.
   * @param model Optional. Get supported languages of this model.
   *     <p>The format depends on model type:
   *     <p>- AutoML Translation models:
   *     `projects/{project-id}/locations/{location-id}/models/{model-id}`
   *     <p>- General (built-in) models:
   *     `projects/{project-id}/locations/{location-id}/models/general/nmt`,
   *     `projects/{project-id}/locations/{location-id}/models/general/base`
   *     <p>Returns languages supported by the specified model. If missing, we get supported
   *     languages of Google general base (PBMT) model.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportedLanguages getSupportedLanguages(
      String parent, String displayLanguageCode, String model) {
    GetSupportedLanguagesRequest request =
        GetSupportedLanguagesRequest.newBuilder()
            .setParent(parent)
            .setDisplayLanguageCode(displayLanguageCode)
            .setModel(model)
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
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String filter = "filter-1274492040";
   *   for (Glossary element :
   *       translationServiceClient.listGlossaries(parent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project from which to list all of the glossaries.
   * @param filter Optional. Filter specifying constraints of a list operation. Filtering is not
   *     supported yet, and the parameter currently has no effect. If missing, no filtering is
   *     performed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossariesPagedResponse listGlossaries(LocationName parent, String filter) {
    ListGlossariesRequest request =
        ListGlossariesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String filter = "filter-1274492040";
   *   for (Glossary element :
   *       translationServiceClient.listGlossaries(parent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project from which to list all of the glossaries.
   * @param filter Optional. Filter specifying constraints of a list operation. Filtering is not
   *     supported yet, and the parameter currently has no effect. If missing, no filtering is
   *     performed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossariesPagedResponse listGlossaries(String parent, String filter) {
    ListGlossariesRequest request =
        ListGlossariesRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listGlossaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
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
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   while (true) {
   *     ListGlossariesResponse response =
   *         translationServiceClient.listGlossariesCallable().call(request);
   *     for (Glossary element : response.getResponsesList()) {
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
