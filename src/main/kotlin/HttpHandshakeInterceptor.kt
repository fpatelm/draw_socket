import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.http.server.ServletServerHttpRequest
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.server.HandshakeInterceptor


class HttpHandshakeInterceptor : HandshakeInterceptor {
    override fun afterHandshake(p0: ServerHttpRequest, p1: ServerHttpResponse, p2: WebSocketHandler, p3: Exception?) {
        TODO("Not yet implemented")
    }

    override fun beforeHandshake(request: ServerHttpRequest, p1: ServerHttpResponse, p2: WebSocketHandler, attributes: MutableMap<String, Any>): Boolean {
        if (request is ServletServerHttpRequest) {
            val session = request.servletRequest.session
            attributes["sessionId"] = session.id
        }
        return true
    }

}