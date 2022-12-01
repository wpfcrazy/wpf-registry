package wpfcrazy.github.io.common.request;

import wpfcrazy.github.io.common.ActionType;
import wpfcrazy.github.io.common.Message;
import wpfcrazy.github.io.common.MessageHeader;

public class RequestMessage extends Message<Request> {
    public RequestMessage(){}
    public RequestMessage(long businessId,Request request){
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setBusinessId(businessId);
        messageHeader.setActionCode(ActionType.fromRequest(request).getCode());
        this.setMessageHeader(messageHeader);
        this.setMessageBody(request);
    }
    @Override
    public Class getMessageBodyByActionCode(int actionCode) {
        return ActionType.fromActionCode(actionCode).getRequestClazz();
    }
}
