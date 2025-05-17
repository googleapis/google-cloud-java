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

package com.google.shopping.merchant.accounts.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.OmnichannelSettingsServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.OmnichannelSettingsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The service facilitates the management of a merchant's omnichannel settings.
 * ## This API defines the following resource model:
 *
 * <p>[OmnichannelSetting][google.shopping.merchant.accounts.v1.OmnichannelSetting]
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
 * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
 *     OmnichannelSettingsServiceClient.create()) {
 *   OmnichannelSettingName name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");
 *   OmnichannelSetting response = omnichannelSettingsServiceClient.getOmnichannelSetting(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OmnichannelSettingsServiceClient object to clean up
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
 *      <td><p> GetOmnichannelSetting</td>
 *      <td><p> Get the omnichannel settings for a given merchant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOmnichannelSetting(GetOmnichannelSettingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOmnichannelSetting(OmnichannelSettingName name)
 *           <li><p> getOmnichannelSetting(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOmnichannelSettingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOmnichannelSettings</td>
 *      <td><p> List all the omnichannel settings for a given merchant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOmnichannelSettings(ListOmnichannelSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOmnichannelSettings(AccountName parent)
 *           <li><p> listOmnichannelSettings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOmnichannelSettingsPagedCallable()
 *           <li><p> listOmnichannelSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateOmnichannelSetting</td>
 *      <td><p> Create the omnichannel settings for a given merchant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createOmnichannelSetting(CreateOmnichannelSettingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createOmnichannelSetting(AccountName parent, OmnichannelSetting omnichannelSetting)
 *           <li><p> createOmnichannelSetting(String parent, OmnichannelSetting omnichannelSetting)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createOmnichannelSettingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateOmnichannelSetting</td>
 *      <td><p> Update the omnichannel setting for a given merchant in a given country.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateOmnichannelSetting(UpdateOmnichannelSettingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateOmnichannelSetting(OmnichannelSetting omnichannelSetting, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateOmnichannelSettingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RequestInventoryVerification</td>
 *      <td><p> Requests inventory verification for a given merchant in a given country.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> requestInventoryVerification(OmnichannelSettingName name)
 *           <li><p> requestInventoryVerification(String name)
 *           <li><p> requestInventoryVerification(RequestInventoryVerificationRequest request)
 *           <li><p> requestInventoryVerificationCallable()
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
 * OmnichannelSettingsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OmnichannelSettingsServiceSettings omnichannelSettingsServiceSettings =
 *     OmnichannelSettingsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
 *     OmnichannelSettingsServiceClient.create(omnichannelSettingsServiceSettings);
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
 * OmnichannelSettingsServiceSettings omnichannelSettingsServiceSettings =
 *     OmnichannelSettingsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
 *     OmnichannelSettingsServiceClient.create(omnichannelSettingsServiceSettings);
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
 * OmnichannelSettingsServiceSettings omnichannelSettingsServiceSettings =
 *     OmnichannelSettingsServiceSettings.newHttpJsonBuilder().build();
 * OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
 *     OmnichannelSettingsServiceClient.create(omnichannelSettingsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class OmnichannelSettingsServiceClient implements BackgroundResource {
  private final OmnichannelSettingsServiceSettings settings;
  private final OmnichannelSettingsServiceStub stub;

  /** Constructs an instance of OmnichannelSettingsServiceClient with default settings. */
  public static final OmnichannelSettingsServiceClient create() throws IOException {
    return create(OmnichannelSettingsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OmnichannelSettingsServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final OmnichannelSettingsServiceClient create(
      OmnichannelSettingsServiceSettings settings) throws IOException {
    return new OmnichannelSettingsServiceClient(settings);
  }

  /**
   * Constructs an instance of OmnichannelSettingsServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(OmnichannelSettingsServiceSettings).
   */
  public static final OmnichannelSettingsServiceClient create(OmnichannelSettingsServiceStub stub) {
    return new OmnichannelSettingsServiceClient(stub);
  }

  /**
   * Constructs an instance of OmnichannelSettingsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected OmnichannelSettingsServiceClient(OmnichannelSettingsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((OmnichannelSettingsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected OmnichannelSettingsServiceClient(OmnichannelSettingsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OmnichannelSettingsServiceSettings getSettings() {
    return settings;
  }

  public OmnichannelSettingsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the omnichannel settings for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   OmnichannelSettingName name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");
   *   OmnichannelSetting response = omnichannelSettingsServiceClient.getOmnichannelSetting(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the omnichannel setting to retrieve. Format:
   *     `accounts/{account}/omnichannelSettings/{omnichannel_setting}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OmnichannelSetting getOmnichannelSetting(OmnichannelSettingName name) {
    GetOmnichannelSettingRequest request =
        GetOmnichannelSettingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getOmnichannelSetting(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the omnichannel settings for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   String name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString();
   *   OmnichannelSetting response = omnichannelSettingsServiceClient.getOmnichannelSetting(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the omnichannel setting to retrieve. Format:
   *     `accounts/{account}/omnichannelSettings/{omnichannel_setting}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OmnichannelSetting getOmnichannelSetting(String name) {
    GetOmnichannelSettingRequest request =
        GetOmnichannelSettingRequest.newBuilder().setName(name).build();
    return getOmnichannelSetting(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the omnichannel settings for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   GetOmnichannelSettingRequest request =
   *       GetOmnichannelSettingRequest.newBuilder()
   *           .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
   *           .build();
   *   OmnichannelSetting response = omnichannelSettingsServiceClient.getOmnichannelSetting(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OmnichannelSetting getOmnichannelSetting(GetOmnichannelSettingRequest request) {
    return getOmnichannelSettingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the omnichannel settings for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   GetOmnichannelSettingRequest request =
   *       GetOmnichannelSettingRequest.newBuilder()
   *           .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
   *           .build();
   *   ApiFuture<OmnichannelSetting> future =
   *       omnichannelSettingsServiceClient.getOmnichannelSettingCallable().futureCall(request);
   *   // Do something.
   *   OmnichannelSetting response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOmnichannelSettingRequest, OmnichannelSetting>
      getOmnichannelSettingCallable() {
    return stub.getOmnichannelSettingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the omnichannel settings for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (OmnichannelSetting element :
   *       omnichannelSettingsServiceClient.listOmnichannelSettings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of omnichannel settings. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOmnichannelSettingsPagedResponse listOmnichannelSettings(AccountName parent) {
    ListOmnichannelSettingsRequest request =
        ListOmnichannelSettingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOmnichannelSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the omnichannel settings for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (OmnichannelSetting element :
   *       omnichannelSettingsServiceClient.listOmnichannelSettings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of omnichannel settings. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOmnichannelSettingsPagedResponse listOmnichannelSettings(String parent) {
    ListOmnichannelSettingsRequest request =
        ListOmnichannelSettingsRequest.newBuilder().setParent(parent).build();
    return listOmnichannelSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the omnichannel settings for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   ListOmnichannelSettingsRequest request =
   *       ListOmnichannelSettingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (OmnichannelSetting element :
   *       omnichannelSettingsServiceClient.listOmnichannelSettings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOmnichannelSettingsPagedResponse listOmnichannelSettings(
      ListOmnichannelSettingsRequest request) {
    return listOmnichannelSettingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the omnichannel settings for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   ListOmnichannelSettingsRequest request =
   *       ListOmnichannelSettingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<OmnichannelSetting> future =
   *       omnichannelSettingsServiceClient
   *           .listOmnichannelSettingsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (OmnichannelSetting element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOmnichannelSettingsRequest, ListOmnichannelSettingsPagedResponse>
      listOmnichannelSettingsPagedCallable() {
    return stub.listOmnichannelSettingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the omnichannel settings for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   ListOmnichannelSettingsRequest request =
   *       ListOmnichannelSettingsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListOmnichannelSettingsResponse response =
   *         omnichannelSettingsServiceClient.listOmnichannelSettingsCallable().call(request);
   *     for (OmnichannelSetting element : response.getOmnichannelSettingsList()) {
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
  public final UnaryCallable<ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>
      listOmnichannelSettingsCallable() {
    return stub.listOmnichannelSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create the omnichannel settings for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   OmnichannelSetting omnichannelSetting = OmnichannelSetting.newBuilder().build();
   *   OmnichannelSetting response =
   *       omnichannelSettingsServiceClient.createOmnichannelSetting(parent, omnichannelSetting);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this omnichannel setting will be created.
   *     Format: `accounts/{account}`
   * @param omnichannelSetting Required. The omnichannel setting to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OmnichannelSetting createOmnichannelSetting(
      AccountName parent, OmnichannelSetting omnichannelSetting) {
    CreateOmnichannelSettingRequest request =
        CreateOmnichannelSettingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setOmnichannelSetting(omnichannelSetting)
            .build();
    return createOmnichannelSetting(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create the omnichannel settings for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   OmnichannelSetting omnichannelSetting = OmnichannelSetting.newBuilder().build();
   *   OmnichannelSetting response =
   *       omnichannelSettingsServiceClient.createOmnichannelSetting(parent, omnichannelSetting);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this omnichannel setting will be created.
   *     Format: `accounts/{account}`
   * @param omnichannelSetting Required. The omnichannel setting to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OmnichannelSetting createOmnichannelSetting(
      String parent, OmnichannelSetting omnichannelSetting) {
    CreateOmnichannelSettingRequest request =
        CreateOmnichannelSettingRequest.newBuilder()
            .setParent(parent)
            .setOmnichannelSetting(omnichannelSetting)
            .build();
    return createOmnichannelSetting(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create the omnichannel settings for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   CreateOmnichannelSettingRequest request =
   *       CreateOmnichannelSettingRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setOmnichannelSetting(OmnichannelSetting.newBuilder().build())
   *           .build();
   *   OmnichannelSetting response =
   *       omnichannelSettingsServiceClient.createOmnichannelSetting(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OmnichannelSetting createOmnichannelSetting(
      CreateOmnichannelSettingRequest request) {
    return createOmnichannelSettingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create the omnichannel settings for a given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   CreateOmnichannelSettingRequest request =
   *       CreateOmnichannelSettingRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setOmnichannelSetting(OmnichannelSetting.newBuilder().build())
   *           .build();
   *   ApiFuture<OmnichannelSetting> future =
   *       omnichannelSettingsServiceClient.createOmnichannelSettingCallable().futureCall(request);
   *   // Do something.
   *   OmnichannelSetting response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateOmnichannelSettingRequest, OmnichannelSetting>
      createOmnichannelSettingCallable() {
    return stub.createOmnichannelSettingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the omnichannel setting for a given merchant in a given country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   OmnichannelSetting omnichannelSetting = OmnichannelSetting.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   OmnichannelSetting response =
   *       omnichannelSettingsServiceClient.updateOmnichannelSetting(omnichannelSetting, updateMask);
   * }
   * }</pre>
   *
   * @param omnichannelSetting Required. The omnichannel setting to update.
   *     <p>The omnichannel setting's `name` field is used to identify the omnichannel setting to be
   *     updated.
   * @param updateMask Required. The list of fields to be updated.
   *     <p>The following fields are supported in snake_case only: - `lsf_type` - `in_stock` -
   *     `pickup` - `odo` - `about` - `inventory_verification`
   *     <p>Full replacement with wildcard `&#42;`is supported, while empty/implied update mask is
   *     not.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OmnichannelSetting updateOmnichannelSetting(
      OmnichannelSetting omnichannelSetting, FieldMask updateMask) {
    UpdateOmnichannelSettingRequest request =
        UpdateOmnichannelSettingRequest.newBuilder()
            .setOmnichannelSetting(omnichannelSetting)
            .setUpdateMask(updateMask)
            .build();
    return updateOmnichannelSetting(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the omnichannel setting for a given merchant in a given country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   UpdateOmnichannelSettingRequest request =
   *       UpdateOmnichannelSettingRequest.newBuilder()
   *           .setOmnichannelSetting(OmnichannelSetting.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OmnichannelSetting response =
   *       omnichannelSettingsServiceClient.updateOmnichannelSetting(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OmnichannelSetting updateOmnichannelSetting(
      UpdateOmnichannelSettingRequest request) {
    return updateOmnichannelSettingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the omnichannel setting for a given merchant in a given country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   UpdateOmnichannelSettingRequest request =
   *       UpdateOmnichannelSettingRequest.newBuilder()
   *           .setOmnichannelSetting(OmnichannelSetting.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<OmnichannelSetting> future =
   *       omnichannelSettingsServiceClient.updateOmnichannelSettingCallable().futureCall(request);
   *   // Do something.
   *   OmnichannelSetting response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateOmnichannelSettingRequest, OmnichannelSetting>
      updateOmnichannelSettingCallable() {
    return stub.updateOmnichannelSettingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests inventory verification for a given merchant in a given country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   OmnichannelSettingName name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");
   *   RequestInventoryVerificationResponse response =
   *       omnichannelSettingsServiceClient.requestInventoryVerification(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the omnichannel setting to request inventory verification.
   *     Format: `accounts/{account}/omnichannelSettings/{omnichannel_setting}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RequestInventoryVerificationResponse requestInventoryVerification(
      OmnichannelSettingName name) {
    RequestInventoryVerificationRequest request =
        RequestInventoryVerificationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return requestInventoryVerification(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests inventory verification for a given merchant in a given country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   String name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString();
   *   RequestInventoryVerificationResponse response =
   *       omnichannelSettingsServiceClient.requestInventoryVerification(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the omnichannel setting to request inventory verification.
   *     Format: `accounts/{account}/omnichannelSettings/{omnichannel_setting}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RequestInventoryVerificationResponse requestInventoryVerification(String name) {
    RequestInventoryVerificationRequest request =
        RequestInventoryVerificationRequest.newBuilder().setName(name).build();
    return requestInventoryVerification(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests inventory verification for a given merchant in a given country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   RequestInventoryVerificationRequest request =
   *       RequestInventoryVerificationRequest.newBuilder()
   *           .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
   *           .build();
   *   RequestInventoryVerificationResponse response =
   *       omnichannelSettingsServiceClient.requestInventoryVerification(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RequestInventoryVerificationResponse requestInventoryVerification(
      RequestInventoryVerificationRequest request) {
    return requestInventoryVerificationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests inventory verification for a given merchant in a given country.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OmnichannelSettingsServiceClient omnichannelSettingsServiceClient =
   *     OmnichannelSettingsServiceClient.create()) {
   *   RequestInventoryVerificationRequest request =
   *       RequestInventoryVerificationRequest.newBuilder()
   *           .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
   *           .build();
   *   ApiFuture<RequestInventoryVerificationResponse> future =
   *       omnichannelSettingsServiceClient
   *           .requestInventoryVerificationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   RequestInventoryVerificationResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
      requestInventoryVerificationCallable() {
    return stub.requestInventoryVerificationCallable();
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

  public static class ListOmnichannelSettingsPagedResponse
      extends AbstractPagedListResponse<
          ListOmnichannelSettingsRequest,
          ListOmnichannelSettingsResponse,
          OmnichannelSetting,
          ListOmnichannelSettingsPage,
          ListOmnichannelSettingsFixedSizeCollection> {

    public static ApiFuture<ListOmnichannelSettingsPagedResponse> createAsync(
        PageContext<
                ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse, OmnichannelSetting>
            context,
        ApiFuture<ListOmnichannelSettingsResponse> futureResponse) {
      ApiFuture<ListOmnichannelSettingsPage> futurePage =
          ListOmnichannelSettingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOmnichannelSettingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOmnichannelSettingsPagedResponse(ListOmnichannelSettingsPage page) {
      super(page, ListOmnichannelSettingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOmnichannelSettingsPage
      extends AbstractPage<
          ListOmnichannelSettingsRequest,
          ListOmnichannelSettingsResponse,
          OmnichannelSetting,
          ListOmnichannelSettingsPage> {

    private ListOmnichannelSettingsPage(
        PageContext<
                ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse, OmnichannelSetting>
            context,
        ListOmnichannelSettingsResponse response) {
      super(context, response);
    }

    private static ListOmnichannelSettingsPage createEmptyPage() {
      return new ListOmnichannelSettingsPage(null, null);
    }

    @Override
    protected ListOmnichannelSettingsPage createPage(
        PageContext<
                ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse, OmnichannelSetting>
            context,
        ListOmnichannelSettingsResponse response) {
      return new ListOmnichannelSettingsPage(context, response);
    }

    @Override
    public ApiFuture<ListOmnichannelSettingsPage> createPageAsync(
        PageContext<
                ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse, OmnichannelSetting>
            context,
        ApiFuture<ListOmnichannelSettingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOmnichannelSettingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOmnichannelSettingsRequest,
          ListOmnichannelSettingsResponse,
          OmnichannelSetting,
          ListOmnichannelSettingsPage,
          ListOmnichannelSettingsFixedSizeCollection> {

    private ListOmnichannelSettingsFixedSizeCollection(
        List<ListOmnichannelSettingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOmnichannelSettingsFixedSizeCollection createEmptyCollection() {
      return new ListOmnichannelSettingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOmnichannelSettingsFixedSizeCollection createCollection(
        List<ListOmnichannelSettingsPage> pages, int collectionSize) {
      return new ListOmnichannelSettingsFixedSizeCollection(pages, collectionSize);
    }
  }
}
