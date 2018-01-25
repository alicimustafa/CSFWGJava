package security;

public class JWTConfig {

	public static final Long EXPIRATIONTIME = 864_000_000L;
	public static final String SECRET = "ThisIsASecret";
	public static final String TOKEN_PREFIX = "Bearer";
	public static final String HEADER_STRING = "Authorization";
	
}
