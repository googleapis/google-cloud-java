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
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.translate.v3beta1.stub.TranslationServiceStub;
import com.google.cloud.translate.v3beta1.stub.TranslationServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Provides natural language translation operations.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
 *   String formattedParent = TranslationServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
 *   String model = "";
 *   String mimeType = "";
 *   DetectLanguageResponse response = translationServiceClient.detectLanguage(formattedParent, model, mimeType);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the translationServiceClient object to clean up resources
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
 * <pre>
 * <code>
 * TranslationServiceSettings translationServiceSettings =
 *     TranslationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TranslationServiceClient translationServiceClient =
 *     TranslationServiceClient.create(translationServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * TranslationServiceSettings translationServiceSettings =
 *     TranslationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TranslationServiceClient translationServiceClient =
 *     TranslationServiceClient.create(translationServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TranslationServiceClient implements BackgroundResource {
  private final TranslationServiceSettings settings;
  private final TranslationServiceStub stub;
  private final OperationsClient operationsClient;

  private static final PathTemplate LOCATION_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}");

  private static final PathTemplate GLOSSARY_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/glossaries/{glossary}");

  /**
   * Formats a string containing the fully-qualified path to represent a location resource.
   *
   * @deprecated Use the {@link LocationName} class instead.
   */
  @Deprecated
  public static final String formatLocationName(String project, String location) {
    return LOCATION_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location);
  }

  /**
   * Formats a string containing the fully-qualified path to represent a glossary resource.
   *
   * @deprecated Use the {@link GlossaryName} class instead.
   */
  @Deprecated
  public static final String formatGlossaryName(String project, String location, String glossary) {
    return GLOSSARY_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "glossary", glossary);
  }

  /**
   * Parses the project from the given fully-qualified path which represents a location resource.
   *
   * @deprecated Use the {@link LocationName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromLocationName(String locationName) {
    return LOCATION_PATH_TEMPLATE.parse(locationName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a location resource.
   *
   * @deprecated Use the {@link LocationName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromLocationName(String locationName) {
    return LOCATION_PATH_TEMPLATE.parse(locationName).get("location");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a glossary resource.
   *
   * @deprecated Use the {@link GlossaryName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromGlossaryName(String glossaryName) {
    return GLOSSARY_PATH_TEMPLATE.parse(glossaryName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a glossary resource.
   *
   * @deprecated Use the {@link GlossaryName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromGlossaryName(String glossaryName) {
    return GLOSSARY_PATH_TEMPLATE.parse(glossaryName).get("location");
  }

  /**
   * Parses the glossary from the given fully-qualified path which represents a glossary resource.
   *
   * @deprecated Use the {@link GlossaryName} class instead.
   */
  @Deprecated
  public static final String parseGlossaryFromGlossaryName(String glossaryName) {
    return GLOSSARY_PATH_TEMPLATE.parse(glossaryName).get("glossary");
  }

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
   * is for advanced usage - prefer to use TranslationServiceSettings}.
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
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   List&lt;String&gt; contents = new ArrayList&lt;&gt;();
   *   String targetLanguageCode = "";
   *   TranslateTextRequest request = TranslateTextRequest.newBuilder()
   *     .addAllContents(contents)
   *     .setTargetLanguageCode(targetLanguageCode)
   *     .build();
   *   TranslateTextResponse response = translationServiceClient.translateText(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TranslateTextResponse translateText(TranslateTextRequest request) {
    return translateTextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Translates input text and returns translated text.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   List&lt;String&gt; contents = new ArrayList&lt;&gt;();
   *   String targetLanguageCode = "";
   *   TranslateTextRequest request = TranslateTextRequest.newBuilder()
   *     .addAllContents(contents)
   *     .setTargetLanguageCode(targetLanguageCode)
   *     .build();
   *   ApiFuture&lt;TranslateTextResponse&gt; future = translationServiceClient.translateTextCallable().futureCall(request);
   *   // Do something
   *   TranslateTextResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TranslateTextRequest, TranslateTextResponse> translateTextCallable() {
    return stub.translateTextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detects the language of text within a request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedParent = TranslationServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String model = "";
   *   String mimeType = "";
   *   DetectLanguageResponse response = translationServiceClient.detectLanguage(formattedParent, model, mimeType);
   * }
   * </code></pre>
   *
   * @param parent Optional. Only used when making regionalized call. Format:
   *     projects/{project-id}/locations/{location-id}.
   *     <p>Only custom model within the same location-id can be used. Otherwise 400 is returned.
   * @param model Optional. The language detection model to be used.
   *     projects/{project-id}/locations/{location-id}/models/language-detection/{model-id} If not
   *     specified, default will be used.
   * @param mimeType Optional. The format of the source text, for example, "text/html",
   *     "text/plain". If left blank, the MIME type is assumed to be "text/html".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetectLanguageResponse detectLanguage(String parent, String model, String mimeType) {
    if (!parent.isEmpty()) {
      LOCATION_PATH_TEMPLATE.validate(parent, "detectLanguage");
    }
    DetectLanguageRequest request =
        DetectLanguageRequest.newBuilder()
            .setParent(parent)
            .setModel(model)
            .setMimeType(mimeType)
            .build();
    return detectLanguage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detects the language of text within a request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DetectLanguageRequest request = DetectLanguageRequest.newBuilder().build();
   *   DetectLanguageResponse response = translationServiceClient.detectLanguage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DetectLanguageResponse detectLanguage(DetectLanguageRequest request) {
    return detectLanguageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detects the language of text within a request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   DetectLanguageRequest request = DetectLanguageRequest.newBuilder().build();
   *   ApiFuture&lt;DetectLanguageResponse&gt; future = translationServiceClient.detectLanguageCallable().futureCall(request);
   *   // Do something
   *   DetectLanguageResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DetectLanguageRequest, DetectLanguageResponse>
      detectLanguageCallable() {
    return stub.detectLanguageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a list of supported languages for translation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedParent = TranslationServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String displayLanguageCode = "";
   *   String model = "";
   *   SupportedLanguages response = translationServiceClient.getSupportedLanguages(formattedParent, displayLanguageCode, model);
   * }
   * </code></pre>
   *
   * @param parent Optional. Used for making regionalized calls. Format:
   *     projects/{project-id}/locations/{location-id}. For global calls, use
   *     projects/{project-id}/locations/global. If missing, the call is treated as a global call.
   *     <p>Only custom model within the same location-id can be used. Otherwise 400 is returned.
   * @param displayLanguageCode Optional. The language to use to return localized, human readable
   *     names of supported languages. If missing, default language is ENGLISH.
   * @param model Optional. Get supported languages of this model. The format depends on model type:
   *     1. Custom models: projects/{project-id}/locations/{location-id}/models/{model-id}. 2.
   *     General (built-in) models: projects/{project-id}/locations/{location-id}/models/general/nmt
   *     projects/{project-id}/locations/{location-id}/models/general/base Returns languages
   *     supported by the specified model. If missing, we get supported languages of Google general
   *     NMT model.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportedLanguages getSupportedLanguages(
      String parent, String displayLanguageCode, String model) {
    if (!parent.isEmpty()) {
      LOCATION_PATH_TEMPLATE.validate(parent, "getSupportedLanguages");
    }
    GetSupportedLanguagesRequest request =
        GetSupportedLanguagesRequest.newBuilder()
            .setParent(parent)
            .setDisplayLanguageCode(displayLanguageCode)
            .setModel(model)
            .build();
    return getSupportedLanguages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a list of supported languages for translation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetSupportedLanguagesRequest request = GetSupportedLanguagesRequest.newBuilder().build();
   *   SupportedLanguages response = translationServiceClient.getSupportedLanguages(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SupportedLanguages getSupportedLanguages(GetSupportedLanguagesRequest request) {
    return getSupportedLanguagesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a list of supported languages for translation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   GetSupportedLanguagesRequest request = GetSupportedLanguagesRequest.newBuilder().build();
   *   ApiFuture&lt;SupportedLanguages&gt; future = translationServiceClient.getSupportedLanguagesCallable().futureCall(request);
   *   // Do something
   *   SupportedLanguages response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetSupportedLanguagesRequest, SupportedLanguages>
      getSupportedLanguagesCallable() {
    return stub.getSupportedLanguagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String sourceLanguageCode = "";
   *   List&lt;String&gt; targetLanguageCodes = new ArrayList&lt;&gt;();
   *   List&lt;InputConfig&gt; inputConfigs = new ArrayList&lt;&gt;();
   *   OutputConfig outputConfig = OutputConfig.newBuilder().build();
   *   BatchTranslateTextRequest request = BatchTranslateTextRequest.newBuilder()
   *     .setSourceLanguageCode(sourceLanguageCode)
   *     .addAllTargetLanguageCodes(targetLanguageCodes)
   *     .addAllInputConfigs(inputConfigs)
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   BatchTranslateResponse response = translationServiceClient.batchTranslateTextAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<BatchTranslateResponse, BatchTranslateMetadata>
      batchTranslateTextAsync(BatchTranslateTextRequest request) {
    return batchTranslateTextOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String sourceLanguageCode = "";
   *   List&lt;String&gt; targetLanguageCodes = new ArrayList&lt;&gt;();
   *   List&lt;InputConfig&gt; inputConfigs = new ArrayList&lt;&gt;();
   *   OutputConfig outputConfig = OutputConfig.newBuilder().build();
   *   BatchTranslateTextRequest request = BatchTranslateTextRequest.newBuilder()
   *     .setSourceLanguageCode(sourceLanguageCode)
   *     .addAllTargetLanguageCodes(targetLanguageCodes)
   *     .addAllInputConfigs(inputConfigs)
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   OperationFuture&lt;BatchTranslateResponse, BatchTranslateMetadata&gt; future = translationServiceClient.batchTranslateTextOperationCallable().futureCall(request);
   *   // Do something
   *   BatchTranslateResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<
          BatchTranslateTextRequest, BatchTranslateResponse, BatchTranslateMetadata>
      batchTranslateTextOperationCallable() {
    return stub.batchTranslateTextOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String sourceLanguageCode = "";
   *   List&lt;String&gt; targetLanguageCodes = new ArrayList&lt;&gt;();
   *   List&lt;InputConfig&gt; inputConfigs = new ArrayList&lt;&gt;();
   *   OutputConfig outputConfig = OutputConfig.newBuilder().build();
   *   BatchTranslateTextRequest request = BatchTranslateTextRequest.newBuilder()
   *     .setSourceLanguageCode(sourceLanguageCode)
   *     .addAllTargetLanguageCodes(targetLanguageCodes)
   *     .addAllInputConfigs(inputConfigs)
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = translationServiceClient.batchTranslateTextCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchTranslateTextRequest, Operation> batchTranslateTextCallable() {
    return stub.batchTranslateTextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedParent = TranslationServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   Glossary glossary = Glossary.newBuilder().build();
   *   Glossary response = translationServiceClient.createGlossaryAsync(formattedParent, glossary).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The project name.
   * @param glossary Required. The glossary to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Glossary, CreateGlossaryMetadata> createGlossaryAsync(
      String parent, Glossary glossary) {
    LOCATION_PATH_TEMPLATE.validate(parent, "createGlossary");
    CreateGlossaryRequest request =
        CreateGlossaryRequest.newBuilder().setParent(parent).setGlossary(glossary).build();
    return createGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedParent = TranslationServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   Glossary glossary = Glossary.newBuilder().build();
   *   CreateGlossaryRequest request = CreateGlossaryRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setGlossary(glossary)
   *     .build();
   *   Glossary response = translationServiceClient.createGlossaryAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Glossary, CreateGlossaryMetadata> createGlossaryAsync(
      CreateGlossaryRequest request) {
    return createGlossaryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedParent = TranslationServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   Glossary glossary = Glossary.newBuilder().build();
   *   CreateGlossaryRequest request = CreateGlossaryRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setGlossary(glossary)
   *     .build();
   *   OperationFuture&lt;Glossary, CreateGlossaryMetadata&gt; future = translationServiceClient.createGlossaryOperationCallable().futureCall(request);
   *   // Do something
   *   Glossary response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<CreateGlossaryRequest, Glossary, CreateGlossaryMetadata>
      createGlossaryOperationCallable() {
    return stub.createGlossaryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project
   * doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedParent = TranslationServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   Glossary glossary = Glossary.newBuilder().build();
   *   CreateGlossaryRequest request = CreateGlossaryRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setGlossary(glossary)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = translationServiceClient.createGlossaryCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateGlossaryRequest, Operation> createGlossaryCallable() {
    return stub.createGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedParent = TranslationServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String filter = "";
   *   for (Glossary element : translationServiceClient.listGlossaries(formattedParent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the project from which to list all of the glossaries.
   * @param filter Optional. Filter specifying constraints of a list operation. For example,
   *     `tags.glossary_name="products&#42;"`. If missing, no filtering is performed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossariesPagedResponse listGlossaries(String parent, String filter) {
    if (!parent.isEmpty()) {
      LOCATION_PATH_TEMPLATE.validate(parent, "listGlossaries");
    }
    ListGlossariesRequest request =
        ListGlossariesRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listGlossaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListGlossariesRequest request = ListGlossariesRequest.newBuilder().build();
   *   for (Glossary element : translationServiceClient.listGlossaries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossariesPagedResponse listGlossaries(ListGlossariesRequest request) {
    return listGlossariesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListGlossariesRequest request = ListGlossariesRequest.newBuilder().build();
   *   ApiFuture&lt;ListGlossariesPagedResponse&gt; future = translationServiceClient.listGlossariesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Glossary element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListGlossariesRequest, ListGlossariesPagedResponse>
      listGlossariesPagedCallable() {
    return stub.listGlossariesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   ListGlossariesRequest request = ListGlossariesRequest.newBuilder().build();
   *   while (true) {
   *     ListGlossariesResponse response = translationServiceClient.listGlossariesCallable().call(request);
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
   * </code></pre>
   */
  public final UnaryCallable<ListGlossariesRequest, ListGlossariesResponse>
      listGlossariesCallable() {
    return stub.listGlossariesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedName = TranslationServiceClient.formatGlossaryName("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   Glossary response = translationServiceClient.getGlossary(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the glossary to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Glossary getGlossary(String name) {
    GLOSSARY_PATH_TEMPLATE.validate(name, "getGlossary");
    GetGlossaryRequest request = GetGlossaryRequest.newBuilder().setName(name).build();
    return getGlossary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedName = TranslationServiceClient.formatGlossaryName("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   GetGlossaryRequest request = GetGlossaryRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Glossary response = translationServiceClient.getGlossary(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Glossary getGlossary(GetGlossaryRequest request) {
    return getGlossaryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedName = TranslationServiceClient.formatGlossaryName("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   GetGlossaryRequest request = GetGlossaryRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Glossary&gt; future = translationServiceClient.getGlossaryCallable().futureCall(request);
   *   // Do something
   *   Glossary response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetGlossaryRequest, Glossary> getGlossaryCallable() {
    return stub.getGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedName = TranslationServiceClient.formatGlossaryName("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   DeleteGlossaryResponse response = translationServiceClient.deleteGlossaryAsync(formattedName).get();
   * }
   * </code></pre>
   *
   * @param name Required. The name of the glossary to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<DeleteGlossaryResponse, DeleteGlossaryMetadata> deleteGlossaryAsync(
      String name) {
    GLOSSARY_PATH_TEMPLATE.validate(name, "deleteGlossary");
    DeleteGlossaryRequest request = DeleteGlossaryRequest.newBuilder().setName(name).build();
    return deleteGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedName = TranslationServiceClient.formatGlossaryName("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   DeleteGlossaryRequest request = DeleteGlossaryRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   DeleteGlossaryResponse response = translationServiceClient.deleteGlossaryAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<DeleteGlossaryResponse, DeleteGlossaryMetadata> deleteGlossaryAsync(
      DeleteGlossaryRequest request) {
    return deleteGlossaryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedName = TranslationServiceClient.formatGlossaryName("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   DeleteGlossaryRequest request = DeleteGlossaryRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   OperationFuture&lt;DeleteGlossaryResponse, DeleteGlossaryMetadata&gt; future = translationServiceClient.deleteGlossaryOperationCallable().futureCall(request);
   *   // Do something
   *   DeleteGlossaryResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<
          DeleteGlossaryRequest, DeleteGlossaryResponse, DeleteGlossaryMetadata>
      deleteGlossaryOperationCallable() {
    return stub.deleteGlossaryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns
   * NOT_FOUND, if the glossary doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
   *   String formattedName = TranslationServiceClient.formatGlossaryName("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   DeleteGlossaryRequest request = DeleteGlossaryRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = translationServiceClient.deleteGlossaryCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
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
