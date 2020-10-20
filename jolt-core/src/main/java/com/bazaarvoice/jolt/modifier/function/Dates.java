package com.bazaarvoice.jolt.modifier.function;

import java.time.Instant;

import com.bazaarvoice.jolt.common.Optional;

@SuppressWarnings("deprecated")
public class Dates {
  
  public static Optional<String> isoDateNow() {
    Instant date = Instant.now();

    return Optional.of(date.toString());
  }
  
  // Function wrappers
  
  public static final class isoDateNow extends Function.SingleFunction<String> {
    
    @Override
    protected Optional<String> applySingle(Object _arg) {
      return isoDateNow();
    }
  }
}
