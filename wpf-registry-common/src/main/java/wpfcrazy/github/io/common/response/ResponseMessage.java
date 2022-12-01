package wpfcrazy.github.io.common.response;

import wpfcrazy.github.io.common.ActionType;
import wpfcrazy.github.io.common.Message;

public class ResponseMessage extends Message<Response> {
    @Override
    public Class getMessageBodyByActionCode(int actionCode) {
        return ActionType.fromActionCode(actionCode).getResponseClazz();
    }
}
