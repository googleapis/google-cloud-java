package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.gcloud.datastore.DatastoreServiceException.Code;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

public final class StructuredQuery<T> extends Query<T> {

  private static final long serialVersionUID = 546838955624019594L;


  static class BaseBuilder<T> {
    // TODO: impelement and have sub-classes for keys-only, entity and projection
  }

  private StructuredQuery(String namespace) {
    super(namespace);
  }

  @Override
  public int hashCode() {
    // implement
    return 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    // implement
    return false;
  }

  @Override
  protected void populatePb(DatastoreV1.RunQueryRequest.Builder requestPb, int totalRead,
      ByteString batchCursor) {
    if (batchCursor == null) {
      requestPb.setQuery(toPb());
      return;
    }
    throw new UnsupportedOperationException("paging not implemented yet");
  }

  @Override
  protected Object fromPb(String namespace, byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(namespace, DatastoreV1.Query.parseFrom(bytesPb));
  }

  @Override
  protected DatastoreV1.Query toPb() {
    // TODO Auto-generated method stub
    return null;
  }

  static StructuredQuery<?> fromPb(String namespace, DatastoreV1.Query queryPb) {
    return null;
  }

  static DatastoreV1.Query nextQuery(DatastoreV1.Query query, ByteString cursor) {
    // see b/18705483
    throw new DatastoreServiceException(Code.INTERNAL, "paging for gql results is not implemented");
  }
}
