package com.inetra.shop.inetrashop.presentation.exception;

import android.content.Context;

import com.inetra.shop.inetrashop.R;
import com.inetra.shop.inetrashop.data.exception.NetworkConnectionException;
import com.inetra.shop.inetrashop.data.exception.ProductNotFoundException;

public class ErrorMessageFactory {

  private ErrorMessageFactory() {
    //empty
  }

  public static String create(Context context, Exception exception) {
    String message = context.getString(R.string.exception_message_generic);

    if (exception instanceof NetworkConnectionException) {
      message = context.getString(R.string.exception_message_no_connection);
    } else if (exception instanceof ProductNotFoundException) {
      message = context.getString(R.string.exception_message_product_not_found);
    }

    return message;
  }
}
