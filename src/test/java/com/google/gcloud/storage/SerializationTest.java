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

package com.google.gcloud.storage;

import static org.junit.Assert.assertEquals;

import com.google.gcloud.AuthCredentials;
import com.google.gcloud.RetryParams;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTest {


  @Test
  public void testServiceOptions() throws Exception {
    StorageServiceOptions options = StorageServiceOptions.builder()
        .project("p1")
        .authCredentials(AuthCredentials.createForAppEngine())
        .build();
    StorageServiceOptions serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);

    options = options.toBuilder()
        .project("p2")
        .retryParams(RetryParams.getDefaultInstance())
        .authCredentials(AuthCredentials.noCredentials())
        .pathDelimiter(":")
        .build();
    serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);
  }

  @Test
  public void testTypes() throws Exception {
    // todo: implement
  }

  @SuppressWarnings("unchecked")
  private <T extends java.io.Serializable> T serializeAndDeserialize(T obj)
      throws IOException, ClassNotFoundException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
      output.writeObject(obj);
    }
    try (ObjectInputStream input =
        new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
      return (T) input.readObject();
    }
  }
}
