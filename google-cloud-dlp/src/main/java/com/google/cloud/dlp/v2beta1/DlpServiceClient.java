/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.dlp.v2beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dlp.v2beta1.stub.DlpServiceStub;
import com.google.cloud.dlp.v2beta1.stub.DlpServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest;
import com.google.privacy.dlp.v2beta1.BigQueryTable;
import com.google.privacy.dlp.v2beta1.ContentItem;
import com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest;
import com.google.privacy.dlp.v2beta1.DeidentifyConfig;
import com.google.privacy.dlp.v2beta1.DeidentifyContentRequest;
import com.google.privacy.dlp.v2beta1.DeidentifyContentResponse;
import com.google.privacy.dlp.v2beta1.InspectConfig;
import com.google.privacy.dlp.v2beta1.InspectContentRequest;
import com.google.privacy.dlp.v2beta1.InspectContentResponse;
import com.google.privacy.dlp.v2beta1.InspectOperationMetadata;
import com.google.privacy.dlp.v2beta1.InspectOperationResult;
import com.google.privacy.dlp.v2beta1.ListInfoTypesRequest;
import com.google.privacy.dlp.v2beta1.ListInfoTypesResponse;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse;
import com.google.privacy.dlp.v2beta1.OutputStorageConfig;
import com.google.privacy.dlp.v2beta1.PrivacyMetric;
import com.google.privacy.dlp.v2beta1.RedactContentRequest;
import com.google.privacy.dlp.v2beta1.RedactContentResponse;
import com.google.privacy.dlp.v2beta1.ResultName;
import com.google.privacy.dlp.v2beta1.RiskAnalysisOperationMetadata;
import com.google.privacy.dlp.v2beta1.RiskAnalysisOperationResult;
import com.google.privacy.dlp.v2beta1.StorageConfig;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The DLP API is a service that allows clients to detect the presence of
 * Personally Identifiable Information (PII) and other privacy-sensitive data in user-supplied,
 * unstructured data streams, like text blocks or images. The service also includes methods for
 * sensitive data redaction and scheduling of data scans on Google Cloud Platform based data sets.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
 *   String name = "EMAIL_ADDRESS";
 *   InfoType infoTypesElement = InfoType.newBuilder()
 *     .setName(name)
 *     .build();
 *   List&lt;InfoType&gt; infoTypes = Arrays.asList(infoTypesElement);
 *   InspectConfig inspectConfig = InspectConfig.newBuilder()
 *     .addAllInfoTypes(infoTypes)
 *     .build();
 *   String type = "text/plain";
 *   String value = "My email is example{@literal @}example.com.";
 *   ContentItem itemsElement = ContentItem.newBuilder()
 *     .setType(type)
 *     .setValue(value)
 *     .build();
 *   List&lt;ContentItem&gt; items = Arrays.asList(itemsElement);
 *   InspectContentResponse response = dlpServiceClient.inspectContent(inspectConfig, items);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the dlpServiceClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of DlpServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * DlpServiceSettings dlpServiceSettings =
 *     DlpServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DlpServiceClient dlpServiceClient =
 *     DlpServiceClient.create(dlpServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * DlpServiceSettings dlpServiceSettings =
 *     DlpServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DlpServiceClient dlpServiceClient =
 *     DlpServiceClient.create(dlpServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class DlpServiceClient implements BackgroundResource {
  private final DlpServiceSettings settings;
  private final DlpServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of DlpServiceClient with default settings. */
  public static final DlpServiceClient create() throws IOException {
    return create(DlpServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DlpServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DlpServiceClient create(DlpServiceSettings settings) throws IOException {
    return new DlpServiceClient(settings);
  }

  /**
   * Constructs an instance of DlpServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use DlpServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final DlpServiceClient create(DlpServiceStub stub) {
    return new DlpServiceClient(stub);
  }

  /**
   * Constructs an instance of DlpServiceClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DlpServiceClient(DlpServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DlpServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DlpServiceClient(DlpServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final DlpServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DlpServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Finds potentially sensitive info in a list of strings. This method has limits on input size,
   * processing time, and output size.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = "EMAIL_ADDRESS";
   *   InfoType infoTypesElement = InfoType.newBuilder()
   *     .setName(name)
   *     .build();
   *   List&lt;InfoType&gt; infoTypes = Arrays.asList(infoTypesElement);
   *   InspectConfig inspectConfig = InspectConfig.newBuilder()
   *     .addAllInfoTypes(infoTypes)
   *     .build();
   *   String type = "text/plain";
   *   String value = "My email is example{@literal @}example.com.";
   *   ContentItem itemsElement = ContentItem.newBuilder()
   *     .setType(type)
   *     .setValue(value)
   *     .build();
   *   List&lt;ContentItem&gt; items = Arrays.asList(itemsElement);
   *   InspectContentResponse response = dlpServiceClient.inspectContent(inspectConfig, items);
   * }
   * </code></pre>
   *
   * @param inspectConfig Configuration for the inspector.
   * @param items The list of items to inspect. Items in a single request are considered "related"
   *     unless inspect_config.independent_inputs is true. Up to 100 are allowed per request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectContentResponse inspectContent(
      InspectConfig inspectConfig, List<ContentItem> items) {

    InspectContentRequest request =
        InspectContentRequest.newBuilder()
            .setInspectConfig(inspectConfig)
            .addAllItems(items)
            .build();
    return inspectContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Finds potentially sensitive info in a list of strings. This method has limits on input size,
   * processing time, and output size.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = "EMAIL_ADDRESS";
   *   InfoType infoTypesElement = InfoType.newBuilder()
   *     .setName(name)
   *     .build();
   *   List&lt;InfoType&gt; infoTypes = Arrays.asList(infoTypesElement);
   *   InspectConfig inspectConfig = InspectConfig.newBuilder()
   *     .addAllInfoTypes(infoTypes)
   *     .build();
   *   String type = "text/plain";
   *   String value = "My email is example{@literal @}example.com.";
   *   ContentItem itemsElement = ContentItem.newBuilder()
   *     .setType(type)
   *     .setValue(value)
   *     .build();
   *   List&lt;ContentItem&gt; items = Arrays.asList(itemsElement);
   *   InspectContentRequest request = InspectContentRequest.newBuilder()
   *     .setInspectConfig(inspectConfig)
   *     .addAllItems(items)
   *     .build();
   *   InspectContentResponse response = dlpServiceClient.inspectContent(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InspectContentResponse inspectContent(InspectContentRequest request) {
    return inspectContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Finds potentially sensitive info in a list of strings. This method has limits on input size,
   * processing time, and output size.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = "EMAIL_ADDRESS";
   *   InfoType infoTypesElement = InfoType.newBuilder()
   *     .setName(name)
   *     .build();
   *   List&lt;InfoType&gt; infoTypes = Arrays.asList(infoTypesElement);
   *   InspectConfig inspectConfig = InspectConfig.newBuilder()
   *     .addAllInfoTypes(infoTypes)
   *     .build();
   *   String type = "text/plain";
   *   String value = "My email is example{@literal @}example.com.";
   *   ContentItem itemsElement = ContentItem.newBuilder()
   *     .setType(type)
   *     .setValue(value)
   *     .build();
   *   List&lt;ContentItem&gt; items = Arrays.asList(itemsElement);
   *   InspectContentRequest request = InspectContentRequest.newBuilder()
   *     .setInspectConfig(inspectConfig)
   *     .addAllItems(items)
   *     .build();
   *   ApiFuture&lt;InspectContentResponse&gt; future = dlpServiceClient.inspectContentCallable().futureCall(request);
   *   // Do something
   *   InspectContentResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InspectContentRequest, InspectContentResponse>
      inspectContentCallable() {
    return stub.inspectContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Redacts potentially sensitive info from a list of strings. This method has limits on input
   * size, processing time, and output size.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = "EMAIL_ADDRESS";
   *   InfoType infoTypesElement = InfoType.newBuilder()
   *     .setName(name)
   *     .build();
   *   List&lt;InfoType&gt; infoTypes = Arrays.asList(infoTypesElement);
   *   InspectConfig inspectConfig = InspectConfig.newBuilder()
   *     .addAllInfoTypes(infoTypes)
   *     .build();
   *   String type = "text/plain";
   *   String value = "My email is example{@literal @}example.com.";
   *   ContentItem itemsElement = ContentItem.newBuilder()
   *     .setType(type)
   *     .setValue(value)
   *     .build();
   *   List&lt;ContentItem&gt; items = Arrays.asList(itemsElement);
   *   String name2 = "EMAIL_ADDRESS";
   *   InfoType infoType = InfoType.newBuilder()
   *     .setName(name2)
   *     .build();
   *   String replaceWith = "REDACTED";
   *   RedactContentRequest.ReplaceConfig replaceConfigsElement = RedactContentRequest.ReplaceConfig.newBuilder()
   *     .setInfoType(infoType)
   *     .setReplaceWith(replaceWith)
   *     .build();
   *   List&lt;RedactContentRequest.ReplaceConfig&gt; replaceConfigs = Arrays.asList(replaceConfigsElement);
   *   RedactContentRequest request = RedactContentRequest.newBuilder()
   *     .setInspectConfig(inspectConfig)
   *     .addAllItems(items)
   *     .addAllReplaceConfigs(replaceConfigs)
   *     .build();
   *   RedactContentResponse response = dlpServiceClient.redactContent(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RedactContentResponse redactContent(RedactContentRequest request) {
    return redactContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Redacts potentially sensitive info from a list of strings. This method has limits on input
   * size, processing time, and output size.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = "EMAIL_ADDRESS";
   *   InfoType infoTypesElement = InfoType.newBuilder()
   *     .setName(name)
   *     .build();
   *   List&lt;InfoType&gt; infoTypes = Arrays.asList(infoTypesElement);
   *   InspectConfig inspectConfig = InspectConfig.newBuilder()
   *     .addAllInfoTypes(infoTypes)
   *     .build();
   *   String type = "text/plain";
   *   String value = "My email is example{@literal @}example.com.";
   *   ContentItem itemsElement = ContentItem.newBuilder()
   *     .setType(type)
   *     .setValue(value)
   *     .build();
   *   List&lt;ContentItem&gt; items = Arrays.asList(itemsElement);
   *   String name2 = "EMAIL_ADDRESS";
   *   InfoType infoType = InfoType.newBuilder()
   *     .setName(name2)
   *     .build();
   *   String replaceWith = "REDACTED";
   *   RedactContentRequest.ReplaceConfig replaceConfigsElement = RedactContentRequest.ReplaceConfig.newBuilder()
   *     .setInfoType(infoType)
   *     .setReplaceWith(replaceWith)
   *     .build();
   *   List&lt;RedactContentRequest.ReplaceConfig&gt; replaceConfigs = Arrays.asList(replaceConfigsElement);
   *   RedactContentRequest request = RedactContentRequest.newBuilder()
   *     .setInspectConfig(inspectConfig)
   *     .addAllItems(items)
   *     .addAllReplaceConfigs(replaceConfigs)
   *     .build();
   *   ApiFuture&lt;RedactContentResponse&gt; future = dlpServiceClient.redactContentCallable().futureCall(request);
   *   // Do something
   *   RedactContentResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RedactContentRequest, RedactContentResponse> redactContentCallable() {
    return stub.redactContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * De-identifies potentially sensitive info from a list of strings. This method has limits on
   * input size and output size.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyConfig deidentifyConfig = DeidentifyConfig.newBuilder().build();
   *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
   *   List&lt;ContentItem&gt; items = new ArrayList&lt;&gt;();
   *   DeidentifyContentResponse response = dlpServiceClient.deidentifyContent(deidentifyConfig, inspectConfig, items);
   * }
   * </code></pre>
   *
   * @param deidentifyConfig Configuration for the de-identification of the list of content items.
   * @param inspectConfig Configuration for the inspector.
   * @param items The list of items to inspect. Up to 100 are allowed per request. All items will be
   *     treated as text/&#42;.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyContentResponse deidentifyContent(
      DeidentifyConfig deidentifyConfig, InspectConfig inspectConfig, List<ContentItem> items) {

    DeidentifyContentRequest request =
        DeidentifyContentRequest.newBuilder()
            .setDeidentifyConfig(deidentifyConfig)
            .setInspectConfig(inspectConfig)
            .addAllItems(items)
            .build();
    return deidentifyContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * De-identifies potentially sensitive info from a list of strings. This method has limits on
   * input size and output size.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyConfig deidentifyConfig = DeidentifyConfig.newBuilder().build();
   *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
   *   List&lt;ContentItem&gt; items = new ArrayList&lt;&gt;();
   *   DeidentifyContentRequest request = DeidentifyContentRequest.newBuilder()
   *     .setDeidentifyConfig(deidentifyConfig)
   *     .setInspectConfig(inspectConfig)
   *     .addAllItems(items)
   *     .build();
   *   DeidentifyContentResponse response = dlpServiceClient.deidentifyContent(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeidentifyContentResponse deidentifyContent(DeidentifyContentRequest request) {
    return deidentifyContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * De-identifies potentially sensitive info from a list of strings. This method has limits on
   * input size and output size.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   DeidentifyConfig deidentifyConfig = DeidentifyConfig.newBuilder().build();
   *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
   *   List&lt;ContentItem&gt; items = new ArrayList&lt;&gt;();
   *   DeidentifyContentRequest request = DeidentifyContentRequest.newBuilder()
   *     .setDeidentifyConfig(deidentifyConfig)
   *     .setInspectConfig(inspectConfig)
   *     .addAllItems(items)
   *     .build();
   *   ApiFuture&lt;DeidentifyContentResponse&gt; future = dlpServiceClient.deidentifyContentCallable().futureCall(request);
   *   // Do something
   *   DeidentifyContentResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentCallable() {
    return stub.deidentifyContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a job to compute risk analysis metrics over content in a Google Cloud Platform
   * repository.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   PrivacyMetric privacyMetric = PrivacyMetric.newBuilder().build();
   *   BigQueryTable sourceTable = BigQueryTable.newBuilder().build();
   *   RiskAnalysisOperationResult response = dlpServiceClient.analyzeDataSourceRiskAsync(privacyMetric, sourceTable).get();
   * }
   * </code></pre>
   *
   * @param privacyMetric Privacy metric to compute.
   * @param sourceTable Input dataset to compute metrics over.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RiskAnalysisOperationResult, RiskAnalysisOperationMetadata>
      analyzeDataSourceRiskAsync(PrivacyMetric privacyMetric, BigQueryTable sourceTable) {

    AnalyzeDataSourceRiskRequest request =
        AnalyzeDataSourceRiskRequest.newBuilder()
            .setPrivacyMetric(privacyMetric)
            .setSourceTable(sourceTable)
            .build();
    return analyzeDataSourceRiskAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a job to compute risk analysis metrics over content in a Google Cloud Platform
   * repository.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   PrivacyMetric privacyMetric = PrivacyMetric.newBuilder().build();
   *   BigQueryTable sourceTable = BigQueryTable.newBuilder().build();
   *   AnalyzeDataSourceRiskRequest request = AnalyzeDataSourceRiskRequest.newBuilder()
   *     .setPrivacyMetric(privacyMetric)
   *     .setSourceTable(sourceTable)
   *     .build();
   *   RiskAnalysisOperationResult response = dlpServiceClient.analyzeDataSourceRiskAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RiskAnalysisOperationResult, RiskAnalysisOperationMetadata>
      analyzeDataSourceRiskAsync(AnalyzeDataSourceRiskRequest request) {
    return analyzeDataSourceRiskOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a job to compute risk analysis metrics over content in a Google Cloud Platform
   * repository.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   PrivacyMetric privacyMetric = PrivacyMetric.newBuilder().build();
   *   BigQueryTable sourceTable = BigQueryTable.newBuilder().build();
   *   AnalyzeDataSourceRiskRequest request = AnalyzeDataSourceRiskRequest.newBuilder()
   *     .setPrivacyMetric(privacyMetric)
   *     .setSourceTable(sourceTable)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = dlpServiceClient.analyzeDataSourceRiskOperationCallable().futureCall(request);
   *   // Do something
   *   RiskAnalysisOperationResult response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<
          AnalyzeDataSourceRiskRequest, RiskAnalysisOperationResult, RiskAnalysisOperationMetadata>
      analyzeDataSourceRiskOperationCallable() {
    return stub.analyzeDataSourceRiskOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a job to compute risk analysis metrics over content in a Google Cloud Platform
   * repository.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   PrivacyMetric privacyMetric = PrivacyMetric.newBuilder().build();
   *   BigQueryTable sourceTable = BigQueryTable.newBuilder().build();
   *   AnalyzeDataSourceRiskRequest request = AnalyzeDataSourceRiskRequest.newBuilder()
   *     .setPrivacyMetric(privacyMetric)
   *     .setSourceTable(sourceTable)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = dlpServiceClient.analyzeDataSourceRiskCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AnalyzeDataSourceRiskRequest, Operation>
      analyzeDataSourceRiskCallable() {
    return stub.analyzeDataSourceRiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a job scanning content in a Google Cloud Platform data repository.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = "EMAIL_ADDRESS";
   *   InfoType infoTypesElement = InfoType.newBuilder()
   *     .setName(name)
   *     .build();
   *   List&lt;InfoType&gt; infoTypes = Arrays.asList(infoTypesElement);
   *   InspectConfig inspectConfig = InspectConfig.newBuilder()
   *     .addAllInfoTypes(infoTypes)
   *     .build();
   *   String url = "gs://example_bucket/example_file.png";
   *   CloudStorageOptions.FileSet fileSet = CloudStorageOptions.FileSet.newBuilder()
   *     .setUrl(url)
   *     .build();
   *   CloudStorageOptions cloudStorageOptions = CloudStorageOptions.newBuilder()
   *     .setFileSet(fileSet)
   *     .build();
   *   StorageConfig storageConfig = StorageConfig.newBuilder()
   *     .setCloudStorageOptions(cloudStorageOptions)
   *     .build();
   *   OutputStorageConfig outputConfig = OutputStorageConfig.newBuilder().build();
   *   InspectOperationResult response = dlpServiceClient.createInspectOperationAsync(inspectConfig, storageConfig, outputConfig).get();
   * }
   * </code></pre>
   *
   * @param inspectConfig Configuration for the inspector.
   * @param storageConfig Specification of the data set to process.
   * @param outputConfig Optional location to store findings.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InspectOperationResult, InspectOperationMetadata>
      createInspectOperationAsync(
          InspectConfig inspectConfig,
          StorageConfig storageConfig,
          OutputStorageConfig outputConfig) {

    CreateInspectOperationRequest request =
        CreateInspectOperationRequest.newBuilder()
            .setInspectConfig(inspectConfig)
            .setStorageConfig(storageConfig)
            .setOutputConfig(outputConfig)
            .build();
    return createInspectOperationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a job scanning content in a Google Cloud Platform data repository.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = "EMAIL_ADDRESS";
   *   InfoType infoTypesElement = InfoType.newBuilder()
   *     .setName(name)
   *     .build();
   *   List&lt;InfoType&gt; infoTypes = Arrays.asList(infoTypesElement);
   *   InspectConfig inspectConfig = InspectConfig.newBuilder()
   *     .addAllInfoTypes(infoTypes)
   *     .build();
   *   String url = "gs://example_bucket/example_file.png";
   *   CloudStorageOptions.FileSet fileSet = CloudStorageOptions.FileSet.newBuilder()
   *     .setUrl(url)
   *     .build();
   *   CloudStorageOptions cloudStorageOptions = CloudStorageOptions.newBuilder()
   *     .setFileSet(fileSet)
   *     .build();
   *   StorageConfig storageConfig = StorageConfig.newBuilder()
   *     .setCloudStorageOptions(cloudStorageOptions)
   *     .build();
   *   OutputStorageConfig outputConfig = OutputStorageConfig.newBuilder().build();
   *   CreateInspectOperationRequest request = CreateInspectOperationRequest.newBuilder()
   *     .setInspectConfig(inspectConfig)
   *     .setStorageConfig(storageConfig)
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   InspectOperationResult response = dlpServiceClient.createInspectOperationAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InspectOperationResult, InspectOperationMetadata>
      createInspectOperationAsync(CreateInspectOperationRequest request) {
    return createInspectOperationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a job scanning content in a Google Cloud Platform data repository.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = "EMAIL_ADDRESS";
   *   InfoType infoTypesElement = InfoType.newBuilder()
   *     .setName(name)
   *     .build();
   *   List&lt;InfoType&gt; infoTypes = Arrays.asList(infoTypesElement);
   *   InspectConfig inspectConfig = InspectConfig.newBuilder()
   *     .addAllInfoTypes(infoTypes)
   *     .build();
   *   String url = "gs://example_bucket/example_file.png";
   *   CloudStorageOptions.FileSet fileSet = CloudStorageOptions.FileSet.newBuilder()
   *     .setUrl(url)
   *     .build();
   *   CloudStorageOptions cloudStorageOptions = CloudStorageOptions.newBuilder()
   *     .setFileSet(fileSet)
   *     .build();
   *   StorageConfig storageConfig = StorageConfig.newBuilder()
   *     .setCloudStorageOptions(cloudStorageOptions)
   *     .build();
   *   OutputStorageConfig outputConfig = OutputStorageConfig.newBuilder().build();
   *   CreateInspectOperationRequest request = CreateInspectOperationRequest.newBuilder()
   *     .setInspectConfig(inspectConfig)
   *     .setStorageConfig(storageConfig)
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = dlpServiceClient.createInspectOperationOperationCallable().futureCall(request);
   *   // Do something
   *   InspectOperationResult response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
      createInspectOperationOperationCallable() {
    return stub.createInspectOperationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a job scanning content in a Google Cloud Platform data repository.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String name = "EMAIL_ADDRESS";
   *   InfoType infoTypesElement = InfoType.newBuilder()
   *     .setName(name)
   *     .build();
   *   List&lt;InfoType&gt; infoTypes = Arrays.asList(infoTypesElement);
   *   InspectConfig inspectConfig = InspectConfig.newBuilder()
   *     .addAllInfoTypes(infoTypes)
   *     .build();
   *   String url = "gs://example_bucket/example_file.png";
   *   CloudStorageOptions.FileSet fileSet = CloudStorageOptions.FileSet.newBuilder()
   *     .setUrl(url)
   *     .build();
   *   CloudStorageOptions cloudStorageOptions = CloudStorageOptions.newBuilder()
   *     .setFileSet(fileSet)
   *     .build();
   *   StorageConfig storageConfig = StorageConfig.newBuilder()
   *     .setCloudStorageOptions(cloudStorageOptions)
   *     .build();
   *   OutputStorageConfig outputConfig = OutputStorageConfig.newBuilder().build();
   *   CreateInspectOperationRequest request = CreateInspectOperationRequest.newBuilder()
   *     .setInspectConfig(inspectConfig)
   *     .setStorageConfig(storageConfig)
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = dlpServiceClient.createInspectOperationCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateInspectOperationRequest, Operation>
      createInspectOperationCallable() {
    return stub.createInspectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns list of results for given inspect operation result set id.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ResultName name = ResultName.of("[RESULT]");
   *   ListInspectFindingsResponse response = dlpServiceClient.listInspectFindings(name);
   * }
   * </code></pre>
   *
   * @param name Identifier of the results set returned as metadata of the longrunning operation
   *     created by a call to InspectDataSource. Should be in the format of `inspect/results/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInspectFindingsResponse listInspectFindings(ResultName name) {

    ListInspectFindingsRequest request =
        ListInspectFindingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listInspectFindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns list of results for given inspect operation result set id.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ResultName name = ResultName.of("[RESULT]");
   *   ListInspectFindingsResponse response = dlpServiceClient.listInspectFindings(name.toString());
   * }
   * </code></pre>
   *
   * @param name Identifier of the results set returned as metadata of the longrunning operation
   *     created by a call to InspectDataSource. Should be in the format of `inspect/results/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInspectFindingsResponse listInspectFindings(String name) {

    ListInspectFindingsRequest request =
        ListInspectFindingsRequest.newBuilder().setName(name).build();
    return listInspectFindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns list of results for given inspect operation result set id.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ResultName name = ResultName.of("[RESULT]");
   *   ListInspectFindingsRequest request = ListInspectFindingsRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ListInspectFindingsResponse response = dlpServiceClient.listInspectFindings(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInspectFindingsResponse listInspectFindings(ListInspectFindingsRequest request) {
    return listInspectFindingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns list of results for given inspect operation result set id.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ResultName name = ResultName.of("[RESULT]");
   *   ListInspectFindingsRequest request = ListInspectFindingsRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;ListInspectFindingsResponse&gt; future = dlpServiceClient.listInspectFindingsCallable().futureCall(request);
   *   // Do something
   *   ListInspectFindingsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsCallable() {
    return stub.listInspectFindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns sensitive information types for given category.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String category = "PII";
   *   String languageCode = "en";
   *   ListInfoTypesResponse response = dlpServiceClient.listInfoTypes(category, languageCode);
   * }
   * </code></pre>
   *
   * @param category Category name as returned by ListRootCategories.
   * @param languageCode Optional BCP-47 language code for localized info type friendly names. If
   *     omitted, or if localized strings are not available, en-US strings will be returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInfoTypesResponse listInfoTypes(String category, String languageCode) {

    ListInfoTypesRequest request =
        ListInfoTypesRequest.newBuilder()
            .setCategory(category)
            .setLanguageCode(languageCode)
            .build();
    return listInfoTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns sensitive information types for given category.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String category = "PII";
   *   String languageCode = "en";
   *   ListInfoTypesRequest request = ListInfoTypesRequest.newBuilder()
   *     .setCategory(category)
   *     .setLanguageCode(languageCode)
   *     .build();
   *   ListInfoTypesResponse response = dlpServiceClient.listInfoTypes(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInfoTypesResponse listInfoTypes(ListInfoTypesRequest request) {
    return listInfoTypesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns sensitive information types for given category.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String category = "PII";
   *   String languageCode = "en";
   *   ListInfoTypesRequest request = ListInfoTypesRequest.newBuilder()
   *     .setCategory(category)
   *     .setLanguageCode(languageCode)
   *     .build();
   *   ApiFuture&lt;ListInfoTypesResponse&gt; future = dlpServiceClient.listInfoTypesCallable().futureCall(request);
   *   // Do something
   *   ListInfoTypesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable() {
    return stub.listInfoTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of root categories of sensitive information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String languageCode = "en";
   *   ListRootCategoriesResponse response = dlpServiceClient.listRootCategories(languageCode);
   * }
   * </code></pre>
   *
   * @param languageCode Optional language code for localized friendly category names. If omitted or
   *     if localized strings are not available, en-US strings will be returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRootCategoriesResponse listRootCategories(String languageCode) {

    ListRootCategoriesRequest request =
        ListRootCategoriesRequest.newBuilder().setLanguageCode(languageCode).build();
    return listRootCategories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of root categories of sensitive information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String languageCode = "en";
   *   ListRootCategoriesRequest request = ListRootCategoriesRequest.newBuilder()
   *     .setLanguageCode(languageCode)
   *     .build();
   *   ListRootCategoriesResponse response = dlpServiceClient.listRootCategories(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final ListRootCategoriesResponse listRootCategories(ListRootCategoriesRequest request) {
    return listRootCategoriesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of root categories of sensitive information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String languageCode = "en";
   *   ListRootCategoriesRequest request = ListRootCategoriesRequest.newBuilder()
   *     .setLanguageCode(languageCode)
   *     .build();
   *   ApiFuture&lt;ListRootCategoriesResponse&gt; future = dlpServiceClient.listRootCategoriesCallable().futureCall(request);
   *   // Do something
   *   ListRootCategoriesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListRootCategoriesRequest, ListRootCategoriesResponse>
      listRootCategoriesCallable() {
    return stub.listRootCategoriesCallable();
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
