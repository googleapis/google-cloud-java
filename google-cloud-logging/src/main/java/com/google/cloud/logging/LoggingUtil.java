package com.google.cloud.logging;

import java.util.logging.Level;

abstract class LoggingUtil {

  static Severity severityFor(Level level) {
    if (level instanceof LoggingLevel) {
      return ((LoggingLevel) level).getSeverity();
    }
    switch (level.intValue()) {
      // FINEST
      case 300:
        return Severity.DEBUG;
      // FINER
      case 400:
        return Severity.DEBUG;
      // FINE
      case 500:
        return Severity.DEBUG;
      // CONFIG
      case 700:
        return Severity.INFO;
      // INFO
      case 800:
        return Severity.INFO;
      // WARNING
      case 900:
        return Severity.WARNING;
      // SEVERE
      case 1000:
        return Severity.ERROR;
      default:
        return Severity.DEFAULT;
    }
  }
}
