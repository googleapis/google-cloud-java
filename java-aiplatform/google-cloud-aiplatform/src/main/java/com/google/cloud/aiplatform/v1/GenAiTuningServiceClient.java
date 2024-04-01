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

package com.google.cloud.aiplatform.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.stub.GenAiTuningServiceStub;
import com.google.cloud.aiplatform.v1.stub.GenAiTuningServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for creating and managing GenAI Tuning Jobs.
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
 * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   TuningJob tuningJob = TuningJob.newBuilder().build();
 *   TuningJob response = genAiTuningServiceClient.createTuningJob(parent, tuningJob);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GenAiTuningServiceClient object to clean up resources
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
 *      <td><p> CreateTuningJob</td>
 *      <td><p> Creates a TuningJob. A created TuningJob right away will be attempted to be run.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTuningJob(CreateTuningJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTuningJob(LocationName parent, TuningJob tuningJob)
 *           <li><p> createTuningJob(String parent, TuningJob tuningJob)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTuningJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTuningJob</td>
 *      <td><p> Gets a TuningJob.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTuningJob(GetTuningJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTuningJob(TuningJobName name)
 *           <li><p> getTuningJob(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTuningJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTuningJobs</td>
 *      <td><p> Lists TuningJobs in a Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTuningJobs(ListTuningJobsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTuningJobs(LocationName parent)
 *           <li><p> listTuningJobs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTuningJobsPagedCallable()
 *           <li><p> listTuningJobsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CancelTuningJob</td>
 *      <td><p> Cancels a TuningJob. Starts asynchronous cancellation on the TuningJob. The server makes a best effort to cancel the job, but success is not guaranteed. Clients can use [GenAiTuningService.GetTuningJob][google.cloud.aiplatform.v1.GenAiTuningService.GetTuningJob] or other methods to check whether the cancellation succeeded or whether the job completed despite cancellation. On successful cancellation, the TuningJob is not deleted; instead it becomes a job with a [TuningJob.error][google.cloud.aiplatform.v1.TuningJob.error] value with a [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and [TuningJob.state][google.cloud.aiplatform.v1.TuningJob.state] is set to `CANCELLED`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelTuningJob(CancelTuningJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> cancelTuningJob(TuningJobName name)
 *           <li><p> cancelTuningJob(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelTuningJobCallable()
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
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of GenAiTuningServiceSettings to
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
 * GenAiTuningServiceSettings genAiTuningServiceSettings =
 *     GenAiTuningServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GenAiTuningServiceClient genAiTuningServiceClient =
 *     GenAiTuningServiceClient.create(genAiTuningServiceSettings);
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
 * GenAiTuningServiceSettings genAiTuningServiceSettings =
 *     GenAiTuningServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GenAiTuningServiceClient genAiTuningServiceClient =
 *     GenAiTuningServiceClient.create(genAiTuningServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GenAiTuningServiceClient implements BackgroundResource {
  private final GenAiTuningServiceSettings settings;
  private final GenAiTuningServiceStub stub;

  /** Constructs an instance of GenAiTuningServiceClient with default settings. */
  public static final GenAiTuningServiceClient create() throws IOException {
    return create(GenAiTuningServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GenAiTuningServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GenAiTuningServiceClient create(GenAiTuningServiceSettings settings)
      throws IOException {
    return new GenAiTuningServiceClient(settings);
  }

  /**
   * Constructs an instance of GenAiTuningServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(GenAiTuningServiceSettings).
   */
  public static final GenAiTuningServiceClient create(GenAiTuningServiceStub stub) {
    return new GenAiTuningServiceClient(stub);
  }

  /**
   * Constructs an instance of GenAiTuningServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GenAiTuningServiceClient(GenAiTuningServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GenAiTuningServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected GenAiTuningServiceClient(GenAiTuningServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GenAiTuningServiceSettings getSettings() {
    return settings;
  }

  public GenAiTuningServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TuningJob. A created TuningJob right away will be attempted to be run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   TuningJob tuningJob = TuningJob.newBuilder().build();
   *   TuningJob response = genAiTuningServiceClient.createTuningJob(parent, tuningJob);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the TuningJob in. Format:
   *     `projects/{project}/locations/{location}`
   * @param tuningJob Required. The TuningJob to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TuningJob createTuningJob(LocationName parent, TuningJob tuningJob) {
    CreateTuningJobRequest request =
        CreateTuningJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTuningJob(tuningJob)
            .build();
    return createTuningJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TuningJob. A created TuningJob right away will be attempted to be run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   TuningJob tuningJob = TuningJob.newBuilder().build();
   *   TuningJob response = genAiTuningServiceClient.createTuningJob(parent, tuningJob);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the TuningJob in. Format:
   *     `projects/{project}/locations/{location}`
   * @param tuningJob Required. The TuningJob to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TuningJob createTuningJob(String parent, TuningJob tuningJob) {
    CreateTuningJobRequest request =
        CreateTuningJobRequest.newBuilder().setParent(parent).setTuningJob(tuningJob).build();
    return createTuningJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TuningJob. A created TuningJob right away will be attempted to be run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   CreateTuningJobRequest request =
   *       CreateTuningJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTuningJob(TuningJob.newBuilder().build())
   *           .build();
   *   TuningJob response = genAiTuningServiceClient.createTuningJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TuningJob createTuningJob(CreateTuningJobRequest request) {
    return createTuningJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a TuningJob. A created TuningJob right away will be attempted to be run.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   CreateTuningJobRequest request =
   *       CreateTuningJobRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTuningJob(TuningJob.newBuilder().build())
   *           .build();
   *   ApiFuture<TuningJob> future =
   *       genAiTuningServiceClient.createTuningJobCallable().futureCall(request);
   *   // Do something.
   *   TuningJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTuningJobRequest, TuningJob> createTuningJobCallable() {
    return stub.createTuningJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TuningJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   TuningJobName name = TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]");
   *   TuningJob response = genAiTuningServiceClient.getTuningJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TuningJob resource. Format:
   *     `projects/{project}/locations/{location}/tuningJobs/{tuning_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TuningJob getTuningJob(TuningJobName name) {
    GetTuningJobRequest request =
        GetTuningJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTuningJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TuningJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   String name = TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]").toString();
   *   TuningJob response = genAiTuningServiceClient.getTuningJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TuningJob resource. Format:
   *     `projects/{project}/locations/{location}/tuningJobs/{tuning_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TuningJob getTuningJob(String name) {
    GetTuningJobRequest request = GetTuningJobRequest.newBuilder().setName(name).build();
    return getTuningJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TuningJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   GetTuningJobRequest request =
   *       GetTuningJobRequest.newBuilder()
   *           .setName(TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]").toString())
   *           .build();
   *   TuningJob response = genAiTuningServiceClient.getTuningJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TuningJob getTuningJob(GetTuningJobRequest request) {
    return getTuningJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a TuningJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   GetTuningJobRequest request =
   *       GetTuningJobRequest.newBuilder()
   *           .setName(TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]").toString())
   *           .build();
   *   ApiFuture<TuningJob> future =
   *       genAiTuningServiceClient.getTuningJobCallable().futureCall(request);
   *   // Do something.
   *   TuningJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTuningJobRequest, TuningJob> getTuningJobCallable() {
    return stub.getTuningJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TuningJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (TuningJob element : genAiTuningServiceClient.listTuningJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the TuningJobs from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTuningJobsPagedResponse listTuningJobs(LocationName parent) {
    ListTuningJobsRequest request =
        ListTuningJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTuningJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TuningJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (TuningJob element : genAiTuningServiceClient.listTuningJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the TuningJobs from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTuningJobsPagedResponse listTuningJobs(String parent) {
    ListTuningJobsRequest request = ListTuningJobsRequest.newBuilder().setParent(parent).build();
    return listTuningJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TuningJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   ListTuningJobsRequest request =
   *       ListTuningJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TuningJob element : genAiTuningServiceClient.listTuningJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTuningJobsPagedResponse listTuningJobs(ListTuningJobsRequest request) {
    return listTuningJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TuningJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   ListTuningJobsRequest request =
   *       ListTuningJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TuningJob> future =
   *       genAiTuningServiceClient.listTuningJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TuningJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTuningJobsRequest, ListTuningJobsPagedResponse>
      listTuningJobsPagedCallable() {
    return stub.listTuningJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TuningJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   ListTuningJobsRequest request =
   *       ListTuningJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTuningJobsResponse response =
   *         genAiTuningServiceClient.listTuningJobsCallable().call(request);
   *     for (TuningJob element : response.getTuningJobsList()) {
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
  public final UnaryCallable<ListTuningJobsRequest, ListTuningJobsResponse>
      listTuningJobsCallable() {
    return stub.listTuningJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a TuningJob. Starts asynchronous cancellation on the TuningJob. The server makes a best
   * effort to cancel the job, but success is not guaranteed. Clients can use
   * [GenAiTuningService.GetTuningJob][google.cloud.aiplatform.v1.GenAiTuningService.GetTuningJob]
   * or other methods to check whether the cancellation succeeded or whether the job completed
   * despite cancellation. On successful cancellation, the TuningJob is not deleted; instead it
   * becomes a job with a [TuningJob.error][google.cloud.aiplatform.v1.TuningJob.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [TuningJob.state][google.cloud.aiplatform.v1.TuningJob.state] is set to `CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   TuningJobName name = TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]");
   *   genAiTuningServiceClient.cancelTuningJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TuningJob to cancel. Format:
   *     `projects/{project}/locations/{location}/tuningJobs/{tuning_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelTuningJob(TuningJobName name) {
    CancelTuningJobRequest request =
        CancelTuningJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    cancelTuningJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a TuningJob. Starts asynchronous cancellation on the TuningJob. The server makes a best
   * effort to cancel the job, but success is not guaranteed. Clients can use
   * [GenAiTuningService.GetTuningJob][google.cloud.aiplatform.v1.GenAiTuningService.GetTuningJob]
   * or other methods to check whether the cancellation succeeded or whether the job completed
   * despite cancellation. On successful cancellation, the TuningJob is not deleted; instead it
   * becomes a job with a [TuningJob.error][google.cloud.aiplatform.v1.TuningJob.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [TuningJob.state][google.cloud.aiplatform.v1.TuningJob.state] is set to `CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   String name = TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]").toString();
   *   genAiTuningServiceClient.cancelTuningJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the TuningJob to cancel. Format:
   *     `projects/{project}/locations/{location}/tuningJobs/{tuning_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelTuningJob(String name) {
    CancelTuningJobRequest request = CancelTuningJobRequest.newBuilder().setName(name).build();
    cancelTuningJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a TuningJob. Starts asynchronous cancellation on the TuningJob. The server makes a best
   * effort to cancel the job, but success is not guaranteed. Clients can use
   * [GenAiTuningService.GetTuningJob][google.cloud.aiplatform.v1.GenAiTuningService.GetTuningJob]
   * or other methods to check whether the cancellation succeeded or whether the job completed
   * despite cancellation. On successful cancellation, the TuningJob is not deleted; instead it
   * becomes a job with a [TuningJob.error][google.cloud.aiplatform.v1.TuningJob.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [TuningJob.state][google.cloud.aiplatform.v1.TuningJob.state] is set to `CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   CancelTuningJobRequest request =
   *       CancelTuningJobRequest.newBuilder()
   *           .setName(TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]").toString())
   *           .build();
   *   genAiTuningServiceClient.cancelTuningJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void cancelTuningJob(CancelTuningJobRequest request) {
    cancelTuningJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a TuningJob. Starts asynchronous cancellation on the TuningJob. The server makes a best
   * effort to cancel the job, but success is not guaranteed. Clients can use
   * [GenAiTuningService.GetTuningJob][google.cloud.aiplatform.v1.GenAiTuningService.GetTuningJob]
   * or other methods to check whether the cancellation succeeded or whether the job completed
   * despite cancellation. On successful cancellation, the TuningJob is not deleted; instead it
   * becomes a job with a [TuningJob.error][google.cloud.aiplatform.v1.TuningJob.error] value with a
   * [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding to `Code.CANCELLED`, and
   * [TuningJob.state][google.cloud.aiplatform.v1.TuningJob.state] is set to `CANCELLED`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   CancelTuningJobRequest request =
   *       CancelTuningJobRequest.newBuilder()
   *           .setName(TuningJobName.of("[PROJECT]", "[LOCATION]", "[TUNING_JOB]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       genAiTuningServiceClient.cancelTuningJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelTuningJobRequest, Empty> cancelTuningJobCallable() {
    return stub.cancelTuningJobCallable();
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
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : genAiTuningServiceClient.listLocations(request).iterateAll()) {
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
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       genAiTuningServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         genAiTuningServiceClient.listLocationsCallable().call(request);
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
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = genAiTuningServiceClient.getLocation(request);
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
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       genAiTuningServiceClient.getLocationCallable().futureCall(request);
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
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = genAiTuningServiceClient.setIamPolicy(request);
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
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       genAiTuningServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = genAiTuningServiceClient.getIamPolicy(request);
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
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       genAiTuningServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = genAiTuningServiceClient.testIamPermissions(request);
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
   * try (GenAiTuningServiceClient genAiTuningServiceClient = GenAiTuningServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       genAiTuningServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListTuningJobsPagedResponse
      extends AbstractPagedListResponse<
          ListTuningJobsRequest,
          ListTuningJobsResponse,
          TuningJob,
          ListTuningJobsPage,
          ListTuningJobsFixedSizeCollection> {

    public static ApiFuture<ListTuningJobsPagedResponse> createAsync(
        PageContext<ListTuningJobsRequest, ListTuningJobsResponse, TuningJob> context,
        ApiFuture<ListTuningJobsResponse> futureResponse) {
      ApiFuture<ListTuningJobsPage> futurePage =
          ListTuningJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTuningJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTuningJobsPagedResponse(ListTuningJobsPage page) {
      super(page, ListTuningJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTuningJobsPage
      extends AbstractPage<
          ListTuningJobsRequest, ListTuningJobsResponse, TuningJob, ListTuningJobsPage> {

    private ListTuningJobsPage(
        PageContext<ListTuningJobsRequest, ListTuningJobsResponse, TuningJob> context,
        ListTuningJobsResponse response) {
      super(context, response);
    }

    private static ListTuningJobsPage createEmptyPage() {
      return new ListTuningJobsPage(null, null);
    }

    @Override
    protected ListTuningJobsPage createPage(
        PageContext<ListTuningJobsRequest, ListTuningJobsResponse, TuningJob> context,
        ListTuningJobsResponse response) {
      return new ListTuningJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListTuningJobsPage> createPageAsync(
        PageContext<ListTuningJobsRequest, ListTuningJobsResponse, TuningJob> context,
        ApiFuture<ListTuningJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTuningJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTuningJobsRequest,
          ListTuningJobsResponse,
          TuningJob,
          ListTuningJobsPage,
          ListTuningJobsFixedSizeCollection> {

    private ListTuningJobsFixedSizeCollection(List<ListTuningJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTuningJobsFixedSizeCollection createEmptyCollection() {
      return new ListTuningJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTuningJobsFixedSizeCollection createCollection(
        List<ListTuningJobsPage> pages, int collectionSize) {
      return new ListTuningJobsFixedSizeCollection(pages, collectionSize);
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
