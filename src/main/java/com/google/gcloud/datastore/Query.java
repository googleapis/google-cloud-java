package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;


public abstract class Query<T> extends Serializable<GeneratedMessage> {

  private static final long serialVersionUID = -2748141759901313101L;

  private final String namespace;

  Query(String namespace) {
    this.namespace = namespace;
  }

  public String namespace() {
    return namespace;
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    toStringHelper.add("namespace", namespace);
    toStringHelper.add("queryPb", super.toString());
    return toStringHelper.toString();
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(namespace, bytesPb);
  }

  protected abstract Object fromPb(String namespace, byte[] bytesPb)
      throws InvalidProtocolBufferException;

  protected abstract void populatePb(DatastoreV1.RunQueryRequest.Builder requestPb, int totalRead,
      ByteString batchCursor);
}
