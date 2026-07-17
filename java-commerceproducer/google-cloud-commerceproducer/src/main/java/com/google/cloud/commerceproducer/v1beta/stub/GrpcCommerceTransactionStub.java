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

package com.google.cloud.commerceproducer.v1beta.stub;

import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListLocationsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListPrivateOfferDocumentsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListPrivateOffersPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListServicesPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListSkuGroupsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListSkusPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListStandardOffersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest;
import com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest;
import com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest;
import com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.GetServiceRequest;
import com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest;
import com.google.cloud.commerceproducer.v1beta.GetSkuRequest;
import com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest;
import com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest;
import com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse;
import com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest;
import com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse;
import com.google.cloud.commerceproducer.v1beta.ListServicesRequest;
import com.google.cloud.commerceproducer.v1beta.ListServicesResponse;
import com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest;
import com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse;
import com.google.cloud.commerceproducer.v1beta.ListSkusRequest;
import com.google.cloud.commerceproducer.v1beta.ListSkusResponse;
import com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest;
import com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse;
import com.google.cloud.commerceproducer.v1beta.PrivateOffer;
import com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument;
import com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.Service;
import com.google.cloud.commerceproducer.v1beta.Sku;
import com.google.cloud.commerceproducer.v1beta.SkuGroup;
import com.google.cloud.commerceproducer.v1beta.StandardOffer;
import com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest;
import com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CommerceTransaction service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcCommerceTransactionStub extends CommerceTransactionStub {
  private static final MethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          MethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/ListServices")
              .setRequestMarshaller(ProtoUtils.marshaller(ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServicesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      MethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.commerceproducer.v1beta.CommerceTransaction/GetService")
          .setRequestMarshaller(ProtoUtils.marshaller(GetServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListPrivateOffersRequest, ListPrivateOffersResponse>
      listPrivateOffersMethodDescriptor =
          MethodDescriptor.<ListPrivateOffersRequest, ListPrivateOffersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/ListPrivateOffers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPrivateOffersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPrivateOffersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetPrivateOfferRequest, PrivateOffer>
      getPrivateOfferMethodDescriptor =
          MethodDescriptor.<GetPrivateOfferRequest, PrivateOffer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/GetPrivateOffer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPrivateOfferRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PrivateOffer.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreatePrivateOfferRequest, PrivateOffer>
      createPrivateOfferMethodDescriptor =
          MethodDescriptor.<CreatePrivateOfferRequest, PrivateOffer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/CreatePrivateOffer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePrivateOfferRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PrivateOffer.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdatePrivateOfferRequest, PrivateOffer>
      updatePrivateOfferMethodDescriptor =
          MethodDescriptor.<UpdatePrivateOfferRequest, PrivateOffer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/UpdatePrivateOffer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePrivateOfferRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PrivateOffer.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<PublishPrivateOfferRequest, PrivateOffer>
      publishPrivateOfferMethodDescriptor =
          MethodDescriptor.<PublishPrivateOfferRequest, PrivateOffer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/PublishPrivateOffer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PublishPrivateOfferRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PrivateOffer.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CancelPrivateOfferRequest, PrivateOffer>
      cancelPrivateOfferMethodDescriptor =
          MethodDescriptor.<CancelPrivateOfferRequest, PrivateOffer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/CancelPrivateOffer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelPrivateOfferRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PrivateOffer.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeletePrivateOfferRequest, Empty>
      deletePrivateOfferMethodDescriptor =
          MethodDescriptor.<DeletePrivateOfferRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/DeletePrivateOffer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePrivateOfferRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse>
      listPrivateOfferDocumentsMethodDescriptor =
          MethodDescriptor
              .<ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/ListPrivateOfferDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPrivateOfferDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPrivateOfferDocumentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
      getPrivateOfferDocumentMethodDescriptor =
          MethodDescriptor.<GetPrivateOfferDocumentRequest, PrivateOfferDocument>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/GetPrivateOfferDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPrivateOfferDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PrivateOfferDocument.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
      createPrivateOfferDocumentMethodDescriptor =
          MethodDescriptor.<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/CreatePrivateOfferDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePrivateOfferDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PrivateOfferDocument.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
      updatePrivateOfferDocumentMethodDescriptor =
          MethodDescriptor.<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/UpdatePrivateOfferDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePrivateOfferDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PrivateOfferDocument.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeletePrivateOfferDocumentRequest, Empty>
      deletePrivateOfferDocumentMethodDescriptor =
          MethodDescriptor.<DeletePrivateOfferDocumentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/DeletePrivateOfferDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePrivateOfferDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListStandardOffersRequest, ListStandardOffersResponse>
      listStandardOffersMethodDescriptor =
          MethodDescriptor.<ListStandardOffersRequest, ListStandardOffersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/ListStandardOffers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListStandardOffersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListStandardOffersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetStandardOfferRequest, StandardOffer>
      getStandardOfferMethodDescriptor =
          MethodDescriptor.<GetStandardOfferRequest, StandardOffer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/GetStandardOffer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetStandardOfferRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StandardOffer.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSkuRequest, Sku> getSkuMethodDescriptor =
      MethodDescriptor.<GetSkuRequest, Sku>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.commerceproducer.v1beta.CommerceTransaction/GetSku")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSkuRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Sku.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListSkusRequest, ListSkusResponse>
      listSkusMethodDescriptor =
          MethodDescriptor.<ListSkusRequest, ListSkusResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/ListSkus")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSkusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSkusResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSkuGroupRequest, SkuGroup> getSkuGroupMethodDescriptor =
      MethodDescriptor.<GetSkuGroupRequest, SkuGroup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.commerceproducer.v1beta.CommerceTransaction/GetSkuGroup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSkuGroupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(SkuGroup.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListSkuGroupsRequest, ListSkuGroupsResponse>
      listSkuGroupsMethodDescriptor =
          MethodDescriptor.<ListSkuGroupsRequest, ListSkuGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/ListSkuGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSkuGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSkuGroupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<GetServiceRequest, Service> getServiceCallable;
  private final UnaryCallable<ListPrivateOffersRequest, ListPrivateOffersResponse>
      listPrivateOffersCallable;
  private final UnaryCallable<ListPrivateOffersRequest, ListPrivateOffersPagedResponse>
      listPrivateOffersPagedCallable;
  private final UnaryCallable<GetPrivateOfferRequest, PrivateOffer> getPrivateOfferCallable;
  private final UnaryCallable<CreatePrivateOfferRequest, PrivateOffer> createPrivateOfferCallable;
  private final UnaryCallable<UpdatePrivateOfferRequest, PrivateOffer> updatePrivateOfferCallable;
  private final UnaryCallable<PublishPrivateOfferRequest, PrivateOffer> publishPrivateOfferCallable;
  private final UnaryCallable<CancelPrivateOfferRequest, PrivateOffer> cancelPrivateOfferCallable;
  private final UnaryCallable<DeletePrivateOfferRequest, Empty> deletePrivateOfferCallable;
  private final UnaryCallable<ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse>
      listPrivateOfferDocumentsCallable;
  private final UnaryCallable<
          ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsPagedResponse>
      listPrivateOfferDocumentsPagedCallable;
  private final UnaryCallable<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
      getPrivateOfferDocumentCallable;
  private final UnaryCallable<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
      createPrivateOfferDocumentCallable;
  private final UnaryCallable<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
      updatePrivateOfferDocumentCallable;
  private final UnaryCallable<DeletePrivateOfferDocumentRequest, Empty>
      deletePrivateOfferDocumentCallable;
  private final UnaryCallable<ListStandardOffersRequest, ListStandardOffersResponse>
      listStandardOffersCallable;
  private final UnaryCallable<ListStandardOffersRequest, ListStandardOffersPagedResponse>
      listStandardOffersPagedCallable;
  private final UnaryCallable<GetStandardOfferRequest, StandardOffer> getStandardOfferCallable;
  private final UnaryCallable<GetSkuRequest, Sku> getSkuCallable;
  private final UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable;
  private final UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable;
  private final UnaryCallable<GetSkuGroupRequest, SkuGroup> getSkuGroupCallable;
  private final UnaryCallable<ListSkuGroupsRequest, ListSkuGroupsResponse> listSkuGroupsCallable;
  private final UnaryCallable<ListSkuGroupsRequest, ListSkuGroupsPagedResponse>
      listSkuGroupsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCommerceTransactionStub create(CommerceTransactionStubSettings settings)
      throws IOException {
    return new GrpcCommerceTransactionStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCommerceTransactionStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCommerceTransactionStub(
        CommerceTransactionStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCommerceTransactionStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCommerceTransactionStub(
        CommerceTransactionStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCommerceTransactionStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCommerceTransactionStub(
      CommerceTransactionStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCommerceTransactionCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCommerceTransactionStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCommerceTransactionStub(
      CommerceTransactionStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        GrpcCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetServiceRequest, Service> getServiceTransportSettings =
        GrpcCallSettings.<GetServiceRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListPrivateOffersRequest, ListPrivateOffersResponse>
        listPrivateOffersTransportSettings =
            GrpcCallSettings.<ListPrivateOffersRequest, ListPrivateOffersResponse>newBuilder()
                .setMethodDescriptor(listPrivateOffersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetPrivateOfferRequest, PrivateOffer> getPrivateOfferTransportSettings =
        GrpcCallSettings.<GetPrivateOfferRequest, PrivateOffer>newBuilder()
            .setMethodDescriptor(getPrivateOfferMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreatePrivateOfferRequest, PrivateOffer> createPrivateOfferTransportSettings =
        GrpcCallSettings.<CreatePrivateOfferRequest, PrivateOffer>newBuilder()
            .setMethodDescriptor(createPrivateOfferMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdatePrivateOfferRequest, PrivateOffer> updatePrivateOfferTransportSettings =
        GrpcCallSettings.<UpdatePrivateOfferRequest, PrivateOffer>newBuilder()
            .setMethodDescriptor(updatePrivateOfferMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "private_offer.name", String.valueOf(request.getPrivateOffer().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<PublishPrivateOfferRequest, PrivateOffer>
        publishPrivateOfferTransportSettings =
            GrpcCallSettings.<PublishPrivateOfferRequest, PrivateOffer>newBuilder()
                .setMethodDescriptor(publishPrivateOfferMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CancelPrivateOfferRequest, PrivateOffer> cancelPrivateOfferTransportSettings =
        GrpcCallSettings.<CancelPrivateOfferRequest, PrivateOffer>newBuilder()
            .setMethodDescriptor(cancelPrivateOfferMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<DeletePrivateOfferRequest, Empty> deletePrivateOfferTransportSettings =
        GrpcCallSettings.<DeletePrivateOfferRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePrivateOfferMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse>
        listPrivateOfferDocumentsTransportSettings =
            GrpcCallSettings
                .<ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse>newBuilder()
                .setMethodDescriptor(listPrivateOfferDocumentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
        getPrivateOfferDocumentTransportSettings =
            GrpcCallSettings.<GetPrivateOfferDocumentRequest, PrivateOfferDocument>newBuilder()
                .setMethodDescriptor(getPrivateOfferDocumentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
        createPrivateOfferDocumentTransportSettings =
            GrpcCallSettings.<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>newBuilder()
                .setMethodDescriptor(createPrivateOfferDocumentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
        updatePrivateOfferDocumentTransportSettings =
            GrpcCallSettings.<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>newBuilder()
                .setMethodDescriptor(updatePrivateOfferDocumentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "private_offer_document.name",
                          String.valueOf(request.getPrivateOfferDocument().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeletePrivateOfferDocumentRequest, Empty>
        deletePrivateOfferDocumentTransportSettings =
            GrpcCallSettings.<DeletePrivateOfferDocumentRequest, Empty>newBuilder()
                .setMethodDescriptor(deletePrivateOfferDocumentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListStandardOffersRequest, ListStandardOffersResponse>
        listStandardOffersTransportSettings =
            GrpcCallSettings.<ListStandardOffersRequest, ListStandardOffersResponse>newBuilder()
                .setMethodDescriptor(listStandardOffersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetStandardOfferRequest, StandardOffer> getStandardOfferTransportSettings =
        GrpcCallSettings.<GetStandardOfferRequest, StandardOffer>newBuilder()
            .setMethodDescriptor(getStandardOfferMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetSkuRequest, Sku> getSkuTransportSettings =
        GrpcCallSettings.<GetSkuRequest, Sku>newBuilder()
            .setMethodDescriptor(getSkuMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListSkusRequest, ListSkusResponse> listSkusTransportSettings =
        GrpcCallSettings.<ListSkusRequest, ListSkusResponse>newBuilder()
            .setMethodDescriptor(listSkusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetSkuGroupRequest, SkuGroup> getSkuGroupTransportSettings =
        GrpcCallSettings.<GetSkuGroupRequest, SkuGroup>newBuilder()
            .setMethodDescriptor(getSkuGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListSkuGroupsRequest, ListSkuGroupsResponse> listSkuGroupsTransportSettings =
        GrpcCallSettings.<ListSkuGroupsRequest, ListSkuGroupsResponse>newBuilder()
            .setMethodDescriptor(listSkuGroupsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.getServiceCallable =
        callableFactory.createUnaryCallable(
            getServiceTransportSettings, settings.getServiceSettings(), clientContext);
    this.listPrivateOffersCallable =
        callableFactory.createUnaryCallable(
            listPrivateOffersTransportSettings,
            settings.listPrivateOffersSettings(),
            clientContext);
    this.listPrivateOffersPagedCallable =
        callableFactory.createPagedCallable(
            listPrivateOffersTransportSettings,
            settings.listPrivateOffersSettings(),
            clientContext);
    this.getPrivateOfferCallable =
        callableFactory.createUnaryCallable(
            getPrivateOfferTransportSettings, settings.getPrivateOfferSettings(), clientContext);
    this.createPrivateOfferCallable =
        callableFactory.createUnaryCallable(
            createPrivateOfferTransportSettings,
            settings.createPrivateOfferSettings(),
            clientContext);
    this.updatePrivateOfferCallable =
        callableFactory.createUnaryCallable(
            updatePrivateOfferTransportSettings,
            settings.updatePrivateOfferSettings(),
            clientContext);
    this.publishPrivateOfferCallable =
        callableFactory.createUnaryCallable(
            publishPrivateOfferTransportSettings,
            settings.publishPrivateOfferSettings(),
            clientContext);
    this.cancelPrivateOfferCallable =
        callableFactory.createUnaryCallable(
            cancelPrivateOfferTransportSettings,
            settings.cancelPrivateOfferSettings(),
            clientContext);
    this.deletePrivateOfferCallable =
        callableFactory.createUnaryCallable(
            deletePrivateOfferTransportSettings,
            settings.deletePrivateOfferSettings(),
            clientContext);
    this.listPrivateOfferDocumentsCallable =
        callableFactory.createUnaryCallable(
            listPrivateOfferDocumentsTransportSettings,
            settings.listPrivateOfferDocumentsSettings(),
            clientContext);
    this.listPrivateOfferDocumentsPagedCallable =
        callableFactory.createPagedCallable(
            listPrivateOfferDocumentsTransportSettings,
            settings.listPrivateOfferDocumentsSettings(),
            clientContext);
    this.getPrivateOfferDocumentCallable =
        callableFactory.createUnaryCallable(
            getPrivateOfferDocumentTransportSettings,
            settings.getPrivateOfferDocumentSettings(),
            clientContext);
    this.createPrivateOfferDocumentCallable =
        callableFactory.createUnaryCallable(
            createPrivateOfferDocumentTransportSettings,
            settings.createPrivateOfferDocumentSettings(),
            clientContext);
    this.updatePrivateOfferDocumentCallable =
        callableFactory.createUnaryCallable(
            updatePrivateOfferDocumentTransportSettings,
            settings.updatePrivateOfferDocumentSettings(),
            clientContext);
    this.deletePrivateOfferDocumentCallable =
        callableFactory.createUnaryCallable(
            deletePrivateOfferDocumentTransportSettings,
            settings.deletePrivateOfferDocumentSettings(),
            clientContext);
    this.listStandardOffersCallable =
        callableFactory.createUnaryCallable(
            listStandardOffersTransportSettings,
            settings.listStandardOffersSettings(),
            clientContext);
    this.listStandardOffersPagedCallable =
        callableFactory.createPagedCallable(
            listStandardOffersTransportSettings,
            settings.listStandardOffersSettings(),
            clientContext);
    this.getStandardOfferCallable =
        callableFactory.createUnaryCallable(
            getStandardOfferTransportSettings, settings.getStandardOfferSettings(), clientContext);
    this.getSkuCallable =
        callableFactory.createUnaryCallable(
            getSkuTransportSettings, settings.getSkuSettings(), clientContext);
    this.listSkusCallable =
        callableFactory.createUnaryCallable(
            listSkusTransportSettings, settings.listSkusSettings(), clientContext);
    this.listSkusPagedCallable =
        callableFactory.createPagedCallable(
            listSkusTransportSettings, settings.listSkusSettings(), clientContext);
    this.getSkuGroupCallable =
        callableFactory.createUnaryCallable(
            getSkuGroupTransportSettings, settings.getSkuGroupSettings(), clientContext);
    this.listSkuGroupsCallable =
        callableFactory.createUnaryCallable(
            listSkuGroupsTransportSettings, settings.listSkuGroupsSettings(), clientContext);
    this.listSkuGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listSkuGroupsTransportSettings, settings.listSkuGroupsSettings(), clientContext);
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
  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return listServicesCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    return listServicesPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return getServiceCallable;
  }

  @Override
  public UnaryCallable<ListPrivateOffersRequest, ListPrivateOffersResponse>
      listPrivateOffersCallable() {
    return listPrivateOffersCallable;
  }

  @Override
  public UnaryCallable<ListPrivateOffersRequest, ListPrivateOffersPagedResponse>
      listPrivateOffersPagedCallable() {
    return listPrivateOffersPagedCallable;
  }

  @Override
  public UnaryCallable<GetPrivateOfferRequest, PrivateOffer> getPrivateOfferCallable() {
    return getPrivateOfferCallable;
  }

  @Override
  public UnaryCallable<CreatePrivateOfferRequest, PrivateOffer> createPrivateOfferCallable() {
    return createPrivateOfferCallable;
  }

  @Override
  public UnaryCallable<UpdatePrivateOfferRequest, PrivateOffer> updatePrivateOfferCallable() {
    return updatePrivateOfferCallable;
  }

  @Override
  public UnaryCallable<PublishPrivateOfferRequest, PrivateOffer> publishPrivateOfferCallable() {
    return publishPrivateOfferCallable;
  }

  @Override
  public UnaryCallable<CancelPrivateOfferRequest, PrivateOffer> cancelPrivateOfferCallable() {
    return cancelPrivateOfferCallable;
  }

  @Override
  public UnaryCallable<DeletePrivateOfferRequest, Empty> deletePrivateOfferCallable() {
    return deletePrivateOfferCallable;
  }

  @Override
  public UnaryCallable<ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse>
      listPrivateOfferDocumentsCallable() {
    return listPrivateOfferDocumentsCallable;
  }

  @Override
  public UnaryCallable<ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsPagedResponse>
      listPrivateOfferDocumentsPagedCallable() {
    return listPrivateOfferDocumentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
      getPrivateOfferDocumentCallable() {
    return getPrivateOfferDocumentCallable;
  }

  @Override
  public UnaryCallable<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
      createPrivateOfferDocumentCallable() {
    return createPrivateOfferDocumentCallable;
  }

  @Override
  public UnaryCallable<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
      updatePrivateOfferDocumentCallable() {
    return updatePrivateOfferDocumentCallable;
  }

  @Override
  public UnaryCallable<DeletePrivateOfferDocumentRequest, Empty>
      deletePrivateOfferDocumentCallable() {
    return deletePrivateOfferDocumentCallable;
  }

  @Override
  public UnaryCallable<ListStandardOffersRequest, ListStandardOffersResponse>
      listStandardOffersCallable() {
    return listStandardOffersCallable;
  }

  @Override
  public UnaryCallable<ListStandardOffersRequest, ListStandardOffersPagedResponse>
      listStandardOffersPagedCallable() {
    return listStandardOffersPagedCallable;
  }

  @Override
  public UnaryCallable<GetStandardOfferRequest, StandardOffer> getStandardOfferCallable() {
    return getStandardOfferCallable;
  }

  @Override
  public UnaryCallable<GetSkuRequest, Sku> getSkuCallable() {
    return getSkuCallable;
  }

  @Override
  public UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable() {
    return listSkusCallable;
  }

  @Override
  public UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable() {
    return listSkusPagedCallable;
  }

  @Override
  public UnaryCallable<GetSkuGroupRequest, SkuGroup> getSkuGroupCallable() {
    return getSkuGroupCallable;
  }

  @Override
  public UnaryCallable<ListSkuGroupsRequest, ListSkuGroupsResponse> listSkuGroupsCallable() {
    return listSkuGroupsCallable;
  }

  @Override
  public UnaryCallable<ListSkuGroupsRequest, ListSkuGroupsPagedResponse>
      listSkuGroupsPagedCallable() {
    return listSkuGroupsPagedCallable;
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
