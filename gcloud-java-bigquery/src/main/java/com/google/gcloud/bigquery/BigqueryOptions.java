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
import com.google.gcloud.spi.DefaultBigqueryRpc;
import com.google.gcloud.spi.BigqueryRpc;
import com.google.gcloud.spi.BigqueryRpcFactory;

import java.util.Set;

public class BigqueryOptions extends ServiceOptions<Bigquery, BigqueryRpc, BigqueryOptions> {

  private static final String BIGQUERY_SCOPE = "https://www.googleapis.com/auth/bigquery";
  private static final Set<String> SCOPES = ImmutableSet.of(BIGQUERY_SCOPE);
  private static final long serialVersionUID = -215981591481708043L;

  public static class DefaultBigqueryFactory implements BigqueryFactory {

    private static final BigqueryFactory INSTANCE = new DefaultBigqueryFactory();

    @Override
    public Bigquery create(BigqueryOptions options) {
      // TODO(mziccard) return new BigqueryImpl(options);
      return null;
    }
  }

  public static class DefaultBigqueryRpcFactory implements BigqueryRpcFactory {

    private static final BigqueryRpcFactory INSTANCE = new DefaultBigqueryRpcFactory();

    @Override
    public BigqueryRpc create(BigqueryOptions options) {
      // TODO(mziccard) return new DefaultBigqueryRpc(options);
      return null;
    }
  }

  public static class Builder extends
      ServiceOptions.Builder<Bigquery, BigqueryRpc, BigqueryOptions, Builder> {

    private Builder() {
    }

    private Builder(BigqueryOptions options) {
      super(options);
    }

    @Override
    public BigqueryOptions build() {
      return new BigqueryOptions(this);
    }
  }

  private BigqueryOptions(Builder builder) {
    super(BigqueryFactory.class, BigqueryRpcFactory.class, builder);
  }

  @Override
  protected BigqueryFactory defaultServiceFactory() {
    return DefaultBigqueryFactory.INSTANCE;
  }

  @Override
  protected BigqueryRpcFactory defaultRpcFactory() {
    return DefaultBigqueryRpcFactory.INSTANCE;
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
    if (!(obj instanceof BigqueryOptions)) {
      return false;
    }
    BigqueryOptions other = (BigqueryOptions) obj;
    return baseEquals(other);
  }

  public static Builder builder() {
    return new Builder();
  }
}
