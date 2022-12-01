package wpfcrazy.github.io.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import wpfcrazy.github.io.common.request.*;
import wpfcrazy.github.io.common.response.*;

import java.util.function.Predicate;

@Getter
@AllArgsConstructor
public enum ActionType {
    REGISTER(1,"register", RegisterRequest.class, RegisterResponse.class),
    UN_REGISTER(2,"unRegister", UnRegisterRequest.class, UnRegisterResponse.class),
    SERVICE_DISCOVERY(3,"serviceDiscovery", ServiceDiscoveryRequest.class, ServiceDiscoveryResponse.class),
    KEEP_ALIVE(4,"keepAlive",KeepAliveRequest.class, KeepAliveResponse.class);

    private int code;
    private String name;
    private Class<? extends Request> requestClazz;
    private Class<? extends Response> responseClazz;

    public static ActionType fromActionCode(int actionCode){
        return getActionType(actionType -> actionType.code == actionCode);
    }

    public static ActionType fromRequest(Request request){
        return getActionType(actionType -> actionType.requestClazz.equals(request.getClass()));
    }
    private static ActionType getActionType(Predicate<ActionType> predicate){
        for (ActionType actionType:ActionType.values()){
            if (predicate.test(actionType)){
                return actionType;
            }
        }
        throw new RuntimeException("no found action type");
    }
}
