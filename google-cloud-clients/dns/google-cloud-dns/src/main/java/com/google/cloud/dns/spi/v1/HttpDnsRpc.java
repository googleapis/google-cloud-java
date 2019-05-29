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

package com.google.cloud.dns.spi.v1;

import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.dns.Dns;
import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ChangesListResponse;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.ManagedZonesListResponse;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.api.services.dns.model.ResourceRecordSetsListResponse;
import com.google.cloud.dns.DnsException;
import com.google.cloud.dns.DnsOptions;
import com.google.cloud.http.HttpTransportOptions;
import java.io.IOException;
import java.util.Map;

/** A default implementation of the DnsRpc interface. */
public class HttpDnsRpc implements DnsRpc {

  private static final String SORT_BY = "changeSequence";
  private final Dns dns;
  private final DnsOptions options;

  private class DefaultRpcBatch implements RpcBatch {

    private final BatchRequest batch;

    private DefaultRpcBatch(BatchRequest batch) {
      this.batch = batch;
    }

    @Override
    public void addListZones(
        RpcBatch.Callback<ManagedZonesListResponse> callback, Map<DnsRpc.Option, ?> options) {
      try {
        listZonesCall(options).queue(batch, toJsonCallback(callback));
      } catch (IOException ex) {
        throw translate(ex, false);
      }
    }

    @Override
    public void addCreateZone(
        ManagedZone zone, RpcBatch.Callback<ManagedZone> callback, Map<Option, ?> options) {
      try {
        createZoneCall(zone, options).queue(batch, toJsonCallback(callback));
      } catch (IOException ex) {
        throw translate(ex, false);
      }
    }

    @Override
    public void addGetZone(
        String zoneName, RpcBatch.Callback<ManagedZone> callback, Map<Option, ?> options) {
      try {
        getZoneCall(zoneName, options).queue(batch, toJsonCallback(callback));
      } catch (IOException ex) {
        throw translate(ex, false);
      }
    }

    @Override
    public void addDeleteZone(String zoneName, RpcBatch.Callback<Void> callback) {
      try {
        deleteZoneCall(zoneName).queue(batch, toJsonCallback(callback));
      } catch (IOException ex) {
        throw translate(ex, false);
      }
    }

    @Override
    public void addGetProject(RpcBatch.Callback<Project> callback, Map<Option, ?> options) {
      try {
        getProjectCall(options).queue(batch, toJsonCallback(callback));
      } catch (IOException ex) {
        throw translate(ex, false);
      }
    }

    @Override
    public void addListRecordSets(
        String zoneName,
        RpcBatch.Callback<ResourceRecordSetsListResponse> callback,
        Map<DnsRpc.Option, ?> options) {
      try {
        listRecordSetsCall(zoneName, options).queue(batch, toJsonCallback(callback));
      } catch (IOException ex) {
        throw translate(ex, false);
      }
    }

    @Override
    public void addListChangeRequests(
        String zoneName,
        RpcBatch.Callback<ChangesListResponse> callback,
        Map<DnsRpc.Option, ?> options) {
      try {
        listChangeRequestsCall(zoneName, options).queue(batch, toJsonCallback(callback));
      } catch (IOException ex) {
        throw translate(ex, false);
      }
    }

    @Override
    public void addGetChangeRequest(
        String zoneName,
        String changeRequestId,
        RpcBatch.Callback<Change> callback,
        Map<DnsRpc.Option, ?> options) {
      try {
        getChangeRequestCall(zoneName, changeRequestId, options)
            .queue(batch, toJsonCallback(callback));
      } catch (IOException ex) {
        throw translate(ex, false);
      }
    }

    @Override
    public void addApplyChangeRequest(
        String zoneName,
        Change change,
        RpcBatch.Callback<Change> callback,
        Map<DnsRpc.Option, ?> options) {
      try {
        applyChangeRequestCall(zoneName, change, options).queue(batch, toJsonCallback(callback));
      } catch (IOException ex) {
        throw translate(ex, false);
      }
    }

