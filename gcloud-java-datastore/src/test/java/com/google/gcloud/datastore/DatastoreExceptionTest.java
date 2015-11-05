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

import com.google.gcloud.datastore.DatastoreException.DatastoreError;
import com.google.gcloud.spi.DatastoreRpc.DatastoreRpcException;
import com.google.gcloud.spi.DatastoreRpc.DatastoreRpcException.Reason;

import org.junit.Test;

public class DatastoreExceptionTest {

  @Test
  public void testDatastoreError() throws Exception {
    for (Reason reason : Reason.values()) {
      DatastoreError error = DatastoreError.valueOf(reason.name());
      assertEquals(reason.retryable(), error.retryable());
      assertEquals(reason.description(), error.description());
      assertEquals(reason.httpStatus(), error.httpStatus());
    }

    DatastoreException exception = new DatastoreException(DatastoreError.ABORTED, "bla");
    assertEquals(DatastoreError.ABORTED, exception.datastoreError());
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    for (Reason reason : Reason.values()) {
      try {
        DatastoreException.translateAndThrow(new DatastoreRpcException(reason));
        fail("Exception expected");
      } catch (DatastoreException ex) {
        assertEquals(reason.name(), ex.datastoreError().name());
      }
    }
  }

  @Test
  public void testThrowInvalidRequest() throws Exception {
    try {
      DatastoreException.throwInvalidRequest("message %s %d", "a", 1);
      fail("Exception expected");
    } catch (DatastoreException ex) {
      assertEquals(DatastoreError.FAILED_PRECONDITION, ex.datastoreError());
      assertEquals("message a 1", ex.getMessage());
    }
  }
}
