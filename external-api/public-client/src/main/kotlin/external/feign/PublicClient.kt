package external.feign

import org.springframework.cloud.openfeign.FeignClient

@FeignClient(name = "publicClient", url = "\${external.public.url}", configuration = [PublicClientConfig::class])
interface PublicClient {
}