/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import static com.google.gcloud.RetryHelper.runWithRetries;
import static java.util.concurrent.Executors.callable;

import com.google.gcloud.BaseWriteChannel;
import com.google.gcloud.RestorableState;
import com.google.gcloud.RetryHelper;
import com.google.gcloud.WriteChannel;

/**
 * WriteChannel implementation to stream data into a BigQuery table.
 */
class TableDataWriteChannel extends BaseWriteChannel<BigQueryOptions, WriteChannelConfiguration> {

  TableDataWriteChannel(BigQueryOptions options,
      WriteChannelConfiguration writeChannelConfiguration) {
    this(options, writeChannelConfiguration, options.rpc().open(writeChannelConfiguration.toPb()));
  }

  TableDataWriteChannel(BigQueryOptions options, WriteChannelConfiguration config,
      String uploadId) {
    super(options, config, uploadId);
  }

  @Override
  protected void flushBuffer(final int length, final boolean last) {
    try {
      runWithRetries(callable(new Runnable() {
        @Override
        public void run() {
          options().rpc().write(uploadId(), buffer(), 0, position(), length, last);
        }
      }), options().retryParams(), BigQueryImpl.EXCEPTION_HANDLER);
    } catch (RetryHelper.RetryHelperException e) {
      throw BigQueryException.translateAndThrow(e);
    }
  }

  protected StateImpl.Builder stateBuilder() {
    return StateImpl.builder(options(), entity(), uploadId());
  }

  static class StateImpl
      extends BaseWriteChannel.BaseState<BigQueryOptions, WriteChannelConfiguration> {

    private static final long serialVersionUID = -787362105981823738L;

    StateImpl(Builder builder) {
      super(builder);
    }

    static class Builder
        extends BaseWriteChannel.BaseState.Builder<BigQueryOptions, WriteChannelConfiguration> {

      private Builder(BigQueryOptions options, WriteChannelConfiguration configuration,
          String uploadId) {
        super(options, configuration, uploadId);
      }

      public RestorableState<WriteChannel> build() {
        return new StateImpl(this);
      }
    }

    static Builder builder(BigQueryOptions options, WriteChannelConfiguration config,
        String uploadId) {
      return new Builder(options, config, uploadId);
    }

    @Override
    public WriteChannel restore() {
      TableDataWriteChannel channel = new TableDataWriteChannel(serviceOptions, entity, uploadId);
      channel.restore(this);
      return channel;
    }
  }
}
