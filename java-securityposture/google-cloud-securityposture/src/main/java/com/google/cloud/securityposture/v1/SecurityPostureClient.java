/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.securityposture.v1;

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
import com.google.cloud.securityposture.v1.stub.SecurityPostureStub;
import com.google.cloud.securityposture.v1.stub.SecurityPostureStubSettings;
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
 * Service Description: Service describing handlers for resources.
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
 * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
 *   PostureName name = PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]");
 *   Posture response = securityPostureClient.getPosture(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SecurityPostureClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListPostures</td>
 *      <td><p> (-- This option restricts the visibility of the API to only projects that will (-- be labeled as `PREVIEW` or `GOOGLE_INTERNAL` by the service. (-- option (google.api.api_visibility).restriction = "PREVIEW,GOOGLE_INTERNAL"; Postures Lists Postures in a given organization and location. In case a posture has multiple revisions, the latest revision as per UpdateTime will be returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPostures(ListPosturesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPostures(OrganizationName parent)
 *           <li><p> listPostures(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPosturesPagedCallable()
 *           <li><p> listPosturesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPostureRevisions</td>
 *      <td><p> Lists revisions of a Posture in a given organization and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPostureRevisions(ListPostureRevisionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPostureRevisionsPagedCallable()
 *           <li><p> listPostureRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPosture</td>
 *      <td><p> Gets a posture in a given organization and location. User must provide revision_id to retrieve a specific revision of the resource. NOT_FOUND error is returned if the revision_id or the Posture name does not exist. In case revision_id is not provided then the latest Posture revision by UpdateTime is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPosture(GetPostureRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPosture(PostureName name)
 *           <li><p> getPosture(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPostureCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePosture</td>
 *      <td><p> Creates a new Posture resource. If a Posture with the specified name already exists in the specified organization and location, the long running operation returns a [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPostureAsync(CreatePostureRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createPostureAsync(OrganizationName parent, Posture posture, String postureId)
 *           <li><p> createPostureAsync(String parent, Posture posture, String postureId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPostureOperationCallable()
 *           <li><p> createPostureCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePosture</td>
 *      <td><p> Updates an existing Posture. A new revision of the posture will be created if the revision to be updated is currently deployed on a workload. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the Posture does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag of the Posture. Updatable fields are state, description and policy_sets. State update operation cannot be clubbed with update of description and policy_sets. An ACTIVE posture can be updated to both DRAFT or DEPRECATED states. Postures in DRAFT or DEPRECATED states can only be updated to ACTIVE state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePostureAsync(UpdatePostureRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updatePostureAsync(Posture posture, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePostureOperationCallable()
 *           <li><p> updatePostureCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePosture</td>
 *      <td><p> Deletes all the revisions of a resource. A posture can only be deleted when none of the revisions are deployed to any workload.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePostureAsync(DeletePostureRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePostureAsync(PostureName name)
 *           <li><p> deletePostureAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePostureOperationCallable()
 *           <li><p> deletePostureCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExtractPosture</td>
 *      <td><p> Extracts existing policies on a workload as a posture. If a Posture on the given workload already exists, the long running operation returns a [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> extractPostureAsync(ExtractPostureRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> extractPostureAsync(OrganizationName parent, String postureId, String workload)
 *           <li><p> extractPostureAsync(String parent, String postureId, String workload)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> extractPostureOperationCallable()
 *           <li><p> extractPostureCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPostureDeployments</td>
 *      <td><p> PostureDeployments Lists PostureDeployments in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPostureDeployments(ListPostureDeploymentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPostureDeployments(OrganizationName parent)
 *           <li><p> listPostureDeployments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPostureDeploymentsPagedCallable()
 *           <li><p> listPostureDeploymentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPostureDeployment</td>
 *      <td><p> Gets details of a single PostureDeployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPostureDeployment(GetPostureDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPostureDeployment(PostureDeploymentName name)
 *           <li><p> getPostureDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPostureDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePostureDeployment</td>
 *      <td><p> Creates a new PostureDeployment in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPostureDeploymentAsync(CreatePostureDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createPostureDeploymentAsync(OrganizationName parent, PostureDeployment postureDeployment, String postureDeploymentId)
 *           <li><p> createPostureDeploymentAsync(String parent, PostureDeployment postureDeployment, String postureDeploymentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPostureDeploymentOperationCallable()
 *           <li><p> createPostureDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePostureDeployment</td>
 *      <td><p> Updates the parameters of a single PostureDeployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePostureDeploymentAsync(UpdatePostureDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updatePostureDeploymentAsync(PostureDeployment postureDeployment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePostureDeploymentOperationCallable()
 *           <li><p> updatePostureDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePostureDeployment</td>
 *      <td><p> Deletes a single PostureDeployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePostureDeploymentAsync(DeletePostureDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePostureDeploymentAsync(PostureDeploymentName name)
 *           <li><p> deletePostureDeploymentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePostureDeploymentOperationCallable()
 *           <li><p> deletePostureDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPostureTemplates</td>
 *      <td><p> PostureTemplates Lists all the PostureTemplates available to the user.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPostureTemplates(ListPostureTemplatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPostureTemplates(OrganizationName parent)
 *           <li><p> listPostureTemplates(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPostureTemplatesPagedCallable()
 *           <li><p> listPostureTemplatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPostureTemplate</td>
 *      <td><p> Gets a PostureTemplate. User must provide revision_id to retrieve a specific revision of the resource. NOT_FOUND error is returned if the revision_id or the PostureTemplate name does not exist. In case revision_id is not provided then the PostureTemplate with latest revision_id is returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPostureTemplate(GetPostureTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPostureTemplate(PostureTemplateName name)
 *           <li><p> getPostureTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPostureTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of SecurityPostureSettings to
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
 * SecurityPostureSettings securityPostureSettings =
 *     SecurityPostureSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SecurityPostureClient securityPostureClient =
 *     SecurityPostureClient.create(securityPostureSettings);
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
 * SecurityPostureSettings securityPostureSettings =
 *     SecurityPostureSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SecurityPostureClient securityPostureClient =
 *     SecurityPostureClient.create(securityPostureSettings);
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
 * SecurityPostureSettings securityPostureSettings =
 *     SecurityPostureSettings.newHttpJsonBuilder().build();
 * SecurityPostureClient securityPostureClient =
 *     SecurityPostureClient.create(securityPostureSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SecurityPostureClient implements BackgroundResource {
  private final SecurityPostureSettings settings;
  private final SecurityPostureStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of SecurityPostureClient with default settings. */
  public static final SecurityPostureClient create() throws IOException {
    return create(SecurityPostureSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SecurityPostureClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SecurityPostureClient create(SecurityPostureSettings settings)
      throws IOException {
    return new SecurityPostureClient(settings);
  }

  /**
   * Constructs an instance of SecurityPostureClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SecurityPostureSettings).
   */
  public static final SecurityPostureClient create(SecurityPostureStub stub) {
    return new SecurityPostureClient(stub);
  }

  /**
   * Constructs an instance of SecurityPostureClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SecurityPostureClient(SecurityPostureSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SecurityPostureStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SecurityPostureClient(SecurityPostureStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final SecurityPostureSettings getSettings() {
    return settings;
  }

  public SecurityPostureStub getStub() {
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
   * (-- This option restricts the visibility of the API to only projects that will (-- be labeled
   * as `PREVIEW` or `GOOGLE_INTERNAL` by the service. (-- option
   * (google.api.api_visibility).restriction = "PREVIEW,GOOGLE_INTERNAL"; Postures Lists Postures in
   * a given organization and location. In case a posture has multiple revisions, the latest
   * revision as per UpdateTime will be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (Posture element : securityPostureClient.listPostures(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListPosturesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPosturesPagedResponse listPostures(OrganizationName parent) {
    ListPosturesRequest request =
        ListPosturesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPostures(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * (-- This option restricts the visibility of the API to only projects that will (-- be labeled
   * as `PREVIEW` or `GOOGLE_INTERNAL` by the service. (-- option
   * (google.api.api_visibility).restriction = "PREVIEW,GOOGLE_INTERNAL"; Postures Lists Postures in
   * a given organization and location. In case a posture has multiple revisions, the latest
   * revision as per UpdateTime will be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (Posture element : securityPostureClient.listPostures(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListPosturesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPosturesPagedResponse listPostures(String parent) {
    ListPosturesRequest request = ListPosturesRequest.newBuilder().setParent(parent).build();
    return listPostures(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * (-- This option restricts the visibility of the API to only projects that will (-- be labeled
   * as `PREVIEW` or `GOOGLE_INTERNAL` by the service. (-- option
   * (google.api.api_visibility).restriction = "PREVIEW,GOOGLE_INTERNAL"; Postures Lists Postures in
   * a given organization and location. In case a posture has multiple revisions, the latest
   * revision as per UpdateTime will be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListPosturesRequest request =
   *       ListPosturesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Posture element : securityPostureClient.listPostures(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPosturesPagedResponse listPostures(ListPosturesRequest request) {
    return listPosturesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * (-- This option restricts the visibility of the API to only projects that will (-- be labeled
   * as `PREVIEW` or `GOOGLE_INTERNAL` by the service. (-- option
   * (google.api.api_visibility).restriction = "PREVIEW,GOOGLE_INTERNAL"; Postures Lists Postures in
   * a given organization and location. In case a posture has multiple revisions, the latest
   * revision as per UpdateTime will be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListPosturesRequest request =
   *       ListPosturesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Posture> future =
   *       securityPostureClient.listPosturesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Posture element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPosturesRequest, ListPosturesPagedResponse>
      listPosturesPagedCallable() {
    return stub.listPosturesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * (-- This option restricts the visibility of the API to only projects that will (-- be labeled
   * as `PREVIEW` or `GOOGLE_INTERNAL` by the service. (-- option
   * (google.api.api_visibility).restriction = "PREVIEW,GOOGLE_INTERNAL"; Postures Lists Postures in
   * a given organization and location. In case a posture has multiple revisions, the latest
   * revision as per UpdateTime will be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListPosturesRequest request =
   *       ListPosturesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPosturesResponse response = securityPostureClient.listPosturesCallable().call(request);
   *     for (Posture element : response.getPosturesList()) {
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
  public final UnaryCallable<ListPosturesRequest, ListPosturesResponse> listPosturesCallable() {
    return stub.listPosturesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists revisions of a Posture in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListPostureRevisionsRequest request =
   *       ListPostureRevisionsRequest.newBuilder()
   *           .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Posture element : securityPostureClient.listPostureRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPostureRevisionsPagedResponse listPostureRevisions(
      ListPostureRevisionsRequest request) {
    return listPostureRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists revisions of a Posture in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListPostureRevisionsRequest request =
   *       ListPostureRevisionsRequest.newBuilder()
   *           .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Posture> future =
   *       securityPostureClient.listPostureRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Posture element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPostureRevisionsRequest, ListPostureRevisionsPagedResponse>
      listPostureRevisionsPagedCallable() {
    return stub.listPostureRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists revisions of a Posture in a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListPostureRevisionsRequest request =
   *       ListPostureRevisionsRequest.newBuilder()
   *           .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPostureRevisionsResponse response =
   *         securityPostureClient.listPostureRevisionsCallable().call(request);
   *     for (Posture element : response.getRevisionsList()) {
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
  public final UnaryCallable<ListPostureRevisionsRequest, ListPostureRevisionsResponse>
      listPostureRevisionsCallable() {
    return stub.listPostureRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a posture in a given organization and location. User must provide revision_id to retrieve
   * a specific revision of the resource. NOT_FOUND error is returned if the revision_id or the
   * Posture name does not exist. In case revision_id is not provided then the latest Posture
   * revision by UpdateTime is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   PostureName name = PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]");
   *   Posture response = securityPostureClient.getPosture(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Posture getPosture(PostureName name) {
    GetPostureRequest request =
        GetPostureRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPosture(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a posture in a given organization and location. User must provide revision_id to retrieve
   * a specific revision of the resource. NOT_FOUND error is returned if the revision_id or the
   * Posture name does not exist. In case revision_id is not provided then the latest Posture
   * revision by UpdateTime is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   String name = PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString();
   *   Posture response = securityPostureClient.getPosture(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Posture getPosture(String name) {
    GetPostureRequest request = GetPostureRequest.newBuilder().setName(name).build();
    return getPosture(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a posture in a given organization and location. User must provide revision_id to retrieve
   * a specific revision of the resource. NOT_FOUND error is returned if the revision_id or the
   * Posture name does not exist. In case revision_id is not provided then the latest Posture
   * revision by UpdateTime is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   GetPostureRequest request =
   *       GetPostureRequest.newBuilder()
   *           .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   Posture response = securityPostureClient.getPosture(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Posture getPosture(GetPostureRequest request) {
    return getPostureCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a posture in a given organization and location. User must provide revision_id to retrieve
   * a specific revision of the resource. NOT_FOUND error is returned if the revision_id or the
   * Posture name does not exist. In case revision_id is not provided then the latest Posture
   * revision by UpdateTime is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   GetPostureRequest request =
   *       GetPostureRequest.newBuilder()
   *           .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   ApiFuture<Posture> future = securityPostureClient.getPostureCallable().futureCall(request);
   *   // Do something.
   *   Posture response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPostureRequest, Posture> getPostureCallable() {
    return stub.getPostureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Posture resource. If a Posture with the specified name already exists in the
   * specified organization and location, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
   *   Posture posture = Posture.newBuilder().build();
   *   String postureId = "postureId2023219203";
   *   Posture response = securityPostureClient.createPostureAsync(parent, posture, postureId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param posture Required. The resource being created.
   * @param postureId Required. User provided identifier. It should be unique in scope of an
   *     Organization and location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Posture, OperationMetadata> createPostureAsync(
      OrganizationName parent, Posture posture, String postureId) {
    CreatePostureRequest request =
        CreatePostureRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPosture(posture)
            .setPostureId(postureId)
            .build();
    return createPostureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Posture resource. If a Posture with the specified name already exists in the
   * specified organization and location, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   Posture posture = Posture.newBuilder().build();
   *   String postureId = "postureId2023219203";
   *   Posture response = securityPostureClient.createPostureAsync(parent, posture, postureId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param posture Required. The resource being created.
   * @param postureId Required. User provided identifier. It should be unique in scope of an
   *     Organization and location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Posture, OperationMetadata> createPostureAsync(
      String parent, Posture posture, String postureId) {
    CreatePostureRequest request =
        CreatePostureRequest.newBuilder()
            .setParent(parent)
            .setPosture(posture)
            .setPostureId(postureId)
            .build();
    return createPostureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Posture resource. If a Posture with the specified name already exists in the
   * specified organization and location, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   CreatePostureRequest request =
   *       CreatePostureRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPostureId("postureId2023219203")
   *           .setPosture(Posture.newBuilder().build())
   *           .build();
   *   Posture response = securityPostureClient.createPostureAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Posture, OperationMetadata> createPostureAsync(
      CreatePostureRequest request) {
    return createPostureOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Posture resource. If a Posture with the specified name already exists in the
   * specified organization and location, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   CreatePostureRequest request =
   *       CreatePostureRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPostureId("postureId2023219203")
   *           .setPosture(Posture.newBuilder().build())
   *           .build();
   *   OperationFuture<Posture, OperationMetadata> future =
   *       securityPostureClient.createPostureOperationCallable().futureCall(request);
   *   // Do something.
   *   Posture response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreatePostureRequest, Posture, OperationMetadata>
      createPostureOperationCallable() {
    return stub.createPostureOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Posture resource. If a Posture with the specified name already exists in the
   * specified organization and location, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   CreatePostureRequest request =
   *       CreatePostureRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPostureId("postureId2023219203")
   *           .setPosture(Posture.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       securityPostureClient.createPostureCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePostureRequest, Operation> createPostureCallable() {
    return stub.createPostureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Posture. A new revision of the posture will be created if the revision to
   * be updated is currently deployed on a workload. Returns a `google.rpc.Status` with
   * `google.rpc.Code.NOT_FOUND` if the Posture does not exist. Returns a `google.rpc.Status` with
   * `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag
   * of the Posture. Updatable fields are state, description and policy_sets. State update operation
   * cannot be clubbed with update of description and policy_sets. An ACTIVE posture can be updated
   * to both DRAFT or DEPRECATED states. Postures in DRAFT or DEPRECATED states can only be updated
   * to ACTIVE state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   Posture posture = Posture.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Posture response = securityPostureClient.updatePostureAsync(posture, updateMask).get();
   * }
   * }</pre>
   *
   * @param posture Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Posture resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Posture, OperationMetadata> updatePostureAsync(
      Posture posture, FieldMask updateMask) {
    UpdatePostureRequest request =
        UpdatePostureRequest.newBuilder().setPosture(posture).setUpdateMask(updateMask).build();
    return updatePostureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Posture. A new revision of the posture will be created if the revision to
   * be updated is currently deployed on a workload. Returns a `google.rpc.Status` with
   * `google.rpc.Code.NOT_FOUND` if the Posture does not exist. Returns a `google.rpc.Status` with
   * `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag
   * of the Posture. Updatable fields are state, description and policy_sets. State update operation
   * cannot be clubbed with update of description and policy_sets. An ACTIVE posture can be updated
   * to both DRAFT or DEPRECATED states. Postures in DRAFT or DEPRECATED states can only be updated
   * to ACTIVE state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   UpdatePostureRequest request =
   *       UpdatePostureRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPosture(Posture.newBuilder().build())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   Posture response = securityPostureClient.updatePostureAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Posture, OperationMetadata> updatePostureAsync(
      UpdatePostureRequest request) {
    return updatePostureOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Posture. A new revision of the posture will be created if the revision to
   * be updated is currently deployed on a workload. Returns a `google.rpc.Status` with
   * `google.rpc.Code.NOT_FOUND` if the Posture does not exist. Returns a `google.rpc.Status` with
   * `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag
   * of the Posture. Updatable fields are state, description and policy_sets. State update operation
   * cannot be clubbed with update of description and policy_sets. An ACTIVE posture can be updated
   * to both DRAFT or DEPRECATED states. Postures in DRAFT or DEPRECATED states can only be updated
   * to ACTIVE state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   UpdatePostureRequest request =
   *       UpdatePostureRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPosture(Posture.newBuilder().build())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   OperationFuture<Posture, OperationMetadata> future =
   *       securityPostureClient.updatePostureOperationCallable().futureCall(request);
   *   // Do something.
   *   Posture response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdatePostureRequest, Posture, OperationMetadata>
      updatePostureOperationCallable() {
    return stub.updatePostureOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing Posture. A new revision of the posture will be created if the revision to
   * be updated is currently deployed on a workload. Returns a `google.rpc.Status` with
   * `google.rpc.Code.NOT_FOUND` if the Posture does not exist. Returns a `google.rpc.Status` with
   * `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag
   * of the Posture. Updatable fields are state, description and policy_sets. State update operation
   * cannot be clubbed with update of description and policy_sets. An ACTIVE posture can be updated
   * to both DRAFT or DEPRECATED states. Postures in DRAFT or DEPRECATED states can only be updated
   * to ACTIVE state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   UpdatePostureRequest request =
   *       UpdatePostureRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPosture(Posture.newBuilder().build())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   ApiFuture<Operation> future =
   *       securityPostureClient.updatePostureCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePostureRequest, Operation> updatePostureCallable() {
    return stub.updatePostureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all the revisions of a resource. A posture can only be deleted when none of the
   * revisions are deployed to any workload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   PostureName name = PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]");
   *   securityPostureClient.deletePostureAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePostureAsync(PostureName name) {
    DeletePostureRequest request =
        DeletePostureRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deletePostureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all the revisions of a resource. A posture can only be deleted when none of the
   * revisions are deployed to any workload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   String name = PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString();
   *   securityPostureClient.deletePostureAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePostureAsync(String name) {
    DeletePostureRequest request = DeletePostureRequest.newBuilder().setName(name).build();
    return deletePostureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all the revisions of a resource. A posture can only be deleted when none of the
   * revisions are deployed to any workload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   DeletePostureRequest request =
   *       DeletePostureRequest.newBuilder()
   *           .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   securityPostureClient.deletePostureAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePostureAsync(
      DeletePostureRequest request) {
    return deletePostureOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all the revisions of a resource. A posture can only be deleted when none of the
   * revisions are deployed to any workload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   DeletePostureRequest request =
   *       DeletePostureRequest.newBuilder()
   *           .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       securityPostureClient.deletePostureOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePostureRequest, Empty, OperationMetadata>
      deletePostureOperationCallable() {
    return stub.deletePostureOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all the revisions of a resource. A posture can only be deleted when none of the
   * revisions are deployed to any workload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   DeletePostureRequest request =
   *       DeletePostureRequest.newBuilder()
   *           .setName(PostureName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       securityPostureClient.deletePostureCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePostureRequest, Operation> deletePostureCallable() {
    return stub.deletePostureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Extracts existing policies on a workload as a posture. If a Posture on the given workload
   * already exists, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
   *   String postureId = "postureId2023219203";
   *   String workload = "workload35560311";
   *   Posture response =
   *       securityPostureClient.extractPostureAsync(parent, postureId, workload).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. The format of this value is as follows:
   *     `organizations/{organization}/locations/{location}`
   * @param postureId Required. User provided identifier. It should be unique in scope of an
   *     Organization and location.
   * @param workload Required. Workload from which the policies are to be extracted, it should
   *     belong to the same organization defined in parent. The format of this value varies
   *     depending on the scope of the request: - `folder/folderNumber` - `project/projectNumber` -
   *     `organization/organizationNumber`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Posture, OperationMetadata> extractPostureAsync(
      OrganizationName parent, String postureId, String workload) {
    ExtractPostureRequest request =
        ExtractPostureRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPostureId(postureId)
            .setWorkload(workload)
            .build();
    return extractPostureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Extracts existing policies on a workload as a posture. If a Posture on the given workload
   * already exists, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   String postureId = "postureId2023219203";
   *   String workload = "workload35560311";
   *   Posture response =
   *       securityPostureClient.extractPostureAsync(parent, postureId, workload).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. The format of this value is as follows:
   *     `organizations/{organization}/locations/{location}`
   * @param postureId Required. User provided identifier. It should be unique in scope of an
   *     Organization and location.
   * @param workload Required. Workload from which the policies are to be extracted, it should
   *     belong to the same organization defined in parent. The format of this value varies
   *     depending on the scope of the request: - `folder/folderNumber` - `project/projectNumber` -
   *     `organization/organizationNumber`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Posture, OperationMetadata> extractPostureAsync(
      String parent, String postureId, String workload) {
    ExtractPostureRequest request =
        ExtractPostureRequest.newBuilder()
            .setParent(parent)
            .setPostureId(postureId)
            .setWorkload(workload)
            .build();
    return extractPostureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Extracts existing policies on a workload as a posture. If a Posture on the given workload
   * already exists, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ExtractPostureRequest request =
   *       ExtractPostureRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPostureId("postureId2023219203")
   *           .setWorkload("workload35560311")
   *           .build();
   *   Posture response = securityPostureClient.extractPostureAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Posture, OperationMetadata> extractPostureAsync(
      ExtractPostureRequest request) {
    return extractPostureOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Extracts existing policies on a workload as a posture. If a Posture on the given workload
   * already exists, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ExtractPostureRequest request =
   *       ExtractPostureRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPostureId("postureId2023219203")
   *           .setWorkload("workload35560311")
   *           .build();
   *   OperationFuture<Posture, OperationMetadata> future =
   *       securityPostureClient.extractPostureOperationCallable().futureCall(request);
   *   // Do something.
   *   Posture response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExtractPostureRequest, Posture, OperationMetadata>
      extractPostureOperationCallable() {
    return stub.extractPostureOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Extracts existing policies on a workload as a posture. If a Posture on the given workload
   * already exists, the long running operation returns a
   * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ExtractPostureRequest request =
   *       ExtractPostureRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPostureId("postureId2023219203")
   *           .setWorkload("workload35560311")
   *           .build();
   *   ApiFuture<Operation> future =
   *       securityPostureClient.extractPostureCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExtractPostureRequest, Operation> extractPostureCallable() {
    return stub.extractPostureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PostureDeployments Lists PostureDeployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (PostureDeployment element :
   *       securityPostureClient.listPostureDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListPostureDeploymentsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPostureDeploymentsPagedResponse listPostureDeployments(OrganizationName parent) {
    ListPostureDeploymentsRequest request =
        ListPostureDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPostureDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PostureDeployments Lists PostureDeployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (PostureDeployment element :
   *       securityPostureClient.listPostureDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListPostureDeploymentsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPostureDeploymentsPagedResponse listPostureDeployments(String parent) {
    ListPostureDeploymentsRequest request =
        ListPostureDeploymentsRequest.newBuilder().setParent(parent).build();
    return listPostureDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PostureDeployments Lists PostureDeployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListPostureDeploymentsRequest request =
   *       ListPostureDeploymentsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (PostureDeployment element :
   *       securityPostureClient.listPostureDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPostureDeploymentsPagedResponse listPostureDeployments(
      ListPostureDeploymentsRequest request) {
    return listPostureDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PostureDeployments Lists PostureDeployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListPostureDeploymentsRequest request =
   *       ListPostureDeploymentsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<PostureDeployment> future =
   *       securityPostureClient.listPostureDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PostureDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPostureDeploymentsRequest, ListPostureDeploymentsPagedResponse>
      listPostureDeploymentsPagedCallable() {
    return stub.listPostureDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PostureDeployments Lists PostureDeployments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListPostureDeploymentsRequest request =
   *       ListPostureDeploymentsRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListPostureDeploymentsResponse response =
   *         securityPostureClient.listPostureDeploymentsCallable().call(request);
   *     for (PostureDeployment element : response.getPostureDeploymentsList()) {
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
  public final UnaryCallable<ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>
      listPostureDeploymentsCallable() {
    return stub.listPostureDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PostureDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   PostureDeploymentName name =
   *       PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]");
   *   PostureDeployment response = securityPostureClient.getPostureDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PostureDeployment getPostureDeployment(PostureDeploymentName name) {
    GetPostureDeploymentRequest request =
        GetPostureDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPostureDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PostureDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   String name =
   *       PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
   *           .toString();
   *   PostureDeployment response = securityPostureClient.getPostureDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PostureDeployment getPostureDeployment(String name) {
    GetPostureDeploymentRequest request =
        GetPostureDeploymentRequest.newBuilder().setName(name).build();
    return getPostureDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PostureDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   GetPostureDeploymentRequest request =
   *       GetPostureDeploymentRequest.newBuilder()
   *           .setName(
   *               PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   PostureDeployment response = securityPostureClient.getPostureDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PostureDeployment getPostureDeployment(GetPostureDeploymentRequest request) {
    return getPostureDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PostureDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   GetPostureDeploymentRequest request =
   *       GetPostureDeploymentRequest.newBuilder()
   *           .setName(
   *               PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PostureDeployment> future =
   *       securityPostureClient.getPostureDeploymentCallable().futureCall(request);
   *   // Do something.
   *   PostureDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPostureDeploymentRequest, PostureDeployment>
      getPostureDeploymentCallable() {
    return stub.getPostureDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PostureDeployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
   *   PostureDeployment postureDeployment = PostureDeployment.newBuilder().build();
   *   String postureDeploymentId = "postureDeploymentId1771206568";
   *   PostureDeployment response =
   *       securityPostureClient
   *           .createPostureDeploymentAsync(parent, postureDeployment, postureDeploymentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent. Format: organizations/{org_id}/locations/{location}
   * @param postureDeployment Required. The resource being created.
   * @param postureDeploymentId Required. User provided identifier. It should be unique in scope of
   *     an Organization and location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PostureDeployment, OperationMetadata> createPostureDeploymentAsync(
      OrganizationName parent, PostureDeployment postureDeployment, String postureDeploymentId) {
    CreatePostureDeploymentRequest request =
        CreatePostureDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPostureDeployment(postureDeployment)
            .setPostureDeploymentId(postureDeploymentId)
            .build();
    return createPostureDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PostureDeployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   PostureDeployment postureDeployment = PostureDeployment.newBuilder().build();
   *   String postureDeploymentId = "postureDeploymentId1771206568";
   *   PostureDeployment response =
   *       securityPostureClient
   *           .createPostureDeploymentAsync(parent, postureDeployment, postureDeploymentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent. Format: organizations/{org_id}/locations/{location}
   * @param postureDeployment Required. The resource being created.
   * @param postureDeploymentId Required. User provided identifier. It should be unique in scope of
   *     an Organization and location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PostureDeployment, OperationMetadata> createPostureDeploymentAsync(
      String parent, PostureDeployment postureDeployment, String postureDeploymentId) {
    CreatePostureDeploymentRequest request =
        CreatePostureDeploymentRequest.newBuilder()
            .setParent(parent)
            .setPostureDeployment(postureDeployment)
            .setPostureDeploymentId(postureDeploymentId)
            .build();
    return createPostureDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PostureDeployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   CreatePostureDeploymentRequest request =
   *       CreatePostureDeploymentRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPostureDeploymentId("postureDeploymentId1771206568")
   *           .setPostureDeployment(PostureDeployment.newBuilder().build())
   *           .build();
   *   PostureDeployment response =
   *       securityPostureClient.createPostureDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PostureDeployment, OperationMetadata> createPostureDeploymentAsync(
      CreatePostureDeploymentRequest request) {
    return createPostureDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PostureDeployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   CreatePostureDeploymentRequest request =
   *       CreatePostureDeploymentRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPostureDeploymentId("postureDeploymentId1771206568")
   *           .setPostureDeployment(PostureDeployment.newBuilder().build())
   *           .build();
   *   OperationFuture<PostureDeployment, OperationMetadata> future =
   *       securityPostureClient.createPostureDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   PostureDeployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      createPostureDeploymentOperationCallable() {
    return stub.createPostureDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new PostureDeployment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   CreatePostureDeploymentRequest request =
   *       CreatePostureDeploymentRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPostureDeploymentId("postureDeploymentId1771206568")
   *           .setPostureDeployment(PostureDeployment.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       securityPostureClient.createPostureDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePostureDeploymentRequest, Operation>
      createPostureDeploymentCallable() {
    return stub.createPostureDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single PostureDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   PostureDeployment postureDeployment = PostureDeployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PostureDeployment response =
   *       securityPostureClient.updatePostureDeploymentAsync(postureDeployment, updateMask).get();
   * }
   * }</pre>
   *
   * @param postureDeployment Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     PostureDeployment resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PostureDeployment, OperationMetadata> updatePostureDeploymentAsync(
      PostureDeployment postureDeployment, FieldMask updateMask) {
    UpdatePostureDeploymentRequest request =
        UpdatePostureDeploymentRequest.newBuilder()
            .setPostureDeployment(postureDeployment)
            .setUpdateMask(updateMask)
            .build();
    return updatePostureDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single PostureDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   UpdatePostureDeploymentRequest request =
   *       UpdatePostureDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPostureDeployment(PostureDeployment.newBuilder().build())
   *           .build();
   *   PostureDeployment response =
   *       securityPostureClient.updatePostureDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PostureDeployment, OperationMetadata> updatePostureDeploymentAsync(
      UpdatePostureDeploymentRequest request) {
    return updatePostureDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single PostureDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   UpdatePostureDeploymentRequest request =
   *       UpdatePostureDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPostureDeployment(PostureDeployment.newBuilder().build())
   *           .build();
   *   OperationFuture<PostureDeployment, OperationMetadata> future =
   *       securityPostureClient.updatePostureDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   PostureDeployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      updatePostureDeploymentOperationCallable() {
    return stub.updatePostureDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single PostureDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   UpdatePostureDeploymentRequest request =
   *       UpdatePostureDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPostureDeployment(PostureDeployment.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       securityPostureClient.updatePostureDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePostureDeploymentRequest, Operation>
      updatePostureDeploymentCallable() {
    return stub.updatePostureDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single PostureDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   PostureDeploymentName name =
   *       PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]");
   *   securityPostureClient.deletePostureDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePostureDeploymentAsync(
      PostureDeploymentName name) {
    DeletePostureDeploymentRequest request =
        DeletePostureDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePostureDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single PostureDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   String name =
   *       PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
   *           .toString();
   *   securityPostureClient.deletePostureDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePostureDeploymentAsync(String name) {
    DeletePostureDeploymentRequest request =
        DeletePostureDeploymentRequest.newBuilder().setName(name).build();
    return deletePostureDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single PostureDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   DeletePostureDeploymentRequest request =
   *       DeletePostureDeploymentRequest.newBuilder()
   *           .setName(
   *               PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   securityPostureClient.deletePostureDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deletePostureDeploymentAsync(
      DeletePostureDeploymentRequest request) {
    return deletePostureDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single PostureDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   DeletePostureDeploymentRequest request =
   *       DeletePostureDeploymentRequest.newBuilder()
   *           .setName(
   *               PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       securityPostureClient.deletePostureDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePostureDeploymentRequest, Empty, OperationMetadata>
      deletePostureDeploymentOperationCallable() {
    return stub.deletePostureDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single PostureDeployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   DeletePostureDeploymentRequest request =
   *       DeletePostureDeploymentRequest.newBuilder()
   *           .setName(
   *               PostureDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_DEPLOYMENT]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       securityPostureClient.deletePostureDeploymentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePostureDeploymentRequest, Operation>
      deletePostureDeploymentCallable() {
    return stub.deletePostureDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PostureTemplates Lists all the PostureTemplates available to the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (PostureTemplate element :
   *       securityPostureClient.listPostureTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListPostureTemplatesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPostureTemplatesPagedResponse listPostureTemplates(OrganizationName parent) {
    ListPostureTemplatesRequest request =
        ListPostureTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPostureTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PostureTemplates Lists all the PostureTemplates available to the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (PostureTemplate element :
   *       securityPostureClient.listPostureTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListPostureTemplatesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPostureTemplatesPagedResponse listPostureTemplates(String parent) {
    ListPostureTemplatesRequest request =
        ListPostureTemplatesRequest.newBuilder().setParent(parent).build();
    return listPostureTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PostureTemplates Lists all the PostureTemplates available to the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListPostureTemplatesRequest request =
   *       ListPostureTemplatesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (PostureTemplate element :
   *       securityPostureClient.listPostureTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPostureTemplatesPagedResponse listPostureTemplates(
      ListPostureTemplatesRequest request) {
    return listPostureTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PostureTemplates Lists all the PostureTemplates available to the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListPostureTemplatesRequest request =
   *       ListPostureTemplatesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<PostureTemplate> future =
   *       securityPostureClient.listPostureTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PostureTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPostureTemplatesRequest, ListPostureTemplatesPagedResponse>
      listPostureTemplatesPagedCallable() {
    return stub.listPostureTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PostureTemplates Lists all the PostureTemplates available to the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListPostureTemplatesRequest request =
   *       ListPostureTemplatesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListPostureTemplatesResponse response =
   *         securityPostureClient.listPostureTemplatesCallable().call(request);
   *     for (PostureTemplate element : response.getPostureTemplatesList()) {
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
  public final UnaryCallable<ListPostureTemplatesRequest, ListPostureTemplatesResponse>
      listPostureTemplatesCallable() {
    return stub.listPostureTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PostureTemplate. User must provide revision_id to retrieve a specific revision of the
   * resource. NOT_FOUND error is returned if the revision_id or the PostureTemplate name does not
   * exist. In case revision_id is not provided then the PostureTemplate with latest revision_id is
   * returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   PostureTemplateName name =
   *       PostureTemplateName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_TEMPLATE]");
   *   PostureTemplate response = securityPostureClient.getPostureTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PostureTemplate getPostureTemplate(PostureTemplateName name) {
    GetPostureTemplateRequest request =
        GetPostureTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPostureTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PostureTemplate. User must provide revision_id to retrieve a specific revision of the
   * resource. NOT_FOUND error is returned if the revision_id or the PostureTemplate name does not
   * exist. In case revision_id is not provided then the PostureTemplate with latest revision_id is
   * returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   String name =
   *       PostureTemplateName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_TEMPLATE]").toString();
   *   PostureTemplate response = securityPostureClient.getPostureTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PostureTemplate getPostureTemplate(String name) {
    GetPostureTemplateRequest request =
        GetPostureTemplateRequest.newBuilder().setName(name).build();
    return getPostureTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PostureTemplate. User must provide revision_id to retrieve a specific revision of the
   * resource. NOT_FOUND error is returned if the revision_id or the PostureTemplate name does not
   * exist. In case revision_id is not provided then the PostureTemplate with latest revision_id is
   * returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   GetPostureTemplateRequest request =
   *       GetPostureTemplateRequest.newBuilder()
   *           .setName(
   *               PostureTemplateName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_TEMPLATE]")
   *                   .toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   PostureTemplate response = securityPostureClient.getPostureTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PostureTemplate getPostureTemplate(GetPostureTemplateRequest request) {
    return getPostureTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PostureTemplate. User must provide revision_id to retrieve a specific revision of the
   * resource. NOT_FOUND error is returned if the revision_id or the PostureTemplate name does not
   * exist. In case revision_id is not provided then the PostureTemplate with latest revision_id is
   * returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   GetPostureTemplateRequest request =
   *       GetPostureTemplateRequest.newBuilder()
   *           .setName(
   *               PostureTemplateName.of("[ORGANIZATION]", "[LOCATION]", "[POSTURE_TEMPLATE]")
   *                   .toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   ApiFuture<PostureTemplate> future =
   *       securityPostureClient.getPostureTemplateCallable().futureCall(request);
   *   // Do something.
   *   PostureTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPostureTemplateRequest, PostureTemplate>
      getPostureTemplateCallable() {
    return stub.getPostureTemplateCallable();
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
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : securityPostureClient.listLocations(request).iterateAll()) {
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
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       securityPostureClient.listLocationsPagedCallable().futureCall(request);
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
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         securityPostureClient.listLocationsCallable().call(request);
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
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = securityPostureClient.getLocation(request);
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
   * try (SecurityPostureClient securityPostureClient = SecurityPostureClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = securityPostureClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListPosturesPagedResponse
      extends AbstractPagedListResponse<
          ListPosturesRequest,
          ListPosturesResponse,
          Posture,
          ListPosturesPage,
          ListPosturesFixedSizeCollection> {

    public static ApiFuture<ListPosturesPagedResponse> createAsync(
        PageContext<ListPosturesRequest, ListPosturesResponse, Posture> context,
        ApiFuture<ListPosturesResponse> futureResponse) {
      ApiFuture<ListPosturesPage> futurePage =
          ListPosturesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPosturesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPosturesPagedResponse(ListPosturesPage page) {
      super(page, ListPosturesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPosturesPage
      extends AbstractPage<ListPosturesRequest, ListPosturesResponse, Posture, ListPosturesPage> {

    private ListPosturesPage(
        PageContext<ListPosturesRequest, ListPosturesResponse, Posture> context,
        ListPosturesResponse response) {
      super(context, response);
    }

    private static ListPosturesPage createEmptyPage() {
      return new ListPosturesPage(null, null);
    }

    @Override
    protected ListPosturesPage createPage(
        PageContext<ListPosturesRequest, ListPosturesResponse, Posture> context,
        ListPosturesResponse response) {
      return new ListPosturesPage(context, response);
    }

    @Override
    public ApiFuture<ListPosturesPage> createPageAsync(
        PageContext<ListPosturesRequest, ListPosturesResponse, Posture> context,
        ApiFuture<ListPosturesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPosturesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPosturesRequest,
          ListPosturesResponse,
          Posture,
          ListPosturesPage,
          ListPosturesFixedSizeCollection> {

    private ListPosturesFixedSizeCollection(List<ListPosturesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPosturesFixedSizeCollection createEmptyCollection() {
      return new ListPosturesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPosturesFixedSizeCollection createCollection(
        List<ListPosturesPage> pages, int collectionSize) {
      return new ListPosturesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPostureRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListPostureRevisionsRequest,
          ListPostureRevisionsResponse,
          Posture,
          ListPostureRevisionsPage,
          ListPostureRevisionsFixedSizeCollection> {

    public static ApiFuture<ListPostureRevisionsPagedResponse> createAsync(
        PageContext<ListPostureRevisionsRequest, ListPostureRevisionsResponse, Posture> context,
        ApiFuture<ListPostureRevisionsResponse> futureResponse) {
      ApiFuture<ListPostureRevisionsPage> futurePage =
          ListPostureRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPostureRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPostureRevisionsPagedResponse(ListPostureRevisionsPage page) {
      super(page, ListPostureRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPostureRevisionsPage
      extends AbstractPage<
          ListPostureRevisionsRequest,
          ListPostureRevisionsResponse,
          Posture,
          ListPostureRevisionsPage> {

    private ListPostureRevisionsPage(
        PageContext<ListPostureRevisionsRequest, ListPostureRevisionsResponse, Posture> context,
        ListPostureRevisionsResponse response) {
      super(context, response);
    }

    private static ListPostureRevisionsPage createEmptyPage() {
      return new ListPostureRevisionsPage(null, null);
    }

    @Override
    protected ListPostureRevisionsPage createPage(
        PageContext<ListPostureRevisionsRequest, ListPostureRevisionsResponse, Posture> context,
        ListPostureRevisionsResponse response) {
      return new ListPostureRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListPostureRevisionsPage> createPageAsync(
        PageContext<ListPostureRevisionsRequest, ListPostureRevisionsResponse, Posture> context,
        ApiFuture<ListPostureRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPostureRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPostureRevisionsRequest,
          ListPostureRevisionsResponse,
          Posture,
          ListPostureRevisionsPage,
          ListPostureRevisionsFixedSizeCollection> {

    private ListPostureRevisionsFixedSizeCollection(
        List<ListPostureRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPostureRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListPostureRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPostureRevisionsFixedSizeCollection createCollection(
        List<ListPostureRevisionsPage> pages, int collectionSize) {
      return new ListPostureRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPostureDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListPostureDeploymentsRequest,
          ListPostureDeploymentsResponse,
          PostureDeployment,
          ListPostureDeploymentsPage,
          ListPostureDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListPostureDeploymentsPagedResponse> createAsync(
        PageContext<
                ListPostureDeploymentsRequest, ListPostureDeploymentsResponse, PostureDeployment>
            context,
        ApiFuture<ListPostureDeploymentsResponse> futureResponse) {
      ApiFuture<ListPostureDeploymentsPage> futurePage =
          ListPostureDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPostureDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPostureDeploymentsPagedResponse(ListPostureDeploymentsPage page) {
      super(page, ListPostureDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPostureDeploymentsPage
      extends AbstractPage<
          ListPostureDeploymentsRequest,
          ListPostureDeploymentsResponse,
          PostureDeployment,
          ListPostureDeploymentsPage> {

    private ListPostureDeploymentsPage(
        PageContext<
                ListPostureDeploymentsRequest, ListPostureDeploymentsResponse, PostureDeployment>
            context,
        ListPostureDeploymentsResponse response) {
      super(context, response);
    }

    private static ListPostureDeploymentsPage createEmptyPage() {
      return new ListPostureDeploymentsPage(null, null);
    }

    @Override
    protected ListPostureDeploymentsPage createPage(
        PageContext<
                ListPostureDeploymentsRequest, ListPostureDeploymentsResponse, PostureDeployment>
            context,
        ListPostureDeploymentsResponse response) {
      return new ListPostureDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListPostureDeploymentsPage> createPageAsync(
        PageContext<
                ListPostureDeploymentsRequest, ListPostureDeploymentsResponse, PostureDeployment>
            context,
        ApiFuture<ListPostureDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPostureDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPostureDeploymentsRequest,
          ListPostureDeploymentsResponse,
          PostureDeployment,
          ListPostureDeploymentsPage,
          ListPostureDeploymentsFixedSizeCollection> {

    private ListPostureDeploymentsFixedSizeCollection(
        List<ListPostureDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPostureDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListPostureDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPostureDeploymentsFixedSizeCollection createCollection(
        List<ListPostureDeploymentsPage> pages, int collectionSize) {
      return new ListPostureDeploymentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPostureTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListPostureTemplatesRequest,
          ListPostureTemplatesResponse,
          PostureTemplate,
          ListPostureTemplatesPage,
          ListPostureTemplatesFixedSizeCollection> {

    public static ApiFuture<ListPostureTemplatesPagedResponse> createAsync(
        PageContext<ListPostureTemplatesRequest, ListPostureTemplatesResponse, PostureTemplate>
            context,
        ApiFuture<ListPostureTemplatesResponse> futureResponse) {
      ApiFuture<ListPostureTemplatesPage> futurePage =
          ListPostureTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPostureTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPostureTemplatesPagedResponse(ListPostureTemplatesPage page) {
      super(page, ListPostureTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPostureTemplatesPage
      extends AbstractPage<
          ListPostureTemplatesRequest,
          ListPostureTemplatesResponse,
          PostureTemplate,
          ListPostureTemplatesPage> {

    private ListPostureTemplatesPage(
        PageContext<ListPostureTemplatesRequest, ListPostureTemplatesResponse, PostureTemplate>
            context,
        ListPostureTemplatesResponse response) {
      super(context, response);
    }

    private static ListPostureTemplatesPage createEmptyPage() {
      return new ListPostureTemplatesPage(null, null);
    }

    @Override
    protected ListPostureTemplatesPage createPage(
        PageContext<ListPostureTemplatesRequest, ListPostureTemplatesResponse, PostureTemplate>
            context,
        ListPostureTemplatesResponse response) {
      return new ListPostureTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListPostureTemplatesPage> createPageAsync(
        PageContext<ListPostureTemplatesRequest, ListPostureTemplatesResponse, PostureTemplate>
            context,
        ApiFuture<ListPostureTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPostureTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPostureTemplatesRequest,
          ListPostureTemplatesResponse,
          PostureTemplate,
          ListPostureTemplatesPage,
          ListPostureTemplatesFixedSizeCollection> {

    private ListPostureTemplatesFixedSizeCollection(
        List<ListPostureTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPostureTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListPostureTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPostureTemplatesFixedSizeCollection createCollection(
        List<ListPostureTemplatesPage> pages, int collectionSize) {
      return new ListPostureTemplatesFixedSizeCollection(pages, collectionSize);
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
