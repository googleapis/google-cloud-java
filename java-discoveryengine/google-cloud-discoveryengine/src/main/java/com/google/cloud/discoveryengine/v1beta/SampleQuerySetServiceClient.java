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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.stub.SampleQuerySetServiceStub;
import com.google.cloud.discoveryengine.v1beta.stub.SampleQuerySetServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]s,
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
 * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
 *     SampleQuerySetServiceClient.create()) {
 *   SampleQuerySetName name =
 *       SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");
 *   SampleQuerySet response = sampleQuerySetServiceClient.getSampleQuerySet(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SampleQuerySetServiceClient object to clean up
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
 *      <td><p> GetSampleQuerySet</td>
 *      <td><p> Gets a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSampleQuerySet(GetSampleQuerySetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSampleQuerySet(SampleQuerySetName name)
 *           <li><p> getSampleQuerySet(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSampleQuerySetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSampleQuerySets</td>
 *      <td><p> Gets a list of [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]s.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSampleQuerySets(ListSampleQuerySetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSampleQuerySets(LocationName parent)
 *           <li><p> listSampleQuerySets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSampleQuerySetsPagedCallable()
 *           <li><p> listSampleQuerySetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSampleQuerySet</td>
 *      <td><p> Creates a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSampleQuerySet(CreateSampleQuerySetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSampleQuerySet(LocationName parent, SampleQuerySet sampleQuerySet, String sampleQuerySetId)
 *           <li><p> createSampleQuerySet(String parent, SampleQuerySet sampleQuerySet, String sampleQuerySetId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSampleQuerySetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSampleQuerySet</td>
 *      <td><p> Updates a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSampleQuerySet(UpdateSampleQuerySetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSampleQuerySet(SampleQuerySet sampleQuerySet, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSampleQuerySetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSampleQuerySet</td>
 *      <td><p> Deletes a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSampleQuerySet(DeleteSampleQuerySetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSampleQuerySet(SampleQuerySetName name)
 *           <li><p> deleteSampleQuerySet(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSampleQuerySetCallable()
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
 * <p>This class can be customized by passing in a custom instance of SampleQuerySetServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SampleQuerySetServiceSettings sampleQuerySetServiceSettings =
 *     SampleQuerySetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SampleQuerySetServiceClient sampleQuerySetServiceClient =
 *     SampleQuerySetServiceClient.create(sampleQuerySetServiceSettings);
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
 * SampleQuerySetServiceSettings sampleQuerySetServiceSettings =
 *     SampleQuerySetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SampleQuerySetServiceClient sampleQuerySetServiceClient =
 *     SampleQuerySetServiceClient.create(sampleQuerySetServiceSettings);
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
 * SampleQuerySetServiceSettings sampleQuerySetServiceSettings =
 *     SampleQuerySetServiceSettings.newHttpJsonBuilder().build();
 * SampleQuerySetServiceClient sampleQuerySetServiceClient =
 *     SampleQuerySetServiceClient.create(sampleQuerySetServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SampleQuerySetServiceClient implements BackgroundResource {
  private final SampleQuerySetServiceSettings settings;
  private final SampleQuerySetServiceStub stub;

  /** Constructs an instance of SampleQuerySetServiceClient with default settings. */
  public static final SampleQuerySetServiceClient create() throws IOException {
    return create(SampleQuerySetServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SampleQuerySetServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SampleQuerySetServiceClient create(SampleQuerySetServiceSettings settings)
      throws IOException {
    return new SampleQuerySetServiceClient(settings);
  }

  /**
   * Constructs an instance of SampleQuerySetServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SampleQuerySetServiceSettings).
   */
  public static final SampleQuerySetServiceClient create(SampleQuerySetServiceStub stub) {
    return new SampleQuerySetServiceClient(stub);
  }

  /**
   * Constructs an instance of SampleQuerySetServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SampleQuerySetServiceClient(SampleQuerySetServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SampleQuerySetServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SampleQuerySetServiceClient(SampleQuerySetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SampleQuerySetServiceSettings getSettings() {
    return settings;
  }

  public SampleQuerySetServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   SampleQuerySetName name =
   *       SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");
   *   SampleQuerySet response = sampleQuerySetServiceClient.getSampleQuerySet(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet], such as
   *     `projects/{project}/locations/{location}/sampleQuerySets/{sample_query_set}`.
   *     <p>If the caller does not have permission to access the
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet], regardless of whether
   *     or not it exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]
   *     does not exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuerySet getSampleQuerySet(SampleQuerySetName name) {
    GetSampleQuerySetRequest request =
        GetSampleQuerySetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSampleQuerySet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   String name =
   *       SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString();
   *   SampleQuerySet response = sampleQuerySetServiceClient.getSampleQuerySet(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet], such as
   *     `projects/{project}/locations/{location}/sampleQuerySets/{sample_query_set}`.
   *     <p>If the caller does not have permission to access the
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet], regardless of whether
   *     or not it exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]
   *     does not exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuerySet getSampleQuerySet(String name) {
    GetSampleQuerySetRequest request = GetSampleQuerySetRequest.newBuilder().setName(name).build();
    return getSampleQuerySet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   GetSampleQuerySetRequest request =
   *       GetSampleQuerySetRequest.newBuilder()
   *           .setName(
   *               SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
   *           .build();
   *   SampleQuerySet response = sampleQuerySetServiceClient.getSampleQuerySet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuerySet getSampleQuerySet(GetSampleQuerySetRequest request) {
    return getSampleQuerySetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   GetSampleQuerySetRequest request =
   *       GetSampleQuerySetRequest.newBuilder()
   *           .setName(
   *               SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
   *           .build();
   *   ApiFuture<SampleQuerySet> future =
   *       sampleQuerySetServiceClient.getSampleQuerySetCallable().futureCall(request);
   *   // Do something.
   *   SampleQuerySet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSampleQuerySetRequest, SampleQuerySet> getSampleQuerySetCallable() {
    return stub.getSampleQuerySetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SampleQuerySet element :
   *       sampleQuerySetServiceClient.listSampleQuerySets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location resource name, such as
   *     `projects/{project}/locations/{location}`.
   *     <p>If the caller does not have permission to list
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]s under this location,
   *     regardless of whether or not this location exists, a `PERMISSION_DENIED` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSampleQuerySetsPagedResponse listSampleQuerySets(LocationName parent) {
    ListSampleQuerySetsRequest request =
        ListSampleQuerySetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSampleQuerySets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (SampleQuerySet element :
   *       sampleQuerySetServiceClient.listSampleQuerySets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location resource name, such as
   *     `projects/{project}/locations/{location}`.
   *     <p>If the caller does not have permission to list
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]s under this location,
   *     regardless of whether or not this location exists, a `PERMISSION_DENIED` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSampleQuerySetsPagedResponse listSampleQuerySets(String parent) {
    ListSampleQuerySetsRequest request =
        ListSampleQuerySetsRequest.newBuilder().setParent(parent).build();
    return listSampleQuerySets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   ListSampleQuerySetsRequest request =
   *       ListSampleQuerySetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SampleQuerySet element :
   *       sampleQuerySetServiceClient.listSampleQuerySets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSampleQuerySetsPagedResponse listSampleQuerySets(
      ListSampleQuerySetsRequest request) {
    return listSampleQuerySetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   ListSampleQuerySetsRequest request =
   *       ListSampleQuerySetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SampleQuerySet> future =
   *       sampleQuerySetServiceClient.listSampleQuerySetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SampleQuerySet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSampleQuerySetsRequest, ListSampleQuerySetsPagedResponse>
      listSampleQuerySetsPagedCallable() {
    return stub.listSampleQuerySetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   ListSampleQuerySetsRequest request =
   *       ListSampleQuerySetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSampleQuerySetsResponse response =
   *         sampleQuerySetServiceClient.listSampleQuerySetsCallable().call(request);
   *     for (SampleQuerySet element : response.getSampleQuerySetsList()) {
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
  public final UnaryCallable<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse>
      listSampleQuerySetsCallable() {
    return stub.listSampleQuerySetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   SampleQuerySet sampleQuerySet = SampleQuerySet.newBuilder().build();
   *   String sampleQuerySetId = "sampleQuerySetId1320431231";
   *   SampleQuerySet response =
   *       sampleQuerySetServiceClient.createSampleQuerySet(
   *           parent, sampleQuerySet, sampleQuerySetId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}`.
   * @param sampleQuerySet Required. The
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet] to create.
   * @param sampleQuerySetId Required. The ID to use for the
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet], which will become the
   *     final component of the
   *     [SampleQuerySet.name][google.cloud.discoveryengine.v1beta.SampleQuerySet.name].
   *     <p>If the caller does not have permission to create the
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet], regardless of whether
   *     or not it exists, a `PERMISSION_DENIED` error is returned.
   *     <p>This field must be unique among all
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]s with the same
   *     [parent][google.cloud.discoveryengine.v1beta.CreateSampleQuerySetRequest.parent].
   *     Otherwise, an `ALREADY_EXISTS` error is returned.
   *     <p>This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with
   *     a length limit of 63 characters. Otherwise, an `INVALID_ARGUMENT` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuerySet createSampleQuerySet(
      LocationName parent, SampleQuerySet sampleQuerySet, String sampleQuerySetId) {
    CreateSampleQuerySetRequest request =
        CreateSampleQuerySetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSampleQuerySet(sampleQuerySet)
            .setSampleQuerySetId(sampleQuerySetId)
            .build();
    return createSampleQuerySet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   SampleQuerySet sampleQuerySet = SampleQuerySet.newBuilder().build();
   *   String sampleQuerySetId = "sampleQuerySetId1320431231";
   *   SampleQuerySet response =
   *       sampleQuerySetServiceClient.createSampleQuerySet(
   *           parent, sampleQuerySet, sampleQuerySetId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}`.
   * @param sampleQuerySet Required. The
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet] to create.
   * @param sampleQuerySetId Required. The ID to use for the
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet], which will become the
   *     final component of the
   *     [SampleQuerySet.name][google.cloud.discoveryengine.v1beta.SampleQuerySet.name].
   *     <p>If the caller does not have permission to create the
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet], regardless of whether
   *     or not it exists, a `PERMISSION_DENIED` error is returned.
   *     <p>This field must be unique among all
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]s with the same
   *     [parent][google.cloud.discoveryengine.v1beta.CreateSampleQuerySetRequest.parent].
   *     Otherwise, an `ALREADY_EXISTS` error is returned.
   *     <p>This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with
   *     a length limit of 63 characters. Otherwise, an `INVALID_ARGUMENT` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuerySet createSampleQuerySet(
      String parent, SampleQuerySet sampleQuerySet, String sampleQuerySetId) {
    CreateSampleQuerySetRequest request =
        CreateSampleQuerySetRequest.newBuilder()
            .setParent(parent)
            .setSampleQuerySet(sampleQuerySet)
            .setSampleQuerySetId(sampleQuerySetId)
            .build();
    return createSampleQuerySet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   CreateSampleQuerySetRequest request =
   *       CreateSampleQuerySetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSampleQuerySet(SampleQuerySet.newBuilder().build())
   *           .setSampleQuerySetId("sampleQuerySetId1320431231")
   *           .build();
   *   SampleQuerySet response = sampleQuerySetServiceClient.createSampleQuerySet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuerySet createSampleQuerySet(CreateSampleQuerySetRequest request) {
    return createSampleQuerySetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   CreateSampleQuerySetRequest request =
   *       CreateSampleQuerySetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSampleQuerySet(SampleQuerySet.newBuilder().build())
   *           .setSampleQuerySetId("sampleQuerySetId1320431231")
   *           .build();
   *   ApiFuture<SampleQuerySet> future =
   *       sampleQuerySetServiceClient.createSampleQuerySetCallable().futureCall(request);
   *   // Do something.
   *   SampleQuerySet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSampleQuerySetRequest, SampleQuerySet>
      createSampleQuerySetCallable() {
    return stub.createSampleQuerySetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   SampleQuerySet sampleQuerySet = SampleQuerySet.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SampleQuerySet response =
   *       sampleQuerySetServiceClient.updateSampleQuerySet(sampleQuerySet, updateMask);
   * }
   * }</pre>
   *
   * @param sampleQuerySet Required. The sample query set to update.
   *     <p>If the caller does not have permission to update the
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet], regardless of whether
   *     or not it exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet] to update
   *     does not exist a `NOT_FOUND` error is returned.
   * @param updateMask Indicates which fields in the provided imported 'sample query set' to update.
   *     If not set, will by default update all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuerySet updateSampleQuerySet(
      SampleQuerySet sampleQuerySet, FieldMask updateMask) {
    UpdateSampleQuerySetRequest request =
        UpdateSampleQuerySetRequest.newBuilder()
            .setSampleQuerySet(sampleQuerySet)
            .setUpdateMask(updateMask)
            .build();
    return updateSampleQuerySet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   UpdateSampleQuerySetRequest request =
   *       UpdateSampleQuerySetRequest.newBuilder()
   *           .setSampleQuerySet(SampleQuerySet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SampleQuerySet response = sampleQuerySetServiceClient.updateSampleQuerySet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SampleQuerySet updateSampleQuerySet(UpdateSampleQuerySetRequest request) {
    return updateSampleQuerySetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   UpdateSampleQuerySetRequest request =
   *       UpdateSampleQuerySetRequest.newBuilder()
   *           .setSampleQuerySet(SampleQuerySet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SampleQuerySet> future =
   *       sampleQuerySetServiceClient.updateSampleQuerySetCallable().futureCall(request);
   *   // Do something.
   *   SampleQuerySet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSampleQuerySetRequest, SampleQuerySet>
      updateSampleQuerySetCallable() {
    return stub.updateSampleQuerySetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   SampleQuerySetName name =
   *       SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]");
   *   sampleQuerySetServiceClient.deleteSampleQuerySet(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet], such as
   *     `projects/{project}/locations/{location}/sampleQuerySets/{sample_query_set}`.
   *     <p>If the caller does not have permission to delete the
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet], regardless of whether
   *     or not it exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet] to delete
   *     does not exist, a `NOT_FOUND` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSampleQuerySet(SampleQuerySetName name) {
    DeleteSampleQuerySetRequest request =
        DeleteSampleQuerySetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSampleQuerySet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   String name =
   *       SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString();
   *   sampleQuerySetServiceClient.deleteSampleQuerySet(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet], such as
   *     `projects/{project}/locations/{location}/sampleQuerySets/{sample_query_set}`.
   *     <p>If the caller does not have permission to delete the
   *     [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet], regardless of whether
   *     or not it exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet] to delete
   *     does not exist, a `NOT_FOUND` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSampleQuerySet(String name) {
    DeleteSampleQuerySetRequest request =
        DeleteSampleQuerySetRequest.newBuilder().setName(name).build();
    deleteSampleQuerySet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   DeleteSampleQuerySetRequest request =
   *       DeleteSampleQuerySetRequest.newBuilder()
   *           .setName(
   *               SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
   *           .build();
   *   sampleQuerySetServiceClient.deleteSampleQuerySet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSampleQuerySet(DeleteSampleQuerySetRequest request) {
    deleteSampleQuerySetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [SampleQuerySet][google.cloud.discoveryengine.v1beta.SampleQuerySet].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SampleQuerySetServiceClient sampleQuerySetServiceClient =
   *     SampleQuerySetServiceClient.create()) {
   *   DeleteSampleQuerySetRequest request =
   *       DeleteSampleQuerySetRequest.newBuilder()
   *           .setName(
   *               SampleQuerySetName.of("[PROJECT]", "[LOCATION]", "[SAMPLE_QUERY_SET]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       sampleQuerySetServiceClient.deleteSampleQuerySetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSampleQuerySetRequest, Empty> deleteSampleQuerySetCallable() {
    return stub.deleteSampleQuerySetCallable();
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

  public static class ListSampleQuerySetsPagedResponse
      extends AbstractPagedListResponse<
          ListSampleQuerySetsRequest,
          ListSampleQuerySetsResponse,
          SampleQuerySet,
          ListSampleQuerySetsPage,
          ListSampleQuerySetsFixedSizeCollection> {

    public static ApiFuture<ListSampleQuerySetsPagedResponse> createAsync(
        PageContext<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse, SampleQuerySet>
            context,
        ApiFuture<ListSampleQuerySetsResponse> futureResponse) {
      ApiFuture<ListSampleQuerySetsPage> futurePage =
          ListSampleQuerySetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSampleQuerySetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSampleQuerySetsPagedResponse(ListSampleQuerySetsPage page) {
      super(page, ListSampleQuerySetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSampleQuerySetsPage
      extends AbstractPage<
          ListSampleQuerySetsRequest,
          ListSampleQuerySetsResponse,
          SampleQuerySet,
          ListSampleQuerySetsPage> {

    private ListSampleQuerySetsPage(
        PageContext<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse, SampleQuerySet>
            context,
        ListSampleQuerySetsResponse response) {
      super(context, response);
    }

    private static ListSampleQuerySetsPage createEmptyPage() {
      return new ListSampleQuerySetsPage(null, null);
    }

    @Override
    protected ListSampleQuerySetsPage createPage(
        PageContext<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse, SampleQuerySet>
            context,
        ListSampleQuerySetsResponse response) {
      return new ListSampleQuerySetsPage(context, response);
    }

    @Override
    public ApiFuture<ListSampleQuerySetsPage> createPageAsync(
        PageContext<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse, SampleQuerySet>
            context,
        ApiFuture<ListSampleQuerySetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSampleQuerySetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSampleQuerySetsRequest,
          ListSampleQuerySetsResponse,
          SampleQuerySet,
          ListSampleQuerySetsPage,
          ListSampleQuerySetsFixedSizeCollection> {

    private ListSampleQuerySetsFixedSizeCollection(
        List<ListSampleQuerySetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSampleQuerySetsFixedSizeCollection createEmptyCollection() {
      return new ListSampleQuerySetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSampleQuerySetsFixedSizeCollection createCollection(
        List<ListSampleQuerySetsPage> pages, int collectionSize) {
      return new ListSampleQuerySetsFixedSizeCollection(pages, collectionSize);
    }
  }
}
