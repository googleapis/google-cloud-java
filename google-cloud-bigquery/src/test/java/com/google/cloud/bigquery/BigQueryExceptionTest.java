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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.cloud.BaseServiceException;
import com.google.cloud.ExceptionHandler;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.bigquery.spi.v2.BigQueryRpc;
import com.google.cloud.bigquery.spi.v2.HttpBigQueryRpc;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BigQueryExceptionTest {

  @Test
  public void testBigQueryException() {
    BigQueryException exception = new BigQueryException(500, "message");
    assertEquals(500, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertNull(exception.getError());
    assertTrue(exception.isRetryable());

    exception = new BigQueryException(502, "message");
    assertEquals(502, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertNull(exception.getError());
    assertTrue(exception.isRetryable());

    exception = new BigQueryException(503, "message");
    assertEquals(503, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertNull(exception.getError());
    assertTrue(exception.isRetryable());

    exception = new BigQueryException(504, "message");
    assertEquals(504, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertNull(exception.getError());
    assertTrue(exception.isRetryable());

    exception = new BigQueryException(400, "message");
    assertEquals(400, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertNull(exception.getError());
    assertFalse(exception.isRetryable());

    BigQueryError error = new BigQueryError("reason", null, null);
    exception = new BigQueryException(504, "message", error);
    assertEquals(504, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertEquals("reason", exception.getReason());
    assertEquals(error, exception.getError());
    assertTrue(exception.isRetryable());

    IOException cause = new SocketTimeoutException("socketTimeoutMessage");
    exception = new BigQueryException(cause);
    assertEquals(BigQueryException.UNKNOWN_CODE, exception.getCode());
    assertNull(exception.getReason());
    assertEquals("socketTimeoutMessage", exception.getMessage());
    assertEquals(cause, exception.getCause());
    assertTrue(exception.isRetryable());
    assertSame(cause, exception.getCause());

    exception = new BigQueryException(504, "message", cause);
    assertEquals(504, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertNull(exception.getError());
    assertTrue(exception.isRetryable());
    assertSame(cause, exception.getCause());

    HttpResponseException httpResponseException =
        new HttpResponseException.Builder(404, "Service Unavailable", new HttpHeaders()).build();
    exception = new BigQueryException(httpResponseException);
    assertEquals(404, exception.getCode());
    assertFalse(exception.isRetryable());

    httpResponseException = new HttpResponseException.Builder(504, null, new HttpHeaders()).build();
    exception = new BigQueryException(httpResponseException);
    assertEquals(504, exception.getCode());
    assertTrue(exception.isRetryable());

    httpResponseException = new HttpResponseException.Builder(503, null, new HttpHeaders()).build();
    exception = new BigQueryException(httpResponseException);
    assertEquals(503, exception.getCode());
    assertTrue(exception.isRetryable());

    httpResponseException = new HttpResponseException.Builder(502, null, new HttpHeaders()).build();
    exception = new BigQueryException(httpResponseException);
    assertEquals(502, exception.getCode());
    assertTrue(exception.isRetryable());

    httpResponseException = new HttpResponseException.Builder(500, null, new HttpHeaders()).build();
    exception = new BigQueryException(httpResponseException);
    assertEquals(500, exception.getCode());
    assertTrue(exception.isRetryable());
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    Exception cause = new BigQueryException(503, "message");
    RetryHelperException exceptionMock = mock(RetryHelperException.class);
    when(exceptionMock.getCause()).thenReturn(cause);
    try {
      BigQueryException.translateAndThrow(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(503, ex.getCode());
      assertEquals("message", ex.getMessage());
      assertTrue(ex.isRetryable());
    } finally {
      verify(exceptionMock, times(2)).getCause();
    }
    cause = new IllegalArgumentException("message");
    exceptionMock = mock(RetryHelperException.class);
    when(exceptionMock.getMessage()).thenReturn("message");
    when(exceptionMock.getCause()).thenReturn(cause);
    try {
      BigQueryException.translateAndThrow(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(BigQueryException.UNKNOWN_CODE, ex.getCode());
      assertEquals("message", ex.getMessage());
      assertFalse(ex.isRetryable());
      assertSame(cause, ex.getCause());
    } finally {
      verify(exceptionMock).getMessage();
      verify(exceptionMock, times(2)).getCause();
    }
  }

  @Test
  public void testDefaultExceptionHandler() throws java.io.IOException {
    BigQueryOptions defaultOptions =
        BigQueryOptions.newBuilder().setProjectId("project-id").build();
    DatasetInfo info = DatasetInfo.newBuilder("dataset").build();
    Dataset dataset = null;

    final com.google.api.services.bigquery.model.Dataset datasetPb =
        info.setProjectId(defaultOptions.getProjectId()).toPb();
    final Map<BigQueryRpc.Option, ?> optionsMap = new HashMap<>();

    BigQueryOptions mockOptions = spy(defaultOptions);
    HttpBigQueryRpc bigQueryRpcMock = mock(HttpBigQueryRpc.class);
    doReturn(bigQueryRpcMock).when(mockOptions).getBigQueryRpcV2();
    // java.net.SocketException is retry-able in the default exception handler.
    doThrow(java.net.SocketException.class)
        .when(bigQueryRpcMock)
        .createSkipExceptionTranslation(datasetPb, optionsMap);

    BigQuery bigquery = mockOptions.getService();
    try {
      dataset = bigquery.create(info);
    } catch (BigQueryException e) {
      assertEquals(e.getCause().getClass(), java.net.SocketException.class);
      assertNull(dataset);
    } finally {
      verify(bigQueryRpcMock, times(6)).createSkipExceptionTranslation(datasetPb, optionsMap);
    }
  }

  @Test
  public void testCustomExceptionHandler() throws java.io.IOException {
    BigQueryOptions defaultOptions =
        BigQueryOptions.newBuilder()
            .setProjectId("project-id")
            .setResultRetryAlgorithm(
                ExceptionHandler.newBuilder()
                    .abortOn(RuntimeException.class)
                    .retryOn(java.util.EmptyStackException.class)
                    .addInterceptors(BigQueryBaseService.EXCEPTION_HANDLER_INTERCEPTOR)
                    .build())
            .build();
    DatasetInfo info = DatasetInfo.newBuilder("dataset").build();
    Dataset dataset = null;

    final com.google.api.services.bigquery.model.Dataset datasetPb =
        info.setProjectId(defaultOptions.getProjectId()).toPb();
    final Map<BigQueryRpc.Option, ?> optionsMap = new HashMap<>();

    BigQueryOptions mockOptions = spy(defaultOptions);
    HttpBigQueryRpc bigQueryRpcRetryMock = mock(HttpBigQueryRpc.class);
    doReturn(bigQueryRpcRetryMock).when(mockOptions).getBigQueryRpcV2();
    doThrow(java.util.EmptyStackException.class)
        .when(bigQueryRpcRetryMock)
        .createSkipExceptionTranslation(datasetPb, optionsMap);

    BigQuery bigquery = mockOptions.getService();
    try {
      dataset = bigquery.create(info);
    } catch (BigQueryException e) {
      assertEquals(e.getCause().getClass(), java.util.EmptyStackException.class);
      assertNull(dataset);
    } finally {
      verify(bigQueryRpcRetryMock, times(6)).createSkipExceptionTranslation(datasetPb, optionsMap);
    }

    BigQueryOptions mockOptionsAbort = spy(defaultOptions);
    HttpBigQueryRpc bigQueryRpcAbortMock = mock(HttpBigQueryRpc.class);
    doReturn(bigQueryRpcAbortMock).when(mockOptionsAbort).getBigQueryRpcV2();
    doThrow(RuntimeException.class)
        .when(bigQueryRpcAbortMock)
        .createSkipExceptionTranslation(datasetPb, optionsMap);
    bigquery = mockOptionsAbort.getService();
    try {
      dataset = bigquery.create(info);
    } catch (BigQueryException e) {
      assertEquals(e.getCause().getClass(), RuntimeException.class);
      assertNull(dataset);
    } finally {
      verify(bigQueryRpcAbortMock, times(1)).createSkipExceptionTranslation(datasetPb, optionsMap);
    }
  }
}
