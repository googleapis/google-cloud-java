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

package com.google.cloud.gkemulticloud.v1;

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
import com.google.cloud.gkemulticloud.v1.stub.AzureClustersStub;
import com.google.cloud.gkemulticloud.v1.stub.AzureClustersStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The AzureClusters API provides a single centrally managed service to create
 * and manage Anthos clusters that run on Azure infrastructure.
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
 * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
 *   AzureClientName name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]");
 *   AzureClient response = azureClustersClient.getAzureClient(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AzureClustersClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of AzureClustersSettings to
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
 * AzureClustersSettings azureClustersSettings =
 *     AzureClustersSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AzureClustersClient azureClustersClient = AzureClustersClient.create(azureClustersSettings);
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
 * AzureClustersSettings azureClustersSettings =
 *     AzureClustersSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AzureClustersClient azureClustersClient = AzureClustersClient.create(azureClustersSettings);
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
 * AzureClustersSettings azureClustersSettings =
 *     AzureClustersSettings.newHttpJsonBuilder().build();
 * AzureClustersClient azureClustersClient = AzureClustersClient.create(azureClustersSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AzureClustersClient implements BackgroundResource {
  private final AzureClustersSettings settings;
  private final AzureClustersStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AzureClustersClient with default settings. */
  public static final AzureClustersClient create() throws IOException {
    return create(AzureClustersSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AzureClustersClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AzureClustersClient create(AzureClustersSettings settings)
      throws IOException {
    return new AzureClustersClient(settings);
  }

  /**
   * Constructs an instance of AzureClustersClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AzureClustersSettings).
   */
  public static final AzureClustersClient create(AzureClustersStub stub) {
    return new AzureClustersClient(stub);
  }

  /**
   * Constructs an instance of AzureClustersClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AzureClustersClient(AzureClustersSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AzureClustersStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AzureClustersClient(AzureClustersStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AzureClustersSettings getSettings() {
    return settings;
  }

  public AzureClustersStub getStub() {
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
   * Creates a new [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource on a given
   * Google Cloud project and region.
   *
   * <p>`AzureClient` resources hold client authentication information needed by the Anthos
   * Multicloud API to manage Azure resources on your Azure subscription on your behalf.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AzureClient azureClient = AzureClient.newBuilder().build();
   *   String azureClientId = "azureClientId-1735934475";
   *   AzureClient response =
   *       azureClustersClient.createAzureClientAsync(parent, azureClient, azureClientId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location where this
   *     [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param azureClient Required. The specification of the
   *     [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] to create.
   * @param azureClientId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClients/&lt;client-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AzureClient, OperationMetadata> createAzureClientAsync(
      LocationName parent, AzureClient azureClient, String azureClientId) {
    CreateAzureClientRequest request =
        CreateAzureClientRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAzureClient(azureClient)
            .setAzureClientId(azureClientId)
            .build();
    return createAzureClientAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource on a given
   * Google Cloud project and region.
   *
   * <p>`AzureClient` resources hold client authentication information needed by the Anthos
   * Multicloud API to manage Azure resources on your Azure subscription on your behalf.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AzureClient azureClient = AzureClient.newBuilder().build();
   *   String azureClientId = "azureClientId-1735934475";
   *   AzureClient response =
   *       azureClustersClient.createAzureClientAsync(parent, azureClient, azureClientId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location where this
   *     [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param azureClient Required. The specification of the
   *     [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] to create.
   * @param azureClientId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClients/&lt;client-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AzureClient, OperationMetadata> createAzureClientAsync(
      String parent, AzureClient azureClient, String azureClientId) {
    CreateAzureClientRequest request =
        CreateAzureClientRequest.newBuilder()
            .setParent(parent)
            .setAzureClient(azureClient)
            .setAzureClientId(azureClientId)
            .build();
    return createAzureClientAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource on a given
   * Google Cloud project and region.
   *
   * <p>`AzureClient` resources hold client authentication information needed by the Anthos
   * Multicloud API to manage Azure resources on your Azure subscription on your behalf.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   CreateAzureClientRequest request =
   *       CreateAzureClientRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAzureClient(AzureClient.newBuilder().build())
   *           .setAzureClientId("azureClientId-1735934475")
   *           .setValidateOnly(true)
   *           .build();
   *   AzureClient response = azureClustersClient.createAzureClientAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AzureClient, OperationMetadata> createAzureClientAsync(
      CreateAzureClientRequest request) {
    return createAzureClientOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource on a given
   * Google Cloud project and region.
   *
   * <p>`AzureClient` resources hold client authentication information needed by the Anthos
   * Multicloud API to manage Azure resources on your Azure subscription on your behalf.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   CreateAzureClientRequest request =
   *       CreateAzureClientRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAzureClient(AzureClient.newBuilder().build())
   *           .setAzureClientId("azureClientId-1735934475")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AzureClient, OperationMetadata> future =
   *       azureClustersClient.createAzureClientOperationCallable().futureCall(request);
   *   // Do something.
   *   AzureClient response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAzureClientRequest, AzureClient, OperationMetadata>
      createAzureClientOperationCallable() {
    return stub.createAzureClientOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource on a given
   * Google Cloud project and region.
   *
   * <p>`AzureClient` resources hold client authentication information needed by the Anthos
   * Multicloud API to manage Azure resources on your Azure subscription on your behalf.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   CreateAzureClientRequest request =
   *       CreateAzureClientRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAzureClient(AzureClient.newBuilder().build())
   *           .setAzureClientId("azureClientId-1735934475")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       azureClustersClient.createAzureClientCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAzureClientRequest, Operation> createAzureClientCallable() {
    return stub.createAzureClientCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   AzureClientName name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]");
   *   AzureClient response = azureClustersClient.getAzureClient(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
   *     resource to describe.
   *     <p>[AzureClient][google.cloud.gkemulticloud.v1.AzureClient] names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClients/&lt;client-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AzureClient getAzureClient(AzureClientName name) {
    GetAzureClientRequest request =
        GetAzureClientRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAzureClient(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   String name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString();
   *   AzureClient response = azureClustersClient.getAzureClient(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the [AzureClient][google.cloud.gkemulticloud.v1.AzureClient]
   *     resource to describe.
   *     <p>[AzureClient][google.cloud.gkemulticloud.v1.AzureClient] names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClients/&lt;client-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AzureClient getAzureClient(String name) {
    GetAzureClientRequest request = GetAzureClientRequest.newBuilder().setName(name).build();
    return getAzureClient(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   GetAzureClientRequest request =
   *       GetAzureClientRequest.newBuilder()
   *           .setName(AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString())
   *           .build();
   *   AzureClient response = azureClustersClient.getAzureClient(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AzureClient getAzureClient(GetAzureClientRequest request) {
    return getAzureClientCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   GetAzureClientRequest request =
   *       GetAzureClientRequest.newBuilder()
   *           .setName(AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString())
   *           .build();
   *   ApiFuture<AzureClient> future =
   *       azureClustersClient.getAzureClientCallable().futureCall(request);
   *   // Do something.
   *   AzureClient response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAzureClientRequest, AzureClient> getAzureClientCallable() {
    return stub.getAzureClientCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resources on a given Google
   * Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AzureClient element : azureClustersClient.listAzureClients(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location which owns this collection of
   *     [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resources.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAzureClientsPagedResponse listAzureClients(LocationName parent) {
    ListAzureClientsRequest request =
        ListAzureClientsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAzureClients(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resources on a given Google
   * Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AzureClient element : azureClustersClient.listAzureClients(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location which owns this collection of
   *     [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resources.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAzureClientsPagedResponse listAzureClients(String parent) {
    ListAzureClientsRequest request =
        ListAzureClientsRequest.newBuilder().setParent(parent).build();
    return listAzureClients(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resources on a given Google
   * Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   ListAzureClientsRequest request =
   *       ListAzureClientsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AzureClient element : azureClustersClient.listAzureClients(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAzureClientsPagedResponse listAzureClients(ListAzureClientsRequest request) {
    return listAzureClientsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resources on a given Google
   * Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   ListAzureClientsRequest request =
   *       ListAzureClientsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AzureClient> future =
   *       azureClustersClient.listAzureClientsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AzureClient element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAzureClientsRequest, ListAzureClientsPagedResponse>
      listAzureClientsPagedCallable() {
    return stub.listAzureClientsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resources on a given Google
   * Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   ListAzureClientsRequest request =
   *       ListAzureClientsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAzureClientsResponse response =
   *         azureClustersClient.listAzureClientsCallable().call(request);
   *     for (AzureClient element : response.getAzureClientsList()) {
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
  public final UnaryCallable<ListAzureClientsRequest, ListAzureClientsResponse>
      listAzureClientsCallable() {
    return stub.listAzureClientsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource.
   *
   * <p>If the client is used by one or more clusters, deletion will fail and a
   * `FAILED_PRECONDITION` error will be returned.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   AzureClientName name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]");
   *   azureClustersClient.deleteAzureClientAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name the
   *     [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] to delete.
   *     <p>[AzureClient][google.cloud.gkemulticloud.v1.AzureClient] names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClients/&lt;client-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAzureClientAsync(
      AzureClientName name) {
    DeleteAzureClientRequest request =
        DeleteAzureClientRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteAzureClientAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource.
   *
   * <p>If the client is used by one or more clusters, deletion will fail and a
   * `FAILED_PRECONDITION` error will be returned.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   String name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString();
   *   azureClustersClient.deleteAzureClientAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name the
   *     [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] to delete.
   *     <p>[AzureClient][google.cloud.gkemulticloud.v1.AzureClient] names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClients/&lt;client-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAzureClientAsync(String name) {
    DeleteAzureClientRequest request = DeleteAzureClientRequest.newBuilder().setName(name).build();
    return deleteAzureClientAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource.
   *
   * <p>If the client is used by one or more clusters, deletion will fail and a
   * `FAILED_PRECONDITION` error will be returned.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   DeleteAzureClientRequest request =
   *       DeleteAzureClientRequest.newBuilder()
   *           .setName(AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   azureClustersClient.deleteAzureClientAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAzureClientAsync(
      DeleteAzureClientRequest request) {
    return deleteAzureClientOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource.
   *
   * <p>If the client is used by one or more clusters, deletion will fail and a
   * `FAILED_PRECONDITION` error will be returned.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   DeleteAzureClientRequest request =
   *       DeleteAzureClientRequest.newBuilder()
   *           .setName(AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       azureClustersClient.deleteAzureClientOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAzureClientRequest, Empty, OperationMetadata>
      deleteAzureClientOperationCallable() {
    return stub.deleteAzureClientOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureClient][google.cloud.gkemulticloud.v1.AzureClient] resource.
   *
   * <p>If the client is used by one or more clusters, deletion will fail and a
   * `FAILED_PRECONDITION` error will be returned.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   DeleteAzureClientRequest request =
   *       DeleteAzureClientRequest.newBuilder()
   *           .setName(AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]").toString())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       azureClustersClient.deleteAzureClientCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAzureClientRequest, Operation> deleteAzureClientCallable() {
    return stub.deleteAzureClientCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource on a given
   * GCP project and region.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AzureCluster azureCluster = AzureCluster.newBuilder().build();
   *   String azureClusterId = "azureClusterId191689446";
   *   AzureCluster response =
   *       azureClustersClient.createAzureClusterAsync(parent, azureCluster, azureClusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location where this
   *     [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param azureCluster Required. The specification of the
   *     [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] to create.
   * @param azureClusterId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AzureCluster, OperationMetadata> createAzureClusterAsync(
      LocationName parent, AzureCluster azureCluster, String azureClusterId) {
    CreateAzureClusterRequest request =
        CreateAzureClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAzureCluster(azureCluster)
            .setAzureClusterId(azureClusterId)
            .build();
    return createAzureClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource on a given
   * GCP project and region.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AzureCluster azureCluster = AzureCluster.newBuilder().build();
   *   String azureClusterId = "azureClusterId191689446";
   *   AzureCluster response =
   *       azureClustersClient.createAzureClusterAsync(parent, azureCluster, azureClusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location where this
   *     [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param azureCluster Required. The specification of the
   *     [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] to create.
   * @param azureClusterId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AzureCluster, OperationMetadata> createAzureClusterAsync(
      String parent, AzureCluster azureCluster, String azureClusterId) {
    CreateAzureClusterRequest request =
        CreateAzureClusterRequest.newBuilder()
            .setParent(parent)
            .setAzureCluster(azureCluster)
            .setAzureClusterId(azureClusterId)
            .build();
    return createAzureClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource on a given
   * GCP project and region.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   CreateAzureClusterRequest request =
   *       CreateAzureClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAzureCluster(AzureCluster.newBuilder().build())
   *           .setAzureClusterId("azureClusterId191689446")
   *           .setValidateOnly(true)
   *           .build();
   *   AzureCluster response = azureClustersClient.createAzureClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AzureCluster, OperationMetadata> createAzureClusterAsync(
      CreateAzureClusterRequest request) {
    return createAzureClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource on a given
   * GCP project and region.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   CreateAzureClusterRequest request =
   *       CreateAzureClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAzureCluster(AzureCluster.newBuilder().build())
   *           .setAzureClusterId("azureClusterId191689446")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AzureCluster, OperationMetadata> future =
   *       azureClustersClient.createAzureClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   AzureCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAzureClusterRequest, AzureCluster, OperationMetadata>
      createAzureClusterOperationCallable() {
    return stub.createAzureClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource on a given
   * GCP project and region.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   CreateAzureClusterRequest request =
   *       CreateAzureClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAzureCluster(AzureCluster.newBuilder().build())
   *           .setAzureClusterId("azureClusterId191689446")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       azureClustersClient.createAzureClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAzureClusterRequest, Operation> createAzureClusterCallable() {
    return stub.createAzureClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   AzureCluster azureCluster = AzureCluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AzureCluster response =
   *       azureClustersClient.updateAzureClusterAsync(azureCluster, updateMask).get();
   * }
   * }</pre>
   *
   * @param azureCluster Required. The [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster]
   *     resource to update.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. The elements of the repeated paths field can only include these fields from
   *     [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster]:
   *     <p>&#42; `description`. &#42; `azureClient`. &#42; `control_plane.version`. &#42;
   *     `control_plane.vm_size`. &#42; `annotations`. &#42; `authorization.admin_users`. &#42;
   *     `control_plane.root_volume.size_gib`. &#42; `control_plane.proxy_config`. &#42;
   *     `control_plane.proxy_config.resource_group_id`. &#42;
   *     `control_plane.proxy_config.secret_id`. &#42; `control_plane.ssh_config.authorized_key`.
   *     &#42; `logging_config.component_config.enable_components` &#42;
   *     `monitoring_config.managed_prometheus_config.enabled`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AzureCluster, OperationMetadata> updateAzureClusterAsync(
      AzureCluster azureCluster, FieldMask updateMask) {
    UpdateAzureClusterRequest request =
        UpdateAzureClusterRequest.newBuilder()
            .setAzureCluster(azureCluster)
            .setUpdateMask(updateMask)
            .build();
    return updateAzureClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   UpdateAzureClusterRequest request =
   *       UpdateAzureClusterRequest.newBuilder()
   *           .setAzureCluster(AzureCluster.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AzureCluster response = azureClustersClient.updateAzureClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AzureCluster, OperationMetadata> updateAzureClusterAsync(
      UpdateAzureClusterRequest request) {
    return updateAzureClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   UpdateAzureClusterRequest request =
   *       UpdateAzureClusterRequest.newBuilder()
   *           .setAzureCluster(AzureCluster.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<AzureCluster, OperationMetadata> future =
   *       azureClustersClient.updateAzureClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   AzureCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAzureClusterRequest, AzureCluster, OperationMetadata>
      updateAzureClusterOperationCallable() {
    return stub.updateAzureClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   UpdateAzureClusterRequest request =
   *       UpdateAzureClusterRequest.newBuilder()
   *           .setAzureCluster(AzureCluster.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       azureClustersClient.updateAzureClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAzureClusterRequest, Operation> updateAzureClusterCallable() {
    return stub.updateAzureClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   AzureClusterName name = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
   *   AzureCluster response = azureClustersClient.getAzureCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource to describe.
   *     <p>`AzureCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AzureCluster getAzureCluster(AzureClusterName name) {
    GetAzureClusterRequest request =
        GetAzureClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAzureCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   String name = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString();
   *   AzureCluster response = azureClustersClient.getAzureCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource to describe.
   *     <p>`AzureCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AzureCluster getAzureCluster(String name) {
    GetAzureClusterRequest request = GetAzureClusterRequest.newBuilder().setName(name).build();
    return getAzureCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   GetAzureClusterRequest request =
   *       GetAzureClusterRequest.newBuilder()
   *           .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
   *           .build();
   *   AzureCluster response = azureClustersClient.getAzureCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AzureCluster getAzureCluster(GetAzureClusterRequest request) {
    return getAzureClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   GetAzureClusterRequest request =
   *       GetAzureClusterRequest.newBuilder()
   *           .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
   *           .build();
   *   ApiFuture<AzureCluster> future =
   *       azureClustersClient.getAzureClusterCallable().futureCall(request);
   *   // Do something.
   *   AzureCluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAzureClusterRequest, AzureCluster> getAzureClusterCallable() {
    return stub.getAzureClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resources on a given
   * Google Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AzureCluster element : azureClustersClient.listAzureClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location which owns this collection of
   *     [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resources.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAzureClustersPagedResponse listAzureClusters(LocationName parent) {
    ListAzureClustersRequest request =
        ListAzureClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAzureClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resources on a given
   * Google Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AzureCluster element : azureClustersClient.listAzureClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location which owns this collection of
   *     [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resources.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAzureClustersPagedResponse listAzureClusters(String parent) {
    ListAzureClustersRequest request =
        ListAzureClustersRequest.newBuilder().setParent(parent).build();
    return listAzureClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resources on a given
   * Google Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   ListAzureClustersRequest request =
   *       ListAzureClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AzureCluster element : azureClustersClient.listAzureClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAzureClustersPagedResponse listAzureClusters(ListAzureClustersRequest request) {
    return listAzureClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resources on a given
   * Google Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   ListAzureClustersRequest request =
   *       ListAzureClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AzureCluster> future =
   *       azureClustersClient.listAzureClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AzureCluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAzureClustersRequest, ListAzureClustersPagedResponse>
      listAzureClustersPagedCallable() {
    return stub.listAzureClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resources on a given
   * Google Cloud project and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   ListAzureClustersRequest request =
   *       ListAzureClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAzureClustersResponse response =
   *         azureClustersClient.listAzureClustersCallable().call(request);
   *     for (AzureCluster element : response.getAzureClustersList()) {
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
  public final UnaryCallable<ListAzureClustersRequest, ListAzureClustersResponse>
      listAzureClustersCallable() {
    return stub.listAzureClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
   *
   * <p>Fails if the cluster has one or more associated
   * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   AzureClusterName name = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
   *   azureClustersClient.deleteAzureClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name the
   *     [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] to delete.
   *     <p>`AzureCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAzureClusterAsync(
      AzureClusterName name) {
    DeleteAzureClusterRequest request =
        DeleteAzureClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteAzureClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
   *
   * <p>Fails if the cluster has one or more associated
   * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   String name = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString();
   *   azureClustersClient.deleteAzureClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name the
   *     [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] to delete.
   *     <p>`AzureCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on GCP resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAzureClusterAsync(String name) {
    DeleteAzureClusterRequest request =
        DeleteAzureClusterRequest.newBuilder().setName(name).build();
    return deleteAzureClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
   *
   * <p>Fails if the cluster has one or more associated
   * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   DeleteAzureClusterRequest request =
   *       DeleteAzureClusterRequest.newBuilder()
   *           .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   azureClustersClient.deleteAzureClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAzureClusterAsync(
      DeleteAzureClusterRequest request) {
    return deleteAzureClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
   *
   * <p>Fails if the cluster has one or more associated
   * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   DeleteAzureClusterRequest request =
   *       DeleteAzureClusterRequest.newBuilder()
   *           .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       azureClustersClient.deleteAzureClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAzureClusterRequest, Empty, OperationMetadata>
      deleteAzureClusterOperationCallable() {
    return stub.deleteAzureClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
   *
   * <p>Fails if the cluster has one or more associated
   * [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   DeleteAzureClusterRequest request =
   *       DeleteAzureClusterRequest.newBuilder()
   *           .setName(AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       azureClustersClient.deleteAzureClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAzureClusterRequest, Operation> deleteAzureClusterCallable() {
    return stub.deleteAzureClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a short-lived access token to authenticate to a given
   * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   GenerateAzureAccessTokenRequest request =
   *       GenerateAzureAccessTokenRequest.newBuilder()
   *           .setAzureCluster(
   *               AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
   *           .build();
   *   GenerateAzureAccessTokenResponse response =
   *       azureClustersClient.generateAzureAccessToken(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAzureAccessTokenResponse generateAzureAccessToken(
      GenerateAzureAccessTokenRequest request) {
    return generateAzureAccessTokenCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a short-lived access token to authenticate to a given
   * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   GenerateAzureAccessTokenRequest request =
   *       GenerateAzureAccessTokenRequest.newBuilder()
   *           .setAzureCluster(
   *               AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
   *           .build();
   *   ApiFuture<GenerateAzureAccessTokenResponse> future =
   *       azureClustersClient.generateAzureAccessTokenCallable().futureCall(request);
   *   // Do something.
   *   GenerateAzureAccessTokenResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
      generateAzureAccessTokenCallable() {
    return stub.generateAzureAccessTokenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool], attached to a given
   * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   AzureClusterName parent = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
   *   AzureNodePool azureNodePool = AzureNodePool.newBuilder().build();
   *   String azureNodePoolId = "azureNodePoolId-1766264088";
   *   AzureNodePool response =
   *       azureClustersClient
   *           .createAzureNodePoolAsync(parent, azureNodePool, azureNodePoolId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource
   *     where this node pool will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param azureNodePool Required. The specification of the
   *     [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] to create.
   * @param azureNodePoolId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;/azureNodePools/&lt;node-pool-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AzureNodePool, OperationMetadata> createAzureNodePoolAsync(
      AzureClusterName parent, AzureNodePool azureNodePool, String azureNodePoolId) {
    CreateAzureNodePoolRequest request =
        CreateAzureNodePoolRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAzureNodePool(azureNodePool)
            .setAzureNodePoolId(azureNodePoolId)
            .build();
    return createAzureNodePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool], attached to a given
   * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   String parent = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString();
   *   AzureNodePool azureNodePool = AzureNodePool.newBuilder().build();
   *   String azureNodePoolId = "azureNodePoolId-1766264088";
   *   AzureNodePool response =
   *       azureClustersClient
   *           .createAzureNodePoolAsync(parent, azureNodePool, azureNodePoolId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster] resource
   *     where this node pool will be created.
   *     <p>Location names are formatted as `projects/&lt;project-id&gt;/locations/&lt;region&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @param azureNodePool Required. The specification of the
   *     [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] to create.
   * @param azureNodePoolId Required. A client provided ID the resource. Must be unique within the
   *     parent resource.
   *     <p>The provided ID will be part of the
   *     [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource name formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;/azureNodePools/&lt;node-pool-id&gt;`.
   *     <p>Valid characters are `/[a-z][0-9]-/`. Cannot be longer than 63 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AzureNodePool, OperationMetadata> createAzureNodePoolAsync(
      String parent, AzureNodePool azureNodePool, String azureNodePoolId) {
    CreateAzureNodePoolRequest request =
        CreateAzureNodePoolRequest.newBuilder()
            .setParent(parent)
            .setAzureNodePool(azureNodePool)
            .setAzureNodePoolId(azureNodePoolId)
            .build();
    return createAzureNodePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool], attached to a given
   * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   CreateAzureNodePoolRequest request =
   *       CreateAzureNodePoolRequest.newBuilder()
   *           .setParent(
   *               AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
   *           .setAzureNodePool(AzureNodePool.newBuilder().build())
   *           .setAzureNodePoolId("azureNodePoolId-1766264088")
   *           .setValidateOnly(true)
   *           .build();
   *   AzureNodePool response = azureClustersClient.createAzureNodePoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AzureNodePool, OperationMetadata> createAzureNodePoolAsync(
      CreateAzureNodePoolRequest request) {
    return createAzureNodePoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool], attached to a given
   * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   CreateAzureNodePoolRequest request =
   *       CreateAzureNodePoolRequest.newBuilder()
   *           .setParent(
   *               AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
   *           .setAzureNodePool(AzureNodePool.newBuilder().build())
   *           .setAzureNodePoolId("azureNodePoolId-1766264088")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AzureNodePool, OperationMetadata> future =
   *       azureClustersClient.createAzureNodePoolOperationCallable().futureCall(request);
   *   // Do something.
   *   AzureNodePool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      createAzureNodePoolOperationCallable() {
    return stub.createAzureNodePoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool], attached to a given
   * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   CreateAzureNodePoolRequest request =
   *       CreateAzureNodePoolRequest.newBuilder()
   *           .setParent(
   *               AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
   *           .setAzureNodePool(AzureNodePool.newBuilder().build())
   *           .setAzureNodePoolId("azureNodePoolId-1766264088")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       azureClustersClient.createAzureNodePoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAzureNodePoolRequest, Operation> createAzureNodePoolCallable() {
    return stub.createAzureNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   AzureNodePool azureNodePool = AzureNodePool.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AzureNodePool response =
   *       azureClustersClient.updateAzureNodePoolAsync(azureNodePool, updateMask).get();
   * }
   * }</pre>
   *
   * @param azureNodePool Required. The [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool]
   *     resource to update.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. The elements of the repeated paths field can only include these fields from
   *     [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool]:
   *     <p>&#42;. `annotations`. &#42; `version`. &#42; `autoscaling.min_node_count`. &#42;
   *     `autoscaling.max_node_count`. &#42; `config.ssh_config.authorized_key`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AzureNodePool, OperationMetadata> updateAzureNodePoolAsync(
      AzureNodePool azureNodePool, FieldMask updateMask) {
    UpdateAzureNodePoolRequest request =
        UpdateAzureNodePoolRequest.newBuilder()
            .setAzureNodePool(azureNodePool)
            .setUpdateMask(updateMask)
            .build();
    return updateAzureNodePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   UpdateAzureNodePoolRequest request =
   *       UpdateAzureNodePoolRequest.newBuilder()
   *           .setAzureNodePool(AzureNodePool.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AzureNodePool response = azureClustersClient.updateAzureNodePoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AzureNodePool, OperationMetadata> updateAzureNodePoolAsync(
      UpdateAzureNodePoolRequest request) {
    return updateAzureNodePoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   UpdateAzureNodePoolRequest request =
   *       UpdateAzureNodePoolRequest.newBuilder()
   *           .setAzureNodePool(AzureNodePool.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<AzureNodePool, OperationMetadata> future =
   *       azureClustersClient.updateAzureNodePoolOperationCallable().futureCall(request);
   *   // Do something.
   *   AzureNodePool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      updateAzureNodePoolOperationCallable() {
    return stub.updateAzureNodePoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   UpdateAzureNodePoolRequest request =
   *       UpdateAzureNodePoolRequest.newBuilder()
   *           .setAzureNodePool(AzureNodePool.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       azureClustersClient.updateAzureNodePoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAzureNodePoolRequest, Operation> updateAzureNodePoolCallable() {
    return stub.updateAzureNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   AzureNodePoolName name =
   *       AzureNodePoolName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]");
   *   AzureNodePool response = azureClustersClient.getAzureNodePool(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource to describe.
   *     <p>`AzureNodePool` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;/azureNodePools/&lt;node-pool-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AzureNodePool getAzureNodePool(AzureNodePoolName name) {
    GetAzureNodePoolRequest request =
        GetAzureNodePoolRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAzureNodePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   String name =
   *       AzureNodePoolName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
   *           .toString();
   *   AzureNodePool response = azureClustersClient.getAzureNodePool(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource to describe.
   *     <p>`AzureNodePool` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;/azureNodePools/&lt;node-pool-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AzureNodePool getAzureNodePool(String name) {
    GetAzureNodePoolRequest request = GetAzureNodePoolRequest.newBuilder().setName(name).build();
    return getAzureNodePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   GetAzureNodePoolRequest request =
   *       GetAzureNodePoolRequest.newBuilder()
   *           .setName(
   *               AzureNodePoolName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
   *                   .toString())
   *           .build();
   *   AzureNodePool response = azureClustersClient.getAzureNodePool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AzureNodePool getAzureNodePool(GetAzureNodePoolRequest request) {
    return getAzureNodePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specific [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   GetAzureNodePoolRequest request =
   *       GetAzureNodePoolRequest.newBuilder()
   *           .setName(
   *               AzureNodePoolName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AzureNodePool> future =
   *       azureClustersClient.getAzureNodePoolCallable().futureCall(request);
   *   // Do something.
   *   AzureNodePool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAzureNodePoolRequest, AzureNodePool> getAzureNodePoolCallable() {
    return stub.getAzureNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources on a given
   * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   AzureClusterName parent = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]");
   *   for (AzureNodePool element : azureClustersClient.listAzureNodePools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent `AzureCluster` which owns this collection of
   *     [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources.
   *     <p>`AzureCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAzureNodePoolsPagedResponse listAzureNodePools(AzureClusterName parent) {
    ListAzureNodePoolsRequest request =
        ListAzureNodePoolsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAzureNodePools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources on a given
   * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   String parent = AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString();
   *   for (AzureNodePool element : azureClustersClient.listAzureNodePools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent `AzureCluster` which owns this collection of
   *     [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources.
   *     <p>`AzureCluster` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAzureNodePoolsPagedResponse listAzureNodePools(String parent) {
    ListAzureNodePoolsRequest request =
        ListAzureNodePoolsRequest.newBuilder().setParent(parent).build();
    return listAzureNodePools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources on a given
   * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   ListAzureNodePoolsRequest request =
   *       ListAzureNodePoolsRequest.newBuilder()
   *           .setParent(
   *               AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AzureNodePool element : azureClustersClient.listAzureNodePools(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAzureNodePoolsPagedResponse listAzureNodePools(
      ListAzureNodePoolsRequest request) {
    return listAzureNodePoolsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources on a given
   * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   ListAzureNodePoolsRequest request =
   *       ListAzureNodePoolsRequest.newBuilder()
   *           .setParent(
   *               AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AzureNodePool> future =
   *       azureClustersClient.listAzureNodePoolsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AzureNodePool element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsPagedResponse>
      listAzureNodePoolsPagedCallable() {
    return stub.listAzureNodePoolsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resources on a given
   * [AzureCluster][google.cloud.gkemulticloud.v1.AzureCluster].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   ListAzureNodePoolsRequest request =
   *       ListAzureNodePoolsRequest.newBuilder()
   *           .setParent(
   *               AzureClusterName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAzureNodePoolsResponse response =
   *         azureClustersClient.listAzureNodePoolsCallable().call(request);
   *     for (AzureNodePool element : response.getAzureNodePoolsList()) {
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
  public final UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>
      listAzureNodePoolsCallable() {
    return stub.listAzureNodePoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   AzureNodePoolName name =
   *       AzureNodePoolName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]");
   *   azureClustersClient.deleteAzureNodePoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name the
   *     [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] to delete.
   *     <p>`AzureNodePool` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;/azureNodePools/&lt;node-pool-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAzureNodePoolAsync(
      AzureNodePoolName name) {
    DeleteAzureNodePoolRequest request =
        DeleteAzureNodePoolRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteAzureNodePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   String name =
   *       AzureNodePoolName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
   *           .toString();
   *   azureClustersClient.deleteAzureNodePoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name the
   *     [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] to delete.
   *     <p>`AzureNodePool` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureClusters/&lt;cluster-id&gt;/azureNodePools/&lt;node-pool-id&gt;`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAzureNodePoolAsync(String name) {
    DeleteAzureNodePoolRequest request =
        DeleteAzureNodePoolRequest.newBuilder().setName(name).build();
    return deleteAzureNodePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   DeleteAzureNodePoolRequest request =
   *       DeleteAzureNodePoolRequest.newBuilder()
   *           .setName(
   *               AzureNodePoolName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   azureClustersClient.deleteAzureNodePoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAzureNodePoolAsync(
      DeleteAzureNodePoolRequest request) {
    return deleteAzureNodePoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   DeleteAzureNodePoolRequest request =
   *       DeleteAzureNodePoolRequest.newBuilder()
   *           .setName(
   *               AzureNodePoolName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       azureClustersClient.deleteAzureNodePoolOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAzureNodePoolRequest, Empty, OperationMetadata>
      deleteAzureNodePoolOperationCallable() {
    return stub.deleteAzureNodePoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific [AzureNodePool][google.cloud.gkemulticloud.v1.AzureNodePool] resource.
   *
   * <p>If successful, the response contains a newly created
   * [Operation][google.longrunning.Operation] resource that can be described to track the status of
   * the operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   DeleteAzureNodePoolRequest request =
   *       DeleteAzureNodePoolRequest.newBuilder()
   *           .setName(
   *               AzureNodePoolName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       azureClustersClient.deleteAzureNodePoolCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAzureNodePoolRequest, Operation> deleteAzureNodePoolCallable() {
    return stub.deleteAzureNodePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information, such as supported Azure regions and Kubernetes versions, on a given Google
   * Cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   AzureServerConfigName name = AzureServerConfigName.of("[PROJECT]", "[LOCATION]");
   *   AzureServerConfig response = azureClustersClient.getAzureServerConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [AzureServerConfig][google.cloud.gkemulticloud.v1.AzureServerConfig] resource to describe.
   *     <p>`AzureServerConfig` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureServerConfig`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AzureServerConfig getAzureServerConfig(AzureServerConfigName name) {
    GetAzureServerConfigRequest request =
        GetAzureServerConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAzureServerConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information, such as supported Azure regions and Kubernetes versions, on a given Google
   * Cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   String name = AzureServerConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   AzureServerConfig response = azureClustersClient.getAzureServerConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [AzureServerConfig][google.cloud.gkemulticloud.v1.AzureServerConfig] resource to describe.
   *     <p>`AzureServerConfig` names are formatted as
   *     `projects/&lt;project-id&gt;/locations/&lt;region&gt;/azureServerConfig`.
   *     <p>See [Resource Names](https://cloud.google.com/apis/design/resource_names) for more
   *     details on Google Cloud resource names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AzureServerConfig getAzureServerConfig(String name) {
    GetAzureServerConfigRequest request =
        GetAzureServerConfigRequest.newBuilder().setName(name).build();
    return getAzureServerConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information, such as supported Azure regions and Kubernetes versions, on a given Google
   * Cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   GetAzureServerConfigRequest request =
   *       GetAzureServerConfigRequest.newBuilder()
   *           .setName(AzureServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   AzureServerConfig response = azureClustersClient.getAzureServerConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AzureServerConfig getAzureServerConfig(GetAzureServerConfigRequest request) {
    return getAzureServerConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information, such as supported Azure regions and Kubernetes versions, on a given Google
   * Cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
   *   GetAzureServerConfigRequest request =
   *       GetAzureServerConfigRequest.newBuilder()
   *           .setName(AzureServerConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<AzureServerConfig> future =
   *       azureClustersClient.getAzureServerConfigCallable().futureCall(request);
   *   // Do something.
   *   AzureServerConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAzureServerConfigRequest, AzureServerConfig>
      getAzureServerConfigCallable() {
    return stub.getAzureServerConfigCallable();
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

  public static class ListAzureClientsPagedResponse
      extends AbstractPagedListResponse<
          ListAzureClientsRequest,
          ListAzureClientsResponse,
          AzureClient,
          ListAzureClientsPage,
          ListAzureClientsFixedSizeCollection> {

    public static ApiFuture<ListAzureClientsPagedResponse> createAsync(
        PageContext<ListAzureClientsRequest, ListAzureClientsResponse, AzureClient> context,
        ApiFuture<ListAzureClientsResponse> futureResponse) {
      ApiFuture<ListAzureClientsPage> futurePage =
          ListAzureClientsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAzureClientsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAzureClientsPagedResponse(ListAzureClientsPage page) {
      super(page, ListAzureClientsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAzureClientsPage
      extends AbstractPage<
          ListAzureClientsRequest, ListAzureClientsResponse, AzureClient, ListAzureClientsPage> {

    private ListAzureClientsPage(
        PageContext<ListAzureClientsRequest, ListAzureClientsResponse, AzureClient> context,
        ListAzureClientsResponse response) {
      super(context, response);
    }

    private static ListAzureClientsPage createEmptyPage() {
      return new ListAzureClientsPage(null, null);
    }

    @Override
    protected ListAzureClientsPage createPage(
        PageContext<ListAzureClientsRequest, ListAzureClientsResponse, AzureClient> context,
        ListAzureClientsResponse response) {
      return new ListAzureClientsPage(context, response);
    }

    @Override
    public ApiFuture<ListAzureClientsPage> createPageAsync(
        PageContext<ListAzureClientsRequest, ListAzureClientsResponse, AzureClient> context,
        ApiFuture<ListAzureClientsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAzureClientsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAzureClientsRequest,
          ListAzureClientsResponse,
          AzureClient,
          ListAzureClientsPage,
          ListAzureClientsFixedSizeCollection> {

    private ListAzureClientsFixedSizeCollection(
        List<ListAzureClientsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAzureClientsFixedSizeCollection createEmptyCollection() {
      return new ListAzureClientsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAzureClientsFixedSizeCollection createCollection(
        List<ListAzureClientsPage> pages, int collectionSize) {
      return new ListAzureClientsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAzureClustersPagedResponse
      extends AbstractPagedListResponse<
          ListAzureClustersRequest,
          ListAzureClustersResponse,
          AzureCluster,
          ListAzureClustersPage,
          ListAzureClustersFixedSizeCollection> {

    public static ApiFuture<ListAzureClustersPagedResponse> createAsync(
        PageContext<ListAzureClustersRequest, ListAzureClustersResponse, AzureCluster> context,
        ApiFuture<ListAzureClustersResponse> futureResponse) {
      ApiFuture<ListAzureClustersPage> futurePage =
          ListAzureClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAzureClustersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAzureClustersPagedResponse(ListAzureClustersPage page) {
      super(page, ListAzureClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAzureClustersPage
      extends AbstractPage<
          ListAzureClustersRequest,
          ListAzureClustersResponse,
          AzureCluster,
          ListAzureClustersPage> {

    private ListAzureClustersPage(
        PageContext<ListAzureClustersRequest, ListAzureClustersResponse, AzureCluster> context,
        ListAzureClustersResponse response) {
      super(context, response);
    }

    private static ListAzureClustersPage createEmptyPage() {
      return new ListAzureClustersPage(null, null);
    }

    @Override
    protected ListAzureClustersPage createPage(
        PageContext<ListAzureClustersRequest, ListAzureClustersResponse, AzureCluster> context,
        ListAzureClustersResponse response) {
      return new ListAzureClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListAzureClustersPage> createPageAsync(
        PageContext<ListAzureClustersRequest, ListAzureClustersResponse, AzureCluster> context,
        ApiFuture<ListAzureClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAzureClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAzureClustersRequest,
          ListAzureClustersResponse,
          AzureCluster,
          ListAzureClustersPage,
          ListAzureClustersFixedSizeCollection> {

    private ListAzureClustersFixedSizeCollection(
        List<ListAzureClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAzureClustersFixedSizeCollection createEmptyCollection() {
      return new ListAzureClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAzureClustersFixedSizeCollection createCollection(
        List<ListAzureClustersPage> pages, int collectionSize) {
      return new ListAzureClustersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAzureNodePoolsPagedResponse
      extends AbstractPagedListResponse<
          ListAzureNodePoolsRequest,
          ListAzureNodePoolsResponse,
          AzureNodePool,
          ListAzureNodePoolsPage,
          ListAzureNodePoolsFixedSizeCollection> {

    public static ApiFuture<ListAzureNodePoolsPagedResponse> createAsync(
        PageContext<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, AzureNodePool> context,
        ApiFuture<ListAzureNodePoolsResponse> futureResponse) {
      ApiFuture<ListAzureNodePoolsPage> futurePage =
          ListAzureNodePoolsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAzureNodePoolsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAzureNodePoolsPagedResponse(ListAzureNodePoolsPage page) {
      super(page, ListAzureNodePoolsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAzureNodePoolsPage
      extends AbstractPage<
          ListAzureNodePoolsRequest,
          ListAzureNodePoolsResponse,
          AzureNodePool,
          ListAzureNodePoolsPage> {

    private ListAzureNodePoolsPage(
        PageContext<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, AzureNodePool> context,
        ListAzureNodePoolsResponse response) {
      super(context, response);
    }

    private static ListAzureNodePoolsPage createEmptyPage() {
      return new ListAzureNodePoolsPage(null, null);
    }

    @Override
    protected ListAzureNodePoolsPage createPage(
        PageContext<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, AzureNodePool> context,
        ListAzureNodePoolsResponse response) {
      return new ListAzureNodePoolsPage(context, response);
    }

    @Override
    public ApiFuture<ListAzureNodePoolsPage> createPageAsync(
        PageContext<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse, AzureNodePool> context,
        ApiFuture<ListAzureNodePoolsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAzureNodePoolsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAzureNodePoolsRequest,
          ListAzureNodePoolsResponse,
          AzureNodePool,
          ListAzureNodePoolsPage,
          ListAzureNodePoolsFixedSizeCollection> {

    private ListAzureNodePoolsFixedSizeCollection(
        List<ListAzureNodePoolsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAzureNodePoolsFixedSizeCollection createEmptyCollection() {
      return new ListAzureNodePoolsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAzureNodePoolsFixedSizeCollection createCollection(
        List<ListAzureNodePoolsPage> pages, int collectionSize) {
      return new ListAzureNodePoolsFixedSizeCollection(pages, collectionSize);
    }
  }
}
