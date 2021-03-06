package com.duoduopin.model;

import com.duoduopin.config.ResultStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultModel {
  private int code;
  private String message;
  private Object content;

  public ResultModel(int code, String message) {
    this.code = code;
    this.message = message;
    this.content = "";
  }

  public ResultModel(int code, String message, Object content) {
    this.code = code;
    this.message = message;
    this.content = content;
  }

  public ResultModel(ResultStatus status) {
    this.code = status.getCode();
    this.message = status.getMessage();
    this.content = "";
  }

  public ResultModel(ResultStatus status, Object content) {
    this.code = status.getCode();
    this.message = status.getMessage();
    this.content = content;
  }

  public static ResultModel ok(Object content) {
    return new ResultModel(ResultStatus.SUCCESS, content);
  }

  public static ResultModel ok() {
    return new ResultModel(ResultStatus.SUCCESS);
  }

  public static ResultModel error(ResultStatus error) {
    return new ResultModel(error);
  }
}
