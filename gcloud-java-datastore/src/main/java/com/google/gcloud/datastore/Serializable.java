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

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.StreamCorruptedException;

abstract class Serializable<M extends GeneratedMessage> implements java.io.Serializable {

  private static final long serialVersionUID = -5565522710061949199L;

  private transient byte[] bytesPb; // only for deserialization

  @Override
  public String toString() {
    return toPb().toString();
  }

  private void writeObject(ObjectOutputStream output) throws IOException {
    output.defaultWriteObject();
    output.writeObject(toPb().toByteArray());
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    bytesPb = (byte[]) input.readObject();
  }

  protected Object readResolve() throws ObjectStreamException {
    try {
      return fromPb(bytesPb);
    } catch (InvalidProtocolBufferException ex) {
      StreamCorruptedException sce = new StreamCorruptedException("Failed to create object");
      sce.initCause(ex);
      throw sce;
    } finally {
      bytesPb = null;
    }
  }

  protected abstract M toPb();

  protected abstract Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException;
}
