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
import com.google.gcloud.compute.Operation.Status;
import com.google.gcloud.compute.Operation.OperationWarning;

import org.junit.After;
import org.junit.Test;

import java.math.BigInteger;
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

  private Compute serviceMockReturnsOptions = createStrictMock(Compute.class);
  private ComputeOptions mockOptions = createMock(ComputeOptions.class);
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
        .creationTimestamp(CREATION_TIMESTAMP)
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
        .creationTimestamp(CREATION_TIMESTAMP)
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
        .creationTimestamp(CREATION_TIMESTAMP)
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
        .creationTimestamp(CREATION_TIMESTAMP)
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

  @Test
  public void testBuilder() {
    initializeExpectedOperation(6);
    assertEquals(CREATION_TIMESTAMP, globalOperation.creationTimestamp());
    assertEquals(ID, globalOperation.id());
    assertEquals(GLOBAL_OPERATION_ID, globalOperation.operationId());
    assertEquals(CLIENT_OPERATION_ID, globalOperation.clientOperationId());
    assertEquals(OPERATION_TYPE, globalOperation.operationType());
    assertEquals(TARGET_LINK, globalOperation.targetLink());
    assertEquals(TARGET_ID, globalOperation.targetId());
    assertEquals(STATUS, globalOperation.status());
    assertEquals(STATUS_MESSAGE, globalOperation.statusMessage());
    assertEquals(USER, globalOperation.user());
    assertEquals(PROGRESS, globalOperation.progress());
    assertEquals(INSERT_TIME, globalOperation.insertTime());
    assertEquals(START_TIME, globalOperation.startTime());
    assertEquals(END_TIME, globalOperation.endTime());
    assertEquals(ERRORS, globalOperation.errors());
    assertEquals(WARNINGS, globalOperation.warnings());
    assertEquals(HTTP_ERROR_STATUS_CODE, globalOperation.httpErrorStatusCode());
    assertEquals(HTTP_ERROR_MESSAGE, globalOperation.httpErrorMessage());
    assertEquals(DESCRIPTION, globalOperation.description());
    assertSame(serviceMockReturnsOptions, globalOperation.compute());
    assertEquals(ID, regionOperation.id());
    assertEquals(CREATION_TIMESTAMP, regionOperation.creationTimestamp());
    assertEquals(REGION_OPERATION_ID, regionOperation.operationId());
    assertEquals(CLIENT_OPERATION_ID, regionOperation.clientOperationId());
    assertEquals(OPERATION_TYPE, regionOperation.operationType());
    assertEquals(TARGET_LINK, regionOperation.targetLink());
    assertEquals(TARGET_ID, regionOperation.targetId());
    assertEquals(STATUS, regionOperation.status());
    assertEquals(STATUS_MESSAGE, regionOperation.statusMessage());
    assertEquals(USER, regionOperation.user());
    assertEquals(PROGRESS, regionOperation.progress());
    assertEquals(INSERT_TIME, regionOperation.insertTime());
    assertEquals(START_TIME, regionOperation.startTime());
    assertEquals(END_TIME, regionOperation.endTime());
    assertEquals(ERRORS, regionOperation.errors());
    assertEquals(WARNINGS, regionOperation.warnings());
    assertEquals(HTTP_ERROR_STATUS_CODE, regionOperation.httpErrorStatusCode());
    assertEquals(HTTP_ERROR_MESSAGE, regionOperation.httpErrorMessage());
    assertEquals(DESCRIPTION, regionOperation.description());
    assertSame(serviceMockReturnsOptions, regionOperation.compute());
    assertEquals(ID, zoneOperation.id());
    assertEquals(CREATION_TIMESTAMP, zoneOperation.creationTimestamp());
    assertEquals(ZONE_OPERATION_ID, zoneOperation.operationId());
    assertEquals(CLIENT_OPERATION_ID, zoneOperation.clientOperationId());
    assertEquals(OPERATION_TYPE, zoneOperation.operationType());
    assertEquals(TARGET_LINK, zoneOperation.targetLink());
    assertEquals(TARGET_ID, zoneOperation.targetId());
    assertEquals(STATUS, zoneOperation.status());
    assertEquals(STATUS_MESSAGE, zoneOperation.statusMessage());
    assertEquals(USER, zoneOperation.user());
    assertEquals(PROGRESS, zoneOperation.progress());
    assertEquals(INSERT_TIME, zoneOperation.insertTime());
    assertEquals(START_TIME, zoneOperation.startTime());
    assertEquals(END_TIME, zoneOperation.endTime());
    assertEquals(ERRORS, zoneOperation.errors());
    assertEquals(WARNINGS, zoneOperation.warnings());
    assertEquals(HTTP_ERROR_STATUS_CODE, zoneOperation.httpErrorStatusCode());
    assertEquals(HTTP_ERROR_MESSAGE, zoneOperation.httpErrorMessage());
    assertEquals(DESCRIPTION, zoneOperation.description());
    assertSame(serviceMockReturnsOptions, zoneOperation.compute());
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(GLOBAL_OPERATION_ID)
        .build();
    assertEquals(GLOBAL_OPERATION_ID, operation.operationId());
    assertSame(serviceMockReturnsOptions, operation.compute());
    assertNull(operation.creationTimestamp());
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
    operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(ZONE_OPERATION_ID)
        .build();
    assertSame(serviceMockReturnsOptions, operation.compute());
    assertEquals(ZONE_OPERATION_ID, operation.operationId());
    assertNull(operation.creationTimestamp());
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
    operation = new Operation.Builder(serviceMockReturnsOptions)
        .operationId(REGION_OPERATION_ID)
        .build();
    assertSame(serviceMockReturnsOptions, operation.compute());
    assertEquals(REGION_OPERATION_ID, operation.operationId());
    assertNull(operation.creationTimestamp());
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
    expect(compute.get(GLOBAL_OPERATION_ID, expectedOptions)).andReturn(globalOperation);
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
    assertEquals(expected.creationTimestamp(), value.creationTimestamp());
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
