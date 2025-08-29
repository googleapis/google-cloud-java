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

package com.google.cloud.bigquery;

import com.google.api.core.BetaApi;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.bigquery.QueryJobConfiguration.JobCreationMode;
import com.google.cloud.bigquery.spi.BigQueryRpcFactory;
import com.google.cloud.bigquery.spi.v2.HttpBigQueryRpc;
import com.google.cloud.http.HttpTransportOptions;
import com.google.common.collect.ImmutableSet;
import io.opentelemetry.api.trace.Tracer;
import java.util.Set;

public class BigQueryOptions extends ServiceOptions<BigQuery, BigQueryOptions> {

  private static final String API_SHORT_NAME = "BigQuery";
  private static final int DEFAULT_READ_API_TIME_OUT = 60000;
  private static final String BIGQUERY_SCOPE = "https://www.googleapis.com/auth/bigquery";
  private static final Set<String> SCOPES = ImmutableSet.of(BIGQUERY_SCOPE);
  private static final long serialVersionUID = -2437598817433266048L;
  private final String location;
  // set the option ThrowNotFound when you want to throw the exception when the value not found
  private boolean setThrowNotFound;
  private boolean useInt64Timestamps;
  private JobCreationMode defaultJobCreationMode = JobCreationMode.JOB_CREATION_MODE_UNSPECIFIED;
  private boolean enableOpenTelemetryTracing;
  private Tracer openTelemetryTracer;
  private ResultRetryAlgorithm<?> resultRetryAlgorithm;

  public static class DefaultBigQueryFactory implements BigQueryFactory {

    private static final BigQueryFactory INSTANCE = new DefaultBigQueryFactory();

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

  public static class Builder extends ServiceOptions.Builder<BigQuery, BigQueryOptions, Builder> {

    private String location;
    private boolean useInt64Timestamps;
    private boolean enableOpenTelemetryTracing;
    private Tracer openTelemetryTracer;
    private ResultRetryAlgorithm<?> resultRetryAlgorithm;

    private Builder() {}

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

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setUseInt64Timestamps(boolean useInt64Timestamps) {
      this.useInt64Timestamps = useInt64Timestamps;
      return this;
    }

    /**
     * Enables OpenTelemetry tracing functionality for this BigQuery instance
     *
     * @param enableOpenTelemetryTracing enables OpenTelemetry tracing if true
     */
    @BetaApi
    public Builder setEnableOpenTelemetryTracing(boolean enableOpenTelemetryTracing) {
      this.enableOpenTelemetryTracing = enableOpenTelemetryTracing;
      return this;
    }

    /**
     * Sets the OpenTelemetry tracer for this BigQuery instance to be tracer.
     *
     * @param tracer OpenTelemetry tracer to be used
     */
    @BetaApi
    public Builder setOpenTelemetryTracer(Tracer tracer) {
      this.openTelemetryTracer = tracer;
      return this;
    }

    public Builder setResultRetryAlgorithm(ResultRetryAlgorithm<?> resultRetryAlgorithm) {
      this.resultRetryAlgorithm = resultRetryAlgorithm;
      return this;
    }

    @Override
    public BigQueryOptions build() {
      return new BigQueryOptions(this);
    }
  }

  private BigQueryOptions(Builder builder) {
    super(BigQueryFactory.class, BigQueryRpcFactory.class, builder, new BigQueryDefaults());
    this.location = builder.location;
    this.useInt64Timestamps = builder.useInt64Timestamps;
    this.enableOpenTelemetryTracing = builder.enableOpenTelemetryTracing;
    this.openTelemetryTracer = builder.openTelemetryTracer;
    if (builder.resultRetryAlgorithm != null) {
      this.resultRetryAlgorithm = builder.resultRetryAlgorithm;
    } else {
      this.resultRetryAlgorithm = BigQueryBaseService.DEFAULT_BIGQUERY_EXCEPTION_HANDLER;
    }
  }

  private static class BigQueryDefaults implements ServiceDefaults<BigQuery, BigQueryOptions> {

    private static final long serialVersionUID = -4551722608999107711L;

    @Override
    public BigQueryFactory getDefaultServiceFactory() {
      return DefaultBigQueryFactory.INSTANCE;
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
    return HttpTransportOptions.newBuilder().setReadTimeout(DEFAULT_READ_API_TIME_OUT).build();
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  protected HttpBigQueryRpc getBigQueryRpcV2() {
    return (HttpBigQueryRpc) getRpc();
  }

  public String getLocation() {
    return location;
  }

  @Deprecated
  public boolean isQueryPreviewEnabled() {
    return false;
  }

  public void setThrowNotFound(boolean setThrowNotFound) {
    this.setThrowNotFound = setThrowNotFound;
  }

  public void setUseInt64Timestamps(boolean useInt64Timestamps) {
    this.useInt64Timestamps = useInt64Timestamps;
  }

  @Deprecated
  public void setQueryPreviewEnabled(String queryPreviewEnabled) {}

  public void setDefaultJobCreationMode(JobCreationMode jobCreationMode) {
    this.defaultJobCreationMode = jobCreationMode;
  }

  public boolean getThrowNotFound() {
    return setThrowNotFound;
  }

  public boolean getUseInt64Timestamps() {
    return useInt64Timestamps;
  }

  public JobCreationMode getDefaultJobCreationMode() {
    return defaultJobCreationMode;
  }

  /**
   * Returns whether this BigQuery instance has OpenTelemetry tracing enabled
   *
   * @return true if tracing is enabled, false if not
   */
  @BetaApi("Span names and attributes are subject to change without notice")
  public boolean isOpenTelemetryTracingEnabled() {
    return enableOpenTelemetryTracing;
  }

  /**
   * Returns the OpenTelemetry tracer used by this BigQuery instance
   *
   * @return OpenTelemetry tracer object or {@code null} if not set
   */
  @BetaApi("Span names and attributes are subject to change without notice")
  public Tracer getOpenTelemetryTracer() {
    return openTelemetryTracer;
  }

  public ResultRetryAlgorithm<?> getResultRetryAlgorithm() {
    return resultRetryAlgorithm;
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
