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

package com.google.cloud.secretmanager.v1;

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
import com.google.cloud.secretmanager.v1.stub.SecretOperationsServiceStub;
import com.google.cloud.secretmanager.v1.stub.SecretOperationsServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Secret Operations Service
 *
 * <p>Manages backups of secrets. Implements a REST model with the following objects:
 *
 * <ul>
 *   <li>[Backup][google.cloud.secretmanager.v1.Backup]
 * </ul>
 *
 * <p>Note: `SecretOperationsService` is a regional service and must be called using regional
 * endpoints (`secretmanager.{location}.rep.googleapis.com`).
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
 * try (SecretOperationsServiceClient secretOperationsServiceClient =
 *     SecretOperationsServiceClient.create()) {
 *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");
 *   Backup response = secretOperationsServiceClient.getBackup(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SecretOperationsServiceClient object to clean up
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
 *      <td><p> ListBackups</td>
 *      <td><p> Lists Backups in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackups(ListBackupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackups(LocationName parent)
 *           <li><p> listBackups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupsPagedCallable()
 *           <li><p> listBackupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackup</td>
 *      <td><p> Gets details of a single Backup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackup(GetBackupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackup(BackupName name)
 *           <li><p> getBackup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBackup</td>
 *      <td><p> Creates a new Backup in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBackupAsync(CreateBackupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createBackupAsync(LocationName parent, Backup backup, String backupId)
 *           <li><p> createBackupAsync(String parent, Backup backup, String backupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBackupOperationCallable()
 *           <li><p> createBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBackup</td>
 *      <td><p> Updates the parameters of a single Backup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBackupAsync(UpdateBackupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateBackupAsync(Backup backup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBackupOperationCallable()
 *           <li><p> updateBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBackup</td>
 *      <td><p> Deletes a single Backup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBackupAsync(DeleteBackupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteBackupAsync(BackupName name)
 *           <li><p> deleteBackupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBackupOperationCallable()
 *           <li><p> deleteBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RestoreBackup</td>
 *      <td><p> Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given [Backup][google.cloud.secretmanager.v1.Backup]. This creates a &#42;new&#42; [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the restoration process, and the result of the LRO is the newly created Secret.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> restoreBackupAsync(RestoreBackupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> restoreBackupAsync(BackupName name, LocationName destinationSecretParent, String destinationSecretId)
 *           <li><p> restoreBackupAsync(BackupName name, ProjectName destinationSecretParent, String destinationSecretId)
 *           <li><p> restoreBackupAsync(BackupName name, String destinationSecretParent, String destinationSecretId)
 *           <li><p> restoreBackupAsync(String name, LocationName destinationSecretParent, String destinationSecretId)
 *           <li><p> restoreBackupAsync(String name, ProjectName destinationSecretParent, String destinationSecretId)
 *           <li><p> restoreBackupAsync(String name, String destinationSecretParent, String destinationSecretId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> restoreBackupOperationCallable()
 *           <li><p> restoreBackupCallable()
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
 * SecretOperationsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecretOperationsServiceSettings secretOperationsServiceSettings =
 *     SecretOperationsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SecretOperationsServiceClient secretOperationsServiceClient =
 *     SecretOperationsServiceClient.create(secretOperationsServiceSettings);
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
 * SecretOperationsServiceSettings secretOperationsServiceSettings =
 *     SecretOperationsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SecretOperationsServiceClient secretOperationsServiceClient =
 *     SecretOperationsServiceClient.create(secretOperationsServiceSettings);
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
 * SecretOperationsServiceSettings secretOperationsServiceSettings =
 *     SecretOperationsServiceSettings.newHttpJsonBuilder().build();
 * SecretOperationsServiceClient secretOperationsServiceClient =
 *     SecretOperationsServiceClient.create(secretOperationsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class SecretOperationsServiceClient implements BackgroundResource {
  private final @Nullable SecretOperationsServiceSettings settings;
  private final SecretOperationsServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of SecretOperationsServiceClient with default settings. */
  public static final SecretOperationsServiceClient create() throws IOException {
    return create(SecretOperationsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SecretOperationsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SecretOperationsServiceClient create(SecretOperationsServiceSettings settings)
      throws IOException {
    return new SecretOperationsServiceClient(settings);
  }

  /**
   * Constructs an instance of SecretOperationsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SecretOperationsServiceSettings).
   */
  public static final SecretOperationsServiceClient create(SecretOperationsServiceStub stub) {
    return new SecretOperationsServiceClient(stub);
  }

  /**
   * Constructs an instance of SecretOperationsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SecretOperationsServiceClient(SecretOperationsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((SecretOperationsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SecretOperationsServiceClient(SecretOperationsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final @Nullable SecretOperationsServiceSettings getSettings() {
    return settings;
  }

  public SecretOperationsServiceStub getStub() {
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
   * Lists Backups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Backup element : secretOperationsServiceClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [Backups][google.cloud.secretmanager.v1.Backup], in the format
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(@Nullable LocationName parent) {
    ListBackupsRequest request =
        ListBackupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Backups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Backup element : secretOperationsServiceClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [Backups][google.cloud.secretmanager.v1.Backup], in the format
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(String parent) {
    ListBackupsRequest request = ListBackupsRequest.newBuilder().setParent(parent).build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Backups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Backup element : secretOperationsServiceClient.listBackups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(ListBackupsRequest request) {
    return listBackupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Backups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Backup> future =
   *       secretOperationsServiceClient.listBackupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Backup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable() {
    return stub.listBackupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Backups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListBackupsResponse response =
   *         secretOperationsServiceClient.listBackupsCallable().call(request);
   *     for (Backup element : response.getBackupsList()) {
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
  public final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return stub.listBackupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");
   *   Backup response = secretOperationsServiceClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Backup][google.cloud.secretmanager.v1.Backup],
   *     in the format `projects/{project}/locations/{location}/backups/{backup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(@Nullable BackupName name) {
    GetBackupRequest request =
        GetBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   String name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString();
   *   Backup response = secretOperationsServiceClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Backup][google.cloud.secretmanager.v1.Backup],
   *     in the format `projects/{project}/locations/{location}/backups/{backup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(String name) {
    GetBackupRequest request = GetBackupRequest.newBuilder().setName(name).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .build();
   *   Backup response = secretOperationsServiceClient.getBackup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(GetBackupRequest request) {
    return getBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .build();
   *   ApiFuture<Backup> future =
   *       secretOperationsServiceClient.getBackupCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return stub.getBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Backup in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Backup backup = Backup.newBuilder().build();
   *   String backupId = "backupId2121930365";
   *   Backup response =
   *       secretOperationsServiceClient.createBackupAsync(parent, backup, backupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location where the
   *     [Backup][google.cloud.secretmanager.v1.Backup] will be created, in the format
   *     `projects/{project}/locations/{location}`.
   * @param backup Required. The [Backup][google.cloud.secretmanager.v1.Backup] resource to create.
   * @param backupId Required. The ID to use for the backup, which will become the final component
   *     of the backup's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> createBackupAsync(
      @Nullable LocationName parent, Backup backup, String backupId) {
    CreateBackupRequest request =
        CreateBackupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackup(backup)
            .setBackupId(backupId)
            .build();
    return createBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Backup in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Backup backup = Backup.newBuilder().build();
   *   String backupId = "backupId2121930365";
   *   Backup response =
   *       secretOperationsServiceClient.createBackupAsync(parent, backup, backupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location where the
   *     [Backup][google.cloud.secretmanager.v1.Backup] will be created, in the format
   *     `projects/{project}/locations/{location}`.
   * @param backup Required. The [Backup][google.cloud.secretmanager.v1.Backup] resource to create.
   * @param backupId Required. The ID to use for the backup, which will become the final component
   *     of the backup's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> createBackupAsync(
      String parent, Backup backup, String backupId) {
    CreateBackupRequest request =
        CreateBackupRequest.newBuilder()
            .setParent(parent)
            .setBackup(backup)
            .setBackupId(backupId)
            .build();
    return createBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Backup in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupId("backupId2121930365")
   *           .setBackup(Backup.newBuilder().build())
   *           .build();
   *   Backup response = secretOperationsServiceClient.createBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> createBackupAsync(
      CreateBackupRequest request) {
    return createBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Backup in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupId("backupId2121930365")
   *           .setBackup(Backup.newBuilder().build())
   *           .build();
   *   OperationFuture<Backup, OperationMetadata> future =
   *       secretOperationsServiceClient.createBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable() {
    return stub.createBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Backup in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupId("backupId2121930365")
   *           .setBackup(Backup.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secretOperationsServiceClient.createBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    return stub.createBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   Backup backup = Backup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Backup response = secretOperationsServiceClient.updateBackupAsync(backup, updateMask).get();
   * }
   * }</pre>
   *
   * @param backup Required. The [Backup][google.cloud.secretmanager.v1.Backup] resource with
   *     updated fields.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     [Backup][google.cloud.secretmanager.v1.Backup] resource by the update. The fields specified
   *     in the `update_mask` are relative to the resource, not the full request. A field will be
   *     overwritten if it is in the mask. If the user does not provide a mask then all fields
   *     present in the request will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> updateBackupAsync(
      Backup backup, FieldMask updateMask) {
    UpdateBackupRequest request =
        UpdateBackupRequest.newBuilder().setBackup(backup).setUpdateMask(updateMask).build();
    return updateBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBackup(Backup.newBuilder().build())
   *           .build();
   *   Backup response = secretOperationsServiceClient.updateBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> updateBackupAsync(
      UpdateBackupRequest request) {
    return updateBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBackup(Backup.newBuilder().build())
   *           .build();
   *   OperationFuture<Backup, OperationMetadata> future =
   *       secretOperationsServiceClient.updateBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable() {
    return stub.updateBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBackup(Backup.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secretOperationsServiceClient.updateBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable() {
    return stub.updateBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");
   *   secretOperationsServiceClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Backup][google.cloud.secretmanager.v1.Backup]
   *     to delete, in the format `projects/{project}/locations/{location}/backups/{backup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(
      @Nullable BackupName name) {
    DeleteBackupRequest request =
        DeleteBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   String name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString();
   *   secretOperationsServiceClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Backup][google.cloud.secretmanager.v1.Backup]
   *     to delete, in the format `projects/{project}/locations/{location}/backups/{backup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(String name) {
    DeleteBackupRequest request = DeleteBackupRequest.newBuilder().setName(name).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   secretOperationsServiceClient.deleteBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(
      DeleteBackupRequest request) {
    return deleteBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       secretOperationsServiceClient.deleteBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable() {
    return stub.deleteBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       secretOperationsServiceClient.deleteBackupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    return stub.deleteBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
   * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a &#42;new&#42;
   * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the restoration
   * process, and the result of the LRO is the newly created Secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");
   *   LocationName destinationSecretParent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String destinationSecretId = "destinationSecretId171779609";
   *   Secret response =
   *       secretOperationsServiceClient
   *           .restoreBackupAsync(name, destinationSecretParent, destinationSecretId)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Backup][google.cloud.secretmanager.v1.Backup]
   *     to restore from. Format: `projects/{project}/locations/{location}/backups/{backup}`
   * @param destinationSecretParent Required. Parent of the new
   *     [Secret][google.cloud.secretmanager.v1.Secret] to be created from this backup. Formats: -
   *     `projects/{project}/locations/{location}` (for regional secrets) - `projects/{project}`
   *     (for global secrets)
   * @param destinationSecretId Required. ID of the new
   *     [Secret][google.cloud.secretmanager.v1.Secret] to be created from this backup. This must be
   *     unique within the project.
   *     <p>A secret ID is a string with a maximum length of 255 characters and can contain
   *     uppercase and lowercase letters, numerals, and the hyphen (`-`) and underscore (`_`)
   *     characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Secret, OperationMetadata> restoreBackupAsync(
      @Nullable BackupName name,
      @Nullable LocationName destinationSecretParent,
      String destinationSecretId) {
    RestoreBackupRequest request =
        RestoreBackupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDestinationSecretParent(
                destinationSecretParent == null ? null : destinationSecretParent.toString())
            .setDestinationSecretId(destinationSecretId)
            .build();
    return restoreBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
   * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a &#42;new&#42;
   * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the restoration
   * process, and the result of the LRO is the newly created Secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");
   *   ProjectName destinationSecretParent = ProjectName.of("[PROJECT]");
   *   String destinationSecretId = "destinationSecretId171779609";
   *   Secret response =
   *       secretOperationsServiceClient
   *           .restoreBackupAsync(name, destinationSecretParent, destinationSecretId)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Backup][google.cloud.secretmanager.v1.Backup]
   *     to restore from. Format: `projects/{project}/locations/{location}/backups/{backup}`
   * @param destinationSecretParent Required. Parent of the new
   *     [Secret][google.cloud.secretmanager.v1.Secret] to be created from this backup. Formats: -
   *     `projects/{project}/locations/{location}` (for regional secrets) - `projects/{project}`
   *     (for global secrets)
   * @param destinationSecretId Required. ID of the new
   *     [Secret][google.cloud.secretmanager.v1.Secret] to be created from this backup. This must be
   *     unique within the project.
   *     <p>A secret ID is a string with a maximum length of 255 characters and can contain
   *     uppercase and lowercase letters, numerals, and the hyphen (`-`) and underscore (`_`)
   *     characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Secret, OperationMetadata> restoreBackupAsync(
      @Nullable BackupName name,
      @Nullable ProjectName destinationSecretParent,
      String destinationSecretId) {
    RestoreBackupRequest request =
        RestoreBackupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDestinationSecretParent(
                destinationSecretParent == null ? null : destinationSecretParent.toString())
            .setDestinationSecretId(destinationSecretId)
            .build();
    return restoreBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
   * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a &#42;new&#42;
   * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the restoration
   * process, and the result of the LRO is the newly created Secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");
   *   String destinationSecretParent = ProjectName.of("[PROJECT]").toString();
   *   String destinationSecretId = "destinationSecretId171779609";
   *   Secret response =
   *       secretOperationsServiceClient
   *           .restoreBackupAsync(name, destinationSecretParent, destinationSecretId)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Backup][google.cloud.secretmanager.v1.Backup]
   *     to restore from. Format: `projects/{project}/locations/{location}/backups/{backup}`
   * @param destinationSecretParent Required. Parent of the new
   *     [Secret][google.cloud.secretmanager.v1.Secret] to be created from this backup. Formats: -
   *     `projects/{project}/locations/{location}` (for regional secrets) - `projects/{project}`
   *     (for global secrets)
   * @param destinationSecretId Required. ID of the new
   *     [Secret][google.cloud.secretmanager.v1.Secret] to be created from this backup. This must be
   *     unique within the project.
   *     <p>A secret ID is a string with a maximum length of 255 characters and can contain
   *     uppercase and lowercase letters, numerals, and the hyphen (`-`) and underscore (`_`)
   *     characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Secret, OperationMetadata> restoreBackupAsync(
      @Nullable BackupName name, String destinationSecretParent, String destinationSecretId) {
    RestoreBackupRequest request =
        RestoreBackupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDestinationSecretParent(destinationSecretParent)
            .setDestinationSecretId(destinationSecretId)
            .build();
    return restoreBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
   * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a &#42;new&#42;
   * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the restoration
   * process, and the result of the LRO is the newly created Secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   String name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString();
   *   LocationName destinationSecretParent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String destinationSecretId = "destinationSecretId171779609";
   *   Secret response =
   *       secretOperationsServiceClient
   *           .restoreBackupAsync(name, destinationSecretParent, destinationSecretId)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Backup][google.cloud.secretmanager.v1.Backup]
   *     to restore from. Format: `projects/{project}/locations/{location}/backups/{backup}`
   * @param destinationSecretParent Required. Parent of the new
   *     [Secret][google.cloud.secretmanager.v1.Secret] to be created from this backup. Formats: -
   *     `projects/{project}/locations/{location}` (for regional secrets) - `projects/{project}`
   *     (for global secrets)
   * @param destinationSecretId Required. ID of the new
   *     [Secret][google.cloud.secretmanager.v1.Secret] to be created from this backup. This must be
   *     unique within the project.
   *     <p>A secret ID is a string with a maximum length of 255 characters and can contain
   *     uppercase and lowercase letters, numerals, and the hyphen (`-`) and underscore (`_`)
   *     characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Secret, OperationMetadata> restoreBackupAsync(
      String name, @Nullable LocationName destinationSecretParent, String destinationSecretId) {
    RestoreBackupRequest request =
        RestoreBackupRequest.newBuilder()
            .setName(name)
            .setDestinationSecretParent(
                destinationSecretParent == null ? null : destinationSecretParent.toString())
            .setDestinationSecretId(destinationSecretId)
            .build();
    return restoreBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
   * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a &#42;new&#42;
   * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the restoration
   * process, and the result of the LRO is the newly created Secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   String name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString();
   *   ProjectName destinationSecretParent = ProjectName.of("[PROJECT]");
   *   String destinationSecretId = "destinationSecretId171779609";
   *   Secret response =
   *       secretOperationsServiceClient
   *           .restoreBackupAsync(name, destinationSecretParent, destinationSecretId)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Backup][google.cloud.secretmanager.v1.Backup]
   *     to restore from. Format: `projects/{project}/locations/{location}/backups/{backup}`
   * @param destinationSecretParent Required. Parent of the new
   *     [Secret][google.cloud.secretmanager.v1.Secret] to be created from this backup. Formats: -
   *     `projects/{project}/locations/{location}` (for regional secrets) - `projects/{project}`
   *     (for global secrets)
   * @param destinationSecretId Required. ID of the new
   *     [Secret][google.cloud.secretmanager.v1.Secret] to be created from this backup. This must be
   *     unique within the project.
   *     <p>A secret ID is a string with a maximum length of 255 characters and can contain
   *     uppercase and lowercase letters, numerals, and the hyphen (`-`) and underscore (`_`)
   *     characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Secret, OperationMetadata> restoreBackupAsync(
      String name, @Nullable ProjectName destinationSecretParent, String destinationSecretId) {
    RestoreBackupRequest request =
        RestoreBackupRequest.newBuilder()
            .setName(name)
            .setDestinationSecretParent(
                destinationSecretParent == null ? null : destinationSecretParent.toString())
            .setDestinationSecretId(destinationSecretId)
            .build();
    return restoreBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
   * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a &#42;new&#42;
   * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the restoration
   * process, and the result of the LRO is the newly created Secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   String name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString();
   *   String destinationSecretParent = ProjectName.of("[PROJECT]").toString();
   *   String destinationSecretId = "destinationSecretId171779609";
   *   Secret response =
   *       secretOperationsServiceClient
   *           .restoreBackupAsync(name, destinationSecretParent, destinationSecretId)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Backup][google.cloud.secretmanager.v1.Backup]
   *     to restore from. Format: `projects/{project}/locations/{location}/backups/{backup}`
   * @param destinationSecretParent Required. Parent of the new
   *     [Secret][google.cloud.secretmanager.v1.Secret] to be created from this backup. Formats: -
   *     `projects/{project}/locations/{location}` (for regional secrets) - `projects/{project}`
   *     (for global secrets)
   * @param destinationSecretId Required. ID of the new
   *     [Secret][google.cloud.secretmanager.v1.Secret] to be created from this backup. This must be
   *     unique within the project.
   *     <p>A secret ID is a string with a maximum length of 255 characters and can contain
   *     uppercase and lowercase letters, numerals, and the hyphen (`-`) and underscore (`_`)
   *     characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Secret, OperationMetadata> restoreBackupAsync(
      String name, String destinationSecretParent, String destinationSecretId) {
    RestoreBackupRequest request =
        RestoreBackupRequest.newBuilder()
            .setName(name)
            .setDestinationSecretParent(destinationSecretParent)
            .setDestinationSecretId(destinationSecretId)
            .build();
    return restoreBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
   * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a &#42;new&#42;
   * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the restoration
   * process, and the result of the LRO is the newly created Secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   RestoreBackupRequest request =
   *       RestoreBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .setDestinationSecretParent(ProjectName.of("[PROJECT]").toString())
   *           .setDestinationSecretId("destinationSecretId171779609")
   *           .setKmsKeyName(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .build();
   *   Secret response = secretOperationsServiceClient.restoreBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Secret, OperationMetadata> restoreBackupAsync(
      RestoreBackupRequest request) {
    return restoreBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
   * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a &#42;new&#42;
   * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the restoration
   * process, and the result of the LRO is the newly created Secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   RestoreBackupRequest request =
   *       RestoreBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .setDestinationSecretParent(ProjectName.of("[PROJECT]").toString())
   *           .setDestinationSecretId("destinationSecretId171779609")
   *           .setKmsKeyName(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Secret, OperationMetadata> future =
   *       secretOperationsServiceClient.restoreBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Secret response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RestoreBackupRequest, Secret, OperationMetadata>
      restoreBackupOperationCallable() {
    return stub.restoreBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
   * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a &#42;new&#42;
   * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the restoration
   * process, and the result of the LRO is the newly created Secret.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretOperationsServiceClient secretOperationsServiceClient =
   *     SecretOperationsServiceClient.create()) {
   *   RestoreBackupRequest request =
   *       RestoreBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .setDestinationSecretParent(ProjectName.of("[PROJECT]").toString())
   *           .setDestinationSecretId("destinationSecretId171779609")
   *           .setKmsKeyName(
   *               CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       secretOperationsServiceClient.restoreBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestoreBackupRequest, Operation> restoreBackupCallable() {
    return stub.restoreBackupCallable();
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

  public static class ListBackupsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupsRequest,
          ListBackupsResponse,
          Backup,
          ListBackupsPage,
          ListBackupsFixedSizeCollection> {

    public static ApiFuture<ListBackupsPagedResponse> createAsync(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ApiFuture<ListBackupsResponse> futureResponse) {
      ApiFuture<ListBackupsPage> futurePage =
          ListBackupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListBackupsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListBackupsPagedResponse(ListBackupsPage page) {
      super(page, ListBackupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupsPage
      extends AbstractPage<ListBackupsRequest, ListBackupsResponse, Backup, ListBackupsPage> {

    private ListBackupsPage(
        @Nullable PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        @Nullable ListBackupsResponse response) {
      super(context, response);
    }

    private static ListBackupsPage createEmptyPage() {
      return new ListBackupsPage(null, null);
    }

    @Override
    protected ListBackupsPage createPage(
        @Nullable PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        @Nullable ListBackupsResponse response) {
      return new ListBackupsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupsPage> createPageAsync(
        @Nullable PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ApiFuture<ListBackupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupsRequest,
          ListBackupsResponse,
          Backup,
          ListBackupsPage,
          ListBackupsFixedSizeCollection> {

    private ListBackupsFixedSizeCollection(
        @Nullable List<ListBackupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupsFixedSizeCollection createEmptyCollection() {
      return new ListBackupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupsFixedSizeCollection createCollection(
        @Nullable List<ListBackupsPage> pages, int collectionSize) {
      return new ListBackupsFixedSizeCollection(pages, collectionSize);
    }
  }
}
