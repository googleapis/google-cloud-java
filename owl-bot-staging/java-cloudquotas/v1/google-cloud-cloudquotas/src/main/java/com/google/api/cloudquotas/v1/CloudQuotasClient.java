/*
 * Copyright 2023 Google LLC
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

package com.google.api.cloudquotas.v1;

import com.google.api.cloudquotas.v1.stub.CloudQuotasStub;
import com.google.api.cloudquotas.v1.stub.CloudQuotasStubSettings;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Cloud Quotas API is an infrastructure service for Google Cloud that lets
 * service consumers list and manage their resource usage limits.
 *
 * <p>- List/Get the metadata and current status of the quotas for a service. - Create/Update quota
 * preferencess that declare the preferred quota values. - Check the status of a quota preference
 * request. - List/Get pending and historical quota preference.
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
 * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
 *   QuotaInfoName name =
 *       QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
 *           "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]");
 *   QuotaInfo response = cloudQuotasClient.getQuotaInfo(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudQuotasClient object to clean up resources such as
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
 *      <td><p> ListQuotaInfos</td>
 *      <td><p> Lists QuotaInfos of all quotas for a given project, folder or organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listQuotaInfos(ListQuotaInfosRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listQuotaInfos(ServiceName parent)
 *           <li><p> listQuotaInfos(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listQuotaInfosPagedCallable()
 *           <li><p> listQuotaInfosCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetQuotaInfo</td>
 *      <td><p> Retrieve the QuotaInfo of a quota for a project, folder or organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getQuotaInfo(GetQuotaInfoRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getQuotaInfo(QuotaInfoName name)
 *           <li><p> getQuotaInfo(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getQuotaInfoCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListQuotaPreferences</td>
 *      <td><p> Lists QuotaPreferences in a given project, folder or organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listQuotaPreferences(ListQuotaPreferencesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listQuotaPreferences(LocationName parent)
 *           <li><p> listQuotaPreferences(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listQuotaPreferencesPagedCallable()
 *           <li><p> listQuotaPreferencesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetQuotaPreference</td>
 *      <td><p> Gets details of a single QuotaPreference.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getQuotaPreference(GetQuotaPreferenceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getQuotaPreference(QuotaPreferenceName name)
 *           <li><p> getQuotaPreference(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getQuotaPreferenceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateQuotaPreference</td>
 *      <td><p> Creates a new QuotaPreference that declares the desired value for a quota.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createQuotaPreference(CreateQuotaPreferenceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createQuotaPreference(LocationName parent, QuotaPreference quotaPreference)
 *           <li><p> createQuotaPreference(String parent, QuotaPreference quotaPreference)
 *           <li><p> createQuotaPreference(LocationName parent, QuotaPreference quotaPreference, String quotaPreferenceId)
 *           <li><p> createQuotaPreference(String parent, QuotaPreference quotaPreference, String quotaPreferenceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createQuotaPreferenceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateQuotaPreference</td>
 *      <td><p> Updates the parameters of a single QuotaPreference. It can updates the config in any states, not just the ones pending approval.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateQuotaPreference(UpdateQuotaPreferenceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateQuotaPreference(QuotaPreference quotaPreference, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateQuotaPreferenceCallable()
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
 * <p>This class can be customized by passing in a custom instance of CloudQuotasSettings to
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
 * CloudQuotasSettings cloudQuotasSettings =
 *     CloudQuotasSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create(cloudQuotasSettings);
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
 * CloudQuotasSettings cloudQuotasSettings =
 *     CloudQuotasSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create(cloudQuotasSettings);
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
 * CloudQuotasSettings cloudQuotasSettings = CloudQuotasSettings.newHttpJsonBuilder().build();
 * CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create(cloudQuotasSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CloudQuotasClient implements BackgroundResource {
  private final CloudQuotasSettings settings;
  private final CloudQuotasStub stub;

  /** Constructs an instance of CloudQuotasClient with default settings. */
  public static final CloudQuotasClient create() throws IOException {
    return create(CloudQuotasSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudQuotasClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudQuotasClient create(CloudQuotasSettings settings) throws IOException {
    return new CloudQuotasClient(settings);
  }

  /**
   * Constructs an instance of CloudQuotasClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(CloudQuotasSettings).
   */
  public static final CloudQuotasClient create(CloudQuotasStub stub) {
    return new CloudQuotasClient(stub);
  }

  /**
   * Constructs an instance of CloudQuotasClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CloudQuotasClient(CloudQuotasSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudQuotasStubSettings) settings.getStubSettings()).createStub();
  }

  protected CloudQuotasClient(CloudQuotasStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CloudQuotasSettings getSettings() {
    return settings;
  }

  public CloudQuotasStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QuotaInfos of all quotas for a given project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   ServiceName parent =
   *       ServiceName.ofProjectLocationServiceName("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   for (QuotaInfo element : cloudQuotasClient.listQuotaInfos(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value of QuotaInfo resources. Listing across different resource
   *     containers (such as 'projects/-') is not allowed.
   *     <p>Example names: `projects/123/locations/global/services/compute.googleapis.com`
   *     `folders/234/locations/global/services/compute.googleapis.com`
   *     `organizations/345/locations/global/services/compute.googleapis.com`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQuotaInfosPagedResponse listQuotaInfos(ServiceName parent) {
    ListQuotaInfosRequest request =
        ListQuotaInfosRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listQuotaInfos(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QuotaInfos of all quotas for a given project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   String parent =
   *       ServiceName.ofProjectLocationServiceName("[PROJECT]", "[LOCATION]", "[SERVICE]")
   *           .toString();
   *   for (QuotaInfo element : cloudQuotasClient.listQuotaInfos(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value of QuotaInfo resources. Listing across different resource
   *     containers (such as 'projects/-') is not allowed.
   *     <p>Example names: `projects/123/locations/global/services/compute.googleapis.com`
   *     `folders/234/locations/global/services/compute.googleapis.com`
   *     `organizations/345/locations/global/services/compute.googleapis.com`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQuotaInfosPagedResponse listQuotaInfos(String parent) {
    ListQuotaInfosRequest request = ListQuotaInfosRequest.newBuilder().setParent(parent).build();
    return listQuotaInfos(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QuotaInfos of all quotas for a given project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   ListQuotaInfosRequest request =
   *       ListQuotaInfosRequest.newBuilder()
   *           .setParent(
   *               ServiceName.ofProjectLocationServiceName("[PROJECT]", "[LOCATION]", "[SERVICE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (QuotaInfo element : cloudQuotasClient.listQuotaInfos(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQuotaInfosPagedResponse listQuotaInfos(ListQuotaInfosRequest request) {
    return listQuotaInfosPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QuotaInfos of all quotas for a given project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   ListQuotaInfosRequest request =
   *       ListQuotaInfosRequest.newBuilder()
   *           .setParent(
   *               ServiceName.ofProjectLocationServiceName("[PROJECT]", "[LOCATION]", "[SERVICE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<QuotaInfo> future =
   *       cloudQuotasClient.listQuotaInfosPagedCallable().futureCall(request);
   *   // Do something.
   *   for (QuotaInfo element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListQuotaInfosRequest, ListQuotaInfosPagedResponse>
      listQuotaInfosPagedCallable() {
    return stub.listQuotaInfosPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QuotaInfos of all quotas for a given project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   ListQuotaInfosRequest request =
   *       ListQuotaInfosRequest.newBuilder()
   *           .setParent(
   *               ServiceName.ofProjectLocationServiceName("[PROJECT]", "[LOCATION]", "[SERVICE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListQuotaInfosResponse response = cloudQuotasClient.listQuotaInfosCallable().call(request);
   *     for (QuotaInfo element : response.getQuotaInfosList()) {
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
  public final UnaryCallable<ListQuotaInfosRequest, ListQuotaInfosResponse>
      listQuotaInfosCallable() {
    return stub.listQuotaInfosCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the QuotaInfo of a quota for a project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   QuotaInfoName name =
   *       QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
   *           "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]");
   *   QuotaInfo response = cloudQuotasClient.getQuotaInfo(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the quota info.
   *     <p>An example name:
   *     `projects/123/locations/global/services/compute.googleapis.com/quotaInfos/CpusPerProjectPerRegion`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaInfo getQuotaInfo(QuotaInfoName name) {
    GetQuotaInfoRequest request =
        GetQuotaInfoRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getQuotaInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the QuotaInfo of a quota for a project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   String name =
   *       QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
   *               "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]")
   *           .toString();
   *   QuotaInfo response = cloudQuotasClient.getQuotaInfo(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the quota info.
   *     <p>An example name:
   *     `projects/123/locations/global/services/compute.googleapis.com/quotaInfos/CpusPerProjectPerRegion`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaInfo getQuotaInfo(String name) {
    GetQuotaInfoRequest request = GetQuotaInfoRequest.newBuilder().setName(name).build();
    return getQuotaInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the QuotaInfo of a quota for a project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   GetQuotaInfoRequest request =
   *       GetQuotaInfoRequest.newBuilder()
   *           .setName(
   *               QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]")
   *                   .toString())
   *           .build();
   *   QuotaInfo response = cloudQuotasClient.getQuotaInfo(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaInfo getQuotaInfo(GetQuotaInfoRequest request) {
    return getQuotaInfoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the QuotaInfo of a quota for a project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   GetQuotaInfoRequest request =
   *       GetQuotaInfoRequest.newBuilder()
   *           .setName(
   *               QuotaInfoName.ofProjectLocationServiceQuotaInfoName(
   *                       "[PROJECT]", "[LOCATION]", "[SERVICE]", "[QUOTA_INFO]")
   *                   .toString())
   *           .build();
   *   ApiFuture<QuotaInfo> future = cloudQuotasClient.getQuotaInfoCallable().futureCall(request);
   *   // Do something.
   *   QuotaInfo response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoCallable() {
    return stub.getQuotaInfoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QuotaPreferences in a given project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
   *   for (QuotaPreference element : cloudQuotasClient.listQuotaPreferences(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value of QuotaPreference resources. Listing across different
   *     resource containers (such as 'projects/-') is not allowed.
   *     <p>When the value starts with 'folders' or 'organizations', it lists the QuotaPreferences
   *     for org quotas in the container. It does not list the QuotaPreferences in the descendant
   *     projects of the container.
   *     <p>Example parents: `projects/123/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQuotaPreferencesPagedResponse listQuotaPreferences(LocationName parent) {
    ListQuotaPreferencesRequest request =
        ListQuotaPreferencesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listQuotaPreferences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QuotaPreferences in a given project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   String parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString();
   *   for (QuotaPreference element : cloudQuotasClient.listQuotaPreferences(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value of QuotaPreference resources. Listing across different
   *     resource containers (such as 'projects/-') is not allowed.
   *     <p>When the value starts with 'folders' or 'organizations', it lists the QuotaPreferences
   *     for org quotas in the container. It does not list the QuotaPreferences in the descendant
   *     projects of the container.
   *     <p>Example parents: `projects/123/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQuotaPreferencesPagedResponse listQuotaPreferences(String parent) {
    ListQuotaPreferencesRequest request =
        ListQuotaPreferencesRequest.newBuilder().setParent(parent).build();
    return listQuotaPreferences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QuotaPreferences in a given project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   ListQuotaPreferencesRequest request =
   *       ListQuotaPreferencesRequest.newBuilder()
   *           .setParent(LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (QuotaPreference element : cloudQuotasClient.listQuotaPreferences(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListQuotaPreferencesPagedResponse listQuotaPreferences(
      ListQuotaPreferencesRequest request) {
    return listQuotaPreferencesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QuotaPreferences in a given project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   ListQuotaPreferencesRequest request =
   *       ListQuotaPreferencesRequest.newBuilder()
   *           .setParent(LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<QuotaPreference> future =
   *       cloudQuotasClient.listQuotaPreferencesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (QuotaPreference element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListQuotaPreferencesRequest, ListQuotaPreferencesPagedResponse>
      listQuotaPreferencesPagedCallable() {
    return stub.listQuotaPreferencesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists QuotaPreferences in a given project, folder or organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   ListQuotaPreferencesRequest request =
   *       ListQuotaPreferencesRequest.newBuilder()
   *           .setParent(LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListQuotaPreferencesResponse response =
   *         cloudQuotasClient.listQuotaPreferencesCallable().call(request);
   *     for (QuotaPreference element : response.getQuotaPreferencesList()) {
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
  public final UnaryCallable<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>
      listQuotaPreferencesCallable() {
    return stub.listQuotaPreferencesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single QuotaPreference.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   QuotaPreferenceName name =
   *       QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
   *           "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]");
   *   QuotaPreference response = cloudQuotasClient.getQuotaPreference(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   *     <p>Example name: `projects/123/locations/global/quota_preferences/my-config-for-us-east1`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaPreference getQuotaPreference(QuotaPreferenceName name) {
    GetQuotaPreferenceRequest request =
        GetQuotaPreferenceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getQuotaPreference(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single QuotaPreference.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   String name =
   *       QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
   *               "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
   *           .toString();
   *   QuotaPreference response = cloudQuotasClient.getQuotaPreference(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   *     <p>Example name: `projects/123/locations/global/quota_preferences/my-config-for-us-east1`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaPreference getQuotaPreference(String name) {
    GetQuotaPreferenceRequest request =
        GetQuotaPreferenceRequest.newBuilder().setName(name).build();
    return getQuotaPreference(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single QuotaPreference.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   GetQuotaPreferenceRequest request =
   *       GetQuotaPreferenceRequest.newBuilder()
   *           .setName(
   *               QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
   *                       "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
   *                   .toString())
   *           .build();
   *   QuotaPreference response = cloudQuotasClient.getQuotaPreference(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaPreference getQuotaPreference(GetQuotaPreferenceRequest request) {
    return getQuotaPreferenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single QuotaPreference.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   GetQuotaPreferenceRequest request =
   *       GetQuotaPreferenceRequest.newBuilder()
   *           .setName(
   *               QuotaPreferenceName.ofProjectLocationQuotaPreferenceName(
   *                       "[PROJECT]", "[LOCATION]", "[QUOTA_PREFERENCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<QuotaPreference> future =
   *       cloudQuotasClient.getQuotaPreferenceCallable().futureCall(request);
   *   // Do something.
   *   QuotaPreference response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetQuotaPreferenceRequest, QuotaPreference>
      getQuotaPreferenceCallable() {
    return stub.getQuotaPreferenceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new QuotaPreference that declares the desired value for a quota.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
   *   QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
   *   QuotaPreference response = cloudQuotasClient.createQuotaPreference(parent, quotaPreference);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   *     <p>Example: `projects/123/locations/global`
   * @param quotaPreference Required. The resource being created
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaPreference createQuotaPreference(
      LocationName parent, QuotaPreference quotaPreference) {
    CreateQuotaPreferenceRequest request =
        CreateQuotaPreferenceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setQuotaPreference(quotaPreference)
            .build();
    return createQuotaPreference(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new QuotaPreference that declares the desired value for a quota.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   String parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString();
   *   QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
   *   QuotaPreference response = cloudQuotasClient.createQuotaPreference(parent, quotaPreference);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   *     <p>Example: `projects/123/locations/global`
   * @param quotaPreference Required. The resource being created
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaPreference createQuotaPreference(
      String parent, QuotaPreference quotaPreference) {
    CreateQuotaPreferenceRequest request =
        CreateQuotaPreferenceRequest.newBuilder()
            .setParent(parent)
            .setQuotaPreference(quotaPreference)
            .build();
    return createQuotaPreference(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new QuotaPreference that declares the desired value for a quota.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   LocationName parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
   *   QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
   *   String quotaPreferenceId = "quotaPreferenceId-948332050";
   *   QuotaPreference response =
   *       cloudQuotasClient.createQuotaPreference(parent, quotaPreference, quotaPreferenceId);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   *     <p>Example: `projects/123/locations/global`
   * @param quotaPreference Required. The resource being created
   * @param quotaPreferenceId Optional. Id of the requesting object, must be unique under its
   *     parent. If client does not set this field, the service will generate one.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaPreference createQuotaPreference(
      LocationName parent, QuotaPreference quotaPreference, String quotaPreferenceId) {
    CreateQuotaPreferenceRequest request =
        CreateQuotaPreferenceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setQuotaPreference(quotaPreference)
            .setQuotaPreferenceId(quotaPreferenceId)
            .build();
    return createQuotaPreference(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new QuotaPreference that declares the desired value for a quota.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   String parent = LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString();
   *   QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
   *   String quotaPreferenceId = "quotaPreferenceId-948332050";
   *   QuotaPreference response =
   *       cloudQuotasClient.createQuotaPreference(parent, quotaPreference, quotaPreferenceId);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   *     <p>Example: `projects/123/locations/global`
   * @param quotaPreference Required. The resource being created
   * @param quotaPreferenceId Optional. Id of the requesting object, must be unique under its
   *     parent. If client does not set this field, the service will generate one.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaPreference createQuotaPreference(
      String parent, QuotaPreference quotaPreference, String quotaPreferenceId) {
    CreateQuotaPreferenceRequest request =
        CreateQuotaPreferenceRequest.newBuilder()
            .setParent(parent)
            .setQuotaPreference(quotaPreference)
            .setQuotaPreferenceId(quotaPreferenceId)
            .build();
    return createQuotaPreference(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new QuotaPreference that declares the desired value for a quota.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   CreateQuotaPreferenceRequest request =
   *       CreateQuotaPreferenceRequest.newBuilder()
   *           .setParent(LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
   *           .setQuotaPreferenceId("quotaPreferenceId-948332050")
   *           .setQuotaPreference(QuotaPreference.newBuilder().build())
   *           .addAllIgnoreSafetyChecks(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   QuotaPreference response = cloudQuotasClient.createQuotaPreference(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaPreference createQuotaPreference(CreateQuotaPreferenceRequest request) {
    return createQuotaPreferenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new QuotaPreference that declares the desired value for a quota.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   CreateQuotaPreferenceRequest request =
   *       CreateQuotaPreferenceRequest.newBuilder()
   *           .setParent(LocationName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
   *           .setQuotaPreferenceId("quotaPreferenceId-948332050")
   *           .setQuotaPreference(QuotaPreference.newBuilder().build())
   *           .addAllIgnoreSafetyChecks(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   ApiFuture<QuotaPreference> future =
   *       cloudQuotasClient.createQuotaPreferenceCallable().futureCall(request);
   *   // Do something.
   *   QuotaPreference response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateQuotaPreferenceRequest, QuotaPreference>
      createQuotaPreferenceCallable() {
    return stub.createQuotaPreferenceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single QuotaPreference. It can updates the config in any states,
   * not just the ones pending approval.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   QuotaPreference quotaPreference = QuotaPreference.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   QuotaPreference response =
   *       cloudQuotasClient.updateQuotaPreference(quotaPreference, updateMask);
   * }
   * }</pre>
   *
   * @param quotaPreference Required. The resource being updated
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     QuotaPreference resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaPreference updateQuotaPreference(
      QuotaPreference quotaPreference, FieldMask updateMask) {
    UpdateQuotaPreferenceRequest request =
        UpdateQuotaPreferenceRequest.newBuilder()
            .setQuotaPreference(quotaPreference)
            .setUpdateMask(updateMask)
            .build();
    return updateQuotaPreference(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single QuotaPreference. It can updates the config in any states,
   * not just the ones pending approval.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   UpdateQuotaPreferenceRequest request =
   *       UpdateQuotaPreferenceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setQuotaPreference(QuotaPreference.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .addAllIgnoreSafetyChecks(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   QuotaPreference response = cloudQuotasClient.updateQuotaPreference(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QuotaPreference updateQuotaPreference(UpdateQuotaPreferenceRequest request) {
    return updateQuotaPreferenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single QuotaPreference. It can updates the config in any states,
   * not just the ones pending approval.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudQuotasClient cloudQuotasClient = CloudQuotasClient.create()) {
   *   UpdateQuotaPreferenceRequest request =
   *       UpdateQuotaPreferenceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setQuotaPreference(QuotaPreference.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .addAllIgnoreSafetyChecks(new ArrayList<QuotaSafetyCheck>())
   *           .build();
   *   ApiFuture<QuotaPreference> future =
   *       cloudQuotasClient.updateQuotaPreferenceCallable().futureCall(request);
   *   // Do something.
   *   QuotaPreference response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateQuotaPreferenceRequest, QuotaPreference>
      updateQuotaPreferenceCallable() {
    return stub.updateQuotaPreferenceCallable();
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

  public static class ListQuotaInfosPagedResponse
      extends AbstractPagedListResponse<
          ListQuotaInfosRequest,
          ListQuotaInfosResponse,
          QuotaInfo,
          ListQuotaInfosPage,
          ListQuotaInfosFixedSizeCollection> {

    public static ApiFuture<ListQuotaInfosPagedResponse> createAsync(
        PageContext<ListQuotaInfosRequest, ListQuotaInfosResponse, QuotaInfo> context,
        ApiFuture<ListQuotaInfosResponse> futureResponse) {
      ApiFuture<ListQuotaInfosPage> futurePage =
          ListQuotaInfosPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListQuotaInfosPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListQuotaInfosPagedResponse(ListQuotaInfosPage page) {
      super(page, ListQuotaInfosFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListQuotaInfosPage
      extends AbstractPage<
          ListQuotaInfosRequest, ListQuotaInfosResponse, QuotaInfo, ListQuotaInfosPage> {

    private ListQuotaInfosPage(
        PageContext<ListQuotaInfosRequest, ListQuotaInfosResponse, QuotaInfo> context,
        ListQuotaInfosResponse response) {
      super(context, response);
    }

    private static ListQuotaInfosPage createEmptyPage() {
      return new ListQuotaInfosPage(null, null);
    }

    @Override
    protected ListQuotaInfosPage createPage(
        PageContext<ListQuotaInfosRequest, ListQuotaInfosResponse, QuotaInfo> context,
        ListQuotaInfosResponse response) {
      return new ListQuotaInfosPage(context, response);
    }

    @Override
    public ApiFuture<ListQuotaInfosPage> createPageAsync(
        PageContext<ListQuotaInfosRequest, ListQuotaInfosResponse, QuotaInfo> context,
        ApiFuture<ListQuotaInfosResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListQuotaInfosFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListQuotaInfosRequest,
          ListQuotaInfosResponse,
          QuotaInfo,
          ListQuotaInfosPage,
          ListQuotaInfosFixedSizeCollection> {

    private ListQuotaInfosFixedSizeCollection(List<ListQuotaInfosPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListQuotaInfosFixedSizeCollection createEmptyCollection() {
      return new ListQuotaInfosFixedSizeCollection(null, 0);
    }

    @Override
    protected ListQuotaInfosFixedSizeCollection createCollection(
        List<ListQuotaInfosPage> pages, int collectionSize) {
      return new ListQuotaInfosFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListQuotaPreferencesPagedResponse
      extends AbstractPagedListResponse<
          ListQuotaPreferencesRequest,
          ListQuotaPreferencesResponse,
          QuotaPreference,
          ListQuotaPreferencesPage,
          ListQuotaPreferencesFixedSizeCollection> {

    public static ApiFuture<ListQuotaPreferencesPagedResponse> createAsync(
        PageContext<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse, QuotaPreference>
            context,
        ApiFuture<ListQuotaPreferencesResponse> futureResponse) {
      ApiFuture<ListQuotaPreferencesPage> futurePage =
          ListQuotaPreferencesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListQuotaPreferencesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListQuotaPreferencesPagedResponse(ListQuotaPreferencesPage page) {
      super(page, ListQuotaPreferencesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListQuotaPreferencesPage
      extends AbstractPage<
          ListQuotaPreferencesRequest,
          ListQuotaPreferencesResponse,
          QuotaPreference,
          ListQuotaPreferencesPage> {

    private ListQuotaPreferencesPage(
        PageContext<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse, QuotaPreference>
            context,
        ListQuotaPreferencesResponse response) {
      super(context, response);
    }

    private static ListQuotaPreferencesPage createEmptyPage() {
      return new ListQuotaPreferencesPage(null, null);
    }

    @Override
    protected ListQuotaPreferencesPage createPage(
        PageContext<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse, QuotaPreference>
            context,
        ListQuotaPreferencesResponse response) {
      return new ListQuotaPreferencesPage(context, response);
    }

    @Override
    public ApiFuture<ListQuotaPreferencesPage> createPageAsync(
        PageContext<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse, QuotaPreference>
            context,
        ApiFuture<ListQuotaPreferencesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListQuotaPreferencesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListQuotaPreferencesRequest,
          ListQuotaPreferencesResponse,
          QuotaPreference,
          ListQuotaPreferencesPage,
          ListQuotaPreferencesFixedSizeCollection> {

    private ListQuotaPreferencesFixedSizeCollection(
        List<ListQuotaPreferencesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListQuotaPreferencesFixedSizeCollection createEmptyCollection() {
      return new ListQuotaPreferencesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListQuotaPreferencesFixedSizeCollection createCollection(
        List<ListQuotaPreferencesPage> pages, int collectionSize) {
      return new ListQuotaPreferencesFixedSizeCollection(pages, collectionSize);
    }
  }
}
