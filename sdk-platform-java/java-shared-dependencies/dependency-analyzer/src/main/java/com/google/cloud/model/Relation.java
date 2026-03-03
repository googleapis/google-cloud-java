package com.google.cloud.model;

/**
 * Relationship between two packages within a dependency graph.
 * <p>
 * For more information, please refer to <a href="https://docs.deps.dev/api/v3/#getdependencies">GetDependencies</a>.
 */
public enum Relation {
  SELF,
  DIRECT,
  INDIRECT
}
