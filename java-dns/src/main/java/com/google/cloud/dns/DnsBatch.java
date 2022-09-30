/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.dns;

import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.gax.paging.Page;
import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ChangesListResponse;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.ManagedZonesListResponse;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.api.services.dns.model.ResourceRecordSetsListResponse;
import com.google.cloud.PageImpl;
import com.google.cloud.dns.spi.v1.DnsRpc;
import com.google.cloud.dns.spi.v1.RpcBatch;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Map;

/** A batch of operations to be submitted to Google Cloud DNS using a single RPC request. */
public class DnsBatch {

  private final RpcBatch batch;
  private final DnsRpc dnsRpc;
  private final DnsOptions options;

  DnsBatch(DnsOptions options) {
    this.options = options;
    this.dnsRpc = options.getDnsRpcV1();
    this.batch = dnsRpc.createBatch();
  }

  @VisibleForTesting
  Object getBatch() {
    return batch;
  }

  @VisibleForTesting
  DnsRpc getDnsRpc() {
    return dnsRpc;
  }

  @VisibleForTesting
  DnsOptions getOptions() {
    return options;
  }

  /**
   * Adds a request representing the "list zones" operation to this batch. The {@code options} can
   * be used to restrict the fields returned or provide page size limits in the same way as for
   * {@link Dns#listZones(Dns.ZoneListOption...)}. Calling {@link DnsBatchResult#get()} on the
   * return value yields a page of zones if successful and throws a {@link DnsException} otherwise.
   */
  public DnsBatchResult<Page<Zone>> listZones(Dns.ZoneListOption... options) {
    DnsBatchResult<Page<Zone>> result = new DnsBatchResult<>();
    Map<DnsRpc.Option, ?> optionMap = DnsImpl.optionMap(options);
    RpcBatch.Callback<ManagedZonesListResponse> callback =
        createListZonesCallback(result, optionMap);
    batch.addListZones(callback, optionMap);
    return result;
  }

  /**
   * Adds a request representing the "create zone" operation to this batch. The {@code options} can
   * be used to restrict the fields returned in the same way as for {@link Dns#create(ZoneInfo,
   * Dns.ZoneOption...)}. Calling {@link DnsBatchResult#get()} on the return value yields the
   * created {@link Zone} if successful and throws a {@link DnsException} otherwise.
   */
  public DnsBatchResult<Zone> createZone(ZoneInfo zone, Dns.ZoneOption... options) {
    DnsBatchResult<Zone> result = new DnsBatchResult<>();
    // todo this can cause misleading report of a failure, intended to be fixed within #924
    RpcBatch.Callback<ManagedZone> callback = createZoneCallback(this.options, result, false, true);
    Map<DnsRpc.Option, ?> optionMap = DnsImpl.optionMap(options);
    batch.addCreateZone(zone.toPb(), callback, optionMap);
    return result;
  }

  /**
   * Adds a request representing the "delete zone" operation to this batch. Calling {@link
   * DnsBatchResult#get()} on the return value yields {@code true} upon successful deletion, {@code
   * false} if the zone was not found, or throws a {@link DnsException} if the operation failed.
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
   * Dns.ZoneOption...)}. Calling {@link DnsBatchResult#get()} on the return value yields the
   * requested {@link Zone} if successful, {@code null} if no such zone exists, or throws a {@link
   * DnsException} if the operation failed.
   */
  public DnsBatchResult<Zone> getZone(String zoneName, Dns.ZoneOption... options) {
    DnsBatchResult<Zone> result = new DnsBatchResult<>();
    RpcBatch.Callback<ManagedZone> callback = createZoneCallback(this.options, result, true, true);
    Map<DnsRpc.Option, ?> optionMap = DnsImpl.optionMap(options);
    batch.addGetZone(zoneName, callback, optionMap);
    return result;
  }

