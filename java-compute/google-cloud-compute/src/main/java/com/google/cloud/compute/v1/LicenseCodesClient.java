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

package com.google.cloud.compute.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.LicenseCodesStub;
import com.google.cloud.compute.v1.stub.LicenseCodesStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The LicenseCodes API.
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
 * try (LicenseCodesClient licenseCodesClient = LicenseCodesClient.create()) {
 *   String project = "project-309310695";
 *   String licenseCode = "licenseCode-641557042";
 *   LicenseCode response = licenseCodesClient.get(project, licenseCode);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LicenseCodesClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of LicenseCodesSettings to
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
 * LicenseCodesSettings licenseCodesSettings =
 *     LicenseCodesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LicenseCodesClient licenseCodesClient = LicenseCodesClient.create(licenseCodesSettings);
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
 * LicenseCodesSettings licenseCodesSettings =
 *     LicenseCodesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LicenseCodesClient licenseCodesClient = LicenseCodesClient.create(licenseCodesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LicenseCodesClient implements BackgroundResource {
  private final LicenseCodesSettings settings;
  private final LicenseCodesStub stub;

  /** Constructs an instance of LicenseCodesClient with default settings. */
  public static final LicenseCodesClient create() throws IOException {
    return create(LicenseCodesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LicenseCodesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LicenseCodesClient create(LicenseCodesSettings settings) throws IOException {
    return new LicenseCodesClient(settings);
  }

  /**
   * Constructs an instance of LicenseCodesClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(LicenseCodesSettings).
   */
  public static final LicenseCodesClient create(LicenseCodesStub stub) {
    return new LicenseCodesClient(stub);
  }

  /**
   * Constructs an instance of LicenseCodesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LicenseCodesClient(LicenseCodesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LicenseCodesStubSettings) settings.getStubSettings()).createStub();
  }

  protected LicenseCodesClient(LicenseCodesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LicenseCodesSettings getSettings() {
    return settings;
  }

  public LicenseCodesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return a specified license code. License codes are mirrored across all projects that have
   * permissions to read the License Code. &#42;Caution&#42; This resource is intended for use only
   * by third-party partners who are creating Cloud Marketplace images.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseCodesClient licenseCodesClient = LicenseCodesClient.create()) {
   *   String project = "project-309310695";
   *   String licenseCode = "licenseCode-641557042";
   *   LicenseCode response = licenseCodesClient.get(project, licenseCode);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param licenseCode Number corresponding to the License code resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicenseCode get(String project, String licenseCode) {
    GetLicenseCodeRequest request =
        GetLicenseCodeRequest.newBuilder().setProject(project).setLicenseCode(licenseCode).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return a specified license code. License codes are mirrored across all projects that have
   * permissions to read the License Code. &#42;Caution&#42; This resource is intended for use only
   * by third-party partners who are creating Cloud Marketplace images.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseCodesClient licenseCodesClient = LicenseCodesClient.create()) {
   *   GetLicenseCodeRequest request =
   *       GetLicenseCodeRequest.newBuilder()
   *           .setLicenseCode("licenseCode-641557042")
   *           .setProject("project-309310695")
   *           .build();
   *   LicenseCode response = licenseCodesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicenseCode get(GetLicenseCodeRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return a specified license code. License codes are mirrored across all projects that have
   * permissions to read the License Code. &#42;Caution&#42; This resource is intended for use only
   * by third-party partners who are creating Cloud Marketplace images.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseCodesClient licenseCodesClient = LicenseCodesClient.create()) {
   *   GetLicenseCodeRequest request =
   *       GetLicenseCodeRequest.newBuilder()
   *           .setLicenseCode("licenseCode-641557042")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<LicenseCode> future = licenseCodesClient.getCallable().futureCall(request);
   *   // Do something.
   *   LicenseCode response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLicenseCodeRequest, LicenseCode> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. &#42;Caution&#42; This
   * resource is intended for use only by third-party partners who are creating Cloud Marketplace
   * images.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseCodesClient licenseCodesClient = LicenseCodesClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       licenseCodesClient.testIamPermissions(project, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project, String resource, TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsLicenseCodeRequest request =
        TestIamPermissionsLicenseCodeRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. &#42;Caution&#42; This
   * resource is intended for use only by third-party partners who are creating Cloud Marketplace
   * images.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseCodesClient licenseCodesClient = LicenseCodesClient.create()) {
   *   TestIamPermissionsLicenseCodeRequest request =
   *       TestIamPermissionsLicenseCodeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   TestPermissionsResponse response = licenseCodesClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsLicenseCodeRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. &#42;Caution&#42; This
   * resource is intended for use only by third-party partners who are creating Cloud Marketplace
   * images.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseCodesClient licenseCodesClient = LicenseCodesClient.create()) {
   *   TestIamPermissionsLicenseCodeRequest request =
   *       TestIamPermissionsLicenseCodeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       licenseCodesClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsLicenseCodeRequest, TestPermissionsResponse>
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
}
