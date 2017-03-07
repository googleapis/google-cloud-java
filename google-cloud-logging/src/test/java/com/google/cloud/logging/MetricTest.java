/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.logging;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.core.ApiFutures;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Test;

public class MetricTest {

  private static final String NAME = "name";
  private static final String FILTER = "logName=projects/my-projectid/logs/syslog";
  private static final String DESCRIPTION = "description";
  private static final String NEW_NAME = "newName";
  private static final String NEW_FILTER = "logName=projects/my-projectid/logs/newSyslog";
  private static final String NEW_DESCRIPTION = "newDescription";
  private static final MetricInfo METRIC_INFO = MetricInfo.newBuilder(NAME, FILTER)
      .setDescription(DESCRIPTION)
      .build();
  private final Logging serviceMockReturnsOptions = createStrictMock(Logging.class);
  private final LoggingOptions mockOptions = createMock(LoggingOptions.class);
  private Logging logging;
  private Metric expectedMetric;
  private Metric metric;

  private void initializeExpectedMetric(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    logging = createStrictMock(Logging.class);
    expectedMetric = new Metric(serviceMockReturnsOptions, new Metric.BuilderImpl(METRIC_INFO));
  }

  private void initializeMetric() {
    metric = new Metric(logging, new Metric.BuilderImpl(METRIC_INFO));
  }

  @After
  public void tearDown() throws Exception {
    verify(logging, serviceMockReturnsOptions);
  }

  @Test
  public void testBuilder() {
    initializeExpectedMetric(2);
    replay(logging);
    Metric builtMetric = expectedMetric.toBuilder()
        .setName(NEW_NAME)
        .setFilter(NEW_FILTER)
        .setDescription(NEW_DESCRIPTION)
        .build();
    assertEquals(NEW_NAME, builtMetric.getName());
    assertEquals(NEW_DESCRIPTION, builtMetric.getDescription());
    assertEquals(NEW_FILTER, builtMetric.getFilter());
    assertSame(serviceMockReturnsOptions, builtMetric.getLogging());
  }


  @Test
  public void testToBuilder() {
    initializeExpectedMetric(2);
    replay(logging);
    compareMetric(expectedMetric, expectedMetric.toBuilder().build());
  }

  @Test
  public void testReload() {
    initializeExpectedMetric(2);
    MetricInfo updatedInfo = METRIC_INFO.toBuilder().setFilter(NEW_FILTER).build();
    Metric expectedMetric =
        new Metric(serviceMockReturnsOptions, new MetricInfo.BuilderImpl(updatedInfo));
    expect(logging.getOptions()).andReturn(mockOptions);
    expect(logging.getMetric(NAME)).andReturn(expectedMetric);
    replay(logging);
    initializeMetric();
    Metric updatedMetric = metric.reload();
    compareMetric(expectedMetric, updatedMetric);
  }

  @Test
  public void testReloadNull() {
    initializeExpectedMetric(1);
    expect(logging.getOptions()).andReturn(mockOptions);
    expect(logging.getMetric(NAME)).andReturn(null);
    replay(logging);
    initializeMetric();
    assertNull(metric.reload());
  }

  @Test
  public void testReloadAsync() throws ExecutionException, InterruptedException {
    initializeExpectedMetric(2);
    MetricInfo updatedInfo = METRIC_INFO.toBuilder().setFilter(NEW_FILTER).build();
    Metric expectedMetric = new Metric(serviceMockReturnsOptions, new MetricInfo.BuilderImpl(updatedInfo));
    expect(logging.getOptions()).andReturn(mockOptions);
    expect(logging.getMetricAsync(NAME))
        .andReturn(ApiFutures.immediateFuture(expectedMetric));
    replay(logging);
    initializeMetric();
    Metric updatedMetric = metric.reloadAsync().get();
    compareMetric(expectedMetric, updatedMetric);
  }

  @Test
  public void testReloadAsyncNull() throws ExecutionException, InterruptedException {
    initializeExpectedMetric(1);
    expect(logging.getOptions()).andReturn(mockOptions);
    expect(logging.getMetricAsync(NAME)).andReturn(ApiFutures.<Metric>immediateFuture(null));
    replay(logging);
    initializeMetric();
    assertNull(metric.reloadAsync().get());
  }

  @Test
  public void testUpdate() {
    initializeExpectedMetric(2);
    MetricInfo updatedInfo = METRIC_INFO.toBuilder().setFilter(NEW_FILTER).build();
    Metric expectedMetric =
        new Metric(serviceMockReturnsOptions, new MetricInfo.BuilderImpl(updatedInfo));
    expect(logging.getOptions()).andReturn(mockOptions).times(2);
    expect(logging.update(expectedMetric)).andReturn(expectedMetric);
    replay(logging);
    initializeMetric();
    Metric updatedMetric = metric.toBuilder().setFilter(NEW_FILTER).build().update();
    compareMetric(expectedMetric, updatedMetric);
  }

  @Test
  public void testUpdateAsync() throws ExecutionException, InterruptedException {
    initializeExpectedMetric(2);
    MetricInfo updatedInfo = METRIC_INFO.toBuilder().setFilter(NEW_FILTER).build();
    Metric expectedMetric =
        new Metric(serviceMockReturnsOptions, new MetricInfo.BuilderImpl(updatedInfo));
    expect(logging.getOptions()).andReturn(mockOptions).times(2);
    expect(logging.updateAsync(expectedMetric)).andReturn(ApiFutures.immediateFuture(expectedMetric));
    replay(logging);
    initializeMetric();
    Metric updatedMetric = metric.toBuilder().setFilter(NEW_FILTER).build().updateAsync().get();
    compareMetric(expectedMetric, updatedMetric);
  }

  @Test
  public void testDeleteTrue() {
    initializeExpectedMetric(1);
    expect(logging.getOptions()).andReturn(mockOptions);
    expect(logging.deleteMetric(NAME)).andReturn(true);
    replay(logging);
    initializeMetric();
    assertTrue(metric.delete());
  }

  @Test
  public void testDeleteFalse() {
    initializeExpectedMetric(1);
    expect(logging.getOptions()).andReturn(mockOptions);
    expect(logging.deleteMetric(NAME)).andReturn(false);
    replay(logging);
    initializeMetric();
    assertFalse(metric.delete());
  }

  @Test
  public void testDeleteAsyncTrue() throws ExecutionException, InterruptedException {
    initializeExpectedMetric(1);
    expect(logging.getOptions()).andReturn(mockOptions);
    expect(logging.deleteMetricAsync(NAME)).andReturn(ApiFutures.immediateFuture(true));
    replay(logging);
    initializeMetric();
    assertTrue(metric.deleteAsync().get());
  }

  @Test
  public void testDeleteAsyncFalse() throws ExecutionException, InterruptedException {
    initializeExpectedMetric(1);
    expect(logging.getOptions()).andReturn(mockOptions);
    expect(logging.deleteMetricAsync(NAME)).andReturn(ApiFutures.immediateFuture(false));
    replay(logging);
    initializeMetric();
    assertFalse(metric.deleteAsync().get());
  }

  private void compareMetric(Metric expected, Metric value) {
    assertEquals(expected, value);
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getFilter(), value.getFilter());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
