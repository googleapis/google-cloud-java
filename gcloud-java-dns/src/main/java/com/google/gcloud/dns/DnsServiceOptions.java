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

package com.google.gcloud.dns;

import com.google.gcloud.ServiceOptions;
import com.google.gcloud.spi.DnsServiceRpc;
import com.google.gcloud.spi.DnsServiceRpcFactory;

import java.util.Set;

public class DnsServiceOptions
    extends ServiceOptions<DnsService, DnsServiceRpc, DnsServiceOptions> {

  private static final long serialVersionUID = -5311219368450107146L;

  // TODO(mderka) Finish implementation. Created issue #595.

  public static class DefaultDnsServiceFactory implements DnsServiceFactory {
    private static final DnsServiceFactory INSTANCE = new DefaultDnsServiceFactory();

    @Override
    public DnsService create(DnsServiceOptions options) {
      // TODO(mderka) Implement. Created issue #595.
      return null;
    }
  }

  public static class Builder extends ServiceOptions.Builder<DnsService, DnsServiceRpc,
      DnsServiceOptions, Builder> {

    private Builder() {
    }

    private Builder(DnsServiceOptions options) {
      super(options);
    }

    @Override
    public DnsServiceOptions build() {
      return new DnsServiceOptions(this);
    }
  }

  private DnsServiceOptions(Builder builder) {
    super(DnsServiceFactory.class, DnsServiceRpcFactory.class, builder);
  }

  @Override
  protected DnsServiceFactory defaultServiceFactory() {
    return DefaultDnsServiceFactory.INSTANCE;
  }

  @Override
  protected DnsServiceRpcFactory defaultRpcFactory() {
    return null;
  }

  @Override
  protected Set<String> scopes() {
    return null;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder builder() {
    return new Builder();
  }
}
