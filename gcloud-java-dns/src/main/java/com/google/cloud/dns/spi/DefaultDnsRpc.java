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
package com.google.cloud.dns.spi;

import static com.google.cloud.dns.spi.DnsRpc.ListResult.of;
import static com.google.cloud.dns.spi.DnsRpc.Option.DNS_NAME;
import static com.google.cloud.dns.spi.DnsRpc.Option.DNS_TYPE;
import static com.google.cloud.dns.spi.DnsRpc.Option.FIELDS;
import static com.google.cloud.dns.spi.DnsRpc.Option.NAME;
import static com.google.cloud.dns.spi.DnsRpc.Option.PAGE_SIZE;
import static com.google.cloud.dns.spi.DnsRpc.Option.PAGE_TOKEN;
import static com.google.cloud.dns.spi.DnsRpc.Option.SORTING_ORDER;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
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

import java.io.IOException;
import java.util.Map;

/**
 * A default implementation of the DnsRpc interface.
 */
public class DefaultDnsRpc implements DnsRpc {

  private static final String SORT_BY = "changeSequence";
  private final Dns dns;
  private final DnsOptions options;

  private static DnsException translate(IOException exception) {
    return new DnsException(exception);
  }

  /**
   * Constructs an instance of this rpc client with provided {@link DnsOptions}.
   */
  public DefaultDnsRpc(DnsOptions options) {
    HttpTransport transport = options.httpTransportFactory().create();
    HttpRequestInitializer initializer = options.httpRequestInitializer();
    this.dns = new Dns.Builder(transport, new JacksonFactory(), initializer)
        .setRootUrl(options.host())
        .setApplicationName(options.applicationName())
        .build();
    this.options = options;
  }

