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
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.LicenseCodeStub;
import com.google.cloud.compute.v1.stub.LicenseCodeStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (LicenseCodeClient licenseCodeClient = LicenseCodeClient.create()) {
 *   ProjectGlobalLicenseCodeName licenseCode = ProjectGlobalLicenseCodeName.of("[PROJECT]", "[LICENSE_CODE]");
 *   LicenseCode response = licenseCodeClient.getLicenseCode(licenseCode);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the licenseCodeClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of LicenseCodeSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * LicenseCodeSettings licenseCodeSettings =
 *     LicenseCodeSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LicenseCodeClient licenseCodeClient =
 *     LicenseCodeClient.create(licenseCodeSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * LicenseCodeSettings licenseCodeSettings =
 *     LicenseCodeSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LicenseCodeClient licenseCodeClient =
 *     LicenseCodeClient.create(licenseCodeSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class LicenseCodeClient implements BackgroundResource {
  private final LicenseCodeSettings settings;
  private final LicenseCodeStub stub;

  /** Constructs an instance of LicenseCodeClient with default settings. */
  public static final LicenseCodeClient create() throws IOException {
    return create(LicenseCodeSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LicenseCodeClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LicenseCodeClient create(LicenseCodeSettings settings) throws IOException {
    return new LicenseCodeClient(settings);
  }

  /**
   * Constructs an instance of LicenseCodeClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use LicenseCodeSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final LicenseCodeClient create(LicenseCodeStub stub) {
    return new LicenseCodeClient(stub);
  }

  /**
   * Constructs an instance of LicenseCodeClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LicenseCodeClient(LicenseCodeSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LicenseCodeStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected LicenseCodeClient(LicenseCodeStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LicenseCodeSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public LicenseCodeStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Return a specified license code. License codes are mirrored across all projects that have
   * permissions to read the License Code.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseCodeClient licenseCodeClient = LicenseCodeClient.create()) {
   *   ProjectGlobalLicenseCodeName licenseCode = ProjectGlobalLicenseCodeName.of("[PROJECT]", "[LICENSE_CODE]");
   *   LicenseCode response = licenseCodeClient.getLicenseCode(licenseCode);
   * }
   * </code></pre>
   *
   * @param licenseCode Number corresponding to the License code resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final LicenseCode getLicenseCode(ProjectGlobalLicenseCodeName licenseCode) {

    GetLicenseCodeHttpRequest request =
        GetLicenseCodeHttpRequest.newBuilder()
            .setLicenseCode(licenseCode == null ? null : licenseCode.toString())
            .build();
    return getLicenseCode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Return a specified license code. License codes are mirrored across all projects that have
   * permissions to read the License Code.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseCodeClient licenseCodeClient = LicenseCodeClient.create()) {
   *   ProjectGlobalLicenseCodeName licenseCode = ProjectGlobalLicenseCodeName.of("[PROJECT]", "[LICENSE_CODE]");
   *   LicenseCode response = licenseCodeClient.getLicenseCode(licenseCode.toString());
   * }
   * </code></pre>
   *
   * @param licenseCode Number corresponding to the License code resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final LicenseCode getLicenseCode(String licenseCode) {

    GetLicenseCodeHttpRequest request =
        GetLicenseCodeHttpRequest.newBuilder().setLicenseCode(licenseCode).build();
    return getLicenseCode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Return a specified license code. License codes are mirrored across all projects that have
   * permissions to read the License Code.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseCodeClient licenseCodeClient = LicenseCodeClient.create()) {
   *   ProjectGlobalLicenseCodeName licenseCode = ProjectGlobalLicenseCodeName.of("[PROJECT]", "[LICENSE_CODE]");
   *   GetLicenseCodeHttpRequest request = GetLicenseCodeHttpRequest.newBuilder()
   *     .setLicenseCode(licenseCode.toString())
   *     .build();
   *   LicenseCode response = licenseCodeClient.getLicenseCode(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final LicenseCode getLicenseCode(GetLicenseCodeHttpRequest request) {
    return getLicenseCodeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Return a specified license code. License codes are mirrored across all projects that have
   * permissions to read the License Code.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseCodeClient licenseCodeClient = LicenseCodeClient.create()) {
   *   ProjectGlobalLicenseCodeName licenseCode = ProjectGlobalLicenseCodeName.of("[PROJECT]", "[LICENSE_CODE]");
   *   GetLicenseCodeHttpRequest request = GetLicenseCodeHttpRequest.newBuilder()
   *     .setLicenseCode(licenseCode.toString())
   *     .build();
   *   ApiFuture&lt;LicenseCode&gt; future = licenseCodeClient.getLicenseCodeCallable().futureCall(request);
   *   // Do something
   *   LicenseCode response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetLicenseCodeHttpRequest, LicenseCode> getLicenseCodeCallable() {
    return stub.getLicenseCodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseCodeClient licenseCodeClient = LicenseCodeClient.create()) {
   *   ProjectGlobalLicenseCodeResourceName resource = ProjectGlobalLicenseCodeResourceName.of("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = licenseCodeClient.testIamPermissionsLicenseCode(resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsLicenseCode(
      ProjectGlobalLicenseCodeResourceName resource,
      TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsLicenseCodeHttpRequest request =
        TestIamPermissionsLicenseCodeHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsLicenseCode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseCodeClient licenseCodeClient = LicenseCodeClient.create()) {
   *   ProjectGlobalLicenseCodeResourceName resource = ProjectGlobalLicenseCodeResourceName.of("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = licenseCodeClient.testIamPermissionsLicenseCode(resource.toString(), testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsLicenseCode(
      String resource, TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsLicenseCodeHttpRequest request =
        TestIamPermissionsLicenseCodeHttpRequest.newBuilder()
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsLicenseCode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseCodeClient licenseCodeClient = LicenseCodeClient.create()) {
   *   ProjectGlobalLicenseCodeResourceName resource = ProjectGlobalLicenseCodeResourceName.of("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsLicenseCodeHttpRequest request = TestIamPermissionsLicenseCodeHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = licenseCodeClient.testIamPermissionsLicenseCode(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsLicenseCode(
      TestIamPermissionsLicenseCodeHttpRequest request) {
    return testIamPermissionsLicenseCodeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseCodeClient licenseCodeClient = LicenseCodeClient.create()) {
   *   ProjectGlobalLicenseCodeResourceName resource = ProjectGlobalLicenseCodeResourceName.of("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsLicenseCodeHttpRequest request = TestIamPermissionsLicenseCodeHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = licenseCodeClient.testIamPermissionsLicenseCodeCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<TestIamPermissionsLicenseCodeHttpRequest, TestPermissionsResponse>
      testIamPermissionsLicenseCodeCallable() {
    return stub.testIamPermissionsLicenseCodeCallable();
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
