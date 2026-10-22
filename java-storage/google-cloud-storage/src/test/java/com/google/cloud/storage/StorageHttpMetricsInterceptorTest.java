/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.core.ApiClock;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Before;
import org.junit.Test;

public final class StorageHttpMetricsInterceptorTest {

  private InMemoryMetricReader reader;
  private SdkMeterProvider meterProvider;
  private FakeClock clock;

  @Before
  public void setUp() {
    reader = InMemoryMetricReader.create();
    meterProvider = SdkMeterProvider.builder().registerMetricReader(reader).build();
    clock = new FakeClock();
  }

  @Test
  public void extractUrlTemplate_cases() {
    assertThat(StorageHttpMetricsInterceptor.extractUrlTemplate(null)).isEqualTo("/");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/upload/storage/v1/b/my-b/o?upload_id=xyz")))
        .isEqualTo("/upload/storage/v1/b/{bucket}/o");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl("https://storage.googleapis.com/upload/storage/v1/b/my-b/o")))
        .isEqualTo("/upload/storage/v1/b/{bucket}/o");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj")))
        .isEqualTo("/download/storage/v1/b/{bucket}/o/{object}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl("https://storage.googleapis.com/batch/storage/v1")))
        .isEqualTo("/batch/storage/v1");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b")))
        .isEqualTo("/storage/v1/b/{bucket}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj")))
        .isEqualTo("/storage/v1/b/{bucket}/o/{object}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/acl/allUsers")))
        .isEqualTo("/storage/v1/b/{bucket}/o/{object}/acl/{entity}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/b/b1/o/o1/copyTo/b/b2/o/o2")))
        .isEqualTo(
            "/storage/v1/b/{bucket}/o/{object}/copyTo/b/{destinationBucket}/o/{destinationObject}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/b/b1/o/o1/rewriteTo/b/b2/o/o2")))
        .isEqualTo(
            "/storage/v1/b/{bucket}/o/{object}/rewriteTo/b/{destinationBucket}/o/{destinationObject}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/b1/o/o1/moveTo/o/o2")))
        .isEqualTo("/storage/v1/b/{bucket}/o/{object}/moveTo/o/{destinationObject}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/b1/acl/allUsers")))
        .isEqualTo("/storage/v1/b/{bucket}/acl/{entity}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/b/b1/defaultObjectAcl/allUsers")))
        .isEqualTo("/storage/v1/b/{bucket}/defaultObjectAcl/{entity}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/b/b1/notifications/notif1")))
        .isEqualTo("/storage/v1/b/{bucket}/notifications/{notification}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/projects/my-p/hmacKeys/key1")))
        .isEqualTo("/storage/v1/projects/{project}/hmacKeys/{accessId}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl("https://storage.googleapis.com/my-b")))
        .isEqualTo("/{bucket}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl("https://storage.googleapis.com/my-b/my-obj")))
        .isEqualTo("/{bucket}/{object}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl("https://storage.googleapis.com/")))
        .isEqualTo("/");
  }

  @Test
  public void initialize_200Ok_recordsDurationWithoutErrorType() throws IOException {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock, "https://storage.googleapis.com");

    MockLowLevelHttpResponse lowLevelResponse = new MockLowLevelHttpResponse();
    lowLevelResponse.setStatusCode(200);
    HttpTransport transport =
        new MockHttpTransport.Builder().setLowLevelHttpResponse(lowLevelResponse).build();

    HttpRequest request =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj"));
    request.execute();

    Collection<MetricData> metricData = reader.collectAllMetrics();
    MetricData durationData =
        metricData.stream()
            .filter(
                m -> m.getName().equals(StorageClientMetrics.METRIC_HTTP_CLIENT_REQUEST_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(durationData).isNotNull();
    assertThat(durationData.getHistogramData().getPoints()).hasSize(1);
    HistogramPointData point = durationData.getHistogramData().getPoints().iterator().next();

    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_REQUEST_METHOD)).isEqualTo("GET");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo(200L);
    assertThat(attrs.get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_CLOUDPATH);
    assertThat(attrs.get(StorageClientMetrics.KEY_URL_TEMPLATE))
        .isEqualTo("/storage/v1/b/{bucket}/o/{object}");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isEqualTo("OK");
  }

  @Test
  public void initialize_308ResumeIncomplete_recordsWithoutErrorType() throws IOException {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock, "https://storage.googleapis.com");

    MockLowLevelHttpResponse lowLevelResponse = new MockLowLevelHttpResponse();
    lowLevelResponse.setStatusCode(308);
    HttpTransport transport =
        new MockHttpTransport.Builder().setLowLevelHttpResponse(lowLevelResponse).build();

    HttpRequest request =
        transport
            .createRequestFactory(interceptor)
            .buildPutRequest(
                new GenericUrl(
                    "https://storage.googleapis.com/upload/storage/v1/b/my-b/o?upload_id=123"),
                null);
    request.setThrowExceptionOnExecuteError(false);
    request.execute();

    Collection<MetricData> metricData = reader.collectAllMetrics();
    MetricData durationData =
        metricData.stream()
            .filter(
                m -> m.getName().equals(StorageClientMetrics.METRIC_HTTP_CLIENT_REQUEST_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(durationData).isNotNull();
    HistogramPointData point = durationData.getHistogramData().getPoints().iterator().next();
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo(308L);
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isEqualTo("OK");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void initialize_404NotFound_recordsErrorType() throws IOException {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock, "https://storage.googleapis.com");

    MockLowLevelHttpResponse lowLevelResponse = new MockLowLevelHttpResponse();
    lowLevelResponse.setStatusCode(404);
    HttpTransport transport =
        new MockHttpTransport.Builder().setLowLevelHttpResponse(lowLevelResponse).build();

    HttpRequest request =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/missing-bucket"));
    request.setThrowExceptionOnExecuteError(false);
    request.execute();

    Collection<MetricData> metricData = reader.collectAllMetrics();
    MetricData durationData =
        metricData.stream()
            .filter(
                m -> m.getName().equals(StorageClientMetrics.METRIC_HTTP_CLIENT_REQUEST_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(durationData).isNotNull();
    HistogramPointData point = durationData.getHistogramData().getPoints().iterator().next();
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo(404L);
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isEqualTo("NOT_FOUND");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void initialize_503ServiceUnavailable_recordsErrorType() throws IOException {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock, "https://storage.googleapis.com");

    MockLowLevelHttpResponse lowLevelResponse = new MockLowLevelHttpResponse();
    lowLevelResponse.setStatusCode(503);
    HttpTransport transport =
        new MockHttpTransport.Builder().setLowLevelHttpResponse(lowLevelResponse).build();

    HttpRequest request =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj"));
    request.setThrowExceptionOnExecuteError(false);
    request.execute();

    Collection<MetricData> metricData = reader.collectAllMetrics();
    MetricData durationData =
        metricData.stream()
            .filter(
                m -> m.getName().equals(StorageClientMetrics.METRIC_HTTP_CLIENT_REQUEST_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(durationData).isNotNull();
    HistogramPointData point = durationData.getHistogramData().getPoints().iterator().next();
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo(503L);
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isEqualTo("UNAVAILABLE");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void initialize_networkIOException_recordsErrorTypeWithoutStatusCode() {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock, "https://storage.googleapis.com");

    HttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                throw new IOException("Connection reset by peer");
              }
            };
          }
        };

    assertThrows(
        IOException.class,
        () -> {
          HttpRequest req =
              transport
                  .createRequestFactory(interceptor)
                  .buildGetRequest(
                      new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b"));
          req.execute();
        });

    Collection<MetricData> metricData = reader.collectAllMetrics();
    MetricData durationData =
        metricData.stream()
            .filter(
                m -> m.getName().equals(StorageClientMetrics.METRIC_HTTP_CLIENT_REQUEST_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(durationData).isNotNull();
    HistogramPointData point = durationData.getHistogramData().getPoints().iterator().next();
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isEqualTo("CONNECTIVITY");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo(0L);
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void isMediaDownloadRequest_cases() throws IOException {
    HttpTransport transport = new MockHttpTransport();
    HttpRequest getDownload =
        transport
            .createRequestFactory()
            .buildGetRequest(
                new GenericUrl(
                    "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj"));
    assertThat(StorageHttpMetricsInterceptor.isMediaDownloadRequest(getDownload)).isTrue();

    HttpRequest getAltMedia =
        transport
            .createRequestFactory()
            .buildGetRequest(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj?alt=media"));
    assertThat(StorageHttpMetricsInterceptor.isMediaDownloadRequest(getAltMedia)).isTrue();

    HttpRequest getMetadata =
        transport
            .createRequestFactory()
            .buildGetRequest(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj"));
    assertThat(StorageHttpMetricsInterceptor.isMediaDownloadRequest(getMetadata)).isFalse();

    HttpRequest postReq =
        transport
            .createRequestFactory()
            .buildPostRequest(
                new GenericUrl(
                    "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj"),
                null);
    assertThat(StorageHttpMetricsInterceptor.isMediaDownloadRequest(postReq)).isFalse();

    assertThat(StorageHttpMetricsInterceptor.isMediaDownloadRequest(null)).isFalse();
  }

  @Test
  public void initialize_mediaDownload_recordsTtfb() throws IOException {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock, "https://storage.googleapis.com");

    MockLowLevelHttpResponse lowLevelResponse = new MockLowLevelHttpResponse();
    lowLevelResponse.setStatusCode(200);
    HttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                clock.advanceNanos(250_000_000L); // 0.25s network duration
                return lowLevelResponse;
              }
            };
          }
        };

    HttpRequest request =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(
                new GenericUrl(
                    "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj"));
    request.execute();

    Collection<MetricData> metricData = reader.collectAllMetrics();
    MetricData ttfbData =
        metricData.stream()
            .filter(m -> m.getName().equals(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_TTFB))
            .findFirst()
            .orElse(null);

    assertThat(ttfbData).isNotNull();
    assertThat(ttfbData.getHistogramData().getPoints()).hasSize(1);
    HistogramPointData ttfbPoint = ttfbData.getHistogramData().getPoints().iterator().next();
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.25);
    Attributes attrs = ttfbPoint.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("http");
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_METHOD)).isEqualTo("ReadObject");
    assertThat(attrs.get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_CLOUDPATH);
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void initialize_nonDownloadGet_doesNotRecordTtfb() throws IOException {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock, "https://storage.googleapis.com");

    MockLowLevelHttpResponse lowLevelResponse = new MockLowLevelHttpResponse();
    lowLevelResponse.setStatusCode(200);
    HttpTransport transport =
        new MockHttpTransport.Builder().setLowLevelHttpResponse(lowLevelResponse).build();

    HttpRequest request =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj"));
    request.execute();

    Collection<MetricData> metricData = reader.collectAllMetrics();
    MetricData ttfbData =
        metricData.stream()
            .filter(m -> m.getName().equals(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_TTFB))
            .findFirst()
            .orElse(null);
    assertThat(ttfbData).isNull();
  }

  @Test
  public void initialize_metricsDisabled_doesNotRecord() throws IOException {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, false, false);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock, "https://storage.googleapis.com");

    MockLowLevelHttpResponse lowLevelResponse = new MockLowLevelHttpResponse();
    lowLevelResponse.setStatusCode(200);
    HttpTransport transport =
        new MockHttpTransport.Builder().setLowLevelHttpResponse(lowLevelResponse).build();

    HttpRequest request =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b"));
    request.execute();

    assertThat(reader.collectAllMetrics()).isEmpty();
  }

  private static final class FakeClock implements ApiClock {
    private final AtomicLong nanos = new AtomicLong(1_000_000_000L);

    @Override
    public long nanoTime() {
      return nanos.get();
    }

    @Override
    public long millisTime() {
      return nanos.get() / 1_000_000L;
    }

    void advanceNanos(long amount) {
      nanos.addAndGet(amount);
    }
  }
}
