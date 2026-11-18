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
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.client.googleapis.batch.BatchCallback;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.core.ApiClock;
import com.google.cloud.NoCredentials;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Before;
import org.junit.Test;

public final class StorageHttpMetricsInterceptorTest {

  private InMemoryMetricReader reader;
  private FakeClock clock;
  private HttpStorageOptions httpOptions;
  private StorageClientMetrics metrics;

  @Before
  public void setUp() {
    reader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(reader).build();
    clock = new FakeClock();
    httpOptions =
        StorageOptions.http()
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setClock(clock)
            .setEnableOtelMetrics(true)
            .setMeterProvider(meterProvider)
            .build();
    metrics = httpOptions.getStorageClientMetrics();
  }

  @Test
  public void extractUrlTemplate_cases() {
    String[][] cases = {
      {"https://storage.googleapis.com", "/"},
      {"https://storage.googleapis.com/", "/"},
      {
        "https://storage.googleapis.com/upload/storage/v1/b/my-b/o",
        "/upload/storage/v1/b/{bucket}/o"
      },
      {
        "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj",
        "/download/storage/v1/b/{bucket}/o/{object}"
      },
      {"https://storage.googleapis.com/batch/storage/v1", "/batch/storage/v1"},
      {"https://storage.googleapis.com/storage/v1/b", "/storage/v1/b"},
      {"https://storage.googleapis.com/storage/v1/b/my-b", "/storage/v1/b/{bucket}"},
      {"https://storage.googleapis.com/storage/v1/b/my-b/o", "/storage/v1/b/{bucket}/o"},
      {
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj",
        "/storage/v1/b/{bucket}/o/{object}"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/my-b/o/dir/sub/file.txt",
        "/storage/v1/b/{bucket}/o/{object}"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/compose",
        "/storage/v1/b/{bucket}/o/{object}/compose"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/restore",
        "/storage/v1/b/{bucket}/o/{object}/restore"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/acl",
        "/storage/v1/b/{bucket}/o/{object}/acl"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj/acl/allUsers",
        "/storage/v1/b/{bucket}/o/{object}/acl/{entity}"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/b1/o/o1/rewriteTo/b/b2/o/o2",
        "/storage/v1/b/{bucket}/o/{object}/rewriteTo/b/{bucket}/o/{object}"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/b1/o/o1/moveTo/o/o2",
        "/storage/v1/b/{bucket}/o/{object}/moveTo/o/{object}"
      },
      {"https://storage.googleapis.com/storage/v1/b/b1/acl", "/storage/v1/b/{bucket}/acl"},
      {
        "https://storage.googleapis.com/storage/v1/b/b1/acl/allUsers",
        "/storage/v1/b/{bucket}/acl/{entity}"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/b1/defaultObjectAcl",
        "/storage/v1/b/{bucket}/defaultObjectAcl"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/b1/defaultObjectAcl/allUsers",
        "/storage/v1/b/{bucket}/defaultObjectAcl/{entity}"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/b1/notificationConfigs",
        "/storage/v1/b/{bucket}/notificationConfigs"
      },
      {
        "https://storage.googleapis.com/storage/v1/b/b1/notificationConfigs/notif1",
        "/storage/v1/b/{bucket}/notificationConfigs/{notification}"
      },
      {"https://storage.googleapis.com/storage/v1/b/b1/iam", "/storage/v1/b/{bucket}/iam"},
      {
        "https://storage.googleapis.com/storage/v1/b/b1/iam/testPermissions",
        "/storage/v1/b/{bucket}/iam/testPermissions"
      },
      {
        "https://storage.googleapis.com/storage/v1/projects/my-p/hmacKeys/key1",
        "/storage/v1/projects/{project}/hmacKeys/{access_id}"
      },
      {
        "https://storage.googleapis.com/storage/v1/projects/my-p/serviceAccount",
        "/storage/v1/projects/{project}/serviceAccount"
      },
      {"https://storage.googleapis.com/my-b", "/{bucket}"},
      {"https://storage.googleapis.com/my-b/my-obj", "/{bucket}/{object}"},
      {"https://my-bucket.storage.googleapis.com/", "/"},
      {"https://my-bucket.storage.googleapis.com/my-obj", "/{object}"},
      {"https://my-bucket.storage.googleapis.com/dir/my-obj", "/{object}"},
    };

    for (String[] testCase : cases) {
      String url = testCase[0];
      String expectedTemplate = testCase[1];
      assertWithMessage(url)
          .that(StorageHttpMetricsInterceptor.extractUrlTemplate(new GenericUrl(url)))
          .isEqualTo(expectedTemplate);
    }
  }

