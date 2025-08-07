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

package com.google.shopping.merchant.datasources.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.datasources.v1.stub.FileUploadsServiceStub;
import com.google.shopping.merchant.datasources.v1.stub.FileUploadsServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to manage data source file uploads.
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
 * try (FileUploadsServiceClient fileUploadsServiceClient = FileUploadsServiceClient.create()) {
 *   FileUploadName name = FileUploadName.of("[ACCOUNT]", "[DATASOURCE]", "[FILEUPLOAD]");
 *   FileUpload response = fileUploadsServiceClient.getFileUpload(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FileUploadsServiceClient object to clean up resources
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
 *      <td><p> GetFileUpload</td>
 *      <td><p> Gets the latest data source file upload. Only the `latest` alias is accepted for a file upload.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFileUpload(GetFileUploadRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFileUpload(FileUploadName name)
 *           <li><p> getFileUpload(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFileUploadCallable()
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
 * <p>This class can be customized by passing in a custom instance of FileUploadsServiceSettings to
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
 * FileUploadsServiceSettings fileUploadsServiceSettings =
 *     FileUploadsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FileUploadsServiceClient fileUploadsServiceClient =
 *     FileUploadsServiceClient.create(fileUploadsServiceSettings);
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
 * FileUploadsServiceSettings fileUploadsServiceSettings =
 *     FileUploadsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FileUploadsServiceClient fileUploadsServiceClient =
 *     FileUploadsServiceClient.create(fileUploadsServiceSettings);
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
 * FileUploadsServiceSettings fileUploadsServiceSettings =
 *     FileUploadsServiceSettings.newHttpJsonBuilder().build();
 * FileUploadsServiceClient fileUploadsServiceClient =
 *     FileUploadsServiceClient.create(fileUploadsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class FileUploadsServiceClient implements BackgroundResource {
  private final FileUploadsServiceSettings settings;
  private final FileUploadsServiceStub stub;

  /** Constructs an instance of FileUploadsServiceClient with default settings. */
  public static final FileUploadsServiceClient create() throws IOException {
    return create(FileUploadsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FileUploadsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FileUploadsServiceClient create(FileUploadsServiceSettings settings)
      throws IOException {
    return new FileUploadsServiceClient(settings);
  }

  /**
   * Constructs an instance of FileUploadsServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(FileUploadsServiceSettings).
   */
  public static final FileUploadsServiceClient create(FileUploadsServiceStub stub) {
    return new FileUploadsServiceClient(stub);
  }

  /**
   * Constructs an instance of FileUploadsServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected FileUploadsServiceClient(FileUploadsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FileUploadsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected FileUploadsServiceClient(FileUploadsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FileUploadsServiceSettings getSettings() {
    return settings;
  }

  public FileUploadsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest data source file upload. Only the `latest` alias is accepted for a file upload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FileUploadsServiceClient fileUploadsServiceClient = FileUploadsServiceClient.create()) {
   *   FileUploadName name = FileUploadName.of("[ACCOUNT]", "[DATASOURCE]", "[FILEUPLOAD]");
   *   FileUpload response = fileUploadsServiceClient.getFileUpload(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data source file upload to retrieve. Format:
   *     `accounts/{account}/dataSources/{datasource}/fileUploads/latest`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FileUpload getFileUpload(FileUploadName name) {
    GetFileUploadRequest request =
        GetFileUploadRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFileUpload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest data source file upload. Only the `latest` alias is accepted for a file upload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FileUploadsServiceClient fileUploadsServiceClient = FileUploadsServiceClient.create()) {
   *   String name = FileUploadName.of("[ACCOUNT]", "[DATASOURCE]", "[FILEUPLOAD]").toString();
   *   FileUpload response = fileUploadsServiceClient.getFileUpload(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data source file upload to retrieve. Format:
   *     `accounts/{account}/dataSources/{datasource}/fileUploads/latest`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FileUpload getFileUpload(String name) {
    GetFileUploadRequest request = GetFileUploadRequest.newBuilder().setName(name).build();
    return getFileUpload(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest data source file upload. Only the `latest` alias is accepted for a file upload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FileUploadsServiceClient fileUploadsServiceClient = FileUploadsServiceClient.create()) {
   *   GetFileUploadRequest request =
   *       GetFileUploadRequest.newBuilder()
   *           .setName(FileUploadName.of("[ACCOUNT]", "[DATASOURCE]", "[FILEUPLOAD]").toString())
   *           .build();
   *   FileUpload response = fileUploadsServiceClient.getFileUpload(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FileUpload getFileUpload(GetFileUploadRequest request) {
    return getFileUploadCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest data source file upload. Only the `latest` alias is accepted for a file upload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FileUploadsServiceClient fileUploadsServiceClient = FileUploadsServiceClient.create()) {
   *   GetFileUploadRequest request =
   *       GetFileUploadRequest.newBuilder()
   *           .setName(FileUploadName.of("[ACCOUNT]", "[DATASOURCE]", "[FILEUPLOAD]").toString())
   *           .build();
   *   ApiFuture<FileUpload> future =
   *       fileUploadsServiceClient.getFileUploadCallable().futureCall(request);
   *   // Do something.
   *   FileUpload response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFileUploadRequest, FileUpload> getFileUploadCallable() {
    return stub.getFileUploadCallable();
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
