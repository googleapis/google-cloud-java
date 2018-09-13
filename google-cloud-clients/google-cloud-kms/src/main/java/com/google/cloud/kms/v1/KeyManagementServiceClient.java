/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.kms.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.v1.stub.KeyManagementServiceStub;
import com.google.cloud.kms.v1.stub.KeyManagementServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Google Cloud Key Management Service
 *
 * <p>Manages cryptographic keys and operations using those keys. Implements a REST model with the
 * following objects:
 *
 * <p>&#42; [KeyRing][google.cloud.kms.v1.KeyRing] &#42; [CryptoKey][google.cloud.kms.v1.CryptoKey]
 * &#42; [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
 *
 * <p>If you are using manual gRPC libraries, see [Using gRPC with Cloud
 * KMS](https://cloud.google.com/kms/docs/grpc).
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
 *   KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
 *   KeyRing response = keyManagementServiceClient.getKeyRing(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the keyManagementServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of KeyManagementServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * KeyManagementServiceSettings keyManagementServiceSettings =
 *     KeyManagementServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * KeyManagementServiceClient keyManagementServiceClient =
 *     KeyManagementServiceClient.create(keyManagementServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * KeyManagementServiceSettings keyManagementServiceSettings =
 *     KeyManagementServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * KeyManagementServiceClient keyManagementServiceClient =
 *     KeyManagementServiceClient.create(keyManagementServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class KeyManagementServiceClient implements BackgroundResource {
  private final KeyManagementServiceSettings settings;
  private final KeyManagementServiceStub stub;

  /** Constructs an instance of KeyManagementServiceClient with default settings. */
  public static final KeyManagementServiceClient create() throws IOException {
    return create(KeyManagementServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of KeyManagementServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final KeyManagementServiceClient create(KeyManagementServiceSettings settings)
      throws IOException {
    return new KeyManagementServiceClient(settings);
  }

  /**
   * Constructs an instance of KeyManagementServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use KeyManagementServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final KeyManagementServiceClient create(KeyManagementServiceStub stub) {
    return new KeyManagementServiceClient(stub);
  }

  /**
   * Constructs an instance of KeyManagementServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected KeyManagementServiceClient(KeyManagementServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((KeyManagementServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected KeyManagementServiceClient(KeyManagementServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final KeyManagementServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public KeyManagementServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (KeyRing element : keyManagementServiceClient.listKeyRings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [KeyRings][google.cloud.kms.v1.KeyRing], in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKeyRingsPagedResponse listKeyRings(LocationName parent) {
    ListKeyRingsRequest request =
        ListKeyRingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listKeyRings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (KeyRing element : keyManagementServiceClient.listKeyRings(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [KeyRings][google.cloud.kms.v1.KeyRing], in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKeyRingsPagedResponse listKeyRings(String parent) {
    ListKeyRingsRequest request = ListKeyRingsRequest.newBuilder().setParent(parent).build();
    return listKeyRings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListKeyRingsRequest request = ListKeyRingsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (KeyRing element : keyManagementServiceClient.listKeyRings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKeyRingsPagedResponse listKeyRings(ListKeyRingsRequest request) {
    return listKeyRingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListKeyRingsRequest request = ListKeyRingsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListKeyRingsPagedResponse&gt; future = keyManagementServiceClient.listKeyRingsPagedCallable().futureCall(request);
   *   // Do something
   *   for (KeyRing element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListKeyRingsRequest, ListKeyRingsPagedResponse>
      listKeyRingsPagedCallable() {
    return stub.listKeyRingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListKeyRingsRequest request = ListKeyRingsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListKeyRingsResponse response = keyManagementServiceClient.listKeyRingsCallable().call(request);
   *     for (KeyRing element : response.getKeyRingsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListKeyRingsRequest, ListKeyRingsResponse> listKeyRingsCallable() {
    return stub.listKeyRingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   for (CryptoKey element : keyManagementServiceClient.listCryptoKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the [KeyRing][google.cloud.kms.v1.KeyRing] to
   *     list, in the format `projects/&#42;/locations/&#42;/keyRings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeysPagedResponse listCryptoKeys(KeyRingName parent) {
    ListCryptoKeysRequest request =
        ListCryptoKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCryptoKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   for (CryptoKey element : keyManagementServiceClient.listCryptoKeys(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the [KeyRing][google.cloud.kms.v1.KeyRing] to
   *     list, in the format `projects/&#42;/locations/&#42;/keyRings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeysPagedResponse listCryptoKeys(String parent) {
    ListCryptoKeysRequest request = ListCryptoKeysRequest.newBuilder().setParent(parent).build();
    return listCryptoKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   ListCryptoKeysRequest request = ListCryptoKeysRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (CryptoKey element : keyManagementServiceClient.listCryptoKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeysPagedResponse listCryptoKeys(ListCryptoKeysRequest request) {
    return listCryptoKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   ListCryptoKeysRequest request = ListCryptoKeysRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListCryptoKeysPagedResponse&gt; future = keyManagementServiceClient.listCryptoKeysPagedCallable().futureCall(request);
   *   // Do something
   *   for (CryptoKey element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysPagedResponse>
      listCryptoKeysPagedCallable() {
    return stub.listCryptoKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   ListCryptoKeysRequest request = ListCryptoKeysRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListCryptoKeysResponse response = keyManagementServiceClient.listCryptoKeysCallable().call(request);
   *     for (CryptoKey element : response.getCryptoKeysList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysResponse>
      listCryptoKeysCallable() {
    return stub.listCryptoKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName parent = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   for (CryptoKeyVersion element : keyManagementServiceClient.listCryptoKeyVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] to
   *     list, in the format `projects/&#42;/locations/&#42;/keyRings/&#42;/cryptoKeys/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeyVersionsPagedResponse listCryptoKeyVersions(CryptoKeyName parent) {
    ListCryptoKeyVersionsRequest request =
        ListCryptoKeyVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCryptoKeyVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName parent = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   for (CryptoKeyVersion element : keyManagementServiceClient.listCryptoKeyVersions(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] to
   *     list, in the format `projects/&#42;/locations/&#42;/keyRings/&#42;/cryptoKeys/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeyVersionsPagedResponse listCryptoKeyVersions(String parent) {
    ListCryptoKeyVersionsRequest request =
        ListCryptoKeyVersionsRequest.newBuilder().setParent(parent).build();
    return listCryptoKeyVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName parent = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   ListCryptoKeyVersionsRequest request = ListCryptoKeyVersionsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (CryptoKeyVersion element : keyManagementServiceClient.listCryptoKeyVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeyVersionsPagedResponse listCryptoKeyVersions(
      ListCryptoKeyVersionsRequest request) {
    return listCryptoKeyVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName parent = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   ListCryptoKeyVersionsRequest request = ListCryptoKeyVersionsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListCryptoKeyVersionsPagedResponse&gt; future = keyManagementServiceClient.listCryptoKeyVersionsPagedCallable().futureCall(request);
   *   // Do something
   *   for (CryptoKeyVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsPagedResponse>
      listCryptoKeyVersionsPagedCallable() {
    return stub.listCryptoKeyVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName parent = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   ListCryptoKeyVersionsRequest request = ListCryptoKeyVersionsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListCryptoKeyVersionsResponse response = keyManagementServiceClient.listCryptoKeyVersionsCallable().call(request);
   *     for (CryptoKeyVersion element : response.getCryptoKeyVersionsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse>
      listCryptoKeyVersionsCallable() {
    return stub.listCryptoKeyVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   KeyRing response = keyManagementServiceClient.getKeyRing(name);
   * }
   * </code></pre>
   *
   * @param name The [name][google.cloud.kms.v1.KeyRing.name] of the
   *     [KeyRing][google.cloud.kms.v1.KeyRing] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KeyRing getKeyRing(KeyRingName name) {

    GetKeyRingRequest request =
        GetKeyRingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getKeyRing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   KeyRing response = keyManagementServiceClient.getKeyRing(name.toString());
   * }
   * </code></pre>
   *
   * @param name The [name][google.cloud.kms.v1.KeyRing.name] of the
   *     [KeyRing][google.cloud.kms.v1.KeyRing] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KeyRing getKeyRing(String name) {

    GetKeyRingRequest request = GetKeyRingRequest.newBuilder().setName(name).build();
    return getKeyRing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   GetKeyRingRequest request = GetKeyRingRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   KeyRing response = keyManagementServiceClient.getKeyRing(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final KeyRing getKeyRing(GetKeyRingRequest request) {
    return getKeyRingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   GetKeyRingRequest request = GetKeyRingRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;KeyRing&gt; future = keyManagementServiceClient.getKeyRingCallable().futureCall(request);
   *   // Do something
   *   KeyRing response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetKeyRingRequest, KeyRing> getKeyRingCallable() {
    return stub.getKeyRingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as well as its
   * [primary][google.cloud.kms.v1.CryptoKey.primary]
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   CryptoKey response = keyManagementServiceClient.getCryptoKey(name);
   * }
   * </code></pre>
   *
   * @param name The [name][google.cloud.kms.v1.CryptoKey.name] of the
   *     [CryptoKey][google.cloud.kms.v1.CryptoKey] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey getCryptoKey(CryptoKeyName name) {

    GetCryptoKeyRequest request =
        GetCryptoKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCryptoKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as well as its
   * [primary][google.cloud.kms.v1.CryptoKey.primary]
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   CryptoKey response = keyManagementServiceClient.getCryptoKey(name.toString());
   * }
   * </code></pre>
   *
   * @param name The [name][google.cloud.kms.v1.CryptoKey.name] of the
   *     [CryptoKey][google.cloud.kms.v1.CryptoKey] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey getCryptoKey(String name) {

    GetCryptoKeyRequest request = GetCryptoKeyRequest.newBuilder().setName(name).build();
    return getCryptoKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as well as its
   * [primary][google.cloud.kms.v1.CryptoKey.primary]
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   GetCryptoKeyRequest request = GetCryptoKeyRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   CryptoKey response = keyManagementServiceClient.getCryptoKey(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final CryptoKey getCryptoKey(GetCryptoKeyRequest request) {
    return getCryptoKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as well as its
   * [primary][google.cloud.kms.v1.CryptoKey.primary]
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   GetCryptoKeyRequest request = GetCryptoKeyRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;CryptoKey&gt; future = keyManagementServiceClient.getCryptoKeyCallable().futureCall(request);
   *   // Do something
   *   CryptoKey response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetCryptoKeyRequest, CryptoKey> getCryptoKeyCallable() {
    return stub.getCryptoKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns metadata for a given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   CryptoKeyVersion response = keyManagementServiceClient.getCryptoKeyVersion(name);
   * }
   * </code></pre>
   *
   * @param name The [name][google.cloud.kms.v1.CryptoKeyVersion.name] of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion getCryptoKeyVersion(CryptoKeyVersionName name) {

    GetCryptoKeyVersionRequest request =
        GetCryptoKeyVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns metadata for a given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   CryptoKeyVersion response = keyManagementServiceClient.getCryptoKeyVersion(name.toString());
   * }
   * </code></pre>
   *
   * @param name The [name][google.cloud.kms.v1.CryptoKeyVersion.name] of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion getCryptoKeyVersion(String name) {

    GetCryptoKeyVersionRequest request =
        GetCryptoKeyVersionRequest.newBuilder().setName(name).build();
    return getCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns metadata for a given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   GetCryptoKeyVersionRequest request = GetCryptoKeyVersionRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   CryptoKeyVersion response = keyManagementServiceClient.getCryptoKeyVersion(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final CryptoKeyVersion getCryptoKeyVersion(GetCryptoKeyVersionRequest request) {
    return getCryptoKeyVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns metadata for a given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   GetCryptoKeyVersionRequest request = GetCryptoKeyVersionRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;CryptoKeyVersion&gt; future = keyManagementServiceClient.getCryptoKeyVersionCallable().futureCall(request);
   *   // Do something
   *   CryptoKeyVersion response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetCryptoKeyVersionRequest, CryptoKeyVersion>
      getCryptoKeyVersionCallable() {
    return stub.getCryptoKeyVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String keyRingId = "";
   *   KeyRing keyRing = KeyRing.newBuilder().build();
   *   KeyRing response = keyManagementServiceClient.createKeyRing(parent, keyRingId, keyRing);
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [KeyRings][google.cloud.kms.v1.KeyRing], in the format `projects/&#42;/locations/&#42;`.
   * @param keyRingId Required. It must be unique within a location and match the regular expression
   *     `[a-zA-Z0-9_-]{1,63}`
   * @param keyRing A [KeyRing][google.cloud.kms.v1.KeyRing] with initial field values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KeyRing createKeyRing(LocationName parent, String keyRingId, KeyRing keyRing) {

    CreateKeyRingRequest request =
        CreateKeyRingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setKeyRingId(keyRingId)
            .setKeyRing(keyRing)
            .build();
    return createKeyRing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String keyRingId = "";
   *   KeyRing keyRing = KeyRing.newBuilder().build();
   *   KeyRing response = keyManagementServiceClient.createKeyRing(parent.toString(), keyRingId, keyRing);
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [KeyRings][google.cloud.kms.v1.KeyRing], in the format `projects/&#42;/locations/&#42;`.
   * @param keyRingId Required. It must be unique within a location and match the regular expression
   *     `[a-zA-Z0-9_-]{1,63}`
   * @param keyRing A [KeyRing][google.cloud.kms.v1.KeyRing] with initial field values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KeyRing createKeyRing(String parent, String keyRingId, KeyRing keyRing) {

    CreateKeyRingRequest request =
        CreateKeyRingRequest.newBuilder()
            .setParent(parent)
            .setKeyRingId(keyRingId)
            .setKeyRing(keyRing)
            .build();
    return createKeyRing(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String keyRingId = "";
   *   KeyRing keyRing = KeyRing.newBuilder().build();
   *   CreateKeyRingRequest request = CreateKeyRingRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setKeyRingId(keyRingId)
   *     .setKeyRing(keyRing)
   *     .build();
   *   KeyRing response = keyManagementServiceClient.createKeyRing(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KeyRing createKeyRing(CreateKeyRingRequest request) {
    return createKeyRingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String keyRingId = "";
   *   KeyRing keyRing = KeyRing.newBuilder().build();
   *   CreateKeyRingRequest request = CreateKeyRingRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setKeyRingId(keyRingId)
   *     .setKeyRing(keyRing)
   *     .build();
   *   ApiFuture&lt;KeyRing&gt; future = keyManagementServiceClient.createKeyRingCallable().futureCall(request);
   *   // Do something
   *   KeyRing response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateKeyRingRequest, KeyRing> createKeyRingCallable() {
    return stub.createKeyRingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
   * [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>[CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
   * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
   * are required.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   String cryptoKeyId = "my-app-key";
   *   CryptoKey.CryptoKeyPurpose purpose = CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT;
   *   long seconds = 2147483647L;
   *   Timestamp nextRotationTime = Timestamp.newBuilder()
   *     .setSeconds(seconds)
   *     .build();
   *   long seconds2 = 604800L;
   *   Duration rotationPeriod = Duration.newBuilder()
   *     .setSeconds(seconds2)
   *     .build();
   *   CryptoKey cryptoKey = CryptoKey.newBuilder()
   *     .setPurpose(purpose)
   *     .setNextRotationTime(nextRotationTime)
   *     .setRotationPeriod(rotationPeriod)
   *     .build();
   *   CryptoKey response = keyManagementServiceClient.createCryptoKey(parent, cryptoKeyId, cryptoKey);
   * }
   * </code></pre>
   *
   * @param parent Required. The [name][google.cloud.kms.v1.KeyRing.name] of the KeyRing associated
   *     with the [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   * @param cryptoKeyId Required. It must be unique within a KeyRing and match the regular
   *     expression `[a-zA-Z0-9_-]{1,63}`
   * @param cryptoKey A [CryptoKey][google.cloud.kms.v1.CryptoKey] with initial field values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey createCryptoKey(
      KeyRingName parent, String cryptoKeyId, CryptoKey cryptoKey) {

    CreateCryptoKeyRequest request =
        CreateCryptoKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCryptoKeyId(cryptoKeyId)
            .setCryptoKey(cryptoKey)
            .build();
    return createCryptoKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
   * [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>[CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
   * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
   * are required.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   String cryptoKeyId = "my-app-key";
   *   CryptoKey.CryptoKeyPurpose purpose = CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT;
   *   long seconds = 2147483647L;
   *   Timestamp nextRotationTime = Timestamp.newBuilder()
   *     .setSeconds(seconds)
   *     .build();
   *   long seconds2 = 604800L;
   *   Duration rotationPeriod = Duration.newBuilder()
   *     .setSeconds(seconds2)
   *     .build();
   *   CryptoKey cryptoKey = CryptoKey.newBuilder()
   *     .setPurpose(purpose)
   *     .setNextRotationTime(nextRotationTime)
   *     .setRotationPeriod(rotationPeriod)
   *     .build();
   *   CryptoKey response = keyManagementServiceClient.createCryptoKey(parent.toString(), cryptoKeyId, cryptoKey);
   * }
   * </code></pre>
   *
   * @param parent Required. The [name][google.cloud.kms.v1.KeyRing.name] of the KeyRing associated
   *     with the [CryptoKeys][google.cloud.kms.v1.CryptoKey].
   * @param cryptoKeyId Required. It must be unique within a KeyRing and match the regular
   *     expression `[a-zA-Z0-9_-]{1,63}`
   * @param cryptoKey A [CryptoKey][google.cloud.kms.v1.CryptoKey] with initial field values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey createCryptoKey(String parent, String cryptoKeyId, CryptoKey cryptoKey) {

    CreateCryptoKeyRequest request =
        CreateCryptoKeyRequest.newBuilder()
            .setParent(parent)
            .setCryptoKeyId(cryptoKeyId)
            .setCryptoKey(cryptoKey)
            .build();
    return createCryptoKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
   * [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>[CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
   * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
   * are required.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   String cryptoKeyId = "my-app-key";
   *   CryptoKey.CryptoKeyPurpose purpose = CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT;
   *   long seconds = 2147483647L;
   *   Timestamp nextRotationTime = Timestamp.newBuilder()
   *     .setSeconds(seconds)
   *     .build();
   *   long seconds2 = 604800L;
   *   Duration rotationPeriod = Duration.newBuilder()
   *     .setSeconds(seconds2)
   *     .build();
   *   CryptoKey cryptoKey = CryptoKey.newBuilder()
   *     .setPurpose(purpose)
   *     .setNextRotationTime(nextRotationTime)
   *     .setRotationPeriod(rotationPeriod)
   *     .build();
   *   CreateCryptoKeyRequest request = CreateCryptoKeyRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setCryptoKeyId(cryptoKeyId)
   *     .setCryptoKey(cryptoKey)
   *     .build();
   *   CryptoKey response = keyManagementServiceClient.createCryptoKey(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey createCryptoKey(CreateCryptoKeyRequest request) {
    return createCryptoKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
   * [KeyRing][google.cloud.kms.v1.KeyRing].
   *
   * <p>[CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
   * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
   * are required.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   String cryptoKeyId = "my-app-key";
   *   CryptoKey.CryptoKeyPurpose purpose = CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT;
   *   long seconds = 2147483647L;
   *   Timestamp nextRotationTime = Timestamp.newBuilder()
   *     .setSeconds(seconds)
   *     .build();
   *   long seconds2 = 604800L;
   *   Duration rotationPeriod = Duration.newBuilder()
   *     .setSeconds(seconds2)
   *     .build();
   *   CryptoKey cryptoKey = CryptoKey.newBuilder()
   *     .setPurpose(purpose)
   *     .setNextRotationTime(nextRotationTime)
   *     .setRotationPeriod(rotationPeriod)
   *     .build();
   *   CreateCryptoKeyRequest request = CreateCryptoKeyRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setCryptoKeyId(cryptoKeyId)
   *     .setCryptoKey(cryptoKey)
   *     .build();
   *   ApiFuture&lt;CryptoKey&gt; future = keyManagementServiceClient.createCryptoKeyCallable().futureCall(request);
   *   // Do something
   *   CryptoKey response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateCryptoKeyRequest, CryptoKey> createCryptoKeyCallable() {
    return stub.createCryptoKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
   * [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>The server will assign the next sequential id. If unset,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName parent = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
   *   CryptoKeyVersion response = keyManagementServiceClient.createCryptoKeyVersion(parent, cryptoKeyVersion);
   * }
   * </code></pre>
   *
   * @param parent Required. The [name][google.cloud.kms.v1.CryptoKey.name] of the
   *     [CryptoKey][google.cloud.kms.v1.CryptoKey] associated with the
   *     [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   * @param cryptoKeyVersion A [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with initial
   *     field values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion createCryptoKeyVersion(
      CryptoKeyName parent, CryptoKeyVersion cryptoKeyVersion) {

    CreateCryptoKeyVersionRequest request =
        CreateCryptoKeyVersionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCryptoKeyVersion(cryptoKeyVersion)
            .build();
    return createCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
   * [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>The server will assign the next sequential id. If unset,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName parent = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
   *   CryptoKeyVersion response = keyManagementServiceClient.createCryptoKeyVersion(parent.toString(), cryptoKeyVersion);
   * }
   * </code></pre>
   *
   * @param parent Required. The [name][google.cloud.kms.v1.CryptoKey.name] of the
   *     [CryptoKey][google.cloud.kms.v1.CryptoKey] associated with the
   *     [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
   * @param cryptoKeyVersion A [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with initial
   *     field values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion createCryptoKeyVersion(
      String parent, CryptoKeyVersion cryptoKeyVersion) {

    CreateCryptoKeyVersionRequest request =
        CreateCryptoKeyVersionRequest.newBuilder()
            .setParent(parent)
            .setCryptoKeyVersion(cryptoKeyVersion)
            .build();
    return createCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
   * [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>The server will assign the next sequential id. If unset,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName parent = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
   *   CreateCryptoKeyVersionRequest request = CreateCryptoKeyVersionRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setCryptoKeyVersion(cryptoKeyVersion)
   *     .build();
   *   CryptoKeyVersion response = keyManagementServiceClient.createCryptoKeyVersion(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion createCryptoKeyVersion(CreateCryptoKeyVersionRequest request) {
    return createCryptoKeyVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
   * [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>The server will assign the next sequential id. If unset,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName parent = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
   *   CreateCryptoKeyVersionRequest request = CreateCryptoKeyVersionRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setCryptoKeyVersion(cryptoKeyVersion)
   *     .build();
   *   ApiFuture&lt;CryptoKeyVersion&gt; future = keyManagementServiceClient.createCryptoKeyVersionCallable().futureCall(request);
   *   // Do something
   *   CryptoKeyVersion response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
      createCryptoKeyVersionCallable() {
    return stub.createCryptoKeyVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKey cryptoKey = CryptoKey.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CryptoKey response = keyManagementServiceClient.updateCryptoKey(cryptoKey, updateMask);
   * }
   * </code></pre>
   *
   * @param cryptoKey [CryptoKey][google.cloud.kms.v1.CryptoKey] with updated values.
   * @param updateMask Required list of fields to be updated in this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey updateCryptoKey(CryptoKey cryptoKey, FieldMask updateMask) {

    UpdateCryptoKeyRequest request =
        UpdateCryptoKeyRequest.newBuilder()
            .setCryptoKey(cryptoKey)
            .setUpdateMask(updateMask)
            .build();
    return updateCryptoKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKey cryptoKey = CryptoKey.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateCryptoKeyRequest request = UpdateCryptoKeyRequest.newBuilder()
   *     .setCryptoKey(cryptoKey)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   CryptoKey response = keyManagementServiceClient.updateCryptoKey(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey updateCryptoKey(UpdateCryptoKeyRequest request) {
    return updateCryptoKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKey cryptoKey = CryptoKey.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateCryptoKeyRequest request = UpdateCryptoKeyRequest.newBuilder()
   *     .setCryptoKey(cryptoKey)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;CryptoKey&gt; future = keyManagementServiceClient.updateCryptoKeyCallable().futureCall(request);
   *   // Do something
   *   CryptoKey response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeyCallable() {
    return stub.updateCryptoKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Update a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s metadata.
   *
   * <p>[state][google.cloud.kms.v1.CryptoKeyVersion.state] may be changed between
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED] and
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED] using this
   * method. See
   * [DestroyCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.DestroyCryptoKeyVersion] and
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] to
   * move between other states.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CryptoKeyVersion response = keyManagementServiceClient.updateCryptoKeyVersion(cryptoKeyVersion, updateMask);
   * }
   * </code></pre>
   *
   * @param cryptoKeyVersion [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with updated
   *     values.
   * @param updateMask Required list of fields to be updated in this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion updateCryptoKeyVersion(
      CryptoKeyVersion cryptoKeyVersion, FieldMask updateMask) {

    UpdateCryptoKeyVersionRequest request =
        UpdateCryptoKeyVersionRequest.newBuilder()
            .setCryptoKeyVersion(cryptoKeyVersion)
            .setUpdateMask(updateMask)
            .build();
    return updateCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Update a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s metadata.
   *
   * <p>[state][google.cloud.kms.v1.CryptoKeyVersion.state] may be changed between
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED] and
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED] using this
   * method. See
   * [DestroyCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.DestroyCryptoKeyVersion] and
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] to
   * move between other states.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateCryptoKeyVersionRequest request = UpdateCryptoKeyVersionRequest.newBuilder()
   *     .setCryptoKeyVersion(cryptoKeyVersion)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   CryptoKeyVersion response = keyManagementServiceClient.updateCryptoKeyVersion(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion updateCryptoKeyVersion(UpdateCryptoKeyVersionRequest request) {
    return updateCryptoKeyVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Update a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s metadata.
   *
   * <p>[state][google.cloud.kms.v1.CryptoKeyVersion.state] may be changed between
   * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED] and
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED] using this
   * method. See
   * [DestroyCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.DestroyCryptoKeyVersion] and
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] to
   * move between other states.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateCryptoKeyVersionRequest request = UpdateCryptoKeyVersionRequest.newBuilder()
   *     .setCryptoKeyVersion(cryptoKeyVersion)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;CryptoKeyVersion&gt; future = keyManagementServiceClient.updateCryptoKeyVersionCallable().futureCall(request);
   *   // Do something
   *   CryptoKeyVersion response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
      updateCryptoKeyVersionCallable() {
    return stub.updateCryptoKeyVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Encrypts data, so that it can only be recovered by a call to
   * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyPathName name = CryptoKeyPathName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY_PATH]");
   *   ByteString plaintext = ByteString.copyFromUtf8("");
   *   EncryptResponse response = keyManagementServiceClient.encrypt(name, plaintext);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] or
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for encryption.
   *     <p>If a [CryptoKey][google.cloud.kms.v1.CryptoKey] is specified, the server will use its
   *     [primary version][google.cloud.kms.v1.CryptoKey.primary].
   * @param plaintext Required. The data to encrypt. Must be no larger than 64KiB.
   *     <p>The maximum size depends on the key version's
   *     [protection_level][google.cloud.kms.v1.CryptoKeyVersionTemplate.protection_level]. For
   *     [SOFTWARE][google.cloud.kms.v1.ProtectionLevel.SOFTWARE] keys, the plaintext must be no
   *     larger than 64KiB. For [HSM][google.cloud.kms.v1.ProtectionLevel.HSM] keys, the combined
   *     length of the plaintext and additional_authenticated_data fields must be no larger than
   *     8KiB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptResponse encrypt(CryptoKeyPathName name, ByteString plaintext) {

    EncryptRequest request =
        EncryptRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPlaintext(plaintext)
            .build();
    return encrypt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Encrypts data, so that it can only be recovered by a call to
   * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyPathName name = CryptoKeyPathName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY_PATH]");
   *   ByteString plaintext = ByteString.copyFromUtf8("");
   *   EncryptResponse response = keyManagementServiceClient.encrypt(name.toString(), plaintext);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] or
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for encryption.
   *     <p>If a [CryptoKey][google.cloud.kms.v1.CryptoKey] is specified, the server will use its
   *     [primary version][google.cloud.kms.v1.CryptoKey.primary].
   * @param plaintext Required. The data to encrypt. Must be no larger than 64KiB.
   *     <p>The maximum size depends on the key version's
   *     [protection_level][google.cloud.kms.v1.CryptoKeyVersionTemplate.protection_level]. For
   *     [SOFTWARE][google.cloud.kms.v1.ProtectionLevel.SOFTWARE] keys, the plaintext must be no
   *     larger than 64KiB. For [HSM][google.cloud.kms.v1.ProtectionLevel.HSM] keys, the combined
   *     length of the plaintext and additional_authenticated_data fields must be no larger than
   *     8KiB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptResponse encrypt(String name, ByteString plaintext) {

    EncryptRequest request =
        EncryptRequest.newBuilder().setName(name).setPlaintext(plaintext).build();
    return encrypt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Encrypts data, so that it can only be recovered by a call to
   * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyPathName name = CryptoKeyPathName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY_PATH]");
   *   ByteString plaintext = ByteString.copyFromUtf8("");
   *   EncryptRequest request = EncryptRequest.newBuilder()
   *     .setName(name.toString())
   *     .setPlaintext(plaintext)
   *     .build();
   *   EncryptResponse response = keyManagementServiceClient.encrypt(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptResponse encrypt(EncryptRequest request) {
    return encryptCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Encrypts data, so that it can only be recovered by a call to
   * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyPathName name = CryptoKeyPathName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY_PATH]");
   *   ByteString plaintext = ByteString.copyFromUtf8("");
   *   EncryptRequest request = EncryptRequest.newBuilder()
   *     .setName(name.toString())
   *     .setPlaintext(plaintext)
   *     .build();
   *   ApiFuture&lt;EncryptResponse&gt; future = keyManagementServiceClient.encryptCallable().futureCall(request);
   *   // Do something
   *   EncryptResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<EncryptRequest, EncryptResponse> encryptCallable() {
    return stub.encryptCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Decrypts data that was protected by
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   ByteString ciphertext = ByteString.copyFromUtf8("");
   *   DecryptResponse response = keyManagementServiceClient.decrypt(name, ciphertext);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] to
   *     use for decryption. The server will choose the appropriate version.
   * @param ciphertext Required. The encrypted data originally returned in
   *     [EncryptResponse.ciphertext][google.cloud.kms.v1.EncryptResponse.ciphertext].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DecryptResponse decrypt(CryptoKeyName name, ByteString ciphertext) {

    DecryptRequest request =
        DecryptRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setCiphertext(ciphertext)
            .build();
    return decrypt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Decrypts data that was protected by
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   ByteString ciphertext = ByteString.copyFromUtf8("");
   *   DecryptResponse response = keyManagementServiceClient.decrypt(name.toString(), ciphertext);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] to
   *     use for decryption. The server will choose the appropriate version.
   * @param ciphertext Required. The encrypted data originally returned in
   *     [EncryptResponse.ciphertext][google.cloud.kms.v1.EncryptResponse.ciphertext].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DecryptResponse decrypt(String name, ByteString ciphertext) {

    DecryptRequest request =
        DecryptRequest.newBuilder().setName(name).setCiphertext(ciphertext).build();
    return decrypt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Decrypts data that was protected by
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   ByteString ciphertext = ByteString.copyFromUtf8("");
   *   DecryptRequest request = DecryptRequest.newBuilder()
   *     .setName(name.toString())
   *     .setCiphertext(ciphertext)
   *     .build();
   *   DecryptResponse response = keyManagementServiceClient.decrypt(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DecryptResponse decrypt(DecryptRequest request) {
    return decryptCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Decrypts data that was protected by
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   ByteString ciphertext = ByteString.copyFromUtf8("");
   *   DecryptRequest request = DecryptRequest.newBuilder()
   *     .setName(name.toString())
   *     .setCiphertext(ciphertext)
   *     .build();
   *   ApiFuture&lt;DecryptResponse&gt; future = keyManagementServiceClient.decryptCallable().futureCall(request);
   *   // Do something
   *   DecryptResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DecryptRequest, DecryptResponse> decryptCallable() {
    return stub.decryptCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that will be used in
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
   *
   * <p>Returns an error if called on an asymmetric key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   String cryptoKeyVersionId = "";
   *   CryptoKey response = keyManagementServiceClient.updateCryptoKeyPrimaryVersion(name, cryptoKeyVersionId);
   * }
   * </code></pre>
   *
   * @param name The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] to update.
   * @param cryptoKeyVersionId The id of the child
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use as primary.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey updateCryptoKeyPrimaryVersion(
      CryptoKeyName name, String cryptoKeyVersionId) {

    UpdateCryptoKeyPrimaryVersionRequest request =
        UpdateCryptoKeyPrimaryVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setCryptoKeyVersionId(cryptoKeyVersionId)
            .build();
    return updateCryptoKeyPrimaryVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that will be used in
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
   *
   * <p>Returns an error if called on an asymmetric key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   String cryptoKeyVersionId = "";
   *   CryptoKey response = keyManagementServiceClient.updateCryptoKeyPrimaryVersion(name.toString(), cryptoKeyVersionId);
   * }
   * </code></pre>
   *
   * @param name The resource name of the [CryptoKey][google.cloud.kms.v1.CryptoKey] to update.
   * @param cryptoKeyVersionId The id of the child
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use as primary.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey updateCryptoKeyPrimaryVersion(String name, String cryptoKeyVersionId) {

    UpdateCryptoKeyPrimaryVersionRequest request =
        UpdateCryptoKeyPrimaryVersionRequest.newBuilder()
            .setName(name)
            .setCryptoKeyVersionId(cryptoKeyVersionId)
            .build();
    return updateCryptoKeyPrimaryVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that will be used in
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
   *
   * <p>Returns an error if called on an asymmetric key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   String cryptoKeyVersionId = "";
   *   UpdateCryptoKeyPrimaryVersionRequest request = UpdateCryptoKeyPrimaryVersionRequest.newBuilder()
   *     .setName(name.toString())
   *     .setCryptoKeyVersionId(cryptoKeyVersionId)
   *     .build();
   *   CryptoKey response = keyManagementServiceClient.updateCryptoKeyPrimaryVersion(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKey updateCryptoKeyPrimaryVersion(
      UpdateCryptoKeyPrimaryVersionRequest request) {
    return updateCryptoKeyPrimaryVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that will be used in
   * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
   *
   * <p>Returns an error if called on an asymmetric key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
   *   String cryptoKeyVersionId = "";
   *   UpdateCryptoKeyPrimaryVersionRequest request = UpdateCryptoKeyPrimaryVersionRequest.newBuilder()
   *     .setName(name.toString())
   *     .setCryptoKeyVersionId(cryptoKeyVersionId)
   *     .build();
   *   ApiFuture&lt;CryptoKey&gt; future = keyManagementServiceClient.updateCryptoKeyPrimaryVersionCallable().futureCall(request);
   *   // Do something
   *   CryptoKey response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
      updateCryptoKeyPrimaryVersionCallable() {
    return stub.updateCryptoKeyPrimaryVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for destruction.
   *
   * <p>Upon calling this method,
   * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
   * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be set to a time 24
   * hours in the future, at which point the [state][google.cloud.kms.v1.CryptoKeyVersion.state]
   * will be changed to
   * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED], and the key
   * material will be irrevocably destroyed.
   *
   * <p>Before the [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is reached,
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] may
   * be called to reverse the process.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   CryptoKeyVersion response = keyManagementServiceClient.destroyCryptoKeyVersion(name);
   * }
   * </code></pre>
   *
   * @param name The resource name of the [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   *     to destroy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion destroyCryptoKeyVersion(CryptoKeyVersionName name) {

    DestroyCryptoKeyVersionRequest request =
        DestroyCryptoKeyVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return destroyCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for destruction.
   *
   * <p>Upon calling this method,
   * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
   * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be set to a time 24
   * hours in the future, at which point the [state][google.cloud.kms.v1.CryptoKeyVersion.state]
   * will be changed to
   * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED], and the key
   * material will be irrevocably destroyed.
   *
   * <p>Before the [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is reached,
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] may
   * be called to reverse the process.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   CryptoKeyVersion response = keyManagementServiceClient.destroyCryptoKeyVersion(name.toString());
   * }
   * </code></pre>
   *
   * @param name The resource name of the [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   *     to destroy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion destroyCryptoKeyVersion(String name) {

    DestroyCryptoKeyVersionRequest request =
        DestroyCryptoKeyVersionRequest.newBuilder().setName(name).build();
    return destroyCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for destruction.
   *
   * <p>Upon calling this method,
   * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
   * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be set to a time 24
   * hours in the future, at which point the [state][google.cloud.kms.v1.CryptoKeyVersion.state]
   * will be changed to
   * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED], and the key
   * material will be irrevocably destroyed.
   *
   * <p>Before the [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is reached,
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] may
   * be called to reverse the process.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   DestroyCryptoKeyVersionRequest request = DestroyCryptoKeyVersionRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   CryptoKeyVersion response = keyManagementServiceClient.destroyCryptoKeyVersion(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final CryptoKeyVersion destroyCryptoKeyVersion(DestroyCryptoKeyVersionRequest request) {
    return destroyCryptoKeyVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for destruction.
   *
   * <p>Upon calling this method,
   * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
   * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be set to a time 24
   * hours in the future, at which point the [state][google.cloud.kms.v1.CryptoKeyVersion.state]
   * will be changed to
   * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED], and the key
   * material will be irrevocably destroyed.
   *
   * <p>Before the [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is reached,
   * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion] may
   * be called to reverse the process.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   DestroyCryptoKeyVersionRequest request = DestroyCryptoKeyVersionRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;CryptoKeyVersion&gt; future = keyManagementServiceClient.destroyCryptoKeyVersionCallable().futureCall(request);
   *   // Do something
   *   CryptoKeyVersion response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
      destroyCryptoKeyVersionCallable() {
    return stub.destroyCryptoKeyVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Restore a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in the
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
   * state.
   *
   * <p>Upon restoration of the CryptoKeyVersion,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED], and
   * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be cleared.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   CryptoKeyVersion response = keyManagementServiceClient.restoreCryptoKeyVersion(name);
   * }
   * </code></pre>
   *
   * @param name The resource name of the [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   *     to restore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion restoreCryptoKeyVersion(CryptoKeyVersionName name) {

    RestoreCryptoKeyVersionRequest request =
        RestoreCryptoKeyVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return restoreCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Restore a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in the
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
   * state.
   *
   * <p>Upon restoration of the CryptoKeyVersion,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED], and
   * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be cleared.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   CryptoKeyVersion response = keyManagementServiceClient.restoreCryptoKeyVersion(name.toString());
   * }
   * </code></pre>
   *
   * @param name The resource name of the [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   *     to restore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CryptoKeyVersion restoreCryptoKeyVersion(String name) {

    RestoreCryptoKeyVersionRequest request =
        RestoreCryptoKeyVersionRequest.newBuilder().setName(name).build();
    return restoreCryptoKeyVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Restore a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in the
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
   * state.
   *
   * <p>Upon restoration of the CryptoKeyVersion,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED], and
   * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be cleared.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   RestoreCryptoKeyVersionRequest request = RestoreCryptoKeyVersionRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   CryptoKeyVersion response = keyManagementServiceClient.restoreCryptoKeyVersion(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final CryptoKeyVersion restoreCryptoKeyVersion(RestoreCryptoKeyVersionRequest request) {
    return restoreCryptoKeyVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Restore a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in the
   * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
   * state.
   *
   * <p>Upon restoration of the CryptoKeyVersion,
   * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
   * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED], and
   * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will be cleared.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   RestoreCryptoKeyVersionRequest request = RestoreCryptoKeyVersionRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;CryptoKeyVersion&gt; future = keyManagementServiceClient.restoreCryptoKeyVersionCallable().futureCall(request);
   *   // Do something
   *   CryptoKeyVersion response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
      restoreCryptoKeyVersionCallable() {
    return stub.restoreCryptoKeyVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the public key for the given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   * The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN] or
   * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   PublicKey response = keyManagementServiceClient.getPublicKey(name);
   * }
   * </code></pre>
   *
   * @param name The [name][google.cloud.kms.v1.CryptoKeyVersion.name] of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] public key to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicKey getPublicKey(CryptoKeyVersionName name) {

    GetPublicKeyRequest request =
        GetPublicKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the public key for the given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   * The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN] or
   * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   PublicKey response = keyManagementServiceClient.getPublicKey(name.toString());
   * }
   * </code></pre>
   *
   * @param name The [name][google.cloud.kms.v1.CryptoKeyVersion.name] of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] public key to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicKey getPublicKey(String name) {

    GetPublicKeyRequest request = GetPublicKeyRequest.newBuilder().setName(name).build();
    return getPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the public key for the given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   * The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN] or
   * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   GetPublicKeyRequest request = GetPublicKeyRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   PublicKey response = keyManagementServiceClient.getPublicKey(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicKey getPublicKey(GetPublicKeyRequest request) {
    return getPublicKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the public key for the given [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
   * The [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
   * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN] or
   * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   GetPublicKeyRequest request = GetPublicKeyRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;PublicKey&gt; future = keyManagementServiceClient.getPublicKeyCallable().futureCall(request);
   *   // Do something
   *   PublicKey response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetPublicKeyRequest, PublicKey> getPublicKeyCallable() {
    return stub.getPublicKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Decrypts data that was encrypted with a public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey] corresponding to a
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_DECRYPT.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   ByteString ciphertext = ByteString.copyFromUtf8("");
   *   AsymmetricDecryptResponse response = keyManagementServiceClient.asymmetricDecrypt(name, ciphertext);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for decryption.
   * @param ciphertext Required. The data encrypted with the named
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s public key using OAEP.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AsymmetricDecryptResponse asymmetricDecrypt(
      CryptoKeyVersionName name, ByteString ciphertext) {

    AsymmetricDecryptRequest request =
        AsymmetricDecryptRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setCiphertext(ciphertext)
            .build();
    return asymmetricDecrypt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Decrypts data that was encrypted with a public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey] corresponding to a
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_DECRYPT.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   ByteString ciphertext = ByteString.copyFromUtf8("");
   *   AsymmetricDecryptResponse response = keyManagementServiceClient.asymmetricDecrypt(name.toString(), ciphertext);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for decryption.
   * @param ciphertext Required. The data encrypted with the named
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s public key using OAEP.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AsymmetricDecryptResponse asymmetricDecrypt(String name, ByteString ciphertext) {

    AsymmetricDecryptRequest request =
        AsymmetricDecryptRequest.newBuilder().setName(name).setCiphertext(ciphertext).build();
    return asymmetricDecrypt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Decrypts data that was encrypted with a public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey] corresponding to a
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_DECRYPT.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   ByteString ciphertext = ByteString.copyFromUtf8("");
   *   AsymmetricDecryptRequest request = AsymmetricDecryptRequest.newBuilder()
   *     .setName(name.toString())
   *     .setCiphertext(ciphertext)
   *     .build();
   *   AsymmetricDecryptResponse response = keyManagementServiceClient.asymmetricDecrypt(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AsymmetricDecryptResponse asymmetricDecrypt(AsymmetricDecryptRequest request) {
    return asymmetricDecryptCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Decrypts data that was encrypted with a public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey] corresponding to a
   * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_DECRYPT.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   ByteString ciphertext = ByteString.copyFromUtf8("");
   *   AsymmetricDecryptRequest request = AsymmetricDecryptRequest.newBuilder()
   *     .setName(name.toString())
   *     .setCiphertext(ciphertext)
   *     .build();
   *   ApiFuture&lt;AsymmetricDecryptResponse&gt; future = keyManagementServiceClient.asymmetricDecryptCallable().futureCall(request);
   *   // Do something
   *   AsymmetricDecryptResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
      asymmetricDecryptCallable() {
    return stub.asymmetricDecryptCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_SIGN, producing a
   * signature that can be verified with the public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   Digest digest = Digest.newBuilder().build();
   *   AsymmetricSignResponse response = keyManagementServiceClient.asymmetricSign(name, digest);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for signing.
   * @param digest Required. The digest of the data to sign. The digest must be produced with the
   *     same digest algorithm as specified by the key version's
   *     [algorithm][google.cloud.kms.v1.CryptoKeyVersion.algorithm].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AsymmetricSignResponse asymmetricSign(CryptoKeyVersionName name, Digest digest) {

    AsymmetricSignRequest request =
        AsymmetricSignRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDigest(digest)
            .build();
    return asymmetricSign(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_SIGN, producing a
   * signature that can be verified with the public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   Digest digest = Digest.newBuilder().build();
   *   AsymmetricSignResponse response = keyManagementServiceClient.asymmetricSign(name.toString(), digest);
   * }
   * </code></pre>
   *
   * @param name Required. The resource name of the
   *     [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] to use for signing.
   * @param digest Required. The digest of the data to sign. The digest must be produced with the
   *     same digest algorithm as specified by the key version's
   *     [algorithm][google.cloud.kms.v1.CryptoKeyVersion.algorithm].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AsymmetricSignResponse asymmetricSign(String name, Digest digest) {

    AsymmetricSignRequest request =
        AsymmetricSignRequest.newBuilder().setName(name).setDigest(digest).build();
    return asymmetricSign(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_SIGN, producing a
   * signature that can be verified with the public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   Digest digest = Digest.newBuilder().build();
   *   AsymmetricSignRequest request = AsymmetricSignRequest.newBuilder()
   *     .setName(name.toString())
   *     .setDigest(digest)
   *     .build();
   *   AsymmetricSignResponse response = keyManagementServiceClient.asymmetricSign(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AsymmetricSignResponse asymmetricSign(AsymmetricSignRequest request) {
    return asymmetricSignCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
   * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] ASYMMETRIC_SIGN, producing a
   * signature that can be verified with the public key retrieved from
   * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   CryptoKeyVersionName name = CryptoKeyVersionName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
   *   Digest digest = Digest.newBuilder().build();
   *   AsymmetricSignRequest request = AsymmetricSignRequest.newBuilder()
   *     .setName(name.toString())
   *     .setDigest(digest)
   *     .build();
   *   ApiFuture&lt;AsymmetricSignResponse&gt; future = keyManagementServiceClient.asymmetricSignCallable().futureCall(request);
   *   // Do something
   *   AsymmetricSignResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AsymmetricSignRequest, AsymmetricSignResponse>
      asymmetricSignCallable() {
    return stub.asymmetricSignCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = keyManagementServiceClient.setIamPolicy(resource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(KeyName resource, Policy policy) {

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = keyManagementServiceClient.setIamPolicy(resource.toString(), policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   ResourceName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setPolicy(policy)
   *     .build();
   *   Policy response = keyManagementServiceClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   ResourceName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setPolicy(policy)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = keyManagementServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy response = keyManagementServiceClient.getIamPolicy(resource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(KeyName resource) {

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   Policy response = keyManagementServiceClient.getIamPolicy(resource.toString());
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. `resource` is
   *     usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {

    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   ResourceName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .build();
   *   Policy response = keyManagementServiceClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   ResourceName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = keyManagementServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = keyManagementServiceClient.testIamPermissions(resource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested.
   *     `resource` is usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      KeyName resource, List<String> permissions) {

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   KeyName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = keyManagementServiceClient.testIamPermissions(resource.toString(), permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested.
   *     `resource` is usually specified as a path. For example, a Project resource is specified as
   *     `projects/{project}`.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   ResourceName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .addAllPermissions(permissions)
   *     .build();
   *   TestIamPermissionsResponse response = keyManagementServiceClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (KeyManagementServiceClient keyManagementServiceClient = KeyManagementServiceClient.create()) {
   *   ResourceName resource = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .addAllPermissions(permissions)
   *     .build();
   *   ApiFuture&lt;TestIamPermissionsResponse&gt; future = keyManagementServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestIamPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
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

  public static class ListKeyRingsPagedResponse
      extends AbstractPagedListResponse<
          ListKeyRingsRequest, ListKeyRingsResponse, KeyRing, ListKeyRingsPage,
          ListKeyRingsFixedSizeCollection> {

    public static ApiFuture<ListKeyRingsPagedResponse> createAsync(
        PageContext<ListKeyRingsRequest, ListKeyRingsResponse, KeyRing> context,
        ApiFuture<ListKeyRingsResponse> futureResponse) {
      ApiFuture<ListKeyRingsPage> futurePage =
          ListKeyRingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListKeyRingsPage, ListKeyRingsPagedResponse>() {
            @Override
            public ListKeyRingsPagedResponse apply(ListKeyRingsPage input) {
              return new ListKeyRingsPagedResponse(input);
            }
          });
    }

    private ListKeyRingsPagedResponse(ListKeyRingsPage page) {
      super(page, ListKeyRingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListKeyRingsPage
      extends AbstractPage<ListKeyRingsRequest, ListKeyRingsResponse, KeyRing, ListKeyRingsPage> {

    private ListKeyRingsPage(
        PageContext<ListKeyRingsRequest, ListKeyRingsResponse, KeyRing> context,
        ListKeyRingsResponse response) {
      super(context, response);
    }

    private static ListKeyRingsPage createEmptyPage() {
      return new ListKeyRingsPage(null, null);
    }

    @Override
    protected ListKeyRingsPage createPage(
        PageContext<ListKeyRingsRequest, ListKeyRingsResponse, KeyRing> context,
        ListKeyRingsResponse response) {
      return new ListKeyRingsPage(context, response);
    }

    @Override
    public ApiFuture<ListKeyRingsPage> createPageAsync(
        PageContext<ListKeyRingsRequest, ListKeyRingsResponse, KeyRing> context,
        ApiFuture<ListKeyRingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListKeyRingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListKeyRingsRequest, ListKeyRingsResponse, KeyRing, ListKeyRingsPage,
          ListKeyRingsFixedSizeCollection> {

    private ListKeyRingsFixedSizeCollection(List<ListKeyRingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListKeyRingsFixedSizeCollection createEmptyCollection() {
      return new ListKeyRingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListKeyRingsFixedSizeCollection createCollection(
        List<ListKeyRingsPage> pages, int collectionSize) {
      return new ListKeyRingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCryptoKeysPagedResponse
      extends AbstractPagedListResponse<
          ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey, ListCryptoKeysPage,
          ListCryptoKeysFixedSizeCollection> {

    public static ApiFuture<ListCryptoKeysPagedResponse> createAsync(
        PageContext<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey> context,
        ApiFuture<ListCryptoKeysResponse> futureResponse) {
      ApiFuture<ListCryptoKeysPage> futurePage =
          ListCryptoKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListCryptoKeysPage, ListCryptoKeysPagedResponse>() {
            @Override
            public ListCryptoKeysPagedResponse apply(ListCryptoKeysPage input) {
              return new ListCryptoKeysPagedResponse(input);
            }
          });
    }

    private ListCryptoKeysPagedResponse(ListCryptoKeysPage page) {
      super(page, ListCryptoKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCryptoKeysPage
      extends AbstractPage<
          ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey, ListCryptoKeysPage> {

    private ListCryptoKeysPage(
        PageContext<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey> context,
        ListCryptoKeysResponse response) {
      super(context, response);
    }

    private static ListCryptoKeysPage createEmptyPage() {
      return new ListCryptoKeysPage(null, null);
    }

    @Override
    protected ListCryptoKeysPage createPage(
        PageContext<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey> context,
        ListCryptoKeysResponse response) {
      return new ListCryptoKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListCryptoKeysPage> createPageAsync(
        PageContext<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey> context,
        ApiFuture<ListCryptoKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCryptoKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey, ListCryptoKeysPage,
          ListCryptoKeysFixedSizeCollection> {

    private ListCryptoKeysFixedSizeCollection(List<ListCryptoKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCryptoKeysFixedSizeCollection createEmptyCollection() {
      return new ListCryptoKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCryptoKeysFixedSizeCollection createCollection(
        List<ListCryptoKeysPage> pages, int collectionSize) {
      return new ListCryptoKeysFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCryptoKeyVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion,
          ListCryptoKeyVersionsPage, ListCryptoKeyVersionsFixedSizeCollection> {

    public static ApiFuture<ListCryptoKeyVersionsPagedResponse> createAsync(
        PageContext<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion>
            context,
        ApiFuture<ListCryptoKeyVersionsResponse> futureResponse) {
      ApiFuture<ListCryptoKeyVersionsPage> futurePage =
          ListCryptoKeyVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListCryptoKeyVersionsPage, ListCryptoKeyVersionsPagedResponse>() {
            @Override
            public ListCryptoKeyVersionsPagedResponse apply(ListCryptoKeyVersionsPage input) {
              return new ListCryptoKeyVersionsPagedResponse(input);
            }
          });
    }

    private ListCryptoKeyVersionsPagedResponse(ListCryptoKeyVersionsPage page) {
      super(page, ListCryptoKeyVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCryptoKeyVersionsPage
      extends AbstractPage<
          ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion,
          ListCryptoKeyVersionsPage> {

    private ListCryptoKeyVersionsPage(
        PageContext<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion>
            context,
        ListCryptoKeyVersionsResponse response) {
      super(context, response);
    }

    private static ListCryptoKeyVersionsPage createEmptyPage() {
      return new ListCryptoKeyVersionsPage(null, null);
    }

    @Override
    protected ListCryptoKeyVersionsPage createPage(
        PageContext<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion>
            context,
        ListCryptoKeyVersionsResponse response) {
      return new ListCryptoKeyVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListCryptoKeyVersionsPage> createPageAsync(
        PageContext<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion>
            context,
        ApiFuture<ListCryptoKeyVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCryptoKeyVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion,
          ListCryptoKeyVersionsPage, ListCryptoKeyVersionsFixedSizeCollection> {

    private ListCryptoKeyVersionsFixedSizeCollection(
        List<ListCryptoKeyVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCryptoKeyVersionsFixedSizeCollection createEmptyCollection() {
      return new ListCryptoKeyVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCryptoKeyVersionsFixedSizeCollection createCollection(
        List<ListCryptoKeyVersionsPage> pages, int collectionSize) {
      return new ListCryptoKeyVersionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
