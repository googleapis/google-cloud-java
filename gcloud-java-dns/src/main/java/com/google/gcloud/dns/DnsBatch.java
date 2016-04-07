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

import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ChangesListResponse;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.ManagedZonesListResponse;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.api.services.dns.model.ResourceRecordSetsListResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
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
    Map<DnsRpc.Option, ?> optionMap = DnsImpl.optionMap(options);
    RpcBatch.Callback<ManagedZonesListResponse> callback = createListZonesCallback(result,
        optionMap);
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
    RpcBatch.Callback<ManagedZone> callback = createZoneCallback(this.options, result);
    Map<DnsRpc.Option, ?> optionMap = DnsImpl.optionMap(options);
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
    RpcBatch.Callback<Void> callback = createDeleteZoneCallback(result);
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
    RpcBatch.Callback<ManagedZone> callback = createZoneCallback(this.options, result);
    Map<DnsRpc.Option, ?> optionMap = DnsImpl.optionMap(options);
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
    RpcBatch.Callback<Project> callback = createProjectCallback(result);
    Map<DnsRpc.Option, ?> optionMap = DnsImpl.optionMap(options);
    batch.addGetProject(callback, optionMap);
    return result;
  }

  /**
   * Adds a request representing the "list record sets" operation in the zone specified by {@code
   * zoneName} to this batch. The {@code options} can be used to restrict the fields returned or
   * provide page size limits in the same way as for {@link Dns#listRecordSets(String,
   * Dns.RecordSetListOption...)}. The returned {@link DnsBatchResult} will return a page of record
   * sets upon calling {@link DnsBatchResult#get()} on successful completion, or it will throw a
   * {@link DnsException} if the operation failed or the zone does not exist.
   */
  public DnsBatchResult<Page<RecordSet>> listRecordSets(String zoneName,
      Dns.RecordSetListOption... options) {
    DnsBatchResult<Page<RecordSet>> result = new DnsBatchResult<>();
    Map<DnsRpc.Option, ?> optionMap = DnsImpl.optionMap(options);
    RpcBatch.Callback<ResourceRecordSetsListResponse> callback =
        createListRecordSetsCallback(zoneName, result, optionMap);
    batch.addListRecordSets(zoneName, callback, optionMap);
    return result;
  }

  /**
   * Adds a request representing the "list change requests" operation in the zone specified by
   * {@code zoneName} to this batch. The {@code options} can be used to restrict the fields returned
   * or provide page size limits in the same way as for {@link Dns#listChangeRequests(String,
   * Dns.ChangeRequestListOption...)}. The returned {@link DnsBatchResult} will return a page of
   * change requests upon calling {@link DnsBatchResult#get()} on successful completion, or it will
   * throw a {@link DnsException} if the operation failed or the zone does not exist.
   */
  public DnsBatchResult<Page<ChangeRequest>> listChangeRequests(String zoneName,
      Dns.ChangeRequestListOption... options) {
    DnsBatchResult<Page<ChangeRequest>> result = new DnsBatchResult<>();
    Map<DnsRpc.Option, ?> optionMap = DnsImpl.optionMap(options);
    RpcBatch.Callback<ChangesListResponse> callback =
        createListChangeRequestsCallback(zoneName, result, optionMap);
    batch.addListChangeRequests(zoneName, callback, optionMap);
    return result;
  }

  /**
   * Adds a request representing the "get change request" operation for the zone specified by {@code
   * zoneName} to this batch. The {@code options} can be used to restrict the fields returned in the
   * same way as for {@link Dns#getChangeRequest(String, String, Dns.ChangeRequestOption...)}. The
   * returned {@link DnsBatchResult} will return the requested {@link ChangeRequest} upon calling
   * {@link DnsBatchResult#get()} on successful completion, {@code null} if the change request does
   * not exist, or it will throw a {@link DnsException} if the operation failed or the zone does not
   * exists.
   */
  public DnsBatchResult<ChangeRequest> getChangeRequest(String zoneName, String changeRequestId,
      Dns.ChangeRequestOption... options) {
    DnsBatchResult<ChangeRequest> result = new DnsBatchResult<>();
    RpcBatch.Callback<Change> callback = createChangeRequestCallback(zoneName, result);
    Map<DnsRpc.Option, ?> optionMap = DnsImpl.optionMap(options);
    batch.addGetChangeRequest(zoneName, changeRequestId, callback, optionMap);
    return result;
  }

  /**
   * Adds a request representing the "apply change request" operation to the zone specified by
   * {@code zoneName} to this batch. The {@code options} can be used to restrict the fields returned
   * in the same way as for {@link Dns#applyChangeRequest(String, ChangeRequestInfo,
   * Dns.ChangeRequestOption...)}. The returned {@link DnsBatchResult} will return the requested
   * {@link ChangeRequest} upon calling {@link DnsBatchResult#get()} on successful completion, or it
   * will throw a {@link DnsException} if the operation failed or the zone does not exists.
   */
  public DnsBatchResult<ChangeRequest> applyChangeRequest(String zoneName,
      ChangeRequestInfo changeRequest, Dns.ChangeRequestOption... options) {
    DnsBatchResult<ChangeRequest> result = new DnsBatchResult<>();
    RpcBatch.Callback<Change> callback = createChangeRequestCallback(zoneName, result);
    Map<DnsRpc.Option, ?> optionMap = DnsImpl.optionMap(options);
    batch.addApplyChangeRequest(zoneName, changeRequest.toPb(), callback, optionMap);
    return result;
  }

  /**
   * Submits this batch for processing using a single HTTP request.
   */
  public void submit() {
    batch.submit();
  }

  private RpcBatch.Callback<ManagedZonesListResponse> createListZonesCallback(
      final DnsBatchResult result, final Map<DnsRpc.Option, ?> optionMap) {
    return new RpcBatch.Callback<ManagedZonesListResponse>() {
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
  }

  private RpcBatch.Callback<Void> createDeleteZoneCallback(final DnsBatchResult result) {
    return new RpcBatch.Callback<Void>() {
      @Override
      public void onSuccess(Void response) {
        result.success(true);
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        DnsException serviceException = new DnsException(googleJsonError);
        if (serviceException.code() == HTTP_NOT_FOUND) {
          result.success(false);
        } else {
          result.error(serviceException);
        }
      }
    };
  }

  /**
   * A joint callback for both "get zone" and "create zone" operation.
   */
  private RpcBatch.Callback<ManagedZone> createZoneCallback(final DnsOptions serviceOptions,
      final DnsBatchResult result) {
    return new RpcBatch.Callback<ManagedZone>() {
      @Override
      public void onSuccess(ManagedZone response) {
        result.success(response == null ? null : Zone.fromPb(serviceOptions.service(), response));
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        result.error(new DnsException(googleJsonError));
      }
    };
  }

  private RpcBatch.Callback<Project> createProjectCallback(final DnsBatchResult result) {
    return new RpcBatch.Callback<Project>() {
      @Override
      public void onSuccess(Project response) {
        result.success(response == null ? null : ProjectInfo.fromPb(response));
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        result.error(new DnsException(googleJsonError));
      }
    };
  }

  private RpcBatch.Callback<ResourceRecordSetsListResponse> createListRecordSetsCallback(
      final String zoneName, final DnsBatchResult<Page<RecordSet>> result,
      final Map<DnsRpc.Option, ?> optionMap) {
    return new RpcBatch.Callback<ResourceRecordSetsListResponse>() {
      @Override
      public void onSuccess(ResourceRecordSetsListResponse response) {
        List<ResourceRecordSet> recordSets = response.getRrsets();
        Page<RecordSet> page = new PageImpl<>(
            new DnsImpl.RecordSetPageFetcher(zoneName, options, response.getNextPageToken(),
                optionMap),
            response.getNextPageToken(), recordSets == null ? ImmutableList.<RecordSet>of()
            : Iterables.transform(recordSets, RecordSet.FROM_PB_FUNCTION));
        result.success(page);
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        result.error(new DnsException(googleJsonError));
      }
    };
  }

  private RpcBatch.Callback<ChangesListResponse> createListChangeRequestsCallback(
      final String zoneName, final DnsBatchResult result, final Map<DnsRpc.Option, ?> optionMap) {
    return new RpcBatch.Callback<ChangesListResponse>() {
      @Override
      public void onSuccess(ChangesListResponse response) {
        List<Change> changes = response.getChanges();
        Page<ChangeRequest> page = new PageImpl<>(
            new DnsImpl.ChangeRequestPageFetcher(zoneName, options, response.getNextPageToken(),
                optionMap),
            response.getNextPageToken(), changes == null ? ImmutableList.<ChangeRequest>of()
            : Iterables.transform(changes, ChangeRequest.fromPbFunction(options.service(),
            zoneName)));
        result.success(page);
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        result.error(new DnsException(googleJsonError));
      }
    };
  }

  /**
   * A joint callback for both "get change request" and "create change request" operation.
   */
  private RpcBatch.Callback<Change> createChangeRequestCallback(final String zoneName,
      final DnsBatchResult result) {
    return new RpcBatch.Callback<Change>() {
      @Override
      public void onSuccess(Change response) {
        result.success(response == null ? null : ChangeRequest.fromPb(options.service(),
            zoneName, response));
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        result.error(new DnsException(googleJsonError));
      }
    };
  }
}
