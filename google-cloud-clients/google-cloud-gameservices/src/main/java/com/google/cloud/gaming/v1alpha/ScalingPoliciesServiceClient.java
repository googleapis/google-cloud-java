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
import com.google.cloud.gaming.v1alpha.stub.ScalingPoliciesServiceStub;
import com.google.cloud.gaming.v1alpha.stub.ScalingPoliciesServiceStubSettings;
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
 * Service Description: The cloud gaming scaling policy is used to configure scaling parameters for
 * each fleet.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
 *   String formattedName = ScalingPoliciesServiceClient.formatScalingPolicyName("[PROJECT]", "[LOCATION]", "[SCALING_POLICY]");
 *   ScalingPolicy response = scalingPoliciesServiceClient.getScalingPolicy(formattedName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the scalingPoliciesServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of ScalingPoliciesServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ScalingPoliciesServiceSettings scalingPoliciesServiceSettings =
 *     ScalingPoliciesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ScalingPoliciesServiceClient scalingPoliciesServiceClient =
 *     ScalingPoliciesServiceClient.create(scalingPoliciesServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ScalingPoliciesServiceSettings scalingPoliciesServiceSettings =
 *     ScalingPoliciesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ScalingPoliciesServiceClient scalingPoliciesServiceClient =
 *     ScalingPoliciesServiceClient.create(scalingPoliciesServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ScalingPoliciesServiceClient implements BackgroundResource {
  private final ScalingPoliciesServiceSettings settings;
  private final ScalingPoliciesServiceStub stub;
  private final OperationsClient operationsClient;

  private static final PathTemplate LOCATION_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}");

  private static final PathTemplate SCALING_POLICY_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/scalingPolicies/{scaling_policy}");

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
   * Formats a string containing the fully-qualified path to represent a scaling_policy resource.
   *
   * @deprecated Use the {@link ScalingPolicyName} class instead.
   */
  @Deprecated
  public static final String formatScalingPolicyName(
      String project, String location, String scalingPolicy) {
    return SCALING_POLICY_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "scaling_policy", scalingPolicy);
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
   * Parses the project from the given fully-qualified path which represents a scaling_policy
   * resource.
   *
   * @deprecated Use the {@link ScalingPolicyName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromScalingPolicyName(String scalingPolicyName) {
    return SCALING_POLICY_PATH_TEMPLATE.parse(scalingPolicyName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a scaling_policy
   * resource.
   *
   * @deprecated Use the {@link ScalingPolicyName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromScalingPolicyName(String scalingPolicyName) {
    return SCALING_POLICY_PATH_TEMPLATE.parse(scalingPolicyName).get("location");
  }

  /**
   * Parses the scaling_policy from the given fully-qualified path which represents a scaling_policy
   * resource.
   *
   * @deprecated Use the {@link ScalingPolicyName} class instead.
   */
  @Deprecated
  public static final String parseScalingPolicyFromScalingPolicyName(String scalingPolicyName) {
    return SCALING_POLICY_PATH_TEMPLATE.parse(scalingPolicyName).get("scaling_policy");
  }

  /** Constructs an instance of ScalingPoliciesServiceClient with default settings. */
  public static final ScalingPoliciesServiceClient create() throws IOException {
    return create(ScalingPoliciesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ScalingPoliciesServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ScalingPoliciesServiceClient create(ScalingPoliciesServiceSettings settings)
      throws IOException {
    return new ScalingPoliciesServiceClient(settings);
  }

  /**
   * Constructs an instance of ScalingPoliciesServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use ScalingPoliciesServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ScalingPoliciesServiceClient create(ScalingPoliciesServiceStub stub) {
    return new ScalingPoliciesServiceClient(stub);
  }

  /**
   * Constructs an instance of ScalingPoliciesServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ScalingPoliciesServiceClient(ScalingPoliciesServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ScalingPoliciesServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ScalingPoliciesServiceClient(ScalingPoliciesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ScalingPoliciesServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ScalingPoliciesServiceStub getStub() {
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
   * Lists ScalingPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedParent = ScalingPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   for (ScalingPolicy element : scalingPoliciesServiceClient.listScalingPolicies(formattedParent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name, using the form:
   *     `projects/{project_id}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScalingPoliciesPagedResponse listScalingPolicies(String parent) {
    LOCATION_PATH_TEMPLATE.validate(parent, "listScalingPolicies");
    ListScalingPoliciesRequest request =
        ListScalingPoliciesRequest.newBuilder().setParent(parent).build();
    return listScalingPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists ScalingPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedParent = ScalingPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListScalingPoliciesRequest request = ListScalingPoliciesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (ScalingPolicy element : scalingPoliciesServiceClient.listScalingPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScalingPoliciesPagedResponse listScalingPolicies(
      ListScalingPoliciesRequest request) {
    return listScalingPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists ScalingPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedParent = ScalingPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListScalingPoliciesRequest request = ListScalingPoliciesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListScalingPoliciesPagedResponse&gt; future = scalingPoliciesServiceClient.listScalingPoliciesPagedCallable().futureCall(request);
   *   // Do something
   *   for (ScalingPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListScalingPoliciesRequest, ListScalingPoliciesPagedResponse>
      listScalingPoliciesPagedCallable() {
    return stub.listScalingPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists ScalingPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedParent = ScalingPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListScalingPoliciesRequest request = ListScalingPoliciesRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListScalingPoliciesResponse response = scalingPoliciesServiceClient.listScalingPoliciesCallable().call(request);
   *     for (ScalingPolicy element : response.getScalingPoliciesList()) {
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
  public final UnaryCallable<ListScalingPoliciesRequest, ListScalingPoliciesResponse>
      listScalingPoliciesCallable() {
    return stub.listScalingPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single scaling policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedName = ScalingPoliciesServiceClient.formatScalingPolicyName("[PROJECT]", "[LOCATION]", "[SCALING_POLICY]");
   *   ScalingPolicy response = scalingPoliciesServiceClient.getScalingPolicy(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the scaling policy to retrieve, using the form:
   *     <p>`projects/{project_id}/locations/{location}/scalingPolicies/{scaling_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScalingPolicy getScalingPolicy(String name) {
    SCALING_POLICY_PATH_TEMPLATE.validate(name, "getScalingPolicy");
    GetScalingPolicyRequest request = GetScalingPolicyRequest.newBuilder().setName(name).build();
    return getScalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single scaling policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedName = ScalingPoliciesServiceClient.formatScalingPolicyName("[PROJECT]", "[LOCATION]", "[SCALING_POLICY]");
   *   GetScalingPolicyRequest request = GetScalingPolicyRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ScalingPolicy response = scalingPoliciesServiceClient.getScalingPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScalingPolicy getScalingPolicy(GetScalingPolicyRequest request) {
    return getScalingPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details of a single scaling policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedName = ScalingPoliciesServiceClient.formatScalingPolicyName("[PROJECT]", "[LOCATION]", "[SCALING_POLICY]");
   *   GetScalingPolicyRequest request = GetScalingPolicyRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;ScalingPolicy&gt; future = scalingPoliciesServiceClient.getScalingPolicyCallable().futureCall(request);
   *   // Do something
   *   ScalingPolicy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetScalingPolicyRequest, ScalingPolicy> getScalingPolicyCallable() {
    return stub.getScalingPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new scaling policy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedParent = ScalingPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String scalingPolicyId = "";
   *   ScalingPolicy scalingPolicy = ScalingPolicy.newBuilder().build();
   *   ScalingPolicy response = scalingPoliciesServiceClient.createScalingPolicyAsync(formattedParent, scalingPolicyId, scalingPolicy).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The parent resource name, using the form:
   *     `projects/{project_id}/locations/{location}`.
   * @param scalingPolicyId Required. The ID of the scaling policy resource to be created.
   * @param scalingPolicy Required. The scaling policy resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ScalingPolicy, Empty> createScalingPolicyAsync(
      String parent, String scalingPolicyId, ScalingPolicy scalingPolicy) {
    LOCATION_PATH_TEMPLATE.validate(parent, "createScalingPolicy");
    CreateScalingPolicyRequest request =
        CreateScalingPolicyRequest.newBuilder()
            .setParent(parent)
            .setScalingPolicyId(scalingPolicyId)
            .setScalingPolicy(scalingPolicy)
            .build();
    return createScalingPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new scaling policy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedParent = ScalingPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String scalingPolicyId = "";
   *   ScalingPolicy scalingPolicy = ScalingPolicy.newBuilder().build();
   *   CreateScalingPolicyRequest request = CreateScalingPolicyRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setScalingPolicyId(scalingPolicyId)
   *     .setScalingPolicy(scalingPolicy)
   *     .build();
   *   ScalingPolicy response = scalingPoliciesServiceClient.createScalingPolicyAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ScalingPolicy, Empty> createScalingPolicyAsync(
      CreateScalingPolicyRequest request) {
    return createScalingPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new scaling policy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedParent = ScalingPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String scalingPolicyId = "";
   *   ScalingPolicy scalingPolicy = ScalingPolicy.newBuilder().build();
   *   CreateScalingPolicyRequest request = CreateScalingPolicyRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setScalingPolicyId(scalingPolicyId)
   *     .setScalingPolicy(scalingPolicy)
   *     .build();
   *   OperationFuture&lt;ScalingPolicy, Empty&gt; future = scalingPoliciesServiceClient.createScalingPolicyOperationCallable().futureCall(request);
   *   // Do something
   *   ScalingPolicy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<CreateScalingPolicyRequest, ScalingPolicy, Empty>
      createScalingPolicyOperationCallable() {
    return stub.createScalingPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new scaling policy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedParent = ScalingPoliciesServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String scalingPolicyId = "";
   *   ScalingPolicy scalingPolicy = ScalingPolicy.newBuilder().build();
   *   CreateScalingPolicyRequest request = CreateScalingPolicyRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setScalingPolicyId(scalingPolicyId)
   *     .setScalingPolicy(scalingPolicy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = scalingPoliciesServiceClient.createScalingPolicyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateScalingPolicyRequest, Operation> createScalingPolicyCallable() {
    return stub.createScalingPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single scaling policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedName = ScalingPoliciesServiceClient.formatScalingPolicyName("[PROJECT]", "[LOCATION]", "[SCALING_POLICY]");
   *   scalingPoliciesServiceClient.deleteScalingPolicyAsync(formattedName).get();
   * }
   * </code></pre>
   *
   * @param name Required. The name of the scaling policy to delete, using the form:
   *     <p>`projects/{project_id}/locations/{location}/scalingPolicies/{scaling_policy_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, Empty> deleteScalingPolicyAsync(String name) {
    SCALING_POLICY_PATH_TEMPLATE.validate(name, "deleteScalingPolicy");
    DeleteScalingPolicyRequest request =
        DeleteScalingPolicyRequest.newBuilder().setName(name).build();
    return deleteScalingPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single scaling policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedName = ScalingPoliciesServiceClient.formatScalingPolicyName("[PROJECT]", "[LOCATION]", "[SCALING_POLICY]");
   *   DeleteScalingPolicyRequest request = DeleteScalingPolicyRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   scalingPoliciesServiceClient.deleteScalingPolicyAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Empty, Empty> deleteScalingPolicyAsync(
      DeleteScalingPolicyRequest request) {
    return deleteScalingPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single scaling policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedName = ScalingPoliciesServiceClient.formatScalingPolicyName("[PROJECT]", "[LOCATION]", "[SCALING_POLICY]");
   *   DeleteScalingPolicyRequest request = DeleteScalingPolicyRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   OperationFuture&lt;Empty, Empty&gt; future = scalingPoliciesServiceClient.deleteScalingPolicyOperationCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<DeleteScalingPolicyRequest, Empty, Empty>
      deleteScalingPolicyOperationCallable() {
    return stub.deleteScalingPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a single scaling policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   String formattedName = ScalingPoliciesServiceClient.formatScalingPolicyName("[PROJECT]", "[LOCATION]", "[SCALING_POLICY]");
   *   DeleteScalingPolicyRequest request = DeleteScalingPolicyRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = scalingPoliciesServiceClient.deleteScalingPolicyCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteScalingPolicyRequest, Operation> deleteScalingPolicyCallable() {
    return stub.deleteScalingPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single scaling policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   ScalingPolicy scalingPolicy = ScalingPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ScalingPolicy response = scalingPoliciesServiceClient.updateScalingPolicyAsync(scalingPolicy, updateMask).get();
   * }
   * </code></pre>
   *
   * @param scalingPolicy Required. The scaling policy to be updated. Only fields specified in
   *     update_mask are updated.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. For the `FieldMask` definition, see
   *     <p>https: //developers.google.com/protocol-buffers //
   *     /docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ScalingPolicy, Empty> updateScalingPolicyAsync(
      ScalingPolicy scalingPolicy, FieldMask updateMask) {

    UpdateScalingPolicyRequest request =
        UpdateScalingPolicyRequest.newBuilder()
            .setScalingPolicy(scalingPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateScalingPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single scaling policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   ScalingPolicy scalingPolicy = ScalingPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateScalingPolicyRequest request = UpdateScalingPolicyRequest.newBuilder()
   *     .setScalingPolicy(scalingPolicy)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ScalingPolicy response = scalingPoliciesServiceClient.updateScalingPolicyAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ScalingPolicy, Empty> updateScalingPolicyAsync(
      UpdateScalingPolicyRequest request) {
    return updateScalingPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single scaling policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   ScalingPolicy scalingPolicy = ScalingPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateScalingPolicyRequest request = UpdateScalingPolicyRequest.newBuilder()
   *     .setScalingPolicy(scalingPolicy)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   OperationFuture&lt;ScalingPolicy, Empty&gt; future = scalingPoliciesServiceClient.updateScalingPolicyOperationCallable().futureCall(request);
   *   // Do something
   *   ScalingPolicy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<UpdateScalingPolicyRequest, ScalingPolicy, Empty>
      updateScalingPolicyOperationCallable() {
    return stub.updateScalingPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches a single scaling policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
   *   ScalingPolicy scalingPolicy = ScalingPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateScalingPolicyRequest request = UpdateScalingPolicyRequest.newBuilder()
   *     .setScalingPolicy(scalingPolicy)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = scalingPoliciesServiceClient.updateScalingPolicyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateScalingPolicyRequest, Operation> updateScalingPolicyCallable() {
    return stub.updateScalingPolicyCallable();
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

  public static class ListScalingPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListScalingPoliciesRequest,
          ListScalingPoliciesResponse,
          ScalingPolicy,
          ListScalingPoliciesPage,
          ListScalingPoliciesFixedSizeCollection> {

    public static ApiFuture<ListScalingPoliciesPagedResponse> createAsync(
        PageContext<ListScalingPoliciesRequest, ListScalingPoliciesResponse, ScalingPolicy> context,
        ApiFuture<ListScalingPoliciesResponse> futureResponse) {
      ApiFuture<ListScalingPoliciesPage> futurePage =
          ListScalingPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListScalingPoliciesPage, ListScalingPoliciesPagedResponse>() {
            @Override
            public ListScalingPoliciesPagedResponse apply(ListScalingPoliciesPage input) {
              return new ListScalingPoliciesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListScalingPoliciesPagedResponse(ListScalingPoliciesPage page) {
      super(page, ListScalingPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListScalingPoliciesPage
      extends AbstractPage<
          ListScalingPoliciesRequest,
          ListScalingPoliciesResponse,
          ScalingPolicy,
          ListScalingPoliciesPage> {

    private ListScalingPoliciesPage(
        PageContext<ListScalingPoliciesRequest, ListScalingPoliciesResponse, ScalingPolicy> context,
        ListScalingPoliciesResponse response) {
      super(context, response);
    }

    private static ListScalingPoliciesPage createEmptyPage() {
      return new ListScalingPoliciesPage(null, null);
    }

    @Override
    protected ListScalingPoliciesPage createPage(
        PageContext<ListScalingPoliciesRequest, ListScalingPoliciesResponse, ScalingPolicy> context,
        ListScalingPoliciesResponse response) {
      return new ListScalingPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListScalingPoliciesPage> createPageAsync(
        PageContext<ListScalingPoliciesRequest, ListScalingPoliciesResponse, ScalingPolicy> context,
        ApiFuture<ListScalingPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListScalingPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListScalingPoliciesRequest,
          ListScalingPoliciesResponse,
          ScalingPolicy,
          ListScalingPoliciesPage,
          ListScalingPoliciesFixedSizeCollection> {

    private ListScalingPoliciesFixedSizeCollection(
        List<ListScalingPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListScalingPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListScalingPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListScalingPoliciesFixedSizeCollection createCollection(
        List<ListScalingPoliciesPage> pages, int collectionSize) {
      return new ListScalingPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }
}
