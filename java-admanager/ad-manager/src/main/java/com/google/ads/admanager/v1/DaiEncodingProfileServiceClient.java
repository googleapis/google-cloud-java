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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.DaiEncodingProfileServiceStub;
import com.google.ads.admanager.v1.stub.DaiEncodingProfileServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `DaiEncodingProfile` objects.
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
 * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
 *     DaiEncodingProfileServiceClient.create()) {
 *   DaiEncodingProfileName name =
 *       DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]");
 *   DaiEncodingProfile response = daiEncodingProfileServiceClient.getDaiEncodingProfile(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DaiEncodingProfileServiceClient object to clean up
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
 *      <td><p> GetDaiEncodingProfile</td>
 *      <td><p> Retrieves a `DaiEncodingProfile` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDaiEncodingProfile(GetDaiEncodingProfileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDaiEncodingProfile(DaiEncodingProfileName name)
 *           <li><p> getDaiEncodingProfile(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDaiEncodingProfileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDaiEncodingProfiles</td>
 *      <td><p> Lists `DaiEncodingProfile` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDaiEncodingProfiles(ListDaiEncodingProfilesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDaiEncodingProfiles(NetworkName parent)
 *           <li><p> listDaiEncodingProfiles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDaiEncodingProfilesPagedCallable()
 *           <li><p> listDaiEncodingProfilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDaiEncodingProfile</td>
 *      <td><p> Creates a `DaiEncodingProfile` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDaiEncodingProfile(CreateDaiEncodingProfileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDaiEncodingProfile(NetworkName parent, DaiEncodingProfile daiEncodingProfile)
 *           <li><p> createDaiEncodingProfile(String parent, DaiEncodingProfile daiEncodingProfile)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDaiEncodingProfileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateDaiEncodingProfiles</td>
 *      <td><p> Batch creates `DaiEncodingProfile` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateDaiEncodingProfiles(NetworkName parent, List&lt;CreateDaiEncodingProfileRequest&gt; requests)
 *           <li><p> batchCreateDaiEncodingProfiles(String parent, List&lt;CreateDaiEncodingProfileRequest&gt; requests)
 *           <li><p> batchCreateDaiEncodingProfiles(BatchCreateDaiEncodingProfilesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateDaiEncodingProfilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDaiEncodingProfile</td>
 *      <td><p> Updates a `DaiEncodingProfile` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDaiEncodingProfile(UpdateDaiEncodingProfileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDaiEncodingProfile(DaiEncodingProfile daiEncodingProfile, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDaiEncodingProfileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateDaiEncodingProfiles</td>
 *      <td><p> Batch updates `DaiEncodingProfile` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateDaiEncodingProfiles(NetworkName parent, List&lt;UpdateDaiEncodingProfileRequest&gt; requests)
 *           <li><p> batchUpdateDaiEncodingProfiles(String parent, List&lt;UpdateDaiEncodingProfileRequest&gt; requests)
 *           <li><p> batchUpdateDaiEncodingProfiles(BatchUpdateDaiEncodingProfilesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateDaiEncodingProfilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateDaiEncodingProfiles</td>
 *      <td><p> Activates a list of `DaiEncodingProfile` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateDaiEncodingProfiles(NetworkName parent, List&lt;ActivateDaiEncodingProfileRequest&gt; requests)
 *           <li><p> batchActivateDaiEncodingProfiles(String parent, List&lt;ActivateDaiEncodingProfileRequest&gt; requests)
 *           <li><p> batchActivateDaiEncodingProfiles(BatchActivateDaiEncodingProfilesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateDaiEncodingProfilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchArchiveDaiEncodingProfiles</td>
 *      <td><p> Archives a list of `DaiEncodingProfile` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchArchiveDaiEncodingProfiles(NetworkName parent, List&lt;ArchiveDaiEncodingProfileRequest&gt; requests)
 *           <li><p> batchArchiveDaiEncodingProfiles(String parent, List&lt;ArchiveDaiEncodingProfileRequest&gt; requests)
 *           <li><p> batchArchiveDaiEncodingProfiles(BatchArchiveDaiEncodingProfilesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchArchiveDaiEncodingProfilesCallable()
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
 * DaiEncodingProfileServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DaiEncodingProfileServiceSettings daiEncodingProfileServiceSettings =
 *     DaiEncodingProfileServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
 *     DaiEncodingProfileServiceClient.create(daiEncodingProfileServiceSettings);
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
 * DaiEncodingProfileServiceSettings daiEncodingProfileServiceSettings =
 *     DaiEncodingProfileServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
 *     DaiEncodingProfileServiceClient.create(daiEncodingProfileServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class DaiEncodingProfileServiceClient implements BackgroundResource {
  private final @Nullable DaiEncodingProfileServiceSettings settings;
  private final DaiEncodingProfileServiceStub stub;

  /** Constructs an instance of DaiEncodingProfileServiceClient with default settings. */
  public static final DaiEncodingProfileServiceClient create() throws IOException {
    return create(DaiEncodingProfileServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DaiEncodingProfileServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final DaiEncodingProfileServiceClient create(
      DaiEncodingProfileServiceSettings settings) throws IOException {
    return new DaiEncodingProfileServiceClient(settings);
  }

  /**
   * Constructs an instance of DaiEncodingProfileServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(DaiEncodingProfileServiceSettings).
   */
  public static final DaiEncodingProfileServiceClient create(DaiEncodingProfileServiceStub stub) {
    return new DaiEncodingProfileServiceClient(stub);
  }

  /**
   * Constructs an instance of DaiEncodingProfileServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DaiEncodingProfileServiceClient(DaiEncodingProfileServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((DaiEncodingProfileServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DaiEncodingProfileServiceClient(DaiEncodingProfileServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable DaiEncodingProfileServiceSettings getSettings() {
    return settings;
  }

  public DaiEncodingProfileServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `DaiEncodingProfile` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   DaiEncodingProfileName name =
   *       DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]");
   *   DaiEncodingProfile response = daiEncodingProfileServiceClient.getDaiEncodingProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DaiEncodingProfile. Format:
   *     `networks/{network_code}/daiEncodingProfiles/{dai_encoding_profile_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiEncodingProfile getDaiEncodingProfile(@Nullable DaiEncodingProfileName name) {
    GetDaiEncodingProfileRequest request =
        GetDaiEncodingProfileRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDaiEncodingProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `DaiEncodingProfile` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   String name =
   *       DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]").toString();
   *   DaiEncodingProfile response = daiEncodingProfileServiceClient.getDaiEncodingProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DaiEncodingProfile. Format:
   *     `networks/{network_code}/daiEncodingProfiles/{dai_encoding_profile_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiEncodingProfile getDaiEncodingProfile(String name) {
    GetDaiEncodingProfileRequest request =
        GetDaiEncodingProfileRequest.newBuilder().setName(name).build();
    return getDaiEncodingProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `DaiEncodingProfile` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   GetDaiEncodingProfileRequest request =
   *       GetDaiEncodingProfileRequest.newBuilder()
   *           .setName(
   *               DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]").toString())
   *           .build();
   *   DaiEncodingProfile response = daiEncodingProfileServiceClient.getDaiEncodingProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiEncodingProfile getDaiEncodingProfile(GetDaiEncodingProfileRequest request) {
    return getDaiEncodingProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `DaiEncodingProfile` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   GetDaiEncodingProfileRequest request =
   *       GetDaiEncodingProfileRequest.newBuilder()
   *           .setName(
   *               DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]").toString())
   *           .build();
   *   ApiFuture<DaiEncodingProfile> future =
   *       daiEncodingProfileServiceClient.getDaiEncodingProfileCallable().futureCall(request);
   *   // Do something.
   *   DaiEncodingProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDaiEncodingProfileRequest, DaiEncodingProfile>
      getDaiEncodingProfileCallable() {
    return stub.getDaiEncodingProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (DaiEncodingProfile element :
   *       daiEncodingProfileServiceClient.listDaiEncodingProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DaiEncodingProfiles. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDaiEncodingProfilesPagedResponse listDaiEncodingProfiles(
      @Nullable NetworkName parent) {
    ListDaiEncodingProfilesRequest request =
        ListDaiEncodingProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDaiEncodingProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (DaiEncodingProfile element :
   *       daiEncodingProfileServiceClient.listDaiEncodingProfiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DaiEncodingProfiles. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDaiEncodingProfilesPagedResponse listDaiEncodingProfiles(String parent) {
    ListDaiEncodingProfilesRequest request =
        ListDaiEncodingProfilesRequest.newBuilder().setParent(parent).build();
    return listDaiEncodingProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   ListDaiEncodingProfilesRequest request =
   *       ListDaiEncodingProfilesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (DaiEncodingProfile element :
   *       daiEncodingProfileServiceClient.listDaiEncodingProfiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDaiEncodingProfilesPagedResponse listDaiEncodingProfiles(
      ListDaiEncodingProfilesRequest request) {
    return listDaiEncodingProfilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   ListDaiEncodingProfilesRequest request =
   *       ListDaiEncodingProfilesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<DaiEncodingProfile> future =
   *       daiEncodingProfileServiceClient
   *           .listDaiEncodingProfilesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (DaiEncodingProfile element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesPagedResponse>
      listDaiEncodingProfilesPagedCallable() {
    return stub.listDaiEncodingProfilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   ListDaiEncodingProfilesRequest request =
   *       ListDaiEncodingProfilesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListDaiEncodingProfilesResponse response =
   *         daiEncodingProfileServiceClient.listDaiEncodingProfilesCallable().call(request);
   *     for (DaiEncodingProfile element : response.getDaiEncodingProfilesList()) {
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
  public final UnaryCallable<ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse>
      listDaiEncodingProfilesCallable() {
    return stub.listDaiEncodingProfilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `DaiEncodingProfile` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   DaiEncodingProfile daiEncodingProfile = DaiEncodingProfile.newBuilder().build();
   *   DaiEncodingProfile response =
   *       daiEncodingProfileServiceClient.createDaiEncodingProfile(parent, daiEncodingProfile);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `DaiEncodingProfile` will be created.
   *     Format: `networks/{network_code}`
   * @param daiEncodingProfile Required. The `DaiEncodingProfile` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiEncodingProfile createDaiEncodingProfile(
      @Nullable NetworkName parent, DaiEncodingProfile daiEncodingProfile) {
    CreateDaiEncodingProfileRequest request =
        CreateDaiEncodingProfileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDaiEncodingProfile(daiEncodingProfile)
            .build();
    return createDaiEncodingProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `DaiEncodingProfile` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   DaiEncodingProfile daiEncodingProfile = DaiEncodingProfile.newBuilder().build();
   *   DaiEncodingProfile response =
   *       daiEncodingProfileServiceClient.createDaiEncodingProfile(parent, daiEncodingProfile);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `DaiEncodingProfile` will be created.
   *     Format: `networks/{network_code}`
   * @param daiEncodingProfile Required. The `DaiEncodingProfile` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiEncodingProfile createDaiEncodingProfile(
      String parent, DaiEncodingProfile daiEncodingProfile) {
    CreateDaiEncodingProfileRequest request =
        CreateDaiEncodingProfileRequest.newBuilder()
            .setParent(parent)
            .setDaiEncodingProfile(daiEncodingProfile)
            .build();
    return createDaiEncodingProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `DaiEncodingProfile` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   CreateDaiEncodingProfileRequest request =
   *       CreateDaiEncodingProfileRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setDaiEncodingProfile(DaiEncodingProfile.newBuilder().build())
   *           .build();
   *   DaiEncodingProfile response =
   *       daiEncodingProfileServiceClient.createDaiEncodingProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiEncodingProfile createDaiEncodingProfile(
      CreateDaiEncodingProfileRequest request) {
    return createDaiEncodingProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `DaiEncodingProfile` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   CreateDaiEncodingProfileRequest request =
   *       CreateDaiEncodingProfileRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setDaiEncodingProfile(DaiEncodingProfile.newBuilder().build())
   *           .build();
   *   ApiFuture<DaiEncodingProfile> future =
   *       daiEncodingProfileServiceClient.createDaiEncodingProfileCallable().futureCall(request);
   *   // Do something.
   *   DaiEncodingProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDaiEncodingProfileRequest, DaiEncodingProfile>
      createDaiEncodingProfileCallable() {
    return stub.createDaiEncodingProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateDaiEncodingProfileRequest> requests = new ArrayList<>();
   *   BatchCreateDaiEncodingProfilesResponse response =
   *       daiEncodingProfileServiceClient.batchCreateDaiEncodingProfiles(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `DaiEncodingProfiles` will be created.
   *     Format: `networks/{network_code}` The parent field in the CreateDaiEncodingProfileRequest
   *     must match this field.
   * @param requests Required. The `DaiEncodingProfile` objects to create. A maximum of 100 objects
   *     can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateDaiEncodingProfilesResponse batchCreateDaiEncodingProfiles(
      @Nullable NetworkName parent, List<CreateDaiEncodingProfileRequest> requests) {
    BatchCreateDaiEncodingProfilesRequest request =
        BatchCreateDaiEncodingProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateDaiEncodingProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateDaiEncodingProfileRequest> requests = new ArrayList<>();
   *   BatchCreateDaiEncodingProfilesResponse response =
   *       daiEncodingProfileServiceClient.batchCreateDaiEncodingProfiles(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `DaiEncodingProfiles` will be created.
   *     Format: `networks/{network_code}` The parent field in the CreateDaiEncodingProfileRequest
   *     must match this field.
   * @param requests Required. The `DaiEncodingProfile` objects to create. A maximum of 100 objects
   *     can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateDaiEncodingProfilesResponse batchCreateDaiEncodingProfiles(
      String parent, List<CreateDaiEncodingProfileRequest> requests) {
    BatchCreateDaiEncodingProfilesRequest request =
        BatchCreateDaiEncodingProfilesRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateDaiEncodingProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   BatchCreateDaiEncodingProfilesRequest request =
   *       BatchCreateDaiEncodingProfilesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateDaiEncodingProfileRequest>())
   *           .build();
   *   BatchCreateDaiEncodingProfilesResponse response =
   *       daiEncodingProfileServiceClient.batchCreateDaiEncodingProfiles(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateDaiEncodingProfilesResponse batchCreateDaiEncodingProfiles(
      BatchCreateDaiEncodingProfilesRequest request) {
    return batchCreateDaiEncodingProfilesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   BatchCreateDaiEncodingProfilesRequest request =
   *       BatchCreateDaiEncodingProfilesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateDaiEncodingProfileRequest>())
   *           .build();
   *   ApiFuture<BatchCreateDaiEncodingProfilesResponse> future =
   *       daiEncodingProfileServiceClient
   *           .batchCreateDaiEncodingProfilesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchCreateDaiEncodingProfilesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
      batchCreateDaiEncodingProfilesCallable() {
    return stub.batchCreateDaiEncodingProfilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `DaiEncodingProfile` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   DaiEncodingProfile daiEncodingProfile = DaiEncodingProfile.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DaiEncodingProfile response =
   *       daiEncodingProfileServiceClient.updateDaiEncodingProfile(daiEncodingProfile, updateMask);
   * }
   * }</pre>
   *
   * @param daiEncodingProfile Required. The `DaiEncodingProfile` to update.
   *     <p>The `DaiEncodingProfile`'s `name` is used to identify the `DaiEncodingProfile` to
   *     update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiEncodingProfile updateDaiEncodingProfile(
      DaiEncodingProfile daiEncodingProfile, FieldMask updateMask) {
    UpdateDaiEncodingProfileRequest request =
        UpdateDaiEncodingProfileRequest.newBuilder()
            .setDaiEncodingProfile(daiEncodingProfile)
            .setUpdateMask(updateMask)
            .build();
    return updateDaiEncodingProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `DaiEncodingProfile` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   UpdateDaiEncodingProfileRequest request =
   *       UpdateDaiEncodingProfileRequest.newBuilder()
   *           .setDaiEncodingProfile(DaiEncodingProfile.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DaiEncodingProfile response =
   *       daiEncodingProfileServiceClient.updateDaiEncodingProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DaiEncodingProfile updateDaiEncodingProfile(
      UpdateDaiEncodingProfileRequest request) {
    return updateDaiEncodingProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `DaiEncodingProfile` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   UpdateDaiEncodingProfileRequest request =
   *       UpdateDaiEncodingProfileRequest.newBuilder()
   *           .setDaiEncodingProfile(DaiEncodingProfile.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DaiEncodingProfile> future =
   *       daiEncodingProfileServiceClient.updateDaiEncodingProfileCallable().futureCall(request);
   *   // Do something.
   *   DaiEncodingProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>
      updateDaiEncodingProfileCallable() {
    return stub.updateDaiEncodingProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateDaiEncodingProfileRequest> requests = new ArrayList<>();
   *   BatchUpdateDaiEncodingProfilesResponse response =
   *       daiEncodingProfileServiceClient.batchUpdateDaiEncodingProfiles(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `DaiEncodingProfiles` will be updated.
   *     Format: `networks/{network_code}` The parent field in the UpdateDaiEncodingProfileRequest
   *     must match this field.
   * @param requests Required. The `DaiEncodingProfile` objects to update. A maximum of 100 objects
   *     can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateDaiEncodingProfilesResponse batchUpdateDaiEncodingProfiles(
      @Nullable NetworkName parent, List<UpdateDaiEncodingProfileRequest> requests) {
    BatchUpdateDaiEncodingProfilesRequest request =
        BatchUpdateDaiEncodingProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateDaiEncodingProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateDaiEncodingProfileRequest> requests = new ArrayList<>();
   *   BatchUpdateDaiEncodingProfilesResponse response =
   *       daiEncodingProfileServiceClient.batchUpdateDaiEncodingProfiles(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `DaiEncodingProfiles` will be updated.
   *     Format: `networks/{network_code}` The parent field in the UpdateDaiEncodingProfileRequest
   *     must match this field.
   * @param requests Required. The `DaiEncodingProfile` objects to update. A maximum of 100 objects
   *     can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateDaiEncodingProfilesResponse batchUpdateDaiEncodingProfiles(
      String parent, List<UpdateDaiEncodingProfileRequest> requests) {
    BatchUpdateDaiEncodingProfilesRequest request =
        BatchUpdateDaiEncodingProfilesRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateDaiEncodingProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   BatchUpdateDaiEncodingProfilesRequest request =
   *       BatchUpdateDaiEncodingProfilesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateDaiEncodingProfileRequest>())
   *           .build();
   *   BatchUpdateDaiEncodingProfilesResponse response =
   *       daiEncodingProfileServiceClient.batchUpdateDaiEncodingProfiles(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateDaiEncodingProfilesResponse batchUpdateDaiEncodingProfiles(
      BatchUpdateDaiEncodingProfilesRequest request) {
    return batchUpdateDaiEncodingProfilesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   BatchUpdateDaiEncodingProfilesRequest request =
   *       BatchUpdateDaiEncodingProfilesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateDaiEncodingProfileRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateDaiEncodingProfilesResponse> future =
   *       daiEncodingProfileServiceClient
   *           .batchUpdateDaiEncodingProfilesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchUpdateDaiEncodingProfilesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
      batchUpdateDaiEncodingProfilesCallable() {
    return stub.batchUpdateDaiEncodingProfilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<ActivateDaiEncodingProfileRequest> requests = new ArrayList<>();
   *   BatchActivateDaiEncodingProfilesResponse response =
   *       daiEncodingProfileServiceClient.batchActivateDaiEncodingProfiles(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param requests Required. The `DaiEncodingProfile` objects to activate. A maximum of 100
   *     objects can be activated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateDaiEncodingProfilesResponse batchActivateDaiEncodingProfiles(
      @Nullable NetworkName parent, List<ActivateDaiEncodingProfileRequest> requests) {
    BatchActivateDaiEncodingProfilesRequest request =
        BatchActivateDaiEncodingProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchActivateDaiEncodingProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<ActivateDaiEncodingProfileRequest> requests = new ArrayList<>();
   *   BatchActivateDaiEncodingProfilesResponse response =
   *       daiEncodingProfileServiceClient.batchActivateDaiEncodingProfiles(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param requests Required. The `DaiEncodingProfile` objects to activate. A maximum of 100
   *     objects can be activated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateDaiEncodingProfilesResponse batchActivateDaiEncodingProfiles(
      String parent, List<ActivateDaiEncodingProfileRequest> requests) {
    BatchActivateDaiEncodingProfilesRequest request =
        BatchActivateDaiEncodingProfilesRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchActivateDaiEncodingProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   BatchActivateDaiEncodingProfilesRequest request =
   *       BatchActivateDaiEncodingProfilesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<ActivateDaiEncodingProfileRequest>())
   *           .build();
   *   BatchActivateDaiEncodingProfilesResponse response =
   *       daiEncodingProfileServiceClient.batchActivateDaiEncodingProfiles(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateDaiEncodingProfilesResponse batchActivateDaiEncodingProfiles(
      BatchActivateDaiEncodingProfilesRequest request) {
    return batchActivateDaiEncodingProfilesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   BatchActivateDaiEncodingProfilesRequest request =
   *       BatchActivateDaiEncodingProfilesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<ActivateDaiEncodingProfileRequest>())
   *           .build();
   *   ApiFuture<BatchActivateDaiEncodingProfilesResponse> future =
   *       daiEncodingProfileServiceClient
   *           .batchActivateDaiEncodingProfilesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchActivateDaiEncodingProfilesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
      batchActivateDaiEncodingProfilesCallable() {
    return stub.batchActivateDaiEncodingProfilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<ArchiveDaiEncodingProfileRequest> requests = new ArrayList<>();
   *   BatchArchiveDaiEncodingProfilesResponse response =
   *       daiEncodingProfileServiceClient.batchArchiveDaiEncodingProfiles(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param requests Required. The `DaiEncodingProfile` objects to archive. A maximum of 100 objects
   *     can be archived in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveDaiEncodingProfilesResponse batchArchiveDaiEncodingProfiles(
      @Nullable NetworkName parent, List<ArchiveDaiEncodingProfileRequest> requests) {
    BatchArchiveDaiEncodingProfilesRequest request =
        BatchArchiveDaiEncodingProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchArchiveDaiEncodingProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<ArchiveDaiEncodingProfileRequest> requests = new ArrayList<>();
   *   BatchArchiveDaiEncodingProfilesResponse response =
   *       daiEncodingProfileServiceClient.batchArchiveDaiEncodingProfiles(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param requests Required. The `DaiEncodingProfile` objects to archive. A maximum of 100 objects
   *     can be archived in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveDaiEncodingProfilesResponse batchArchiveDaiEncodingProfiles(
      String parent, List<ArchiveDaiEncodingProfileRequest> requests) {
    BatchArchiveDaiEncodingProfilesRequest request =
        BatchArchiveDaiEncodingProfilesRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchArchiveDaiEncodingProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   BatchArchiveDaiEncodingProfilesRequest request =
   *       BatchArchiveDaiEncodingProfilesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<ArchiveDaiEncodingProfileRequest>())
   *           .build();
   *   BatchArchiveDaiEncodingProfilesResponse response =
   *       daiEncodingProfileServiceClient.batchArchiveDaiEncodingProfiles(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveDaiEncodingProfilesResponse batchArchiveDaiEncodingProfiles(
      BatchArchiveDaiEncodingProfilesRequest request) {
    return batchArchiveDaiEncodingProfilesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `DaiEncodingProfile` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DaiEncodingProfileServiceClient daiEncodingProfileServiceClient =
   *     DaiEncodingProfileServiceClient.create()) {
   *   BatchArchiveDaiEncodingProfilesRequest request =
   *       BatchArchiveDaiEncodingProfilesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<ArchiveDaiEncodingProfileRequest>())
   *           .build();
   *   ApiFuture<BatchArchiveDaiEncodingProfilesResponse> future =
   *       daiEncodingProfileServiceClient
   *           .batchArchiveDaiEncodingProfilesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchArchiveDaiEncodingProfilesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
      batchArchiveDaiEncodingProfilesCallable() {
    return stub.batchArchiveDaiEncodingProfilesCallable();
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

  public static class ListDaiEncodingProfilesPagedResponse
      extends AbstractPagedListResponse<
          ListDaiEncodingProfilesRequest,
          ListDaiEncodingProfilesResponse,
          DaiEncodingProfile,
          ListDaiEncodingProfilesPage,
          ListDaiEncodingProfilesFixedSizeCollection> {

    public static ApiFuture<ListDaiEncodingProfilesPagedResponse> createAsync(
        PageContext<
                ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse, DaiEncodingProfile>
            context,
        ApiFuture<ListDaiEncodingProfilesResponse> futureResponse) {
      ApiFuture<ListDaiEncodingProfilesPage> futurePage =
          ListDaiEncodingProfilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDaiEncodingProfilesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDaiEncodingProfilesPagedResponse(ListDaiEncodingProfilesPage page) {
      super(page, ListDaiEncodingProfilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDaiEncodingProfilesPage
      extends AbstractPage<
          ListDaiEncodingProfilesRequest,
          ListDaiEncodingProfilesResponse,
          DaiEncodingProfile,
          ListDaiEncodingProfilesPage> {

    private ListDaiEncodingProfilesPage(
        @Nullable
            PageContext<
                ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse, DaiEncodingProfile>
            context,
        @Nullable ListDaiEncodingProfilesResponse response) {
      super(context, response);
    }

    private static ListDaiEncodingProfilesPage createEmptyPage() {
      return new ListDaiEncodingProfilesPage(null, null);
    }

    @Override
    protected ListDaiEncodingProfilesPage createPage(
        @Nullable
            PageContext<
                ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse, DaiEncodingProfile>
            context,
        @Nullable ListDaiEncodingProfilesResponse response) {
      return new ListDaiEncodingProfilesPage(context, response);
    }

    @Override
    public ApiFuture<ListDaiEncodingProfilesPage> createPageAsync(
        @Nullable
            PageContext<
                ListDaiEncodingProfilesRequest, ListDaiEncodingProfilesResponse, DaiEncodingProfile>
            context,
        ApiFuture<ListDaiEncodingProfilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDaiEncodingProfilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDaiEncodingProfilesRequest,
          ListDaiEncodingProfilesResponse,
          DaiEncodingProfile,
          ListDaiEncodingProfilesPage,
          ListDaiEncodingProfilesFixedSizeCollection> {

    private ListDaiEncodingProfilesFixedSizeCollection(
        @Nullable List<ListDaiEncodingProfilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDaiEncodingProfilesFixedSizeCollection createEmptyCollection() {
      return new ListDaiEncodingProfilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDaiEncodingProfilesFixedSizeCollection createCollection(
        @Nullable List<ListDaiEncodingProfilesPage> pages, int collectionSize) {
      return new ListDaiEncodingProfilesFixedSizeCollection(pages, collectionSize);
    }
  }
}
