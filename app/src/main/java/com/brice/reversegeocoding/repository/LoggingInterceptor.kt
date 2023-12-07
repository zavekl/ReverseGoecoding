import android.util.Log
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val originalHttpUrl: HttpUrl = originalRequest.url()

        // Créer une nouvelle URL avec le chemin de la requête
        val newUrl: HttpUrl = originalHttpUrl.newBuilder()
            .build()

        // Créer une nouvelle requête avec la nouvelle URL
        val newRequest: Request = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        // Log de l'URL
        Log.d("TESTBRice", "intercept: " + newRequest.toString())

        return chain.proceed(newRequest)
    }
}