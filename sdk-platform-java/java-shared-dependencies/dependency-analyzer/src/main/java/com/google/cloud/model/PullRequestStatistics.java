package com.google.cloud.model;

/**
 * A record that represents statistics about pull requests within a specified time interval.
 *
 * <p>The pull request statistics is used to show pull request freshness in the package information
 * report.
 *
 * <p>For example, x pull requests are created and y pull requests are merged in the last 30 days.
 *
 * @param created The number of pull requests created within the interval.
 * @param merged The number of pull requests merged within the interval.
 * @param interval The time interval over which the statistics were collected.
 */
public record PullRequestStatistics(long created, long merged, Interval interval) {}
