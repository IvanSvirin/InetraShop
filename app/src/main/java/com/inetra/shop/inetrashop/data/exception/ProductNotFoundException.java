package com.inetra.shop.inetrashop.data.exception;

public class ProductNotFoundException extends Exception {

  public ProductNotFoundException() {
    super();
  }

  public ProductNotFoundException(final String message) {
    super(message);
  }

  public ProductNotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ProductNotFoundException(final Throwable cause) {
    super(cause);
  }
}
