package com.bazaarvoice.jolt.modifier.function;

import java.time.Instant;
import java.time.ZonedDateTime;

import com.bazaarvoice.jolt.common.Optional;

@SuppressWarnings("deprecated")
public class Dates {

  public static Optional<String> isoDateNow() {
    Instant date = Instant.now();

    return Optional.of(date.toString());
  }

  public static Optional<String> toIsoUtcDate(Object date) {
    if (date instanceof String) {
      ZonedDateTime dateTime;

      try {
        dateTime = ZonedDateTime.parse((String) date);
      } catch (Exception e) {
        dateTime = null;
      }

      if (dateTime == null) {
        // Hack: fix timezone, if present
        String stripped = date.toString().replaceFirst("00$", ":00");
        try {
          dateTime = ZonedDateTime.parse((String) stripped);
        } catch (Exception e) {
          dateTime = null;
        }
      }

      if (dateTime != null) {
        String utcDate = dateTime.toInstant().toString();

        return Optional.of(utcDate);
      } else {
        return Optional.empty();
      }
    } else {
      return Optional.empty();
    }
  }

  public static Optional<String> epochToIsoDate(Object epoch) {
    Optional<String> res;

    if (epoch instanceof Long) {
      Instant dateTime;
      try {
        dateTime = Instant.ofEpochMilli((Long) epoch);
      } catch (Exception e) {
        dateTime = null;
      }

      if (dateTime != null) {
        String isoDate = dateTime.toString();
        res = Optional.of(isoDate);
      } else {
        res = Optional.empty();
      }

    } else {
      res = Optional.empty();
    }

    return res;
  }

  // Function wrappers

  public static final class isoDateNow extends Function.SingleFunction<String> {

    @Override
    protected Optional<String> applySingle(Object _arg) {
      return isoDateNow();
    }
  }

  public static final class toIsoUtcDate extends Function.SingleFunction<String> {

    @Override
    protected Optional<String> applySingle(Object arg) {
      return toIsoUtcDate(arg);
    }
  }
  
  public static final class epochToIsoDate extends Function.SingleFunction<String> {

    @Override
    protected Optional<String> applySingle(Object arg) {
      return epochToIsoDate(arg);
    }
  }
}
