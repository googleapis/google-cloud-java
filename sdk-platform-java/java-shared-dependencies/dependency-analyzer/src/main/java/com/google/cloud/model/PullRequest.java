package com.google.cloud.model;

import com.google.gson.annotations.SerializedName;

/**
 * A record that represents a GitHub pull request.
 *
 * @param url The url of the pull request.
 * @param state The state of the pull request, e.g., open, merged.
 * @param createdAt The creation time of the pull request.
 * @param mergedAt The merged time of the pull request; null if not merged.
 */
public record PullRequest(
    String url,
    String state,
    @SerializedName("created_at") String createdAt,
    @SerializedName("merged_at") String mergedAt) {}
