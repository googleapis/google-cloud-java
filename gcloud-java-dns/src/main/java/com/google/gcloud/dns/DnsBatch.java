/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.dns;

import static com.google.common.base.Preconditions.checkArgument;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.ManagedZonesListResponse;
import com.google.api.services.dns.model.Project;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.gcloud.Page;
import com.google.gcloud.PageImpl;
import com.google.gcloud.dns.spi.DnsRpc;
import com.google.gcloud.dns.spi.RpcBatch;

import java.util.List;
import java.util.Map;

/**
 * A batch of operations to be submitted to Google Cloud DNS using a single RPC request.
 */
public class DnsBatch {

  private RpcBatch batch;
  private final DnsRpc dnsRpc;
  private final DnsOptions options;

  DnsBatch(DnsOptions options) {
    this.options = options;
    this.dnsRpc = options.rpc();
    this.batch = dnsRpc.createBatch();
  }

  Object batch() {
    return batch;
  }

  DnsRpc dnsRpc() {
    return dnsRpc;
  }

  DnsOptions options() {
    return options;
  }

  /**
   * Adds a request representing the "list zones" operation to this batch. The {@code options} can
   * be used to restrict the fields returned or provide page size limits in the same way as for
   * {@link Dns#listZones(Dns.ZoneListOption...)}. The returned {@link DnsBatchResult} will return a
   * page of zones upon calling {@link DnsBatchResult#get()} on successful completion, or it will
   * throw a {@link DnsException} if the operation failed.
   */
  public DnsBatchResult<Page<Zone>> listZones(Dns.ZoneListOption... options) {
    DnsBatchResult<Page<Zone>> result = new DnsBatchResult<>();
    final Map<DnsRpc.Option, ?> optionMap = optionMap(options);
    DnsRpc.Callback<ManagedZonesListResponse> callback = createListZonesCallback(result, optionMap);
    batch.addListZones(callback, optionMap);
    return result;
  }

  /**
   * Adds a request representing the "create zone" operation to this batch. The {@code options} can
   * be used to restrict the fields returned in the same way as for {@link Dns#create(ZoneInfo,
   * Dns.ZoneOption...)}. The returned {@link DnsBatchResult} will return the created {@link Zone}
   * upon calling {@link DnsBatchResult#get()} on successful completion, or it will throw a {@link
   * DnsException} if the operation failed.
   */
  public DnsBatchResult<Zone> createZone(ZoneInfo zone, Dns.ZoneOption... options) {
    DnsBatchResult<Zone> result = new DnsBatchResult<>();
    DnsRpc.Callback<ManagedZone> callback = createZoneCallback(this.options, result);
    Map<DnsRpc.Option, ?> optionMap = optionMap(options);
    batch.addCreateZone(zone.toPb(), callback, optionMap);
    return result;
  }

  /**
   * Adds a request representing the "delete zone" operation to this batch. The returned {@link
   * DnsBatchResult} will return {@code true} upon calling {@link DnsBatchResult#get()} on
   * successful deletion, {@code false} if the zone was not found, or it will throw a {@link
   * DnsException} if the operation failed.
   */
  public DnsBatchResult<Boolean> deleteZone(String zoneName) {
    DnsBatchResult<Boolean> result = new DnsBatchResult<>();
    DnsRpc.Callback<Void> callback = createDeleteZoneCallback(result);
    batch.addDeleteZone(zoneName, callback);
    return result;
  }

  /**
   * Adds a request representing the "get zone" operation to this batch. The {@code options} can be
   * used to restrict the fields returned in the same way as for {@link Dns#getZone(String,
   * Dns.ZoneOption...)}. The returned {@link DnsBatchResult} will return the requested {@link Zone}
   * upon calling {@link DnsBatchResult#get()} on successful completion, {@code null} if no such
   * zone exists, or it will throw a {@link DnsException} if the operation failed.
   */
  public DnsBatchResult<Zone> getZone(String zoneName, Dns.ZoneOption... options) {
    DnsBatchResult<Zone> result = new DnsBatchResult<>();
    DnsRpc.Callback<ManagedZone> callback = createZoneCallback(this.options, result);
    Map<DnsRpc.Option, ?> optionMap = optionMap(options);
    batch.addGetZone(zoneName, callback, optionMap);
    return result;
  }

