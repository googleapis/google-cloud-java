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

package com.google.gcloud;

import static com.google.common.base.MoreObjects.firstNonNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Base class for serialization tests. To use this class in your tests override the
 * {@code serializableObjects()} method to return all objects that must be serializable. Also
 * override {@code restorableObjects()} method to return all restorable objects whose state must be
 * tested for proper serialization. Both methods can return {@code null} if no such object needs to
 * be tested.
 */
public abstract class BaseSerializationTest {

  /**
   * Returns all objects for which correct serialization must be tested.
   */
  protected abstract Serializable[] serializableObjects();

  /**
   * Returns all restorable objects whose state must be tested for proper serialization.
   */
  protected abstract Restorable<?>[] restorableObjects();

  @Test
  public void testSerializableObjects() throws Exception {
    for (Serializable obj : firstNonNull(serializableObjects(), new Serializable[0])) {
      Object copy = serializeAndDeserialize(obj);
      assertEquals(obj, obj);
      assertEquals(obj, copy);
      assertEquals(obj.hashCode(), copy.hashCode());
      assertEquals(obj.toString(), copy.toString());
      assertNotSame(obj, copy);
      assertEquals(copy, copy);
    }
  }

  @Test
  public void testRestorableObjects() throws Exception {
    for (Restorable restorable : firstNonNull(restorableObjects(), new Restorable[0])) {
      RestorableState<?> state = restorable.capture();
      RestorableState<?> deserializedState = serializeAndDeserialize(state);
      assertEquals(state, deserializedState);
      assertEquals(state.hashCode(), deserializedState.hashCode());
      assertEquals(state.toString(), deserializedState.toString());
    }
  }

  @SuppressWarnings("unchecked")
  public <T> T serializeAndDeserialize(T obj) throws IOException, ClassNotFoundException {
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
