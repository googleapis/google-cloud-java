package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

final class StructuredQuery<T> extends Query<T> {

  private static final long serialVersionUID = 546838955624019594L;


  static class BaseBuilder<T, B extends BaseBuilder<T, B>> {

    private String kind;
    private String namespace;
    private Cursor startCursor;
    private Cursor endCursor;
    private Integer offset;
    private Integer limit;


    protected B self() {
      return (B) this;
    }

    public B kind(String kind) {
      this.kind = kind;
      return self();
    }

    public B namespace(String namespace) {
      this.namespace = namespace;
      return self();
    }

    public B startCursor(Cursor startCursor) {
      this.startCursor = startCursor;
      return self();
    }

    public B encCursor(Cursor endCursor) {
      this.endCursor = endCursor;
      return self();
    }

    public B offset(int offset) {
      this.offset = offset;
      return self();
    }

    public B limit(int limit) {
      this.limit = limit;
      return self();
    }
  }

  public static final class FullBuilder extends BaseBuilder<Entity, FullBuilder> {

  }

  public static final class KeyOnlyBuilder extends BaseBuilder<Key, KeyOnlyBuilder> {

  }

  public static final class ProjectionBuilder
      extends BaseBuilder<PartialEntity, ProjectionBuilder> {

  }

  private StructuredQuery(ResultType<T> resultType, String namespace) {
    super(resultType, namespace);
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
  protected Object fromPb(ResultType<T> resultType, String namespace, byte[] bytesPb)
      throws InvalidProtocolBufferException {
    return fromPb(resultType, namespace, DatastoreV1.Query.parseFrom(bytesPb));
  }

  @Override
  protected DatastoreV1.Query toPb() {
    // TODO Auto-generated method stub
    return null;
  }

  static <T> StructuredQuery<T> fromPb(ResultType<T> resultType, String namespace,
      DatastoreV1.Query queryPb) {
    return null;
  }
}
