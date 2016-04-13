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

package com.google.gcloud.compute;

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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.compute.Operation.OperationError;
import com.google.gcloud.compute.Operation.OperationWarning;
import com.google.gcloud.compute.Operation.Status;

import org.junit.After;
import org.junit.Test;

import java.util.List;

public class OperationTest {

  private static final OperationError OPERATION_ERROR1 =
      new OperationError("code1", "location1", "message1");
  private static final OperationError OPERATION_ERROR2 =
      new OperationError("code2", "location2", "message2");
  private static final OperationWarning OPERATION_WARNING1 =
      new OperationWarning("code1", "message1", ImmutableMap.of("k1", "v1"));
  private static final OperationWarning OPERATION_WARNING2 =
      new OperationWarning("code2", "location2", ImmutableMap.of("k2", "v2"));
  private static final String ID = "1";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String CLIENT_OPERATION_ID = "clientOperationId";
  private static final String OPERATION_TYPE = "delete";
  private static final String TARGET_LINK = "targetLink";
  private static final String TARGET_ID = "42";
  private static final Status STATUS = Status.DONE;
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

  private final Compute serviceMockReturnsOptions = createStrictMock(Compute.class);
  private final ComputeOptions mockOptions = createMock(ComputeOptions.class);
  private Compute compute;
  private Operation globalOperation;
  private Operation regionOperation;
  private Operation zoneOperation;
  private Operation operation;

  private void initializeExpectedOperation(int optionsCalls) {
    expect(serviceMockReturnsOptions.options()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    globalOperation = new Operation.Builder(serviceMockReturnsOptions)
        .id(ID)
        .operationId(GLOBAL_OPERATION_ID)
        .clientOperationId(CLIENT_OPERATION_ID)
        .operationType(OPERATION_TYPE)
        .targetLink(TARGET_LINK)
        .targetId(TARGET_ID)
        .status(STATUS)
        .statusMessage(STATUS_MESSAGE)
        .user(USER)
        .progress(PROGRESS)
        .insertTime(INSERT_TIME)
        .startTime(START_TIME)
        .endTime(END_TIME)
        .errors(ERRORS)
        .warnings(WARNINGS)
        .httpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .httpErrorMessage(HTTP_ERROR_MESSAGE)
        .description(DESCRIPTION)
        .build();
    zoneOperation = new Operation.Builder(serviceMockReturnsOptions)
        .id(ID)
        .operationId(ZONE_OPERATION_ID)
        .clientOperationId(CLIENT_OPERATION_ID)
        .operationType(OPERATION_TYPE)
        .targetLink(TARGET_LINK)
        .targetId(TARGET_ID)
        .status(STATUS)
        .statusMessage(STATUS_MESSAGE)
        .user(USER)
        .progress(PROGRESS)
        .insertTime(INSERT_TIME)
        .startTime(START_TIME)
        .endTime(END_TIME)
        .errors(ERRORS)
        .warnings(WARNINGS)
        .httpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .httpErrorMessage(HTTP_ERROR_MESSAGE)
        .description(DESCRIPTION)
        .build();
    regionOperation = new Operation.Builder(serviceMockReturnsOptions)
        .id(ID)
        .operationId(REGION_OPERATION_ID)
        .clientOperationId(CLIENT_OPERATION_ID)
        .operationType(OPERATION_TYPE)
        .targetLink(TARGET_LINK)
        .targetId(TARGET_ID)
        .status(STATUS)
        .statusMessage(STATUS_MESSAGE)
        .user(USER)
        .progress(PROGRESS)
        .insertTime(INSERT_TIME)
        .startTime(START_TIME)
        .endTime(END_TIME)
        .errors(ERRORS)
        .warnings(WARNINGS)
        .httpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .httpErrorMessage(HTTP_ERROR_MESSAGE)
        .description(DESCRIPTION)
        .build();
    compute = createStrictMock(Compute.class);
  }

  private void initializeOperation() {
    operation = new Operation.Builder(compute)
        .id(ID)
        .operationId(GLOBAL_OPERATION_ID)
        .clientOperationId(CLIENT_OPERATION_ID)
        .operationType(OPERATION_TYPE)
        .targetLink(TARGET_LINK)
        .targetId(TARGET_ID)
        .status(STATUS)
        .statusMessage(STATUS_MESSAGE)
        .user(USER)
        .progress(PROGRESS)
        .insertTime(INSERT_TIME)
        .startTime(START_TIME)
        .endTime(END_TIME)
        .errors(ERRORS)
        .warnings(WARNINGS)
        .httpErrorStatusCode(HTTP_ERROR_STATUS_CODE)
        .httpErrorMessage(HTTP_ERROR_MESSAGE)
        .description(DESCRIPTION)
        .build();
  }

  @After
  public void tearDown() throws Exception {
    verify(serviceMockReturnsOptions);
  }

  private void assertEqualsCommonFields(Operation operation) {
    assertEquals(ID, operation.id());
    assertEquals(CLIENT_OPERATION_ID, operation.clientOperationId());
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
    assertNull(operation.id());
    assertNull(operation.clientOperationId());
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
    assertEquals(GLOBAL_OPERATION_ID, globalOperation.operationId());
    assertEqualsCommonFields(regionOperation);
    assertEquals(REGION_OPERATION_ID, regionOperation.operationId());
    assertEqualsCommonFields(zoneOperation);
    assertEquals(ZONE_OPERATION_ID, zoneOperation.operationId());
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(GLOBAL_OPERATION_ID)
        .build();
    assertNullCommonFields(operation);
    assertEquals(GLOBAL_OPERATION_ID, operation.operationId());
    operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(ZONE_OPERATION_ID)
        .build();
    assertNullCommonFields(operation);
    assertEquals(ZONE_OPERATION_ID, operation.operationId());
    operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(REGION_OPERATION_ID)
        .build();
    assertNullCommonFields(operation);
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
        .operationId(GLOBAL_OPERATION_ID)
        .build();
    compareOperation(operation, Operation.fromPb(serviceMockReturnsOptions, operation.toPb()));
    operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(ZONE_OPERATION_ID)
        .build();
    compareOperation(operation, Operation.fromPb(serviceMockReturnsOptions, operation.toPb()));
    operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(REGION_OPERATION_ID)
        .build();
    compareOperation(operation, Operation.fromPb(serviceMockReturnsOptions, operation.toPb()));
  }

  @Test
  public void testDeleteTrue() {
    initializeExpectedOperation(3);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.delete(GLOBAL_OPERATION_ID)).andReturn(true);
    replay(compute);
    initializeOperation();
    assertTrue(operation.delete());
    verify(compute);
  }

