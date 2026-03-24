package com.google.cloud.model;

public enum Interval {
  WEEKLY(7),
  MONTHLY(30);

  private final int days;

  Interval(int days) {
    this.days = days;
  }

  public int getDays() {
    return days;
  }
}
