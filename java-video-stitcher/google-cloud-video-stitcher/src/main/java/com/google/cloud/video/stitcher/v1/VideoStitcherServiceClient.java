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

package com.google.cloud.video.stitcher.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.video.stitcher.v1.stub.VideoStitcherServiceStub;
import com.google.cloud.video.stitcher.v1.stub.VideoStitcherServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Video-On-Demand content stitching API allows you to insert ads into (VoD)
 * video on demand files. You will be able to render custom scrubber bars with highlighted ads,
 * enforce ad policies, allow seamless playback and tracking on native players and monetize content
 * with any standard VMAP compliant ad server.
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
 * try (VideoStitcherServiceClient videoStitcherServiceClient =
 *     VideoStitcherServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   CdnKey cdnKey = CdnKey.newBuilder().build();
 *   String cdnKeyId = "cdnKeyId-1777782867";
 *   CdnKey response = videoStitcherServiceClient.createCdnKey(parent, cdnKey, cdnKeyId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the VideoStitcherServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of VideoStitcherServiceSettings
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
 * VideoStitcherServiceSettings videoStitcherServiceSettings =
 *     VideoStitcherServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VideoStitcherServiceClient videoStitcherServiceClient =
 *     VideoStitcherServiceClient.create(videoStitcherServiceSettings);
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
 * VideoStitcherServiceSettings videoStitcherServiceSettings =
 *     VideoStitcherServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VideoStitcherServiceClient videoStitcherServiceClient =
 *     VideoStitcherServiceClient.create(videoStitcherServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class VideoStitcherServiceClient implements BackgroundResource {
  private final VideoStitcherServiceSettings settings;
  private final VideoStitcherServiceStub stub;

  /** Constructs an instance of VideoStitcherServiceClient with default settings. */
  public static final VideoStitcherServiceClient create() throws IOException {
    return create(VideoStitcherServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VideoStitcherServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VideoStitcherServiceClient create(VideoStitcherServiceSettings settings)
      throws IOException {
    return new VideoStitcherServiceClient(settings);
  }

  /**
   * Constructs an instance of VideoStitcherServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(VideoStitcherServiceSettings).
   */
  public static final VideoStitcherServiceClient create(VideoStitcherServiceStub stub) {
    return new VideoStitcherServiceClient(stub);
  }

  /**
   * Constructs an instance of VideoStitcherServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected VideoStitcherServiceClient(VideoStitcherServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VideoStitcherServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected VideoStitcherServiceClient(VideoStitcherServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final VideoStitcherServiceSettings getSettings() {
    return settings;
  }

  public VideoStitcherServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CdnKey cdnKey = CdnKey.newBuilder().build();
   *   String cdnKeyId = "cdnKeyId-1777782867";
   *   CdnKey response = videoStitcherServiceClient.createCdnKey(parent, cdnKey, cdnKeyId);
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the CDN key should be created, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @param cdnKey Required. The CDN key resource to create.
   * @param cdnKeyId Required. The ID to use for the CDN key, which will become the final component
   *     of the CDN key's resource name.
   *     <p>This value should conform to RFC-1034, which restricts to lower-case letters, numbers,
   *     and hyphen, with the first character a letter, the last a letter or a number, and a 63
   *     character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnKey createCdnKey(LocationName parent, CdnKey cdnKey, String cdnKeyId) {
    CreateCdnKeyRequest request =
        CreateCdnKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCdnKey(cdnKey)
            .setCdnKeyId(cdnKeyId)
            .build();
    return createCdnKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CdnKey cdnKey = CdnKey.newBuilder().build();
   *   String cdnKeyId = "cdnKeyId-1777782867";
   *   CdnKey response = videoStitcherServiceClient.createCdnKey(parent, cdnKey, cdnKeyId);
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the CDN key should be created, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @param cdnKey Required. The CDN key resource to create.
   * @param cdnKeyId Required. The ID to use for the CDN key, which will become the final component
   *     of the CDN key's resource name.
   *     <p>This value should conform to RFC-1034, which restricts to lower-case letters, numbers,
   *     and hyphen, with the first character a letter, the last a letter or a number, and a 63
   *     character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnKey createCdnKey(String parent, CdnKey cdnKey, String cdnKeyId) {
    CreateCdnKeyRequest request =
        CreateCdnKeyRequest.newBuilder()
            .setParent(parent)
            .setCdnKey(cdnKey)
            .setCdnKeyId(cdnKeyId)
            .build();
    return createCdnKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateCdnKeyRequest request =
   *       CreateCdnKeyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCdnKey(CdnKey.newBuilder().build())
   *           .setCdnKeyId("cdnKeyId-1777782867")
   *           .build();
   *   CdnKey response = videoStitcherServiceClient.createCdnKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnKey createCdnKey(CreateCdnKeyRequest request) {
    return createCdnKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateCdnKeyRequest request =
   *       CreateCdnKeyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCdnKey(CdnKey.newBuilder().build())
   *           .setCdnKeyId("cdnKeyId-1777782867")
   *           .build();
   *   ApiFuture<CdnKey> future =
   *       videoStitcherServiceClient.createCdnKeyCallable().futureCall(request);
   *   // Do something.
   *   CdnKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCdnKeyRequest, CdnKey> createCdnKeyCallable() {
    return stub.createCdnKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CDN keys in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CdnKey element : videoStitcherServiceClient.listCdnKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project that contains the list of CDN keys, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCdnKeysPagedResponse listCdnKeys(LocationName parent) {
    ListCdnKeysRequest request =
        ListCdnKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCdnKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CDN keys in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CdnKey element : videoStitcherServiceClient.listCdnKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project that contains the list of CDN keys, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCdnKeysPagedResponse listCdnKeys(String parent) {
    ListCdnKeysRequest request = ListCdnKeysRequest.newBuilder().setParent(parent).build();
    return listCdnKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CDN keys in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListCdnKeysRequest request =
   *       ListCdnKeysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CdnKey element : videoStitcherServiceClient.listCdnKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCdnKeysPagedResponse listCdnKeys(ListCdnKeysRequest request) {
    return listCdnKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CDN keys in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListCdnKeysRequest request =
   *       ListCdnKeysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CdnKey> future =
   *       videoStitcherServiceClient.listCdnKeysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CdnKey element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCdnKeysRequest, ListCdnKeysPagedResponse>
      listCdnKeysPagedCallable() {
    return stub.listCdnKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CDN keys in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListCdnKeysRequest request =
   *       ListCdnKeysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCdnKeysResponse response =
   *         videoStitcherServiceClient.listCdnKeysCallable().call(request);
   *     for (CdnKey element : response.getCdnKeysList()) {
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
  public final UnaryCallable<ListCdnKeysRequest, ListCdnKeysResponse> listCdnKeysCallable() {
    return stub.listCdnKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CdnKeyName name = CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]");
   *   CdnKey response = videoStitcherServiceClient.getCdnKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CDN key to be retrieved, in the form of
   *     `projects/{project}/locations/{location}/cdnKeys/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnKey getCdnKey(CdnKeyName name) {
    GetCdnKeyRequest request =
        GetCdnKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCdnKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString();
   *   CdnKey response = videoStitcherServiceClient.getCdnKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CDN key to be retrieved, in the form of
   *     `projects/{project}/locations/{location}/cdnKeys/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnKey getCdnKey(String name) {
    GetCdnKeyRequest request = GetCdnKeyRequest.newBuilder().setName(name).build();
    return getCdnKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetCdnKeyRequest request =
   *       GetCdnKeyRequest.newBuilder()
   *           .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
   *           .build();
   *   CdnKey response = videoStitcherServiceClient.getCdnKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnKey getCdnKey(GetCdnKeyRequest request) {
    return getCdnKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetCdnKeyRequest request =
   *       GetCdnKeyRequest.newBuilder()
   *           .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
   *           .build();
   *   ApiFuture<CdnKey> future = videoStitcherServiceClient.getCdnKeyCallable().futureCall(request);
   *   // Do something.
   *   CdnKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCdnKeyRequest, CdnKey> getCdnKeyCallable() {
    return stub.getCdnKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CdnKeyName name = CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]");
   *   videoStitcherServiceClient.deleteCdnKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CDN key to be deleted, in the form of
   *     `projects/{project_number}/locations/{location}/cdnKeys/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCdnKey(CdnKeyName name) {
    DeleteCdnKeyRequest request =
        DeleteCdnKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteCdnKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString();
   *   videoStitcherServiceClient.deleteCdnKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CDN key to be deleted, in the form of
   *     `projects/{project_number}/locations/{location}/cdnKeys/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCdnKey(String name) {
    DeleteCdnKeyRequest request = DeleteCdnKeyRequest.newBuilder().setName(name).build();
    deleteCdnKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteCdnKeyRequest request =
   *       DeleteCdnKeyRequest.newBuilder()
   *           .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
   *           .build();
   *   videoStitcherServiceClient.deleteCdnKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCdnKey(DeleteCdnKeyRequest request) {
    deleteCdnKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteCdnKeyRequest request =
   *       DeleteCdnKeyRequest.newBuilder()
   *           .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       videoStitcherServiceClient.deleteCdnKeyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCdnKeyRequest, Empty> deleteCdnKeyCallable() {
    return stub.deleteCdnKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified CDN key. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CdnKey cdnKey = CdnKey.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CdnKey response = videoStitcherServiceClient.updateCdnKey(cdnKey, updateMask);
   * }
   * }</pre>
   *
   * @param cdnKey Required. The CDN key resource which replaces the resource on the server.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnKey updateCdnKey(CdnKey cdnKey, FieldMask updateMask) {
    UpdateCdnKeyRequest request =
        UpdateCdnKeyRequest.newBuilder().setCdnKey(cdnKey).setUpdateMask(updateMask).build();
    return updateCdnKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified CDN key. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateCdnKeyRequest request =
   *       UpdateCdnKeyRequest.newBuilder()
   *           .setCdnKey(CdnKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CdnKey response = videoStitcherServiceClient.updateCdnKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnKey updateCdnKey(UpdateCdnKeyRequest request) {
    return updateCdnKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified CDN key. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateCdnKeyRequest request =
   *       UpdateCdnKeyRequest.newBuilder()
   *           .setCdnKey(CdnKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CdnKey> future =
   *       videoStitcherServiceClient.updateCdnKeyCallable().futureCall(request);
   *   // Do something.
   *   CdnKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCdnKeyRequest, CdnKey> updateCdnKeyCallable() {
    return stub.updateCdnKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a client side playback VOD session and returns the full tracking and playback metadata
   * of the session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   VodSession vodSession = VodSession.newBuilder().build();
   *   VodSession response = videoStitcherServiceClient.createVodSession(parent, vodSession);
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the VOD session should be created, in
   *     the form of `projects/{project_number}/locations/{location}`.
   * @param vodSession Required. Parameters for creating a session.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodSession createVodSession(LocationName parent, VodSession vodSession) {
    CreateVodSessionRequest request =
        CreateVodSessionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setVodSession(vodSession)
            .build();
    return createVodSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a client side playback VOD session and returns the full tracking and playback metadata
   * of the session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   VodSession vodSession = VodSession.newBuilder().build();
   *   VodSession response = videoStitcherServiceClient.createVodSession(parent, vodSession);
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the VOD session should be created, in
   *     the form of `projects/{project_number}/locations/{location}`.
   * @param vodSession Required. Parameters for creating a session.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodSession createVodSession(String parent, VodSession vodSession) {
    CreateVodSessionRequest request =
        CreateVodSessionRequest.newBuilder().setParent(parent).setVodSession(vodSession).build();
    return createVodSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a client side playback VOD session and returns the full tracking and playback metadata
   * of the session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateVodSessionRequest request =
   *       CreateVodSessionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVodSession(VodSession.newBuilder().build())
   *           .build();
   *   VodSession response = videoStitcherServiceClient.createVodSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodSession createVodSession(CreateVodSessionRequest request) {
    return createVodSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a client side playback VOD session and returns the full tracking and playback metadata
   * of the session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateVodSessionRequest request =
   *       CreateVodSessionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVodSession(VodSession.newBuilder().build())
   *           .build();
   *   ApiFuture<VodSession> future =
   *       videoStitcherServiceClient.createVodSessionCallable().futureCall(request);
   *   // Do something.
   *   VodSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateVodSessionRequest, VodSession> createVodSessionCallable() {
    return stub.createVodSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the full tracking, playback metadata, and relevant ad-ops logs for the specified VOD
   * session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   VodSessionName name = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]");
   *   VodSession response = videoStitcherServiceClient.getVodSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the VOD session to be retrieved, in the form of
   *     `projects/{project_number}/locations/{location}/vodSessions/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodSession getVodSession(VodSessionName name) {
    GetVodSessionRequest request =
        GetVodSessionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getVodSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the full tracking, playback metadata, and relevant ad-ops logs for the specified VOD
   * session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString();
   *   VodSession response = videoStitcherServiceClient.getVodSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the VOD session to be retrieved, in the form of
   *     `projects/{project_number}/locations/{location}/vodSessions/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodSession getVodSession(String name) {
    GetVodSessionRequest request = GetVodSessionRequest.newBuilder().setName(name).build();
    return getVodSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the full tracking, playback metadata, and relevant ad-ops logs for the specified VOD
   * session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodSessionRequest request =
   *       GetVodSessionRequest.newBuilder()
   *           .setName(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .build();
   *   VodSession response = videoStitcherServiceClient.getVodSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodSession getVodSession(GetVodSessionRequest request) {
    return getVodSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the full tracking, playback metadata, and relevant ad-ops logs for the specified VOD
   * session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodSessionRequest request =
   *       GetVodSessionRequest.newBuilder()
   *           .setName(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .build();
   *   ApiFuture<VodSession> future =
   *       videoStitcherServiceClient.getVodSessionCallable().futureCall(request);
   *   // Do something.
   *   VodSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVodSessionRequest, VodSession> getVodSessionCallable() {
    return stub.getVodSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of detailed stitching information of the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   VodSessionName parent = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]");
   *   for (VodStitchDetail element :
   *       videoStitcherServiceClient.listVodStitchDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The VOD session where the stitch details belong to, in the form of
   *     `projects/{project}/locations/{location}/vodSessions/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodStitchDetailsPagedResponse listVodStitchDetails(VodSessionName parent) {
    ListVodStitchDetailsRequest request =
        ListVodStitchDetailsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVodStitchDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of detailed stitching information of the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString();
   *   for (VodStitchDetail element :
   *       videoStitcherServiceClient.listVodStitchDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The VOD session where the stitch details belong to, in the form of
   *     `projects/{project}/locations/{location}/vodSessions/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodStitchDetailsPagedResponse listVodStitchDetails(String parent) {
    ListVodStitchDetailsRequest request =
        ListVodStitchDetailsRequest.newBuilder().setParent(parent).build();
    return listVodStitchDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of detailed stitching information of the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodStitchDetailsRequest request =
   *       ListVodStitchDetailsRequest.newBuilder()
   *           .setParent(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (VodStitchDetail element :
   *       videoStitcherServiceClient.listVodStitchDetails(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodStitchDetailsPagedResponse listVodStitchDetails(
      ListVodStitchDetailsRequest request) {
    return listVodStitchDetailsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of detailed stitching information of the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodStitchDetailsRequest request =
   *       ListVodStitchDetailsRequest.newBuilder()
   *           .setParent(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<VodStitchDetail> future =
   *       videoStitcherServiceClient.listVodStitchDetailsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VodStitchDetail element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVodStitchDetailsRequest, ListVodStitchDetailsPagedResponse>
      listVodStitchDetailsPagedCallable() {
    return stub.listVodStitchDetailsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of detailed stitching information of the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodStitchDetailsRequest request =
   *       ListVodStitchDetailsRequest.newBuilder()
   *           .setParent(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListVodStitchDetailsResponse response =
   *         videoStitcherServiceClient.listVodStitchDetailsCallable().call(request);
   *     for (VodStitchDetail element : response.getVodStitchDetailsList()) {
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
  public final UnaryCallable<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse>
      listVodStitchDetailsCallable() {
    return stub.listVodStitchDetailsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified stitching information for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   VodStitchDetailName name =
   *       VodStitchDetailName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_STITCH_DETAIL]");
   *   VodStitchDetail response = videoStitcherServiceClient.getVodStitchDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the stitch detail in the specified VOD session, in the form
   *     of
   *     `projects/{project}/locations/{location}/vodSessions/{vod_session_id}/vodStitchDetails/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodStitchDetail getVodStitchDetail(VodStitchDetailName name) {
    GetVodStitchDetailRequest request =
        GetVodStitchDetailRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getVodStitchDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified stitching information for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name =
   *       VodStitchDetailName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_STITCH_DETAIL]")
   *           .toString();
   *   VodStitchDetail response = videoStitcherServiceClient.getVodStitchDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the stitch detail in the specified VOD session, in the form
   *     of
   *     `projects/{project}/locations/{location}/vodSessions/{vod_session_id}/vodStitchDetails/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodStitchDetail getVodStitchDetail(String name) {
    GetVodStitchDetailRequest request =
        GetVodStitchDetailRequest.newBuilder().setName(name).build();
    return getVodStitchDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified stitching information for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodStitchDetailRequest request =
   *       GetVodStitchDetailRequest.newBuilder()
   *           .setName(
   *               VodStitchDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_STITCH_DETAIL]")
   *                   .toString())
   *           .build();
   *   VodStitchDetail response = videoStitcherServiceClient.getVodStitchDetail(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodStitchDetail getVodStitchDetail(GetVodStitchDetailRequest request) {
    return getVodStitchDetailCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified stitching information for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodStitchDetailRequest request =
   *       GetVodStitchDetailRequest.newBuilder()
   *           .setName(
   *               VodStitchDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_STITCH_DETAIL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<VodStitchDetail> future =
   *       videoStitcherServiceClient.getVodStitchDetailCallable().futureCall(request);
   *   // Do something.
   *   VodStitchDetail response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVodStitchDetailRequest, VodStitchDetail>
      getVodStitchDetailCallable() {
    return stub.getVodStitchDetailCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   VodSessionName parent = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]");
   *   for (VodAdTagDetail element :
   *       videoStitcherServiceClient.listVodAdTagDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The VOD session which the ad tag details belong to, in the form of
   *     `projects/{project}/locations/{location}/vodSessions/{vod_session_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodAdTagDetailsPagedResponse listVodAdTagDetails(VodSessionName parent) {
    ListVodAdTagDetailsRequest request =
        ListVodAdTagDetailsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVodAdTagDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString();
   *   for (VodAdTagDetail element :
   *       videoStitcherServiceClient.listVodAdTagDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The VOD session which the ad tag details belong to, in the form of
   *     `projects/{project}/locations/{location}/vodSessions/{vod_session_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodAdTagDetailsPagedResponse listVodAdTagDetails(String parent) {
    ListVodAdTagDetailsRequest request =
        ListVodAdTagDetailsRequest.newBuilder().setParent(parent).build();
    return listVodAdTagDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodAdTagDetailsRequest request =
   *       ListVodAdTagDetailsRequest.newBuilder()
   *           .setParent(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (VodAdTagDetail element :
   *       videoStitcherServiceClient.listVodAdTagDetails(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodAdTagDetailsPagedResponse listVodAdTagDetails(
      ListVodAdTagDetailsRequest request) {
    return listVodAdTagDetailsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodAdTagDetailsRequest request =
   *       ListVodAdTagDetailsRequest.newBuilder()
   *           .setParent(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<VodAdTagDetail> future =
   *       videoStitcherServiceClient.listVodAdTagDetailsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VodAdTagDetail element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVodAdTagDetailsRequest, ListVodAdTagDetailsPagedResponse>
      listVodAdTagDetailsPagedCallable() {
    return stub.listVodAdTagDetailsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodAdTagDetailsRequest request =
   *       ListVodAdTagDetailsRequest.newBuilder()
   *           .setParent(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListVodAdTagDetailsResponse response =
   *         videoStitcherServiceClient.listVodAdTagDetailsCallable().call(request);
   *     for (VodAdTagDetail element : response.getVodAdTagDetailsList()) {
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
  public final UnaryCallable<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse>
      listVodAdTagDetailsCallable() {
    return stub.listVodAdTagDetailsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   VodAdTagDetailName name =
   *       VodAdTagDetailName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_AD_TAG_DETAIL]");
   *   VodAdTagDetail response = videoStitcherServiceClient.getVodAdTagDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ad tag detail for the specified VOD session, in the form
   *     of
   *     `projects/{project}/locations/{location}/vodSessions/{vod_session_id}/vodAdTagDetails/{vod_ad_tag_detail}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodAdTagDetail getVodAdTagDetail(VodAdTagDetailName name) {
    GetVodAdTagDetailRequest request =
        GetVodAdTagDetailRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getVodAdTagDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name =
   *       VodAdTagDetailName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_AD_TAG_DETAIL]")
   *           .toString();
   *   VodAdTagDetail response = videoStitcherServiceClient.getVodAdTagDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ad tag detail for the specified VOD session, in the form
   *     of
   *     `projects/{project}/locations/{location}/vodSessions/{vod_session_id}/vodAdTagDetails/{vod_ad_tag_detail}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodAdTagDetail getVodAdTagDetail(String name) {
    GetVodAdTagDetailRequest request = GetVodAdTagDetailRequest.newBuilder().setName(name).build();
    return getVodAdTagDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodAdTagDetailRequest request =
   *       GetVodAdTagDetailRequest.newBuilder()
   *           .setName(
   *               VodAdTagDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_AD_TAG_DETAIL]")
   *                   .toString())
   *           .build();
   *   VodAdTagDetail response = videoStitcherServiceClient.getVodAdTagDetail(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodAdTagDetail getVodAdTagDetail(GetVodAdTagDetailRequest request) {
    return getVodAdTagDetailCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodAdTagDetailRequest request =
   *       GetVodAdTagDetailRequest.newBuilder()
   *           .setName(
   *               VodAdTagDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_AD_TAG_DETAIL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<VodAdTagDetail> future =
   *       videoStitcherServiceClient.getVodAdTagDetailCallable().futureCall(request);
   *   // Do something.
   *   VodAdTagDetail response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVodAdTagDetailRequest, VodAdTagDetail> getVodAdTagDetailCallable() {
    return stub.getVodAdTagDetailCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LiveSessionName parent = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]");
   *   for (LiveAdTagDetail element :
   *       videoStitcherServiceClient.listLiveAdTagDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource parent in the form of
   *     `projects/{project}/locations/{location}/liveSessions/{live_session}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLiveAdTagDetailsPagedResponse listLiveAdTagDetails(LiveSessionName parent) {
    ListLiveAdTagDetailsRequest request =
        ListLiveAdTagDetailsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLiveAdTagDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString();
   *   for (LiveAdTagDetail element :
   *       videoStitcherServiceClient.listLiveAdTagDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource parent in the form of
   *     `projects/{project}/locations/{location}/liveSessions/{live_session}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLiveAdTagDetailsPagedResponse listLiveAdTagDetails(String parent) {
    ListLiveAdTagDetailsRequest request =
        ListLiveAdTagDetailsRequest.newBuilder().setParent(parent).build();
    return listLiveAdTagDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListLiveAdTagDetailsRequest request =
   *       ListLiveAdTagDetailsRequest.newBuilder()
   *           .setParent(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (LiveAdTagDetail element :
   *       videoStitcherServiceClient.listLiveAdTagDetails(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLiveAdTagDetailsPagedResponse listLiveAdTagDetails(
      ListLiveAdTagDetailsRequest request) {
    return listLiveAdTagDetailsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListLiveAdTagDetailsRequest request =
   *       ListLiveAdTagDetailsRequest.newBuilder()
   *           .setParent(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<LiveAdTagDetail> future =
   *       videoStitcherServiceClient.listLiveAdTagDetailsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LiveAdTagDetail element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsPagedResponse>
      listLiveAdTagDetailsPagedCallable() {
    return stub.listLiveAdTagDetailsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListLiveAdTagDetailsRequest request =
   *       ListLiveAdTagDetailsRequest.newBuilder()
   *           .setParent(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLiveAdTagDetailsResponse response =
   *         videoStitcherServiceClient.listLiveAdTagDetailsCallable().call(request);
   *     for (LiveAdTagDetail element : response.getLiveAdTagDetailsList()) {
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
  public final UnaryCallable<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse>
      listLiveAdTagDetailsCallable() {
    return stub.listLiveAdTagDetailsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LiveAdTagDetailName name =
   *       LiveAdTagDetailName.of(
   *           "[PROJECT]", "[LOCATION]", "[LIVE_SESSION]", "[LIVE_AD_TAG_DETAIL]");
   *   LiveAdTagDetail response = videoStitcherServiceClient.getLiveAdTagDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name in the form of
   *     `projects/{project}/locations/{location}/liveSessions/{live_session}/liveAdTagDetails/{live_ad_tag_detail}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveAdTagDetail getLiveAdTagDetail(LiveAdTagDetailName name) {
    GetLiveAdTagDetailRequest request =
        GetLiveAdTagDetailRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getLiveAdTagDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name =
   *       LiveAdTagDetailName.of(
   *               "[PROJECT]", "[LOCATION]", "[LIVE_SESSION]", "[LIVE_AD_TAG_DETAIL]")
   *           .toString();
   *   LiveAdTagDetail response = videoStitcherServiceClient.getLiveAdTagDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name in the form of
   *     `projects/{project}/locations/{location}/liveSessions/{live_session}/liveAdTagDetails/{live_ad_tag_detail}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveAdTagDetail getLiveAdTagDetail(String name) {
    GetLiveAdTagDetailRequest request =
        GetLiveAdTagDetailRequest.newBuilder().setName(name).build();
    return getLiveAdTagDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetLiveAdTagDetailRequest request =
   *       GetLiveAdTagDetailRequest.newBuilder()
   *           .setName(
   *               LiveAdTagDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[LIVE_SESSION]", "[LIVE_AD_TAG_DETAIL]")
   *                   .toString())
   *           .build();
   *   LiveAdTagDetail response = videoStitcherServiceClient.getLiveAdTagDetail(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveAdTagDetail getLiveAdTagDetail(GetLiveAdTagDetailRequest request) {
    return getLiveAdTagDetailCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetLiveAdTagDetailRequest request =
   *       GetLiveAdTagDetailRequest.newBuilder()
   *           .setName(
   *               LiveAdTagDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[LIVE_SESSION]", "[LIVE_AD_TAG_DETAIL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<LiveAdTagDetail> future =
   *       videoStitcherServiceClient.getLiveAdTagDetailCallable().futureCall(request);
   *   // Do something.
   *   LiveAdTagDetail response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLiveAdTagDetailRequest, LiveAdTagDetail>
      getLiveAdTagDetailCallable() {
    return stub.getLiveAdTagDetailCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Slate slate = Slate.newBuilder().build();
   *   String slateId = "slateId-2126174060";
   *   Slate response = videoStitcherServiceClient.createSlate(parent, slate, slateId);
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the slate should be created, in the form of
   *     `projects/{project_number}`.
   * @param slate Required. The slate to create.
   * @param slateId Required. The unique identifier for the slate. This value should conform to
   *     RFC-1034, which restricts to lower-case letters, numbers, and hyphen, with the first
   *     character a letter, the last a letter or a number, and a 63 character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate createSlate(LocationName parent, Slate slate, String slateId) {
    CreateSlateRequest request =
        CreateSlateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSlate(slate)
            .setSlateId(slateId)
            .build();
    return createSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Slate slate = Slate.newBuilder().build();
   *   String slateId = "slateId-2126174060";
   *   Slate response = videoStitcherServiceClient.createSlate(parent, slate, slateId);
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the slate should be created, in the form of
   *     `projects/{project_number}`.
   * @param slate Required. The slate to create.
   * @param slateId Required. The unique identifier for the slate. This value should conform to
   *     RFC-1034, which restricts to lower-case letters, numbers, and hyphen, with the first
   *     character a letter, the last a letter or a number, and a 63 character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate createSlate(String parent, Slate slate, String slateId) {
    CreateSlateRequest request =
        CreateSlateRequest.newBuilder()
            .setParent(parent)
            .setSlate(slate)
            .setSlateId(slateId)
            .build();
    return createSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateSlateRequest request =
   *       CreateSlateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSlateId("slateId-2126174060")
   *           .setSlate(Slate.newBuilder().build())
   *           .build();
   *   Slate response = videoStitcherServiceClient.createSlate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate createSlate(CreateSlateRequest request) {
    return createSlateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateSlateRequest request =
   *       CreateSlateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSlateId("slateId-2126174060")
   *           .setSlate(Slate.newBuilder().build())
   *           .build();
   *   ApiFuture<Slate> future =
   *       videoStitcherServiceClient.createSlateCallable().futureCall(request);
   *   // Do something.
   *   Slate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSlateRequest, Slate> createSlateCallable() {
    return stub.createSlateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all slates in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Slate element : videoStitcherServiceClient.listSlates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list slates, in the form of `projects/{project_number}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSlatesPagedResponse listSlates(LocationName parent) {
    ListSlatesRequest request =
        ListSlatesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all slates in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Slate element : videoStitcherServiceClient.listSlates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list slates, in the form of `projects/{project_number}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSlatesPagedResponse listSlates(String parent) {
    ListSlatesRequest request = ListSlatesRequest.newBuilder().setParent(parent).build();
    return listSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all slates in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListSlatesRequest request =
   *       ListSlatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Slate element : videoStitcherServiceClient.listSlates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSlatesPagedResponse listSlates(ListSlatesRequest request) {
    return listSlatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all slates in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListSlatesRequest request =
   *       ListSlatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Slate> future =
   *       videoStitcherServiceClient.listSlatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Slate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSlatesRequest, ListSlatesPagedResponse> listSlatesPagedCallable() {
    return stub.listSlatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all slates in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListSlatesRequest request =
   *       ListSlatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSlatesResponse response = videoStitcherServiceClient.listSlatesCallable().call(request);
   *     for (Slate element : response.getSlatesList()) {
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
  public final UnaryCallable<ListSlatesRequest, ListSlatesResponse> listSlatesCallable() {
    return stub.listSlatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   SlateName name = SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]");
   *   Slate response = videoStitcherServiceClient.getSlate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the slate to be retrieved, of the slate, in the form of
   *     `projects/{project_number}/locations/{location}/slates/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate getSlate(SlateName name) {
    GetSlateRequest request =
        GetSlateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString();
   *   Slate response = videoStitcherServiceClient.getSlate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the slate to be retrieved, of the slate, in the form of
   *     `projects/{project_number}/locations/{location}/slates/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate getSlate(String name) {
    GetSlateRequest request = GetSlateRequest.newBuilder().setName(name).build();
    return getSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetSlateRequest request =
   *       GetSlateRequest.newBuilder()
   *           .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
   *           .build();
   *   Slate response = videoStitcherServiceClient.getSlate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate getSlate(GetSlateRequest request) {
    return getSlateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetSlateRequest request =
   *       GetSlateRequest.newBuilder()
   *           .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
   *           .build();
   *   ApiFuture<Slate> future = videoStitcherServiceClient.getSlateCallable().futureCall(request);
   *   // Do something.
   *   Slate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSlateRequest, Slate> getSlateCallable() {
    return stub.getSlateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   Slate slate = Slate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Slate response = videoStitcherServiceClient.updateSlate(slate, updateMask);
   * }
   * }</pre>
   *
   * @param slate Required. The resource with updated fields.
   * @param updateMask Required. The update mask which specifies fields which should be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate updateSlate(Slate slate, FieldMask updateMask) {
    UpdateSlateRequest request =
        UpdateSlateRequest.newBuilder().setSlate(slate).setUpdateMask(updateMask).build();
    return updateSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateSlateRequest request =
   *       UpdateSlateRequest.newBuilder()
   *           .setSlate(Slate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Slate response = videoStitcherServiceClient.updateSlate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate updateSlate(UpdateSlateRequest request) {
    return updateSlateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateSlateRequest request =
   *       UpdateSlateRequest.newBuilder()
   *           .setSlate(Slate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Slate> future =
   *       videoStitcherServiceClient.updateSlateCallable().futureCall(request);
   *   // Do something.
   *   Slate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSlateRequest, Slate> updateSlateCallable() {
    return stub.updateSlateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   SlateName name = SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]");
   *   videoStitcherServiceClient.deleteSlate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the slate to be deleted, in the form of
   *     `projects/{project_number}/locations/{location}/slates/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSlate(SlateName name) {
    DeleteSlateRequest request =
        DeleteSlateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString();
   *   videoStitcherServiceClient.deleteSlate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the slate to be deleted, in the form of
   *     `projects/{project_number}/locations/{location}/slates/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSlate(String name) {
    DeleteSlateRequest request = DeleteSlateRequest.newBuilder().setName(name).build();
    deleteSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteSlateRequest request =
   *       DeleteSlateRequest.newBuilder()
   *           .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
   *           .build();
   *   videoStitcherServiceClient.deleteSlate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSlate(DeleteSlateRequest request) {
    deleteSlateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteSlateRequest request =
   *       DeleteSlateRequest.newBuilder()
   *           .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       videoStitcherServiceClient.deleteSlateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSlateRequest, Empty> deleteSlateCallable() {
    return stub.deleteSlateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LiveSessionName parent = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]");
   *   LiveSession liveSession = LiveSession.newBuilder().build();
   *   LiveSession response = videoStitcherServiceClient.createLiveSession(parent, liveSession);
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the live session should be created,
   *     in the form of `projects/{project_number}/locations/{location}`.
   * @param liveSession Required. Parameters for creating a live session.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveSession createLiveSession(LiveSessionName parent, LiveSession liveSession) {
    CreateLiveSessionRequest request =
        CreateLiveSessionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLiveSession(liveSession)
            .build();
    return createLiveSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString();
   *   LiveSession liveSession = LiveSession.newBuilder().build();
   *   LiveSession response = videoStitcherServiceClient.createLiveSession(parent, liveSession);
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the live session should be created,
   *     in the form of `projects/{project_number}/locations/{location}`.
   * @param liveSession Required. Parameters for creating a live session.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveSession createLiveSession(String parent, LiveSession liveSession) {
    CreateLiveSessionRequest request =
        CreateLiveSessionRequest.newBuilder().setParent(parent).setLiveSession(liveSession).build();
    return createLiveSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateLiveSessionRequest request =
   *       CreateLiveSessionRequest.newBuilder()
   *           .setParent(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
   *           .setLiveSession(LiveSession.newBuilder().build())
   *           .build();
   *   LiveSession response = videoStitcherServiceClient.createLiveSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveSession createLiveSession(CreateLiveSessionRequest request) {
    return createLiveSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateLiveSessionRequest request =
   *       CreateLiveSessionRequest.newBuilder()
   *           .setParent(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
   *           .setLiveSession(LiveSession.newBuilder().build())
   *           .build();
   *   ApiFuture<LiveSession> future =
   *       videoStitcherServiceClient.createLiveSessionCallable().futureCall(request);
   *   // Do something.
   *   LiveSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLiveSessionRequest, LiveSession> createLiveSessionCallable() {
    return stub.createLiveSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LiveSessionName name = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]");
   *   LiveSession response = videoStitcherServiceClient.getLiveSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the live session, in the form of
   *     `projects/{project_number}/locations/{location}/liveSessions/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveSession getLiveSession(LiveSessionName name) {
    GetLiveSessionRequest request =
        GetLiveSessionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLiveSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString();
   *   LiveSession response = videoStitcherServiceClient.getLiveSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the live session, in the form of
   *     `projects/{project_number}/locations/{location}/liveSessions/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveSession getLiveSession(String name) {
    GetLiveSessionRequest request = GetLiveSessionRequest.newBuilder().setName(name).build();
    return getLiveSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetLiveSessionRequest request =
   *       GetLiveSessionRequest.newBuilder()
   *           .setName(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
   *           .build();
   *   LiveSession response = videoStitcherServiceClient.getLiveSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveSession getLiveSession(GetLiveSessionRequest request) {
    return getLiveSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetLiveSessionRequest request =
   *       GetLiveSessionRequest.newBuilder()
   *           .setName(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
   *           .build();
   *   ApiFuture<LiveSession> future =
   *       videoStitcherServiceClient.getLiveSessionCallable().futureCall(request);
   *   // Do something.
   *   LiveSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLiveSessionRequest, LiveSession> getLiveSessionCallable() {
    return stub.getLiveSessionCallable();
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

  public static class ListCdnKeysPagedResponse
      extends AbstractPagedListResponse<
          ListCdnKeysRequest,
          ListCdnKeysResponse,
          CdnKey,
          ListCdnKeysPage,
          ListCdnKeysFixedSizeCollection> {

    public static ApiFuture<ListCdnKeysPagedResponse> createAsync(
        PageContext<ListCdnKeysRequest, ListCdnKeysResponse, CdnKey> context,
        ApiFuture<ListCdnKeysResponse> futureResponse) {
      ApiFuture<ListCdnKeysPage> futurePage =
          ListCdnKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListCdnKeysPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListCdnKeysPagedResponse(ListCdnKeysPage page) {
      super(page, ListCdnKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCdnKeysPage
      extends AbstractPage<ListCdnKeysRequest, ListCdnKeysResponse, CdnKey, ListCdnKeysPage> {

    private ListCdnKeysPage(
        PageContext<ListCdnKeysRequest, ListCdnKeysResponse, CdnKey> context,
        ListCdnKeysResponse response) {
      super(context, response);
    }

    private static ListCdnKeysPage createEmptyPage() {
      return new ListCdnKeysPage(null, null);
    }

    @Override
    protected ListCdnKeysPage createPage(
        PageContext<ListCdnKeysRequest, ListCdnKeysResponse, CdnKey> context,
        ListCdnKeysResponse response) {
      return new ListCdnKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListCdnKeysPage> createPageAsync(
        PageContext<ListCdnKeysRequest, ListCdnKeysResponse, CdnKey> context,
        ApiFuture<ListCdnKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCdnKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCdnKeysRequest,
          ListCdnKeysResponse,
          CdnKey,
          ListCdnKeysPage,
          ListCdnKeysFixedSizeCollection> {

    private ListCdnKeysFixedSizeCollection(List<ListCdnKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCdnKeysFixedSizeCollection createEmptyCollection() {
      return new ListCdnKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCdnKeysFixedSizeCollection createCollection(
        List<ListCdnKeysPage> pages, int collectionSize) {
      return new ListCdnKeysFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVodStitchDetailsPagedResponse
      extends AbstractPagedListResponse<
          ListVodStitchDetailsRequest,
          ListVodStitchDetailsResponse,
          VodStitchDetail,
          ListVodStitchDetailsPage,
          ListVodStitchDetailsFixedSizeCollection> {

    public static ApiFuture<ListVodStitchDetailsPagedResponse> createAsync(
        PageContext<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse, VodStitchDetail>
            context,
        ApiFuture<ListVodStitchDetailsResponse> futureResponse) {
      ApiFuture<ListVodStitchDetailsPage> futurePage =
          ListVodStitchDetailsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVodStitchDetailsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVodStitchDetailsPagedResponse(ListVodStitchDetailsPage page) {
      super(page, ListVodStitchDetailsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVodStitchDetailsPage
      extends AbstractPage<
          ListVodStitchDetailsRequest,
          ListVodStitchDetailsResponse,
          VodStitchDetail,
          ListVodStitchDetailsPage> {

    private ListVodStitchDetailsPage(
        PageContext<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse, VodStitchDetail>
            context,
        ListVodStitchDetailsResponse response) {
      super(context, response);
    }

    private static ListVodStitchDetailsPage createEmptyPage() {
      return new ListVodStitchDetailsPage(null, null);
    }

    @Override
    protected ListVodStitchDetailsPage createPage(
        PageContext<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse, VodStitchDetail>
            context,
        ListVodStitchDetailsResponse response) {
      return new ListVodStitchDetailsPage(context, response);
    }

    @Override
    public ApiFuture<ListVodStitchDetailsPage> createPageAsync(
        PageContext<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse, VodStitchDetail>
            context,
        ApiFuture<ListVodStitchDetailsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVodStitchDetailsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVodStitchDetailsRequest,
          ListVodStitchDetailsResponse,
          VodStitchDetail,
          ListVodStitchDetailsPage,
          ListVodStitchDetailsFixedSizeCollection> {

    private ListVodStitchDetailsFixedSizeCollection(
        List<ListVodStitchDetailsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVodStitchDetailsFixedSizeCollection createEmptyCollection() {
      return new ListVodStitchDetailsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVodStitchDetailsFixedSizeCollection createCollection(
        List<ListVodStitchDetailsPage> pages, int collectionSize) {
      return new ListVodStitchDetailsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVodAdTagDetailsPagedResponse
      extends AbstractPagedListResponse<
          ListVodAdTagDetailsRequest,
          ListVodAdTagDetailsResponse,
          VodAdTagDetail,
          ListVodAdTagDetailsPage,
          ListVodAdTagDetailsFixedSizeCollection> {

    public static ApiFuture<ListVodAdTagDetailsPagedResponse> createAsync(
        PageContext<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, VodAdTagDetail>
            context,
        ApiFuture<ListVodAdTagDetailsResponse> futureResponse) {
      ApiFuture<ListVodAdTagDetailsPage> futurePage =
          ListVodAdTagDetailsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVodAdTagDetailsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVodAdTagDetailsPagedResponse(ListVodAdTagDetailsPage page) {
      super(page, ListVodAdTagDetailsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVodAdTagDetailsPage
      extends AbstractPage<
          ListVodAdTagDetailsRequest,
          ListVodAdTagDetailsResponse,
          VodAdTagDetail,
          ListVodAdTagDetailsPage> {

    private ListVodAdTagDetailsPage(
        PageContext<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, VodAdTagDetail>
            context,
        ListVodAdTagDetailsResponse response) {
      super(context, response);
    }

    private static ListVodAdTagDetailsPage createEmptyPage() {
      return new ListVodAdTagDetailsPage(null, null);
    }

    @Override
    protected ListVodAdTagDetailsPage createPage(
        PageContext<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, VodAdTagDetail>
            context,
        ListVodAdTagDetailsResponse response) {
      return new ListVodAdTagDetailsPage(context, response);
    }

    @Override
    public ApiFuture<ListVodAdTagDetailsPage> createPageAsync(
        PageContext<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, VodAdTagDetail>
            context,
        ApiFuture<ListVodAdTagDetailsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVodAdTagDetailsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVodAdTagDetailsRequest,
          ListVodAdTagDetailsResponse,
          VodAdTagDetail,
          ListVodAdTagDetailsPage,
          ListVodAdTagDetailsFixedSizeCollection> {

    private ListVodAdTagDetailsFixedSizeCollection(
        List<ListVodAdTagDetailsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVodAdTagDetailsFixedSizeCollection createEmptyCollection() {
      return new ListVodAdTagDetailsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVodAdTagDetailsFixedSizeCollection createCollection(
        List<ListVodAdTagDetailsPage> pages, int collectionSize) {
      return new ListVodAdTagDetailsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLiveAdTagDetailsPagedResponse
      extends AbstractPagedListResponse<
          ListLiveAdTagDetailsRequest,
          ListLiveAdTagDetailsResponse,
          LiveAdTagDetail,
          ListLiveAdTagDetailsPage,
          ListLiveAdTagDetailsFixedSizeCollection> {

    public static ApiFuture<ListLiveAdTagDetailsPagedResponse> createAsync(
        PageContext<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse, LiveAdTagDetail>
            context,
        ApiFuture<ListLiveAdTagDetailsResponse> futureResponse) {
      ApiFuture<ListLiveAdTagDetailsPage> futurePage =
          ListLiveAdTagDetailsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLiveAdTagDetailsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLiveAdTagDetailsPagedResponse(ListLiveAdTagDetailsPage page) {
      super(page, ListLiveAdTagDetailsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLiveAdTagDetailsPage
      extends AbstractPage<
          ListLiveAdTagDetailsRequest,
          ListLiveAdTagDetailsResponse,
          LiveAdTagDetail,
          ListLiveAdTagDetailsPage> {

    private ListLiveAdTagDetailsPage(
        PageContext<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse, LiveAdTagDetail>
            context,
        ListLiveAdTagDetailsResponse response) {
      super(context, response);
    }

    private static ListLiveAdTagDetailsPage createEmptyPage() {
      return new ListLiveAdTagDetailsPage(null, null);
    }

    @Override
    protected ListLiveAdTagDetailsPage createPage(
        PageContext<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse, LiveAdTagDetail>
            context,
        ListLiveAdTagDetailsResponse response) {
      return new ListLiveAdTagDetailsPage(context, response);
    }

    @Override
    public ApiFuture<ListLiveAdTagDetailsPage> createPageAsync(
        PageContext<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse, LiveAdTagDetail>
            context,
        ApiFuture<ListLiveAdTagDetailsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLiveAdTagDetailsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLiveAdTagDetailsRequest,
          ListLiveAdTagDetailsResponse,
          LiveAdTagDetail,
          ListLiveAdTagDetailsPage,
          ListLiveAdTagDetailsFixedSizeCollection> {

    private ListLiveAdTagDetailsFixedSizeCollection(
        List<ListLiveAdTagDetailsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLiveAdTagDetailsFixedSizeCollection createEmptyCollection() {
      return new ListLiveAdTagDetailsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLiveAdTagDetailsFixedSizeCollection createCollection(
        List<ListLiveAdTagDetailsPage> pages, int collectionSize) {
      return new ListLiveAdTagDetailsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSlatesPagedResponse
      extends AbstractPagedListResponse<
          ListSlatesRequest,
          ListSlatesResponse,
          Slate,
          ListSlatesPage,
          ListSlatesFixedSizeCollection> {

    public static ApiFuture<ListSlatesPagedResponse> createAsync(
        PageContext<ListSlatesRequest, ListSlatesResponse, Slate> context,
        ApiFuture<ListSlatesResponse> futureResponse) {
      ApiFuture<ListSlatesPage> futurePage =
          ListSlatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSlatesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSlatesPagedResponse(ListSlatesPage page) {
      super(page, ListSlatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSlatesPage
      extends AbstractPage<ListSlatesRequest, ListSlatesResponse, Slate, ListSlatesPage> {

    private ListSlatesPage(
        PageContext<ListSlatesRequest, ListSlatesResponse, Slate> context,
        ListSlatesResponse response) {
      super(context, response);
    }

    private static ListSlatesPage createEmptyPage() {
      return new ListSlatesPage(null, null);
    }

    @Override
    protected ListSlatesPage createPage(
        PageContext<ListSlatesRequest, ListSlatesResponse, Slate> context,
        ListSlatesResponse response) {
      return new ListSlatesPage(context, response);
    }

    @Override
    public ApiFuture<ListSlatesPage> createPageAsync(
        PageContext<ListSlatesRequest, ListSlatesResponse, Slate> context,
        ApiFuture<ListSlatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSlatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSlatesRequest,
          ListSlatesResponse,
          Slate,
          ListSlatesPage,
          ListSlatesFixedSizeCollection> {

    private ListSlatesFixedSizeCollection(List<ListSlatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSlatesFixedSizeCollection createEmptyCollection() {
      return new ListSlatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSlatesFixedSizeCollection createCollection(
        List<ListSlatesPage> pages, int collectionSize) {
      return new ListSlatesFixedSizeCollection(pages, collectionSize);
    }
  }
}
