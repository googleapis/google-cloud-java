/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.spanner.spi.v1;

import static com.google.api.gax.grpc.GrpcCallContext.TRACER_KEY;
import static com.google.cloud.spanner.spi.v1.SpannerRpcViews.DATABASE_ID;
import static com.google.cloud.spanner.spi.v1.SpannerRpcViews.INSTANCE_ID;
import static com.google.cloud.spanner.spi.v1.SpannerRpcViews.METHOD;
import static com.google.cloud.spanner.spi.v1.SpannerRpcViews.PROJECT_ID;
import static com.google.cloud.spanner.spi.v1.SpannerRpcViews.SPANNER_GFE_HEADER_MISSING_COUNT;
import static com.google.cloud.spanner.spi.v1.SpannerRpcViews.SPANNER_GFE_LATENCY;

import com.google.api.gax.tracing.ApiTracer;
import com.google.cloud.spanner.*;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.spanner.admin.database.v1.DatabaseName;
import io.grpc.*;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.alts.AltsContextUtil;
import io.opencensus.stats.MeasureMap;
import io.opencensus.stats.Stats;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.TagContext;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import io.opencensus.tags.Tags;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.Span;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Intercepts all gRPC calls to extract server-timing header. Captures GFE Latency and GFE Header
 * Missing count metrics.
 */
class HeaderInterceptor implements ClientInterceptor {
  private static final DatabaseName UNDEFINED_DATABASE_NAME =
      DatabaseName.of("undefined-project", "undefined-instance", "undefined-database");
  private static final Metadata.Key<String> SERVER_TIMING_HEADER_KEY =
      Metadata.Key.of("server-timing", Metadata.ASCII_STRING_MARSHALLER);
  private static final String GFE_TIMING_HEADER = "gfet4t7";
  private static final String AFE_TIMING_HEADER = "afe";
  private static final Metadata.Key<String> GOOGLE_CLOUD_RESOURCE_PREFIX_KEY =
      Metadata.Key.of("google-cloud-resource-prefix", Metadata.ASCII_STRING_MARSHALLER);
  private static final Pattern SERVER_TIMING_PATTERN =
      Pattern.compile("(?<metricName>[a-zA-Z0-9_-]+);\\s*dur=(?<duration>\\d+(\\.\\d+)?)");
  private static final Pattern GOOGLE_CLOUD_RESOURCE_PREFIX_PATTERN =
      Pattern.compile(
          ".*projects/(?<project>\\p{ASCII}[^/]*)(/instances/(?<instance>\\p{ASCII}[^/]*))?(/databases/(?<database>\\p{ASCII}[^/]*))?");
  private final Cache<String, DatabaseName> databaseNameCache =
      CacheBuilder.newBuilder().maximumSize(100).build();
  private final Cache<String, TagContext> tagsCache =
      CacheBuilder.newBuilder().maximumSize(1000).build();
  private final Cache<String, Attributes> attributesCache =
      CacheBuilder.newBuilder().maximumSize(1000).build();
  private final Cache<String, Map<String, String>> builtInAttributesCache =
      CacheBuilder.newBuilder().maximumSize(1000).build();
  private final Cache<DatabaseName, Cache<String, String>> keyCache =
      CacheBuilder.newBuilder().maximumSize(1000).build();

  // Get the global singleton Tagger object.
  private static final Tagger TAGGER = Tags.getTagger();
  private static final StatsRecorder STATS_RECORDER = Stats.getStatsRecorder();

  private static final Logger LOGGER = Logger.getLogger(HeaderInterceptor.class.getName());
  private static final Level LEVEL = Level.INFO;
  private final SpannerRpcMetrics spannerRpcMetrics;
  private Float gfeLatency;
  private Float afeLatency;

