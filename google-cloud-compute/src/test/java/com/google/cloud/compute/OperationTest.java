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

package com.google.cloud.compute;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Clock;
import com.google.cloud.WaitForOption;
import com.google.cloud.compute.Operation.OperationError;
import com.google.cloud.compute.Operation.OperationWarning;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class OperationTest {

  private static final OperationError OPERATION_ERROR1 =
      new OperationError("code1", "location1", "message1");
  private static final OperationError OPERATION_ERROR2 =
      new OperationError("code2", "location2", "message2");
  private static final OperationWarning OPERATION_WARNING1 =
      new OperationWarning("code1", "message1", ImmutableMap.of("k1", "v1"));
  private static final OperationWarning OPERATION_WARNING2 =
      new OperationWarning("code2", "location2", ImmutableMap.of("k2", "v2"));
  private static final String GENERATED_ID = "1";
  private static final String CLIENT_OPERATION_ID = "clientOperationId";
  private static final String OPERATION_TYPE = "delete";
  private static final String TARGET_LINK = "targetLink";
  private static final String TARGET_ID = "42";
  private static final Operation.Status STATUS = Operation.Status.DONE;
  private static final String STATUS_MESSAGE = "statusMessage";
  private static final String USER = "user";
  private static final Integer PROGRESS = 100;
  private static final Long INSERT_TIME = 1453293540000L;
  private static final Long START_TIME = 1453293420000L;
  private static final Long END_TIME = 1453293480000L;
  private static final List<OperationError> ERRORS =
      ImmutableList.of(OPERATION_ERROR1, OPERATION_ERROR2);
  private static final List<OperationWarning> WARNINGS =
      ImmutableList.of(OPERATION_WARNING1, OPERATION_WARNING2);
  private static final Integer HTTP_ERROR_STATUS_CODE = 404;
  private static final String HTTP_ERROR_MESSAGE = "NOT FOUND";
  private static final String DESCRIPTION = "description";
  private static final GlobalOperationId GLOBAL_OPERATION_ID =
      GlobalOperationId.of("project", "op");
  private static final ZoneOperationId ZONE_OPERATION_ID =
      ZoneOperationId.of("project", "zone", "op");
  private static final RegionOperationId REGION_OPERATION_ID =
      RegionOperationId.of("project", "region", "op");

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  private final Compute serviceMockReturnsOptions = createStrictMock(Compute.class);
  private final ComputeOptions mockOptions = createMock(ComputeOptions.class);
  private Compute compute;
  private Operation globalOperation;
  private Operation regionOperation;
  private Operation zoneOperation;
  private Operation operation;

  private void initializeExpectedOperation(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    globalOperation = new Operation.Builder(serviceMockReturnsOptions)
        .getGeneratedId(GENERATED_ID)
        .setOperationId(GLOBAL_OPERATION_ID)
        .setClientOperationId(CLIENT_OPERATION_ID)
        .setOperationType(OPERATION_TYPE)
        .setTargetLink(TARGET_LINK)
        .setTargetId(TARGET_ID)
        .setStatus(STATUS)
        .setStatusMessage(STATUS_MESSAGE)
        .setUser(USER)
        .setProgress(PROGRESS)
        .setInsertTime(INSERT_TIME)
        .setStartTime(START_TIME)
        .setEndTime(END_TIME)
        .setErrors(ERRORS)
        .setWarnings(WARNINGS)
        .setHttpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .setHttpErrorMessage(HTTP_ERROR_MESSAGE)
        .setDescription(DESCRIPTION)
        .build();
    zoneOperation = new Operation.Builder(serviceMockReturnsOptions)
        .getGeneratedId(GENERATED_ID)
        .setOperationId(ZONE_OPERATION_ID)
        .setClientOperationId(CLIENT_OPERATION_ID)
        .setOperationType(OPERATION_TYPE)
        .setTargetLink(TARGET_LINK)
        .setTargetId(TARGET_ID)
        .setStatus(STATUS)
        .setStatusMessage(STATUS_MESSAGE)
        .setUser(USER)
        .setProgress(PROGRESS)
        .setInsertTime(INSERT_TIME)
        .setStartTime(START_TIME)
        .setEndTime(END_TIME)
        .setErrors(ERRORS)
        .setWarnings(WARNINGS)
        .setHttpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .setHttpErrorMessage(HTTP_ERROR_MESSAGE)
        .setDescription(DESCRIPTION)
        .build();
    regionOperation = new Operation.Builder(serviceMockReturnsOptions)
        .getGeneratedId(GENERATED_ID)
        .setOperationId(REGION_OPERATION_ID)
        .setClientOperationId(CLIENT_OPERATION_ID)
        .setOperationType(OPERATION_TYPE)
        .setTargetLink(TARGET_LINK)
        .setTargetId(TARGET_ID)
        .setStatus(STATUS)
        .setStatusMessage(STATUS_MESSAGE)
        .setUser(USER)
        .setProgress(PROGRESS)
        .setInsertTime(INSERT_TIME)
        .setStartTime(START_TIME)
        .setEndTime(END_TIME)
        .setErrors(ERRORS)
        .setWarnings(WARNINGS)
        .setHttpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .setHttpErrorMessage(HTTP_ERROR_MESSAGE)
        .setDescription(DESCRIPTION)
        .build();
    compute = createStrictMock(Compute.class);
  }

  private void initializeOperation() {
    operation = new Operation.Builder(compute)
        .getGeneratedId(GENERATED_ID)
        .setOperationId(GLOBAL_OPERATION_ID)
        .setClientOperationId(CLIENT_OPERATION_ID)
        .setOperationType(OPERATION_TYPE)
        .setTargetLink(TARGET_LINK)
        .setTargetId(TARGET_ID)
        .setStatus(STATUS)
        .setStatusMessage(STATUS_MESSAGE)
        .setUser(USER)
        .setProgress(PROGRESS)
        .setInsertTime(INSERT_TIME)
        .setStartTime(START_TIME)
        .setEndTime(END_TIME)
        .setErrors(ERRORS)
        .setWarnings(WARNINGS)
        .setHttpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .setHttpErrorMessage(HTTP_ERROR_MESSAGE)
        .setDescription(DESCRIPTION)
        .build();
  }

  @After
  public void tearDown() throws Exception {
    verify(serviceMockReturnsOptions);
  }

  private void assertEqualsCommonFields(Operation operation) {
    assertEquals(GENERATED_ID, operation.getGeneratedId());
    assertEquals(CLIENT_OPERATION_ID, operation.getClientOperationId());
    assertEquals(OPERATION_TYPE, operation.getOperationType());
    assertEquals(TARGET_LINK, operation.getTargetLink());
    assertEquals(TARGET_ID, operation.getTargetId());
    assertEquals(STATUS, operation.getStatus());
    assertEquals(STATUS_MESSAGE, operation.getStatusMessage());
    assertEquals(USER, operation.getUser());
    assertEquals(PROGRESS, operation.getProgress());
    assertEquals(INSERT_TIME, operation.getInsertTime());
    assertEquals(START_TIME, operation.getStartTime());
    assertEquals(END_TIME, operation.getEndTime());
    assertEquals(ERRORS, operation.getErrors());
    assertEquals(WARNINGS, operation.getWarnings());
    assertEquals(HTTP_ERROR_STATUS_CODE, globalOperation.getHttpErrorStatusCode());
    assertEquals(HTTP_ERROR_MESSAGE, globalOperation.getHttpErrorMessage());
    assertEquals(DESCRIPTION, globalOperation.getDescription());
    assertSame(serviceMockReturnsOptions, globalOperation.getCompute());
  }

  private void assertEqualsCommonFieldsDeprecated(Operation operation) {
    assertEquals(GENERATED_ID, operation.generatedId());
    assertEquals(CLIENT_OPERATION_ID, operation.getClientOperationId());
    assertEquals(OPERATION_TYPE, operation.operationType());
    assertEquals(TARGET_LINK, operation.targetLink());
    assertEquals(TARGET_ID, operation.targetId());
    assertEquals(STATUS, operation.status());
    assertEquals(STATUS_MESSAGE, operation.statusMessage());
    assertEquals(USER, operation.user());
    assertEquals(PROGRESS, operation.progress());
    assertEquals(INSERT_TIME, operation.insertTime());
    assertEquals(START_TIME, operation.startTime());
    assertEquals(END_TIME, operation.endTime());
    assertEquals(ERRORS, operation.errors());
    assertEquals(WARNINGS, operation.warnings());
    assertEquals(HTTP_ERROR_STATUS_CODE, globalOperation.httpErrorStatusCode());
    assertEquals(HTTP_ERROR_MESSAGE, globalOperation.httpErrorMessage());
    assertEquals(DESCRIPTION, globalOperation.description());
    assertSame(serviceMockReturnsOptions, globalOperation.compute());
  }

  private void assertNullCommonFields(Operation operation) {
    assertNull(operation.getGeneratedId());
    assertNull(operation.getClientOperationId());
    assertNull(operation.getOperationType());
    assertNull(operation.getTargetLink());
    assertNull(operation.getTargetId());
    assertNull(operation.getStatus());
    assertNull(operation.getStatusMessage());
    assertNull(operation.getUser());
    assertNull(operation.getProgress());
    assertNull(operation.getInsertTime());
    assertNull(operation.getStartTime());
    assertNull(operation.getEndTime());
    assertNull(operation.getErrors());
    assertNull(operation.getWarnings());
    assertNull(operation.getHttpErrorStatusCode());
    assertNull(operation.getHttpErrorMessage());
    assertNull(operation.getDescription());
    assertSame(serviceMockReturnsOptions, operation.getCompute());
  }

  private void assertNullCommonFieldsDeprecated(Operation operation) {
    assertNull(operation.generatedId());
    assertNull(operation.getClientOperationId());
    assertNull(operation.operationType());
    assertNull(operation.targetLink());
    assertNull(operation.targetId());
    assertNull(operation.status());
    assertNull(operation.statusMessage());
    assertNull(operation.user());
    assertNull(operation.progress());
    assertNull(operation.insertTime());
    assertNull(operation.startTime());
    assertNull(operation.endTime());
    assertNull(operation.errors());
    assertNull(operation.warnings());
    assertNull(operation.httpErrorStatusCode());
    assertNull(operation.httpErrorMessage());
    assertNull(operation.description());
    assertSame(serviceMockReturnsOptions, operation.compute());
  }

  @Test
  public void testBuilder() {
    initializeExpectedOperation(6);
    assertEqualsCommonFields(globalOperation);
    assertEquals(GLOBAL_OPERATION_ID, globalOperation.getOperationId());
    assertEqualsCommonFields(regionOperation);
    assertEquals(REGION_OPERATION_ID, regionOperation.getOperationId());
    assertEqualsCommonFields(zoneOperation);
    assertEquals(ZONE_OPERATION_ID, zoneOperation.getOperationId());
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(GLOBAL_OPERATION_ID)
        .build();
    assertNullCommonFields(operation);
    assertEquals(GLOBAL_OPERATION_ID, operation.getOperationId());
    operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZONE_OPERATION_ID)
        .build();
    assertNullCommonFields(operation);
    assertEquals(ZONE_OPERATION_ID, operation.getOperationId());
    operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(REGION_OPERATION_ID)
        .build();
    assertNullCommonFields(operation);
    assertEquals(REGION_OPERATION_ID, operation.getOperationId());
  }

  @Test
  public void testBuilderDeprecated() {
    initializeExpectedOperation(6);
    assertEqualsCommonFieldsDeprecated(globalOperation);
    assertEquals(GLOBAL_OPERATION_ID, globalOperation.operationId());
    assertEqualsCommonFieldsDeprecated(regionOperation);
    assertEquals(REGION_OPERATION_ID, regionOperation.operationId());
    assertEqualsCommonFieldsDeprecated(zoneOperation);
    assertEquals(ZONE_OPERATION_ID, zoneOperation.operationId());
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(GLOBAL_OPERATION_ID)
        .build();
    assertNullCommonFieldsDeprecated(operation);
    assertEquals(GLOBAL_OPERATION_ID, operation.operationId());
    operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZONE_OPERATION_ID)
        .build();
    assertNullCommonFieldsDeprecated(operation);
    assertEquals(ZONE_OPERATION_ID, operation.operationId());
    operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(REGION_OPERATION_ID)
        .build();
    assertNullCommonFieldsDeprecated(operation);
    assertEquals(REGION_OPERATION_ID, operation.operationId());
  }

  @Test
  public void testToAndFromPb() {
    initializeExpectedOperation(24);
    compareOperation(globalOperation,
        Operation.fromPb(serviceMockReturnsOptions, globalOperation.toPb()));
    assertNotNull(regionOperation.toPb().getRegion());
    compareOperation(regionOperation,
        Operation.fromPb(serviceMockReturnsOptions, regionOperation.toPb()));
    assertNotNull(zoneOperation.toPb().getZone());
    compareOperation(zoneOperation,
        Operation.fromPb(serviceMockReturnsOptions, zoneOperation.toPb()));
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(GLOBAL_OPERATION_ID)
        .build();
    compareOperation(operation, Operation.fromPb(serviceMockReturnsOptions, operation.toPb()));
    operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(ZONE_OPERATION_ID)
        .build();
    compareOperation(operation, Operation.fromPb(serviceMockReturnsOptions, operation.toPb()));
    operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(REGION_OPERATION_ID)
        .build();
    compareOperation(operation, Operation.fromPb(serviceMockReturnsOptions, operation.toPb()));
  }

  @Test
  public void testDeleteTrue() {
    initializeExpectedOperation(3);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.deleteOperation(GLOBAL_OPERATION_ID)).andReturn(true);
    replay(compute);
    initializeOperation();
    assertTrue(operation.delete());
    verify(compute);
  }

  @Test
  public void testDeleteFalse() {
    initializeExpectedOperation(3);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.deleteOperation(GLOBAL_OPERATION_ID)).andReturn(false);
    replay(compute);
    initializeOperation();
    assertFalse(operation.delete());
    verify(compute);
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedOperation(3);
    Compute.OperationOption[] expectedOptions = {Compute.OperationOption.fields()};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getOperation(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(globalOperation);
    replay(compute);
    initializeOperation();
    assertTrue(operation.exists());
    verify(compute);
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedOperation(3);
    Compute.OperationOption[] expectedOptions = {Compute.OperationOption.fields()};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getOperation(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(null);
    replay(compute);
    initializeOperation();
    assertFalse(operation.exists());
    verify(compute);
  }

  @Test
  public void testIsDone_True() throws Exception {
    initializeExpectedOperation(3);
    Compute.OperationOption[] expectedOptions =
        {Compute.OperationOption.fields(Compute.OperationField.STATUS)};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getOperation(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(globalOperation);
    replay(compute);
    initializeOperation();
    assertTrue(operation.isDone());
    verify(compute);
  }

  @Test
  public void testIsDone_False() throws Exception {
    initializeExpectedOperation(4);
    Compute.OperationOption[] expectedOptions =
        {Compute.OperationOption.fields(Compute.OperationField.STATUS)};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getOperation(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(
        Operation.fromPb(serviceMockReturnsOptions, globalOperation.toPb().setStatus("PENDING")));
    replay(compute);
    initializeOperation();
    assertFalse(operation.isDone());
    verify(compute);
  }
  @Test
  public void testIsDone_NotExists() throws Exception {
    initializeExpectedOperation(3);
    Compute.OperationOption[] expectedOptions =
        {Compute.OperationOption.fields(Compute.OperationField.STATUS)};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getOperation(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(null);
    replay(compute);
    initializeOperation();
    assertTrue(operation.isDone());
    verify(compute);
  }

  @Test
  public void testWaitFor() throws InterruptedException, TimeoutException {
    initializeExpectedOperation(4);
    Compute.OperationOption[] expectedOptions =
        {Compute.OperationOption.fields(Compute.OperationField.STATUS)};
    Operation successOperation =
        Operation.fromPb(serviceMockReturnsOptions, globalOperation.toPb().setError(null));
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(mockOptions.getClock()).andReturn(Clock.defaultClock());
    expect(compute.getOperation(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(successOperation);
    expect(compute.getOperation(GLOBAL_OPERATION_ID)).andReturn(successOperation);
    replay(compute, mockOptions);
    initializeOperation();
    assertSame(successOperation, operation.waitFor());
    verify(mockOptions);
  }

  @Test
  public void testWaitFor_Null() throws InterruptedException, TimeoutException {
    initializeExpectedOperation(3);
    Compute.OperationOption[] expectedOptions =
        {Compute.OperationOption.fields(Compute.OperationField.STATUS)};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(mockOptions.getClock()).andReturn(Clock.defaultClock());
    expect(compute.getOperation(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(null);
    expect(compute.getOperation(GLOBAL_OPERATION_ID)).andReturn(null);
    replay(compute, mockOptions);
    initializeOperation();
    assertNull(operation.waitFor());
    verify(mockOptions);
  }

  @Test
  public void testWaitForCheckingPeriod() throws InterruptedException, TimeoutException {
    initializeExpectedOperation(5);
    Compute.OperationOption[] expectedOptions =
        {Compute.OperationOption.fields(Compute.OperationField.STATUS)};
    TimeUnit timeUnit = createStrictMock(TimeUnit.class);
    timeUnit.sleep(42);
    EasyMock.expectLastCall();
    Operation runningOperation = Operation.fromPb(serviceMockReturnsOptions,
        globalOperation.toPb().setError(null).setStatus("RUNNING"));
    Operation completedOperation =
        Operation.fromPb(serviceMockReturnsOptions, globalOperation.toPb().setError(null));
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(mockOptions.getClock()).andReturn(Clock.defaultClock());
    expect(compute.getOperation(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(runningOperation);
    expect(compute.getOperation(GLOBAL_OPERATION_ID, expectedOptions))
        .andReturn(completedOperation);
    expect(compute.getOperation(GLOBAL_OPERATION_ID)).andReturn(completedOperation);
    replay(compute, timeUnit, mockOptions);
    initializeOperation();
    assertSame(completedOperation, operation.waitFor(WaitForOption.checkEvery(42, timeUnit)));
    verify(timeUnit, mockOptions);
  }

  @Test
  public void testWaitForCheckingPeriod_Null() throws InterruptedException, TimeoutException {
    initializeExpectedOperation(4);
    Compute.OperationOption[] expectedOptions =
        {Compute.OperationOption.fields(Compute.OperationField.STATUS)};
    TimeUnit timeUnit = createStrictMock(TimeUnit.class);
    timeUnit.sleep(42);
    EasyMock.expectLastCall();
    Operation runningOperation = Operation.fromPb(serviceMockReturnsOptions,
        globalOperation.toPb().setError(null).setStatus("RUNNING"));
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(mockOptions.getClock()).andReturn(Clock.defaultClock());
    expect(compute.getOperation(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(runningOperation);
    expect(compute.getOperation(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(null);
    expect(compute.getOperation(GLOBAL_OPERATION_ID)).andReturn(null);
    replay(compute, timeUnit, mockOptions);
    initializeOperation();
    assertNull(operation.waitFor(WaitForOption.checkEvery(42, timeUnit)));
    verify(compute, timeUnit, mockOptions);
  }

  @Test
  public void testWaitForWithTimeout() throws InterruptedException, TimeoutException {
    initializeExpectedOperation(4);
    Compute.OperationOption[] expectedOptions =
        {Compute.OperationOption.fields(Compute.OperationField.STATUS)};
    TimeUnit timeUnit = createStrictMock(TimeUnit.class);
    timeUnit.sleep(1);
    EasyMock.expectLastCall();
    Clock clock = createStrictMock(Clock.class);
    expect(clock.millis()).andReturn(0L);
    expect(clock.millis()).andReturn(1L);
    expect(clock.millis()).andReturn(3L);
    Operation runningOperation = Operation.fromPb(serviceMockReturnsOptions,
        globalOperation.toPb().setError(null).setStatus("RUNNING"));
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(mockOptions.getClock()).andReturn(clock);
    expect(compute.getOperation(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(runningOperation);
    expect(compute.getOperation(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(runningOperation);
    replay(compute, timeUnit, clock, mockOptions);
    initializeOperation();
    thrown.expect(TimeoutException.class);
    operation.waitFor(WaitForOption.checkEvery(1, timeUnit),
        WaitForOption.timeout(3, TimeUnit.MILLISECONDS));
    verify(compute, timeUnit, clock, mockOptions);
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedOperation(5);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getOperation(GLOBAL_OPERATION_ID)).andReturn(globalOperation);
    replay(compute);
    initializeOperation();
    Operation updatedOperation = operation.reload();
    compareOperation(globalOperation, updatedOperation);
    verify(compute);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedOperation(3);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getOperation(GLOBAL_OPERATION_ID)).andReturn(null);
    replay(compute);
    initializeOperation();
    assertNull(operation.reload());
    verify(compute);
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedOperation(5);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getOperation(GLOBAL_OPERATION_ID, Compute.OperationOption.fields()))
        .andReturn(globalOperation);
    replay(compute);
    initializeOperation();
    Operation updatedOperation = operation.reload(Compute.OperationOption.fields());
    compareOperation(globalOperation, updatedOperation);
    verify(compute);
  }

  private void compareOperation(Operation expected, Operation value) {
    assertEquals(expected, value);
    assertEquals(expected.getCompute().getOptions(), value.getCompute().getOptions());
    assertEquals(expected.getOperationId(), value.getOperationId());
    assertEquals(expected.getClientOperationId(), value.getClientOperationId());
    assertEquals(expected.getOperationType(), value.getOperationType());
    assertEquals(expected.getTargetLink(), value.getTargetLink());
    assertEquals(expected.getTargetId(), value.getTargetId());
    assertEquals(expected.getStatus(), value.getStatus());
    assertEquals(expected.getStatusMessage(), value.getStatusMessage());
    assertEquals(expected.getUser(), value.getUser());
    assertEquals(expected.getProgress(), value.getProgress());
    assertEquals(expected.getInsertTime(), value.getInsertTime());
    assertEquals(expected.getStartTime(), value.getStartTime());
    assertEquals(expected.getEndTime(), value.getEndTime());
    assertEquals(expected.getErrors(), value.getErrors());
    assertEquals(expected.getWarnings(), value.getWarnings());
    assertEquals(expected.getHttpErrorStatusCode(), value.getHttpErrorStatusCode());
    assertEquals(expected.getHttpErrorMessage(), value.getHttpErrorMessage());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
