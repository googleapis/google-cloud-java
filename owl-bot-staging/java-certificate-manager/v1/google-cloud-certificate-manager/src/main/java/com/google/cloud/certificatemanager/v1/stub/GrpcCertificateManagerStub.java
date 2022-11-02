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

package com.google.cloud.certificatemanager.v1.stub;

import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificateIssuanceConfigsPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificateMapEntriesPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificateMapsPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificatesPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListDnsAuthorizationsPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.certificatemanager.v1.Certificate;
import com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig;
import com.google.cloud.certificatemanager.v1.CertificateMap;
import com.google.cloud.certificatemanager.v1.CertificateMapEntry;
import com.google.cloud.certificatemanager.v1.CreateCertificateIssuanceConfigRequest;
import com.google.cloud.certificatemanager.v1.CreateCertificateMapEntryRequest;
import com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest;
import com.google.cloud.certificatemanager.v1.CreateCertificateRequest;
import com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest;
import com.google.cloud.certificatemanager.v1.DeleteCertificateIssuanceConfigRequest;
import com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest;
import com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest;
import com.google.cloud.certificatemanager.v1.DeleteCertificateRequest;
import com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest;
import com.google.cloud.certificatemanager.v1.DnsAuthorization;
import com.google.cloud.certificatemanager.v1.GetCertificateIssuanceConfigRequest;
import com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest;
import com.google.cloud.certificatemanager.v1.GetCertificateMapRequest;
import com.google.cloud.certificatemanager.v1.GetCertificateRequest;
import com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest;
import com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsRequest;
import com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsResponse;
import com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesRequest;
import com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesResponse;
import com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest;
import com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse;
import com.google.cloud.certificatemanager.v1.ListCertificatesRequest;
import com.google.cloud.certificatemanager.v1.ListCertificatesResponse;
import com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest;
import com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse;
import com.google.cloud.certificatemanager.v1.OperationMetadata;
import com.google.cloud.certificatemanager.v1.UpdateCertificateMapEntryRequest;
import com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest;
import com.google.cloud.certificatemanager.v1.UpdateCertificateRequest;
import com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CertificateManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCertificateManagerStub extends CertificateManagerStub {
  private static final MethodDescriptor<ListCertificatesRequest, ListCertificatesResponse>
      listCertificatesMethodDescriptor =
          MethodDescriptor.<ListCertificatesRequest, ListCertificatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/ListCertificates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCertificatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCertificatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCertificateRequest, Certificate>
      getCertificateMethodDescriptor =
          MethodDescriptor.<GetCertificateRequest, Certificate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/GetCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Certificate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCertificateRequest, Operation>
      createCertificateMethodDescriptor =
          MethodDescriptor.<CreateCertificateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/CreateCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCertificateRequest, Operation>
      updateCertificateMethodDescriptor =
          MethodDescriptor.<UpdateCertificateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/UpdateCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCertificateRequest, Operation>
      deleteCertificateMethodDescriptor =
          MethodDescriptor.<DeleteCertificateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/DeleteCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCertificateMapsRequest, ListCertificateMapsResponse>
      listCertificateMapsMethodDescriptor =
          MethodDescriptor.<ListCertificateMapsRequest, ListCertificateMapsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/ListCertificateMaps")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCertificateMapsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCertificateMapsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCertificateMapRequest, CertificateMap>
      getCertificateMapMethodDescriptor =
          MethodDescriptor.<GetCertificateMapRequest, CertificateMap>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/GetCertificateMap")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCertificateMapRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CertificateMap.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCertificateMapRequest, Operation>
      createCertificateMapMethodDescriptor =
          MethodDescriptor.<CreateCertificateMapRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/CreateCertificateMap")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCertificateMapRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCertificateMapRequest, Operation>
      updateCertificateMapMethodDescriptor =
          MethodDescriptor.<UpdateCertificateMapRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/UpdateCertificateMap")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCertificateMapRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCertificateMapRequest, Operation>
      deleteCertificateMapMethodDescriptor =
          MethodDescriptor.<DeleteCertificateMapRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/DeleteCertificateMap")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCertificateMapRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListCertificateMapEntriesRequest, ListCertificateMapEntriesResponse>
      listCertificateMapEntriesMethodDescriptor =
          MethodDescriptor
              .<ListCertificateMapEntriesRequest, ListCertificateMapEntriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/ListCertificateMapEntries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCertificateMapEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCertificateMapEntriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCertificateMapEntryRequest, CertificateMapEntry>
      getCertificateMapEntryMethodDescriptor =
          MethodDescriptor.<GetCertificateMapEntryRequest, CertificateMapEntry>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/GetCertificateMapEntry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCertificateMapEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CertificateMapEntry.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCertificateMapEntryRequest, Operation>
      createCertificateMapEntryMethodDescriptor =
          MethodDescriptor.<CreateCertificateMapEntryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/CreateCertificateMapEntry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCertificateMapEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCertificateMapEntryRequest, Operation>
      updateCertificateMapEntryMethodDescriptor =
          MethodDescriptor.<UpdateCertificateMapEntryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/UpdateCertificateMapEntry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCertificateMapEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCertificateMapEntryRequest, Operation>
      deleteCertificateMapEntryMethodDescriptor =
          MethodDescriptor.<DeleteCertificateMapEntryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/DeleteCertificateMapEntry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCertificateMapEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse>
      listDnsAuthorizationsMethodDescriptor =
          MethodDescriptor.<ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/ListDnsAuthorizations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDnsAuthorizationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDnsAuthorizationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDnsAuthorizationRequest, DnsAuthorization>
      getDnsAuthorizationMethodDescriptor =
          MethodDescriptor.<GetDnsAuthorizationRequest, DnsAuthorization>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/GetDnsAuthorization")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDnsAuthorizationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DnsAuthorization.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDnsAuthorizationRequest, Operation>
      createDnsAuthorizationMethodDescriptor =
          MethodDescriptor.<CreateDnsAuthorizationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/CreateDnsAuthorization")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDnsAuthorizationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDnsAuthorizationRequest, Operation>
      updateDnsAuthorizationMethodDescriptor =
          MethodDescriptor.<UpdateDnsAuthorizationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/UpdateDnsAuthorization")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDnsAuthorizationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDnsAuthorizationRequest, Operation>
      deleteDnsAuthorizationMethodDescriptor =
          MethodDescriptor.<DeleteDnsAuthorizationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/DeleteDnsAuthorization")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDnsAuthorizationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListCertificateIssuanceConfigsRequest, ListCertificateIssuanceConfigsResponse>
      listCertificateIssuanceConfigsMethodDescriptor =
          MethodDescriptor
              .<ListCertificateIssuanceConfigsRequest, ListCertificateIssuanceConfigsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/ListCertificateIssuanceConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCertificateIssuanceConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListCertificateIssuanceConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetCertificateIssuanceConfigRequest, CertificateIssuanceConfig>
      getCertificateIssuanceConfigMethodDescriptor =
          MethodDescriptor
              .<GetCertificateIssuanceConfigRequest, CertificateIssuanceConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/GetCertificateIssuanceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCertificateIssuanceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CertificateIssuanceConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCertificateIssuanceConfigRequest, Operation>
      createCertificateIssuanceConfigMethodDescriptor =
          MethodDescriptor.<CreateCertificateIssuanceConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/CreateCertificateIssuanceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateCertificateIssuanceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCertificateIssuanceConfigRequest, Operation>
      deleteCertificateIssuanceConfigMethodDescriptor =
          MethodDescriptor.<DeleteCertificateIssuanceConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.certificatemanager.v1.CertificateManager/DeleteCertificateIssuanceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteCertificateIssuanceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListCertificatesRequest, ListCertificatesResponse>
      listCertificatesCallable;
  private final UnaryCallable<ListCertificatesRequest, ListCertificatesPagedResponse>
      listCertificatesPagedCallable;
  private final UnaryCallable<GetCertificateRequest, Certificate> getCertificateCallable;
  private final UnaryCallable<CreateCertificateRequest, Operation> createCertificateCallable;
  private final OperationCallable<CreateCertificateRequest, Certificate, OperationMetadata>
      createCertificateOperationCallable;
  private final UnaryCallable<UpdateCertificateRequest, Operation> updateCertificateCallable;
  private final OperationCallable<UpdateCertificateRequest, Certificate, OperationMetadata>
      updateCertificateOperationCallable;
  private final UnaryCallable<DeleteCertificateRequest, Operation> deleteCertificateCallable;
  private final OperationCallable<DeleteCertificateRequest, Empty, OperationMetadata>
      deleteCertificateOperationCallable;
  private final UnaryCallable<ListCertificateMapsRequest, ListCertificateMapsResponse>
      listCertificateMapsCallable;
  private final UnaryCallable<ListCertificateMapsRequest, ListCertificateMapsPagedResponse>
      listCertificateMapsPagedCallable;
  private final UnaryCallable<GetCertificateMapRequest, CertificateMap> getCertificateMapCallable;
  private final UnaryCallable<CreateCertificateMapRequest, Operation> createCertificateMapCallable;
  private final OperationCallable<CreateCertificateMapRequest, CertificateMap, OperationMetadata>
      createCertificateMapOperationCallable;
  private final UnaryCallable<UpdateCertificateMapRequest, Operation> updateCertificateMapCallable;
  private final OperationCallable<UpdateCertificateMapRequest, CertificateMap, OperationMetadata>
      updateCertificateMapOperationCallable;
  private final UnaryCallable<DeleteCertificateMapRequest, Operation> deleteCertificateMapCallable;
  private final OperationCallable<DeleteCertificateMapRequest, Empty, OperationMetadata>
      deleteCertificateMapOperationCallable;
  private final UnaryCallable<ListCertificateMapEntriesRequest, ListCertificateMapEntriesResponse>
      listCertificateMapEntriesCallable;
  private final UnaryCallable<
          ListCertificateMapEntriesRequest, ListCertificateMapEntriesPagedResponse>
      listCertificateMapEntriesPagedCallable;
  private final UnaryCallable<GetCertificateMapEntryRequest, CertificateMapEntry>
      getCertificateMapEntryCallable;
  private final UnaryCallable<CreateCertificateMapEntryRequest, Operation>
      createCertificateMapEntryCallable;
  private final OperationCallable<
          CreateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
      createCertificateMapEntryOperationCallable;
  private final UnaryCallable<UpdateCertificateMapEntryRequest, Operation>
      updateCertificateMapEntryCallable;
  private final OperationCallable<
          UpdateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
      updateCertificateMapEntryOperationCallable;
  private final UnaryCallable<DeleteCertificateMapEntryRequest, Operation>
      deleteCertificateMapEntryCallable;
  private final OperationCallable<DeleteCertificateMapEntryRequest, Empty, OperationMetadata>
      deleteCertificateMapEntryOperationCallable;
  private final UnaryCallable<ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse>
      listDnsAuthorizationsCallable;
  private final UnaryCallable<ListDnsAuthorizationsRequest, ListDnsAuthorizationsPagedResponse>
      listDnsAuthorizationsPagedCallable;
  private final UnaryCallable<GetDnsAuthorizationRequest, DnsAuthorization>
      getDnsAuthorizationCallable;
  private final UnaryCallable<CreateDnsAuthorizationRequest, Operation>
      createDnsAuthorizationCallable;
  private final OperationCallable<
          CreateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
      createDnsAuthorizationOperationCallable;
  private final UnaryCallable<UpdateDnsAuthorizationRequest, Operation>
      updateDnsAuthorizationCallable;
  private final OperationCallable<
          UpdateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
      updateDnsAuthorizationOperationCallable;
  private final UnaryCallable<DeleteDnsAuthorizationRequest, Operation>
      deleteDnsAuthorizationCallable;
  private final OperationCallable<DeleteDnsAuthorizationRequest, Empty, OperationMetadata>
      deleteDnsAuthorizationOperationCallable;
  private final UnaryCallable<
          ListCertificateIssuanceConfigsRequest, ListCertificateIssuanceConfigsResponse>
      listCertificateIssuanceConfigsCallable;
  private final UnaryCallable<
          ListCertificateIssuanceConfigsRequest, ListCertificateIssuanceConfigsPagedResponse>
      listCertificateIssuanceConfigsPagedCallable;
  private final UnaryCallable<GetCertificateIssuanceConfigRequest, CertificateIssuanceConfig>
      getCertificateIssuanceConfigCallable;
  private final UnaryCallable<CreateCertificateIssuanceConfigRequest, Operation>
      createCertificateIssuanceConfigCallable;
  private final OperationCallable<
          CreateCertificateIssuanceConfigRequest, CertificateIssuanceConfig, OperationMetadata>
      createCertificateIssuanceConfigOperationCallable;
  private final UnaryCallable<DeleteCertificateIssuanceConfigRequest, Operation>
      deleteCertificateIssuanceConfigCallable;
  private final OperationCallable<DeleteCertificateIssuanceConfigRequest, Empty, OperationMetadata>
      deleteCertificateIssuanceConfigOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCertificateManagerStub create(CertificateManagerStubSettings settings)
      throws IOException {
    return new GrpcCertificateManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCertificateManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCertificateManagerStub(
        CertificateManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCertificateManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCertificateManagerStub(
        CertificateManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCertificateManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCertificateManagerStub(
      CertificateManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCertificateManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCertificateManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCertificateManagerStub(
      CertificateManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListCertificatesRequest, ListCertificatesResponse>
        listCertificatesTransportSettings =
            GrpcCallSettings.<ListCertificatesRequest, ListCertificatesResponse>newBuilder()
                .setMethodDescriptor(listCertificatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetCertificateRequest, Certificate> getCertificateTransportSettings =
        GrpcCallSettings.<GetCertificateRequest, Certificate>newBuilder()
            .setMethodDescriptor(getCertificateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateCertificateRequest, Operation> createCertificateTransportSettings =
        GrpcCallSettings.<CreateCertificateRequest, Operation>newBuilder()
            .setMethodDescriptor(createCertificateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateCertificateRequest, Operation> updateCertificateTransportSettings =
        GrpcCallSettings.<UpdateCertificateRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCertificateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "certificate.name", String.valueOf(request.getCertificate().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteCertificateRequest, Operation> deleteCertificateTransportSettings =
        GrpcCallSettings.<DeleteCertificateRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCertificateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListCertificateMapsRequest, ListCertificateMapsResponse>
        listCertificateMapsTransportSettings =
            GrpcCallSettings.<ListCertificateMapsRequest, ListCertificateMapsResponse>newBuilder()
                .setMethodDescriptor(listCertificateMapsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetCertificateMapRequest, CertificateMap> getCertificateMapTransportSettings =
        GrpcCallSettings.<GetCertificateMapRequest, CertificateMap>newBuilder()
            .setMethodDescriptor(getCertificateMapMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateCertificateMapRequest, Operation> createCertificateMapTransportSettings =
        GrpcCallSettings.<CreateCertificateMapRequest, Operation>newBuilder()
            .setMethodDescriptor(createCertificateMapMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateCertificateMapRequest, Operation> updateCertificateMapTransportSettings =
        GrpcCallSettings.<UpdateCertificateMapRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCertificateMapMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "certificate_map.name",
                      String.valueOf(request.getCertificateMap().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteCertificateMapRequest, Operation> deleteCertificateMapTransportSettings =
        GrpcCallSettings.<DeleteCertificateMapRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCertificateMapMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListCertificateMapEntriesRequest, ListCertificateMapEntriesResponse>
        listCertificateMapEntriesTransportSettings =
            GrpcCallSettings
                .<ListCertificateMapEntriesRequest, ListCertificateMapEntriesResponse>newBuilder()
                .setMethodDescriptor(listCertificateMapEntriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetCertificateMapEntryRequest, CertificateMapEntry>
        getCertificateMapEntryTransportSettings =
            GrpcCallSettings.<GetCertificateMapEntryRequest, CertificateMapEntry>newBuilder()
                .setMethodDescriptor(getCertificateMapEntryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateCertificateMapEntryRequest, Operation>
        createCertificateMapEntryTransportSettings =
            GrpcCallSettings.<CreateCertificateMapEntryRequest, Operation>newBuilder()
                .setMethodDescriptor(createCertificateMapEntryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateCertificateMapEntryRequest, Operation>
        updateCertificateMapEntryTransportSettings =
            GrpcCallSettings.<UpdateCertificateMapEntryRequest, Operation>newBuilder()
                .setMethodDescriptor(updateCertificateMapEntryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "certificate_map_entry.name",
                          String.valueOf(request.getCertificateMapEntry().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteCertificateMapEntryRequest, Operation>
        deleteCertificateMapEntryTransportSettings =
            GrpcCallSettings.<DeleteCertificateMapEntryRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCertificateMapEntryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse>
        listDnsAuthorizationsTransportSettings =
            GrpcCallSettings
                .<ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse>newBuilder()
                .setMethodDescriptor(listDnsAuthorizationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetDnsAuthorizationRequest, DnsAuthorization>
        getDnsAuthorizationTransportSettings =
            GrpcCallSettings.<GetDnsAuthorizationRequest, DnsAuthorization>newBuilder()
                .setMethodDescriptor(getDnsAuthorizationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateDnsAuthorizationRequest, Operation>
        createDnsAuthorizationTransportSettings =
            GrpcCallSettings.<CreateDnsAuthorizationRequest, Operation>newBuilder()
                .setMethodDescriptor(createDnsAuthorizationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateDnsAuthorizationRequest, Operation>
        updateDnsAuthorizationTransportSettings =
            GrpcCallSettings.<UpdateDnsAuthorizationRequest, Operation>newBuilder()
                .setMethodDescriptor(updateDnsAuthorizationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "dns_authorization.name",
                          String.valueOf(request.getDnsAuthorization().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteDnsAuthorizationRequest, Operation>
        deleteDnsAuthorizationTransportSettings =
            GrpcCallSettings.<DeleteDnsAuthorizationRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDnsAuthorizationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListCertificateIssuanceConfigsRequest, ListCertificateIssuanceConfigsResponse>
        listCertificateIssuanceConfigsTransportSettings =
            GrpcCallSettings
                .<ListCertificateIssuanceConfigsRequest, ListCertificateIssuanceConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(listCertificateIssuanceConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetCertificateIssuanceConfigRequest, CertificateIssuanceConfig>
        getCertificateIssuanceConfigTransportSettings =
            GrpcCallSettings
                .<GetCertificateIssuanceConfigRequest, CertificateIssuanceConfig>newBuilder()
                .setMethodDescriptor(getCertificateIssuanceConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateCertificateIssuanceConfigRequest, Operation>
        createCertificateIssuanceConfigTransportSettings =
            GrpcCallSettings.<CreateCertificateIssuanceConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(createCertificateIssuanceConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteCertificateIssuanceConfigRequest, Operation>
        deleteCertificateIssuanceConfigTransportSettings =
            GrpcCallSettings.<DeleteCertificateIssuanceConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCertificateIssuanceConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listCertificatesCallable =
        callableFactory.createUnaryCallable(
            listCertificatesTransportSettings, settings.listCertificatesSettings(), clientContext);
    this.listCertificatesPagedCallable =
        callableFactory.createPagedCallable(
            listCertificatesTransportSettings, settings.listCertificatesSettings(), clientContext);
    this.getCertificateCallable =
        callableFactory.createUnaryCallable(
            getCertificateTransportSettings, settings.getCertificateSettings(), clientContext);
    this.createCertificateCallable =
        callableFactory.createUnaryCallable(
            createCertificateTransportSettings,
            settings.createCertificateSettings(),
            clientContext);
    this.createCertificateOperationCallable =
        callableFactory.createOperationCallable(
            createCertificateTransportSettings,
            settings.createCertificateOperationSettings(),
            clientContext,
            operationsStub);
    this.updateCertificateCallable =
        callableFactory.createUnaryCallable(
            updateCertificateTransportSettings,
            settings.updateCertificateSettings(),
            clientContext);
    this.updateCertificateOperationCallable =
        callableFactory.createOperationCallable(
            updateCertificateTransportSettings,
            settings.updateCertificateOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteCertificateCallable =
        callableFactory.createUnaryCallable(
            deleteCertificateTransportSettings,
            settings.deleteCertificateSettings(),
            clientContext);
    this.deleteCertificateOperationCallable =
        callableFactory.createOperationCallable(
            deleteCertificateTransportSettings,
            settings.deleteCertificateOperationSettings(),
            clientContext,
            operationsStub);
    this.listCertificateMapsCallable =
        callableFactory.createUnaryCallable(
            listCertificateMapsTransportSettings,
            settings.listCertificateMapsSettings(),
            clientContext);
    this.listCertificateMapsPagedCallable =
        callableFactory.createPagedCallable(
            listCertificateMapsTransportSettings,
            settings.listCertificateMapsSettings(),
            clientContext);
    this.getCertificateMapCallable =
        callableFactory.createUnaryCallable(
            getCertificateMapTransportSettings,
            settings.getCertificateMapSettings(),
            clientContext);
    this.createCertificateMapCallable =
        callableFactory.createUnaryCallable(
            createCertificateMapTransportSettings,
            settings.createCertificateMapSettings(),
            clientContext);
    this.createCertificateMapOperationCallable =
        callableFactory.createOperationCallable(
            createCertificateMapTransportSettings,
            settings.createCertificateMapOperationSettings(),
            clientContext,
            operationsStub);
    this.updateCertificateMapCallable =
        callableFactory.createUnaryCallable(
            updateCertificateMapTransportSettings,
            settings.updateCertificateMapSettings(),
            clientContext);
    this.updateCertificateMapOperationCallable =
        callableFactory.createOperationCallable(
            updateCertificateMapTransportSettings,
            settings.updateCertificateMapOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteCertificateMapCallable =
        callableFactory.createUnaryCallable(
            deleteCertificateMapTransportSettings,
            settings.deleteCertificateMapSettings(),
            clientContext);
    this.deleteCertificateMapOperationCallable =
        callableFactory.createOperationCallable(
            deleteCertificateMapTransportSettings,
            settings.deleteCertificateMapOperationSettings(),
            clientContext,
            operationsStub);
    this.listCertificateMapEntriesCallable =
        callableFactory.createUnaryCallable(
            listCertificateMapEntriesTransportSettings,
            settings.listCertificateMapEntriesSettings(),
            clientContext);
    this.listCertificateMapEntriesPagedCallable =
        callableFactory.createPagedCallable(
            listCertificateMapEntriesTransportSettings,
            settings.listCertificateMapEntriesSettings(),
            clientContext);
    this.getCertificateMapEntryCallable =
        callableFactory.createUnaryCallable(
            getCertificateMapEntryTransportSettings,
            settings.getCertificateMapEntrySettings(),
            clientContext);
    this.createCertificateMapEntryCallable =
        callableFactory.createUnaryCallable(
            createCertificateMapEntryTransportSettings,
            settings.createCertificateMapEntrySettings(),
            clientContext);
    this.createCertificateMapEntryOperationCallable =
        callableFactory.createOperationCallable(
            createCertificateMapEntryTransportSettings,
            settings.createCertificateMapEntryOperationSettings(),
            clientContext,
            operationsStub);
    this.updateCertificateMapEntryCallable =
        callableFactory.createUnaryCallable(
            updateCertificateMapEntryTransportSettings,
            settings.updateCertificateMapEntrySettings(),
            clientContext);
    this.updateCertificateMapEntryOperationCallable =
        callableFactory.createOperationCallable(
            updateCertificateMapEntryTransportSettings,
            settings.updateCertificateMapEntryOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteCertificateMapEntryCallable =
        callableFactory.createUnaryCallable(
            deleteCertificateMapEntryTransportSettings,
            settings.deleteCertificateMapEntrySettings(),
            clientContext);
    this.deleteCertificateMapEntryOperationCallable =
        callableFactory.createOperationCallable(
            deleteCertificateMapEntryTransportSettings,
            settings.deleteCertificateMapEntryOperationSettings(),
            clientContext,
            operationsStub);
    this.listDnsAuthorizationsCallable =
        callableFactory.createUnaryCallable(
            listDnsAuthorizationsTransportSettings,
            settings.listDnsAuthorizationsSettings(),
            clientContext);
    this.listDnsAuthorizationsPagedCallable =
        callableFactory.createPagedCallable(
            listDnsAuthorizationsTransportSettings,
            settings.listDnsAuthorizationsSettings(),
            clientContext);
    this.getDnsAuthorizationCallable =
        callableFactory.createUnaryCallable(
            getDnsAuthorizationTransportSettings,
            settings.getDnsAuthorizationSettings(),
            clientContext);
    this.createDnsAuthorizationCallable =
        callableFactory.createUnaryCallable(
            createDnsAuthorizationTransportSettings,
            settings.createDnsAuthorizationSettings(),
            clientContext);
    this.createDnsAuthorizationOperationCallable =
        callableFactory.createOperationCallable(
            createDnsAuthorizationTransportSettings,
            settings.createDnsAuthorizationOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDnsAuthorizationCallable =
        callableFactory.createUnaryCallable(
            updateDnsAuthorizationTransportSettings,
            settings.updateDnsAuthorizationSettings(),
            clientContext);
    this.updateDnsAuthorizationOperationCallable =
        callableFactory.createOperationCallable(
            updateDnsAuthorizationTransportSettings,
            settings.updateDnsAuthorizationOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDnsAuthorizationCallable =
        callableFactory.createUnaryCallable(
            deleteDnsAuthorizationTransportSettings,
            settings.deleteDnsAuthorizationSettings(),
            clientContext);
    this.deleteDnsAuthorizationOperationCallable =
        callableFactory.createOperationCallable(
            deleteDnsAuthorizationTransportSettings,
            settings.deleteDnsAuthorizationOperationSettings(),
            clientContext,
            operationsStub);
    this.listCertificateIssuanceConfigsCallable =
        callableFactory.createUnaryCallable(
            listCertificateIssuanceConfigsTransportSettings,
            settings.listCertificateIssuanceConfigsSettings(),
            clientContext);
    this.listCertificateIssuanceConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listCertificateIssuanceConfigsTransportSettings,
            settings.listCertificateIssuanceConfigsSettings(),
            clientContext);
    this.getCertificateIssuanceConfigCallable =
        callableFactory.createUnaryCallable(
            getCertificateIssuanceConfigTransportSettings,
            settings.getCertificateIssuanceConfigSettings(),
            clientContext);
    this.createCertificateIssuanceConfigCallable =
        callableFactory.createUnaryCallable(
            createCertificateIssuanceConfigTransportSettings,
            settings.createCertificateIssuanceConfigSettings(),
            clientContext);
    this.createCertificateIssuanceConfigOperationCallable =
        callableFactory.createOperationCallable(
            createCertificateIssuanceConfigTransportSettings,
            settings.createCertificateIssuanceConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteCertificateIssuanceConfigCallable =
        callableFactory.createUnaryCallable(
            deleteCertificateIssuanceConfigTransportSettings,
            settings.deleteCertificateIssuanceConfigSettings(),
            clientContext);
    this.deleteCertificateIssuanceConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteCertificateIssuanceConfigTransportSettings,
            settings.deleteCertificateIssuanceConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListCertificatesRequest, ListCertificatesResponse>
      listCertificatesCallable() {
    return listCertificatesCallable;
  }

  @Override
  public UnaryCallable<ListCertificatesRequest, ListCertificatesPagedResponse>
      listCertificatesPagedCallable() {
    return listCertificatesPagedCallable;
  }

  @Override
  public UnaryCallable<GetCertificateRequest, Certificate> getCertificateCallable() {
    return getCertificateCallable;
  }

  @Override
  public UnaryCallable<CreateCertificateRequest, Operation> createCertificateCallable() {
    return createCertificateCallable;
  }

  @Override
  public OperationCallable<CreateCertificateRequest, Certificate, OperationMetadata>
      createCertificateOperationCallable() {
    return createCertificateOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateCertificateRequest, Operation> updateCertificateCallable() {
    return updateCertificateCallable;
  }

  @Override
  public OperationCallable<UpdateCertificateRequest, Certificate, OperationMetadata>
      updateCertificateOperationCallable() {
    return updateCertificateOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCertificateRequest, Operation> deleteCertificateCallable() {
    return deleteCertificateCallable;
  }

  @Override
  public OperationCallable<DeleteCertificateRequest, Empty, OperationMetadata>
      deleteCertificateOperationCallable() {
    return deleteCertificateOperationCallable;
  }

  @Override
  public UnaryCallable<ListCertificateMapsRequest, ListCertificateMapsResponse>
      listCertificateMapsCallable() {
    return listCertificateMapsCallable;
  }

  @Override
  public UnaryCallable<ListCertificateMapsRequest, ListCertificateMapsPagedResponse>
      listCertificateMapsPagedCallable() {
    return listCertificateMapsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCertificateMapRequest, CertificateMap> getCertificateMapCallable() {
    return getCertificateMapCallable;
  }

  @Override
  public UnaryCallable<CreateCertificateMapRequest, Operation> createCertificateMapCallable() {
    return createCertificateMapCallable;
  }

  @Override
  public OperationCallable<CreateCertificateMapRequest, CertificateMap, OperationMetadata>
      createCertificateMapOperationCallable() {
    return createCertificateMapOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateCertificateMapRequest, Operation> updateCertificateMapCallable() {
    return updateCertificateMapCallable;
  }

  @Override
  public OperationCallable<UpdateCertificateMapRequest, CertificateMap, OperationMetadata>
      updateCertificateMapOperationCallable() {
    return updateCertificateMapOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCertificateMapRequest, Operation> deleteCertificateMapCallable() {
    return deleteCertificateMapCallable;
  }

  @Override
  public OperationCallable<DeleteCertificateMapRequest, Empty, OperationMetadata>
      deleteCertificateMapOperationCallable() {
    return deleteCertificateMapOperationCallable;
  }

  @Override
  public UnaryCallable<ListCertificateMapEntriesRequest, ListCertificateMapEntriesResponse>
      listCertificateMapEntriesCallable() {
    return listCertificateMapEntriesCallable;
  }

  @Override
  public UnaryCallable<ListCertificateMapEntriesRequest, ListCertificateMapEntriesPagedResponse>
      listCertificateMapEntriesPagedCallable() {
    return listCertificateMapEntriesPagedCallable;
  }

  @Override
  public UnaryCallable<GetCertificateMapEntryRequest, CertificateMapEntry>
      getCertificateMapEntryCallable() {
    return getCertificateMapEntryCallable;
  }

  @Override
  public UnaryCallable<CreateCertificateMapEntryRequest, Operation>
      createCertificateMapEntryCallable() {
    return createCertificateMapEntryCallable;
  }

  @Override
  public OperationCallable<CreateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
      createCertificateMapEntryOperationCallable() {
    return createCertificateMapEntryOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateCertificateMapEntryRequest, Operation>
      updateCertificateMapEntryCallable() {
    return updateCertificateMapEntryCallable;
  }

  @Override
  public OperationCallable<UpdateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
      updateCertificateMapEntryOperationCallable() {
    return updateCertificateMapEntryOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCertificateMapEntryRequest, Operation>
      deleteCertificateMapEntryCallable() {
    return deleteCertificateMapEntryCallable;
  }

  @Override
  public OperationCallable<DeleteCertificateMapEntryRequest, Empty, OperationMetadata>
      deleteCertificateMapEntryOperationCallable() {
    return deleteCertificateMapEntryOperationCallable;
  }

  @Override
  public UnaryCallable<ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse>
      listDnsAuthorizationsCallable() {
    return listDnsAuthorizationsCallable;
  }

  @Override
  public UnaryCallable<ListDnsAuthorizationsRequest, ListDnsAuthorizationsPagedResponse>
      listDnsAuthorizationsPagedCallable() {
    return listDnsAuthorizationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDnsAuthorizationRequest, DnsAuthorization> getDnsAuthorizationCallable() {
    return getDnsAuthorizationCallable;
  }

  @Override
  public UnaryCallable<CreateDnsAuthorizationRequest, Operation> createDnsAuthorizationCallable() {
    return createDnsAuthorizationCallable;
  }

  @Override
  public OperationCallable<CreateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
      createDnsAuthorizationOperationCallable() {
    return createDnsAuthorizationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDnsAuthorizationRequest, Operation> updateDnsAuthorizationCallable() {
    return updateDnsAuthorizationCallable;
  }

  @Override
  public OperationCallable<UpdateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
      updateDnsAuthorizationOperationCallable() {
    return updateDnsAuthorizationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDnsAuthorizationRequest, Operation> deleteDnsAuthorizationCallable() {
    return deleteDnsAuthorizationCallable;
  }

  @Override
  public OperationCallable<DeleteDnsAuthorizationRequest, Empty, OperationMetadata>
      deleteDnsAuthorizationOperationCallable() {
    return deleteDnsAuthorizationOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListCertificateIssuanceConfigsRequest, ListCertificateIssuanceConfigsResponse>
      listCertificateIssuanceConfigsCallable() {
    return listCertificateIssuanceConfigsCallable;
  }

  @Override
  public UnaryCallable<
          ListCertificateIssuanceConfigsRequest, ListCertificateIssuanceConfigsPagedResponse>
      listCertificateIssuanceConfigsPagedCallable() {
    return listCertificateIssuanceConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCertificateIssuanceConfigRequest, CertificateIssuanceConfig>
      getCertificateIssuanceConfigCallable() {
    return getCertificateIssuanceConfigCallable;
  }

  @Override
  public UnaryCallable<CreateCertificateIssuanceConfigRequest, Operation>
      createCertificateIssuanceConfigCallable() {
    return createCertificateIssuanceConfigCallable;
  }

  @Override
  public OperationCallable<
          CreateCertificateIssuanceConfigRequest, CertificateIssuanceConfig, OperationMetadata>
      createCertificateIssuanceConfigOperationCallable() {
    return createCertificateIssuanceConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCertificateIssuanceConfigRequest, Operation>
      deleteCertificateIssuanceConfigCallable() {
    return deleteCertificateIssuanceConfigCallable;
  }

  @Override
  public OperationCallable<DeleteCertificateIssuanceConfigRequest, Empty, OperationMetadata>
      deleteCertificateIssuanceConfigOperationCallable() {
    return deleteCertificateIssuanceConfigOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
