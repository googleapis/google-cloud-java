/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.google.gcloud.datastore.DatastoreException.Code;
import com.google.gcloud.spi.DatastoreRpc.DatastoreRpcException;
import com.google.gcloud.spi.DatastoreRpc.DatastoreRpcException.Reason;

import org.junit.Test;

public class DatastoreExceptionTest {

  @Test
  public void testCode() throws Exception {
    for (Reason reason : Reason.values()) {
      Code code = Code.valueOf(reason.name());
      assertEquals(reason.retryable(), code.retryable());
      assertEquals(reason.description(), code.description());
      assertEquals(reason.httpStatus(), code.httpStatus());
    }

    DatastoreException exception = new DatastoreException(Code.ABORTED, "bla");
    assertEquals(Code.ABORTED, exception.code());
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    for (Reason reason : Reason.values()) {
      try {
        DatastoreException.translateAndThrow(new DatastoreRpcException(reason));
        fail("Exception expected");
      } catch (DatastoreException ex) {
        assertEquals(reason.name(), ex.code().name());
      }
    }
  }

  @Test
  public void testThrowInvalidRequest() throws Exception {
    try {
      DatastoreException.throwInvalidRequest("message %s %d", "a", 1);
      fail("Exception expected");
    } catch (DatastoreException ex) {
      assertEquals(Code.FAILED_PRECONDITION, ex.code());
      assertEquals("message a 1", ex.getMessage());
    }
  }
}
