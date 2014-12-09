package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.BLOB_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;

public final class BlobValue extends Value<Blob> {

  private static final long serialVersionUID = -5096238337676649540L;

  static final BaseMarshaller<Blob, BlobValue, Builder> MARSHALLER =
      new BaseMarshaller<Blob, BlobValue, Builder>() {

    @Override
    public int getProtoFieldId() {
      return BLOB_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(Blob value) {
      return builder(value);
    }

    @Override
    protected Blob getValue(DatastoreV1.Value from) {
      return new Blob(from.getBlobValue(), false);
    }

    @Override
    protected void setValue(BlobValue from, DatastoreV1.Value.Builder to) {
      to.setBlobValue(from.get().byteString());
    }
  };

  public static final class Builder extends Value.BaseBuilder<Blob, BlobValue, Builder> {

    private Builder() {
      super(Type.BLOB);
    }

    @Override
    public BlobValue build() {
      return new BlobValue(this);
    }
  }

  public BlobValue(Blob blob) {
    this(builder(blob));
  }

  private BlobValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static Builder builder(Blob blob) {
    return new Builder().set(blob);
  }
}
