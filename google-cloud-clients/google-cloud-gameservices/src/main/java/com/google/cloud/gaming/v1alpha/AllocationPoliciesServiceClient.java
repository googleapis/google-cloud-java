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
package com.google.cloud.gaming.v1alpha;

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
import com.google.cloud.gaming.v1alpha.stub.AllocationPoliciesServiceStub;
import com.google.cloud.gaming.v1alpha.stub.AllocationPoliciesServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The cloud gaming allocation policy is used as the controller's recipe for
 * the allocating game servers from clusters. The policy has three modes: 1. Default mode which is
 * not limited to time. 2. Time based mode which is temporary and overrides the default mode when
 * effective. 3. Periodic mode which follows the time base mode, but happens periodically using
 * local time, identified by cron specs.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
 *   String formattedName = AllocationPoliciesServiceClient.formatAllocationPolicyName("[PROJECT]", "[LOCATION]", "[ALLOCATION_POLICY]");
 *   AllocationPolicy response = allocationPoliciesServiceClient.getAllocationPolicy(formattedName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the allocationPoliciesServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * AllocationPoliciesServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * AllocationPoliciesServiceSettings allocationPoliciesServiceSettings =
 *     AllocationPoliciesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AllocationPoliciesServiceClient allocationPoliciesServiceClient =
 *     AllocationPoliciesServiceClient.create(allocationPoliciesServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * AllocationPoliciesServiceSettings allocationPoliciesServiceSettings =
 *     AllocationPoliciesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AllocationPoliciesServiceClient allocationPoliciesServiceClient =
 *     AllocationPoliciesServiceClient.create(allocationPoliciesServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class AllocationPoliciesServiceClient implements BackgroundResource {
  private final AllocationPoliciesServiceSettings settings;
  private final AllocationPoliciesServiceStub stub;
  private final OperationsClient operationsClient;

  private static final PathTemplate ALLOCATION_POLICY_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/allocationPolicies/{allocation_policy}");

  private static final PathTemplate LOCATION_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}");

  /**
   * Formats a string containing the fully-qualified path to represent a allocation_policy resource.
   *
   * @deprecated Use the {@link AllocationPolicyName} class instead.
   */
  @Deprecated
  public static final String formatAllocationPolicyName(
      String project, String location, String allocationPolicy) {
    return ALLOCATION_POLICY_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "allocation_policy", allocationPolicy);
  }

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
   * Parses the project from the given fully-qualified path which represents a allocation_policy
   * resource.
   *
   * @deprecated Use the {@link AllocationPolicyName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromAllocationPolicyName(String allocationPolicyName) {
    return ALLOCATION_POLICY_PATH_TEMPLATE.parse(allocationPolicyName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a allocation_policy
   * resource.
   *
   * @deprecated Use the {@link AllocationPolicyName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromAllocationPolicyName(String allocationPolicyName) {
    return ALLOCATION_POLICY_PATH_TEMPLATE.parse(allocationPolicyName).get("location");
  }

  /**
   * Parses the allocation_policy from the given fully-qualified path which represents a
   * allocation_policy resource.
   *
   * @deprecated Use the {@link AllocationPolicyName} class instead.
   */
  @Deprecated
  public static final String parseAllocationPolicyFromAllocationPolicyName(
      String allocationPolicyName) {
    return ALLOCATION_POLICY_PATH_TEMPLATE.parse(allocationPolicyName).get("allocation_policy");
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

  /** Constructs an instance of AllocationPoliciesServiceClient with default settings. */
  public static final AllocationPoliciesServiceClient create() throws IOException {
    return create(AllocationPoliciesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AllocationPoliciesServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final AllocationPoliciesServiceClient create(
      AllocationPoliciesServiceSettings settings) throws IOException {
    return new AllocationPoliciesServiceClient(settings);
  }

  /**
   * Constructs an instance of AllocationPoliciesServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer to use AllocationPoliciesServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AllocationPoliciesServiceClient create(AllocationPoliciesServiceStub stub) {
    return new AllocationPoliciesServiceClient(stub);
  }

  /**
   * Constructs an instance of AllocationPoliciesServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AllocationPoliciesServiceClient(AllocationPoliciesServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((AllocationPoliciesServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AllocationPoliciesServiceClient(AllocationPoliciesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final AllocationPoliciesServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AllocationPoliciesServiceStub getStub() {
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
   * List allocation policies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedParent = AllocationPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   for (AllocationPolicy element : allocationPoliciesServiceClient.listAllocationPolicies(formattedParent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name, using the form:
   *     `projects/{project_id}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAllocationPoliciesPagedResponse listAllocationPolicies(String parent) {
    LOCATION_PATH_TEMPLATE.validate(parent, "listAllocationPolicies");
    ListAllocationPoliciesRequest request =
        ListAllocationPoliciesRequest.newBuilder().setParent(parent).build();
    return listAllocationPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List allocation policies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedParent = AllocationPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListAllocationPoliciesRequest request = ListAllocationPoliciesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (AllocationPolicy element : allocationPoliciesServiceClient.listAllocationPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAllocationPoliciesPagedResponse listAllocationPolicies(
      ListAllocationPoliciesRequest request) {
    return listAllocationPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List allocation policies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedParent = AllocationPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListAllocationPoliciesRequest request = ListAllocationPoliciesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListAllocationPoliciesPagedResponse&gt; future = allocationPoliciesServiceClient.listAllocationPoliciesPagedCallable().futureCall(request);
   *   // Do something
   *   for (AllocationPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListAllocationPoliciesRequest, ListAllocationPoliciesPagedResponse>
      listAllocationPoliciesPagedCallable() {
    return stub.listAllocationPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List allocation policies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedParent = AllocationPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListAllocationPoliciesRequest request = ListAllocationPoliciesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListAllocationPoliciesResponse response = allocationPoliciesServiceClient.listAllocationPoliciesCallable().call(request);
   *     for (AllocationPolicy element : response.getAllocationPoliciesList()) {
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
  public final UnaryCallable<ListAllocationPoliciesRequest, ListAllocationPoliciesResponse>
      listAllocationPoliciesCallable() {
    return stub.listAllocationPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single allocation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedName = AllocationPoliciesServiceClient.formatAllocationPolicyName("[PROJECT]", "[LOCATION]", "[ALLOCATION_POLICY]");
   *   AllocationPolicy response = allocationPoliciesServiceClient.getAllocationPolicy(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the allocation policy to retrieve, using the form:
   *     <p>`projects/{project_id}/locations/{location}/allocationPolicies/{allocation_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AllocationPolicy getAllocationPolicy(String name) {
    ALLOCATION_POLICY_PATH_TEMPLATE.validate(name, "getAllocationPolicy");
    GetAllocationPolicyRequest request =
        GetAllocationPolicyRequest.newBuilder().setName(name).build();
    return getAllocationPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single allocation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedName = AllocationPoliciesServiceClient.formatAllocationPolicyName("[PROJECT]", "[LOCATION]", "[ALLOCATION_POLICY]");
   *   GetAllocationPolicyRequest request = GetAllocationPolicyRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   AllocationPolicy response = allocationPoliciesServiceClient.getAllocationPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AllocationPolicy getAllocationPolicy(GetAllocationPolicyRequest request) {
    return getAllocationPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single allocation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedName = AllocationPoliciesServiceClient.formatAllocationPolicyName("[PROJECT]", "[LOCATION]", "[ALLOCATION_POLICY]");
   *   GetAllocationPolicyRequest request = GetAllocationPolicyRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;AllocationPolicy&gt; future = allocationPoliciesServiceClient.getAllocationPolicyCallable().futureCall(request);
   *   // Do something
   *   AllocationPolicy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetAllocationPolicyRequest, AllocationPolicy>
      getAllocationPolicyCallable() {
    return stub.getAllocationPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new allocation policy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedParent = AllocationPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String allocationPolicyId = "";
   *   AllocationPolicy allocationPolicy = AllocationPolicy.newBuilder().build();
   *   AllocationPolicy response = allocationPoliciesServiceClient.createAllocationPolicyAsync(formattedParent, allocationPolicyId, allocationPolicy).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name, using the form:
   *     `projects/{project_id}/locations/{location}`.
   * @param allocationPolicyId Required. The ID of the allocation policy resource to be created.
   * @param allocationPolicy Required. The allocation policy resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<AllocationPolicy, Empty> createAllocationPolicyAsync(
      String parent, String allocationPolicyId, AllocationPolicy allocationPolicy) {
    LOCATION_PATH_TEMPLATE.validate(parent, "createAllocationPolicy");
    CreateAllocationPolicyRequest request =
        CreateAllocationPolicyRequest.newBuilder()
            .setParent(parent)
            .setAllocationPolicyId(allocationPolicyId)
            .setAllocationPolicy(allocationPolicy)
            .build();
    return createAllocationPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new allocation policy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedParent = AllocationPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String allocationPolicyId = "";
   *   AllocationPolicy allocationPolicy = AllocationPolicy.newBuilder().build();
   *   CreateAllocationPolicyRequest request = CreateAllocationPolicyRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setAllocationPolicyId(allocationPolicyId)
   *     .setAllocationPolicy(allocationPolicy)
   *     .build();
   *   AllocationPolicy response = allocationPoliciesServiceClient.createAllocationPolicyAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<AllocationPolicy, Empty> createAllocationPolicyAsync(
      CreateAllocationPolicyRequest request) {
    return createAllocationPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new allocation policy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedParent = AllocationPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String allocationPolicyId = "";
   *   AllocationPolicy allocationPolicy = AllocationPolicy.newBuilder().build();
   *   CreateAllocationPolicyRequest request = CreateAllocationPolicyRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setAllocationPolicyId(allocationPolicyId)
   *     .setAllocationPolicy(allocationPolicy)
   *     .build();
   *   OperationFuture&lt;AllocationPolicy, Empty&gt; future = allocationPoliciesServiceClient.createAllocationPolicyOperationCallable().futureCall(request);
   *   // Do something
   *   AllocationPolicy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<CreateAllocationPolicyRequest, AllocationPolicy, Empty>
      createAllocationPolicyOperationCallable() {
    return stub.createAllocationPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new allocation policy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedParent = AllocationPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String allocationPolicyId = "";
   *   AllocationPolicy allocationPolicy = AllocationPolicy.newBuilder().build();
   *   CreateAllocationPolicyRequest request = CreateAllocationPolicyRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setAllocationPolicyId(allocationPolicyId)
   *     .setAllocationPolicy(allocationPolicy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = allocationPoliciesServiceClient.createAllocationPolicyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateAllocationPolicyRequest, Operation>
      createAllocationPolicyCallable() {
    return stub.createAllocationPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single allocation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedName = AllocationPoliciesServiceClient.formatAllocationPolicyName("[PROJECT]", "[LOCATION]", "[ALLOCATION_POLICY]");
   *   allocationPoliciesServiceClient.deleteAllocationPolicyAsync(formattedName).get();
   * }
   * </code></pre>
   *
   * @param name Required. The name of the allocation policy to delete, using the form:
   *     <p>`projects/{project_id}/locations/{location}/allocationPolicies/{allocation_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, Empty> deleteAllocationPolicyAsync(String name) {
    ALLOCATION_POLICY_PATH_TEMPLATE.validate(name, "deleteAllocationPolicy");
    DeleteAllocationPolicyRequest request =
        DeleteAllocationPolicyRequest.newBuilder().setName(name).build();
    return deleteAllocationPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single allocation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedName = AllocationPoliciesServiceClient.formatAllocationPolicyName("[PROJECT]", "[LOCATION]", "[ALLOCATION_POLICY]");
   *   DeleteAllocationPolicyRequest request = DeleteAllocationPolicyRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   allocationPoliciesServiceClient.deleteAllocationPolicyAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, Empty> deleteAllocationPolicyAsync(
      DeleteAllocationPolicyRequest request) {
    return deleteAllocationPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single allocation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedName = AllocationPoliciesServiceClient.formatAllocationPolicyName("[PROJECT]", "[LOCATION]", "[ALLOCATION_POLICY]");
   *   DeleteAllocationPolicyRequest request = DeleteAllocationPolicyRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   OperationFuture&lt;Empty, Empty&gt; future = allocationPoliciesServiceClient.deleteAllocationPolicyOperationCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<DeleteAllocationPolicyRequest, Empty, Empty>
      deleteAllocationPolicyOperationCallable() {
    return stub.deleteAllocationPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single allocation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   String formattedName = AllocationPoliciesServiceClient.formatAllocationPolicyName("[PROJECT]", "[LOCATION]", "[ALLOCATION_POLICY]");
   *   DeleteAllocationPolicyRequest request = DeleteAllocationPolicyRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = allocationPoliciesServiceClient.deleteAllocationPolicyCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteAllocationPolicyRequest, Operation>
      deleteAllocationPolicyCallable() {
    return stub.deleteAllocationPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single allocation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   AllocationPolicy allocationPolicy = AllocationPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AllocationPolicy response = allocationPoliciesServiceClient.updateAllocationPolicyAsync(allocationPolicy, updateMask).get();
   * }
   * </code></pre>
   *
   * @param allocationPolicy Required. The allocation policy to be updated. Only fields specified in
   *     update_mask are updated.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. For the `FieldMask` definition, see
   *     <p>https: //developers.google.com/protocol-buffers //
   *     /docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<AllocationPolicy, Empty> updateAllocationPolicyAsync(
      AllocationPolicy allocationPolicy, FieldMask updateMask) {

    UpdateAllocationPolicyRequest request =
        UpdateAllocationPolicyRequest.newBuilder()
            .setAllocationPolicy(allocationPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateAllocationPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single allocation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   AllocationPolicy allocationPolicy = AllocationPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateAllocationPolicyRequest request = UpdateAllocationPolicyRequest.newBuilder()
   *     .setAllocationPolicy(allocationPolicy)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   AllocationPolicy response = allocationPoliciesServiceClient.updateAllocationPolicyAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<AllocationPolicy, Empty> updateAllocationPolicyAsync(
      UpdateAllocationPolicyRequest request) {
    return updateAllocationPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single allocation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   AllocationPolicy allocationPolicy = AllocationPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateAllocationPolicyRequest request = UpdateAllocationPolicyRequest.newBuilder()
   *     .setAllocationPolicy(allocationPolicy)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   OperationFuture&lt;AllocationPolicy, Empty&gt; future = allocationPoliciesServiceClient.updateAllocationPolicyOperationCallable().futureCall(request);
   *   // Do something
   *   AllocationPolicy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<UpdateAllocationPolicyRequest, AllocationPolicy, Empty>
      updateAllocationPolicyOperationCallable() {
    return stub.updateAllocationPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single allocation policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
   *   AllocationPolicy allocationPolicy = AllocationPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateAllocationPolicyRequest request = UpdateAllocationPolicyRequest.newBuilder()
   *     .setAllocationPolicy(allocationPolicy)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = allocationPoliciesServiceClient.updateAllocationPolicyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateAllocationPolicyRequest, Operation>
      updateAllocationPolicyCallable() {
    return stub.updateAllocationPolicyCallable();
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

  public static class ListAllocationPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListAllocationPoliciesRequest,
          ListAllocationPoliciesResponse,
          AllocationPolicy,
          ListAllocationPoliciesPage,
          ListAllocationPoliciesFixedSizeCollection> {

    public static ApiFuture<ListAllocationPoliciesPagedResponse> createAsync(
        PageContext<ListAllocationPoliciesRequest, ListAllocationPoliciesResponse, AllocationPolicy>
            context,
        ApiFuture<ListAllocationPoliciesResponse> futureResponse) {
      ApiFuture<ListAllocationPoliciesPage> futurePage =
          ListAllocationPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListAllocationPoliciesPage, ListAllocationPoliciesPagedResponse>() {
            @Override
            public ListAllocationPoliciesPagedResponse apply(ListAllocationPoliciesPage input) {
              return new ListAllocationPoliciesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListAllocationPoliciesPagedResponse(ListAllocationPoliciesPage page) {
      super(page, ListAllocationPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAllocationPoliciesPage
      extends AbstractPage<
          ListAllocationPoliciesRequest,
          ListAllocationPoliciesResponse,
          AllocationPolicy,
          ListAllocationPoliciesPage> {

    private ListAllocationPoliciesPage(
        PageContext<ListAllocationPoliciesRequest, ListAllocationPoliciesResponse, AllocationPolicy>
            context,
        ListAllocationPoliciesResponse response) {
      super(context, response);
    }

    private static ListAllocationPoliciesPage createEmptyPage() {
      return new ListAllocationPoliciesPage(null, null);
    }

    @Override
    protected ListAllocationPoliciesPage createPage(
        PageContext<ListAllocationPoliciesRequest, ListAllocationPoliciesResponse, AllocationPolicy>
            context,
        ListAllocationPoliciesResponse response) {
      return new ListAllocationPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListAllocationPoliciesPage> createPageAsync(
        PageContext<ListAllocationPoliciesRequest, ListAllocationPoliciesResponse, AllocationPolicy>
            context,
        ApiFuture<ListAllocationPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAllocationPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAllocationPoliciesRequest,
          ListAllocationPoliciesResponse,
          AllocationPolicy,
          ListAllocationPoliciesPage,
          ListAllocationPoliciesFixedSizeCollection> {

    private ListAllocationPoliciesFixedSizeCollection(
        List<ListAllocationPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAllocationPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListAllocationPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAllocationPoliciesFixedSizeCollection createCollection(
        List<ListAllocationPoliciesPage> pages, int collectionSize) {
      return new ListAllocationPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }
}
