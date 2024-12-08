package external.feign

import com.core.ApiException
import com.core.ErrorType
import com.core.log.logger
import com.fasterxml.jackson.databind.ObjectMapper
import external.PublicErrorResponse
import feign.Response
import feign.codec.ErrorDecoder
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import java.io.IOException
import java.nio.charset.StandardCharsets

@Slf4j
class PublicErrorDecoder(
    private val objectMapper: ObjectMapper
):ErrorDecoder {
    override fun decode(methodKey: String?, response: Response): Exception {
        try {
            val body = String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8)
            val errorResponse =
                objectMapper.readValue(body, PublicErrorResponse::class.java)
            throw ApiException(
                errorResponse.errorMessage,
                ErrorType.EXTERNAL_API_ERROR,
                HttpStatus.valueOf(errorResponse.errorCode)
            )
        } catch (e: IOException) {
            logger.error { "[Public] 에러 메세지 파싱 에러 code={${response.status()}}, request={${response.request()}}, methodKey={${methodKey}}, errorMessage={${e.message}}" }
            throw ApiException("공공데이터 메세지 파싱에러", ErrorType.EXTERNAL_API_ERROR, HttpStatus.valueOf(response.status()))
        }
    }
}