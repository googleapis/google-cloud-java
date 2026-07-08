/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.chronicle.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.stub.FindingsRefinementServiceStub;
import com.google.cloud.chronicle.v1.stub.FindingsRefinementServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: FindingsRefinementService provides an interface for filtering out findings
 * that are unlikely to be real threats to prevent them from triggering alerts or notifications.
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
 * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
 *     FindingsRefinementServiceClient.create()) {
 *   FindingsRefinementName name =
 *       FindingsRefinementName.of(
 *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");
 *   FindingsRefinement response = findingsRefinementServiceClient.getFindingsRefinement(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FindingsRefinementServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetFindingsRefinement</td>
 *      <td><p> Gets a single findings refinement.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFindingsRefinement(GetFindingsRefinementRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFindingsRefinement(FindingsRefinementName name)
 *           <li><p> getFindingsRefinement(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFindingsRefinementCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFindingsRefinements</td>
 *      <td><p> Lists a collection of findings refinements.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFindingsRefinements(ListFindingsRefinementsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFindingsRefinements(InstanceName parent)
 *           <li><p> listFindingsRefinements(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFindingsRefinementsPagedCallable()
 *           <li><p> listFindingsRefinementsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateFindingsRefinement</td>
 *      <td><p> Creates a new findings refinement.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFindingsRefinement(CreateFindingsRefinementRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createFindingsRefinement(InstanceName parent, FindingsRefinement findingsRefinement)
 *           <li><p> createFindingsRefinement(String parent, FindingsRefinement findingsRefinement)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createFindingsRefinementCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFindingsRefinement</td>
 *      <td><p> Updates a findings refinement.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFindingsRefinement(UpdateFindingsRefinementRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateFindingsRefinement(FindingsRefinement findingsRefinement, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFindingsRefinementCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFindingsRefinementDeployment</td>
 *      <td><p> Gets a findings refinement deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFindingsRefinementDeployment(GetFindingsRefinementDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFindingsRefinementDeployment(FindingsRefinementDeploymentName name)
 *           <li><p> getFindingsRefinementDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFindingsRefinementDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFindingsRefinementDeployment</td>
 *      <td><p> Updates a findings refinement deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFindingsRefinementDeployment(UpdateFindingsRefinementDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateFindingsRefinementDeployment(FindingsRefinementDeployment findingsRefinementDeployment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFindingsRefinementDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAllFindingsRefinementDeployments</td>
 *      <td><p> Lists all findings refinement deployments.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAllFindingsRefinementDeployments(ListAllFindingsRefinementDeploymentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAllFindingsRefinementDeployments(InstanceName instance)
 *           <li><p> listAllFindingsRefinementDeployments(String instance)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAllFindingsRefinementDeploymentsPagedCallable()
 *           <li><p> listAllFindingsRefinementDeploymentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ComputeFindingsRefinementActivity</td>
 *      <td><p> Returns findings refinement activity for a specific findings refinement.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> computeFindingsRefinementActivity(ComputeFindingsRefinementActivityRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> computeFindingsRefinementActivity(FindingsRefinementName name)
 *           <li><p> computeFindingsRefinementActivity(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> computeFindingsRefinementActivityCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ComputeAllFindingsRefinementActivities</td>
 *      <td><p> Returns findings refinement activity for all findings refinements.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> computeAllFindingsRefinementActivities(ComputeAllFindingsRefinementActivitiesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> computeAllFindingsRefinementActivities(InstanceName instance)
 *           <li><p> computeAllFindingsRefinementActivities(String instance)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> computeAllFindingsRefinementActivitiesCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * FindingsRefinementServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FindingsRefinementServiceSettings findingsRefinementServiceSettings =
 *     FindingsRefinementServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FindingsRefinementServiceClient findingsRefinementServiceClient =
 *     FindingsRefinementServiceClient.create(findingsRefinementServiceSettings);
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
 * FindingsRefinementServiceSettings findingsRefinementServiceSettings =
 *     FindingsRefinementServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FindingsRefinementServiceClient findingsRefinementServiceClient =
 *     FindingsRefinementServiceClient.create(findingsRefinementServiceSettings);
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
 * FindingsRefinementServiceSettings findingsRefinementServiceSettings =
 *     FindingsRefinementServiceSettings.newHttpJsonBuilder().build();
 * FindingsRefinementServiceClient findingsRefinementServiceClient =
 *     FindingsRefinementServiceClient.create(findingsRefinementServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class FindingsRefinementServiceClient implements BackgroundResource {
  private final FindingsRefinementServiceSettings settings;
  private final FindingsRefinementServiceStub stub;

  /** Constructs an instance of FindingsRefinementServiceClient with default settings. */
  public static final FindingsRefinementServiceClient create() throws IOException {
    return create(FindingsRefinementServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FindingsRefinementServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final FindingsRefinementServiceClient create(
      FindingsRefinementServiceSettings settings) throws IOException {
    return new FindingsRefinementServiceClient(settings);
  }

  /**
   * Constructs an instance of FindingsRefinementServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(FindingsRefinementServiceSettings).
   */
  public static final FindingsRefinementServiceClient create(FindingsRefinementServiceStub stub) {
    return new FindingsRefinementServiceClient(stub);
  }

  /**
   * Constructs an instance of FindingsRefinementServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected FindingsRefinementServiceClient(FindingsRefinementServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((FindingsRefinementServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected FindingsRefinementServiceClient(FindingsRefinementServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FindingsRefinementServiceSettings getSettings() {
    return settings;
  }

  public FindingsRefinementServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   FindingsRefinementName name =
   *       FindingsRefinementName.of(
   *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");
   *   FindingsRefinement response = findingsRefinementServiceClient.getFindingsRefinement(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the findings refinement to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/findingsRefinements/{findings_refinement}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindingsRefinement getFindingsRefinement(FindingsRefinementName name) {
    GetFindingsRefinementRequest request =
        GetFindingsRefinementRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getFindingsRefinement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   String name =
   *       FindingsRefinementName.of(
   *               "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
   *           .toString();
   *   FindingsRefinement response = findingsRefinementServiceClient.getFindingsRefinement(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the findings refinement to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/findingsRefinements/{findings_refinement}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindingsRefinement getFindingsRefinement(String name) {
    GetFindingsRefinementRequest request =
        GetFindingsRefinementRequest.newBuilder().setName(name).build();
    return getFindingsRefinement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   GetFindingsRefinementRequest request =
   *       GetFindingsRefinementRequest.newBuilder()
   *           .setName(
   *               FindingsRefinementName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
   *                   .toString())
   *           .build();
   *   FindingsRefinement response = findingsRefinementServiceClient.getFindingsRefinement(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindingsRefinement getFindingsRefinement(GetFindingsRefinementRequest request) {
    return getFindingsRefinementCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   GetFindingsRefinementRequest request =
   *       GetFindingsRefinementRequest.newBuilder()
   *           .setName(
   *               FindingsRefinementName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FindingsRefinement> future =
   *       findingsRefinementServiceClient.getFindingsRefinementCallable().futureCall(request);
   *   // Do something.
   *   FindingsRefinement response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFindingsRefinementRequest, FindingsRefinement>
      getFindingsRefinementCallable() {
    return stub.getFindingsRefinementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a collection of findings refinements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (FindingsRefinement element :
   *       findingsRefinementServiceClient.listFindingsRefinements(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of findings refinements. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingsRefinementsPagedResponse listFindingsRefinements(InstanceName parent) {
    ListFindingsRefinementsRequest request =
        ListFindingsRefinementsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFindingsRefinements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a collection of findings refinements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (FindingsRefinement element :
   *       findingsRefinementServiceClient.listFindingsRefinements(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of findings refinements. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingsRefinementsPagedResponse listFindingsRefinements(String parent) {
    ListFindingsRefinementsRequest request =
        ListFindingsRefinementsRequest.newBuilder().setParent(parent).build();
    return listFindingsRefinements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a collection of findings refinements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   ListFindingsRefinementsRequest request =
   *       ListFindingsRefinementsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (FindingsRefinement element :
   *       findingsRefinementServiceClient.listFindingsRefinements(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingsRefinementsPagedResponse listFindingsRefinements(
      ListFindingsRefinementsRequest request) {
    return listFindingsRefinementsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a collection of findings refinements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   ListFindingsRefinementsRequest request =
   *       ListFindingsRefinementsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<FindingsRefinement> future =
   *       findingsRefinementServiceClient
   *           .listFindingsRefinementsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (FindingsRefinement element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFindingsRefinementsRequest, ListFindingsRefinementsPagedResponse>
      listFindingsRefinementsPagedCallable() {
    return stub.listFindingsRefinementsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a collection of findings refinements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   ListFindingsRefinementsRequest request =
   *       ListFindingsRefinementsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListFindingsRefinementsResponse response =
   *         findingsRefinementServiceClient.listFindingsRefinementsCallable().call(request);
   *     for (FindingsRefinement element : response.getFindingsRefinementsList()) {
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
  public final UnaryCallable<ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>
      listFindingsRefinementsCallable() {
    return stub.listFindingsRefinementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   FindingsRefinement findingsRefinement = FindingsRefinement.newBuilder().build();
   *   FindingsRefinement response =
   *       findingsRefinementServiceClient.createFindingsRefinement(parent, findingsRefinement);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this findings refinement will be created.
   *     Format: projects/{project}/locations/{location}/instances/{instance}
   * @param findingsRefinement Required. The findings refinement to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindingsRefinement createFindingsRefinement(
      InstanceName parent, FindingsRefinement findingsRefinement) {
    CreateFindingsRefinementRequest request =
        CreateFindingsRefinementRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFindingsRefinement(findingsRefinement)
            .build();
    return createFindingsRefinement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   FindingsRefinement findingsRefinement = FindingsRefinement.newBuilder().build();
   *   FindingsRefinement response =
   *       findingsRefinementServiceClient.createFindingsRefinement(parent, findingsRefinement);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this findings refinement will be created.
   *     Format: projects/{project}/locations/{location}/instances/{instance}
   * @param findingsRefinement Required. The findings refinement to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindingsRefinement createFindingsRefinement(
      String parent, FindingsRefinement findingsRefinement) {
    CreateFindingsRefinementRequest request =
        CreateFindingsRefinementRequest.newBuilder()
            .setParent(parent)
            .setFindingsRefinement(findingsRefinement)
            .build();
    return createFindingsRefinement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   CreateFindingsRefinementRequest request =
   *       CreateFindingsRefinementRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setFindingsRefinement(FindingsRefinement.newBuilder().build())
   *           .build();
   *   FindingsRefinement response =
   *       findingsRefinementServiceClient.createFindingsRefinement(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindingsRefinement createFindingsRefinement(
      CreateFindingsRefinementRequest request) {
    return createFindingsRefinementCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   CreateFindingsRefinementRequest request =
   *       CreateFindingsRefinementRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setFindingsRefinement(FindingsRefinement.newBuilder().build())
   *           .build();
   *   ApiFuture<FindingsRefinement> future =
   *       findingsRefinementServiceClient.createFindingsRefinementCallable().futureCall(request);
   *   // Do something.
   *   FindingsRefinement response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFindingsRefinementRequest, FindingsRefinement>
      createFindingsRefinementCallable() {
    return stub.createFindingsRefinementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   FindingsRefinement findingsRefinement = FindingsRefinement.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   FindingsRefinement response =
   *       findingsRefinementServiceClient.updateFindingsRefinement(findingsRefinement, updateMask);
   * }
   * }</pre>
   *
   * @param findingsRefinement Required. The findings refinement to update.
   *     <p>The findings refinement's `name` field is used to identify the findings refinement to
   *     update. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/findingsRefinements/{findings_refinement}
   * @param updateMask Optional. The list of fields to update. If `&#42;` is provided, all fields
   *     will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindingsRefinement updateFindingsRefinement(
      FindingsRefinement findingsRefinement, FieldMask updateMask) {
    UpdateFindingsRefinementRequest request =
        UpdateFindingsRefinementRequest.newBuilder()
            .setFindingsRefinement(findingsRefinement)
            .setUpdateMask(updateMask)
            .build();
    return updateFindingsRefinement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   UpdateFindingsRefinementRequest request =
   *       UpdateFindingsRefinementRequest.newBuilder()
   *           .setFindingsRefinement(FindingsRefinement.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   FindingsRefinement response =
   *       findingsRefinementServiceClient.updateFindingsRefinement(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindingsRefinement updateFindingsRefinement(
      UpdateFindingsRefinementRequest request) {
    return updateFindingsRefinementCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   UpdateFindingsRefinementRequest request =
   *       UpdateFindingsRefinementRequest.newBuilder()
   *           .setFindingsRefinement(FindingsRefinement.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<FindingsRefinement> future =
   *       findingsRefinementServiceClient.updateFindingsRefinementCallable().futureCall(request);
   *   // Do something.
   *   FindingsRefinement response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFindingsRefinementRequest, FindingsRefinement>
      updateFindingsRefinementCallable() {
    return stub.updateFindingsRefinementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a findings refinement deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   FindingsRefinementDeploymentName name =
   *       FindingsRefinementDeploymentName.of(
   *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");
   *   FindingsRefinementDeployment response =
   *       findingsRefinementServiceClient.getFindingsRefinementDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the findings refinement to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/findingsRefinements/{findings_refinement}/deployment
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindingsRefinementDeployment getFindingsRefinementDeployment(
      FindingsRefinementDeploymentName name) {
    GetFindingsRefinementDeploymentRequest request =
        GetFindingsRefinementDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getFindingsRefinementDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a findings refinement deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   String name =
   *       FindingsRefinementDeploymentName.of(
   *               "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
   *           .toString();
   *   FindingsRefinementDeployment response =
   *       findingsRefinementServiceClient.getFindingsRefinementDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the findings refinement to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/findingsRefinements/{findings_refinement}/deployment
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindingsRefinementDeployment getFindingsRefinementDeployment(String name) {
    GetFindingsRefinementDeploymentRequest request =
        GetFindingsRefinementDeploymentRequest.newBuilder().setName(name).build();
    return getFindingsRefinementDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a findings refinement deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   GetFindingsRefinementDeploymentRequest request =
   *       GetFindingsRefinementDeploymentRequest.newBuilder()
   *           .setName(
   *               FindingsRefinementDeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
   *                   .toString())
   *           .build();
   *   FindingsRefinementDeployment response =
   *       findingsRefinementServiceClient.getFindingsRefinementDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindingsRefinementDeployment getFindingsRefinementDeployment(
      GetFindingsRefinementDeploymentRequest request) {
    return getFindingsRefinementDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a findings refinement deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   GetFindingsRefinementDeploymentRequest request =
   *       GetFindingsRefinementDeploymentRequest.newBuilder()
   *           .setName(
   *               FindingsRefinementDeploymentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FindingsRefinementDeployment> future =
   *       findingsRefinementServiceClient
   *           .getFindingsRefinementDeploymentCallable()
   *           .futureCall(request);
   *   // Do something.
   *   FindingsRefinementDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      getFindingsRefinementDeploymentCallable() {
    return stub.getFindingsRefinementDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a findings refinement deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   FindingsRefinementDeployment findingsRefinementDeployment =
   *       FindingsRefinementDeployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   FindingsRefinementDeployment response =
   *       findingsRefinementServiceClient.updateFindingsRefinementDeployment(
   *           findingsRefinementDeployment, updateMask);
   * }
   * }</pre>
   *
   * @param findingsRefinementDeployment Required. The findings refinement deployment to update.
   *     <p>The findings refinement deployment's `name` field is used to identify the findings
   *     refinement deployment to update. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/findingsRefinements/{findings_refinement}/deployment
   * @param updateMask Required. The list of fields to update. If `&#42;` is provided, all fields
   *     will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindingsRefinementDeployment updateFindingsRefinementDeployment(
      FindingsRefinementDeployment findingsRefinementDeployment, FieldMask updateMask) {
    UpdateFindingsRefinementDeploymentRequest request =
        UpdateFindingsRefinementDeploymentRequest.newBuilder()
            .setFindingsRefinementDeployment(findingsRefinementDeployment)
            .setUpdateMask(updateMask)
            .build();
    return updateFindingsRefinementDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a findings refinement deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   UpdateFindingsRefinementDeploymentRequest request =
   *       UpdateFindingsRefinementDeploymentRequest.newBuilder()
   *           .setFindingsRefinementDeployment(FindingsRefinementDeployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   FindingsRefinementDeployment response =
   *       findingsRefinementServiceClient.updateFindingsRefinementDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindingsRefinementDeployment updateFindingsRefinementDeployment(
      UpdateFindingsRefinementDeploymentRequest request) {
    return updateFindingsRefinementDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a findings refinement deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   UpdateFindingsRefinementDeploymentRequest request =
   *       UpdateFindingsRefinementDeploymentRequest.newBuilder()
   *           .setFindingsRefinementDeployment(FindingsRefinementDeployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<FindingsRefinementDeployment> future =
   *       findingsRefinementServiceClient
   *           .updateFindingsRefinementDeploymentCallable()
   *           .futureCall(request);
   *   // Do something.
   *   FindingsRefinementDeployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      updateFindingsRefinementDeploymentCallable() {
    return stub.updateFindingsRefinementDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all findings refinement deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (FindingsRefinementDeployment element :
   *       findingsRefinementServiceClient
   *           .listAllFindingsRefinementDeployments(instance)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param instance Required. The name of the parent resource, which is the SecOps instance to list
   *     all findings refinement deployments over. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAllFindingsRefinementDeploymentsPagedResponse
      listAllFindingsRefinementDeployments(InstanceName instance) {
    ListAllFindingsRefinementDeploymentsRequest request =
        ListAllFindingsRefinementDeploymentsRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .build();
    return listAllFindingsRefinementDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all findings refinement deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   String instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (FindingsRefinementDeployment element :
   *       findingsRefinementServiceClient
   *           .listAllFindingsRefinementDeployments(instance)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param instance Required. The name of the parent resource, which is the SecOps instance to list
   *     all findings refinement deployments over. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAllFindingsRefinementDeploymentsPagedResponse
      listAllFindingsRefinementDeployments(String instance) {
    ListAllFindingsRefinementDeploymentsRequest request =
        ListAllFindingsRefinementDeploymentsRequest.newBuilder().setInstance(instance).build();
    return listAllFindingsRefinementDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all findings refinement deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   ListAllFindingsRefinementDeploymentsRequest request =
   *       ListAllFindingsRefinementDeploymentsRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (FindingsRefinementDeployment element :
   *       findingsRefinementServiceClient
   *           .listAllFindingsRefinementDeployments(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAllFindingsRefinementDeploymentsPagedResponse
      listAllFindingsRefinementDeployments(ListAllFindingsRefinementDeploymentsRequest request) {
    return listAllFindingsRefinementDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all findings refinement deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   ListAllFindingsRefinementDeploymentsRequest request =
   *       ListAllFindingsRefinementDeploymentsRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<FindingsRefinementDeployment> future =
   *       findingsRefinementServiceClient
   *           .listAllFindingsRefinementDeploymentsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (FindingsRefinementDeployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsPagedResponse>
      listAllFindingsRefinementDeploymentsPagedCallable() {
    return stub.listAllFindingsRefinementDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all findings refinement deployments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   ListAllFindingsRefinementDeploymentsRequest request =
   *       ListAllFindingsRefinementDeploymentsRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListAllFindingsRefinementDeploymentsResponse response =
   *         findingsRefinementServiceClient
   *             .listAllFindingsRefinementDeploymentsCallable()
   *             .call(request);
   *     for (FindingsRefinementDeployment element :
   *         response.getAllFindingsRefinementDeploymentsList()) {
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
  public final UnaryCallable<
          ListAllFindingsRefinementDeploymentsRequest, ListAllFindingsRefinementDeploymentsResponse>
      listAllFindingsRefinementDeploymentsCallable() {
    return stub.listAllFindingsRefinementDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns findings refinement activity for a specific findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   FindingsRefinementName name =
   *       FindingsRefinementName.of(
   *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]");
   *   ComputeFindingsRefinementActivityResponse response =
   *       findingsRefinementServiceClient.computeFindingsRefinementActivity(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name for the findings refinement to fetch the activity for.
   *     Format:
   *     projects/{project}/locations/{region}/instances/{instance}/findingsRefinements/{findings_refinement}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeFindingsRefinementActivityResponse computeFindingsRefinementActivity(
      FindingsRefinementName name) {
    ComputeFindingsRefinementActivityRequest request =
        ComputeFindingsRefinementActivityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return computeFindingsRefinementActivity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns findings refinement activity for a specific findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   String name =
   *       FindingsRefinementName.of(
   *               "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
   *           .toString();
   *   ComputeFindingsRefinementActivityResponse response =
   *       findingsRefinementServiceClient.computeFindingsRefinementActivity(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name for the findings refinement to fetch the activity for.
   *     Format:
   *     projects/{project}/locations/{region}/instances/{instance}/findingsRefinements/{findings_refinement}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeFindingsRefinementActivityResponse computeFindingsRefinementActivity(
      String name) {
    ComputeFindingsRefinementActivityRequest request =
        ComputeFindingsRefinementActivityRequest.newBuilder().setName(name).build();
    return computeFindingsRefinementActivity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns findings refinement activity for a specific findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   ComputeFindingsRefinementActivityRequest request =
   *       ComputeFindingsRefinementActivityRequest.newBuilder()
   *           .setName(
   *               FindingsRefinementName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
   *                   .toString())
   *           .setInterval(Interval.newBuilder().build())
   *           .build();
   *   ComputeFindingsRefinementActivityResponse response =
   *       findingsRefinementServiceClient.computeFindingsRefinementActivity(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeFindingsRefinementActivityResponse computeFindingsRefinementActivity(
      ComputeFindingsRefinementActivityRequest request) {
    return computeFindingsRefinementActivityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns findings refinement activity for a specific findings refinement.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   ComputeFindingsRefinementActivityRequest request =
   *       ComputeFindingsRefinementActivityRequest.newBuilder()
   *           .setName(
   *               FindingsRefinementName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FINDINGS_REFINEMENT]")
   *                   .toString())
   *           .setInterval(Interval.newBuilder().build())
   *           .build();
   *   ApiFuture<ComputeFindingsRefinementActivityResponse> future =
   *       findingsRefinementServiceClient
   *           .computeFindingsRefinementActivityCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ComputeFindingsRefinementActivityResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
      computeFindingsRefinementActivityCallable() {
    return stub.computeFindingsRefinementActivityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns findings refinement activity for all findings refinements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   ComputeAllFindingsRefinementActivitiesResponse response =
   *       findingsRefinementServiceClient.computeAllFindingsRefinementActivities(instance);
   * }
   * }</pre>
   *
   * @param instance Required. The ID of the Instance to retrieve counts for. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeAllFindingsRefinementActivitiesResponse
      computeAllFindingsRefinementActivities(InstanceName instance) {
    ComputeAllFindingsRefinementActivitiesRequest request =
        ComputeAllFindingsRefinementActivitiesRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .build();
    return computeAllFindingsRefinementActivities(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns findings refinement activity for all findings refinements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   String instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   ComputeAllFindingsRefinementActivitiesResponse response =
   *       findingsRefinementServiceClient.computeAllFindingsRefinementActivities(instance);
   * }
   * }</pre>
   *
   * @param instance Required. The ID of the Instance to retrieve counts for. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeAllFindingsRefinementActivitiesResponse
      computeAllFindingsRefinementActivities(String instance) {
    ComputeAllFindingsRefinementActivitiesRequest request =
        ComputeAllFindingsRefinementActivitiesRequest.newBuilder().setInstance(instance).build();
    return computeAllFindingsRefinementActivities(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns findings refinement activity for all findings refinements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   ComputeAllFindingsRefinementActivitiesRequest request =
   *       ComputeAllFindingsRefinementActivitiesRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setInterval(Interval.newBuilder().build())
   *           .build();
   *   ComputeAllFindingsRefinementActivitiesResponse response =
   *       findingsRefinementServiceClient.computeAllFindingsRefinementActivities(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeAllFindingsRefinementActivitiesResponse
      computeAllFindingsRefinementActivities(
          ComputeAllFindingsRefinementActivitiesRequest request) {
    return computeAllFindingsRefinementActivitiesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns findings refinement activity for all findings refinements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FindingsRefinementServiceClient findingsRefinementServiceClient =
   *     FindingsRefinementServiceClient.create()) {
   *   ComputeAllFindingsRefinementActivitiesRequest request =
   *       ComputeAllFindingsRefinementActivitiesRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setInterval(Interval.newBuilder().build())
   *           .build();
   *   ApiFuture<ComputeAllFindingsRefinementActivitiesResponse> future =
   *       findingsRefinementServiceClient
   *           .computeAllFindingsRefinementActivitiesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ComputeAllFindingsRefinementActivitiesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ComputeAllFindingsRefinementActivitiesRequest,
          ComputeAllFindingsRefinementActivitiesResponse>
      computeAllFindingsRefinementActivitiesCallable() {
    return stub.computeAllFindingsRefinementActivitiesCallable();
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

  public static class ListFindingsRefinementsPagedResponse
      extends AbstractPagedListResponse<
          ListFindingsRefinementsRequest,
          ListFindingsRefinementsResponse,
          FindingsRefinement,
          ListFindingsRefinementsPage,
          ListFindingsRefinementsFixedSizeCollection> {

    public static ApiFuture<ListFindingsRefinementsPagedResponse> createAsync(
        PageContext<
                ListFindingsRefinementsRequest, ListFindingsRefinementsResponse, FindingsRefinement>
            context,
        ApiFuture<ListFindingsRefinementsResponse> futureResponse) {
      ApiFuture<ListFindingsRefinementsPage> futurePage =
          ListFindingsRefinementsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFindingsRefinementsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFindingsRefinementsPagedResponse(ListFindingsRefinementsPage page) {
      super(page, ListFindingsRefinementsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFindingsRefinementsPage
      extends AbstractPage<
          ListFindingsRefinementsRequest,
          ListFindingsRefinementsResponse,
          FindingsRefinement,
          ListFindingsRefinementsPage> {

    private ListFindingsRefinementsPage(
        PageContext<
                ListFindingsRefinementsRequest, ListFindingsRefinementsResponse, FindingsRefinement>
            context,
        ListFindingsRefinementsResponse response) {
      super(context, response);
    }

    private static ListFindingsRefinementsPage createEmptyPage() {
      return new ListFindingsRefinementsPage(null, null);
    }

    @Override
    protected ListFindingsRefinementsPage createPage(
        PageContext<
                ListFindingsRefinementsRequest, ListFindingsRefinementsResponse, FindingsRefinement>
            context,
        ListFindingsRefinementsResponse response) {
      return new ListFindingsRefinementsPage(context, response);
    }

    @Override
    public ApiFuture<ListFindingsRefinementsPage> createPageAsync(
        PageContext<
                ListFindingsRefinementsRequest, ListFindingsRefinementsResponse, FindingsRefinement>
            context,
        ApiFuture<ListFindingsRefinementsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFindingsRefinementsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFindingsRefinementsRequest,
          ListFindingsRefinementsResponse,
          FindingsRefinement,
          ListFindingsRefinementsPage,
          ListFindingsRefinementsFixedSizeCollection> {

    private ListFindingsRefinementsFixedSizeCollection(
        List<ListFindingsRefinementsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFindingsRefinementsFixedSizeCollection createEmptyCollection() {
      return new ListFindingsRefinementsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFindingsRefinementsFixedSizeCollection createCollection(
        List<ListFindingsRefinementsPage> pages, int collectionSize) {
      return new ListFindingsRefinementsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAllFindingsRefinementDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsResponse,
          FindingsRefinementDeployment,
          ListAllFindingsRefinementDeploymentsPage,
          ListAllFindingsRefinementDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListAllFindingsRefinementDeploymentsPagedResponse> createAsync(
        PageContext<
                ListAllFindingsRefinementDeploymentsRequest,
                ListAllFindingsRefinementDeploymentsResponse,
                FindingsRefinementDeployment>
            context,
        ApiFuture<ListAllFindingsRefinementDeploymentsResponse> futureResponse) {
      ApiFuture<ListAllFindingsRefinementDeploymentsPage> futurePage =
          ListAllFindingsRefinementDeploymentsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAllFindingsRefinementDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAllFindingsRefinementDeploymentsPagedResponse(
        ListAllFindingsRefinementDeploymentsPage page) {
      super(page, ListAllFindingsRefinementDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAllFindingsRefinementDeploymentsPage
      extends AbstractPage<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsResponse,
          FindingsRefinementDeployment,
          ListAllFindingsRefinementDeploymentsPage> {

    private ListAllFindingsRefinementDeploymentsPage(
        PageContext<
                ListAllFindingsRefinementDeploymentsRequest,
                ListAllFindingsRefinementDeploymentsResponse,
                FindingsRefinementDeployment>
            context,
        ListAllFindingsRefinementDeploymentsResponse response) {
      super(context, response);
    }

    private static ListAllFindingsRefinementDeploymentsPage createEmptyPage() {
      return new ListAllFindingsRefinementDeploymentsPage(null, null);
    }

    @Override
    protected ListAllFindingsRefinementDeploymentsPage createPage(
        PageContext<
                ListAllFindingsRefinementDeploymentsRequest,
                ListAllFindingsRefinementDeploymentsResponse,
                FindingsRefinementDeployment>
            context,
        ListAllFindingsRefinementDeploymentsResponse response) {
      return new ListAllFindingsRefinementDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListAllFindingsRefinementDeploymentsPage> createPageAsync(
        PageContext<
                ListAllFindingsRefinementDeploymentsRequest,
                ListAllFindingsRefinementDeploymentsResponse,
                FindingsRefinementDeployment>
            context,
        ApiFuture<ListAllFindingsRefinementDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAllFindingsRefinementDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsResponse,
          FindingsRefinementDeployment,
          ListAllFindingsRefinementDeploymentsPage,
          ListAllFindingsRefinementDeploymentsFixedSizeCollection> {

    private ListAllFindingsRefinementDeploymentsFixedSizeCollection(
        List<ListAllFindingsRefinementDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAllFindingsRefinementDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListAllFindingsRefinementDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAllFindingsRefinementDeploymentsFixedSizeCollection createCollection(
        List<ListAllFindingsRefinementDeploymentsPage> pages, int collectionSize) {
      return new ListAllFindingsRefinementDeploymentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
