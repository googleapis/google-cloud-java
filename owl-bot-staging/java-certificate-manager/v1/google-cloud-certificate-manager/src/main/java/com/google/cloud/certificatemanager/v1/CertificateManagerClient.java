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

package com.google.cloud.certificatemanager.v1;

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
import com.google.cloud.certificatemanager.v1.stub.CertificateManagerStub;
import com.google.cloud.certificatemanager.v1.stub.CertificateManagerStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: API Overview
 *
 * <p>Certificates Manager API allows customers to see and manage all their TLS certificates.
 *
 * <p>Certificates Manager API service provides methods to manage certificates, group them into
 * collections, and create serving configuration that can be easily applied to other Cloud resources
 * e.g. Target Proxies.
 *
 * <p>Data Model
 *
 * <p>The Certificates Manager service exposes the following resources:
 *
 * <ul>
 *   <li>`Certificate` which describes a single TLS certificate.
 *   <li>`CertificateMap` which describes a collection of certificates that can be attached to a
 *       target resource.
 *   <li>`CertificateMapEntry` which describes a single configuration entry that consists of a SNI
 *       and a group of certificates. It's a subresource of CertificateMap.
 * </ul>
 *
 * <p>Certificate, CertificateMap and CertificateMapEntry IDs have to match "^[a-z0-9-]{1,63}$"
 * regexp, which means that - only lower case letters, digits, and hyphen are allowed - length of
 * the resource ID has to be in [1,63] range.
 *
 * <p>Provides methods to manage Cloud Certificate Manager entities.
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
 * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
 *   CertificateName name = CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]");
 *   Certificate response = certificateManagerClient.getCertificate(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CertificateManagerClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of CertificateManagerSettings to
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
 * CertificateManagerSettings certificateManagerSettings =
 *     CertificateManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CertificateManagerClient certificateManagerClient =
 *     CertificateManagerClient.create(certificateManagerSettings);
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
 * CertificateManagerSettings certificateManagerSettings =
 *     CertificateManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CertificateManagerClient certificateManagerClient =
 *     CertificateManagerClient.create(certificateManagerSettings);
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
 * CertificateManagerSettings certificateManagerSettings =
 *     CertificateManagerSettings.newHttpJsonBuilder().build();
 * CertificateManagerClient certificateManagerClient =
 *     CertificateManagerClient.create(certificateManagerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CertificateManagerClient implements BackgroundResource {
  private final CertificateManagerSettings settings;
  private final CertificateManagerStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of CertificateManagerClient with default settings. */
  public static final CertificateManagerClient create() throws IOException {
    return create(CertificateManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CertificateManagerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CertificateManagerClient create(CertificateManagerSettings settings)
      throws IOException {
    return new CertificateManagerClient(settings);
  }

  /**
   * Constructs an instance of CertificateManagerClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(CertificateManagerSettings).
   */
  public static final CertificateManagerClient create(CertificateManagerStub stub) {
    return new CertificateManagerClient(stub);
  }

  /**
   * Constructs an instance of CertificateManagerClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CertificateManagerClient(CertificateManagerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CertificateManagerStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CertificateManagerClient(CertificateManagerStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final CertificateManagerSettings getSettings() {
    return settings;
  }

  public CertificateManagerStub getStub() {
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
   * Lists Certificates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Certificate element : certificateManagerClient.listCertificates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the certificate should be listed,
   *     specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificatesPagedResponse listCertificates(LocationName parent) {
    ListCertificatesRequest request =
        ListCertificatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCertificates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Certificates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Certificate element : certificateManagerClient.listCertificates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the certificate should be listed,
   *     specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificatesPagedResponse listCertificates(String parent) {
    ListCertificatesRequest request =
        ListCertificatesRequest.newBuilder().setParent(parent).build();
    return listCertificates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Certificates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListCertificatesRequest request =
   *       ListCertificatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Certificate element : certificateManagerClient.listCertificates(request).iterateAll()) {
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
   * Lists Certificates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListCertificatesRequest request =
   *       ListCertificatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Certificate> future =
   *       certificateManagerClient.listCertificatesPagedCallable().futureCall(request);
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
   * Lists Certificates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListCertificatesRequest request =
   *       ListCertificatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCertificatesResponse response =
   *         certificateManagerClient.listCertificatesCallable().call(request);
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
   * Gets details of a single Certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CertificateName name = CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]");
   *   Certificate response = certificateManagerClient.getCertificate(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate to describe. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate getCertificate(CertificateName name) {
    GetCertificateRequest request =
        GetCertificateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String name = CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]").toString();
   *   Certificate response = certificateManagerClient.getCertificate(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate to describe. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Certificate getCertificate(String name) {
    GetCertificateRequest request = GetCertificateRequest.newBuilder().setName(name).build();
    return getCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   GetCertificateRequest request =
   *       GetCertificateRequest.newBuilder()
   *           .setName(CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]").toString())
   *           .build();
   *   Certificate response = certificateManagerClient.getCertificate(request);
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
   * Gets details of a single Certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   GetCertificateRequest request =
   *       GetCertificateRequest.newBuilder()
   *           .setName(CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]").toString())
   *           .build();
   *   ApiFuture<Certificate> future =
   *       certificateManagerClient.getCertificateCallable().futureCall(request);
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
   * Creates a new Certificate in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Certificate certificate = Certificate.newBuilder().build();
   *   String certificateId = "certificateId-644529902";
   *   Certificate response =
   *       certificateManagerClient.createCertificateAsync(parent, certificate, certificateId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the certificate. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param certificate Required. A definition of the certificate to create.
   * @param certificateId Required. A user-provided name of the certificate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Certificate, OperationMetadata> createCertificateAsync(
      LocationName parent, Certificate certificate, String certificateId) {
    CreateCertificateRequest request =
        CreateCertificateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCertificate(certificate)
            .setCertificateId(certificateId)
            .build();
    return createCertificateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Certificate in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Certificate certificate = Certificate.newBuilder().build();
   *   String certificateId = "certificateId-644529902";
   *   Certificate response =
   *       certificateManagerClient.createCertificateAsync(parent, certificate, certificateId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the certificate. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param certificate Required. A definition of the certificate to create.
   * @param certificateId Required. A user-provided name of the certificate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Certificate, OperationMetadata> createCertificateAsync(
      String parent, Certificate certificate, String certificateId) {
    CreateCertificateRequest request =
        CreateCertificateRequest.newBuilder()
            .setParent(parent)
            .setCertificate(certificate)
            .setCertificateId(certificateId)
            .build();
    return createCertificateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Certificate in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateCertificateRequest request =
   *       CreateCertificateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateId("certificateId-644529902")
   *           .setCertificate(Certificate.newBuilder().build())
   *           .build();
   *   Certificate response = certificateManagerClient.createCertificateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Certificate, OperationMetadata> createCertificateAsync(
      CreateCertificateRequest request) {
    return createCertificateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Certificate in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateCertificateRequest request =
   *       CreateCertificateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateId("certificateId-644529902")
   *           .setCertificate(Certificate.newBuilder().build())
   *           .build();
   *   OperationFuture<Certificate, OperationMetadata> future =
   *       certificateManagerClient.createCertificateOperationCallable().futureCall(request);
   *   // Do something.
   *   Certificate response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCertificateRequest, Certificate, OperationMetadata>
      createCertificateOperationCallable() {
    return stub.createCertificateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Certificate in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateCertificateRequest request =
   *       CreateCertificateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateId("certificateId-644529902")
   *           .setCertificate(Certificate.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.createCertificateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCertificateRequest, Operation> createCertificateCallable() {
    return stub.createCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   Certificate certificate = Certificate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Certificate response =
   *       certificateManagerClient.updateCertificateAsync(certificate, updateMask).get();
   * }
   * }</pre>
   *
   * @param certificate Required. A definition of the certificate to update.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Certificate, OperationMetadata> updateCertificateAsync(
      Certificate certificate, FieldMask updateMask) {
    UpdateCertificateRequest request =
        UpdateCertificateRequest.newBuilder()
            .setCertificate(certificate)
            .setUpdateMask(updateMask)
            .build();
    return updateCertificateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   UpdateCertificateRequest request =
   *       UpdateCertificateRequest.newBuilder()
   *           .setCertificate(Certificate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Certificate response = certificateManagerClient.updateCertificateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Certificate, OperationMetadata> updateCertificateAsync(
      UpdateCertificateRequest request) {
    return updateCertificateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   UpdateCertificateRequest request =
   *       UpdateCertificateRequest.newBuilder()
   *           .setCertificate(Certificate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Certificate, OperationMetadata> future =
   *       certificateManagerClient.updateCertificateOperationCallable().futureCall(request);
   *   // Do something.
   *   Certificate response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateCertificateRequest, Certificate, OperationMetadata>
      updateCertificateOperationCallable() {
    return stub.updateCertificateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   UpdateCertificateRequest request =
   *       UpdateCertificateRequest.newBuilder()
   *           .setCertificate(Certificate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.updateCertificateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCertificateRequest, Operation> updateCertificateCallable() {
    return stub.updateCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CertificateName name = CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]");
   *   certificateManagerClient.deleteCertificateAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate to delete. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateAsync(
      CertificateName name) {
    DeleteCertificateRequest request =
        DeleteCertificateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteCertificateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String name = CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]").toString();
   *   certificateManagerClient.deleteCertificateAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate to delete. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateAsync(String name) {
    DeleteCertificateRequest request = DeleteCertificateRequest.newBuilder().setName(name).build();
    return deleteCertificateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteCertificateRequest request =
   *       DeleteCertificateRequest.newBuilder()
   *           .setName(CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]").toString())
   *           .build();
   *   certificateManagerClient.deleteCertificateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateAsync(
      DeleteCertificateRequest request) {
    return deleteCertificateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteCertificateRequest request =
   *       DeleteCertificateRequest.newBuilder()
   *           .setName(CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       certificateManagerClient.deleteCertificateOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCertificateRequest, Empty, OperationMetadata>
      deleteCertificateOperationCallable() {
    return stub.deleteCertificateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteCertificateRequest request =
   *       DeleteCertificateRequest.newBuilder()
   *           .setName(CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.deleteCertificateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCertificateRequest, Operation> deleteCertificateCallable() {
    return stub.deleteCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateMaps in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CertificateMap element :
   *       certificateManagerClient.listCertificateMaps(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the certificate maps should be
   *     listed, specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateMapsPagedResponse listCertificateMaps(LocationName parent) {
    ListCertificateMapsRequest request =
        ListCertificateMapsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCertificateMaps(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateMaps in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CertificateMap element :
   *       certificateManagerClient.listCertificateMaps(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the certificate maps should be
   *     listed, specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateMapsPagedResponse listCertificateMaps(String parent) {
    ListCertificateMapsRequest request =
        ListCertificateMapsRequest.newBuilder().setParent(parent).build();
    return listCertificateMaps(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateMaps in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListCertificateMapsRequest request =
   *       ListCertificateMapsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CertificateMap element :
   *       certificateManagerClient.listCertificateMaps(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateMapsPagedResponse listCertificateMaps(
      ListCertificateMapsRequest request) {
    return listCertificateMapsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateMaps in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListCertificateMapsRequest request =
   *       ListCertificateMapsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CertificateMap> future =
   *       certificateManagerClient.listCertificateMapsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CertificateMap element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCertificateMapsRequest, ListCertificateMapsPagedResponse>
      listCertificateMapsPagedCallable() {
    return stub.listCertificateMapsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateMaps in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListCertificateMapsRequest request =
   *       ListCertificateMapsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCertificateMapsResponse response =
   *         certificateManagerClient.listCertificateMapsCallable().call(request);
   *     for (CertificateMap element : response.getCertificateMapsList()) {
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
  public final UnaryCallable<ListCertificateMapsRequest, ListCertificateMapsResponse>
      listCertificateMapsCallable() {
    return stub.listCertificateMapsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CertificateMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CertificateMapName name =
   *       CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]");
   *   CertificateMap response = certificateManagerClient.getCertificateMap(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate map to describe. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificateMaps/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateMap getCertificateMap(CertificateMapName name) {
    GetCertificateMapRequest request =
        GetCertificateMapRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCertificateMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CertificateMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String name =
   *       CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString();
   *   CertificateMap response = certificateManagerClient.getCertificateMap(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate map to describe. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificateMaps/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateMap getCertificateMap(String name) {
    GetCertificateMapRequest request = GetCertificateMapRequest.newBuilder().setName(name).build();
    return getCertificateMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CertificateMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   GetCertificateMapRequest request =
   *       GetCertificateMapRequest.newBuilder()
   *           .setName(
   *               CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
   *           .build();
   *   CertificateMap response = certificateManagerClient.getCertificateMap(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateMap getCertificateMap(GetCertificateMapRequest request) {
    return getCertificateMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CertificateMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   GetCertificateMapRequest request =
   *       GetCertificateMapRequest.newBuilder()
   *           .setName(
   *               CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
   *           .build();
   *   ApiFuture<CertificateMap> future =
   *       certificateManagerClient.getCertificateMapCallable().futureCall(request);
   *   // Do something.
   *   CertificateMap response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCertificateMapRequest, CertificateMap> getCertificateMapCallable() {
    return stub.getCertificateMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateMap in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CertificateMap certificateMap = CertificateMap.newBuilder().build();
   *   String certificateMapId = "certificateMapId1612184640";
   *   CertificateMap response =
   *       certificateManagerClient
   *           .createCertificateMapAsync(parent, certificateMap, certificateMapId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the certificate map. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param certificateMap Required. A definition of the certificate map to create.
   * @param certificateMapId Required. A user-provided name of the certificate map.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateMap, OperationMetadata> createCertificateMapAsync(
      LocationName parent, CertificateMap certificateMap, String certificateMapId) {
    CreateCertificateMapRequest request =
        CreateCertificateMapRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCertificateMap(certificateMap)
            .setCertificateMapId(certificateMapId)
            .build();
    return createCertificateMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateMap in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CertificateMap certificateMap = CertificateMap.newBuilder().build();
   *   String certificateMapId = "certificateMapId1612184640";
   *   CertificateMap response =
   *       certificateManagerClient
   *           .createCertificateMapAsync(parent, certificateMap, certificateMapId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the certificate map. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param certificateMap Required. A definition of the certificate map to create.
   * @param certificateMapId Required. A user-provided name of the certificate map.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateMap, OperationMetadata> createCertificateMapAsync(
      String parent, CertificateMap certificateMap, String certificateMapId) {
    CreateCertificateMapRequest request =
        CreateCertificateMapRequest.newBuilder()
            .setParent(parent)
            .setCertificateMap(certificateMap)
            .setCertificateMapId(certificateMapId)
            .build();
    return createCertificateMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateMap in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateCertificateMapRequest request =
   *       CreateCertificateMapRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateMapId("certificateMapId1612184640")
   *           .setCertificateMap(CertificateMap.newBuilder().build())
   *           .build();
   *   CertificateMap response = certificateManagerClient.createCertificateMapAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateMap, OperationMetadata> createCertificateMapAsync(
      CreateCertificateMapRequest request) {
    return createCertificateMapOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateMap in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateCertificateMapRequest request =
   *       CreateCertificateMapRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateMapId("certificateMapId1612184640")
   *           .setCertificateMap(CertificateMap.newBuilder().build())
   *           .build();
   *   OperationFuture<CertificateMap, OperationMetadata> future =
   *       certificateManagerClient.createCertificateMapOperationCallable().futureCall(request);
   *   // Do something.
   *   CertificateMap response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCertificateMapRequest, CertificateMap, OperationMetadata>
      createCertificateMapOperationCallable() {
    return stub.createCertificateMapOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateMap in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateCertificateMapRequest request =
   *       CreateCertificateMapRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateMapId("certificateMapId1612184640")
   *           .setCertificateMap(CertificateMap.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.createCertificateMapCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCertificateMapRequest, Operation>
      createCertificateMapCallable() {
    return stub.createCertificateMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CertificateMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CertificateMap certificateMap = CertificateMap.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CertificateMap response =
   *       certificateManagerClient.updateCertificateMapAsync(certificateMap, updateMask).get();
   * }
   * }</pre>
   *
   * @param certificateMap Required. A definition of the certificate map to update.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateMap, OperationMetadata> updateCertificateMapAsync(
      CertificateMap certificateMap, FieldMask updateMask) {
    UpdateCertificateMapRequest request =
        UpdateCertificateMapRequest.newBuilder()
            .setCertificateMap(certificateMap)
            .setUpdateMask(updateMask)
            .build();
    return updateCertificateMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CertificateMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   UpdateCertificateMapRequest request =
   *       UpdateCertificateMapRequest.newBuilder()
   *           .setCertificateMap(CertificateMap.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CertificateMap response = certificateManagerClient.updateCertificateMapAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateMap, OperationMetadata> updateCertificateMapAsync(
      UpdateCertificateMapRequest request) {
    return updateCertificateMapOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CertificateMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   UpdateCertificateMapRequest request =
   *       UpdateCertificateMapRequest.newBuilder()
   *           .setCertificateMap(CertificateMap.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<CertificateMap, OperationMetadata> future =
   *       certificateManagerClient.updateCertificateMapOperationCallable().futureCall(request);
   *   // Do something.
   *   CertificateMap response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateCertificateMapRequest, CertificateMap, OperationMetadata>
      updateCertificateMapOperationCallable() {
    return stub.updateCertificateMapOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CertificateMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   UpdateCertificateMapRequest request =
   *       UpdateCertificateMapRequest.newBuilder()
   *           .setCertificateMap(CertificateMap.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.updateCertificateMapCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCertificateMapRequest, Operation>
      updateCertificateMapCallable() {
    return stub.updateCertificateMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateMap. A Certificate Map can't be deleted if it contains Certificate
   * Map Entries. Remove all the entries from the map before calling this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CertificateMapName name =
   *       CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]");
   *   certificateManagerClient.deleteCertificateMapAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate map to delete. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificateMaps/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateMapAsync(
      CertificateMapName name) {
    DeleteCertificateMapRequest request =
        DeleteCertificateMapRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteCertificateMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateMap. A Certificate Map can't be deleted if it contains Certificate
   * Map Entries. Remove all the entries from the map before calling this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String name =
   *       CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString();
   *   certificateManagerClient.deleteCertificateMapAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate map to delete. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificateMaps/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateMapAsync(String name) {
    DeleteCertificateMapRequest request =
        DeleteCertificateMapRequest.newBuilder().setName(name).build();
    return deleteCertificateMapAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateMap. A Certificate Map can't be deleted if it contains Certificate
   * Map Entries. Remove all the entries from the map before calling this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteCertificateMapRequest request =
   *       DeleteCertificateMapRequest.newBuilder()
   *           .setName(
   *               CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
   *           .build();
   *   certificateManagerClient.deleteCertificateMapAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateMapAsync(
      DeleteCertificateMapRequest request) {
    return deleteCertificateMapOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateMap. A Certificate Map can't be deleted if it contains Certificate
   * Map Entries. Remove all the entries from the map before calling this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteCertificateMapRequest request =
   *       DeleteCertificateMapRequest.newBuilder()
   *           .setName(
   *               CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       certificateManagerClient.deleteCertificateMapOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCertificateMapRequest, Empty, OperationMetadata>
      deleteCertificateMapOperationCallable() {
    return stub.deleteCertificateMapOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateMap. A Certificate Map can't be deleted if it contains Certificate
   * Map Entries. Remove all the entries from the map before calling this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteCertificateMapRequest request =
   *       DeleteCertificateMapRequest.newBuilder()
   *           .setName(
   *               CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.deleteCertificateMapCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCertificateMapRequest, Operation>
      deleteCertificateMapCallable() {
    return stub.deleteCertificateMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateMapEntries in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CertificateMapName parent =
   *       CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]");
   *   for (CertificateMapEntry element :
   *       certificateManagerClient.listCertificateMapEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project, location and certificate map from which the certificate
   *     map entries should be listed, specified in the format
   *     `projects/&#42;/locations/&#42;/certificateMaps/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateMapEntriesPagedResponse listCertificateMapEntries(
      CertificateMapName parent) {
    ListCertificateMapEntriesRequest request =
        ListCertificateMapEntriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCertificateMapEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateMapEntries in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String parent =
   *       CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString();
   *   for (CertificateMapEntry element :
   *       certificateManagerClient.listCertificateMapEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project, location and certificate map from which the certificate
   *     map entries should be listed, specified in the format
   *     `projects/&#42;/locations/&#42;/certificateMaps/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateMapEntriesPagedResponse listCertificateMapEntries(String parent) {
    ListCertificateMapEntriesRequest request =
        ListCertificateMapEntriesRequest.newBuilder().setParent(parent).build();
    return listCertificateMapEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateMapEntries in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListCertificateMapEntriesRequest request =
   *       ListCertificateMapEntriesRequest.newBuilder()
   *           .setParent(
   *               CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CertificateMapEntry element :
   *       certificateManagerClient.listCertificateMapEntries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateMapEntriesPagedResponse listCertificateMapEntries(
      ListCertificateMapEntriesRequest request) {
    return listCertificateMapEntriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateMapEntries in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListCertificateMapEntriesRequest request =
   *       ListCertificateMapEntriesRequest.newBuilder()
   *           .setParent(
   *               CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CertificateMapEntry> future =
   *       certificateManagerClient.listCertificateMapEntriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CertificateMapEntry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListCertificateMapEntriesRequest, ListCertificateMapEntriesPagedResponse>
      listCertificateMapEntriesPagedCallable() {
    return stub.listCertificateMapEntriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateMapEntries in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListCertificateMapEntriesRequest request =
   *       ListCertificateMapEntriesRequest.newBuilder()
   *           .setParent(
   *               CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCertificateMapEntriesResponse response =
   *         certificateManagerClient.listCertificateMapEntriesCallable().call(request);
   *     for (CertificateMapEntry element : response.getCertificateMapEntriesList()) {
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
  public final UnaryCallable<ListCertificateMapEntriesRequest, ListCertificateMapEntriesResponse>
      listCertificateMapEntriesCallable() {
    return stub.listCertificateMapEntriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CertificateMapEntry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CertificateMapEntryName name =
   *       CertificateMapEntryName.of(
   *           "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]");
   *   CertificateMapEntry response = certificateManagerClient.getCertificateMapEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate map entry to describe. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificateMaps/&#42;/certificateMapEntries/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateMapEntry getCertificateMapEntry(CertificateMapEntryName name) {
    GetCertificateMapEntryRequest request =
        GetCertificateMapEntryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCertificateMapEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CertificateMapEntry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String name =
   *       CertificateMapEntryName.of(
   *               "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]")
   *           .toString();
   *   CertificateMapEntry response = certificateManagerClient.getCertificateMapEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate map entry to describe. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificateMaps/&#42;/certificateMapEntries/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateMapEntry getCertificateMapEntry(String name) {
    GetCertificateMapEntryRequest request =
        GetCertificateMapEntryRequest.newBuilder().setName(name).build();
    return getCertificateMapEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CertificateMapEntry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   GetCertificateMapEntryRequest request =
   *       GetCertificateMapEntryRequest.newBuilder()
   *           .setName(
   *               CertificateMapEntryName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]")
   *                   .toString())
   *           .build();
   *   CertificateMapEntry response = certificateManagerClient.getCertificateMapEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateMapEntry getCertificateMapEntry(GetCertificateMapEntryRequest request) {
    return getCertificateMapEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CertificateMapEntry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   GetCertificateMapEntryRequest request =
   *       GetCertificateMapEntryRequest.newBuilder()
   *           .setName(
   *               CertificateMapEntryName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CertificateMapEntry> future =
   *       certificateManagerClient.getCertificateMapEntryCallable().futureCall(request);
   *   // Do something.
   *   CertificateMapEntry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCertificateMapEntryRequest, CertificateMapEntry>
      getCertificateMapEntryCallable() {
    return stub.getCertificateMapEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateMapEntry in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CertificateMapName parent =
   *       CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]");
   *   CertificateMapEntry certificateMapEntry = CertificateMapEntry.newBuilder().build();
   *   String certificateMapEntryId = "certificateMapEntryId-859079384";
   *   CertificateMapEntry response =
   *       certificateManagerClient
   *           .createCertificateMapEntryAsync(parent, certificateMapEntry, certificateMapEntryId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the certificate map entry. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificateMaps/&#42;`.
   * @param certificateMapEntry Required. A definition of the certificate map entry to create.
   * @param certificateMapEntryId Required. A user-provided name of the certificate map entry.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateMapEntry, OperationMetadata>
      createCertificateMapEntryAsync(
          CertificateMapName parent,
          CertificateMapEntry certificateMapEntry,
          String certificateMapEntryId) {
    CreateCertificateMapEntryRequest request =
        CreateCertificateMapEntryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCertificateMapEntry(certificateMapEntry)
            .setCertificateMapEntryId(certificateMapEntryId)
            .build();
    return createCertificateMapEntryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateMapEntry in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String parent =
   *       CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString();
   *   CertificateMapEntry certificateMapEntry = CertificateMapEntry.newBuilder().build();
   *   String certificateMapEntryId = "certificateMapEntryId-859079384";
   *   CertificateMapEntry response =
   *       certificateManagerClient
   *           .createCertificateMapEntryAsync(parent, certificateMapEntry, certificateMapEntryId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the certificate map entry. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificateMaps/&#42;`.
   * @param certificateMapEntry Required. A definition of the certificate map entry to create.
   * @param certificateMapEntryId Required. A user-provided name of the certificate map entry.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateMapEntry, OperationMetadata>
      createCertificateMapEntryAsync(
          String parent, CertificateMapEntry certificateMapEntry, String certificateMapEntryId) {
    CreateCertificateMapEntryRequest request =
        CreateCertificateMapEntryRequest.newBuilder()
            .setParent(parent)
            .setCertificateMapEntry(certificateMapEntry)
            .setCertificateMapEntryId(certificateMapEntryId)
            .build();
    return createCertificateMapEntryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateMapEntry in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateCertificateMapEntryRequest request =
   *       CreateCertificateMapEntryRequest.newBuilder()
   *           .setParent(
   *               CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
   *           .setCertificateMapEntryId("certificateMapEntryId-859079384")
   *           .setCertificateMapEntry(CertificateMapEntry.newBuilder().build())
   *           .build();
   *   CertificateMapEntry response =
   *       certificateManagerClient.createCertificateMapEntryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateMapEntry, OperationMetadata>
      createCertificateMapEntryAsync(CreateCertificateMapEntryRequest request) {
    return createCertificateMapEntryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateMapEntry in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateCertificateMapEntryRequest request =
   *       CreateCertificateMapEntryRequest.newBuilder()
   *           .setParent(
   *               CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
   *           .setCertificateMapEntryId("certificateMapEntryId-859079384")
   *           .setCertificateMapEntry(CertificateMapEntry.newBuilder().build())
   *           .build();
   *   OperationFuture<CertificateMapEntry, OperationMetadata> future =
   *       certificateManagerClient.createCertificateMapEntryOperationCallable().futureCall(request);
   *   // Do something.
   *   CertificateMapEntry response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
      createCertificateMapEntryOperationCallable() {
    return stub.createCertificateMapEntryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateMapEntry in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateCertificateMapEntryRequest request =
   *       CreateCertificateMapEntryRequest.newBuilder()
   *           .setParent(
   *               CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
   *           .setCertificateMapEntryId("certificateMapEntryId-859079384")
   *           .setCertificateMapEntry(CertificateMapEntry.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.createCertificateMapEntryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCertificateMapEntryRequest, Operation>
      createCertificateMapEntryCallable() {
    return stub.createCertificateMapEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CertificateMapEntry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CertificateMapEntry certificateMapEntry = CertificateMapEntry.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CertificateMapEntry response =
   *       certificateManagerClient
   *           .updateCertificateMapEntryAsync(certificateMapEntry, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param certificateMapEntry Required. A definition of the certificate map entry to create map
   *     entry.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateMapEntry, OperationMetadata>
      updateCertificateMapEntryAsync(
          CertificateMapEntry certificateMapEntry, FieldMask updateMask) {
    UpdateCertificateMapEntryRequest request =
        UpdateCertificateMapEntryRequest.newBuilder()
            .setCertificateMapEntry(certificateMapEntry)
            .setUpdateMask(updateMask)
            .build();
    return updateCertificateMapEntryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CertificateMapEntry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   UpdateCertificateMapEntryRequest request =
   *       UpdateCertificateMapEntryRequest.newBuilder()
   *           .setCertificateMapEntry(CertificateMapEntry.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CertificateMapEntry response =
   *       certificateManagerClient.updateCertificateMapEntryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateMapEntry, OperationMetadata>
      updateCertificateMapEntryAsync(UpdateCertificateMapEntryRequest request) {
    return updateCertificateMapEntryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CertificateMapEntry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   UpdateCertificateMapEntryRequest request =
   *       UpdateCertificateMapEntryRequest.newBuilder()
   *           .setCertificateMapEntry(CertificateMapEntry.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<CertificateMapEntry, OperationMetadata> future =
   *       certificateManagerClient.updateCertificateMapEntryOperationCallable().futureCall(request);
   *   // Do something.
   *   CertificateMapEntry response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
      updateCertificateMapEntryOperationCallable() {
    return stub.updateCertificateMapEntryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CertificateMapEntry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   UpdateCertificateMapEntryRequest request =
   *       UpdateCertificateMapEntryRequest.newBuilder()
   *           .setCertificateMapEntry(CertificateMapEntry.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.updateCertificateMapEntryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCertificateMapEntryRequest, Operation>
      updateCertificateMapEntryCallable() {
    return stub.updateCertificateMapEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateMapEntry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CertificateMapEntryName name =
   *       CertificateMapEntryName.of(
   *           "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]");
   *   certificateManagerClient.deleteCertificateMapEntryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate map entry to delete. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificateMaps/&#42;/certificateMapEntries/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateMapEntryAsync(
      CertificateMapEntryName name) {
    DeleteCertificateMapEntryRequest request =
        DeleteCertificateMapEntryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteCertificateMapEntryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateMapEntry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String name =
   *       CertificateMapEntryName.of(
   *               "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]")
   *           .toString();
   *   certificateManagerClient.deleteCertificateMapEntryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate map entry to delete. Must be in the format
   *     `projects/&#42;/locations/&#42;/certificateMaps/&#42;/certificateMapEntries/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateMapEntryAsync(
      String name) {
    DeleteCertificateMapEntryRequest request =
        DeleteCertificateMapEntryRequest.newBuilder().setName(name).build();
    return deleteCertificateMapEntryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateMapEntry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteCertificateMapEntryRequest request =
   *       DeleteCertificateMapEntryRequest.newBuilder()
   *           .setName(
   *               CertificateMapEntryName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]")
   *                   .toString())
   *           .build();
   *   certificateManagerClient.deleteCertificateMapEntryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateMapEntryAsync(
      DeleteCertificateMapEntryRequest request) {
    return deleteCertificateMapEntryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateMapEntry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteCertificateMapEntryRequest request =
   *       DeleteCertificateMapEntryRequest.newBuilder()
   *           .setName(
   *               CertificateMapEntryName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       certificateManagerClient.deleteCertificateMapEntryOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCertificateMapEntryRequest, Empty, OperationMetadata>
      deleteCertificateMapEntryOperationCallable() {
    return stub.deleteCertificateMapEntryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateMapEntry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteCertificateMapEntryRequest request =
   *       DeleteCertificateMapEntryRequest.newBuilder()
   *           .setName(
   *               CertificateMapEntryName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.deleteCertificateMapEntryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCertificateMapEntryRequest, Operation>
      deleteCertificateMapEntryCallable() {
    return stub.deleteCertificateMapEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DnsAuthorizations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DnsAuthorization element :
   *       certificateManagerClient.listDnsAuthorizations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the dns authorizations should be
   *     listed, specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDnsAuthorizationsPagedResponse listDnsAuthorizations(LocationName parent) {
    ListDnsAuthorizationsRequest request =
        ListDnsAuthorizationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDnsAuthorizations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DnsAuthorizations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DnsAuthorization element :
   *       certificateManagerClient.listDnsAuthorizations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the dns authorizations should be
   *     listed, specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDnsAuthorizationsPagedResponse listDnsAuthorizations(String parent) {
    ListDnsAuthorizationsRequest request =
        ListDnsAuthorizationsRequest.newBuilder().setParent(parent).build();
    return listDnsAuthorizations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DnsAuthorizations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListDnsAuthorizationsRequest request =
   *       ListDnsAuthorizationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DnsAuthorization element :
   *       certificateManagerClient.listDnsAuthorizations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDnsAuthorizationsPagedResponse listDnsAuthorizations(
      ListDnsAuthorizationsRequest request) {
    return listDnsAuthorizationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DnsAuthorizations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListDnsAuthorizationsRequest request =
   *       ListDnsAuthorizationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DnsAuthorization> future =
   *       certificateManagerClient.listDnsAuthorizationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DnsAuthorization element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDnsAuthorizationsRequest, ListDnsAuthorizationsPagedResponse>
      listDnsAuthorizationsPagedCallable() {
    return stub.listDnsAuthorizationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DnsAuthorizations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListDnsAuthorizationsRequest request =
   *       ListDnsAuthorizationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDnsAuthorizationsResponse response =
   *         certificateManagerClient.listDnsAuthorizationsCallable().call(request);
   *     for (DnsAuthorization element : response.getDnsAuthorizationsList()) {
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
  public final UnaryCallable<ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse>
      listDnsAuthorizationsCallable() {
    return stub.listDnsAuthorizationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DnsAuthorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DnsAuthorizationName name =
   *       DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]");
   *   DnsAuthorization response = certificateManagerClient.getDnsAuthorization(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the dns authorization to describe. Must be in the format
   *     `projects/&#42;/locations/&#42;/dnsAuthorizations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsAuthorization getDnsAuthorization(DnsAuthorizationName name) {
    GetDnsAuthorizationRequest request =
        GetDnsAuthorizationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDnsAuthorization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DnsAuthorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String name =
   *       DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]").toString();
   *   DnsAuthorization response = certificateManagerClient.getDnsAuthorization(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the dns authorization to describe. Must be in the format
   *     `projects/&#42;/locations/&#42;/dnsAuthorizations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsAuthorization getDnsAuthorization(String name) {
    GetDnsAuthorizationRequest request =
        GetDnsAuthorizationRequest.newBuilder().setName(name).build();
    return getDnsAuthorization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DnsAuthorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   GetDnsAuthorizationRequest request =
   *       GetDnsAuthorizationRequest.newBuilder()
   *           .setName(
   *               DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]")
   *                   .toString())
   *           .build();
   *   DnsAuthorization response = certificateManagerClient.getDnsAuthorization(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsAuthorization getDnsAuthorization(GetDnsAuthorizationRequest request) {
    return getDnsAuthorizationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DnsAuthorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   GetDnsAuthorizationRequest request =
   *       GetDnsAuthorizationRequest.newBuilder()
   *           .setName(
   *               DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DnsAuthorization> future =
   *       certificateManagerClient.getDnsAuthorizationCallable().futureCall(request);
   *   // Do something.
   *   DnsAuthorization response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDnsAuthorizationRequest, DnsAuthorization>
      getDnsAuthorizationCallable() {
    return stub.getDnsAuthorizationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DnsAuthorization in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DnsAuthorization dnsAuthorization = DnsAuthorization.newBuilder().build();
   *   String dnsAuthorizationId = "dnsAuthorizationId-2054763765";
   *   DnsAuthorization response =
   *       certificateManagerClient
   *           .createDnsAuthorizationAsync(parent, dnsAuthorization, dnsAuthorizationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the dns authorization. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param dnsAuthorization Required. A definition of the dns authorization to create.
   * @param dnsAuthorizationId Required. A user-provided name of the dns authorization.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DnsAuthorization, OperationMetadata> createDnsAuthorizationAsync(
      LocationName parent, DnsAuthorization dnsAuthorization, String dnsAuthorizationId) {
    CreateDnsAuthorizationRequest request =
        CreateDnsAuthorizationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDnsAuthorization(dnsAuthorization)
            .setDnsAuthorizationId(dnsAuthorizationId)
            .build();
    return createDnsAuthorizationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DnsAuthorization in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DnsAuthorization dnsAuthorization = DnsAuthorization.newBuilder().build();
   *   String dnsAuthorizationId = "dnsAuthorizationId-2054763765";
   *   DnsAuthorization response =
   *       certificateManagerClient
   *           .createDnsAuthorizationAsync(parent, dnsAuthorization, dnsAuthorizationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the dns authorization. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param dnsAuthorization Required. A definition of the dns authorization to create.
   * @param dnsAuthorizationId Required. A user-provided name of the dns authorization.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DnsAuthorization, OperationMetadata> createDnsAuthorizationAsync(
      String parent, DnsAuthorization dnsAuthorization, String dnsAuthorizationId) {
    CreateDnsAuthorizationRequest request =
        CreateDnsAuthorizationRequest.newBuilder()
            .setParent(parent)
            .setDnsAuthorization(dnsAuthorization)
            .setDnsAuthorizationId(dnsAuthorizationId)
            .build();
    return createDnsAuthorizationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DnsAuthorization in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateDnsAuthorizationRequest request =
   *       CreateDnsAuthorizationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDnsAuthorizationId("dnsAuthorizationId-2054763765")
   *           .setDnsAuthorization(DnsAuthorization.newBuilder().build())
   *           .build();
   *   DnsAuthorization response =
   *       certificateManagerClient.createDnsAuthorizationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DnsAuthorization, OperationMetadata> createDnsAuthorizationAsync(
      CreateDnsAuthorizationRequest request) {
    return createDnsAuthorizationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DnsAuthorization in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateDnsAuthorizationRequest request =
   *       CreateDnsAuthorizationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDnsAuthorizationId("dnsAuthorizationId-2054763765")
   *           .setDnsAuthorization(DnsAuthorization.newBuilder().build())
   *           .build();
   *   OperationFuture<DnsAuthorization, OperationMetadata> future =
   *       certificateManagerClient.createDnsAuthorizationOperationCallable().futureCall(request);
   *   // Do something.
   *   DnsAuthorization response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
      createDnsAuthorizationOperationCallable() {
    return stub.createDnsAuthorizationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DnsAuthorization in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateDnsAuthorizationRequest request =
   *       CreateDnsAuthorizationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDnsAuthorizationId("dnsAuthorizationId-2054763765")
   *           .setDnsAuthorization(DnsAuthorization.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.createDnsAuthorizationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDnsAuthorizationRequest, Operation>
      createDnsAuthorizationCallable() {
    return stub.createDnsAuthorizationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DnsAuthorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DnsAuthorization dnsAuthorization = DnsAuthorization.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DnsAuthorization response =
   *       certificateManagerClient.updateDnsAuthorizationAsync(dnsAuthorization, updateMask).get();
   * }
   * }</pre>
   *
   * @param dnsAuthorization Required. A definition of the dns authorization to update.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DnsAuthorization, OperationMetadata> updateDnsAuthorizationAsync(
      DnsAuthorization dnsAuthorization, FieldMask updateMask) {
    UpdateDnsAuthorizationRequest request =
        UpdateDnsAuthorizationRequest.newBuilder()
            .setDnsAuthorization(dnsAuthorization)
            .setUpdateMask(updateMask)
            .build();
    return updateDnsAuthorizationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DnsAuthorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   UpdateDnsAuthorizationRequest request =
   *       UpdateDnsAuthorizationRequest.newBuilder()
   *           .setDnsAuthorization(DnsAuthorization.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DnsAuthorization response =
   *       certificateManagerClient.updateDnsAuthorizationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DnsAuthorization, OperationMetadata> updateDnsAuthorizationAsync(
      UpdateDnsAuthorizationRequest request) {
    return updateDnsAuthorizationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DnsAuthorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   UpdateDnsAuthorizationRequest request =
   *       UpdateDnsAuthorizationRequest.newBuilder()
   *           .setDnsAuthorization(DnsAuthorization.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<DnsAuthorization, OperationMetadata> future =
   *       certificateManagerClient.updateDnsAuthorizationOperationCallable().futureCall(request);
   *   // Do something.
   *   DnsAuthorization response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
      updateDnsAuthorizationOperationCallable() {
    return stub.updateDnsAuthorizationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a DnsAuthorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   UpdateDnsAuthorizationRequest request =
   *       UpdateDnsAuthorizationRequest.newBuilder()
   *           .setDnsAuthorization(DnsAuthorization.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.updateDnsAuthorizationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDnsAuthorizationRequest, Operation>
      updateDnsAuthorizationCallable() {
    return stub.updateDnsAuthorizationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DnsAuthorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DnsAuthorizationName name =
   *       DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]");
   *   certificateManagerClient.deleteDnsAuthorizationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the dns authorization to delete. Must be in the format
   *     `projects/&#42;/locations/&#42;/dnsAuthorizations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDnsAuthorizationAsync(
      DnsAuthorizationName name) {
    DeleteDnsAuthorizationRequest request =
        DeleteDnsAuthorizationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDnsAuthorizationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DnsAuthorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String name =
   *       DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]").toString();
   *   certificateManagerClient.deleteDnsAuthorizationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the dns authorization to delete. Must be in the format
   *     `projects/&#42;/locations/&#42;/dnsAuthorizations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDnsAuthorizationAsync(String name) {
    DeleteDnsAuthorizationRequest request =
        DeleteDnsAuthorizationRequest.newBuilder().setName(name).build();
    return deleteDnsAuthorizationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DnsAuthorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteDnsAuthorizationRequest request =
   *       DeleteDnsAuthorizationRequest.newBuilder()
   *           .setName(
   *               DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]")
   *                   .toString())
   *           .build();
   *   certificateManagerClient.deleteDnsAuthorizationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDnsAuthorizationAsync(
      DeleteDnsAuthorizationRequest request) {
    return deleteDnsAuthorizationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DnsAuthorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteDnsAuthorizationRequest request =
   *       DeleteDnsAuthorizationRequest.newBuilder()
   *           .setName(
   *               DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       certificateManagerClient.deleteDnsAuthorizationOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDnsAuthorizationRequest, Empty, OperationMetadata>
      deleteDnsAuthorizationOperationCallable() {
    return stub.deleteDnsAuthorizationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DnsAuthorization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteDnsAuthorizationRequest request =
   *       DeleteDnsAuthorizationRequest.newBuilder()
   *           .setName(
   *               DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.deleteDnsAuthorizationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDnsAuthorizationRequest, Operation>
      deleteDnsAuthorizationCallable() {
    return stub.deleteDnsAuthorizationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateIssuanceConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CertificateIssuanceConfig element :
   *       certificateManagerClient.listCertificateIssuanceConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the certificate should be listed,
   *     specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateIssuanceConfigsPagedResponse listCertificateIssuanceConfigs(
      LocationName parent) {
    ListCertificateIssuanceConfigsRequest request =
        ListCertificateIssuanceConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCertificateIssuanceConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateIssuanceConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CertificateIssuanceConfig element :
   *       certificateManagerClient.listCertificateIssuanceConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the certificate should be listed,
   *     specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateIssuanceConfigsPagedResponse listCertificateIssuanceConfigs(
      String parent) {
    ListCertificateIssuanceConfigsRequest request =
        ListCertificateIssuanceConfigsRequest.newBuilder().setParent(parent).build();
    return listCertificateIssuanceConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateIssuanceConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListCertificateIssuanceConfigsRequest request =
   *       ListCertificateIssuanceConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CertificateIssuanceConfig element :
   *       certificateManagerClient.listCertificateIssuanceConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCertificateIssuanceConfigsPagedResponse listCertificateIssuanceConfigs(
      ListCertificateIssuanceConfigsRequest request) {
    return listCertificateIssuanceConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateIssuanceConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListCertificateIssuanceConfigsRequest request =
   *       ListCertificateIssuanceConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CertificateIssuanceConfig> future =
   *       certificateManagerClient
   *           .listCertificateIssuanceConfigsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (CertificateIssuanceConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListCertificateIssuanceConfigsRequest, ListCertificateIssuanceConfigsPagedResponse>
      listCertificateIssuanceConfigsPagedCallable() {
    return stub.listCertificateIssuanceConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CertificateIssuanceConfigs in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListCertificateIssuanceConfigsRequest request =
   *       ListCertificateIssuanceConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCertificateIssuanceConfigsResponse response =
   *         certificateManagerClient.listCertificateIssuanceConfigsCallable().call(request);
   *     for (CertificateIssuanceConfig element : response.getCertificateIssuanceConfigsList()) {
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
          ListCertificateIssuanceConfigsRequest, ListCertificateIssuanceConfigsResponse>
      listCertificateIssuanceConfigsCallable() {
    return stub.listCertificateIssuanceConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CertificateIssuanceConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CertificateIssuanceConfigName name =
   *       CertificateIssuanceConfigName.of(
   *           "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]");
   *   CertificateIssuanceConfig response =
   *       certificateManagerClient.getCertificateIssuanceConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate issuance config to describe. Must be in the
   *     format `projects/&#42;/locations/&#42;/certificateIssuanceConfigs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateIssuanceConfig getCertificateIssuanceConfig(
      CertificateIssuanceConfigName name) {
    GetCertificateIssuanceConfigRequest request =
        GetCertificateIssuanceConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCertificateIssuanceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CertificateIssuanceConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String name =
   *       CertificateIssuanceConfigName.of(
   *               "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]")
   *           .toString();
   *   CertificateIssuanceConfig response =
   *       certificateManagerClient.getCertificateIssuanceConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate issuance config to describe. Must be in the
   *     format `projects/&#42;/locations/&#42;/certificateIssuanceConfigs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateIssuanceConfig getCertificateIssuanceConfig(String name) {
    GetCertificateIssuanceConfigRequest request =
        GetCertificateIssuanceConfigRequest.newBuilder().setName(name).build();
    return getCertificateIssuanceConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CertificateIssuanceConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   GetCertificateIssuanceConfigRequest request =
   *       GetCertificateIssuanceConfigRequest.newBuilder()
   *           .setName(
   *               CertificateIssuanceConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]")
   *                   .toString())
   *           .build();
   *   CertificateIssuanceConfig response =
   *       certificateManagerClient.getCertificateIssuanceConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateIssuanceConfig getCertificateIssuanceConfig(
      GetCertificateIssuanceConfigRequest request) {
    return getCertificateIssuanceConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CertificateIssuanceConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   GetCertificateIssuanceConfigRequest request =
   *       GetCertificateIssuanceConfigRequest.newBuilder()
   *           .setName(
   *               CertificateIssuanceConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CertificateIssuanceConfig> future =
   *       certificateManagerClient.getCertificateIssuanceConfigCallable().futureCall(request);
   *   // Do something.
   *   CertificateIssuanceConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCertificateIssuanceConfigRequest, CertificateIssuanceConfig>
      getCertificateIssuanceConfigCallable() {
    return stub.getCertificateIssuanceConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateIssuanceConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CertificateIssuanceConfig certificateIssuanceConfig =
   *       CertificateIssuanceConfig.newBuilder().build();
   *   String certificateIssuanceConfigId = "certificateIssuanceConfigId1910303023";
   *   CertificateIssuanceConfig response =
   *       certificateManagerClient
   *           .createCertificateIssuanceConfigAsync(
   *               parent, certificateIssuanceConfig, certificateIssuanceConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the certificate issuance config. Must be in the
   *     format `projects/&#42;/locations/&#42;`.
   * @param certificateIssuanceConfig Required. A definition of the certificate issuance config to
   *     create.
   * @param certificateIssuanceConfigId Required. A user-provided name of the certificate config.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateIssuanceConfig, OperationMetadata>
      createCertificateIssuanceConfigAsync(
          LocationName parent,
          CertificateIssuanceConfig certificateIssuanceConfig,
          String certificateIssuanceConfigId) {
    CreateCertificateIssuanceConfigRequest request =
        CreateCertificateIssuanceConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCertificateIssuanceConfig(certificateIssuanceConfig)
            .setCertificateIssuanceConfigId(certificateIssuanceConfigId)
            .build();
    return createCertificateIssuanceConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateIssuanceConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CertificateIssuanceConfig certificateIssuanceConfig =
   *       CertificateIssuanceConfig.newBuilder().build();
   *   String certificateIssuanceConfigId = "certificateIssuanceConfigId1910303023";
   *   CertificateIssuanceConfig response =
   *       certificateManagerClient
   *           .createCertificateIssuanceConfigAsync(
   *               parent, certificateIssuanceConfig, certificateIssuanceConfigId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the certificate issuance config. Must be in the
   *     format `projects/&#42;/locations/&#42;`.
   * @param certificateIssuanceConfig Required. A definition of the certificate issuance config to
   *     create.
   * @param certificateIssuanceConfigId Required. A user-provided name of the certificate config.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateIssuanceConfig, OperationMetadata>
      createCertificateIssuanceConfigAsync(
          String parent,
          CertificateIssuanceConfig certificateIssuanceConfig,
          String certificateIssuanceConfigId) {
    CreateCertificateIssuanceConfigRequest request =
        CreateCertificateIssuanceConfigRequest.newBuilder()
            .setParent(parent)
            .setCertificateIssuanceConfig(certificateIssuanceConfig)
            .setCertificateIssuanceConfigId(certificateIssuanceConfigId)
            .build();
    return createCertificateIssuanceConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateIssuanceConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateCertificateIssuanceConfigRequest request =
   *       CreateCertificateIssuanceConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateIssuanceConfigId("certificateIssuanceConfigId1910303023")
   *           .setCertificateIssuanceConfig(CertificateIssuanceConfig.newBuilder().build())
   *           .build();
   *   CertificateIssuanceConfig response =
   *       certificateManagerClient.createCertificateIssuanceConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CertificateIssuanceConfig, OperationMetadata>
      createCertificateIssuanceConfigAsync(CreateCertificateIssuanceConfigRequest request) {
    return createCertificateIssuanceConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateIssuanceConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateCertificateIssuanceConfigRequest request =
   *       CreateCertificateIssuanceConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateIssuanceConfigId("certificateIssuanceConfigId1910303023")
   *           .setCertificateIssuanceConfig(CertificateIssuanceConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<CertificateIssuanceConfig, OperationMetadata> future =
   *       certificateManagerClient
   *           .createCertificateIssuanceConfigOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CertificateIssuanceConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateCertificateIssuanceConfigRequest, CertificateIssuanceConfig, OperationMetadata>
      createCertificateIssuanceConfigOperationCallable() {
    return stub.createCertificateIssuanceConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CertificateIssuanceConfig in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CreateCertificateIssuanceConfigRequest request =
   *       CreateCertificateIssuanceConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCertificateIssuanceConfigId("certificateIssuanceConfigId1910303023")
   *           .setCertificateIssuanceConfig(CertificateIssuanceConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.createCertificateIssuanceConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCertificateIssuanceConfigRequest, Operation>
      createCertificateIssuanceConfigCallable() {
    return stub.createCertificateIssuanceConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateIssuanceConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   CertificateIssuanceConfigName name =
   *       CertificateIssuanceConfigName.of(
   *           "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]");
   *   certificateManagerClient.deleteCertificateIssuanceConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate issuance config to delete. Must be in the
   *     format `projects/&#42;/locations/&#42;/certificateIssuanceConfigs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateIssuanceConfigAsync(
      CertificateIssuanceConfigName name) {
    DeleteCertificateIssuanceConfigRequest request =
        DeleteCertificateIssuanceConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteCertificateIssuanceConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateIssuanceConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   String name =
   *       CertificateIssuanceConfigName.of(
   *               "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]")
   *           .toString();
   *   certificateManagerClient.deleteCertificateIssuanceConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the certificate issuance config to delete. Must be in the
   *     format `projects/&#42;/locations/&#42;/certificateIssuanceConfigs/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateIssuanceConfigAsync(
      String name) {
    DeleteCertificateIssuanceConfigRequest request =
        DeleteCertificateIssuanceConfigRequest.newBuilder().setName(name).build();
    return deleteCertificateIssuanceConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateIssuanceConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteCertificateIssuanceConfigRequest request =
   *       DeleteCertificateIssuanceConfigRequest.newBuilder()
   *           .setName(
   *               CertificateIssuanceConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]")
   *                   .toString())
   *           .build();
   *   certificateManagerClient.deleteCertificateIssuanceConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCertificateIssuanceConfigAsync(
      DeleteCertificateIssuanceConfigRequest request) {
    return deleteCertificateIssuanceConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateIssuanceConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteCertificateIssuanceConfigRequest request =
   *       DeleteCertificateIssuanceConfigRequest.newBuilder()
   *           .setName(
   *               CertificateIssuanceConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       certificateManagerClient
   *           .deleteCertificateIssuanceConfigOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCertificateIssuanceConfigRequest, Empty, OperationMetadata>
      deleteCertificateIssuanceConfigOperationCallable() {
    return stub.deleteCertificateIssuanceConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CertificateIssuanceConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   DeleteCertificateIssuanceConfigRequest request =
   *       DeleteCertificateIssuanceConfigRequest.newBuilder()
   *           .setName(
   *               CertificateIssuanceConfigName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       certificateManagerClient.deleteCertificateIssuanceConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCertificateIssuanceConfigRequest, Operation>
      deleteCertificateIssuanceConfigCallable() {
    return stub.deleteCertificateIssuanceConfigCallable();
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
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : certificateManagerClient.listLocations(request).iterateAll()) {
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
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       certificateManagerClient.listLocationsPagedCallable().futureCall(request);
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
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         certificateManagerClient.listLocationsCallable().call(request);
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
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = certificateManagerClient.getLocation(request);
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
   * try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       certificateManagerClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListCertificateMapsPagedResponse
      extends AbstractPagedListResponse<
          ListCertificateMapsRequest,
          ListCertificateMapsResponse,
          CertificateMap,
          ListCertificateMapsPage,
          ListCertificateMapsFixedSizeCollection> {

    public static ApiFuture<ListCertificateMapsPagedResponse> createAsync(
        PageContext<ListCertificateMapsRequest, ListCertificateMapsResponse, CertificateMap>
            context,
        ApiFuture<ListCertificateMapsResponse> futureResponse) {
      ApiFuture<ListCertificateMapsPage> futurePage =
          ListCertificateMapsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCertificateMapsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCertificateMapsPagedResponse(ListCertificateMapsPage page) {
      super(page, ListCertificateMapsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCertificateMapsPage
      extends AbstractPage<
          ListCertificateMapsRequest,
          ListCertificateMapsResponse,
          CertificateMap,
          ListCertificateMapsPage> {

    private ListCertificateMapsPage(
        PageContext<ListCertificateMapsRequest, ListCertificateMapsResponse, CertificateMap>
            context,
        ListCertificateMapsResponse response) {
      super(context, response);
    }

    private static ListCertificateMapsPage createEmptyPage() {
      return new ListCertificateMapsPage(null, null);
    }

    @Override
    protected ListCertificateMapsPage createPage(
        PageContext<ListCertificateMapsRequest, ListCertificateMapsResponse, CertificateMap>
            context,
        ListCertificateMapsResponse response) {
      return new ListCertificateMapsPage(context, response);
    }

    @Override
    public ApiFuture<ListCertificateMapsPage> createPageAsync(
        PageContext<ListCertificateMapsRequest, ListCertificateMapsResponse, CertificateMap>
            context,
        ApiFuture<ListCertificateMapsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCertificateMapsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCertificateMapsRequest,
          ListCertificateMapsResponse,
          CertificateMap,
          ListCertificateMapsPage,
          ListCertificateMapsFixedSizeCollection> {

    private ListCertificateMapsFixedSizeCollection(
        List<ListCertificateMapsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCertificateMapsFixedSizeCollection createEmptyCollection() {
      return new ListCertificateMapsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCertificateMapsFixedSizeCollection createCollection(
        List<ListCertificateMapsPage> pages, int collectionSize) {
      return new ListCertificateMapsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCertificateMapEntriesPagedResponse
      extends AbstractPagedListResponse<
          ListCertificateMapEntriesRequest,
          ListCertificateMapEntriesResponse,
          CertificateMapEntry,
          ListCertificateMapEntriesPage,
          ListCertificateMapEntriesFixedSizeCollection> {

    public static ApiFuture<ListCertificateMapEntriesPagedResponse> createAsync(
        PageContext<
                ListCertificateMapEntriesRequest,
                ListCertificateMapEntriesResponse,
                CertificateMapEntry>
            context,
        ApiFuture<ListCertificateMapEntriesResponse> futureResponse) {
      ApiFuture<ListCertificateMapEntriesPage> futurePage =
          ListCertificateMapEntriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCertificateMapEntriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCertificateMapEntriesPagedResponse(ListCertificateMapEntriesPage page) {
      super(page, ListCertificateMapEntriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCertificateMapEntriesPage
      extends AbstractPage<
          ListCertificateMapEntriesRequest,
          ListCertificateMapEntriesResponse,
          CertificateMapEntry,
          ListCertificateMapEntriesPage> {

    private ListCertificateMapEntriesPage(
        PageContext<
                ListCertificateMapEntriesRequest,
                ListCertificateMapEntriesResponse,
                CertificateMapEntry>
            context,
        ListCertificateMapEntriesResponse response) {
      super(context, response);
    }

    private static ListCertificateMapEntriesPage createEmptyPage() {
      return new ListCertificateMapEntriesPage(null, null);
    }

    @Override
    protected ListCertificateMapEntriesPage createPage(
        PageContext<
                ListCertificateMapEntriesRequest,
                ListCertificateMapEntriesResponse,
                CertificateMapEntry>
            context,
        ListCertificateMapEntriesResponse response) {
      return new ListCertificateMapEntriesPage(context, response);
    }

    @Override
    public ApiFuture<ListCertificateMapEntriesPage> createPageAsync(
        PageContext<
                ListCertificateMapEntriesRequest,
                ListCertificateMapEntriesResponse,
                CertificateMapEntry>
            context,
        ApiFuture<ListCertificateMapEntriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCertificateMapEntriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCertificateMapEntriesRequest,
          ListCertificateMapEntriesResponse,
          CertificateMapEntry,
          ListCertificateMapEntriesPage,
          ListCertificateMapEntriesFixedSizeCollection> {

    private ListCertificateMapEntriesFixedSizeCollection(
        List<ListCertificateMapEntriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCertificateMapEntriesFixedSizeCollection createEmptyCollection() {
      return new ListCertificateMapEntriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCertificateMapEntriesFixedSizeCollection createCollection(
        List<ListCertificateMapEntriesPage> pages, int collectionSize) {
      return new ListCertificateMapEntriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDnsAuthorizationsPagedResponse
      extends AbstractPagedListResponse<
          ListDnsAuthorizationsRequest,
          ListDnsAuthorizationsResponse,
          DnsAuthorization,
          ListDnsAuthorizationsPage,
          ListDnsAuthorizationsFixedSizeCollection> {

    public static ApiFuture<ListDnsAuthorizationsPagedResponse> createAsync(
        PageContext<ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse, DnsAuthorization>
            context,
        ApiFuture<ListDnsAuthorizationsResponse> futureResponse) {
      ApiFuture<ListDnsAuthorizationsPage> futurePage =
          ListDnsAuthorizationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDnsAuthorizationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDnsAuthorizationsPagedResponse(ListDnsAuthorizationsPage page) {
      super(page, ListDnsAuthorizationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDnsAuthorizationsPage
      extends AbstractPage<
          ListDnsAuthorizationsRequest,
          ListDnsAuthorizationsResponse,
          DnsAuthorization,
          ListDnsAuthorizationsPage> {

    private ListDnsAuthorizationsPage(
        PageContext<ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse, DnsAuthorization>
            context,
        ListDnsAuthorizationsResponse response) {
      super(context, response);
    }

    private static ListDnsAuthorizationsPage createEmptyPage() {
      return new ListDnsAuthorizationsPage(null, null);
    }

    @Override
    protected ListDnsAuthorizationsPage createPage(
        PageContext<ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse, DnsAuthorization>
            context,
        ListDnsAuthorizationsResponse response) {
      return new ListDnsAuthorizationsPage(context, response);
    }

    @Override
    public ApiFuture<ListDnsAuthorizationsPage> createPageAsync(
        PageContext<ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse, DnsAuthorization>
            context,
        ApiFuture<ListDnsAuthorizationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDnsAuthorizationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDnsAuthorizationsRequest,
          ListDnsAuthorizationsResponse,
          DnsAuthorization,
          ListDnsAuthorizationsPage,
          ListDnsAuthorizationsFixedSizeCollection> {

    private ListDnsAuthorizationsFixedSizeCollection(
        List<ListDnsAuthorizationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDnsAuthorizationsFixedSizeCollection createEmptyCollection() {
      return new ListDnsAuthorizationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDnsAuthorizationsFixedSizeCollection createCollection(
        List<ListDnsAuthorizationsPage> pages, int collectionSize) {
      return new ListDnsAuthorizationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCertificateIssuanceConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListCertificateIssuanceConfigsRequest,
          ListCertificateIssuanceConfigsResponse,
          CertificateIssuanceConfig,
          ListCertificateIssuanceConfigsPage,
          ListCertificateIssuanceConfigsFixedSizeCollection> {

    public static ApiFuture<ListCertificateIssuanceConfigsPagedResponse> createAsync(
        PageContext<
                ListCertificateIssuanceConfigsRequest,
                ListCertificateIssuanceConfigsResponse,
                CertificateIssuanceConfig>
            context,
        ApiFuture<ListCertificateIssuanceConfigsResponse> futureResponse) {
      ApiFuture<ListCertificateIssuanceConfigsPage> futurePage =
          ListCertificateIssuanceConfigsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCertificateIssuanceConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCertificateIssuanceConfigsPagedResponse(ListCertificateIssuanceConfigsPage page) {
      super(page, ListCertificateIssuanceConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCertificateIssuanceConfigsPage
      extends AbstractPage<
          ListCertificateIssuanceConfigsRequest,
          ListCertificateIssuanceConfigsResponse,
          CertificateIssuanceConfig,
          ListCertificateIssuanceConfigsPage> {

    private ListCertificateIssuanceConfigsPage(
        PageContext<
                ListCertificateIssuanceConfigsRequest,
                ListCertificateIssuanceConfigsResponse,
                CertificateIssuanceConfig>
            context,
        ListCertificateIssuanceConfigsResponse response) {
      super(context, response);
    }

    private static ListCertificateIssuanceConfigsPage createEmptyPage() {
      return new ListCertificateIssuanceConfigsPage(null, null);
    }

    @Override
    protected ListCertificateIssuanceConfigsPage createPage(
        PageContext<
                ListCertificateIssuanceConfigsRequest,
                ListCertificateIssuanceConfigsResponse,
                CertificateIssuanceConfig>
            context,
        ListCertificateIssuanceConfigsResponse response) {
      return new ListCertificateIssuanceConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListCertificateIssuanceConfigsPage> createPageAsync(
        PageContext<
                ListCertificateIssuanceConfigsRequest,
                ListCertificateIssuanceConfigsResponse,
                CertificateIssuanceConfig>
            context,
        ApiFuture<ListCertificateIssuanceConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCertificateIssuanceConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCertificateIssuanceConfigsRequest,
          ListCertificateIssuanceConfigsResponse,
          CertificateIssuanceConfig,
          ListCertificateIssuanceConfigsPage,
          ListCertificateIssuanceConfigsFixedSizeCollection> {

    private ListCertificateIssuanceConfigsFixedSizeCollection(
        List<ListCertificateIssuanceConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCertificateIssuanceConfigsFixedSizeCollection createEmptyCollection() {
      return new ListCertificateIssuanceConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCertificateIssuanceConfigsFixedSizeCollection createCollection(
        List<ListCertificateIssuanceConfigsPage> pages, int collectionSize) {
      return new ListCertificateIssuanceConfigsFixedSizeCollection(pages, collectionSize);
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
