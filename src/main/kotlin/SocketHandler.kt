import com.google.gson.Gson
import org.springframework.stereotype.Component
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.concurrent.CopyOnWriteArrayList




@Component
class SocketHandler : TextWebSocketHandler() {
    var sessions: List<WebSocketSession> = CopyOnWriteArrayList()
    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        for (webSocketSession in this.sessions) {
            val value = Gson().fromJson(message.payload, MutableMap::class.java)
            webSocketSession.sendMessage(TextMessage("Hello " + value.get("name") + " !"));
        }
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessions.plusElement(session)
    }
}