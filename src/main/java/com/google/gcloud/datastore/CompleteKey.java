package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.gcloud.datastore.Key.PathEntry;

import java.util.List;

/**
 * A key that is guaranteed to be complete.
 */
public final class CompleteKey {

  private final Key key;

  public static class Builder {

    private final Key.Builder keyBuilder = new Key.Builder();

    public Builder(String dataset) {
      this(dataset, "");
    }

    public Builder(String dataset, String namespace) {
      keyBuilder.setDataset(checkNotNull(dataset));
      keyBuilder.setNamespace(checkNotNull(namespace));
    }

    public Builder addChild(String kind, long id) {
      keyBuilder.addChild(kind, id);
      return this;
    }

    public Builder addChild(String kind, String name) {
      keyBuilder.addChild(kind, name);
      return this;
    }

    public CompleteKey build() {
      return new CompleteKey(keyBuilder.build());
    }
  }

  private CompleteKey(Key key) {
    this.key = key;
  }

  public String getDataset() {
    return key.getDataset();
  }

  public String getNamespace() {
    return key.getNamespace();
  }

  public List<PathEntry> getPath() {
    return key.getPath();
  }

  public String getKind() {
    return key.getKind();
  }

  public Long getId() {
    return key.getLeaf().getId();
  }

  public String getName() {
    return key.getLeaf().getName();
  }

  public Object getNameOrId() {
    PathEntry leaf = key.getLeaf();
    return leaf.hasId() ? leaf.getId() : leaf.getName();
  }

  public Key toKey() {
    return key;
  }

  @Override
  public String toString() {
    return key.toString();
  }

  @Override
  public int hashCode() {
    return key.hashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof CompleteKey)) {
      return false;
    }
    return key.equals(((CompleteKey) other).key);
  }

  // TODO (here and in key - also consider for Properties):
  // 1) cloneable
  // 2) serializable (or externalizable)
  // 3) toBuilder (and builder supports clear,...)
  // 4) Builder accept builder
}
