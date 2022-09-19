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

package com.google.cloud.security.privateca.v1;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.security.privateca.v1.stub.CertificateAuthorityServiceStub;
import com.google.cloud.security.privateca.v1.stub.CertificateAuthorityServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: [Certificate Authority
 * Service][google.cloud.security.privateca.v1.CertificateAuthorityService] manages private
 * certificate authorities and issued certificates.
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
 * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
 *     CertificateAuthorityServiceClient.create()) {
 *   CaPoolName parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CertificateAuthorityServiceSettings certificateAuthorityServiceSettings =
 *     CertificateAuthorityServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CertificateAuthorityServiceClient certificateAuthorityServiceClient =
 *     CertificateAuthorityServiceClient.create(certificateAuthorityServiceSettings);
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
 * CertificateAuthorityServiceSettings certificateAuthorityServiceSettings =
 *     CertificateAuthorityServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             CertificateAuthorityServiceSettings.defaultHttpJsonTransportProviderBuilder()
 *                 .build())
 *         .build();
 * CertificateAuthorityServiceClient certificateAuthorityServiceClient =
 *     CertificateAuthorityServiceClient.create(certificateAuthorityServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CertificateAuthorityServiceClient implements BackgroundResource {
  private final CertificateAuthorityServiceSettings settings;
  private final CertificateAuthorityServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

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
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CertificateAuthorityServiceClient(CertificateAuthorityServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final CertificateAuthorityServiceSettings getSettings() {
    return settings;
  }

  public CertificateAuthorityServiceStub getStub() {
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
   * Create a new [Certificate][google.cloud.security.privateca.v1.Certificate] in a given Project,
   * Location from a particular [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CaPoolName parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
   *   Certificate certificate = Certificate.newBuilder().build();
   *   String certificateId = "certificateId-644529902";
   *   Certificate response =
   *       certificateAuthorityServiceClient.createCertificate(parent, certificate, certificateId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the
   *     [CaPool][google.cloud.security.privateca.v1.CaPool] associated with the
   *     [Certificate][google.cloud.security.privateca.v1.Certificate], in the format
   *     `projects/&#42;/locations/&#42;/caPools/&#42;`.
   * @param certificate Required. A [Certificate][google.cloud.security.privateca.v1.Certificate]
   *     with initial field values.
   * @param certificateId Optional. It must be unique within a location and match the regular
   *     expression `[a-zA-Z0-9_-]{1,63}`. This field is required when using a
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     Enterprise [CertificateAuthority.Tier][], but is optional and its value is ignored
   *     otherwise.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate createCertificate(
      CaPoolName parent, Certificate certificate, String certificateId) {
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
   * Create a new [Certificate][google.cloud.security.privateca.v1.Certificate] in a given Project,
   * Location from a particular [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString();
   *   Certificate certificate = Certificate.newBuilder().build();
   *   String certificateId = "certificateId-644529902";
   *   Certificate response =
   *       certificateAuthorityServiceClient.createCertificate(parent, certificate, certificateId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the
   *     [CaPool][google.cloud.security.privateca.v1.CaPool] associated with the
   *     [Certificate][google.cloud.security.privateca.v1.Certificate], in the format
   *     `projects/&#42;/locations/&#42;/caPools/&#42;`.
   * @param certificate Required. A [Certificate][google.cloud.security.privateca.v1.Certificate]
   *     with initial field values.
   * @param certificateId Optional. It must be unique within a location and match the regular
   *     expression `[a-zA-Z0-9_-]{1,63}`. This field is required when using a
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     Enterprise [CertificateAuthority.Tier][], but is optional and its value is ignored
   *     otherwise.
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
   * Create a new [Certificate][google.cloud.security.privateca.v1.Certificate] in a given Project,
   * Location from a particular [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCertificateRequest request =
   *       CreateCertificateRequest.newBuilder()
   *           .setParent(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .setCertificateId("certificateId-644529902")
   *           .setCertificate(Certificate.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setIssuingCertificateAuthorityId("issuingCertificateAuthorityId-559908707")
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
   * Create a new [Certificate][google.cloud.security.privateca.v1.Certificate] in a given Project,
   * Location from a particular [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCertificateRequest request =
   *       CreateCertificateRequest.newBuilder()
   *           .setParent(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .setCertificateId("certificateId-644529902")
   *           .setCertificate(Certificate.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setIssuingCertificateAuthorityId("issuingCertificateAuthorityId-559908707")
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
   * Returns a [Certificate][google.cloud.security.privateca.v1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateName name =
   *       CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]");
   *   Certificate response = certificateAuthorityServiceClient.getCertificate(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.security.privateca.v1.Certificate.name] of the
   *     [Certificate][google.cloud.security.privateca.v1.Certificate] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate getCertificate(CertificateName name) {
    GetCertificateRequest request =
        GetCertificateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [Certificate][google.cloud.security.privateca.v1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]").toString();
   *   Certificate response = certificateAuthorityServiceClient.getCertificate(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.security.privateca.v1.Certificate.name] of the
   *     [Certificate][google.cloud.security.privateca.v1.Certificate] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate getCertificate(String name) {
    GetCertificateRequest request = GetCertificateRequest.newBuilder().setName(name).build();
    return getCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [Certificate][google.cloud.security.privateca.v1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateRequest request =
   *       GetCertificateRequest.newBuilder()
   *           .setName(
   *               CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]")
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
   * Returns a [Certificate][google.cloud.security.privateca.v1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateRequest request =
   *       GetCertificateRequest.newBuilder()
   *           .setName(
   *               CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]")
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
   * Lists [Certificates][google.cloud.security.privateca.v1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CaPoolName parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
   *   for (Certificate element :
   *       certificateAuthorityServiceClient.listCertificates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [Certificates][google.cloud.security.privateca.v1.Certificate], in the format
   *     `projects/&#42;/locations/&#42;/caPools/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificatesPagedResponse listCertificates(CaPoolName parent) {
    ListCertificatesRequest request =
        ListCertificatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCertificates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Certificates][google.cloud.security.privateca.v1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString();
   *   for (Certificate element :
   *       certificateAuthorityServiceClient.listCertificates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [Certificates][google.cloud.security.privateca.v1.Certificate], in the format
   *     `projects/&#42;/locations/&#42;/caPools/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificatesPagedResponse listCertificates(String parent) {
    ListCertificatesRequest request =
        ListCertificatesRequest.newBuilder().setParent(parent).build();
    return listCertificates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Certificates][google.cloud.security.privateca.v1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificatesRequest request =
   *       ListCertificatesRequest.newBuilder()
   *           .setParent(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
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
   * Lists [Certificates][google.cloud.security.privateca.v1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificatesRequest request =
   *       ListCertificatesRequest.newBuilder()
   *           .setParent(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
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
   * Lists [Certificates][google.cloud.security.privateca.v1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificatesRequest request =
   *       ListCertificatesRequest.newBuilder()
   *           .setParent(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCertificatesResponse response =
   *         certificateAuthorityServiceClient.listCertificatesCallable().call(request);
   *     for (Certificate element : response.getCertificatesList()) {
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
   * Revoke a [Certificate][google.cloud.security.privateca.v1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateName name =
   *       CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]");
   *   Certificate response = certificateAuthorityServiceClient.revokeCertificate(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [Certificate][google.cloud.security.privateca.v1.Certificate] in the format
   *     `projects/&#42;/locations/&#42;/caPools/&#42;/certificates/&#42;`.
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
   * Revoke a [Certificate][google.cloud.security.privateca.v1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]").toString();
   *   Certificate response = certificateAuthorityServiceClient.revokeCertificate(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [Certificate][google.cloud.security.privateca.v1.Certificate] in the format
   *     `projects/&#42;/locations/&#42;/caPools/&#42;/certificates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate revokeCertificate(String name) {
    RevokeCertificateRequest request = RevokeCertificateRequest.newBuilder().setName(name).build();
    return revokeCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revoke a [Certificate][google.cloud.security.privateca.v1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   RevokeCertificateRequest request =
   *       RevokeCertificateRequest.newBuilder()
   *           .setName(
   *               CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]")
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
   * Revoke a [Certificate][google.cloud.security.privateca.v1.Certificate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   RevokeCertificateRequest request =
   *       RevokeCertificateRequest.newBuilder()
   *           .setName(
   *               CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]")
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
   * Update a [Certificate][google.cloud.security.privateca.v1.Certificate]. Currently, the only
   * field you can update is the [labels][google.cloud.security.privateca.v1.Certificate.labels]
   * field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   Certificate certificate = Certificate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Certificate response =
   *       certificateAuthorityServiceClient.updateCertificate(certificate, updateMask);
   * }
   * }</pre>
   *
   * @param certificate Required. [Certificate][google.cloud.security.privateca.v1.Certificate] with
   *     updated values.
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
   * Update a [Certificate][google.cloud.security.privateca.v1.Certificate]. Currently, the only
   * field you can update is the [labels][google.cloud.security.privateca.v1.Certificate.labels]
   * field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Update a [Certificate][google.cloud.security.privateca.v1.Certificate]. Currently, the only
   * field you can update is the [labels][google.cloud.security.privateca.v1.Certificate.labels]
   * field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Activate a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that
   * is in state
   * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. After
   * the parent Certificate Authority signs a certificate signing request from
   * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1.CertificateAuthorityService.FetchCertificateAuthorityCsr],
   * this method can complete the activation process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of(
   *           "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.activateCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
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
   * Activate a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that
   * is in state
   * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. After
   * the parent Certificate Authority signs a certificate signing request from
   * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1.CertificateAuthorityService.FetchCertificateAuthorityCsr],
   * this method can complete the activation process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of(
   *               "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.activateCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
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
   * Activate a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that
   * is in state
   * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. After
   * the parent Certificate Authority signs a certificate signing request from
   * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1.CertificateAuthorityService.FetchCertificateAuthorityCsr],
   * this method can complete the activation process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ActivateCertificateAuthorityRequest request =
   *       ActivateCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * Activate a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that
   * is in state
   * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. After
   * the parent Certificate Authority signs a certificate signing request from
   * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1.CertificateAuthorityService.FetchCertificateAuthorityCsr],
   * this method can complete the activation process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ActivateCertificateAuthorityRequest request =
   *       ActivateCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * Activate a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that
   * is in state
   * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. After
   * the parent Certificate Authority signs a certificate signing request from
   * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1.CertificateAuthorityService.FetchCertificateAuthorityCsr],
   * this method can complete the activation process.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ActivateCertificateAuthorityRequest request =
   *       ActivateCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * Create a new [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in
   * a given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CaPoolName parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
   *   CertificateAuthority certificateAuthority = CertificateAuthority.newBuilder().build();
   *   String certificateAuthorityId = "certificateAuthorityId-1652580953";
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient
   *           .createCertificateAuthorityAsync(parent, certificateAuthority, certificateAuthorityId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the
   *     [CaPool][google.cloud.security.privateca.v1.CaPool] associated with the
   *     [CertificateAuthorities][google.cloud.security.privateca.v1.CertificateAuthority], in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;`.
   * @param certificateAuthority Required. A
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] with
   *     initial field values.
   * @param certificateAuthorityId Required. It must be unique within a location and match the
   *     regular expression `[a-zA-Z0-9_-]{1,63}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      createCertificateAuthorityAsync(
          CaPoolName parent,
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
   * Create a new [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in
   * a given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString();
   *   CertificateAuthority certificateAuthority = CertificateAuthority.newBuilder().build();
   *   String certificateAuthorityId = "certificateAuthorityId-1652580953";
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient
   *           .createCertificateAuthorityAsync(parent, certificateAuthority, certificateAuthorityId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the
   *     [CaPool][google.cloud.security.privateca.v1.CaPool] associated with the
   *     [CertificateAuthorities][google.cloud.security.privateca.v1.CertificateAuthority], in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;`.
   * @param certificateAuthority Required. A
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] with
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
   * Create a new [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in
   * a given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCertificateAuthorityRequest request =
   *       CreateCertificateAuthorityRequest.newBuilder()
   *           .setParent(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
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
   * Create a new [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in
   * a given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCertificateAuthorityRequest request =
   *       CreateCertificateAuthorityRequest.newBuilder()
   *           .setParent(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
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
   * Create a new [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in
   * a given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCertificateAuthorityRequest request =
   *       CreateCertificateAuthorityRequest.newBuilder()
   *           .setParent(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
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
   * Disable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of(
   *           "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.disableCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
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
   * Disable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of(
   *               "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.disableCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
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
   * Disable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DisableCertificateAuthorityRequest request =
   *       DisableCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * Disable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DisableCertificateAuthorityRequest request =
   *       DisableCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * Disable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DisableCertificateAuthorityRequest request =
   *       DisableCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * Enable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of(
   *           "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.enableCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
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
   * Enable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of(
   *               "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.enableCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
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
   * Enable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   EnableCertificateAuthorityRequest request =
   *       EnableCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * Enable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   EnableCertificateAuthorityRequest request =
   *       EnableCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * Enable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   EnableCertificateAuthorityRequest request =
   *       EnableCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that is in
   * state
   * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. The
   * CSR must then be signed by the desired parent Certificate Authority, which could be another
   * [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] resource, or
   * could be an on-prem certificate authority. See also
   * [ActivateCertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthorityService.ActivateCertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of(
   *           "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
   *   FetchCertificateAuthorityCsrResponse response =
   *       certificateAuthorityServiceClient.fetchCertificateAuthorityCsr(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
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
   * [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that is in
   * state
   * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. The
   * CSR must then be signed by the desired parent Certificate Authority, which could be another
   * [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] resource, or
   * could be an on-prem certificate authority. See also
   * [ActivateCertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthorityService.ActivateCertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of(
   *               "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   FetchCertificateAuthorityCsrResponse response =
   *       certificateAuthorityServiceClient.fetchCertificateAuthorityCsr(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
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
   * [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that is in
   * state
   * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. The
   * CSR must then be signed by the desired parent Certificate Authority, which could be another
   * [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] resource, or
   * could be an on-prem certificate authority. See also
   * [ActivateCertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthorityService.ActivateCertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   FetchCertificateAuthorityCsrRequest request =
   *       FetchCertificateAuthorityCsrRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that is in
   * state
   * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
   * and is of type
   * [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. The
   * CSR must then be signed by the desired parent Certificate Authority, which could be another
   * [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] resource, or
   * could be an on-prem certificate authority. See also
   * [ActivateCertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthorityService.ActivateCertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   FetchCertificateAuthorityCsrRequest request =
   *       FetchCertificateAuthorityCsrRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * Returns a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of(
   *           "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.getCertificateAuthority(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.security.privateca.v1.CertificateAuthority.name]
   *     of the [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] to
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
   * Returns a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of(
   *               "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.getCertificateAuthority(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.security.privateca.v1.CertificateAuthority.name]
   *     of the [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] to
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
   * Returns a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateAuthorityRequest request =
   *       GetCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * Returns a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateAuthorityRequest request =
   *       GetCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * Lists [CertificateAuthorities][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CaPoolName parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
   *   for (CertificateAuthority element :
   *       certificateAuthorityServiceClient.listCertificateAuthorities(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the
   *     [CaPool][google.cloud.security.privateca.v1.CaPool] associated with the
   *     [CertificateAuthorities][google.cloud.security.privateca.v1.CertificateAuthority], in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateAuthoritiesPagedResponse listCertificateAuthorities(
      CaPoolName parent) {
    ListCertificateAuthoritiesRequest request =
        ListCertificateAuthoritiesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCertificateAuthorities(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CertificateAuthorities][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString();
   *   for (CertificateAuthority element :
   *       certificateAuthorityServiceClient.listCertificateAuthorities(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the
   *     [CaPool][google.cloud.security.privateca.v1.CaPool] associated with the
   *     [CertificateAuthorities][google.cloud.security.privateca.v1.CertificateAuthority], in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateAuthoritiesPagedResponse listCertificateAuthorities(String parent) {
    ListCertificateAuthoritiesRequest request =
        ListCertificateAuthoritiesRequest.newBuilder().setParent(parent).build();
    return listCertificateAuthorities(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CertificateAuthorities][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificateAuthoritiesRequest request =
   *       ListCertificateAuthoritiesRequest.newBuilder()
   *           .setParent(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
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
   * Lists [CertificateAuthorities][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificateAuthoritiesRequest request =
   *       ListCertificateAuthoritiesRequest.newBuilder()
   *           .setParent(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
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
   * Lists [CertificateAuthorities][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificateAuthoritiesRequest request =
   *       ListCertificateAuthoritiesRequest.newBuilder()
   *           .setParent(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCertificateAuthoritiesResponse response =
   *         certificateAuthorityServiceClient.listCertificateAuthoritiesCallable().call(request);
   *     for (CertificateAuthority element : response.getCertificateAuthoritiesList()) {
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
   * Undelete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that
   * has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of(
   *           "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.undeleteCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      undeleteCertificateAuthorityAsync(CertificateAuthorityName name) {
    UndeleteCertificateAuthorityRequest request =
        UndeleteCertificateAuthorityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeleteCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undelete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that
   * has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of(
   *               "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.undeleteCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      undeleteCertificateAuthorityAsync(String name) {
    UndeleteCertificateAuthorityRequest request =
        UndeleteCertificateAuthorityRequest.newBuilder().setName(name).build();
    return undeleteCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undelete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that
   * has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UndeleteCertificateAuthorityRequest request =
   *       UndeleteCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.undeleteCertificateAuthorityAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      undeleteCertificateAuthorityAsync(UndeleteCertificateAuthorityRequest request) {
    return undeleteCertificateAuthorityOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undelete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that
   * has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UndeleteCertificateAuthorityRequest request =
   *       UndeleteCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CertificateAuthority, OperationMetadata> future =
   *       certificateAuthorityServiceClient
   *           .undeleteCertificateAuthorityOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UndeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      undeleteCertificateAuthorityOperationCallable() {
    return stub.undeleteCertificateAuthorityOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undelete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that
   * has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UndeleteCertificateAuthorityRequest request =
   *       UndeleteCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient
   *           .undeleteCertificateAuthorityCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteCertificateAuthorityRequest, Operation>
      undeleteCertificateAuthorityCallable() {
    return stub.undeleteCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of(
   *           "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.deleteCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      deleteCertificateAuthorityAsync(CertificateAuthorityName name) {
    DeleteCertificateAuthorityRequest request =
        DeleteCertificateAuthorityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateAuthorityName.of(
   *               "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.deleteCertificateAuthorityAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in the
   *     format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      deleteCertificateAuthorityAsync(String name) {
    DeleteCertificateAuthorityRequest request =
        DeleteCertificateAuthorityRequest.newBuilder().setName(name).build();
    return deleteCertificateAuthorityAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DeleteCertificateAuthorityRequest request =
   *       DeleteCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setIgnoreActiveCertificates(true)
   *           .setSkipGracePeriod(true)
   *           .build();
   *   CertificateAuthority response =
   *       certificateAuthorityServiceClient.deleteCertificateAuthorityAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateAuthority, OperationMetadata>
      deleteCertificateAuthorityAsync(DeleteCertificateAuthorityRequest request) {
    return deleteCertificateAuthorityOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DeleteCertificateAuthorityRequest request =
   *       DeleteCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setIgnoreActiveCertificates(true)
   *           .setSkipGracePeriod(true)
   *           .build();
   *   OperationFuture<CertificateAuthority, OperationMetadata> future =
   *       certificateAuthorityServiceClient
   *           .deleteCertificateAuthorityOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      deleteCertificateAuthorityOperationCallable() {
    return stub.deleteCertificateAuthorityOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DeleteCertificateAuthorityRequest request =
   *       DeleteCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setIgnoreActiveCertificates(true)
   *           .setSkipGracePeriod(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient
   *           .deleteCertificateAuthorityCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCertificateAuthorityRequest, Operation>
      deleteCertificateAuthorityCallable() {
    return stub.deleteCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   *     [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] with
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
   * Update a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Update a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Update a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Create a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CaPool caPool = CaPool.newBuilder().build();
   *   String caPoolId = "caPoolId-970668971";
   *   CaPool response =
   *       certificateAuthorityServiceClient.createCaPoolAsync(parent, caPool, caPoolId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CaPool][google.cloud.security.privateca.v1.CaPool], in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param caPool Required. A [CaPool][google.cloud.security.privateca.v1.CaPool] with initial
   *     field values.
   * @param caPoolId Required. It must be unique within a location and match the regular expression
   *     `[a-zA-Z0-9_-]{1,63}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CaPool, OperationMetadata> createCaPoolAsync(
      LocationName parent, CaPool caPool, String caPoolId) {
    CreateCaPoolRequest request =
        CreateCaPoolRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCaPool(caPool)
            .setCaPoolId(caPoolId)
            .build();
    return createCaPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CaPool caPool = CaPool.newBuilder().build();
   *   String caPoolId = "caPoolId-970668971";
   *   CaPool response =
   *       certificateAuthorityServiceClient.createCaPoolAsync(parent, caPool, caPoolId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CaPool][google.cloud.security.privateca.v1.CaPool], in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param caPool Required. A [CaPool][google.cloud.security.privateca.v1.CaPool] with initial
   *     field values.
   * @param caPoolId Required. It must be unique within a location and match the regular expression
   *     `[a-zA-Z0-9_-]{1,63}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CaPool, OperationMetadata> createCaPoolAsync(
      String parent, CaPool caPool, String caPoolId) {
    CreateCaPoolRequest request =
        CreateCaPoolRequest.newBuilder()
            .setParent(parent)
            .setCaPool(caPool)
            .setCaPoolId(caPoolId)
            .build();
    return createCaPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCaPoolRequest request =
   *       CreateCaPoolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCaPoolId("caPoolId-970668971")
   *           .setCaPool(CaPool.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CaPool response = certificateAuthorityServiceClient.createCaPoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CaPool, OperationMetadata> createCaPoolAsync(
      CreateCaPoolRequest request) {
    return createCaPoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCaPoolRequest request =
   *       CreateCaPoolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCaPoolId("caPoolId-970668971")
   *           .setCaPool(CaPool.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CaPool, OperationMetadata> future =
   *       certificateAuthorityServiceClient.createCaPoolOperationCallable().futureCall(request);
   *   // Do something.
   *   CaPool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCaPoolRequest, CaPool, OperationMetadata>
      createCaPoolOperationCallable() {
    return stub.createCaPoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCaPoolRequest request =
   *       CreateCaPoolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCaPoolId("caPoolId-970668971")
   *           .setCaPool(CaPool.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient.createCaPoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCaPoolRequest, Operation> createCaPoolCallable() {
    return stub.createCaPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CaPool caPool = CaPool.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CaPool response =
   *       certificateAuthorityServiceClient.updateCaPoolAsync(caPool, updateMask).get();
   * }
   * }</pre>
   *
   * @param caPool Required. [CaPool][google.cloud.security.privateca.v1.CaPool] with updated
   *     values.
   * @param updateMask Required. A list of fields to be updated in this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CaPool, OperationMetadata> updateCaPoolAsync(
      CaPool caPool, FieldMask updateMask) {
    UpdateCaPoolRequest request =
        UpdateCaPoolRequest.newBuilder().setCaPool(caPool).setUpdateMask(updateMask).build();
    return updateCaPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCaPoolRequest request =
   *       UpdateCaPoolRequest.newBuilder()
   *           .setCaPool(CaPool.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CaPool response = certificateAuthorityServiceClient.updateCaPoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CaPool, OperationMetadata> updateCaPoolAsync(
      UpdateCaPoolRequest request) {
    return updateCaPoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCaPoolRequest request =
   *       UpdateCaPoolRequest.newBuilder()
   *           .setCaPool(CaPool.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CaPool, OperationMetadata> future =
   *       certificateAuthorityServiceClient.updateCaPoolOperationCallable().futureCall(request);
   *   // Do something.
   *   CaPool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateCaPoolRequest, CaPool, OperationMetadata>
      updateCaPoolOperationCallable() {
    return stub.updateCaPoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCaPoolRequest request =
   *       UpdateCaPoolRequest.newBuilder()
   *           .setCaPool(CaPool.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient.updateCaPoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCaPoolRequest, Operation> updateCaPoolCallable() {
    return stub.updateCaPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CaPoolName name = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
   *   CaPool response = certificateAuthorityServiceClient.getCaPool(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.security.privateca.v1.CaPool.name] of the
   *     [CaPool][google.cloud.security.privateca.v1.CaPool] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CaPool getCaPool(CaPoolName name) {
    GetCaPoolRequest request =
        GetCaPoolRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCaPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString();
   *   CaPool response = certificateAuthorityServiceClient.getCaPool(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.security.privateca.v1.CaPool.name] of the
   *     [CaPool][google.cloud.security.privateca.v1.CaPool] to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CaPool getCaPool(String name) {
    GetCaPoolRequest request = GetCaPoolRequest.newBuilder().setName(name).build();
    return getCaPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCaPoolRequest request =
   *       GetCaPoolRequest.newBuilder()
   *           .setName(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .build();
   *   CaPool response = certificateAuthorityServiceClient.getCaPool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CaPool getCaPool(GetCaPoolRequest request) {
    return getCaPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCaPoolRequest request =
   *       GetCaPoolRequest.newBuilder()
   *           .setName(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .build();
   *   ApiFuture<CaPool> future =
   *       certificateAuthorityServiceClient.getCaPoolCallable().futureCall(request);
   *   // Do something.
   *   CaPool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCaPoolRequest, CaPool> getCaPoolCallable() {
    return stub.getCaPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CaPools][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CaPool element : certificateAuthorityServiceClient.listCaPools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CaPools][google.cloud.security.privateca.v1.CaPool], in the format
   *     `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCaPoolsPagedResponse listCaPools(LocationName parent) {
    ListCaPoolsRequest request =
        ListCaPoolsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCaPools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CaPools][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CaPool element : certificateAuthorityServiceClient.listCaPools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CaPools][google.cloud.security.privateca.v1.CaPool], in the format
   *     `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCaPoolsPagedResponse listCaPools(String parent) {
    ListCaPoolsRequest request = ListCaPoolsRequest.newBuilder().setParent(parent).build();
    return listCaPools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CaPools][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCaPoolsRequest request =
   *       ListCaPoolsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CaPool element : certificateAuthorityServiceClient.listCaPools(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCaPoolsPagedResponse listCaPools(ListCaPoolsRequest request) {
    return listCaPoolsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CaPools][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCaPoolsRequest request =
   *       ListCaPoolsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CaPool> future =
   *       certificateAuthorityServiceClient.listCaPoolsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CaPool element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCaPoolsRequest, ListCaPoolsPagedResponse>
      listCaPoolsPagedCallable() {
    return stub.listCaPoolsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CaPools][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCaPoolsRequest request =
   *       ListCaPoolsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCaPoolsResponse response =
   *         certificateAuthorityServiceClient.listCaPoolsCallable().call(request);
   *     for (CaPool element : response.getCaPoolsList()) {
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
  public final UnaryCallable<ListCaPoolsRequest, ListCaPoolsResponse> listCaPoolsCallable() {
    return stub.listCaPoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CaPoolName name = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
   *   certificateAuthorityServiceClient.deleteCaPoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CaPool][google.cloud.security.privateca.v1.CaPool] in the format
   *     `projects/&#42;/locations/&#42;/caPools/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCaPoolAsync(CaPoolName name) {
    DeleteCaPoolRequest request =
        DeleteCaPoolRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteCaPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString();
   *   certificateAuthorityServiceClient.deleteCaPoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CaPool][google.cloud.security.privateca.v1.CaPool] in the format
   *     `projects/&#42;/locations/&#42;/caPools/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCaPoolAsync(String name) {
    DeleteCaPoolRequest request = DeleteCaPoolRequest.newBuilder().setName(name).build();
    return deleteCaPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DeleteCaPoolRequest request =
   *       DeleteCaPoolRequest.newBuilder()
   *           .setName(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   certificateAuthorityServiceClient.deleteCaPoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCaPoolAsync(
      DeleteCaPoolRequest request) {
    return deleteCaPoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DeleteCaPoolRequest request =
   *       DeleteCaPoolRequest.newBuilder()
   *           .setName(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       certificateAuthorityServiceClient.deleteCaPoolOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCaPoolRequest, Empty, OperationMetadata>
      deleteCaPoolOperationCallable() {
    return stub.deleteCaPoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DeleteCaPoolRequest request =
   *       DeleteCaPoolRequest.newBuilder()
   *           .setName(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient.deleteCaPoolCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCaPoolRequest, Operation> deleteCaPoolCallable() {
    return stub.deleteCaPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchCaCerts returns the current trust anchor for the
   * [CaPool][google.cloud.security.privateca.v1.CaPool]. This will include CA certificate chains
   * for all ACTIVE [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority]
   * resources in the [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CaPoolName caPool = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
   *   FetchCaCertsResponse response = certificateAuthorityServiceClient.fetchCaCerts(caPool);
   * }
   * }</pre>
   *
   * @param caPool Required. The resource name for the
   *     [CaPool][google.cloud.security.privateca.v1.CaPool] in the format
   *     `projects/&#42;/locations/&#42;/caPools/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchCaCertsResponse fetchCaCerts(CaPoolName caPool) {
    FetchCaCertsRequest request =
        FetchCaCertsRequest.newBuilder()
            .setCaPool(caPool == null ? null : caPool.toString())
            .build();
    return fetchCaCerts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchCaCerts returns the current trust anchor for the
   * [CaPool][google.cloud.security.privateca.v1.CaPool]. This will include CA certificate chains
   * for all ACTIVE [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority]
   * resources in the [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String caPool = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString();
   *   FetchCaCertsResponse response = certificateAuthorityServiceClient.fetchCaCerts(caPool);
   * }
   * }</pre>
   *
   * @param caPool Required. The resource name for the
   *     [CaPool][google.cloud.security.privateca.v1.CaPool] in the format
   *     `projects/&#42;/locations/&#42;/caPools/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchCaCertsResponse fetchCaCerts(String caPool) {
    FetchCaCertsRequest request = FetchCaCertsRequest.newBuilder().setCaPool(caPool).build();
    return fetchCaCerts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchCaCerts returns the current trust anchor for the
   * [CaPool][google.cloud.security.privateca.v1.CaPool]. This will include CA certificate chains
   * for all ACTIVE [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority]
   * resources in the [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   FetchCaCertsRequest request =
   *       FetchCaCertsRequest.newBuilder()
   *           .setCaPool(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   FetchCaCertsResponse response = certificateAuthorityServiceClient.fetchCaCerts(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchCaCertsResponse fetchCaCerts(FetchCaCertsRequest request) {
    return fetchCaCertsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchCaCerts returns the current trust anchor for the
   * [CaPool][google.cloud.security.privateca.v1.CaPool]. This will include CA certificate chains
   * for all ACTIVE [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority]
   * resources in the [CaPool][google.cloud.security.privateca.v1.CaPool].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   FetchCaCertsRequest request =
   *       FetchCaCertsRequest.newBuilder()
   *           .setCaPool(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<FetchCaCertsResponse> future =
   *       certificateAuthorityServiceClient.fetchCaCertsCallable().futureCall(request);
   *   // Do something.
   *   FetchCaCertsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchCaCertsRequest, FetchCaCertsResponse> fetchCaCertsCallable() {
    return stub.fetchCaCertsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a
   * [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateRevocationListName name =
   *       CertificateRevocationListName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[CA_POOL]",
   *           "[CERTIFICATE_AUTHORITY]",
   *           "[CERTIFICATE_REVOCATION_LIST]");
   *   CertificateRevocationList response =
   *       certificateAuthorityServiceClient.getCertificateRevocationList(name);
   * }
   * }</pre>
   *
   * @param name Required. The
   *     [name][google.cloud.security.privateca.v1.CertificateRevocationList.name] of the
   *     [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList]
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
   * [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateRevocationListName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[CA_POOL]",
   *               "[CERTIFICATE_AUTHORITY]",
   *               "[CERTIFICATE_REVOCATION_LIST]")
   *           .toString();
   *   CertificateRevocationList response =
   *       certificateAuthorityServiceClient.getCertificateRevocationList(name);
   * }
   * }</pre>
   *
   * @param name Required. The
   *     [name][google.cloud.security.privateca.v1.CertificateRevocationList.name] of the
   *     [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList]
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
   * [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateRevocationListRequest request =
   *       GetCertificateRevocationListRequest.newBuilder()
   *           .setName(
   *               CertificateRevocationListName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[CA_POOL]",
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
   * [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateRevocationListRequest request =
   *       GetCertificateRevocationListRequest.newBuilder()
   *           .setName(
   *               CertificateRevocationListName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[CA_POOL]",
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
   * [CertificateRevocationLists][google.cloud.security.privateca.v1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateAuthorityName parent =
   *       CertificateAuthorityName.of(
   *           "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
   *   for (CertificateRevocationList element :
   *       certificateAuthorityServiceClient.listCertificateRevocationLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CertificateRevocationLists][google.cloud.security.privateca.v1.CertificateRevocationList],
   *     in the format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
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
   * [CertificateRevocationLists][google.cloud.security.privateca.v1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent =
   *       CertificateAuthorityName.of(
   *               "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *           .toString();
   *   for (CertificateRevocationList element :
   *       certificateAuthorityServiceClient.listCertificateRevocationLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CertificateRevocationLists][google.cloud.security.privateca.v1.CertificateRevocationList],
   *     in the format `projects/&#42;/locations/&#42;/caPools/&#42;/certificateAuthorities/&#42;`.
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
   * [CertificateRevocationLists][google.cloud.security.privateca.v1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificateRevocationListsRequest request =
   *       ListCertificateRevocationListsRequest.newBuilder()
   *           .setParent(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * [CertificateRevocationLists][google.cloud.security.privateca.v1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificateRevocationListsRequest request =
   *       ListCertificateRevocationListsRequest.newBuilder()
   *           .setParent(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
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
   * [CertificateRevocationLists][google.cloud.security.privateca.v1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificateRevocationListsRequest request =
   *       ListCertificateRevocationListsRequest.newBuilder()
   *           .setParent(
   *               CertificateAuthorityName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCertificateRevocationListsResponse response =
   *         certificateAuthorityServiceClient
   *             .listCertificateRevocationListsCallable()
   *             .call(request);
   *     for (CertificateRevocationList element : response.getCertificateRevocationListsList()) {
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
   * [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   *     [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList]
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
   * [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Create a new [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] in a
   * given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CertificateTemplate certificateTemplate = CertificateTemplate.newBuilder().build();
   *   String certificateTemplateId = "certificateTemplateId1920134188";
   *   CertificateTemplate response =
   *       certificateAuthorityServiceClient
   *           .createCertificateTemplateAsync(parent, certificateTemplate, certificateTemplateId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate], in the
   *     format `projects/&#42;/locations/&#42;`.
   * @param certificateTemplate Required. A
   *     [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] with initial
   *     field values.
   * @param certificateTemplateId Required. It must be unique within a location and match the
   *     regular expression `[a-zA-Z0-9_-]{1,63}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateTemplate, OperationMetadata>
      createCertificateTemplateAsync(
          LocationName parent,
          CertificateTemplate certificateTemplate,
          String certificateTemplateId) {
    CreateCertificateTemplateRequest request =
        CreateCertificateTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCertificateTemplate(certificateTemplate)
            .setCertificateTemplateId(certificateTemplateId)
            .build();
    return createCertificateTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] in a
   * given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CertificateTemplate certificateTemplate = CertificateTemplate.newBuilder().build();
   *   String certificateTemplateId = "certificateTemplateId1920134188";
   *   CertificateTemplate response =
   *       certificateAuthorityServiceClient
   *           .createCertificateTemplateAsync(parent, certificateTemplate, certificateTemplateId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate], in the
   *     format `projects/&#42;/locations/&#42;`.
   * @param certificateTemplate Required. A
   *     [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] with initial
   *     field values.
   * @param certificateTemplateId Required. It must be unique within a location and match the
   *     regular expression `[a-zA-Z0-9_-]{1,63}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateTemplate, OperationMetadata>
      createCertificateTemplateAsync(
          String parent, CertificateTemplate certificateTemplate, String certificateTemplateId) {
    CreateCertificateTemplateRequest request =
        CreateCertificateTemplateRequest.newBuilder()
            .setParent(parent)
            .setCertificateTemplate(certificateTemplate)
            .setCertificateTemplateId(certificateTemplateId)
            .build();
    return createCertificateTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] in a
   * given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCertificateTemplateRequest request =
   *       CreateCertificateTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateTemplateId("certificateTemplateId1920134188")
   *           .setCertificateTemplate(CertificateTemplate.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CertificateTemplate response =
   *       certificateAuthorityServiceClient.createCertificateTemplateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateTemplate, OperationMetadata>
      createCertificateTemplateAsync(CreateCertificateTemplateRequest request) {
    return createCertificateTemplateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] in a
   * given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCertificateTemplateRequest request =
   *       CreateCertificateTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateTemplateId("certificateTemplateId1920134188")
   *           .setCertificateTemplate(CertificateTemplate.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CertificateTemplate, OperationMetadata> future =
   *       certificateAuthorityServiceClient
   *           .createCertificateTemplateOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateTemplate response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      createCertificateTemplateOperationCallable() {
    return stub.createCertificateTemplateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] in a
   * given Project and Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CreateCertificateTemplateRequest request =
   *       CreateCertificateTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateTemplateId("certificateTemplateId1920134188")
   *           .setCertificateTemplate(CertificateTemplate.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient.createCertificateTemplateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCertificateTemplateRequest, Operation>
      createCertificateTemplateCallable() {
    return stub.createCertificateTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * DeleteCertificateTemplate deletes a
   * [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateTemplateName name =
   *       CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]");
   *   certificateAuthorityServiceClient.deleteCertificateTemplateAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] in the format
   *     `projects/&#42;/locations/&#42;/certificateTemplates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateTemplateAsync(
      CertificateTemplateName name) {
    DeleteCertificateTemplateRequest request =
        DeleteCertificateTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteCertificateTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * DeleteCertificateTemplate deletes a
   * [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
   *           .toString();
   *   certificateAuthorityServiceClient.deleteCertificateTemplateAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name for this
   *     [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] in the format
   *     `projects/&#42;/locations/&#42;/certificateTemplates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateTemplateAsync(
      String name) {
    DeleteCertificateTemplateRequest request =
        DeleteCertificateTemplateRequest.newBuilder().setName(name).build();
    return deleteCertificateTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * DeleteCertificateTemplate deletes a
   * [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DeleteCertificateTemplateRequest request =
   *       DeleteCertificateTemplateRequest.newBuilder()
   *           .setName(
   *               CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   certificateAuthorityServiceClient.deleteCertificateTemplateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateTemplateAsync(
      DeleteCertificateTemplateRequest request) {
    return deleteCertificateTemplateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * DeleteCertificateTemplate deletes a
   * [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DeleteCertificateTemplateRequest request =
   *       DeleteCertificateTemplateRequest.newBuilder()
   *           .setName(
   *               CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       certificateAuthorityServiceClient
   *           .deleteCertificateTemplateOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCertificateTemplateRequest, Empty, OperationMetadata>
      deleteCertificateTemplateOperationCallable() {
    return stub.deleteCertificateTemplateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * DeleteCertificateTemplate deletes a
   * [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   DeleteCertificateTemplateRequest request =
   *       DeleteCertificateTemplateRequest.newBuilder()
   *           .setName(
   *               CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient.deleteCertificateTemplateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCertificateTemplateRequest, Operation>
      deleteCertificateTemplateCallable() {
    return stub.deleteCertificateTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateTemplateName name =
   *       CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]");
   *   CertificateTemplate response = certificateAuthorityServiceClient.getCertificateTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.security.privateca.v1.CertificateTemplate.name]
   *     of the [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] to
   *     get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateTemplate getCertificateTemplate(CertificateTemplateName name) {
    GetCertificateTemplateRequest request =
        GetCertificateTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCertificateTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String name =
   *       CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
   *           .toString();
   *   CertificateTemplate response = certificateAuthorityServiceClient.getCertificateTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The [name][google.cloud.security.privateca.v1.CertificateTemplate.name]
   *     of the [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] to
   *     get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateTemplate getCertificateTemplate(String name) {
    GetCertificateTemplateRequest request =
        GetCertificateTemplateRequest.newBuilder().setName(name).build();
    return getCertificateTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateTemplateRequest request =
   *       GetCertificateTemplateRequest.newBuilder()
   *           .setName(
   *               CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   CertificateTemplate response =
   *       certificateAuthorityServiceClient.getCertificateTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateTemplate getCertificateTemplate(GetCertificateTemplateRequest request) {
    return getCertificateTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetCertificateTemplateRequest request =
   *       GetCertificateTemplateRequest.newBuilder()
   *           .setName(
   *               CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CertificateTemplate> future =
   *       certificateAuthorityServiceClient.getCertificateTemplateCallable().futureCall(request);
   *   // Do something.
   *   CertificateTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCertificateTemplateRequest, CertificateTemplate>
      getCertificateTemplateCallable() {
    return stub.getCertificateTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CertificateTemplates][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CertificateTemplate element :
   *       certificateAuthorityServiceClient.listCertificateTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CertificateTemplates][google.cloud.security.privateca.v1.CertificateTemplate], in the
   *     format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateTemplatesPagedResponse listCertificateTemplates(LocationName parent) {
    ListCertificateTemplatesRequest request =
        ListCertificateTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCertificateTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CertificateTemplates][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CertificateTemplate element :
   *       certificateAuthorityServiceClient.listCertificateTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location associated with the
   *     [CertificateTemplates][google.cloud.security.privateca.v1.CertificateTemplate], in the
   *     format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateTemplatesPagedResponse listCertificateTemplates(String parent) {
    ListCertificateTemplatesRequest request =
        ListCertificateTemplatesRequest.newBuilder().setParent(parent).build();
    return listCertificateTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CertificateTemplates][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificateTemplatesRequest request =
   *       ListCertificateTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CertificateTemplate element :
   *       certificateAuthorityServiceClient.listCertificateTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateTemplatesPagedResponse listCertificateTemplates(
      ListCertificateTemplatesRequest request) {
    return listCertificateTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CertificateTemplates][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificateTemplatesRequest request =
   *       ListCertificateTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CertificateTemplate> future =
   *       certificateAuthorityServiceClient
   *           .listCertificateTemplatesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (CertificateTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCertificateTemplatesRequest, ListCertificateTemplatesPagedResponse>
      listCertificateTemplatesPagedCallable() {
    return stub.listCertificateTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [CertificateTemplates][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListCertificateTemplatesRequest request =
   *       ListCertificateTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCertificateTemplatesResponse response =
   *         certificateAuthorityServiceClient.listCertificateTemplatesCallable().call(request);
   *     for (CertificateTemplate element : response.getCertificateTemplatesList()) {
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
  public final UnaryCallable<ListCertificateTemplatesRequest, ListCertificateTemplatesResponse>
      listCertificateTemplatesCallable() {
    return stub.listCertificateTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   CertificateTemplate certificateTemplate = CertificateTemplate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CertificateTemplate response =
   *       certificateAuthorityServiceClient
   *           .updateCertificateTemplateAsync(certificateTemplate, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param certificateTemplate Required.
   *     [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] with updated
   *     values.
   * @param updateMask Required. A list of fields to be updated in this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateTemplate, OperationMetadata>
      updateCertificateTemplateAsync(
          CertificateTemplate certificateTemplate, FieldMask updateMask) {
    UpdateCertificateTemplateRequest request =
        UpdateCertificateTemplateRequest.newBuilder()
            .setCertificateTemplate(certificateTemplate)
            .setUpdateMask(updateMask)
            .build();
    return updateCertificateTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCertificateTemplateRequest request =
   *       UpdateCertificateTemplateRequest.newBuilder()
   *           .setCertificateTemplate(CertificateTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CertificateTemplate response =
   *       certificateAuthorityServiceClient.updateCertificateTemplateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateTemplate, OperationMetadata>
      updateCertificateTemplateAsync(UpdateCertificateTemplateRequest request) {
    return updateCertificateTemplateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCertificateTemplateRequest request =
   *       UpdateCertificateTemplateRequest.newBuilder()
   *           .setCertificateTemplate(CertificateTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CertificateTemplate, OperationMetadata> future =
   *       certificateAuthorityServiceClient
   *           .updateCertificateTemplateOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateTemplate response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      updateCertificateTemplateOperationCallable() {
    return stub.updateCertificateTemplateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   UpdateCertificateTemplateRequest request =
   *       UpdateCertificateTemplateRequest.newBuilder()
   *           .setCertificateTemplate(CertificateTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateAuthorityServiceClient.updateCertificateTemplateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCertificateTemplateRequest, Operation>
      updateCertificateTemplateCallable() {
    return stub.updateCertificateTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element :
   *       certificateAuthorityServiceClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       certificateAuthorityServiceClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         certificateAuthorityServiceClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = certificateAuthorityServiceClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       certificateAuthorityServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = certificateAuthorityServiceClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       certificateAuthorityServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = certificateAuthorityServiceClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       certificateAuthorityServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       certificateAuthorityServiceClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
   *     CertificateAuthorityServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       certificateAuthorityServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
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
          input -> new ListCertificatesPagedResponse(input),
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
          input -> new ListCertificateAuthoritiesPagedResponse(input),
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

  public static class ListCaPoolsPagedResponse
      extends AbstractPagedListResponse<
          ListCaPoolsRequest,
          ListCaPoolsResponse,
          CaPool,
          ListCaPoolsPage,
          ListCaPoolsFixedSizeCollection> {

    public static ApiFuture<ListCaPoolsPagedResponse> createAsync(
        PageContext<ListCaPoolsRequest, ListCaPoolsResponse, CaPool> context,
        ApiFuture<ListCaPoolsResponse> futureResponse) {
      ApiFuture<ListCaPoolsPage> futurePage =
          ListCaPoolsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListCaPoolsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListCaPoolsPagedResponse(ListCaPoolsPage page) {
      super(page, ListCaPoolsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCaPoolsPage
      extends AbstractPage<ListCaPoolsRequest, ListCaPoolsResponse, CaPool, ListCaPoolsPage> {

    private ListCaPoolsPage(
        PageContext<ListCaPoolsRequest, ListCaPoolsResponse, CaPool> context,
        ListCaPoolsResponse response) {
      super(context, response);
    }

    private static ListCaPoolsPage createEmptyPage() {
      return new ListCaPoolsPage(null, null);
    }

    @Override
    protected ListCaPoolsPage createPage(
        PageContext<ListCaPoolsRequest, ListCaPoolsResponse, CaPool> context,
        ListCaPoolsResponse response) {
      return new ListCaPoolsPage(context, response);
    }

    @Override
    public ApiFuture<ListCaPoolsPage> createPageAsync(
        PageContext<ListCaPoolsRequest, ListCaPoolsResponse, CaPool> context,
        ApiFuture<ListCaPoolsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCaPoolsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCaPoolsRequest,
          ListCaPoolsResponse,
          CaPool,
          ListCaPoolsPage,
          ListCaPoolsFixedSizeCollection> {

    private ListCaPoolsFixedSizeCollection(List<ListCaPoolsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCaPoolsFixedSizeCollection createEmptyCollection() {
      return new ListCaPoolsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCaPoolsFixedSizeCollection createCollection(
        List<ListCaPoolsPage> pages, int collectionSize) {
      return new ListCaPoolsFixedSizeCollection(pages, collectionSize);
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
          input -> new ListCertificateRevocationListsPagedResponse(input),
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

  public static class ListCertificateTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListCertificateTemplatesRequest,
          ListCertificateTemplatesResponse,
          CertificateTemplate,
          ListCertificateTemplatesPage,
          ListCertificateTemplatesFixedSizeCollection> {

    public static ApiFuture<ListCertificateTemplatesPagedResponse> createAsync(
        PageContext<
                ListCertificateTemplatesRequest,
                ListCertificateTemplatesResponse,
                CertificateTemplate>
            context,
        ApiFuture<ListCertificateTemplatesResponse> futureResponse) {
      ApiFuture<ListCertificateTemplatesPage> futurePage =
          ListCertificateTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCertificateTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCertificateTemplatesPagedResponse(ListCertificateTemplatesPage page) {
      super(page, ListCertificateTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCertificateTemplatesPage
      extends AbstractPage<
          ListCertificateTemplatesRequest,
          ListCertificateTemplatesResponse,
          CertificateTemplate,
          ListCertificateTemplatesPage> {

    private ListCertificateTemplatesPage(
        PageContext<
                ListCertificateTemplatesRequest,
                ListCertificateTemplatesResponse,
                CertificateTemplate>
            context,
        ListCertificateTemplatesResponse response) {
      super(context, response);
    }

    private static ListCertificateTemplatesPage createEmptyPage() {
      return new ListCertificateTemplatesPage(null, null);
    }

    @Override
    protected ListCertificateTemplatesPage createPage(
        PageContext<
                ListCertificateTemplatesRequest,
                ListCertificateTemplatesResponse,
                CertificateTemplate>
            context,
        ListCertificateTemplatesResponse response) {
      return new ListCertificateTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListCertificateTemplatesPage> createPageAsync(
        PageContext<
                ListCertificateTemplatesRequest,
                ListCertificateTemplatesResponse,
                CertificateTemplate>
            context,
        ApiFuture<ListCertificateTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCertificateTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCertificateTemplatesRequest,
          ListCertificateTemplatesResponse,
          CertificateTemplate,
          ListCertificateTemplatesPage,
          ListCertificateTemplatesFixedSizeCollection> {

    private ListCertificateTemplatesFixedSizeCollection(
        List<ListCertificateTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCertificateTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListCertificateTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCertificateTemplatesFixedSizeCollection createCollection(
        List<ListCertificateTemplatesPage> pages, int collectionSize) {
      return new ListCertificateTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
