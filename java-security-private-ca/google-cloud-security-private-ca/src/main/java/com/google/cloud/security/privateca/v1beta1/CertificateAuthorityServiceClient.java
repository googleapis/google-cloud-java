/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.security.privateca.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.security.privateca.v1beta1.stub.CertificateAuthorityServiceStub;
import com.google.cloud.security.privateca.v1beta1.stub.CertificateAuthorityServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: [Certificate Authority
 * Service][google.cloud.security.privateca.v1beta1.CertificateAuthorityService] manages private
 * certificate authorities and issued certificates.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
 *     CertificateAuthorityServiceClient.create()) {
 *   CertificateAuthorityName parent =
 *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
 *   Certificate certificate = Certificate.newBuilder().build();
 *   String certificateId = "certificateId-644529902";
 *   Certificate response =
 *       certificateAuthorityServiceClient.createCertificate(parent, certificate, certificateId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CertificateAuthorityServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of
 * CertificateAuthorityServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * CertificateAuthorityServiceSettings certificateAuthorityServiceSettings =
 *     CertificateAuthorityServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CertificateAuthorityServiceClient certificateAuthorityServiceClient =
 *     CertificateAuthorityServiceClient.create(certificateAuthorityServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * CertificateAuthorityServiceSettings certificateAuthorityServiceSettings =
 *     CertificateAuthorityServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CertificateAuthorityServiceClient certificateAuthorityServiceClient =
 *     CertificateAuthorityServiceClient.create(certificateAuthorityServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CertificateAuthorityServiceClient implements BackgroundResource {
  private final CertificateAuthorityServiceSettings settings;
  private final CertificateAuthorityServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of CertificateAuthorityServiceClient with default settings. */
  public static final CertificateAuthorityServiceClient create() throws IOException {
    return create(CertificateAuthorityServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CertificateAuthorityServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final CertificateAuthorityServiceClient create(
      CertificateAuthorityServiceSettings settings) throws IOException {
    return new CertificateAuthorityServiceClient(settings);
  }

  /**
   * Constructs an instance of CertificateAuthorityServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(CertificateAuthorityServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final CertificateAuthorityServiceClient create(
      CertificateAuthorityServiceStub stub) {
    return new CertificateAuthorityServiceClient(stub);
  }

  /**
   * Constructs an instance of CertificateAuthorityServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CertificateAuthorityServiceClient(CertificateAuthorityServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((CertificateAuthorityServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected CertificateAuthorityServiceClient(CertificateAuthorityServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final CertificateAuthorityServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CertificateAuthorityServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [Certificate][google.cloud.security.privateca.v1beta1.Certificate] in a given
   * Project, Location from a particular
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName parent =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
   *   Certificate certificate = Certificate.newBuilder().build();
   *   String certificateId = "certificateId-644529902";
   *   Certificate response =
   *       certificateAuthorityServiceClient.createCertificate(parent, certificate, certificateId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location and
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   *     associated with the [Certificate][google.cloud.security.privateca.v1beta1.Certificate], in
   *     the format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @param certificate Required. A
   *     [Certificate][google.cloud.security.privateca.v1beta1.Certificate] with initial field
   *     values.
   * @param certificateId Optional. It must be unique within a location and match the regular
   *     expression `[a-zA-Z0-9_-]{1,63}`. This field is required when using a
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     Enterprise
   *     [CertificateAuthority.Tier][google.cloud.security.privateca.v1beta1.CertificateAuthority.Tier],
   *     but is optional and its value is ignored otherwise.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate createCertificate(
      CertificateAuthorityName parent, Certificate certificate, String certificateId) {
    CreateCertificateRequest request =
        CreateCertificateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCertificate(certificate)
            .setCertificateId(certificateId)
            .build();
    return createCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [Certificate][google.cloud.security.privateca.v1beta1.Certificate] in a given
   * Project, Location from a particular
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   Certificate certificate = Certificate.newBuilder().build();
   *   String certificateId = "certificateId-644529902";
   *   Certificate response =
   *       certificateAuthorityServiceClient.createCertificate(parent, certificate, certificateId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location and
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   *     associated with the [Certificate][google.cloud.security.privateca.v1beta1.Certificate], in
   *     the format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @param certificate Required. A
   *     [Certificate][google.cloud.security.privateca.v1beta1.Certificate] with initial field
   *     values.
   * @param certificateId Optional. It must be unique within a location and match the regular
   *     expression `[a-zA-Z0-9_-]{1,63}`. This field is required when using a
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     Enterprise
   *     [CertificateAuthority.Tier][google.cloud.security.privateca.v1beta1.CertificateAuthority.Tier],
   *     but is optional and its value is ignored otherwise.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate createCertificate(
      String parent, Certificate certificate, String certificateId) {
    CreateCertificateRequest request =
        CreateCertificateRequest.newBuilder()
            .setParent(parent)
            .setCertificate(certificate)
            .setCertificateId(certificateId)
            .build();
    return createCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [Certificate][google.cloud.security.privateca.v1beta1.Certificate] in a given
   * Project, Location from a particular
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCertificateRequest request =
   *       CreateCertificateRequest.newBuilder()
   *           .setParent(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setCertificateId("certificateId-644529902")
   *           .setCertificate(Certificate.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Certificate response = certificateAuthorityServiceClient.createCertificate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate createCertificate(CreateCertificateRequest request) {
    return createCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [Certificate][google.cloud.security.privateca.v1beta1.Certificate] in a given
   * Project, Location from a particular
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCertificateRequest request =
   *       CreateCertificateRequest.newBuilder()
   *           .setParent(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setCertificateId("certificateId-644529902")
   *           .setCertificate(Certificate.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Certificate> future =
   *       certificateAuthorityServiceClient.createCertificateCallable().futureCall(request);
   *   // Do something.
   *   Certificate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCertificateRequest, Certificate> createCertificateCallable() {
    return stub.createCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateName name =
   *       CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");
   *   Certificate response = certificateAuthorityServiceClient.getCertificate(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.security.privateca.v1beta1.Certificate.name] of
   *     the [Certificate][google.cloud.security.privateca.v1beta1.Certificate] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate getCertificate(CertificateName name) {
    GetCertificateRequest request =
        GetCertificateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
   *           .toString();
   *   Certificate response = certificateAuthorityServiceClient.getCertificate(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.security.privateca.v1beta1.Certificate.name] of
   *     the [Certificate][google.cloud.security.privateca.v1beta1.Certificate] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate getCertificate(String name) {
    GetCertificateRequest request = GetCertificateRequest.newBuilder().setName(name).build();
    return getCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateRequest request =
   *       GetCertificateRequest.newBuilder()
   *           .setName(
   *               CertificateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
   *                   .toString())
   *           .build();
   *   Certificate response = certificateAuthorityServiceClient.getCertificate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate getCertificate(GetCertificateRequest request) {
    return getCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateRequest request =
   *       GetCertificateRequest.newBuilder()
   *           .setName(
   *               CertificateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Certificate> future =
   *       certificateAuthorityServiceClient.getCertificateCallable().futureCall(request);
   *   // Do something.
   *   Certificate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCertificateRequest, Certificate> getCertificateCallable() {
    return stub.getCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Certificates][google.cloud.security.privateca.v1beta1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName parent =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
   *   for (Certificate element :
   *       certificateAuthorityServiceClient.listCertificates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [Certificates][google.cloud.security.privateca.v1beta1.Certificate], in the format
   *     `projects/&#42;/locations/&#42;/certificateauthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificatesPagedResponse listCertificates(CertificateAuthorityName parent) {
    ListCertificatesRequest request =
        ListCertificatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCertificates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Certificates][google.cloud.security.privateca.v1beta1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   for (Certificate element :
   *       certificateAuthorityServiceClient.listCertificates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [Certificates][google.cloud.security.privateca.v1beta1.Certificate], in the format
   *     `projects/&#42;/locations/&#42;/certificateauthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificatesPagedResponse listCertificates(String parent) {
    ListCertificatesRequest request =
        ListCertificatesRequest.newBuilder().setParent(parent).build();
    return listCertificates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Certificates][google.cloud.security.privateca.v1beta1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificatesRequest request =
   *       ListCertificatesRequest.newBuilder()
   *           .setParent(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Certificate element :
   *       certificateAuthorityServiceClient.listCertificates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificatesPagedResponse listCertificates(ListCertificatesRequest request) {
    return listCertificatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Certificates][google.cloud.security.privateca.v1beta1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificatesRequest request =
   *       ListCertificatesRequest.newBuilder()
   *           .setParent(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Certificate> future =
   *       certificateAuthorityServiceClient.listCertificatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Certificate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCertificatesRequest, ListCertificatesPagedResponse>
      listCertificatesPagedCallable() {
    return stub.listCertificatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Certificates][google.cloud.security.privateca.v1beta1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   while (true) {
   *     ListCertificatesResponse response =
   *         certificateAuthorityServiceClient.listCertificatesCallable().call(request);
   *     for (Certificate element : response.getResponsesList()) {
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
  public final UnaryCallable<ListCertificatesRequest, ListCertificatesResponse>
      listCertificatesCallable() {
    return stub.listCertificatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revoke a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateName name =
   *       CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");
   *   Certificate response = certificateAuthorityServiceClient.revokeCertificate(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [Certificate][google.cloud.security.privateca.v1beta1.Certificate] in the format
   *     `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;/certificates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate revokeCertificate(CertificateName name) {
    RevokeCertificateRequest request =
        RevokeCertificateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return revokeCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revoke a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
   *           .toString();
   *   Certificate response = certificateAuthorityServiceClient.revokeCertificate(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [Certificate][google.cloud.security.privateca.v1beta1.Certificate] in the format
   *     `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;/certificates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate revokeCertificate(String name) {
    RevokeCertificateRequest request = RevokeCertificateRequest.newBuilder().setName(name).build();
    return revokeCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revoke a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   RevokeCertificateRequest request =
   *       RevokeCertificateRequest.newBuilder()
   *           .setName(
   *               CertificateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
   *                   .toString())
   *           .setReason(RevocationReason.forNumber(0))
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Certificate response = certificateAuthorityServiceClient.revokeCertificate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate revokeCertificate(RevokeCertificateRequest request) {
    return revokeCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revoke a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   RevokeCertificateRequest request =
   *       RevokeCertificateRequest.newBuilder()
   *           .setName(
   *               CertificateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
   *                   .toString())
   *           .setReason(RevocationReason.forNumber(0))
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Certificate> future =
   *       certificateAuthorityServiceClient.revokeCertificateCallable().futureCall(request);
   *   // Do something.
   *   Certificate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RevokeCertificateRequest, Certificate> revokeCertificateCallable() {
    return stub.revokeCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [Certificate][google.cloud.security.privateca.v1beta1.Certificate]. Currently, the
   * only field you can update is the
   * [labels][google.cloud.security.privateca.v1beta1.Certificate.labels] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   Certificate certificate = Certificate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Certificate response =
   *       certificateAuthorityServiceClient.updateCertificate(certificate, updateMask);
   * }
   * }</pre>
   *
   * @param certificate Required. [Certificate][google.cloud.security.privateca.v1beta1.Certificate]
   *     with updated values.
   * @param updateMask Required. A list of fields to be updated in this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate updateCertificate(Certificate certificate, FieldMask updateMask) {
    UpdateCertificateRequest request =
        UpdateCertificateRequest.newBuilder()
            .setCertificate(certificate)
            .setUpdateMask(updateMask)
            .build();
    return updateCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [Certificate][google.cloud.security.privateca.v1beta1.Certificate]. Currently, the
   * only field you can update is the
   * [labels][google.cloud.security.privateca.v1beta1.Certificate.labels] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCertificateRequest request =
   *       UpdateCertificateRequest.newBuilder()
   *           .setCertificate(Certificate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Certificate response = certificateAuthorityServiceClient.updateCertificate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate updateCertificate(UpdateCertificateRequest request) {
    return updateCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [Certificate][google.cloud.security.privateca.v1beta1.Certificate]. Currently, the
   * only field you can update is the
   * [labels][google.cloud.security.privateca.v1beta1.Certificate.labels] field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCertificateRequest request =
   *       UpdateCertificateRequest.newBuilder()
   *           .setCertificate(Certificate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Certificate> future =
   *       certificateAuthorityServiceClient.updateCertificateCallable().futureCall(request);
   *   // Do something.
   *   Certificate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCertificateRequest, Certificate> updateCertificateCallable() {
    return stub.updateCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activate a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * that is in state
   * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE].
   * After the parent Certificate Authority signs a certificate signing request from
   * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.FetchCertificateAuthorityCsr],
   * this method can complete the activation process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.activateCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      activateCertificateAuthorityAsync(CertificateAuthorityName name) {
    ActivateCertificateAuthorityRequest request =
        ActivateCertificateAuthorityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return activateCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activate a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * that is in state
   * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE].
   * After the parent Certificate Authority signs a certificate signing request from
   * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.FetchCertificateAuthorityCsr],
   * this method can complete the activation process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.activateCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      activateCertificateAuthorityAsync(String name) {
    ActivateCertificateAuthorityRequest request =
        ActivateCertificateAuthorityRequest.newBuilder().setName(name).build();
    return activateCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activate a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * that is in state
   * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE].
   * After the parent Certificate Authority signs a certificate signing request from
   * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.FetchCertificateAuthorityCsr],
   * this method can complete the activation process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ActivateCertificateAuthorityRequest request =
   *       ActivateCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setPemCaCertificate("pemCaCertificate2100567073")
   *           .setSubordinateConfig(SubordinateConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.activateCertificateAuthorityAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      activateCertificateAuthorityAsync(ActivateCertificateAuthorityRequest request) {
    return activateCertificateAuthorityOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activate a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * that is in state
   * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE].
   * After the parent Certificate Authority signs a certificate signing request from
   * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.FetchCertificateAuthorityCsr],
   * this method can complete the activation process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ActivateCertificateAuthorityRequest request =
   *       ActivateCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setPemCaCertificate("pemCaCertificate2100567073")
   *           .setSubordinateConfig(SubordinateConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CertificateAuthority, OperationMetadata> future =
   *       certificateAuthorityServiceClient
   *           .activateCertificateAuthorityOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ActivateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      activateCertificateAuthorityOperationCallable() {
    return stub.activateCertificateAuthorityOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activate a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * that is in state
   * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE].
   * After the parent Certificate Authority signs a certificate signing request from
   * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.FetchCertificateAuthorityCsr],
   * this method can complete the activation process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ActivateCertificateAuthorityRequest request =
   *       ActivateCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setPemCaCertificate("pemCaCertificate2100567073")
   *           .setSubordinateConfig(SubordinateConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient
   *           .activateCertificateAuthorityCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ActivateCertificateAuthorityRequest, Operation>
      activateCertificateAuthorityCallable() {
    return stub.activateCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in a given
   * Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CertificateAuthority certificateAuthority = CertificateAuthority.newBuilder().build();
   *   String certificateAuthorityId = "certificateAuthorityId-1652580953";
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient
   *           .createCertificateAuthorityAsync(parent, certificateAuthority, certificateAuthorityId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CertificateAuthorities][google.cloud.security.privateca.v1beta1.CertificateAuthority], in
   *     the format `projects/&#42;/locations/&#42;`.
   * @param certificateAuthority Required. A
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] with
   *     initial field values.
   * @param certificateAuthorityId Required. It must be unique within a location and match the
   *     regular expression `[a-zA-Z0-9_-]{1,63}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      createCertificateAuthorityAsync(
          LocationName parent,
          CertificateAuthority certificateAuthority,
          String certificateAuthorityId) {
    CreateCertificateAuthorityRequest request =
        CreateCertificateAuthorityRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCertificateAuthority(certificateAuthority)
            .setCertificateAuthorityId(certificateAuthorityId)
            .build();
    return createCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in a given
   * Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CertificateAuthority certificateAuthority = CertificateAuthority.newBuilder().build();
   *   String certificateAuthorityId = "certificateAuthorityId-1652580953";
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient
   *           .createCertificateAuthorityAsync(parent, certificateAuthority, certificateAuthorityId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CertificateAuthorities][google.cloud.security.privateca.v1beta1.CertificateAuthority], in
   *     the format `projects/&#42;/locations/&#42;`.
   * @param certificateAuthority Required. A
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] with
   *     initial field values.
   * @param certificateAuthorityId Required. It must be unique within a location and match the
   *     regular expression `[a-zA-Z0-9_-]{1,63}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      createCertificateAuthorityAsync(
          String parent, CertificateAuthority certificateAuthority, String certificateAuthorityId) {
    CreateCertificateAuthorityRequest request =
        CreateCertificateAuthorityRequest.newBuilder()
            .setParent(parent)
            .setCertificateAuthority(certificateAuthority)
            .setCertificateAuthorityId(certificateAuthorityId)
            .build();
    return createCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in a given
   * Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCertificateAuthorityRequest request =
   *       CreateCertificateAuthorityRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateAuthorityId("certificateAuthorityId-1652580953")
   *           .setCertificateAuthority(CertificateAuthority.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.createCertificateAuthorityAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      createCertificateAuthorityAsync(CreateCertificateAuthorityRequest request) {
    return createCertificateAuthorityOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in a given
   * Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCertificateAuthorityRequest request =
   *       CreateCertificateAuthorityRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateAuthorityId("certificateAuthorityId-1652580953")
   *           .setCertificateAuthority(CertificateAuthority.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CertificateAuthority, OperationMetadata> future =
   *       certificateAuthorityServiceClient
   *           .createCertificateAuthorityOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      createCertificateAuthorityOperationCallable() {
    return stub.createCertificateAuthorityOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in a given
   * Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCertificateAuthorityRequest request =
   *       CreateCertificateAuthorityRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateAuthorityId("certificateAuthorityId-1652580953")
   *           .setCertificateAuthority(CertificateAuthority.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient
   *           .createCertificateAuthorityCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCertificateAuthorityRequest, Operation>
      createCertificateAuthorityCallable() {
    return stub.createCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.disableCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      disableCertificateAuthorityAsync(CertificateAuthorityName name) {
    DisableCertificateAuthorityRequest request =
        DisableCertificateAuthorityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return disableCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.disableCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      disableCertificateAuthorityAsync(String name) {
    DisableCertificateAuthorityRequest request =
        DisableCertificateAuthorityRequest.newBuilder().setName(name).build();
    return disableCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DisableCertificateAuthorityRequest request =
   *       DisableCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.disableCertificateAuthorityAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      disableCertificateAuthorityAsync(DisableCertificateAuthorityRequest request) {
    return disableCertificateAuthorityOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DisableCertificateAuthorityRequest request =
   *       DisableCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CertificateAuthority, OperationMetadata> future =
   *       certificateAuthorityServiceClient
   *           .disableCertificateAuthorityOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DisableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      disableCertificateAuthorityOperationCallable() {
    return stub.disableCertificateAuthorityOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DisableCertificateAuthorityRequest request =
   *       DisableCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient
   *           .disableCertificateAuthorityCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableCertificateAuthorityRequest, Operation>
      disableCertificateAuthorityCallable() {
    return stub.disableCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.enableCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      enableCertificateAuthorityAsync(CertificateAuthorityName name) {
    EnableCertificateAuthorityRequest request =
        EnableCertificateAuthorityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return enableCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.enableCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      enableCertificateAuthorityAsync(String name) {
    EnableCertificateAuthorityRequest request =
        EnableCertificateAuthorityRequest.newBuilder().setName(name).build();
    return enableCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   EnableCertificateAuthorityRequest request =
   *       EnableCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.enableCertificateAuthorityAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      enableCertificateAuthorityAsync(EnableCertificateAuthorityRequest request) {
    return enableCertificateAuthorityOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   EnableCertificateAuthorityRequest request =
   *       EnableCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CertificateAuthority, OperationMetadata> future =
   *       certificateAuthorityServiceClient
   *           .enableCertificateAuthorityOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          EnableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      enableCertificateAuthorityOperationCallable() {
    return stub.enableCertificateAuthorityOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   EnableCertificateAuthorityRequest request =
   *       EnableCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient
   *           .enableCertificateAuthorityCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnableCertificateAuthorityRequest, Operation>
      enableCertificateAuthorityCallable() {
    return stub.enableCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch a certificate signing request (CSR) from a
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] that is in
   * state
   * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE].
   * The CSR must then be signed by the desired parent Certificate Authority, which could be another
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] resource,
   * or could be an on-prem certificate authority. See also
   * [ActivateCertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.ActivateCertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
   *   FetchCertificateAuthorityCsrResponse response =
   *       certificateAuthorityServiceClient.fetchCertificateAuthorityCsr(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchCertificateAuthorityCsrResponse fetchCertificateAuthorityCsr(
      CertificateAuthorityName name) {
    FetchCertificateAuthorityCsrRequest request =
        FetchCertificateAuthorityCsrRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return fetchCertificateAuthorityCsr(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch a certificate signing request (CSR) from a
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] that is in
   * state
   * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE].
   * The CSR must then be signed by the desired parent Certificate Authority, which could be another
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] resource,
   * or could be an on-prem certificate authority. See also
   * [ActivateCertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.ActivateCertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   FetchCertificateAuthorityCsrResponse response =
   *       certificateAuthorityServiceClient.fetchCertificateAuthorityCsr(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchCertificateAuthorityCsrResponse fetchCertificateAuthorityCsr(String name) {
    FetchCertificateAuthorityCsrRequest request =
        FetchCertificateAuthorityCsrRequest.newBuilder().setName(name).build();
    return fetchCertificateAuthorityCsr(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch a certificate signing request (CSR) from a
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] that is in
   * state
   * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE].
   * The CSR must then be signed by the desired parent Certificate Authority, which could be another
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] resource,
   * or could be an on-prem certificate authority. See also
   * [ActivateCertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.ActivateCertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   FetchCertificateAuthorityCsrRequest request =
   *       FetchCertificateAuthorityCsrRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .build();
   *   FetchCertificateAuthorityCsrResponse response =
   *       certificateAuthorityServiceClient.fetchCertificateAuthorityCsr(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchCertificateAuthorityCsrResponse fetchCertificateAuthorityCsr(
      FetchCertificateAuthorityCsrRequest request) {
    return fetchCertificateAuthorityCsrCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch a certificate signing request (CSR) from a
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] that is in
   * state
   * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE].
   * The CSR must then be signed by the desired parent Certificate Authority, which could be another
   * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] resource,
   * or could be an on-prem certificate authority. See also
   * [ActivateCertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.ActivateCertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   FetchCertificateAuthorityCsrRequest request =
   *       FetchCertificateAuthorityCsrRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FetchCertificateAuthorityCsrResponse> future =
   *       certificateAuthorityServiceClient
   *           .fetchCertificateAuthorityCsrCallable()
   *           .futureCall(request);
   *   // Do something.
   *   FetchCertificateAuthorityCsrResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
      fetchCertificateAuthorityCsrCallable() {
    return stub.fetchCertificateAuthorityCsrCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.getCertificateAuthority(name);
   * }
   * }</pre>
   *
   * @param name Required. The
   *     [name][google.cloud.security.privateca.v1beta1.CertificateAuthority.name] of the
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] to
   *     get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateAuthority getCertificateAuthority(CertificateAuthorityName name) {
    GetCertificateAuthorityRequest request =
        GetCertificateAuthorityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCertificateAuthority(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.getCertificateAuthority(name);
   * }
   * }</pre>
   *
   * @param name Required. The
   *     [name][google.cloud.security.privateca.v1beta1.CertificateAuthority.name] of the
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] to
   *     get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateAuthority getCertificateAuthority(String name) {
    GetCertificateAuthorityRequest request =
        GetCertificateAuthorityRequest.newBuilder().setName(name).build();
    return getCertificateAuthority(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateAuthorityRequest request =
   *       GetCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .build();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.getCertificateAuthority(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateAuthority getCertificateAuthority(
      GetCertificateAuthorityRequest request) {
    return getCertificateAuthorityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateAuthorityRequest request =
   *       GetCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CertificateAuthority> future =
   *       certificateAuthorityServiceClient.getCertificateAuthorityCallable().futureCall(request);
   *   // Do something.
   *   CertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthorityCallable() {
    return stub.getCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CertificateAuthorities][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CertificateAuthority element :
   *       certificateAuthorityServiceClient.listCertificateAuthorities(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CertificateAuthorities][google.cloud.security.privateca.v1beta1.CertificateAuthority], in
   *     the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateAuthoritiesPagedResponse listCertificateAuthorities(
      LocationName parent) {
    ListCertificateAuthoritiesRequest request =
        ListCertificateAuthoritiesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCertificateAuthorities(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CertificateAuthorities][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CertificateAuthority element :
   *       certificateAuthorityServiceClient.listCertificateAuthorities(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CertificateAuthorities][google.cloud.security.privateca.v1beta1.CertificateAuthority], in
   *     the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateAuthoritiesPagedResponse listCertificateAuthorities(String parent) {
    ListCertificateAuthoritiesRequest request =
        ListCertificateAuthoritiesRequest.newBuilder().setParent(parent).build();
    return listCertificateAuthorities(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CertificateAuthorities][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificateAuthoritiesRequest request =
   *       ListCertificateAuthoritiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CertificateAuthority element :
   *       certificateAuthorityServiceClient.listCertificateAuthorities(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateAuthoritiesPagedResponse listCertificateAuthorities(
      ListCertificateAuthoritiesRequest request) {
    return listCertificateAuthoritiesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CertificateAuthorities][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificateAuthoritiesRequest request =
   *       ListCertificateAuthoritiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CertificateAuthority> future =
   *       certificateAuthorityServiceClient
   *           .listCertificateAuthoritiesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (CertificateAuthority element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesPagedResponse>
      listCertificateAuthoritiesPagedCallable() {
    return stub.listCertificateAuthoritiesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CertificateAuthorities][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   while (true) {
   *     ListCertificateAuthoritiesResponse response =
   *         certificateAuthorityServiceClient.listCertificateAuthoritiesCallable().call(request);
   *     for (CertificateAuthority element : response.getResponsesList()) {
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
  public final UnaryCallable<ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesResponse>
      listCertificateAuthoritiesCallable() {
    return stub.listCertificateAuthoritiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * that is scheduled for deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.restoreCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      restoreCertificateAuthorityAsync(CertificateAuthorityName name) {
    RestoreCertificateAuthorityRequest request =
        RestoreCertificateAuthorityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return restoreCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * that is scheduled for deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.restoreCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      restoreCertificateAuthorityAsync(String name) {
    RestoreCertificateAuthorityRequest request =
        RestoreCertificateAuthorityRequest.newBuilder().setName(name).build();
    return restoreCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * that is scheduled for deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   RestoreCertificateAuthorityRequest request =
   *       RestoreCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.restoreCertificateAuthorityAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      restoreCertificateAuthorityAsync(RestoreCertificateAuthorityRequest request) {
    return restoreCertificateAuthorityOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * that is scheduled for deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   RestoreCertificateAuthorityRequest request =
   *       RestoreCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CertificateAuthority, OperationMetadata> future =
   *       certificateAuthorityServiceClient
   *           .restoreCertificateAuthorityOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RestoreCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      restoreCertificateAuthorityOperationCallable() {
    return stub.restoreCertificateAuthorityOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * that is scheduled for deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   RestoreCertificateAuthorityRequest request =
   *       RestoreCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient
   *           .restoreCertificateAuthorityCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestoreCertificateAuthorityRequest, Operation>
      restoreCertificateAuthorityCallable() {
    return stub.restoreCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedule a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * for deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.scheduleDeleteCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      scheduleDeleteCertificateAuthorityAsync(CertificateAuthorityName name) {
    ScheduleDeleteCertificateAuthorityRequest request =
        ScheduleDeleteCertificateAuthorityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return scheduleDeleteCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedule a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * for deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.scheduleDeleteCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      scheduleDeleteCertificateAuthorityAsync(String name) {
    ScheduleDeleteCertificateAuthorityRequest request =
        ScheduleDeleteCertificateAuthorityRequest.newBuilder().setName(name).build();
    return scheduleDeleteCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedule a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * for deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ScheduleDeleteCertificateAuthorityRequest request =
   *       ScheduleDeleteCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.scheduleDeleteCertificateAuthorityAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      scheduleDeleteCertificateAuthorityAsync(ScheduleDeleteCertificateAuthorityRequest request) {
    return scheduleDeleteCertificateAuthorityOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedule a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * for deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ScheduleDeleteCertificateAuthorityRequest request =
   *       ScheduleDeleteCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CertificateAuthority, OperationMetadata> future =
   *       certificateAuthorityServiceClient
   *           .scheduleDeleteCertificateAuthorityOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ScheduleDeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      scheduleDeleteCertificateAuthorityOperationCallable() {
    return stub.scheduleDeleteCertificateAuthorityOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Schedule a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
   * for deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ScheduleDeleteCertificateAuthorityRequest request =
   *       ScheduleDeleteCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient
   *           .scheduleDeleteCertificateAuthorityCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ScheduleDeleteCertificateAuthorityRequest, Operation>
      scheduleDeleteCertificateAuthorityCallable() {
    return stub.scheduleDeleteCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthority certificateAuthority = CertificateAuthority.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient
   *           .updateCertificateAuthorityAsync(certificateAuthority, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param certificateAuthority Required.
   *     [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] with
   *     updated values.
   * @param updateMask Required. A list of fields to be updated in this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      updateCertificateAuthorityAsync(
          CertificateAuthority certificateAuthority, FieldMask updateMask) {
    UpdateCertificateAuthorityRequest request =
        UpdateCertificateAuthorityRequest.newBuilder()
            .setCertificateAuthority(certificateAuthority)
            .setUpdateMask(updateMask)
            .build();
    return updateCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCertificateAuthorityRequest request =
   *       UpdateCertificateAuthorityRequest.newBuilder()
   *           .setCertificateAuthority(CertificateAuthority.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.updateCertificateAuthorityAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      updateCertificateAuthorityAsync(UpdateCertificateAuthorityRequest request) {
    return updateCertificateAuthorityOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCertificateAuthorityRequest request =
   *       UpdateCertificateAuthorityRequest.newBuilder()
   *           .setCertificateAuthority(CertificateAuthority.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CertificateAuthority, OperationMetadata> future =
   *       certificateAuthorityServiceClient
   *           .updateCertificateAuthorityOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      updateCertificateAuthorityOperationCallable() {
    return stub.updateCertificateAuthorityOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCertificateAuthorityRequest request =
   *       UpdateCertificateAuthorityRequest.newBuilder()
   *           .setCertificateAuthority(CertificateAuthority.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient
   *           .updateCertificateAuthorityCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCertificateAuthorityRequest, Operation>
      updateCertificateAuthorityCallable() {
    return stub.updateCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a
   * [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateRevocationListName name =
   *       CertificateRevocationListName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[CERTIFICATE_AUTHORITY]",
   *           "[CERTIFICATE_REVOCATION_LIST]");
   *   CertificateRevocationList response =
   *       certificateAuthorityServiceClient.getCertificateRevocationList(name);
   * }
   * }</pre>
   *
   * @param name Required. The
   *     [name][google.cloud.security.privateca.v1beta1.CertificateRevocationList.name] of the
   *     [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList]
   *     to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateRevocationList getCertificateRevocationList(
      CertificateRevocationListName name) {
    GetCertificateRevocationListRequest request =
        GetCertificateRevocationListRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCertificateRevocationList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a
   * [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateRevocationListName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[CERTIFICATE_AUTHORITY]",
   *               "[CERTIFICATE_REVOCATION_LIST]")
   *           .toString();
   *   CertificateRevocationList response =
   *       certificateAuthorityServiceClient.getCertificateRevocationList(name);
   * }
   * }</pre>
   *
   * @param name Required. The
   *     [name][google.cloud.security.privateca.v1beta1.CertificateRevocationList.name] of the
   *     [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList]
   *     to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateRevocationList getCertificateRevocationList(String name) {
    GetCertificateRevocationListRequest request =
        GetCertificateRevocationListRequest.newBuilder().setName(name).build();
    return getCertificateRevocationList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a
   * [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateRevocationListRequest request =
   *       GetCertificateRevocationListRequest.newBuilder()
   *           .setName(
   *               CertificateRevocationListName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[CERTIFICATE_AUTHORITY]",
   *                       "[CERTIFICATE_REVOCATION_LIST]")
   *                   .toString())
   *           .build();
   *   CertificateRevocationList response =
   *       certificateAuthorityServiceClient.getCertificateRevocationList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateRevocationList getCertificateRevocationList(
      GetCertificateRevocationListRequest request) {
    return getCertificateRevocationListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a
   * [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateRevocationListRequest request =
   *       GetCertificateRevocationListRequest.newBuilder()
   *           .setName(
   *               CertificateRevocationListName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[CERTIFICATE_AUTHORITY]",
   *                       "[CERTIFICATE_REVOCATION_LIST]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CertificateRevocationList> future =
   *       certificateAuthorityServiceClient
   *           .getCertificateRevocationListCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateRevocationList response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCertificateRevocationListRequest, CertificateRevocationList>
      getCertificateRevocationListCallable() {
    return stub.getCertificateRevocationListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists
   * [CertificateRevocationLists][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName parent =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
   *   for (CertificateRevocationList element :
   *       certificateAuthorityServiceClient.listCertificateRevocationLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CertificateRevocationLists][google.cloud.security.privateca.v1beta1.CertificateRevocationList],
   *     in the format `projects/&#42;/locations/&#42;/certificateauthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateRevocationListsPagedResponse listCertificateRevocationLists(
      CertificateAuthorityName parent) {
    ListCertificateRevocationListsRequest request =
        ListCertificateRevocationListsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCertificateRevocationLists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists
   * [CertificateRevocationLists][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   for (CertificateRevocationList element :
   *       certificateAuthorityServiceClient.listCertificateRevocationLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CertificateRevocationLists][google.cloud.security.privateca.v1beta1.CertificateRevocationList],
   *     in the format `projects/&#42;/locations/&#42;/certificateauthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateRevocationListsPagedResponse listCertificateRevocationLists(
      String parent) {
    ListCertificateRevocationListsRequest request =
        ListCertificateRevocationListsRequest.newBuilder().setParent(parent).build();
    return listCertificateRevocationLists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists
   * [CertificateRevocationLists][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificateRevocationListsRequest request =
   *       ListCertificateRevocationListsRequest.newBuilder()
   *           .setParent(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CertificateRevocationList element :
   *       certificateAuthorityServiceClient.listCertificateRevocationLists(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateRevocationListsPagedResponse listCertificateRevocationLists(
      ListCertificateRevocationListsRequest request) {
    return listCertificateRevocationListsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists
   * [CertificateRevocationLists][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificateRevocationListsRequest request =
   *       ListCertificateRevocationListsRequest.newBuilder()
   *           .setParent(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CertificateRevocationList> future =
   *       certificateAuthorityServiceClient
   *           .listCertificateRevocationListsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (CertificateRevocationList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListCertificateRevocationListsRequest, ListCertificateRevocationListsPagedResponse>
      listCertificateRevocationListsPagedCallable() {
    return stub.listCertificateRevocationListsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists
   * [CertificateRevocationLists][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   while (true) {
   *     ListCertificateRevocationListsResponse response =
   *         certificateAuthorityServiceClient
   *             .listCertificateRevocationListsCallable()
   *             .call(request);
   *     for (CertificateRevocationList element : response.getResponsesList()) {
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
  public final UnaryCallable<
          ListCertificateRevocationListsRequest, ListCertificateRevocationListsResponse>
      listCertificateRevocationListsCallable() {
    return stub.listCertificateRevocationListsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a
   * [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateRevocationList certificateRevocationList =
   *       CertificateRevocationList.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CertificateRevocationList response =
   *       certificateAuthorityServiceClient
   *           .updateCertificateRevocationListAsync(certificateRevocationList, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param certificateRevocationList Required.
   *     [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList]
   *     with updated values.
   * @param updateMask Required. A list of fields to be updated in this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateRevocationList, OperationMetadata>
      updateCertificateRevocationListAsync(
          CertificateRevocationList certificateRevocationList, FieldMask updateMask) {
    UpdateCertificateRevocationListRequest request =
        UpdateCertificateRevocationListRequest.newBuilder()
            .setCertificateRevocationList(certificateRevocationList)
            .setUpdateMask(updateMask)
            .build();
    return updateCertificateRevocationListAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a
   * [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCertificateRevocationListRequest request =
   *       UpdateCertificateRevocationListRequest.newBuilder()
   *           .setCertificateRevocationList(CertificateRevocationList.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CertificateRevocationList response =
   *       certificateAuthorityServiceClient.updateCertificateRevocationListAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateRevocationList, OperationMetadata>
      updateCertificateRevocationListAsync(UpdateCertificateRevocationListRequest request) {
    return updateCertificateRevocationListOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a
   * [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCertificateRevocationListRequest request =
   *       UpdateCertificateRevocationListRequest.newBuilder()
   *           .setCertificateRevocationList(CertificateRevocationList.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CertificateRevocationList, OperationMetadata> future =
   *       certificateAuthorityServiceClient
   *           .updateCertificateRevocationListOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateRevocationList response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateCertificateRevocationListRequest, CertificateRevocationList, OperationMetadata>
      updateCertificateRevocationListOperationCallable() {
    return stub.updateCertificateRevocationListOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a
   * [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCertificateRevocationListRequest request =
   *       UpdateCertificateRevocationListRequest.newBuilder()
   *           .setCertificateRevocationList(CertificateRevocationList.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient
   *           .updateCertificateRevocationListCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCertificateRevocationListRequest, Operation>
      updateCertificateRevocationListCallable() {
    return stub.updateCertificateRevocationListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ReusableConfigName name =
   *       ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]");
   *   ReusableConfig response = certificateAuthorityServiceClient.getReusableConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][ReusableConfigs.name] of the [ReusableConfigs][] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReusableConfig getReusableConfig(ReusableConfigName name) {
    GetReusableConfigRequest request =
        GetReusableConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getReusableConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]").toString();
   *   ReusableConfig response = certificateAuthorityServiceClient.getReusableConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][ReusableConfigs.name] of the [ReusableConfigs][] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReusableConfig getReusableConfig(String name) {
    GetReusableConfigRequest request = GetReusableConfigRequest.newBuilder().setName(name).build();
    return getReusableConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetReusableConfigRequest request =
   *       GetReusableConfigRequest.newBuilder()
   *           .setName(
   *               ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]").toString())
   *           .build();
   *   ReusableConfig response = certificateAuthorityServiceClient.getReusableConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReusableConfig getReusableConfig(GetReusableConfigRequest request) {
    return getReusableConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetReusableConfigRequest request =
   *       GetReusableConfigRequest.newBuilder()
   *           .setName(
   *               ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]").toString())
   *           .build();
   *   ApiFuture<ReusableConfig> future =
   *       certificateAuthorityServiceClient.getReusableConfigCallable().futureCall(request);
   *   // Do something.
   *   ReusableConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReusableConfigRequest, ReusableConfig> getReusableConfigCallable() {
    return stub.getReusableConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ReusableConfigs][google.cloud.security.privateca.v1beta1.ReusableConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ReusableConfig element :
   *       certificateAuthorityServiceClient.listReusableConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [ReusableConfigs][google.cloud.security.privateca.v1beta1.ReusableConfig], in the format
   *     `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReusableConfigsPagedResponse listReusableConfigs(LocationName parent) {
    ListReusableConfigsRequest request =
        ListReusableConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReusableConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ReusableConfigs][google.cloud.security.privateca.v1beta1.ReusableConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ReusableConfig element :
   *       certificateAuthorityServiceClient.listReusableConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [ReusableConfigs][google.cloud.security.privateca.v1beta1.ReusableConfig], in the format
   *     `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReusableConfigsPagedResponse listReusableConfigs(String parent) {
    ListReusableConfigsRequest request =
        ListReusableConfigsRequest.newBuilder().setParent(parent).build();
    return listReusableConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ReusableConfigs][google.cloud.security.privateca.v1beta1.ReusableConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListReusableConfigsRequest request =
   *       ListReusableConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ReusableConfig element :
   *       certificateAuthorityServiceClient.listReusableConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReusableConfigsPagedResponse listReusableConfigs(
      ListReusableConfigsRequest request) {
    return listReusableConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ReusableConfigs][google.cloud.security.privateca.v1beta1.ReusableConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListReusableConfigsRequest request =
   *       ListReusableConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ReusableConfig> future =
   *       certificateAuthorityServiceClient.listReusableConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReusableConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReusableConfigsRequest, ListReusableConfigsPagedResponse>
      listReusableConfigsPagedCallable() {
    return stub.listReusableConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ReusableConfigs][google.cloud.security.privateca.v1beta1.ReusableConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   while (true) {
   *     ListReusableConfigsResponse response =
   *         certificateAuthorityServiceClient.listReusableConfigsCallable().call(request);
   *     for (ReusableConfig element : response.getResponsesList()) {
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
  public final UnaryCallable<ListReusableConfigsRequest, ListReusableConfigsResponse>
      listReusableConfigsCallable() {
    return stub.listReusableConfigsCallable();
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

  public static class ListCertificatesPagedResponse
      extends AbstractPagedListResponse<
          ListCertificatesRequest,
          ListCertificatesResponse,
          Certificate,
          ListCertificatesPage,
          ListCertificatesFixedSizeCollection> {

    public static ApiFuture<ListCertificatesPagedResponse> createAsync(
        PageContext<ListCertificatesRequest, ListCertificatesResponse, Certificate> context,
        ApiFuture<ListCertificatesResponse> futureResponse) {
      ApiFuture<ListCertificatesPage> futurePage =
          ListCertificatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListCertificatesPage, ListCertificatesPagedResponse>() {
            @Override
            public ListCertificatesPagedResponse apply(ListCertificatesPage input) {
              return new ListCertificatesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListCertificatesPagedResponse(ListCertificatesPage page) {
      super(page, ListCertificatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCertificatesPage
      extends AbstractPage<
          ListCertificatesRequest, ListCertificatesResponse, Certificate, ListCertificatesPage> {

    private ListCertificatesPage(
        PageContext<ListCertificatesRequest, ListCertificatesResponse, Certificate> context,
        ListCertificatesResponse response) {
      super(context, response);
    }

    private static ListCertificatesPage createEmptyPage() {
      return new ListCertificatesPage(null, null);
    }

    @Override
    protected ListCertificatesPage createPage(
        PageContext<ListCertificatesRequest, ListCertificatesResponse, Certificate> context,
        ListCertificatesResponse response) {
      return new ListCertificatesPage(context, response);
    }

    @Override
    public ApiFuture<ListCertificatesPage> createPageAsync(
        PageContext<ListCertificatesRequest, ListCertificatesResponse, Certificate> context,
        ApiFuture<ListCertificatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCertificatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCertificatesRequest,
          ListCertificatesResponse,
          Certificate,
          ListCertificatesPage,
          ListCertificatesFixedSizeCollection> {

    private ListCertificatesFixedSizeCollection(
        List<ListCertificatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCertificatesFixedSizeCollection createEmptyCollection() {
      return new ListCertificatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCertificatesFixedSizeCollection createCollection(
        List<ListCertificatesPage> pages, int collectionSize) {
      return new ListCertificatesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCertificateAuthoritiesPagedResponse
      extends AbstractPagedListResponse<
          ListCertificateAuthoritiesRequest,
          ListCertificateAuthoritiesResponse,
          CertificateAuthority,
          ListCertificateAuthoritiesPage,
          ListCertificateAuthoritiesFixedSizeCollection> {

    public static ApiFuture<ListCertificateAuthoritiesPagedResponse> createAsync(
        PageContext<
                ListCertificateAuthoritiesRequest,
                ListCertificateAuthoritiesResponse,
                CertificateAuthority>
            context,
        ApiFuture<ListCertificateAuthoritiesResponse> futureResponse) {
      ApiFuture<ListCertificateAuthoritiesPage> futurePage =
          ListCertificateAuthoritiesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListCertificateAuthoritiesPage, ListCertificateAuthoritiesPagedResponse>() {
            @Override
            public ListCertificateAuthoritiesPagedResponse apply(
                ListCertificateAuthoritiesPage input) {
              return new ListCertificateAuthoritiesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListCertificateAuthoritiesPagedResponse(ListCertificateAuthoritiesPage page) {
      super(page, ListCertificateAuthoritiesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCertificateAuthoritiesPage
      extends AbstractPage<
          ListCertificateAuthoritiesRequest,
          ListCertificateAuthoritiesResponse,
          CertificateAuthority,
          ListCertificateAuthoritiesPage> {

    private ListCertificateAuthoritiesPage(
        PageContext<
                ListCertificateAuthoritiesRequest,
                ListCertificateAuthoritiesResponse,
                CertificateAuthority>
            context,
        ListCertificateAuthoritiesResponse response) {
      super(context, response);
    }

    private static ListCertificateAuthoritiesPage createEmptyPage() {
      return new ListCertificateAuthoritiesPage(null, null);
    }

    @Override
    protected ListCertificateAuthoritiesPage createPage(
        PageContext<
                ListCertificateAuthoritiesRequest,
                ListCertificateAuthoritiesResponse,
                CertificateAuthority>
            context,
        ListCertificateAuthoritiesResponse response) {
      return new ListCertificateAuthoritiesPage(context, response);
    }

    @Override
    public ApiFuture<ListCertificateAuthoritiesPage> createPageAsync(
        PageContext<
                ListCertificateAuthoritiesRequest,
                ListCertificateAuthoritiesResponse,
                CertificateAuthority>
            context,
        ApiFuture<ListCertificateAuthoritiesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCertificateAuthoritiesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCertificateAuthoritiesRequest,
          ListCertificateAuthoritiesResponse,
          CertificateAuthority,
          ListCertificateAuthoritiesPage,
          ListCertificateAuthoritiesFixedSizeCollection> {

    private ListCertificateAuthoritiesFixedSizeCollection(
        List<ListCertificateAuthoritiesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCertificateAuthoritiesFixedSizeCollection createEmptyCollection() {
      return new ListCertificateAuthoritiesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCertificateAuthoritiesFixedSizeCollection createCollection(
        List<ListCertificateAuthoritiesPage> pages, int collectionSize) {
      return new ListCertificateAuthoritiesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCertificateRevocationListsPagedResponse
      extends AbstractPagedListResponse<
          ListCertificateRevocationListsRequest,
          ListCertificateRevocationListsResponse,
          CertificateRevocationList,
          ListCertificateRevocationListsPage,
          ListCertificateRevocationListsFixedSizeCollection> {

    public static ApiFuture<ListCertificateRevocationListsPagedResponse> createAsync(
        PageContext<
                ListCertificateRevocationListsRequest,
                ListCertificateRevocationListsResponse,
                CertificateRevocationList>
            context,
        ApiFuture<ListCertificateRevocationListsResponse> futureResponse) {
      ApiFuture<ListCertificateRevocationListsPage> futurePage =
          ListCertificateRevocationListsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListCertificateRevocationListsPage, ListCertificateRevocationListsPagedResponse>() {
            @Override
            public ListCertificateRevocationListsPagedResponse apply(
                ListCertificateRevocationListsPage input) {
              return new ListCertificateRevocationListsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListCertificateRevocationListsPagedResponse(ListCertificateRevocationListsPage page) {
      super(page, ListCertificateRevocationListsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCertificateRevocationListsPage
      extends AbstractPage<
          ListCertificateRevocationListsRequest,
          ListCertificateRevocationListsResponse,
          CertificateRevocationList,
          ListCertificateRevocationListsPage> {

    private ListCertificateRevocationListsPage(
        PageContext<
                ListCertificateRevocationListsRequest,
                ListCertificateRevocationListsResponse,
                CertificateRevocationList>
            context,
        ListCertificateRevocationListsResponse response) {
      super(context, response);
    }

    private static ListCertificateRevocationListsPage createEmptyPage() {
      return new ListCertificateRevocationListsPage(null, null);
    }

    @Override
    protected ListCertificateRevocationListsPage createPage(
        PageContext<
                ListCertificateRevocationListsRequest,
                ListCertificateRevocationListsResponse,
                CertificateRevocationList>
            context,
        ListCertificateRevocationListsResponse response) {
      return new ListCertificateRevocationListsPage(context, response);
    }

    @Override
    public ApiFuture<ListCertificateRevocationListsPage> createPageAsync(
        PageContext<
                ListCertificateRevocationListsRequest,
                ListCertificateRevocationListsResponse,
                CertificateRevocationList>
            context,
        ApiFuture<ListCertificateRevocationListsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCertificateRevocationListsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCertificateRevocationListsRequest,
          ListCertificateRevocationListsResponse,
          CertificateRevocationList,
          ListCertificateRevocationListsPage,
          ListCertificateRevocationListsFixedSizeCollection> {

    private ListCertificateRevocationListsFixedSizeCollection(
        List<ListCertificateRevocationListsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCertificateRevocationListsFixedSizeCollection createEmptyCollection() {
      return new ListCertificateRevocationListsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCertificateRevocationListsFixedSizeCollection createCollection(
        List<ListCertificateRevocationListsPage> pages, int collectionSize) {
      return new ListCertificateRevocationListsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReusableConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListReusableConfigsRequest,
          ListReusableConfigsResponse,
          ReusableConfig,
          ListReusableConfigsPage,
          ListReusableConfigsFixedSizeCollection> {

    public static ApiFuture<ListReusableConfigsPagedResponse> createAsync(
        PageContext<ListReusableConfigsRequest, ListReusableConfigsResponse, ReusableConfig>
            context,
        ApiFuture<ListReusableConfigsResponse> futureResponse) {
      ApiFuture<ListReusableConfigsPage> futurePage =
          ListReusableConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListReusableConfigsPage, ListReusableConfigsPagedResponse>() {
            @Override
            public ListReusableConfigsPagedResponse apply(ListReusableConfigsPage input) {
              return new ListReusableConfigsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListReusableConfigsPagedResponse(ListReusableConfigsPage page) {
      super(page, ListReusableConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReusableConfigsPage
      extends AbstractPage<
          ListReusableConfigsRequest,
          ListReusableConfigsResponse,
          ReusableConfig,
          ListReusableConfigsPage> {

    private ListReusableConfigsPage(
        PageContext<ListReusableConfigsRequest, ListReusableConfigsResponse, ReusableConfig>
            context,
        ListReusableConfigsResponse response) {
      super(context, response);
    }

    private static ListReusableConfigsPage createEmptyPage() {
      return new ListReusableConfigsPage(null, null);
    }

    @Override
    protected ListReusableConfigsPage createPage(
        PageContext<ListReusableConfigsRequest, ListReusableConfigsResponse, ReusableConfig>
            context,
        ListReusableConfigsResponse response) {
      return new ListReusableConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListReusableConfigsPage> createPageAsync(
        PageContext<ListReusableConfigsRequest, ListReusableConfigsResponse, ReusableConfig>
            context,
        ApiFuture<ListReusableConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReusableConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReusableConfigsRequest,
          ListReusableConfigsResponse,
          ReusableConfig,
          ListReusableConfigsPage,
          ListReusableConfigsFixedSizeCollection> {

    private ListReusableConfigsFixedSizeCollection(
        List<ListReusableConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReusableConfigsFixedSizeCollection createEmptyCollection() {
      return new ListReusableConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReusableConfigsFixedSizeCollection createCollection(
        List<ListReusableConfigsPage> pages, int collectionSize) {
      return new ListReusableConfigsFixedSizeCollection(pages, collectionSize);
    }
  }
}
