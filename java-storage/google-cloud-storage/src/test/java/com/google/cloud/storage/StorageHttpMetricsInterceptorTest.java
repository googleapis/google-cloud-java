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
import com.google.api.client.http.HttpRequestInitializer;
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
import java.util.concurrent.atomic.AtomicBoolean;
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
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b/o")))
        .isEqualTo("/storage/v1/b/{bucket}/o");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj")))
        .isEqualTo("/storage/v1/b/{bucket}/o/{object}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/b/my-b/o/dir/sub/file.txt")))
        .isEqualTo("/storage/v1/b/{bucket}/o/{object}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/compose")))
        .isEqualTo("/storage/v1/b/{bucket}/o/{object}/compose");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/restore")))
        .isEqualTo("/storage/v1/b/{bucket}/o/{object}/restore");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/watchAll")))
        .isEqualTo("/storage/v1/b/{bucket}/o/{object}/watchAll");
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
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/b1/iam")))
        .isEqualTo("/storage/v1/b/{bucket}/iam");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/b/b1/iam/testPermissions")))
        .isEqualTo("/storage/v1/b/{bucket}/iam/testPermissions");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/projects/my-p/hmacKeys/key1")))
        .isEqualTo("/storage/v1/projects/{project}/hmacKeys/{accessId}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl(
                    "https://storage.googleapis.com/storage/v1/projects/my-p/serviceAccount")))
        .isEqualTo("/storage/v1/projects/{project}/serviceAccount");
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
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl("https://my-bucket.storage.googleapis.com/")))
        .isEqualTo("/");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl("https://my-bucket.storage.googleapis.com/my-obj")))
        .isEqualTo("/{object}");
    assertThat(
            StorageHttpMetricsInterceptor.extractUrlTemplate(
                new GenericUrl("https://my-bucket.storage.googleapis.com/dir/my-obj")))
        .isEqualTo("/{object}");
  }

  @Test
  public void resolveServerAddress_stripsVirtualHostedBucketPrefix() {
    assertThat(
            StorageHttpMetricsInterceptor.resolveServerAddress(
                new GenericUrl("https://my-bucket.storage.googleapis.com/my-obj"),
                "storage.googleapis.com"))
        .isEqualTo("storage.googleapis.com");
    assertThat(
            StorageHttpMetricsInterceptor.resolveServerAddress(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b"),
                "storage.googleapis.com"))
        .isEqualTo("storage.googleapis.com");
    assertThat(StorageHttpMetricsInterceptor.resolveServerAddress(null, "storage.googleapis.com"))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void initialize_200Ok_recordsDurationWithoutErrorType() throws IOException {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock, "https://storage.googleapis.com");

    HttpTransport transport = createAdvancingTransport(200, 250_000_000L);

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
    assertThat(point.getSum()).isWithin(1e-6).of(0.25);

    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("http");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_REQUEST_METHOD)).isEqualTo("GET");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo("200");
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

    HttpTransport transport = createAdvancingTransport(308, 120_000_000L);

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
    assertThat(point.getSum()).isWithin(1e-6).of(0.12);
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("http");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo("308");
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isEqualTo("OK");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void initialize_404NotFound_recordsErrorType() throws IOException {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock, "https://storage.googleapis.com");

    HttpTransport transport = createAdvancingTransport(404, 80_000_000L);

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
    assertThat(point.getSum()).isWithin(1e-6).of(0.08);
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("http");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo("404");
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isEqualTo("NOT_FOUND");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void initialize_503ServiceUnavailable_recordsErrorType() throws IOException {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock, "https://storage.googleapis.com");

    HttpTransport transport = createAdvancingTransport(503, 400_000_000L);

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
    assertThat(point.getSum()).isWithin(1e-6).of(0.40);
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("http");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo("503");
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isEqualTo("UNAVAILABLE");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void initialize_networkIOException_recordsErrorTypeWithoutStatusCode() throws IOException {
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
                clock.advanceNanos(150_000_000L);
                throw new IOException("Connection reset by peer");
              }
            };
          }
        };

    HttpRequest req =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b"));

    assertThrows(IOException.class, req::execute);

    Collection<MetricData> metricData = reader.collectAllMetrics();
    MetricData durationData =
        metricData.stream()
            .filter(
                m -> m.getName().equals(StorageClientMetrics.METRIC_HTTP_CLIENT_REQUEST_DURATION))
            .findFirst()
            .orElse(null);

    assertThat(durationData).isNotNull();
    HistogramPointData point = durationData.getHistogramData().getPoints().iterator().next();
    assertThat(point.getSum()).isWithin(1e-6).of(0.15);
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("http");
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isEqualTo("CONNECTIVITY");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo("0");
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
    assertThat(ttfbPoint.getCount()).isEqualTo(1L);
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.25);
    Attributes attrs = ttfbPoint.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("http");
    assertThat(attrs.get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION)).isEqualTo("ReadObject");
    assertThat(attrs.get(StorageClientMetrics.KEY_NETWORK_PATH))
        .isEqualTo(StorageClientMetrics.NETWORK_PATH_CLOUDPATH);
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void initialize_mediaDownloadNon2xxResponse_doesNotRecordTtfb() throws IOException {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock, "https://storage.googleapis.com");

    for (int statusCode : new int[] {304, 404}) {
      MockLowLevelHttpResponse lowLevelResponse = new MockLowLevelHttpResponse();
      lowLevelResponse.setStatusCode(statusCode);
      HttpTransport transport =
          new MockHttpTransport.Builder().setLowLevelHttpResponse(lowLevelResponse).build();

      HttpRequest request =
          transport
              .createRequestFactory(interceptor)
              .buildGetRequest(
                  new GenericUrl(
                      "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj?alt=media"));
      request.setThrowExceptionOnExecuteError(false);
      request.execute();
    }

    Collection<MetricData> metricData = reader.collectAllMetrics();
    MetricData ttfbData =
        metricData.stream()
            .filter(m -> m.getName().equals(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_TTFB))
            .findFirst()
            .orElse(null);
    assertThat(ttfbData).isNull();
  }

  @Test
  public void initialize_altMediaAddedAfterBuildGetRequest_recordsTtfb() throws IOException {
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
              public LowLevelHttpResponse execute() {
                clock.advanceNanos(120_000_000L);
                return lowLevelResponse;
              }
            };
          }
        };

    HttpRequest request =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj"));
    request.getUrl().put("alt", "media");
    request.execute();

    Collection<MetricData> metricData = reader.collectAllMetrics();
    MetricData ttfbData =
        metricData.stream()
            .filter(m -> m.getName().equals(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_TTFB))
            .findFirst()
            .orElse(null);

    assertThat(ttfbData).isNotNull();
    HistogramPointData ttfbPoint = ttfbData.getHistogramData().getPoints().iterator().next();
    assertThat(ttfbPoint.getCount()).isEqualTo(1L);
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.12);
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("ReadObject");
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
  public void initialize_ioExceptionBeforeExecuteInterceptorRuns_doesNotRecordMetric()
      throws IOException {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock, "https://storage.googleapis.com");

    HttpTransport transport = new MockHttpTransport();
    HttpRequest req =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b"));

    clock.advanceNanos(500_000_000L);
    boolean handled = req.getIOExceptionHandler().handleIOException(req, false);

    assertThat(handled).isFalse();
    assertThat(reader.collectAllMetrics()).isEmpty();
  }

  @Test
  public void initialize_chainsExistingDelegateAndInterceptors() throws IOException {
    StorageClientMetrics metrics = StorageClientMetrics.create(meterProvider, true, false);
    AtomicBoolean delegateCalled = new AtomicBoolean(false);
    AtomicBoolean execCalled = new AtomicBoolean(false);
    AtomicBoolean respCalled = new AtomicBoolean(false);
    AtomicBoolean ioHandlerCalled = new AtomicBoolean(false);

    HttpRequestInitializer delegate =
        request -> {
          delegateCalled.set(true);
          request.setInterceptor(req -> execCalled.set(true));
          request.setResponseInterceptor(resp -> respCalled.set(true));
          request.setIOExceptionHandler(
              (req, supportsRetry) -> {
                ioHandlerCalled.set(true);
                return false;
              });
        };

    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(
            delegate, metrics, clock, "https://storage.googleapis.com");

    HttpTransport transport = createAdvancingTransport(200, 100_000_000L);
    HttpRequest request =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b"));
    request.execute();

    assertThat(delegateCalled.get()).isTrue();
    assertThat(execCalled.get()).isTrue();
    assertThat(respCalled.get()).isTrue();

    request.getIOExceptionHandler().handleIOException(request, false);
    assertThat(ioHandlerCalled.get()).isTrue();
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

  private HttpTransport createAdvancingTransport(int statusCode, long advanceNanos) {
    return new MockHttpTransport() {
      @Override
      public LowLevelHttpRequest buildRequest(String method, String url) {
        return new MockLowLevelHttpRequest() {
          @Override
          public LowLevelHttpResponse execute() {
            clock.advanceNanos(advanceNanos);
            MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
            response.setStatusCode(statusCode);
            return response;
          }
        };
      }
    };
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
