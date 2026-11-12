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

package com.google.cloud.run.v2;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.stub.SourceUploadStub;
import com.google.cloud.run.v2.stub.SourceUploadStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Cloud Run Source Upload API allows you to upload source code to deploy
 * Cloud Run resources.
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
 * try (SourceUploadClient sourceUploadClient = SourceUploadClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   UploadSourceResponse response = sourceUploadClient.uploadSource(parent);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SourceUploadClient object to clean up resources such
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
 *      <td><p> UploadSource</td>
 *      <td><p> Uploads a source archive to a Google Cloud Storage bucket through Cloud Run. The uploaded source object should be used for Cloud Run resource deployments. User is responsible for managing the lifecycle of the uploaded object. If uploading through the Cloud Run API to Cloud Storage is not desired, you can use the IAM Deny Policy to deny the `run.locations.uploadSource` permission for all principals.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> uploadSource(UploadSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> uploadSource(LocationName parent)
 *           <li><p> uploadSource(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> uploadSourceCallable()
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
 * <p>This class can be customized by passing in a custom instance of SourceUploadSettings to
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
 * SourceUploadSettings sourceUploadSettings =
 *     SourceUploadSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SourceUploadClient sourceUploadClient = SourceUploadClient.create(sourceUploadSettings);
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
 * SourceUploadSettings sourceUploadSettings =
 *     SourceUploadSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SourceUploadClient sourceUploadClient = SourceUploadClient.create(sourceUploadSettings);
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
 * SourceUploadSettings sourceUploadSettings = SourceUploadSettings.newHttpJsonBuilder().build();
 * SourceUploadClient sourceUploadClient = SourceUploadClient.create(sourceUploadSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class SourceUploadClient implements BackgroundResource {
  private final @Nullable SourceUploadSettings settings;
  private final SourceUploadStub stub;

  /** Constructs an instance of SourceUploadClient with default settings. */
  public static final SourceUploadClient create() throws IOException {
    return create(SourceUploadSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SourceUploadClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SourceUploadClient create(SourceUploadSettings settings) throws IOException {
    return new SourceUploadClient(settings);
  }

  /**
   * Constructs an instance of SourceUploadClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SourceUploadSettings).
   */
  public static final SourceUploadClient create(SourceUploadStub stub) {
    return new SourceUploadClient(stub);
  }

  /**
   * Constructs an instance of SourceUploadClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SourceUploadClient(SourceUploadSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SourceUploadStubSettings) settings.getStubSettings()).createStub();
  }

  protected SourceUploadClient(SourceUploadStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable SourceUploadSettings getSettings() {
    return settings;
  }

  public SourceUploadStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a source archive to a Google Cloud Storage bucket through Cloud Run. The uploaded
   * source object should be used for Cloud Run resource deployments. User is responsible for
   * managing the lifecycle of the uploaded object. If uploading through the Cloud Run API to Cloud
   * Storage is not desired, you can use the IAM Deny Policy to deny the
   * `run.locations.uploadSource` permission for all principals.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SourceUploadClient sourceUploadClient = SourceUploadClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   UploadSourceResponse response = sourceUploadClient.uploadSource(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the source archive should be uploaded
   *     to, specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UploadSourceResponse uploadSource(@Nullable LocationName parent) {
    UploadSourceRequest request =
        UploadSourceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return uploadSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a source archive to a Google Cloud Storage bucket through Cloud Run. The uploaded
   * source object should be used for Cloud Run resource deployments. User is responsible for
   * managing the lifecycle of the uploaded object. If uploading through the Cloud Run API to Cloud
   * Storage is not desired, you can use the IAM Deny Policy to deny the
   * `run.locations.uploadSource` permission for all principals.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SourceUploadClient sourceUploadClient = SourceUploadClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   UploadSourceResponse response = sourceUploadClient.uploadSource(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the source archive should be uploaded
   *     to, specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UploadSourceResponse uploadSource(String parent) {
    UploadSourceRequest request = UploadSourceRequest.newBuilder().setParent(parent).build();
    return uploadSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a source archive to a Google Cloud Storage bucket through Cloud Run. The uploaded
   * source object should be used for Cloud Run resource deployments. User is responsible for
   * managing the lifecycle of the uploaded object. If uploading through the Cloud Run API to Cloud
   * Storage is not desired, you can use the IAM Deny Policy to deny the
   * `run.locations.uploadSource` permission for all principals.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SourceUploadClient sourceUploadClient = SourceUploadClient.create()) {
   *   UploadSourceRequest request =
   *       UploadSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   UploadSourceResponse response = sourceUploadClient.uploadSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UploadSourceResponse uploadSource(UploadSourceRequest request) {
    return uploadSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a source archive to a Google Cloud Storage bucket through Cloud Run. The uploaded
   * source object should be used for Cloud Run resource deployments. User is responsible for
   * managing the lifecycle of the uploaded object. If uploading through the Cloud Run API to Cloud
   * Storage is not desired, you can use the IAM Deny Policy to deny the
   * `run.locations.uploadSource` permission for all principals.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SourceUploadClient sourceUploadClient = SourceUploadClient.create()) {
   *   UploadSourceRequest request =
   *       UploadSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<UploadSourceResponse> future =
   *       sourceUploadClient.uploadSourceCallable().futureCall(request);
   *   // Do something.
   *   UploadSourceResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UploadSourceRequest, UploadSourceResponse> uploadSourceCallable() {
    return stub.uploadSourceCallable();
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
