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

import static com.google.cloud.RetryHelper.runWithRetries;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.gax.paging.Page;
import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.cloud.BaseService;
import com.google.cloud.PageImpl;
import com.google.cloud.RetryHelper;
import com.google.cloud.dns.spi.v1.DnsRpc;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.concurrent.Callable;

/** A default implementation of Dns. */
final class DnsImpl extends BaseService<DnsOptions> implements Dns {

  private final DnsRpc dnsRpc;

  static class ZonePageFetcher implements PageImpl.NextPageFetcher<Zone> {

    private static final long serialVersionUID = 2158209410430566961L;
    private final Map<DnsRpc.Option, ?> requestOptions;
    private final DnsOptions serviceOptions;

    ZonePageFetcher(DnsOptions serviceOptions, String cursor, Map<DnsRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(DnsRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Zone> getNextPage() {
      return listZones(serviceOptions, requestOptions);
    }
  }

  static class ChangeRequestPageFetcher implements PageImpl.NextPageFetcher<ChangeRequest> {

    private static final long serialVersionUID = 4473265130673029139L;
    private final String zoneName;
    private final Map<DnsRpc.Option, ?> requestOptions;
    private final DnsOptions serviceOptions;

    ChangeRequestPageFetcher(
        String zoneName,
        DnsOptions serviceOptions,
        String cursor,
        Map<DnsRpc.Option, ?> optionMap) {
      this.zoneName = zoneName;
      this.requestOptions =
          PageImpl.nextRequestOptions(DnsRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<ChangeRequest> getNextPage() {
      return listChangeRequests(zoneName, serviceOptions, requestOptions);
    }
  }

  static class RecordSetPageFetcher implements PageImpl.NextPageFetcher<RecordSet> {

    private static final long serialVersionUID = -6039369212511530846L;
    private final Map<DnsRpc.Option, ?> requestOptions;
    private final DnsOptions serviceOptions;
    private final String zoneName;

    RecordSetPageFetcher(
        String zoneName,
        DnsOptions serviceOptions,
        String cursor,
        Map<DnsRpc.Option, ?> optionMap) {
      this.zoneName = zoneName;
      this.requestOptions =
          PageImpl.nextRequestOptions(DnsRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<RecordSet> getNextPage() {
      return listRecordSets(zoneName, serviceOptions, requestOptions);
    }
  }

  DnsImpl(DnsOptions options) {
    super(options);
    dnsRpc = options.getDnsRpcV1();
  }

  static Function<ManagedZone, Zone> zoneFromPb(final DnsOptions options) {
    return new Function<ManagedZone, Zone>() {
      @Override
      public Zone apply(ManagedZone zonePb) {
        return Zone.fromPb(options.getService(), zonePb);
      }
    };
  }

  @Override
  public Page<Zone> listZones(ZoneListOption... options) {
    return listZones(getOptions(), optionMap(options));
  }

  private static Page<Zone> listZones(
      final DnsOptions serviceOptions, final Map<DnsRpc.Option, ?> optionsMap) {
    try {
      // get a list of managed zones
      final DnsRpc rpc = serviceOptions.getDnsRpcV1();
      DnsRpc.ListResult<ManagedZone> result =
          runWithRetries(
              new Callable<DnsRpc.ListResult<ManagedZone>>() {
                @Override
                public DnsRpc.ListResult<ManagedZone> call() {
                  return rpc.listZones(optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              EXCEPTION_HANDLER,
              serviceOptions.getClock());
      String cursor = result.pageToken();
      // transform that list into zone objects
      Iterable<Zone> zones =
          result.results() == null
              ? ImmutableList.<Zone>of()
              : Iterables.transform(result.results(), zoneFromPb(serviceOptions));
      return new PageImpl<>(new ZonePageFetcher(serviceOptions, cursor, optionsMap), cursor, zones);
    } catch (RetryHelper.RetryHelperException e) {
      throw DnsException.translateAndThrow(e);
    }
  }

  @Override
  public Page<ChangeRequest> listChangeRequests(
      String zoneName, ChangeRequestListOption... options) {
    return listChangeRequests(zoneName, getOptions(), optionMap(options));
  }

  private static Page<ChangeRequest> listChangeRequests(
      final String zoneName,
      final DnsOptions serviceOptions,
      final Map<DnsRpc.Option, ?> optionsMap) {
    try {
      // get a list of changes
      final DnsRpc rpc = serviceOptions.getDnsRpcV1();
      DnsRpc.ListResult<Change> result =
          runWithRetries(
              new Callable<DnsRpc.ListResult<Change>>() {
                @Override
                public DnsRpc.ListResult<Change> call() {
                  return rpc.listChangeRequests(zoneName, optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              EXCEPTION_HANDLER,
              serviceOptions.getClock());
      String cursor = result.pageToken();
      // transform that list into change request objects
      Iterable<ChangeRequest> changes =
          result.results() == null
              ? ImmutableList.<ChangeRequest>of()
              : Iterables.transform(
                  result.results(),
                  ChangeRequest.fromPbFunction(serviceOptions.getService(), zoneName));
      return new PageImpl<>(
          new ChangeRequestPageFetcher(zoneName, serviceOptions, cursor, optionsMap),
          cursor,
          changes);
    } catch (RetryHelper.RetryHelperException e) {
      throw DnsException.translateAndThrow(e);
    }
  }

  @Override
  public Page<RecordSet> listRecordSets(String zoneName, RecordSetListOption... options) {
    return listRecordSets(zoneName, getOptions(), optionMap(options));
  }

  private static Page<RecordSet> listRecordSets(
      final String zoneName,
      final DnsOptions serviceOptions,
      final Map<DnsRpc.Option, ?> optionsMap) {
    try {
      // get a list of record sets
      final DnsRpc rpc = serviceOptions.getDnsRpcV1();
      DnsRpc.ListResult<ResourceRecordSet> result =
          runWithRetries(
              new Callable<DnsRpc.ListResult<ResourceRecordSet>>() {
                @Override
                public DnsRpc.ListResult<ResourceRecordSet> call() {
                  return rpc.listRecordSets(zoneName, optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              EXCEPTION_HANDLER,
              serviceOptions.getClock());
      String cursor = result.pageToken();
      // transform that list into record sets
      Iterable<RecordSet> recordSets =
          result.results() == null
              ? ImmutableList.<RecordSet>of()
              : Iterables.transform(result.results(), RecordSet.FROM_PB_FUNCTION);
      return new PageImpl<>(
          new RecordSetPageFetcher(zoneName, serviceOptions, cursor, optionsMap),
          cursor,
          recordSets);
    } catch (RetryHelper.RetryHelperException e) {
      throw DnsException.translateAndThrow(e);
    }
  }

  @Override
  public Zone create(final ZoneInfo zoneInfo, Dns.ZoneOption... options) {
    final Map<DnsRpc.Option, ?> optionsMap = optionMap(options);
    try {
      ManagedZone answer =
          runWithRetries(
              new Callable<ManagedZone>() {
                @Override
                public ManagedZone call() {
                  return dnsRpc.create(zoneInfo.toPb(), optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return answer == null ? null : Zone.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException ex) {
      throw DnsException.translateAndThrow(ex);
    }
  }

  @Override
  public Zone getZone(final String zoneName, Dns.ZoneOption... options) {
    final Map<DnsRpc.Option, ?> optionsMap = optionMap(options);
    try {
      ManagedZone answer =
          runWithRetries(
              new Callable<ManagedZone>() {
                @Override
                public ManagedZone call() {
                  return dnsRpc.getZone(zoneName, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return answer == null ? null : Zone.fromPb(this, answer);
    } catch (RetryHelper.RetryHelperException ex) {
      throw DnsException.translateAndThrow(ex);
    }
  }

  @Override
  public boolean delete(final String zoneName) {
    try {
      return runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              return dnsRpc.deleteZone(zoneName);
            }
          },
          getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelper.RetryHelperException ex) {
      throw DnsException.translateAndThrow(ex);
    }
  }

  @Override
  public ProjectInfo getProject(Dns.ProjectOption... fields) {
    final Map<DnsRpc.Option, ?> optionsMap = optionMap(fields);
    try {
      Project answer =
          runWithRetries(
              new Callable<Project>() {
                @Override
                public Project call() {
                  return dnsRpc.getProject(optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return answer == null ? null : ProjectInfo.fromPb(answer); // should never be null
    } catch (RetryHelper.RetryHelperException ex) {
      throw DnsException.translateAndThrow(ex);
    }
  }

  @Override
  public ChangeRequest applyChangeRequest(
      final String zoneName,
      final ChangeRequestInfo changeRequest,
      ChangeRequestOption... options) {
    final Map<DnsRpc.Option, ?> optionsMap = optionMap(options);
    try {
      Change answer =
          runWithRetries(
              new Callable<Change>() {
                @Override
                public Change call() {
                  return dnsRpc.applyChangeRequest(zoneName, changeRequest.toPb(), optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return answer == null ? null : ChangeRequest.fromPb(this, zoneName, answer); // not null
    } catch (RetryHelper.RetryHelperException ex) {
      throw DnsException.translateAndThrow(ex);
    }
  }

  @Override
  public ChangeRequest getChangeRequest(
      final String zoneName, final String changeRequestId, Dns.ChangeRequestOption... options) {
    final Map<DnsRpc.Option, ?> optionsMap = optionMap(options);
    try {
      Change answer =
          runWithRetries(
              new Callable<Change>() {
                @Override
                public Change call() {
                  return dnsRpc.getChangeRequest(zoneName, changeRequestId, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return answer == null ? null : ChangeRequest.fromPb(this, zoneName, answer);
    } catch (RetryHelper.RetryHelperException ex) {
      throw DnsException.translateAndThrow(ex);
    }
  }

  @Override
  public DnsBatch batch() {
    return new DnsBatch(this.getOptions());
  }

  static Map<DnsRpc.Option, ?> optionMap(Option... options) {
    Map<DnsRpc.Option, Object> temp = Maps.newEnumMap(DnsRpc.Option.class);
    for (Option option : options) {
      Object prev = temp.put(option.getRpcOption(), option.getValue());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return ImmutableMap.copyOf(temp);
  }
}
