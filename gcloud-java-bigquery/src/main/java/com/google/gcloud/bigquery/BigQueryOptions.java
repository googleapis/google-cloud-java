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

import com.google.common.collect.ImmutableSet;
import com.google.gcloud.ServiceOptions;
import com.google.gcloud.spi.DefaultBigQueryRpc;
import com.google.gcloud.spi.BigQueryRpc;
import com.google.gcloud.spi.BigQueryRpcFactory;

import java.util.Set;

public class BigQueryOptions extends ServiceOptions<BigQuery, BigQueryRpc, BigQueryOptions> {

  private static final String BIGQUERY_SCOPE = "https://www.googleapis.com/auth/bigquery";
  private static final Set<String> SCOPES = ImmutableSet.of(BIGQUERY_SCOPE);
  private static final long serialVersionUID = -215981591481708043L;

  public static class DefaultBigqueryFactory implements BigQueryFactory {

    private static final BigQueryFactory INSTANCE = new DefaultBigqueryFactory();

    @Override
    public BigQuery create(BigQueryOptions options) {
      // TODO(mziccard) return new BigqueryImpl(options);
      return null;
    }
  }

  public static class DefaultBigQueryRpcFactory implements BigQueryRpcFactory {

    private static final BigQueryRpcFactory INSTANCE = new DefaultBigQueryRpcFactory();

    @Override
    public BigQueryRpc create(BigQueryOptions options) {
      // TODO(mziccard) return new DefaultBigqueryRpc(options);
      return null;
    }
  }

  public static class Builder extends
      ServiceOptions.Builder<BigQuery, BigQueryRpc, BigQueryOptions, Builder> {

    private Builder() {
    }

    private Builder(BigQueryOptions options) {
      super(options);
    }

    @Override
    public BigQueryOptions build() {
      return new BigQueryOptions(this);
    }
  }

  private BigQueryOptions(Builder builder) {
    super(BigQueryFactory.class, BigQueryRpcFactory.class, builder);
  }

  @Override
  protected BigQueryFactory defaultServiceFactory() {
    return DefaultBigqueryFactory.INSTANCE;
  }

  @Override
  protected BigQueryRpcFactory defaultRpcFactory() {
    return DefaultBigQueryRpcFactory.INSTANCE;
  }

  @Override
  protected Set<String> scopes() {
    return SCOPES;
  }

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

  public static Builder builder() {
    return new Builder();
  }
}
