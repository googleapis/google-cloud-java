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

import com.google.common.collect.Sets;
import com.google.gcloud.ServiceOptions;
import com.google.gcloud.spi.DnsRpc;
import com.google.gcloud.spi.DnsRpcFactory;

import java.util.Set;

public class DnsOptions
    extends ServiceOptions<Dns, DnsRpc, DnsOptions> {

  private static final long serialVersionUID = -5311219368450107146L;

  // TODO(mderka) Finish implementation. Created issue #595.

  public static class DefaultDnsFactory implements DnsFactory {
    private static final DnsFactory INSTANCE = new DefaultDnsFactory();

    @Override
    public Dns create(DnsOptions options) {
      // TODO(mderka) Implement. Created issue #595.
      return null;
    }
  }

  public static class Builder extends ServiceOptions.Builder<Dns, DnsRpc,
      DnsOptions, Builder> {

    private Builder() {
    }

    private Builder(DnsOptions options) {
      super(options);
    }

    @Override
    public DnsOptions build() {
      return new DnsOptions(this);
    }
  }

  private DnsOptions(Builder builder) {
    super(DnsFactory.class, DnsRpcFactory.class, builder);
  }

  @Override
  protected DnsFactory defaultServiceFactory() {
    return DefaultDnsFactory.INSTANCE;
  }

  @Override
  protected DnsRpcFactory defaultRpcFactory() {
    return null;
  }

  @Override
  protected Set<String> scopes() {
    // TODO(mderka) Verify.
    return Sets.newHashSet("ndev.clouddns.readwrite");
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder builder() {
    return new Builder();
  }
}
