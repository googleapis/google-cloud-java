package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1.Value;
import com.google.api.services.datastore.DatastoreV1.Value.Builder;

// TODO: add javadoc, find the right place to describe that null should only
// be represented by NullValue (so nulls are not allowed here).
public final class StringProperty extends Property {

  private final String content;

  static final Provider<StringProperty> PROVIDER = new Provider<StringProperty>() {
    @Override
    StringProperty get(Value proto, boolean indexed, Integer meaning) {
      return new StringProperty(proto.getStringValue(), indexed, meaning);
    }
  };

  public StringProperty(String content) {
    this(content, true);
  }

  public StringProperty(String content, boolean indexed) {
    this(content, indexed, null);
  }

  public StringProperty(String content, boolean indexed, Integer meaning) {
    super(Type.STRING, indexed, meaning);
    this.content = checkNotNull(content);
    // some validations:
    if (indexed) {
      checkArgument(content.length() <= 500, "Indexed string is limited to 500 characters");
    }
  }

  public String getContent() {
    return content;
  }

  @Override
  protected void addValueToProto(Builder builder) {
    builder.setStringValue(content);
  }
}
