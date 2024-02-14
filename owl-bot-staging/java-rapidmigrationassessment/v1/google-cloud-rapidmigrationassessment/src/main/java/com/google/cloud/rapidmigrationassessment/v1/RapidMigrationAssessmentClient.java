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

package com.google.cloud.rapidmigrationassessment.v1;

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
import com.google.cloud.rapidmigrationassessment.v1.stub.RapidMigrationAssessmentStub;
import com.google.cloud.rapidmigrationassessment.v1.stub.RapidMigrationAssessmentStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
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
 * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
 *     RapidMigrationAssessmentClient.create()) {
 *   AnnotationName name = AnnotationName.of("[PROJECT]", "[LOCATION]", "[ANNOTATION]");
 *   Annotation response = rapidMigrationAssessmentClient.getAnnotation(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RapidMigrationAssessmentClient object to clean up
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
 *      <td><p> CreateCollector</td>
 *      <td><p> Create a Collector to manage the on-prem appliance which collects information about Customer assets.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCollectorAsync(CreateCollectorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createCollectorAsync(LocationName parent, Collector collector, String collectorId)
 *           <li><p> createCollectorAsync(String parent, Collector collector, String collectorId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCollectorOperationCallable()
 *           <li><p> createCollectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAnnotation</td>
 *      <td><p> Creates an Annotation</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAnnotationAsync(CreateAnnotationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAnnotationAsync(LocationName parent, Annotation annotation)
 *           <li><p> createAnnotationAsync(String parent, Annotation annotation)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAnnotationOperationCallable()
 *           <li><p> createAnnotationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAnnotation</td>
 *      <td><p> Gets details of a single Annotation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAnnotation(GetAnnotationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAnnotation(AnnotationName name)
 *           <li><p> getAnnotation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAnnotationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCollectors</td>
 *      <td><p> Lists Collectors in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCollectors(ListCollectorsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCollectors(LocationName parent)
 *           <li><p> listCollectors(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCollectorsPagedCallable()
 *           <li><p> listCollectorsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCollector</td>
 *      <td><p> Gets details of a single Collector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCollector(GetCollectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCollector(CollectorName name)
 *           <li><p> getCollector(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCollectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCollector</td>
 *      <td><p> Updates the parameters of a single Collector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCollectorAsync(UpdateCollectorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateCollectorAsync(Collector collector, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCollectorOperationCallable()
 *           <li><p> updateCollectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCollector</td>
 *      <td><p> Deletes a single Collector - changes state of collector to "Deleting". Background jobs does final deletion thorugh producer api.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCollectorAsync(DeleteCollectorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteCollectorAsync(CollectorName name)
 *           <li><p> deleteCollectorAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCollectorOperationCallable()
 *           <li><p> deleteCollectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResumeCollector</td>
 *      <td><p> Resumes the given collector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resumeCollectorAsync(ResumeCollectorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> resumeCollectorAsync(CollectorName name)
 *           <li><p> resumeCollectorAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resumeCollectorOperationCallable()
 *           <li><p> resumeCollectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RegisterCollector</td>
 *      <td><p> Registers the given collector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> registerCollectorAsync(RegisterCollectorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> registerCollectorAsync(CollectorName name)
 *           <li><p> registerCollectorAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> registerCollectorOperationCallable()
 *           <li><p> registerCollectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PauseCollector</td>
 *      <td><p> Pauses the given collector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> pauseCollectorAsync(PauseCollectorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> pauseCollectorAsync(CollectorName name)
 *           <li><p> pauseCollectorAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> pauseCollectorOperationCallable()
 *           <li><p> pauseCollectorCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * RapidMigrationAssessmentSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RapidMigrationAssessmentSettings rapidMigrationAssessmentSettings =
 *     RapidMigrationAssessmentSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
 *     RapidMigrationAssessmentClient.create(rapidMigrationAssessmentSettings);
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
 * RapidMigrationAssessmentSettings rapidMigrationAssessmentSettings =
 *     RapidMigrationAssessmentSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
 *     RapidMigrationAssessmentClient.create(rapidMigrationAssessmentSettings);
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
 * RapidMigrationAssessmentSettings rapidMigrationAssessmentSettings =
 *     RapidMigrationAssessmentSettings.newHttpJsonBuilder().build();
 * RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
 *     RapidMigrationAssessmentClient.create(rapidMigrationAssessmentSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RapidMigrationAssessmentClient implements BackgroundResource {
  private final RapidMigrationAssessmentSettings settings;
  private final RapidMigrationAssessmentStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of RapidMigrationAssessmentClient with default settings. */
  public static final RapidMigrationAssessmentClient create() throws IOException {
    return create(RapidMigrationAssessmentSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RapidMigrationAssessmentClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RapidMigrationAssessmentClient create(
      RapidMigrationAssessmentSettings settings) throws IOException {
    return new RapidMigrationAssessmentClient(settings);
  }

  /**
   * Constructs an instance of RapidMigrationAssessmentClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(RapidMigrationAssessmentSettings).
   */
  public static final RapidMigrationAssessmentClient create(RapidMigrationAssessmentStub stub) {
    return new RapidMigrationAssessmentClient(stub);
  }

  /**
   * Constructs an instance of RapidMigrationAssessmentClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RapidMigrationAssessmentClient(RapidMigrationAssessmentSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RapidMigrationAssessmentStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected RapidMigrationAssessmentClient(RapidMigrationAssessmentStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final RapidMigrationAssessmentSettings getSettings() {
    return settings;
  }

  public RapidMigrationAssessmentStub getStub() {
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
   * Create a Collector to manage the on-prem appliance which collects information about Customer
   * assets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Collector collector = Collector.newBuilder().build();
   *   String collectorId = "collectorId1854072456";
   *   Collector response =
   *       rapidMigrationAssessmentClient.createCollectorAsync(parent, collector, collectorId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent (project+location).
   * @param collector Required. The resource being created.
   * @param collectorId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> createCollectorAsync(
      LocationName parent, Collector collector, String collectorId) {
    CreateCollectorRequest request =
        CreateCollectorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCollector(collector)
            .setCollectorId(collectorId)
            .build();
    return createCollectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a Collector to manage the on-prem appliance which collects information about Customer
   * assets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Collector collector = Collector.newBuilder().build();
   *   String collectorId = "collectorId1854072456";
   *   Collector response =
   *       rapidMigrationAssessmentClient.createCollectorAsync(parent, collector, collectorId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent (project+location).
   * @param collector Required. The resource being created.
   * @param collectorId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> createCollectorAsync(
      String parent, Collector collector, String collectorId) {
    CreateCollectorRequest request =
        CreateCollectorRequest.newBuilder()
            .setParent(parent)
            .setCollector(collector)
            .setCollectorId(collectorId)
            .build();
    return createCollectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a Collector to manage the on-prem appliance which collects information about Customer
   * assets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   CreateCollectorRequest request =
   *       CreateCollectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCollectorId("collectorId1854072456")
   *           .setCollector(Collector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Collector response = rapidMigrationAssessmentClient.createCollectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> createCollectorAsync(
      CreateCollectorRequest request) {
    return createCollectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a Collector to manage the on-prem appliance which collects information about Customer
   * assets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   CreateCollectorRequest request =
   *       CreateCollectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCollectorId("collectorId1854072456")
   *           .setCollector(Collector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Collector, OperationMetadata> future =
   *       rapidMigrationAssessmentClient.createCollectorOperationCallable().futureCall(request);
   *   // Do something.
   *   Collector response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCollectorRequest, Collector, OperationMetadata>
      createCollectorOperationCallable() {
    return stub.createCollectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a Collector to manage the on-prem appliance which collects information about Customer
   * assets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   CreateCollectorRequest request =
   *       CreateCollectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCollectorId("collectorId1854072456")
   *           .setCollector(Collector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       rapidMigrationAssessmentClient.createCollectorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCollectorRequest, Operation> createCollectorCallable() {
    return stub.createCollectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Annotation
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Annotation annotation = Annotation.newBuilder().build();
   *   Annotation response =
   *       rapidMigrationAssessmentClient.createAnnotationAsync(parent, annotation).get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent (project+location).
   * @param annotation Required. The resource being created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Annotation, OperationMetadata> createAnnotationAsync(
      LocationName parent, Annotation annotation) {
    CreateAnnotationRequest request =
        CreateAnnotationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAnnotation(annotation)
            .build();
    return createAnnotationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Annotation
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Annotation annotation = Annotation.newBuilder().build();
   *   Annotation response =
   *       rapidMigrationAssessmentClient.createAnnotationAsync(parent, annotation).get();
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent (project+location).
   * @param annotation Required. The resource being created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Annotation, OperationMetadata> createAnnotationAsync(
      String parent, Annotation annotation) {
    CreateAnnotationRequest request =
        CreateAnnotationRequest.newBuilder().setParent(parent).setAnnotation(annotation).build();
    return createAnnotationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Annotation
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   CreateAnnotationRequest request =
   *       CreateAnnotationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAnnotation(Annotation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Annotation response = rapidMigrationAssessmentClient.createAnnotationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Annotation, OperationMetadata> createAnnotationAsync(
      CreateAnnotationRequest request) {
    return createAnnotationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Annotation
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   CreateAnnotationRequest request =
   *       CreateAnnotationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAnnotation(Annotation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Annotation, OperationMetadata> future =
   *       rapidMigrationAssessmentClient.createAnnotationOperationCallable().futureCall(request);
   *   // Do something.
   *   Annotation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAnnotationRequest, Annotation, OperationMetadata>
      createAnnotationOperationCallable() {
    return stub.createAnnotationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Annotation
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   CreateAnnotationRequest request =
   *       CreateAnnotationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAnnotation(Annotation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       rapidMigrationAssessmentClient.createAnnotationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAnnotationRequest, Operation> createAnnotationCallable() {
    return stub.createAnnotationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Annotation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   AnnotationName name = AnnotationName.of("[PROJECT]", "[LOCATION]", "[ANNOTATION]");
   *   Annotation response = rapidMigrationAssessmentClient.getAnnotation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Annotation getAnnotation(AnnotationName name) {
    GetAnnotationRequest request =
        GetAnnotationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAnnotation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Annotation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   String name = AnnotationName.of("[PROJECT]", "[LOCATION]", "[ANNOTATION]").toString();
   *   Annotation response = rapidMigrationAssessmentClient.getAnnotation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Annotation getAnnotation(String name) {
    GetAnnotationRequest request = GetAnnotationRequest.newBuilder().setName(name).build();
    return getAnnotation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Annotation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   GetAnnotationRequest request =
   *       GetAnnotationRequest.newBuilder()
   *           .setName(AnnotationName.of("[PROJECT]", "[LOCATION]", "[ANNOTATION]").toString())
   *           .build();
   *   Annotation response = rapidMigrationAssessmentClient.getAnnotation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Annotation getAnnotation(GetAnnotationRequest request) {
    return getAnnotationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Annotation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   GetAnnotationRequest request =
   *       GetAnnotationRequest.newBuilder()
   *           .setName(AnnotationName.of("[PROJECT]", "[LOCATION]", "[ANNOTATION]").toString())
   *           .build();
   *   ApiFuture<Annotation> future =
   *       rapidMigrationAssessmentClient.getAnnotationCallable().futureCall(request);
   *   // Do something.
   *   Annotation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAnnotationRequest, Annotation> getAnnotationCallable() {
    return stub.getAnnotationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Collectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Collector element : rapidMigrationAssessmentClient.listCollectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListCollectorsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCollectorsPagedResponse listCollectors(LocationName parent) {
    ListCollectorsRequest request =
        ListCollectorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCollectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Collectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Collector element : rapidMigrationAssessmentClient.listCollectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListCollectorsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCollectorsPagedResponse listCollectors(String parent) {
    ListCollectorsRequest request = ListCollectorsRequest.newBuilder().setParent(parent).build();
    return listCollectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Collectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   ListCollectorsRequest request =
   *       ListCollectorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Collector element :
   *       rapidMigrationAssessmentClient.listCollectors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCollectorsPagedResponse listCollectors(ListCollectorsRequest request) {
    return listCollectorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Collectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   ListCollectorsRequest request =
   *       ListCollectorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Collector> future =
   *       rapidMigrationAssessmentClient.listCollectorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Collector element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCollectorsRequest, ListCollectorsPagedResponse>
      listCollectorsPagedCallable() {
    return stub.listCollectorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Collectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   ListCollectorsRequest request =
   *       ListCollectorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCollectorsResponse response =
   *         rapidMigrationAssessmentClient.listCollectorsCallable().call(request);
   *     for (Collector element : response.getCollectorsList()) {
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
  public final UnaryCallable<ListCollectorsRequest, ListCollectorsResponse>
      listCollectorsCallable() {
    return stub.listCollectorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
   *   Collector response = rapidMigrationAssessmentClient.getCollector(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Collector getCollector(CollectorName name) {
    GetCollectorRequest request =
        GetCollectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCollector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   String name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString();
   *   Collector response = rapidMigrationAssessmentClient.getCollector(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Collector getCollector(String name) {
    GetCollectorRequest request = GetCollectorRequest.newBuilder().setName(name).build();
    return getCollector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   GetCollectorRequest request =
   *       GetCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .build();
   *   Collector response = rapidMigrationAssessmentClient.getCollector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Collector getCollector(GetCollectorRequest request) {
    return getCollectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   GetCollectorRequest request =
   *       GetCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .build();
   *   ApiFuture<Collector> future =
   *       rapidMigrationAssessmentClient.getCollectorCallable().futureCall(request);
   *   // Do something.
   *   Collector response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCollectorRequest, Collector> getCollectorCallable() {
    return stub.getCollectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   Collector collector = Collector.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Collector response =
   *       rapidMigrationAssessmentClient.updateCollectorAsync(collector, updateMask).get();
   * }
   * }</pre>
   *
   * @param collector Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Collector resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> updateCollectorAsync(
      Collector collector, FieldMask updateMask) {
    UpdateCollectorRequest request =
        UpdateCollectorRequest.newBuilder()
            .setCollector(collector)
            .setUpdateMask(updateMask)
            .build();
    return updateCollectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   UpdateCollectorRequest request =
   *       UpdateCollectorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCollector(Collector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Collector response = rapidMigrationAssessmentClient.updateCollectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> updateCollectorAsync(
      UpdateCollectorRequest request) {
    return updateCollectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   UpdateCollectorRequest request =
   *       UpdateCollectorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCollector(Collector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Collector, OperationMetadata> future =
   *       rapidMigrationAssessmentClient.updateCollectorOperationCallable().futureCall(request);
   *   // Do something.
   *   Collector response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateCollectorRequest, Collector, OperationMetadata>
      updateCollectorOperationCallable() {
    return stub.updateCollectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   UpdateCollectorRequest request =
   *       UpdateCollectorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCollector(Collector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       rapidMigrationAssessmentClient.updateCollectorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCollectorRequest, Operation> updateCollectorCallable() {
    return stub.updateCollectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Collector - changes state of collector to "Deleting". Background jobs does
   * final deletion thorugh producer api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
   *   Collector response = rapidMigrationAssessmentClient.deleteCollectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> deleteCollectorAsync(
      CollectorName name) {
    DeleteCollectorRequest request =
        DeleteCollectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteCollectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Collector - changes state of collector to "Deleting". Background jobs does
   * final deletion thorugh producer api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   String name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString();
   *   Collector response = rapidMigrationAssessmentClient.deleteCollectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> deleteCollectorAsync(String name) {
    DeleteCollectorRequest request = DeleteCollectorRequest.newBuilder().setName(name).build();
    return deleteCollectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Collector - changes state of collector to "Deleting". Background jobs does
   * final deletion thorugh producer api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   DeleteCollectorRequest request =
   *       DeleteCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Collector response = rapidMigrationAssessmentClient.deleteCollectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> deleteCollectorAsync(
      DeleteCollectorRequest request) {
    return deleteCollectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Collector - changes state of collector to "Deleting". Background jobs does
   * final deletion thorugh producer api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   DeleteCollectorRequest request =
   *       DeleteCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Collector, OperationMetadata> future =
   *       rapidMigrationAssessmentClient.deleteCollectorOperationCallable().futureCall(request);
   *   // Do something.
   *   Collector response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCollectorRequest, Collector, OperationMetadata>
      deleteCollectorOperationCallable() {
    return stub.deleteCollectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Collector - changes state of collector to "Deleting". Background jobs does
   * final deletion thorugh producer api.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   DeleteCollectorRequest request =
   *       DeleteCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       rapidMigrationAssessmentClient.deleteCollectorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCollectorRequest, Operation> deleteCollectorCallable() {
    return stub.deleteCollectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
   *   Collector response = rapidMigrationAssessmentClient.resumeCollectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> resumeCollectorAsync(
      CollectorName name) {
    ResumeCollectorRequest request =
        ResumeCollectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return resumeCollectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   String name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString();
   *   Collector response = rapidMigrationAssessmentClient.resumeCollectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> resumeCollectorAsync(String name) {
    ResumeCollectorRequest request = ResumeCollectorRequest.newBuilder().setName(name).build();
    return resumeCollectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   ResumeCollectorRequest request =
   *       ResumeCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Collector response = rapidMigrationAssessmentClient.resumeCollectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> resumeCollectorAsync(
      ResumeCollectorRequest request) {
    return resumeCollectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   ResumeCollectorRequest request =
   *       ResumeCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Collector, OperationMetadata> future =
   *       rapidMigrationAssessmentClient.resumeCollectorOperationCallable().futureCall(request);
   *   // Do something.
   *   Collector response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResumeCollectorRequest, Collector, OperationMetadata>
      resumeCollectorOperationCallable() {
    return stub.resumeCollectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   ResumeCollectorRequest request =
   *       ResumeCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       rapidMigrationAssessmentClient.resumeCollectorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResumeCollectorRequest, Operation> resumeCollectorCallable() {
    return stub.resumeCollectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
   *   Collector response = rapidMigrationAssessmentClient.registerCollectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> registerCollectorAsync(
      CollectorName name) {
    RegisterCollectorRequest request =
        RegisterCollectorRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return registerCollectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   String name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString();
   *   Collector response = rapidMigrationAssessmentClient.registerCollectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> registerCollectorAsync(String name) {
    RegisterCollectorRequest request = RegisterCollectorRequest.newBuilder().setName(name).build();
    return registerCollectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   RegisterCollectorRequest request =
   *       RegisterCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Collector response = rapidMigrationAssessmentClient.registerCollectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> registerCollectorAsync(
      RegisterCollectorRequest request) {
    return registerCollectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   RegisterCollectorRequest request =
   *       RegisterCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Collector, OperationMetadata> future =
   *       rapidMigrationAssessmentClient.registerCollectorOperationCallable().futureCall(request);
   *   // Do something.
   *   Collector response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RegisterCollectorRequest, Collector, OperationMetadata>
      registerCollectorOperationCallable() {
    return stub.registerCollectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   RegisterCollectorRequest request =
   *       RegisterCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       rapidMigrationAssessmentClient.registerCollectorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RegisterCollectorRequest, Operation> registerCollectorCallable() {
    return stub.registerCollectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   CollectorName name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]");
   *   Collector response = rapidMigrationAssessmentClient.pauseCollectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> pauseCollectorAsync(
      CollectorName name) {
    PauseCollectorRequest request =
        PauseCollectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return pauseCollectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   String name = CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString();
   *   Collector response = rapidMigrationAssessmentClient.pauseCollectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> pauseCollectorAsync(String name) {
    PauseCollectorRequest request = PauseCollectorRequest.newBuilder().setName(name).build();
    return pauseCollectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   PauseCollectorRequest request =
   *       PauseCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Collector response = rapidMigrationAssessmentClient.pauseCollectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Collector, OperationMetadata> pauseCollectorAsync(
      PauseCollectorRequest request) {
    return pauseCollectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   PauseCollectorRequest request =
   *       PauseCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Collector, OperationMetadata> future =
   *       rapidMigrationAssessmentClient.pauseCollectorOperationCallable().futureCall(request);
   *   // Do something.
   *   Collector response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PauseCollectorRequest, Collector, OperationMetadata>
      pauseCollectorOperationCallable() {
    return stub.pauseCollectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses the given collector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   PauseCollectorRequest request =
   *       PauseCollectorRequest.newBuilder()
   *           .setName(CollectorName.of("[PROJECT]", "[LOCATION]", "[COLLECTOR]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       rapidMigrationAssessmentClient.pauseCollectorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PauseCollectorRequest, Operation> pauseCollectorCallable() {
    return stub.pauseCollectorCallable();
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
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : rapidMigrationAssessmentClient.listLocations(request).iterateAll()) {
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
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       rapidMigrationAssessmentClient.listLocationsPagedCallable().futureCall(request);
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
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         rapidMigrationAssessmentClient.listLocationsCallable().call(request);
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
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = rapidMigrationAssessmentClient.getLocation(request);
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
   * try (RapidMigrationAssessmentClient rapidMigrationAssessmentClient =
   *     RapidMigrationAssessmentClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       rapidMigrationAssessmentClient.getLocationCallable().futureCall(request);
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

  public static class ListCollectorsPagedResponse
      extends AbstractPagedListResponse<
          ListCollectorsRequest,
          ListCollectorsResponse,
          Collector,
          ListCollectorsPage,
          ListCollectorsFixedSizeCollection> {

    public static ApiFuture<ListCollectorsPagedResponse> createAsync(
        PageContext<ListCollectorsRequest, ListCollectorsResponse, Collector> context,
        ApiFuture<ListCollectorsResponse> futureResponse) {
      ApiFuture<ListCollectorsPage> futurePage =
          ListCollectorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCollectorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCollectorsPagedResponse(ListCollectorsPage page) {
      super(page, ListCollectorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCollectorsPage
      extends AbstractPage<
          ListCollectorsRequest, ListCollectorsResponse, Collector, ListCollectorsPage> {

    private ListCollectorsPage(
        PageContext<ListCollectorsRequest, ListCollectorsResponse, Collector> context,
        ListCollectorsResponse response) {
      super(context, response);
    }

    private static ListCollectorsPage createEmptyPage() {
      return new ListCollectorsPage(null, null);
    }

    @Override
    protected ListCollectorsPage createPage(
        PageContext<ListCollectorsRequest, ListCollectorsResponse, Collector> context,
        ListCollectorsResponse response) {
      return new ListCollectorsPage(context, response);
    }

    @Override
    public ApiFuture<ListCollectorsPage> createPageAsync(
        PageContext<ListCollectorsRequest, ListCollectorsResponse, Collector> context,
        ApiFuture<ListCollectorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCollectorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCollectorsRequest,
          ListCollectorsResponse,
          Collector,
          ListCollectorsPage,
          ListCollectorsFixedSizeCollection> {

    private ListCollectorsFixedSizeCollection(List<ListCollectorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCollectorsFixedSizeCollection createEmptyCollection() {
      return new ListCollectorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCollectorsFixedSizeCollection createCollection(
        List<ListCollectorsPage> pages, int collectionSize) {
      return new ListCollectorsFixedSizeCollection(pages, collectionSize);
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
