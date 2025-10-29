/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.cloudsecuritycompliance.v1;

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
import com.google.cloud.cloudsecuritycompliance.v1.stub.AuditStub;
import com.google.cloud.cloudsecuritycompliance.v1.stub.AuditStubSettings;
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
 * try (AuditClient auditClient = AuditClient.create()) {
 *   String scope = "scope109264468";
 *   GenerateFrameworkAuditScopeReportRequest.Format reportFormat =
 *       GenerateFrameworkAuditScopeReportRequest.Format.forNumber(0);
 *   String complianceFramework = "complianceFramework-1808314333";
 *   GenerateFrameworkAuditScopeReportResponse response =
 *       auditClient.generateFrameworkAuditScopeReport(scope, reportFormat, complianceFramework);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AuditClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateFrameworkAuditScopeReport</td>
 *      <td><p> Generates an audit scope report for a framework.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateFrameworkAuditScopeReport(GenerateFrameworkAuditScopeReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateFrameworkAuditScopeReport(String scope, GenerateFrameworkAuditScopeReportRequest.Format reportFormat, String complianceFramework)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateFrameworkAuditScopeReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateFrameworkAudit</td>
 *      <td><p> Creates an audit scope report for a framework.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFrameworkAuditAsync(CreateFrameworkAuditRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createFrameworkAuditAsync(LocationName parent, FrameworkAudit frameworkAudit, String frameworkAuditId)
 *           <li><p> createFrameworkAuditAsync(OrganizationLocationName parent, FrameworkAudit frameworkAudit, String frameworkAuditId)
 *           <li><p> createFrameworkAuditAsync(String parent, FrameworkAudit frameworkAudit, String frameworkAuditId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createFrameworkAuditOperationCallable()
 *           <li><p> createFrameworkAuditCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFrameworkAudits</td>
 *      <td><p> Lists the framework audits for a given organization, folder, or project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFrameworkAudits(ListFrameworkAuditsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFrameworkAudits(LocationName parent)
 *           <li><p> listFrameworkAudits(OrganizationLocationName parent)
 *           <li><p> listFrameworkAudits(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFrameworkAuditsPagedCallable()
 *           <li><p> listFrameworkAuditsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFrameworkAudit</td>
 *      <td><p> Gets the details for a framework audit.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFrameworkAudit(GetFrameworkAuditRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFrameworkAudit(FrameworkAuditName name)
 *           <li><p> getFrameworkAudit(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFrameworkAuditCallable()
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
 * <p>This class can be customized by passing in a custom instance of AuditSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AuditSettings auditSettings =
 *     AuditSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AuditClient auditClient = AuditClient.create(auditSettings);
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
 * AuditSettings auditSettings = AuditSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AuditClient auditClient = AuditClient.create(auditSettings);
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
 * AuditSettings auditSettings = AuditSettings.newHttpJsonBuilder().build();
 * AuditClient auditClient = AuditClient.create(auditSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AuditClient implements BackgroundResource {
  private final AuditSettings settings;
  private final AuditStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AuditClient with default settings. */
  public static final AuditClient create() throws IOException {
    return create(AuditSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AuditClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AuditClient create(AuditSettings settings) throws IOException {
    return new AuditClient(settings);
  }

  /**
   * Constructs an instance of AuditClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(AuditSettings).
   */
  public static final AuditClient create(AuditStub stub) {
    return new AuditClient(stub);
  }

  /**
   * Constructs an instance of AuditClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected AuditClient(AuditSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AuditStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AuditClient(AuditStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AuditSettings getSettings() {
    return settings;
  }

  public AuditStub getStub() {
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
   * Generates an audit scope report for a framework.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   String scope = "scope109264468";
   *   GenerateFrameworkAuditScopeReportRequest.Format reportFormat =
   *       GenerateFrameworkAuditScopeReportRequest.Format.forNumber(0);
   *   String complianceFramework = "complianceFramework-1808314333";
   *   GenerateFrameworkAuditScopeReportResponse response =
   *       auditClient.generateFrameworkAuditScopeReport(scope, reportFormat, complianceFramework);
   * }
   * }</pre>
   *
   * @param scope Required. The organization, folder or project for the audit report.
   *     <p>Supported formats are the following:
   *     <ul>
   *       <li>`projects/{project_id}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`organizations/{organization_id}/locations/{location}`
   *     </ul>
   *
   * @param reportFormat Required. The format that the scope report bytes is returned in.
   * @param complianceFramework Required. The compliance framework that the scope report is
   *     generated for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateFrameworkAuditScopeReportResponse generateFrameworkAuditScopeReport(
      String scope,
      GenerateFrameworkAuditScopeReportRequest.Format reportFormat,
      String complianceFramework) {
    GenerateFrameworkAuditScopeReportRequest request =
        GenerateFrameworkAuditScopeReportRequest.newBuilder()
            .setScope(scope)
            .setReportFormat(reportFormat)
            .setComplianceFramework(complianceFramework)
            .build();
    return generateFrameworkAuditScopeReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an audit scope report for a framework.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   GenerateFrameworkAuditScopeReportRequest request =
   *       GenerateFrameworkAuditScopeReportRequest.newBuilder()
   *           .setScope("scope109264468")
   *           .setComplianceFramework("complianceFramework-1808314333")
   *           .build();
   *   GenerateFrameworkAuditScopeReportResponse response =
   *       auditClient.generateFrameworkAuditScopeReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateFrameworkAuditScopeReportResponse generateFrameworkAuditScopeReport(
      GenerateFrameworkAuditScopeReportRequest request) {
    return generateFrameworkAuditScopeReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an audit scope report for a framework.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   GenerateFrameworkAuditScopeReportRequest request =
   *       GenerateFrameworkAuditScopeReportRequest.newBuilder()
   *           .setScope("scope109264468")
   *           .setComplianceFramework("complianceFramework-1808314333")
   *           .build();
   *   ApiFuture<GenerateFrameworkAuditScopeReportResponse> future =
   *       auditClient.generateFrameworkAuditScopeReportCallable().futureCall(request);
   *   // Do something.
   *   GenerateFrameworkAuditScopeReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
      generateFrameworkAuditScopeReportCallable() {
    return stub.generateFrameworkAuditScopeReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audit scope report for a framework.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
   *   String frameworkAuditId = "frameworkAuditId-548788616";
   *   FrameworkAudit response =
   *       auditClient.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this framework audit is created.
   *     <p>Supported formats are the following:
   *     <ul>
   *       <li>`organizations/{organization_id}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @param frameworkAudit Required. The framework audit to create.
   * @param frameworkAuditId Optional. The ID to use for the framework audit. The ID becomes the
   *     final component of the framework audit's full resource name.
   *     <p>The ID must be between 4-63 characters, and valid characters are `\\[a-z][0-9]-\\`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FrameworkAudit, OperationMetadata> createFrameworkAuditAsync(
      LocationName parent, FrameworkAudit frameworkAudit, String frameworkAuditId) {
    CreateFrameworkAuditRequest request =
        CreateFrameworkAuditRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFrameworkAudit(frameworkAudit)
            .setFrameworkAuditId(frameworkAuditId)
            .build();
    return createFrameworkAuditAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audit scope report for a framework.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
   *   String frameworkAuditId = "frameworkAuditId-548788616";
   *   FrameworkAudit response =
   *       auditClient.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this framework audit is created.
   *     <p>Supported formats are the following:
   *     <ul>
   *       <li>`organizations/{organization_id}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @param frameworkAudit Required. The framework audit to create.
   * @param frameworkAuditId Optional. The ID to use for the framework audit. The ID becomes the
   *     final component of the framework audit's full resource name.
   *     <p>The ID must be between 4-63 characters, and valid characters are `\\[a-z][0-9]-\\`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FrameworkAudit, OperationMetadata> createFrameworkAuditAsync(
      OrganizationLocationName parent, FrameworkAudit frameworkAudit, String frameworkAuditId) {
    CreateFrameworkAuditRequest request =
        CreateFrameworkAuditRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFrameworkAudit(frameworkAudit)
            .setFrameworkAuditId(frameworkAuditId)
            .build();
    return createFrameworkAuditAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audit scope report for a framework.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   FrameworkAudit frameworkAudit = FrameworkAudit.newBuilder().build();
   *   String frameworkAuditId = "frameworkAuditId-548788616";
   *   FrameworkAudit response =
   *       auditClient.createFrameworkAuditAsync(parent, frameworkAudit, frameworkAuditId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this framework audit is created.
   *     <p>Supported formats are the following:
   *     <ul>
   *       <li>`organizations/{organization_id}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @param frameworkAudit Required. The framework audit to create.
   * @param frameworkAuditId Optional. The ID to use for the framework audit. The ID becomes the
   *     final component of the framework audit's full resource name.
   *     <p>The ID must be between 4-63 characters, and valid characters are `\\[a-z][0-9]-\\`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FrameworkAudit, OperationMetadata> createFrameworkAuditAsync(
      String parent, FrameworkAudit frameworkAudit, String frameworkAuditId) {
    CreateFrameworkAuditRequest request =
        CreateFrameworkAuditRequest.newBuilder()
            .setParent(parent)
            .setFrameworkAudit(frameworkAudit)
            .setFrameworkAuditId(frameworkAuditId)
            .build();
    return createFrameworkAuditAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audit scope report for a framework.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   CreateFrameworkAuditRequest request =
   *       CreateFrameworkAuditRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFrameworkAuditId("frameworkAuditId-548788616")
   *           .setFrameworkAudit(FrameworkAudit.newBuilder().build())
   *           .build();
   *   FrameworkAudit response = auditClient.createFrameworkAuditAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FrameworkAudit, OperationMetadata> createFrameworkAuditAsync(
      CreateFrameworkAuditRequest request) {
    return createFrameworkAuditOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audit scope report for a framework.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   CreateFrameworkAuditRequest request =
   *       CreateFrameworkAuditRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFrameworkAuditId("frameworkAuditId-548788616")
   *           .setFrameworkAudit(FrameworkAudit.newBuilder().build())
   *           .build();
   *   OperationFuture<FrameworkAudit, OperationMetadata> future =
   *       auditClient.createFrameworkAuditOperationCallable().futureCall(request);
   *   // Do something.
   *   FrameworkAudit response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateFrameworkAuditRequest, FrameworkAudit, OperationMetadata>
      createFrameworkAuditOperationCallable() {
    return stub.createFrameworkAuditOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audit scope report for a framework.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   CreateFrameworkAuditRequest request =
   *       CreateFrameworkAuditRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFrameworkAuditId("frameworkAuditId-548788616")
   *           .setFrameworkAudit(FrameworkAudit.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = auditClient.createFrameworkAuditCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFrameworkAuditRequest, Operation>
      createFrameworkAuditCallable() {
    return stub.createFrameworkAuditCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the framework audits for a given organization, folder, or project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (FrameworkAudit element : auditClient.listFrameworkAudits(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the framework audits are listed.
   *     <p>Supported formats are the following:
   *     <ul>
   *       <li>`organizations/{organization_id}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworkAuditsPagedResponse listFrameworkAudits(LocationName parent) {
    ListFrameworkAuditsRequest request =
        ListFrameworkAuditsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFrameworkAudits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the framework audits for a given organization, folder, or project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (FrameworkAudit element : auditClient.listFrameworkAudits(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the framework audits are listed.
   *     <p>Supported formats are the following:
   *     <ul>
   *       <li>`organizations/{organization_id}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworkAuditsPagedResponse listFrameworkAudits(
      OrganizationLocationName parent) {
    ListFrameworkAuditsRequest request =
        ListFrameworkAuditsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFrameworkAudits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the framework audits for a given organization, folder, or project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (FrameworkAudit element : auditClient.listFrameworkAudits(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the framework audits are listed.
   *     <p>Supported formats are the following:
   *     <ul>
   *       <li>`organizations/{organization_id}/locations/{location}`
   *       <li>`folders/{folder_id}/locations/{location}`
   *       <li>`projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworkAuditsPagedResponse listFrameworkAudits(String parent) {
    ListFrameworkAuditsRequest request =
        ListFrameworkAuditsRequest.newBuilder().setParent(parent).build();
    return listFrameworkAudits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the framework audits for a given organization, folder, or project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   ListFrameworkAuditsRequest request =
   *       ListFrameworkAuditsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (FrameworkAudit element : auditClient.listFrameworkAudits(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFrameworkAuditsPagedResponse listFrameworkAudits(
      ListFrameworkAuditsRequest request) {
    return listFrameworkAuditsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the framework audits for a given organization, folder, or project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   ListFrameworkAuditsRequest request =
   *       ListFrameworkAuditsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<FrameworkAudit> future =
   *       auditClient.listFrameworkAuditsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FrameworkAudit element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFrameworkAuditsRequest, ListFrameworkAuditsPagedResponse>
      listFrameworkAuditsPagedCallable() {
    return stub.listFrameworkAuditsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the framework audits for a given organization, folder, or project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   ListFrameworkAuditsRequest request =
   *       ListFrameworkAuditsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListFrameworkAuditsResponse response =
   *         auditClient.listFrameworkAuditsCallable().call(request);
   *     for (FrameworkAudit element : response.getFrameworkAuditsList()) {
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
  public final UnaryCallable<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>
      listFrameworkAuditsCallable() {
    return stub.listFrameworkAuditsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details for a framework audit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   FrameworkAuditName name =
   *       FrameworkAuditName.ofOrganizationLocationFrameworkAuditName(
   *           "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_AUDIT]");
   *   FrameworkAudit response = auditClient.getFrameworkAudit(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the framework audit to retrieve.
   *     <p>Supported formats are the following:
   *     <ul>
   *       <li>`organizations/{organization_id}/locations/{location}/frameworkAudits/{frameworkAuditName}`
   *       <li>`folders/{folder_id}/locations/{location}/frameworkAudits/{frameworkAuditName}`
   *       <li>`projects/{project_id}/locations/{location}/frameworkAudits/{frameworkAuditName}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FrameworkAudit getFrameworkAudit(FrameworkAuditName name) {
    GetFrameworkAuditRequest request =
        GetFrameworkAuditRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getFrameworkAudit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details for a framework audit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   String name =
   *       FrameworkAuditName.ofProjectLocationFrameworkAuditName(
   *               "[PROJECT]", "[LOCATION]", "[FRAMEWORK_AUDIT]")
   *           .toString();
   *   FrameworkAudit response = auditClient.getFrameworkAudit(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the framework audit to retrieve.
   *     <p>Supported formats are the following:
   *     <ul>
   *       <li>`organizations/{organization_id}/locations/{location}/frameworkAudits/{frameworkAuditName}`
   *       <li>`folders/{folder_id}/locations/{location}/frameworkAudits/{frameworkAuditName}`
   *       <li>`projects/{project_id}/locations/{location}/frameworkAudits/{frameworkAuditName}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FrameworkAudit getFrameworkAudit(String name) {
    GetFrameworkAuditRequest request = GetFrameworkAuditRequest.newBuilder().setName(name).build();
    return getFrameworkAudit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details for a framework audit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   GetFrameworkAuditRequest request =
   *       GetFrameworkAuditRequest.newBuilder()
   *           .setName(
   *               FrameworkAuditName.ofOrganizationLocationFrameworkAuditName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_AUDIT]")
   *                   .toString())
   *           .build();
   *   FrameworkAudit response = auditClient.getFrameworkAudit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FrameworkAudit getFrameworkAudit(GetFrameworkAuditRequest request) {
    return getFrameworkAuditCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details for a framework audit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuditClient auditClient = AuditClient.create()) {
   *   GetFrameworkAuditRequest request =
   *       GetFrameworkAuditRequest.newBuilder()
   *           .setName(
   *               FrameworkAuditName.ofOrganizationLocationFrameworkAuditName(
   *                       "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_AUDIT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FrameworkAudit> future =
   *       auditClient.getFrameworkAuditCallable().futureCall(request);
   *   // Do something.
   *   FrameworkAudit response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFrameworkAuditRequest, FrameworkAudit> getFrameworkAuditCallable() {
    return stub.getFrameworkAuditCallable();
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
   * try (AuditClient auditClient = AuditClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : auditClient.listLocations(request).iterateAll()) {
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
   * try (AuditClient auditClient = AuditClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = auditClient.listLocationsPagedCallable().futureCall(request);
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
   * try (AuditClient auditClient = AuditClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = auditClient.listLocationsCallable().call(request);
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
   * try (AuditClient auditClient = AuditClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = auditClient.getLocation(request);
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
   * try (AuditClient auditClient = AuditClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = auditClient.getLocationCallable().futureCall(request);
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

  public static class ListFrameworkAuditsPagedResponse
      extends AbstractPagedListResponse<
          ListFrameworkAuditsRequest,
          ListFrameworkAuditsResponse,
          FrameworkAudit,
          ListFrameworkAuditsPage,
          ListFrameworkAuditsFixedSizeCollection> {

    public static ApiFuture<ListFrameworkAuditsPagedResponse> createAsync(
        PageContext<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse, FrameworkAudit>
            context,
        ApiFuture<ListFrameworkAuditsResponse> futureResponse) {
      ApiFuture<ListFrameworkAuditsPage> futurePage =
          ListFrameworkAuditsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFrameworkAuditsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFrameworkAuditsPagedResponse(ListFrameworkAuditsPage page) {
      super(page, ListFrameworkAuditsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFrameworkAuditsPage
      extends AbstractPage<
          ListFrameworkAuditsRequest,
          ListFrameworkAuditsResponse,
          FrameworkAudit,
          ListFrameworkAuditsPage> {

    private ListFrameworkAuditsPage(
        PageContext<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse, FrameworkAudit>
            context,
        ListFrameworkAuditsResponse response) {
      super(context, response);
    }

    private static ListFrameworkAuditsPage createEmptyPage() {
      return new ListFrameworkAuditsPage(null, null);
    }

    @Override
    protected ListFrameworkAuditsPage createPage(
        PageContext<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse, FrameworkAudit>
            context,
        ListFrameworkAuditsResponse response) {
      return new ListFrameworkAuditsPage(context, response);
    }

    @Override
    public ApiFuture<ListFrameworkAuditsPage> createPageAsync(
        PageContext<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse, FrameworkAudit>
            context,
        ApiFuture<ListFrameworkAuditsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFrameworkAuditsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFrameworkAuditsRequest,
          ListFrameworkAuditsResponse,
          FrameworkAudit,
          ListFrameworkAuditsPage,
          ListFrameworkAuditsFixedSizeCollection> {

    private ListFrameworkAuditsFixedSizeCollection(
        List<ListFrameworkAuditsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFrameworkAuditsFixedSizeCollection createEmptyCollection() {
      return new ListFrameworkAuditsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFrameworkAuditsFixedSizeCollection createCollection(
        List<ListFrameworkAuditsPage> pages, int collectionSize) {
      return new ListFrameworkAuditsFixedSizeCollection(pages, collectionSize);
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