  @Test
  public void testDeleteFalse() {
    initializeExpectedOperation(3);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.delete(GLOBAL_OPERATION_ID)).andReturn(false);
    replay(compute);
    initializeOperation();
    assertFalse(operation.delete());
    verify(compute);
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedOperation(3);
    Compute.OperationOption[] expectedOptions = {Compute.OperationOption.fields()};
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.get(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(globalOperation);
    replay(compute);
    initializeOperation();
    assertTrue(operation.exists());
    verify(compute);
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedOperation(3);
    Compute.OperationOption[] expectedOptions = {Compute.OperationOption.fields()};
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.get(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(null);
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
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.get(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(globalOperation);
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
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.get(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(
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
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.get(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(null);
    replay(compute);
    initializeOperation();
    assertTrue(operation.isDone());
    verify(compute);
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedOperation(5);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.get(GLOBAL_OPERATION_ID)).andReturn(globalOperation);
    replay(compute);
    initializeOperation();
    Operation updatedOperation = operation.reload();
    compareOperation(globalOperation, updatedOperation);
    verify(compute);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedOperation(3);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.get(GLOBAL_OPERATION_ID)).andReturn(null);
    replay(compute);
    initializeOperation();
    assertNull(operation.reload());
    verify(compute);
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedOperation(5);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.get(GLOBAL_OPERATION_ID, Compute.OperationOption.fields()))
        .andReturn(globalOperation);
    replay(compute);
    initializeOperation();
    Operation updatedOperation = operation.reload(Compute.OperationOption.fields());
    compareOperation(globalOperation, updatedOperation);
    verify(compute);
  }

  private void compareOperation(Operation expected, Operation value) {
    assertEquals(expected, value);
    assertEquals(expected.compute().options(), value.compute().options());
    assertEquals(expected.operationId(), value.operationId());
    assertEquals(expected.clientOperationId(), value.clientOperationId());
    assertEquals(expected.operationType(), value.operationType());
    assertEquals(expected.targetLink(), value.targetLink());
    assertEquals(expected.targetId(), value.targetId());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.statusMessage(), value.statusMessage());
    assertEquals(expected.user(), value.user());
    assertEquals(expected.progress(), value.progress());
    assertEquals(expected.insertTime(), value.insertTime());
    assertEquals(expected.startTime(), value.startTime());
    assertEquals(expected.endTime(), value.endTime());
    assertEquals(expected.errors(), value.errors());
    assertEquals(expected.warnings(), value.warnings());
    assertEquals(expected.httpErrorStatusCode(), value.httpErrorStatusCode());
    assertEquals(expected.httpErrorMessage(), value.httpErrorMessage());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
