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

package com.google.cloud.bigquery;

import com.google.cloud.HttpTransportOptions;
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.bigquery.spi.v2.BigQueryRpc;
import com.google.cloud.bigquery.spi.BigQueryRpcFactory;
import com.google.cloud.bigquery.spi.v2.HttpBigQueryRpc;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class BigQueryOptions extends ServiceOptions<BigQuery, BigQueryOptions> {

  private static final String API_SHORT_NAME = "BigQuery";
  private static final String BIGQUERY_SCOPE = "https://www.googleapis.com/auth/bigquery";
  private static final Set<String> SCOPES = ImmutableSet.of(BIGQUERY_SCOPE);
  private static final long serialVersionUID = -2437598817433266049L;

  public static class DefaultBigqueryFactory implements BigQueryFactory {

    private static final BigQueryFactory INSTANCE = new DefaultBigqueryFactory();

    @Override
    public BigQuery create(BigQueryOptions options) {
      return new BigQueryImpl(options);
    }
  }

  public static class DefaultBigQueryRpcFactory implements BigQueryRpcFactory {

    private static final BigQueryRpcFactory INSTANCE = new DefaultBigQueryRpcFactory();

    @Override
    public ServiceRpc create(BigQueryOptions options) {
      return new HttpBigQueryRpc(options);
    }
  }

  public static class Builder extends
      ServiceOptions.Builder<BigQuery, BigQueryOptions, Builder> {

    private Builder() {
    }

    private Builder(BigQueryOptions options) {
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
    public BigQueryOptions build() {
      return new BigQueryOptions(this);
    }
  }

  private BigQueryOptions(Builder builder) {
    super(BigQueryFactory.class, BigQueryRpcFactory.class, builder, new BigQueryDefaults());
  }

  private static class BigQueryDefaults implements
      ServiceDefaults<BigQuery, BigQueryOptions> {

    @Override
    public BigQueryFactory getDefaultServiceFactory() {
      return DefaultBigqueryFactory.INSTANCE;
    }

    @Override
    public BigQueryRpcFactory getDefaultRpcFactory() {
      return DefaultBigQueryRpcFactory.INSTANCE;
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

  protected BigQueryRpc getBigQueryRpcV2() {
    return (BigQueryRpc) getRpc();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return baseHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof BigQueryOptions)) {
      return false;
    }
    BigQueryOptions other = (BigQueryOptions) obj;
    return baseEquals(other);
  }


  public static BigQueryOptions getDefaultInstance() {
    return newBuilder().build();
  }


  public static Builder newBuilder() {
    return new Builder();
  }
}
