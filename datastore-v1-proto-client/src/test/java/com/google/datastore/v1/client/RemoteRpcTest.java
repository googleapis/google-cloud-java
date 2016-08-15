/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.v1.client;

import static org.junit.Assert.assertEquals;

import com.google.api.client.util.Charsets;
import com.google.rpc.Code;
import com.google.rpc.Status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayInputStream;

/**
 * Test for {@link RemoteRpc}.
 */
@RunWith(JUnit4.class)
public class RemoteRpcTest {

  private static final String METHOD_NAME = "methodName";

  @Test
  public void testException() {
    Status statusProto =
        Status.newBuilder()
            .setCode(Code.UNAUTHENTICATED_VALUE)
            .setMessage("The request does not have valid authentication credentials.")
            .build();
    DatastoreException exception = RemoteRpc.makeException("url", METHOD_NAME,
        new ByteArrayInputStream(statusProto.toByteArray()), "application/x-protobuf",
        Charsets.UTF_8, new RuntimeException(), 401);
    assertEquals(Code.UNAUTHENTICATED, exception.getCode());
    assertEquals("The request does not have valid authentication credentials.",
        exception.getMessage());
    assertEquals(METHOD_NAME, exception.getMethodName());
  }

  @Test
  public void testInvalidProtoException() {
    DatastoreException exception = RemoteRpc.makeException("url", METHOD_NAME,
        new ByteArrayInputStream("<invalid proto>".getBytes()), "application/x-protobuf",
        Charsets.UTF_8, new RuntimeException(), 401);
    assertEquals(Code.INTERNAL, exception.getCode());
    assertEquals("Unable to parse Status protocol buffer: HTTP status code was 401.",
        exception.getMessage());
    assertEquals(METHOD_NAME, exception.getMethodName());
  }
  
  @Test
  public void testEmptyProtoException() {
    Status statusProto = Status.newBuilder().build();
    DatastoreException exception = RemoteRpc.makeException("url", METHOD_NAME,
        new ByteArrayInputStream(statusProto.toByteArray()), "application/x-protobuf",
        Charsets.UTF_8, new RuntimeException(), 401);
    assertEquals(Code.INTERNAL, exception.getCode());
    assertEquals("Unexpected OK error code with HTTP status code of 401. Message: .",
        exception.getMessage());
    assertEquals(METHOD_NAME, exception.getMethodName());
  }

  @Test
  public void testPlainTextException() {
    DatastoreException exception = RemoteRpc.makeException("url", METHOD_NAME,
        new ByteArrayInputStream("Text Error".getBytes()), "text/plain", Charsets.UTF_8,
        new RuntimeException(), 401);
    assertEquals(Code.INTERNAL, exception.getCode());
    assertEquals(
        "Non-protobuf error: Text Error. HTTP status code was 401.", exception.getMessage());
    assertEquals(METHOD_NAME, exception.getMethodName());
  }
}
