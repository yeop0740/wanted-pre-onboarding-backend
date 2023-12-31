package wanted.preonboarding.backend.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private ErrorCode code;
    private String message;
    private LocalDateTime time;

    public ErrorResponse(Exception e) {
        this.message = e.getMessage();
        this.time = LocalDateTime.now();
    }
}
