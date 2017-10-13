package com.inetra.shop.inetrashop.domain.exception;

public interface ErrorBundle {
  Exception getException();

  String getErrorMessage();
}
