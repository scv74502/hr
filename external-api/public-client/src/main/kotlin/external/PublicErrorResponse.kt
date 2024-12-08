package external

import lombok.AccessLevel
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.ToString

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class PublicErrorResponse(var errorMessage: String, var errorCode: String)