  @Test
  public void isMediaDownloadRequest_cases() throws IOException {
    HttpRequestFactory factory = new MockHttpTransport().createRequestFactory();
    Object[][] cases = {
      {"GET", "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj", true},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj?alt=media", true},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj?alt=json", false},
      {"GET", "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj", false},
      {"GET", "https://storage.googleapis.com", false},
      {"POST", "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj", false},
    };

    for (Object[] testCase : cases) {
      String method = (String) testCase[0];
      String url = (String) testCase[1];
      boolean expected = (boolean) testCase[2];
      HttpRequest request = factory.buildRequest(method, new GenericUrl(url), null);
      assertWithMessage("%s %s", method, url)
          .that(StorageHttpMetricsInterceptor.isMediaDownloadRequest(request))
          .isEqualTo(expected);
    }
  }

  @Test
  public void initialize_statusCodes_recordsDurationAndErrorType() throws IOException {
    Map<Integer, String> cases =
        ImmutableMap.of(
            308, "OK",
            503, "UNAVAILABLE",
            200, "OK");

    for (int statusCode : cases.keySet()) {
      AtomicBoolean delegateCalled = new AtomicBoolean(false);
      AtomicBoolean execCalled = new AtomicBoolean(false);
      AtomicBoolean respCalled = new AtomicBoolean(false);
      HttpRequestInitializer delegate =
          request -> {
            delegateCalled.set(true);
            request.setInterceptor(req -> execCalled.set(true));
            request.setResponseInterceptor(
                resp -> {
                  clock.advanceNanos(50_000_000L);
                  respCalled.set(true);
                });
          };
      HttpRequestInitializer interceptor = httpOptions.decorateWithMetrics(delegate);

      HttpTransport transport = createAdvancingTransport(statusCode, 250_000_000L);
      String url =
          statusCode == 200
              ? "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj?alt=media"
              : "https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj";
      HttpRequest request =
          transport.createRequestFactory(interceptor).buildGetRequest(new GenericUrl(url));
      if (statusCode != 200) {
        request.setThrowExceptionOnExecuteError(false);
      }
      request.execute();

      assertWithMessage("status=%s", statusCode).that(delegateCalled.get()).isTrue();
      assertWithMessage("status=%s", statusCode).that(execCalled.get()).isTrue();
      assertWithMessage("status=%s", statusCode).that(respCalled.get()).isTrue();
      if (statusCode != 200) {
        assertWithMessage("status=%s", statusCode).that(ttfbPoints()).isEmpty();
      }
    }

    List<HistogramPointData> points = durationPoints();
    assertThat(points).hasSize(cases.size());
    for (Map.Entry<Integer, String> entry : cases.entrySet()) {
      long statusCode = entry.getKey();
      HistogramPointData point = findPointByStatus(points, statusCode);
      assertWithMessage("status=%s", statusCode).that(point.getCount()).isEqualTo(1L);
      assertWithMessage("status=%s", statusCode).that(point.getSum()).isWithin(1e-6).of(0.25);

      Attributes attrs = point.getAttributes();
      assertThat(attrs.get(StorageClientMetrics.KEY_GCP_CLIENT_SERVICE))
          .isEqualTo(StorageClientMetrics.SERVICE_STORAGE);
      assertThat(attrs.get(StorageClientMetrics.KEY_GCP_CLIENT_VERSION))
          .isEqualTo(StorageOptions.version());
      assertThat(attrs.get(StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT))
          .isEqualTo(StorageClientMetrics.ARTIFACT_STORAGE);
      assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("http");
      assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_REQUEST_METHOD)).isEqualTo("GET");
      assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE))
          .isEqualTo(statusCode);
      assertThat(attrs.get(StorageClientMetrics.KEY_NETWORK_PATH))
          .isEqualTo(StorageClientMetrics.NETWORK_PATH_CLOUDPATH);
      assertThat(attrs.get(StorageClientMetrics.KEY_URL_TEMPLATE))
          .isEqualTo("/storage/v1/b/{bucket}/o/{object}");
      assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
          .isEqualTo("storage.googleapis.com");
      assertWithMessage("status=%s", statusCode)
          .that(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE))
          .isEqualTo(entry.getValue());
    }

    List<HistogramPointData> ttfb = ttfbPoints();
    assertThat(ttfb).hasSize(1);
    HistogramPointData ttfbPoint = ttfb.get(0);
    assertThat(ttfbPoint.getCount()).isEqualTo(1L);
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.25);
    assertThat(ttfbPoint.getAttributes())
        .isEqualTo(
            Attributes.builder()
                .put(
                    StorageClientMetrics.KEY_GCP_CLIENT_SERVICE,
                    StorageClientMetrics.SERVICE_STORAGE)
                .put(StorageClientMetrics.KEY_GCP_CLIENT_VERSION, StorageOptions.version())
                .put(
                    StorageClientMetrics.KEY_GCP_CLIENT_ARTIFACT,
                    StorageClientMetrics.ARTIFACT_STORAGE)
                .put(StorageClientMetrics.KEY_RPC_SYSTEM_NAME, "http")
                .put(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION, "ReadObject")
                .put(
                    StorageClientMetrics.KEY_NETWORK_PATH,
                    StorageClientMetrics.NETWORK_PATH_CLOUDPATH)
                .put(StorageClientMetrics.KEY_SERVER_ADDRESS, "storage.googleapis.com")
                .build());
  }

  @Test
  public void initialize_altMediaAddedAfterBuildGetRequest_recordsTtfb() throws IOException {
    HttpRequestInitializer interceptor = httpOptions.decorateWithMetrics(null);

    HttpTransport transport = createAdvancingTransport(200, 120_000_000L);
    HttpRequest request =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj"));
    request.getUrl().put("alt", "media");
    request.execute();

    List<HistogramPointData> ttfb = ttfbPoints();
    assertThat(ttfb).hasSize(1);
    HistogramPointData ttfbPoint = ttfb.get(0);
    assertThat(ttfbPoint.getCount()).isEqualTo(1L);
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.12);
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("ReadObject");
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void initialize_unsuccessfulResponseHandlerReturnsFalseOn404_recordsOnce()
      throws IOException {
    AtomicBoolean handlerCalled = new AtomicBoolean(false);
    HttpRequestInitializer delegate =
        request ->
            request.setUnsuccessfulResponseHandler(
                (req, response, supportsRetry) -> {
                  handlerCalled.set(true);
                  return false;
                });
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(delegate, metrics, clock);

    HttpTransport transport = createAdvancingTransport(404, 80_000_000L);
    HttpRequest request =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(
                new GenericUrl(
                    "https://storage.googleapis.com/download/storage/v1/b/my-b/o/missing-obj?alt=media"));
    request.setThrowExceptionOnExecuteError(false);
    request.execute();

    assertThat(handlerCalled.get()).isTrue();

    List<HistogramPointData> points = durationPoints();
    assertThat(points).hasSize(1);
    HistogramPointData point = points.get(0);
    assertThat(point.getCount()).isEqualTo(1L);
    assertThat(point.getSum()).isWithin(1e-6).of(0.08);
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME)).isEqualTo("http");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo(404L);
    assertThat(attrs.get(StorageClientMetrics.KEY_URL_TEMPLATE))
        .isEqualTo("/download/storage/v1/b/{bucket}/o/{object}");
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE)).isEqualTo("NOT_FOUND");
    assertThat(attrs.get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");

    List<HistogramPointData> ttfb = ttfbPoints();
    assertThat(ttfb).hasSize(1);
    HistogramPointData ttfbPoint = ttfb.get(0);
    assertThat(ttfbPoint.getCount()).isEqualTo(1L);
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.08);
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("ReadObject");
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void initialize_ioExceptionThenRetrySucceeds_recordsTwoPoints() throws IOException {
    AtomicBoolean firstAttempt = new AtomicBoolean(true);
    HttpRequestInitializer retryDelegate =
        request -> request.setIOExceptionHandler((req, supportsRetry) -> true);
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(retryDelegate, metrics, clock);

    HttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                if (firstAttempt.compareAndSet(true, false)) {
                  clock.advanceNanos(100_000_000L);
                  throw new IOException("Connection reset by peer");
                }
                clock.advanceNanos(200_000_000L);
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(200);
                return response;
              }
            };
          }
        };

    HttpRequest req =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b"));
    req.execute();

    List<HistogramPointData> points = durationPoints();
    assertThat(points).hasSize(2);

    HistogramPointData errorPoint = findPointByStatus(points, 0L);
    assertThat(errorPoint.getSum()).isWithin(1e-6).of(0.10);
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_RPC_SYSTEM_NAME))
        .isEqualTo("http");
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
    assertThat(errorPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_CONNECTION_ERROR);

    HistogramPointData okPoint = findPointByStatus(points, 200L);
    assertThat(okPoint.getSum()).isWithin(1e-6).of(0.20);
    assertThat(okPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_OK);

    assertThat(ttfbPoints()).isEmpty();
  }

  @Test
  public void initialize_401RefreshRetryThen200_recordsBothAttempts() throws IOException {
    AtomicBoolean firstAttempt = new AtomicBoolean(true);
    HttpRequestInitializer refreshDelegate =
        request ->
            request.setUnsuccessfulResponseHandler(
                (req, response, supportsRetry) -> {
                  if (response.getStatusCode() == 401) {
                    // Simulate token refresh latency inside the UnsuccessfulResponseHandler;
                    // the 401 request duration and TTFB must be captured before this handler runs.
                    clock.advanceNanos(200_000_000L);
                    return true;
                  }
                  return false;
                });
    StorageHttpMetricsInterceptor interceptor =
        new StorageHttpMetricsInterceptor(refreshDelegate, metrics, clock);

    HttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() {
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                if (firstAttempt.compareAndSet(true, false)) {
                  clock.advanceNanos(90_000_000L);
                  response.setStatusCode(401);
                } else {
                  clock.advanceNanos(180_000_000L);
                  response.setStatusCode(200);
                }
                return response;
              }
            };
          }
        };

    HttpRequest req =
        transport
            .createRequestFactory(interceptor)
            .buildGetRequest(
                new GenericUrl(
                    "https://storage.googleapis.com/download/storage/v1/b/my-b/o/my-obj?alt=media"));
    req.execute();

    List<HistogramPointData> points = durationPoints();
    assertThat(points).hasSize(2);

    HistogramPointData unauthorizedPoint = findPointByStatus(points, 401L);
    assertThat(unauthorizedPoint.getSum()).isWithin(1e-6).of(0.09);
    assertThat(unauthorizedPoint.getAttributes().get(StorageClientMetrics.KEY_URL_TEMPLATE))
        .isEqualTo("/download/storage/v1/b/{bucket}/o/{object}");
    assertThat(unauthorizedPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo("UNAUTHENTICATED");

    HistogramPointData okPoint = findPointByStatus(points, 200L);
    assertThat(okPoint.getSum()).isWithin(1e-6).of(0.18);
    assertThat(okPoint.getAttributes().get(StorageClientMetrics.KEY_URL_TEMPLATE))
        .isEqualTo("/download/storage/v1/b/{bucket}/o/{object}");
    assertThat(okPoint.getAttributes().get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_OK);

    List<HistogramPointData> ttfb = ttfbPoints();
    assertThat(ttfb).hasSize(1);
    HistogramPointData ttfbPoint = ttfb.get(0);
    assertThat(ttfbPoint.getCount()).isEqualTo(2L);
    assertThat(ttfbPoint.getSum()).isWithin(1e-6).of(0.27);
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_GCP_STORAGE_OPERATION))
        .isEqualTo("ReadObject");
    assertThat(ttfbPoint.getAttributes().get(StorageClientMetrics.KEY_SERVER_ADDRESS))
        .isEqualTo("storage.googleapis.com");
  }

  @Test
  public void initialize_batchPart401_doesNotRecordPartDuration() throws IOException {
    AtomicBoolean refreshHandlerCalled = new AtomicBoolean(false);
    AtomicBoolean partSucceeded = new AtomicBoolean(false);
    AtomicBoolean firstBatch = new AtomicBoolean(true);

    HttpRequestInitializer refreshDelegate =
        request ->
            request.setUnsuccessfulResponseHandler(
                (req, response, supportsRetry) -> {
                  if (response.getStatusCode() == 401) {
                    refreshHandlerCalled.set(true);
                    return true;
                  }
                  return false;
                });
    StorageHttpMetricsInterceptor partInterceptor =
        new StorageHttpMetricsInterceptor(refreshDelegate, metrics, clock);
    StorageHttpMetricsInterceptor batchInterceptor =
        new StorageHttpMetricsInterceptor(null, metrics, clock);

    HttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() {
                clock.advanceNanos(100_000_000L);
                String partStatusLine =
                    firstBatch.compareAndSet(true, false)
                        ? "HTTP/1.1 401 Unauthorized"
                        : "HTTP/1.1 200 OK";
                String body =
                    "--batch_boundary\r\n"
                        + "Content-Type: application/http\r\n"
                        + "\r\n"
                        + partStatusLine
                        + "\r\n"
                        + "\r\n"
                        + "--batch_boundary--\r\n";
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(200);
                response.setContentType("multipart/mixed; boundary=batch_boundary");
                response.setContent(body);
                return response;
              }
            };
          }
        };

    HttpRequest partRequest =
        transport
            .createRequestFactory(partInterceptor)
            .buildGetRequest(
                new GenericUrl("https://storage.googleapis.com/storage/v1/b/my-b/o/my-obj"));

    BatchRequest batchRequest = new BatchRequest(transport, batchInterceptor);
    batchRequest.setBatchUrl(new GenericUrl("https://storage.googleapis.com/batch/storage/v1"));
    batchRequest.setSleeper(millis -> {});
    batchRequest.queue(
        partRequest,
        Void.class,
        Void.class,
        new BatchCallback<Void, Void>() {
          @Override
          public void onSuccess(Void t, HttpHeaders responseHeaders) {
            partSucceeded.set(true);
          }

          @Override
          public void onFailure(Void e, HttpHeaders responseHeaders) {
            throw new AssertionError("Expected retried batch part to succeed");
          }
        });

    batchRequest.execute();

    assertThat(refreshHandlerCalled.get()).isTrue();
    assertThat(partSucceeded.get()).isTrue();

    List<HistogramPointData> points = durationPoints();
    assertThat(points).hasSize(1);
    HistogramPointData point = points.get(0);
    assertThat(point.getCount()).isEqualTo(2L);
    assertThat(point.getSum()).isWithin(1e-6).of(0.20);
    Attributes attrs = point.getAttributes();
    assertThat(attrs.get(StorageClientMetrics.KEY_URL_TEMPLATE)).isEqualTo("/batch/storage/v1");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_REQUEST_METHOD)).isEqualTo("POST");
    assertThat(attrs.get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE)).isEqualTo(200L);
    assertThat(attrs.get(StorageClientMetrics.KEY_ERROR_TYPE))
        .isEqualTo(StorageErrorTypeMapper.STATUS_OK);
    assertThat(ttfbPoints()).isEmpty();
  }

  private List<HistogramPointData> durationPoints() {
    return histogramPoints(StorageClientMetrics.METRIC_HTTP_CLIENT_REQUEST_DURATION);
  }

  private List<HistogramPointData> ttfbPoints() {
    return histogramPoints(StorageClientMetrics.METRIC_GCP_STORAGE_CLIENT_TTFB);
  }

  private List<HistogramPointData> histogramPoints(String metricName) {
    return reader.collectAllMetrics().stream()
        .filter(m -> m.getName().equals(metricName))
        .findFirst()
        .map(m -> ImmutableList.copyOf(m.getHistogramData().getPoints()))
        .orElse(ImmutableList.of());
  }

  private static HistogramPointData findPointByStatus(
      List<HistogramPointData> points, long statusCode) {
    return points.stream()
        .filter(
            p ->
                Objects.equals(
                    p.getAttributes().get(StorageClientMetrics.KEY_HTTP_RESPONSE_STATUS_CODE),
                    statusCode))
        .findFirst()
        .orElseThrow(() -> new AssertionError("No point for status " + statusCode));
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
