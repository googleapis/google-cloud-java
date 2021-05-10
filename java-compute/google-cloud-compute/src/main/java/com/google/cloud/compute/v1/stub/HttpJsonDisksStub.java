/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.DisksClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.DisksClient.ListPagedResponse;

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.FieldsExtractor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddResourcePoliciesDiskRequest;
import com.google.cloud.compute.v1.AggregatedListDisksRequest;
import com.google.cloud.compute.v1.CreateSnapshotDiskRequest;
import com.google.cloud.compute.v1.DeleteDiskRequest;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskAggregatedList;
import com.google.cloud.compute.v1.DiskList;
import com.google.cloud.compute.v1.GetDiskRequest;
import com.google.cloud.compute.v1.GetIamPolicyDiskRequest;
import com.google.cloud.compute.v1.InsertDiskRequest;
import com.google.cloud.compute.v1.ListDisksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveResourcePoliciesDiskRequest;
import com.google.cloud.compute.v1.ResizeDiskRequest;
import com.google.cloud.compute.v1.SetIamPolicyDiskRequest;
import com.google.cloud.compute.v1.SetLabelsDiskRequest;
import com.google.cloud.compute.v1.TestIamPermissionsDiskRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * REST stub implementation for Google Compute Engine API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonDisksStub extends DisksStub {

  @InternalApi
  public static final ApiMethodDescriptor<AddResourcePoliciesDiskRequest, Operation>
      addResourcePoliciesMethodDescriptor =
          ApiMethodDescriptor.<AddResourcePoliciesDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Disks.AddResourcePolicies")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddResourcePoliciesDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/disks/{disk}/addResourcePolicies",
                          new FieldsExtractor<
                              AddResourcePoliciesDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AddResourcePoliciesDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddResourcePoliciesDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "disk", request.getDisk());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddResourcePoliciesDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddResourcePoliciesDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddResourcePoliciesDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddResourcePoliciesDiskRequest, String>() {
                            @Override
                            public String extract(AddResourcePoliciesDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "disksAddResourcePoliciesRequestResource",
                                      request.getDisksAddResourcePoliciesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<AggregatedListDisksRequest, DiskAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor.<AggregatedListDisksRequest, DiskAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Disks.AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListDisksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/disks",
                          new FieldsExtractor<AggregatedListDisksRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(AggregatedListDisksRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListDisksRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListDisksRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListDisksRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListDisksRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasFilter()) {
                                serializer.putQueryParam(fields, "filter", request.getFilter());
                              }
                              if (request.hasIncludeAllScopes()) {
                                serializer.putQueryParam(
                                    fields, "includeAllScopes", request.getIncludeAllScopes());
                              }
                              if (request.hasMaxResults()) {
                                serializer.putQueryParam(
                                    fields, "maxResults", request.getMaxResults());
                              }
                              if (request.hasOrderBy()) {
                                serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                              }
                              if (request.hasPageToken()) {
                                serializer.putQueryParam(
                                    fields, "pageToken", request.getPageToken());
                              }
                              if (request.hasReturnPartialSuccess()) {
                                serializer.putQueryParam(
                                    fields,
                                    "returnPartialSuccess",
                                    request.getReturnPartialSuccess());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AggregatedListDisksRequest, String>() {
                            @Override
                            public String extract(AggregatedListDisksRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DiskAggregatedList>newBuilder()
                      .setDefaultInstance(DiskAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<CreateSnapshotDiskRequest, Operation>
      createSnapshotMethodDescriptor =
          ApiMethodDescriptor.<CreateSnapshotDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Disks.CreateSnapshot")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSnapshotDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/disks/{disk}/createSnapshot",
                          new FieldsExtractor<CreateSnapshotDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(CreateSnapshotDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<CreateSnapshotDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "disk", request.getDisk());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              CreateSnapshotDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                CreateSnapshotDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<CreateSnapshotDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasGuestFlush()) {
                                serializer.putQueryParam(
                                    fields, "guestFlush", request.getGuestFlush());
                              }
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<CreateSnapshotDiskRequest, String>() {
                            @Override
                            public String extract(CreateSnapshotDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("snapshotResource", request.getSnapshotResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteDiskRequest, Operation> deleteMethodDescriptor =
      ApiMethodDescriptor.<DeleteDiskRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Disks.Delete")
          .setHttpMethod(HttpMethods.DELETE)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteDiskRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/disks/{disk}",
                      new FieldsExtractor<DeleteDiskRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(DeleteDiskRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteDiskRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          serializer.putPathParam(fields, "disk", request.getDisk());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<DeleteDiskRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(DeleteDiskRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteDiskRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<DeleteDiskRequest, String>() {
                        @Override
                        public String extract(DeleteDiskRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetDiskRequest, Disk> getMethodDescriptor =
      ApiMethodDescriptor.<GetDiskRequest, Disk>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Disks.Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetDiskRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/disks/{disk}",
                      new FieldsExtractor<GetDiskRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetDiskRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetDiskRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          serializer.putPathParam(fields, "disk", request.getDisk());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetDiskRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetDiskRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetDiskRequest> serializer =
                              ProtoRestSerializer.create();

                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetDiskRequest, String>() {
                        @Override
                        public String extract(GetDiskRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Disk>newBuilder()
                  .setDefaultInstance(Disk.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicyDiskRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyDiskRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Disks.GetIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/disks/{resource}/getIamPolicy",
                          new FieldsExtractor<GetIamPolicyDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetIamPolicyDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetIamPolicyDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetIamPolicyDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasOptionsRequestedPolicyVersion()) {
                                serializer.putQueryParam(
                                    fields,
                                    "optionsRequestedPolicyVersion",
                                    request.getOptionsRequestedPolicyVersion());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetIamPolicyDiskRequest, String>() {
                            @Override
                            public String extract(GetIamPolicyDiskRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertDiskRequest, Operation> insertMethodDescriptor =
      ApiMethodDescriptor.<InsertDiskRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Disks.Insert")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<InsertDiskRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/disks",
                      new FieldsExtractor<InsertDiskRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(InsertDiskRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<InsertDiskRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<InsertDiskRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(InsertDiskRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<InsertDiskRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          if (request.hasSourceImage()) {
                            serializer.putQueryParam(
                                fields, "sourceImage", request.getSourceImage());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<InsertDiskRequest, String>() {
                        @Override
                        public String extract(InsertDiskRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("diskResource", request.getDiskResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListDisksRequest, DiskList> listMethodDescriptor =
      ApiMethodDescriptor.<ListDisksRequest, DiskList>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Disks.List")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ListDisksRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/disks",
                      new FieldsExtractor<ListDisksRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(ListDisksRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<ListDisksRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<ListDisksRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(ListDisksRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<ListDisksRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasFilter()) {
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                          }
                          if (request.hasMaxResults()) {
                            serializer.putQueryParam(fields, "maxResults", request.getMaxResults());
                          }
                          if (request.hasOrderBy()) {
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                          }
                          if (request.hasPageToken()) {
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                          }
                          if (request.hasReturnPartialSuccess()) {
                            serializer.putQueryParam(
                                fields, "returnPartialSuccess", request.getReturnPartialSuccess());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<ListDisksRequest, String>() {
                        @Override
                        public String extract(ListDisksRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<DiskList>newBuilder()
                  .setDefaultInstance(DiskList.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<RemoveResourcePoliciesDiskRequest, Operation>
      removeResourcePoliciesMethodDescriptor =
          ApiMethodDescriptor.<RemoveResourcePoliciesDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Disks.RemoveResourcePolicies")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveResourcePoliciesDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/disks/{disk}/removeResourcePolicies",
                          new FieldsExtractor<
                              RemoveResourcePoliciesDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                RemoveResourcePoliciesDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveResourcePoliciesDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "disk", request.getDisk());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              RemoveResourcePoliciesDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                RemoveResourcePoliciesDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveResourcePoliciesDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<RemoveResourcePoliciesDiskRequest, String>() {
                            @Override
                            public String extract(RemoveResourcePoliciesDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "disksRemoveResourcePoliciesRequestResource",
                                      request.getDisksRemoveResourcePoliciesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ResizeDiskRequest, Operation> resizeMethodDescriptor =
      ApiMethodDescriptor.<ResizeDiskRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Disks.Resize")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ResizeDiskRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/disks/{disk}/resize",
                      new FieldsExtractor<ResizeDiskRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(ResizeDiskRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<ResizeDiskRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          serializer.putPathParam(fields, "disk", request.getDisk());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<ResizeDiskRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(ResizeDiskRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<ResizeDiskRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<ResizeDiskRequest, String>() {
                        @Override
                        public String extract(ResizeDiskRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody(
                                  "disksResizeRequestResource",
                                  request.getDisksResizeRequestResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicyDiskRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyDiskRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Disks.SetIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/disks/{resource}/setIamPolicy",
                          new FieldsExtractor<SetIamPolicyDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(SetIamPolicyDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetIamPolicyDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetIamPolicyDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyDiskRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetIamPolicyDiskRequest, String>() {
                            @Override
                            public String extract(SetIamPolicyDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "zoneSetPolicyRequestResource",
                                      request.getZoneSetPolicyRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetLabelsDiskRequest, Operation>
      setLabelsMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Disks.SetLabels")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLabelsDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/disks/{resource}/setLabels",
                          new FieldsExtractor<SetLabelsDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(SetLabelsDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<SetLabelsDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(SetLabelsDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetLabelsDiskRequest, String>() {
                            @Override
                            public String extract(SetLabelsDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "zoneSetLabelsRequestResource",
                                      request.getZoneSetLabelsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<TestIamPermissionsDiskRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsDiskRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Disks.TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/disks/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsDiskRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<TestIamPermissionsDiskRequest, String>() {
                            @Override
                            public String extract(TestIamPermissionsDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "testPermissionsRequestResource",
                                      request.getTestPermissionsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AddResourcePoliciesDiskRequest, Operation>
      addResourcePoliciesCallable;
  private final UnaryCallable<AggregatedListDisksRequest, DiskAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListDisksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<CreateSnapshotDiskRequest, Operation> createSnapshotCallable;
  private final UnaryCallable<DeleteDiskRequest, Operation> deleteCallable;
  private final UnaryCallable<GetDiskRequest, Disk> getCallable;
  private final UnaryCallable<GetIamPolicyDiskRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertDiskRequest, Operation> insertCallable;
  private final UnaryCallable<ListDisksRequest, DiskList> listCallable;
  private final UnaryCallable<ListDisksRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<RemoveResourcePoliciesDiskRequest, Operation>
      removeResourcePoliciesCallable;
  private final UnaryCallable<ResizeDiskRequest, Operation> resizeCallable;
  private final UnaryCallable<SetIamPolicyDiskRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetLabelsDiskRequest, Operation> setLabelsCallable;
  private final UnaryCallable<TestIamPermissionsDiskRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDisksStub create(DisksStubSettings settings) throws IOException {
    return new HttpJsonDisksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDisksStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonDisksStub(DisksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonDisksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDisksStub(
        DisksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDisksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDisksStub(DisksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDisksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDisksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDisksStub(
      DisksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddResourcePoliciesDiskRequest, Operation>
        addResourcePoliciesTransportSettings =
            HttpJsonCallSettings.<AddResourcePoliciesDiskRequest, Operation>newBuilder()
                .setMethodDescriptor(addResourcePoliciesMethodDescriptor)
                .build();
    HttpJsonCallSettings<AggregatedListDisksRequest, DiskAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings.<AggregatedListDisksRequest, DiskAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<CreateSnapshotDiskRequest, Operation> createSnapshotTransportSettings =
        HttpJsonCallSettings.<CreateSnapshotDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(createSnapshotMethodDescriptor)
            .build();
    HttpJsonCallSettings<DeleteDiskRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetDiskRequest, Disk> getTransportSettings =
        HttpJsonCallSettings.<GetDiskRequest, Disk>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetIamPolicyDiskRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyDiskRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertDiskRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListDisksRequest, DiskList> listTransportSettings =
        HttpJsonCallSettings.<ListDisksRequest, DiskList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<RemoveResourcePoliciesDiskRequest, Operation>
        removeResourcePoliciesTransportSettings =
            HttpJsonCallSettings.<RemoveResourcePoliciesDiskRequest, Operation>newBuilder()
                .setMethodDescriptor(removeResourcePoliciesMethodDescriptor)
                .build();
    HttpJsonCallSettings<ResizeDiskRequest, Operation> resizeTransportSettings =
        HttpJsonCallSettings.<ResizeDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetIamPolicyDiskRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyDiskRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetLabelsDiskRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .build();
    HttpJsonCallSettings<TestIamPermissionsDiskRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsDiskRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .build();

    this.addResourcePoliciesCallable =
        callableFactory.createUnaryCallable(
            addResourcePoliciesTransportSettings,
            settings.addResourcePoliciesSettings(),
            clientContext);
    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.createSnapshotCallable =
        callableFactory.createUnaryCallable(
            createSnapshotTransportSettings, settings.createSnapshotSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.removeResourcePoliciesCallable =
        callableFactory.createUnaryCallable(
            removeResourcePoliciesTransportSettings,
            settings.removeResourcePoliciesSettings(),
            clientContext);
    this.resizeCallable =
        callableFactory.createUnaryCallable(
            resizeTransportSettings, settings.resizeSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.setLabelsCallable =
        callableFactory.createUnaryCallable(
            setLabelsTransportSettings, settings.setLabelsSettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<AddResourcePoliciesDiskRequest, Operation> addResourcePoliciesCallable() {
    return addResourcePoliciesCallable;
  }

  public UnaryCallable<AggregatedListDisksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  public UnaryCallable<AggregatedListDisksRequest, DiskAggregatedList> aggregatedListCallable() {
    return aggregatedListCallable;
  }

  public UnaryCallable<CreateSnapshotDiskRequest, Operation> createSnapshotCallable() {
    return createSnapshotCallable;
  }

  public UnaryCallable<DeleteDiskRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetDiskRequest, Disk> getCallable() {
    return getCallable;
  }

  public UnaryCallable<GetIamPolicyDiskRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<InsertDiskRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListDisksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListDisksRequest, DiskList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<RemoveResourcePoliciesDiskRequest, Operation>
      removeResourcePoliciesCallable() {
    return removeResourcePoliciesCallable;
  }

  public UnaryCallable<ResizeDiskRequest, Operation> resizeCallable() {
    return resizeCallable;
  }

  public UnaryCallable<SetIamPolicyDiskRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<SetLabelsDiskRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  public UnaryCallable<TestIamPermissionsDiskRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