  @Override
  public ManagedZone create(ManagedZone zone, Map<Option, ?> options) throws DnsException {
    try {
      return createZoneRequest(zone, options).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  private Dns.ManagedZones.Create createZoneRequest(ManagedZone zone, Map<Option, ?> options)
      throws IOException {
    return dns.managedZones()
        .create(this.options.projectId(), zone)
        .setFields(FIELDS.getString(options));
  }

  @Override
  public ManagedZone getZone(String zoneName, Map<Option, ?> options) throws DnsException {
    // just fields option
    try {
      return getZoneRequest(zoneName, options).execute();
    } catch (IOException ex) {
      DnsException serviceException = translate(ex);
      if (serviceException.code() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  private Dns.ManagedZones.Get getZoneRequest(String zoneName, Map<Option, ?> options)
      throws IOException {
    return dns.managedZones()
        .get(this.options.projectId(), zoneName)
        .setFields(FIELDS.getString(options));
  }

  @Override
  public ListResult<ManagedZone> listZones(Map<Option, ?> options) throws DnsException {
    // fields, page token, page size
    try {
      ManagedZonesListResponse zoneList = zoneListRequest(options).execute();
      return of(zoneList.getNextPageToken(), zoneList.getManagedZones());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  private Dns.ManagedZones.List zoneListRequest(Map<DnsRpc.Option, ?> options) throws IOException {
    return dns.managedZones().list(this.options.projectId())
        .setFields(FIELDS.getString(options))
        .setMaxResults(PAGE_SIZE.getInt(options))
        .setDnsName(DNS_NAME.getString(options))
        .setPageToken(PAGE_TOKEN.getString(options));
  }

  @Override
  public boolean deleteZone(String zoneName) throws DnsException {
    try {
      deleteZoneRequest(zoneName).execute();
      return true;
    } catch (IOException ex) {
      DnsException serviceException = translate(ex);
      if (serviceException.code() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  private Dns.ManagedZones.Delete deleteZoneRequest(String zoneName) throws IOException {
    return dns.managedZones().delete(this.options.projectId(), zoneName);
  }

  @Override
  public ListResult<ResourceRecordSet> listRecordSets(String zoneName, Map<Option, ?> options)
      throws DnsException {

    try {
      ResourceRecordSetsListResponse response = listDnsRecordsRequest(zoneName, options).execute();
      return of(response.getNextPageToken(), response.getRrsets());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  private Dns.ResourceRecordSets.List listDnsRecordsRequest(String zoneName, Map<Option, ?> options)
      throws IOException {
    // options are fields, page token, dns name, type
    return dns.resourceRecordSets()
        .list(this.options.projectId(), zoneName)
        .setFields(FIELDS.getString(options))
        .setPageToken(PAGE_TOKEN.getString(options))
        .setMaxResults(PAGE_SIZE.getInt(options))
        .setName(NAME.getString(options))
        .setType(DNS_TYPE.getString(options));
  }

  @Override
  public Project getProject(Map<Option, ?> options) throws DnsException {
    try {
      return getProjectRequest(options).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  private Dns.Projects.Get getProjectRequest(Map<Option, ?> options) throws IOException {
    return dns.projects().get(this.options.projectId()).setFields(FIELDS.getString(options));
  }

  @Override
  public Change applyChangeRequest(String zoneName, Change changeRequest, Map<Option, ?> options)
      throws DnsException {
    try {
      return applyChangeRequestRequest(zoneName, changeRequest, options).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  private Dns.Changes.Create applyChangeRequestRequest(String zoneName, Change changeRequest,
      Map<Option, ?> options) throws IOException {
    return dns.changes()
        .create(this.options.projectId(), zoneName, changeRequest)
        .setFields(FIELDS.getString(options));
  }

  @Override
  public Change getChangeRequest(String zoneName, String changeRequestId, Map<Option, ?> options)
      throws DnsException {
    try {
      return getChangeRequestRequest(zoneName, changeRequestId, options).execute();
    } catch (IOException ex) {
      DnsException serviceException = translate(ex);
      if (serviceException.code() == HTTP_NOT_FOUND) {
        if ("entity.parameters.changeId".equals(serviceException.location())
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

  // todo(mderka) rename
  private Dns.Changes.Get getChangeRequestRequest(String zoneName, String changeRequestId,
      Map<Option, ?> options) throws IOException {
    return dns.changes()
        .get(this.options.projectId(), zoneName, changeRequestId)
        .setFields(FIELDS.getString(options));
  }

  @Override
  public ListResult<Change> listChangeRequests(String zoneName, Map<Option, ?> options)
      throws DnsException {
    try {
      ChangesListResponse response = listChangeRequestsRequest(zoneName, options).execute();
      return of(response.getNextPageToken(), response.getChanges());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  // todo(mderka) rename
  private Dns.Changes.List listChangeRequestsRequest(String zoneName, Map<Option, ?> options)
      throws IOException {
    // options are fields, page token, page size, sort order
    Dns.Changes.List request = dns.changes().list(this.options.projectId(), zoneName)
        .setFields(FIELDS.getString(options))
        .setMaxResults(PAGE_SIZE.getInt(options))
        .setPageToken(PAGE_TOKEN.getString(options));
    if (SORTING_ORDER.getString(options) != null) {
      // todo check and change if more sorting options are implemented, issue #604
      request = request.setSortBy(SORT_BY).setSortOrder(SORTING_ORDER.getString(options));
    }
    return request;
  }

  @Override
  public BatchRequest createBatch() {
    return dns.batch();
  }

  @Override
  public BatchRequest addToBatchListZones(Object batch,
      DnsRpc.Callback<ManagedZonesListResponse> callback, Map<DnsRpc.Option, ?> options) {
    BatchRequest casted = (BatchRequest) batch;
    try {
      zoneListRequest(options).queue(casted, jsonCallback(callback));
      return casted;
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public BatchRequest addToBatchCreateZone(ManagedZone zone, Object batch,
      DnsRpc.Callback<ManagedZone> callback, Map<Option, ?> options) {
    BatchRequest casted = (BatchRequest) batch;
    try {
      createZoneRequest(zone, options).queue(casted, jsonCallback(callback));
      return casted;
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public BatchRequest addToBatchGetZone(String zoneName, Object batch,
      DnsRpc.Callback<ManagedZone> callback, Map<Option, ?> options) {
    BatchRequest casted = (BatchRequest) batch;
    try {
      getZoneRequest(zoneName, options).queue(casted, jsonCallback(callback));
      return casted;
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public BatchRequest addToBatchDeleteZone(String zoneName, Object batch,
      DnsRpc.Callback<Void> callback) {
    BatchRequest casted = (BatchRequest) batch;
    try {
      deleteZoneRequest(zoneName).queue(casted, jsonCallback(callback));
      return casted;
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public BatchRequest addToBatchGetProject(Object batch, DnsRpc.Callback<Project> callback,
      Map<Option, ?> options) {
    BatchRequest casted = (BatchRequest) batch;
    try {
      getProjectRequest(options).queue(casted, jsonCallback(callback));
      return casted;
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  private static <T> JsonBatchCallback<T> jsonCallback(final DnsRpc.Callback<T> callback) {
    JsonBatchCallback<T> jsonCallback = new JsonBatchCallback<T>() {
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
    return jsonCallback;
  }

  @Override
  public void submitBatch(Object batchRequest) {
    try {
      ((BatchRequest) batchRequest).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }
}
