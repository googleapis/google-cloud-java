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

package com.google.cloud.auditmanager.v1;

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
import com.google.cloud.auditmanager.v1.stub.AuditManagerStub;
import com.google.cloud.auditmanager.v1.stub.AuditManagerStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
 *   String scope = "scope109264468";
 *   List<EnrollResourceRequest.EligibleDestination> destinations = new ArrayList<>();
 *   Enrollment response = auditManagerClient.enrollResource(scope, destinations);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AuditManagerClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> EnrollResource</td>
 *      <td><p> Enrolls the customer resource(folder/project/organization) to the audit manager service by creating the audit managers Service Agent in customers workload and granting required permissions to the Service Agent. Please note that if enrollment request is made on the already enrolled workload then enrollment is executed overriding the existing set of destinations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enrollResource(EnrollResourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> enrollResource(String scope, List&lt;EnrollResourceRequest.EligibleDestination&gt; destinations)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enrollResourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateAuditScopeReport</td>
 *      <td><p> Generates a demo report highlighting different responsibilities (Google/Customer/ shared) required to be fulfilled for the customer's workload to be compliant with the given standard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateAuditScopeReport(GenerateAuditScopeReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateAuditScopeReport(String scope, String complianceStandard, GenerateAuditScopeReportRequest.AuditScopeReportFormat reportFormat)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateAuditScopeReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateAuditReport</td>
 *      <td><p> Register the Audit Report generation requests and returns the OperationId using which the customer can track the report generation progress.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateAuditReportAsync(GenerateAuditReportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> generateAuditReportAsync(String scope, String gcsUri, String complianceStandard, GenerateAuditReportRequest.AuditReportFormat reportFormat)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateAuditReportOperationCallable()
 *           <li><p> generateAuditReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAuditReports</td>
 *      <td><p> Lists audit reports in the selected parent scope</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAuditReports(ListAuditReportsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAuditReports(EnrollmentStatusScopeName parent)
 *           <li><p> listAuditReports(LocationName parent)
 *           <li><p> listAuditReports(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAuditReportsPagedCallable()
 *           <li><p> listAuditReportsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAuditReport</td>
 *      <td><p> Get the overall audit report</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAuditReport(GetAuditReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAuditReport(AuditReportName name)
 *           <li><p> getAuditReport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAuditReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetResourceEnrollmentStatus</td>
 *      <td><p> Get a resource along with its enrollment status.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getResourceEnrollmentStatus(GetResourceEnrollmentStatusRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getResourceEnrollmentStatus(ResourceEnrollmentStatusName name)
 *           <li><p> getResourceEnrollmentStatus(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getResourceEnrollmentStatusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListResourceEnrollmentStatuses</td>
 *      <td><p> Fetches all resources under the parent along with their enrollment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listResourceEnrollmentStatuses(ListResourceEnrollmentStatusesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listResourceEnrollmentStatuses(EnrollmentStatusScopeName parent)
 *           <li><p> listResourceEnrollmentStatuses(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listResourceEnrollmentStatusesPagedCallable()
 *           <li><p> listResourceEnrollmentStatusesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListControls</td>
 *      <td><p> Gets controls needed to be implemented to be compliant to a standard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listControls(ListControlsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listControls(StandardName parent)
 *           <li><p> listControls(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listControlsPagedCallable()
 *           <li><p> listControlsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.This method can be called in two ways:
 * <p> &#42;   &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;   &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or other locations specifically visibleto the project.</td>
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
 * <p>This class can be customized by passing in a custom instance of AuditManagerSettings to
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
 * AuditManagerSettings auditManagerSettings =
 *     AuditManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AuditManagerClient auditManagerClient = AuditManagerClient.create(auditManagerSettings);
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
 * AuditManagerSettings auditManagerSettings =
 *     AuditManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AuditManagerClient auditManagerClient = AuditManagerClient.create(auditManagerSettings);
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
 * AuditManagerSettings auditManagerSettings = AuditManagerSettings.newHttpJsonBuilder().build();
 * AuditManagerClient auditManagerClient = AuditManagerClient.create(auditManagerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AuditManagerClient implements BackgroundResource {
  private final AuditManagerSettings settings;
  private final AuditManagerStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AuditManagerClient with default settings. */
  public static final AuditManagerClient create() throws IOException {
    return create(AuditManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AuditManagerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AuditManagerClient create(AuditManagerSettings settings) throws IOException {
    return new AuditManagerClient(settings);
  }

  /**
   * Constructs an instance of AuditManagerClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AuditManagerSettings).
   */
  public static final AuditManagerClient create(AuditManagerStub stub) {
    return new AuditManagerClient(stub);
  }

  /**
   * Constructs an instance of AuditManagerClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AuditManagerClient(AuditManagerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AuditManagerStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AuditManagerClient(AuditManagerStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AuditManagerSettings getSettings() {
    return settings;
  }

  public AuditManagerStub getStub() {
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
   * Enrolls the customer resource(folder/project/organization) to the audit manager service by
   * creating the audit managers Service Agent in customers workload and granting required
   * permissions to the Service Agent. Please note that if enrollment request is made on the already
   * enrolled workload then enrollment is executed overriding the existing set of destinations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   String scope = "scope109264468";
   *   List<EnrollResourceRequest.EligibleDestination> destinations = new ArrayList<>();
   *   Enrollment response = auditManagerClient.enrollResource(scope, destinations);
   * }
   * }</pre>
   *
   * @param scope Required. The resource to be enrolled to the audit manager. Scope format should be
   *     resource_type/resource_identifier Eg: projects/{project}/locations/{location},
   *     folders/{folder}/locations/{location} organizations/{organization}/locations/{location}
   * @param destinations Required. List of destination among which customer can choose to upload
   *     their reports during the audit process. While enrolling at a organization/folder level,
   *     customer can choose Cloud storage bucket in any project. If the audit is triggered at
   *     project level using the service agent at organization/folder level, all the destination
   *     options associated with respective organization/folder level service agent will be
   *     available to auditing projects.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Enrollment enrollResource(
      String scope, List<EnrollResourceRequest.EligibleDestination> destinations) {
    EnrollResourceRequest request =
        EnrollResourceRequest.newBuilder().setScope(scope).addAllDestinations(destinations).build();
    return enrollResource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enrolls the customer resource(folder/project/organization) to the audit manager service by
   * creating the audit managers Service Agent in customers workload and granting required
   * permissions to the Service Agent. Please note that if enrollment request is made on the already
   * enrolled workload then enrollment is executed overriding the existing set of destinations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   EnrollResourceRequest request =
   *       EnrollResourceRequest.newBuilder()
   *           .setScope("scope109264468")
   *           .addAllDestinations(new ArrayList<EnrollResourceRequest.EligibleDestination>())
   *           .build();
   *   Enrollment response = auditManagerClient.enrollResource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Enrollment enrollResource(EnrollResourceRequest request) {
    return enrollResourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enrolls the customer resource(folder/project/organization) to the audit manager service by
   * creating the audit managers Service Agent in customers workload and granting required
   * permissions to the Service Agent. Please note that if enrollment request is made on the already
   * enrolled workload then enrollment is executed overriding the existing set of destinations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   EnrollResourceRequest request =
   *       EnrollResourceRequest.newBuilder()
   *           .setScope("scope109264468")
   *           .addAllDestinations(new ArrayList<EnrollResourceRequest.EligibleDestination>())
   *           .build();
   *   ApiFuture<Enrollment> future =
   *       auditManagerClient.enrollResourceCallable().futureCall(request);
   *   // Do something.
   *   Enrollment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnrollResourceRequest, Enrollment> enrollResourceCallable() {
    return stub.enrollResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a demo report highlighting different responsibilities (Google/Customer/ shared)
   * required to be fulfilled for the customer's workload to be compliant with the given standard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   String scope = "scope109264468";
   *   String complianceStandard = "complianceStandard-1534269448";
   *   GenerateAuditScopeReportRequest.AuditScopeReportFormat reportFormat =
   *       GenerateAuditScopeReportRequest.AuditScopeReportFormat.forNumber(0);
   *   AuditScopeReport response =
   *       auditManagerClient.generateAuditScopeReport(scope, complianceStandard, reportFormat);
   * }
   * }</pre>
   *
   * @param scope Required. Scope for which the AuditScopeReport is required. Must be of format
   *     resource_type/resource_identifier Eg: projects/{project}/locations/{location},
   *     folders/{folder}/locations/{location}
   * @param complianceStandard Required. Compliance Standard against which the Scope Report must be
   *     generated. Eg: FEDRAMP_MODERATE
   * @param reportFormat Required. The format in which the Scope report bytes should be returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuditScopeReport generateAuditScopeReport(
      String scope,
      String complianceStandard,
      GenerateAuditScopeReportRequest.AuditScopeReportFormat reportFormat) {
    GenerateAuditScopeReportRequest request =
        GenerateAuditScopeReportRequest.newBuilder()
            .setScope(scope)
            .setComplianceStandard(complianceStandard)
            .setReportFormat(reportFormat)
            .build();
    return generateAuditScopeReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a demo report highlighting different responsibilities (Google/Customer/ shared)
   * required to be fulfilled for the customer's workload to be compliant with the given standard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   GenerateAuditScopeReportRequest request =
   *       GenerateAuditScopeReportRequest.newBuilder()
   *           .setScope("scope109264468")
   *           .setComplianceStandard("complianceStandard-1534269448")
   *           .setComplianceFramework("complianceFramework-1808314333")
   *           .build();
   *   AuditScopeReport response = auditManagerClient.generateAuditScopeReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuditScopeReport generateAuditScopeReport(GenerateAuditScopeReportRequest request) {
    return generateAuditScopeReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a demo report highlighting different responsibilities (Google/Customer/ shared)
   * required to be fulfilled for the customer's workload to be compliant with the given standard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   GenerateAuditScopeReportRequest request =
   *       GenerateAuditScopeReportRequest.newBuilder()
   *           .setScope("scope109264468")
   *           .setComplianceStandard("complianceStandard-1534269448")
   *           .setComplianceFramework("complianceFramework-1808314333")
   *           .build();
   *   ApiFuture<AuditScopeReport> future =
   *       auditManagerClient.generateAuditScopeReportCallable().futureCall(request);
   *   // Do something.
   *   AuditScopeReport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateAuditScopeReportRequest, AuditScopeReport>
      generateAuditScopeReportCallable() {
    return stub.generateAuditScopeReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register the Audit Report generation requests and returns the OperationId using which the
   * customer can track the report generation progress.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   String scope = "scope109264468";
   *   String gcsUri = "gcsUri-1251224875";
   *   String complianceStandard = "complianceStandard-1534269448";
   *   GenerateAuditReportRequest.AuditReportFormat reportFormat =
   *       GenerateAuditReportRequest.AuditReportFormat.forNumber(0);
   *   AuditReport response =
   *       auditManagerClient
   *           .generateAuditReportAsync(scope, gcsUri, complianceStandard, reportFormat)
   *           .get();
   * }
   * }</pre>
   *
   * @param scope Required. Scope for which the AuditScopeReport is required. Must be of format
   *     resource_type/resource_identifier Eg: projects/{project}/locations/{location},
   *     folders/{folder}/locations/{location}
   * @param gcsUri Destination Cloud storage bucket where report and evidence must be uploaded. The
   *     Cloud storage bucket provided here must be selected among the buckets entered during the
   *     enrollment process.
   * @param complianceStandard Required. Compliance Standard against which the Scope Report must be
   *     generated. Eg: FEDRAMP_MODERATE
   * @param reportFormat Required. The format in which the audit report should be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AuditReport, OperationMetadata> generateAuditReportAsync(
      String scope,
      String gcsUri,
      String complianceStandard,
      GenerateAuditReportRequest.AuditReportFormat reportFormat) {
    GenerateAuditReportRequest request =
        GenerateAuditReportRequest.newBuilder()
            .setScope(scope)
            .setGcsUri(gcsUri)
            .setComplianceStandard(complianceStandard)
            .setReportFormat(reportFormat)
            .build();
    return generateAuditReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register the Audit Report generation requests and returns the OperationId using which the
   * customer can track the report generation progress.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   GenerateAuditReportRequest request =
   *       GenerateAuditReportRequest.newBuilder()
   *           .setScope("scope109264468")
   *           .setComplianceStandard("complianceStandard-1534269448")
   *           .setComplianceFramework("complianceFramework-1808314333")
   *           .build();
   *   AuditReport response = auditManagerClient.generateAuditReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AuditReport, OperationMetadata> generateAuditReportAsync(
      GenerateAuditReportRequest request) {
    return generateAuditReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register the Audit Report generation requests and returns the OperationId using which the
   * customer can track the report generation progress.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   GenerateAuditReportRequest request =
   *       GenerateAuditReportRequest.newBuilder()
   *           .setScope("scope109264468")
   *           .setComplianceStandard("complianceStandard-1534269448")
   *           .setComplianceFramework("complianceFramework-1808314333")
   *           .build();
   *   OperationFuture<AuditReport, OperationMetadata> future =
   *       auditManagerClient.generateAuditReportOperationCallable().futureCall(request);
   *   // Do something.
   *   AuditReport response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<GenerateAuditReportRequest, AuditReport, OperationMetadata>
      generateAuditReportOperationCallable() {
    return stub.generateAuditReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register the Audit Report generation requests and returns the OperationId using which the
   * customer can track the report generation progress.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   GenerateAuditReportRequest request =
   *       GenerateAuditReportRequest.newBuilder()
   *           .setScope("scope109264468")
   *           .setComplianceStandard("complianceStandard-1534269448")
   *           .setComplianceFramework("complianceFramework-1808314333")
   *           .build();
   *   ApiFuture<Operation> future =
   *       auditManagerClient.generateAuditReportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateAuditReportRequest, Operation> generateAuditReportCallable() {
    return stub.generateAuditReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists audit reports in the selected parent scope
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   EnrollmentStatusScopeName parent =
   *       EnrollmentStatusScopeName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");
   *   for (AuditReport element : auditManagerClient.listAuditReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for which to list the reports.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuditReportsPagedResponse listAuditReports(EnrollmentStatusScopeName parent) {
    ListAuditReportsRequest request =
        ListAuditReportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAuditReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists audit reports in the selected parent scope
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AuditReport element : auditManagerClient.listAuditReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for which to list the reports.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuditReportsPagedResponse listAuditReports(LocationName parent) {
    ListAuditReportsRequest request =
        ListAuditReportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAuditReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists audit reports in the selected parent scope
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AuditReport element : auditManagerClient.listAuditReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for which to list the reports.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuditReportsPagedResponse listAuditReports(String parent) {
    ListAuditReportsRequest request =
        ListAuditReportsRequest.newBuilder().setParent(parent).build();
    return listAuditReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists audit reports in the selected parent scope
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   ListAuditReportsRequest request =
   *       ListAuditReportsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AuditReport element : auditManagerClient.listAuditReports(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuditReportsPagedResponse listAuditReports(ListAuditReportsRequest request) {
    return listAuditReportsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists audit reports in the selected parent scope
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   ListAuditReportsRequest request =
   *       ListAuditReportsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AuditReport> future =
   *       auditManagerClient.listAuditReportsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AuditReport element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAuditReportsRequest, ListAuditReportsPagedResponse>
      listAuditReportsPagedCallable() {
    return stub.listAuditReportsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists audit reports in the selected parent scope
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   ListAuditReportsRequest request =
   *       ListAuditReportsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAuditReportsResponse response =
   *         auditManagerClient.listAuditReportsCallable().call(request);
   *     for (AuditReport element : response.getAuditReportsList()) {
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
  public final UnaryCallable<ListAuditReportsRequest, ListAuditReportsResponse>
      listAuditReportsCallable() {
    return stub.listAuditReportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the overall audit report
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   AuditReportName name =
   *       AuditReportName.ofFolderLocationAuditReportName(
   *           "[FOLDER]", "[LOCATION]", "[AUDIT_REPORT]");
   *   AuditReport response = auditManagerClient.getAuditReport(name);
   * }
   * }</pre>
   *
   * @param name Required. Format
   *     projects/{project}/locations/{location}/auditReports/{audit_report},
   *     folders/{folder}/locations/{location}/auditReports/{audit_report}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuditReport getAuditReport(AuditReportName name) {
    GetAuditReportRequest request =
        GetAuditReportRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAuditReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the overall audit report
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   String name =
   *       AuditReportName.ofProjectLocationAuditReportName(
   *               "[PROJECT]", "[LOCATION]", "[AUDIT_REPORT]")
   *           .toString();
   *   AuditReport response = auditManagerClient.getAuditReport(name);
   * }
   * }</pre>
   *
   * @param name Required. Format
   *     projects/{project}/locations/{location}/auditReports/{audit_report},
   *     folders/{folder}/locations/{location}/auditReports/{audit_report}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuditReport getAuditReport(String name) {
    GetAuditReportRequest request = GetAuditReportRequest.newBuilder().setName(name).build();
    return getAuditReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the overall audit report
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   GetAuditReportRequest request =
   *       GetAuditReportRequest.newBuilder()
   *           .setName(
   *               AuditReportName.ofFolderLocationAuditReportName(
   *                       "[FOLDER]", "[LOCATION]", "[AUDIT_REPORT]")
   *                   .toString())
   *           .build();
   *   AuditReport response = auditManagerClient.getAuditReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuditReport getAuditReport(GetAuditReportRequest request) {
    return getAuditReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the overall audit report
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   GetAuditReportRequest request =
   *       GetAuditReportRequest.newBuilder()
   *           .setName(
   *               AuditReportName.ofFolderLocationAuditReportName(
   *                       "[FOLDER]", "[LOCATION]", "[AUDIT_REPORT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AuditReport> future =
   *       auditManagerClient.getAuditReportCallable().futureCall(request);
   *   // Do something.
   *   AuditReport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAuditReportRequest, AuditReport> getAuditReportCallable() {
    return stub.getAuditReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a resource along with its enrollment status.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   ResourceEnrollmentStatusName name =
   *       ResourceEnrollmentStatusName.ofProjectLocationResourceEnrollmentStatusName(
   *           "[PROJECT]", "[LOCATION]", "[RESOURCE_ENROLLMENT_STATUS]");
   *   ResourceEnrollmentStatus response = auditManagerClient.getResourceEnrollmentStatus(name);
   * }
   * }</pre>
   *
   * @param name Required. Format
   *     folders/{folder}/locations/{location}/resourceEnrollmentStatuses/{resource_enrollment_status},
   *     projects/{project}/locations/{location}/resourceEnrollmentStatuses/{resource_enrollment_status},
   *     organizations/{organization}/locations/{location}/resourceEnrollmentStatuses/{resource_enrollment_status}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceEnrollmentStatus getResourceEnrollmentStatus(
      ResourceEnrollmentStatusName name) {
    GetResourceEnrollmentStatusRequest request =
        GetResourceEnrollmentStatusRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getResourceEnrollmentStatus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a resource along with its enrollment status.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   String name =
   *       ResourceEnrollmentStatusName.ofFolderLocationResourceEnrollmentStatusName(
   *               "[FOLDER]", "[LOCATION]", "[RESOURCE_ENROLLMENT_STATUS]")
   *           .toString();
   *   ResourceEnrollmentStatus response = auditManagerClient.getResourceEnrollmentStatus(name);
   * }
   * }</pre>
   *
   * @param name Required. Format
   *     folders/{folder}/locations/{location}/resourceEnrollmentStatuses/{resource_enrollment_status},
   *     projects/{project}/locations/{location}/resourceEnrollmentStatuses/{resource_enrollment_status},
   *     organizations/{organization}/locations/{location}/resourceEnrollmentStatuses/{resource_enrollment_status}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceEnrollmentStatus getResourceEnrollmentStatus(String name) {
    GetResourceEnrollmentStatusRequest request =
        GetResourceEnrollmentStatusRequest.newBuilder().setName(name).build();
    return getResourceEnrollmentStatus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a resource along with its enrollment status.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   GetResourceEnrollmentStatusRequest request =
   *       GetResourceEnrollmentStatusRequest.newBuilder()
   *           .setName(
   *               ResourceEnrollmentStatusName.ofProjectLocationResourceEnrollmentStatusName(
   *                       "[PROJECT]", "[LOCATION]", "[RESOURCE_ENROLLMENT_STATUS]")
   *                   .toString())
   *           .build();
   *   ResourceEnrollmentStatus response = auditManagerClient.getResourceEnrollmentStatus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceEnrollmentStatus getResourceEnrollmentStatus(
      GetResourceEnrollmentStatusRequest request) {
    return getResourceEnrollmentStatusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a resource along with its enrollment status.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   GetResourceEnrollmentStatusRequest request =
   *       GetResourceEnrollmentStatusRequest.newBuilder()
   *           .setName(
   *               ResourceEnrollmentStatusName.ofProjectLocationResourceEnrollmentStatusName(
   *                       "[PROJECT]", "[LOCATION]", "[RESOURCE_ENROLLMENT_STATUS]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ResourceEnrollmentStatus> future =
   *       auditManagerClient.getResourceEnrollmentStatusCallable().futureCall(request);
   *   // Do something.
   *   ResourceEnrollmentStatus response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
      getResourceEnrollmentStatusCallable() {
    return stub.getResourceEnrollmentStatusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches all resources under the parent along with their enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   EnrollmentStatusScopeName parent =
   *       EnrollmentStatusScopeName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");
   *   for (ResourceEnrollmentStatus element :
   *       auditManagerClient.listResourceEnrollmentStatuses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for which the list of resources with enrollments are
   *     required.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceEnrollmentStatusesPagedResponse listResourceEnrollmentStatuses(
      EnrollmentStatusScopeName parent) {
    ListResourceEnrollmentStatusesRequest request =
        ListResourceEnrollmentStatusesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listResourceEnrollmentStatuses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches all resources under the parent along with their enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   String parent =
   *       EnrollmentStatusScopeName.ofFolderLocationName("[FOLDER]", "[LOCATION]").toString();
   *   for (ResourceEnrollmentStatus element :
   *       auditManagerClient.listResourceEnrollmentStatuses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent scope for which the list of resources with enrollments are
   *     required.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceEnrollmentStatusesPagedResponse listResourceEnrollmentStatuses(
      String parent) {
    ListResourceEnrollmentStatusesRequest request =
        ListResourceEnrollmentStatusesRequest.newBuilder().setParent(parent).build();
    return listResourceEnrollmentStatuses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches all resources under the parent along with their enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   ListResourceEnrollmentStatusesRequest request =
   *       ListResourceEnrollmentStatusesRequest.newBuilder()
   *           .setParent(
   *               EnrollmentStatusScopeName.ofOrganizationLocationName(
   *                       "[ORGANIZATION]", "[LOCATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ResourceEnrollmentStatus element :
   *       auditManagerClient.listResourceEnrollmentStatuses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceEnrollmentStatusesPagedResponse listResourceEnrollmentStatuses(
      ListResourceEnrollmentStatusesRequest request) {
    return listResourceEnrollmentStatusesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches all resources under the parent along with their enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   ListResourceEnrollmentStatusesRequest request =
   *       ListResourceEnrollmentStatusesRequest.newBuilder()
   *           .setParent(
   *               EnrollmentStatusScopeName.ofOrganizationLocationName(
   *                       "[ORGANIZATION]", "[LOCATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ResourceEnrollmentStatus> future =
   *       auditManagerClient.listResourceEnrollmentStatusesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ResourceEnrollmentStatus element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesPagedResponse>
      listResourceEnrollmentStatusesPagedCallable() {
    return stub.listResourceEnrollmentStatusesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches all resources under the parent along with their enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   ListResourceEnrollmentStatusesRequest request =
   *       ListResourceEnrollmentStatusesRequest.newBuilder()
   *           .setParent(
   *               EnrollmentStatusScopeName.ofOrganizationLocationName(
   *                       "[ORGANIZATION]", "[LOCATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListResourceEnrollmentStatusesResponse response =
   *         auditManagerClient.listResourceEnrollmentStatusesCallable().call(request);
   *     for (ResourceEnrollmentStatus element : response.getResourceEnrollmentStatusesList()) {
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
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
      listResourceEnrollmentStatusesCallable() {
    return stub.listResourceEnrollmentStatusesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets controls needed to be implemented to be compliant to a standard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   StandardName parent =
   *       StandardName.ofOrganizationLocationStandardName(
   *           "[ORGANIZATION]", "[LOCATION]", "[STANDARD]");
   *   for (Control element : auditManagerClient.listControls(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format projects/{project}/locations/{location}/standards/{standard},
   *     folders/{folder}/locations/{location}/standards/{standard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListControlsPagedResponse listControls(StandardName parent) {
    ListControlsRequest request =
        ListControlsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listControls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets controls needed to be implemented to be compliant to a standard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   String parent =
   *       StandardName.ofProjectLocationStandardName("[PROJECT]", "[LOCATION]", "[STANDARD]")
   *           .toString();
   *   for (Control element : auditManagerClient.listControls(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Format projects/{project}/locations/{location}/standards/{standard},
   *     folders/{folder}/locations/{location}/standards/{standard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListControlsPagedResponse listControls(String parent) {
    ListControlsRequest request = ListControlsRequest.newBuilder().setParent(parent).build();
    return listControls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets controls needed to be implemented to be compliant to a standard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   ListControlsRequest request =
   *       ListControlsRequest.newBuilder()
   *           .setParent(
   *               StandardName.ofOrganizationLocationStandardName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[STANDARD]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Control element : auditManagerClient.listControls(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListControlsPagedResponse listControls(ListControlsRequest request) {
    return listControlsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets controls needed to be implemented to be compliant to a standard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   ListControlsRequest request =
   *       ListControlsRequest.newBuilder()
   *           .setParent(
   *               StandardName.ofOrganizationLocationStandardName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[STANDARD]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Control> future =
   *       auditManagerClient.listControlsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Control element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListControlsRequest, ListControlsPagedResponse>
      listControlsPagedCallable() {
    return stub.listControlsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets controls needed to be implemented to be compliant to a standard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   ListControlsRequest request =
   *       ListControlsRequest.newBuilder()
   *           .setParent(
   *               StandardName.ofOrganizationLocationStandardName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[STANDARD]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListControlsResponse response = auditManagerClient.listControlsCallable().call(request);
   *     for (Control element : response.getControlsList()) {
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
  public final UnaryCallable<ListControlsRequest, ListControlsResponse> listControlsCallable() {
    return stub.listControlsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : auditManagerClient.listLocations(request).iterateAll()) {
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
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       auditManagerClient.listLocationsPagedCallable().futureCall(request);
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
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = auditManagerClient.listLocationsCallable().call(request);
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
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = auditManagerClient.getLocation(request);
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
   * try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = auditManagerClient.getLocationCallable().futureCall(request);
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

  public static class ListAuditReportsPagedResponse
      extends AbstractPagedListResponse<
          ListAuditReportsRequest,
          ListAuditReportsResponse,
          AuditReport,
          ListAuditReportsPage,
          ListAuditReportsFixedSizeCollection> {

    public static ApiFuture<ListAuditReportsPagedResponse> createAsync(
        PageContext<ListAuditReportsRequest, ListAuditReportsResponse, AuditReport> context,
        ApiFuture<ListAuditReportsResponse> futureResponse) {
      ApiFuture<ListAuditReportsPage> futurePage =
          ListAuditReportsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAuditReportsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAuditReportsPagedResponse(ListAuditReportsPage page) {
      super(page, ListAuditReportsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAuditReportsPage
      extends AbstractPage<
          ListAuditReportsRequest, ListAuditReportsResponse, AuditReport, ListAuditReportsPage> {

    private ListAuditReportsPage(
        PageContext<ListAuditReportsRequest, ListAuditReportsResponse, AuditReport> context,
        ListAuditReportsResponse response) {
      super(context, response);
    }

    private static ListAuditReportsPage createEmptyPage() {
      return new ListAuditReportsPage(null, null);
    }

    @Override
    protected ListAuditReportsPage createPage(
        PageContext<ListAuditReportsRequest, ListAuditReportsResponse, AuditReport> context,
        ListAuditReportsResponse response) {
      return new ListAuditReportsPage(context, response);
    }

    @Override
    public ApiFuture<ListAuditReportsPage> createPageAsync(
        PageContext<ListAuditReportsRequest, ListAuditReportsResponse, AuditReport> context,
        ApiFuture<ListAuditReportsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAuditReportsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAuditReportsRequest,
          ListAuditReportsResponse,
          AuditReport,
          ListAuditReportsPage,
          ListAuditReportsFixedSizeCollection> {

    private ListAuditReportsFixedSizeCollection(
        List<ListAuditReportsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAuditReportsFixedSizeCollection createEmptyCollection() {
      return new ListAuditReportsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAuditReportsFixedSizeCollection createCollection(
        List<ListAuditReportsPage> pages, int collectionSize) {
      return new ListAuditReportsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListResourceEnrollmentStatusesPagedResponse
      extends AbstractPagedListResponse<
          ListResourceEnrollmentStatusesRequest,
          ListResourceEnrollmentStatusesResponse,
          ResourceEnrollmentStatus,
          ListResourceEnrollmentStatusesPage,
          ListResourceEnrollmentStatusesFixedSizeCollection> {

    public static ApiFuture<ListResourceEnrollmentStatusesPagedResponse> createAsync(
        PageContext<
                ListResourceEnrollmentStatusesRequest,
                ListResourceEnrollmentStatusesResponse,
                ResourceEnrollmentStatus>
            context,
        ApiFuture<ListResourceEnrollmentStatusesResponse> futureResponse) {
      ApiFuture<ListResourceEnrollmentStatusesPage> futurePage =
          ListResourceEnrollmentStatusesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListResourceEnrollmentStatusesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListResourceEnrollmentStatusesPagedResponse(ListResourceEnrollmentStatusesPage page) {
      super(page, ListResourceEnrollmentStatusesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListResourceEnrollmentStatusesPage
      extends AbstractPage<
          ListResourceEnrollmentStatusesRequest,
          ListResourceEnrollmentStatusesResponse,
          ResourceEnrollmentStatus,
          ListResourceEnrollmentStatusesPage> {

    private ListResourceEnrollmentStatusesPage(
        PageContext<
                ListResourceEnrollmentStatusesRequest,
                ListResourceEnrollmentStatusesResponse,
                ResourceEnrollmentStatus>
            context,
        ListResourceEnrollmentStatusesResponse response) {
      super(context, response);
    }

    private static ListResourceEnrollmentStatusesPage createEmptyPage() {
      return new ListResourceEnrollmentStatusesPage(null, null);
    }

    @Override
    protected ListResourceEnrollmentStatusesPage createPage(
        PageContext<
                ListResourceEnrollmentStatusesRequest,
                ListResourceEnrollmentStatusesResponse,
                ResourceEnrollmentStatus>
            context,
        ListResourceEnrollmentStatusesResponse response) {
      return new ListResourceEnrollmentStatusesPage(context, response);
    }

    @Override
    public ApiFuture<ListResourceEnrollmentStatusesPage> createPageAsync(
        PageContext<
                ListResourceEnrollmentStatusesRequest,
                ListResourceEnrollmentStatusesResponse,
                ResourceEnrollmentStatus>
            context,
        ApiFuture<ListResourceEnrollmentStatusesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListResourceEnrollmentStatusesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListResourceEnrollmentStatusesRequest,
          ListResourceEnrollmentStatusesResponse,
          ResourceEnrollmentStatus,
          ListResourceEnrollmentStatusesPage,
          ListResourceEnrollmentStatusesFixedSizeCollection> {

    private ListResourceEnrollmentStatusesFixedSizeCollection(
        List<ListResourceEnrollmentStatusesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListResourceEnrollmentStatusesFixedSizeCollection createEmptyCollection() {
      return new ListResourceEnrollmentStatusesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListResourceEnrollmentStatusesFixedSizeCollection createCollection(
        List<ListResourceEnrollmentStatusesPage> pages, int collectionSize) {
      return new ListResourceEnrollmentStatusesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListControlsPagedResponse
      extends AbstractPagedListResponse<
          ListControlsRequest,
          ListControlsResponse,
          Control,
          ListControlsPage,
          ListControlsFixedSizeCollection> {

    public static ApiFuture<ListControlsPagedResponse> createAsync(
        PageContext<ListControlsRequest, ListControlsResponse, Control> context,
        ApiFuture<ListControlsResponse> futureResponse) {
      ApiFuture<ListControlsPage> futurePage =
          ListControlsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListControlsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListControlsPagedResponse(ListControlsPage page) {
      super(page, ListControlsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListControlsPage
      extends AbstractPage<ListControlsRequest, ListControlsResponse, Control, ListControlsPage> {

    private ListControlsPage(
        PageContext<ListControlsRequest, ListControlsResponse, Control> context,
        ListControlsResponse response) {
      super(context, response);
    }

    private static ListControlsPage createEmptyPage() {
      return new ListControlsPage(null, null);
    }

    @Override
    protected ListControlsPage createPage(
        PageContext<ListControlsRequest, ListControlsResponse, Control> context,
        ListControlsResponse response) {
      return new ListControlsPage(context, response);
    }

    @Override
    public ApiFuture<ListControlsPage> createPageAsync(
        PageContext<ListControlsRequest, ListControlsResponse, Control> context,
        ApiFuture<ListControlsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListControlsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListControlsRequest,
          ListControlsResponse,
          Control,
          ListControlsPage,
          ListControlsFixedSizeCollection> {

    private ListControlsFixedSizeCollection(List<ListControlsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListControlsFixedSizeCollection createEmptyCollection() {
      return new ListControlsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListControlsFixedSizeCollection createCollection(
        List<ListControlsPage> pages, int collectionSize) {
      return new ListControlsFixedSizeCollection(pages, collectionSize);
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