    @Override
    public void submit() {
      try {
        batch.execute();
      } catch (IOException ex) {
        throw translate(ex, false);
      }
    }
  }

  private static <T> JsonBatchCallback<T> toJsonCallback(final RpcBatch.Callback<T> callback) {
    return new JsonBatchCallback<T>() {
      @Override
      public void onSuccess(T response, HttpHeaders httpHeaders) throws IOException {
        callback.onSuccess(response);
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError, HttpHeaders httpHeaders)
          throws IOException {
        callback.onFailure(googleJsonError);
      }
    };
  }

  private static DnsException translate(IOException exception, boolean idempotent) {
    return new DnsException(exception, idempotent);
  }

  /** Constructs an instance of this rpc client with provided {@link DnsOptions}. */
  public HttpDnsRpc(DnsOptions options) {
    HttpTransportOptions transportOptions = (HttpTransportOptions) options.getTransportOptions();
    HttpTransport transport = transportOptions.getHttpTransportFactory().create();
    HttpRequestInitializer initializer = transportOptions.getHttpRequestInitializer(options);
    this.dns =
        new Dns.Builder(transport, new JacksonFactory(), initializer)
            .setRootUrl(options.getHost())
            .setApplicationName(options.getApplicationName())
            .build();
    this.options = options;
  }

  @Override
  public ManagedZone create(ManagedZone zone, Map<Option, ?> options) throws DnsException {
    try {
      return createZoneCall(zone, options).execute();
    } catch (IOException ex) {
      // todo this can cause misleading report of a failure, intended to be fixed within #924
      throw translate(ex, true);
    }
  }

  private Dns.ManagedZones.Create createZoneCall(ManagedZone zone, Map<Option, ?> options)
      throws IOException {
    return dns.managedZones()
        .create(this.options.getProjectId(), zone)
        .setFields(Option.FIELDS.getString(options));
  }

