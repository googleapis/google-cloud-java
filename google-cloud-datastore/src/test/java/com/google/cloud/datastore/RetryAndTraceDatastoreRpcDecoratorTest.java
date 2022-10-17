/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.datastore;

import static com.google.cloud.datastore.TraceUtil.END_SPAN_OPTIONS;
import static com.google.cloud.datastore.TraceUtil.SPAN_NAME_RUN_AGGREGATION_QUERY;
import static com.google.common.truth.Truth.assertThat;
import static com.google.rpc.Code.UNAVAILABLE;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import org.junit.Before;
import org.junit.Test;

public class RetryAndTraceDatastoreRpcDecoratorTest {

  public static final int MAX_ATTEMPTS = 3;
  private DatastoreRpc mockDatastoreRpc;
  private TraceUtil mockTraceUtil;
  private DatastoreOptions datastoreOptions =
      DatastoreOptions.newBuilder().setProjectId("project-id").build();
  private RetrySettings retrySettings =
      RetrySettings.newBuilder().setMaxAttempts(MAX_ATTEMPTS).build();

  private RetryAndTraceDatastoreRpcDecorator datastoreRpcDecorator;

  @Before
  public void setUp() throws Exception {
    mockDatastoreRpc = createStrictMock(DatastoreRpc.class);
    mockTraceUtil = createStrictMock(TraceUtil.class);
    datastoreRpcDecorator =
        new RetryAndTraceDatastoreRpcDecorator(
            mockDatastoreRpc, mockTraceUtil, retrySettings, datastoreOptions);
  }

  @Test
  public void testRunAggregationQuery() {
    Span mockSpan = createStrictMock(Span.class);
    RunAggregationQueryRequest aggregationQueryRequest =
        RunAggregationQueryRequest.getDefaultInstance();
    RunAggregationQueryResponse aggregationQueryResponse =
        RunAggregationQueryResponse.getDefaultInstance();

    expect(mockDatastoreRpc.runAggregationQuery(aggregationQueryRequest))
        .andThrow(
            new DatastoreException(
                UNAVAILABLE.getNumber(), "API not accessible currently", UNAVAILABLE.name()))
        .times(2)
        .andReturn(aggregationQueryResponse);
    expect(mockTraceUtil.startSpan(SPAN_NAME_RUN_AGGREGATION_QUERY)).andReturn(mockSpan);
    expect(mockTraceUtil.getTracer()).andReturn(createNiceMock(Tracer.class));
    mockSpan.end(END_SPAN_OPTIONS);

    replay(mockDatastoreRpc, mockTraceUtil, mockSpan);

    RunAggregationQueryResponse actualAggregationQueryResponse =
        datastoreRpcDecorator.runAggregationQuery(aggregationQueryRequest);

    assertThat(actualAggregationQueryResponse).isSameInstanceAs(aggregationQueryResponse);
    verify(mockDatastoreRpc, mockTraceUtil, mockSpan);
  }
}
