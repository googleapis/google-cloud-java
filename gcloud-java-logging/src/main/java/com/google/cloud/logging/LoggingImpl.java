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

package com.google.cloud.logging;

import static com.google.api.client.util.Preconditions.checkArgument;
import static com.google.cloud.logging.Logging.ListOption.OptionType.PAGE_SIZE;
import static com.google.cloud.logging.Logging.ListOption.OptionType.PAGE_TOKEN;
import static com.google.common.util.concurrent.Futures.lazyTransform;

import com.google.cloud.AsyncPage;
import com.google.cloud.AsyncPageImpl;
import com.google.cloud.BaseService;
import com.google.cloud.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.logging.spi.LoggingRpc;
import com.google.cloud.logging.spi.v2.ConfigServiceV2Api;
import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.Empty;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class LoggingImpl extends BaseService<LoggingOptions> implements Logging {

  private final LoggingRpc rpc;
  private boolean closed;

  private static final Function<Empty, Boolean> EMPTY_TO_BOOLEAN_FUNCTION =
      new Function<Empty, Boolean>() {
        @Override
        public Boolean apply(Empty input) {
          return input != null;
        }
      };

  LoggingImpl(LoggingOptions options) {
    super(options);
    rpc = options.rpc();
  }

  private static <V> V get(Future<V> future) {
    try {
      return Uninterruptibles.getUninterruptibly(future);
    } catch (ExecutionException ex) {
      throw Throwables.propagate(ex.getCause());
    }
  }

  private abstract static class BasePageFetcher<T> implements AsyncPageImpl.NextPageFetcher<T> {

    private static final long serialVersionUID = 5095123855547444030L;

    private final LoggingOptions serviceOptions;
    private final Map<Option.OptionType, ?> requestOptions;

    private BasePageFetcher(LoggingOptions serviceOptions, String cursor,
        Map<Option.OptionType, ?> requestOptions) {
      this.serviceOptions = serviceOptions;
      this.requestOptions =
          PageImpl.nextRequestOptions(PAGE_TOKEN, cursor, requestOptions);
    }

    LoggingOptions serviceOptions() {
      return serviceOptions;
    }

    Map<Option.OptionType, ?> requestOptions() {
      return requestOptions;
    }
  }

  private static class SinkPageFetcher extends BasePageFetcher<Sink> {

    private static final long serialVersionUID = 4879364260060886875L;

    SinkPageFetcher(LoggingOptions serviceOptions, String cursor,
        Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
    }

    @Override
    public Future<AsyncPage<Sink>> nextPage() {
      return listSinksAsync(serviceOptions(), requestOptions());
    }
  }

  @Override
  public Sink create(SinkInfo sink) {
    return get(createAsync(sink));
  }

  @Override
  public Future<Sink> createAsync(SinkInfo sink) {
    CreateSinkRequest request = CreateSinkRequest.newBuilder()
        .setProjectName(ConfigServiceV2Api.formatProjectName(options().projectId()))
        .setSink(sink.toPb(options().projectId()))
        .build();
    return lazyTransform(rpc.create(request), Sink.fromPbFunction(this));
  }

  @Override
  public Sink update(SinkInfo sink) {
    return get(updateAsync(sink));
  }

  @Override
  public Future<Sink> updateAsync(SinkInfo sink) {
    UpdateSinkRequest request = UpdateSinkRequest.newBuilder()
        .setSinkName(ConfigServiceV2Api.formatSinkName(options().projectId(), sink.name()))
        .setSink(sink.toPb(options().projectId()))
        .build();
    return lazyTransform(rpc.update(request), Sink.fromPbFunction(this));
  }

  @Override
  public Sink getSink(String sink) {
    return get(getSinkAsync(sink));
  }

  @Override
  public Future<Sink> getSinkAsync(String sink) {
    GetSinkRequest request = GetSinkRequest.newBuilder()
        .setSinkName(ConfigServiceV2Api.formatSinkName(options().projectId(), sink))
        .build();
    return lazyTransform(rpc.get(request), Sink.fromPbFunction(this));
  }

  private static ListSinksRequest listSinksRequest(LoggingOptions serviceOptions,
      Map<Option.OptionType, ?> options) {
    ListSinksRequest.Builder builder = ListSinksRequest.newBuilder();
    builder.setProjectName(ConfigServiceV2Api.formatProjectName(serviceOptions.projectId()));
    Integer pageSize = PAGE_SIZE.get(options);
    String pageToken = PAGE_TOKEN.get(options);
    if (pageSize != null) {
      builder.setPageSize(pageSize);
    }
    if (pageToken != null) {
      builder.setPageToken(pageToken);
    }
    return builder.build();
  }

  private static Future<AsyncPage<Sink>> listSinksAsync(final LoggingOptions serviceOptions,
      final Map<Option.OptionType, ?> options) {
    final ListSinksRequest request = listSinksRequest(serviceOptions, options);
    Future<ListSinksResponse> list = serviceOptions.rpc().list(request);
    return lazyTransform(list, new Function<ListSinksResponse, AsyncPage<Sink>>() {
      @Override
      public AsyncPage<Sink> apply(ListSinksResponse listSinksResponse) {
        List<Sink> sinks = listSinksResponse.getSinksList() == null ? ImmutableList.<Sink>of()
            : Lists.transform(listSinksResponse.getSinksList(),
            Sink.fromPbFunction(serviceOptions.service()));
        String cursor = listSinksResponse.getNextPageToken().equals("") ? null
            : listSinksResponse.getNextPageToken();
        return new AsyncPageImpl<>(
            new SinkPageFetcher(serviceOptions, cursor, options), cursor, sinks);
      }
    });
  }

  @Override
  public Page<Sink> listSinks(ListOption... options) {
    return get(listSinksAsync(options));
  }

  @Override
  public Future<AsyncPage<Sink>> listSinksAsync(ListOption... options) {
    return listSinksAsync(options(), optionMap(options));
  }

  @Override
  public boolean deleteSink(String sink) {
    return get(deleteSinkAsync(sink));
  }

  @Override
  public Future<Boolean> deleteSinkAsync(String sink) {
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder()
        .setSinkName(ConfigServiceV2Api.formatSinkName(options().projectId(), sink))
        .build();
    return lazyTransform(rpc.delete(request), EMPTY_TO_BOOLEAN_FUNCTION);
  }

  @Override
  public void close() throws Exception {
    if (closed) {
      return;
    }
    closed = true;
    rpc.close();
  }

  static <T extends Option.OptionType> Map<Option.OptionType, ?> optionMap(Option... options) {
    Map<Option.OptionType, Object> optionMap = Maps.newHashMap();
    for (Option option : options) {
      Object prev = optionMap.put(option.optionType(), option.value());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return optionMap;
  }
}