  /**
   * Adds a request representing the "get project" operation to this batch. The {@code options} can
   * be used to restrict the fields returned in the same way as for {@link
   * Dns#getProject(Dns.ProjectOption...)}. Calling {@link DnsBatchResult#get()} on the return value
   * yields the created {@link ProjectInfo} if successful and throws a {@link DnsException} if the
   * operation failed.
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
   * Dns.RecordSetListOption...)}. Calling {@link DnsBatchResult#get()} on the return value yields a
   * page of record sets if successful and throws a {@link DnsException} if the operation failed or
   * the zone does not exist.
   */
  public DnsBatchResult<Page<RecordSet>> listRecordSets(
      String zoneName, Dns.RecordSetListOption... options) {
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
   * Dns.ChangeRequestListOption...)}. Calling {@link DnsBatchResult#get()} on the return value
   * yields a page of change requests if successful and throws a {@link DnsException} if the
   * operation failed or the zone does not exist.
   */
  public DnsBatchResult<Page<ChangeRequest>> listChangeRequests(
      String zoneName, Dns.ChangeRequestListOption... options) {
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
   * same way as for {@link Dns#getChangeRequest(String, String, Dns.ChangeRequestOption...)}.
   * Calling {@link DnsBatchResult#get()} on the return value yields the requested {@link
   * ChangeRequest} if successful, {@code null} if the change request does not exist, or throws a
   * {@link DnsException} if the operation failed or the zone does not exist.
   */
  public DnsBatchResult<ChangeRequest> getChangeRequest(
      String zoneName, String changeRequestId, Dns.ChangeRequestOption... options) {
    DnsBatchResult<ChangeRequest> result = new DnsBatchResult<>();
    RpcBatch.Callback<Change> callback = createChangeRequestCallback(zoneName, result, true, true);
    Map<DnsRpc.Option, ?> optionMap = DnsImpl.optionMap(options);
    batch.addGetChangeRequest(zoneName, changeRequestId, callback, optionMap);
    return result;
  }

  /**
   * Adds a request representing the "apply change request" operation to the zone specified by
   * {@code zoneName} to this batch. The {@code options} can be used to restrict the fields returned
   * in the same way as for {@link Dns#applyChangeRequest(String, ChangeRequestInfo,
   * Dns.ChangeRequestOption...)}. Calling {@link DnsBatchResult#get()} on the return value yields
   * the created {@link ChangeRequest} if successful or throws a {@link DnsException} if the
   * operation failed or the zone does not exist.
   */
  public DnsBatchResult<ChangeRequest> applyChangeRequest(
      String zoneName, ChangeRequestInfo changeRequest, Dns.ChangeRequestOption... options) {
    DnsBatchResult<ChangeRequest> result = new DnsBatchResult<>();
    RpcBatch.Callback<Change> callback =
        createChangeRequestCallback(zoneName, result, false, false);
    Map<DnsRpc.Option, ?> optionMap = DnsImpl.optionMap(options);
    batch.addApplyChangeRequest(zoneName, changeRequest.toPb(), callback, optionMap);
    return result;
  }

  /** Submits this batch for processing using a single RPC request. */
  public void submit() {
    batch.submit();
  }

  private RpcBatch.Callback<ManagedZonesListResponse> createListZonesCallback(
      final DnsBatchResult<Page<Zone>> result, final Map<DnsRpc.Option, ?> optionMap) {
    return new RpcBatch.Callback<ManagedZonesListResponse>() {
      @Override
      public void onSuccess(ManagedZonesListResponse response) {
        List<ManagedZone> zones = response.getManagedZones();
        Page<Zone> zonePage =
            new PageImpl<>(
                new DnsImpl.ZonePageFetcher(options, response.getNextPageToken(), optionMap),
                response.getNextPageToken(),
                zones == null
                    ? ImmutableList.<Zone>of()
                    : Iterables.transform(zones, DnsImpl.zoneFromPb(options)));
        result.success(zonePage);
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        result.error(new DnsException(googleJsonError, true));
      }
    };
  }

  private RpcBatch.Callback<Void> createDeleteZoneCallback(final DnsBatchResult<Boolean> result) {
    return new RpcBatch.Callback<Void>() {
      @Override
      public void onSuccess(Void response) {
        result.success(true);
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        DnsException serviceException = new DnsException(googleJsonError, false);
        if (serviceException.getCode() == HTTP_NOT_FOUND) {
          result.success(false);
        } else {
          result.error(serviceException);
        }
      }
    };
  }

  /** A joint callback for both "get zone" and "create zone" operations. */
  private RpcBatch.Callback<ManagedZone> createZoneCallback(
      final DnsOptions serviceOptions,
      final DnsBatchResult<Zone> result,
      final boolean nullForNotFound,
      final boolean idempotent) {
    return new RpcBatch.Callback<ManagedZone>() {
      @Override
      public void onSuccess(ManagedZone response) {
        result.success(
            response == null ? null : Zone.fromPb(serviceOptions.getService(), response));
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        DnsException serviceException = new DnsException(googleJsonError, idempotent);
        if (nullForNotFound && serviceException.getCode() == HTTP_NOT_FOUND) {
          result.success(null);
        } else {
          result.error(serviceException);
        }
      }
    };
  }

  private RpcBatch.Callback<Project> createProjectCallback(
      final DnsBatchResult<ProjectInfo> result) {
    return new RpcBatch.Callback<Project>() {
      @Override
      public void onSuccess(Project response) {
        result.success(response == null ? null : ProjectInfo.fromPb(response));
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        result.error(new DnsException(googleJsonError, true));
      }
    };
  }

  private RpcBatch.Callback<ResourceRecordSetsListResponse> createListRecordSetsCallback(
      final String zoneName,
      final DnsBatchResult<Page<RecordSet>> result,
      final Map<DnsRpc.Option, ?> optionMap) {
    return new RpcBatch.Callback<ResourceRecordSetsListResponse>() {
      @Override
      public void onSuccess(ResourceRecordSetsListResponse response) {
        List<ResourceRecordSet> recordSets = response.getRrsets();
        Page<RecordSet> page =
            new PageImpl<>(
                new DnsImpl.RecordSetPageFetcher(
                    zoneName, options, response.getNextPageToken(), optionMap),
                response.getNextPageToken(),
                recordSets == null
                    ? ImmutableList.<RecordSet>of()
                    : Iterables.transform(recordSets, RecordSet.FROM_PB_FUNCTION));
        result.success(page);
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        result.error(new DnsException(googleJsonError, true));
      }
    };
  }

  private RpcBatch.Callback<ChangesListResponse> createListChangeRequestsCallback(
      final String zoneName,
      final DnsBatchResult<Page<ChangeRequest>> result,
      final Map<DnsRpc.Option, ?> optionMap) {
    return new RpcBatch.Callback<ChangesListResponse>() {
      @Override
      public void onSuccess(ChangesListResponse response) {
        List<Change> changes = response.getChanges();
        Page<ChangeRequest> page =
            new PageImpl<>(
                new DnsImpl.ChangeRequestPageFetcher(
                    zoneName, options, response.getNextPageToken(), optionMap),
                response.getNextPageToken(),
                changes == null
                    ? ImmutableList.<ChangeRequest>of()
                    : Iterables.transform(
                        changes, ChangeRequest.fromPbFunction(options.getService(), zoneName)));
        result.success(page);
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        result.error(new DnsException(googleJsonError, true));
      }
    };
  }

  /** A joint callback for both "get change request" and "create change request" operations. */
  private RpcBatch.Callback<Change> createChangeRequestCallback(
      final String zoneName,
      final DnsBatchResult<ChangeRequest> result,
      final boolean nullForNotFound,
      final boolean idempotent) {
    return new RpcBatch.Callback<Change>() {
      @Override
      public void onSuccess(Change response) {
        result.success(
            response == null
                ? null
                : ChangeRequest.fromPb(options.getService(), zoneName, response));
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError) {
        DnsException serviceException = new DnsException(googleJsonError, idempotent);
        if (serviceException.getCode() == HTTP_NOT_FOUND) {
          if ("entity.parameters.changeId".equals(serviceException.getLocation())
              || (serviceException.getMessage() != null
                  && serviceException.getMessage().contains("parameters.changeId"))) {
            // the change id was not found, but the zone exists
            result.success(null);
            return;
          }
          // the zone does not exist, so throw an exception
        }
        result.error(serviceException);
      }
    };
  }
}
