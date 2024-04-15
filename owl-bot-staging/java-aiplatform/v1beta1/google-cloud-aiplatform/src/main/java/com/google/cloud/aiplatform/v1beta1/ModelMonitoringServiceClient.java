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

package com.google.cloud.aiplatform.v1beta1;

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
import com.google.cloud.aiplatform.v1beta1.stub.ModelMonitoringServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.ModelMonitoringServiceStubSettings;
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
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for creating and managing Vertex AI Model moitoring. This includes
 * `ModelMonitor` resources, `ModelMonitoringJob` resources.
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
 * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
 *     ModelMonitoringServiceClient.create()) {
 *   ModelMonitorName name = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
 *   ModelMonitor response = modelMonitoringServiceClient.getModelMonitor(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ModelMonitoringServiceClient object to clean up
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
 *      <td><p> CreateModelMonitor</td>
 *      <td><p> Creates a ModelMonitor.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createModelMonitorAsync(CreateModelMonitorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createModelMonitorAsync(LocationName parent, ModelMonitor modelMonitor)
 *           <li><p> createModelMonitorAsync(String parent, ModelMonitor modelMonitor)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createModelMonitorOperationCallable()
 *           <li><p> createModelMonitorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateModelMonitor</td>
 *      <td><p> Updates a ModelMonitor.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateModelMonitorAsync(UpdateModelMonitorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateModelMonitorAsync(ModelMonitor modelMonitor, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateModelMonitorOperationCallable()
 *           <li><p> updateModelMonitorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetModelMonitor</td>
 *      <td><p> Gets a ModelMonitor.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getModelMonitor(GetModelMonitorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getModelMonitor(ModelMonitorName name)
 *           <li><p> getModelMonitor(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getModelMonitorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListModelMonitors</td>
 *      <td><p> Lists ModelMonitors in a Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listModelMonitors(ListModelMonitorsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listModelMonitors(LocationName parent)
 *           <li><p> listModelMonitors(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listModelMonitorsPagedCallable()
 *           <li><p> listModelMonitorsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteModelMonitor</td>
 *      <td><p> Deletes a ModelMonitor.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteModelMonitorAsync(DeleteModelMonitorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteModelMonitorAsync(ModelMonitorName name)
 *           <li><p> deleteModelMonitorAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteModelMonitorOperationCallable()
 *           <li><p> deleteModelMonitorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateModelMonitoringJob</td>
 *      <td><p> Creates a ModelMonitoringJob.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createModelMonitoringJob(CreateModelMonitoringJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createModelMonitoringJob(ModelMonitorName parent, ModelMonitoringJob modelMonitoringJob)
 *           <li><p> createModelMonitoringJob(String parent, ModelMonitoringJob modelMonitoringJob)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createModelMonitoringJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetModelMonitoringJob</td>
 *      <td><p> Gets a ModelMonitoringJob.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getModelMonitoringJob(GetModelMonitoringJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getModelMonitoringJob(ModelMonitoringJobName name)
 *           <li><p> getModelMonitoringJob(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getModelMonitoringJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListModelMonitoringJobs</td>
 *      <td><p> Lists ModelMonitoringJobs. Callers may choose to read across multiple Monitors as per [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash character) as a wildcard character instead of modelMonitor id in the parent. Format `projects/{project_id}/locations/{location}/moodelMonitors/-/modelMonitoringJobs`</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listModelMonitoringJobs(ListModelMonitoringJobsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listModelMonitoringJobs(ModelMonitorName parent)
 *           <li><p> listModelMonitoringJobs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listModelMonitoringJobsPagedCallable()
 *           <li><p> listModelMonitoringJobsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteModelMonitoringJob</td>
 *      <td><p> Deletes a ModelMonitoringJob.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteModelMonitoringJobAsync(DeleteModelMonitoringJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteModelMonitoringJobAsync(ModelMonitoringJobName name)
 *           <li><p> deleteModelMonitoringJobAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteModelMonitoringJobOperationCallable()
 *           <li><p> deleteModelMonitoringJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchModelMonitoringStats</td>
 *      <td><p> Searches Model Monitoring Stats generated within a given time window.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchModelMonitoringStats(SearchModelMonitoringStatsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchModelMonitoringStats(ModelMonitorName modelMonitor)
 *           <li><p> searchModelMonitoringStats(String modelMonitor)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchModelMonitoringStatsPagedCallable()
 *           <li><p> searchModelMonitoringStatsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchModelMonitoringAlerts</td>
 *      <td><p> Returns the Model Monitoring alerts.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchModelMonitoringAlerts(SearchModelMonitoringAlertsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchModelMonitoringAlerts(ModelMonitorName modelMonitor)
 *           <li><p> searchModelMonitoringAlerts(String modelMonitor)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchModelMonitoringAlertsPagedCallable()
 *           <li><p> searchModelMonitoringAlertsCallable()
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
 * <p>This class can be customized by passing in a custom instance of ModelMonitoringServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ModelMonitoringServiceSettings modelMonitoringServiceSettings =
 *     ModelMonitoringServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ModelMonitoringServiceClient modelMonitoringServiceClient =
 *     ModelMonitoringServiceClient.create(modelMonitoringServiceSettings);
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
 * ModelMonitoringServiceSettings modelMonitoringServiceSettings =
 *     ModelMonitoringServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ModelMonitoringServiceClient modelMonitoringServiceClient =
 *     ModelMonitoringServiceClient.create(modelMonitoringServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ModelMonitoringServiceClient implements BackgroundResource {
  private final ModelMonitoringServiceSettings settings;
  private final ModelMonitoringServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ModelMonitoringServiceClient with default settings. */
  public static final ModelMonitoringServiceClient create() throws IOException {
    return create(ModelMonitoringServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ModelMonitoringServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ModelMonitoringServiceClient create(ModelMonitoringServiceSettings settings)
      throws IOException {
    return new ModelMonitoringServiceClient(settings);
  }

  /**
   * Constructs an instance of ModelMonitoringServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ModelMonitoringServiceSettings).
   */
  public static final ModelMonitoringServiceClient create(ModelMonitoringServiceStub stub) {
    return new ModelMonitoringServiceClient(stub);
  }

  /**
   * Constructs an instance of ModelMonitoringServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ModelMonitoringServiceClient(ModelMonitoringServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ModelMonitoringServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected ModelMonitoringServiceClient(ModelMonitoringServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ModelMonitoringServiceSettings getSettings() {
    return settings;
  }

  public ModelMonitoringServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ModelMonitor modelMonitor = ModelMonitor.newBuilder().build();
   *   ModelMonitor response =
   *       modelMonitoringServiceClient.createModelMonitorAsync(parent, modelMonitor).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the ModelMonitor in.
   *     Format: `projects/{project}/locations/{location}`
   * @param modelMonitor Required. The ModelMonitor to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ModelMonitor, CreateModelMonitorOperationMetadata>
      createModelMonitorAsync(LocationName parent, ModelMonitor modelMonitor) {
    CreateModelMonitorRequest request =
        CreateModelMonitorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModelMonitor(modelMonitor)
            .build();
    return createModelMonitorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ModelMonitor modelMonitor = ModelMonitor.newBuilder().build();
   *   ModelMonitor response =
   *       modelMonitoringServiceClient.createModelMonitorAsync(parent, modelMonitor).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the ModelMonitor in.
   *     Format: `projects/{project}/locations/{location}`
   * @param modelMonitor Required. The ModelMonitor to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ModelMonitor, CreateModelMonitorOperationMetadata>
      createModelMonitorAsync(String parent, ModelMonitor modelMonitor) {
    CreateModelMonitorRequest request =
        CreateModelMonitorRequest.newBuilder()
            .setParent(parent)
            .setModelMonitor(modelMonitor)
            .build();
    return createModelMonitorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   CreateModelMonitorRequest request =
   *       CreateModelMonitorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModelMonitor(ModelMonitor.newBuilder().build())
   *           .setModelMonitorId("modelMonitorId2093120236")
   *           .build();
   *   ModelMonitor response = modelMonitoringServiceClient.createModelMonitorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ModelMonitor, CreateModelMonitorOperationMetadata>
      createModelMonitorAsync(CreateModelMonitorRequest request) {
    return createModelMonitorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   CreateModelMonitorRequest request =
   *       CreateModelMonitorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModelMonitor(ModelMonitor.newBuilder().build())
   *           .setModelMonitorId("modelMonitorId2093120236")
   *           .build();
   *   OperationFuture<ModelMonitor, CreateModelMonitorOperationMetadata> future =
   *       modelMonitoringServiceClient.createModelMonitorOperationCallable().futureCall(request);
   *   // Do something.
   *   ModelMonitor response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateModelMonitorRequest, ModelMonitor, CreateModelMonitorOperationMetadata>
      createModelMonitorOperationCallable() {
    return stub.createModelMonitorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   CreateModelMonitorRequest request =
   *       CreateModelMonitorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModelMonitor(ModelMonitor.newBuilder().build())
   *           .setModelMonitorId("modelMonitorId2093120236")
   *           .build();
   *   ApiFuture<Operation> future =
   *       modelMonitoringServiceClient.createModelMonitorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateModelMonitorRequest, Operation> createModelMonitorCallable() {
    return stub.createModelMonitorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ModelMonitor modelMonitor = ModelMonitor.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ModelMonitor response =
   *       modelMonitoringServiceClient.updateModelMonitorAsync(modelMonitor, updateMask).get();
   * }
   * }</pre>
   *
   * @param modelMonitor Required. The model monitoring configuration which replaces the resource on
   *     the server.
   * @param updateMask Required. Mask specifying which fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ModelMonitor, UpdateModelMonitorOperationMetadata>
      updateModelMonitorAsync(ModelMonitor modelMonitor, FieldMask updateMask) {
    UpdateModelMonitorRequest request =
        UpdateModelMonitorRequest.newBuilder()
            .setModelMonitor(modelMonitor)
            .setUpdateMask(updateMask)
            .build();
    return updateModelMonitorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   UpdateModelMonitorRequest request =
   *       UpdateModelMonitorRequest.newBuilder()
   *           .setModelMonitor(ModelMonitor.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ModelMonitor response = modelMonitoringServiceClient.updateModelMonitorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ModelMonitor, UpdateModelMonitorOperationMetadata>
      updateModelMonitorAsync(UpdateModelMonitorRequest request) {
    return updateModelMonitorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   UpdateModelMonitorRequest request =
   *       UpdateModelMonitorRequest.newBuilder()
   *           .setModelMonitor(ModelMonitor.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<ModelMonitor, UpdateModelMonitorOperationMetadata> future =
   *       modelMonitoringServiceClient.updateModelMonitorOperationCallable().futureCall(request);
   *   // Do something.
   *   ModelMonitor response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateModelMonitorRequest, ModelMonitor, UpdateModelMonitorOperationMetadata>
      updateModelMonitorOperationCallable() {
    return stub.updateModelMonitorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   UpdateModelMonitorRequest request =
   *       UpdateModelMonitorRequest.newBuilder()
   *           .setModelMonitor(ModelMonitor.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       modelMonitoringServiceClient.updateModelMonitorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateModelMonitorRequest, Operation> updateModelMonitorCallable() {
    return stub.updateModelMonitorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ModelMonitorName name = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
   *   ModelMonitor response = modelMonitoringServiceClient.getModelMonitor(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ModelMonitor resource. Format:
   *     `projects/{project}/locations/{location}/modelMonitors/{model_monitor}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelMonitor getModelMonitor(ModelMonitorName name) {
    GetModelMonitorRequest request =
        GetModelMonitorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getModelMonitor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   String name = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString();
   *   ModelMonitor response = modelMonitoringServiceClient.getModelMonitor(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ModelMonitor resource. Format:
   *     `projects/{project}/locations/{location}/modelMonitors/{model_monitor}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelMonitor getModelMonitor(String name) {
    GetModelMonitorRequest request = GetModelMonitorRequest.newBuilder().setName(name).build();
    return getModelMonitor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   GetModelMonitorRequest request =
   *       GetModelMonitorRequest.newBuilder()
   *           .setName(ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .build();
   *   ModelMonitor response = modelMonitoringServiceClient.getModelMonitor(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelMonitor getModelMonitor(GetModelMonitorRequest request) {
    return getModelMonitorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   GetModelMonitorRequest request =
   *       GetModelMonitorRequest.newBuilder()
   *           .setName(ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .build();
   *   ApiFuture<ModelMonitor> future =
   *       modelMonitoringServiceClient.getModelMonitorCallable().futureCall(request);
   *   // Do something.
   *   ModelMonitor response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetModelMonitorRequest, ModelMonitor> getModelMonitorCallable() {
    return stub.getModelMonitorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelMonitors in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ModelMonitor element :
   *       modelMonitoringServiceClient.listModelMonitors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the ModelMonitors from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelMonitorsPagedResponse listModelMonitors(LocationName parent) {
    ListModelMonitorsRequest request =
        ListModelMonitorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listModelMonitors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelMonitors in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ModelMonitor element :
   *       modelMonitoringServiceClient.listModelMonitors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the ModelMonitors from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelMonitorsPagedResponse listModelMonitors(String parent) {
    ListModelMonitorsRequest request =
        ListModelMonitorsRequest.newBuilder().setParent(parent).build();
    return listModelMonitors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelMonitors in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ListModelMonitorsRequest request =
   *       ListModelMonitorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (ModelMonitor element :
   *       modelMonitoringServiceClient.listModelMonitors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelMonitorsPagedResponse listModelMonitors(ListModelMonitorsRequest request) {
    return listModelMonitorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelMonitors in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ListModelMonitorsRequest request =
   *       ListModelMonitorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ModelMonitor> future =
   *       modelMonitoringServiceClient.listModelMonitorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ModelMonitor element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListModelMonitorsRequest, ListModelMonitorsPagedResponse>
      listModelMonitorsPagedCallable() {
    return stub.listModelMonitorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelMonitors in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ListModelMonitorsRequest request =
   *       ListModelMonitorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListModelMonitorsResponse response =
   *         modelMonitoringServiceClient.listModelMonitorsCallable().call(request);
   *     for (ModelMonitor element : response.getModelMonitorsList()) {
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
  public final UnaryCallable<ListModelMonitorsRequest, ListModelMonitorsResponse>
      listModelMonitorsCallable() {
    return stub.listModelMonitorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ModelMonitorName name = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
   *   modelMonitoringServiceClient.deleteModelMonitorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ModelMonitor resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/modelMonitords/{model_monitor}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelMonitorAsync(
      ModelMonitorName name) {
    DeleteModelMonitorRequest request =
        DeleteModelMonitorRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteModelMonitorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   String name = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString();
   *   modelMonitoringServiceClient.deleteModelMonitorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ModelMonitor resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/modelMonitords/{model_monitor}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelMonitorAsync(
      String name) {
    DeleteModelMonitorRequest request =
        DeleteModelMonitorRequest.newBuilder().setName(name).build();
    return deleteModelMonitorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   DeleteModelMonitorRequest request =
   *       DeleteModelMonitorRequest.newBuilder()
   *           .setName(ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setForce(true)
   *           .build();
   *   modelMonitoringServiceClient.deleteModelMonitorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelMonitorAsync(
      DeleteModelMonitorRequest request) {
    return deleteModelMonitorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   DeleteModelMonitorRequest request =
   *       DeleteModelMonitorRequest.newBuilder()
   *           .setName(ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       modelMonitoringServiceClient.deleteModelMonitorOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteModelMonitorRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitorOperationCallable() {
    return stub.deleteModelMonitorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ModelMonitor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   DeleteModelMonitorRequest request =
   *       DeleteModelMonitorRequest.newBuilder()
   *           .setName(ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       modelMonitoringServiceClient.deleteModelMonitorCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteModelMonitorRequest, Operation> deleteModelMonitorCallable() {
    return stub.deleteModelMonitorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ModelMonitoringJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ModelMonitorName parent = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
   *   ModelMonitoringJob modelMonitoringJob = ModelMonitoringJob.newBuilder().build();
   *   ModelMonitoringJob response =
   *       modelMonitoringServiceClient.createModelMonitoringJob(parent, modelMonitoringJob);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the ModelMonitoringJob. Format:
   *     `projects/{project}/locations/{location}/modelMoniitors/{model_monitor}`
   * @param modelMonitoringJob Required. The ModelMonitoringJob to create
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelMonitoringJob createModelMonitoringJob(
      ModelMonitorName parent, ModelMonitoringJob modelMonitoringJob) {
    CreateModelMonitoringJobRequest request =
        CreateModelMonitoringJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setModelMonitoringJob(modelMonitoringJob)
            .build();
    return createModelMonitoringJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ModelMonitoringJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   String parent = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString();
   *   ModelMonitoringJob modelMonitoringJob = ModelMonitoringJob.newBuilder().build();
   *   ModelMonitoringJob response =
   *       modelMonitoringServiceClient.createModelMonitoringJob(parent, modelMonitoringJob);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the ModelMonitoringJob. Format:
   *     `projects/{project}/locations/{location}/modelMoniitors/{model_monitor}`
   * @param modelMonitoringJob Required. The ModelMonitoringJob to create
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelMonitoringJob createModelMonitoringJob(
      String parent, ModelMonitoringJob modelMonitoringJob) {
    CreateModelMonitoringJobRequest request =
        CreateModelMonitoringJobRequest.newBuilder()
            .setParent(parent)
            .setModelMonitoringJob(modelMonitoringJob)
            .build();
    return createModelMonitoringJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ModelMonitoringJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   CreateModelMonitoringJobRequest request =
   *       CreateModelMonitoringJobRequest.newBuilder()
   *           .setParent(
   *               ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setModelMonitoringJob(ModelMonitoringJob.newBuilder().build())
   *           .setModelMonitoringJobId("modelMonitoringJobId-1595185177")
   *           .build();
   *   ModelMonitoringJob response = modelMonitoringServiceClient.createModelMonitoringJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelMonitoringJob createModelMonitoringJob(
      CreateModelMonitoringJobRequest request) {
    return createModelMonitoringJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ModelMonitoringJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   CreateModelMonitoringJobRequest request =
   *       CreateModelMonitoringJobRequest.newBuilder()
   *           .setParent(
   *               ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setModelMonitoringJob(ModelMonitoringJob.newBuilder().build())
   *           .setModelMonitoringJobId("modelMonitoringJobId-1595185177")
   *           .build();
   *   ApiFuture<ModelMonitoringJob> future =
   *       modelMonitoringServiceClient.createModelMonitoringJobCallable().futureCall(request);
   *   // Do something.
   *   ModelMonitoringJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateModelMonitoringJobRequest, ModelMonitoringJob>
      createModelMonitoringJobCallable() {
    return stub.createModelMonitoringJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelMonitoringJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ModelMonitoringJobName name =
   *       ModelMonitoringJobName.of(
   *           "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]");
   *   ModelMonitoringJob response = modelMonitoringServiceClient.getModelMonitoringJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ModelMonitoringJob. Format:
   *     `projects/{project}/locations/{location}/modelMonitors/{model_monitor}/modelMonitoringJobs/{model_monitoring_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelMonitoringJob getModelMonitoringJob(ModelMonitoringJobName name) {
    GetModelMonitoringJobRequest request =
        GetModelMonitoringJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getModelMonitoringJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelMonitoringJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   String name =
   *       ModelMonitoringJobName.of(
   *               "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]")
   *           .toString();
   *   ModelMonitoringJob response = modelMonitoringServiceClient.getModelMonitoringJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ModelMonitoringJob. Format:
   *     `projects/{project}/locations/{location}/modelMonitors/{model_monitor}/modelMonitoringJobs/{model_monitoring_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelMonitoringJob getModelMonitoringJob(String name) {
    GetModelMonitoringJobRequest request =
        GetModelMonitoringJobRequest.newBuilder().setName(name).build();
    return getModelMonitoringJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelMonitoringJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   GetModelMonitoringJobRequest request =
   *       GetModelMonitoringJobRequest.newBuilder()
   *           .setName(
   *               ModelMonitoringJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]")
   *                   .toString())
   *           .build();
   *   ModelMonitoringJob response = modelMonitoringServiceClient.getModelMonitoringJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ModelMonitoringJob getModelMonitoringJob(GetModelMonitoringJobRequest request) {
    return getModelMonitoringJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ModelMonitoringJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   GetModelMonitoringJobRequest request =
   *       GetModelMonitoringJobRequest.newBuilder()
   *           .setName(
   *               ModelMonitoringJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ModelMonitoringJob> future =
   *       modelMonitoringServiceClient.getModelMonitoringJobCallable().futureCall(request);
   *   // Do something.
   *   ModelMonitoringJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetModelMonitoringJobRequest, ModelMonitoringJob>
      getModelMonitoringJobCallable() {
    return stub.getModelMonitoringJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelMonitoringJobs. Callers may choose to read across multiple Monitors as per
   * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash character) as a wildcard
   * character instead of modelMonitor id in the parent. Format
   * `projects/{project_id}/locations/{location}/moodelMonitors/-/modelMonitoringJobs`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ModelMonitorName parent = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
   *   for (ModelMonitoringJob element :
   *       modelMonitoringServiceClient.listModelMonitoringJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the ModelMonitoringJob. Format:
   *     `projects/{project}/locations/{location}/modelMonitors/{model_monitor}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelMonitoringJobsPagedResponse listModelMonitoringJobs(
      ModelMonitorName parent) {
    ListModelMonitoringJobsRequest request =
        ListModelMonitoringJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listModelMonitoringJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelMonitoringJobs. Callers may choose to read across multiple Monitors as per
   * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash character) as a wildcard
   * character instead of modelMonitor id in the parent. Format
   * `projects/{project_id}/locations/{location}/moodelMonitors/-/modelMonitoringJobs`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   String parent = ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString();
   *   for (ModelMonitoringJob element :
   *       modelMonitoringServiceClient.listModelMonitoringJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the ModelMonitoringJob. Format:
   *     `projects/{project}/locations/{location}/modelMonitors/{model_monitor}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelMonitoringJobsPagedResponse listModelMonitoringJobs(String parent) {
    ListModelMonitoringJobsRequest request =
        ListModelMonitoringJobsRequest.newBuilder().setParent(parent).build();
    return listModelMonitoringJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelMonitoringJobs. Callers may choose to read across multiple Monitors as per
   * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash character) as a wildcard
   * character instead of modelMonitor id in the parent. Format
   * `projects/{project_id}/locations/{location}/moodelMonitors/-/modelMonitoringJobs`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ListModelMonitoringJobsRequest request =
   *       ListModelMonitoringJobsRequest.newBuilder()
   *           .setParent(
   *               ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (ModelMonitoringJob element :
   *       modelMonitoringServiceClient.listModelMonitoringJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListModelMonitoringJobsPagedResponse listModelMonitoringJobs(
      ListModelMonitoringJobsRequest request) {
    return listModelMonitoringJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelMonitoringJobs. Callers may choose to read across multiple Monitors as per
   * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash character) as a wildcard
   * character instead of modelMonitor id in the parent. Format
   * `projects/{project_id}/locations/{location}/moodelMonitors/-/modelMonitoringJobs`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ListModelMonitoringJobsRequest request =
   *       ListModelMonitoringJobsRequest.newBuilder()
   *           .setParent(
   *               ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ModelMonitoringJob> future =
   *       modelMonitoringServiceClient.listModelMonitoringJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ModelMonitoringJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListModelMonitoringJobsRequest, ListModelMonitoringJobsPagedResponse>
      listModelMonitoringJobsPagedCallable() {
    return stub.listModelMonitoringJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ModelMonitoringJobs. Callers may choose to read across multiple Monitors as per
   * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash character) as a wildcard
   * character instead of modelMonitor id in the parent. Format
   * `projects/{project_id}/locations/{location}/moodelMonitors/-/modelMonitoringJobs`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ListModelMonitoringJobsRequest request =
   *       ListModelMonitoringJobsRequest.newBuilder()
   *           .setParent(
   *               ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListModelMonitoringJobsResponse response =
   *         modelMonitoringServiceClient.listModelMonitoringJobsCallable().call(request);
   *     for (ModelMonitoringJob element : response.getModelMonitoringJobsList()) {
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
  public final UnaryCallable<ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse>
      listModelMonitoringJobsCallable() {
    return stub.listModelMonitoringJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ModelMonitoringJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ModelMonitoringJobName name =
   *       ModelMonitoringJobName.of(
   *           "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]");
   *   modelMonitoringServiceClient.deleteModelMonitoringJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model monitoring job to delete. Format:
   *     `projects/{project}/locations/{location}/modelMonitors/{model_monitor}/modelMonitoringJobs/{model_monitoring_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelMonitoringJobAsync(
      ModelMonitoringJobName name) {
    DeleteModelMonitoringJobRequest request =
        DeleteModelMonitoringJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteModelMonitoringJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ModelMonitoringJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   String name =
   *       ModelMonitoringJobName.of(
   *               "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]")
   *           .toString();
   *   modelMonitoringServiceClient.deleteModelMonitoringJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the model monitoring job to delete. Format:
   *     `projects/{project}/locations/{location}/modelMonitors/{model_monitor}/modelMonitoringJobs/{model_monitoring_job}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelMonitoringJobAsync(
      String name) {
    DeleteModelMonitoringJobRequest request =
        DeleteModelMonitoringJobRequest.newBuilder().setName(name).build();
    return deleteModelMonitoringJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ModelMonitoringJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   DeleteModelMonitoringJobRequest request =
   *       DeleteModelMonitoringJobRequest.newBuilder()
   *           .setName(
   *               ModelMonitoringJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]")
   *                   .toString())
   *           .build();
   *   modelMonitoringServiceClient.deleteModelMonitoringJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteModelMonitoringJobAsync(
      DeleteModelMonitoringJobRequest request) {
    return deleteModelMonitoringJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ModelMonitoringJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   DeleteModelMonitoringJobRequest request =
   *       DeleteModelMonitoringJobRequest.newBuilder()
   *           .setName(
   *               ModelMonitoringJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       modelMonitoringServiceClient
   *           .deleteModelMonitoringJobOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteModelMonitoringJobRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitoringJobOperationCallable() {
    return stub.deleteModelMonitoringJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a ModelMonitoringJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   DeleteModelMonitoringJobRequest request =
   *       DeleteModelMonitoringJobRequest.newBuilder()
   *           .setName(
   *               ModelMonitoringJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]", "[MODEL_MONITORING_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       modelMonitoringServiceClient.deleteModelMonitoringJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteModelMonitoringJobRequest, Operation>
      deleteModelMonitoringJobCallable() {
    return stub.deleteModelMonitoringJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Model Monitoring Stats generated within a given time window.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ModelMonitorName modelMonitor =
   *       ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
   *   for (ModelMonitoringStats element :
   *       modelMonitoringServiceClient.searchModelMonitoringStats(modelMonitor).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param modelMonitor Required. ModelMonitor resource name. Format:
   *     `projects/{project}/locations/{location}/modelMonitors/{model_monitor}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchModelMonitoringStatsPagedResponse searchModelMonitoringStats(
      ModelMonitorName modelMonitor) {
    SearchModelMonitoringStatsRequest request =
        SearchModelMonitoringStatsRequest.newBuilder()
            .setModelMonitor(modelMonitor == null ? null : modelMonitor.toString())
            .build();
    return searchModelMonitoringStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Model Monitoring Stats generated within a given time window.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   String modelMonitor =
   *       ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString();
   *   for (ModelMonitoringStats element :
   *       modelMonitoringServiceClient.searchModelMonitoringStats(modelMonitor).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param modelMonitor Required. ModelMonitor resource name. Format:
   *     `projects/{project}/locations/{location}/modelMonitors/{model_monitor}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchModelMonitoringStatsPagedResponse searchModelMonitoringStats(
      String modelMonitor) {
    SearchModelMonitoringStatsRequest request =
        SearchModelMonitoringStatsRequest.newBuilder().setModelMonitor(modelMonitor).build();
    return searchModelMonitoringStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Model Monitoring Stats generated within a given time window.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   SearchModelMonitoringStatsRequest request =
   *       SearchModelMonitoringStatsRequest.newBuilder()
   *           .setModelMonitor(
   *               ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setStatsFilter(SearchModelMonitoringStatsFilter.newBuilder().build())
   *           .setTimeInterval(Interval.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ModelMonitoringStats element :
   *       modelMonitoringServiceClient.searchModelMonitoringStats(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchModelMonitoringStatsPagedResponse searchModelMonitoringStats(
      SearchModelMonitoringStatsRequest request) {
    return searchModelMonitoringStatsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Model Monitoring Stats generated within a given time window.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   SearchModelMonitoringStatsRequest request =
   *       SearchModelMonitoringStatsRequest.newBuilder()
   *           .setModelMonitor(
   *               ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setStatsFilter(SearchModelMonitoringStatsFilter.newBuilder().build())
   *           .setTimeInterval(Interval.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ModelMonitoringStats> future =
   *       modelMonitoringServiceClient
   *           .searchModelMonitoringStatsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (ModelMonitoringStats element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SearchModelMonitoringStatsRequest, SearchModelMonitoringStatsPagedResponse>
      searchModelMonitoringStatsPagedCallable() {
    return stub.searchModelMonitoringStatsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Model Monitoring Stats generated within a given time window.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   SearchModelMonitoringStatsRequest request =
   *       SearchModelMonitoringStatsRequest.newBuilder()
   *           .setModelMonitor(
   *               ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setStatsFilter(SearchModelMonitoringStatsFilter.newBuilder().build())
   *           .setTimeInterval(Interval.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchModelMonitoringStatsResponse response =
   *         modelMonitoringServiceClient.searchModelMonitoringStatsCallable().call(request);
   *     for (ModelMonitoringStats element : response.getMonitoringStatsList()) {
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
  public final UnaryCallable<SearchModelMonitoringStatsRequest, SearchModelMonitoringStatsResponse>
      searchModelMonitoringStatsCallable() {
    return stub.searchModelMonitoringStatsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Model Monitoring alerts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ModelMonitorName modelMonitor =
   *       ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]");
   *   for (ModelMonitoringAlert element :
   *       modelMonitoringServiceClient.searchModelMonitoringAlerts(modelMonitor).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param modelMonitor Required. ModelMonitor resource name. Format:
   *     `projects/{project}/locations/{location}/modelMonitors/{model_monitor}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchModelMonitoringAlertsPagedResponse searchModelMonitoringAlerts(
      ModelMonitorName modelMonitor) {
    SearchModelMonitoringAlertsRequest request =
        SearchModelMonitoringAlertsRequest.newBuilder()
            .setModelMonitor(modelMonitor == null ? null : modelMonitor.toString())
            .build();
    return searchModelMonitoringAlerts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Model Monitoring alerts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   String modelMonitor =
   *       ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString();
   *   for (ModelMonitoringAlert element :
   *       modelMonitoringServiceClient.searchModelMonitoringAlerts(modelMonitor).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param modelMonitor Required. ModelMonitor resource name. Format:
   *     `projects/{project}/locations/{location}/modelMonitors/{model_monitor}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchModelMonitoringAlertsPagedResponse searchModelMonitoringAlerts(
      String modelMonitor) {
    SearchModelMonitoringAlertsRequest request =
        SearchModelMonitoringAlertsRequest.newBuilder().setModelMonitor(modelMonitor).build();
    return searchModelMonitoringAlerts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Model Monitoring alerts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   SearchModelMonitoringAlertsRequest request =
   *       SearchModelMonitoringAlertsRequest.newBuilder()
   *           .setModelMonitor(
   *               ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setModelMonitoringJob("modelMonitoringJob1196104108")
   *           .setAlertTimeInterval(Interval.newBuilder().build())
   *           .setStatsName("statsName-2073146422")
   *           .setObjectiveType("objectiveType1316845587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ModelMonitoringAlert element :
   *       modelMonitoringServiceClient.searchModelMonitoringAlerts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchModelMonitoringAlertsPagedResponse searchModelMonitoringAlerts(
      SearchModelMonitoringAlertsRequest request) {
    return searchModelMonitoringAlertsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Model Monitoring alerts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   SearchModelMonitoringAlertsRequest request =
   *       SearchModelMonitoringAlertsRequest.newBuilder()
   *           .setModelMonitor(
   *               ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setModelMonitoringJob("modelMonitoringJob1196104108")
   *           .setAlertTimeInterval(Interval.newBuilder().build())
   *           .setStatsName("statsName-2073146422")
   *           .setObjectiveType("objectiveType1316845587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ModelMonitoringAlert> future =
   *       modelMonitoringServiceClient
   *           .searchModelMonitoringAlertsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (ModelMonitoringAlert element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SearchModelMonitoringAlertsRequest, SearchModelMonitoringAlertsPagedResponse>
      searchModelMonitoringAlertsPagedCallable() {
    return stub.searchModelMonitoringAlertsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the Model Monitoring alerts.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   SearchModelMonitoringAlertsRequest request =
   *       SearchModelMonitoringAlertsRequest.newBuilder()
   *           .setModelMonitor(
   *               ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
   *           .setModelMonitoringJob("modelMonitoringJob1196104108")
   *           .setAlertTimeInterval(Interval.newBuilder().build())
   *           .setStatsName("statsName-2073146422")
   *           .setObjectiveType("objectiveType1316845587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchModelMonitoringAlertsResponse response =
   *         modelMonitoringServiceClient.searchModelMonitoringAlertsCallable().call(request);
   *     for (ModelMonitoringAlert element : response.getModelMonitoringAlertsList()) {
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
          SearchModelMonitoringAlertsRequest, SearchModelMonitoringAlertsResponse>
      searchModelMonitoringAlertsCallable() {
    return stub.searchModelMonitoringAlertsCallable();
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
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : modelMonitoringServiceClient.listLocations(request).iterateAll()) {
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
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       modelMonitoringServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         modelMonitoringServiceClient.listLocationsCallable().call(request);
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
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = modelMonitoringServiceClient.getLocation(request);
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
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       modelMonitoringServiceClient.getLocationCallable().futureCall(request);
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
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = modelMonitoringServiceClient.setIamPolicy(request);
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
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
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
   *       modelMonitoringServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = modelMonitoringServiceClient.getIamPolicy(request);
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
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       modelMonitoringServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       modelMonitoringServiceClient.testIamPermissions(request);
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
   * try (ModelMonitoringServiceClient modelMonitoringServiceClient =
   *     ModelMonitoringServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       modelMonitoringServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListModelMonitorsPagedResponse
      extends AbstractPagedListResponse<
          ListModelMonitorsRequest,
          ListModelMonitorsResponse,
          ModelMonitor,
          ListModelMonitorsPage,
          ListModelMonitorsFixedSizeCollection> {

    public static ApiFuture<ListModelMonitorsPagedResponse> createAsync(
        PageContext<ListModelMonitorsRequest, ListModelMonitorsResponse, ModelMonitor> context,
        ApiFuture<ListModelMonitorsResponse> futureResponse) {
      ApiFuture<ListModelMonitorsPage> futurePage =
          ListModelMonitorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListModelMonitorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListModelMonitorsPagedResponse(ListModelMonitorsPage page) {
      super(page, ListModelMonitorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListModelMonitorsPage
      extends AbstractPage<
          ListModelMonitorsRequest,
          ListModelMonitorsResponse,
          ModelMonitor,
          ListModelMonitorsPage> {

    private ListModelMonitorsPage(
        PageContext<ListModelMonitorsRequest, ListModelMonitorsResponse, ModelMonitor> context,
        ListModelMonitorsResponse response) {
      super(context, response);
    }

    private static ListModelMonitorsPage createEmptyPage() {
      return new ListModelMonitorsPage(null, null);
    }

    @Override
    protected ListModelMonitorsPage createPage(
        PageContext<ListModelMonitorsRequest, ListModelMonitorsResponse, ModelMonitor> context,
        ListModelMonitorsResponse response) {
      return new ListModelMonitorsPage(context, response);
    }

    @Override
    public ApiFuture<ListModelMonitorsPage> createPageAsync(
        PageContext<ListModelMonitorsRequest, ListModelMonitorsResponse, ModelMonitor> context,
        ApiFuture<ListModelMonitorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListModelMonitorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListModelMonitorsRequest,
          ListModelMonitorsResponse,
          ModelMonitor,
          ListModelMonitorsPage,
          ListModelMonitorsFixedSizeCollection> {

    private ListModelMonitorsFixedSizeCollection(
        List<ListModelMonitorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListModelMonitorsFixedSizeCollection createEmptyCollection() {
      return new ListModelMonitorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListModelMonitorsFixedSizeCollection createCollection(
        List<ListModelMonitorsPage> pages, int collectionSize) {
      return new ListModelMonitorsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListModelMonitoringJobsPagedResponse
      extends AbstractPagedListResponse<
          ListModelMonitoringJobsRequest,
          ListModelMonitoringJobsResponse,
          ModelMonitoringJob,
          ListModelMonitoringJobsPage,
          ListModelMonitoringJobsFixedSizeCollection> {

    public static ApiFuture<ListModelMonitoringJobsPagedResponse> createAsync(
        PageContext<
                ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse, ModelMonitoringJob>
            context,
        ApiFuture<ListModelMonitoringJobsResponse> futureResponse) {
      ApiFuture<ListModelMonitoringJobsPage> futurePage =
          ListModelMonitoringJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListModelMonitoringJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListModelMonitoringJobsPagedResponse(ListModelMonitoringJobsPage page) {
      super(page, ListModelMonitoringJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListModelMonitoringJobsPage
      extends AbstractPage<
          ListModelMonitoringJobsRequest,
          ListModelMonitoringJobsResponse,
          ModelMonitoringJob,
          ListModelMonitoringJobsPage> {

    private ListModelMonitoringJobsPage(
        PageContext<
                ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse, ModelMonitoringJob>
            context,
        ListModelMonitoringJobsResponse response) {
      super(context, response);
    }

    private static ListModelMonitoringJobsPage createEmptyPage() {
      return new ListModelMonitoringJobsPage(null, null);
    }

    @Override
    protected ListModelMonitoringJobsPage createPage(
        PageContext<
                ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse, ModelMonitoringJob>
            context,
        ListModelMonitoringJobsResponse response) {
      return new ListModelMonitoringJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListModelMonitoringJobsPage> createPageAsync(
        PageContext<
                ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse, ModelMonitoringJob>
            context,
        ApiFuture<ListModelMonitoringJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListModelMonitoringJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListModelMonitoringJobsRequest,
          ListModelMonitoringJobsResponse,
          ModelMonitoringJob,
          ListModelMonitoringJobsPage,
          ListModelMonitoringJobsFixedSizeCollection> {

    private ListModelMonitoringJobsFixedSizeCollection(
        List<ListModelMonitoringJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListModelMonitoringJobsFixedSizeCollection createEmptyCollection() {
      return new ListModelMonitoringJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListModelMonitoringJobsFixedSizeCollection createCollection(
        List<ListModelMonitoringJobsPage> pages, int collectionSize) {
      return new ListModelMonitoringJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchModelMonitoringStatsPagedResponse
      extends AbstractPagedListResponse<
          SearchModelMonitoringStatsRequest,
          SearchModelMonitoringStatsResponse,
          ModelMonitoringStats,
          SearchModelMonitoringStatsPage,
          SearchModelMonitoringStatsFixedSizeCollection> {

    public static ApiFuture<SearchModelMonitoringStatsPagedResponse> createAsync(
        PageContext<
                SearchModelMonitoringStatsRequest,
                SearchModelMonitoringStatsResponse,
                ModelMonitoringStats>
            context,
        ApiFuture<SearchModelMonitoringStatsResponse> futureResponse) {
      ApiFuture<SearchModelMonitoringStatsPage> futurePage =
          SearchModelMonitoringStatsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchModelMonitoringStatsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchModelMonitoringStatsPagedResponse(SearchModelMonitoringStatsPage page) {
      super(page, SearchModelMonitoringStatsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchModelMonitoringStatsPage
      extends AbstractPage<
          SearchModelMonitoringStatsRequest,
          SearchModelMonitoringStatsResponse,
          ModelMonitoringStats,
          SearchModelMonitoringStatsPage> {

    private SearchModelMonitoringStatsPage(
        PageContext<
                SearchModelMonitoringStatsRequest,
                SearchModelMonitoringStatsResponse,
                ModelMonitoringStats>
            context,
        SearchModelMonitoringStatsResponse response) {
      super(context, response);
    }

    private static SearchModelMonitoringStatsPage createEmptyPage() {
      return new SearchModelMonitoringStatsPage(null, null);
    }

    @Override
    protected SearchModelMonitoringStatsPage createPage(
        PageContext<
                SearchModelMonitoringStatsRequest,
                SearchModelMonitoringStatsResponse,
                ModelMonitoringStats>
            context,
        SearchModelMonitoringStatsResponse response) {
      return new SearchModelMonitoringStatsPage(context, response);
    }

    @Override
    public ApiFuture<SearchModelMonitoringStatsPage> createPageAsync(
        PageContext<
                SearchModelMonitoringStatsRequest,
                SearchModelMonitoringStatsResponse,
                ModelMonitoringStats>
            context,
        ApiFuture<SearchModelMonitoringStatsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchModelMonitoringStatsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchModelMonitoringStatsRequest,
          SearchModelMonitoringStatsResponse,
          ModelMonitoringStats,
          SearchModelMonitoringStatsPage,
          SearchModelMonitoringStatsFixedSizeCollection> {

    private SearchModelMonitoringStatsFixedSizeCollection(
        List<SearchModelMonitoringStatsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchModelMonitoringStatsFixedSizeCollection createEmptyCollection() {
      return new SearchModelMonitoringStatsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchModelMonitoringStatsFixedSizeCollection createCollection(
        List<SearchModelMonitoringStatsPage> pages, int collectionSize) {
      return new SearchModelMonitoringStatsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchModelMonitoringAlertsPagedResponse
      extends AbstractPagedListResponse<
          SearchModelMonitoringAlertsRequest,
          SearchModelMonitoringAlertsResponse,
          ModelMonitoringAlert,
          SearchModelMonitoringAlertsPage,
          SearchModelMonitoringAlertsFixedSizeCollection> {

    public static ApiFuture<SearchModelMonitoringAlertsPagedResponse> createAsync(
        PageContext<
                SearchModelMonitoringAlertsRequest,
                SearchModelMonitoringAlertsResponse,
                ModelMonitoringAlert>
            context,
        ApiFuture<SearchModelMonitoringAlertsResponse> futureResponse) {
      ApiFuture<SearchModelMonitoringAlertsPage> futurePage =
          SearchModelMonitoringAlertsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchModelMonitoringAlertsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchModelMonitoringAlertsPagedResponse(SearchModelMonitoringAlertsPage page) {
      super(page, SearchModelMonitoringAlertsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchModelMonitoringAlertsPage
      extends AbstractPage<
          SearchModelMonitoringAlertsRequest,
          SearchModelMonitoringAlertsResponse,
          ModelMonitoringAlert,
          SearchModelMonitoringAlertsPage> {

    private SearchModelMonitoringAlertsPage(
        PageContext<
                SearchModelMonitoringAlertsRequest,
                SearchModelMonitoringAlertsResponse,
                ModelMonitoringAlert>
            context,
        SearchModelMonitoringAlertsResponse response) {
      super(context, response);
    }

    private static SearchModelMonitoringAlertsPage createEmptyPage() {
      return new SearchModelMonitoringAlertsPage(null, null);
    }

    @Override
    protected SearchModelMonitoringAlertsPage createPage(
        PageContext<
                SearchModelMonitoringAlertsRequest,
                SearchModelMonitoringAlertsResponse,
                ModelMonitoringAlert>
            context,
        SearchModelMonitoringAlertsResponse response) {
      return new SearchModelMonitoringAlertsPage(context, response);
    }

    @Override
    public ApiFuture<SearchModelMonitoringAlertsPage> createPageAsync(
        PageContext<
                SearchModelMonitoringAlertsRequest,
                SearchModelMonitoringAlertsResponse,
                ModelMonitoringAlert>
            context,
        ApiFuture<SearchModelMonitoringAlertsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchModelMonitoringAlertsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchModelMonitoringAlertsRequest,
          SearchModelMonitoringAlertsResponse,
          ModelMonitoringAlert,
          SearchModelMonitoringAlertsPage,
          SearchModelMonitoringAlertsFixedSizeCollection> {

    private SearchModelMonitoringAlertsFixedSizeCollection(
        List<SearchModelMonitoringAlertsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchModelMonitoringAlertsFixedSizeCollection createEmptyCollection() {
      return new SearchModelMonitoringAlertsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchModelMonitoringAlertsFixedSizeCollection createCollection(
        List<SearchModelMonitoringAlertsPage> pages, int collectionSize) {
      return new SearchModelMonitoringAlertsFixedSizeCollection(pages, collectionSize);
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
