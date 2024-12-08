package external.feign

import external.MinWagePerYearResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "publicClient",
    url = "\${external.public.min-wage.url}",
    configuration = [PublicClientConfig::class])
interface PublicClient {
    @GetMapping("\${external.public.min-wage.api-url}")
    fun search(
        @RequestParam("page") page: Int,
        @RequestParam("perPage") perPage: Int,
    ): MinWagePerYearResponse?
}