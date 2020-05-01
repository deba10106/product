package backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UploadException extends RuntimeException {

	private static final long serialVersionUID = 4377893526895128719L;

	public UploadException(String message) {
		super(message);
	}
}