  HeaderInterceptor(SpannerRpcMetrics spannerRpcMetrics) {
    this.spannerRpcMetrics = spannerRpcMetrics;
  }

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    ApiTracer tracer = callOptions.getOption(TRACER_KEY);
    CompositeTracer compositeTracer =
        tracer instanceof CompositeTracer ? (CompositeTracer) tracer : null;
    return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        try {
          Span span = Span.current();
          DatabaseName databaseName = extractDatabaseName(headers);
          String key = extractKey(databaseName, method.getFullMethodName());
          String requestId = extractRequestId(headers);
          TagContext tagContext = getTagContext(key, method.getFullMethodName(), databaseName);
          Attributes attributes =
              getMetricAttributes(key, method.getFullMethodName(), databaseName);

          super.start(
              new SimpleForwardingClientCallListener<RespT>(responseListener) {
                @Override
                public void onHeaders(Metadata metadata) {
                  String serverTiming = metadata.get(SERVER_TIMING_HEADER_KEY);
                  try {
                    // Get gfe and afe Latency value
                    Map<String, Float> serverTimingMetrics = parseServerTimingHeader(serverTiming);
                    gfeLatency = serverTimingMetrics.get(GFE_TIMING_HEADER);
                    afeLatency = serverTimingMetrics.get(AFE_TIMING_HEADER);
                  } catch (NumberFormatException e) {
                    LOGGER.log(LEVEL, "Invalid server-timing object in header: {}", serverTiming);
                  }

                  super.onHeaders(metadata);
                }

                @Override
                public void onClose(Status status, Metadata trailers) {
                  // Record Built-in Metrics
                  boolean isDirectPathUsed = AltsContextUtil.check(getAttributes());
                  boolean isAfeEnabled = GapicSpannerRpc.isEnableAFEServerTiming();
                  recordSpan(span, requestId);
                  recordCustomMetrics(tagContext, attributes, isDirectPathUsed);
                  Map<String, String> builtInMetricsAttributes = new HashMap<>();
                  try {
                    builtInMetricsAttributes = getBuiltInMetricAttributes(key, databaseName);
                  } catch (ExecutionException e) {
                    LOGGER.log(
                        LEVEL, "Unable to get built-in metric attributes {}", e.getMessage());
                  }
                  recordBuiltInMetrics(
                      compositeTracer,
                      builtInMetricsAttributes,
                      requestId,
                      isDirectPathUsed,
                      isAfeEnabled);
                  super.onClose(status, trailers);
                }
              },
              headers);
        } catch (ExecutionException executionException) {
          // This should never happen,
          throw SpannerExceptionFactory.asSpannerException(executionException.getCause());
        }
      }
    };
  }

  private void recordCustomMetrics(
      TagContext tagContext, Attributes attributes, Boolean isDirectPathUsed) {
    // Record OpenCensus and Custom OpenTelemetry Metrics
    MeasureMap measureMap = STATS_RECORDER.newMeasureMap();

    if (!isDirectPathUsed) {
      if (gfeLatency != null) {
        long gfeVal = gfeLatency.longValue();
        measureMap.put(SPANNER_GFE_LATENCY, gfeVal);
        measureMap.put(SPANNER_GFE_HEADER_MISSING_COUNT, 0L);
        spannerRpcMetrics.recordGfeLatency(gfeVal, attributes);
        spannerRpcMetrics.recordGfeHeaderMissingCount(0L, attributes);
      } else {
        measureMap.put(SPANNER_GFE_HEADER_MISSING_COUNT, 1L);
        spannerRpcMetrics.recordGfeHeaderMissingCount(1L, attributes);
      }
    }
    measureMap.record(tagContext);
  }

  private void recordSpan(Span span, String requestId) {
    if (span != null) {
      if (gfeLatency != null) {
        span.setAttribute("gfe_latency", gfeLatency.toString());
      }
      if (afeLatency != null) {
        span.setAttribute("afe_latency", afeLatency.toString());
      }
      span.setAttribute(XGoogSpannerRequestId.REQUEST_ID_HEADER_NAME, requestId);
    }
  }

  private void recordBuiltInMetrics(
      CompositeTracer compositeTracer,
      Map<String, String> builtInMetricsAttributes,
      String requestId,
      Boolean isDirectPathUsed,
      Boolean isAfeEnabled) {
    if (compositeTracer != null) {
      builtInMetricsAttributes.put(BuiltInMetricsConstant.REQUEST_ID_KEY.getKey(), requestId);
      builtInMetricsAttributes.put(
          BuiltInMetricsConstant.DIRECT_PATH_USED_KEY.getKey(), Boolean.toString(isDirectPathUsed));
      compositeTracer.addAttributes(builtInMetricsAttributes);
      compositeTracer.recordServerTimingHeaderMetrics(
          gfeLatency, afeLatency, isDirectPathUsed, isAfeEnabled);
    }
  }

  private Map<String, Float> parseServerTimingHeader(String serverTiming) {
    Map<String, Float> serverTimingMetrics = new HashMap<>();
    if (serverTiming != null) {
      Matcher matcher = SERVER_TIMING_PATTERN.matcher(serverTiming);
      while (matcher.find()) {
        String metricName = matcher.group("metricName");
        String durationStr = matcher.group("duration");

        if (metricName != null && durationStr != null) {
          serverTimingMetrics.put(metricName, Float.valueOf(durationStr));
        }
      }
    }
    return serverTimingMetrics;
  }

  private String extractKey(DatabaseName databaseName, String methodName)
      throws ExecutionException {
    Cache<String, String> keys =
        keyCache.get(databaseName, () -> CacheBuilder.newBuilder().maximumSize(1000).build());
    return keys.get(methodName, () -> databaseName + methodName);
  }

  private DatabaseName extractDatabaseName(Metadata headers) throws ExecutionException {
    String googleResourcePrefix = headers.get(GOOGLE_CLOUD_RESOURCE_PREFIX_KEY);
    if (googleResourcePrefix != null) {
      return databaseNameCache.get(
          googleResourcePrefix,
          () -> {
            String projectId = "undefined-project";
            String instanceId = "undefined-database";
            String databaseId = "undefined-database";
            Matcher matcher = GOOGLE_CLOUD_RESOURCE_PREFIX_PATTERN.matcher(googleResourcePrefix);
            if (matcher.find()) {
              projectId = matcher.group("project");
              if (matcher.group("instance") != null) {
                instanceId = matcher.group("instance");
              }
              if (matcher.group("database") != null) {
                databaseId = matcher.group("database");
              }
            } else {
              LOGGER.log(
                  LEVEL, "Error parsing google cloud resource header: " + googleResourcePrefix);
            }
            return DatabaseName.of(projectId, instanceId, databaseId);
          });
    }
    return UNDEFINED_DATABASE_NAME;
  }

  private String extractRequestId(Metadata headers) throws ExecutionException {
    return headers.get(XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY);
  }

  private TagContext getTagContext(String key, String method, DatabaseName databaseName)
      throws ExecutionException {
    return tagsCache.get(
        key,
        () ->
            TAGGER
                .currentBuilder()
                .putLocal(PROJECT_ID, TagValue.create(databaseName.getProject()))
                .putLocal(INSTANCE_ID, TagValue.create(databaseName.getInstance()))
                .putLocal(DATABASE_ID, TagValue.create(databaseName.getDatabase()))
                .putLocal(METHOD, TagValue.create(method))
                .build());
  }

  private Attributes getMetricAttributes(String key, String method, DatabaseName databaseName)
      throws ExecutionException {
    return attributesCache.get(
        key,
        () -> {
          AttributesBuilder attributesBuilder = Attributes.builder();
          attributesBuilder.put("database", databaseName.getDatabase());
          attributesBuilder.put("instance_id", databaseName.getInstance());
          attributesBuilder.put("project_id", databaseName.getProject());
          attributesBuilder.put("method", method);

          return attributesBuilder.build();
        });
  }

  private Map<String, String> getBuiltInMetricAttributes(String key, DatabaseName databaseName)
      throws ExecutionException {
    return builtInAttributesCache.get(
        key,
        () -> {
          Map<String, String> attributes = new HashMap<>();
          attributes.put(BuiltInMetricsConstant.DATABASE_KEY.getKey(), databaseName.getDatabase());
          attributes.put(
              BuiltInMetricsConstant.INSTANCE_ID_KEY.getKey(), databaseName.getInstance());
          attributes.put(
              BuiltInMetricsConstant.DIRECT_PATH_ENABLED_KEY.getKey(),
              String.valueOf(GapicSpannerRpc.DIRECTPATH_CHANNEL_CREATED));
          return attributes;
        });
  }
}
