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
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
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
import com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest;
import com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse;
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
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CommerceTransaction service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonCommerceTransactionStub extends CommerceTransactionStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          ApiMethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/ListServices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServicesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/services",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListServicesResponse>newBuilder()
                      .setDefaultInstance(ListServicesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      ApiMethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setFullMethodName("google.cloud.commerceproducer.v1beta.CommerceTransaction/GetService")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetServiceRequest>newBuilder()
                  .setPath(
                      "/v1beta/{name=projects/*/locations/*/services/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetServiceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetServiceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "view", request.getViewValue());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Service>newBuilder()
                  .setDefaultInstance(Service.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListPrivateOffersRequest, ListPrivateOffersResponse>
      listPrivateOffersMethodDescriptor =
          ApiMethodDescriptor.<ListPrivateOffersRequest, ListPrivateOffersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/ListPrivateOffers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPrivateOffersRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/privateOffers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateOffersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateOffersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPrivateOffersResponse>newBuilder()
                      .setDefaultInstance(ListPrivateOffersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPrivateOfferRequest, PrivateOffer>
      getPrivateOfferMethodDescriptor =
          ApiMethodDescriptor.<GetPrivateOfferRequest, PrivateOffer>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/GetPrivateOffer")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPrivateOfferRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/privateOffers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateOffer>newBuilder()
                      .setDefaultInstance(PrivateOffer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ResolveAmendmentTargetRequest, ResolveAmendmentTargetResponse>
      resolveAmendmentTargetMethodDescriptor =
          ApiMethodDescriptor
              .<ResolveAmendmentTargetRequest, ResolveAmendmentTargetResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/ResolveAmendmentTarget")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResolveAmendmentTargetRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/privateOffers:resolveAmendmentTarget",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResolveAmendmentTargetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResolveAmendmentTargetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "baseStandardOffer", request.getBaseStandardOffer());
                            serializer.putQueryParam(
                                fields, "targetBillingAccount", request.getTargetBillingAccount());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResolveAmendmentTargetResponse>newBuilder()
                      .setDefaultInstance(ResolveAmendmentTargetResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePrivateOfferRequest, PrivateOffer>
      createPrivateOfferMethodDescriptor =
          ApiMethodDescriptor.<CreatePrivateOfferRequest, PrivateOffer>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/CreatePrivateOffer")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePrivateOfferRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/privateOffers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("privateOffer", request.getPrivateOffer(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateOffer>newBuilder()
                      .setDefaultInstance(PrivateOffer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePrivateOfferRequest, PrivateOffer>
      updatePrivateOfferMethodDescriptor =
          ApiMethodDescriptor.<UpdatePrivateOfferRequest, PrivateOffer>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/UpdatePrivateOffer")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePrivateOfferRequest>newBuilder()
                      .setPath(
                          "/v1beta/{privateOffer.name=projects/*/locations/*/privateOffers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrivateOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "privateOffer.name", request.getPrivateOffer().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrivateOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("privateOffer", request.getPrivateOffer(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateOffer>newBuilder()
                      .setDefaultInstance(PrivateOffer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PublishPrivateOfferRequest, PrivateOffer>
      publishPrivateOfferMethodDescriptor =
          ApiMethodDescriptor.<PublishPrivateOfferRequest, PrivateOffer>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/PublishPrivateOffer")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PublishPrivateOfferRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/privateOffers/*}:publish",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PublishPrivateOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PublishPrivateOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateOffer>newBuilder()
                      .setDefaultInstance(PrivateOffer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CancelPrivateOfferRequest, PrivateOffer>
      cancelPrivateOfferMethodDescriptor =
          ApiMethodDescriptor.<CancelPrivateOfferRequest, PrivateOffer>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/CancelPrivateOffer")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelPrivateOfferRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/privateOffers/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelPrivateOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelPrivateOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateOffer>newBuilder()
                      .setDefaultInstance(PrivateOffer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePrivateOfferRequest, Empty>
      deletePrivateOfferMethodDescriptor =
          ApiMethodDescriptor.<DeletePrivateOfferRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/DeletePrivateOffer")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePrivateOfferRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/privateOffers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePrivateOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePrivateOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse>
      listPrivateOfferDocumentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/ListPrivateOfferDocuments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPrivateOfferDocumentsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/privateOffers/*}/documents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateOfferDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateOfferDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPrivateOfferDocumentsResponse>newBuilder()
                      .setDefaultInstance(ListPrivateOfferDocumentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
      getPrivateOfferDocumentMethodDescriptor =
          ApiMethodDescriptor.<GetPrivateOfferDocumentRequest, PrivateOfferDocument>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/GetPrivateOfferDocument")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPrivateOfferDocumentRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/privateOffers/*/documents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateOfferDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateOfferDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateOfferDocument>newBuilder()
                      .setDefaultInstance(PrivateOfferDocument.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
      createPrivateOfferDocumentMethodDescriptor =
          ApiMethodDescriptor.<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/CreatePrivateOfferDocument")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePrivateOfferDocumentRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/privateOffers/*}/documents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateOfferDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateOfferDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "privateOfferDocument",
                                      request.getPrivateOfferDocument(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateOfferDocument>newBuilder()
                      .setDefaultInstance(PrivateOfferDocument.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
      updatePrivateOfferDocumentMethodDescriptor =
          ApiMethodDescriptor.<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/UpdatePrivateOfferDocument")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePrivateOfferDocumentRequest>newBuilder()
                      .setPath(
                          "/v1beta/{privateOfferDocument.name=projects/*/locations/*/privateOffers/*/documents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrivateOfferDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "privateOfferDocument.name",
                                request.getPrivateOfferDocument().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePrivateOfferDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "privateOfferDocument",
                                      request.getPrivateOfferDocument(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateOfferDocument>newBuilder()
                      .setDefaultInstance(PrivateOfferDocument.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePrivateOfferDocumentRequest, Empty>
      deletePrivateOfferDocumentMethodDescriptor =
          ApiMethodDescriptor.<DeletePrivateOfferDocumentRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/DeletePrivateOfferDocument")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePrivateOfferDocumentRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/privateOffers/*/documents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePrivateOfferDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePrivateOfferDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListStandardOffersRequest, ListStandardOffersResponse>
      listStandardOffersMethodDescriptor =
          ApiMethodDescriptor.<ListStandardOffersRequest, ListStandardOffersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/ListStandardOffers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListStandardOffersRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/services/*}/standardOffers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListStandardOffersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListStandardOffersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListStandardOffersResponse>newBuilder()
                      .setDefaultInstance(ListStandardOffersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetStandardOfferRequest, StandardOffer>
      getStandardOfferMethodDescriptor =
          ApiMethodDescriptor.<GetStandardOfferRequest, StandardOffer>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/GetStandardOffer")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetStandardOfferRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/services/*/standardOffers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetStandardOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetStandardOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StandardOffer>newBuilder()
                      .setDefaultInstance(StandardOffer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSkuRequest, Sku> getSkuMethodDescriptor =
      ApiMethodDescriptor.<GetSkuRequest, Sku>newBuilder()
          .setFullMethodName("google.cloud.commerceproducer.v1beta.CommerceTransaction/GetSku")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSkuRequest>newBuilder()
                  .setPath(
                      "/v1beta/{name=projects/*/locations/*/services/*/skus/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSkuRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSkuRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Sku>newBuilder()
                  .setDefaultInstance(Sku.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListSkusRequest, ListSkusResponse>
      listSkusMethodDescriptor =
          ApiMethodDescriptor.<ListSkusRequest, ListSkusResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/ListSkus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSkusRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/services/*}/skus",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSkusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSkusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSkusResponse>newBuilder()
                      .setDefaultInstance(ListSkusResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSkuGroupRequest, SkuGroup>
      getSkuGroupMethodDescriptor =
          ApiMethodDescriptor.<GetSkuGroupRequest, SkuGroup>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/GetSkuGroup")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSkuGroupRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/skuGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSkuGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSkuGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SkuGroup>newBuilder()
                      .setDefaultInstance(SkuGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSkuGroupsRequest, ListSkuGroupsResponse>
      listSkuGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListSkuGroupsRequest, ListSkuGroupsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerceproducer.v1beta.CommerceTransaction/ListSkuGroups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSkuGroupsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/skuGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSkuGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSkuGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSkuGroupsResponse>newBuilder()
                      .setDefaultInstance(ListSkuGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final UnaryCallable<ResolveAmendmentTargetRequest, ResolveAmendmentTargetResponse>
      resolveAmendmentTargetCallable;
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCommerceTransactionStub create(
      CommerceTransactionStubSettings settings) throws IOException {
    return new HttpJsonCommerceTransactionStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCommerceTransactionStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCommerceTransactionStub(
        CommerceTransactionStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCommerceTransactionStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCommerceTransactionStub(
        CommerceTransactionStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCommerceTransactionStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCommerceTransactionStub(
      CommerceTransactionStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCommerceTransactionCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCommerceTransactionStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCommerceTransactionStub(
      CommerceTransactionStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        HttpJsonCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetServiceRequest, Service> getServiceTransportSettings =
        HttpJsonCallSettings.<GetServiceRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListPrivateOffersRequest, ListPrivateOffersResponse>
        listPrivateOffersTransportSettings =
            HttpJsonCallSettings.<ListPrivateOffersRequest, ListPrivateOffersResponse>newBuilder()
                .setMethodDescriptor(listPrivateOffersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetPrivateOfferRequest, PrivateOffer> getPrivateOfferTransportSettings =
        HttpJsonCallSettings.<GetPrivateOfferRequest, PrivateOffer>newBuilder()
            .setMethodDescriptor(getPrivateOfferMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ResolveAmendmentTargetRequest, ResolveAmendmentTargetResponse>
        resolveAmendmentTargetTransportSettings =
            HttpJsonCallSettings
                .<ResolveAmendmentTargetRequest, ResolveAmendmentTargetResponse>newBuilder()
                .setMethodDescriptor(resolveAmendmentTargetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreatePrivateOfferRequest, PrivateOffer>
        createPrivateOfferTransportSettings =
            HttpJsonCallSettings.<CreatePrivateOfferRequest, PrivateOffer>newBuilder()
                .setMethodDescriptor(createPrivateOfferMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdatePrivateOfferRequest, PrivateOffer>
        updatePrivateOfferTransportSettings =
            HttpJsonCallSettings.<UpdatePrivateOfferRequest, PrivateOffer>newBuilder()
                .setMethodDescriptor(updatePrivateOfferMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "private_offer.name",
                          String.valueOf(request.getPrivateOffer().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<PublishPrivateOfferRequest, PrivateOffer>
        publishPrivateOfferTransportSettings =
            HttpJsonCallSettings.<PublishPrivateOfferRequest, PrivateOffer>newBuilder()
                .setMethodDescriptor(publishPrivateOfferMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<CancelPrivateOfferRequest, PrivateOffer>
        cancelPrivateOfferTransportSettings =
            HttpJsonCallSettings.<CancelPrivateOfferRequest, PrivateOffer>newBuilder()
                .setMethodDescriptor(cancelPrivateOfferMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<DeletePrivateOfferRequest, Empty> deletePrivateOfferTransportSettings =
        HttpJsonCallSettings.<DeletePrivateOfferRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePrivateOfferMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse>
        listPrivateOfferDocumentsTransportSettings =
            HttpJsonCallSettings
                .<ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse>newBuilder()
                .setMethodDescriptor(listPrivateOfferDocumentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
        getPrivateOfferDocumentTransportSettings =
            HttpJsonCallSettings.<GetPrivateOfferDocumentRequest, PrivateOfferDocument>newBuilder()
                .setMethodDescriptor(getPrivateOfferDocumentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
        createPrivateOfferDocumentTransportSettings =
            HttpJsonCallSettings
                .<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>newBuilder()
                .setMethodDescriptor(createPrivateOfferDocumentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
        updatePrivateOfferDocumentTransportSettings =
            HttpJsonCallSettings
                .<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>newBuilder()
                .setMethodDescriptor(updatePrivateOfferDocumentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "private_offer_document.name",
                          String.valueOf(request.getPrivateOfferDocument().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeletePrivateOfferDocumentRequest, Empty>
        deletePrivateOfferDocumentTransportSettings =
            HttpJsonCallSettings.<DeletePrivateOfferDocumentRequest, Empty>newBuilder()
                .setMethodDescriptor(deletePrivateOfferDocumentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListStandardOffersRequest, ListStandardOffersResponse>
        listStandardOffersTransportSettings =
            HttpJsonCallSettings.<ListStandardOffersRequest, ListStandardOffersResponse>newBuilder()
                .setMethodDescriptor(listStandardOffersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetStandardOfferRequest, StandardOffer> getStandardOfferTransportSettings =
        HttpJsonCallSettings.<GetStandardOfferRequest, StandardOffer>newBuilder()
            .setMethodDescriptor(getStandardOfferMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetSkuRequest, Sku> getSkuTransportSettings =
        HttpJsonCallSettings.<GetSkuRequest, Sku>newBuilder()
            .setMethodDescriptor(getSkuMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListSkusRequest, ListSkusResponse> listSkusTransportSettings =
        HttpJsonCallSettings.<ListSkusRequest, ListSkusResponse>newBuilder()
            .setMethodDescriptor(listSkusMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetSkuGroupRequest, SkuGroup> getSkuGroupTransportSettings =
        HttpJsonCallSettings.<GetSkuGroupRequest, SkuGroup>newBuilder()
            .setMethodDescriptor(getSkuGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListSkuGroupsRequest, ListSkuGroupsResponse>
        listSkuGroupsTransportSettings =
            HttpJsonCallSettings.<ListSkuGroupsRequest, ListSkuGroupsResponse>newBuilder()
                .setMethodDescriptor(listSkuGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
    this.resolveAmendmentTargetCallable =
        callableFactory.createUnaryCallable(
            resolveAmendmentTargetTransportSettings,
            settings.resolveAmendmentTargetSettings(),
            clientContext);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listServicesMethodDescriptor);
    methodDescriptors.add(getServiceMethodDescriptor);
    methodDescriptors.add(listPrivateOffersMethodDescriptor);
    methodDescriptors.add(getPrivateOfferMethodDescriptor);
    methodDescriptors.add(resolveAmendmentTargetMethodDescriptor);
    methodDescriptors.add(createPrivateOfferMethodDescriptor);
    methodDescriptors.add(updatePrivateOfferMethodDescriptor);
    methodDescriptors.add(publishPrivateOfferMethodDescriptor);
    methodDescriptors.add(cancelPrivateOfferMethodDescriptor);
    methodDescriptors.add(deletePrivateOfferMethodDescriptor);
    methodDescriptors.add(listPrivateOfferDocumentsMethodDescriptor);
    methodDescriptors.add(getPrivateOfferDocumentMethodDescriptor);
    methodDescriptors.add(createPrivateOfferDocumentMethodDescriptor);
    methodDescriptors.add(updatePrivateOfferDocumentMethodDescriptor);
    methodDescriptors.add(deletePrivateOfferDocumentMethodDescriptor);
    methodDescriptors.add(listStandardOffersMethodDescriptor);
    methodDescriptors.add(getStandardOfferMethodDescriptor);
    methodDescriptors.add(getSkuMethodDescriptor);
    methodDescriptors.add(listSkusMethodDescriptor);
    methodDescriptors.add(getSkuGroupMethodDescriptor);
    methodDescriptors.add(listSkuGroupsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
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
  public UnaryCallable<ResolveAmendmentTargetRequest, ResolveAmendmentTargetResponse>
      resolveAmendmentTargetCallable() {
    return resolveAmendmentTargetCallable;
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
