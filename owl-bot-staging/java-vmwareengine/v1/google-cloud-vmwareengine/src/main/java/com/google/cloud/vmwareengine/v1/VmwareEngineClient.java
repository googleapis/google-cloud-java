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

package com.google.cloud.vmwareengine.v1;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vmwareengine.v1.stub.VmwareEngineStub;
import com.google.cloud.vmwareengine.v1.stub.VmwareEngineStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: VMwareEngine manages VMware's private clusters in the Cloud.
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
 * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
 *   PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
 *   PrivateCloud response = vmwareEngineClient.getPrivateCloud(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the VmwareEngineClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of VmwareEngineSettings to
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
 * VmwareEngineSettings vmwareEngineSettings =
 *     VmwareEngineSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create(vmwareEngineSettings);
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
 * VmwareEngineSettings vmwareEngineSettings =
 *     VmwareEngineSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create(vmwareEngineSettings);
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
 * VmwareEngineSettings vmwareEngineSettings = VmwareEngineSettings.newHttpJsonBuilder().build();
 * VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create(vmwareEngineSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class VmwareEngineClient implements BackgroundResource {
  private final VmwareEngineSettings settings;
  private final VmwareEngineStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of VmwareEngineClient with default settings. */
  public static final VmwareEngineClient create() throws IOException {
    return create(VmwareEngineSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VmwareEngineClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VmwareEngineClient create(VmwareEngineSettings settings) throws IOException {
    return new VmwareEngineClient(settings);
  }

  /**
   * Constructs an instance of VmwareEngineClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(VmwareEngineSettings).
   */
  public static final VmwareEngineClient create(VmwareEngineStub stub) {
    return new VmwareEngineClient(stub);
  }

  /**
   * Constructs an instance of VmwareEngineClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected VmwareEngineClient(VmwareEngineSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VmwareEngineStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected VmwareEngineClient(VmwareEngineStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final VmwareEngineSettings getSettings() {
    return settings;
  }

  public VmwareEngineStub getStub() {
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
   * Lists `PrivateCloud` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PrivateCloud element : vmwareEngineClient.listPrivateClouds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for clusters.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateCloudsPagedResponse listPrivateClouds(LocationName parent) {
    ListPrivateCloudsRequest request =
        ListPrivateCloudsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPrivateClouds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateCloud` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PrivateCloud element : vmwareEngineClient.listPrivateClouds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for clusters.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateCloudsPagedResponse listPrivateClouds(String parent) {
    ListPrivateCloudsRequest request =
        ListPrivateCloudsRequest.newBuilder().setParent(parent).build();
    return listPrivateClouds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateCloud` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPrivateCloudsRequest request =
   *       ListPrivateCloudsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (PrivateCloud element : vmwareEngineClient.listPrivateClouds(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateCloudsPagedResponse listPrivateClouds(ListPrivateCloudsRequest request) {
    return listPrivateCloudsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateCloud` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPrivateCloudsRequest request =
   *       ListPrivateCloudsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<PrivateCloud> future =
   *       vmwareEngineClient.listPrivateCloudsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PrivateCloud element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsPagedResponse>
      listPrivateCloudsPagedCallable() {
    return stub.listPrivateCloudsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `PrivateCloud` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListPrivateCloudsRequest request =
   *       ListPrivateCloudsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListPrivateCloudsResponse response =
   *         vmwareEngineClient.listPrivateCloudsCallable().call(request);
   *     for (PrivateCloud element : response.getPrivateCloudsList()) {
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
  public final UnaryCallable<ListPrivateCloudsRequest, ListPrivateCloudsResponse>
      listPrivateCloudsCallable() {
    return stub.listPrivateCloudsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `PrivateCloud` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   PrivateCloud response = vmwareEngineClient.getPrivateCloud(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private cloud to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateCloud getPrivateCloud(PrivateCloudName name) {
    GetPrivateCloudRequest request =
        GetPrivateCloudRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPrivateCloud(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `PrivateCloud` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   PrivateCloud response = vmwareEngineClient.getPrivateCloud(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private cloud to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateCloud getPrivateCloud(String name) {
    GetPrivateCloudRequest request = GetPrivateCloudRequest.newBuilder().setName(name).build();
    return getPrivateCloud(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `PrivateCloud` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetPrivateCloudRequest request =
   *       GetPrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.getPrivateCloud(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateCloud getPrivateCloud(GetPrivateCloudRequest request) {
    return getPrivateCloudCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `PrivateCloud` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetPrivateCloudRequest request =
   *       GetPrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .build();
   *   ApiFuture<PrivateCloud> future =
   *       vmwareEngineClient.getPrivateCloudCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPrivateCloudRequest, PrivateCloud> getPrivateCloudCallable() {
    return stub.getPrivateCloudCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `PrivateCloud` resource in a given project and location. Private clouds can only
   * be created in zones, regional private clouds are not supported.
   *
   * <p>Creating a private cloud also creates a [management
   * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components) for that
   * private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
   *   String privateCloudId = "privateCloudId573896493";
   *   PrivateCloud response =
   *       vmwareEngineClient.createPrivateCloudAsync(parent, privateCloud, privateCloudId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create the new private cloud in.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a`
   * @param privateCloud Required. The initial description of the new private cloud.
   * @param privateCloudId Required. The user-provided identifier of the private cloud to be
   *     created. This identifier must be unique among each `PrivateCloud` within the parent and
   *     becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> createPrivateCloudAsync(
      LocationName parent, PrivateCloud privateCloud, String privateCloudId) {
    CreatePrivateCloudRequest request =
        CreatePrivateCloudRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPrivateCloud(privateCloud)
            .setPrivateCloudId(privateCloudId)
            .build();
    return createPrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `PrivateCloud` resource in a given project and location. Private clouds can only
   * be created in zones, regional private clouds are not supported.
   *
   * <p>Creating a private cloud also creates a [management
   * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components) for that
   * private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
   *   String privateCloudId = "privateCloudId573896493";
   *   PrivateCloud response =
   *       vmwareEngineClient.createPrivateCloudAsync(parent, privateCloud, privateCloudId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create the new private cloud in.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a`
   * @param privateCloud Required. The initial description of the new private cloud.
   * @param privateCloudId Required. The user-provided identifier of the private cloud to be
   *     created. This identifier must be unique among each `PrivateCloud` within the parent and
   *     becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> createPrivateCloudAsync(
      String parent, PrivateCloud privateCloud, String privateCloudId) {
    CreatePrivateCloudRequest request =
        CreatePrivateCloudRequest.newBuilder()
            .setParent(parent)
            .setPrivateCloud(privateCloud)
            .setPrivateCloudId(privateCloudId)
            .build();
    return createPrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `PrivateCloud` resource in a given project and location. Private clouds can only
   * be created in zones, regional private clouds are not supported.
   *
   * <p>Creating a private cloud also creates a [management
   * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components) for that
   * private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreatePrivateCloudRequest request =
   *       CreatePrivateCloudRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateCloudId("privateCloudId573896493")
   *           .setPrivateCloud(PrivateCloud.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.createPrivateCloudAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> createPrivateCloudAsync(
      CreatePrivateCloudRequest request) {
    return createPrivateCloudOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `PrivateCloud` resource in a given project and location. Private clouds can only
   * be created in zones, regional private clouds are not supported.
   *
   * <p>Creating a private cloud also creates a [management
   * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components) for that
   * private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreatePrivateCloudRequest request =
   *       CreatePrivateCloudRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateCloudId("privateCloudId573896493")
   *           .setPrivateCloud(PrivateCloud.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<PrivateCloud, OperationMetadata> future =
   *       vmwareEngineClient.createPrivateCloudOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      createPrivateCloudOperationCallable() {
    return stub.createPrivateCloudOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new `PrivateCloud` resource in a given project and location. Private clouds can only
   * be created in zones, regional private clouds are not supported.
   *
   * <p>Creating a private cloud also creates a [management
   * cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components) for that
   * private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreatePrivateCloudRequest request =
   *       CreatePrivateCloudRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPrivateCloudId("privateCloudId573896493")
   *           .setPrivateCloud(PrivateCloud.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createPrivateCloudCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePrivateCloudRequest, Operation> createPrivateCloudCallable() {
    return stub.createPrivateCloudCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `PrivateCloud` resource. Only the following fields can be updated: `description`.
   * Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloud privateCloud = PrivateCloud.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PrivateCloud response =
   *       vmwareEngineClient.updatePrivateCloudAsync(privateCloud, updateMask).get();
   * }
   * }</pre>
   *
   * @param privateCloud Required. Private cloud description.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `PrivateCloud` resource by the update. The fields specified in `updateMask` are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> updatePrivateCloudAsync(
      PrivateCloud privateCloud, FieldMask updateMask) {
    UpdatePrivateCloudRequest request =
        UpdatePrivateCloudRequest.newBuilder()
            .setPrivateCloud(privateCloud)
            .setUpdateMask(updateMask)
            .build();
    return updatePrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `PrivateCloud` resource. Only the following fields can be updated: `description`.
   * Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdatePrivateCloudRequest request =
   *       UpdatePrivateCloudRequest.newBuilder()
   *           .setPrivateCloud(PrivateCloud.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.updatePrivateCloudAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> updatePrivateCloudAsync(
      UpdatePrivateCloudRequest request) {
    return updatePrivateCloudOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `PrivateCloud` resource. Only the following fields can be updated: `description`.
   * Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdatePrivateCloudRequest request =
   *       UpdatePrivateCloudRequest.newBuilder()
   *           .setPrivateCloud(PrivateCloud.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PrivateCloud, OperationMetadata> future =
   *       vmwareEngineClient.updatePrivateCloudOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdatePrivateCloudRequest, PrivateCloud, OperationMetadata>
      updatePrivateCloudOperationCallable() {
    return stub.updatePrivateCloudOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `PrivateCloud` resource. Only the following fields can be updated: `description`.
   * Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdatePrivateCloudRequest request =
   *       UpdatePrivateCloudRequest.newBuilder()
   *           .setPrivateCloud(PrivateCloud.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.updatePrivateCloudCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePrivateCloudRequest, Operation> updatePrivateCloudCallable() {
    return stub.updatePrivateCloudCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedules a `PrivateCloud` resource for deletion.
   *
   * <p>A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED`
   * and `expireTime` set to the time when deletion is final and can no longer be reversed. The
   * delete operation is marked as done as soon as the `PrivateCloud` is successfully scheduled for
   * deletion (this also applies when `delayHours` is set to zero), and the operation is not kept in
   * pending state until `PrivateCloud` is purged. `PrivateCloud` can be restored using
   * `UndeletePrivateCloud` method before the `expireTime` elapses. When `expireTime` is reached,
   * deletion is final and all private cloud resources are irreversibly removed and billing stops.
   * During the final removal process, `PrivateCloud.state` is set to `PURGING`. `PrivateCloud` can
   * be polled using standard `GET` method for the whole period of deletion and purging. It will not
   * be returned only when it is completely purged.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   PrivateCloud response = vmwareEngineClient.deletePrivateCloudAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private cloud to delete. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> deletePrivateCloudAsync(
      PrivateCloudName name) {
    DeletePrivateCloudRequest request =
        DeletePrivateCloudRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedules a `PrivateCloud` resource for deletion.
   *
   * <p>A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED`
   * and `expireTime` set to the time when deletion is final and can no longer be reversed. The
   * delete operation is marked as done as soon as the `PrivateCloud` is successfully scheduled for
   * deletion (this also applies when `delayHours` is set to zero), and the operation is not kept in
   * pending state until `PrivateCloud` is purged. `PrivateCloud` can be restored using
   * `UndeletePrivateCloud` method before the `expireTime` elapses. When `expireTime` is reached,
   * deletion is final and all private cloud resources are irreversibly removed and billing stops.
   * During the final removal process, `PrivateCloud.state` is set to `PURGING`. `PrivateCloud` can
   * be polled using standard `GET` method for the whole period of deletion and purging. It will not
   * be returned only when it is completely purged.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   PrivateCloud response = vmwareEngineClient.deletePrivateCloudAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private cloud to delete. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> deletePrivateCloudAsync(
      String name) {
    DeletePrivateCloudRequest request =
        DeletePrivateCloudRequest.newBuilder().setName(name).build();
    return deletePrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedules a `PrivateCloud` resource for deletion.
   *
   * <p>A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED`
   * and `expireTime` set to the time when deletion is final and can no longer be reversed. The
   * delete operation is marked as done as soon as the `PrivateCloud` is successfully scheduled for
   * deletion (this also applies when `delayHours` is set to zero), and the operation is not kept in
   * pending state until `PrivateCloud` is purged. `PrivateCloud` can be restored using
   * `UndeletePrivateCloud` method before the `expireTime` elapses. When `expireTime` is reached,
   * deletion is final and all private cloud resources are irreversibly removed and billing stops.
   * During the final removal process, `PrivateCloud.state` is set to `PURGING`. `PrivateCloud` can
   * be polled using standard `GET` method for the whole period of deletion and purging. It will not
   * be returned only when it is completely purged.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeletePrivateCloudRequest request =
   *       DeletePrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .setDelayHours(475821395)
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.deletePrivateCloudAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> deletePrivateCloudAsync(
      DeletePrivateCloudRequest request) {
    return deletePrivateCloudOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedules a `PrivateCloud` resource for deletion.
   *
   * <p>A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED`
   * and `expireTime` set to the time when deletion is final and can no longer be reversed. The
   * delete operation is marked as done as soon as the `PrivateCloud` is successfully scheduled for
   * deletion (this also applies when `delayHours` is set to zero), and the operation is not kept in
   * pending state until `PrivateCloud` is purged. `PrivateCloud` can be restored using
   * `UndeletePrivateCloud` method before the `expireTime` elapses. When `expireTime` is reached,
   * deletion is final and all private cloud resources are irreversibly removed and billing stops.
   * During the final removal process, `PrivateCloud.state` is set to `PURGING`. `PrivateCloud` can
   * be polled using standard `GET` method for the whole period of deletion and purging. It will not
   * be returned only when it is completely purged.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeletePrivateCloudRequest request =
   *       DeletePrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .setDelayHours(475821395)
   *           .build();
   *   OperationFuture<PrivateCloud, OperationMetadata> future =
   *       vmwareEngineClient.deletePrivateCloudOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      deletePrivateCloudOperationCallable() {
    return stub.deletePrivateCloudOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedules a `PrivateCloud` resource for deletion.
   *
   * <p>A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED`
   * and `expireTime` set to the time when deletion is final and can no longer be reversed. The
   * delete operation is marked as done as soon as the `PrivateCloud` is successfully scheduled for
   * deletion (this also applies when `delayHours` is set to zero), and the operation is not kept in
   * pending state until `PrivateCloud` is purged. `PrivateCloud` can be restored using
   * `UndeletePrivateCloud` method before the `expireTime` elapses. When `expireTime` is reached,
   * deletion is final and all private cloud resources are irreversibly removed and billing stops.
   * During the final removal process, `PrivateCloud.state` is set to `PURGING`. `PrivateCloud` can
   * be polled using standard `GET` method for the whole period of deletion and purging. It will not
   * be returned only when it is completely purged.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeletePrivateCloudRequest request =
   *       DeletePrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .setDelayHours(475821395)
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.deletePrivateCloudCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePrivateCloudRequest, Operation> deletePrivateCloudCallable() {
    return stub.deletePrivateCloudCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a private cloud that was previously scheduled for deletion by `DeletePrivateCloud`. A
   * `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and
   * `PrivateCloud.expireTime` set to the time when deletion can no longer be reversed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   PrivateCloud response = vmwareEngineClient.undeletePrivateCloudAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private cloud scheduled for deletion. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> undeletePrivateCloudAsync(
      PrivateCloudName name) {
    UndeletePrivateCloudRequest request =
        UndeletePrivateCloudRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeletePrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a private cloud that was previously scheduled for deletion by `DeletePrivateCloud`. A
   * `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and
   * `PrivateCloud.expireTime` set to the time when deletion can no longer be reversed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   PrivateCloud response = vmwareEngineClient.undeletePrivateCloudAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the private cloud scheduled for deletion. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> undeletePrivateCloudAsync(
      String name) {
    UndeletePrivateCloudRequest request =
        UndeletePrivateCloudRequest.newBuilder().setName(name).build();
    return undeletePrivateCloudAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a private cloud that was previously scheduled for deletion by `DeletePrivateCloud`. A
   * `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and
   * `PrivateCloud.expireTime` set to the time when deletion can no longer be reversed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UndeletePrivateCloudRequest request =
   *       UndeletePrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.undeletePrivateCloudAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> undeletePrivateCloudAsync(
      UndeletePrivateCloudRequest request) {
    return undeletePrivateCloudOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a private cloud that was previously scheduled for deletion by `DeletePrivateCloud`. A
   * `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and
   * `PrivateCloud.expireTime` set to the time when deletion can no longer be reversed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UndeletePrivateCloudRequest request =
   *       UndeletePrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PrivateCloud, OperationMetadata> future =
   *       vmwareEngineClient.undeletePrivateCloudOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UndeletePrivateCloudRequest, PrivateCloud, OperationMetadata>
      undeletePrivateCloudOperationCallable() {
    return stub.undeletePrivateCloudOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a private cloud that was previously scheduled for deletion by `DeletePrivateCloud`. A
   * `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and
   * `PrivateCloud.expireTime` set to the time when deletion can no longer be reversed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UndeletePrivateCloudRequest request =
   *       UndeletePrivateCloudRequest.newBuilder()
   *           .setName(PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.undeletePrivateCloudCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeletePrivateCloudRequest, Operation>
      undeletePrivateCloudCallable() {
    return stub.undeletePrivateCloudCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Cluster` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   for (Cluster element : vmwareEngineClient.listClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to query for clusters. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(PrivateCloudName parent) {
    ListClustersRequest request =
        ListClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Cluster` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   for (Cluster element : vmwareEngineClient.listClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to query for clusters. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(String parent) {
    ListClustersRequest request = ListClustersRequest.newBuilder().setParent(parent).build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Cluster` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Cluster element : vmwareEngineClient.listClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(ListClustersRequest request) {
    return listClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Cluster` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Cluster> future =
   *       vmwareEngineClient.listClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Cluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListClustersRequest, ListClustersPagedResponse>
      listClustersPagedCallable() {
    return stub.listClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Cluster` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListClustersResponse response = vmwareEngineClient.listClustersCallable().call(request);
   *     for (Cluster element : response.getClustersList()) {
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
  public final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return stub.listClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Cluster` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");
   *   Cluster response = vmwareEngineClient.getCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The cluster resource name to retrieve. Resource names are schemeless URIs
   *     that follow the conventions in https://cloud.google.com/apis/design/resource_names. For
   *     example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(ClusterName name) {
    GetClusterRequest request =
        GetClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Cluster` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]").toString();
   *   Cluster response = vmwareEngineClient.getCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The cluster resource name to retrieve. Resource names are schemeless URIs
   *     that follow the conventions in https://cloud.google.com/apis/design/resource_names. For
   *     example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(String name) {
    GetClusterRequest request = GetClusterRequest.newBuilder().setName(name).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Cluster` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setName(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .build();
   *   Cluster response = vmwareEngineClient.getCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(GetClusterRequest request) {
    return getClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Cluster` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setName(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Cluster> future = vmwareEngineClient.getClusterCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return stub.getClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given private cloud. Creating a new cluster provides additional
   * nodes for use in the parent private cloud and requires sufficient [node
   * quota](https://cloud.google.com/vmware-engine/quotas).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   Cluster cluster = Cluster.newBuilder().build();
   *   String clusterId = "clusterId561939637";
   *   Cluster response = vmwareEngineClient.createClusterAsync(parent, cluster, clusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create a new cluster in.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @param cluster Required. The initial description of the new cluster.
   * @param clusterId Required. The user-provided identifier of the new `Cluster`. This identifier
   *     must be unique among clusters within the parent and becomes the final token in the name
   *     URI. The identifier must meet the following requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> createClusterAsync(
      PrivateCloudName parent, Cluster cluster, String clusterId) {
    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCluster(cluster)
            .setClusterId(clusterId)
            .build();
    return createClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given private cloud. Creating a new cluster provides additional
   * nodes for use in the parent private cloud and requires sufficient [node
   * quota](https://cloud.google.com/vmware-engine/quotas).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   Cluster cluster = Cluster.newBuilder().build();
   *   String clusterId = "clusterId561939637";
   *   Cluster response = vmwareEngineClient.createClusterAsync(parent, cluster, clusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create a new cluster in.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @param cluster Required. The initial description of the new cluster.
   * @param clusterId Required. The user-provided identifier of the new `Cluster`. This identifier
   *     must be unique among clusters within the parent and becomes the final token in the name
   *     URI. The identifier must meet the following requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> createClusterAsync(
      String parent, Cluster cluster, String clusterId) {
    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setParent(parent)
            .setCluster(cluster)
            .setClusterId(clusterId)
            .build();
    return createClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given private cloud. Creating a new cluster provides additional
   * nodes for use in the parent private cloud and requires sufficient [node
   * quota](https://cloud.google.com/vmware-engine/quotas).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Cluster response = vmwareEngineClient.createClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> createClusterAsync(
      CreateClusterRequest request) {
    return createClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given private cloud. Creating a new cluster provides additional
   * nodes for use in the parent private cloud and requires sufficient [node
   * quota](https://cloud.google.com/vmware-engine/quotas).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Cluster, OperationMetadata> future =
   *       vmwareEngineClient.createClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationCallable() {
    return stub.createClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given private cloud. Creating a new cluster provides additional
   * nodes for use in the parent private cloud and requires sufficient [node
   * quota](https://cloud.google.com/vmware-engine/quotas).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = vmwareEngineClient.createClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return stub.createClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `Cluster` resource. Only the following fields can be updated:
   * `node_type_configs.&#42;.node_count`. Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   Cluster cluster = Cluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Cluster response = vmwareEngineClient.updateClusterAsync(cluster, updateMask).get();
   * }
   * }</pre>
   *
   * @param cluster Required. The description of the cluster.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `Cluster` resource by the update. The fields specified in the `updateMask` are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> updateClusterAsync(
      Cluster cluster, FieldMask updateMask) {
    UpdateClusterRequest request =
        UpdateClusterRequest.newBuilder().setCluster(cluster).setUpdateMask(updateMask).build();
    return updateClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `Cluster` resource. Only the following fields can be updated:
   * `node_type_configs.&#42;.node_count`. Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Cluster response = vmwareEngineClient.updateClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> updateClusterAsync(
      UpdateClusterRequest request) {
    return updateClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `Cluster` resource. Only the following fields can be updated:
   * `node_type_configs.&#42;.node_count`. Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Cluster, OperationMetadata> future =
   *       vmwareEngineClient.updateClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationCallable() {
    return stub.updateClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `Cluster` resource. Only the following fields can be updated:
   * `node_type_configs.&#42;.node_count`. Only fields specified in `updateMask` are applied.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = vmwareEngineClient.updateClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return stub.updateClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or gracefully shut down
   * any workloads running on the cluster before deletion. You cannot delete the management cluster
   * of a private cloud using this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]");
   *   vmwareEngineClient.deleteClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the cluster to delete. Resource names are schemeless
   *     URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names.
   *     For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClusterAsync(ClusterName name) {
    DeleteClusterRequest request =
        DeleteClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or gracefully shut down
   * any workloads running on the cluster before deletion. You cannot delete the management cluster
   * of a private cloud using this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]").toString();
   *   vmwareEngineClient.deleteClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the cluster to delete. Resource names are schemeless
   *     URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names.
   *     For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClusterAsync(String name) {
    DeleteClusterRequest request = DeleteClusterRequest.newBuilder().setName(name).build();
    return deleteClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or gracefully shut down
   * any workloads running on the cluster before deletion. You cannot delete the management cluster
   * of a private cloud using this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmwareEngineClient.deleteClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClusterAsync(
      DeleteClusterRequest request) {
    return deleteClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or gracefully shut down
   * any workloads running on the cluster before deletion. You cannot delete the management cluster
   * of a private cloud using this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmwareEngineClient.deleteClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable() {
    return stub.deleteClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Cluster` resource. To avoid unintended data loss, migrate or gracefully shut down
   * any workloads running on the cluster before deletion. You cannot delete the management cluster
   * of a private cloud using this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmwareEngineClient.deleteClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return stub.deleteClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnets in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   for (Subnet element : vmwareEngineClient.listSubnets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for subnets.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubnetsPagedResponse listSubnets(PrivateCloudName parent) {
    ListSubnetsRequest request =
        ListSubnetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSubnets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnets in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   for (Subnet element : vmwareEngineClient.listSubnets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for subnets.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubnetsPagedResponse listSubnets(String parent) {
    ListSubnetsRequest request = ListSubnetsRequest.newBuilder().setParent(parent).build();
    return listSubnets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnets in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListSubnetsRequest request =
   *       ListSubnetsRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Subnet element : vmwareEngineClient.listSubnets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubnetsPagedResponse listSubnets(ListSubnetsRequest request) {
    return listSubnetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnets in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListSubnetsRequest request =
   *       ListSubnetsRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Subnet> future = vmwareEngineClient.listSubnetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Subnet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse>
      listSubnetsPagedCallable() {
    return stub.listSubnetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists subnets in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListSubnetsRequest request =
   *       ListSubnetsRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSubnetsResponse response = vmwareEngineClient.listSubnetsCallable().call(request);
   *     for (Subnet element : response.getSubnetsList()) {
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
  public final UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable() {
    return stub.listSubnetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists node types
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (NodeType element : vmwareEngineClient.listNodeTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to be queried for node types.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodeTypesPagedResponse listNodeTypes(LocationName parent) {
    ListNodeTypesRequest request =
        ListNodeTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNodeTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists node types
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (NodeType element : vmwareEngineClient.listNodeTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to be queried for node types.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodeTypesPagedResponse listNodeTypes(String parent) {
    ListNodeTypesRequest request = ListNodeTypesRequest.newBuilder().setParent(parent).build();
    return listNodeTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists node types
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNodeTypesRequest request =
   *       ListNodeTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (NodeType element : vmwareEngineClient.listNodeTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNodeTypesPagedResponse listNodeTypes(ListNodeTypesRequest request) {
    return listNodeTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists node types
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNodeTypesRequest request =
   *       ListNodeTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<NodeType> future =
   *       vmwareEngineClient.listNodeTypesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NodeType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNodeTypesRequest, ListNodeTypesPagedResponse>
      listNodeTypesPagedCallable() {
    return stub.listNodeTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists node types
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNodeTypesRequest request =
   *       ListNodeTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListNodeTypesResponse response = vmwareEngineClient.listNodeTypesCallable().call(request);
   *     for (NodeType element : response.getNodeTypesList()) {
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
  public final UnaryCallable<ListNodeTypesRequest, ListNodeTypesResponse> listNodeTypesCallable() {
    return stub.listNodeTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single `NodeType`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NodeTypeName name = NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]");
   *   NodeType response = vmwareEngineClient.getNodeType(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the node type to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-proj/locations/us-central1-a/nodeTypes/standard-72`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodeType getNodeType(NodeTypeName name) {
    GetNodeTypeRequest request =
        GetNodeTypeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNodeType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single `NodeType`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]").toString();
   *   NodeType response = vmwareEngineClient.getNodeType(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the node type to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-proj/locations/us-central1-a/nodeTypes/standard-72`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodeType getNodeType(String name) {
    GetNodeTypeRequest request = GetNodeTypeRequest.newBuilder().setName(name).build();
    return getNodeType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single `NodeType`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetNodeTypeRequest request =
   *       GetNodeTypeRequest.newBuilder()
   *           .setName(NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]").toString())
   *           .build();
   *   NodeType response = vmwareEngineClient.getNodeType(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodeType getNodeType(GetNodeTypeRequest request) {
    return getNodeTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single `NodeType`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetNodeTypeRequest request =
   *       GetNodeTypeRequest.newBuilder()
   *           .setName(NodeTypeName.of("[PROJECT]", "[LOCATION]", "[NODE_TYPE]").toString())
   *           .build();
   *   ApiFuture<NodeType> future = vmwareEngineClient.getNodeTypeCallable().futureCall(request);
   *   // Do something.
   *   NodeType response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNodeTypeRequest, NodeType> getNodeTypeCallable() {
    return stub.getNodeTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   Credentials response = vmwareEngineClient.showNsxCredentials(privateCloud);
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to be queried for
   *     credentials. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Credentials showNsxCredentials(PrivateCloudName privateCloud) {
    ShowNsxCredentialsRequest request =
        ShowNsxCredentialsRequest.newBuilder()
            .setPrivateCloud(privateCloud == null ? null : privateCloud.toString())
            .build();
    return showNsxCredentials(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   Credentials response = vmwareEngineClient.showNsxCredentials(privateCloud);
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to be queried for
   *     credentials. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Credentials showNsxCredentials(String privateCloud) {
    ShowNsxCredentialsRequest request =
        ShowNsxCredentialsRequest.newBuilder().setPrivateCloud(privateCloud).build();
    return showNsxCredentials(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ShowNsxCredentialsRequest request =
   *       ShowNsxCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .build();
   *   Credentials response = vmwareEngineClient.showNsxCredentials(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Credentials showNsxCredentials(ShowNsxCredentialsRequest request) {
    return showNsxCredentialsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ShowNsxCredentialsRequest request =
   *       ShowNsxCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .build();
   *   ApiFuture<Credentials> future =
   *       vmwareEngineClient.showNsxCredentialsCallable().futureCall(request);
   *   // Do something.
   *   Credentials response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ShowNsxCredentialsRequest, Credentials> showNsxCredentialsCallable() {
    return stub.showNsxCredentialsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   Credentials response = vmwareEngineClient.showVcenterCredentials(privateCloud);
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to be queried for
   *     credentials. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Credentials showVcenterCredentials(PrivateCloudName privateCloud) {
    ShowVcenterCredentialsRequest request =
        ShowVcenterCredentialsRequest.newBuilder()
            .setPrivateCloud(privateCloud == null ? null : privateCloud.toString())
            .build();
    return showVcenterCredentials(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   Credentials response = vmwareEngineClient.showVcenterCredentials(privateCloud);
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to be queried for
   *     credentials. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Credentials showVcenterCredentials(String privateCloud) {
    ShowVcenterCredentialsRequest request =
        ShowVcenterCredentialsRequest.newBuilder().setPrivateCloud(privateCloud).build();
    return showVcenterCredentials(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ShowVcenterCredentialsRequest request =
   *       ShowVcenterCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .build();
   *   Credentials response = vmwareEngineClient.showVcenterCredentials(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Credentials showVcenterCredentials(ShowVcenterCredentialsRequest request) {
    return showVcenterCredentialsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of credentials for Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ShowVcenterCredentialsRequest request =
   *       ShowVcenterCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .build();
   *   ApiFuture<Credentials> future =
   *       vmwareEngineClient.showVcenterCredentialsCallable().futureCall(request);
   *   // Do something.
   *   Credentials response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ShowVcenterCredentialsRequest, Credentials>
      showVcenterCredentialsCallable() {
    return stub.showVcenterCredentialsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   PrivateCloud response = vmwareEngineClient.resetNsxCredentialsAsync(privateCloud).get();
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to reset credentials for.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> resetNsxCredentialsAsync(
      PrivateCloudName privateCloud) {
    ResetNsxCredentialsRequest request =
        ResetNsxCredentialsRequest.newBuilder()
            .setPrivateCloud(privateCloud == null ? null : privateCloud.toString())
            .build();
    return resetNsxCredentialsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   PrivateCloud response = vmwareEngineClient.resetNsxCredentialsAsync(privateCloud).get();
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to reset credentials for.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> resetNsxCredentialsAsync(
      String privateCloud) {
    ResetNsxCredentialsRequest request =
        ResetNsxCredentialsRequest.newBuilder().setPrivateCloud(privateCloud).build();
    return resetNsxCredentialsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ResetNsxCredentialsRequest request =
   *       ResetNsxCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.resetNsxCredentialsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> resetNsxCredentialsAsync(
      ResetNsxCredentialsRequest request) {
    return resetNsxCredentialsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ResetNsxCredentialsRequest request =
   *       ResetNsxCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PrivateCloud, OperationMetadata> future =
   *       vmwareEngineClient.resetNsxCredentialsOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResetNsxCredentialsRequest, PrivateCloud, OperationMetadata>
      resetNsxCredentialsOperationCallable() {
    return stub.resetNsxCredentialsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the NSX appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ResetNsxCredentialsRequest request =
   *       ResetNsxCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.resetNsxCredentialsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResetNsxCredentialsRequest, Operation> resetNsxCredentialsCallable() {
    return stub.resetNsxCredentialsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   PrivateCloud response = vmwareEngineClient.resetVcenterCredentialsAsync(privateCloud).get();
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to reset credentials for.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> resetVcenterCredentialsAsync(
      PrivateCloudName privateCloud) {
    ResetVcenterCredentialsRequest request =
        ResetVcenterCredentialsRequest.newBuilder()
            .setPrivateCloud(privateCloud == null ? null : privateCloud.toString())
            .build();
    return resetVcenterCredentialsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String privateCloud =
   *       PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   PrivateCloud response = vmwareEngineClient.resetVcenterCredentialsAsync(privateCloud).get();
   * }
   * }</pre>
   *
   * @param privateCloud Required. The resource name of the private cloud to reset credentials for.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> resetVcenterCredentialsAsync(
      String privateCloud) {
    ResetVcenterCredentialsRequest request =
        ResetVcenterCredentialsRequest.newBuilder().setPrivateCloud(privateCloud).build();
    return resetVcenterCredentialsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ResetVcenterCredentialsRequest request =
   *       ResetVcenterCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   PrivateCloud response = vmwareEngineClient.resetVcenterCredentialsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PrivateCloud, OperationMetadata> resetVcenterCredentialsAsync(
      ResetVcenterCredentialsRequest request) {
    return resetVcenterCredentialsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ResetVcenterCredentialsRequest request =
   *       ResetVcenterCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<PrivateCloud, OperationMetadata> future =
   *       vmwareEngineClient.resetVcenterCredentialsOperationCallable().futureCall(request);
   *   // Do something.
   *   PrivateCloud response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResetVcenterCredentialsRequest, PrivateCloud, OperationMetadata>
      resetVcenterCredentialsOperationCallable() {
    return stub.resetVcenterCredentialsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets credentials of the Vcenter appliance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ResetVcenterCredentialsRequest request =
   *       ResetVcenterCredentialsRequest.newBuilder()
   *           .setPrivateCloud(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.resetVcenterCredentialsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResetVcenterCredentialsRequest, Operation>
      resetVcenterCredentialsCallable() {
    return stub.resetVcenterCredentialsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HCX activation key in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   HcxActivationKey hcxActivationKey = HcxActivationKey.newBuilder().build();
   *   String hcxActivationKeyId = "hcxActivationKeyId-645871673";
   *   HcxActivationKey response =
   *       vmwareEngineClient
   *           .createHcxActivationKeyAsync(parent, hcxActivationKey, hcxActivationKeyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create the key for. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateClouds/my-cloud`
   * @param hcxActivationKey Required. The initial description of a new HCX activation key. When
   *     creating a new key, this field must be an empty object.
   * @param hcxActivationKeyId Required. The user-provided identifier of the `HcxActivationKey` to
   *     be created. This identifier must be unique among `HcxActivationKey` resources within the
   *     parent and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HcxActivationKey, OperationMetadata> createHcxActivationKeyAsync(
      PrivateCloudName parent, HcxActivationKey hcxActivationKey, String hcxActivationKeyId) {
    CreateHcxActivationKeyRequest request =
        CreateHcxActivationKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setHcxActivationKey(hcxActivationKey)
            .setHcxActivationKeyId(hcxActivationKeyId)
            .build();
    return createHcxActivationKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HCX activation key in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   HcxActivationKey hcxActivationKey = HcxActivationKey.newBuilder().build();
   *   String hcxActivationKeyId = "hcxActivationKeyId-645871673";
   *   HcxActivationKey response =
   *       vmwareEngineClient
   *           .createHcxActivationKeyAsync(parent, hcxActivationKey, hcxActivationKeyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to create the key for. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateClouds/my-cloud`
   * @param hcxActivationKey Required. The initial description of a new HCX activation key. When
   *     creating a new key, this field must be an empty object.
   * @param hcxActivationKeyId Required. The user-provided identifier of the `HcxActivationKey` to
   *     be created. This identifier must be unique among `HcxActivationKey` resources within the
   *     parent and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HcxActivationKey, OperationMetadata> createHcxActivationKeyAsync(
      String parent, HcxActivationKey hcxActivationKey, String hcxActivationKeyId) {
    CreateHcxActivationKeyRequest request =
        CreateHcxActivationKeyRequest.newBuilder()
            .setParent(parent)
            .setHcxActivationKey(hcxActivationKey)
            .setHcxActivationKeyId(hcxActivationKeyId)
            .build();
    return createHcxActivationKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HCX activation key in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateHcxActivationKeyRequest request =
   *       CreateHcxActivationKeyRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setHcxActivationKey(HcxActivationKey.newBuilder().build())
   *           .setHcxActivationKeyId("hcxActivationKeyId-645871673")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   HcxActivationKey response = vmwareEngineClient.createHcxActivationKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HcxActivationKey, OperationMetadata> createHcxActivationKeyAsync(
      CreateHcxActivationKeyRequest request) {
    return createHcxActivationKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HCX activation key in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateHcxActivationKeyRequest request =
   *       CreateHcxActivationKeyRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setHcxActivationKey(HcxActivationKey.newBuilder().build())
   *           .setHcxActivationKeyId("hcxActivationKeyId-645871673")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<HcxActivationKey, OperationMetadata> future =
   *       vmwareEngineClient.createHcxActivationKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   HcxActivationKey response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateHcxActivationKeyRequest, HcxActivationKey, OperationMetadata>
      createHcxActivationKeyOperationCallable() {
    return stub.createHcxActivationKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HCX activation key in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateHcxActivationKeyRequest request =
   *       CreateHcxActivationKeyRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setHcxActivationKey(HcxActivationKey.newBuilder().build())
   *           .setHcxActivationKeyId("hcxActivationKeyId-645871673")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createHcxActivationKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateHcxActivationKeyRequest, Operation>
      createHcxActivationKeyCallable() {
    return stub.createHcxActivationKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `HcxActivationKey` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   PrivateCloudName parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]");
   *   for (HcxActivationKey element :
   *       vmwareEngineClient.listHcxActivationKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for HCX activation
   *     keys. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHcxActivationKeysPagedResponse listHcxActivationKeys(PrivateCloudName parent) {
    ListHcxActivationKeysRequest request =
        ListHcxActivationKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listHcxActivationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `HcxActivationKey` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString();
   *   for (HcxActivationKey element :
   *       vmwareEngineClient.listHcxActivationKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the private cloud to be queried for HCX activation
   *     keys. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateClouds/my-cloud`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHcxActivationKeysPagedResponse listHcxActivationKeys(String parent) {
    ListHcxActivationKeysRequest request =
        ListHcxActivationKeysRequest.newBuilder().setParent(parent).build();
    return listHcxActivationKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `HcxActivationKey` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListHcxActivationKeysRequest request =
   *       ListHcxActivationKeysRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (HcxActivationKey element :
   *       vmwareEngineClient.listHcxActivationKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHcxActivationKeysPagedResponse listHcxActivationKeys(
      ListHcxActivationKeysRequest request) {
    return listHcxActivationKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `HcxActivationKey` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListHcxActivationKeysRequest request =
   *       ListHcxActivationKeysRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<HcxActivationKey> future =
   *       vmwareEngineClient.listHcxActivationKeysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HcxActivationKey element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysPagedResponse>
      listHcxActivationKeysPagedCallable() {
    return stub.listHcxActivationKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `HcxActivationKey` resources in a given private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListHcxActivationKeysRequest request =
   *       ListHcxActivationKeysRequest.newBuilder()
   *           .setParent(
   *               PrivateCloudName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListHcxActivationKeysResponse response =
   *         vmwareEngineClient.listHcxActivationKeysCallable().call(request);
   *     for (HcxActivationKey element : response.getHcxActivationKeysList()) {
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
  public final UnaryCallable<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse>
      listHcxActivationKeysCallable() {
    return stub.listHcxActivationKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `HcxActivationKey` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   HcxActivationKeyName name =
   *       HcxActivationKeyName.of(
   *           "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]");
   *   HcxActivationKey response = vmwareEngineClient.getHcxActivationKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the HCX activation key to retrieve. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateClouds/my-cloud/hcxActivationKeys/my-key`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HcxActivationKey getHcxActivationKey(HcxActivationKeyName name) {
    GetHcxActivationKeyRequest request =
        GetHcxActivationKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getHcxActivationKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `HcxActivationKey` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       HcxActivationKeyName.of(
   *               "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
   *           .toString();
   *   HcxActivationKey response = vmwareEngineClient.getHcxActivationKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the HCX activation key to retrieve. Resource names
   *     are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/privateClouds/my-cloud/hcxActivationKeys/my-key`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HcxActivationKey getHcxActivationKey(String name) {
    GetHcxActivationKeyRequest request =
        GetHcxActivationKeyRequest.newBuilder().setName(name).build();
    return getHcxActivationKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `HcxActivationKey` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetHcxActivationKeyRequest request =
   *       GetHcxActivationKeyRequest.newBuilder()
   *           .setName(
   *               HcxActivationKeyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
   *                   .toString())
   *           .build();
   *   HcxActivationKey response = vmwareEngineClient.getHcxActivationKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HcxActivationKey getHcxActivationKey(GetHcxActivationKeyRequest request) {
    return getHcxActivationKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `HcxActivationKey` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetHcxActivationKeyRequest request =
   *       GetHcxActivationKeyRequest.newBuilder()
   *           .setName(
   *               HcxActivationKeyName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[HCX_ACTIVATION_KEY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<HcxActivationKey> future =
   *       vmwareEngineClient.getHcxActivationKeyCallable().futureCall(request);
   *   // Do something.
   *   HcxActivationKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHcxActivationKeyRequest, HcxActivationKey>
      getHcxActivationKeyCallable() {
    return stub.getHcxActivationKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NetworkPolicy` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NetworkPolicyName name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
   *   NetworkPolicy response = vmwareEngineClient.getNetworkPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the network policy to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-network-policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkPolicy getNetworkPolicy(NetworkPolicyName name) {
    GetNetworkPolicyRequest request =
        GetNetworkPolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNetworkPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NetworkPolicy` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString();
   *   NetworkPolicy response = vmwareEngineClient.getNetworkPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the network policy to retrieve. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-network-policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkPolicy getNetworkPolicy(String name) {
    GetNetworkPolicyRequest request = GetNetworkPolicyRequest.newBuilder().setName(name).build();
    return getNetworkPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NetworkPolicy` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetNetworkPolicyRequest request =
   *       GetNetworkPolicyRequest.newBuilder()
   *           .setName(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .build();
   *   NetworkPolicy response = vmwareEngineClient.getNetworkPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NetworkPolicy getNetworkPolicy(GetNetworkPolicyRequest request) {
    return getNetworkPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `NetworkPolicy` resource by its resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetNetworkPolicyRequest request =
   *       GetNetworkPolicyRequest.newBuilder()
   *           .setName(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .build();
   *   ApiFuture<NetworkPolicy> future =
   *       vmwareEngineClient.getNetworkPolicyCallable().futureCall(request);
   *   // Do something.
   *   NetworkPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNetworkPolicyRequest, NetworkPolicy> getNetworkPolicyCallable() {
    return stub.getNetworkPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPolicy` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (NetworkPolicy element : vmwareEngineClient.listNetworkPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location (region) to query for network
   *     policies. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkPoliciesPagedResponse listNetworkPolicies(LocationName parent) {
    ListNetworkPoliciesRequest request =
        ListNetworkPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNetworkPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPolicy` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (NetworkPolicy element : vmwareEngineClient.listNetworkPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location (region) to query for network
   *     policies. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkPoliciesPagedResponse listNetworkPolicies(String parent) {
    ListNetworkPoliciesRequest request =
        ListNetworkPoliciesRequest.newBuilder().setParent(parent).build();
    return listNetworkPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPolicy` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNetworkPoliciesRequest request =
   *       ListNetworkPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (NetworkPolicy element : vmwareEngineClient.listNetworkPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkPoliciesPagedResponse listNetworkPolicies(
      ListNetworkPoliciesRequest request) {
    return listNetworkPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPolicy` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNetworkPoliciesRequest request =
   *       ListNetworkPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<NetworkPolicy> future =
   *       vmwareEngineClient.listNetworkPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NetworkPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesPagedResponse>
      listNetworkPoliciesPagedCallable() {
    return stub.listNetworkPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `NetworkPolicy` resources in a specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListNetworkPoliciesRequest request =
   *       ListNetworkPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListNetworkPoliciesResponse response =
   *         vmwareEngineClient.listNetworkPoliciesCallable().call(request);
   *     for (NetworkPolicy element : response.getNetworkPoliciesList()) {
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
  public final UnaryCallable<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse>
      listNetworkPoliciesCallable() {
    return stub.listNetworkPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network policy in a given VMware Engine network of a project and location
   * (region). A new network policy cannot be created if another network policy already exists in
   * the same scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
   *   String networkPolicyId = "networkPolicyId-727262661";
   *   NetworkPolicy response =
   *       vmwareEngineClient.createNetworkPolicyAsync(parent, networkPolicy, networkPolicyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location (region) to create the new network
   *     policy in. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1`
   * @param networkPolicy Required. The network policy configuration to use in the request.
   * @param networkPolicyId Required. The user-provided identifier of the network policy to be
   *     created. This identifier must be unique within parent
   *     `projects/{my-project}/locations/{us-central1}/networkPolicies` and becomes the final token
   *     in the name URI. The identifier must meet the following requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPolicy, OperationMetadata> createNetworkPolicyAsync(
      LocationName parent, NetworkPolicy networkPolicy, String networkPolicyId) {
    CreateNetworkPolicyRequest request =
        CreateNetworkPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNetworkPolicy(networkPolicy)
            .setNetworkPolicyId(networkPolicyId)
            .build();
    return createNetworkPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network policy in a given VMware Engine network of a project and location
   * (region). A new network policy cannot be created if another network policy already exists in
   * the same scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
   *   String networkPolicyId = "networkPolicyId-727262661";
   *   NetworkPolicy response =
   *       vmwareEngineClient.createNetworkPolicyAsync(parent, networkPolicy, networkPolicyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location (region) to create the new network
   *     policy in. Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1`
   * @param networkPolicy Required. The network policy configuration to use in the request.
   * @param networkPolicyId Required. The user-provided identifier of the network policy to be
   *     created. This identifier must be unique within parent
   *     `projects/{my-project}/locations/{us-central1}/networkPolicies` and becomes the final token
   *     in the name URI. The identifier must meet the following requirements:
   *     <ul>
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPolicy, OperationMetadata> createNetworkPolicyAsync(
      String parent, NetworkPolicy networkPolicy, String networkPolicyId) {
    CreateNetworkPolicyRequest request =
        CreateNetworkPolicyRequest.newBuilder()
            .setParent(parent)
            .setNetworkPolicy(networkPolicy)
            .setNetworkPolicyId(networkPolicyId)
            .build();
    return createNetworkPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network policy in a given VMware Engine network of a project and location
   * (region). A new network policy cannot be created if another network policy already exists in
   * the same scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateNetworkPolicyRequest request =
   *       CreateNetworkPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNetworkPolicyId("networkPolicyId-727262661")
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   NetworkPolicy response = vmwareEngineClient.createNetworkPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPolicy, OperationMetadata> createNetworkPolicyAsync(
      CreateNetworkPolicyRequest request) {
    return createNetworkPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network policy in a given VMware Engine network of a project and location
   * (region). A new network policy cannot be created if another network policy already exists in
   * the same scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateNetworkPolicyRequest request =
   *       CreateNetworkPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNetworkPolicyId("networkPolicyId-727262661")
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<NetworkPolicy, OperationMetadata> future =
   *       vmwareEngineClient.createNetworkPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   NetworkPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      createNetworkPolicyOperationCallable() {
    return stub.createNetworkPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new network policy in a given VMware Engine network of a project and location
   * (region). A new network policy cannot be created if another network policy already exists in
   * the same scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateNetworkPolicyRequest request =
   *       CreateNetworkPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNetworkPolicyId("networkPolicyId-727262661")
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createNetworkPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNetworkPolicyRequest, Operation> createNetworkPolicyCallable() {
    return stub.createNetworkPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `NetworkPolicy` resource. Only the following fields can be updated:
   * `internet_access`, `external_ip`, `edge_services_cidr`. Only fields specified in `updateMask`
   * are applied. When updating a network policy, the external IP network service can only be
   * disabled if there are no external IP addresses present in the scope of the policy. Also, a
   * `NetworkService` cannot be updated when `NetworkService.state` is set to `RECONCILING`.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NetworkPolicy networkPolicy = NetworkPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   NetworkPolicy response =
   *       vmwareEngineClient.updateNetworkPolicyAsync(networkPolicy, updateMask).get();
   * }
   * }</pre>
   *
   * @param networkPolicy Required. Network policy description.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     `NetworkPolicy` resource by the update. The fields specified in the `update_mask` are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPolicy, OperationMetadata> updateNetworkPolicyAsync(
      NetworkPolicy networkPolicy, FieldMask updateMask) {
    UpdateNetworkPolicyRequest request =
        UpdateNetworkPolicyRequest.newBuilder()
            .setNetworkPolicy(networkPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateNetworkPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `NetworkPolicy` resource. Only the following fields can be updated:
   * `internet_access`, `external_ip`, `edge_services_cidr`. Only fields specified in `updateMask`
   * are applied. When updating a network policy, the external IP network service can only be
   * disabled if there are no external IP addresses present in the scope of the policy. Also, a
   * `NetworkService` cannot be updated when `NetworkService.state` is set to `RECONCILING`.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateNetworkPolicyRequest request =
   *       UpdateNetworkPolicyRequest.newBuilder()
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   NetworkPolicy response = vmwareEngineClient.updateNetworkPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NetworkPolicy, OperationMetadata> updateNetworkPolicyAsync(
      UpdateNetworkPolicyRequest request) {
    return updateNetworkPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `NetworkPolicy` resource. Only the following fields can be updated:
   * `internet_access`, `external_ip`, `edge_services_cidr`. Only fields specified in `updateMask`
   * are applied. When updating a network policy, the external IP network service can only be
   * disabled if there are no external IP addresses present in the scope of the policy. Also, a
   * `NetworkService` cannot be updated when `NetworkService.state` is set to `RECONCILING`.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateNetworkPolicyRequest request =
   *       UpdateNetworkPolicyRequest.newBuilder()
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<NetworkPolicy, OperationMetadata> future =
   *       vmwareEngineClient.updateNetworkPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   NetworkPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateNetworkPolicyRequest, NetworkPolicy, OperationMetadata>
      updateNetworkPolicyOperationCallable() {
    return stub.updateNetworkPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a `NetworkPolicy` resource. Only the following fields can be updated:
   * `internet_access`, `external_ip`, `edge_services_cidr`. Only fields specified in `updateMask`
   * are applied. When updating a network policy, the external IP network service can only be
   * disabled if there are no external IP addresses present in the scope of the policy. Also, a
   * `NetworkService` cannot be updated when `NetworkService.state` is set to `RECONCILING`.
   *
   * <p>During operation processing, the resource is temporarily in the `ACTIVE` state before the
   * operation fully completes. For that period of time, you can't update the resource. Use the
   * operation status to determine when the processing fully completes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateNetworkPolicyRequest request =
   *       UpdateNetworkPolicyRequest.newBuilder()
   *           .setNetworkPolicy(NetworkPolicy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.updateNetworkPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNetworkPolicyRequest, Operation> updateNetworkPolicyCallable() {
    return stub.updateNetworkPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted when
   * `NetworkService.state` is set to `RECONCILING` for either its external IP or internet access
   * service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   NetworkPolicyName name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]");
   *   vmwareEngineClient.deleteNetworkPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the network policy to delete. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-network-policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNetworkPolicyAsync(
      NetworkPolicyName name) {
    DeleteNetworkPolicyRequest request =
        DeleteNetworkPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteNetworkPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted when
   * `NetworkService.state` is set to `RECONCILING` for either its external IP or internet access
   * service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name = NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString();
   *   vmwareEngineClient.deleteNetworkPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the network policy to delete. Resource names are
   *     schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/us-central1/networkPolicies/my-network-policy`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNetworkPolicyAsync(String name) {
    DeleteNetworkPolicyRequest request =
        DeleteNetworkPolicyRequest.newBuilder().setName(name).build();
    return deleteNetworkPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted when
   * `NetworkService.state` is set to `RECONCILING` for either its external IP or internet access
   * service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteNetworkPolicyRequest request =
   *       DeleteNetworkPolicyRequest.newBuilder()
   *           .setName(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmwareEngineClient.deleteNetworkPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNetworkPolicyAsync(
      DeleteNetworkPolicyRequest request) {
    return deleteNetworkPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted when
   * `NetworkService.state` is set to `RECONCILING` for either its external IP or internet access
   * service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteNetworkPolicyRequest request =
   *       DeleteNetworkPolicyRequest.newBuilder()
   *           .setName(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmwareEngineClient.deleteNetworkPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteNetworkPolicyRequest, Empty, OperationMetadata>
      deleteNetworkPolicyOperationCallable() {
    return stub.deleteNetworkPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `NetworkPolicy` resource. A network policy cannot be deleted when
   * `NetworkService.state` is set to `RECONCILING` for either its external IP or internet access
   * service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteNetworkPolicyRequest request =
   *       DeleteNetworkPolicyRequest.newBuilder()
   *           .setName(
   *               NetworkPolicyName.of("[PROJECT]", "[LOCATION]", "[NETWORK_POLICY]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.deleteNetworkPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNetworkPolicyRequest, Operation> deleteNetworkPolicyCallable() {
    return stub.deleteNetworkPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VMware Engine network that can be used by a private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
   *   String vmwareEngineNetworkId = "vmwareEngineNetworkId532532083";
   *   VmwareEngineNetwork response =
   *       vmwareEngineClient
   *           .createVmwareEngineNetworkAsync(parent, vmwareEngineNetwork, vmwareEngineNetworkId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create the new VMware Engine
   *     network in. A VMware Engine network of type `LEGACY` is a regional resource, and a VMware
   *     Engine network of type `STANDARD` is a global resource. Resource names are schemeless URIs
   *     that follow the conventions in https://cloud.google.com/apis/design/resource_names. For
   *     example: `projects/my-project/locations/global`
   * @param vmwareEngineNetwork Required. The initial description of the new VMware Engine network.
   * @param vmwareEngineNetworkId Required. The user-provided identifier of the new VMware Engine
   *     network. This identifier must be unique among VMware Engine network resources within the
   *     parent and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>For networks of type LEGACY, adheres to the format: `{region-id}-default`. Replace
   *           `{region-id}` with the region where you want to create the VMware Engine network. For
   *           example, "us-central1-default".
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkAsync(
          LocationName parent,
          VmwareEngineNetwork vmwareEngineNetwork,
          String vmwareEngineNetworkId) {
    CreateVmwareEngineNetworkRequest request =
        CreateVmwareEngineNetworkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setVmwareEngineNetwork(vmwareEngineNetwork)
            .setVmwareEngineNetworkId(vmwareEngineNetworkId)
            .build();
    return createVmwareEngineNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VMware Engine network that can be used by a private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
   *   String vmwareEngineNetworkId = "vmwareEngineNetworkId532532083";
   *   VmwareEngineNetwork response =
   *       vmwareEngineClient
   *           .createVmwareEngineNetworkAsync(parent, vmwareEngineNetwork, vmwareEngineNetworkId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create the new VMware Engine
   *     network in. A VMware Engine network of type `LEGACY` is a regional resource, and a VMware
   *     Engine network of type `STANDARD` is a global resource. Resource names are schemeless URIs
   *     that follow the conventions in https://cloud.google.com/apis/design/resource_names. For
   *     example: `projects/my-project/locations/global`
   * @param vmwareEngineNetwork Required. The initial description of the new VMware Engine network.
   * @param vmwareEngineNetworkId Required. The user-provided identifier of the new VMware Engine
   *     network. This identifier must be unique among VMware Engine network resources within the
   *     parent and becomes the final token in the name URI. The identifier must meet the following
   *     requirements:
   *     <ul>
   *       <li>For networks of type LEGACY, adheres to the format: `{region-id}-default`. Replace
   *           `{region-id}` with the region where you want to create the VMware Engine network. For
   *           example, "us-central1-default".
   *       <li>Only contains 1-63 alphanumeric characters and hyphens
   *       <li>Begins with an alphabetical character
   *       <li>Ends with a non-hyphen character
   *       <li>Not formatted as a UUID
   *       <li>Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkAsync(
          String parent, VmwareEngineNetwork vmwareEngineNetwork, String vmwareEngineNetworkId) {
    CreateVmwareEngineNetworkRequest request =
        CreateVmwareEngineNetworkRequest.newBuilder()
            .setParent(parent)
            .setVmwareEngineNetwork(vmwareEngineNetwork)
            .setVmwareEngineNetworkId(vmwareEngineNetworkId)
            .build();
    return createVmwareEngineNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VMware Engine network that can be used by a private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateVmwareEngineNetworkRequest request =
   *       CreateVmwareEngineNetworkRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVmwareEngineNetworkId("vmwareEngineNetworkId532532083")
   *           .setVmwareEngineNetwork(VmwareEngineNetwork.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   VmwareEngineNetwork response =
   *       vmwareEngineClient.createVmwareEngineNetworkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkAsync(CreateVmwareEngineNetworkRequest request) {
    return createVmwareEngineNetworkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VMware Engine network that can be used by a private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateVmwareEngineNetworkRequest request =
   *       CreateVmwareEngineNetworkRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVmwareEngineNetworkId("vmwareEngineNetworkId532532083")
   *           .setVmwareEngineNetwork(VmwareEngineNetwork.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<VmwareEngineNetwork, OperationMetadata> future =
   *       vmwareEngineClient.createVmwareEngineNetworkOperationCallable().futureCall(request);
   *   // Do something.
   *   VmwareEngineNetwork response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      createVmwareEngineNetworkOperationCallable() {
    return stub.createVmwareEngineNetworkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VMware Engine network that can be used by a private cloud.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   CreateVmwareEngineNetworkRequest request =
   *       CreateVmwareEngineNetworkRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVmwareEngineNetworkId("vmwareEngineNetworkId532532083")
   *           .setVmwareEngineNetwork(VmwareEngineNetwork.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.createVmwareEngineNetworkCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateVmwareEngineNetworkRequest, Operation>
      createVmwareEngineNetworkCallable() {
    return stub.createVmwareEngineNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a VMware Engine network resource. Only the following fields can be updated:
   * `description`. Only fields specified in `updateMask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   VmwareEngineNetwork vmwareEngineNetwork = VmwareEngineNetwork.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   VmwareEngineNetwork response =
   *       vmwareEngineClient.updateVmwareEngineNetworkAsync(vmwareEngineNetwork, updateMask).get();
   * }
   * }</pre>
   *
   * @param vmwareEngineNetwork Required. VMware Engine network description.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     VMware Engine network resource by the update. The fields specified in the `update_mask` are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten. Only the
   *     following fields can be updated: `description`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkAsync(
          VmwareEngineNetwork vmwareEngineNetwork, FieldMask updateMask) {
    UpdateVmwareEngineNetworkRequest request =
        UpdateVmwareEngineNetworkRequest.newBuilder()
            .setVmwareEngineNetwork(vmwareEngineNetwork)
            .setUpdateMask(updateMask)
            .build();
    return updateVmwareEngineNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a VMware Engine network resource. Only the following fields can be updated:
   * `description`. Only fields specified in `updateMask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateVmwareEngineNetworkRequest request =
   *       UpdateVmwareEngineNetworkRequest.newBuilder()
   *           .setVmwareEngineNetwork(VmwareEngineNetwork.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   VmwareEngineNetwork response =
   *       vmwareEngineClient.updateVmwareEngineNetworkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkAsync(UpdateVmwareEngineNetworkRequest request) {
    return updateVmwareEngineNetworkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a VMware Engine network resource. Only the following fields can be updated:
   * `description`. Only fields specified in `updateMask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateVmwareEngineNetworkRequest request =
   *       UpdateVmwareEngineNetworkRequest.newBuilder()
   *           .setVmwareEngineNetwork(VmwareEngineNetwork.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<VmwareEngineNetwork, OperationMetadata> future =
   *       vmwareEngineClient.updateVmwareEngineNetworkOperationCallable().futureCall(request);
   *   // Do something.
   *   VmwareEngineNetwork response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateVmwareEngineNetworkRequest, VmwareEngineNetwork, OperationMetadata>
      updateVmwareEngineNetworkOperationCallable() {
    return stub.updateVmwareEngineNetworkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies a VMware Engine network resource. Only the following fields can be updated:
   * `description`. Only fields specified in `updateMask` are applied.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   UpdateVmwareEngineNetworkRequest request =
   *       UpdateVmwareEngineNetworkRequest.newBuilder()
   *           .setVmwareEngineNetwork(VmwareEngineNetwork.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.updateVmwareEngineNetworkCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateVmwareEngineNetworkRequest, Operation>
      updateVmwareEngineNetworkCallable() {
    return stub.updateVmwareEngineNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware Engine network after all
   * resources that refer to it are deleted. For example, a private cloud, a network peering, and a
   * network policy can all refer to the same VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   VmwareEngineNetworkName name =
   *       VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]");
   *   vmwareEngineClient.deleteVmwareEngineNetworkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the VMware Engine network to be deleted. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/vmwareEngineNetworks/my-network`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVmwareEngineNetworkAsync(
      VmwareEngineNetworkName name) {
    DeleteVmwareEngineNetworkRequest request =
        DeleteVmwareEngineNetworkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteVmwareEngineNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware Engine network after all
   * resources that refer to it are deleted. For example, a private cloud, a network peering, and a
   * network policy can all refer to the same VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *           .toString();
   *   vmwareEngineClient.deleteVmwareEngineNetworkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the VMware Engine network to be deleted. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/vmwareEngineNetworks/my-network`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVmwareEngineNetworkAsync(
      String name) {
    DeleteVmwareEngineNetworkRequest request =
        DeleteVmwareEngineNetworkRequest.newBuilder().setName(name).build();
    return deleteVmwareEngineNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware Engine network after all
   * resources that refer to it are deleted. For example, a private cloud, a network peering, and a
   * network policy can all refer to the same VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteVmwareEngineNetworkRequest request =
   *       DeleteVmwareEngineNetworkRequest.newBuilder()
   *           .setName(
   *               VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   vmwareEngineClient.deleteVmwareEngineNetworkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVmwareEngineNetworkAsync(
      DeleteVmwareEngineNetworkRequest request) {
    return deleteVmwareEngineNetworkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware Engine network after all
   * resources that refer to it are deleted. For example, a private cloud, a network peering, and a
   * network policy can all refer to the same VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteVmwareEngineNetworkRequest request =
   *       DeleteVmwareEngineNetworkRequest.newBuilder()
   *           .setName(
   *               VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmwareEngineClient.deleteVmwareEngineNetworkOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteVmwareEngineNetworkRequest, Empty, OperationMetadata>
      deleteVmwareEngineNetworkOperationCallable() {
    return stub.deleteVmwareEngineNetworkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware Engine network after all
   * resources that refer to it are deleted. For example, a private cloud, a network peering, and a
   * network policy can all refer to the same VMware Engine network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   DeleteVmwareEngineNetworkRequest request =
   *       DeleteVmwareEngineNetworkRequest.newBuilder()
   *           .setName(
   *               VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmwareEngineClient.deleteVmwareEngineNetworkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteVmwareEngineNetworkRequest, Operation>
      deleteVmwareEngineNetworkCallable() {
    return stub.deleteVmwareEngineNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `VmwareEngineNetwork` resource by its resource name. The resource contains details
   * of the VMware Engine network, such as its VMware Engine network type, peered networks in a
   * service project, and state (for example, `CREATING`, `ACTIVE`, `DELETING`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   VmwareEngineNetworkName name =
   *       VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]");
   *   VmwareEngineNetwork response = vmwareEngineClient.getVmwareEngineNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the VMware Engine network to retrieve. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/vmwareEngineNetworks/my-network`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VmwareEngineNetwork getVmwareEngineNetwork(VmwareEngineNetworkName name) {
    GetVmwareEngineNetworkRequest request =
        GetVmwareEngineNetworkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getVmwareEngineNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `VmwareEngineNetwork` resource by its resource name. The resource contains details
   * of the VMware Engine network, such as its VMware Engine network type, peered networks in a
   * service project, and state (for example, `CREATING`, `ACTIVE`, `DELETING`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String name =
   *       VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *           .toString();
   *   VmwareEngineNetwork response = vmwareEngineClient.getVmwareEngineNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the VMware Engine network to retrieve. Resource
   *     names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global/vmwareEngineNetworks/my-network`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VmwareEngineNetwork getVmwareEngineNetwork(String name) {
    GetVmwareEngineNetworkRequest request =
        GetVmwareEngineNetworkRequest.newBuilder().setName(name).build();
    return getVmwareEngineNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `VmwareEngineNetwork` resource by its resource name. The resource contains details
   * of the VMware Engine network, such as its VMware Engine network type, peered networks in a
   * service project, and state (for example, `CREATING`, `ACTIVE`, `DELETING`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetVmwareEngineNetworkRequest request =
   *       GetVmwareEngineNetworkRequest.newBuilder()
   *           .setName(
   *               VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *                   .toString())
   *           .build();
   *   VmwareEngineNetwork response = vmwareEngineClient.getVmwareEngineNetwork(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VmwareEngineNetwork getVmwareEngineNetwork(GetVmwareEngineNetworkRequest request) {
    return getVmwareEngineNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `VmwareEngineNetwork` resource by its resource name. The resource contains details
   * of the VMware Engine network, such as its VMware Engine network type, peered networks in a
   * service project, and state (for example, `CREATING`, `ACTIVE`, `DELETING`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetVmwareEngineNetworkRequest request =
   *       GetVmwareEngineNetworkRequest.newBuilder()
   *           .setName(
   *               VmwareEngineNetworkName.of("[PROJECT]", "[LOCATION]", "[VMWARE_ENGINE_NETWORK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<VmwareEngineNetwork> future =
   *       vmwareEngineClient.getVmwareEngineNetworkCallable().futureCall(request);
   *   // Do something.
   *   VmwareEngineNetwork response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVmwareEngineNetworkRequest, VmwareEngineNetwork>
      getVmwareEngineNetworkCallable() {
    return stub.getVmwareEngineNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `VmwareEngineNetwork` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (VmwareEngineNetwork element :
   *       vmwareEngineClient.listVmwareEngineNetworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to query for VMware Engine networks.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVmwareEngineNetworksPagedResponse listVmwareEngineNetworks(LocationName parent) {
    ListVmwareEngineNetworksRequest request =
        ListVmwareEngineNetworksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVmwareEngineNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `VmwareEngineNetwork` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (VmwareEngineNetwork element :
   *       vmwareEngineClient.listVmwareEngineNetworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to query for VMware Engine networks.
   *     Resource names are schemeless URIs that follow the conventions in
   *     https://cloud.google.com/apis/design/resource_names. For example:
   *     `projects/my-project/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVmwareEngineNetworksPagedResponse listVmwareEngineNetworks(String parent) {
    ListVmwareEngineNetworksRequest request =
        ListVmwareEngineNetworksRequest.newBuilder().setParent(parent).build();
    return listVmwareEngineNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `VmwareEngineNetwork` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListVmwareEngineNetworksRequest request =
   *       ListVmwareEngineNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (VmwareEngineNetwork element :
   *       vmwareEngineClient.listVmwareEngineNetworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVmwareEngineNetworksPagedResponse listVmwareEngineNetworks(
      ListVmwareEngineNetworksRequest request) {
    return listVmwareEngineNetworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `VmwareEngineNetwork` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListVmwareEngineNetworksRequest request =
   *       ListVmwareEngineNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<VmwareEngineNetwork> future =
   *       vmwareEngineClient.listVmwareEngineNetworksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VmwareEngineNetwork element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksPagedResponse>
      listVmwareEngineNetworksPagedCallable() {
    return stub.listVmwareEngineNetworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `VmwareEngineNetwork` resources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListVmwareEngineNetworksRequest request =
   *       ListVmwareEngineNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListVmwareEngineNetworksResponse response =
   *         vmwareEngineClient.listVmwareEngineNetworksCallable().call(request);
   *     for (VmwareEngineNetwork element : response.getVmwareEngineNetworksList()) {
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
  public final UnaryCallable<ListVmwareEngineNetworksRequest, ListVmwareEngineNetworksResponse>
      listVmwareEngineNetworksCallable() {
    return stub.listVmwareEngineNetworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : vmwareEngineClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       vmwareEngineClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = vmwareEngineClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = vmwareEngineClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = vmwareEngineClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = vmwareEngineClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = vmwareEngineClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = vmwareEngineClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = vmwareEngineClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = vmwareEngineClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmwareEngineClient vmwareEngineClient = VmwareEngineClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ClusterName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CLOUD]", "[CLUSTER]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       vmwareEngineClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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

  public static class ListPrivateCloudsPagedResponse
      extends AbstractPagedListResponse<
          ListPrivateCloudsRequest,
          ListPrivateCloudsResponse,
          PrivateCloud,
          ListPrivateCloudsPage,
          ListPrivateCloudsFixedSizeCollection> {

    public static ApiFuture<ListPrivateCloudsPagedResponse> createAsync(
        PageContext<ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud> context,
        ApiFuture<ListPrivateCloudsResponse> futureResponse) {
      ApiFuture<ListPrivateCloudsPage> futurePage =
          ListPrivateCloudsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPrivateCloudsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPrivateCloudsPagedResponse(ListPrivateCloudsPage page) {
      super(page, ListPrivateCloudsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPrivateCloudsPage
      extends AbstractPage<
          ListPrivateCloudsRequest,
          ListPrivateCloudsResponse,
          PrivateCloud,
          ListPrivateCloudsPage> {

    private ListPrivateCloudsPage(
        PageContext<ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud> context,
        ListPrivateCloudsResponse response) {
      super(context, response);
    }

    private static ListPrivateCloudsPage createEmptyPage() {
      return new ListPrivateCloudsPage(null, null);
    }

    @Override
    protected ListPrivateCloudsPage createPage(
        PageContext<ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud> context,
        ListPrivateCloudsResponse response) {
      return new ListPrivateCloudsPage(context, response);
    }

    @Override
    public ApiFuture<ListPrivateCloudsPage> createPageAsync(
        PageContext<ListPrivateCloudsRequest, ListPrivateCloudsResponse, PrivateCloud> context,
        ApiFuture<ListPrivateCloudsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPrivateCloudsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPrivateCloudsRequest,
          ListPrivateCloudsResponse,
          PrivateCloud,
          ListPrivateCloudsPage,
          ListPrivateCloudsFixedSizeCollection> {

    private ListPrivateCloudsFixedSizeCollection(
        List<ListPrivateCloudsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPrivateCloudsFixedSizeCollection createEmptyCollection() {
      return new ListPrivateCloudsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPrivateCloudsFixedSizeCollection createCollection(
        List<ListPrivateCloudsPage> pages, int collectionSize) {
      return new ListPrivateCloudsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListClustersPagedResponse
      extends AbstractPagedListResponse<
          ListClustersRequest,
          ListClustersResponse,
          Cluster,
          ListClustersPage,
          ListClustersFixedSizeCollection> {

    public static ApiFuture<ListClustersPagedResponse> createAsync(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ApiFuture<ListClustersResponse> futureResponse) {
      ApiFuture<ListClustersPage> futurePage =
          ListClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListClustersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListClustersPagedResponse(ListClustersPage page) {
      super(page, ListClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListClustersPage
      extends AbstractPage<ListClustersRequest, ListClustersResponse, Cluster, ListClustersPage> {

    private ListClustersPage(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ListClustersResponse response) {
      super(context, response);
    }

    private static ListClustersPage createEmptyPage() {
      return new ListClustersPage(null, null);
    }

    @Override
    protected ListClustersPage createPage(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ListClustersResponse response) {
      return new ListClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListClustersPage> createPageAsync(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ApiFuture<ListClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListClustersRequest,
          ListClustersResponse,
          Cluster,
          ListClustersPage,
          ListClustersFixedSizeCollection> {

    private ListClustersFixedSizeCollection(List<ListClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListClustersFixedSizeCollection createEmptyCollection() {
      return new ListClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListClustersFixedSizeCollection createCollection(
        List<ListClustersPage> pages, int collectionSize) {
      return new ListClustersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSubnetsPagedResponse
      extends AbstractPagedListResponse<
          ListSubnetsRequest,
          ListSubnetsResponse,
          Subnet,
          ListSubnetsPage,
          ListSubnetsFixedSizeCollection> {

    public static ApiFuture<ListSubnetsPagedResponse> createAsync(
        PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> context,
        ApiFuture<ListSubnetsResponse> futureResponse) {
      ApiFuture<ListSubnetsPage> futurePage =
          ListSubnetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSubnetsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSubnetsPagedResponse(ListSubnetsPage page) {
      super(page, ListSubnetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSubnetsPage
      extends AbstractPage<ListSubnetsRequest, ListSubnetsResponse, Subnet, ListSubnetsPage> {

    private ListSubnetsPage(
        PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> context,
        ListSubnetsResponse response) {
      super(context, response);
    }

    private static ListSubnetsPage createEmptyPage() {
      return new ListSubnetsPage(null, null);
    }

    @Override
    protected ListSubnetsPage createPage(
        PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> context,
        ListSubnetsResponse response) {
      return new ListSubnetsPage(context, response);
    }

    @Override
    public ApiFuture<ListSubnetsPage> createPageAsync(
        PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> context,
        ApiFuture<ListSubnetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSubnetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSubnetsRequest,
          ListSubnetsResponse,
          Subnet,
          ListSubnetsPage,
          ListSubnetsFixedSizeCollection> {

    private ListSubnetsFixedSizeCollection(List<ListSubnetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSubnetsFixedSizeCollection createEmptyCollection() {
      return new ListSubnetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSubnetsFixedSizeCollection createCollection(
        List<ListSubnetsPage> pages, int collectionSize) {
      return new ListSubnetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNodeTypesPagedResponse
      extends AbstractPagedListResponse<
          ListNodeTypesRequest,
          ListNodeTypesResponse,
          NodeType,
          ListNodeTypesPage,
          ListNodeTypesFixedSizeCollection> {

    public static ApiFuture<ListNodeTypesPagedResponse> createAsync(
        PageContext<ListNodeTypesRequest, ListNodeTypesResponse, NodeType> context,
        ApiFuture<ListNodeTypesResponse> futureResponse) {
      ApiFuture<ListNodeTypesPage> futurePage =
          ListNodeTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNodeTypesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNodeTypesPagedResponse(ListNodeTypesPage page) {
      super(page, ListNodeTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNodeTypesPage
      extends AbstractPage<
          ListNodeTypesRequest, ListNodeTypesResponse, NodeType, ListNodeTypesPage> {

    private ListNodeTypesPage(
        PageContext<ListNodeTypesRequest, ListNodeTypesResponse, NodeType> context,
        ListNodeTypesResponse response) {
      super(context, response);
    }

    private static ListNodeTypesPage createEmptyPage() {
      return new ListNodeTypesPage(null, null);
    }

    @Override
    protected ListNodeTypesPage createPage(
        PageContext<ListNodeTypesRequest, ListNodeTypesResponse, NodeType> context,
        ListNodeTypesResponse response) {
      return new ListNodeTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListNodeTypesPage> createPageAsync(
        PageContext<ListNodeTypesRequest, ListNodeTypesResponse, NodeType> context,
        ApiFuture<ListNodeTypesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNodeTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNodeTypesRequest,
          ListNodeTypesResponse,
          NodeType,
          ListNodeTypesPage,
          ListNodeTypesFixedSizeCollection> {

    private ListNodeTypesFixedSizeCollection(List<ListNodeTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNodeTypesFixedSizeCollection createEmptyCollection() {
      return new ListNodeTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNodeTypesFixedSizeCollection createCollection(
        List<ListNodeTypesPage> pages, int collectionSize) {
      return new ListNodeTypesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListHcxActivationKeysPagedResponse
      extends AbstractPagedListResponse<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          HcxActivationKey,
          ListHcxActivationKeysPage,
          ListHcxActivationKeysFixedSizeCollection> {

    public static ApiFuture<ListHcxActivationKeysPagedResponse> createAsync(
        PageContext<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>
            context,
        ApiFuture<ListHcxActivationKeysResponse> futureResponse) {
      ApiFuture<ListHcxActivationKeysPage> futurePage =
          ListHcxActivationKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListHcxActivationKeysPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListHcxActivationKeysPagedResponse(ListHcxActivationKeysPage page) {
      super(page, ListHcxActivationKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHcxActivationKeysPage
      extends AbstractPage<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          HcxActivationKey,
          ListHcxActivationKeysPage> {

    private ListHcxActivationKeysPage(
        PageContext<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>
            context,
        ListHcxActivationKeysResponse response) {
      super(context, response);
    }

    private static ListHcxActivationKeysPage createEmptyPage() {
      return new ListHcxActivationKeysPage(null, null);
    }

    @Override
    protected ListHcxActivationKeysPage createPage(
        PageContext<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>
            context,
        ListHcxActivationKeysResponse response) {
      return new ListHcxActivationKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListHcxActivationKeysPage> createPageAsync(
        PageContext<ListHcxActivationKeysRequest, ListHcxActivationKeysResponse, HcxActivationKey>
            context,
        ApiFuture<ListHcxActivationKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHcxActivationKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHcxActivationKeysRequest,
          ListHcxActivationKeysResponse,
          HcxActivationKey,
          ListHcxActivationKeysPage,
          ListHcxActivationKeysFixedSizeCollection> {

    private ListHcxActivationKeysFixedSizeCollection(
        List<ListHcxActivationKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHcxActivationKeysFixedSizeCollection createEmptyCollection() {
      return new ListHcxActivationKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHcxActivationKeysFixedSizeCollection createCollection(
        List<ListHcxActivationKeysPage> pages, int collectionSize) {
      return new ListHcxActivationKeysFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNetworkPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListNetworkPoliciesRequest,
          ListNetworkPoliciesResponse,
          NetworkPolicy,
          ListNetworkPoliciesPage,
          ListNetworkPoliciesFixedSizeCollection> {

    public static ApiFuture<ListNetworkPoliciesPagedResponse> createAsync(
        PageContext<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy> context,
        ApiFuture<ListNetworkPoliciesResponse> futureResponse) {
      ApiFuture<ListNetworkPoliciesPage> futurePage =
          ListNetworkPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNetworkPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNetworkPoliciesPagedResponse(ListNetworkPoliciesPage page) {
      super(page, ListNetworkPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNetworkPoliciesPage
      extends AbstractPage<
          ListNetworkPoliciesRequest,
          ListNetworkPoliciesResponse,
          NetworkPolicy,
          ListNetworkPoliciesPage> {

    private ListNetworkPoliciesPage(
        PageContext<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy> context,
        ListNetworkPoliciesResponse response) {
      super(context, response);
    }

    private static ListNetworkPoliciesPage createEmptyPage() {
      return new ListNetworkPoliciesPage(null, null);
    }

    @Override
    protected ListNetworkPoliciesPage createPage(
        PageContext<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy> context,
        ListNetworkPoliciesResponse response) {
      return new ListNetworkPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListNetworkPoliciesPage> createPageAsync(
        PageContext<ListNetworkPoliciesRequest, ListNetworkPoliciesResponse, NetworkPolicy> context,
        ApiFuture<ListNetworkPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNetworkPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworkPoliciesRequest,
          ListNetworkPoliciesResponse,
          NetworkPolicy,
          ListNetworkPoliciesPage,
          ListNetworkPoliciesFixedSizeCollection> {

    private ListNetworkPoliciesFixedSizeCollection(
        List<ListNetworkPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNetworkPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListNetworkPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNetworkPoliciesFixedSizeCollection createCollection(
        List<ListNetworkPoliciesPage> pages, int collectionSize) {
      return new ListNetworkPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVmwareEngineNetworksPagedResponse
      extends AbstractPagedListResponse<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          VmwareEngineNetwork,
          ListVmwareEngineNetworksPage,
          ListVmwareEngineNetworksFixedSizeCollection> {

    public static ApiFuture<ListVmwareEngineNetworksPagedResponse> createAsync(
        PageContext<
                ListVmwareEngineNetworksRequest,
                ListVmwareEngineNetworksResponse,
                VmwareEngineNetwork>
            context,
        ApiFuture<ListVmwareEngineNetworksResponse> futureResponse) {
      ApiFuture<ListVmwareEngineNetworksPage> futurePage =
          ListVmwareEngineNetworksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVmwareEngineNetworksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVmwareEngineNetworksPagedResponse(ListVmwareEngineNetworksPage page) {
      super(page, ListVmwareEngineNetworksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVmwareEngineNetworksPage
      extends AbstractPage<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          VmwareEngineNetwork,
          ListVmwareEngineNetworksPage> {

    private ListVmwareEngineNetworksPage(
        PageContext<
                ListVmwareEngineNetworksRequest,
                ListVmwareEngineNetworksResponse,
                VmwareEngineNetwork>
            context,
        ListVmwareEngineNetworksResponse response) {
      super(context, response);
    }

    private static ListVmwareEngineNetworksPage createEmptyPage() {
      return new ListVmwareEngineNetworksPage(null, null);
    }

    @Override
    protected ListVmwareEngineNetworksPage createPage(
        PageContext<
                ListVmwareEngineNetworksRequest,
                ListVmwareEngineNetworksResponse,
                VmwareEngineNetwork>
            context,
        ListVmwareEngineNetworksResponse response) {
      return new ListVmwareEngineNetworksPage(context, response);
    }

    @Override
    public ApiFuture<ListVmwareEngineNetworksPage> createPageAsync(
        PageContext<
                ListVmwareEngineNetworksRequest,
                ListVmwareEngineNetworksResponse,
                VmwareEngineNetwork>
            context,
        ApiFuture<ListVmwareEngineNetworksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVmwareEngineNetworksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVmwareEngineNetworksRequest,
          ListVmwareEngineNetworksResponse,
          VmwareEngineNetwork,
          ListVmwareEngineNetworksPage,
          ListVmwareEngineNetworksFixedSizeCollection> {

    private ListVmwareEngineNetworksFixedSizeCollection(
        List<ListVmwareEngineNetworksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVmwareEngineNetworksFixedSizeCollection createEmptyCollection() {
      return new ListVmwareEngineNetworksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVmwareEngineNetworksFixedSizeCollection createCollection(
        List<ListVmwareEngineNetworksPage> pages, int collectionSize) {
      return new ListVmwareEngineNetworksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
