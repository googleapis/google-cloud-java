/*
 * Copyright 2015 Google LLC
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

import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.dns.spi.DnsRpcFactory;
import com.google.cloud.dns.spi.v1.DnsRpc;
import com.google.cloud.dns.spi.v1.HttpDnsRpc;
import com.google.cloud.http.HttpTransportOptions;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

public class DnsOptions extends ServiceOptions<Dns, DnsOptions> {

  private static final long serialVersionUID = -2501790264435912627L;
  private static final String API_SHORT_NAME = "Dns";
  private static final String GC_DNS_RW = "https://www.googleapis.com/auth/ndev.clouddns.readwrite";
  private static final Set<String> SCOPES = ImmutableSet.of(GC_DNS_RW);

  public static class DefaultDnsFactory implements DnsFactory {
    private static final DnsFactory INSTANCE = new DefaultDnsFactory();

    @Override
    public Dns create(DnsOptions options) {
      return new DnsImpl(options);
    }
  }

  public static class DefaultDnsRpcFactory implements DnsRpcFactory {

    private static final DnsRpcFactory INSTANCE = new DefaultDnsRpcFactory();

    @Override
    public ServiceRpc create(DnsOptions options) {
      return new HttpDnsRpc(options);
    }
  }

  public static class Builder extends ServiceOptions.Builder<Dns, DnsOptions, Builder> {

    private Builder() {}

    private Builder(DnsOptions options) {
      super(options);
    }

    @Override
    public Builder setTransportOptions(TransportOptions transportOptions) {
      if (!(transportOptions instanceof HttpTransportOptions)) {
        throw new IllegalArgumentException(
            "Only http transport is allowed for " + API_SHORT_NAME + ".");
      }
      return super.setTransportOptions(transportOptions);
    }

    @Override
    public DnsOptions build() {
      return new DnsOptions(this);
    }
  }

  private DnsOptions(Builder builder) {
    super(DnsFactory.class, DnsRpcFactory.class, builder, new DnsDefaults());
  }

  private static class DnsDefaults implements ServiceDefaults<Dns, DnsOptions> {

    @Override
    public DnsFactory getDefaultServiceFactory() {
      return DefaultDnsFactory.INSTANCE;
    }

    @Override
    public DnsRpcFactory getDefaultRpcFactory() {
      return DefaultDnsRpcFactory.INSTANCE;
    }

    @Override
    public TransportOptions getDefaultTransportOptions() {
      return getDefaultHttpTransportOptions();
    }
  }

  public static HttpTransportOptions getDefaultHttpTransportOptions() {
    return HttpTransportOptions.newBuilder().build();
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  protected DnsRpc getDnsRpcV1() {
    return (DnsRpc) getRpc();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder newBuilder() {
    return new Builder().setHost(com.google.api.services.dns.Dns.DEFAULT_BASE_URL);
  }

  /**
   * Creates a default instance of {@code DnsOptions} with the project ID and credentials inferred
   * from the environment.
   */
  public static DnsOptions getDefaultInstance() {
    return newBuilder().build();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof DnsOptions && baseEquals((DnsOptions) obj);
  }

  @Override
  public int hashCode() {
    return baseHashCode();
  }
}
