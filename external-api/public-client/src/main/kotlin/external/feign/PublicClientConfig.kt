package external.feign

import com.fasterxml.jackson.databind.ObjectMapper
import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean

class PublicClientConfig {
    @Bean
    fun requestInterceptor(
        @Value("\${external.public.params.serviceKey}") serviceKey: String,
        @Value("\${external.public.headers.Authorization}") authorization: String
    ): RequestInterceptor {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            requestTemplate.header("Authorization", authorization)
                .query("serviceKey", serviceKey)
        }
    }

    @Bean
    fun publicErrorDecoder(objectMapper: ObjectMapper): PublicErrorDecoder {
        return PublicErrorDecoder(objectMapper)
    }
}