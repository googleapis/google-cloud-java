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

package com.google.gcloud.dns.spi;

import static com.google.gcloud.dns.spi.DnsRpc.ListResult.of;
import static com.google.gcloud.dns.spi.DnsRpc.Option.DNS_NAME;
import static com.google.gcloud.dns.spi.DnsRpc.Option.DNS_TYPE;
import static com.google.gcloud.dns.spi.DnsRpc.Option.FIELDS;
import static com.google.gcloud.dns.spi.DnsRpc.Option.NAME;
import static com.google.gcloud.dns.spi.DnsRpc.Option.PAGE_SIZE;
import static com.google.gcloud.dns.spi.DnsRpc.Option.PAGE_TOKEN;
import static com.google.gcloud.dns.spi.DnsRpc.Option.SORTING_ORDER;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
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
import com.google.gcloud.dns.DnsException;
import com.google.gcloud.dns.DnsOptions;

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
      return dns.managedZones()
          .create(this.options.projectId(), zone)
          .setFields(FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public ManagedZone getZone(String zoneName, Map<Option, ?> options) throws DnsException {
    // just fields option
    try {
      return dns.managedZones().get(this.options.projectId(), zoneName)
          .setFields(FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      DnsException serviceException = translate(ex);
      if (serviceException.code() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
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

  @Override
  public boolean deleteZone(String zoneName) throws DnsException {
    try {
      dns.managedZones().delete(this.options.projectId(), zoneName).execute();
      return true;
    } catch (IOException ex) {
      DnsException serviceException = translate(ex);
      if (serviceException.code() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @Override
  public ListResult<ResourceRecordSet> listDnsRecords(String zoneName, Map<Option, ?> options)
      throws DnsException {
    // options are fields, page token, dns name, type
    try {
      ResourceRecordSetsListResponse response = dns.resourceRecordSets()
          .list(this.options.projectId(), zoneName)
          .setFields(FIELDS.getString(options))
          .setPageToken(PAGE_TOKEN.getString(options))
          .setMaxResults(PAGE_SIZE.getInt(options))
          .setName(NAME.getString(options))
          .setType(DNS_TYPE.getString(options))
          .execute();
      return of(response.getNextPageToken(), response.getRrsets());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Project getProject(Map<Option, ?> options) throws DnsException {
    try {
      return dns.projects().get(this.options.projectId())
          .setFields(FIELDS.getString(options)).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Change applyChangeRequest(String zoneName, Change changeRequest, Map<Option, ?> options)
      throws DnsException {
    try {
      return dns.changes().create(this.options.projectId(), zoneName, changeRequest)
          .setFields(FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Change getChangeRequest(String zoneName, String changeRequestId, Map<Option, ?> options)
      throws DnsException {
    try {
      return dns.changes().get(this.options.projectId(), zoneName, changeRequestId)
          .setFields(FIELDS.getString(options))
          .execute();
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

  @Override
  public ListResult<Change> listChangeRequests(String zoneName, Map<Option, ?> options)
      throws DnsException {
    // options are fields, page token, page size, sort order
    try {
      Dns.Changes.List request = dns.changes().list(this.options.projectId(), zoneName)
          .setFields(FIELDS.getString(options))
          .setMaxResults(PAGE_SIZE.getInt(options))
          .setPageToken(PAGE_TOKEN.getString(options));
      if (SORTING_ORDER.getString(options) != null) {
        // todo check and change if more sorting options are implemented, issue #604
        request = request.setSortBy(SORT_BY).setSortOrder(SORTING_ORDER.getString(options));
      }
      ChangesListResponse response = request.execute();
      return of(response.getNextPageToken(), response.getChanges());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public BatchRequest createBatch() {
    return dns.batch();
  }

  @Override
  public BatchRequest prepareListZones(BatchRequest batch, JsonBatchCallback callback,
      Map<DnsRpc.Option, ?> options) {
    try {
      zoneListRequest(options).queue(batch, callback);
      return batch;
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public BatchRequest prepareCreateZone(ManagedZone zone, BatchRequest batch,
      JsonBatchCallback callback, Map<Option, ?> options) {
    // todo(mderka) implement
    throw new UnsupportedOperationException("not implemented yet");
  }

  @Override
  public BatchRequest prepareGetZone(String zoneName, BatchRequest batch,
      JsonBatchCallback callback, Map<Option, ?> options) {
    // todo(mderka) implement
    throw new UnsupportedOperationException("not implemented yet");
  }

  @Override
  public BatchRequest prepareDeleteZone(String zoneName, BatchRequest batch,
      JsonBatchCallback callback) {
    // todo(mderka) implement
    throw new UnsupportedOperationException("not implemented yet");
  }

  @Override
  public void submitBatch(BatchRequest batchRequest) {
    try {
      batchRequest.execute();
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
}