  /**
   * Adds a request representing the "get project" operation to this batch. The {@code options} can
   * be used to restrict the fields returned in the same way as for {@link
   * Dns#getProject(Dns.ProjectOption...)}. The returned {@link DnsBatchResult} will return the
   * requested {@link ProjectInfo} upon calling {@link DnsBatchResult#get()} on successful
   * completion, or it will throw a {@link DnsException} if the operation failed.
   */
  public DnsBatchResult<ProjectInfo> getProject(Dns.ProjectOption... options) {
    DnsBatchResult<ProjectInfo> result = new DnsBatchResult<>();
    DnsRpc.Callback<Project> callback = createProjectCallback(result);
    Map<DnsRpc.Option, ?> optionMap = optionMap(options);
    batch.addGetProject(callback, optionMap);
    return result;
  }

  // todo(mderka) implement remaining operations

  /**
   * Submits this batch for processing using a single HTTP request.
   */
  public void submit() {
    batch.submit();
  }

  private Map<DnsRpc.Option, ?> optionMap(AbstractOption... options) {
    Map<DnsRpc.Option, Object> temp = Maps.newEnumMap(DnsRpc.Option.class);
    for (AbstractOption option : options) {
      Object prev = temp.put(option.rpcOption(), option.value());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return ImmutableMap.copyOf(temp);
  }

  private DnsRpc.Callback<ManagedZonesListResponse> createListZonesCallback(
      final DnsBatchResult result, final Map<DnsRpc.Option, ?> optionMap) {
    DnsRpc.Callback callback = new DnsRpc.Callback<ManagedZonesListResponse>() {
      @Override
      public void onSuccess(ManagedZonesListResponse response) {
        List<ManagedZone> zones = response.getManagedZones();
        Page<Zone> zonePage = new PageImpl<>(
            new DnsImpl.ZonePageFetcher(options, response.getNextPageToken(), optionMap),
            response.getNextPageToken(), zones == null ? ImmutableList.<Zone>of()
            : Iterables.transform(zones, DnsImpl.pbToZoneFunction(options)));
        result.success(zonePage);
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        result.error(new DnsException(googleJsonError));
      }
    };
    return callback;
  }

  private DnsRpc.Callback<Void> createDeleteZoneCallback(final DnsBatchResult result) {
    DnsRpc.Callback callback = new DnsRpc.Callback<Void>() {
      @Override
      public void onSuccess(Void response) {
        result.success(true);
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        DnsException serviceException = new DnsException(googleJsonError);
        if (serviceException.code() == HTTP_NOT_FOUND) {
          result.success(false);
          return;
        }
        result.error(serviceException);
      }
    };
    return callback;
  }

  /**
   * A joint callback for both "get zone" and "create zone" operation.
   */
  private DnsRpc.Callback<ManagedZone> createZoneCallback(final DnsOptions serviceOptions,
      final DnsBatchResult result) {
    DnsRpc.Callback callback = new DnsRpc.Callback<ManagedZone>() {
      @Override
      public void onSuccess(ManagedZone response) {
        result.success(response == null ? null : Zone.fromPb(serviceOptions.service(), response));
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        result.error(new DnsException(googleJsonError));
      }
    };
    return callback;
  }

  private DnsRpc.Callback<Project> createProjectCallback(final DnsBatchResult result) {
    DnsRpc.Callback callback = new DnsRpc.Callback<Project>() {
      @Override
      public void onSuccess(Project response) {
        result.success(response == null ? null : ProjectInfo.fromPb(response));
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        result.error(new DnsException(googleJsonError));
      }
    };
    return callback;
  }
}
