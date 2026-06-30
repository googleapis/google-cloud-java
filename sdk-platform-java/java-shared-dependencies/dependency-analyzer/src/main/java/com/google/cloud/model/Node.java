package com.google.cloud.model;

/**
 * The nodes of the dependency graph.
 *
 * @param versionKey The package version represented by this node.
 * @param relation Whether this node represents a direct or indirect dependency within this
 * dependency graph.
 */
public record Node(VersionKey versionKey, Relation relation) {

}
