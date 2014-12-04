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
  public int hashCode() {
    return toPb().hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!getClass().isInstance(obj)) {
      return false;
    }
    return toPb().equals(((Serializable<?>) obj).toPb());
  }

  @Override
  public String toString() {
    return toPb().toString();
  }

  private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
    out.writeObject(toPb().toByteArray());
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    bytesPb = (byte[]) in.readObject();
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
