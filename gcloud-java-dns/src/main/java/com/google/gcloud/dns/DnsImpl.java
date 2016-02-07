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
import static com.google.gcloud.RetryHelper.RetryHelperException;
import static com.google.gcloud.RetryHelper.runWithRetries;
import static com.google.gcloud.dns.ChangeRequest.fromPb;

import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.gcloud.BaseService;
import com.google.gcloud.Page;
import com.google.gcloud.PageImpl;
import com.google.gcloud.RetryHelper;
import com.google.gcloud.spi.DnsRpc;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * A default implementation of Dns.
 */
final class DnsImpl extends BaseService<DnsOptions> implements Dns {

  private final DnsRpc dnsRpc;

  private static class ZonePageFetcher implements PageImpl.NextPageFetcher<Zone> {

    private static final long serialVersionUID = 2158209410430566961L;
    private final Map<DnsRpc.Option, ?> requestOptions;
    private final DnsOptions serviceOptions;

    ZonePageFetcher(DnsOptions serviceOptions, String cursor,
        Map<DnsRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(DnsRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Zone> nextPage() {
      return listZones(serviceOptions, requestOptions);
    }
  }

  private static class ChangeRequestPageFetcher implements PageImpl.NextPageFetcher<ChangeRequest> {

    private static final Function<Change, ChangeRequest> PB_TO_CHANGE_REQUEST =
        new Function<Change, ChangeRequest>() {
          @Override
          public ChangeRequest apply(com.google.api.services.dns.model.Change changePb) {
            return fromPb(changePb);
          }
        };
    private static final long serialVersionUID = -8737501076674042014L;
    private final String zoneName;
    private final Map<DnsRpc.Option, ?> requestOptions;
    private final DnsOptions serviceOptions;

    ChangeRequestPageFetcher(String zoneName, DnsOptions serviceOptions, String cursor,
        Map<DnsRpc.Option, ?> optionMap) {
      this.zoneName = zoneName;
      this.requestOptions =
          PageImpl.nextRequestOptions(DnsRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<ChangeRequest> nextPage() {
      return listChangeRequests(zoneName, serviceOptions, requestOptions, PB_TO_CHANGE_REQUEST);
    }
  }

  private static class DnsRecordPageFetcher implements PageImpl.NextPageFetcher<DnsRecord> {

    private static final Function<ResourceRecordSet, DnsRecord> PB_TO_DNS_RECORD =
        new Function<ResourceRecordSet, DnsRecord>() {
          @Override
          public DnsRecord apply(com.google.api.services.dns.model.ResourceRecordSet pb) {
            return DnsRecord.fromPb(pb);
          }
        };
    private static final long serialVersionUID = 670996349097667660L;
    private final Map<DnsRpc.Option, ?> requestOptions;
    private final DnsOptions serviceOptions;
    private final String zoneName;

    DnsRecordPageFetcher(String zoneName, DnsOptions serviceOptions, String cursor,
        Map<DnsRpc.Option, ?> optionMap) {
      this.zoneName = zoneName;
      this.requestOptions =
          PageImpl.nextRequestOptions(DnsRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<DnsRecord> nextPage() {
      return listDnsRecords(zoneName, serviceOptions, requestOptions, PB_TO_DNS_RECORD);
    }
  }

  private static Page<Zone> listZones(final DnsOptions serviceOptions,
      final Map<DnsRpc.Option, ?> optionsMap) {
    // define transformation function
    // this differs from the other list operations since zone is functional and requires dns service
    Function<ManagedZone, Zone> pbToZoneFunction = new Function<ManagedZone, Zone>() {
      @Override
      public Zone apply(
          com.google.api.services.dns.model.ManagedZone zonePb) {
        return new Zone(serviceOptions.service(), ZoneInfo.fromPb(zonePb));
      }
    };
    try {
      // get a list of managed zones
      DnsRpc.ListResult<ManagedZone> result =
          runWithRetries(new Callable<DnsRpc.ListResult<ManagedZone>>() {
            @Override
            public DnsRpc.ListResult<ManagedZone> call() {
              return serviceOptions.rpc().listZones(optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER);
      String cursor = result.pageToken();
      // transform that list into zone objects
      Iterable<Zone> zones = result.results() == null
          ? ImmutableList.<Zone>of() : Iterables.transform(result.results(), pbToZoneFunction);
      return new PageImpl<>(new ZonePageFetcher(serviceOptions, cursor, optionsMap),
          cursor, zones);
    } catch (RetryHelperException e) {
      throw DnsException.translateAndThrow(e);
    }
  }

  private static Page<ChangeRequest> listChangeRequests(final String zoneName,
      final DnsOptions serviceOptions, final Map<DnsRpc.Option, ?> optionsMap,
      Function<Change, ChangeRequest> TRANSFORM_FUNCTION) {
    try {
      // get a list of changes
      DnsRpc.ListResult<Change> result = runWithRetries(new Callable<DnsRpc.ListResult<Change>>() {
        @Override
        public DnsRpc.ListResult<Change> call() {
          return serviceOptions.rpc().listChangeRequests(zoneName, optionsMap);
        }
      }, serviceOptions.retryParams(), EXCEPTION_HANDLER);
      String cursor = result.pageToken();
      // transform that list into change request objects
      Iterable<ChangeRequest> changes = result.results() == null
          ? ImmutableList.<ChangeRequest>of()
          : Iterables.transform(result.results(), TRANSFORM_FUNCTION);
      return new PageImpl<>(new ChangeRequestPageFetcher(zoneName, serviceOptions, cursor,
          optionsMap), cursor, changes);
    } catch (RetryHelperException e) {
      throw DnsException.translateAndThrow(e);
    }
  }

  private static Page<DnsRecord> listDnsRecords(final String zoneName,
      final DnsOptions serviceOptions, final Map<DnsRpc.Option, ?> optionsMap,
      Function<ResourceRecordSet, DnsRecord> TRANSFORM_FUNCTION) {
    try {
      // get a list of resource record sets
      DnsRpc.ListResult<ResourceRecordSet> result = runWithRetries(
          new Callable<DnsRpc.ListResult<ResourceRecordSet>>() {
            @Override
            public DnsRpc.ListResult<ResourceRecordSet> call() {
              return serviceOptions.rpc().listDnsRecords(zoneName, optionsMap);
            }
          }, serviceOptions.retryParams(), EXCEPTION_HANDLER);
      String cursor = result.pageToken();
      // transform that list into dns records
      Iterable<DnsRecord> records = result.results() == null
          ? ImmutableList.<DnsRecord>of()
          : Iterables.transform(result.results(), TRANSFORM_FUNCTION);
      return new PageImpl<>(new DnsRecordPageFetcher(zoneName, serviceOptions, cursor, optionsMap),
          cursor, records);
    } catch (RetryHelperException e) {
      throw DnsException.translateAndThrow(e);
    }
  }

  DnsImpl(DnsOptions options) {
    super(options);
    dnsRpc = options.rpc();
  }

  @Override
  public Page<Zone> listZones(ZoneListOption... options) {
    return listZones(options(), optionMap(options));
  }

  @Override
  public Page<ChangeRequest> listChangeRequests(String zoneName,
      ChangeRequestListOption... options) {
    return listChangeRequests(zoneName, options(), optionMap(options),
        ChangeRequestPageFetcher.PB_TO_CHANGE_REQUEST);
  }

  @Override
  public Page<DnsRecord> listDnsRecords(String zoneName, DnsRecordListOption... options) {
    return listDnsRecords(zoneName, options(), optionMap(options),
        DnsRecordPageFetcher.PB_TO_DNS_RECORD);
  }

  @Override
  public Zone create(final ZoneInfo zoneInfo, Dns.ZoneOption... options) {
    final Map<DnsRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.dns.model.ManagedZone answer = runWithRetries(
          new Callable<com.google.api.services.dns.model.ManagedZone>() {
            @Override
            public com.google.api.services.dns.model.ManagedZone call() {
              return dnsRpc.create(zoneInfo.toPb(), optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER);
      return answer == null ? null : Zone.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException ex) {
      throw DnsException.translateAndThrow(ex);
    }
  }

  @Override
  public Zone getZone(final String zoneName, Dns.ZoneOption... options) {
    final Map<DnsRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.dns.model.ManagedZone answer = runWithRetries(
          new Callable<com.google.api.services.dns.model.ManagedZone>() {
            @Override
            public com.google.api.services.dns.model.ManagedZone call() {
              return dnsRpc.getZone(zoneName, optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER);
      return answer == null ? null : Zone.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException ex) {
      throw DnsException.translateAndThrow(ex);
    }
  }

  @Override
  public boolean delete(final String zoneName) {
    try {
      return runWithRetries(new Callable<Boolean>() {
        @Override
        public Boolean call() {
          return dnsRpc.deleteZone(zoneName);
        }
      }, options().retryParams(), EXCEPTION_HANDLER);
    } catch (RetryHelper.RetryHelperException ex) {
      throw DnsException.translateAndThrow(ex);
    }
  }

  @Override
  public ProjectInfo getProject(Dns.ProjectOption... fields) {
    final Map<DnsRpc.Option, ?> optionsMap = optionMap(fields);
    try {
      com.google.api.services.dns.model.Project answer = runWithRetries(
          new Callable<com.google.api.services.dns.model.Project>() {
            @Override
            public com.google.api.services.dns.model.Project call() {
              return dnsRpc.getProject(optionsMap);
            }
          }, options().retryParams(), EXCEPTION_HANDLER);
      return answer == null ? null : ProjectInfo.fromPb(answer); // should never be null
    } catch (RetryHelper.RetryHelperException ex) {
      throw DnsException.translateAndThrow(ex);
    }
  }

  @Override
  public ChangeRequest applyChangeRequest(final String zoneName, final ChangeRequest changeRequest,
      Dns.ChangeRequestOption... options) {
    final Map<DnsRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.dns.model.Change answer =
          runWithRetries(
              new Callable<com.google.api.services.dns.model.Change>() {
                @Override
                public com.google.api.services.dns.model.Change call() {
                  return dnsRpc.applyChangeRequest(zoneName, changeRequest.toPb(), optionsMap);
                }
              }, options().retryParams(), EXCEPTION_HANDLER);
      return answer == null ? null : fromPb(answer); // should never be null
    } catch (RetryHelper.RetryHelperException ex) {
      throw DnsException.translateAndThrow(ex);
    }
  }

  @Override
  public ChangeRequest getChangeRequest(final String zoneName, final String changeRequestId,
      Dns.ChangeRequestOption... options) {
    final Map<DnsRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.dns.model.Change answer =
          runWithRetries(
              new Callable<com.google.api.services.dns.model.Change>() {
                @Override
                public com.google.api.services.dns.model.Change call() {
                  return dnsRpc.getChangeRequest(zoneName, changeRequestId, optionsMap);
                }
              }, options().retryParams(), EXCEPTION_HANDLER);
      return answer == null ? null : fromPb(answer); // should never be null
    } catch (RetryHelper.RetryHelperException ex) {
      throw DnsException.translateAndThrow(ex);
    }
  }

  private Map<DnsRpc.Option, ?> optionMap(AbstractOption... options) {
    Map<DnsRpc.Option, Object> temp = Maps.newEnumMap(DnsRpc.Option.class);
    for (AbstractOption option : options) {
      Object prev = temp.put(option.rpcOption(), option.value());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return ImmutableMap.copyOf(temp);
  }
}