  @Override
  public ManagedZone getZone(String zoneName, Map<Option, ?> options) throws DnsException {
    // just fields option
    try {
      return getZoneCall(zoneName, options).execute();
    } catch (IOException ex) {
      DnsException serviceException = translate(ex, true);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  private Dns.ManagedZones.Get getZoneCall(String zoneName, Map<Option, ?> options)
      throws IOException {
    return dns.managedZones()
        .get(this.options.getProjectId(), zoneName)
        .setFields(Option.FIELDS.getString(options));
  }

  @Override
  public ListResult<ManagedZone> listZones(Map<Option, ?> options) throws DnsException {
    // fields, page token, page size
    try {
      ManagedZonesListResponse zoneList = listZonesCall(options).execute();
      return ListResult.of(zoneList.getNextPageToken(), zoneList.getManagedZones());
    } catch (IOException ex) {
      throw translate(ex, true);
    }
  }

  private Dns.ManagedZones.List listZonesCall(Map<DnsRpc.Option, ?> options) throws IOException {
    return dns.managedZones()
        .list(this.options.getProjectId())
        .setFields(Option.FIELDS.getString(options))
        .setMaxResults(Option.PAGE_SIZE.getInt(options))
        .setDnsName(Option.DNS_NAME.getString(options))
        .setPageToken(Option.PAGE_TOKEN.getString(options));
  }

  @Override
  public boolean deleteZone(String zoneName) throws DnsException {
    try {
      deleteZoneCall(zoneName).execute();
      return true;
    } catch (IOException ex) {
      DnsException serviceException = translate(ex, false);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  private Dns.ManagedZones.Delete deleteZoneCall(String zoneName) throws IOException {
    return dns.managedZones().delete(this.options.getProjectId(), zoneName);
  }

  @Override
  public ListResult<ResourceRecordSet> listRecordSets(String zoneName, Map<Option, ?> options)
      throws DnsException {
    try {
      ResourceRecordSetsListResponse response = listRecordSetsCall(zoneName, options).execute();
      return ListResult.of(response.getNextPageToken(), response.getRrsets());
    } catch (IOException ex) {
      throw translate(ex, true);
    }
  }

  private Dns.ResourceRecordSets.List listRecordSetsCall(String zoneName, Map<Option, ?> options)
      throws IOException {
    // options are fields, page token, dns name, type
    return dns.resourceRecordSets()
        .list(this.options.getProjectId(), zoneName)
        .setFields(Option.FIELDS.getString(options))
        .setPageToken(Option.PAGE_TOKEN.getString(options))
        .setMaxResults(Option.PAGE_SIZE.getInt(options))
        .setName(Option.NAME.getString(options))
        .setType(Option.DNS_TYPE.getString(options));
  }

  @Override
  public Project getProject(Map<Option, ?> options) throws DnsException {
    try {
      return getProjectCall(options).execute();
    } catch (IOException ex) {
      throw translate(ex, true);
    }
  }

  private Dns.Projects.Get getProjectCall(Map<Option, ?> options) throws IOException {
    return dns.projects()
        .get(this.options.getProjectId())
        .setFields(Option.FIELDS.getString(options));
  }

  @Override
  public Change applyChangeRequest(String zoneName, Change changeRequest, Map<Option, ?> options)
      throws DnsException {
    try {
      return applyChangeRequestCall(zoneName, changeRequest, options).execute();
    } catch (IOException ex) {
      throw translate(ex, false);
    }
  }

  private Dns.Changes.Create applyChangeRequestCall(
      String zoneName, Change changeRequest, Map<Option, ?> options) throws IOException {
    return dns.changes()
        .create(this.options.getProjectId(), zoneName, changeRequest)
        .setFields(Option.FIELDS.getString(options));
  }

  @Override
  public Change getChangeRequest(String zoneName, String changeRequestId, Map<Option, ?> options)
      throws DnsException {
    try {
      return getChangeRequestCall(zoneName, changeRequestId, options).execute();
    } catch (IOException ex) {
      DnsException serviceException = translate(ex, true);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        if ("entity.parameters.changeId".equals(serviceException.getLocation())
            || (serviceException.getMessage() != null
                && serviceException.getMessage().contains("parameters.changeId"))) {
          // the change id was not found, but the zone exists
          return null;
        }
        // the zone does not exist, so throw an exception
      }
      throw serviceException;
    }
  }

  private Dns.Changes.Get getChangeRequestCall(
      String zoneName, String changeRequestId, Map<Option, ?> options) throws IOException {
    return dns.changes()
        .get(this.options.getProjectId(), zoneName, changeRequestId)
        .setFields(Option.FIELDS.getString(options));
  }

  @Override
  public ListResult<Change> listChangeRequests(String zoneName, Map<Option, ?> options)
      throws DnsException {
    try {
      ChangesListResponse response = listChangeRequestsCall(zoneName, options).execute();
      return ListResult.of(response.getNextPageToken(), response.getChanges());
    } catch (IOException ex) {
      throw translate(ex, true);
    }
  }

  private Dns.Changes.List listChangeRequestsCall(String zoneName, Map<Option, ?> options)
      throws IOException {
    // options are fields, page token, page size, sort order
    Dns.Changes.List request =
        dns.changes()
            .list(this.options.getProjectId(), zoneName)
            .setFields(Option.FIELDS.getString(options))
            .setMaxResults(Option.PAGE_SIZE.getInt(options))
            .setPageToken(Option.PAGE_TOKEN.getString(options));
    if (Option.SORTING_ORDER.getString(options) != null) {
      // todo check and change if more sorting options are implemented, issue #604
      request = request.setSortBy(SORT_BY).setSortOrder(Option.SORTING_ORDER.getString(options));
    }
    return request;
  }

  @Override
  public RpcBatch createBatch() {
    return new DefaultRpcBatch(dns.batch());
  }
}
