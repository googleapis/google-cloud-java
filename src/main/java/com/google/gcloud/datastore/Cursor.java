package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.api.services.datastore.DatastoreV1;
import com.google.api.services.datastore.DatastoreV1.Value;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * A Google Cloud Datastore cursor.
 * The cursor can be used to as a starting point or an ending point for a {@link Query}
 */
public final class Cursor extends Serializable<DatastoreV1.Value> {

  private static final long serialVersionUID = -1423744878777486541L;

  private final transient ByteString byteString;

  Cursor(ByteString byteString) {
    this.byteString = byteString;
  }

  @Override
  public int hashCode() {
    return byteString.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Cursor)) {
      return false;
    }
    return byteString.equals(((Cursor) obj).byteString);
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    StringBuilder stBuilder = new StringBuilder();
    for (int i = 0; i < byteString.size(); i++) {
      stBuilder.append(String.format("%02x", byteString.byteAt(i)));
    }
    return toStringHelper.add("bytes", stBuilder.toString()).toString();
  }

  ByteString byteString() {
    return byteString;
  }

  /**
   * Returns the cursor in an encoded form that can be used as part of a URL.
   */
  public String toUrlSafe() {
    try {
      return URLEncoder.encode(toPb().toString(), UTF_8.name());
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("Unxpeced encoding exception", e);
    }
  }

  /**
   * Create a {@code Cursor} given its URL safe encoded form.
   */
  public static Cursor fromUrlSafe(String urlSafe) {
    try {
      String utf8Str = URLDecoder.decode(urlSafe, UTF_8.name());
      return fromPb(DatastoreV1.Value.parseFrom(utf8Str.getBytes()));
    } catch (UnsupportedEncodingException | InvalidProtocolBufferException e) {
      throw new RuntimeException("Unxpeced decoding exception", e);
    }
  }

  public static Cursor copyFrom(byte[] bytes) {
    return new Cursor(ByteString.copyFrom(checkNotNull(bytes)));
  }

  @Override
  protected Value toPb() {
    return DatastoreV1.Value.newBuilder().setBlobValue(byteString).build();
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Value.parseFrom(bytesPb));
  }

  static Cursor fromPb(DatastoreV1.Value valuePb) {
    return new Cursor(valuePb.getBlobValue());
  }
}
