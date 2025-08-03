package dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ErrorMessageDto {

    private String timestamp;
    private int status;
    private String error;
    private Object message;
    private String path;
}

/*
{
  "timestamp": "2025-08-03T15:21:26",
  "status": 400,
  "error": "Bad Request",
  "message": "Contact with id: 1 not found in your contacts!",
  "path": "/v1/contacts/1"
}
 */
