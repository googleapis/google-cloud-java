/*
 * Copyright 2017, Google Inc. All rights reserved.
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
package com.google.cloud.dlp.v2beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.ClientContext;
import com.google.api.gax.grpc.FixedChannelProvider;
import com.google.api.gax.grpc.FixedExecutorProvider;
import com.google.api.gax.grpc.OperationCallable;
import com.google.api.gax.grpc.OperationFuture;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.auth.Credentials;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.longrunning.OperationsSettings;
import com.google.privacy.dlp.v2beta1.ContentItem;
import com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest;
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
import com.google.privacy.dlp.v2beta1.RedactContentRequest;
import com.google.privacy.dlp.v2beta1.RedactContentRequest.ReplaceConfig;
import com.google.privacy.dlp.v2beta1.RedactContentResponse;
import com.google.privacy.dlp.v2beta1.ResultName;
import com.google.privacy.dlp.v2beta1.StorageConfig;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
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
 *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
 *   List&lt;ContentItem&gt; items = new ArrayList&lt;&gt;();
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
 * <pre>
 * <code>
 * DlpServiceSettings dlpServiceSettings =
 *     DlpServiceSettings.defaultBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DlpServiceClient dlpServiceClient =
 *     DlpServiceClient.create(dlpServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
@BetaApi
public class DlpServiceClient implements AutoCloseable {
  private final DlpServiceSettings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final OperationsClient operationsClient;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<InspectContentRequest, InspectContentResponse> inspectContentCallable;
  private final UnaryCallable<RedactContentRequest, RedactContentResponse> redactContentCallable;
  private final UnaryCallable<CreateInspectOperationRequest, Operation>
      createInspectOperationCallable;
  private final OperationCallable<
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
      createInspectOperationOperationCallable;
  private final UnaryCallable<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsCallable;
  private final UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable;
  private final UnaryCallable<ListRootCategoriesRequest, ListRootCategoriesResponse>
      listRootCategoriesCallable;

  /** Constructs an instance of DlpServiceClient with default settings. */
  public static final DlpServiceClient create() throws IOException {
    return create(DlpServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of DlpServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DlpServiceClient create(DlpServiceSettings settings) throws IOException {
    return new DlpServiceClient(settings);
  }

  /**
   * Constructs an instance of DlpServiceClient, using the given settings. This is protected so that
   * it easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DlpServiceClient(DlpServiceSettings settings) throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();
    Credentials credentials = settings.getCredentialsProvider().getCredentials();

    ClientContext clientContext =
        ClientContext.newBuilder()
            .setExecutor(this.executor)
            .setChannel(this.channel)
            .setCredentials(credentials)
            .build();

    OperationsSettings operationsSettings =
        OperationsSettings.defaultBuilder()
            .setExecutorProvider(FixedExecutorProvider.create(this.executor))
            .setChannelProvider(FixedChannelProvider.create(this.channel))
            .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
            .build();
    this.operationsClient = OperationsClient.create(operationsSettings);

    this.inspectContentCallable =
        UnaryCallable.create(settings.inspectContentSettings(), clientContext);
    this.redactContentCallable =
        UnaryCallable.create(settings.redactContentSettings(), clientContext);
    this.createInspectOperationCallable =
        UnaryCallable.create(
            settings.createInspectOperationSettings().getInitialCallSettings(), clientContext);
    this.createInspectOperationOperationCallable =
        OperationCallable.create(
            settings.createInspectOperationSettings(), clientContext, this.operationsClient);
    this.listInspectFindingsCallable =
        UnaryCallable.create(settings.listInspectFindingsSettings(), clientContext);
    this.listInfoTypesCallable =
        UnaryCallable.create(settings.listInfoTypesSettings(), clientContext);
    this.listRootCategoriesCallable =
        UnaryCallable.create(settings.listRootCategoriesSettings(), clientContext);

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

  public final DlpServiceSettings getSettings() {
    return settings;
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
   *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
   *   List&lt;ContentItem&gt; items = new ArrayList&lt;&gt;();
   *   InspectContentResponse response = dlpServiceClient.inspectContent(inspectConfig, items);
   * }
   * </code></pre>
   *
   * @param inspectConfig Configuration for the inspector.
   * @param items The list of items to inspect. Items in a single request are considered "related"
   *     unless inspect_config.independent_inputs is true. Up to 100 are allowed per request.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
   *   List&lt;ContentItem&gt; items = new ArrayList&lt;&gt;();
   *   InspectContentRequest request = InspectContentRequest.newBuilder()
   *     .setInspectConfig(inspectConfig)
   *     .addAllItems(items)
   *     .build();
   *   InspectContentResponse response = dlpServiceClient.inspectContent(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
   *   List&lt;ContentItem&gt; items = new ArrayList&lt;&gt;();
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
    return inspectContentCallable;
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
   *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
   *   List&lt;ContentItem&gt; items = new ArrayList&lt;&gt;();
   *   List&lt;RedactContentRequest.ReplaceConfig&gt; replaceConfigs = new ArrayList&lt;&gt;();
   *   RedactContentResponse response = dlpServiceClient.redactContent(inspectConfig, items, replaceConfigs);
   * }
   * </code></pre>
   *
   * @param inspectConfig Configuration for the inspector.
   * @param items The list of items to inspect. Up to 100 are allowed per request.
   * @param replaceConfigs The strings to replace findings text findings with. Must specify at least
   *     one of these or one ImageRedactionConfig if redacting images.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final RedactContentResponse redactContent(
      InspectConfig inspectConfig,
      List<ContentItem> items,
      List<RedactContentRequest.ReplaceConfig> replaceConfigs) {

    RedactContentRequest request =
        RedactContentRequest.newBuilder()
            .setInspectConfig(inspectConfig)
            .addAllItems(items)
            .addAllReplaceConfigs(replaceConfigs)
            .build();
    return redactContent(request);
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
   *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
   *   List&lt;ContentItem&gt; items = new ArrayList&lt;&gt;();
   *   List&lt;RedactContentRequest.ReplaceConfig&gt; replaceConfigs = new ArrayList&lt;&gt;();
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
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
   *   List&lt;ContentItem&gt; items = new ArrayList&lt;&gt;();
   *   List&lt;RedactContentRequest.ReplaceConfig&gt; replaceConfigs = new ArrayList&lt;&gt;();
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
    return redactContentCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a job scanning content in a Google Cloud Platform data repository.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
   *   StorageConfig storageConfig = StorageConfig.newBuilder().build();
   *   OutputStorageConfig outputConfig = OutputStorageConfig.newBuilder().build();
   *   InspectOperationResult response = dlpServiceClient.createInspectOperationAsync(inspectConfig, storageConfig, outputConfig).get();
   * }
   * </code></pre>
   *
   * @param inspectConfig Configuration for the inspector.
   * @param storageConfig Specification of the data set to process.
   * @param outputConfig Optional location to store findings. The bucket must already exist and the
   *     Google APIs service account for DLP must have write permission to write to the given
   *     bucket. &lt;p&gt;Results are split over multiple csv files with each file name matching the
   *     pattern "[operation_id]_[count].csv", for example `3094877188788974909_1.csv`. The
   *     `operation_id` matches the identifier for the Operation, and the `count` is a counter used
   *     for tracking the number of files written. &lt;p&gt;The CSV file(s) contain the following
   *     columns regardless of storage type scanned: &lt;li&gt;id &lt;li&gt;info_type
   *     &lt;li&gt;likelihood &lt;li&gt;byte size of finding &lt;li&gt;quote
   *     &lt;li&gt;time_stamp&lt;br/&gt; &lt;p&gt;For Cloud Storage the next columns are:
   *     &lt;li&gt;file_path &lt;li&gt;start_offset&lt;br/&gt; &lt;p&gt;For Cloud Datastore the next
   *     columns are: &lt;li&gt;project_id &lt;li&gt;namespace_id &lt;li&gt;path
   *     &lt;li&gt;column_name &lt;li&gt;offset
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
   *   StorageConfig storageConfig = StorageConfig.newBuilder().build();
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
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
   *   StorageConfig storageConfig = StorageConfig.newBuilder().build();
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
    return createInspectOperationOperationCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedules a job scanning content in a Google Cloud Platform data repository.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   InspectConfig inspectConfig = InspectConfig.newBuilder().build();
   *   StorageConfig storageConfig = StorageConfig.newBuilder().build();
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
    return createInspectOperationCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns list of results for given inspect operation result set id.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   ResultName name = ResultName.create("[RESULT]");
   *   ListInspectFindingsResponse response = dlpServiceClient.listInspectFindings(name);
   * }
   * </code></pre>
   *
   * @param name Identifier of the results set returned as metadata of the longrunning operation
   *     created by a call to CreateInspectOperation. Should be in the format of
   *     `inspect/results/{id}.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListInspectFindingsResponse listInspectFindings(ResultName name) {

    ListInspectFindingsRequest request =
        ListInspectFindingsRequest.newBuilder().setNameWithResultName(name).build();
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
   *   ResultName name = ResultName.create("[RESULT]");
   *   ListInspectFindingsRequest request = ListInspectFindingsRequest.newBuilder()
   *     .setNameWithResultName(name)
   *     .build();
   *   ListInspectFindingsResponse response = dlpServiceClient.listInspectFindings(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   ResultName name = ResultName.create("[RESULT]");
   *   ListInspectFindingsRequest request = ListInspectFindingsRequest.newBuilder()
   *     .setNameWithResultName(name)
   *     .build();
   *   ApiFuture&lt;ListInspectFindingsResponse&gt; future = dlpServiceClient.listInspectFindingsCallable().futureCall(request);
   *   // Do something
   *   ListInspectFindingsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsCallable() {
    return listInspectFindingsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns sensitive information types for given category.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String category = "";
   *   String languageCode = "";
   *   ListInfoTypesResponse response = dlpServiceClient.listInfoTypes(category, languageCode);
   * }
   * </code></pre>
   *
   * @param category Category name as returned by ListRootCategories.
   * @param languageCode Optional BCP-47 language code for localized info type friendly names. If
   *     omitted, or if localized strings are not available, en-US strings will be returned.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   String category = "";
   *   String languageCode = "";
   *   ListInfoTypesRequest request = ListInfoTypesRequest.newBuilder()
   *     .setCategory(category)
   *     .setLanguageCode(languageCode)
   *     .build();
   *   ListInfoTypesResponse response = dlpServiceClient.listInfoTypes(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   String category = "";
   *   String languageCode = "";
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
    return listInfoTypesCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of root categories of sensitive information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
   *   String languageCode = "";
   *   ListRootCategoriesResponse response = dlpServiceClient.listRootCategories(languageCode);
   * }
   * </code></pre>
   *
   * @param languageCode Optional language code for localized friendly category names. If omitted or
   *     if localized strings are not available, en-US strings will be returned.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   String languageCode = "";
   *   ListRootCategoriesRequest request = ListRootCategoriesRequest.newBuilder()
   *     .setLanguageCode(languageCode)
   *     .build();
   *   ListRootCategoriesResponse response = dlpServiceClient.listRootCategories(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   String languageCode = "";
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
    return listRootCategoriesCallable;
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
